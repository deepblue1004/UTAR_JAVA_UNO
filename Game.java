import java.util.ArrayList;

//Game.java

public class Game {
	private Player[] fPlayer;
	private ArrayList<Card> fDeck;
	private ArrayList<Card> fPile;
	
	//Constructor
	public Game(Object[] aPlayerName) {
		fPlayer = new Player[aPlayerName.length];
		fDeck = createCard();
		shuffleCard(fDeck);
		distributeCard(fDeck, fPlayer, aPlayerName);
	}
	
	public Player getPlayer(int aIndex) {
		return fPlayer[aIndex];
	}
	
	public Card getDeck(int aIndex) {
		return fDeck.get(aIndex);
	}
	
	public int getDeckCount() {
		return fDeck.size();
	}
	
	//Create a Deck of Card
	private static ArrayList<Card> createCard() {
		ArrayList<Card> result = new ArrayList<Card>();
		Card tempCard;
		for(int i = 0; i < 56; i++) {
			if(i < 40) {
				tempCard = new Card(i / 10, i % 10);
			}
			else if(i < 52) {
				tempCard = new ActionCard((i - 40) / 3, (i - 40) % 3 + 10);
			} 
			else {
				tempCard = new ActionCard(4, i % 2 + 13);
			}
			result.add(tempCard);
		}
		
		return result;
	}
	
	//Shuffle Deck Card
	private static void shuffleCard(ArrayList<Card> aDeck) {
		Card tempCard;
		int index_1, index_2;
		for(int i = 0; i < aDeck.size(); i++) {
			index_1 = (int) (Math.random() * aDeck.size());
			index_2 = (int) (Math.random() * aDeck.size());
			tempCard = aDeck.get(index_1);
			aDeck.set(index_1, aDeck.get(index_2));
			aDeck.set(index_2, tempCard);
		}
		
	}

	//Distribute Card to Player
	private static void distributeCard(ArrayList<Card> aDeck, Player[] aPlayer, Object[] aPlayerName) {
		for(int i = 0; i < aPlayer.length; i++) {
			aPlayer[i] = new Player(aPlayerName[i].toString());
			for(int j = 0; j < 5; j++) {
				aPlayer[i].addCard(aDeck.remove(0));
			}
		}
	}
}