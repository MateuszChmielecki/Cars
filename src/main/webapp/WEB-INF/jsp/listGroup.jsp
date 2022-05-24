<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>List Groups</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>
<%--@elvariable id="group" type="java.util.List<pl.mateusz.Cars.entity.Group>"--%>
<table>
    <sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    </sec:authorize>
    <tr>
        <td>ID: </td>
        <td>Name: </td>
        <td>Country of orgins: </td>
    </tr>
    <c:forEach var="item" items="${groups}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.country}</td>
            <sec:authorize access="hasRole('ADMIN')">
            <td><a href="/safetyDeleteGroup/${item.id}">delete</a></td>
            <td><a href="/updateGroup/${item.id}">update</a></td>
            </sec:authorize>
        </tr>
    </c:forEach>
    <sec:authorize access="hasRole('ADMIN')">
        <tr>
            <td><a href="/Cars/addGroup">Add Group</a></td>
        </tr>
    </sec:authorize>
    <tr>
        <td><a href="/Cars/listBrand">Brand list</a></td>
    </tr>
    <tr>
        <td><a href="/Cars/listCar">Car list</a></td>
    </tr>
</table>

</body>
</html>
