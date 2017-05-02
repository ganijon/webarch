<!DOCTYPE html>

<html>
<head>
<title>Simple Calc</title>
</head>

	<h3>Simple Calc</h3>
	<body>
	<ul>
		<form action="/myNewWebApp/calc" method="post">
			<input type="text" name="add_param1" size="10" /> + 
			<input type="text" name="add_param2" size="10" /> = 
			<input type="text" name="add_result" size="10" /> 
			</br>
			</br>
			<input type="text" name="mul_param1" size="10" /> * 
			<input type="text" name="mul_param2" size="10" /> = 
			<input type="text" name="mul_result" size="10" /> 
			</br>
			</br> 
			<input type="submit" value="Calculate" />
		</form>
	</ul>
	</body>

</html>