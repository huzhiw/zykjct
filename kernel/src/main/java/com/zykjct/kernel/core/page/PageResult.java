package com.zykjct.kernel.core.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:  封装分页结果集
 * @author: huzhiwen
 * @create: 2019-01-26 20:39
 **/

@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -4071521319254024213L;

    private Integer page = 1;// 要查找第几页
    private Integer pageSize = 20;// 每页显示多少条
    private Integer totalPage = 0;// 总页数
    private Long totalRows = 0L;// 总记录数
    private List<T> rows;// 结果集

    public PageResult() {
    }

    public PageResult(Page<T> page) {
        this.setRows(page.getRecords());
        this.setTotalRows(page.getTotal());
        this.setPage((int) page.getCurrent());
        this.setPageSize((int) page.getSize());
    }
}
