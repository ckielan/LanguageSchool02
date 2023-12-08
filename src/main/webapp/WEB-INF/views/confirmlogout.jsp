<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="/static/styles.css">
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>logout</title>
</head>
<body><br>
<br>
<h3>Please confirm logout</h3>
<div class="container">


            <!-- User is authenticated -->
            <security:logout logout-url="/logout" logout-success-url="/login" invalidate-session="true"
                             delete-cookies="JSESSIONID"/>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <button type="submit">Wyloguj</button>
            </form


    </div>

<br>
<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>--%>
<%--    <p>Posiada role: <sec:authentication property="authorities"/></p>--%>
<%--</sec:authorize>--%>
</body>
</html>
