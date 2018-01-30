<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
</style>



<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $('input[type="radio"]').click(function(){
        var inputValue = $(this).attr("value");
        var targetBox = $("." + inputValue);
        $(".box").not(targetBox).hide();
        $(targetBox).show();
    });
});
</script>


</head>
<body>
	<section id="contact">
		<div class="container">
			<div class="section-content">
				<h1 class="section-header">
					<span class="content-header wow fadeIn " data-wow-delay="0.2s"
						data-wow-duration="2s">&nbsp;&nbsp;&nbsp;&nbsp;Update
						SwapRate</span>
				</h1>
			</div>

			<div class="row">
				<div class="span12">
					<div class="" id="loginModal">
						<div class="modal-body">
							<div class="well">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#login" data-toggle="tab">Manual
											update</a></li>
									<li><a href="#create" data-toggle="tab">Upload file</a></li>
								</ul>
								<div id="myTabContent" class="tab-content">
									<div class="tab-pane active in" id="login">
										<form class="form-horizontal" action="singleUpdate"
											method="POST" name="updateForm" id="updateForm">
											<div class="form-group" style="margin-top: 10px;">
												<label class="cols-sm-2 control-label">DATE:</label>
												<div class="cols-sm-10 col-lg-4">
													<div class="input-group">
														<span class="input-group-addon"><i
															class="fa fa-users fa" aria-hidden="true"></i></span> <input
															type="date" name="dt" onchange="submitForm()" id="dt"
															value="${(not empty date) ? date : '' }"
															class="form-control" />
													</div>
												</div>
											</div>


										</form>
										<form method="POST" action="rateUpdate">
											<input type="hidden" name="id"
												value="${(not empty rates.swap_rate_id) ? rates.swap_rate_id : -999 }">
											<input type="hidden" name="date" value="${date}">
											<div class="form-group">
												<label for="username" class="cols-sm-2 control-label">INR:</label>
												<div class="cols-sm-10 col-lg-4">
													<div class="input-group">
														<span class="input-group-addon"><i
															class="fa fa-users fa" aria-hidden="true"></i></span> <input
															type="number" name="inr"
															value="${(not empty rates.inr) ? rates.inr : '' }"
															step="any" class="form-control" placeholder="inr" />
													</div>
												</div>
											</div>


											<div class="form-group">
												<label for="username" class="cols-sm-2 control-label">AUS:</label>
												<div class="cols-sm-10 col-lg-4">
													<div class="input-group">
														<span class="input-group-addon"><i
															class="fa fa-users fa" aria-hidden="true"></i></span> <input
															type="number" name="aus"
															value="${(not empty rates.aus) ? rates.aus : '' }"
															step="any" class="form-control" placeholder="aus" />
													</div>
												</div>
											</div>

											<div class="form-group">
												<label for="username" class="cols-sm-2 control-label">CAD:</label>
												<div class="cols-sm-10 col-lg-4">
													<div class="input-group">
														<span class="input-group-addon"><i
															class="fa fa-users fa" aria-hidden="true"></i></span> <input
															type="number" name="cad"
															value="${(not empty rates.cad) ? rates.cad : '' }"
															step="any" class="form-control" placeholder="cad" />
													</div>
												</div>
											</div>

											<div class="form-group">
												<label class="cols-sm-2 control-label">EUR:</label>
												<div class="cols-sm-10 col-lg-4">
													<div class="input-group">
														<span class="input-group-addon"><i
															class="fa fa-users fa" aria-hidden="true"></i></span> <input
															type="number" name="eur"
															value="${(not empty rates.eur) ? rates.eur : '' }"
															step="any" class="form-control" placeholder="eur" />
													</div>
												</div>
											</div>





											<%-- 	INR:-<input type="number" name="inr" value="${(not empty rates.inr) ? rates.inr : '' }" step="any">
							Euro:-<input type="number" name="eur" value="${(not empty rates.eur) ? rates.eur : '' }" step="any">
                        	Canada:-<input type="number" name="cad" value="${(not empty rates.cad) ? rates.cad : '' }" step="any">
                        	Australia:-<input type="number" name="aus" value="${(not empty rates.aus) ? rates.aus : '' }" step="any">
                        	 --%>
											<div class="form-group ">
												<input type="submit"
													class="btn btn-primary btn-lg btn-block login-button"
													value="${(not empty rates.swap_rate_id) ? 'Update' : 'Add new' }" />
											</div>
										</form>
									</div>
									<div class="tab-pane fade" id="create">
										<form id="tab" method="POST" action="uploadFile" enctype="multipart/form-data">
											<div class="form-group">
												<label class="cols-sm-2 control-label">Select A file to Upload</label>
												<div class="cols-sm-10 col-lg-4">
													<div class="input-group">
														<span class="input-group-addon"><i
															class="fa fa-users fa" aria-hidden="true"></i></span>
															<input type="file" name="file" class="file" />
													</div>
												</div>
											</div>

											<div class="form-group ">
												<input type="submit"
													class="btn btn-primary btn-lg btn-block login-button"
													value="upload file" />
											</div>
											
									</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript">

function submitForm()
{
	document.updateForm.submit();
}

</script>

	</section>
</body>
</html>