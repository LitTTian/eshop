package com.lrz.eshop.util;

import cn.hutool.system.UserInfo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lrz.eshop.common.BaseException;
import com.lrz.eshop.common.ConstantResultCode;
import com.lrz.eshop.pojo.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 天天
 * @create 2023/2/27 20:10
 * @description
 */

@Component
public class TokenUtil {

    /*
        过期时间为24小时，毫秒计时的---毫秒--》秒--》分--》小时--》天
        private static final long EXPIRE_TIME= 60 * 24 * 60 * 1000;
     */
    /**
     * 过期时间为24小时
     */
    private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24;

    /**
     * 密钥，注意这里如果真实用到，应当设置到复杂点，相当于私钥的存在。如果被人拿到，相当于它可以自己制造token了。
     */
    private static final String TOKEN_SECRET = "token-lrz";  //密钥盐

    /**
     * 签名生成
     * @param user
     * @return
     */
    public static String sign(User user) {

        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withClaim("id", user.getId().toString())
                    .withClaim("username", user.getUsername())
                    // .withClaim("email", user.getEmail())
                    // .withClaim("avatarUrl", user.getAvatarUrl())
                    // .withClaim("creditScore", String.valueOf(user.getCreditScore()))
                    // .withClaim("cumulativeScore", String.valueOf(user.getCumulativeScore()))
                    // .withClaim("balance", String.valueOf(user.getBalance()))
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 签名验证
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        if (StringUtils.isBlank(token)) {
            throw new BaseException(ConstantResultCode.ERROR_CLIENT_REQUIRED_PARAMETER_EMPTY, "token为空");
        }
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();//自定义的
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            // System.out.println("id: " + jwt.getClaim("id").asInt());
            // System.out.println("role: " + jwt.getClaim("role").asString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("过期时间：" + sdf.format(jwt.getExpiresAt()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * <p> 获得权限 </p>
     *
     * @Param [request]
     * @Return java.lang.String
     */
    public static String getRoleByToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("status").asString();
    }

    /**
     * <p> 获得id,操作人 </p>
     *
     * @Param [request]
     * @Return java.lang.String
     */
    // public static int getIdByToken(HttpServletRequest request) {
    //     String token = request.getHeader("token");
    public static String getIdByToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("id").asString();
    }

/*     public static User getUserInfoByToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        DecodedJWT jwt = JWT.decode(token);
        User user = new User();
        user.setId(jwt.getClaim("id").asLong());
        user.setUsername(jwt.getClaim("username").asString());
        user.setEmail(jwt.getClaim("email").asString());
        user.setAvatarUrl(jwt.getClaim("avatarUrl").asString());
        user.setCreditScore(Short.parseShort(jwt.getClaim("creditScore").asString()));
        user.setCumulativeScore(Integer.parseInt(jwt.getClaim("cumulativeScore").asString()));
        user.setBalance(Float.parseFloat(jwt.getClaim("balance").asString()));
        return user;
    } */


    /**
     * 生成token
     * @param user
     * @return
     */
    /* public String generateToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 24 * 60 * 60 * 1000;//一天有效时间
        Date end = new Date(currentTime);
        String token = "";
        token = JWT.create()
                .withAudience(user.getId().toString())
                .withAudience(user.getUsername())
                .withIssuedAt(start)
                .withExpiresAt(end)
                .sign(Algorithm.HMAC256(TOKEN_SECRET));
        return token;
    } */

    /* public String token(User user) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .setSubject("user")
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(SignatureAlgorithm.HS512, "liruizhi")
                .compact();
        return jwtToken;
    } */


    /**
     * 验证token
     * @param token
     * @param key
     * @return
     */
    /* public static String get(String token) {
        List<String> list= JWT.decode(token).getAudience();
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    } */


}
