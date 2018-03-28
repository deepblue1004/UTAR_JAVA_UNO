// WildD4Card

package Uno;

public class WildD4Card extends WildCard {

	public WildD4Card() {
		super(14);
	}

	@Override
	public int action(Game aGame) {
		String message = "Wild Draw Four: Choose a color";
		String title = "Wild Draw Four Card";
		setSelectedColor(aGame.actionWild(message, title));
		return aGame.actionDraw(4);
	}
}
