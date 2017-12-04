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
<link href="../assets/css/search.css" rel="stylesheet">
<link href="../assets/css/dashboard.css" rel="stylesheet">

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

	<div class="col-sm-3 col-md-2 sidebar">
		<ul class="nav nav-sidebar">
			<li><a href="dashboard-manager-overview.jsp">Overview </a></li>
		</ul>
		<ul class="nav nav-sidebar">
			<li><a href="../view-employee">Manage Employee</a></li>
		</ul>
		<ul class="nav nav-sidebar">
			<li><a href="../view-sales-report">View Sales Report</a></li>
			<li class="active"><a href="#">View Reservation <span
					class="sr-only">(current)</span></a></li>
			<li><a href="../view-total-revenue">View Total Revenue</a></li>
			<li><a href="../view-flight">View Flight</a></li>
			<li><a href="../view-customer">View Customer</a></li>
		</ul>
	</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="row">
			<h1>Search Results</h1>
			<div class="btn-group pull-right">
				<a href="#" id="list" class="btn btn-default btn-sm"><span
					class="glyphicon glyphicon-th-list"> </span>List</a> <a href="#"
					id="grid" class="btn btn-default btn-sm"><span
					class="glyphicon glyphicon-th"></span>Grid</a>
			</div>
		</div>
		<div id="products" class="row list-group">
			<div class="item  col-xs-4 col-lg-4 list-group-item">
				<div class="thumbnail">
					<img class="group list-group-image"
						src="http://placehold.it/400X240/000/fff" alt="" />
					<div class="caption">
						<h4 class="group inner list-group-item-heading">Product title</h4>
						<p class="group inner list-group-item-text">Product
							description... Lorem ipsum dolor sit amet, consectetuer
							adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
							laoreet dolore magna aliquam erat volutpat.</p>
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">$21.000</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<a class="btn btn-success" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="item  col-xs-4 col-lg-4 list-group-item">
				<div class="thumbnail">
					<img class="group list-group-image"
						src="http://placehold.it/400X240/000/fff" alt="" />
					<div class="caption">
						<h4 class="group inner list-group-item-heading">Product title</h4>
						<p class="group inner list-group-item-text">Product
							description... Lorem ipsum dolor sit amet, consectetuer
							adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
							laoreet dolore magna aliquam erat volutpat.</p>
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">$21.000</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<a class="btn btn-success" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="item  col-xs-4 col-lg-4 list-group-item">
				<div class="thumbnail">
					<img class="group list-group-image"
						src="http://placehold.it/400X240/000/fff" alt="" />
					<div class="caption">
						<h4 class="group inner list-group-item-heading">Product title</h4>
						<p class="group inner list-group-item-text">Product
							description... Lorem ipsum dolor sit amet, consectetuer
							adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
							laoreet dolore magna aliquam erat volutpat.</p>
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">$21.000</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<a class="btn btn-success" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="item  col-xs-4 col-lg-4 list-group-item">
				<div class="thumbnail">
					<img class="group list-group-image"
						src="http://placehold.it/400X240/000/fff" alt="" />
					<div class="caption">
						<h4 class="group inner list-group-item-heading">Product title</h4>
						<p class="group inner list-group-item-text">Product
							description... Lorem ipsum dolor sit amet, consectetuer
							adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
							laoreet dolore magna aliquam erat volutpat.</p>
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">$21.000</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<a class="btn btn-success" href="http://www.jquery2dotnet.com">Add
									to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="item  col-xs-4 col-lg-4 list-group-item">
				<div class="thumbnail">
					<img class="group list-group-image"
						src="http://placehold.it/400X240/000/fff" alt="" />
					<div class="caption">
						<h4 class="group inner list-group-item-heading">Product title</h4>
						<p class="group inner list-group-item-text">Product
							description... Lorem ipsum dolor sit amet, consectetuer
							adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
							laoreet dolore magna aliquam erat volutpat.</p>
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">$21.000</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<a class="btn btn-success" href="http://www.jquery2dotnet.com">Add
									to cart</a>
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
	<!-- Jquery JS-->
	<script src="../assets/js/bootstrap.js"></script>
	<!-- Bootstrap JS -->
	<script src="../assets/js/search.js"></script>

</body>
</html>