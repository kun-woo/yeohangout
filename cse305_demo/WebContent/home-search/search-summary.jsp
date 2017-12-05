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
<link rel="stylesheet" href="../assets/css/font-awesome.min.css">

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
			<div class="col-sm-offset-3 col-sm-9 col-md-offset-3 col-md-9 main">
				<div class="row">
					<h1 class="page-header col-xs-12">Review your Trip</h1>
				</div>
				<div class="row">
					<h2 class="bg-warning warning-text">Price Change<br><small>Because prices change often, we recommend booking now to lock in this price.</small></h2>
				</div>
				<%// this search-row will be spanned%>
				<div class="row search-row">
					<div class="row cart-row">
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<h3 class="no-wrap"><%//Departure Date%>Wed, Dec 13</h3>
							</div>
							<div class="col-xs-3 col-sm-2 text-muted">
								<h3>From</h3>
								<h3>To</h3>
							</div>
							<div class="col-xs-9 col-sm-6">
								<h3 class="no-wrap">
									<%//Departure Airport Name + Airport ID%>Incheon Intl. (ICN)
								</h3>
								<h3 class="no-wrap">
									<%//Arrive Airport Name + Airport ID%>John F. Kennedy Intl. (JFK)
								</h3>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-5 col-sm-4">
								<img src="../images/airline/2.jpg" class="img-responsive img-fixed">
							</div>
							<div class="col-xs-7 col-sm-8">
								<h3>United Airline</h3>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-5 col-sm-4">
								<h3 class="no-wrap"><%//Departure Time%>12:15am</h3>
								<h3 class="no-wrap"><small><%//Departure Airport ID%>ICN</small></h3>
							</div>
							<div class="col-xs-2 col-sm-2 text-muted">
								<h3><span class="glyphicon glyphicon-arrow-right"></span></h3>
							</div>
							<div class="col-xs-5 col-sm-2">
								<h3 class="no-wrap"><%//Departure Time%>11:45am</h3>
								<h3 class="no-wrap"><small><%//Departure Airport ID %>JFK</small></h3>
							</div>
							<div class="col-xs-12 col-sm-4">
								<h3 class="no-wrap">
									<%//Elasped Time+ Stop%>31h 45m, 1 Stop
								</h3>
								<h3 class="no-wrap">
									<small><%//Stop Airport ID%>LGA</small>
								</h3>
								<h3 class="no-wrap">
									<small class="stop-arrive-text">Arrives <%//Stop arrive time%>Sat, Dec 23</small>
								</h3>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
				</div>

				<div class="row search-row">
					<div class="row cart-row">
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<h3 class="no-wrap"><%//Departure Date%>Wed, Dec 13</h3>
							</div>
							<div class="col-xs-3 col-sm-2 text-muted">
								<h3>From</h3>
								<h3>To</h3>
							</div>
							<div class="col-xs-9 col-sm-6">
								<h3 class="no-wrap">
									<%//Departure Airport Name + Airport ID%>Incheon Intl. (ICN)
								</h3>
								<h3 class="no-wrap">
									<%//Arrive Airport Name + Airport ID%>John F. Kennedy Intl. (JFK)
								</h3>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-5 col-sm-4">
								<img src="../images/airline/2.jpg" class="img-responsive img-fixed">
							</div>
							<div class="col-xs-7 col-sm-8">
								<h3>United Airline</h3>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-5 col-sm-4">
								<h3 class="no-wrap"><%//Departure Time%>12:15am</h3>
								<h3 class="no-wrap"><small><%//Departure Airport ID%>ICN</small></h3>
							</div>
							<div class="col-xs-2 col-sm-2 text-muted">
								<h3><span class="glyphicon glyphicon-arrow-right"></span></h3>
							</div>
							<div class="col-xs-5 col-sm-2">
								<h3 class="no-wrap"><%//Departure Time%>11:45am</h3>
								<h3 class="no-wrap"><small><%//Departure Airport ID %>JFK</small></h3>
							</div>
							<div class="col-xs-12 col-sm-4">
								<h3 class="no-wrap">
									<%//Elasped Time+ Stop%>31h 45m, 1 Stop
								</h3>
								<h3 class="no-wrap">
									<small><%//Stop Airport ID%>LGA</small>
								</h3>
								<h3 class="no-wrap">
									<small class="stop-arrive-text">Arrives <%//Stop arrive time%>Sat, Dec 23</small>
								</h3>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
				</div>
				
				<div class="row">
					<div class="col-xs-12 col-sm-8 col-sm-offset-2">
						<div class="row">
							<div class="card-body">
								<form action="#" method="post" novalidate="novalidate">
									<div class="form-group text-center">
										<ul class="list-inline">
											<li class="list-inline-item"><i
												class="text-muted fa fa-cc-visa fa-5x"></i></li>
											<li class="list-inline-item"><i
												class="fa fa-cc-mastercard fa-5x"></i></li>
											<li class="list-inline-item"><i
												class="fa fa-cc-amex fa-5x"></i></li>
											<li class="list-inline-item"><i
												class="fa fa-cc-discover fa-5x"></i></li>
										</ul>
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Payment
											amount</label>
										<h3>$1000.20</h3> 
									</div>
									<div class="form-group">
										<label for="cc-name" class="control-label mb-1">Name
											on card</label> <input id="cc-name" name="cc-name" type="text"
											class="form-control cc-name valid" data-val="true"
											data-val-required="Please enter the name on card"
											autocomplete="cc-name" aria-required="true"
											aria-invalid="false" aria-describedby="cc-name-error">
										<span class="help-block field-validation-valid"
											data-valmsg-for="cc-name" data-valmsg-replace="true"></span>
									</div>
									<div class="form-group">
										<label for="cc-number" class="control-label mb-1">Card
											number</label> <input id="cc-number" name="cc-number" type="tel"
											class="form-control cc-number identified visa" value=""
											data-val="true"
											data-val-required="Please enter the card number"
											data-val-cc-number="Please enter a valid card number"
											autocomplete="cc-number"> <span class="help-block"
											data-valmsg-for="cc-number" data-valmsg-replace="true"></span>
									</div>
									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label for="cc-exp" class="control-label mb-1">Expiration</label>
												<input id="cc-exp" name="cc-exp" type="tel"
													class="form-control cc-exp" value="" data-val="true"
													data-val-required="Please enter the card expiration"
													data-val-cc-exp="Please enter a valid month and year"
													placeholder="MM / YY" autocomplete="cc-exp"> <span
													class="help-block" data-valmsg-for="cc-exp"
													data-valmsg-replace="true"></span>
											</div>
										</div>
										<div class="col-xs-6">
											<label for="x_card_code" class="control-label mb-1">Security
												code</label>
											<div class="input-group">
												<input id="x_card_code" name="x_card_code" type="tel"
													class="form-control cc-cvc" value="" data-val="true"
													data-val-required="Please enter the security code"
													data-val-cc-cvc="Please enter a valid security code"
													autocomplete="off">
												<div class="input-group-addon">
													<span class="fa fa-question-circle fa-lg"
														data-toggle="popover" data-container="body"
														data-html="true" data-title="Security Code"
														data-content="<div class='text-center one-card'>The 3 digit code on back of the card..<div class='visa-mc-cvc-preview'></div></div>"
														data-trigger="hover"></span>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="x_zip" class="control-label mb-1">Postal
											code</label> <input id="x_zip" name="x_zip" type="text"
											class="form-control" value="" data-val="true"
											data-val-required="Please enter the ZIP/Postal code"
											autocomplete="postal-code"> <span class="help-block"
											data-valmsg-for="x_zip" data-valmsg-replace="true"></span>
									</div>
									<div>
										<button id="payment-button" type="submit"
											class="btn btn-lg btn-success btn-block">
											<i class="fa fa-lock fa-lg"></i>&nbsp; <span
												id="payment-button-amount">Pay</span> <span
												id="payment-button-sending" style="display: none;">Sending…</span>
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
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