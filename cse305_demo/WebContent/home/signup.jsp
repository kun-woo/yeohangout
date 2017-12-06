<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="yeohangout.mysql.MyUtils"%>
<%@ include file="../home/header.jsp"%>


<!-- SignUp Modal -->
	<% 
		//This code is for alerting there is an userID which is same as user signed up.
		
		if(MyUtils.getIdAlreadyExists()){
	%>
		<script type="text/javascript">
			alert("The id already exists");
			
			$(document).ready(function(){
			      $("#mySignUp").modal("show");
			});
			
		</script>
			
	<%
			MyUtils.setIdAlreadyExists(false);
		}
	%>
	
		<div class="modal fade" id="mySignUp" role="dialog" tabindex=-1>
	
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4> Yeo Hang Out </h4>
					</div>
					<div class="modal-body">
						<form name="signupForm" onsubmit = "return checkPassword()"  action="signup" method="POST" >
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="id"
										placeholder="Username" name ="userID"/> <span class="input-group-addon">
										<span class="glyphicon glyphicon-user"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="password" class="form-control" id="pwd"
										placeholder="Password" name ="password"/> <span class="input-group-addon">
										<span class="glyphicon glyphicon-edit"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="password" class="form-control" id="pwd2"
										placeholder="Password confirm" name ="passwordConf"/> <span class="input-group-addon">
										<span class="glyphicon glyphicon-check"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="fname"
									placeholder="First Name" name="personFName">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="lname"
									placeholder="Last Name" name="personLName">
								</span>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="address" name = "personAddress" placeholder="Address"/>
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-home"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" name = "city" id="city" placeholder="City"/>
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-th-large"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="state" name = "state" placeholder="State!"/>
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-menu-hamburger"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" name = "zipcode" id="zipcode" placeholder="Zipcode"/>
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-menu-hamburger"></span>
									</span>
								</div>
							</div>
					
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" name = "creditCardNo" id="creditCardNo" placeholder="Credit Card No."/>
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-menu-hamburger"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="email" class="form-control" id="email" name = "email" placeholder="Email"/>
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-envelope"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="number" class="form-control" id="telephone" name ="telephone" placeholder="Telephone"/>
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-earphone"></span>
									</span>
								</div>
							</div>
							<input type="submit" name = "submitBt" value = "Sign Up" class="btn btn-block sign-up-button"/>
							
						</form>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default pull-left"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-remove"></span> Cancel
						</button>
						<p>
							Need <a>help?</a>
						</p>
					</div>
				</div>
			</div>
		</div>
<%@ include file="../home/footer.jsp"%>