<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACCOUNTS</title>
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/Buttons.css">

</head>
<body>

<h5>ACCOUNTS</h5>
<div class="container">
<table>
<tr style="border:none;
	text-align:center;
	font-weight:500;
	padding:10px;height:50px;
	font-size:17px;
	background-color:#aad2d5;"><td>Account Number</td>
<td>Account Type</td>
<td>IFSC</td>
<td>Branch</td>
<td>Balance</td>
<td>Status</td></tr>

 <c:forEach items="${accounts}" var="acc">
		  
<tr><td>${acc.value.getAccountNumber() }</td>
<td style=" font-size:15px;">${acc.value.getAccountType() }</td>
<td>${acc.value.getIFSC() }</td>
<td style="font-size:15px;">${acc.value.getBranch() }</td>
<td >${acc.value.getBalance() }</td>
<td>${acc.value.getStatus() }</td></tr>
	

</c:forEach>
</table></div>


</body>
</html>