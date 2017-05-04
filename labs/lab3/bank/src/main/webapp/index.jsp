<!DOCTYPE html>
<html>
<body>
<h3>Welcome to Bank!</h3>

<form action="/home" method="post">
    <p>Which operation would you like to do?</p>


   <p>
       <select name="operation">
           <optgroup label="Bank operations">
               <option value="create">Create an account</option>
               <option value="list">List all accounts</option>
               <option value="details">View account details</option>
               <option value="deposit">Deposit funds</option>
               <option value="withdraw">Withdraw funds</option>
               <option value="transfer">Transfer funds</option>
           </optgroup>
       </select>

       <input type=submit value="Go">

</form>
</body>
</html>
