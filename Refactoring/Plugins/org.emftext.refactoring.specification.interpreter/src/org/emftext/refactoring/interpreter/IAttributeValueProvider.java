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
/**
 * 
 */
package org.emftext.refactoring.interpreter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

/**
 * This interface should be used for simple values to be provided by the user. Those
 * can for example be a name for a new class. If clients use this value provider, 
 * its visual presentation will only be added with others to one {@link Composite}.
 * 
 * @author Jan Reimann
 *
 */
public interface IAttributeValueProvider extends IValueProvider<EAttribute, Object> {


	/**
	 * Returns the attribute for which the value should be provided.
	 * @return
	 */
	public EAttribute getAttribute();
	
	/**
	 * Returns the owner of the attribute.
	 * @return
	 */
	public EObject getAttributeOwner();

	/**
	 * Returns the owner of the fake attribute.
	 * @return
	 */
	public EObject getFakeAttributeOwner();
	
	/**
	 * Returns whether the given <code>text</code> is valid for this attribute
	 * @param text 
	 * @return
	 */
	public boolean isValueValid(String text);
}
