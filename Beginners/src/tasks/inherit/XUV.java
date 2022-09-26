package tasks.inherit;

public class XUV extends Car
{
	   int seats,airBags;
	   String model,color;
	   public XUV()
	   {
		   super("hello");
	   }
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
}



