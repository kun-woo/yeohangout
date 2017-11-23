<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Set Viewpoint -->
<!-- Google Font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="assets/css/bootstrap.min.css" /> <!-- Bootstrap CSS -->
<link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" /> <!-- Bootstrap DTP CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/main.css">

<script src="assets/js/jquery-3.2.1.min.js"></script> <!-- Jquery JS-->
<script src="assets/js/bootstrap.js"></script> <!-- Boostrap JS -->
<script src="assets/js/moment.js"></script> <!-- Moment JS -->
<script src="assets/js/bootstrap-datetimepicker.js"></script> <!-- Boostrap DTP JS -->
<script src="assets/js/main.js"></script>
<title>YeoHangOut Demo5</title>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
	<!-- Navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#mycarousel">Yeo Hang Out</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#search">BOOK</a></li>
				<li><a href="#about">ABOUT</a></li>
				<li><a href="#service">SERVICE</a></li>
				<li><a href="#contact">CONTACT</a></li>
				<li><a><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        			<li><a><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<!-- Home -->
	<div id="mycarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#mycarousel" data-slide-to="0" class="active"></li>
			<li data-target="#mycarousel" data-slide-to="1"></li>
			<li data-target="#mycarousel" data-slide-to="2"></li>
		</ol>
		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="images/1.jpg"
					data-color="lightblue" alt="First Image">
				<div class="carousel-caption">
					<h1>First Image</h1>
					<h2>This is a first image</h2>
					<br>
					<a href="#search" class="btn btn-default btn-lg book-button" role="button"><b>Book Now</b></a>
				</div>
			</div>
			<div class="item">
				<img src="images/2.jpg"
					data-color="firebrick" alt="Second Image">
				<div class="carousel-caption">
					<h1>Second Image</h1>
					<h2>This is a second image</h2>
					<br>
					<a href="#search" class="btn btn-default btn-lg book-button" role="button"><b>Book Now</b></a>
				</div>
			</div>
			<div class="item">
				<img src="images/3.jpg"
					data-color="violet" alt="Third Image">
				<div class="carousel-caption">
					<h1>Third Image</h1>
					<h2>This is a third image</h2>
					<br>
					<a href="#search" class="btn btn-default btn-lg book-button" role="button"><b>Book Now</b></a>
				</div>
			</div>
		</div>
		<!-- Controls -->
		<a class="left carousel-control" href="#mycarousel" role="button" data-slide="prev"> 
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"> </span> 
		<span class="sr-only">Previous</span> <!-- screen reader only -->
		</a> 
		<a class="right carousel-control" href="#mycarousel" role="button" data-slide="next"> 
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- Popular -->
	<div class="container-fluid bg-gray text-center">
		<h2>Our <b>Top</b> Tours</h2>
		<h4>Places You Don't Want to Miss</h4>
		<p>At the best price</p>
		<div class="row text-center slideanim">
			<div class="col-sm-4">
				<div class="thumbnail-popular">
					<img src="images/4.jpg" alt="Paris">
					<p>
						<strong>Paris</strong>
					</p>
					<p>
					<span class="glyphicon glyphicon-star myStar"></span>
					<span class="glyphicon glyphicon-star myStar"></span>
					<span class="glyphicon glyphicon-star myStar"></span>
					<span class="glyphicon glyphicon-star myStar"></span>
					<span class="glyphicon glyphicon-star myStar"></span>
					Rate Paris!
					</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail-popular">
					<img src="images/4.jpg" alt="New York">
					<p>
						<strong>New York</strong>
					</p>
					<p>We built New York</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail-popular">
					<img src="images/4.jpg" alt="San Francisco">
					<p>
						<strong>San Francisco</strong>
					</p>
					<p>Yes, San Fran is ours</p>
				</div>
			</div>
		</div>
	</div>
	<!-- Search -->
	<div id="search" class="container-fluid text-center">
		<h2>Find a Tour</h2>
		<h4>Travel with Yeo Hang Out</h4>
		<br>
		<div class="row text-center slideanim">
			<div class="col-sm-12 search-form">
				<form class="form">
					<br>
					<div class="form-group">
						<div class="col-sm-12 text-left">
							<div class="btn-group">
								<button type="button" class="btn btn-default btn-md">One-Way</button>
								<button type="button" class="btn btn-default btn-md">Round Trip</button>
								<button type="button" class="btn btn-default btn-md">Multi-City</button>
							</div>
						</div>
					</div>				
					<div class="form-group">
						<div class="col-sm-6 text-left">
							<br>
							<!-- .control-label for all horizontal form's labels -->
							<label class="control-label" for="text">Flying From</label> 
							<input type="text" class="form-control" placeholder="City or Airport">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6 text-left">
							<br>
							<label class="control-label" for="text">Flying To</label>
							<input type="text" class="form-control" placeholder="City or Airport">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6 col-md-4 text-left">
							<br>
							<label class="control-label" for="text">Departing</label>
							<div class='input-group date' id='datetimepicker1'>
								<input type="text" class="form-control" placeholder="mm/dd/yyyy">
								<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6 col-md-4 text-left">
							<br>
							<label class="control-label" for="text">Returning</label>
							<div class='input-group date' id='datetimepicker2'>
								<input type="text" class="form-control" placeholder="mm/dd/yyyy">
								<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6 col-md-2 text-left">
							<br>
							<label class="control-label" for="text">Passengers</label>
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle dropdown-btn"
									type="button" data-toggle="dropdown">
									0 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a>1</a></li>
									<li><a>2</a></li>
									<li><a>3</a></li>
									<li><a>4</a></li>
									<li><a>5</a></li>
									<li><a>6</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6 col-md-2 text-left">
							<br>
							<label class="control-label" for="checkbox">Feeling Lucky? (Auction)</label><!-- 
							<input type="checkbox" name="my-checkbox" data-on-color="danger" data-on-text="YES!"
								data-off-text="NAH" data-handle-width="10" data-size="normal" id="checkbox"> -->
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle dropdown-btn"
									type="button" data-toggle="dropdown">
									Nah <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a>Yeah!</a></li>
									<li><a>Well..nah..</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 text-left">
							<br>
							<button type="button" class="btn btn-success btn-md">Search</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- About -->
	<div id="about" class="container-fluid bg-gray text-center">
		<h2>About Us</h2>
		<h4>Yeo Hang Out: A Creative Travel Agency</h4>
		<p>That Will Take You Far away</p>
		<div class="row text-center slideanim">
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="images/about-image-1.jpg" alt="Paris">
					<p>
						<strong>Paris</strong>
					</p>
					<p>Yes, we built Paris</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="images/about-image-2.jpg" alt="New York">
					<p>
						<strong>New York</strong>
					</p>
					<p>We built New York</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="images/about-image-3.jpg" alt="San Francisco">
					<p>
						<strong>San Francisco</strong>
					</p>
					<p>Yes, San Fran is ours</p>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid bg-gray">
		<div class="row">
			<div class="col-sm-offset-2 col-sm-4">
				<span class="glyphicon glyphicon-globe logo"></span>
			</div>
			<div class="col-sm-6 text-center">
				<h2>Our Values</h2>
				<h4>
					<strong>MISSION:</strong> Our mission is.
				</h4>
				<p>
					<strong>VISION:</strong> Our vision is.
				</p>
			</div>
		</div>
	</div>
	<!-- Service -->
	<div id="service" class="container-fluid text-center">
		<h2>SERVICES</h2>
		<h4>What we offer</h4>
		<br>
		<div class="row">
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-off logo-small"></span>
				<h4>POWER</h4>
				<p>Power you up</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-heart logo-small"></span>
				<h4>LOVE</h4>
				<p>Love you up</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-lock logo-small"></span>
				<h4>JOB DONE</h4>
				<p>Job blow up</p>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-leaf logo-small"></span>
				<h4>GREEN</h4>
				<p>Green you up</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-certificate logo-small"></span>
				<h4>CERTIFIED</h4>
				<p>Certify you up</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-wrench logo-small"></span>
				<h4>HARD WORK</h4>
				<p>Hard you up</p>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-offset-2 col-sm-6 text-center">
				<h2>Fly With Us</h2>
				<button class="btn btn-default btn-lg">Get in Touch</button>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-plane logo"></span>
			</div>
		</div>
	</div>
	<!-- Contact -->
	<div id=contact class="container-fluid bg-gray">
		<h2 class="text-center">Contact</h2>
		<br>
		<div class="row">
			<div class="col-sm-5">
				<p>Contact us and we'll get back to you within 24 hours.</p>
				<p>
					<span class="glyphicon glyphicon-map-marker"></span> Stony Brook, US
				</p>
				<p>
					<span class="glyphicon glyphicon-phone"></span> +1 631-2345-6789
				</p>
				<p>
					<span class="glyphicon glyphicon-envelope"></span>
					no-reply@noreply.com
				</p>
			</div>
			<div class="col-sm-7">
				<div class="row">
					<div class="col-sm-6 form-group">
						<input class="form-control" id="name" name="name"
							placeholder="Name" type="text" required>
					</div>
					<div class="col-sm-6 form-group">
						<input class="form-control" id="email" name="email"
							placeholder="Email" type="email" required>
					</div>
				</div>
				<textarea class="form-control" id="comments" name="comments"
					placeholder="Comment" rows="5"></textarea>
				<br>
				<div class="row">
					<div class="col-sm-12 form-group">
						<button class="btn btn-default pull-right" type="submit">Send</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="container-fluid text-center"> <a href="#myPage"
		title="To Top"> <span class="glyphicon glyphicon-chevron-up"></span>
	</a>
	<p>
		Fifth Demo Powered by <strong>Boostrap</strong> Made by <b>Yeo Hang Out</b>
	</p>
	</footer>
</body>
</html>