package org.emftext.refactoring.smell.test;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

import org.emftext.refactoring.smell.smell_model.ModelSmellModel;
import org.emftext.refactoring.smell.smell_model.Observer;
import org.emftext.refactoring.smell.smell_model.Quality;
import org.emftext.refactoring.smell.smell_model.Smell_modelFactory;
import org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl;
import org.emftext.refactoring.smell.smell_model.ui.View_Tree;

public class Test_ModelSmellModel extends TestCase {
	
	ModelSmellModel model;
	
	public Test_ModelSmellModel(String name){
		super(name);
	}

	protected void setUp(){
		model = ModelSmellModelImpl.getMain();
	}
	
	protected void tearDown(){
		
	}
	
	public void testCalculate(){
		model.calculate();
		assertNotNull(model.getResult());
	}
	
	public void testInit(){
		assertNotNull(model.getModelSmells());
		assertNotNull(model.getQualities());
		assertNotNull(model.getMetrics());
		assertNotNull(model.getQuality_modelSmell());
		assertNotNull(model.getMetric_quality());
		assertNotNull(model.getModelSmell_roleMapping());
		assertNotNull(model.getQualityScale());
		assertNotNull(model.getMarkerRefactoring());
		assertEquals(0.5f, model.getThreshold());
	}

	public void testSetQualityScale(){
		Quality test =  Smell_modelFactory.eINSTANCE.createQuality();
		model.setQualityScale(test, 1.0f);
		assertTrue(model.getQualityScale().containsKey(test));
	}
	
	public void testRegister(){
		Observer o = new View_Tree();
		model.register(o);
		assertTrue(model.getObserver().contains(o));
		model.unregister(o);
		assertTrue(!model.getObserver().contains(o));
	}

	public static void main(String[] args) {
		TestSuite suite = new TestSuite(Test_ModelSmellModel.class);
		TestResult result = new TestResult();
		suite.run(result);
	}
}
