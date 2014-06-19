/*******************************************************************************
 * Copyright 2005-2006, CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.eclipse.pde.internal.visualization.dependency.views;

import java.util.HashSet;

import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;

/**
 * 
 * @author Ian Bull
 * 
 */
class HighlightDependencyLableProvider extends AbstractVisualizationLabelProvider {

	public HighlightDependencyLableProvider(GraphViewer viewer, AbstractVisualizationLabelProvider currentLabelProvider) {
		super(viewer, currentLabelProvider);
	}

	protected void calculateInterestingDependencies(HashSet interestingRels, HashSet interestingEntities) {

		if (getSelected() != null) {
			final Object[] descriptions;
			if (!isReverseBundleDependencies()) {
				descriptions = AnalysisUtil.getDependencies(this.getSelected());
				for (int i = 0; i < descriptions.length; i++) {
					EntityConnectionData entityConnectionData = new EntityConnectionData(this.getSelected(), descriptions[i]);
					interestingRels.add(entityConnectionData);
					interestingEntities.add(descriptions[i]);
				}
			} else  {
				descriptions = DependencyUtil.getDirectDependendBundles(this.getSelected());
				for (int i = 0; i < descriptions.length; i++) {
					EntityConnectionData entityConnectionData = new EntityConnectionData(descriptions[i], this.getSelected());
					interestingRels.add(entityConnectionData);
					interestingEntities.add(descriptions[i]);
				}
			}
		}
	}

}