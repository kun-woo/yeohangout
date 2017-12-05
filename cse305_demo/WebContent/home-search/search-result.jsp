<%@page import="yeohangout.javabeans.EmployeeJude"%>
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
<meta name="author" content="yeo hang out" />
<title>Yeo Hang Out</title>
<!-- Bootstrap core CSS -->
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../assets/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../assets/css/datatables.min.css" />
<link href="../assets/css/search.css" rel="stylesheet">
<link rel="stylesheet" href="../assets/css/bootstrap-datetimepicker.min.css" /> <!-- Bootstrap DTP CSS -->
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
	<%
		ArrayList<EmployeeJude> emplArr = (ArrayList<EmployeeJude>) session.getAttribute("emplArr");
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-3 sidebar" style="overflow:visible;">
				<br>
				<div class="row">
					<form action="#" method="post">
						<div class="side-form col-xs-12 bg-primary">
							<h3>Another Shot?</h3>
							<div class="radio">
								<label><input type="radio" name="side-radio">One
									Way</label>
							</div>
							<div class="radio">
								<label><input type="radio" name="side-radio">Round
									Trip</label>
							</div>
							<div class="radio">
								<label><input type="radio" name="side-radio">Muti
									City</label>
							</div>
							<div class="side-form-input">
								<div class="dropdown">
									<label for="button">Flying from</label>
									<button class="btn btn-default btn-block dropdown-toggle"
										type="button" data-toggle="dropdown">
										City or Airport <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li class=><a href="#">JFK</a></li>
										<li><a href="#">ICN</a></li>
										<li><a href="#">LGA</a></li>
									</ul>
								</div>
								<div class="dropdown">
									<label for="button">Flying to</label>
									<button class="btn btn-default btn-block dropdown-toggle"
										type="button" data-toggle="dropdown">
										City or Airport <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li class=><a href="#">JFK</a></li>
										<li><a href="#">ICN</a></li>
										<li><a href="#">LGA</a></li>
									</ul>
								</div>
								<div class="bg-default" style="overflow:visible;">
									<label class="control-label" for="text">Departing</label>
									<div class='input-group date' id='datetimepicker1'>
										<input type="text" class="form-control" name="deptTime"
											placeholder="mm/dd/yyyy"> <span
											class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
								<div class="bg-default" style="overflow:visible;">
									<label class="control-label" for="text">Returning</label>
									<div class='input-group date' id='datetimepicker2'>
										<input type="text" class="form-control" name="arrTime"
											placeholder="mm/dd/yyyy"> <span
											class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
								<br>
								<button class="btn btn-success btn-block" type="submit">Search</button>
								<br>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-sm-offset-3 col-sm-9 col-md-offset-3 col-md-9 main slideanim">
				<div class="row">
					<h1 class="page-header col-xs-12">Search Result</h1>
				</div>
				<div class="row">
					<h2>Select your <%//Change %>departure to <%//Change %>New York <small class="no-wrap"> Wed, Dec 13</small></h2>
				</div>
				<%// this search-row will be spanned%>
				<div class="row search-row">
					<form action="../add-plane" method="post" novalidate>
					<div class="row cart-row">
						<div class="col-xs-12 col-sm-2 col-md-2">
							<a href="#"> <img src="../images/airline/1.png" class="img-responsive">
							</a>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4">
							<h3><%//depttime%>12:15am - 3:50pm<%//arrtime%>
							</h3>
							<div class="no-wrap">United Airline<%//airline name%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3 class="no-wrap">
								<%//Time Spend%>29h 35m
							</h3>
							<div class="no-wrap"><%//Dpet-airport%>ICN - JFK<%//Land-airport%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3>1 Stop</h3>
							<div class="no-wrap">4h 30m in AUH</div>
						</div>
						<div class="col-xs-12 col-sm-2 col-md-2">
							<div class="form-group">
								<h3>$1000</h3>
								<div class="no-wrap"<%//Type %>>One Way</div>
								<br>
								<button type="submit" class="btn btn-primary btn-block">Book</button>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
					</form>
				</div>
				<div class="row search-row">
					<form action="../add-plane" method="post" novalidate>
					<div class="row cart-row">
						<div class="col-xs-12 col-sm-2 col-md-2">
							<a href="#"> <img src="../images/airline/1.png" class="img-responsive">
							</a>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4">
							<h3><%//depttime%>12:15am - 3:50pm<%//arrtime%>
							</h3>
							<div class="no-wrap">United Airline<%//airline name%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3 class="no-wrap">
								<%//Time Spend%>29h 35m
							</h3>
							<div class="no-wrap"><%//Dpet-airport%>ICN - JFK<%//Land-airport%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3>1 Stop</h3>
							<div class="no-wrap">4h 30m in AUH</div>
						</div>
						<div class="col-xs-12 col-sm-2 col-md-2">
							<div class="form-group">
								<h3>$1000</h3>
								<div class="no-wrap"<%//Type %>>One Way</div>
								<br>
								<button type="submit" class="btn btn-primary btn-block">Book</button>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
					</form>
				</div>
				<div class="row search-row">
					<form action="../add-plane" method="post" novalidate>
					<div class="row cart-row">
						<div class="col-xs-12 col-sm-2 col-md-2">
							<a href="#"> <img src="../images/airline/1.png" class="img-responsive">
							</a>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4">
							<h3><%//depttime%>12:15am - 3:50pm<%//arrtime%>
							</h3>
							<div class="no-wrap">United Airline<%//airline name%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3 class="no-wrap">
								<%//Time Spend%>29h 35m
							</h3>
							<div class="no-wrap"><%//Dpet-airport%>ICN - JFK<%//Land-airport%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3>1 Stop</h3>
							<div class="no-wrap">4h 30m in AUH</div>
						</div>
						<div class="col-xs-12 col-sm-2 col-md-2">
							<div class="form-group">
								<h3>$1000</h3>
								<div class="no-wrap"<%//Type %>>One Way</div>
								<br>
								<button type="submit" class="btn btn-primary btn-block">Book</button>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
					</form>
				</div>
				<div class="row search-row">
					<form action="../add-plane" method="post" novalidate>
					<div class="row cart-row">
						<div class="col-xs-12 col-sm-2 col-md-2">
							<a href="#"> <img src="../images/airline/1.png" class="img-responsive">
							</a>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4">
							<h3><%//depttime%>12:15am - 3:50pm<%//arrtime%>
							</h3>
							<div class="no-wrap">United Airline<%//airline name%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3 class="no-wrap">
								<%//Time Spend%>29h 35m
							</h3>
							<div class="no-wrap"><%//Dpet-airport%>ICN - JFK<%//Land-airport%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3>1 Stop</h3>
							<div class="no-wrap">4h 30m in AUH</div>
						</div>
						<div class="col-xs-12 col-sm-2 col-md-2">
							<div class="form-group">
								<h3>$1000</h3>
								<div class="no-wrap"<%//Type %>>One Way</div>
								<br>
								<button type="submit" class="btn btn-primary btn-block">Book</button>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
					</form>
				</div>
				<div class="row search-row">
					<form action="../add-plane" method="post" novalidate>
					<div class="row cart-row">
						<div class="col-xs-12 col-sm-2 col-md-2">
							<a href="#"> <img src="../images/airline/1.png" class="img-responsive">
							</a>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4">
							<h3><%//depttime%>12:15am - 3:50pm<%//arrtime%>
							</h3>
							<div class="no-wrap">United Airline<%//airline name%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3 class="no-wrap">
								<%//Time Spend%>29h 35m
							</h3>
							<div class="no-wrap"><%//Dpet-airport%>ICN - JFK<%//Land-airport%></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3>1 Stop</h3>
							<div class="no-wrap">4h 30m in AUH</div>
						</div>
						<div class="col-xs-12 col-sm-2 col-md-2">
							<div class="form-group">
								<h3>$1000</h3>
								<div class="no-wrap"<%//Type %>>One Way</div>
								<br>
								<button type="submit" class="btn btn-primary btn-block">Book</button>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../assets/js/jquery-3.2.1.min.js"></script>
	<script src="../assets/js/bootstrap.js"></script>
	<script src="../assets/js/dashboard.js"></script>
	<script src="../assets/js/moment.js"></script> <!-- Moment JS -->
	<script src="../assets/js/bootstrap-datetimepicker.js"></script> <!-- Boostrap DTP JS -->
	<script src="../assets/js/search.js"></script>
	
</body>
</html>