<%--
  Created by IntelliJ IDEA.
  User: 程潇
  Date: 2018/12/22
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>欢迎使用黑马学生管理系统</h2>

  <form action="LoginServlet" method="post">
    账号: <input type="text" name="username" /><br>
    密码: <input type="password" name="password" /><br>
    <input type="submit" value="登录">
  </form>

  </body>
</html>
