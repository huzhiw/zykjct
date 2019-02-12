package com.zykjct.gateway.filter;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zykjct.kernel.core.constants.FrameConstants;

import javax.servlet.http.HttpServletResponse;

/**
 * @description: 生成请求号过滤器
 * @author: huzhiwen
 * @create: 2019-01-31 14:33
 **/

public class RequestNoGenerateFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletResponse response = currentContext.getResponse();
        //生成唯一请求号uuid
        String requestNo = IdWorker.getIdStr();
        currentContext.set(FrameConstants.REQUEST_NO_HEADER_NAME, requestNo);
        currentContext.addZuulRequestHeader(FrameConstants.REQUEST_NO_HEADER_NAME, requestNo);
        response.addHeader(FrameConstants.REQUEST_NO_HEADER_NAME, requestNo);
        return null;
    }
}
