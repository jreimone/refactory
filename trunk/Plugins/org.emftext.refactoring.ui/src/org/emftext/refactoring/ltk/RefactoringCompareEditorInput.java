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
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.ide.ui.internal.configuration.EMFCompareConfiguration;
import org.eclipse.emf.compare.ide.ui.internal.editor.ComparisonEditorInput;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

@SuppressWarnings("restriction")
public class RefactoringCompareEditorInput extends ComparisonEditorInput {

	private EMFCompareConfiguration configuration;
	private IComparisonScope scope;

	public RefactoringCompareEditorInput(IComparisonScope scope, Comparison comparison, ICompareEditingDomain editingDomain, AdapterFactory adapterFactory) {
		super(new EMFCompareConfiguration(new CompareConfiguration()), comparison, editingDomain, adapterFactory);
		this.scope = scope;
		initCompareConfiguration();
	}

	private void initCompareConfiguration() {
		configuration = getCompareConfiguration();
		configuration.setLeftEditable(false);
		configuration.setRightEditable(false);
		AdapterFactory adapterFactory = getAdapterFactory();
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		Notifier original = scope.getRight();
		Notifier fake = scope.getLeft();
		Image originalImage = labelProvider.getImage(original);
		Image fakeImage = labelProvider.getImage(fake);
		String originalLabel = labelProvider.getText(original);
		String fakeLabel = labelProvider.getText(fake);
		configuration.setLeftImage(fakeImage);
		configuration.setLeftLabel("[after refactoring] " + fakeLabel);
		configuration.setRightImage(originalImage);
		configuration.setRightLabel("[before refactoring] " + originalLabel);
	}

	@Override
	public EMFCompareConfiguration getCompareConfiguration() {
		return super.getCompareConfiguration();
	}
	
}
