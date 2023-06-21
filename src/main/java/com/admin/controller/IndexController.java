package com.admin.controller;

import com.admin.bean.Account;
import com.admin.bean.User;
import com.admin.service.AccountService;
import com.mysql.cj.jdbc.JdbcConnection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Frailty
 * @date 2023年03月07日 11:27
 */
@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    AccountService accountService;

    @ResponseBody
    @GetMapping("/acct")
    public Account getAccountById(@RequestParam("id") Integer id){
        return accountService.getAcctById(id);
    }   
    
    @ResponseBody //界面写入json数据，不加会报错
    @GetMapping("/sql")
    public String SqlQueryDb(){
        final Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        //注意记得开启驼峰命名策略
        return aLong.toString();
    }
    /**
     * 来登录页
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }
    
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUserName())&& "123456".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止网页刷新时表单重复提交
            return "redirect:/main.html";
        }
        else{
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }
    }
    
    /**
     * 去main页面
     * @return
     */
    @GetMapping(value = "/main.html")
    public String mainPage(HttpSession session, Model model){
        //是否登录。  拦截器，过滤器
        //必须判断loginUser是否为空，main页面必须登录成功才能访问
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
//            return "/main";
//        }else{
//            //回到登录页面
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        //已经在拦截器中配置了以上逻辑
        log.info("执行mainPage");
        return "/main";
    }
    
}
