<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>YEO HANG OUT</title>
</head>

<body>
	<h1>YEO HANG OUT LOGIN</h1>
	
	<form name="loginForm" action="${pageContext.request.contextPath}/login" method="POST">
		<span id = "userID">User ID : </span>
		<input id = "userIDTF" name ="userIDTF" type="text" />
		<br>
		<span id = "password">PASSWORD : </span>
		<input id = "passwordTF" name = "passwordTF" type = "password" />
		<br>
	
		<input id = "submitBt" name ="submitBt" value="submit" type="submit" />
<!-- 		<input id = "cancelBt" name ="cancelBt" value="cancel" type="button" />
		<input id = "signUpBt" name ="signUpBt" value="sign Up" type="button"/>
 -->	</form>
</body>
</html>