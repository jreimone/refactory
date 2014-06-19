package org.emftext.refactoring.smell.test;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping;
import org.emftext.refactoring.smell.smell_model.ModelMetric;
import org.emftext.refactoring.smell.smell_model.ModelSmell;
import org.emftext.refactoring.smell.smell_model.ModelSmellResult;
import org.emftext.refactoring.smell.smell_model.Quality;
import org.emftext.refactoring.smell.smell_model.Quality_ModelSmell_Mapping;
import org.emftext.refactoring.smell.smell_model.Smell_modelFactory;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class Test_ModelSmellResult extends TestCase {
	
	ModelSmellResult result;
	
	public Test_ModelSmellResult(String name){
		super(name);
	}

	protected void setUp(){
		result = Smell_modelFactory.eINSTANCE.createModelSmellResult();
	}
	
	protected void tearDown(){
		
	}
	
	public void testCalculate(){
		result.calculate(new BasicEList<Metric_Quality_Mapping>(), new BasicEList<Quality_ModelSmell_Mapping>(), new HashMap<ModelMetric, Map<EObject, Float>>(), new HashMap<Quality, Float>());
		assertEquals(new HashMap<ModelSmell, Map<EObject, Float>>(), result.getResult());
		result.calculate(null, null, null, null);
		assertEquals(new HashMap<ModelSmell, Map<EObject, Float>>(), result.getResult());
	}
	
	public static void main(String[] args) {
		TestSuite suite = new TestSuite(Test_ModelSmellResult.class);
		TestResult result = new TestResult();
		suite.run(result);
	}
}
