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
package org.emftext.refactoring.registry.rolemapping.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.ltk.ModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.ICustomWizardPageExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.ICustomWizardPageRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicCustomWizardPageRegistry implements ICustomWizardPageRegistry {

	//Maps from refactoring name to names of the wizard page class.
	private Map<RoleMapping, List<ModelRefactoringWizardPage>> wizardClassMap;
	
	public BasicCustomWizardPageRegistry()
	{
		wizardClassMap = new LinkedHashMap<RoleMapping, List<ModelRefactoringWizardPage>>();
		refreshAllWizardPages();
	}
	
	private void refreshAllWizardPages()
	{
		refreshWizardPages(null);
	}
	
	private void refreshWizardPages(RoleMapping mapping)
	{
		//mappingName value of null means refresh all values
		
		//Remove outdated values before adding new ones.
		if (mapping == null)
		{
			wizardClassMap.clear();
		}
		else
		{
			wizardClassMap.remove(mapping);
		}
		
		//Find new values.
		IConfigurationElement[] configurationElements = RegistryUtil.collectConfigurationElements(ICustomWizardPageExtensionPoint.ID);
		
		for (IConfigurationElement element : configurationElements) {
			
			try	{
				String mappingName = element.getAttribute(ICustomWizardPageExtensionPoint.ATTRIBUTE_MAPPING);
				String nsUri = element.getAttribute(ICustomWizardPageExtensionPoint.ATTRIBUTE_NS_URI);
				
				Map<String, RoleMapping> roleMappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(nsUri);
				
				if (roleMappings.containsKey(mappingName))
				{
					RoleMapping localMapping = roleMappings.get(mappingName);
					
					if (mapping == null || mapping.equals(localMapping))
					{
						ModelRefactoringWizardPage wizardPage = (ModelRefactoringWizardPage) element.createExecutableExtension(ICustomWizardPageExtensionPoint.ATTRIBUTE_WIZARD_PAGE);
									
						List<ModelRefactoringWizardPage> entries = null;
						
						if (wizardClassMap.containsKey(mapping))
						{
							entries = wizardClassMap.get(mapping);
						}
						else
						{
							entries = new ArrayList<ModelRefactoringWizardPage>();
							wizardClassMap.put(mapping, entries);
						}
					
						entries.add(wizardPage);
					}
				}
			}
			catch(Exception e)
			{
				//Creation of wizard page has failed.
				RegistryUtil.log("Could not instantiate custom refactoring wizard page.", IStatus.ERROR, e);
			}
		}
	}
	
	public List<IModelRefactoringWizardPage> getCustomWizardPages(RoleMapping mapping, Map<Role, List<EObject>> roleRuntimeInstanceMap)
	{
		//Fresh pages are needed if a new instance of a refactoring is created
		//because the old UI elements have been disposed.
//		refreshWizardPages(mapping);
		
		List<IModelRefactoringWizardPage> customPages = getCustomWizardPages(mapping);
		
		//Initialize the pages with the relevant data.
		for (IModelRefactoringWizardPage page : customPages)
		{
			if(roleRuntimeInstanceMap != null){
				page.setRoleRuntimeInstanceMap(roleRuntimeInstanceMap);
			}
		}
		
		return customPages;
	}
	
	private List<IModelRefactoringWizardPage> getCustomWizardPages(RoleMapping mapping)
	{
		if (wizardClassMap.containsKey(mapping))
		{
			//Only hand out copies of the original lists to prevent concurrent modifications through SWT threat.
			List<ModelRefactoringWizardPage> customPages = wizardClassMap.get(mapping);
			List<IModelRefactoringWizardPage> copiedCustomPages = new ArrayList<IModelRefactoringWizardPage>();
			copiedCustomPages.addAll(customPages);
			
			return copiedCustomPages;
		}
		
		return new ArrayList<IModelRefactoringWizardPage>();
	}

	@Override
	public void init(RoleMapping roleMapping) {
		refreshWizardPages(roleMapping);
	}
}
