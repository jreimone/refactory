package org.emftext.refactoring.smell.custom;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.SmellPackage;
import org.emftext.refactoring.smell.impl.QualitySmellModelImpl;


public class QualitySmellModelCustom extends QualitySmellModelImpl {

	/**
	 * @model
	 */
	@Override
	public EList<ConcreteQualitySmell> getSmellsForMetamodel(EPackage metamodel) {
		while(metamodel.getESuperPackage() != null){
			metamodel = metamodel.getESuperPackage();
		}
		EList<ConcreteQualitySmell> metamodelSmells = new BasicEList<>();
		for (ConcreteQualitySmell smell : getConcreteSmells()) {
			EcoreUtil.resolveAll(smell);
			if(smell.getMetamodel().equals(metamodel)){
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
					EPackage metamodel = ((ConcreteQualitySmell) newValue).getMetamodel();
					if(metamodel != null && !getSmellingMetamodels().contains(metamodel)){
						getSmellingMetamodels().add((EPackage) metamodel);
					}
				}
				break;
			case Notification.REMOVE:
				EObject oldValue = (EObject) notification.getOldValue();
				if(oldValue instanceof ConcreteQualitySmell){
					EPackage metamodelOldValue = ((ConcreteQualitySmell) oldValue).getMetamodel();
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
						EPackage metamodel = concreteQualitySmell.getMetamodel();
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