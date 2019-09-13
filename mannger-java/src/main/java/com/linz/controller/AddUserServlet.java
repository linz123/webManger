package com.linz.controller;

import com.linz.model.User;
import com.linz.service.UserService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(1);
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer sex = Integer.parseInt(req.getParameter("sex"));
        JSONObject json = new JSONObject();
        resp.setContentType("application/json;charset=UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter writer = resp.getWriter();
        try {
            Date generateTime = simpleDateFormat.parse(req.getParameter("generateTime"));
            if (this.checkParams(userName, password, sex, generateTime)) {
                UserService userService = new UserService();
                User user = userService.getUserByName(userName);
                System.out.println("user");
                System.out.println(user);
                System.out.println("end");
                if (user == null) {
                    User userBody = new User();
                    userBody.setUsername(userName);
                    userBody.setPassword(password);
                    userBody.setGenerate_time(generateTime);
                    userBody.setSex(sex);
                    boolean isAdd = userService.addUser(userBody);
                    if (isAdd) {
                        json.put("message", "添加成功！");
                        json.put("status", 200);
                    } else {
                        json.put("message", "添加失败！");
                        json.put("status", 400);
                    }
                } else {
                    json.put("message", "用户名已存在！");
                    json.put("status", 400);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            json.put("message", "系统错误！");
            json.put("status", 400);
        }
        writer.write(json.toString());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }


    /**
     * 检测参数是否合格
     *
     * @param username     用户名
     * @param password     密码
     * @param sex          性别
     * @param generateTime 注册时间
     * @return boolean
     */
    private boolean checkParams(String username, String password, Integer sex, Date generateTime) {

        return true;
    }
}
