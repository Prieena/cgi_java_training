<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Spring MVC App </h2>
	<h2>Sign Up page</h2>
	<form action="signupuser" method="post">
	<label>EmailId</label>
	<input type="email" name="emailid"/><br/>
	<label>Password</label>
	<input type="password" name="password"/><br/>
	<label>Type of User</label>
	<select name="typeofuser">
		<option value="admin">Admin</option>
		<option value="user">User</option>
	</select><br/>
	<input type="submit" value="Sign Up"/>
	<input type="reset" value="reset"/>
	</form>
	<a href="login">Login!</a>
</body>
</html>