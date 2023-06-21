package com.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Frailty
 * @date 2023年03月07日 11:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")//指定这个类与数据库的哪张表进行对应
public class User {
    /**
     * 如果使用mybatisPlus，那么所有属性都应该在数据库中
     */
    @TableField(exist = false)//表示这个属性在表中不存在
    private String userName;
    @TableField(exist = false)
    private String password;

    //以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
