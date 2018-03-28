// Card.java

package Uno;

public class Card implements Comparable<Card> {
	protected static enum eColor {
		RED, GREEN, BLUE, YELLOW, WILD
	}

	protected static enum eSymbol {
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_2, WILD, WILD_DRAW_4, DRAW_2R, WISH_CHANGE
	}

	private eColor fColor;
	private eSymbol fSymbol;

	// Constructor
	public Card(int aColor, int aSymbol) {
		if ((aColor >= 0 && aColor <= eColor.values().length) && (aSymbol >= 0 && aSymbol <= eSymbol.values().length)) {
			fColor = eColor.values()[aColor];
			fSymbol = eSymbol.values()[aSymbol];
		}
	}

	// Copy Constructor
	public Card(Card aCardObj) {
		fColor = aCardObj.fColor;
		fSymbol = aCardObj.fSymbol;
	}

	public int getColor() {
		return fColor.ordinal();
	}

	public int getSymbol() {
		return fSymbol.ordinal();
	}

	@Override
	public String toString() {
		return "[" + fColor.toString() + ", " + fSymbol.toString() + "]";
	}

	@Override
	public int compareTo(Card c) {
		if (fColor.compareTo(c.fColor) < 0)
			return -1;

		if (fColor.compareTo(c.fColor) == 0) {
			if (fSymbol.compareTo(c.fSymbol) < 0)
				return -1;
			if (fSymbol.compareTo(c.fSymbol) == 0)
				return 0;
		}

		return 1;
	}
	
	// Get image path of card
	public String getPath() {
		return "img/" + getColor() + "_" + getSymbol() + ".png";
	}

	// Check two card is match or not
	public boolean isMatch(Card c) {
		if (this.fColor == c.fColor || this.fSymbol == c.fSymbol || c.fColor == eColor.WILD)
			return true;
		return false;
	}

	public int action(Game aGame) {
		return 0;
	}
}
