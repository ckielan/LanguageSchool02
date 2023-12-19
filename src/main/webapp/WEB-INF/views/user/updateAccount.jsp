<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Szkoła angielskiego</title>
    <link type="text/css" rel="stylesheet" href="/static/styles.css">
    <style>
        .errors {
            color: red;
        }

        .comments {
            font-size: x-small;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Edycja konta</h1>
<div class="container">
    <form:form method="post" modelAttribute="user">
        Nazwa użytkownika:<form:input path="username"/>
        <form:errors path="username" cssClass="errors"/><br>
        Imię:<form:input path="firstname"/>
        Nazwisko:<form:input path="lastname"/>
        Email :<form:input path="email"/>
        <form:errors path="email" cssClass="errors"/><br>
        <input type="hidden" name="id" value="${user.id}" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" onclick="return validatePasswords()">Zapisz zmiany</button>
    </form:form>

</div>
</body>
</html>
