package com.zykjct.kernel.jwt;

import lombok.Data;

/**
 * @description:  jwt相关配置
 * @author: huzhiwen
 * @create: 2019-01-26 20:44
 **/

@Data
public class JwtProperties {
    /**
     * jwt的秘钥
     */
    private String secret = "u47RE1DLrxfd79w";

    /**
     * jwt过期时间(单位:秒)(默认:1天)
     */
    private Long expiration = 82800L;
}
