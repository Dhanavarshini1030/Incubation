<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction</title>
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/Buttons.css">

</head>
<body>
<h5>TRANSFERS</h5>
<h3>${Error}</h3>
<h3>${message }</h3>
<div class="container">
<form  method="post" id="one">
<table>
<tr><td style="font-size:15px; opacity:0.8;">Process</td>
<td><input type="text" value="Debit" readonly></td></tr>
<tr>
<td style=" font-size:15px; opacity:0.8;">Account</td>
<td><select name="accNum"> <c:forEach items="${account}" var="user">
		  <option value="${user.value.getAccountNumber() }">${user.value.getAccountNumber()} - ${user.value.getBalance()} </option> </c:forEach>
</select></td></tr>
<tr><td style="font-size:15px; opacity:0.8;">Transaction Amount</td>
<td><input type="text" name="transAmount" maxlength="10" required></td></tr>
<tr><td style=" font-size:15px; opacity:0.8;">Transaction Account</td>
<td><input type="text" name="transAccount" maxlength="15" required></td></tr></table>
<input type="hidden" name="Debit" value="Debit">
<div style="margin-top:20px; margin-left:50%;">

<button class="buttonClick" type="submit" value="finishTransaction" name="button" form="one">Submit</button>
<button class="buttonClick" type="reset">Reset</button>
		
</div>


</form>
</div>

</body>
</html>