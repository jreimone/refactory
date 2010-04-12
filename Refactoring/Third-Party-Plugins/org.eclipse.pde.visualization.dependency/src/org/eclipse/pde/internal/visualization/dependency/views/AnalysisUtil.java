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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.osgi.service.resolver.ExportPackageDescription;

/**
 * General utility classes for dealing with bundle dependencies.
 * @author Ian Bull
 * 
 */
public class AnalysisUtil {

	public static Object[] getPath(Object root, Object bundle) {
		LinkedList q = new LinkedList();
		Set orderedSet = new HashSet();
		LinkedList orderedList = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			Object head = q.remove(0);
			if (!orderedSet.contains(head)) {
				orderedSet.add(head);
				orderedList.add(head);
				buildQueue(head, q);
			}
		}
		Object[] path = modifiedDijkstra(orderedList, root, bundle);
		return path;
	}

	private static void buildQueue(Object root, LinkedList q) {
		Object[] descriptions = getDependencies(root);
		if (descriptions == null || descriptions.length == 0) {
			return;
		}
		for (int i = 0; i < descriptions.length; i++) {
			q.add(descriptions[i]);
		}
	}

	public static Object[] modifiedDijkstra(LinkedList q, Object s, Object t) {
		HashMap previous = new HashMap();
		HashMap dValues = new HashMap();
		for (Iterator iter = q.iterator(); iter.hasNext();) {
			dValues.put(iter.next(), new Integer(Integer.MAX_VALUE / 10));
		}
		dValues.put(s, new Integer(0));

		while (!q.isEmpty()) {
			Object head = q.remove(0);
			Object[] outgoing = getDependencies(head);
			if (outgoing == null) {
				// @tag PDE bug : I get null in my array of dependencies 
				continue;
			}
			for (int i = 0; i < outgoing.length; i++) {
				Object v = outgoing[i];
				if (((Integer) dValues.get(head)).intValue() + 1 < ((Integer) dValues.get(v)).intValue()) {
					previous.put(v, head);
					dValues.put(v, new Integer(((Integer) dValues.get(head)).intValue() + 1));
				}
			}
		}
		LinkedList path = new LinkedList();
		Object currentNode = t;
		while (previous.containsKey(currentNode)) {
			path.add(currentNode);
			currentNode = previous.get(currentNode);
		}
		path.add(currentNode);
		return path.toArray(new Object[path.size()]);
	}

	public static BundleDescription[] getCallers(BundleDescription bundle, BundleDescription[] bundles) {
		HashSet callers = new HashSet();
		for (int i = 0; i < bundles.length; i++) {
			HashSet hashSet = new HashSet();
			hashSet.addAll(Arrays.asList(getDependencies(bundles[i])));
			if (hashSet.contains(bundle)) {
				callers.add(bundles[i]);
			}
		}
		return (BundleDescription[]) callers.toArray(new BundleDescription[callers.size()]);
	}

	/**
	 * Finds all the callers for bundle within bunldes[]
	 * 
	 * @return
	 */
	public static Object[] getAllCallers(Object bundle, Object[] bundles) {
		HashSet callers = new HashSet();
		for (int i = 0; i < bundles.length; i++) {
			HashSet hashSet = new HashSet();
			hashSet.addAll(Arrays.asList(getPrerequisites(new Object[] { bundles[i] })));
			if (hashSet.contains(bundle)) {
				callers.add(bundles[i]);
			}
		}
		return callers.toArray(new Object[callers.size()]);
	}

	public static Object[] getPrerequisites(Object[] bundles) {
		if (bundles == null || bundles.length == 0) {
			return new BundleDescription[0];
		}
		Set reachable = new HashSet(bundles.length);
		for (int i = 0; i < bundles.length; i++) {
			addPrerequisites(bundles[i], reachable);
		}
		return reachable.toArray(new Object[reachable.size()]);
	}

	private static Collection getExportedDescription(BundleDescription element, ExportPackageDescription[] exportedPackages) {
		Set descriptionList = new HashSet();
		for (int i = 0; i < exportedPackages.length; i++) {
			ExportPackageDescription exportedPackage = exportedPackages[i];
			if (!element.getLocation().equals(exportedPackage.getExporter().getLocation())) {
				descriptionList.add(exportedPackage.getExporter());
			}
		}
		return descriptionList;
	}

	
	public static Object[] getDependencies(Object bundle) {

		if (bundle == null || bundle instanceof BundleSpecification) {
			return new Object[0];
		}
		BundleDescription bundleDescription = (BundleDescription) bundle;

		Collection c = AnalysisUtil.getDescription(bundleDescription.getRequiredBundles());
		c.addAll(getExportedDescription(bundleDescription, bundleDescription.getResolvedImports()));
		
		if (bundleDescription.getHost() != null) {
			c.add(bundleDescription.getHost().getSupplier());
		}
		
		/*
		 * Iterator iterator = c.iterator(); while (iterator.hasNext() ) { if (
		 * iterator.next() == null ) iterator.remove(); }
		 */

		return c.toArray(new Object[c.size()]);
	}

	private static void addPrerequisites(Object bundle, Set reachable) {
		if (reachable.contains(bundle)) {
			return;
		}
		reachable.add(bundle);

		Object[] dependencies = getDependencies(bundle);
		for (int i = 0; i < dependencies.length; i++) {
			if (dependencies[i] instanceof BundleSpecification ) {
				reachable.add(dependencies[i]);
			}
			else {
				addPrerequisites(dependencies[i], reachable);
			}
		}
	}

	public static Collection getDescription(BundleSpecification[] specifications) {
		ArrayList descriptionList = new ArrayList();
		for (int i = 0; i < specifications.length; i++) {
			BundleSpecification specification = specifications[i];
			if ( specification.getSupplier() == null ) {
				// We can't get a description, so just keep the bundle specification
				descriptionList.add(specification);
			}
			else {
				descriptionList.add(specification.getSupplier());
			}
		}
		return descriptionList;
	}

}
