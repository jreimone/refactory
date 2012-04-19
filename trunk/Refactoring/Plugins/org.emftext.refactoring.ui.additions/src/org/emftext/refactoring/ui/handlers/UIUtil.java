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
package org.emftext.refactoring.ui.handlers;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @author jreimann
 *
 */
public abstract class UIUtil {

	/**
	 * Shows a tooltip at the location of the current cursor position in the given <code>editor</code>.
	 * @param title
	 * @param message
	 * @param editor
	 */
	public static void showToolTip(String title, String message, ITextEditor editor) {
		Shell shell = Display.getDefault().getActiveShell();
		ToolTip tip = new ToolTip(shell, SWT.ICON_WARNING);
		tip.setAutoHide(true);
		tip.setText(title);
		tip.setMessage(message);
		if(editor != null){
			//TODO locate tooltip at cursor position
			ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
			selection.getOffset();
		}
		tip.setVisible(true);
	}
}
