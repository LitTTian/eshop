package com.lrz.eshop.util.encrypt;

import com.lrz.eshop.common.math.MyMath;

import java.math.BigDecimal;
import java.security.SecureRandom;

/**
 * 自己实现的Elgamal加密算法
 * @author 天天
 * @create 2023/4/13 22:05
 * @description
 */
public class ElgamalUtils {
    private static final Long p = Long.parseLong("366241480223"); // p为一个素数

    private static final Long a = Long.parseLong("221467792290"); // a为一个原根

    /**
     * 将用户的id作为k生成C1并返回
     * @param k
     * @return C1 = a^k mod p
     */
    Long getC1(Long k) {
        //        Long k = Long.parseLong(userId);
        return MyMath.fastExpMod(a, k, p);
    }

    /**
     * 房间内存储的x，计算并返回Yb
     * @param x
     * @return Yb = a^x mod p
     */
    Long getY(Long x) {
        // Long x = Long.parseLong(roomX);
        return MyMath.fastExpMod(a, x, p);
    }

    /**
     * 计算并返回C2
     * @param y 通过getY方法生成
     * @param k 通过generateK方法生成
     * @param M 要加密的内容
     * @return
     */
    Long getC2(Long y, Long k, Long M) {
        //        Long k = Long.parseLong(userId);
        Long remainder = MyMath.fastExpMod(y, k, p);
        return BigDecimal.valueOf(remainder).multiply(BigDecimal.valueOf(M)).divideAndRemainder(BigDecimal.valueOf(p))[1].longValue();
        //        return remainder * M % p;
    }

    Long generateK() {
        // 重构随机数生成规则
        // Random r = new Random();
        SecureRandom r = new SecureRandom();
        int length = p.toString().length();
        long k = r.nextLong();
        int kLength = Long.toString(k).length();
        if(kLength > length) { // 保证k的长度不超过p的长度
            k = Long.parseLong(Long.toString(k).substring(kLength - length));
        }
        while(k < 0) { // 保证k的范围在0到p之间
            k = r.nextLong();
            if(kLength > length) { // 保证k的长度不超过p的长度
                k = Long.parseLong(Long.toString(k).substring(kLength - length));
            }
        }
        return k;
    }

    public static Long decrypt(Long C1, Long C2, Long x) {
        Long v = MyMath.fastExpMod(C1, x, p);
        Long v1 = MyMath.egcd(v, p)[1];
        Long res = BigDecimal.valueOf(C2).multiply(BigDecimal.valueOf(v1)).divideAndRemainder(BigDecimal.valueOf(p))[1].longValue();
        if(res < 0) {
            res += p;
        }
        return res;
    }

    /**
     *
     * @param M 要加密的内容
     * @param x 房间号
     * @return 加密后的C1和C2
     */
    public static long[] encrypt(Long M, Long x) {
        ElgamalUtils encryptUtils = new ElgamalUtils();
        // Long x = Long.parseLong(roomX);
        Long y = encryptUtils.getY(x); // 根据房间号生成yb
        Long k = encryptUtils.generateK(); // 生成k
        Long C1 = encryptUtils.getC1(k); // 生成C1
        Long C2 = encryptUtils.getC2(y, k, M); // 生成C2
        return new long[]{C1, C2};
    }

}
