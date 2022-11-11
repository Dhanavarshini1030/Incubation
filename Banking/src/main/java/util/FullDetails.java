package util;
//background-image: linear-gradient(to right top, #f6d4f0, #e4d8fa, #d1ddfd, #c2e1fa, #b9e3f1);	height:800px;	
public class FullDetails 
//background-image: linear-gradient(to right top, #77c7c7, #67c6cf, #58c4d7, #49c1e0, #3ebee9);	
/*.container
{background-color:#d1ffff;	#800080
	background-image: linear-gradient(to right top, #77c7c7, #67c6cf, #58c4d7, #49c1e0, #3ebee9);	
	
	position:absolute;
	right:0%;
	left:0%;
	top:70px;
	height:95%;
}*/
{
	//public void setCustomerDetails
}
/*public void addUserPassword(String role) throws SQLException
{
	String query="insert into User_Table(Password,Role) values(?,?)";
	try(Connection connect=DatabaseConnection.getConnection();
			PreparedStatement stmnt=connect.prepareStatement(query);)
	{
		 UserTableDetails user=new UserTableDetails();
		 stmnt.setString(1,user.toString());
		 stmnt.setString(2,role );
		 stmnt.execute();
	}
}*/

/*	public UserTableDetails  getUserDetail() throws SQLException
{
	String query="select * from User_Table";
	UserTableDetails users=new UserTableDetails();
	try(Connection connect=DatabaseConnection.getConnection();
			PreparedStatement stmnt=connect.prepareStatement(query);)
	{
		try(ResultSet result=stmnt.executeQuery();)
		{
		while(result.next())
		 {
			users.setCustomerID(result.getLong("CUSTOMER_ID"));
			users.setPassword(result.getString("Password"));
			users.setRole(result.getString("role"));
			
		 }
		}
	}
	return users;
}*/


/*public String getRole(long id,String table,String column) throws SQLException
{
	String query="select Role from "+table+" where "+column+"=?";
	String role=null;
	try(Connection connect=DatabaseConnection.getConnection();
			PreparedStatement stmnt=connect.prepareStatement(query);)
	{
		stmnt.setLong(1,id);
		try(ResultSet result=stmnt.executeQuery();)
		{
			
			while(result.next())
			{
				role=result.getString("Role");
			}
		}
	}
	return role;
}*/

/*<form action="BankServlet" method="post">
<input type="submit" value="Log Out" name="button">
</form>
<table >
<tr><td><input type="submit" value="Customer Home" name="button" ></td></tr>
<tr><td><input type="submit" value="View Profile" name="button" ></td></tr>
<tr><td><input type="submit" value="View Account" name="button" ></td></tr>
<tr><td><input type="submit" value="Transfer" name="button" ></td></tr>
<tr><td><input type="submit" value="Withdraw" name="button" ></td></tr>
<tr><td><input type="submit" value="Deposit" name="button" ></td></tr>
<tr><td><input type="submit" value="Statement" name="button" ></td></tr>
<tr><td><input type="submit" value="Change Password" name="button" ></td></tr>
<tr><td><input type="submit" value="Request To Active" name="button" ></td></tr>
</table>*/


/*<h1 style="text-align:center; color:rgb(31, 31, 122);
 text-decoration-line:underline; text-decoration-color:gray; text-decoration-style:normal; 
 font-size:42px;"> PEOPLE BANK </h1>

<title>LOGIN PAGE</title>
*/


/*<button class="buttonStyle disabled" type="submit" value="withdraw" name="button" form="one">Withdraw</button>
		<button class="buttonStyle disabled" type="submit" value="deposit" name="button"  form="one">Deposit</button>
		*/



