package org.qualitune.refactoring.energy.test;

import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.Model;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;

import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

public class UMLSequence2Java {

	public CompilationUnit transform(Model umlModel) {
		CompilationUnit compilationUnit = ContainersFactory.eINSTANCE.createCompilationUnit();
		UnmodifiableIterator<Lifeline> lifelines = Iterators.filter(umlModel.eAllContents(), Lifeline.class);
		while (lifelines.hasNext()) {
			Lifeline lifeline = lifelines.next();
			Class clazz = createClassFromLifeline(lifeline);
			compilationUnit.getClassifiers().add(clazz);
		}
		return compilationUnit;
	}

	private Class createClassFromLifeline(Lifeline lifeline) {
		Class clazz = ClassifiersFactory.eINSTANCE.createClass();
		clazz.setName(lifeline.getRepresents().getType().getName());
		for (InteractionFragment fragment : lifeline.getCoveredBys()) {
			if(fragment instanceof MessageOccurrenceSpecification){
				MessageOccurrenceSpecification mos = (MessageOccurrenceSpecification) fragment;
				if(mos.getMessage().getReceiveEvent().equals(mos)){
					// incoming message
				}
			}
		}
		return clazz;
	}
}
