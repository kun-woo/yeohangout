<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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