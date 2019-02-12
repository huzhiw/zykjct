package com.zykjct.kernel.core.constants;

/**
 * @description:  框架常亮
 * @author: huzhiwen
 * @create: 2019-01-26 20:23
 **/

public interface FrameConstants {
    /**
     * 请求号header标识
     */
    String REQUEST_NO_HEADER_NAME = "Request-No";

    /**
     * header中的spanId，传递规则：request header中传递本服务的id
     */
    String SPAN_ID_HEADER_NAME = "Span-Id";
}
