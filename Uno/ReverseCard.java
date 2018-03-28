package Uno;
// ReverseCard.java

public class ReverseCard extends Card {

	public ReverseCard(int aColor) {
		super(aColor, 11);
	}

	@Override
	public int action(Game aGame) {
		aGame.changeDirection();
		return 0;
	}
}
