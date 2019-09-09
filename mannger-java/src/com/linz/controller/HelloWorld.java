package com.linz.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello")
public class HelloWorld implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println(servletRequest.getServerPort());
        System.out.println(servletResponse);
        System.out.println("service");
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<h1>hello world</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
