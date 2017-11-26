<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

	<h2> User is not found</h2>
	
	<h3> Sign In Again</h3>
	<form name="loginForm" action="login" method="POST">
		<span id = "userID">User ID : </span>
		<input id = "userIDTF" name ="userIDTF" type="text" />
	
		<input id = "submitBt" name ="submitBt" value="submit" type="submit" />
<!-- 		<input id = "cancelBt" name ="cancelBt" value="cancel" type="button" />
		<input id = "signUpBt" name ="signUpBt" value="sign Up" type="button"/>
 -->	</form>
 
	<p> If you're not a customer of Yeo Hang Out</p>
	
	<p> Go to Sign up!!</p> 
	<input id = "signupBt" name ="signupBt" value = "Sign Up" type = "button" onclick ="window.location.href='signup.jsp'"/>
	
<%@ include file="../footer.jsp"%>

