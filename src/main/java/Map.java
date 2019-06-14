
public abstract class Map {

	private int xPosition = 0;
	private int yPosition = 0;
	
	private int treasureX = 2 * getScaledRandomNumber();
	private int treasureY = 2 * getScaledRandomNumber();
	
	private int monsterXCoord;
	private int monsterYCoord;

	private int swordXCoord;
	private int swordYCoord;
	private boolean playerHasSword = false;
	
	private int holeXCoord;
	private int holeYCoord;

	private int ropeXCoord;
	private int ropeYCoord;
	private boolean playerHasRope = false;
	
	private int quickSandXCoord;
	private int quickSandYCoord;

	private int lifeJacketXCoord;
	private int lifeJacketYCoord;
	private boolean playerHasLifeJacket = false;

	public void spawn(){
		makeMonster();
		makeQuickSand();
		makeHole();
		makeSword();
		makeLifeJacket();
		makeRope();
	}

	private int getScaledRandomNumber(){
		return (int)(2 + Math.round(5 * Math.random()));
	}

	private void makeSword(){
		swordXCoord = getScaledRandomNumber();
		swordYCoord = getScaledRandomNumber();
	}

	public boolean foundSword(){
		if (swordXCoord==xPosition && swordYCoord==yPosition){
			playerHasSword = true;
			return true;
		} else {
			return false;
		}
	}

	public boolean hasSword(){
		return playerHasSword;
	}

	private void makeRope(){
		ropeXCoord = getScaledRandomNumber();
		ropeYCoord = getScaledRandomNumber();
	}

	public boolean foundRope(){
		if (ropeXCoord==xPosition && ropeYCoord==yPosition){
			playerHasRope = true;
			return true;
		} else {
			return false;
		}
	}

	public boolean hasRope(){
		return playerHasRope;
	}

	private void makeLifeJacket(){
		lifeJacketXCoord = getScaledRandomNumber();
		lifeJacketYCoord = getScaledRandomNumber();
	}

	public boolean foundLifeJacket(){
		if (lifeJacketXCoord==xPosition && lifeJacketYCoord==yPosition){
			playerHasLifeJacket = true;
			return true;
		} else {
			return false;
		}
	}

	public boolean hasLifeJacket(){
		return playerHasLifeJacket;
	}
	
	private void makeMonster() {
		monsterXCoord = getScaledRandomNumber();
		monsterYCoord = getScaledRandomNumber();
		while (monsterXCoord == treasureX && monsterYCoord == treasureY) {
			makeMonster();
		}
	}
	
	public boolean foundMonster()	{
		if (xPosition == monsterXCoord && yPosition == monsterYCoord) {
			return true;
		} else {
			return false;
		}
	}
	
	private void makeHole() {
		holeXCoord = getScaledRandomNumber();
		holeYCoord = getScaledRandomNumber();
		if(holeXCoord == treasureX && holeYCoord == treasureY) {
			makeHole();
		}
	}
	
	public boolean fellInHole()	{
		if (xPosition == holeXCoord && yPosition == holeYCoord)	{
			return true;
		} else
		{
			return false;
		}
	}
	
	private void makeQuickSand()	{

		quickSandXCoord = getScaledRandomNumber();
		quickSandYCoord = getScaledRandomNumber();
		if(quickSandXCoord == treasureX && quickSandYCoord == treasureY) {
			makeHole();
		}
	}
	
	public boolean stoodInQuickSand()
	{
		if (xPosition == quickSandXCoord && yPosition == quickSandYCoord) {
			return true;
		} else {
			return false;
		}
	}
	
	public void resetPlayerPosition() {
		xPosition = 0;
		yPosition = 0;
	}
	
	public void printDialReading() {
		int horizontalDifference = treasureX - xPosition;
		int verticalDifference = treasureY - yPosition;
		double distance = Math.sqrt(horizontalDifference*horizontalDifference+verticalDifference*verticalDifference);
		String reading = distance+"";
		try {
			reading = reading.substring(0, reading.indexOf(".") + 3);
		} catch (Exception e){}
		System.out.println("The dial reads '" + reading + "m'");
	}
	
	public boolean isComplete() {
		if( xPosition == treasureX && yPosition == treasureY) {
			return true;
		} else {
			return false;
		}
	}
	
	public void moveNorth() {
		yPosition += 1;
		printDialReading();
	}
	public void moveSouth() {
		yPosition -= 1;
		printDialReading();
	}
	public void moveEast() {
		xPosition += 1;
		printDialReading();
	}
	public void moveWest() {
		xPosition -= 1;
		printDialReading();
	}
	
	
}
