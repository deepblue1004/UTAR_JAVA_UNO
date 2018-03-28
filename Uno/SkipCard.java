// SkipCard.java

package Uno;

public class SkipCard extends Card {

	public SkipCard(int aColor) {
		super(aColor, 10);
	}

	@Override
	public int action(Game aGame) {
		aGame.nextPlayer();
		return 0;
	}

}