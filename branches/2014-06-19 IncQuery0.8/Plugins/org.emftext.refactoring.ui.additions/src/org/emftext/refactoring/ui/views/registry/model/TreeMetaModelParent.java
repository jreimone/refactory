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
package org.emftext.refactoring.ui.views.registry.model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public class TreeMetaModelParent extends TreeParent {

	private EPackage metamodel;

	public TreeMetaModelParent(EPackage metamodel) {
		super(metamodel);
		this.metamodel = metamodel;
	}

	public EPackage getMetamodel() {
		return metamodel;
	}

	public int getCountMetaclasses() {
		return countMetaclasses(getMetamodel());
	}

	public int getCountStructuralFeatures() {
		return countStructuralFeatures(getMetamodel());
	}

	public double getCountStructuralFeaturesPerMetaclass() {
		return new Integer(getCountStructuralFeatures()).doubleValue() / new Integer(
				getCountMetaclasses()).doubleValue();
	}

	private int countMetaclasses(EPackage epackage) {
		int count = 0;
		if (epackage.getEClassifiers() != null) {
			for (EClassifier classifier : epackage.getEClassifiers()) {
				if (classifier instanceof EClass) {
					count++;
				}
			}
		}
		for (EPackage subPackage : epackage.getESubpackages()) {
			count += countMetaclasses(subPackage);
		}
		return count;
	}

	private int countStructuralFeatures(EPackage epackage) {
		int count = 0;
		if (epackage.getEClassifiers() != null) {
			for (EClassifier classifier : epackage.getEClassifiers()) {
				if (classifier instanceof EClass) {
					count += ((EClass) classifier).getEStructuralFeatures().size();
					// count += ((EClass)
					// classifier).getEReferences().size();
				}
			}
		}
		for (EPackage subPackage : epackage.getESubpackages()) {
			count += countStructuralFeatures(subPackage);
		}
		return count;
	}

	@Override
	public String toString() {
		return metamodel.getNsURI();
	}
}