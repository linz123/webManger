package com.linz.service;

import com.linz.model.User;
import com.linz.util.DbUtil;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;


/**
 * 用户服务类
 *
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
        params.add(user.getUsername());
        params.add(user.getPassword());
        params.add(user.getGenerate_time());
        params.add(user.getSex());
        return this.executeUpdate(sql, params);
    }

    /**
     * 通过用户名查找是否有此用户
     *
     * @param userName 用户名
     * @return boolean
     */
    public User getUserByName(String userName) {
        User user = null;
        String sql = "SELECT * FROM manger_user WHERE username = ?";
        ArrayList<Object> params = new ArrayList<>();
        params.add(userName);
        Object resultObject = null;
        try {
            ResultSet resultSet = this.executeQuery(sql, params);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int cols_len = metaData.getColumnCount();
            Class cls = User.class;
            while (resultSet.next()) {
                resultObject = cls.newInstance();
                for (int i = 0; i < cols_len; i++) {
                    String cols_name = metaData.getColumnName(i + 1);
                    Object cols_value = resultSet.getObject(cols_name);
                    Field field = cls.getDeclaredField(cols_name);
                    field.setAccessible(true);
                    if (cols_value != null) {
                        field.set(resultObject, cols_value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (User) resultObject;
    }

}
