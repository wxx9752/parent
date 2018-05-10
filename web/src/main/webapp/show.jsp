
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${list}" var="u">
    ${u.goodsprice}<br>
    ${u.jinprice}<br>
</c:forEach>
</body>
</html>
