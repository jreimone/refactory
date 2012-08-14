/*******************************************************************************
 * Copyright 2005, 2009 CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.eclipse.pde.internal.visualization.dependency.views;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

class GraphContentProvider implements IGraphEntityContentProvider {

	Object currentBundle = null;
	private boolean reverseBundleDependencies;


	private Object[] getDependencies(Object bundle) {
		if (bundle != null) {
			if (reverseBundleDependencies) {
				return DependencyUtil.getDependentBundles(bundle);
			}
			return AnalysisUtil.getPrerequisites(new Object[] { currentBundle });
		}
		return new BundleDescription[0];
	}

	// Returns all entities that should be linked with the given entity
	public Object[] getConnectedTo(Object entity) {
		if (reverseBundleDependencies) {
			return DependencyUtil.getConnectedBundles(entity, currentBundle);
		}
		return AnalysisUtil.getDependencies(entity);
	}

	public Object[] getElements(Object inputElement) {
		return getDependencies(inputElement);

	}

	public double getWeight(Object entity1, Object entity2) {
		return 0;
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		currentBundle = newInput;

	}

	public void setReverseBundleDependencies(boolean enable) {
		this.reverseBundleDependencies = enable;
	}

}