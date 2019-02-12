package com.zykjct.kernel.core.exception;

import lombok.Data;

/**
 * @description:  远程接口调用出现的业务异常
 * @author: huzhiwen
 * @create: 2019-01-26 17:48
 **/

@Data
public abstract class ApiServiceException extends Exception {
    /**
     * 错误编码
     */
    private Integer code;

    /**
     * 错误的提示信息
     */
    private String errorMessage;

    public ApiServiceException(AbstractBaseExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }

    /**
     * 获取异常的类的具体名称
     */
    public abstract String getExceptionClassName();
}
