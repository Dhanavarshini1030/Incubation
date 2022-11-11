<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER MENU</title>
<link rel="stylesheet" href="css/Decorators.css">
<link rel="stylesheet" href="css/Buttons.css">
<script src='https://kit.fontawesome.com/a076d05399.js' ></script>

</head>
<body>
<h1 style="margin-left:150px;">PEOPLE BANK </h1>

<iframe name="source" src="jsp/CustomerMain.jsp" frameborder="none" height="550" width="80%" align="right" ></iframe>
<form action="BankServlet" method="post" target="source" id="one">
		<button class="buttonStyle"  type="submit" value="customerHome" name="button" form="one">HOME</button>
		<button class="buttonStyle"  type="submit" value="viewAccount" name="button" form="one">Account</button>
		<button class="buttonStyle"  type="submit" value="transfer" name="button" form="one">Transfers</button>
		<button class="buttonStyle"  type="submit" value="statement" name="button" form="one">Statements</button>
		
		</form>
		<div class="right">
		<div class="dropdown">
		<i class='fas fa-user-circle' style='font-size:36px;color:black'></i>
		<div class="content">
		<form action="BankServlet" method="post" target="source" id="one">
		<button class="buttonStyle" type="submit" value="viewProfile" name="button"  form="one">Profile</button>
		<button class="buttonStyle" type="submit" value="changePassword" name="button" form="one">Change Password</button></form>
		<form action="BankServlet" method="post" id="formtwo">
		<button  class="buttonStyle" title="Log Out" type="submit" value="logOut" name="button" form="formtwo">LogOut</button>
	</form></div></div></div>
	

	
</body>
</html>