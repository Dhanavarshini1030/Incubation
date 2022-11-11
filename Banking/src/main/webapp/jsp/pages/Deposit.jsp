
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
<link rel="stylesheet" href="css/Division.css">
<link rel="stylesheet" href="css/ButtonDecorator.css">

</head>
<body>
<h2>DEPOSIT</h2>
<form id="one">
<table>
<tr><td><b>DEPOSIT </b></td><td></td>
<input type="hidden" name="customerID" value="id">
<tr>
<td><b>ACCOUNTS:</b></td>
<td><select> <c:forEach items="${account}" var="user">
		  <option value="${user.value.getAccountNumber() }">${user.value.getAccountNumber() }</option> </c:forEach>
</select></td></tr>
<tr><td><b>AMOUNT: </b></td>
<td><input type="text" name="amount" maxlength="10" required></td></tr>
<tr>
<td><button class="buttonClick" type="submit"  name="button" form="one">Submit</button>
</td>		

<td><button class="buttonClick" type="reset">Reset</button>
</td>		
</table>
</form>
</body>
</html>