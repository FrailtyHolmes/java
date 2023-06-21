package com.admin.service;

import com.admin.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 *  Service 的CRUD也不用写了
 */
//IService，mybatisPlus提供的service顶级方法，里面封装了几乎所有的操作
public interface UserService extends IService<User> {
    
}
