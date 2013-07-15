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
package org.emftext.refactoring.ltk;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.ide.ui.internal.editor.ComparisonEditorInput;

@SuppressWarnings("restriction")
public class RefactoringCompareEditorInput extends ComparisonEditorInput {

	private static CompareConfiguration config = new CompareConfiguration();

	static{
		config.setLeftEditable(false);
		config.setRightEditable(false);
	}

	public RefactoringCompareEditorInput(Comparison comparison, ICompareEditingDomain editingDomain, AdapterFactory adapterFactory) {
		super(config, comparison, editingDomain, adapterFactory);
	}
}
