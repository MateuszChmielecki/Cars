<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Brands</title>
</head>
<body>
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
            <td><a href="/safetyDeleteBrand/${item.id}">delete</a></td>
            <td><a href="/updateBrand/${item.id}">update</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="/addBrand">Add Brand</a></td>
    </tr>
    <tr>
        <td><a href="/listCar">Car list</a></td>
    </tr>
    <tr>
        <td><a href="/listGroup">Group list</a></td>
    </tr>
</table>

</body>
</html>
