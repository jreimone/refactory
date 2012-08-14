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

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class RefactoringCompareEditorInput extends CompareEditorInput {

	private static CompareConfiguration config = new CompareConfiguration();
	
	static{
		config.setLeftEditable(false);
		config.setRightEditable(false);
	}
	
	private EObject originalModel;
	private EObject fakeRefactoredModel;
	
	private Control control;
	
	public RefactoringCompareEditorInput(Composite parent) {
		super(config);
		control = super.createContents(parent);
//		control.pack();
//		control.setVisible(true);
	}

	@Override
	protected Object prepareInput(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		if(originalModel == null){
			throw new InvocationTargetException(new NullPointerException("Original Model mustn't be null"));
		}
		if(fakeRefactoredModel == null){
			throw new InvocationTargetException(new NullPointerException("Fake Refactored Model mustn't be null"));
		}
		Map<String, Object> options = new LinkedHashMap<String, Object>();
		options.put(MatchOptions.OPTION_DISTINCT_METAMODELS, true);
		options.put(MatchOptions.OPTION_IGNORE_ID, true);
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, true);
		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		MatchModel match = MatchService.doContentMatch(originalModel, fakeRefactoredModel, options);
		DiffModel diff = DiffService.doDiff(match, false);
		
		return diff;
	}

	public EObject getOriginalModel() {
		return originalModel;
	}

	public void setOriginalModel(EObject originalModel) {
		this.originalModel = originalModel;
	}

	public EObject getFakeRefactoredModel() {
		return fakeRefactoredModel;
	}

	public void setFakeRefactoredModel(EObject fakeRefactoredModel) {
		this.fakeRefactoredModel = fakeRefactoredModel;
	}

	@Override
	public Control createContents(Composite parent) {
		// don't change the parent
		return control;
	}

	public Control getControl() {
		return control;
	}

}
