package org.modelrefactoring.jamopp.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.language.java.statements.ForLoop;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecResourceFactory;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.junit.Before;
import org.junit.Test;
import org.modelrefactoring.jamopp.test.postprocessor.JavaExtractMethodPostProcessor;
import org.modelrefactoring.jamopp.test.valueprovider.TestValueProviderFactory;

public class JaMoPPRefactoringTest {

	private static final String JAVA_CLASS_TO_REFACTOR		= "SimpleExtractMethodTestClass.java";
	private static final String NEW_METHOD_NAME				= "iteration";

	private static final String FOLDER_INPUT				= "input";
	private static final String FOLDER_EXPECTED				= "expected";
	private static final String FOLDER_OUTPUT				= "output";
	private static final String FOLDER_REFACTORING			= "refactoring";

	private static final String REFACTORING_GENERIC_NAME	= "ExtractXwithReferenceClass";
	private static final String REFACTORING_CONCRETE_NAME	= "Extract Method";

	@Test
	public void testJaMoPPRefactoring(){
		// first copy original model to output folder
		File movedInputFile = copyFile(FOLDER_INPUT + "/" + JAVA_CLASS_TO_REFACTOR, FOLDER_OUTPUT + "/" + JAVA_CLASS_TO_REFACTOR);
		// load java model
		CompilationUnit copiedOriginalModel = getModelByType(movedInputFile.getPath(), CompilationUnit.class);
		// get refactoring models from registry
		Map<String, RoleMapping> roleMappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(JavaPackage.eNS_URI);
		assertNotNull("no concrete refactorings registered for java", roleMappings);
		RoleMapping roleMapping = roleMappings.get(REFACTORING_CONCRETE_NAME);
		assertNotNull("concrete refactoring '" + REFACTORING_CONCRETE_NAME + "' not registered", roleMapping);
		// determine statements to extract
		org.emftext.language.java.classifiers.Class javaClass = copiedOriginalModel.getContainedClass();
		Method method = javaClass.getMethods().get(0);
		assertNotNull("no methods found", method);
		List<Statement> statements = method.getChildrenByType(Statement.class);
		assertNotNull("no statements contained in the method", statements);
		assertTrue("at least 2 statements must be contained in the method", statements.size() >= 2);
		Statement forLoopStatement = statements.get(1);
		assertTrue("statement must be a for loop", forLoopStatement instanceof ForLoop);
		List<EObject> elementsToExtract = new ArrayList<EObject>();
		elementsToExtract.add(forLoopStatement);
		// refactor
		Resource javaResource = copiedOriginalModel.eResource();
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(javaResource, roleMapping);
		TestValueProviderFactory valueProviderFactory = new TestValueProviderFactory();
		valueProviderFactory.setNewMethodName(NEW_METHOD_NAME);
		refactorer.setValueProviderFactory(valueProviderFactory);
		refactorer.setInput(elementsToExtract);
		// obviously refactoredModel = compilationUnit
		EObject refactoredModel = refactorer.refactor();
		// save refactored model
		try {
			javaResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//////////////////////////////////////
		// COMMENT THE FOLLOWING OUT TO USE //
		//    EMF Compare FOR COMPARISON    //
		//////////////////////////////////////
//		// load expected model for comparison
//		CompilationUnit expectedModel = getModelByType(FOLDER_EXPECTED + "/" + JAVA_CLASS_TO_REFACTOR, CompilationUnit.class);
//		// compare both models
//		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
//		IEqualityHelperFactory helperFactory = new DefaultEqualityHelperFactory();
//		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(helperFactory);
//		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
//		matchEngineFactory.setRanking(20);
//		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
//		matchEngineRegistry.add(matchEngineFactory);
//		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();
//		IComparisonScope scope = EMFCompare.createDefaultScope(expectedModel, refactoredModel);
//		Comparison comparison = comparator.compare(scope);
//		List<Diff> differences = comparison.getDifferences();
//		assertTrue("Models are not equal. " + differences.size() + " differences found.", differences.size() == 0);
	}

	@Before
	public void init(){
		// register language stuff
		JaMoPPUtil.initialize();
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(RefactoringSpecificationPackage.eNS_URI, RefactoringSpecificationPackage.eINSTANCE);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("rolestext", new RolestextResourceFactory());
		extensionToFactoryMap.put("rolemapping", new RolemappingResourceFactory());
		extensionToFactoryMap.put("refspec", new RefspecResourceFactory());
		// register refactoring models and post processor
		try {
			RoleModel roleModel = getModelByType(FOLDER_REFACTORING + "/" + REFACTORING_GENERIC_NAME + ".rolestext", RoleModel.class);
			IRoleModelRegistry.INSTANCE.registerRoleModel(roleModel);
			RefactoringSpecification refSpec = getModelByType(FOLDER_REFACTORING + "/" + REFACTORING_GENERIC_NAME + ".refspec", RefactoringSpecification.class);
			IRefactoringSpecificationRegistry.INSTANCE.registerRefSpec(refSpec);
			RoleMappingModel roleMappingModel = getModelByType(FOLDER_REFACTORING + "/" + REFACTORING_CONCRETE_NAME.replace(" ", "") + ".rolemapping", RoleMappingModel.class);
			RoleMapping roleMapping = roleMappingModel.getMappings().get(0);
			IRefactoringPostProcessor postProcessor = new JavaExtractMethodPostProcessor();
			IRoleMappingRegistry.INSTANCE.registerRoleMapping(roleMapping);
			IRoleMappingRegistry.INSTANCE.registerPostProcessor(roleMapping, postProcessor);
		} catch (RoleModelAlreadyRegisteredException e) {
			e.printStackTrace();
		} catch (RefSpecAlreadyRegisteredException e) {
			e.printStackTrace();
		}
	}

	private <T> T getModelByType(String path, Class<T> type){
		File modelFile = new File(path);
		assertTrue("file " + path + " doesn't exist", modelFile.exists());
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(modelFile.getAbsolutePath());
		Resource resource = rs.getResource(uri, true);
		assertNotNull("resource couldn't be loaded", resource);
		EObject model = resource.getContents().get(0);
		assertNotNull("resource is empty", model);
		assertTrue("model must be an instance of " + type.getName(), type.isAssignableFrom(model.getClass()));
		return type.cast(model);
	}

	private File copyFile(String from, String to) {
		File inputFile = new File(from);
		assertTrue("input file doesn't exist: " + inputFile.getPath(), inputFile.exists());
		File movedInputFile = new File(to);
		if(movedInputFile.exists()){
			boolean deleted = movedInputFile.delete();
			assertTrue("existing file couldn't be deleted: " + movedInputFile.getPath(), deleted);
		}
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(inputFile);
			FileChannel inChannel = fileInputStream.getChannel();
			FileOutputStream fileOutputStream = new FileOutputStream(movedInputFile);
			FileChannel outChannel = fileOutputStream.getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
			inChannel.close();
			outChannel.close();
			fileInputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movedInputFile;
	}

	//	private <T extends EObject> Copier copyModel(T inputModel, String to) {
	//		Copier copier = new Copier(false, true);
	//		copier.copy(inputModel);
	//		copier.copyReferences();
	//		@SuppressWarnings("unchecked")
	//		T outputModel = (T) copier.get(inputModel);
	//		
	//		File outputFile = new File(to);
	//		if(outputFile.exists()){
	//			boolean deleted = outputFile.delete();
	//			assertTrue("existing file couldn't be deleted: " + outputFile.getPath(), deleted);
	//		}
	//		ResourceSet rs = new ResourceSetImpl();
	//		URI uri = URI.createFileURI(outputFile.getAbsolutePath());
	//		Resource outputResource = rs.createResource(uri);
	//		outputResource.getContents().add(outputModel);
	//		try {
	//			outputResource.save(Collections.EMPTY_MAP);
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//		return copier;
	//	}
}
