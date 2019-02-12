package com.zykjct.order.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zykjct.kernel.core.page.PageFactory;
import com.zykjct.kernel.core.page.PageInfo;
import com.zykjct.kernel.core.reqres.response.ResponseData;
import com.zykjct.order.entity.Order;
import com.zykjct.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 订单控制器
 * @author: huzhiwen
 * @create: 2019-02-01 09:40
 **/

@Api(value = "订单操作",tags = "订单操作")
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/queryOrder")
    @ApiOperation(value = "查询订单", notes = "查询订单")
    public ResponseData queryOrder(@ApiParam(value = "订单号",required = true) @RequestParam("tradeNo") String tradeNo) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("tradeNo", tradeNo);
        Page<Order> page = new PageFactory().defaultPage();
        page = (Page<Order>) orderService.page(page,wrapper);
        PageInfo pageInfo = new PageInfo(page);
        return ResponseData.success(pageInfo);
    }
}
