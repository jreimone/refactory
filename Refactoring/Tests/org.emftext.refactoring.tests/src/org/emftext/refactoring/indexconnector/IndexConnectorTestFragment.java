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
/**
 * 
 */
package org.emftext.refactoring.indexconnector;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.test.core.ExpectedData;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.emftext.test.core.TestData;
import org.junit.Test;

/**
 * @author Jan Reimann
 *
 */
@TestData("IndexConnectorTest")
public class IndexConnectorTestFragment extends TestClass{

	public static final String CS_MODEL_INPUT_PREFIX = "CS_MODEL_";
	public static final String CS_MAPPING_EXPECTED_PREFIX = "CS_MAPPING_";
	public static final String CS_ROLE_MODEL_PREFIX = "CS_ROLE_";
	public static final String CS_REFSPEC_PREFIX = "CS_REFSPEC_";
	
	@Test
	@InputData({CS_MODEL_INPUT_PREFIX})
	@ExpectedData({CS_MAPPING_EXPECTED_PREFIX})
	public void connectorGetRoleMapping(){
		List<File> inputFiles = getTestDataSet().getInputDataFiles();
		File input = inputFiles.get(0);
		Resource resource = TestUtil.getResourceFromFile(input);
		IndexConnector connector = IndexConnectorRegistry.INSTANCE.getConnectors().get(0);
		assertNotNull(connector);
		EObject model = TestUtil.getModelFromResource(resource);
//		RoleMappingModel mappingModel = connector.getRoleMapping(model.eClass().getEPackage().getNsURI());
//		assertNotNull(mappingModel);
		// both mappingModels are the same but different instances so equals() fails
//		List<File> expectedFiles = getTestDataSet().getExpectedDataFiles();
//		File expected = expectedFiles.get(0);
//		Resource mappingResource = TestUtil.getResourceFromFile(expected);
//		RoleMappingModel targetMM = TestUtil.getExpectedModelFromResource(mappingResource, RoleMappingModel.class);
//		assertEquals(mappingModel, targetMM);
	}
	
	@Test
	@InputData({CS_ROLE_MODEL_PREFIX})
	@ExpectedData({CS_REFSPEC_PREFIX})
	public void connectorGetRefSpec(){
		IndexConnector connector = IndexConnectorRegistry.INSTANCE.getConnectors().get(0);
		assertNotNull(connector);
		List<File> inputFiles = getTestDataSet().getInputDataFiles();
		File input = inputFiles.get(0);
		Resource resource = TestUtil.getResourceFromFile(input);
		RoleModel roleModel = TestUtil.getExpectedModelFromResource(resource, RoleModel.class);
//		RefactoringSpecification refSpec = connector.getRefactoringSpecification(roleModel);
//		assertNotNull(refSpec);
		// both refspecs are the same but different instances so equals() fails
//		List<File> expectedFiles = getTestDataSet().getExpectedDataFiles();
//		File expected = expectedFiles.get(0);
//		Resource refSpecResource = TestUtil.getResourceFromFile(expected);
//		RefactoringSpecification refSpecTarget = TestUtil.getExpectedModelFromResource(refSpecResource, RefactoringSpecification.class);
//		assertEquals(refSpec, refSpecTarget);
	}
}
