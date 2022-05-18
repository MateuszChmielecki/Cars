<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Groups</title>
</head>
<body>
<%--@elvariable id="group" type="java.util.List<pl.mateusz.Cars.entity.Group>"--%>
<table>
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
            <td><a href="/saftydelete/${item.id}">delete</a></td>
            <td><a href="/update/${item.id}">update</a></td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
