<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>YEO HANG OUT Sign UP</h1>
	
	<form name="loginForm" action="${pageContext.request.contextPath}/signup" method="POST">
	
		<span id = "userID">User ID : </span>
		<input id = "userIDTF" name ="personID" type="text" />
		<br>
		<span id = "firstName">First Name : </span>
		<input id = "firstNameTF" name = "personFName" type = "text" />
		<br>
		
		<span id = "lastName">Last Name : </span>
		<input id = "lastNameTF" name = "personLName" type = "text" />
		<br>
		<span id = "address">Address : </span>
		<input id = "adressTF" name = "personAddress" type = "text" />
		<br>
		
		<span id = "city">City : </span>
		<input id = "cityTF" name = "city" type = "text" />
		<br>
		
		<span id = "state">State : </span>
		<input id = "stateTF" name = "state" type = "text" />
		<br>
		
		<span id = "zipcode">Zip Code : </span>
		<input id = "zipcodeTF" name = "zipcode" type = "text" />
		<br>
		
		<span id = "accountNo">Account No : </span>
		<input id = "accountNoTF" name = "accountNo" type = "text" />
		<br>
		<span id = "creditCardNo">Credit Card No : </span>
		<input id = "creditCardNoTF" name = "creditCardNo" type = "text" />
		<br>
		
		
		
		<input id = "submitBt" name ="submitBt" value="submit" type="submit" />
	
	</form>
</body>
</html>