<%@ page import="javax.naming.InitialContext" %>
<%@ page import="lk.jiat.app.core.service.ProductService" %>
<%@ page import="lk.jiat.app.core.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.naming.NamingException" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/6/2025
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Home</h1>

<c:if test="${empty pageContext.request.userPrincipal}">

    <a href="${pageContext.request.contextPath}/register.jsp">Register</a>
    <a href="${pageContext.request.contextPath}/login.jsp">Login</a>

</c:if>
<c:if test="${not empty pageContext.request.userPrincipal}">

    <a href="${pageContext.request.contextPath}/logout">Logout</a>

</c:if>



<%
    try {
        InitialContext ic = new InitialContext();
        ProductService productService = (ProductService) ic.lookup("lk.jiat.app.core.service.ProductService");
        List<Product> products = productService.getAllProduct();
        pageContext.setAttribute("products", products);
    } catch (NamingException e) {
        throw new RuntimeException(e);
    }
%>

<table>
    <tr>
        <th>Product</th>
        <th>Description</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
