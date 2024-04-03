package view.statePattern;

import java.awt.Graphics;

import view.AppWindow;

public interface GameState {
	void goNext(AppWindow context);
	void updateWindow();
	void updateCanvas(Graphics g2);
}
