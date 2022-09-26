package tasks.inherit;

public class SCross extends Car
{
	   int seats,airBags;
	   String model,color;
	  
	   public void setSeats(int seat)
		{
			seats=seat;
		}
		public void setAirBags(int abNum)
		{
			airBags=abNum;
		}
		public void setCarModel( String carModel)
		{
			model=carModel;
		}
		public void setCarColor( String carColor)
		{
			color=carColor;
		}
		public int getSeats()
		{
			return seats;
		}
		public int getAirBags()
		{
			return airBags;
		}
		public String getCarModel()
		{
			return model;
		}
		public String getCarColor()
		{
			return color;
		}
		public void maintainance()
		{
			System.out.println("Maruthi SCross under Maintainance.");
		}
		public void setYear(int year)
		{
			super.setYear(year);
		}
		public int getYear()
		{
			return super.getYear();
		}
		public void setEngNum(String engNum)
		{
			super.setEngNum(engNum);
		}
		public void setCarType( String carType)
		{
			super.setCarType(carType);
		}
		public String getEngNum()
		{
			return super.getEngNum();
		}
		public String getType()
		{
			return super.getType();
		}
	}



