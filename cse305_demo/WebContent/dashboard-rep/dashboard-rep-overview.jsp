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
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-rep-reservation">Record Reservation </a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../manage-customer">Manage
							Customer</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-mail-list">View Customer Mailing List</a></li>
					<li><a href="../view-employee">View Employee</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../produce-flight-suggest">Flight Suggest To Customer</a></li>
				</ul>
			</div>
			<div
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Financial Performance</h1>

				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<div id="test-circle1"></div>
						<h4>Ticket</h4>
						<span class="text-muted">Sales</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<div id="test-circle2"></div>
						<h4>Airline</h4>
						<span class="text-muted">Sales</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<div id="test-circle3"></div>
						<h4>Airport</h4>
						<span class="text-muted">Sales</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<div id="test-circle4"></div>
						<h4>Other</h4>
						<span class="text-muted">Sales</span>
					</div>
				</div>

					<h2 class="sub-header">Usages</h2>
					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<canvas id="myChart" width="400" height="400"></canvas>
						</div>
						<div class="col-xs-12 col-sm-6">
							<canvas id="mySChart" width="400" height="400"></canvas>
						</div>
					</div>
					
					<h2 class="sub-header">Activities</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Date</th>
								<th>ID</th>
								<th>Name</th>
								<th>Department</th>
								<th>Logged at</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>2017-11-30</td>
								<td>1</td>
								<td>Jude Woo</td>
								<td>R&D</td>
								<td>05:05:30</td>
							</tr>
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
	<script src="../assets/js/jquery.circliful.min.js"></script> <!-- Circliful JS -->
	<script src="../assets/js/Chart.bundle.min.js"></script> <!-- Chart JS -->

</body>
</html>