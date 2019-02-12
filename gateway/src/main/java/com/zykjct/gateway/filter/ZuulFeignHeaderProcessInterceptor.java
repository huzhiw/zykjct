package com.zykjct.gateway.filter;

import com.netflix.zuul.context.RequestContext;
import com.zykjct.kernel.core.constants.FrameConstants;
import com.zykjct.kernel.core.feign.FeignHeaderProcessInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @description: feign远程调用添加header的过滤器
 * @author: huzhiwen
 * @create: 2019-01-31 15:15
 **/

@Configuration
public class ZuulFeignHeaderProcessInterceptor extends FeignHeaderProcessInterceptor {
    @Override
    public void addOtherHeaders(RequestTemplate requestTemplate) {

        RequestContext currentContext = RequestContext.getCurrentContext();
        Object contextObject = currentContext.get(FrameConstants.REQUEST_NO_HEADER_NAME);

        requestTemplate.header(FrameConstants.REQUEST_NO_HEADER_NAME, contextObject == null ? "" : contextObject.toString());
    }
}
