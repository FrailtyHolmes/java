package com.admin.mapper;

import com.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public Account getAcct(Integer id);
}
