/**
 * 
 */
package org.modelrefactoring.evolution.cods.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.modelrefactoring.evolution.megamodel.architecture.ArchitecturePackage;

/**
 * @author jreimann
 *
 */
public class TransformationModelView extends AbstractModelView {
	
	@Override
	public EObject getObservableParent() {
		return getMegaModel();
	}

	@Override
	public EReference getObservableDisplayFeature() {
		return ArchitecturePackage.Literals.TRANSFORMATION_MODEL__TRANSFORMATION;
	}

	@Override
	public EReference getObservableParentToObservableFeature() {
		return ArchitecturePackage.Literals.MEGA_MODEL__TRANSFORMATION_MODELS;
	}
}
