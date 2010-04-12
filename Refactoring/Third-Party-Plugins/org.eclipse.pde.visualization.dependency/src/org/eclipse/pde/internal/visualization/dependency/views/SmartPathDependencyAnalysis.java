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

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;

/**
 * 
 * This computues the nodes and edges in the "smart" path. The smart path
 * consists of all your direct dependencies that have paths to the selected
 * nodes.
 * 
 * @author Ian Bull
 * 
 */
public class SmartPathDependencyAnalysis extends AbstractVisualizationLabelProvider {

	/**
	 * SmartPathDependencyAnalysis constructor
	 * 
	 * @param viewer
	 *            The GraphViewer
	 */
	public SmartPathDependencyAnalysis(GraphViewer viewer, AbstractVisualizationLabelProvider currentLabelProvider) {
		super(viewer, currentLabelProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.pde.visualization.views.AbstractVisualizationLabelProvider#calculateInterestingDependencies(java.util.HashSet,
	 *      java.util.HashSet)
	 */
	protected void calculateInterestingDependencies(HashSet interestingRels, HashSet interestingEntities) {

		// Calculates the smart path.
		if (this.getSelected() != null) {
			// Get all the dependencies of the root node
			Object[] descriptions = AnalysisUtil.getDependencies(this.rootNode);
			for (int i = 0; i < descriptions.length; i++) {
				// For each dependency of the root node, compute the shortest path
				// to the selected node.  add each of these to to the list of nodes.
				EntityConnectionData entityConnectionData = new EntityConnectionData(this.rootNode, descriptions[i]);
				Object[] path = AnalysisUtil.getPath(descriptions[i], this.getSelected());
				if (path.length > 1) {
					for (int j = 0; j < path.length; j++) {
						for (int k = 0; k < path.length; k++) {
							EntityConnectionData entityConnectionData2 = new EntityConnectionData(path[j], path[k]);
							interestingRels.add(entityConnectionData2);
						}
					}
					interestingEntities.addAll(Arrays.asList(path));
					interestingEntities.add(descriptions[i]);
					interestingRels.add(entityConnectionData);
				}
			}
			Object[] path = AnalysisUtil.getPath(this.rootNode, this.getSelected());
			if (path.length > 1) {
				for (int j = 0; j < path.length; j++) {
					for (int k = 0; k < path.length; k++) {
						EntityConnectionData entityConnectionData2 = new EntityConnectionData(path[j], path[k]);
						interestingRels.add(entityConnectionData2);
					}
				}
				interestingEntities.addAll(Arrays.asList(path));

			}
			interestingEntities.add(this.rootNode);
		}
	}

}
