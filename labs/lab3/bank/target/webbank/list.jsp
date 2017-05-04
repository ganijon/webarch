<%@ page import="cs544.exercise5_3.bank.domain.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Account Details</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<p>
    <%
        Account account = (Account) request.getAttribute("account");

        out.println("Account number:" + account.getAccountnumber());
        out.println("Customer Name:" + account.getCustomer().getName());
    %>

</body>
</html>
