package com.lrz.eshop.common.math;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author 天天
 * @create 2023/4/13 21:44
 * @description
 */
public class MyMath {

    /**
     * 快速取幂
     * @param a
     * @param e
     * @param m
     * @return
     */
    public static Long fastExpModShortNumber(Long a, Long e, Long m) {
        // 超过10位会溢出
        a = a % m;
        long res = 1;
        int i = 0;
        while(e != 0) {
            if((e & 1) == 1) {
                res = (res * a) % m;
            }
            e = e >> 1;
            a = (a * a) % m;
        }
        return res;
    }

    /**
     * 快速幂取模
     * @param a
     * @param e
     * @param m
     * @return
     */
    public static Long fastExpMod(Long a, Long e, Long m) {
        //        BigDecimal a = new BigDecimal(aOri);
        //        BigDecimal e = new BigDecimal(eOri);
        //        BigDecimal m = new BigDecimal(mOri);
        //        a = a.divideAndRemainder(m)[1];
        a = a % m;
        //        BigDecimal res = new BigDecimal(1);
        long res = 1;
        while(e != 0) {
            if((e & 1) == 1) {
                //                res = (res * a) % m;
                res = BigDecimal.valueOf(res).multiply(BigDecimal.valueOf(a)).divideAndRemainder(BigDecimal.valueOf(m))[1].longValue();
            }
            e = e >> 1;
            //            a = (a * a) % m;
            a = BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(a)).divideAndRemainder(BigDecimal.valueOf(m))[1].longValue();
        }
        return res;
    }

    public static long[] egcd(Long a, Long b) { // #1.gcd 2.a^-1 mod b 3.b^-1 mod a
        long[] array = new long[3];
        if(b == (long) 0) {
            //            System.out.println("b == 0");
            array[0] = a;
            array[1] = (long) 1;
            array[2] = (long) 0;
        }else {
            array = egcd(b, a % b);
            //            System.out.println(Arrays.toString(array));
            //             array[0] = array[0];
            // array[1] = (long)arr[2];
            long temp = array[2]; // 因为array[2]会被覆盖，所以先保存
            //            array[2] = BigDecimal.valueOf(arr[1]).subtract(BigDecimal.valueOf(a).divideAndRemainder(BigDecimal.valueOf(b))[0].multiply(BigDecimal.valueOf(arr[2]))).longValue();
            array[2] = (long) (array[1] - a/b * array[2]);
            array[1] = temp;
        }
        return array;
    }

    public static int[] egcdInt(int a, int b) {
        int[] array = new int[2];
        if(b == 0) {
            array[0] = 1;
            array[1] = 0;
            return array;
        }else {
            array = egcdInt(b, a%b);
            System.out.println(Arrays.toString(array));
            array[0] = array[1];
            array[1] = array[0] - a / b * array[1];
            return array;
        }
    }
}
