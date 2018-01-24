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
	
	public Card getCard(int aIndex) {
		return fHandCard.get(aIndex);
	}
	
	public int removeCard(Card aCard) {
		int result = fHandCard.indexOf(aCard);
		fHandCard.remove(aCard);
		return result;
	}
	
	public Card removeCard(int aIndex) {
		return fHandCard.remove(aIndex);
	}
	
	public boolean win(){
		if(fHandCard.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}	

