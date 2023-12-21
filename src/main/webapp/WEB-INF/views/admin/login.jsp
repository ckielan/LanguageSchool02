<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%--    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style.css"/>--%>
    <link type="text/css" rel="stylesheet" href="/static/styles.css">
    <title>Login to LanguageSchool</title>

</head>
<body>
<div class="page-search-info">
    <h1>Szkoła języka angielskiego</h1>
    <br><br>
</div>
<a href="/students/registerStudent">Załóż konto</a>

    <br>

<div class="container">
    <form method="post">
        <div><label> Nazwa użytkownika : <input type="text" name="username"/> </label></div>
        <div><label> Hasło: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Zaloguj"/></div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

</div>
</body>
</html>
