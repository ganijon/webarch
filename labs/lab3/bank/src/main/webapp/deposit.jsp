<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Deposit</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<h4>Deposit funds into account</h4>

<form action="/deposit" method="post">
    Account Number: <input type="text" name="accountNumber" pattern="[0-9.]+" /><br>
    Deposit Amount: <input type="text" name="depositAmount" pattern="[0-9.]+"/><br>
    <br>
    <input type=submit value="Deposit">
</form>
</body>
</html>
