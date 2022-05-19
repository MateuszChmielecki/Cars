<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Cars</title>
</head>
<body>
<%--@elvariable id="cars" type="java.util.List<pl.mateusz.Cars.entity.Car>"--%>
<table>
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
            <td><a href="/safetyDeleteCar/${item.id}">delete</a></td>
            <td><a href="/updateCar/${item.id}">update</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="/addCar">Add Car</a></td>
    </tr>
    <tr>
        <td><a href="/listBrand">Brand list</a></td>
    </tr>
    <tr>
        <td><a href="/listGroup">Group list</a></td>
    </tr>
</table>

</body>
</html>
