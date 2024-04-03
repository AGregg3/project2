package view.statePattern;

import java.awt.Font;
import java.awt.Graphics;

import controller.App;
import model.NumberGuessGame;
import view.AppWindow;

public class GameStatePlaying implements GameState {

	@Override
	public void goNext(AppWindow context) {
		context.setGameState(new GameStateDone());
	}

	@Override
	public void updateWindow() {
		App.win.newGameButton.setEnabled(false);
		App.win.numberField.setEnabled(true);
		App.win.highLowButton.setEnabled(false);
		App.win.closerAwayButton.setEnabled(false);

		App.win.canvas.repaint();
	}

	@Override
	public void updateCanvas(Graphics g2) {
		g2.setFont(new Font("Courier New", Font.BOLD, 16));
		NumberGuessGame game = App.game;

		if (game.isShowKeyOn()) {
			var keyString = String.format("(Key: %d)", game.getKey());
			g2.drawString(keyString, 50, 100);
		}
		String promptString;
		if (game.getGuess() >= 0) {
			promptString = String.format("Your Guess %d (Attempts: %d)",
					game.getGuess(), game.getAttempts());
		} else {
			promptString = "Enter your guess";
		}
		g2.drawString(promptString, 50, 150);

		if (game.progressMessage != null) {
			g2.drawString(game.progressMessage, 100, 200);
		}
	}

}
