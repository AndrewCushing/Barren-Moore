
public abstract class Map {

	private int horizontalPosition = 0;
	private int verticalPosition = 0;
	
	private int horizontalInterest = (int)(10 + Math.round(10 * Math.random()));
	private int verticalInterest = (int)(10 + Math.round(10 * Math.random()));
	
	private int monsterXCoord;
	private int monsterYCoord;
	
	private int holeXCoord;
	private int holeYCoord;
	
	private int quickSandXCoord;
	private int quickSandYCoord;
	
	public void makeMonster()
	{
		monsterXCoord = (int)(5 + Math.round(10 * Math.random()));
		monsterYCoord = (int)(5 + Math.round(10 * Math.random()));
		
		if(monsterXCoord == horizontalInterest && monsterYCoord == verticalInterest)
		{
			makeMonster();
		}
	}
	
	public boolean eatenByMonster()
	{
		if (horizontalPosition == monsterXCoord && verticalPosition == monsterYCoord)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void makeHole()
	{

		holeXCoord = (int)(5 + Math.round(10 * Math.random()));
		holeYCoord = (int)(5 + Math.round(10 * Math.random()));
		if(holeXCoord == horizontalInterest && holeYCoord == verticalInterest)
		{
			makeHole();
		}
	}
	
	public boolean fellInHole()
	{
		if (horizontalPosition == holeXCoord && verticalPosition == holeYCoord)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void makeQuickSand()
	{

		quickSandXCoord = (int)(5 + Math.round(10 * Math.random()));
		quickSandYCoord = (int)(5 + Math.round(10 * Math.random()));
		if(quickSandXCoord == horizontalInterest && quickSandYCoord == verticalInterest)
		{
			makeHole();
		}
	}
	
	public boolean stuckInQuickSand()
	{
		if (horizontalPosition == quickSandXCoord && verticalPosition == quickSandYCoord)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void resetPlayerPosition()
	{
		horizontalPosition = 0;
		verticalPosition = 0;
	}
	
	public double getDialReading()
	{
		double reading = Math.sqrt(horizontalPosition*horizontalPosition+verticalPosition*verticalPosition);
		return reading;
	}
	
	public void printDialReading()
	{
		int horizontalDifference = horizontalInterest - horizontalPosition;
		int verticalDifference = verticalInterest - verticalPosition;
		double reading = Math.sqrt(horizontalDifference*horizontalDifference+verticalDifference*verticalDifference);
		System.out.println("The dial reads '" + reading + "m'");
	}
	
	public boolean isComplete()
	{
		if( horizontalPosition == horizontalInterest && verticalPosition == verticalInterest)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void moveNorth()
	{
		verticalPosition += 1;
		printDialReading();
	}
	public void moveSouth()
	{
		verticalPosition -= 1;
		printDialReading();
	}
	public void moveEast()
	{
		horizontalPosition += 1;
		printDialReading();
	}
	public void moveWest()
	{
		horizontalPosition -= 1;
		printDialReading();
	}
	
	
}
