package com.zykjct.gateway.config;

import com.zykjct.gateway.filter.RequestNoGenerateFilter;
import com.zykjct.gateway.filter.TokenFilter;
import com.zykjct.gateway.filter.ZuulFeignHeaderProcessInterceptor;
import com.zykjct.kernel.core.feign.FeignErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: huzhiwen
 * @create: 2019-01-30 20:31
 **/

@Configuration
public class ZuulFilter {
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public RequestNoGenerateFilter requestNoGenerateFilter() {
        return new RequestNoGenerateFilter();
    }
}
