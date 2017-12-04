<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="yeohangout.mysql.MyUtils"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Set Viewpoint -->
<!-- Google Font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 

<link rel="stylesheet" href="assets/css/bootstrap.min.css" /> <!-- Bootstrap CSS -->
<link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" /> <!-- Bootstrap DTP CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/main.css">

<script src="assets/js/jquery-3.2.1.min.js"></script> <!-- Jquery JS-->
<script src="assets/js/bootstrap.js"></script> <!-- Boostrap JS -->
<script src="assets/js/moment.js"></script> <!-- Moment JS -->
<script src="assets/js/bootstrap-datetimepicker.js"></script> <!-- Boostrap DTP JS -->

<script src="assets/js/main.js"></script>
<title>YeoHangOut</title>
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
				<li><a href="#mycarousel">HOME</a></li>
				<li><a href="#search">BOOK</a></li>
				<li><a href="#about">ABOUT</a></li>
				<li><a href="#service">SERVICE</a></li>
				<li><a href="#contact">CONTACT</a></li>
				
				<%
					if(MyUtils.getSession()==null){
				%>
					<li><a data-toggle="modal" data-target="#mySignUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        				<li><a data-toggle="modal" data-target="#myLogIn" ><span class="glyphicon glyphicon-log-in"></span> Log In</a></li>
        			
				<%
					} else if(MyUtils.getUserType() == 0){ 
				%>	

        				<li><a data-toggle="modal" href="./customer_mypage.jsp"><span class="glyphicon glyphicon-th-list"></span> My Page</a></li>
        				<li><a data-toggle="mdoal" href="logout"><span class="glyphicon glyphicon-th-list"></span>Log Out</a>
        			<%
        				} else if(MyUtils.getUserType()==1){
        					
        			%>
        				<li><a data-toggle="modal" href="./employee_menu.jsp"><span class="glyphicon glyphicon-th-list"></span>Manage</a></li>
					<li><a data-toggle="mdoal" href="logout"><span class="glyphicon glyphicon-th-list"></span>Log Out</a>
        			 
        				
        			<%
					} else if(MyUtils.getUserType()==2){
				%>
			<li><a data-toggle="modal" href="dashboard-manager/dashboard-manager-overview.jsp"><span class="glyphicon glyphicon-th-list"></span>Manage</a></li>
        				<li><a data-toggle="mdoal" href="logout"><span class="glyphicon glyphicon-th-list"></span>Log Out</a>
				<%
					}
				%>
				
			</ul>
		</div>
	</div>
	</nav>
	
