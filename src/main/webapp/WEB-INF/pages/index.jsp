<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%-- 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="header.jsp" />
<div class="main-login main-center decorate">
	<form class="form-horizontal col-lg-5 col-lg-offset-3" method="post" action="loginForm">
		<p>
		<h3 style="text-align: center;">LOGIN</h3>
		<p style="color: red">${error }</p>
		<div class="form-group">
			<label for="username" class="cols-sm-2 control-label">Username</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-users fa"
						aria-hidden="true"></i></span> <input type="text" class="form-control"
						name="username" id="username" placeholder="Enter your Username" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="cols-sm-2 control-label">Password</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock fa-lg"
						aria-hidden="true"></i></span> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="Enter your Password" />
				</div>
			</div>
		</div>

		<div class="form-group ">
			<button type="submit"
				class="btn btn-primary btn-lg btn-block login-button">Log
				in</button>
		</div>
	</form>
</div>
</div>