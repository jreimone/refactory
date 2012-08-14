/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
