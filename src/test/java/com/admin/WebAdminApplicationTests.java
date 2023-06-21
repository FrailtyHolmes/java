package com.admin;

import com.admin.bean.User;
import com.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
@Slf4j
class WebAdminApplicationTests {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    DataSource  dataSource;
    
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        final Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        log.info("{}",aLong);
        log.info("数据库类型：{}",dataSource.getClass());
    }
    
    @Test
    void testUserMapper(){
        final User user = userMapper.selectById(1L);
        log.info("用户信息：{}",user);
    }
    
}
