package com.zykjct.kernel.core.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;


/**
 * @description:  分页结果的封装
 * @author: huzhiwen
 * @create: 2019-01-26 21:06
 **/


public class PageInfo<T> {
    // 结果集
    private List<T> rows;

    // 总数
    private long total;

    public PageInfo(Page<T> page) {
        this.rows = page.getRecords();
        this.total = page.getTotal();
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
