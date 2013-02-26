package org.emftext.refactoring.smell.custom;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.SmellPackage;
import org.emftext.refactoring.smell.impl.QualitySmellModelImpl;


public class QualitySmellModelCustom extends QualitySmellModelImpl {

	@Override
	public EList<ConcreteQualitySmell> getSmellsForMetamodel(EPackage metamodel) {
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
		//		return super.eNotificationRequired();
		return true;
	}

	@Override 
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		if(SmellPackage.Literals.QUALITY_SMELL_MODEL__CONCRETE_SMELLS.equals(notification.getFeature())){
			int eventType = notification.getEventType();
			switch (eventType) {
			case Notification.ADD:
				EObject newValue = (EObject) notification.getNewValue();
				if(newValue instanceof ConcreteQualitySmell){
					EPackage metamodel = ((ConcreteQualitySmell) newValue).getRefactoring().getOwningMappingModel().getTargetMetamodel();
					if(!getSmellingMetamodels().contains(metamodel)){
						getSmellingMetamodels().add((EPackage) metamodel);
					}
				}
				break;
			case Notification.REMOVE:
				EObject oldValue = (EObject) notification.getOldValue();
				if(oldValue instanceof ConcreteQualitySmell){
					EPackage metamodelOldValue = ((ConcreteQualitySmell) oldValue).getRefactoring().getOwningMappingModel().getTargetMetamodel();
					Set<EPackage> smellingMetamodels = new HashSet<>();
					for (ConcreteQualitySmell existingSmell : getConcreteSmells()) {
						EPackage smellingMetamodel = existingSmell.getRefactoring().getOwningMappingModel().getTargetMetamodel();
						smellingMetamodels.add(smellingMetamodel);
					}
					if(!smellingMetamodels.contains(metamodelOldValue)){
						getSmellingMetamodels().remove(metamodelOldValue);
					}
				}
				break;
			default:
				break;
			}
		}

	}
}