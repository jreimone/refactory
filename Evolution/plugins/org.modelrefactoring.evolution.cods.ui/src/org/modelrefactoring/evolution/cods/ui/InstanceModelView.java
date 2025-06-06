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
public class InstanceModelView extends AbstractModelView {

	@Override
	public EObject getObservableParent() {
		return getMegaModel();
	}

	@Override
	public EReference getObservableParentToObservableFeature() {
		return ArchitecturePackage.Literals.MEGA_MODEL__INSTANCE_MODELS;
	}

	@Override
	public EReference getObservableDisplayFeature() {
		return ArchitecturePackage.Literals.INSTANCE_MODEL__MODEL;
	}

}
