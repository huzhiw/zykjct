package com.zykjct.user.api.fallback;

import com.zykjct.kernel.core.reqres.response.ResponseData;
import com.zykjct.user.api.OrderService;
import org.springframework.stereotype.Component;

/**
 * @description: 订单服务熔断器
 * @author: huzhiwen
 * @create: 2019-02-03 13:16
 **/

@Component
public class OrderFallBack implements OrderService {

    @Override
    public ResponseData queryOrder(String tradeNo) {
        return ResponseData.error("调用订单服务发生异常");
    }
}
