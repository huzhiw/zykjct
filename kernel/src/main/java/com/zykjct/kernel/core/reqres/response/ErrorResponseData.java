package com.zykjct.kernel.core.reqres.response;

import lombok.Data;

/**
 * @description:  请求失败的返回对象
 * @author: huzhiwen
 * @create: 2019-01-26 16:51
 **/

@Data
public class ErrorResponseData extends ResponseData {
    /**
     * 异常的具体类名称
     */
    private String exceptionClazz;

    public ErrorResponseData(String message) {
        super(false, ResponseData.DEFAULT_ERROR_CODE, message, null);
    }

    public ErrorResponseData(Integer code, String message) {
        super(false, code, message, null);
    }

    public ErrorResponseData(Integer code, String message, Object object) {
        super(false, code, message, object);
    }
}
