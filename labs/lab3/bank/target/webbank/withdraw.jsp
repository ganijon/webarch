<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Withdraw</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<h4>Withdraw funds from account</h4>

<form action="/withdraw" method="post">
    Account Number: <input type="text" name="accountNumber" pattern="[0-9.]+" /><br>
    Withdraw Amount: <input type="text" name="withdrawAmount" pattern="[0-9.]+"/><br>
    <br>
    <input type=submit value="Withdraw">
</form>
</body>
</html>
