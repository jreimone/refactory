package org.ontomore.test;

import static org.junit.Assert.assertEquals;

import org.emftext.language.owl.Class;
import org.emftext.language.owl.ClassAtomic;
import org.emftext.language.owl.Conjunction;
import org.emftext.language.owl.Disjunction;
import org.emftext.language.owl.OwlFactory;
import org.junit.Test;

public class OWLEqualTest {

	@Test
	public void testReferencedClassIsEqualToRealClass() {
		Class superClass = OwlFactory.eINSTANCE.createClass();
		Class subClass = OwlFactory.eINSTANCE.createClass();
		setSuperClass(subClass, superClass);
		Class referencedSuperClass = getFirstSuperClass(subClass);
		assertEquals("Superclass and referenced superclass should be equal", superClass,
				referencedSuperClass);
	}

	private void setSuperClass(Class subClass, Class superClass) {
		Disjunction disjunction = OwlFactory.eINSTANCE.createDisjunction();
		subClass.getSuperClassesDescriptions().add(disjunction);
		Conjunction conjunction = OwlFactory.eINSTANCE.createConjunction();
		disjunction.getConjunctions().add(conjunction);
		ClassAtomic classAtomic = OwlFactory.eINSTANCE.createClassAtomic();
		conjunction.getPrimaries().add(classAtomic);
		classAtomic.setClazz(superClass);
	}

	private Class getFirstSuperClass(Class subClass) {
		Disjunction disjunction = (Disjunction) subClass.getSuperClassesDescriptions().get(0);
		Conjunction conjunction = (Conjunction) disjunction.getConjunctions().get(0);
		ClassAtomic classAtomic = (ClassAtomic) conjunction.getPrimaries().get(0);
		return classAtomic.getClazz();
	}
}
