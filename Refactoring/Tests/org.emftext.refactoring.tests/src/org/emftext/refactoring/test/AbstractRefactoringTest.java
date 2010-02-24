/**
 * 
 */
package org.emftext.refactoring.test;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecResourceFactory;
import org.junit.After;
import org.junit.Before;

/**
 * An abstract TestCase class for setting up the needed metamodels in the registry.
 * 
 * @author Jan Reimann
 *
 */
public abstract class AbstractRefactoringTest{

	private ResourceSet resourceSet;
//	private boolean allTestsWereInvoked = false;
//	private WorkspaceBuilder builder;
//	private boolean 
	
	@Before
	public void initTestCase(){
		initializeRegistry();
//		builder = WorkspaceBuilder.INSTANCE;
		WorkspaceBuilder.setTest(this);
		WorkspaceBuilder.buildTestWorkspace();
	}
	
	@After
	public void closeTestCase(){
//		allTestsWereInvoked = true;
		WorkspaceBuilder.clearWorkspace();
	}
	
	public void delay(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getTestProjectName(){
		return WorkspaceBuilder.TEST_PROJECT_NAME;
	}
	
	public String[] getFolderNamesToCopyIntoTestProject(){
		return WorkspaceBuilder.FOLDERS_TO_BE_COPIED_INTO_TEST_PROJECT;
	}
	
	public List<String> getValidExtensions(){
		return WorkspaceBuilder.VALID_EXTENSIONS_FOR_COPYING;
	}
	
	private void initializeRegistry() {
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("rolestext", new RolestextResourceFactory());
		resourceSet.getPackageRegistry().put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("rolemapping", new RolemappingResourceFactory());
		resourceSet.getPackageRegistry().put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pl0", new Pl0ResourceFactory());
		resourceSet.getPackageRegistry().put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("refspec", new RefspecResourceFactory());
		resourceSet.getPackageRegistry().put(RefactoringSpecificationPackage.eNS_URI, RefactoringSpecificationPackage.eINSTANCE);
	}

//	public boolean allTestsWereInvoked() {
//		return allTestsWereInvoked;
//	}


//	public WorkspaceBuilder getBuilder() {
//		return builder;
//	}
	
	public <T extends EObject> T getExpectedModelFromFile(String path, Class<T> expectedType){
		return WorkspaceUtil.getExpectedModelFromFile(this, path, expectedType);
	}
}
