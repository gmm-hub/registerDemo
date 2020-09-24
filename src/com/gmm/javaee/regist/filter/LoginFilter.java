package com.gmm.javaee.regist.filter;

import com.gmm.javaee.regist.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "f2", urlPatterns = {"/index.jsp"},initParams = {@WebInitParam(name = "begin",value = "8"),
@WebInitParam(name = "end",value = "10")})
public class LoginFilter implements Filter {
    private int begin;
    private int end;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Date date = new Date();
        int hours = date.getHours();

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        if(hours>=8 && hours<=10){
            if(user==null){
                //未登录，回到登录页面
                request.setAttribute("msg","当前时间段，资源必须登陆后访问");
                request.getRequestDispatcher("login.jsp").forward(request,resp);
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        begin = Integer.parseInt(config.getInitParameter("begin"));
        end = Integer.parseInt(config.getInitParameter("end"));

    }

}
