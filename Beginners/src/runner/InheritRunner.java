package runner;

import java.util.InputMismatchException;
import java.util.Scanner;

import tasks.inherit.Car;
import tasks.inherit.Duck;
import tasks.inherit.ParrotMod;
import tasks.inherit.SCross;
import tasks.inherit.Swift;
import tasks.inherit.XUV;

public class InheritRunner 
{
	static Scanner scan=new Scanner(System.in);
	public int getNumSeats()
	{
		System.out.println("Enter Number of Seats :");
		int seats=scan.nextInt();
		return seats;
	}
	public int getNumBags()
	{
		System.out.println("Enter Number of AirBags :");
		int airBag=scan.nextInt();
		return airBag;
	}
	public String getModel()
	{
		System.out.println("Enter Name of Models:");
		String model=scan.next();
		return model;
	}
	public String getColor() 
	{
		System.out.println("Enter Name of Color:");
		String color=scan.next();
		return color;
	}
	public void printValues(Car obj)
	{
		if(obj instanceof Swift)
		{
			System.out.println("HATCH");
		}
		else if(obj instanceof XUV)
		{
			System.out.println("SUV");
		}
		else if(obj instanceof SCross)
		{
			System.out.println("Sedan");
		}
	}
	public void swiFunction(Swift obj)
	{
		System.out.println("hey Class!!");
	}
	public static void main(String[] args)
	{
		InheritRunner test=new InheritRunner();
		Swift swi=new Swift();
		SCross sc=new SCross();
		XUV xu=new XUV();
		//XUV xuv=new XUV("Hello"); 8) question insist that we have not create any overloaded constructor() on XUV.
		Car veh=new Car();
		Car objS=new SCross();
	    //Car objSwi=new Swift();
		ParrotMod parrot=new ParrotMod();
		Duck duck=new Duck();
		//BirdAbstract bird=new BirdAbstract();		It is impossible to create objects to Abstract classes.		
		int answer;
		   try
		   {
			   do
			   {
			     System.out.println("Enter your Choice(1 to 20):");
			     int option=scan.nextInt();
			     switch(option)
			     {
			      case 1:
			    	int seat1=test.getNumSeats();
					int bag1=test.getNumBags();
					String model1=test.getModel();
					String color1=test.getColor();
					swi.setSeats(seat1);
					swi.setAirBags(bag1);
					swi.setCarColor(color1);
					swi.setCarModel(model1);
					System.out.println("The number of Seats and AirBags are "+swi.getSeats()+" "+swi.getAirBags());
					System.out.println("The name of Model and Color are "+swi.getCarModel()+" "+swi.getCarColor());
					break;
			      case 2:
			    	int seat2=test.getNumSeats();
					int bag2=test.getNumBags();
					String model2=test.getModel();
					String color2=test.getColor();
					sc.setSeats(seat2);
					sc.setAirBags(bag2);
					sc.setCarColor(color2);
					sc.setCarModel(model2);
					System.out.println("The number of Seats and AirBags are "+sc.getSeats()+" "+sc.getAirBags());
					System.out.println("The name of Model and Color are "+sc.getCarModel()+" "+sc.getCarColor());
					break;
			      
			      case 3:
			    	  System.out.println("Enter the Year of Make:");
			    	  int year=scan.nextInt();
			    	  sc.setYear(year);
			    	  System.out.println("The year of make is "+sc.getYear());
			    	  System.out.println("Enter the Type:");
			    	  String type=scan.next();
			    	  sc.setCarType(type);
			    	  System.out.println("The year of make is "+sc.getType());
			    	  System.out.println("Enter the Engine Number: ");
			    	  String engNum =scan.next();
			    	  sc.setEngNum(engNum);
			    	  System.out.println("The year of make is "+sc.getEngNum());
			    	  break;
				      
			      case 4:
			    	 test.printValues(sc);
			    	 test.printValues(xu);
			    	 test.printValues(swi);
			    	break;
			      case 5:
			    	 test.swiFunction(swi);
			    	 //Swift objSwi = null;
					/*test.swiFunction(objSwi);6)ii)The method() just accept the Swift arguments.
			    	 While this one is car class's argument, so it doesn't work.*/
			    	 //test.swiFunction(sc);similar to (ii) this object belongs to SCross class.
			    	 break;
			      case 6:
			    	  System.out.println("Calling by SCross");
			    	  sc.maintainance();
			    	  System.out.println("Calling by SCross obj and assign it to car variable");
			    	  objS.maintainance();
			    	  System.out.println("Calling by Car");
			    	  veh.maintainance();
			    	  System.out.println("Calling by Swift");
			    	  swi.maintainance();
			    	  break;
			      case 8:
			    	  parrot.fly();
			    	  parrot.speak();
			    	  break;
			      case 9:
			    	  duck.fly();
			    	  duck.speak();
			    	  break;
			    	  																		
			      default:
			    	  System.out.println("Enter The Digits inbetween 1 to 10.");
			     }
			     System.out.println("Do you want to Continue?");
			     System.out.println("Kindly Enter yes(1) or No(2)");
			     answer=scan.nextInt();
			   }while(answer==1);
	}
    catch(InputMismatchException me)
    {
     System.out.println("Kindly Enter The Integer");
    }
	}
}


