<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%-- 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SwapRate</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
      <!-- Bootstrap files -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <!-- Angular files -->
      <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular-route.js"></script>
      <!-- css file -->
	  <link href="<%=request.getContextPath()%>/resources/css/swaprate.css" rel="stylesheet" />
	  <!-- JS File -->
	  	<!-- Controller -->
	  	<script src="<%=request.getContextPath()%>/resources/js/controller/swaprateController.js"></script>
 </head>
<body>
	<body ng-app="app">

<nav class="navbar navbar-expand-md bg-dark navbar-dark" ng-controller="navBarController">
  <a class="navbar-brand" href="index">SwapRate</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
    <li class="nav-item">
        	<a class="nav-link" href="current" ng-click="goToUrl('/current')">Current SwapRate</a>	
      </li>
      	<% if (session.getAttribute("loggedIn")!=null) {%>
      <li class="nav-item">
        <a class="nav-link" href="update" ng-click="goToUrl('/updateRate')" id="URL">Update Rates</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="display" ng-click="goToUrl('/updateRate')" id="URL">View Swaprate</a>
      </li>
      <li class="nav-item">
        	<a class="nav-link" href="logout" ng-click="goToUrl('/logout')">Logout</a>	
      </li> 
  	<%} else {%>
	  <li class="nav-item">
        	<a class="nav-link" href="registration" ng-click="goToUrl('/register')">Register</a>	
      </li>
     <%} %>
   </ul>
  </div>  
</nav>
<br>
</body>
</body>
</html>