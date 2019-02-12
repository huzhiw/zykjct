package com.zykjct.user.api;

import com.zykjct.kernel.core.reqres.response.ResponseData;
import com.zykjct.user.api.fallback.OrderFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 订单服务
 * @author: huzhiwen
 * @create: 2019-02-03 13:09
 **/

@FeignClient(name = "zykjct-order-remote",fallback = OrderFallBack.class)
public interface OrderService {

    @PostMapping("/queryOrder")
    ResponseData queryOrder(@RequestParam("tradeNo") String tradeNo);
}
