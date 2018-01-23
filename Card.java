//Card.java

public class Card {
	private enum eColor {
		RED, GREEN, BLUE, YELLOW, WILD;
	}
	private enum eSymbol {
		ZERO, ONE, TWO, THREE, FOUR, FIVE,
		SIX, SEVEN, EIGHT, NINE, 
		SKIP, REVERSE, WILD, DRAW_2, WILD_DRAW_4;
	}
	
	private eColor fColor;
	private eSymbol fSymbol;
	
	public Card(eColor aColor, eSymbol aSymbol) {
		fColor = aColor;
		fSymbol = aSymbol;	
	}
	
	public void action () {
		
	}
}
