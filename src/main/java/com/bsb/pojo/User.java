package com.bsb.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private Integer id;
    private String real_name;
    private String phone;
    private String password;
    private Integer type;
    private Date create_time;
    private Date update_time;

    public User(Integer id, String real_name, String phone, String password, Integer type, Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.real_name = real_name;
        this.phone = phone;
        this.password = password;
        this.type = type;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public User() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
