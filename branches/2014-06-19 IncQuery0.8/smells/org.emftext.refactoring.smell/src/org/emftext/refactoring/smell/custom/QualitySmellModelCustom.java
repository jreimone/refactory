package org.emftext.refactoring.smell.custom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.impl.QualitySmellModelImpl;


public class QualitySmellModelCustom extends QualitySmellModelImpl {

	/**
	 * @model
	 */
	@Override
	public EList<ConcreteQualitySmell> getSmellsForMetamodel(EPackage metamodel) {
		EPackage rootPackage = metamodel;
		while(rootPackage.getESuperPackage() != null){
			rootPackage = rootPackage.getESuperPackage();
		}
		EList<ConcreteQualitySmell> metamodelSmells = new BasicEList<ConcreteQualitySmell>();
		for (ConcreteQualitySmell smell : getConcreteSmells()) {
			EcoreUtil.resolveAll(smell);
			if(smell.getMetamodel().equals(rootPackage)){
				metamodelSmells.add(smell);
			}
		}
		return metamodelSmells;
	}

	public EList<EPackage> getSmellingMetamodels() {
		EList<EPackage> smellingMetamodels = ECollections.newBasicEList();
		for (ConcreteQualitySmell concreteSmell : getConcreteSmells()) {
			EPackage metamodel = concreteSmell.getMetamodel();
			if(!smellingMetamodels.contains(metamodel)){
				smellingMetamodels.add(metamodel);
			}
		}
		return smellingMetamodels;
	}
}