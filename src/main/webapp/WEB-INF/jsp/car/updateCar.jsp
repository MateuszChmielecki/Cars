<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Update Car Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%@include file="../fragments/infoRole.jsp" %>
<%@include file="../fragments/logOut.jsp" %>
<%--@elvariable id="car" type="pl.mateusz.Cars.entity.Car"--%>
<form:form modelAttribute="car" method="post">
    <label for="brand">Brand</label>
    <form:select path="brand" items="${brand}" itemLabel="name" itemValue="id"/>
    <form:errors path="brand" cssClass="error"/>

    <br>
    <label for="model">Model</label>
    <form:input path="model"/>${car.model}
    <form:errors path="model" cssClass="error" />
    <br>
    <label for="model">Model Code</label>
    <form:input path="modelCode"/>${car.modelCode}
    <form:errors path="modelCode" cssClass="error" />
    <br>
    <label for="productionYearFrom">Production Year From</label>
    <form:input path="productionYearFrom" />${car.productionYearFrom}
    <form:errors path="productionYearFrom" cssClass="error"/>
    <br>
    <label for="productionYearTo">Production Year To</label>
    <form:input path="productionYearTo" />${car.productionYearTo}
    <form:errors path="productionYearTo" cssClass="error"/>
    <br>
    <label for="carSegment">Segment</label>
    <form:select path="carSegment">${car.carSegment}
        <form:options path="${CarSegment}" />
    </form:select>
    <form:errors path="carSegment" cssClass="error"/>
    <br>
    <label for="carPicture">Car Picture</label>
    <form:textarea path="carPicture"/>${car.carPicture}
    <form:errors path="carPicture" cssClass="error"/>
    <br>
    <input type="submit">
</form:form>
<tr>
    <td><a href="/Cars/listCar">Cancel</a></td>
</tr>
</body>
</html>
