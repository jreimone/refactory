package org.emftext.refactoring.customwizardpage.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.customwizardpage.ICustomWizardPageExtensionPoint;
import org.emftext.refactoring.customwizardpage.ICustomWizardPageRegistry;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicCustomWizardPageRegistry implements ICustomWizardPageRegistry {

	// Maps from refactoring name to instances of the wizard page class.
	private Map<RoleMapping, List<IModelRefactoringWizardPage>> wizardClassMap;

	public BasicCustomWizardPageRegistry() {
		wizardClassMap = new LinkedHashMap<RoleMapping, List<IModelRefactoringWizardPage>>();
	}

	private void refreshWizardPages(RoleMapping mapping) {
		// mappingName value of null means refresh all values

		// Remove outdated values before adding new ones.
		wizardClassMap.remove(mapping);

		// Find new values.
		IConfigurationElement[] configurationElements = RegistryUtil.collectConfigurationElements(ICustomWizardPageExtensionPoint.ID);

		for (IConfigurationElement element : configurationElements) {

			try {
				String mappingName = element.getAttribute(ICustomWizardPageExtensionPoint.ATTRIBUTE_MAPPING);
				String nsUri = element.getAttribute(ICustomWizardPageExtensionPoint.ATTRIBUTE_NS_URI);

				Map<String, RoleMapping> roleMappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(nsUri);

				if (roleMappings.containsKey(mappingName)) {
					RoleMapping localMapping = roleMappings.get(mappingName);

					if (mapping.equals(localMapping)) {
						IModelRefactoringWizardPage wizardPage = (IModelRefactoringWizardPage) element.createExecutableExtension(ICustomWizardPageExtensionPoint.ATTRIBUTE_WIZARD_PAGE);

						List<IModelRefactoringWizardPage> entries = null;

						if (wizardClassMap.containsKey(mapping)) {
							entries = wizardClassMap.get(mapping);
						} else {
							entries = new ArrayList<IModelRefactoringWizardPage>();
							wizardClassMap.put(mapping, entries);
						}

						entries.add(wizardPage);
					}
				}
			} catch (Exception e) {
				// Creation of wizard page has failed.
				RegistryUtil.log("Could not instantiate custom refactoring wizard page.", IStatus.ERROR, e);
			}
		}
	}

	public List<IModelRefactoringWizardPage> getFreshCustomWizardPages(RoleMapping mapping, Map<Role, List<EObject>> roleRuntimeInstanceMap) {
		// Fresh pages are needed if a new instance of a refactoring is created
		// because the old UI elements have been disposed.
		refreshWizardPages(mapping);

		List<IModelRefactoringWizardPage> customPages = getCustomWizardPages(mapping);

		// Initialize the pages with the relevant data.
		for (IModelRefactoringWizardPage page : customPages) {
			page.setRoleRuntimeInstanceMap(roleRuntimeInstanceMap);
		}

		return customPages;
	}

	public List<IModelRefactoringWizardPage> getCustomWizardPages(RoleMapping mapping) {
		if (wizardClassMap.containsKey(mapping)) {
			// Only hand out copies of the original lists to prevent concurrent
			// modifications through SWT threat.
			List<IModelRefactoringWizardPage> customPages = wizardClassMap.get(mapping);
			List<IModelRefactoringWizardPage> copiedCustomPages = new ArrayList<IModelRefactoringWizardPage>();
			copiedCustomPages.addAll(customPages);

			return copiedCustomPages;
		}

		return new ArrayList<IModelRefactoringWizardPage>();
	}
}
