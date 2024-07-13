package com.demo.entity;
import java.util.Date;
public class Drivers {
    //ID
    private Integer id;
    //用户名
    private String loginname;
    //密码
    private String password;
    //姓名
    private String username;
    //性别
    private Integer sex;
    //年龄
    private Integer age;
    //电话
    private String phone;
    //驾驶证级别
    private Integer drivinglicense;
    //入职日期
    private Date entryDay;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDrivinglicense() {
        return drivinglicense;
    }
    public void setDrivinglicense(Integer drivinglicense) {
        this.drivinglicense = drivinglicense;
    }

    public Date getEntryDay() {
        return entryDay;
    }
    public void setEntryDay(Date entryDay) {
        this.entryDay = entryDay;
    }
}
