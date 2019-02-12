package com.zykjct.user.service;

import com.zykjct.user.entity.User;
import com.zykjct.user.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author huzhiwen
 * @since 2019-01-31
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
