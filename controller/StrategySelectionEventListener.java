package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.PlayStratagy;
import view.AppWindow;

public class StrategySelectionEventListener implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch (action){
			case AppWindow.highLowAction:
				App.game.setStratagy(PlayStratagy.HighLow);
				break;
			case AppWindow.closerAwayAction:
				App.game.setStratagy(PlayStratagy.CloserAway);
				break;
		}
	}
	
}
