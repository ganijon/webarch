<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Find account</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<h4>Find account</h4>

<form action="/details" method="post">
    Account Number: <input type="text" name="accountNumber" pattern="[0-9.]+" /><br>
    <br>
    <input type=submit value="Proceed">
</form>
</body>
</html>
