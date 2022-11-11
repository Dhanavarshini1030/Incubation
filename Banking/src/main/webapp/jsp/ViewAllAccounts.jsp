<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Accounts</title>
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/Buttons.css">

</head>
<body>
<h5>LIST OF CUSTOMER ACCOUNTS</h5>
<form action="BankServlet" method="post" target="admin" id="one">
<div style="margin-left:74%; margin-bottom:10px; margin-top:20px;">

<button class="buttonClick" type="submit" value="addAccount" name="button" form="one">Add</button>
</div>
<div style="margin-top:0px;">
<table>
<tr style="border:none;
	text-align:center;
	font-weight:500;
	padding:10px;
	font-size:17px;height:50px;
	background-color:#aad2d5;"><td>Customer ID</td>
<td>Account Number</td>
<td>Account Type</td>
<td>IFSC</td>
<td>Branch</td>
<td>Balance</td>
<td>Status</td></tr>

<c:forEach items="${allAccountDetail}" var="accounts">
<tr><td> ${accounts.value.getCustomerID() }</td>
<td>${accounts.value.getAccountNumber() }</td>

<td>${accounts.value.getAccountType() }</td>
<td>${accounts.value.getIFSC() }</td>
<td>${accounts.value.getBranch() }</td>
<td>${accounts.value.getBalance() }</td>
<td>${accounts.value.getStatus() }</td>
</tr></c:forEach></table></div>
</form>


</body>
</html>