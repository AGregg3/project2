package model;

import java.util.Random;

import model.strategyPattern.HighLowStrategy;
import model.strategyPattern.PlayStrategy;

public class NumberGuessGame {

	public static final int MAX_KEY = 100;


	private int key;
	private int guess;
	private boolean showKeyOn;
	private int attempts;
	private PlayStrategy strategy;
	public String progressMessage;

	public NumberGuessGame() {
		key = -1;
		guess = -1;
		showKeyOn = false;
		attempts = 0;
		// state = GameState.INIT;
		setStrategy(new HighLowStrategy(this)); //default strategy
	}

	public void start() {
		key = generateNewKey();
		guess = -1;
		attempts = 0;
		progressMessage = null;
	}

	public int generateNewKey() {
		Random r = new Random();
		int newKey;
		do {
			newKey = r.nextInt(MAX_KEY + 1);
		} while (newKey == key);
		return newKey;
	}

	public void play(int guess) {
	//	this.guess = guess;
		strategy.play(guess);
	}

//	private void playHighLow(int guess){
//		this.guess = guess;
//		int diff = guess - key;
//		if (diff < 0) {
//			progressMessage = "Go Higher!";
//		} else if (diff == 0) {
//			progressMessage = "You got it! The key was " + key;
//		} else {
//			progressMessage = "Go Lower!";
//		}
//	}

//	private void playCloserAway(int guess) { 
//		int prevDiff = Math.abs(key - this.guess);
//		int newDiff = Math.abs(key - guess);
//		this.guess = guess;
//		if (newDiff - prevDiff < 0) {
//			progressMessage = "Getting Closer";
//		} else {
//			progressMessage = "Not getting Closer";
//		}
//	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public void incAttempts() {
		++attempts;
	}

	public PlayStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(PlayStrategy strategy) {
		this.strategy = strategy;
	}

	public boolean isShowKeyOn() {
		return showKeyOn;
	}

	public void setShowKeyOn(boolean showKeyOn) {
		this.showKeyOn = showKeyOn;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public int getKey() {
		return key;
	}

	@Override
	public String toString() {
		return String.format(
			"key(%d) guess(%d) attempts(%d)",
			key, guess, attempts	
		);
	}




	
}
