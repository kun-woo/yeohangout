<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<!-- Help Modal -->
<%@ include file="help-info.jsp"%>
	
<!-- SignUp Modal -->
<%@ include file="signup.jsp"%>
	
<!-- LogIn Modal -->
<%@ include file="signin.jsp"%>

<div class="container-fluid bg-gray text-center" style="max-width: 400px;">
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
	
	<p>Create an account today.</p> 
	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#mySignUp">
  			Sign Up
	</button>
</div>
<%@ include file="footer.jsp"%>

