//GameUI.java

import java.util.Arrays;
import java.util.Scanner;

public class GameUI {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfPlayer;
		String[] playerName;
		
		System.out.print("Number of Player: ");
		numOfPlayer = input.nextInt();
		playerName = new String[numOfPlayer];
		
		//Set Player Name
		for(int i = 0; i < numOfPlayer; i++) {
			System.out.print("Player " + (i + 1) + ": ");
			playerName[i] = input.next();
		}
		input.close();

		Game myGame = new Game(playerName);
		
		//while(!myGame.endGame()){
		System.out.println("Top on Pile: " + Arrays.toString(myGame.getPile(0).getFace()));
		
		System.out.println(myGame.getPlaying().getName() + " :");
		for(int j = 0; j < 5; j++) {
			System.out.println(Arrays.toString(myGame.getPlaying().getCard(j).getFace()));
		}
		// }

	}
}
