package com.zykjct.order.service;

import com.zykjct.order.entity.Order;
import com.zykjct.order.mapper.OrderMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author huzhiwen
 * @since 2019-02-01
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

}
