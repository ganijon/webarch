<%--
  Created by IntelliJ IDEA.
  User: 985565
  Date: 5/15/2017
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details of the book</title>
</head>
<body>

<form action="../books/${book.id}" method="post">
    <table>
        <tr>
            <td>Title:</td>
            <td><input type="text" name="title" value="${book.title}" /> </td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><input type="text" name="author" value="${book.author}" /> </td>
        </tr>
        <tr>
            <td>iSBN:</td>
            <td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" value="${book.price}" /> </td>
        </tr>
    </table>
    <input type="submit" value="update"/>
</form>
<form action="delete?bookId=${book.id}" method="post">
    <button type="submit">Delete</button>
</form>

</body>
</html>
