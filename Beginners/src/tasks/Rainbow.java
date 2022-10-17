package tasks;

public enum Rainbow
{
	VIOLET(1),
	INDIGO(2),
	BLUE(3),
	GREEN(4),
	YELLOW(5),
	ORANGE(6),
	RED(7);
	private int value;

	private Rainbow(int i) 
	{
	   this.value=i;  	
	}
	public int getValue()
	{
		return this.value;
	}
}
