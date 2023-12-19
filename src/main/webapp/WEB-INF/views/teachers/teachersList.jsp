<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
Lista uczniów<br><br>
<table>
    <tr>
        <th>Id</th>
        <th>Nazwa użytkownika</th>
        <th>Adres email</th>
        <th>Aktywny</th>
        <th>Uprawnienia</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${userList}" var="u">
        <tr>
            <td><c:out value="${u.id}"/> </td>
            <td><c:out value="${u.username}"/> </td>
            <td><c:out value="${u.email}"/> </td>
            <td><c:out value="${u.enabled}"/> </td>
            <td><c:forEach items="${u.roles}" var="a">
                    <c:out value="${a.name_shortcut},"></c:out>
                </c:forEach>
            <td>Reset password Edit</td>
        </tr>
    </c:forEach>
</table>
<a href="/home">Home</a>
</body>
</html>
