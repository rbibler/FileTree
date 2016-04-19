package com.bibler.awesome.treetest.main;

import java.io.File;

import com.bibler.awesome.treetest.ui.FileTree;

public class FileIterator {
	
	private FileTree fileTree;
	public FileIterator() {
		
	}
	
	public void setTree(FileTree fileTree) {
		this.fileTree = fileTree;
	}
	
	public void processDirectory(File directory) {
		File[] filesInDirectory = directory.listFiles();
		for(File f : filesInDirectory) {
			if(f.isDirectory()) {
				processDirectory(f);
			} else {
				fileTree.addObject(f);
			}
		}
		
	}

}
