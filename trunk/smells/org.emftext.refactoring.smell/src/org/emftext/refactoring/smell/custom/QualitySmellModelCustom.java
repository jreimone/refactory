package org.emftext.refactoring.smell.custom;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.SmellPackage;
import org.emftext.refactoring.smell.impl.QualitySmellModelImpl;


public class QualitySmellModelCustom extends QualitySmellModelImpl {

	@Override
	public EList<ConcreteQualitySmell> getSmellsForMetamodel(EPackage metamodel) {
		while(metamodel.getESuperPackage() != null){
			metamodel = metamodel.getESuperPackage();
		}
		EList<ConcreteQualitySmell> metamodelSmells = new BasicEList<>();
		for (ConcreteQualitySmell smell : getConcreteSmells()) {
			if(smell.getRefactoring().getOwningMappingModel().getTargetMetamodel().equals(metamodel)){
				metamodelSmells.add(smell);
			}
		}
		return metamodelSmells;
	}

	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	@Override 
	public void eNotify(Notification notification) {
		if(SmellPackage.Literals.QUALITY_SMELL_MODEL__CONCRETE_SMELLS.equals(notification.getFeature())){
			int eventType = notification.getEventType();
			switch (eventType) {
			case Notification.ADD:
				EObject newValue = (EObject) notification.getNewValue();
				if(newValue instanceof ConcreteQualitySmell){
					RoleMapping refactoring = ((ConcreteQualitySmell) newValue).getRefactoring();
					if(refactoring != null){
						EPackage metamodel = refactoring.getOwningMappingModel().getTargetMetamodel();
						if(!getSmellingMetamodels().contains(metamodel)){
							getSmellingMetamodels().add((EPackage) metamodel);
						}
					}
				}
				break;
			case Notification.REMOVE:
				EObject oldValue = (EObject) notification.getOldValue();
				if(oldValue instanceof ConcreteQualitySmell){
					EPackage metamodelOldValue = ((ConcreteQualitySmell) oldValue).getRefactoring().getOwningMappingModel().getTargetMetamodel();
					List<ConcreteQualitySmell> smellsForMetamodel = getSmellsForMetamodel(metamodelOldValue);
					if(smellsForMetamodel.size() == 0){
						getSmellingMetamodels().remove(metamodelOldValue);
					}
				}
				break;
			case Notification.REMOVE_MANY:
				Object value = notification.getOldValue();
				if(value instanceof List<?>){
					@SuppressWarnings("unchecked")
					List<ConcreteQualitySmell> smellsToRemove = (List<ConcreteQualitySmell>) value;
					for (ConcreteQualitySmell concreteQualitySmell : smellsToRemove) {
						EPackage metamodel = concreteQualitySmell.getRefactoring().getOwningMappingModel().getTargetMetamodel();
						List<ConcreteQualitySmell> smellsForMetamodel = getSmellsForMetamodel(metamodel);
						if(smellsForMetamodel.size() == 0){
							getSmellingMetamodels().remove(metamodel);
						}
					}
				}
			default:
				break;
			}
		}
		if(super.eNotificationRequired()){
			super.eNotify(notification);
		}
	}
}