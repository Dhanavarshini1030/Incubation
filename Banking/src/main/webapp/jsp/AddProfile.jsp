<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Profile</title>
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/Buttons.css">

</head>
<body>
<h5>ADD CUSTOMER DETAILS</h5>
<h3>${Message}</h3>
<form action="BankServlet" method="post" target="admin" id="one">
<div style="margin-left:50%; margin-bottom:10px; margin-top:20px;">

<button class="buttonClick" type="submit" value="addDetails" name="button" form="one">Save</button>		
<button class="buttonClick" type="reset" form="one">Reset</button>
</div>
<table>
<tr>
<td style="text-align:left; font-size:15px; opacity:0.8; ">Name</td>
<td><input type="text" name="name" maxlength="50" required></td></tr>
<tr>
<td style="text-align:left; font-size:15px; opacity:0.8;">Aadhar Number</td>
<td><input type="text" name="aadharNumber" maxlength="12" required></td></tr>
<tr>
<td style="text-align:left; font-size:15px; opacity:0.8;"  >PAN Number</td>
<td><input type="text" name="panNum" maxlength="12" required></td></tr>
<tr>
<td style="text-align:left; font-size:15px; opacity:0.8;" >Email</td>
<td><input type="email" name="email" maxlength="50" required></td></tr>
<tr>
<td style="text-align:left; font-size:15px; opacity:0.8;">Mobile Number</td>
<td><input type="text" name="mobileNumber" maxlength="10" pattern="[7-9]{1}[0-9]{9}" title="Should contain 10 numbers only" required></td></tr>
<tr>
<td style="text-align:left; font-size:15px; opacity:0.8;">Date Of Birth</td>
<td><input type="date" name="dob" maxlength="20" required></td></tr>

<tr>
<td style="text-align:left; font-size:15px; opacity:0.8;">Address</td>
<td><input type="text" name="address" maxlength="50" required></td></tr></table>


</form>


</body>
</html>