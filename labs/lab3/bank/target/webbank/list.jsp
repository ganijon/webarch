<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cs544.exercise5_3.bank.domain.Account" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All accounts</title>
</head>
<body>
<p><a href="/home">Back</a></p>

    <%
        Collection<Account> list = (Collection<Account>) request.getAttribute("list");
    %>

<h4>List of all accounts</h4>
<table>
    <caption>
        <b>
            <tr>
                <td width="200">Account Number</td>
                <td width="250">Customer Name</td>
                <td width="200">Account Balance</td>
            </tr>
            <tr><td></td></tr>
        </b>
    </caption>

    <tbody>
    <c:forEach var="account" items="${list}">
        <tr>
            <td width="200">${account.accountnumber}</td>
            <td width="250">${account.customer.name}</td>
            <td width="200">${account.balance}</td>
            <td width="100"><a href="/details?accountNumber=${account.accountnumber}">Details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
