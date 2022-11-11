<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style>
body
{
	background-color:azure;
}
td
{
	border:2px dashed Black;
	padding:10px;
	font:20px verdana;
}

</style>

</head>
<body cellspacing="10" border="10" >
<center>
<h1 align="center">Bank </h1>
<form action="../BankServlet" method="post">
<table cellpadding="20" cellspacing="10">
<td><input type="submit" name="button" value="Admin" >
 <input type="submit" name="button" value="Customer">
 </td>



</table>

</form>
</center>
<td>${trans.value.accountNumber()}</td>
			<td>${trans.value.transactionAccount()}</td>
			<td>${trans.value.creditDebit()}</td>
			<td>${trans.value.processingAmount()}</td>
			<td>${trans.value.currentBalance()}</td>
	
</body>
</html>