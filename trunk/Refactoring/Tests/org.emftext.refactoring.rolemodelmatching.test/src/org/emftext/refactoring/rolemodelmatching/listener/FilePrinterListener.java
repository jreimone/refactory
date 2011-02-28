package org.emftext.refactoring.rolemodelmatching.listener;

import java.io.FileWriter;
import java.io.IOException;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class FilePrinterListener extends PrintMatchPathListener {

	private MatchNode<?, ?> leaf;
	private FileWriter writer;

	public FilePrinterListener(FileWriter writer) {
		super();
		this.writer = writer;
	}

	@Override
	public void execute(MatchNode<?, ?> node) {
		leaf = node;
		StringBuffer buffer = printPath(leaf);
		try {
			writer.append(buffer.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
