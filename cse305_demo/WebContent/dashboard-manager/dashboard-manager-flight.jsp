<%@page import="yeohangout.javabeans.Flight"%>
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
	<% ArrayList<Flight> flightArr = (ArrayList<Flight>) session.getAttribute("flightArr");
	   ArrayList<Flight> flightArrActive = (ArrayList<Flight>) session.getAttribute("flightArrActive");
	   ArrayList<Flight> flightArrAirport = (ArrayList<Flight>) session.getAttribute("flightArrAirport");
	   ArrayList<Flight> flightArrOnTime = (ArrayList<Flight>) session.getAttribute("flightArrOnTime");
	   ArrayList<Flight> flightArrDelayed = (ArrayList<Flight>) session.getAttribute("flightArrDelayed");
	%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="dashboard-manager-overview.jsp">Overview </a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-employee">Manage Employee</a></li>
					<li><a href="../view-customer">Manage
							Customer</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-sales-report">View Sales Report</a></li>
					<li><a href="../view-reservation">View Reservation</a></li>
					<li><a href="../view-total-revenue">View Total Revenue</a></li>					
					<li class="active"><a href="#">View Flight <span class="sr-only">(current)</span></a></li>
					<li><a href="../view-customer-seated">View Customer</a></li>
				</ul>
			</div>
			<div
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">View Flight</h1>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Airline</th>
								<th>Flight Number</th>
								<th>Number of Seats</th>
								<th>Days of Operating</th>
								<th>Minimum Length of Stay</th>
								<th>Max Length of Stay</th>
							</tr>
						</thead>
						<tbody>
						<% for (int i=0; i<flightArr.size(); i++) { %>
							<tr>
								<td><%= flightArr.get(i).getAirlineID() %></td>
								<td><%= flightArr.get(i).getFlightNumber() %></td>
								<td><%= flightArr.get(i).getNumberOfSeats() %></td>
								<td><%= flightArr.get(i).getDaysOperating() %></td>
								<td><%= flightArr.get(i).getMinLenStay() %></td>
								<td><%= flightArr.get(i).getMaxLenStay() %></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				
				<h2 class="sub-header">Most Active Flight</h2>
				<div class="table-responsive">
					<table id="table-1" class="table table-striped">
						<thead>
							<tr>
								<th>Airport ID</th>
								<th>Flight Number</th>
								<th>Max Length of Stay</th>
							</tr>
						</thead>
						<tbody>
						<% for (int i=0; i<flightArrActive.size(); i++) { %>
							<tr>
								<td><%= flightArrActive.get(i).getAirlineID() %></td>
								<td><%= flightArrActive.get(i).getFlightNumber() %></td>
								<td><%= flightArrActive.get(i).getMaxLenStay() %></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				
				<h2 class="sub-header">Flight by Airport</h2>
				<div class="table-responsive">
					<table id="table-2" class="table table-striped">
						<thead>
							<tr>
								<th>Airport ID</th>
								<th>Airport Name</th>
								<th>Airline</th>
								<th>Flight Number</th>
							</tr>
						</thead>
						<tbody>
						<% for (int i=0; i<flightArrAirport.size(); i++) { %>
							<tr>
								<td><%= flightArrAirport.get(i).getAirportID() %></td>
								<td><%= flightArrAirport.get(i).getAirportName() %></td>
								<td><%= flightArrAirport.get(i).getAirlineID() %></td>
								<td><%= flightArrAirport.get(i).getFlightNumber() %></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				
				<h2 class="sub-header">On-Time Flight</h2>
				<div class="table-responsive">
					<table id="table-3" class="table table-striped">
						<thead>
							<tr>
								<th>Airline</th>
								<th>Airport</th>
								<th>Flight Number</th>
								<th>Leg Number</th>
								<th>Expected Arrival Time</th>
								<th>Actual Arrival Time</th>
							</tr>
						</thead>
						<tbody>
						<% for (int i=0; i<flightArrOnTime.size(); i++) { %>
							<tr>
								<td><%= flightArrOnTime.get(i).getAirlineID() %></td>
								<td><%= flightArrOnTime.get(i).getAirportName() %></td>
								<td><%= flightArrOnTime.get(i).getFlightNumber() %></td>
								<td><%= flightArrOnTime.get(i).getLegNumber() %></td>
								<td><%= flightArrOnTime.get(i).getExpected() %></td>
								<td><%= flightArrOnTime.get(i).getActual() %></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				
				<h2 class="sub-header">Delayed Flight</h2>
				<div class="table-responsive">
					<table id="table-4" class="table table-striped">
						<thead>
							<tr>
								<th>Airline</th>
								<th>Airport</th>
								<th>Flight Number</th>
								<th>Leg Number</th>
								<th>Expected Arrival Time</th>
								<th>Actual Arrival Time</th>
							</tr>
						</thead>
						<tbody>
						<% for (int i=0; i<flightArrDelayed.size(); i++) { %>
							<tr>
								<td><%= flightArrDelayed.get(i).getAirlineID() %></td>
								<td><%= flightArrDelayed.get(i).getAirportName() %></td>
								<td><%= flightArrDelayed.get(i).getFlightNumber() %></td>
								<td><%= flightArrDelayed.get(i).getLegNumber() %></td>
								<td><%= flightArrDelayed.get(i).getExpected() %></td>
								<td><%= flightArrDelayed.get(i).getActual() %></td>
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