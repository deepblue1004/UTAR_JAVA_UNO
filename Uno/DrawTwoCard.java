// DrawTwoCard.java

package Uno;

public class DrawTwoCard extends Card {

	public DrawTwoCard(int aColor) {
		super(aColor, 12);
	}

	@Override
	public int action(Game aGame) {
		return aGame.actionDraw(2);
	}
}
