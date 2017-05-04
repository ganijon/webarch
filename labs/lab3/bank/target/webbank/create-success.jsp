<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cs544.exercise5_3.bank.domain.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Account created</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<h4>Account successfully created</h4>
<p>Account number: ${account.accountnumber}</p>
<p>Customer name: ${account.customer.name}</p>


</body>
</html>
