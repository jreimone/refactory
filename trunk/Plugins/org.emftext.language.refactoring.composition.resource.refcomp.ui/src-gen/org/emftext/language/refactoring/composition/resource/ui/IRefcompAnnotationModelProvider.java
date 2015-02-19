/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import org.eclipse.jface.text.source.IAnnotationModel;

/**
 * A provider for annotation models.
 */
public interface IRefcompAnnotationModelProvider {
	
	/**
	 * Returns the annotation model.
	 */
	public IAnnotationModel getAnnotationModel();
	
}
