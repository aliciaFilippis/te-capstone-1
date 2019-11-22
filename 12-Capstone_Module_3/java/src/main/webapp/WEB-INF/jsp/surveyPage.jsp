<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Take a Survey" />
<%@include file="common/header.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style type="text/css">
body {
	margin-left:30px;
	margin-right:30px;
}
</style>


</head>
<body>
	<section class="new">
		<c:url var="newSurveyUrl" value="/surveyPage" />
		<form:form method="POST" action="${newSurveyUrl}" modelAttribute="newSurvey">
			<div class="favoritePark">
				<label for="favoritePark">Your Favorite National Park: </label> <form:select
					path="parkCode" id="favoritePark">
					<option value="GNP">Glacier National Park</option>
					<option value="GCNP">Grand Canyon National Park</option>
					<option value="GTNP">Grand Teton National Park</option>
					<option value="MRNP">Mount Ranier National Park</option>
					<option value="GSMNP">Great Smoky Mountain National Park</option>
					<option value="ENP">Everglades National Park</option>
					<option value="YNP">Yellowstone National Park</option>
					<option value="YNP2">Yosemite National Park</option>
					<option value="CVNP">Cuyahoga Valley National Park</option>
					<option value="RMNP">Rocky Mountain National Park</option>
				</form:select>
			</div>
			<br>
			<div class="email">
				<label for="email">Your email: </label> <form:input type="email"
					path="emailAddress" id="email" />
				<form:errors path="emailAddress" cssClass="error"/>
			</div>
			<br>
			<div class="state">
				<label for="state">Your State of Residence: </label> <form:select id="state"
					path="state">
					<option value="Alabama">Alabama</option>
					<option value="Alaska">Alaska</option>
					<option value="Arizona">Arizona</option>
					<option value="Arkansas">Arkansas</option>
					<option value="California">California</option>
					<option value="Colorado">Colorado</option>
					<option value="Connecticut">Connecticut</option>
					<option value="Delaware">Delaware</option>
					<option value="District of Columbia">District of Columbia</option>
					<option value="Florida">Florida</option>
					<option value="Georgia">Georgia</option>
					<option value="Guam">Guam</option>
					<option value="Hawaii">Hawaii</option>
					<option value="Idaho">Idaho</option>
					<option value="Illinois">Illinois</option>
					<option value="Indiana">Indiana</option>
					<option value="Iowa">Iowa</option>
					<option value="Kansas">Kansas</option>
					<option value="Kentucky">Kentucky</option>
					<option value="Louisiana">Louisiana</option>
					<option value="Maine">Maine</option>
					<option value="Maryland">Maryland</option>
					<option value="Massachusetts">Massachusetts</option>
					<option value="Michigan">Michigan</option>
					<option value="Minnesota">Minnesota</option>
					<option value="Mississippi">Mississippi</option>
					<option value="Missouri">Missouri</option>
					<option value="Montana">Montana</option>
					<option value="Nebraska">Nebraska</option>
					<option value="Nevada">Nevada</option>
					<option value="New Hampshire">New Hampshire</option>
					<option value="New Jersey">New Jersey</option>
					<option value="New Mexico">New Mexico</option>
					<option value="New York">New York</option>
					<option value="North Carolina">North Carolina</option>
					<option value="North Dakota">North Dakota</option>
					<option value="Northern Marianas Islands">Northern
						Marianas Islands</option>
					<option value="Ohio">Ohio</option>
					<option value="Oklahoma">Oklahoma</option>
					<option value="Oregon">Oregon</option>
					<option value="Pennsylvania">Pennsylvania</option>
					<option value="Puerto Rico">Puerto Rico</option>
					<option value="Rhode Island">Rhode Island</option>
					<option value="South Carolina">South Carolina</option>
					<option value="South Dakota">South Dakota</option>
					<option value="Tennessee">Tennessee</option>
					<option value="Texas">Texas</option>
					<option value="Utah">Utah</option>
					<option value="Vermont">Vermont</option>
					<option value="Virginia">Virginia</option>
					<option value="Virgin Islands">Virgin Islands</option>
					<option value="Washington">Washington</option>
					<option value="West Virginia">West Virginia</option>
					<option value="Wisconsin">Wisconsin</option>
					<option value="Wyoming">Wyoming</option>
				</form:select>
			</div>
			<br>
			<div class="activityLevel">
				<label for="activityLevel">Your Activity Level: </label>
				<form:select id="activityLevel" path="activityLevel">
				<option value="inactive">Inactive</option>
				<option value="sedentary">Sedentary</option>
				<option value="active">Active</option>
				<option value="extremely active">Extremely Active</option>
				</form:select>
			</div>
			<br>
			<input class="formSubmitButton" type="submit" value="Submit"/>
		</form:form>
	</section>
</body>
</html>