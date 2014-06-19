/*******************************************************************************
 * Copyright (c) 2009 EclipseSource Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     EclipseSource Corporation - initial API and implementation
 *     Stefan Rock <stefan.rock@cas.de> - bug blah
 *******************************************************************************/
package org.eclipse.pde.internal.visualization.dependency.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.resolver.BundleDescription;

/**
 * Provides some util methods to return bundles that depend on the
 * given bundle, i.e. that are callers.
 */
public class DependencyUtil {

	public static BundleDescription[] getAllBundles() {
		return Platform.getPlatformAdmin().getState(false).getBundles();
	}
	
	/**
	 * Calculates and returns a transitive closure of all dependent bundles of
	 * the given bundle.
	 * @param bundle
	 * @return
	 */
	public static Object[] getDependentBundles(Object bundle) {
		if (!(bundle instanceof BundleDescription)) {
			return new Object[0];
		}
		
		final Set dependentBundles = new HashSet();
		dependentBundles.add(bundle);
		
		calcAndAddDependentBundles(bundle, dependentBundles);
		
		return dependentBundles.toArray();
	}

	private static void calcAndAddDependentBundles(Object element, final Set dependentBundles) {
		BundleDescription bundle = (BundleDescription) element;
		final BundleDescription[] dependents = bundle.getDependents();
		for (int i = 0; i < dependents.length; i++) {
			if (!dependentBundles.contains(dependents[i])) {
				dependentBundles.add(dependents[i]);
				calcAndAddDependentBundles(dependents[i], dependentBundles);
			}
		}
	}
	
	/**
	 * Returns a set of directly dependent bundles to the given element.
	 * @param element
	 * @return
	 */
	public static Object[] getDirectDependendBundles(Object element) {
		if (!(element instanceof BundleDescription)) {
			return new Object[0];
		}
		
		final Set dependentBundles = new HashSet();
		BundleDescription bundle = (BundleDescription) element;
		
		final BundleDescription[] dependents = bundle.getDependents();
		for (int i = 0; i < dependents.length; i++) {
			if (!dependentBundles.contains(dependents[i])) {
				dependentBundles.add(dependents[i]);
			}
		}
		
		return dependentBundles.toArray();
		
	}

	/**
	 * Returns all bundles that 
	 * - are in the set of the transitive closure of dependent bundles for focussedBundle and 
	 * - that the currentBundle depends on.
	 * @param currentBundle
	 * @param focussedBundle
	 * @return
	 */
	public static Object[] getConnectedBundles(Object currentBundle, Object focussedBundle) {
		if (!(currentBundle instanceof BundleDescription)) {
			return new Object[0];
		}

		HashSet dependentBundles = new HashSet();
		dependentBundles.addAll(Arrays.asList(AnalysisUtil.getDependencies(currentBundle)));
		
		Object[] transitiveClosure = getDependentBundles(focussedBundle);
		
		List connectedBundles = new ArrayList();
		for (int i=0; i<transitiveClosure.length; i++) {
			if (dependentBundles.contains(transitiveClosure[i])) {
				connectedBundles.add(transitiveClosure[i]);
			}
		}
		return connectedBundles.toArray();
	}
	
}
