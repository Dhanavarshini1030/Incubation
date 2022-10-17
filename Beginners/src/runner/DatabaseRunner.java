package runner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import tasks.DatabaseTask;

public class DatabaseRunner
{
	Scanner scan=new Scanner(System.in);
	public static void main(String[] args)
	{
		DatabaseRunner runner=new DatabaseRunner();
		DatabaseTask task=new DatabaseTask();
		DatabasePOJO dbSetGet=new DatabasePOJO();
		System.out.println("Enter The Option: ");
		int option=runner.scan.nextInt();
		try
		{
		 switch(option)
		 {
		  case 1:
			  String sql=task.getTable();
			  task.getExecute(sql);
			  break;
		  case 2:
			  System.out.println("Enter the number to be insert data:");
			  int count=runner.scan.nextInt();
			  for(int i=0;i<count;i++)
			  {
			    System.out.println("Enter the values ");
			    System.out.println("Emp_id ,name,mobile,email,department respectively");
			    int id=runner.scan.nextInt();
			    String name=runner.scan.next();
			    long mobile=runner.scan.nextLong();
			    String email=runner.scan.next();
			    String department=runner.scan.next();
			    task.getInsert(id, name, mobile, email, department);
			  }
			  break;
		  case 3:
			  System.out.println("Enter Employee_ID: ");
			  int value=runner.scan.nextInt();
			  
			  List<Object> list=task.getRetrieve(value);
			  
			  for(int i=0;i<(list.size());i++)
			  {
			    System.out.println(list.get(i));
			  }
			  break;
		  case 4:
			  System.out.println("Enter Number of Updates: ");
			  int num=runner.scan.nextInt();
			  System.out.println("Enter Exist field in Table:(UPPERCASE) ");
			  String fieldExist=runner.scan.next();
			  System.out.println("Enter Exist Value of the Field: ");
			  String valueExist=runner.scan.next();
			  for(int i=0;i<num;i++)
			  {
			  System.out.println("Enter Field to be Updated:(UPPERCASE) ");
			  String fieldUpdate=runner.scan.next();
			  System.out.println("Enter Value of the Field: ");
			  String fieldEmp=runner.scan.next();
			  task.getUpdate(fieldUpdate, fieldEmp, fieldExist, valueExist);
			  }
			  break;
		  case 5:
			 List<Object> listRow=task.getData();
			 for(int i=0;i<(listRow.size());i++)
			 {
				 System.out.println(listRow.get(i));
			 }
			 break;
			
		  case 6:
			  List<Object> listOrder=task.getOrderedData();
			  
			  for(int i=0;i<(listOrder.size());i++)
			   {
			       System.out.println(listOrder.get(i));
			   }
			  break;
			  
		  case 7:
			  System.out.println("Enter Field to be Deleted:(UPPERCASE) ");
			  String fieldDelete=runner.scan.next();
			  System.out.println("Enter value of the Field: ");
			  String valueDelete=runner.scan.next();
			  task.getDelete(fieldDelete,valueDelete);
			  List<Object> listDelete=task.getData();
			  for(int i=0;i<(listDelete.size());i++)
				 {
					 System.out.println(listDelete.get(i));
				 }
			  break;
		  case 8:
			  System.out.println("Enter the number to be insert data:");
			  count=runner.scan.nextInt();
			  List<DatabasePOJO> listPojo=new ArrayList<DatabasePOJO>();
			  for(int i=0;i<count;i++)
			  {
			    System.out.println("Enter the values ");
			    System.out.println("Emp_id ,name,mobile,email,department respectively");
			    int id=runner.scan.nextInt();
			    dbSetGet.setEmployee_ID(id);
			    String name=runner.scan.next();
			    dbSetGet.setName(name);
			    long mobile=runner.scan.nextLong();
			    dbSetGet.setMobile(mobile);
			    String email=runner.scan.next();
			    dbSetGet.setEmail(email);
			    String department=runner.scan.next();
			    dbSetGet.setDepartment(department);
			    listPojo.add(dbSetGet);
			    task.getInsertPojo(listPojo);
			   }
			  List<Object> listPojo1=task.getRetrievePojo(4);
			  for(int i=0;i<(listPojo1.size());i++)
			  {
				  System.out.println(listPojo1.get(i));
			  }
			  break;
		  case 9:
			  String query=task.setReferenceTable();
			  task.getExecute(query);
			  break;
		  case 10:
			  System.out.println("Enter the number to be insert data:");
			  count=runner.scan.nextInt();
			  for(int i=0;i<count;i++)
			  {
			    System.out.println("Enter the values ");
			    System.out.println("Emp_id ,index,name,age,relation respectively");
			    int id=runner.scan.nextInt();
			    int index=runner.scan.nextInt();
			    String name=runner.scan.next();
			    int age=runner.scan.nextInt();
			    String relation=runner.scan.next();
			    task.insertOnReferenceTable(id, index, name, age, relation);
			  }
			  break;
		  case 11:
			  System.out.println("Enter The Employee ID to view their Details:");
			  int emp_id=runner.scan.nextInt();
			  List<Object> listReference=task.getReferenceTable(emp_id);
			  for(int i=0;i<(listReference.size());i++)
				 {
				    System.out.println(listReference.get(i));
				 }
			  break;
		  case 12:
			  List<Object> listOrderReference=task.getOrderedReferenceTable();
			  for(int i=0;i<(listOrderReference.size());i++)
				 {
				    System.out.println(listOrderReference.get(i));
				 }
			  break;
		  
		 
		 
		 
		 }
		}catch(InputMismatchException in)
		{
			System.out.println("INVALID STATEMENT");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}	
