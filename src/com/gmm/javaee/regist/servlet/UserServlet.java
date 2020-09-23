package com.gmm.javaee.regist.servlet;

import com.gmm.javaee.regist.entity.User;
import com.gmm.javaee.regist.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        RegisterService service = new RegisterService();

        String method = request.getParameter("method");


        switch (method){
            case "login":
                break;
            case "logout":

                break;
            case "register":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                int age = Integer.parseInt(request.getParameter("age"));
                String sex  = request.getParameter("sex");
                if (username!=null&&!"".equals(username)&&password!=null&&!"".equals(password)){
                    User user = new User(username,password,age,sex);
                    int i = service.register(user);
                    if (i>0){
                        response.sendRedirect("success.jsp");
                    }
                }
                else {
                    request.setAttribute("msg","所填信息格式不对");
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
