package com.admin.service.impl;

import com.admin.bean.User;
import com.admin.mapper.UserMapper;
import com.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Frailty
 * @date 2023年03月09日 21:16
 */
////ServiceImpl，mybatisPlus提供的service顶级方法，里面封装了几乎所有的操作
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
