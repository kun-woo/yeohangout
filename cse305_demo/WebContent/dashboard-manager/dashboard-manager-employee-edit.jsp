<%@page import="yeohangout.javabeans.EmployeeJude"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!-- Edit Modal -->
	<%
		int edited_emp_index = (int)session.getAttribute("dash_edit_emp");
		ArrayList<Integer> edited_emp_ssn_arr = (ArrayList<Integer>)session.getAttribute("emp_ssn_arr");
	%>
	
	<div class="modal fade" id="editTable-<%= edited_emp_index %>" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>Edit Employee</h4>
				</div>
				<div class="modal-body">
					<%
						 int edited_ssn =  edited_emp_ssn_arr.get(edited_emp_index); 
					%>
					<form action="../edit-employee" role="form" class="form-horizontal" method="post">
						
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">First
								Name:</label>
							<div class="col-sm-8">
								<input type="text" name="firstName" class="form-control" placeholder="First Name">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Last
								Name:</label>
							<div class="col-sm-8">
								<input type="text" name="lastName" class="form-control" placeholder="Last Name">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">SSN:</label>
							<div class="col-sm-8">
								<input type="text" name="SSN" class="form-control" placeholder="SSN">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">isManager:</label>
							<div class="col-sm-8">
								<input type="text" name="isManager" class="form-control" placeholder="isManager">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Start
								Date:</label>
							<div class="col-sm-8">
								<input type="text" name="startDate" class="form-control" placeholder="YYYY-MM-DD">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Hourly
								Rate:</label>
							<div class="col-sm-8">
								<input type="text" name="hourlyRate" class="form-control" placeholder="Hourly Rate">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">User
								Name:</label>
							<div class="col-sm-8">
								<input type="text" name="userName" class="form-control" placeholder="User Name">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Password:</label>
							<div class="col-sm-8">
								<input type="text" name="pwd" class="form-control" placeholder="HPassword">
							</div>
						</div>
						
						<input type="hidden" name="edited_ssn" class="form-control" placeholder="Key SSN" value = "<%= edited_ssn %>">
					
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<button type="submit" class="btn btn-default btn-md pull-right">Update</button>
							</div>
						</div>
					
					</form>
				</div>
				<div class="modal-footer">
				<h5>This message will be shown only when input is wrong.</h5>
				</div>
			</div>
		</div>
	</div>