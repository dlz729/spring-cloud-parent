package com.example.fegin.entity.vo;

/**
 * @author dlz
 * @date 2020/8/26
 * @description
 */
public class UserVo {

    private String name;
    private Integer age;

    public UserVo() {
    }

    public UserVo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
