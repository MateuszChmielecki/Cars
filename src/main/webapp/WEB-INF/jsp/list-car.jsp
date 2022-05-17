<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="cars" type="java.util.List<pl.mateusz.models.Car>"--%>
<table>
    <c:forEach var="item" items="${cars}">
        <tr>
            <td>${item.id}</td>
            <td>${item.brand.name}</td>
            <td>${item.model}</td>
            <td>${item.modelCode}</td>
            <td>${item.productionYearFrom}</td>
            <td>${item.productionYearTo}</td>
            <td>${item.carSegment}</td>
            <td>${item.carPicture}</td>
            <td><a href="/book/saftydelete/${item.id}">delete</a></td>
            <td><a href="/update-book/${item.id}">update</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
