<jsp:include page="header.jsp" />
<p style="color:red;font-size: 24px;">${(not empty rate.swap_rate_id) ? "" : "No data found for this date" }</p>
<div class="col-md-4 col-sm-12 col-lg-4 col-lg-offset-4">
	<h1>Date:- ${rate.date }</h1>
	<table class="table table-striped table-bordered table-hover table-condensed">
	<thead>
		<tr>
			<th>Currency</th>
			<th>Rate</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>INR</td>
			<td>${rate.inr }</td>
		</tr>
		<tr>
			<td>AUS</td>
			<td>${rate.aus }</td>
		</tr>
		<tr>
			<td>CAD</td>
			<td>${rate.cad }</td>
		</tr>
		<tr>
			<td>EUR</td>
			<td>${rate.eur }</td>
		</tr>
		</tbody>
	</table>
</div>