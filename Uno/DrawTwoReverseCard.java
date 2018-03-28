// DrawTwoReverseCard.java

package Uno;

public class DrawTwoReverseCard extends Card {
	public DrawTwoReverseCard(int aColor) {
		super(aColor, 15);
	}

	@Override
	public int action(Game aGame) {
		aGame.changeDirection();
		return aGame.actionDraw(2);
	}
}
