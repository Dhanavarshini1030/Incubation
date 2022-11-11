<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Menu</title>
<link rel="stylesheet" href="css/Buttons.css">
<link rel="Stylesheet" href="css/Decorators.css">
<script src='https://kit.fontawesome.com/a076d05399.js' ></script>

</head>
<body>
<h1 style="left:40px; font-family:'Sofia'; font-variant: small-caps;">PEOPLE BANK </h1>
	<iframe name="admin" src="jsp/AdminMain.jsp" frameborder="0" height="600" width="960"
		align="right"></iframe>

	<form action="BankServlet" method="post" target="admin" id="one">
		<button class="buttonStyle" type="submit" value="adminHome" name="button" form="one">HOME</button>
		<button class="buttonStyle" type="submit" value="viewCustomer" name="button"  form="one">Customers</button>
		<button class="buttonStyle"  type="submit" value="viewAccounts" name="button" form="one">Accounts</button>
		</form>
		<div class="right">
		<div class="dropdown">
		<i class='fas fa-user-circle' style='font-size:36px;color:black'></i>
		<div class="content">
		<form action="BankServlet" method="post" target="admin" id="one">
		<button class="menu" type="submit" value="changePassword" name="button" form="one">Change Password</button>
		</form>
		<form action="BankServlet" method="post" id="formtwo">
		<button  class="menu" type="submit" value="logOut" name="button" form="formtwo">LogOut</button>
	</form></div></div></div>
	
		
</body>
</html>