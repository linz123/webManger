package com.linz.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    /**
     * 链接数据库，返回连接对象
     *
     * @return Connection
     */
    private Connection getDbConnection() {
        final String SERVER = "localhost";
        final String DBNAME = "manger_web";

        String URL = "jdbc:mysql://" + SERVER + ":3306/" + DBNAME;

        final String USERNAME = "root";
        final String PASSWORD = "132875";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 查询数据库
     *
     * @param preparedSql preparedSql 语句
     * @param params      参数列表
     * @return ResultSet 数据集
     */
    public ResultSet executeQuery(String preparedSql, ArrayList<Object> params) {
        connection = this.getDbConnection();
        try {
            preparedStatement.executeQuery(preparedSql);
            if (params != null && !params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDbConnection();
        }

        return resultSet;

    }

    /**
     * 数据库增删改
     *
     * @param preparedSql preparedSql 语句
     * @param params      参数列表
     * @return boolean 是否成功
     */
    public boolean executeUpdate(String preparedSql, ArrayList<Object> params) {
        connection = this.getDbConnection();
        int num = -1;
        try {
            preparedStatement = connection.prepareStatement(preparedSql);
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
            }
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDbConnection();
        }
        return num > 0;
    }

    //关闭数据库连接
    private void closeDbConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
