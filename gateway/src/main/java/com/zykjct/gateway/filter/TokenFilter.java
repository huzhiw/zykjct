package com.zykjct.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zykjct.kernel.core.reqres.response.ErrorResponseData;
import com.zykjct.kernel.jwt.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @description: JWT过滤器
 * @author: huzhiwen
 * @create: 2019-01-30 17:13
 **/

public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //登录和swagger不过滤
        String uri = request.getRequestURI();
        if (uri.contains("api-docs") || uri.contains("login")) {
            return null;
        }

        // 从Http请求获得授权
        final String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token) || JwtTokenUtil.isTokenExpired(token)) {
            HttpServletResponse response = requestContext.getResponse();
            response.setCharacterEncoding("utf-8");
            response.setContentType("json/application; charset=utf-8");
            try {
                String json = JSONObject.toJSONString(ErrorResponseData.error("未登录"));
                response.getWriter().write(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
        }
        return null;
    }
}
