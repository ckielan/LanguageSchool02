
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h3>Welcome to JournalDEV Tutorials</h3>

<sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <c:url value="/logout" var="logoutUrl" />

    <c:choose>
        <c:when test="${empty pageContext.request.userPrincipal.name}">
            <!-- User is not authenticated -->
            <a href="/login">Login</a>
        </c:when>
        <c:otherwise>
            <!-- User is authenticated -->
            <form id="logoutForm" action="${logoutUrl}" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <a href="javascript:document.getElementById('logoutForm').submit()">Logout</a>
        </c:otherwise>
    </c:choose>
</sec:authorize>

<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>