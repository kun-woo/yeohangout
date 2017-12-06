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
					<li><a href="#">LOG OUT</a></li>
					<li><a href="#">HELP</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<% ArrayList<Customer> custArr = (ArrayList<Customer>) session.getAttribute("custArr");
	%>

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
					<form role="form" action="../record-reservation" class="form-horizontal" method="post">
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Passenger
								Name:</label>
							<div class="col-sm-8">
								<input type="text" name="passName" class="form-control" placeholder="Passenger">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Account
								Number:</label>
							<div class="col-sm-8">
								<input type="text" name="accountNo" class="form-control" placeholder="Account Number">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Reservation
								Number:</label>
							<div class="col-sm-8">
								<input type="text" name="resrNo" class="form-control" placeholder="Reservation Number">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Reservation
								Date:</label>
							<div class="col-sm-8">
								<input type="text" name="rserDate" class="form-control" placeholder="yyyy-MM-dd HH:mm:SS">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Booking Fee:</label>
							<div class="col-sm-8">
								<input type="text" name="bookingFee" class="form-control" placeholder="Booking Fee">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Total Fare:</label>
							<div class="col-sm-8">
								<input type="text" name="totalFare" class="form-control" placeholder="Total Fare">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Representative
								SSN:</label>
							<div class="col-sm-8">
								<input type="text" name="repSSN" class="form-control" placeholder="SSN">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Airline:</label>
							<div class="col-sm-8">
								<input type="text" name="airlineID" class="form-control" placeholder="Airline">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Flight
								Number:</label>
							<div class="col-sm-8">
								<input type="text" name="flightNo" class="form-control" placeholder="Flight Number">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Leg
								Number:</label>
							<div class="col-sm-8">
								<input type="text" name="legNo" class="form-control" placeholder="Leg Number">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Seat
								Number:</label>
							<div class="col-sm-8">
								<input type="text" name="seatNo" class="form-control" placeholder="Seat Number">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Cabin
								Class:</label>
							<div class="col-sm-8">
								<input type="text" name="class" class="form-control" placeholder="Cabin Class">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Meal:</label>
							<div class="col-sm-8">
								<input type="text" name="meal" class="form-control" placeholder="Meal">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<button type="submit" class="btn btn-default btn-md pull-right">Record</button>
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
	
	<!-- Delete Modal -->
	<div class="modal fade" id="deleteTable" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>Delete Customer</h4>
				</div>
				<div class="modal-body">
					<form action="../delete-employee" role="form" class="form-horizontal" method="post">
						<div class="form-group">
							<label class="control-label col-sm-4" for="text">Reservation Number:</label>
							<div class="col-sm-8">
								<input type="text" name="resrNo" class="form-control" placeholder="Reservation Number">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<button type="submit" class="btn btn-default btn-md pull-right">Delete</button>
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
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="../dashboard-rep/dashboard-rep-overview.jsp">Overview </a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-rep-reservation">Record Reservation </a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="../manage-customer">Manage
							Customer <span class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-mail-list">View Customer Mailing List</a></li>
					<li><a href="../view-employee">View Employee</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../get-flight-suggest">Flight Suggest To Customer</a></li>
				</ul>
			</div>
			<div
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<h1 class="page-header">Reservation</h1>
					<div class="btn-group">
						<a role="button" class="btn btn-default btn-md" data-toggle="modal" 
							data-target="#addTable">Add</a> 
						<a role="button" class="btn btn-default btn-md" data-toggle="modal"
							data-target="#deleteTable">Delete</a>
					</div>
					<div>
						<!-- For Padding -->
						<br>
					</div>
					<div class="table-responsive">
						<table id="test-table1" class="table table-striped">
							<thead>
								<tr>
									<th>Account Number</th>
									<th>Reservation Date</th>
									<th>Booking Fee</th>
									<th>Total Fare</th>
									<th>Representative SSN</th>
									<th>Account Number</th>
 									<th>Edit</th>
								</tr>
							</thead>
							<tbody>
						<%-- <% 
						ArrayList<Integer> accountNoArr = new ArrayList<Integer>();
						
						for (int i=0; i<custArr.size(); i++) { 
							accountNoArr.add(custArr.get(i).getAccountNo());
							
							
 						%>
							<tr>
								<td><%= custArr.get(i).getResrNo() %></td>
								<td><%= custArr.get(i).getResrDateTime() %></td>
								<td><%= resrArr.get(i).getBookingFee() %></td>
								<td><%= resrArr.get(i).getTotalFare() %></td>
								<td><%= resrArr.get(i).getRepSSN() %></td>
								<td><%= resrArr.get(i).getAccountNo() %></td>
								<% 
									session.setAttribute("dash_edit_emp", i);
									session.setAttribute("emp_ssn_arr", resrNoArr);
								%>
								<td><a role="button" class="btn btn-default btn-md" data-toggle="modal"
									data-target="#editTable-<%= i %>" tabindex=i>Edit</a></td>
							
								<%@ include file = "../dashboard-manager/dashboard-manager-user-edit-rep.jsp" %>
							</tr>
							<%
							}
						

							%>
 --%>							</tbody>
						</table>
					</div>
				</div>
				<br>
				
				<div class="row">
					<h1 class="page-header">Passenger</h1>
					<div>
						<!-- For Padding -->
						<br>
					</div>
					<div class="table-responsive">
						<table id="table-3" class="table table-striped">
							<thead>
								<tr>
									<th>Name</th>
									<th>Account Number</th>
									<th>Reservation Number</th>
									<th>Seat Number</th>
									<th>Cabin Class</th>
									<th>Meal</th>
								</tr>
							</thead>
							<tbody>
						<%-- <%
						for (int i=0; i < personArr.size(); i++) {
							if (passArr.get(j).getId() == personArr.get(i).getId())
							{
								fArr.add(personArr.get(i).getFirstName());
								lArr.add(personArr.get(i).getLastName());
								j++;
							}
						}
						%>
						<% 						
						for (int i=0; i<passArr.size(); i++) {
							String fname = fArr.get(i);
							String lname = lArr.get(i);
							String name = fname + " " + lname;
 						%>
							<tr>
								<td><%= name %></td>
								<td><%= passArr.get(i).getAccountNo() %></td>
								<td><%= resrPassArr.get(i).getResrNo() %></td>
								<td><%= resrPassArr.get(i).getSeatNo() %></td>
								<td><%= resrPassArr.get(i).getCabinClass() %></td>
								<td><%= resrPassArr.get(i).getMeal() %></td>								
							</tr>
							<%
							}
						

							%>
							</tbody>
						</table>
					</div>
				</div>
				<br>
				
				<div class="row">
					<h1 class="page-header">Includes</h1>
					<div>
						<!-- For Padding -->
						<br>
					</div>
					<div class="table-responsive">
						<table id="table-2" class="table table-striped">
							<thead>
								<tr>
									<th>Reservation Number</th>
									<th>Airline</th>
									<th>Flight Number</th>
									<th>Leg Number</th>
									<th>Date</th>
								</tr>
							</thead>
							<tbody>
						<% 						
						for (int i=0; i<inclArr.size(); i++) {
 						%>
							<tr>
								<td><%= inclArr.get(i).getResrNo() %></td>
								<td><%= inclArr.get(i).getAirlineID() %></td>
								<td><%= inclArr.get(i).getFlightNo() %></td>
								<td><%= inclArr.get(i).getLegNo() %></td>
								<td><%= inclArr.get(i).getDateTime() %></td>
							</tr>
							<%
							}
						

							%> --%>
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

</body>
</html>