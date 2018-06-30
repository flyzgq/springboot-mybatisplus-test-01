package com.fly.springboot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @author fly
 * @date 2018/6/30 18:55
 * @description
 **/
@TableName(value = "tbl_employee")
public class Employee {
//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    /**
     * avatr 在数据库中没有对应的字段
     */
    @TableField(exist = false)
    private String avatr;
    public Employee() {
    }

    public Employee(String lastName, String email, Integer gender, Integer age, String avatr) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.avatr = avatr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatr() {
        return avatr;
    }

    public void setAvatr(String avatr) {
        this.avatr = avatr;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", avatr='" + avatr + '\'' +
                '}';
    }
}
