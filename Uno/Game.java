// Game.java

package Uno;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Game {
	private Player[] fPlayer;
	private int fPlayIndex = 0;
	private boolean fAscending = true;
	private ArrayList<Card> fDeck = new ArrayList<Card>();
	private ArrayList<Card> fPile = new ArrayList<Card>();;

	// Constructor
	public Game(String[] aPlayerName) {
		fPlayer = new Player[aPlayerName.length];
		createCard();
		shuffleCard();
		distributeCard(aPlayerName);
	}

	// ****Start get and set method****
	public Player getPlayer(int aIndex) {
		return fPlayer[aIndex];
	}

	public int getPlayerCount() {
		return fPlayer.length;
	}

	public int getPlayIndex() {
		return fPlayIndex;
	}
	
	// Get next player index
	public int nextPlayIndex() {
		if (isAscending()) {
			if (fPlayIndex < fPlayer.length - 1)
				return fPlayIndex + 1;
			else
				return 0;
		}
		else {
			if (fPlayIndex > 0)
				return fPlayIndex - 1;
			else
				return fPlayer.length - 1;
		}
	}

	// Get previous player index
	public int prePlayIndex() {
		if (isAscending()) {
			if (fPlayIndex > 0)
				return fPlayIndex - 1;
			else
				return fPlayer.length - 1;
		}
		else {
			if (fPlayIndex < fPlayer.length - 1)
				return fPlayIndex + 1;
			else
				return 0;
		}
	}

	// Get current player
	public Player getPlaying() {
		return fPlayer[fPlayIndex];
	}
	
	// Get previous player
	public Player getPrePlaying() {
		return fPlayer[prePlayIndex()];
	}

	// Get next player
	public Player getNextPlaying() {
		return fPlayer[nextPlayIndex()];
	}

	// Get player's hand cards
	public ArrayList<Card> getPlayingCard() {
		return getPlaying().getCard();
	}

	// Get player's certain hand card
	public Card getPlayingCard(int aIndex) {
		return getPlaying().getCard(aIndex);
	}

	// Change current player
	public void setPlayIndex(int aPlayIndex) {
		fPlayIndex = aPlayIndex;
	}

	// Change to next player
	public void nextPlayer() {
		fPlayIndex = nextPlayIndex();
	}

	public boolean isAscending() {
		return fAscending;
	}

	public void changeDirection() {
		fAscending = !fAscending;
	}

	// Get one deck card
	public Card getFromDeck(int aIndex) {
		return fDeck.get(aIndex);
	}

	// Get number of total cards in deck
	public int deckCount() {
		return fDeck.size();
	}

	// Get one pile card
	public Card getFromPile(int index) {
		return fPile.get(index);
	}

	// Add a card to top of pile
	public void addToPile(Card aCard) {
		fPile.add(0, aCard);
	}
	// ****End get and set method****

	// Draw a Card From Deck
	public Card drawFromDeck() {
		if (fDeck.size() <= 1) {
			int pileSize = fPile.size();
			for (int i = 1; i < pileSize; i++) {
				fDeck.add(fPile.remove(1));
			}
			shuffleCard();
		}

		return fDeck.remove(0);
	}

	// Create a Deck of Card
	private void createCard() {
		for (int i = 0; i < 40; i++) {
			fDeck.add(new Card(i / 10, i % 10));
		}

		for (int i = 0; i < 4; i++) {
			fDeck.add(new SkipCard(i));
			fDeck.add(new ReverseCard(i));
			fDeck.add(new DrawTwoCard(i));
			fDeck.add(new DrawTwoReverseCard(i));
		}

		for (int i = 0; i < 2; i++) {
			fDeck.add(new WildCard(13));
			fDeck.add(new WildD4Card());
		}
		
		fDeck.add(new WildWishChangeCard());
	}

	// Shuffle Deck Card
	private void shuffleCard() {
		for (int i = 0; i < fDeck.size(); i++) {
			int index = new Random().nextInt(fDeck.size());
			Card tempCard = fDeck.get(i);
			fDeck.set(i, fDeck.get(index));
			fDeck.set(index, tempCard);
		}
	}

	// Distribute Card to Player and Pile
	private void distributeCard(String[] aPlayerName) {
		for (int i = 0; i < fPlayer.length; i++) {
			fPlayer[i] = new Player(aPlayerName[i]);
			for (int j = 0; j < 5; j++) {
				fPlayer[i].addCard(drawFromDeck());
			}
		}

		do {
			fPile.add(0, fDeck.remove(0));
		} while (fPile.get(0).getSymbol() > 9);
	}

	// For Player Select a Colour When Discard a Wild Card
	public int actionWild(String aMessage, String aTitle) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Player " + (getPlayIndex() + 1));
		alert.setHeaderText(aTitle);
		alert.setContentText(aMessage);
		
		ButtonType[] btnColor = new ButtonType[4];
		btnColor[0] = new ButtonType("RED");
		btnColor[1] = new ButtonType("GREEN");
		btnColor[2] = new ButtonType("BLUE");
		btnColor[3] = new ButtonType("YELLOW");
		
		alert.getButtonTypes().setAll(btnColor);
		Optional<ButtonType> result = alert.showAndWait();
		
		for (int i = 0; i < 4; i++) {
			if (result.get() == btnColor[i])
				return i;
		}
		return 0;
	}

	// Method for DRAW action card 
	public int actionDraw(int aNum) {
		nextPlayer();
		return aNum;
	}

	// Method for WildWishChangeCard
	public int actionWishChange() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Player " + (getPlayIndex() + 1));
		alert.setHeaderText("Wild wish change card!");
		alert.setContentText("Select a player to force the player exchange all hand card with you!");
		
		ButtonType[] btnPlayer = new ButtonType[getPlayerCount() - 1];
		
		for(int i = 0; i < btnPlayer.length; i++) {
			if (i < getPlayIndex())
				btnPlayer[i] = new ButtonType("Player " + (i + 1));
			else 
				btnPlayer[i] = new ButtonType("Player " + (i + 2));
		}
		
		alert.getButtonTypes().setAll(btnPlayer);
		Optional<ButtonType> result = alert.showAndWait();
		
		int selection = 0;		
		for (int i = 0; i < btnPlayer.length; i++) {
			if (result.get() == btnPlayer[i]) {
				if (i >= getPlayIndex())
					selection = i + 1;
				else
					selection = i;
				
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Player " + (getPlayIndex() + 1));
				alert.setHeaderText("Card exhange success!");
				alert.setContentText("Player " + (getPlayIndex() + 1) + " exchanged card with player " + (selection + 1));
				alert.showAndWait();
				
				ArrayList<Card> tempHandCard = getPlaying().getCard();
				getPlaying().setHandCards(getPlayer(selection).getCard());
				getPlayer(selection).setHandCards(tempHandCard);
			}
		}
		return 0;
	}
	
	// Check end game status
	public boolean endGame() {
		return getPlaying().win();
	}
}
