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
<h1>Rejestracja ucznia</h1>
<%@ include file="../user/createAccount.jsp" %>

</body>
</html>
