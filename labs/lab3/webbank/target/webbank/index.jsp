<!DOCTYPE html>
<html>
<body>
<h3>Welcome to Bank!</h3>

<form action="/home" method="get">
    <p>Which operation would you like to do?</p>

    <input type="radio" name="operation" value="create" checked> Create an account<br>
    <input type="radio" name="operation" value="list"> List all accounts<br>
    <input type="radio" name="operation" view="view"> View account details<br>
    <input type="radio" name="operation" value="deposit"> Deposit money<br>
    <input type="radio" name="operation" value="withdraw"> Withdraw money<br>
    <br>
    <input type=submit value="Go">

    <!-- opt group
    <p>
        <select name="operation">
            <optgroup label="Bank operations">
                <option value="create">Create an account</option>
                <option value="list">List all accounts</option>
                <option value="view">View account details</option>
                <option value="deposit">Deposit money</option>
                <option value="withdraw">Withdraw money</option>
            </optgroup>
        </select>
    -->
</form>
</body>
</html>
