	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="yeohangout.javabeans.Leg" %>
    
	<!-- HEADER -->
	<%@ include file="../header.jsp"%>
	
	<!-- SignUp Modal -->
	<%@ include file="../signup.jsp"%>
	
	<!-- LogIn Modal -->
	<%@ include file="../signin.jsp"%>
	
	<!-- Search -->
	<%@ include file="../search.jsp"%>
	
	<hr>
	<%
		int numOfResults = 0;
		if(request.getAttribute("numOfResults") != null){
			numOfResults = (int) request.getAttribute("numOfResults");
		}
		ArrayList<Leg> resultTable = new ArrayList<Leg>();

		for(int i = 0; i < numOfResults; i++){
			resultTable.add((Leg) request.getAttribute("searchResult" + i));
		}
		
	  	for(int i = 0; i< numOfResults; i++){
	%>
	
	<div class="row text-center">
		<div class="col-sm-12 search-form">
			<form class="form" action="bookflight" method="POST">
				<div class="form-group">
				<div class="row">
				<!-- ROW ONE -->
				<!-- Depart/Return	| DepDate	     "	-->
					<div class="col-sm-2 text-right">
						<label class="control-label" for="text">Departure: </label>
					</div>
					<div class="col-sm-9 text-left">
						<label class="control-label" for="text">Jan. 6, 2018 </label>
					</div>
				<!-- ROW TWO -->
				<!-- PlaneGLYF	| DepTime	| ArrTime	| "Book:     "	-->
					<div class="col-sm-3">
						<span class="glyphicon glyphicon-plane"></span>
					</div>
					<div class="col-sm-3">
						<label class="control-label" for="text"><%=resultTable.get(i).getDepDate() %> </label>
					</div>
					<div class="col-sm-3">
						<label class="control-label" for="text"><%=resultTable.get(i).getArrDate() %> </label>
					</div>
					<div class="col-sm-3">
						<label class="control-label" for="text">Reserve: </label>
					</div>
				<!-- ROW THREE -->
				<!-- AirlineID	| DepAirport| ArrAirport| "BookButton"	-->
					<div class="col-sm-3">
						<label class="control-label" for="text"><%=resultTable.get(i).getAirlineID() %> </label>
					</div>
					<div class="col-sm-3">
						<label class="control-label" for="text"><%=resultTable.get(i).getDepAirportID() %> </label>
					</div>
					<div class="col-sm-3">
						<label class="control-label" for="text"><%=resultTable.get(i).getArrAirportID() %> </label>
					</div>
					<div class="col-sm-3">
						<button type="submit" class="btn btn-success btn-md btn-search">Book</button>
					</div>
				</div>
				</div>
			</form>
		</div>
	</div>
	
	<hr>
	
	<% } %>
	<!-- Footer -->
	<%@ include file="../footer.jsp"%>
	