package com.linz.model;

import java.util.Date;

public class User {
    private Integer user_id;
    private String username;
    private String password;
    private Date generate_time;
    private Date login_time;
    private Date last_login_time;
    private Integer sex;
    private int count;

    public User(
            Integer user_id, String username, String password, Date generate_time, Date login_time,
            Date last_login_time, Integer sex, int count) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.generate_time = generate_time;
        this.login_time = login_time;
        this.last_login_time = last_login_time;
        this.sex = sex;
        this.count = count;
    }

    public User() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public Date getGenerate_time() {
        return generate_time;
    }

    public void setGenerate_time(Date generate_time) {
        this.generate_time = generate_time;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", username=" + username + ", password="
                + password + ", generate_time=" + generate_time + ", login_time=" + login_time
                + ", last_login_time=" + last_login_time + ", sex=" + sex + ", count=" + count + "]";
    }
}
