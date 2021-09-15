package com.baizhi.entity;

import org.apache.ibatis.plugin.Interceptor;

import java.io.Serializable;

public class Admin implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String solt;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", solt='" + solt + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSolt() {
        return solt;
    }

    public void setSolt(String solt) {
        this.solt = solt;
    }

    public Admin(Integer id, String username, String password, String solt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.solt = solt;
    }

    public Admin() {
    }
}
