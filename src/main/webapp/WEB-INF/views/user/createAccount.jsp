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
<h1>Utwórz konto</h1>
<div class="container">
    <form:form method="post" modelAttribute="user">
        Nazwa użytkownika:<form:input path="username"/>
        <form:errors path="username" cssClass="errors"/><br>
        Email :<form:input path="email"/>
        <form:errors path="email" cssClass="errors"/><br>
        Hasło: <form:password id="password" path="password"/><br>
        <form:errors path="password" cssClass="errors"/>
        <div class="comments" style="display: inline">
            <span id="visibilityPassword" onclick="togglePasswordVisibility()">Pokaż hasło</span>
        </div>
        <br>Potwierdź hasło: <input type="password" id="confirmPassword"/>
        <div id="incorectPassword" style="visibility: hidden" class="errors"><br>Hasła niezgodne</div>
        <button type="submit" onclick="return validatePasswords()">Utwórz konto</button>
    </form:form>
    <script>
        function validatePasswords() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;

            if (password !== confirmPassword) {
                alert("Hasło i potwierdzenie hasła nie są zgodne.");
                document.getElementById("incorectPassword").style.visibility = "visible"
                return false;
            }

            return true;
        }

        function togglePasswordVisibility() {
            var passwordField = document.getElementById("password")
            var confirmPasswordField = document.getElementById("confirmPassword")
            var controlPassword = document.getElementById("visibilityPassword")
            if (passwordField.type === "password") {
                passwordField.type = "text"
                confirmPasswordField.type = "text"
                controlPassword.textContent = "Ukryj hasło"
            } else {
                passwordField.type = "password"
                confirmPasswordField.type = "password"
                controlPassword.textContent = "Pokaż hasło"
            }
        }
    </script>
</div>
</body>
</html>
