package model.strategyPattern;

import model.NumberGuessGame;

public class HighLowStrategy implements PlayStrategy {

	private NumberGuessGame game;

	public HighLowStrategy(NumberGuessGame game) {
		this.game = game;
	}

	@Override
	public void play(int guess) {
		guess = game.getGuess();
		int diff = guess - game.getKey();
		if (diff < 0) {
			game.progressMessage = "Go Higher!";
		} else if (diff == 0) {
			game.progressMessage = "You got it! The key was " + game.getKey();
		} else {
			game.progressMessage = "Go Lower!";
		} 
		game.incAttempts();
	}

}
