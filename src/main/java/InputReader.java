import java.util.Scanner;

public class InputReader extends Map{

	private static Scanner sc = new Scanner(System.in);
	
	public void startGame() {
		while(true) {
			if(isComplete()) {
				System.out.println("Congratulations, you found the treasure!");
				return;
			}
			else if (foundMonster()) {
				System.out.println("Oh no! You've encountered a monster!");
				if (hasSword()){
					System.out.println("Luckily you have a sword with you a promptly defeat the monster. You may continue on your journey.");
				} else {
					System.out.println("Without any way to defend yourself, you're eaten by the monster! Game over!");
					return;
				}
			}
			else if (fellInHole()) {
				System.out.println("You fell in a hole, luckily you didn't break anything in the fall.");
				if (hasRope()){
					System.out.println("Luckily you have that rope from earlier. You use typical game magic to use it to climb out of the hole. You may continue on your journey.");
				} else {
					System.out.println("Without any way to climb out of the hole, you eventually die. Game over!");
					return;
				}
			}
			else if (stoodInQuickSand()) {
				System.out.println("Oh dear! You wandered into some quicksand.");
				if (hasLifeJacket()){
					System.out.println("Luckily you have that life jacket, you can slowly and painfully swim out of the quick sand. You may continue on your journey.");
				} else {
					System.out.println("You sink into the quick sand, what a way to go. Game over!");
					return;
				}
			} else if (foundSword()){
				System.out.println("You find a sword lying on the floor in front of you. " +
						"Unsure of what lies ahead, you think it best to take this with you on your travels.");
			} else if (foundRope()) {
				System.out.println("You found a rope lying on the floor, this might come in handy so you take it with you.");
			} else if (foundLifeJacket()){
				System.out.println("You found a life jacket lying on the floor. Seeing as this might come in handy, you take it with you.");
			}
			
			String input = sc.next();
			
			try {
				if (input.equalsIgnoreCase("north") || input.equalsIgnoreCase("n")) {
					moveNorth();
				}
				else if (input.equalsIgnoreCase("south") || input.equalsIgnoreCase("s")) {
					moveSouth();
				}
				else if (input.equalsIgnoreCase("east") || input.equalsIgnoreCase("e")) {
					moveEast();
				}
				else if (input.equalsIgnoreCase("west") || input.equalsIgnoreCase("w")) {
					moveWest();
				}
				else if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("end") || input.equalsIgnoreCase("quit")) {
					System.out.println("Game over!");
					return;
				}
				else if (input.equalsIgnoreCase("help") || input.equalsIgnoreCase("wtf")) {
					System.out.println("You are stuck in a swamp and need to find the treasure. You can type \"North\", \"south\", \"east\" or \"west\" to move around.\n"
							+ "Be careful though, there may be monsters around");
				}
				else if (input.equalsIgnoreCase("reset") || input.equalsIgnoreCase("restart")) {
					System.out.println("You are back at the start, as if by magic!");
					resetPlayerPosition();
				}
				else {
					System.out.println("Please input a valid command. Try \"north\", \"south\", \"east\" or \"west\" to move around. You can also type \"help\" for more info.");
				}
			}
			catch (Exception e) {
				 System.out.println("Please input a valid command. Try \"north\", \"south\", \"east\" or \"west\" to move around. You can also type \"help\" for more info.");
			}
		}
		
	}
	
}
