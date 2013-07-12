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
import org.eclipse.compare.CompareUI;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.domain.impl.EMFCompareEditingDomain;
import org.eclipse.emf.compare.ide.ui.internal.editor.ComparisonEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.ltk.ui.refactoring.ChangePreviewViewerInput;
import org.eclipse.ltk.ui.refactoring.IChangePreviewViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ModelChangePreviewer implements IChangePreviewViewer {

	private ViewForm control;
//	private RefactoringCompareEditorInput compare;
	//	private CompareViewerPane pane;

	public void createControl(Composite parent) {
		control = new ViewForm(parent, SWT.BORDER);
//		compare = new RefactoringCompareEditorInput(control);
	}

	public Control getControl() {
		return control;
	}

	public void setInput(ChangePreviewViewerInput input) {
		if(!(input.getChange() instanceof ModelRefactoringChange)){
			return;
		}
		ModelRefactoringChange change = (ModelRefactoringChange) input.getChange();
		EObject originalModel = change.getRefactorer().getOriginalModel();
		EObject fakeRefactoredModel = change.getRefactorer().getFakeRefactoredModel();
		
//		compare.setChange(change);
//		compare.setOriginalModel(originalModel);
//		compare.setFakeRefactoredModel(fakeRefactoredModel);
//		try {
//			compare.run(new NullProgressMonitor());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
		//		compare.getControl().pack(true);
		//		compare.getControl().setVisible(true);
		
//		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
//		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
//		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
//		matchEngineFactory.setRanking(20);
//		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
//		matchEngineRegistry.add(matchEngineFactory);
//		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();
//		IComparisonScope scope = EMFCompare.createDefaultScope(originalModel, fakeRefactoredModel);
//		Comparison comparison = comparator.compare(scope);
	    
		EMFCompare comparator = EMFCompare.builder().build();
	    Comparison comparison = comparator.compare(EMFCompare.createDefaultScope(originalModel, fakeRefactoredModel));
		
		ICompareEditingDomain editingDomain = EMFCompareEditingDomain.create(originalModel, fakeRefactoredModel, null);
		AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	    CompareEditorInput compareEditorInput = new ComparisonEditorInput(new CompareConfiguration(), comparison, editingDomain, adapterFactory);
//	    CompareUI.openCompareDialog(compareEditorInput);
	    
	    try {
			compareEditorInput.run(new NullProgressMonitor());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	    
	    AbstractModelCompareDialog dialog = new AbstractModelCompareDialog(control, compareEditorInput);
	    Control compareControl = dialog.initializeControl();
		compareControl.setVisible(true);
	    
//		CompareUI.openCompareDialog(compare);
//		System.out.println();
	}

}
