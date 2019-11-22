<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<c:set var="pageTitle" value="Survey Results" />
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
			<c:forEach var="parksurvey" items="${surveyResults }">
			
				<div class="col-md-4" style= "margin-top: 20px;">
					<div class="card" style="width: 98%;">
						<img src="<c:url value="img/parks/${parksurvey.parkcode.toLowerCase()}.jpg" />"
							class="card-img-top" />
						<div class="card-body">
							<a href="<c:url value="detailPage?parkcode=${parksurvey.parkcode}"/>">${parksurvey.parkname}</a>
							<p class="card-text">Votes - ${parksurvey.count}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
