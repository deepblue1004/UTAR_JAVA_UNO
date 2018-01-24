//Game.java

import java.util.ArrayList;

public class Game {
	private Player[] fPlayer;
	private ArrayList<Card> fDeck;
	private ArrayList<Card> fPile;
	private int fPlayerTurn;
	
	//Constructor
	public Game(String[] aPlayerName) {
		fPlayer = new Player[aPlayerName.length];
		fDeck = new ArrayList<Card>();
		fPile = new ArrayList<Card>();
		
		createCard(fDeck);
		shuffleCard(fDeck);
		distributeCard(fDeck, fPlayer, aPlayerName);
		fPlayerTurn = 0;
		fPile.add(fDeck.remove(0));
	}
	
	//****Start get and set method****
	public Player getPlayer(int aIndex) {
		return fPlayer[aIndex];
	}
	
	public Card getDeck(int aIndex) {
		return fDeck.get(aIndex);
	}
	
	public Card getPile(int index) {
		return fPile.get(index);
	}
	
	public int getPlayerCount() {
		return fPlayer.length;		
	}
	
	public int getDeckCount() {
		return fDeck.size();
	}
	
	public int getPlayerTurn() {
		return fPlayerTurn;
	}
	
	public Player getPlaying() {
		return fPlayer[fPlayerTurn];
	}
	
	public void setPlayerTurn(int aPlayerTurn) {
		fPlayerTurn = aPlayerTurn;
	}
	
	public void addToPile(Card aCard) {
		fPile.add(0, aCard);
	}
	
	//****End get and set method****
	
	//Create a Deck of Card
	private static void createCard(ArrayList<Card> aDeck) {
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
			aDeck.add(tempCard);
		}

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
	private static void distributeCard(ArrayList<Card> aDeck, Player[] aPlayer, String[] aPlayerName) {
		for(int i = 0; i < aPlayer.length; i++) {
			aPlayer[i] = new Player(aPlayerName[i].toString());
			for(int j = 0; j < 5; j++) {
				aPlayer[i].addCard(aDeck.remove(0));
			}
		}
	}
	
	public void startGame() {
		
		
	}
	
	public boolean endGame() {
		return false;
	}
}
