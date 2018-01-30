<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<jsp:include page="header.jsp" />
<div class="col-lg-8 col-lg-offset-2">
<a href="downlaodFile" class="btn btn-primary btn-lg btn-block login-button">Download csv data</a>
<a href="downlaodJsonFile" class="btn btn-primary btn-lg btn-block login-button">Download json data</a>
<h3>Complete History </h3>
<table class="table table-striped table-bordered table-hover table-condensed" style="margin-top: 20px">
    <thead>
      <tr>
        <th>Date</th>
        <th>CAD</th>
		<th>INR</th>
		<th>EUR</th>
		<th>AUS</th>
		</tr>
    </thead>
    <tbody>
	<c:forEach items="${allrates }" var="rates">
      <tr>
        <td>${rates.date }</td>
        <td>${rates.cad }</td>
		<td>${rates.inr }</td>
		<td>${rates.eur }</td>
		<td>${rates.aus }</td>
	  </tr>
	</c:forEach>
   </tbody>
</table>
</div>