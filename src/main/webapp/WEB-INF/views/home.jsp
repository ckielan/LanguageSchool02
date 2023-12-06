<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello in ... Language Scholl </h1><br>
Hello . <br>
<a href="/login">Login</a><br><br>

<form action="<c:url value='/logout' />" method="post">
    <input type="submit" value="Logout n"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<sec:authorize access="hasRole('ADMIN')">
    MAM ROLE ADMIN
<form action=<c:url value="/logout" method="post"/>
    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>
</body>
</html>
