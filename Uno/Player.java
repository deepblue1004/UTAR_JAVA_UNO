// Player.java

package Uno;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	private String fName;
	private ArrayList<Card> fHandCard;
	private static int numOfPlayer;

	// Constructor
	public Player(String aName) {
		fName = aName;
		fHandCard = new ArrayList<Card>();
		numOfPlayer++;
	}

	// Copy Constructor
	public Player(Player aPlayerObj) {
		fName = aPlayerObj.fName;
		fHandCard = new ArrayList<Card>(aPlayerObj.fHandCard);
	}

	// ****Start get and set method****
	public String getName() {
		return fName;
	}

	public Card getCard(int aIndex) {
		return fHandCard.get(aIndex);
	}

	public ArrayList<Card> getCard() {
		return new ArrayList<Card>(fHandCard);
	}

	public static int getNum() {
		return numOfPlayer;
	}

	public void setName(String aName) {
		fName = aName;
	}
	
	public void setHandCards(ArrayList<Card> aCardList) {
		fHandCard = aCardList;
	}
	// ****End get and set method****

	@Override
	public String toString() {
		String result = "Player " + fName + " :";
		for (int i = 0; i < fHandCard.size(); i++) {
			result += "\n" + (i + 1) + ": " + fHandCard.get(i);
		}
		return result;
	}

	// Add a card to player's handcard
	public void addCard(Card aNewCard) {
		fHandCard.add(aNewCard);
		Collections.sort(fHandCard);
	}

	// Remove hand card by Index
	public Card removeCard(int aIndex) {
		return fHandCard.remove(aIndex);
	}

	// Remove hand card by Object
	public int removeCard(Card aCard) {
		int result = fHandCard.indexOf(aCard);
		if (result >= 0)
			fHandCard.remove(result);
		return result;
	}
	
	// Check and return player's playable card
	public ArrayList<Card> isPlayable(Card aCard) {
		ArrayList<Card> result = new ArrayList<Card>();
		for (Card c : fHandCard) {
			if (aCard.isMatch(c))
				result.add(c);
		}
		return result;
	}

	// Check wining condition
	public boolean win() {
		if (fHandCard.size() == 0)
			return true;
		return false;
	}
}
