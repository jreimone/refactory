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
public class InstanceModelView extends AbstractModelView {

	@Override
	public List<? extends EObject> getContent2Display() {
		return getMegaModel().getInstanceModels();
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
//			if(operation.getName().equals("getInstanceModels")){
//				return "instanceModels";
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public Class<?> getObservableEClass() {
//		return InstanceModel.class;
//	}
//
//	@Override
//	public String getObservableDisplayFeatureName() {
//		return ArchitecturePackage.Literals.INSTANCE_MODEL__MODEL.getName();
//	}

}
