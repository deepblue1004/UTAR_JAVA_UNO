import java.util.ArrayList;

//Game.java

public class Game {
	private Player[] fPlayer;
	private ArrayList<Card> fDeck;
	private ArrayList<Card> fPile;
	
	public Player getPlayer(int aIndex) {
		return fPlayer[aIndex];
	}
	
	public Card getDeck(int aIndex) {
		return fDeck.get(aIndex);
	}
	
	public Game(int aNumPlayer) {
		fDeck = createCard();
		suffleCard(fDeck);
	}
	
	public static ArrayList<Card> createCard() {
		ArrayList<Card> result = new ArrayList<Card>();
		Card tempCard;
		for(int i = 1; i <= 56; i++) {
			if(i <= 40) {
				tempCard = new Card((i - 1) / 10, i % 10);
			}
			else if(i <= 52) {
				tempCard = new ActionCard((i - 41) / 3, (i - 41) % 3 + 10);
			} 
			else {
				tempCard = new ActionCard(4, i % 2 + 13);
			}
			result.add(tempCard);
		}
		
		return result;
	}
	public static void suffleCard(ArrayList<Card> aDeck) {
		Card tempCard;
		
	}

}
