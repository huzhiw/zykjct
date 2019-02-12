package com.zykjct.kernel.core.feign;

import com.zykjct.kernel.core.util.HttpContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @description:  feign远程调用添加header的过滤器
 * @author: huzhiwen
 * @create: 2019-01-31 15:08
 **/

@Slf4j
@Configuration
public class FeignHeaderProcessInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest request = HttpContext.getRequest();

        if (request == null) {
            return;
        } else {
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    requestTemplate.header(name, values);
                }
            }
        }
        this.addOtherHeaders(requestTemplate);
    }

    public void addOtherHeaders(RequestTemplate requestTemplate) {

    }
}
