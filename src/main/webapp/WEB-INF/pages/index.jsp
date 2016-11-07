<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/res/img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
    <link href="/res/css/j4we.css" rel="stylesheet" type="text/css"/>
    <script src="/res/js/HttpRequest.js"></script>
    <script src="/res/js/j4we.js"></script>
</head>
<body>
Hello from Spring. Now is ${date}. ${text}<br>

<label for="personId">Input person to see details: </label>
<input type="number" min="0" value="0" id="personId">

<div id="persons"></div>

</body>
</html>
