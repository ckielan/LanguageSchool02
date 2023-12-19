<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/static/styles.css">
</head>
<body>
<h1>Hello in ... Language Scholl </h1><br>
Hello . <br>


<sec:authorize access="hasRole('ADMIN')">
    <a href="/users/list">Lista użytkowników</a>
    <a href="/users/add">Dodaj użytkownika</a>
    Lista uczniów<br>
    Lista rodziców<br>
    Lista nauczycieli<br>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
    <a href="/users/update">Edytuj konto</a>
    <a href="/confirmlogout">Wyloguj</a>
</sec:authorize>
</body>
</html>
