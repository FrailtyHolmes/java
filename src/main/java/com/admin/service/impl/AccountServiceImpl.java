package com.admin.service.impl;

import com.admin.bean.Account;
import com.admin.mapper.AccountMapper;
import com.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Frailty
 * @date 2023年03月09日 17:53
 */
@Service
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    AccountMapper accountMapper;
    @Override
    public Account getAcctById(Integer id) {
        return accountMapper.getAcct(id);
    }
}
