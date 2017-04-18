<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="tracker-app">
<head>
<title>Domain Referral Tracker</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script src="tracker.js"></script>
</head>

<body>
	<div ng-controller="tracker-controller">
		<h2>Enter domain referral</h2>
		<div>
			<input name="domainReferral" ng-model="domainReferral">
			<button ng-click="saveDomain()">Save</button>
		</div>
		<p>Top three domain referrals: {{topThree}}</p>
	</div>
</body>
</html>