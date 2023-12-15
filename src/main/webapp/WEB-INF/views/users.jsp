<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
Users list<br><br>
<table>
    <tr>
        <th>Id</th>
        <th>User name</th>
        <th>User email</th>
        <th>User enabled</th>
<%--        <th>User role</th>--%>
        <th>Action</th>
    </tr>
    <c:forEach items="${user}" var="u">
        <tr>
            <td><c:out value="${u.id}"/> </td>
            <td><c:out value="${u.username}"/> </td>
            <td><c:out value="${u.email}"/> </td>
            <td><c:out value="${u.enabled}"/> </td>
<%--            <td><c:out value="${u.roles}"/> </td>--%>
            <td>Reset password Edit</td>
        </tr>
    </c:forEach>
</table>
<a href="/home">Home</a>
</body>
</html>
