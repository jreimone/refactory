package org.ontomore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.emftext.language.owl.Class;
import org.emftext.language.owl.ClassAtomic;
import org.emftext.language.owl.Conjunction;
import org.emftext.language.owl.Disjunction;
import org.emftext.language.owl.Ontology;
import org.emftext.language.owl.OntologyDocument;
import org.junit.Before;
import org.junit.Test;
import org.ontomore.util.ModelComparator;
import org.ontomore.util.ModelStorageUtil;

public class OWLModelComparatorTest {


	private String base = ModelStorageUtil.getBase("org.ontomore.test");
	private ModelComparator modelComparator;

	@Before
	public void setUp() {
		modelComparator = new ModelComparator();
	}

	@Test
	public void testOntologiesAreEqualUsingMatchAndDiff() {
		assertTrue(modelComparator.areModelsEqual(base + "OWLModelComparatorTest/simpleOntology_1.owl",
				base + "OWLModelComparatorTest/simpleOntology_2.owl"));
	}

	@Test
	public void testReferencedClassIsEqualToRealClass() {
		OntologyDocument ontologyDocument = (OntologyDocument) ModelStorageUtil
				.loadModelFromFileName(base + "OWLModelComparatorTest/simpleOntology_1.owl");
		Ontology ontology = ontologyDocument.getOntology();
		Class superClass = (Class) ontology.getFrames().get(0);
		Class subClass = (Class) ontology.getFrames().get(1);
		Class referencedSuperClass = getFirstSuperClass(subClass);
		assertEquals("Superclass and referenced superclass should be equal", superClass,
				referencedSuperClass);
	}

	private Class getFirstSuperClass(Class subClass) {
		Disjunction disjunction = (Disjunction) subClass.getSuperClassesDescriptions().get(0);
		Conjunction conjunction = (Conjunction) disjunction.getConjunctions().get(0);
		ClassAtomic classAtomic = (ClassAtomic) conjunction.getPrimaries().get(0);
		return classAtomic.getClazz();
	}

}
