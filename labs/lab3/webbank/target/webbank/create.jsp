<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create account</title>
</head>
<body>
<p><a href="index.jsp">Back</a></p>

<form action="/create" method="post">
    <p>Create an account</p>
    Account Number: <input type="text" name="accNo" pattern="[0-9.]+" /><br>
    Customer Name : <input type="text" name="cusNm" /><br>
    <br>
    <input type=submit value="Create">
</form>
</body>
</html>
