import java.util.Scanner;

public class BarrenMoor extends InputReader {
	
	private static Scanner sc = new Scanner(System.in);
	
	public BarrenMoor()
	{
		System.out.println("Welcome to the adventure of the barren moor!");
		System.out.println("Your awaken to find yourself in a barren moor. Try \"look\"");
		resetPlayerPosition();
		makeMonster();
		makeQuickSand();
		makeHole();
		while (true)
		{
			String input = sc.next();
			try
			{
				if(input.equalsIgnoreCase("look"))
				{
					System.out.println("You may have had too much to drink last night - you can't remember how you got here.\n"
							+ "You can see that you're in a swamp but the mist prevents you from seeing more than a few feet in front of you :(\n"
							+ "You notice an unfamiliar, watch-like device on your wrist. The face has a single number on it, nothing more.\n"
							+ "Try typing \"north\", \"south\", \"east\" or \"west\" to move around.");
					break;
				}
				else
				{
					System.out.println("Please type \"look\" to begin the game.");
				}
			}
			catch(Exception e)
			{
				System.out.println("Please type \"look\" to begin the game.");
			}
		}
		takeInput();
	}
	
	
	

	


}