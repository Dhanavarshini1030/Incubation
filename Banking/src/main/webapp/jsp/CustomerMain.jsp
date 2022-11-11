<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Main</title>
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/Buttons.css">
<style >
body
{
	background-color:#F6F6F2;	
	
}
	
td,tr
{
	border:none;
	text-align:center;
	padding:6px;
}

table
{
	border:none;
	border-collapse:collapse;
	width:70%;
}
h2
{
	color:Brown;
}
h1
{
	color:MidNightBlue;
}
</style>




</head>
<body>
<div class="container">

<table >
<div style="margin-top:20px; margin-left:71px;">Customer ID ${customerID}</h3></div>
<tr style="border:none;
	text-align:center;
	font-weight:500;
	height:60px;
	font-size:17px;
	background-color:#aad2d5;">
<td >ACCOUNTS</td>
<td >TYPE</td>
<td >BALANCE</td></tr>
<c:forEach items="${accountDetail}" var="account">
<tr><td Style="text-align:center;">${account.value.getAccountNumber()}</td>
<td Style="text-align:center;"> ${account.value.getAccountType()}</td>
<td Style="text-align:center;">${account.value.getBalance()}</td></tr></c:forEach>
</table></div>

</body>
</html>