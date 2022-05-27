<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>List Brands</title>
</head>
<body>
<%@include file="../fragments/infoRole.jsp" %>
<%@include file="../fragments/logOut.jsp" %>
<%--@elvariable id="cars" type="java.util.List<pl.mateusz.Cars.entity.Brand>"--%>
<table>
    <tr>
        <td>ID: </td>
        <td>Group name: </td>
        <td>Name: </td>
        <td>Country of orgins: </td>
    </tr>
    <c:forEach var="item" items="${brands}">
        <tr>
            <td>${item.id}</td>
            <td>${item.group.name}</td>
            <td>${item.name}</td>
            <td>${item.countryOfOrgins}</td>
            <sec:authorize access="hasRole('ADMIN')">
            <td><a href="/Admin/safetyDeleteBrand/${item.id}">delete</a></td>
            <td><a href="/Admin/updateBrand/${item.id}">update</a></td>
            </sec:authorize>
        </tr>
    </c:forEach>
    <sec:authorize access="hasRole('ADMIN')">
        <tr>
            <td><a href="/Admin/addBrand">Add Brand</a></td>
        </tr>
    </sec:authorize>
    <tr>
        <td><a href="/Cars/listCar">Car list</a></td>
    </tr>
    <tr>
        <td><a href="/Cars/listGroup">Group list</a></td>
    </tr>

</table>

</body>
</html>
