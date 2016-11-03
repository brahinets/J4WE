<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="/res/img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
    <link href="/res/css/j4we.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<c:forEach items="${persons}" var="person">
    ${person}<br>
</c:forEach>
</body>
</html>
