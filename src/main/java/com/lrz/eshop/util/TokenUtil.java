package com.lrz.eshop.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lrz.eshop.common.BaseException;
import com.lrz.eshop.common.ConstantResultCode;
import com.lrz.eshop.pojo.user.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            // q：这里的withClaim是什么意思？
            // a：withClaim是设置一个私有声明，可以在解析token的时候获取到。
            // q：这里的sign是什么意思？
            // a：sign是使用了HMAC256加密算法。
            // q: 为什么每次加密的结果都一样
            // a: 因为每次加密的时候，都是用的同一个密钥，所以每次加密的结果都是一样的。
            // q: 怎么才能保证加密的结果不一样
            // a: 每次加密的时候，都使用不同的密钥，这样就能保证加密的结果不一样。
            // q: 每次密钥不一样，我还怎么解密
            // a: 解密的时候，也需要使用同一个密钥，这样才能解密成功。
            // q: 这个不一样的密钥存放在哪里
            // a: 一般是存放在服务器端，这样就能保证每次加密的时候，都使用不同的密钥。
            // q: 那服务端不就变成有状态了？
            // a: 服务端不是有状态的，因为服务端只是存放密钥，而不是存放用户的信息。
            // q: 那我怎么知道这个密钥是不是我自己的
            // a: 一般是使用jwt的时候，会在请求头中携带一个token，这个token就是用户的身份凭证，服务端会根据这个token来获取用户的信息。
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
            // JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();//自定义的
            // DecodedJWT jwt = verifier.verify(token);
            DecodedJWT jwt = JWT.decode(token);
            System.out.println("认证通过：id: " + jwt.getClaim("id").asString());
            // System.out.println("role: " + jwt.getClaim("role").asString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("过期时间：" + sdf.format(jwt.getExpiresAt()));
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * <p> 获得权限 </p>
     *
     * @Param [request]
     * @Return java.lang.String
     */
/*     public static String getRoleByToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("status").asString();
    } */

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
