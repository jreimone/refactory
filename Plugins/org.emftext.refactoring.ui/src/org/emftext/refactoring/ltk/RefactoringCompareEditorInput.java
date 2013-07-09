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

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
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
		// new EMF Compare API
		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
//		IMatchEngine matchEngine = new DefaultMatchEngine(matcher, comparisonFactory);
		//		IMatchEngine.Factory.Registry matchEngineRegistry = EMFCompareRCPPlugin.getDefault().getMatchEngineFactoryRegistry();
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();
		IComparisonScope scope = EMFCompare.createDefaultScope(originalModel, fakeRefactoredModel);
		return comparator.compare(scope);
		
		// old EMF Compare API
		//		Map<String, Object> options = new LinkedHashMap<String, Object>();
		//		options.put(MatchOptions.OPTION_DISTINCT_METAMODELS, true);
		//		options.put(MatchOptions.OPTION_IGNORE_ID, true);
		//		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, true);
		//		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		//		MatchModel match = MatchService.doContentMatch(originalModel, fakeRefactoredModel, options);
		//		DiffModel diff = DiffService.doDiff(match, false);
		//		
		//		return diff;
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
