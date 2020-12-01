package com.example.provider.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dlz
 * @date 2020/12/1 17:23
 * @description
 */
@Data
@TableName("user3")
@NoArgsConstructor
@AllArgsConstructor
public class User2 implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    @TableId(value = "id")
    private Integer id;


    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String passWord;

    private String perms;
    /**
     * 是否删除。0未删除，1删除
     */
    // @TableLogic
    // private Integer isDel;

    /**
     * 版本号
     */
    // @Version
    // private Integer version;
}
