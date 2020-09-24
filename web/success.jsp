<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
<%-- 通过EL表达式，获取请求参数param中值username --%>
<h1 style="color: cadetblue">成功，欢迎${param.username}</h1>

<%-- 从请求作用域中获取属性值 --%>
${requestScope.msg}
<%= request.getAttribute("msg") %>

<br>
<a href="user?method=logout"><h1 style="color: cadetblue">欢迎${sessionScope.user.name}登录</h1></a>
<a href="<%= response.encodeURL("index.jsp") %>">访问index.jsp页面</a>

<%=request.getRemoteAddr() %>
</body>
</html>
