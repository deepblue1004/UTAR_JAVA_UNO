
//Game.java

import java.util.ArrayList;
import java.util.Random;

public class Game {
	private Player[] fPlayer;
	private ArrayList<Card> fDeck;
	private ArrayList<Card> fPile;
	private int fPlayerTurn;

	// Constructor
	public Game(String[] aPlayerName) {
		fPlayer = new Player[aPlayerName.length];
		fDeck = new ArrayList<Card>();
		fPile = new ArrayList<Card>();

		createCard();
		shuffleCard();
		distributeCard(aPlayerName);
		fPlayerTurn = 0;
		fPile.add(fDeck.remove(0));
	}

	// ****Start get and set method****
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
	// ****End get and set method****

	// Create a Deck of Card
	private void createCard() {
		Card tempCard;
		for (int i = 0; i < 56; i++) {
			if (i < 40) {
				tempCard = new Card(i / 10, i % 10);
			}
			else if (i < 52) {
				tempCard = new ActionCard((i - 40) / 3, (i - 40) % 3 + 10);
			}
			else {
				tempCard = new ActionCard(4, i % 2 + 13);
			}
			fDeck.add(tempCard);
		}

	}

	// Shuffle Deck Card
	private void shuffleCard() {
		Card tempCard;
		int index_1, index_2;
		for (int i = 0; i < fDeck.size(); i++) {
			index_1 = new Random().nextInt(fDeck.size());
			index_2 = new Random().nextInt(fDeck.size());
			tempCard = fDeck.get(index_1);
			fDeck.set(index_1, fDeck.get(index_2));
			fDeck.set(index_2, tempCard);
		}
	}

	// Distribute Card to Player
	private void distributeCard(String[] aPlayerName) {
		for (int i = 0; i < fPlayer.length; i++) {
			fPlayer[i] = new Player(aPlayerName[i]);
			for (int j = 0; j < 5; j++) {
				fPlayer[i].addCard(fDeck.remove(0));
			}
		}
	}

	public void startGame() {

	}

	public boolean endGame() {
		return false;
	}
}
