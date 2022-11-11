<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link rel="stylesheet" href="css/Design.css">
<link rel="stylesheet" href="css/Buttons.css">

</head>
<body>
<h5>CHANGE PASSWORD</h5>
<h2>${Message }</h2>
<div class="container">
<form method="post" id="one">


<table>
<tr><td style="text-align:right; font-size:15px; opacity:0.8;">Enter Old Password</td>
<td><input type="password" name="existingPassword" maxlength="10" required></td></tr>
<tr><td style="text-align:right; font-size:15px; opacity:0.8;">Enter New Password</td>
<td><input type="password" name="newPassword" maxlength="10" required></td></tr>
<tr><td style="text-align:right; font-size:15px; opacity:0.8;">Re-Enter New Password</td>
<td><input type="password" name="reEnterPassword" maxlength="10" required></td></tr></table>
<div style="margin-left:49%; margin-bottom:10px; margin-top:20px;">
<button class="buttonClick" type="submit" value="Change" name="button" form="one">Save</button>
<button class="buttonClick" type="reset" form="one">Reset</button>
</div>
</form>
</div>
</body>
</html>