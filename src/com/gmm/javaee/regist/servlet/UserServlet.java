package com.gmm.javaee.regist.servlet;

import com.gmm.javaee.regist.entity.User;
import com.gmm.javaee.regist.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "registerServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("UTF-8");
        RegisterService service = new RegisterService();
        String method = request.getParameter("method");
        HttpSession session = request.getSession();


        if (method!=null&&!"".equals(method)){


            switch (method){
                case "login":
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    if (username!=null&&!"".equals(username)&&password!=null&&!"".equals(password)){
                        User user = service.login(username,password);
                        if (user!=null){
                            String timeLength = request.getParameter("timeLength");
                            int time = 0;
                            if (timeLength!=null && !"0".equals(timeLength)){
                                //创建cookies对象
                                Cookie usernameCookie = new Cookie("name", URLEncoder.encode(username,"UTF-8"));
                                Cookie passwordCookie = new Cookie("pwd",password);
                                //3.设置有效期
                                time = Integer.parseInt(timeLength);
                                usernameCookie.setMaxAge(time*24*60*60);
                                passwordCookie.setMaxAge(time*24*60*60);
                                //4.将Cookie添加到响应对象
                                response.addCookie(usernameCookie);
                                response.addCookie(passwordCookie);

                            }
                            //登录成功将用户信息保存在会话作用中
                            session.setAttribute("user",user);
                            request.getRequestDispatcher("success.jsp").forward(request,response);
                        }
                    }
                    else {
                        request.setAttribute("msg","所填信息格式不对");
                        request.getRequestDispatcher("index.jsp").forward(request,response);
                    }
                    break;
                case "logout":
                    //登出销毁会话
                    session.invalidate();
                    request.setAttribute("msg","当前已退出登录");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                    break;
                case "register":
    //                String username = request.getParameter("username");
    //                String password = request.getParameter("password");
    //                int age = Integer.parseInt(request.getParameter("age"));
    //                String sex  = request.getParameter("sex");
    //                if (username!=null&&!"".equals(username)&&password!=null&&!"".equals(password)){
    //                    User user = new User(username,password,age,sex);
    //                    int i = service.register(user);
    //                    if (i>0){
    //                        response.sendRedirect("success.jsp");
    //                    }
    //                }
    //                else {
    //                    request.setAttribute("msg","所填信息格式不对");
    //                    request.getRequestDispatcher("index.jsp").forward(request,response);
    //                }
                    break;
                default:
                    break;
            }
        }else {
            request.setAttribute("msg","当前未传递具体操作");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
