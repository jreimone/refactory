/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;

/**
 * An inactive implementation of the ILocationMap interface. That is used if the
 * org.emftext.refactoring.tests.properties.resource.testproperties.ITestproperties
 * Options.DISABLE_LOCATION_MAP option is set.
 */
public class TestpropertiesDevNullLocationMap implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap {
	
	public void setLine(EObject element, int line) {
	}
	
	public int getLine(EObject element) {
		return -1;
	}
	
	public void setColumn(EObject element, int column) {
	}
	
	public int getColumn(EObject element) {
		return -1;
	}
	
	public void setCharStart(EObject element, int charStart) {
	}
	
	public int getCharStart(EObject element) {
		return -1;
	}
	
	public void setCharEnd(EObject element, int charEnd) {
	}
	
	public int getCharEnd(EObject element) {
		return -1;
	}
	
	public List<EObject> getElementsAt(final int documentOffset) {
		return Collections.<EObject>emptyList();
	}
	
	public List<EObject> getElementsBetween(final int startOffset, final int endOffset) {
		return Collections.<EObject>emptyList();
	}
	
}
