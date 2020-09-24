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
    <title>注册-界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user?method=register" method="post">

    <table border="1px" cellpadding="10px" cellspacing="0">
        <tr>
            <th colspan="2">注册</th>
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
            <td>年龄</td>
            <td><input type="text" placeholder="请输入年龄" name="age"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" value="男" name="sex">男
                <input type="radio" value="女" name="sex">女
            </td>

        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
