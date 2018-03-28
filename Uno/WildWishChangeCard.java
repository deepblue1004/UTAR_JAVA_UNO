// WildWishChangeCard.java

package Uno;

public class WildWishChangeCard extends WildCard {
	public WildWishChangeCard() {
		super(16);
	}
	
	@Override
	public int action(Game aGame) {
		String message = "Wild Wish Change Card: Choose a color";
		String title = "Wild Wish Change Card";
		setSelectedColor(aGame.actionWild(message, title));
		aGame.actionWishChange();
		return 0;
	}
}
