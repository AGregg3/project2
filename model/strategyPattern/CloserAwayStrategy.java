package model.strategyPattern;

import model.NumberGuessGame;

public class CloserAwayStrategy implements PlayStrategy {

	private NumberGuessGame game;

	public CloserAwayStrategy(NumberGuessGame game) {
		this.game = game;
	}

	@Override
	public void play(int guess) {
		int prevDiff = Math.abs(game.getKey() - game.getGuess());
		int newDiff = Math.abs(game.getKey() - guess);
		this.game.setGuess(guess);
		if (newDiff < prevDiff ) {
			game.progressMessage = "Getting Closer";
		} else {
			game.progressMessage = "Not getting Closer";
		}
		game.incAttempts();
	}

}
