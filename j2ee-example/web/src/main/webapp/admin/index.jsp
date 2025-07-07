<%@ page import="javax.naming.InitialContext" %>
<%@ page import="lk.jiat.app.core.service.ProductService" %>
<%@ page import="lk.jiat.app.core.model.Product" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/7/2025
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Admin Dashboard</h1>
<a href="${pageContext.request.contextPath}/admin/add_product.jsp">Add Product</a>

<h1>All Products </h1>
<%
    try {
        InitialContext ic = new InitialContext();
        ProductService productService = (ProductService) ic.lookup("java:global/j2ee-example-ear/product-module/ProductSessionBean!lk.jiat.app.core.service.ProductService");
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
        <th>Action</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/delete_product?pid=${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
