package com.lrz.eshop.config;

import com.alibaba.druid.util.StringUtils;
import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jasypt加密配置
 * @author 天天
 * @create 2023/1/23 19:03
 * @description
 */

@Configuration
@EnableEncryptableProperties
@EncryptablePropertySource("classpath:application.yml")
public class EncryptionPropertyConfig {
    // 加密属性前缀
    private static final String PREFIX = "ENC@[";
    private static final String SUFFIX = "]";
    // 密钥
    private static final String PASSWORD = "liruizhi";

    /* private static SimpleStringPBEConfig config;

    static {
        config.setPassword(PASSWORD);
        config.setAlgorithm("PBEWITHMD5ANDDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
    } */

    /**
     * 自定义加密解密器
     * @return
     */
    @Bean(name = "encryptablePropertyResolver")
    public EncryptablePropertyResolver encryptablePropertyResolver() {
        return new MyEncryptablePropertyResolver(PREFIX, SUFFIX, PASSWORD);
    }

    private static class MyEncryptablePropertyResolver implements EncryptablePropertyResolver {

        private final String Prefix;
        private final String Suffix;
        //PBE字符串加密器
        private final PooledPBEStringEncryptor encryptor;

        // 计数器
        private int count = 0;

        /**
         * 加密器构造函数
         * @param Prefix
         * @param Suffix
         * @param password
         */
        public MyEncryptablePropertyResolver(String Prefix, String Suffix, String password) {
            this.Prefix = Prefix;
            this.Suffix = Suffix;
            // 集中式PBE字符串加密器
            encryptor = new PooledPBEStringEncryptor();
            // 简单字符串形式的PBC配置
            SimpleStringPBEConfig config = new SimpleStringPBEConfig();
            // 设置加密密码（大小写敏感），密码错误将导致程序异常
            config.setPassword(password);
            // 设置加密算法
            // config.setAlgorithm("PBEWithMD5AndDES");
            config.setAlgorithm("PBEWITHMD5ANDDES");
            // 设置获取加密密钥的哈希迭代次数
            config.setKeyObtentionIterations("1000");
            // 设置线程池大小
            config.setPoolSize("1");
            // 设置加密器的提供者
            config.setProviderName("SunJCE");
            // 设置加盐的类名
            config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
            // 设置初始向量IV生成器的类名
            // config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
            // 设置字节数组以base64格式输出
            config.setStringOutputType("base64");
            // 将对应的配置设置到密码器上
            encryptor.setConfig(config);
        }

        /**

         */
        /**
         * 解密器
         * @description: 依次解析每个属性的值。判断是否是加密字段，如果是则进行解密,解密函数可以用 jsypt 自带的解密方式，也可以用自己写的一套加解密规则
         * @param value
         * @return
         */
        @Override
        public String resolvePropertyValue(String value) {
            System.out.println("resolvePropertyValue::" + count++ + ":: " + value);
            if (!StringUtils.isEmpty(value) && value.startsWith(Prefix) && value.endsWith(Suffix)) {
                String encValue = value.substring(Prefix.length(), value.length() - Suffix.length());
                // System.out.println("resolvePropertyValue::" + count + ":: " + encValue);
                return encryptor.decrypt(encValue);
            }
            return value;
        }
    }


    /**
     * 配置加密器
     * @return StringEncryptor
     */
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        //集中式PBE字符串加密器
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        //简单字符串形式的PBC配置
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        //设置加密密码（大小写敏感），密码错误将导致程序异常
        config.setPassword(PASSWORD);
        //设置加密算法
        // config.setAlgorithm("PBEWithMD5AndDES");
        config.setAlgorithm("PBEWITHMD5ANDDES");
        //设置获取加密密钥的哈希迭代次数
        config.setKeyObtentionIterations("1000");
        //设置线程池大小
        config.setPoolSize("1");
        //设置加密器的提供者
        config.setProviderName("SunJCE");
        //设置加盐的类名
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        //设置初始向量IV生成器的类名
        // config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        //设置字节数组以base64格式输出
        config.setStringOutputType("base64");
        //将对应的配置设置到密码器上
        encryptor.setConfig(config);
        return encryptor;
    }

    private static ApplicationContext context;
    public static StringEncryptor getEncryptor() {
        return (StringEncryptor) context.getBean("jasyptStringEncryptor");
    }


}
