package com.zykjct.gateway.config;

import com.alibaba.fastjson.JSONObject;
import com.zykjct.kernel.core.reqres.response.ErrorResponseData;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 服务网关降级配置
 * @author: huzhiwen
 * @create: 2019-02-14 14:36
 **/

@Component
public class ZuulFallbackConfig implements FallbackProvider {
    @Override
    public String getRoute() {
        /**所有路由都经过此配置*/
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                byte[] respByte = JSONObject.toJSONString(ErrorResponseData.error("服务器开小差了，请稍后再试")).getBytes();
                return new ByteArrayInputStream(respByte);
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
