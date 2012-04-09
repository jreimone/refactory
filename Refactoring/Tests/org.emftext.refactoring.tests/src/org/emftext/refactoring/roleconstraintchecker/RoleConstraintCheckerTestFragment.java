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
package org.emftext.refactoring.roleconstraintchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.refactoring.util.ModelUtil;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.emftext.test.core.TestData;
import org.junit.Test;

/**
 * Tests the constraints between roles with the mapped classes
 * 
 * @author Jan Reimann
 *
 */
@TestData("constraintresources")
public class RoleConstraintCheckerTestFragment extends TestClass{
		
	private static final String path = "relationTestMapping.rolemapping";
//	private RoleMappingModel mappingModel;
	
	@Test
	@InputData(path)
	public void prohibitionConstraints(){
		File input = getTestDataSet().getInputDataFiles().get(0);
		assertNotNull(input);
		RoleMappingModel mappingModel = TestUtil.getExpectedModelFromFile(input, RoleMappingModel.class);
		EPackage metamodel = mappingModel.getTargetMetamodel();
		assertNotNull("Metamodel mustn't be null", metamodel);
		EList<RoleMapping> mappings = mappingModel.getMappings();
		assertTrue("There must be mappings", mappings.size() > 0);
		EList<EObject> prohibitionMappings = ModelUtil.filterObjectsByAttribute(mappings.iterator(), "name", "TestProhibitionMapping");
		assertEquals("There must be a prohibition mapping", 1, prohibitionMappings.size());
		RoleMapping prohibitionMapping = (RoleMapping) prohibitionMappings.get(0);
//		prohibitionMapping.getMappedRoleModel()
		EList<ConcreteMapping> concreteMappings = prohibitionMapping.getRoleToMetaelement();
		assertTrue("There must be concrete mappings", concreteMappings.size() > 0);
		IRoleConstraintValidator validator = RoleConstraintValidatorFactory.eINSTANCE.createValidator();
		assertNotNull("Validator mustn't be null", validator);
		List<IStatus> stati = validator.validateMapping(prohibitionMapping);
		assertEquals("Maybe PROXY PROBLEM: There must be 2 error stati", 2, stati.size());
//		assertEquals("The status code must be an ERROR", IStatus.ERROR, stati.get(0).getSeverity());
//		assertEquals("The status code must be an ERROR", IStatus.ERROR, stati.get(1).getSeverity());
	}
}
