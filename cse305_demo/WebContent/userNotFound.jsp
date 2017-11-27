<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<div class="container-fluid bg-gray text-center">
	<h2> User is not found</h2>
	
	<h3> Sign In Again</h3>
	<form name="loginForm" action="login" method="POST">
		<div class="form-group">
			<div class="input-group">
				<input type="text" class="form-control" id="id" name = "userID"
					placeholder="Username"> <span class="input-group-addon">
					<span class="glyphicon glyphicon-user"></span>
				</span>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<input type="password" class="form-control" id="pwd" name = "password"
					placeholder="Password"> <span class="input-group-addon">
					<span class="glyphicon glyphicon-lock"></span>
				</span>
			</div>
		</div>
		<button type="submit" class="btn btn-block log-in-button">
			Log In<span class="glyphicon glyphicon-log-in"></span>
		</button>
 	</form>
 	
	<p> If you're not a customer of Yeo Hang Out</p>
	
	<p> Go to Sign up!!</p> 
	<input id = "signupBt" name ="signupBt" value = "Sign Up" type = "button" onclick ="window.location.href='signup.jsp'"/>
	
</div>
<%@ include file="../footer.jsp"%>

