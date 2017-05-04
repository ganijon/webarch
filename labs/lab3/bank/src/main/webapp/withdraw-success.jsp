<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cs544.exercise5_3.bank.domain.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Withdraw success</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<h4>Withdawal successfully done</h4>
<p>Account number: ${account.accountnumber}</p>
<p>Withdrawal amount: $${amount}</p>
<p>Current balance:$${account.balance}</p>

</body>
</html>
