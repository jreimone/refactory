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
package org.emftext.refactoring.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.internal.registry.ExtensionRegistry;
import org.eclipse.core.runtime.ContributorFactoryOSGi;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.di.annotations.Execute;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.ltk.ModelRefactoringDescriptor;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.util.RegistryUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

@SuppressWarnings("restriction")
public class StartUpRegistrations {

	private static final String REFACTORING_ID_PLACEHOLDER	= "REFACTORING_ID_PLACEHOLDER";
	private static final String CONTRIBUTION	=
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
			"<?eclipse version=\"3.4\"?>\n" +
			"<plugin>\n" + 
			"\t<extension point=\"org.eclipse.ltk.core.refactoring.refactoringContributions\">\n" +
			"\t\t	<contribution\n" +
			"\t\t\t		class=\"org.emftext.refactoring.ltk.GenericRefactoringContribution\"\n"+ 
			"\t\t\t		id=\"" + REFACTORING_ID_PLACEHOLDER + "\">\n" +
			"\t\t	</contribution>\n" +
			"\t</extension>\n" + 
			"</plugin>";
	
	@SuppressWarnings("unused")
	@Execute
	public void earlyStartup() {
		// just provoke to initialize registries
		IRoleModelRegistry roleModelRegistry = IRoleModelRegistry.INSTANCE;
		RegistryUtil.log("Initialized Role Model registry on startup", IStatus.OK);
		IRefactoringSpecificationRegistry refspecRegistry = IRefactoringSpecificationRegistry.INSTANCE;
		RegistryUtil.log("Initialized Refactoring Specification registry on startup", IStatus.OK);
		IRoleMappingRegistry registry = IRoleMappingRegistry.INSTANCE;
		RegistryUtil.log("Initialized Role Mapping registry on startup", IStatus.OK);
		
		// register a refactoring contribution for each role mapping so that each model refactoring appears in 
		// the refactoring history and can be reexecuted after restarting Eclipse
		registerRefactoringContributionForRoleMappings();
	}

	private void registerRefactoringContributionForRoleMappings() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		Object temporaryUserToken = ((ExtensionRegistry)registry).getTemporaryUserToken();
		Set<RoleMapping> roleMappings = getRoleMappings();
		Bundle bundle = FrameworkUtil.getBundle(StartUpRegistrations.class);
		for (RoleMapping roleMapping : roleMappings) {
			String id = ModelRefactoringDescriptor.generateRefactoringID(roleMapping);
			String extension = CONTRIBUTION.replaceAll(REFACTORING_ID_PLACEHOLDER, id);
			InputStream is;
			try {
				is = new ByteArrayInputStream(extension.getBytes("UTF-8"));
				IContributor contributor = ContributorFactoryOSGi.createContributor(bundle);
				if(registry.addContribution(is, contributor, false, null, null, temporaryUserToken)){
//					System.out.println("Successfully registered contribution for " + id);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Set<RoleMapping> getRoleMappings(){
		Set<RoleMapping> roleMappings = new HashSet<RoleMapping>();
		Map<String, Map<String, RoleMapping>> roleMappingsMap = IRoleMappingRegistry.INSTANCE.getRoleMappingsMap();
		for (Map<String, RoleMapping> map : roleMappingsMap.values()) {
			for (RoleMapping roleMapping : map.values()) {
				roleMappings.add(roleMapping);
			}
		}
		return roleMappings;
	}
}
