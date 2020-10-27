package com.example.provider.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DO
 *
 * @author dlz
 * @date 2020/8/20
 * @description
 */
@Data
@TableName("user2")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
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
