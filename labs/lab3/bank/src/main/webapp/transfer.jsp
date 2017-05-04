<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transfer</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<h4>Transfer funds</h4>

<form action="/transfer" method="post">
    Account Number of Sender: <input type="text" name="accountNumberFrom" pattern="[0-9.]+" /><br>
    Account Number of Beneficiary: <input type="text" name="accountNumberTo" pattern="[0-9.]+" /><br>
    Transfer Amount: <input type="text" name="amount" pattern="[0-9.]+"/><br>
    Description: <input type="text" name="description"/><br>
    <br>
    <input type=submit value="Transfer">
</form>
</body>
</html>
