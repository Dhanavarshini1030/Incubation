<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/Division.css">

<link rel="stylesheet" href="css/ButtonDecorator.css">

<style>
body
{
background-image: linear-gradient(
  45deg,
  hsl(184deg 75% 80%) 0%,
  hsl(195deg 77% 79%) 11%,
  hsl(206deg 78% 79%) 22%,
  hsl(217deg 80% 78%) 33%,
  hsl(228deg 82% 78%) 44%,
  hsl(239deg 83% 77%) 56%,
  hsl(250deg 85% 77%) 67%,
  hsl(261deg 86% 76%) 78%,
  hsl(272deg 87% 76%) 89%,
  hsl(283deg 89% 75%) 100%);
  width:75%;
  height:600px;
}
div.form
{
background-image: linear-gradient(to right bottom, #dde6eb, #dbebf1, #d9f1f4, #d7f6f6, #d7fbf5);	width:30%;
	padding:30px;
	height:290px;
	position:absolute;
	left:32%;
	top:20%;
	border-radius:5px;
	border-left:8px solid aqua;
}

.footer
{
	background-color:aqua;
	color:black;
	text-align:center;
	
	right:0%;
	left:0%;
	bottom:0%;
	position:absolute;
	height:25px;
}
.error
{
	background-color:red;
	color:black;
	top:150px;
	width:50%;
	height:10%;
	border-radius:5px;
	
}
input[type=text],[type=password]
{
	width:80%;
	padding:10px;
	border:hidden;
	background-color:Snow;
	color:black;
	border-bottom:1px solid grey;
	
}
#inputStyle
{
	width:40%;
	padding:6px 10px;
background-image: linear-gradient(to right bottom, #dde6eb, #dbebf1, #d9f1f4, #d7f6f6, #d7fbf5);	heigth:10px;
	font-family: "Times New Roman", Times, serif;
	font-size:14px;
	border-radius:10px;
	border:outset;
	
}
#inputStyle:hover
{
	background-image:linear-gradient(
	  40deg,
  	hsl(220deg 93% 59%) 0%,
  	hsl(210deg 77% 59%) 20%,
  	hsl(196deg 61% 58%) 40%,
  	hsl(176deg 49% 58%) 60%,
  	hsl(155deg 63% 64%) 80%,
  	hsl(136deg 81% 69%) 100%
	);
	cursor:pointer;	
	color:black;
	font-family: Arial, Helvetica, sans-serif;
}


</style>
</head>
<body>

<center>
<div class="header" Style="position:absolute; top:0%; right:0%;left:0%;height:100px;">
<h1 > PEOPLE BANK </h1>

<form action="../BankServlet" method="post" >

<h2 color="red">${error}</h2>
<c:remove var="error" scope="session"></c:remove></div>
<div class="form">

<h2 style="color:blue;">Welcome Back!</h2>
<h3 style="font-size:15px; Font-family:Apple Chancery, cursive; text-align:left;">To keep Connecting with us, Please Login with your Personal Info.</h3>

<h2 style="color:Purple;">Login</h2>
 <div style="margin-top:20px;">
 <input type="text" name="customerID" maxlength="10" pattern="[0-9]{4,5}" title="Should contain Integers only" placeholder="User Id" required></div>
 <div style="margin-top:20px;">
<input type="password" name="password" maxlength="12" placeholder="Password" required></div>
<div style="margin-top:20px;">
<input type="submit" name="button" value="login" id="inputStyle" >
<input type="reset" id="inputStyle"></div></div>
 


</form>

</center>
<div class="footer"><em>Have a Great Day</em></div>
</body>
</html>