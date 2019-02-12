package com.zykjct.kernel.core.reqres.response;

import lombok.Data;

/**
 * @description:  请求成功的返回对象
 * @author: huzhiwen
 * @create: 2019-01-26 16:53
 **/

@Data
public class SuccessResponseData extends ResponseData {
    public SuccessResponseData() {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);
    }

    public SuccessResponseData(Object object) {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, object);
    }

    public SuccessResponseData(Integer code, String message, Object object) {
        super(true, code, message, object);
    }
}
