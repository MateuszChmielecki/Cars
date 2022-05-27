<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Search Car</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%@include file="fragments/infoRole.jsp" %>
<%@include file="fragments/logOut.jsp" %>
How do you want find Cars?
<br>
<form name="search" action="search" method="post">
    <label for="search">Choose a search option:</label>

    <select name="search" id="search">
        <option value="byModel">By model</option>
        <option value="byCode">By model code</option>
        <option value="byBrand">By brand</option>
        <option value="ByGroup">By group</option>
    </select>
    Query: 
    <input type="text" name="query"/>

    <button type="submit">search</button>
</form>

</body>
</html>
