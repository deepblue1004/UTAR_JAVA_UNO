//Player.java

import java.util.ArrayList;

public class Player {
	private String fName;
	private ArrayList<Card> fHandCard;
	
	
	public Player(String aName) {
		fName = aName;
		fHandCard = new ArrayList<Card>();
	}
	
	public String getName() {
		return fName;
	}
	
	public void setName(String aName) {
		fName = aName;
	}
	
	public void addCard(Card aNewCard) {
		fHandCard.add(aNewCard);
	}
	
	public void removeCard(Card aCard) {
		fHandCard.remove(aCard);
	}
}	

