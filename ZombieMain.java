import java.util.Scanner;

// NOTE TO SELF - See line 93 to finish the validation
public class ZombieMain {
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args)  {
		String playSelect;
		Game g = new Game();
		
		do {
		System.out.println("June 20th, 2025: The bloodborne Drena virus epidemic "
				+ "\n has spead like wild fire, and it has reached your area in Phoenix, Arizona. "
				+ "\n Once infected, it will control your brain,"
				+ "\n making you a zombie."
				+ "\n \n The CDC says that a cure will be complete in 30 days. You have fled to your empty house in the countryside."
				+ "\n Can you survive?"
				);
		System.out.print("Begin Game? enter 'y' to play: ");
		playSelect = keyboard.nextLine().toLowerCase();
		if (playSelect.equals("y")) {
			// plays game, asks to play Again at the end.
			g.play();
			System.out.print("Want to play again? Press 'y' to play again: ");
			playSelect = keyboard.nextLine().toLowerCase();
		}
		}
		while (playSelect.equals("y"));
		System.out.println("Ending Game....");
		keyboard.close();
		
	
	
	} //end Main method
	
	


} //end ZombieMain
