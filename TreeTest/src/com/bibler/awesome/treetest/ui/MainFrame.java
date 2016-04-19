package com.bibler.awesome.treetest.ui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private MainPanel panel;
	
	public MainFrame() {
		super();
		panel = new MainPanel();
		add(panel);
		pack();
		setVisible(true);
	}
	
	public MainPanel getPanel() {
		return panel;
	}

}
