package org.ontomore.test;

import static org.junit.Assert.assertEquals;
import static org.ontomore.util.CoRefactoryConstants.ECORE_METAMODEL;
import static org.ontomore.util.CoRefactoryConstants.OWL_METAMODEL;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.emftext.language.owl.OwlFactory;
import org.junit.Test;
import org.ontomore.util.Direction;
import org.ontomore.util.Ecore2OWLDirection;
import org.ontomore.util.OWL2EcoreDirection;

public class DirectionTest {

	@Test
	public void testInitialisation() {
		EObject sourceModel = OwlFactory.eINSTANCE.createOntologyDocument();
		EObject targetModel = EcoreFactory.eINSTANCE.createEPackage();
		Direction direction = new Direction(sourceModel, targetModel);
		assertEquals(OWL_METAMODEL, direction.getSource());
		assertEquals(ECORE_METAMODEL, direction.getTarget());
	}
	
	@Test
	public void testOWL2EcoreDirection() {
		Direction owl2ecore = new OWL2EcoreDirection();
		EObject sourceModel = OwlFactory.eINSTANCE.createOntologyDocument();
		EObject targetModel = EcoreFactory.eINSTANCE.createEPackage();
		Direction direction = new Direction(sourceModel, targetModel);
		
		assertEquals(direction, owl2ecore);
	}
	
	@Test
	public void testEcore2OWLDirection() {
		Direction ecore2owl = new Ecore2OWLDirection();
		EObject sourceModel = EcoreFactory.eINSTANCE.createEPackage();
		EObject targetModel = OwlFactory.eINSTANCE.createOntologyDocument();
		Direction direction = new Direction(sourceModel, targetModel);
		
		assertEquals(direction, ecore2owl);
	}
}
