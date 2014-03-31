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
package org.emftext.refactoring.interpreter.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.indexconnector.IndexConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.interpreter.RefactoringStatus;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.ICustomWizardPageRegistry;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class Refactorer implements IRefactorer {

	private EObject model;
	//	private List<EObject> currentSelection;
	private boolean occuredErrors;
	private List<Resource> resourcesToSave;
	private Resource resource;
	private IRefactoringStatus status;
	private IRefactoringInterpreter interpreter;
	private ResourceSet currentModelResourceSet;
	private EObject fakeRefactoredModel;
	private IValueProviderFactory valueProviderFactory;
	private RoleMapping roleMapping;
	private Copier copier;
	private Map<Role, List<EObject>> filteredRoleBindings;
	private Map<Role, List<EObject>> roleBindings;
	private List<Role> boundInputRoles;

	public Refactorer(Resource resource, RoleMapping roleMapping) {
		this.resource = resource;
		this.model = resource.getContents().get(0);
		this.roleMapping = roleMapping;
		this.roleBindings = new HashMap<Role, List<EObject>>();
		this.boundInputRoles = new ArrayList<Role>();
		createInterpreter();
	}

	private void createInterpreter() {
		RoleModel roleModel = roleMapping.getMappedRoleModel();
		EcoreUtil.resolveAll(roleModel);
		RefactoringSpecification refSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(roleModel);
		IRefactoringPostProcessor postProcessor = IRoleMappingRegistry.INSTANCE.getPostProcessor(roleMapping);
		interpreter = new RefactoringInterpreter(postProcessor);
		interpreter.initialize(refSpec, roleMapping);
	}

	public void fakeRefactor() {
		if(filteredRoleBindings == null){
			loadReferencingResources();
		}
		if (interpreter != null && filteredRoleBindings.size() > 0) {
			fakeInterpreteAndPreCollectValues(roleMapping, filteredRoleBindings, interpreter, currentModelResourceSet);
		} 
	}

	private void loadReferencingResources(){
		filteredRoleBindings = filterSelectedElements();
		if (interpreter != null && filteredRoleBindings.size() > 0) {
			List<Resource> allReferencingResources = IndexConnectorRegistry.INSTANCE.getReferencingResources(model);
			currentModelResourceSet = getResource().getResourceSet();

			for (Resource resource : allReferencingResources) {
				URI uri = resource.getURI();
				currentModelResourceSet.getResource(uri, true);
			}
		} 
	}

	public EObject getFakeRefactoredModel() {
		return fakeRefactoredModel;
	}

	public EObject refactor() {
		loadReferencingResources();
		if (roleMapping == null || interpreter == null || filteredRoleBindings.size() == 0 || currentModelResourceSet == null) {
			return null;
		}
		EObject refactoredModel = realInterprete(filteredRoleBindings, interpreter, currentModelResourceSet);
		return refactoredModel;
	}

	/**
	 * @param mapping
	 * @param filteredRoleBindings
	 * @param interpreter
	 * @param refactoredModelRS
	 * @return
	 */
	private EObject realInterprete(Map<Role, List<EObject>> filteredRoleBindings, IRefactoringInterpreter interpreter, ResourceSet refactoredModelRS) {
		EObject refactoredModel;
		interpreter.setRoleBindings(filteredRoleBindings);
		interpreter.setValueProviderFactory(valueProviderFactory);
		ChangeRecorder recorder = new ChangeRecorder(refactoredModelRS);
		refactoredModel = interpreter.interprete(model);
		status = interpreter.getStatus();
		if (status.getSeverity() != IRefactoringStatus.OK) {
			return refactoredModel;
		}
		ChangeDescription change = recorder.summarize();
		occuredErrors = interpreter.didErrorsOccur();
		if (!occuredErrors) {
			IRefactoringPostProcessor postProcessor = interpreter.getPostProcessor();
			if (postProcessor != null) {
				RefactoringSpecification refactoringSpecification = interpreter.getRefactoringSpecification();

				List<IModelRefactoringWizardPage> customWizardPages = ICustomWizardPageRegistry.INSTANCE.getCustomWizardPages(getRoleMapping(), null);
				for (IModelRefactoringWizardPage wizardPage : customWizardPages) {
					wizardPage.setRoleRuntimeInstanceMap(interpreter.getRoleRuntimeInstances());
				}

				IStatus postProcessingStatus = postProcessor.process(interpreter.getRoleRuntimeInstances(), refactoredModel, refactoredModelRS, change, refactoringSpecification, customWizardPages, false, copier);
				int severity = postProcessingStatus.getSeverity();

				if (severity != IRefactoringStatus.OK) {
					status = new RefactoringStatus(getRoleMapping(), severity, postProcessingStatus.getMessage());
				}
			}
		}
		resourcesToSave = interpreter.getResourcesToSave();
		return refactoredModel;
	}

	public IRefactoringInterpreter getInterpreter() {
		return interpreter;
	}

	/**
	 * @param filteredRoleBindings
	 * @param interpreter
	 * @param refactoredModelRS
	 */
	private void fakeInterpreteAndPreCollectValues(RoleMapping mapping, Map<Role, List<EObject>> filteredRoleBindings, IRefactoringInterpreter interpreter, ResourceSet refactoredModelRS) {
		// copy init start
		copier = new Copier(false, true);
		List<EObject> originalElements = new LinkedList<EObject>();
		// copy start
		for (Resource resource : refactoredModelRS.getResources()) {
			URI uri = resource.getURI();
			if (uri.isPlatformResource() || uri.isFile()) {
				for (EObject model : resource.getContents()) {
					originalElements.add(model);
				}
			}
		}
		copier.copyAll(originalElements);
		copier.copyReferences();
		Map<Role, List<EObject>> copiedInputRoleBinding = new HashMap<Role, List<EObject>>();
		for (Role boundRole : filteredRoleBindings.keySet()) {
			if(boundRole.getModifier().contains(RoleModifier.INPUT)){
				List<EObject> copiedBoundElements = new ArrayList<EObject>();
				List<EObject> boundElements = filteredRoleBindings.get(boundRole);
				for (EObject originalBoundElement : boundElements) {
					EObject copiedBoundElement = copier.get(originalBoundElement);
					if(copiedBoundElement == null) {
						RegistryUtil.log("Copy couldn't be found for fake interpreting. Retry right-clicking the element to refactor", IStatus.ERROR);
						return;
					}
					copiedBoundElements.add(copiedBoundElement);
				}
				copiedInputRoleBinding.put(boundRole, copiedBoundElements);
			}
		}
		EObject copiedModel = copier.get(model);
		//		interpreter.setRoleBindings(copiedInputRoleBinding);

		IRefactoringFakeInterpreter fakeInterpreter = interpreter.getFakeInterpreter();
		fakeInterpreter.setRoleBindings(copiedInputRoleBinding);
		EObject copiedRefactoredModel = null;
		try {
			ChangeRecorder recorder = new ChangeRecorder(refactoredModelRS);
			// this model then can be used for compare view before refactoring
			copiedRefactoredModel = fakeInterpreter.interprete(copiedModel);
			ChangeDescription change = recorder.summarize();

			//after interpreting and refactoring the generic part, the postprocessor is called here
			IRefactoringPostProcessor fakePostProcessor = fakeInterpreter.getPostProcessor();
			if (fakePostProcessor != null) {
				RefactoringSpecification fakeRefactoringSpecification = fakeInterpreter.getRefactoringSpecification();
				List<IModelRefactoringWizardPage> customWizardPages = ICustomWizardPageRegistry.INSTANCE.getCustomWizardPages(mapping, fakeInterpreter.getRoleRuntimeInstances());

				IStatus fakePostProcessingStatus = fakePostProcessor.process(fakeInterpreter.getRoleRuntimeInstances(), copiedRefactoredModel, refactoredModelRS, change, fakeRefactoringSpecification, customWizardPages, true, copier);

				if (fakePostProcessingStatus.getSeverity() != IRefactoringStatus.OK) {
					int severity = fakePostProcessingStatus.getSeverity();
					new RefactoringStatus(getRoleMapping(), severity, fakePostProcessingStatus.getMessage());
				}
			}
			//end of postprocessing

		} catch (Exception e) {
			e.printStackTrace();
			RegistryUtil.log("fake interpreter threw exception", IStatus.ERROR, e);
			return;
			//			return fakeInterpreter;
		}
		// copy end

		//cseidl: Collecting values is no longer needed here as this has already been done 
		//when the wizard was originally created.
		List<IValueProvider<?, ?>> valueProviders = fakeInterpreter.getValueProviderFactory().getValuesToProvide();
		Map<EObject, EObject> inverseCopier = new LinkedHashMap<EObject, EObject>();
		for (EObject originalObject : copier.keySet()) {
			inverseCopier.put(copier.get(originalObject), originalObject);
		}
		List<IValueProvider<?, ?>> provideableValues = new LinkedList<IValueProvider<?, ?>>();
		for (IValueProvider<?, ?> valueProvider : valueProviders) {
			// check if value can be provided before Refactoring
			Object fakeObject = valueProvider.getFakeObject();
			if (fakeObject instanceof EStructuralFeature) {
				provideableValues.add(valueProvider);
			} else if (fakeObject instanceof EObject) {
				EObject realObject = inverseCopier.get(fakeObject);
				if (realObject != null) {
					provideableValues.add(valueProvider);
				}
			} else if (fakeObject instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<EObject> fakeObjects = (List<EObject>) fakeObject;
				boolean provideable = true;
				for (EObject object : fakeObjects) {
					EObject realObject = inverseCopier.get(object);
					if (realObject == null) {
						provideable = false;
						break;
					}
				}
				if (provideable) {
					provideableValues.add(valueProvider);
				} else {
					//TODO delete not providable value provider here?
				}
			}
		}
		//		fakeInterpreter.setProvideableValues(provideableValues);
		for (IValueProvider<?, ?> valueProvider : provideableValues) {
			valueProvider.setCopier(copier);
		}

		if (copiedRefactoredModel != null) {
			fakeRefactoredModel = copiedRefactoredModel;
		} else {
			fakeRefactoredModel = null;
		}

		//cseidl
		fakeRefactoredModel = copiedRefactoredModel;

		//		return fakeInterpreter;
	}

	private Map<Role, List<EObject>> filterSelectedElements() {
		List<EObject> filteredElements = getInput();
		List<EObject> elementsToRemove = new LinkedList<EObject>();
		for (EObject child : filteredElements) {
			List<EObject> othersList = new LinkedList<EObject>(filteredElements);
			othersList.remove(child);
			for (EObject parent : othersList) {
				if (EcoreUtil.isAncestor(parent, child)) {
					elementsToRemove.add(child);
				}
			}
		}
		for (EObject child : elementsToRemove) {
			filteredElements.remove(child);
		}
		//		Collections.sort(filteredElements, new Comparator<EObject>() {
		//
		//			public int compare(EObject o1, EObject o2) {
		//				EObject parent1 = o1.eContainer();
		//				EObject parent2 = o2.eContainer();
		//				if (parent1.equals(parent2)) {
		//					int index1 = ((List<?>) parent1.eGet(o1.eContainingFeature())).indexOf(o1);
		//					int index2 = ((List<?>) parent1.eGet(o2.eContainingFeature())).indexOf(o2);
		//					return index1 - index2;
		//				}
		//				return 0;
		//			}
		//		});
		Map<Role, List<EObject>> filteredRoleBindings = new HashMap<Role, List<EObject>>();
		for (EObject filteredElement : filteredElements) {
			for (Role boundRole : roleBindings.keySet()) {
				List<EObject> boundElements = roleBindings.get(boundRole);
				if(boundElements.contains(filteredElement)){
					List<EObject> filteredBoundElements = filteredRoleBindings.get(boundRole);
					if(filteredBoundElements == null){
						filteredBoundElements = new ArrayList<EObject>();
						filteredRoleBindings.put(boundRole, filteredBoundElements);
					}
					if(!filteredBoundElements.contains(filteredElement)){
						filteredBoundElements.add(filteredElement);
					}
				}
			}
		}
		return filteredRoleBindings;
	}

	public void setInput(List<? extends EObject> selectedElements) {
		List<Role> inputRoles = RoleUtil.getAllInputRoles(roleMapping);
		if(inputRoles == null || inputRoles.size() > 1){
			throw new NullPointerException("The rolemapping used for this refactorer contains more than 1 input role.");
		}
		List<EObject> elements = new ArrayList<EObject>();
		for (EObject element : selectedElements) {
			elements.add(element);
		}
		Map<String, List<EObject>> inputRoleBinding = new HashMap<String, List<EObject>>();
		inputRoleBinding.put(inputRoles.get(0).getName(), elements);
		setInputRoleBindings(inputRoleBinding);
	}

	public void setInputRoleBindings(Map<String, List<EObject>> inputRoleBinding){
		for (String roleName : inputRoleBinding.keySet()) {
			Role role = RoleUtil.getRoleByName(roleMapping, roleName);
			List<Role> inputRoles = RoleUtil.getAllInputRoles(roleMapping);
			if(role != null && inputRoles.contains(role)){
				List<EObject> resolvedElements = new ArrayList<EObject>();
				for (EObject element : inputRoleBinding.get(roleName)) {
					if(!element.eIsProxy()){
						resolvedElements.add(element);
					}
				}
				if(!resolvedElements.isEmpty()){
					List<EObject> filteredObjects = RoleUtil.filterObjectsByInputRoles(resolvedElements, roleMapping);
					boundInputRoles.add(role);
					roleBindings.put(role, filteredObjects);
				}
			}
		}
	}

	public Map<Role, List<EObject>> getRoleBindings(){
		return roleBindings;
	}

	public boolean didErrorsOccur() {
		return occuredErrors;
	}

	public List<Resource> getResourcesToSave() {
		return resourcesToSave;
	}

	public Resource getResource() {
		return resource;
	}

	public IRefactoringStatus getStatus() {
		return status;
	}

	public EObject getOriginalModel() {
		return model;
	}

	public void setValueProviderFactory(IValueProviderFactory factory) {
		this.valueProviderFactory = factory;
		interpreter.setValueProviderFactory(factory);
	}

	@Override
	public RoleMapping getRoleMapping() {
		return roleMapping;
	}

	@Override
	public List<EObject> getInput() {
		return RoleUtil.getBoundInputElements(getInputRoleBindings());
	}

	public Map<Role, List<EObject>> getInputRoleBindings(){
		Map<Role, List<EObject>> inputRoleBindings = new HashMap<Role, List<EObject>>();
		for (Role inputRole : boundInputRoles) {
			List<EObject> boundElements = roleBindings.get(inputRole);
			inputRoleBindings.put(inputRole, boundElements);
		}
		return inputRoleBindings;
	}
}
