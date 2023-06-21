package com.admin.controller;

import com.admin.bean.User;
import com.admin.exception.UserTooManyException;
import com.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * @author Frailty
 * @date 2023年03月07日 16:36
 */
@Controller
public class TableController {
    
    @Autowired
    UserService userService;
    /**
     *
     * @param a  不带请求参数或者参数类型不对  400；Bad Request  一般都是浏览器的参数没有传递正确
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") Integer a){
//        int i = 10 / 0;
        return "table/basic_table";
    }
    
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        
        //使最终跳转到 /dynamic/pn界面
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
    
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){
        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123444"), new User("haha", "aaaaa"),
//                new User("hehe ", "aaddd"));
//        model.addAttribute("users",users);
//        if(users.size()>3){
//            throw new UserTooManyException();
//        }
        
        //从user表中取出数据
        //构造分页参数,pn表示当前页，2表示每页最多展示的记录
        Page<User> page = new Page<>(pn, 2);
        //调用page进行分页
        Page<User> userPage = userService.page(page, null);
        
//        userPage.getCurrent(); //当前页数
//        userPage.getPages(); //总页数
//        userPage.getRecords(); //查询记录，这里返回User
        
        model.addAttribute("users",userPage);
        return "table/dynamic_table";
    }
    
    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
