
//Player.java

import java.util.ArrayList;

public class Player {
	private String fName;
	private ArrayList<Card> fHandCard;
	private static int numOfPlayer;

	// Constructor
	public Player(String aName) {
		fName = aName;
		fHandCard = new ArrayList<Card>();
		numOfPlayer += 1;
	}

	// ****Start get and set method****
	public String getName() {
		return fName;
	}

	public Card getCard(int aIndex) {
		return fHandCard.get(aIndex);
	}

	public static int getNum() {
		return numOfPlayer;
	}

	public void setName(String aName) {
		fName = aName;
	}
	// ****End get and set method****

	public void addCard(Card aNewCard) {
		fHandCard.add(aNewCard);
	}

	// Remove hand card by Object
	public int removeCard(Card aCard) {
		int result = fHandCard.indexOf(aCard);
		fHandCard.remove(aCard);
		return result;
	}

	// Remove hand card by Index
	public Card removeCard(int aIndex) {
		return fHandCard.remove(aIndex);
	}

	// Determine if the player has playable cards
	public boolean playable() {
		for (Card c : fHandCard) {
			if (c.getClass().getName() == "Card") {
				return true;
			}
		}
		return false;
	}

	public boolean win() {
		if (fHandCard.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

}
