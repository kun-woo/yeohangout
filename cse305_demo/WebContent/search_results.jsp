	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<!-- HEADER -->
	<%@ include file="../header.jsp"%>
	
	<!-- SignUp Modal -->
	<%@ include file="../signup.jsp"%>
	
	<!-- LogIn Modal -->
	<%@ include file="../signin.jsp"%>
	
	<!-- Search -->
	<%@ include file="../search.jsp"%>
	
	<%
	  for(int i = 0; i< 10; i++){
	
	    System.out.println(i);
	
	  }
	%>
	
	<!-- Footer -->
	<%@ include file="../footer.jsp"%>
	