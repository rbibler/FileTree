package com.bibler.awesome.treetest.ui;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class FileTree  {
	
	private JTree tree;
	private File rootFile;
	private DefaultMutableTreeNode rootNode;
	private DefaultTreeModel treeModel;
	
	public FileTree(File root) {
		rootFile = root;
		rootNode = new DefaultMutableTreeNode(rootFile.getName());
		treeModel = new DefaultTreeModel(rootNode);
		tree = new JTree(treeModel);
		tree.setEditable(true);;
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);;
		tree.setShowsRootHandles(true);
		
	}
	
	public DefaultMutableTreeNode addObject(Object child) {
		DefaultMutableTreeNode parentNode = null;
		TreePath parentPath = tree.getSelectionPath();
		if(parentPath == null) {
			parentNode = rootNode;
		} else {
			parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
		}
		return addObject(parentNode, child, true);
	}
	
	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parentNode, Object child, boolean shouldBeVisible) {
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
		treeModel.insertNodeInto(childNode, parentNode, parentNode.getChildCount());
		if(shouldBeVisible) {
			tree.scrollPathToVisible(new TreePath(childNode.getPath()));
		}
		return childNode;
	}
	
	public JTree getTree() {
		return tree;
	}
	
	
	
	
	

}
