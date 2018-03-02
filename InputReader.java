import java.util.Scanner;

public class InputReader extends Map{

	private static Scanner sc = new Scanner(System.in);
	
	public void takeInput()
	{
		while(true)
		{
			if(isComplete())
			{
				System.out.println("Congratulations, you found the treasure!");
				return;
			}
			else if (eatenByMonster())
			{
				System.out.println("Unfortunately you were eaten by a monster. Game over!");
			}
			else if (fellInHole())
			{
				System.out.println("You fell in a hole, unlucky. Game Over!");
			}
			else if (stuckInQuickSand())
			{
				System.out.println("Oh dear! You wandered into some quicksand. Game Over!");
			}
			
			String input = sc.next();
			
			try {
				if (input.equalsIgnoreCase("north") || input.equalsIgnoreCase("n"))
				{
					moveNorth();
				}
				else if (input.equalsIgnoreCase("south") || input.equalsIgnoreCase("s"))
				{
					moveSouth();
				}
				else if (input.equalsIgnoreCase("east") || input.equalsIgnoreCase("e"))
				{
					moveEast();
				}
				else if (input.equalsIgnoreCase("west") || input.equalsIgnoreCase("w"))
				{
					moveWest();
				}
				else if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("end") || input.equalsIgnoreCase("quit"))
				{
					System.out.println("Game over!");
					return;
				}
				else if (input.equalsIgnoreCase("help") || input.equalsIgnoreCase("wtf"))
				{
					System.out.println("You are stuck in a swamp and need to find the treasure. You can type \"North\", \"south\", \"east\" or \"west\" to move around.\n"
							+ "Be careful though, there may be monsters around");
				}
				else if (input.equalsIgnoreCase("reset") || input.equalsIgnoreCase("restart"))
				{
					System.out.println("You are back at the start, as if by magic!");
					resetPlayerPosition();
				}
				else
				{
					System.out.println("Please input a valid command. Try \"north\", \"south\", \"east\" or \"west\" to move around. You can also tpye \"help\" for more info.");
				}
			}
			catch (Exception e)
			{
				 System.out.println("Please input a valid command. Try \"north\", \"south\", \"east\" or \"west\" to move around. You can also tpye \"help\" for more info.");
			}
		}
		
	}
	
}
