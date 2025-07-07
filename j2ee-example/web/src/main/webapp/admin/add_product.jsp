<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/7/2025
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin | Add product</title>
</head>
<body>
<h1>Add product</h1>

<form method="POST" action="${pageContext.request.contextPath}/admin/add_product">
  <table>
    <tr>
      <th>Product Name</th>
      <td>
        <input type="text" name="product_name"/>
      </td>
    </tr>
    <tr>
      <th>Product Description</th>
      <td>
        <input type="text" name="product_description"/>
      </td>
    </tr>
    <tr>
      <th>Product Category</th>
      <td>
        <input type="text" name="product_category"/>
      </td>
    </tr>
    <tr>
      <th>Product Price</th>
      <td>
        <input type="text" name="product_price"/>
      </td>
    </tr>
    <tr>
      <th>Product Quantity</th>
      <td>
        <input type="text" name="product_qty"/>
      </td>
    </tr>

    <tr>
      <td><input type="submit" value="Add Product"></td>
    </tr>
  </table>
</form>
</body>
</html>
