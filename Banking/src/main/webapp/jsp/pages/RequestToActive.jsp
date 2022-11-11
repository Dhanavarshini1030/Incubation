<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request To Active</title>
<link rel="stylesheet" href="css/Division.css">
<link rel="stylesheet" href="css/ButtonDecorator.css">

</head>
<body>
<h2>REQUEST TO ACTIVE ACCOUNT</h2>
<form>
<table>
<tr>
<td><b>ACCOUNTS:</b></td>
<td><select name="accountNum"> <c:forEach items="${account}" var="user">
		  <option value="${user.value.getAccountNumber() }" >${user.value.getAccountNumber()} - ${user.value.getStatus()}</option> </c:forEach>
</select></td></tr>
<tr>
<td><button class="buttonClick" type="submit" value="Request" name="button" form="one">Request</button>
</td>		

</table>
</form>
</body>
</html>