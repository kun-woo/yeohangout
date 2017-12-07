<%@page import="yeohangout.javabeans.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!-- Edit Modal -->
	<%
		int dash_edit_cust_index = (int)session.getAttribute("dash_edit_cust_rep");
		ArrayList<Integer> cust_edit_arr = (ArrayList<Integer>)session.getAttribute("cust_edit_arr_rep");
	%>
	
	<!-- EditTable Modal -->
	<div class="modal fade" id="editTable-<%= dash_edit_cust_index %>" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>Edit Customer</h4>
				</div>
				<div class="modal-body">
					<%
						 int edited_cust =  cust_edit_arr.get(dash_edit_cust_index); 
					%>
					<form role="form" action="../edit-customer-rep" class="form-horizontal" method="post">
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
							<label class="control-label col-sm-4" for="text">Customer's Credit Card:</label>
							<div class="col-sm-8">
								<input type="text" name="creditCardNo" class="form-control" placeholder="Credit Card">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Rating:</label>
							<div class="col-sm-8">
								<input type="text" name="rating" class="form-control" placeholder="Rating">
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
								<input type="password" name="pwd" class="form-control" placeholder="Password">
							</div>
						</div>
						<input type="hidden" name="edited_cust" class="form-control" placeholder="Key Cust" value = "<%= edited_cust %>">
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<button type="submit" class="btn btn-default btn-md pull-right">Update</button>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
				<h5>Powered by <a>Yeo Hang Out</a></h5>
				</div>
			</div>
		</div>
	</div>