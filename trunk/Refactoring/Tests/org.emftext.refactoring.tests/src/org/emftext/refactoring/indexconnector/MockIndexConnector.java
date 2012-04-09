/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.indexconnector;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.conference.ConferencePackage;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.RefactoringTestSuite;
import org.emftext.refactoring.test.TestUtil;

public class MockIndexConnector implements IndexConnector {

	private static final String indexFolder = "registry";
	
	private static final Logger LOG = Logger.getLogger(MockIndexConnector.class.getSimpleName());
	private static final Map<String, RoleMappingModel> simpleMappingIndex = new HashMap<String, RoleMappingModel>();
	private static final Map<String, RefactoringSpecification> simpleRefSpecIndex = new HashMap<String, RefactoringSpecification>();
	
	static{
		initMappingIndex();
		initRefSpecIndex();
	}

	private static void initRefSpecIndex() {
		File mapping = TestUtil.getFileByPath(RefactoringTestSuite.INPUT_FOLDER + File.separator 
				+ indexFolder + File.separator 
				+ "ExtractMethod.refspec");
		RefactoringSpecification refSpec = TestUtil.getExpectedModelFromFile(mapping, RefactoringSpecification.class);
		simpleRefSpecIndex.put("ExtractMethod", refSpec);
	}
	
	private static void initMappingIndex() {
		File mapping = TestUtil.getFileByPath(RefactoringTestSuite.INPUT_FOLDER + File.separator 
				+ indexFolder + File.separator 
				+ "pl0mapping.rolemapping");
		RoleMappingModel mappingModel = TestUtil.getExpectedModelFromFile(mapping, RoleMappingModel.class);
		simpleMappingIndex.put(PL0Package.eNS_URI, mappingModel);
		mapping = TestUtil.getFileByPath(RefactoringTestSuite.INPUT_FOLDER + File.separator 
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

	public List<Resource> getReferencingResources(EObject referenceTarget) {
		// TODO Auto-generated method stub
		return null;
	}

}
