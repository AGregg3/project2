package controller;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.NumberGuessGame;

public class NumberEnterListener implements ActionListener  {

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		JTextField numberField = (JTextField) e.getSource();
		var str = numberField.getText();
		int guess;
		try {
			guess = Integer.parseInt(str);
			if (guess < 0 || guess > NumberGuessGame.MAX_KEY){ 
				JOptionPane.showMessageDialog(App.win,
					"Out of range: valid range is 0 ~ " + NumberGuessGame.MAX_KEY);
			}
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(App.win, "Enter Integer Only");
			return;
		}

		App.game.play(guess);

		if (guess == App.game.getKey()){
			App.win.goNextState();
		}
		numberField.setText("");
		App.win.updateWindow();
	}
	
}
