package org.qualitune.evolution.cods.ui;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @author jreimann
 *
 */
public abstract class InvertableSorter extends ViewerSorter {

	public abstract int compare(Viewer viewer, Object e1, Object e2);
	 
	abstract InvertableSorter getInverseSorter();
 
	public abstract int getSortDirection();
}