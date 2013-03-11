package org.emftext.refactoring.smell.custom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellPackage;
import org.emftext.refactoring.smell.impl.ConcreteQualitySmellImpl;


public class ConcreteQualitySmellCustom extends ConcreteQualitySmellImpl {

	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	@Override
	public void eNotify(Notification notification) {
		if(SmellPackage.Literals.CONCRETE_QUALITY_SMELL__METAMODEL.equals(notification.getFeature())){
			int eventType = notification.getEventType();
			switch (eventType) {
			case Notification.SET:
				EObject newValue = (EObject) notification.getNewValue();
				if(newValue instanceof EPackage){
					EPackage metamodel = (EPackage) newValue;
					EObject container = eContainer();
					if(container != null && container instanceof QualitySmellModel){
						QualitySmellModel smellModel = (QualitySmellModel) container;
						if(!smellModel.getSmellingMetamodels().contains(metamodel)){
							smellModel.getSmellingMetamodels().add((EPackage) metamodel);
						}
					}
				}
				
//				if(newValue instanceof RoleMapping){
//					RoleMapping roleMapping = (RoleMapping) newValue;
//					if(roleMapping.eIsProxy()){
//						Map<String, Map<String, RoleMapping>> roleMappingsMap = IRoleMappingRegistry.INSTANCE.getRoleMappingsMap();
//						ResourceSet rs = null;
//						for (Map<String, RoleMapping> map : roleMappingsMap.values()) {
//							for (RoleMapping registeredRoleMapping : map.values()) {
//								rs = registeredRoleMapping.eResource().getResourceSet();
//							}
//						}
//						if(rs != null){
//							roleMapping = (RoleMapping) EcoreUtil.resolve(roleMapping, rs);
//						}
//						// Alternative um den Proxy aufzulösen
//						//						InternalEObject internal = (InternalEObject) roleMapping;
//						//						URI proxyURI = internal.eProxyURI();
//						//						ResourceSet rs2 = new ResourceSetImpl();
//						//						Resource resource = rs2.getResource(proxyURI, true);
//						//						resource.getContents().get(0);
//					}
//					EObject container = eContainer();
//					if(container != null && container instanceof QualitySmellModel){
//						QualitySmellModel smellModel = (QualitySmellModel) container;
//						EPackage metamodel = roleMapping.getOwningMappingModel().getTargetMetamodel();
//						if(!smellModel.getSmellingMetamodels().contains(metamodel)){
//							smellModel.getSmellingMetamodels().add((EPackage) metamodel);
//						}
//					}
//				}
			default:
				break;
			}
		}
		if(super.eNotificationRequired()){
			super.eNotify(notification);
		}
	}
}