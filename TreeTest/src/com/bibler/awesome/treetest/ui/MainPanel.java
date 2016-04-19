package com.bibler.awesome.treetest.ui;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.bibler.awesome.treetest.main.FileIterator;

public class MainPanel extends JPanel {
	
	FileTree tree;
	FileIterator iterator;
	JScrollPane pane;
	
	public MainPanel() {
		super();
		tree = new FileTree(new File("C:/users/ryan/desktop"));
		pane = new JScrollPane(tree.getTree());
		pane.setPreferredSize(new Dimension(450, 900));
		add(pane);
		iterator = new FileIterator();
		iterator.setTree(tree);
		startProcessThread();
	}
	
	private void startProcessThread() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				iterator.processDirectory(new File("C:/users/ryan/desktop"));
			}
		};
		Thread t = new Thread(r);
		t.start();
	}

	
}
