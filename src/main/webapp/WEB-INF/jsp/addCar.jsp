<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Add Car Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>
<%--@elvariable id="car" type="pl.mateusz.Cars.entity.Car"--%>
<form:form modelAttribute="car" method="post">
    <label for="brand">Brand</label>
    <form:select path="brand" items="${brand}" itemLabel="name" itemValue="id"/>
    <form:errors path="brand" cssClass="error"/>

    <br>
    <label for="model">Model</label>
    <form:input path="model"/>
    <form:errors path="model" cssClass="error" />
    <br>
    <label for="model">Model Code</label>
    <form:input path="modelCode"/>
    <form:errors path="modelCode" cssClass="error" />
    <br>
    <label for="productionYearFrom">Production Year From</label>
    <form:input path="productionYearFrom" />
    <form:errors path="productionYearFrom" cssClass="error"/>
    <br>
    <label for="productionYearTo">Production Year To</label>
    <form:input path="productionYearTo" />
    <form:errors path="productionYearTo" cssClass="error"/>
    <br>
    <label for="carSegment">Segment</label>
    <form:select path="carSegment">
        <form:options path="${CarSegment}" />
    </form:select>
    <form:errors path="carSegment" cssClass="error"/>
    <br>
    <label for="carPicture">Car Picture</label>
    <form:textarea path="carPicture"/>
    <form:errors path="carPicture" cssClass="error"/>
    <br>
    <input type="submit">
</form:form>
<tr>
    <td><a href="/Cars/listCar">Cancel</a></td>
</tr>
</body>
</html>
