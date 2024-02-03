package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.App;
import controller.ExitButtonListener;
import controller.NewGameButtonListener;
import controller.NumberEnterListener;
import controller.ShowKeyButtonListener;
import controller.StrategySelectionEventListener;
import model.PlayStratagy;

public class AppWindow extends JFrame {

	public static final String highLowAction = "High/Low";
	public static final String closerAwayAction = "Closer/Away";

	private AppCanvas canvas;

	private JTextField numberField;
	private JRadioButton highLowButton;
	private JRadioButton closerAwayButton;

	private JCheckBox showKeyButton;
	private JButton newGameButton;
	private JButton exitButton;

	public void init() {

		var cp = getContentPane();
		canvas = new AppCanvas();
		cp.add(canvas, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(3, 1));
		cp.add(southPanel, BorderLayout.SOUTH);

		JPanel numberPanel = new JPanel();
		southPanel.add(numberPanel);
		numberPanel.setBorder(new TitledBorder("Your guess"));
		numberPanel.add(new JLabel("Enter (0~100)"));
		numberField = new JTextField(10);
		numberPanel.add(numberField);
		numberField.addActionListener(new NumberEnterListener());

		JPanel strategyPanel = new JPanel();
		strategyPanel.setBorder(new TitledBorder("Select Stratagy"));
		highLowButton = new JRadioButton(highLowAction,
			App.game.getStrategy() == PlayStratagy.HighLow
		);
		closerAwayButton = new JRadioButton(closerAwayAction,
			App.game.getStrategy() == PlayStratagy.CloserAway
		);
		strategyPanel.add(highLowButton);
		strategyPanel.add(closerAwayButton);
		southPanel.add(strategyPanel);
		StrategySelectionEventListener strategySelectionListener = new StrategySelectionEventListener();
		highLowButton.addActionListener(strategySelectionListener);
		closerAwayButton.addActionListener(strategySelectionListener);

		ButtonGroup strategyGroup = new ButtonGroup();
		strategyGroup.add(highLowButton);
		strategyGroup.add(closerAwayButton);

		JPanel actionPanel = new JPanel();
		southPanel.add(actionPanel);
		showKeyButton = new JCheckBox("show key");
		showKeyButton.addItemListener(new ShowKeyButtonListener());
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new NewGameButtonListener());
		exitButton = new JButton("Exit");
		// exitButton.addActionListener(new ExitButtonListener());
		// exitButton.addActionListener((e) -> {
		//	System.exit(0);
		// });
		exitButton.addActionListener( e -> System.exit(0));
		actionPanel.add(showKeyButton);
		actionPanel.add(newGameButton);
		actionPanel.add(exitButton);

		updateWindow();

	}

	public void updateWindow() {
		switch (App.game.getState()) {
			case INIT:
			case OVER:
				newGameButton.setEnabled(true);
				numberField.setEnabled(false);
				highLowButton.setEnabled(true);
				closerAwayButton.setEnabled(true);
				showKeyButton.setEnabled(true);
				break;
			case PLAYING:
				newGameButton.setEnabled(false);
				numberField.setEnabled(true);
				highLowButton.setEnabled(false);
				closerAwayButton.setEnabled(false);
				break;
				

			
		}

		canvas.repaint();

	}


	
}

