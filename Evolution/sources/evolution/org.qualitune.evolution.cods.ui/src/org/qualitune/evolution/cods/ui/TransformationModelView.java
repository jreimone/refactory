/**
 * 
 */
package org.qualitune.evolution.cods.ui;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @author jreimann
 *
 */
public class TransformationModelView extends AbstractModelView {

	@Override
	public List<? extends EObject> getContent2Display() {
		return getMegaModel().getTransformationModels();
	}
	
//	@Override
//	public EObject getObservableParent() {
//		return getMegaModel();
//	}
//
//	@Override
//	public String getObservableParentToObservableFeatureName() {
//		List<EOperation> operations = ArchitecturePackage.Literals.MEGA_MODEL.getEOperations();
//		for (EOperation operation : operations) {
//			if(operation.getName().equals("getTransformationModels")){
//				return "transformationModels";
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public Class<?> getObservableEClass() {
//		return TransformationModel.class;
//	}
//
//	@Override
//	public String getObservableDisplayFeatureName() {
//		return ArchitecturePackage.Literals.TRANSFORMATION_MODEL__TRANSFORMATION.getName();
//	}

}
