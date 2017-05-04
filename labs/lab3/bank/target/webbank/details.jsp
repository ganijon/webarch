<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cs544.exercise5_3.bank.domain.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Account Details</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<h4>Account details</h4>
<p>Account number: ${account.accountnumber}</p>
<p>Customer name: ${account.customer.name}</p>

<p><b>Account entries</b></p>
<c:choose>
    <c:when test='${not empty account.entryList}'>
        <c:forEach var="entry" items="${account.entryList}">
            Entry: ${entry}"
        </c:forEach>
    </c:when>

    <c:otherwise>
        <font color='red'>
            No entries for this account<p>
        </font>
    </c:otherwise>
</c:choose>




</body>
</html>
