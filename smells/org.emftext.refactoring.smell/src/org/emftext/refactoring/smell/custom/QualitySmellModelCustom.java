package org.emftext.refactoring.smell.custom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
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
	
}