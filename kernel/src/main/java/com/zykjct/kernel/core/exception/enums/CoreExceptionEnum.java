package com.zykjct.kernel.core.exception.enums;

import com.zykjct.kernel.core.exception.AbstractBaseExceptionEnum;

/**
 * @description:
 * @author: huzhiwen
 * @create: 2019-01-26 17:53
 **/

public enum CoreExceptionEnum implements AbstractBaseExceptionEnum {
    /**
     * 文件上传
     */
    FILE_READING_ERROR(400, "FILE_READING_ERROR!"),
    FILE_NOT_FOUND(400, "FILE_NOT_FOUND!"),

    /**
     * 错误的请求
     */
    PAGE_NULL(404, "请求页面不存在"),
    IO_ERROR(500, "流读取异常"),
    SERVICE_ERROR(500, "服务器异常"),
    REMOTE_SERVICE_NULL(404, "远程服务不存在");

    private Integer code;
    private String message;

    CoreExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
