package com.zykjct.kernel.core.page;

import lombok.Data;

/**
 * @description:  分页查询的请求参数封装
 * @author: huzhiwen
 * @create: 2019-01-26 20:12
 **/

@Data
public class PageQuery {
    /**
     * 每页的条数
     */
    private Integer pageSize;

    /**
     * 页编码(第几页)
     */
    private Integer pageNo;

    /**
     * 排序方式(asc 或者 desc)
     */
    private String sort;

    /**
     * 排序的字段名称
     */
    private String orderByField;

    public PageQuery() {
    }

    public PageQuery(Integer pageSize, Integer pageNo, String sort, String orderByField) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.sort = sort;
        this.orderByField = orderByField;
    }
}
