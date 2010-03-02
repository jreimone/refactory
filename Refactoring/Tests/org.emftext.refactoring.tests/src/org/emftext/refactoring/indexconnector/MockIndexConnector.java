package org.emftext.refactoring.indexconnector;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.emftext.language.conference.ConferencePackage;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.RefactoringTests;
import org.emftext.refactoring.test.TestUtil;

public class MockIndexConnector implements IndexConnector {

	private static final String indexFolder = "index";
	
	private static final Logger LOG = Logger.getLogger(MockIndexConnector.class.getSimpleName());
	private static final Map<String, RoleMappingModel> simpleMappingIndex = new HashMap<String, RoleMappingModel>();
	private static final Map<String, RefactoringSpecification> simpleRefSpecIndex = new HashMap<String, RefactoringSpecification>();
	
	static{
		initMappingIndex();
		initRefSpecIndex();
	}

	private static void initRefSpecIndex() {
		File mapping = TestUtil.getFileByPath(RefactoringTests.INPUT_FOLDER + File.separator 
				+ indexFolder + File.separator 
				+ "ExtractMethod.refspec");
		RefactoringSpecification refSpec = TestUtil.getExpectedModelFromFile(mapping, RefactoringSpecification.class);
		simpleRefSpecIndex.put("ExtractMethod", refSpec);
	}
	
	private static void initMappingIndex() {
		File mapping = TestUtil.getFileByPath(RefactoringTests.INPUT_FOLDER + File.separator 
				+ indexFolder + File.separator 
				+ "pl0mapping.rolemapping");
		RoleMappingModel mappingModel = TestUtil.getExpectedModelFromFile(mapping, RoleMappingModel.class);
		simpleMappingIndex.put(PL0Package.eNS_URI, mappingModel);
		mapping = TestUtil.getFileByPath(RefactoringTests.INPUT_FOLDER + File.separator 
				+ indexFolder + File.separator 
				+ "conference.rolemapping");
		mappingModel = TestUtil.getExpectedModelFromFile(mapping, RoleMappingModel.class);
		simpleMappingIndex.put(ConferencePackage.eNS_URI, mappingModel);
	}
	
	public RefactoringSpecification getRefactoringSpecification(RoleModel roleModel) {
		System.out.println("Mock index returns RefactoringSpecification for RoleModel '" + roleModel.getName() + "'");
		return simpleRefSpecIndex.get(roleModel.getName());
	}

	public RoleMappingModel getRoleMapping(String metamodelURI) {
		System.out.println("Mock index returns RoleMappingModel for " + metamodelURI);
		return simpleMappingIndex.get(metamodelURI);
	}

}
