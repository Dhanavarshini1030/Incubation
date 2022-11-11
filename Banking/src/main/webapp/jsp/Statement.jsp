<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statement</title>
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/Buttons.css">

</head>
<body>

	<h5>STATEMENTS</h5>
	<h3>${Error}</h3>
	<div class="container">
<form action="BankServlet" method="post" id="one">
<table  cellspacing="15">
<tr style="width:50%; height:50px;"> 
<td style="font-size:15px; opacity:0.7;">Account Number </td>
<td><select name="accountNum"> <c:forEach items="${account}" var="user">
		  <option value="${user.value.getAccountNumber() }" >${user.value.getAccountNumber() }</option> </c:forEach>
</select></td>
<td><button class="buttonClick" style="width:70%;" type="submit" value="Get Statement" name="button" form="one">Get Statement</button>		
</td>
</tr></table>




<c:forEach items="${transaction}" var="trans">
<c:if test="${trans==null}">
<h3>${Message}</h3>
</c:if>
<c:if test="${trans!=null}">
<div style="margin-top:20px;">
<table>
		
		<tr style="border:none;
	text-align:center;
	font-weight:500;
	padding:10px;
	font-size:17px;
	background-color:#aad2d5;">
			<td>Time</td>
			<td>Transaction ID</td>
			<td>Account Number</td>
			<td>Transaction Account</td>
			<td>Mode</td>
			<td>Amount</td>
			<td>Current Balance</td>
		</tr>
		<c:forEach items="${transaction}" var="trans">
		<c:forEach items="${trans.value}" var="tran">
		<tr>
			<td>${tran.getTime()}</td>
			<td>${tran.getTransactionID()}</td>
			<td>${tran.getAccountNumber()}</td>
			<td>${tran.getTransactionAccount()}</td>
			<td>${tran.getCreditDebit()}</td>
			<td>${tran.getProcessingAmount()}</td>
			<td>${tran.getCurrentBalance()}</td>
			
				</tr></c:forEach></c:forEach>
	</table></div>


</c:if></c:forEach>
 

</form></div>
</body>
</html>