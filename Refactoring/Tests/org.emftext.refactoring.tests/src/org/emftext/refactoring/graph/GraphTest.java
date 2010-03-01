package org.emftext.refactoring.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.pl0.PL0Factory;
import org.emftext.language.pl0.Program;
import org.emftext.refactoring.graph.util.GraphUtil;
import org.emftext.refactoring.graph.util.IPath;
import org.emftext.refactoring.graph.util.LinkedListPath;
import org.emftext.refactoring.graph.util.PathAlgorithmFactory;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.test.test.AbstractRefactoringTest;
import org.junit.Ignore;
import org.junit.Test;

public class GraphTest{

//	private EObject model;
	private String path = "/resources/p1.pl0";
	private Resource resource;

	@Ignore("not yet")
	@Test
	public void findNodeByNameAndType(){
//		resource = TestUtil.getResourceInWorkspace(this, path);
		assertNotNull("Resource mustn't be null", resource);
		EObject object = GraphUtil.findFirstNodeByNameAndType(resource, Program.class, "name", "p1");
		assertNotNull("Requested object not found", object);
	}
	
	
//	Program
//	  |__+Block
//	    |__]VarDeclaration
//	    |__]ConstDeclaration
//	    |__+Body
//	      |__+Statement
//	        |__]CallStatement
//	        |__+IfStatement
//	          |__+Condition
//	            |__+OddCondition
//	    |__*ProcedureDeclaration
//	              |__+Expression
//	                |__+TermExpression
//	                  |__+Term
//	                    |__+Factor
//	                      |__]IdentReference
//	                      |__]Number
//	                      |__+ExpressionFactor
//	                        |__~Expression
//	                    |__+OptionalFactor
//	                      |__~Factor
//	                  |__+OptionalTerm
//	                    |__~Term
//	            |__+RelationalCondition
//	              |__~Expression
//	              |__~Expression
//	          |__~Body
//	        |__+WhileStatement
//	        |__+Assignment
//	          |__~Body
//	          |__~Condition
//	          |__~Body
//	          |__~Expression
	@Ignore("not yet")
	@Test
	public void findShortestPathForPL0(){
		PathAlgorithmFactory algoFactory = new PathAlgorithmFactory();
		assertNotNull("Factory mustn't be null", algoFactory);
		IShortestPathAlgorithm algo = algoFactory.getAlgorithm();
		assertNotNull("Default algorithm mustn't be null", algo);
		PL0Factory pl0Factory = PL0Factory.eINSTANCE;
		EObject source = pl0Factory.createProgram();
		assertNotNull("Source mustn't be null", algo);
		EObject target = pl0Factory.createProcedureDeclaration();
		assertNotNull("Target mustn't be null", algo);
		List<IPath> paths = algo.calculatePaths( source, target);
		assertNotNull("There must be a shortest path", paths);
		IPath expectedPath = new LinkedListPath();
		EObject program = pl0Factory.createProgram();
		EObject block = pl0Factory.createBlock();
		EObject procedure = pl0Factory.createProcedureDeclaration();
		expectedPath.add(program.eClass());
		expectedPath.add(block.eClass());
		expectedPath.add(procedure.eClass());
		List<IPath> expectedPaths = new ArrayList<IPath>();
		expectedPaths.add(expectedPath);
		assertEquals("Expected paths and calculated paths should be the same", expectedPaths, paths);
	}
	
	@Ignore("not yet")
	@Test
	public void findShortestPathClassToClassMethodJava(){
		PathAlgorithmFactory algoFactory = new PathAlgorithmFactory();
		assertNotNull("Factory mustn't be null", algoFactory);
		IShortestPathAlgorithm algo = algoFactory.getAlgorithm();
		assertNotNull("Default algorithm mustn't be null", algo);
//		JavaFactory javaFactory = JavaFactory.eINSTANCE;
		EObject source = ClassifiersFactory.eINSTANCE.createClass();
		assertNotNull("Source mustn't be null", algo);
		EObject target = MembersFactory.eINSTANCE.createClassMethod();
		assertNotNull("Target mustn't be null", algo);
		List<IPath> paths = algo.calculatePaths( source, target);
		assertNotNull("There must be a shortest path", paths);
		IPath expectedPath = new LinkedListPath();
		expectedPath.add((EClass) ClassifiersFactory.eINSTANCE.getEPackage().getEClassifier("Class"));
		expectedPath.add((EClass) MembersFactory.eINSTANCE.getEPackage().getEClassifier("Member"));
		expectedPath.add((EClass) MembersFactory.eINSTANCE.getEPackage().getEClassifier("ClassMethod"));
		List<IPath> expectedPaths = new ArrayList<IPath>();
		expectedPaths.add(expectedPath);
		assertEquals("Expected paths and calculated paths should be the same", expectedPaths, paths);
	}
	
	@Ignore("not yet")
	@Test
	public void findShortestPathClassMethodToMethodCallJava(){
		PathAlgorithmFactory algoFactory = new PathAlgorithmFactory();
		assertNotNull("Factory mustn't be null", algoFactory);
		IShortestPathAlgorithm algo = algoFactory.getAlgorithm();
		algo.setOutput(true);
		assertNotNull("Default algorithm mustn't be null", algo);
//		JavaFactory javaFactory = JavaFactory.eINSTANCE;
		EObject source = MembersFactory.eINSTANCE.createClassMethod();
		assertNotNull("Source mustn't be null", algo);
		EObject target = ReferencesFactory.eINSTANCE.createMethodCall();
		assertNotNull("Target mustn't be null", algo);
		List<IPath> paths = algo.calculatePaths( source, target);
		assertNotNull("There must be a shortest path", paths);
		IPath expectedPath = new LinkedListPath();
		expectedPath.add((EClass) MembersFactory.eINSTANCE.getEPackage().getEClassifier("ClassMethod"));
//		expectedPath.add((EClass) MembersFactory.eINSTANCE.getEPackage().getEClassifier("Member"));
		expectedPath.add((EClass) ReferencesFactory.eINSTANCE.getEPackage().getEClassifier("MethodCall"));
		List<IPath> expectedPaths = new ArrayList<IPath>();
		expectedPaths.add(expectedPath);
		assertEquals("Expected paths and calculated paths should be the same", expectedPaths, paths);
	}
	
//	ProcedureDeclaration
//	  |__+Block
//	    |__]VarDeclaration
//	    |__]ConstDeclaration
//	    |__~ProcedureDeclaration
//	        |__*CallStatement
//	    |__+Body
//	      |__+Statement
//	        |__+IfStatement
//	          |__+Condition
//	            |__+OddCondition
//	              |__+Expression
//	                |__+TermExpression
//	                  |__+Term
//	                    |__+Factor
//	                      |__]IdentReference
//	                      |__]Number
//	                      |__+ExpressionFactor
//	                        |__~Expression
//	                    |__+OptionalFactor
//	                      |__~Factor
//	                  |__+OptionalTerm
//	                    |__~Term
//	              |__~Expression
//	              |__~Expression
//	          |__~Body
//	          |__~Body
//	            |__+RelationalCondition
//	        |__+WhileStatement
//	          |__~Condition
//	          |__~Body
//	        |__+Assignment
//	          |__~Expression
	@Ignore("not yet")
	@Test
	public void findPathFromProcedureToCallStatementAndRemoveAbstractClassesPL0(){
		PathAlgorithmFactory algoFactory = new PathAlgorithmFactory();
		assertNotNull("Factory mustn't be null", algoFactory);
		IShortestPathAlgorithm algo = algoFactory.getAlgorithm();
		assertNotNull("Default algorithm mustn't be null", algo);
		PL0Factory pl0Factory = PL0Factory.eINSTANCE;
		EObject source = pl0Factory.createProcedureDeclaration();
		assertNotNull("Source mustn't be null", algo);
		EObject target = pl0Factory.createCallStatement();
		assertNotNull("Target mustn't be null", algo);
		List<IPath> paths = algo.calculatePaths( source, target);
		assertNotNull("There must be a shortest path", paths);
		assertEquals("There must be 1 shortest path", 1, paths.size());
		IPath path = paths.get(0);
		IPath expectedPath = new LinkedListPath();
		expectedPath.add((EClass) pl0Factory.getPL0Package().getEClassifier("ProcedureDeclaration"));
		expectedPath.add((EClass) pl0Factory.getPL0Package().getEClassifier("Block"));
		expectedPath.add((EClass) pl0Factory.getPL0Package().getEClassifier("Body"));
		EClass statement = (EClass) pl0Factory.getPL0Package().getEClassifier("Statement");
		expectedPath.add(statement);
		expectedPath.add((EClass) pl0Factory.getPL0Package().getEClassifier("CallStatement"));
		assertTrue("Both path's must be the same", path.equals(expectedPath));
		assertTrue("An abstract class must be removed", expectedPath.remove(statement));
		assertTrue("An abstract class must be removed", path.removeAbstractEClasses());
		assertEquals("Both path's must be the same, especially without abstract classes", expectedPath, path);
	}
	
	@Ignore("not yet")
	@Test
	public void getAllSubTypesForAbstractSuperclass(){
		EClass abstractSuper = (EClass) PL0Factory.eINSTANCE.getPL0Package().getEClassifier("Statement");
		EList<EClass> subTypes = GraphUtil.getAllSubTypes(abstractSuper);
		assertNotNull("Metaclass Statement must have 4 subtypes", subTypes);
		assertEquals("Metaclass Statement must have 4 subtypes", 4, subTypes.size());
	}
	
	@Ignore("not yet")
	@Test
	public void findPathOptionalTermToTermPL0(){
		PathAlgorithmFactory algoFactory = new PathAlgorithmFactory();
		assertNotNull("Factory mustn't be null", algoFactory);
		IShortestPathAlgorithm algo = algoFactory.getAlgorithm();
//		algo.setOutput(true);
		assertNotNull("Default algorithm mustn't be null", algo);
		PL0Factory pl0Factory = PL0Factory.eINSTANCE;
		EObject source = pl0Factory.createOptionalTerm();
		assertNotNull("Source mustn't be null", algo);
		EObject target = pl0Factory.createTerm();
		assertNotNull("Target mustn't be null", algo);
		List<IPath> paths = algo.calculatePaths( source, target);
		assertNotNull("There must be a shortest path", paths);
		assertEquals("There must be 1 shortest path", 1, paths.size());
		IPath path = paths.get(0);
		IPath expectedPath = new LinkedListPath();
		expectedPath.add((EClass) pl0Factory.getPL0Package().getEClassifier("OptionalTerm"));
		expectedPath.add((EClass) pl0Factory.getPL0Package().getEClassifier("Term"));
		assertTrue("Both path's must be the same", path.equals(expectedPath));
	}
}
