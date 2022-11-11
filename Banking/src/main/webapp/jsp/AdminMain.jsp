<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminMain</title>

<style>
body
{
	background-color:#F6F6F2;
}
td,tr
{
	text-align:left;
	padding:6px;
}
th
{
	text-align:center;
	padding:10px;
	color:Salmon;
}
table
{
	border-collapse:collapse;
	width:50%;
}
h2
{
	color:Salmon;
}
h1
{
	color:MidNightBlue;
}
</style>
</head>
<body>
<div class="header">
	<h4>Your Pending Requests are here..</h4>
	<form >	<table>
			<tr>
				<th>CHOICE</th>
				<th>ACCOUNT NUMBER</th>
				<th>REQUEST</th>
				<th>AMOUNT</th>
				<th>TIME</th>
			<tr>
				<td><input type="checkbox" name="acc1"></td>
				<td>11004545</td>
				<td>Withdraw</td>
				<td>20000</td>
				<td>1245789632</td>
			</tr>

			<tr>
				<td><input type="checkbox" name="acc1"></td>
				<td>11004546</td>
				<td>Withdraw</td>
				<td>10000</td>
				<td>1245784587</td>
			</tr>
			<tr>
				<td><input type="button" value="Approve"></td>
				<td><input type="button" value="Reject"></td>
			</tr>
		</table>

	</form>


</body>
</html>