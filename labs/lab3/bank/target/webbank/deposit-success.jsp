<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cs544.exercise5_3.bank.domain.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Deposit success</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<h4>Deposit successfully accepted</h4>
<p>Account number: ${account.accountnumber}</p>
<p>Deposit amount: $${depositAmount}</p>
<p>Current balance:$${account.balance}</p>

</body>
</html>
