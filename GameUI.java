//GameUI.java

public class GameUI {
	public static void main(String[] args) {
		Game myGame = new Game(4);
		for(int i = 0; i < 56; i++) {
			System.out.println(i + ": " + myGame.getDeck(i).getColor() + ", " + myGame.getDeck(i).getSymbol());
		}
	}
}
