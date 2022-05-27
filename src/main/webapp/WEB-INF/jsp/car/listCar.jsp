<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>List Cars</title>
</head>
<body>
<%@include file="../fragments/infoRole.jsp" %>
<%@include file="../fragments/logOut.jsp" %>
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
            <sec:authorize access="hasRole('ADMIN')">
            <td><a href="/Admin/safetyDeleteCar/${item.id}">delete</a></td>
            <td><a href="/Admin/updateCar/${item.id}">update</a></td>
            </sec:authorize>
        </tr>
    </c:forEach>

    <sec:authorize access="hasRole('ADMIN')">
        <tr>
            <td><a href="/Admin/addCar">Add Car</a></td>
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
