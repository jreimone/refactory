package org.ontomore.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ModelStorageUtilTest.class,
	DirectionTest.class,
	QueryUtilTest.class,
	ModelComparatorTest.class,
	EcoreModelComparatorTest.class,
	OWLModelComparatorTest.class,
	OWLEqualTest.class,
	ModelProviderTest.class,
	RefactoryUtilTest.class,
	SimpleTest.class
})
public class UtilTestSuite {

}
