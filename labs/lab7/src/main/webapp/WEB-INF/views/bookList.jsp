<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>BookStore</title>
</head>
<body>
    <h1>Books in Book Store</h1>
    <table>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.ISBN}</td>
                <td>${book.price}</td>
                <td><a href="books/${book.id}">edit</a></td>
            </tr>
        </c:forEach>
    </table>

<p><a href="addBook.html">+Add</a> </p>
</body>
</html>
