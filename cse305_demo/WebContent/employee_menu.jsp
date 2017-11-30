<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<!-- HEADER -->
<%@ include file="../header.jsp"%>
<div class="container-fluid bg-gray text-center">
		<ul>
			<li><a data-toggle="modal" data-target="#addAirline" ><span class="glyphicon glyphicon-user"></span>Add Airline</a></li>
        		<li><a data-toggle="modal" data-target="#addFlight" ><span class ="glyphicon glyphicon-user"></span>Add Flight</a></li>
        		<li><a data-toggle="modal" data-target="#addAirport" ><span class ="glyphicon glyphicon-user"></span>Add Airport</a></li>
        		<li><a data-toggle="modal" data-target="#addLeg"><span class="glyphicon glyphicon-user"></span>Add Leg</a></li>
        	</ul>
</div>

<%@include file="../employee_add.jsp" %>
<%@include file="../employee_add_flight.jsp"%>	
<%@include file="../employee_add_airport.jsp" %>		
<%@include file="../employee_add_leg.jsp" %>		
<%@ include file="../footer.jsp"%>
