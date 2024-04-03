package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.strategyPattern.CloserAwayStrategy;
import model.strategyPattern.HighLowStrategy;
import view.AppWindow;

public class StrategySelectionEventListener implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch (action){
			case AppWindow.highLowAction:
				App.game.setStrategy(new HighLowStrategy(App.game));
				break;
			case AppWindow.closerAwayAction:
				App.game.setStrategy(new CloserAwayStrategy(App.game));
				break;
		}
	}
	
}
