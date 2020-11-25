<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background-color: #66CDAA;
}
</style>
</head>
<body>
	<h1><center>ONLINE INSURANCE QUOTE GENERATION</center></h1>
	<h2>View Policy</h2>
	<table border="2">
	<tr>
		<th>Policy Number</th>
		<th>Policy Premium</th>
		<th>Account Number</th>
		</tr>
		<c:forEach items="${policies}" var="policy">
			<tr>
				<td>${policy.policyNumber}</td>
				<td>${policy.policyPremium}</td>
				<td>${policy.accNumber }</td>
				<td><a href="AgentReportGeneration?accNumber=${policy.accNumber}&polNumber=${policy.policyNumber}">ViewPolicy</a>
			</tr>
		</c:forEach>
	</table>
		        <br><a href="AgentPage.jsp">Back</a>
</body>
</html>