package view.statePattern;

import java.awt.Font;
import java.awt.Graphics;

import controller.App;
import view.AppWindow;

public class GameStateInit implements GameState {

	@Override
	public void goNext(AppWindow context) {
		context.setGameState(new GameStatePlaying());
	}

	@Override
	public void updateWindow() {
		App.win.newGameButton.setEnabled(true);
		App.win.numberField.setEnabled(false);
		App.win.highLowButton.setEnabled(true);
		App.win.closerAwayButton.setEnabled(true);
		App.win.showKeyButton.setEnabled(true);

		App.win.canvas.repaint();
	}

	@Override
	public void updateCanvas(Graphics g2) {
		g2.setFont(new Font("Courier New", Font.BOLD, 16));
		var message = "Press <New Game> to start";
		g2.drawString(message, 50, 150);
	}

}
