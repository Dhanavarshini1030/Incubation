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
<h5>LIST OF CUSTOMER PROFILE</h5>
<h3>${Error}</h3>
<form action="BankServlet" method="post" target="admin" id="one">
<div style="margin-left:80%; margin-bottom:10px; margin-top:20px;">
<button class="buttonClick" type="submit" value="addProfile" name="button" form="one" >Add </button>		
</div>
<table>
<tr style="border:none;
	text-align:center;
	font-weight:500;
	padding:10px;height:50px;
	font-size:17px;
	background-color:#aad2d5;"><td>Customer ID</td>
<td>Name</td>
<td>Aadhar Number</td>
<td>PAN Number</td>
<td>Email</td>
<td>Mobile</td>
<td>Date-Of-Birth</td>
<td>Address</td>
</tr>

<c:forEach items="${UserDetails}" var="user">
<tr><td>${user.value.getCustomerID()}</td>
<td>${user.value.getCustomerName()}</td>
<td>${user.value.getAadharNumber()}</td>
<td>${user.value.getPAN_Number()}</td>
<td>${user.value.getEmail()}</td>
<td>${user.value.getMobileNumber()}</td>
<td>${user.value.getDOB() }</td>
<td>${user.value.getAddress()}</td>
</c:forEach></table>


</form>

</body>
</html>