<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>List Cars</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>
<%--@elvariable id="cars" type="java.util.List<pl.mateusz.Cars.entity.Car>"--%>
<table>
    <sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    </sec:authorize>
    <tr>
        <td>ID: </td>
        <td>Group name: </td>
        <td>Brand name: </td>
        <td>Country of orgins: </td>
        <td>Model:</td>
        <td>Model code: </td>
        <td>From: </td>
        <td>To: </td>
        <td>Segment: </td>
        <td>Picture: </td>

    </tr>
    <c:forEach var="item" items="${cars}">
        <tr>
            <td>${item.id}</td>
            <td>${item.brand.group.name}</td>
            <td>${item.brand.name}</td>
            <td>${item.brand.countryOfOrgins}</td>
            <td>${item.model}</td>
            <td>${item.modelCode}</td>
            <td>${item.productionYearFrom}</td>
            <td>${item.productionYearTo}</td>
            <td>${item.carSegment}</td>
            <td>${item.carPicture}</td>
            <sec:authorize access="hasRole('ADMIN')">
            <td><a href="/safetyDeleteCar/${item.id}">delete</a></td>
            <td><a href="/updateCar/${item.id}">update</a></td>
            </sec:authorize>
        </tr>
    </c:forEach>

    <sec:authorize access="hasRole('ADMIN')">
        <tr>
            <td><a href="/Cars/addCar">Add Car</a></td>
        </tr>
    </sec:authorize>
    <tr>
        <td><a href="/Cars/listBrand">Brand list</a></td>
    </tr>
    <tr>
        <td><a href="/Cars/listGroup">Group list</a></td>
    </tr>
</table>

</body>
</html>
