<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "loginbox">
		<h1>Profile Creation</h1>
		
		<form action = "ProfileCreation" method = "post">
			<p>Username</p>
			<input type = "text" name = "username"  required>
			<br><p>Password</p>
			<input type = "password" name = "password" required>
			<p>Role code</p>
			<br><select name = "rolecode">
				<option value="Insured">Insured</option>
				<option value="Agent">Agent</option>
				<option value="Admin">UnderWriter</option>
			</select><br><br>
			<center><input type = "submit" name = "submit" value = "Register"></center>
		</form>		
	</div>


</body>
</html>