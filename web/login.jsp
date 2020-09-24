<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录-界面</title>
</head>
<%
    String username = null;
    String password = null;
    //获取cookie对象
    Cookie[] cookies = request.getCookies();
    if (cookies!=null){
        //判断登录状态
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")){
                username = cookie.getValue();
            }
            if (cookie.getName().equals("pwd")){
                password = cookie.getValue();
            }
        }
    }
    if (username!=null&&password!=null){
        request.getRequestDispatcher("/user?method=login&username="+username+"&password="+password).forward(request,response);

    }


%>
<body>
<form action="${pageContext.request.contextPath}/user?method=login" method="post">

    <table border="1px" cellpadding="10px" cellspacing="0">
        <tr>
            <th colspan="2">登录</th>
        </tr>
        <tr>
            <td>username</td>
            <td><input type="text" placeholder="请输入姓名" name="username"><span style="color: red">${requestScope.msg}</span></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" placeholder="请输入密码" name="password"></td>
        </tr>
        <tr>
            <td>记住登录状态</td>
            <td>
                <select name="timeLength">
                    <option value="0">正常登录</option>
                    <option value="7">七天免登陆</option>
                    <option value="10">十天免登陆</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
