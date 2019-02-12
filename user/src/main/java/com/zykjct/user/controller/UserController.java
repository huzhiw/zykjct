package com.zykjct.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zykjct.kernel.core.reqres.response.ErrorResponseData;
import com.zykjct.kernel.core.reqres.response.ResponseData;
import com.zykjct.kernel.core.reqres.response.SuccessResponseData;
import com.zykjct.kernel.jwt.JwtTokenUtil;
import com.zykjct.order.entity.Order;
import com.zykjct.user.api.OrderService;
import com.zykjct.user.entity.User;
import com.zykjct.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @description: 用户控制器
 * @author: huzhiwen
 * @create: 2019-01-27 17:27
 **/

@Api(value = "用户操作",tags = "用户操作")
@RestController
@RequestMapping("/user")
@DefaultProperties(defaultFallback = "fallback")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;


    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @HystrixCommand
    public ResponseData login(@ApiParam(value = "账号",required = true) @RequestParam("username") String username,
                              @ApiParam(value = "密码",required = true) @RequestParam("password") String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        User user = userService.getOne(queryWrapper);
        if (user != null) {
            return ResponseData.success(JwtTokenUtil.generateToken(String.valueOf(user.getId()), new HashMap<>()));
        } else {
            return ResponseData.error("账号或者密码错误");
        }
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @HystrixCommand
    public ResponseData register(@ApiParam(value = "用户名",required = true) @RequestParam("username") String username,
                                 @ApiParam(value = "密码",required = true) @RequestParam("password") String password,
                                 @ApiParam(value = "性别",required = true) @RequestParam("sex") String sex,
                                 @ApiParam(value = "昵称",required = true) @RequestParam("nickName") String nickName,
                                 @ApiParam(value = "电子邮箱",required = true) @RequestParam("email") String email,
                                 @ApiParam(value = "联系电话",required = true) @RequestParam("mobile") String mobile) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(sex);
        user.setNickname(nickName);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setBalance(new BigDecimal("0"));
        if (userService.save(user)) {
            return ResponseData.success();
        } else {
            return ResponseData.error("注册失败");
        }
    }

    @PostMapping("/queryUserInfo")
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @HystrixCommand
    public ResponseData queryUserInfo(@ApiParam(value = "用户名",required = true) @RequestParam("username") String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        User user = userService.getOne(queryWrapper);
        return ResponseData.success(user);
    }

    @PostMapping("/feignTest")
    @ApiOperation(value = "feign熔断测试", notes = "feign熔断测试")
    @HystrixCommand
    public ResponseData queryUserOrder(@ApiParam(value = "订单号",required = true) @RequestParam("tradeNo") String tradeNo) {
        return orderService.queryOrder(tradeNo);
    }

    private ResponseData fallback() {
        return ResponseData.error("太拥挤了，请稍后再尝试");
    }
}
