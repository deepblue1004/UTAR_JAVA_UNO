// WildCard.java

package Uno;

public class WildCard extends Card {
	private eColor fSelectedColor; // For player selected color

	public WildCard(int aSymbol) {
		super(4, aSymbol);
		fSelectedColor = eColor.WILD;
	}

	public void setSelectedColor(int colorIndex) {
		fSelectedColor = eColor.values()[colorIndex];
	}
	
	public int getSelectedColor() {
		return fSelectedColor.ordinal();
	}

	@Override
	public int action(Game aGame) {
		setSelectedColor(aGame.actionWild("Wild Card: Choose a color", "Wild Card"));
		return 0;
	}

	@Override
	public boolean isMatch(Card c) {
		if (c.getColor() == 4 || c.getColor() == this.fSelectedColor.ordinal())
			return true;
		return false;
	}

	@Override
	public String toString() {
		if (fSelectedColor == eColor.WILD)
			return super.toString();
		return super.toString() + "(" + fSelectedColor.toString() + ")";
	}

	@Override
	public int compareTo(Card c) {
		setSelectedColor(eColor.WILD.ordinal());
		return super.compareTo(c);
	}
	
	@Override
	public String getPath() {
		if (getSelectedColor() == 4)
			return super.getPath();
		return "img/" + getColor() + "_" + getSymbol() + "_" + getSelectedColor() + ".png";
	}
}
