package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Types;

import runner.DatabasePOJO;
import runner.DatabaseProgram;

public class DatabaseTask 
{
	
	public String getTable()
	{
		String table="create table EMPLOYEE"+"(EMPLOYEE_ID integer(10) NOT NULL,"
	                   +"NAME varchar(40) NOT NULL,"+"MOBILE bigint(10) NOT NULL,"
				       +"EMAIL varchar(50) NOT NULL,"+"DEPARTMENT varchar(20) NOT NULL,"
	                   +"PRIMARY KEY (EMPLOYEE_ID))";
		return table;
	}
	public String setReferenceTable()
	{
		String query="create table EMPLOYEE_REFERENCE (IndexNO integer(5) NOT NULL,Name varchar(50) NOT NULL,"
				+ "Age integer(2) NOT NULL, Relationship varchar(20) NOT NULL, "
				+ "EMPLOYEE_ID integer(10) NOT NULL,PRIMARY KEY(IndexNO) , "
				+ "FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID))";
		return query;
	}
	
	public void getInsert(int id,String name,long mobile,String email,
			String department) throws SQLException
	{
		String query="insert into EMPLOYEE"+"(EMPLOYEE_ID,NAME,MOBILE,EMAIL,DEPARTMENT )"
						+"values(?,?,?,?,?)";
		try(Connection connect=DatabaseProgram.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setInt(1, id);
			stmnt.setString(2,name);
			stmnt.setLong(3, mobile);
			stmnt.setString(4,email);
			stmnt.setString(5,department);
			
			stmnt.execute();
		}
	}
	
	public void getInsertPojo(List<DatabasePOJO> list) throws SQLException
	{
		String query="insert into EMPLOYEE"+"(EMPLOYEE_ID,NAME,MOBILE,EMAIL,DEPARTMENT )"
				+"values(?,?,?,?,?)";
		try(Connection connect=DatabaseProgram.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			for(DatabasePOJO link:list)
			{
			stmnt.setInt(1, link.getEmployee_ID());
			stmnt.setString(2,link.getName());
			stmnt.setLong(3, link.getMobile());
			stmnt.setString(4,link.getEmail());
			stmnt.setString(5,link.getDepartment());
			stmnt.execute();
			}
		}
	}
	
	public void insertOnReferenceTable(int id, int index,String name, int age, String relation) throws SQLException
	{
		String query="insert into EMPLOYEE_REFERENCE"+"(IndexNO,Name,Age,Relationship,EMPLOYEE_ID)"
				+"values(?,?,?,?,?)";
		try(Connection connect=DatabaseProgram.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setInt(1, index);
			stmnt.setString(2, name);
			stmnt.setInt(3,age);
			stmnt.setString(4,relation);
			stmnt.setInt(5,id);
			stmnt.execute();
		}
	}
	
	public List<Object> getReferenceTable(int id) throws SQLException
	{
		List<Object> list=getList();
		String query="select * from EMPLOYEE_REFERENCE INNER JOIN EMPLOYEE ON "
				+ "EMPLOYEE_REFERENCE.EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID WHERE EMPLOYEE.EMPLOYEE_ID=?";
		try(Connection connect=DatabaseProgram.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{		
			stmnt.setInt(1,id);
			
			try(ResultSet result=stmnt.executeQuery();)
		    {
				while(result.next())
				{
					Map<Object,Object> map=new HashMap<Object,Object>();
					
					ResultSetMetaData res=result.getMetaData();
					int count=res.getColumnCount();
					for(int i=1;i<=count;i++)
					{
				
						int type=res.getColumnType(i);
						if(type==Types.INTEGER)
						{
							map.put(res.getColumnLabel(i),result.getInt(i));
						}
						else if(type==Types.VARCHAR)
						{
							map.put(res.getColumnLabel(i),result.getString(i));
						}
						else if(type==Types.BIGINT)
						{
							map.put(res.getColumnLabel(i),result.getLong(i));
						}			
					}
					list.add(map);
				}
		    }
		}	
		return list;
	}
	public List<Object> getOrderedReferenceTable() throws SQLException
	{
		List<Object> list=getList();
		String query="select * from EMPLOYEE_REFERENCE INNER JOIN EMPLOYEE ON "
				+ "EMPLOYEE_REFERENCE.EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID ORDER BY EMPLOYEE.EMPLOYEE_ID ";
		try(Connection connect=DatabaseProgram.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);
				ResultSet result=stmnt.executeQuery();)
		{		
				while(result.next())
				{
				 Map<Object,Object> map=new HashMap<Object,Object>();
				 map.put("IndexNo",result.getInt(1));
				 map.put("Name",result.getString(2));
				 map.put("Age",result.getInt(3));
				 map.put("Relation",result.getString(4));
				 map.put("Emp_ID",result.getInt(5));
				 
				 list.add(map);
				 }
		   }
		return list;
	}
	public List<Object> getRetrieve(int value) throws SQLException
	{
		List<Object> list=new ArrayList<Object>();
		String query="select * from EMPLOYEE where EMPLOYEE_ID=?";
		try( Connection connect=DatabaseProgram.getConnection();
		PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setInt(1,value);
			try(ResultSet result=stmnt.executeQuery();)
			{
				while(result.next())
				{
					Map<Object,Object> map=new HashMap<Object,Object>();
					
					ResultSetMetaData res=result.getMetaData();
					int count=res.getColumnCount();
					for(int i=1;i<=count;i++)
					{
				
						int type=res.getColumnType(i);
						if(type==Types.INTEGER)
						{
							map.put(res.getColumnLabel(i),result.getInt(i));
						}
						else if(type==Types.VARCHAR)
						{
							map.put(res.getColumnLabel(i),result.getString(i));
						}
						else if(type==Types.BIGINT)
						{
							map.put(res.getColumnLabel(i),result.getLong(i));
						}			
					}
					list.add(map);
				}
			}
		}
		return list;
	}
	
	public List<Object> getRetrievePojo(int value) throws SQLException
	{
		List<Object> list=getList();
		String query="select * from EMPLOYEE where EMPLOYEE_ID=?";
		try( Connection connect=DatabaseProgram.getConnection();
		PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setInt(1,value);
			try(ResultSet result=stmnt.executeQuery();)
			{
				while(result.next())
				{
					DatabasePOJO dbSetGet=new DatabasePOJO();
					dbSetGet.setEmployee_ID(result.getInt(1));
			     	dbSetGet.setName(result.getString(2));
			     	dbSetGet.setMobile(result.getLong(3));
			     	dbSetGet.setEmail(result.getString(4));
			     	dbSetGet.setDepartment(result.getString(5));
			     	list.add(dbSetGet);
				}
			}
		}
		return list;
	}
	
	
	public void getDelete(String field,String value) throws SQLException
	{
		String query="DELETE FROM EMPLOYEE "+"WHERE "+field+"=?";
		try(Connection connect=DatabaseProgram.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setString(1,value);
			stmnt.executeUpdate();
		}
	}
	
	public void getUpdate(String updateField,String updateValue,String realField,String realValue) throws SQLException
	{
		String query="update EMPLOYEE set "+updateField+" =? where "+realField+" = ?";
		try(Connection connect=DatabaseProgram.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setString(1,updateValue);
			stmnt.setString(2,realValue);
			stmnt.executeUpdate();
		}
	}
	public List<Object> getList()
	{
		List<Object> list=new ArrayList<Object>();
		return list;
	}
	
	public List<Object> getData() throws SQLException
	{
		List<Object> list=getList();
	    
		String query="select * from EMPLOYEE ";
		try(Connection connect=DatabaseProgram.getConnection();
		PreparedStatement stmnt=connect.prepareStatement(query);
		ResultSet result=stmnt.executeQuery();)
		{
				while(result.next())
				{
					Map<Object,Object> map=new HashMap<Object,Object>();
					
					ResultSetMetaData res=result.getMetaData();
					int count=res.getColumnCount();
					for(int i=1;i<=count;i++)
					{
				
						int type=res.getColumnType(i);
						if(type==Types.INTEGER)
						{
							map.put(res.getColumnLabel(i),result.getInt(i));
						}
						else if(type==Types.VARCHAR)
						{
							map.put(res.getColumnLabel(i),result.getString(i));
						}
						else if(type==Types.BIGINT)
						{
							map.put(res.getColumnLabel(i),result.getLong(i));
						}			
					}
					list.add(map);
				}
		}
		return list;
	}
	
	
	public List<Object> getOrderedData() throws SQLException
	{
		String query="select * from EMPLOYEE order by name desc";
		List<Object> list=getList();
		
		try(Connection connect=DatabaseProgram.getConnection();
		PreparedStatement stmnt=connect.prepareStatement(query);
		ResultSet result=stmnt.executeQuery();)
		{
			while(result.next())
			{
				Map<Object,Object> map=new HashMap<Object,Object>();
				
				ResultSetMetaData res=result.getMetaData();
				int count=res.getColumnCount();
				for(int i=1;i<=count;i++)
				{
			
					int type=res.getColumnType(i);
					if(type==Types.INTEGER)
					{
						map.put(res.getColumnLabel(i),result.getInt(i));
					}
					else if(type==Types.VARCHAR)
					{
						map.put(res.getColumnLabel(i),result.getString(i));
					}
					else if(type==Types.BIGINT)
					{
						map.put(res.getColumnLabel(i),result.getLong(i));
					}			
				}
				list.add(map);
			}
	    }
	    return list;
     }
	public void getExecute(String query)
	{
		try(Connection connect=DatabaseProgram.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			 stmnt.execute(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet getResultSet(String query) throws SQLException
	{
		try(Connection connect=DatabaseProgram.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);
				ResultSet result=stmnt.executeQuery(query);)
		{
			 return result;
		} 
	}
	
}
