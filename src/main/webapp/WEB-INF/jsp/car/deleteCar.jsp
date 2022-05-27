<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Delete Car</title>
</head>
<body>
<%@include file="../fragments/infoRole.jsp" %>
<%@include file="../fragments/logOut.jsp" %>
<a href="/Admin/deleteCar/${id}">USUN</a>
<a href="/Cars/listCar">NIE USUWAJ</a>

</body>
</html>