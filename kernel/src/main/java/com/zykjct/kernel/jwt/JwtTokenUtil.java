/**
 * Copyright 2018-2020 stylefeng & fengshuonan (sn93@qq.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zykjct.kernel.jwt;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;

/**
 *         jwt的claim里一般包含以下几种数据:
 *         1. iss -- token的发行者
 *         2. sub -- 该JWT所面向的用户
 *         3. aud -- 接收该JWT的一方
 *         4. exp -- token的失效时间
 *         5. nbf -- 在此时间段之前,不会被处理
 *         6. iat -- jwt发布时间
 *         7. jti -- jwt唯一标识,防止重复使用
 * @description:  jwt工具类
 * @author: huzhiwen
 * @create: 2019-01-26 20:45
 **/

public class JwtTokenUtil {

    /**
     * jwt的秘钥
     */
    private static String jwtSecret;

    /**
     * 默认jwt的过期时间
     */
    private static Long defaultExpiredDate;

    public JwtTokenUtil(String jwtSecret, Long defaultExpiredDate) {
        this.jwtSecret = jwtSecret;
        this.defaultExpiredDate = defaultExpiredDate;
    }

    /**
     * 获取用户名从token中
     */
    public static String getUserIdFromToken(String token) {
        return getClaimFromToken(token).getSubject();
    }

    /**
     * 获取jwt发布时间
     */
    public static Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token).getIssuedAt();
    }

    /**
     * 获取jwt失效时间
     */
    public static Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token).getExpiration();
    }

    /**
     * 获取jwt接收者
     */
    public static String getAudienceFromToken(String token) {
        return getClaimFromToken(token).getAudience();
    }

    /**
     * 获取私有的jwt claim
     */
    public static String getPrivateClaimFromToken(String token, String key) {
        return getClaimFromToken(token).get(key).toString();
    }

    /**
     * 获取jwt的payload部分
     */
    public static Claims getClaimFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 解析token是否正确(true-正确, false-错误)<br>
     */
    public static Boolean checkToken(String token) throws JwtException {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    /**
     * <pre>
     *  验证token是否失效
     *  true:过期   false:没过期
     * </pre>
     */
    public static Boolean isTokenExpired(String token) {
        try {
            final Date expiration = getExpirationDateFromToken(token);
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    /**
     * 生成token,根据userId和默认过期时间
     */
    public static String generateToken(String userId, Map<String, Object> claims) {
        final Date expirationDate = new Date(System.currentTimeMillis() + defaultExpiredDate * 1000);
        return generateToken(userId, expirationDate, claims);
    }

    /**
     * 生成token,根据userId和过期时间
     */
    public static String generateToken(String userId, Date exppiredDate, Map<String, Object> claims) {
        final Date createdDate = new Date();
        if (claims == null) {
            return Jwts.builder()
                    .setSubject(userId)
                    .setIssuedAt(createdDate)
                    .setExpiration(exppiredDate)
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
        } else {
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(userId)
                    .setIssuedAt(createdDate)
                    .setExpiration(exppiredDate)
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
        }
    }
}