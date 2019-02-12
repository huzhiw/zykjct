package com.zykjct.kernel.core.exception;

/**
 * @description:
 * @author: huzhiwen
 * @create: 2019-01-26 17:48
 **/

public interface AbstractBaseExceptionEnum {
    /**
     * 获取异常的状态码
     */
    Integer getCode();

    /**
     * 获取异常的提示信息
     */
    String getMessage();
}
