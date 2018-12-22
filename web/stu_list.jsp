<%--
  Created by IntelliJ IDEA.
  User: 程潇
  Date: 2018/12/22
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>stulist</title>
</head>
<body>
<br>学生列表<br>



<table border="1" width="700">
    <tr align="center">
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>住址</td>
        <td>操作</td>
    </tr>

    <%--<%=session.getAttribute("list")%>--%>
    ${list}
    <c:forEach begin="1" end="10" var="i" step="2">
        ${i }
    </c:forEach>

    <c:forEach items="${list }" var="stu">

        <%--<c:if test=""></c:if>--%>
        <tr align="center">
            <td>${stu.id }</td>
            <td>${stu.name }</td>
            <td>${stu.age }</td>
            <td>${stu.gender }</td>
            <td>${stu.address }</td>
            <td><a href="#">更新</a>   <a href="#">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
