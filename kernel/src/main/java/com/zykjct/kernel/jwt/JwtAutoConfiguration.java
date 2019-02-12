package com.zykjct.kernel.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:  jwt自动配置
 * @author: huzhiwen
 * @create: 2019-01-26 20:43
 **/

@Configuration
public class JwtAutoConfiguration {
    /**
     * jwt token的配置
     */
    @Bean
    @ConfigurationProperties(prefix = "jwt")
    public JwtProperties jwtProperties() {
        return new JwtProperties();
    }

    /**
     * jwt工具类
     */
    @Bean
    public JwtTokenUtil jwtTokenUtil(JwtProperties jwtProperties) {
        return new JwtTokenUtil(jwtProperties.getSecret(), jwtProperties.getExpiration());
    }
}
