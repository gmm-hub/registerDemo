<%@ page import="com.gmm.javaee.regist.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首界面</title>
  </head>
<%--  <%--%>
<%--    String username = null;--%>
<%--    String password = null;--%>
<%--    //获取cookie对象--%>
<%--    Cookie[] cookies = request.getCookies();--%>
<%--    if (cookies!=null){--%>
<%--      //判断登录状态--%>
<%--      for (Cookie cookie : cookies) {--%>
<%--        if (cookie.getName().equals("name")){--%>
<%--          username = cookie.getValue();--%>
<%--        }--%>
<%--        if (cookie.getName().equals("pwd")){--%>
<%--          password = cookie.getValue();--%>
<%--        }--%>
<%--      }--%>
<%--    }--%>
<%--    if (username!=null&&password!=null){--%>
<%--      --%>
<%--    }--%>
<%
  //登录访问控制
  User user = (User) session.getAttribute("user");
  if (user==null){
    //未登录状态
    request.setAttribute("msg","当前资源必须登录后访问");
    request.getRequestDispatcher("login.jsp").forward(request,response);
  }

%>

<%--  %>--%>
  <body>
  <h1 style="color: cadetblue">欢迎${sessionScope.user.name}登录</h1>
<h1>这是首页</h1>
  </body>
</html>
