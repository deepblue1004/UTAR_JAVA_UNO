import java.util.ArrayList;
import java.util.Scanner;

//GameUI.java

public class GameUI {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfPlayer;
		String[] playerName;
		
		System.out.print("Number of Player: ");
		numOfPlayer = input.nextInt();
		playerName = new String[numOfPlayer];
		
		for(int i = 0; i < numOfPlayer; i++) {
			System.out.print("Player " + (i + 1) + ": ");
			playerName[i] = input.next();
		}
		
		Game myGame = new Game(playerName);
		for(int i = 0; i < myGame.getDeckCount(); i++) {
			System.out.println(i + ": " + myGame.getDeck(i).getColor() + ", " + myGame.getDeck(i).getSymbol());
		}
		
		for(int i = 0; i < myGame.getPlayerCount(); i++) {
			System.out.println(myGame.getPlayer(i).getName() + " :");
			for(int j = 0; j < 5; j++) {
				System.out.println(myGame.getPlayer(i).getCard(j).getColor() + ", " +
									myGame.getPlayer(i).getCard(j).getSymbol());
			}
			System.out.println();
		}
	}
}
