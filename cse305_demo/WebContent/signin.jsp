<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header.jsp"%>
	<form name="loginForm" action="${pageContext.request.contextPath}/login" method="POST">
		<span id = "userID">User ID : </span>
		<input id = "userIDTF" name ="userIDTF" type="text" />
	
		<input id = "submitBt" name ="submitBt" value="submit" type="submit" />
<!-- 		<input id = "cancelBt" name ="cancelBt" value="cancel" type="button" />
		<input id = "signUpBt" name ="signUpBt" value="sign Up" type="button"/>
 -->	</form>
 
 	<input id = "signupBt" name ="signupBt" value = "Sign Up" type = "button" onclick ="window.location.href='${pageContext.request.contextPath}/signup.jsp'"/>

<%@ include file="../footer.jsp"%>