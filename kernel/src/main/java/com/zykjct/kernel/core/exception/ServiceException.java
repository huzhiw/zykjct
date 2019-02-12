package com.zykjct.kernel.core.exception;

import lombok.Data;

/**
 * @description:  业务异常的封装
 * @author: huzhiwen
 * @create: 2019-01-26 17:50
 **/

@Data
public class ServiceException extends RuntimeException {
    private Integer code;

    private String errorMessage;

    public ServiceException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(AbstractBaseExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }
}
