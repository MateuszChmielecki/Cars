
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <form action="<c:url value="/logout"/>" method="post">
        <input class="fa fa-id-badge" type="submit" value="Sing out">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
