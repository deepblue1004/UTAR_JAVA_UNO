//Card.java

public class Card implements Comparable<Card> {
	private enum eColor {
		RED, GREEN, BLUE, YELLOW, WILD
	}

	private enum eSymbol {
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_2, WILD, WILD_DRAW_4
	}

	private eColor fColor;
	private eSymbol fSymbol;

	// Constructor
	public Card(int aColor, int aSymbol) {
		if ((aColor >= 0 && aColor <= 4) && (aSymbol >= 0 && aSymbol <= 15)) {
			fColor = eColor.values()[aColor];
			fSymbol = eSymbol.values()[aSymbol];
		}
	}

	// Copy Constructor
	public Card(Card aCardObj) {
		fColor = aCardObj.fColor;
		fSymbol = aCardObj.fSymbol;
	}

	public eColor getColor() {
		return fColor;
	}

	public eSymbol getSymbol() {
		return fSymbol;
	}

	public String[] getFace() {
		String[] result = new String[2];
		result[0] = fColor.toString();
		result[1] = fSymbol.toString();
		return result;
	}

	@Override
	public String toString() {
		return fColor.toString() + ", " + fSymbol.toString();
	}

	@Override
	public int compareTo(Card c) {
		if (fColor.compareTo(c.fColor) < 0)
			return -1;
		else if (fColor.compareTo(c.fColor) == 0)
			if (fSymbol.compareTo(c.fSymbol) < 0)
				return -1;
			else if (fSymbol.compareTo(c.fSymbol) == 0)
				return 0;
			else
				return 1;
		else
			return 1;
	}

	public void action() {

	}
}
