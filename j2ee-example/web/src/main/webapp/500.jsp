<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/8/2025
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>500 Error</h1>
${requestScope['jakarta.servlet.error.status_code']}
${requestScope['jakarta.servlet.error.message']}
</body>
</html>
