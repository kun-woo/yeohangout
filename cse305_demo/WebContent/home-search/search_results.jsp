	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="yeohangout.javabeans.Leg" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
	<!-- HEADER -->
	<%@ include file="../home/header.jsp"%>
	
	<!-- SignUp Modal -->
	<%@ include file="../home/signup.jsp"%>
	
	<!-- LogIn Modal -->
	<%@ include file="../home/signin.jsp"%>
	
	<!-- Search -->
	<%@ include file="search.jsp"%>
	
	<c:choose>
		<c:when test = "${searchType.equals(one-way)}">
		</c:when>
		<c:when test = "round-trip">
		</c:when>
		<c:when test = "multi-flight">
		</c:when>
	</c:choose>
	
	<hr>
	<table class="table">
		
		<c:forEach items="${searchResults}" var="result">
			<tr>
				<td><span class="glyphicon glyphicon-plane"></span></td>
				<td><c:out value="${result.depDate}"></c:out></td>
				<td><c:out value="${result.arrDate}"></c:out></td>
				<td>Reserve</td>
			</tr>
			<tr>
				<td><c:out value="${result.airlineID}"></c:out></td>
				<td><c:out value="${result.depAirportID}"></c:out></td>
				<td><c:out value="${result.arrAirportID}"></c:out></td>
				<td><button type="submit" class="btn btn-success btn-md btn-search">Book</button></td>
			</tr>
			<hr>
		</c:forEach>
  		
  	</table>
	
	<!-- Footer -->
	<%@ include file="../home/footer.jsp"%>
	