import java.util.ArrayList;

//GameUI.java

public class GameUI {
	public static void main(String[] args) {
		ArrayList<String> playerName = new ArrayList<String>();
		for(int i = 0; i < 4; i++) {
			playerName.add("player" + i);
		}
		Game myGame = new Game(playerName.toArray());
		for(int i = 0; i < myGame.getDeckCount(); i++) {
			System.out.println(i + ": " + myGame.getDeck(i).getColor() + ", " + myGame.getDeck(i).getSymbol());
		}
	}
}
