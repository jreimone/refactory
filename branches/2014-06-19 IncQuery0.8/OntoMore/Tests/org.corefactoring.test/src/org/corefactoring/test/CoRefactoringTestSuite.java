package org.corefactoring.test;

import org.corefactoring.modelelementmapper.test.MetaModelMapperTest;
import org.corefactoring.modelregistry.test.ModelRegistryTest;
import org.corefactoring.rolemappingregistry.test.RoleMappingRegistryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.ontomore.test.UtilTestSuite;
import org.ontomore.transformation.test.OWL2EcoreTransformerTest;

// runs all tests
@RunWith(Suite.class)
@SuiteClasses({
	OWL2EcoreTransformerTest.class,
	UtilTestSuite.class,
	ModelRegistryTest.class,
	RoleMappingRegistryTest.class,
	MetaModelMapperTest.class,
	OWLRefactoringTest.class, 
	EcoreRefactoringTest.class,
	CoRefactoringTest.class
})
public class CoRefactoringTestSuite {
}
