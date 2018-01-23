import java.util.ArrayList;

//GameLogic.java

public class GameLogic {
	private Player[] fPlayer;
	private ArrayList<Card> fDeck;
	private ArrayList<Card> fPile;
	
	public Player getPlayer(int aIndex) {
		return fPlayer[aIndex];
	}
	
	public GameLogic(int aNumPlayer) {
		suffleCard(fDeck);
	}
	
	public static ArrayList<Card> createCard() {
		ArrayList<Card> result = new ArrayList<Card>();
		Card tempCard;
		for(int i = 0; i < 56; i++) {
			tempCard = new Card();
			result.add(tempCard);
		}
		
		return result;
	}
	public static void suffleCard(ArrayList<Card> aDeck) {
		Card tempCard;
		
	}

}
