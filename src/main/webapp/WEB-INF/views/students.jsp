<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
Students list<br><br>
<table>
    <tr>
        <th>Id</th>
        <th>User name</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td><c:out value="${u.id}"/> </td>
            <td><c:out value="${u.username}"/> </td>
            <td>Change password</td>
        </tr>
    </c:forEach>
</table>
<a href="/home">Home</a>
</body>
</html>
