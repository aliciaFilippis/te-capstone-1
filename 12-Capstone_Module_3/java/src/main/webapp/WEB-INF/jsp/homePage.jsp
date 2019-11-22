<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="pageTitle" value="Homepage" />
<%@include file="common/header.jspf"%>

<style type="text/css">
body {
	margin-left:30px;
	margin-right:30px;
}
</style>

<div class="py-5">
	<div class="row">
		<div class="card-deck">
		
			<c:forEach var="park" items="${park}">

				<div class="col-md-4" style = "margin-top:20px;">
					<div class="card" style="width: 98%;">
						<img
							src="<c:url value="img/parks/${park.parkcode.toLowerCase()}.jpg" />"
							class="card-img-top" />
						<div class="card-body">
							<a href="<c:url value="detailPage?parkcode=${park.parkcode }"/>"><strong>${park.parkname}</strong></a>
							<p class="card-text">${park.parkDescription}</p>
						</div>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>
</div>

<%@include file="common/footer.jspf"%>