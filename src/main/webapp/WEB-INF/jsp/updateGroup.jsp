<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Add Group Form</title>
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
<%--@elvariable id="group" type="pl.mateusz.Cars.entity.Group"--%>
<form:form modelAttribute="group" method="post">

    <label for="name">Name</label>
    <form:input path="name"/>${group.name}
    <form:errors path="name" cssClass="error" />
    <br>
    <label for="country">Country</label>
    <form:input path="country"/>${group.country}
    <form:errors path="country" cssClass="error" />

    <input type="submit">
</form:form>
<tr>
    <td><a href="/Cars/listGroup">Cancel</a></td>
</tr>
</body>
</html>
