package com.linz.service;

import com.linz.model.User;
import com.linz.util.DbUtil;

import java.util.ArrayList;


/**
 * 用户服务类
 * @author linz
 */
public class UserService extends DbUtil {


    /**
     * 添加用户
     *
     * @param user 用户实体类
     * @return boolean 是否添加成功
     */
    public boolean addUser(User user) {
        String sql = "INSERT INTO manger_user (user_id,username,password,generate_time,sex) VALUES (null,?,?,?,?)";
        ArrayList<Object> params = new ArrayList<>();
        params.add(user.getUserName());
        params.add(user.getPassword());
        params.add(user.getGenerate_time());
        params.add(user.getSex());
        return this.executeUpdate(sql, params);
    }

}
