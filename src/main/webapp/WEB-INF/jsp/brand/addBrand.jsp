<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Add Brand Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%@include file="../fragments/infoRole.jsp" %>
<%@include file="../fragments/logOut.jsp" %>

<%--@elvariable id="brand" type="pl.mateusz.Cars.entity.Brand"--%>
<form:form modelAttribute="brand" method="post">
    <label for="group">Group</label>
    <form:select path="group" items="${group}" itemLabel="name" itemValue="id"/>
    <form:errors path="group" cssClass="error"/>
    <br>
    <label for="name">Name</label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error" />
    <br>
    <label for="countryOfOrgins">Country of Orgins</label>
    <form:input path="countryOfOrgins"/>
    <form:errors path="countryOfOrgins" cssClass="error" />

    <input type="submit">
</form:form>
<tr>
    <td><a href="/Cars/listBrand">Cancel</a></td>
</tr>
</body>
</html>
