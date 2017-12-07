<%@page import="yeohangout.javabeans.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="dashboard for managers" />
<meta name="author" content="jude hokyoon woo - yeo hang out" />
<title>Yeo Hang Out</title>
<!-- Bootstrap core CSS -->
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../assets/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../assets/css/datatables.min.css" />
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../index.jsp">Yeo Hang Out</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="../index.jsp">HOME</a></li>
					<li><a href="#">SETTINGS</a></li>
					<li><a href="${pageContext.request.contextPath}/logout">LOG OUT</a></li>
					<li><a href="#">Help</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<%ArrayList<Customer> custArr = (ArrayList<Customer>) session.getAttribute("custArr"); %>

	<!-- AddTable Modal -->
	<div class="modal fade" id="addTable" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>Add Customer</h4>
				</div>
				<div class="modal-body">
					<form data-toggle="validator" role="form" action="../add-customer" class="form-horizontal" method="post">
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
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="dashboard-manager-overview.jsp">Overview </a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-employee">Manage
							Employee</a></li>
					<li class="active"><a href="#">Manage
							Customer <span class="sr-only">(current)</span>
					</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-sales-report">View Sales Report</a></li>
					<li><a href="../view-reservation">View Reservation</a></li>
					<li><a href="../view-total-revenue">View Total Revenue</a></li>					
					<li><a href="../view-flight">View Flight</a></li>
					<li><a href="../view-customer-seated">View Customer</a></li>
				</ul>
			</div>
			<div
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<h1 class="page-header">Manage Customer</h1>
					<a role="button" class="btn btn-default btn-md" data-toggle="modal" 
						data-target="#addTable">Add</a>
					<div>
						<!-- For Padding -->
						<br>
					</div>
					<div class="table-responsive">
						<table id="test-table1" class="table table-striped">
							<thead>
								<tr>
									<th>Name</th>
									<th>Account Number</th>
									<th>Credit Card</th>
									<th>Creation Date</th>
									<th>Rating</th>
									<th>User Name</th>
									<th>Password</th>
									<th>Delete</th>
									<th>Edit</th>
								</tr>
							</thead>
							<tbody>
						<% 
						ArrayList<Integer> accountNoArr = new ArrayList<Integer>();
						
						for (int i=0; i<custArr.size(); i++) { 
							String fn = custArr.get(i).getFname();
							String ln = custArr.get(i).getLname();
							String full = fn + " " + ln;
							accountNoArr.add(custArr.get(i).getAccountNo());
							
							
 						%>
							<tr>
								<td><%= full %></td>
								<td><%= custArr.get(i).getAccountNo() %></td>
								<td><%= custArr.get(i).getCreditCard() %></td>
								<td><%= custArr.get(i).getCreDate() %></td>
								<td><%= custArr.get(i).getRating() %></td>
								<td><%= custArr.get(i).getUserName() %></td>
								<td><%= custArr.get(i).getPwd() %></td>
								<td>
								<% 
									session.setAttribute("dash_delete_cust", custArr.get(i).getAccountNo());
								%>
								<a role="button" class="btn btn-default btn-md" href="../delete-customer">Delete</a></td>
								<td>
								<% 
									session.setAttribute("dash_edit_cust", i);
									session.setAttribute("cust_edit_arr", accountNoArr);
								%>
								<a role="button" class="btn btn-default btn-md" data-toggle="modal"
									data-target="#editTable-<%= i %>" tabindex=i>Edit</a></td>
									
								
								<%@ include file = "../dashboard-manager/dashboard-manager-user-edit.jsp" %>
							</tr>
							<%
							}
						

							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	
	
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../assets/js/jquery-3.2.1.min.js"></script>
	<!-- Jquery JS-->
	<script src="../assets/js/bootstrap.js"></script>
	<!-- Bootstrap JS -->
	<script src="../assets/js/dashboard.js"></script>
	<!-- Dashboard JS -->
	<script type="text/javascript" src="../assets/js/datatables.min.js"></script>
	<script src="https://cdnjs.com/libraries/1000hz-bootstrap-validator"></script>

</body>
</html>