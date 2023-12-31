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
    <a href="/users/list">Lista użytkowników</a><br>
    <a href="/students/list">Lista uczniów</a>  <a href="/students/add">Dodaj ucznia</a><br>
    <a href="/parents/list">Lista rodziców</a> <a href="/parents/add">Dodaj rodzica</a><br><br>
    <a href="/teacher/list">Lista lektorów</a>  <a href="/teacher/add">Dodaj lektora</a><br>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
    <a href="/users/update">Edytuj konto</a>
    <a href="/confirmlogout">Wyloguj</a>
</sec:authorize>
</body>
</html>
