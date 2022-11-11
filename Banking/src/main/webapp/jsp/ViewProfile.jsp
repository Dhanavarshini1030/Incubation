<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER PROFILE</title>
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/Buttons.css">

</head>
<body>
	<h5>CUSTOMER PROFILE</h5>
	<h3>${message}</h3>
	<h3>${Error}</h3>
	<div class="container">
	<form method="post" id="one">
	<div style="margin-left:62%; margin-bottom:10px;">
	<button class="buttonClick" type="submit" value="update" name="button" form="one">  Save  </button>
		</div>
		<table>
		   <c:forEach items="${userDetail}" var="user">
		   <c:forEach items="${userInfo}" var="info">
			<tr>
				<td style="text-align:left; font-size:15px; opacity:0.8;">Customer ID</td>
				<td><input type="text" value="${info.value.getCustomerID()}" readonly></td>
			</tr>
			<tr>
				<td style="text-align:left; font-size:15px; opacity:0.8;">Name</td>
				<td><input type="text" value="${info.value.getCustomerName()}" readonly></td>
			</tr>
			<tr>
				<td style="text-align:left; font-size:15px; opacity:0.8;">Aadhar Number</td>
				<td><input type="text" value="${user.value.getAadharNumber()}" readonly></td>
			</tr>
			<tr>
				<td style="text-align:left; font-size:15px; opacity:0.8;">PAN Number</td>
				<td><input type="text" value="${user.value.getPAN_Number()}" readonly></td>
			</tr>
			<tr>
				<td style="text-align:left; font-size:15px; opacity:0.8;">Email</td>
				<td><input type="email" value="${info.value.getEmail()}" name="email" required></td>
			</tr>
			<tr>
				<td style="text-align:left; font-size:15px; opacity:0.8;">Date Of Birth</td>
				<td><input type="text" value="${user.value.getDOB()}" readonly></td>
			</tr>
			<tr>
				<td style="text-align:left; font-size:15px; opacity:0.8;">Mobile Number</td>
				<td><input type="text" value="${info.value.getMobileNumber()}" name="mobile" 
				maxlength="10" pattern="[7-9]{1}[0-9]{9}" title="Should contain 10 numbers only" required></td>
			</tr>
			<tr>
				<td style="text-align:left; font-size:15px; opacity:0.8;">Address</td>
				<td><input type="text" value="${user.value.getAddress()}" name="address" required></td>
				
			</tr></c:forEach></c:forEach></table>
			
</form>	</div>
</body>
</html>