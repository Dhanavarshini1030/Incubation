<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account</title>
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/Buttons.css">

</head>
<body>
<header><h5>ADD ACCOUNT</h5></header>
<h2>${Message}</h2>
<h2>${Error}</h2>
<form action="BankServlet" method="post" target="admin" id="one">
<div style="margin-left:50%; margin-bottom:10px; margin-top:20px;">
<button class="buttonClick" type="submit" value="accountEntered" name="button" form="one">Save</button>
<button class="buttonClick" type="reset" form="one">Reset</button>
</div>

<table>
<tr><td style="text-align:left; font-size:15px; opacity:0.8;">Customer Id</td>
<c:if test="${id!=null }">
<td><input type="text" name="id" maxlength="12" value="${id}"></td></c:if>

<c:if test="${info!=null }">
<td><select name="id"> <c:forEach items="${info}" var="user">
		  <option>${user.value.getCustomerID()} </option> </c:forEach>
</select></td></c:if></tr>

<tr><td style="font-size:15px; opacity:0.8;">Account Type: </td>
<td><select name="accType"><option value="SAVING">SAVING</option>
<option value="SALARY">SALARY</option><option value="PERSONAL">PERSONAL</option>
</select></td></tr>

<tr><td style="text-align:left; font-size:15px; opacity:0.8;">Account Number </td>
<td><input type="text" name="accNum" maxlength="15" required></td></tr>
<tr><td style="text-align:left; font-size:15px; opacity:0.8;">IFSC </td>
<td><input type="text" name="ifscCode" maxlength="15" required></td></tr>
<tr><td style="text-align:left; font-size:15px; opacity:0.8;">Branch </td>
<td><input type="text" name="branch" maxlength="30" required></td></tr>
<tr><td style="text-align:left; font-size:15px; opacity:0.8;">Balance </td>
<td><input type="text" name="balance" maxlength="10" required></td></tr>
<tr><td style="text-align:left; font-size:15px; opacity:0.8;">Status </td>
<td><input type="text" value="ACTIVE" readonly></td></tr></table>
</form>

</body>
</html>