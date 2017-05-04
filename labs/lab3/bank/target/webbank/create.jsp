<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create account</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<h4>Create an account</h4>

<form action="/create" method="post">
    Account Number: <input type="text" name="accountNumber" pattern="[0-9.]+" /><br>
    Customer Name : <input type="text" name="customerName" /><br>
    <br>
    <input type=submit value="Create">
</form>
</body>
</html>
