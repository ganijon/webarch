<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cs544.exercise5_3.bank.domain.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Account Details</title>
</head>
<body>
<p><a href="/list">Back</a></p>

<h4>Account details</h4>
<p>
    Account number: ${account.accountnumber} <br>
    Customer name: ${account.customer.name} <br>

<p><b>Account entries</b></p>
<c:choose>
    <c:when test='${not empty account.entryList}'>

        <table>
            <caption>
                <b>
                    <tr>

                        <td width="250">Transaction Date</td>
                        <td width="100">Amount</td>
                        <td width="100">Description</td>
                        <td width="200">From Account</td>
                        <td width="200">From Person</td>
                    </tr>
                    <tr><td></td></tr>
                </b>
            </caption>

            <tbody>

            <c:forEach var="entry" items="${account.entryList}">
                <tr>
                    <td width="250">${entry.date}</td>
                    <td width="100">$${entry.amount}</td>
                    <td width="100">${entry.description}</td>
                    <td width="200">${entry.fromAccountNumber}</td>
                    <td width="200">${entry.fromPersonName}</td>
                 </tr>
            </c:forEach>

            </tbody>
        </table>

    </c:when>

    <c:otherwise>
        <font color='red'>
            No entries for this account<p>
        </font>
    </c:otherwise>
</c:choose>




</body>
</html>
