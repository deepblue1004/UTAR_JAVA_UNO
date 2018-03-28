//GameUI.java

import java.util.Scanner;

public class GameUI {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfPlayer;
		String[] playerName;

		System.out.print("Number of Player: ");
		numOfPlayer = input.nextInt();
		playerName = new String[numOfPlayer];

		// Set Player Name
		for (int i = 0; i < numOfPlayer; i++) {
			System.out.print("Player " + (i + 1) + ": ");
			playerName[i] = input.next();
		}

		Game myGame = new Game(playerName);

		// while(!myGame.endGame()){
		System.out.println("Top on Pile: " + myGame.getPile(0).toString());

		System.out.println(myGame.getPlaying().getName() + " :");
		for (Card c : myGame.getPlaying().getCard()) {
			System.out.println(c.toString());
		}

		System.out.print("\nSelect an action:\n"
				+ "1. Discard a card.\n"
				+ "2. Darw a card.\n"
				+ "Selection: ");
		input.nextInt();
		// }
		input.close();
	}
}
