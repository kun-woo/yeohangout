<%@page import="yeohangout.javabeans.Reservation"%>
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
	<% ArrayList<Reservation> resrArr = (ArrayList<Reservation>) session.getAttribute("resrArr"); 
	   ArrayList<Reservation> resrArrFlight = (ArrayList<Reservation>) session.getAttribute("resrArrFlight");
	   ArrayList<Reservation> resrArrCust = (ArrayList<Reservation>) session.getAttribute("resrArrCust");
	%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="dashboard-manager-overview.jsp">Overview </a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-employee">Manage
							Employee</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-sales-report">View Sales Report</a></li>
					<li class="active"><a href="#">View Reservation  <span class="sr-only">(current)</span></a></li>
					<li><a href="../view-total-revenue">View Total Revenue</a></li>					
					<li><a href="../view-flight">View Flight</a></li>
					<li><a href="../view-customer">View Customer</a></li>
				</ul>
			</div>
			<div
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main slideanim">
				<h1 class="page-header">View Reservation</h1>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Reservation Number</th>
								<th>Reservation Date</th>
								<th>Booking Fee</th>
								<th>Total Fare</th>
								<th>Representative's SSN</th>
								<th>Customer's Account Number</th>
							</tr>
						</thead>
						<tbody>
						<% for (int i=0; i<resrArr.size(); i++) { %>
							<tr>
								<td><%= resrArr.get(i).getResrNo() %></td>
								<td><%= resrArr.get(i).getResrDateTime() %></td>
								<td><%= resrArr.get(i).getBookingFee() %></td>
								<td><%= resrArr.get(i).getTotalFare() %></td>
								<td><%= resrArr.get(i).getRepSSN() %></td>
								<td><%= resrArr.get(i).getAccountNo() %></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				
				<h2 class="sub-header">Reservation by Flight</h2>
				<div class="table-responsive">
					<table id="table-1" class="table table-striped">
						<thead>
							<tr>
								<th>Airline</th>
								<th>Flight Number</th>
								<th>Reservation Number</th>
								<th>Reservation Date</th>
								<th>Booking Fee</th>
								<th>Total Fare</th>
								<th>Representative's SSN</th>
								<th>Customer's Account Number</th>
							</tr>
						</thead>
						<tbody>
						<% for (int i=0; i<resrArrFlight.size(); i++) { %>
							<tr>
								<td><%= resrArrFlight.get(i).getAirlineID()%></td>
								<td><%= resrArrFlight.get(i).getFlightNo()%></td>
								<td><%= resrArrFlight.get(i).getResrNo()%></td>
								<td><%= resrArrFlight.get(i).getResrDateTime() %></td>
								<td><%= resrArrFlight.get(i).getBookingFee() %></td>
								<td><%= resrArrFlight.get(i).getTotalFare() %></td>
								<td><%= resrArrFlight.get(i).getRepSSN() %></td>
								<td><%= resrArrFlight.get(i).getAccountNo() %></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				
				<h2 class="sub-header">Reservation by Customer</h2>
				<div class="table-responsive">
					<table id="table-2" class="table table-striped">
						<thead>
							<tr>
								<th>Customer's Name</th>
								<th>Customer's Account Number</th>
								<th>Reservation Number</th>
							</tr>
						</thead>
						<tbody>
						<% for (int i=0; i<resrArrFlight.size(); i++) { %>
							<tr>
								<td><%= resrArrFlight.get(i).getCustName()%></td>
								<td><%= resrArrFlight.get(i).getAccountNo()%></td>
								<td><%= resrArrFlight.get(i).getResrNo()%></td>
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