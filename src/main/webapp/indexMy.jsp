<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 12.07.14
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

    <title>Main page</title>
</head>
<body>
<h2>Available products</h2>
<div class="wraperbody">

    <table id="productList" class="bordered">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>CategoryId</th>
        <th>Category</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="cars" items="${products}">
        <tr>
            <td><c:out value="${cars.id}" /></td>
            <td><c:out value="${cars.name}" /></td>
            <td>$<c:out value="${cars.price}" /></td>
            <td><c:out value="${cars.description}" /></td>
            <td><c:out value="${cars.category.id}" /></td>
            <td><c:out value="${cars.category.name}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div style="margin-top: 40px">
    <div id="addProduct" style="margin-top: 20px">
        <form action="main" method="post" id="adProductForm">
            <label for="productId">Id:</label>
            <input type="text" name="id" id="productId" class="input"/><br/>
            <label for="productName">Name:</label>
            <input type="text" name="name" id="productName" class="input"/><br/>
            <label for="productPrice">Price:</label>
            <input type="text" name="price" id="productPrice" class="input"/><br/>
            <label for="productDescription">Description:</label>
            <textarea id="productDescription" name="description" class="input"></textarea><br/><br/>
            <label for="categoryId">Category Id:</label>
            <input type="text" name="categoryId" id="categoryId" class="input"/><br/>
            <label for="categoryName">categoryName</label>
            <input type="text" name="categoryName" id="categoryName" class="input"/><br/>
            <label for="addProductSubmitBtn"></label>
            <input type="submit" id="addProductSubmitBtn" class="button" value="Submit">
        </form>
    </div>
</div>


<!--
<form action="main" method="post" >
    <p>
        <b>Id:</b><br> <input name="id" type="text" size="30">
        <br><b>Name:</b><br> <input name="name" type="text" size="30">
        <br><b>Price:</b><br> <input name="price" type="text" size="30">
        <br><b>Description:</b><br> <input name="description" type="text" size="30">
        <br><b>Category id:</b><br> <input name="categoryId" type="text" size="30">
        <br><b>Category name:</b><br> <input name="categoryName" type="text" size="30">

        <br><br><input type="submit" value="Сохранить товар">

    </p>
</form>
-->
</div>
</body>
</html>