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

import java.util.Collections;
import java.util.Comparator;
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
import org.emftext.language.refactoring.roles.RoleModel;
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
	private List<? extends EObject> currentSelection;
	private boolean occuredErrors;
	private List<Resource> resourcesToSave;
	private Resource resource;
	private IRefactoringStatus status;
	private IRefactoringInterpreter interpreter;
	private List<? extends EObject> filteredSelection;
	private ResourceSet currentModelResourceSet;
	private EObject fakeRefactoredModel;
	private IValueProviderFactory valueProviderFactory;
	private RoleMapping roleMapping;

	public Refactorer(Resource resource, RoleMapping roleMapping) {
		this.resource = resource;
		this.model = resource.getContents().get(0);
		this.roleMapping = roleMapping;
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

	/*
	 * (non-Javadoc)
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactorer#getPossibleRefactorings()
	 */
	//	public List<RefactoringSpecification> getPossibleRefactoringsForNearestRoleModels(double minEquality) {
	//		List<RefactoringSpecification> refSpecs = new LinkedList<RefactoringSpecification>();
	//		List<RoleMapping> possibleMappings = RoleUtil.getPossibleMappingsForSelection(currentSelection, roleMappings, minEquality);
	//		for (RoleMapping mapping : possibleMappings) {
	//			RefactoringSpecification refSpec = refSpecRegistry.getRefSpec(mapping.getMappedRoleModel());
	//			if (refSpec != null) {
	//				refSpecs.add(refSpec);
	//			}
	//		}
	//		return refSpecs;
	//	}

	public void fakeRefactor() {
		if(filteredSelection == null){
			loadReferencingResources();
		}
		if (interpreter != null && filteredSelection.size() > 0) {
			fakeInterpreteAndPreCollectValues(roleMapping, filteredSelection, interpreter, currentModelResourceSet);
		} 
	}

	private void loadReferencingResources(){
		filteredSelection = filterSelectedElements();
		if (interpreter != null && filteredSelection.size() > 0) {
			List<Resource> allReferencingResources = IndexConnectorRegistry.INSTANCE.getReferencingResources(model);
			currentModelResourceSet = getResource().getResourceSet();

			for (Resource resource : allReferencingResources) {
				URI uri = resource.getURI();
				currentModelResourceSet.getResource(uri, true);
			}
		} 
	}

	//cseidl
	//This is basically a copy of fakeRefactor(...). There is probably some redundancy that can be reduced.
	//	public IRefactoringFakeInterpreter collectValuesToProvide(RoleMapping mapping) {
	//		if (mapping == null) {
	//			currentMapping = null;
	//			return null;
	//		}
	//		currentMapping = mapping;
	//		currentFilteredSelection = filterSelectedElements(mapping);
	//		currentInterpreter = createInterpreter();
	//
	//		if (currentInterpreter != null && currentFilteredSelection.size() > 0) {
	//			List<Resource> allReferencingResources = IndexConnectorRegistry.INSTANCE.getReferencingResources(model);
	//			currentModelResourceSet = getResource().getResourceSet();
	//			for (Resource resource : allReferencingResources) {
	//				URI uri = resource.getURI();
	//				currentModelResourceSet.getResource(uri, true);
	//			}
	//
	//			return preCollectValues(mapping, currentFilteredSelection, currentInterpreter, currentModelResourceSet);
	//		} else {
	//			return null;
	//		}
	//	}

	public EObject getFakeRefactoredModel() {
		return fakeRefactoredModel;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactorer#refactor(org.emftext.
	 * language.refactoring.refactoring_specification.RefactoringSpecification,
	 * boolean)
	 */
	public EObject refactor() {
		loadReferencingResources();
		if (roleMapping == null || interpreter == null || filteredSelection.size() == 0 || currentModelResourceSet == null) {
			return null;
		}
		EObject refactoredModel = realInterprete(filteredSelection, interpreter, currentModelResourceSet);
		return refactoredModel;
	}

	/**
	 * @param mapping
	 * @param filteredElements
	 * @param interpreter
	 * @param refactoredModelRS
	 * @return
	 */
	private EObject realInterprete(List<? extends EObject> filteredElements, IRefactoringInterpreter interpreter, ResourceSet refactoredModelRS) {
		EObject refactoredModel;
		interpreter.setInput(filteredElements);
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

				IStatus postProcessingStatus = postProcessor.process(interpreter.getRoleRuntimeInstances(), refactoredModel, refactoredModelRS, change, refactoringSpecification, customWizardPages, false, null);
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

	//cseidl
	//This is basically a copy of fakeInterpreteAndPreCollectValues(...). There is probably some redundancy that can be reduced.
//	private IRefactoringFakeInterpreter preCollectValues(RoleMapping mapping, List<? extends EObject> filteredElements, IRefactoringInterpreter interpreter, ResourceSet refactoredModelRS)
//	{
//		// copy init start
//		Copier copier = new Copier(false, true);
//		List<EObject> originalElements = new LinkedList<EObject>();
//		// copy start
//		for (Resource resource : refactoredModelRS.getResources()) {
//			URI uri = resource.getURI();
//			if (uri.isPlatformResource() || uri.isFile()) {
//				for (EObject model : resource.getContents()) {
//					originalElements.add(model);
//				}
//			}
//		}
//		copier.copyAll(originalElements);
//		copier.copyReferences();
//		List<EObject> copiedInputSelection = new LinkedList<EObject>();
//		for (EObject eObject : filteredElements) {
//			copiedInputSelection.add(copier.get(eObject));
//		}
//		EObject copiedModel = copier.get(model);
//		interpreter.setInput(copiedInputSelection);
//		IRefactoringFakeInterpreter fakeInterpreter = interpreter
//				.getFakeInterpreter();
//		fakeInterpreter.setInput(copiedInputSelection);
//		try {
//			// cseidl: TODO: Actually, only the valuesToProvide are needed. If there
//			// is a better way to retrieve them, this should happen here.
//			fakeInterpreter.interprete(copiedModel);
//
//			//As a side effect, the fake refactoring also collects the roleRuntimeInstanceMap.
//			//The "real" fake refactoring is performed later. If the map is not cleared here,
//			//all entries will be duplicated.
//			fakeInterpreter.getRoleRuntimeInstances().clear();
//
//		} catch (Exception e) {
//			// e.printStackTrace();
//			RegistryUtil.log("fake interpreter threw exception", IStatus.ERROR,
//					e);
//			return fakeInterpreter;
//		}
//		// copy end
//
//
//
//		List<IValueProvider<?, ?>> valueProviders = fakeInterpreter.getValueProviderFactory().getValuesToProvide();
//
//		Map<EObject, EObject> inverseCopier = new LinkedHashMap<EObject, EObject>();
//		for (EObject originalObject : copier.keySet()) {
//			inverseCopier.put(copier.get(originalObject), originalObject);
//		}
//		List<IValueProvider<?, ?>> provideableValues = new LinkedList<IValueProvider<?, ?>>();
//		for (IValueProvider<?, ?> valueProvider : valueProviders) {
//			// check if value can be provided before Refactoring
//			Object fakeObject = valueProvider.getFakeObject();
//			if (fakeObject instanceof EStructuralFeature) {
//				provideableValues.add(valueProvider);
//			} else if (fakeObject instanceof EObject) {
//				EObject realObject = inverseCopier.get(fakeObject);
//				if (realObject != null) {
//					provideableValues.add(valueProvider);
//				}
//			} else if (fakeObject instanceof List<?>) {
//				@SuppressWarnings("unchecked")
//				List<EObject> fakeObjects = (List<EObject>) fakeObject;
//				boolean provideable = true;
//				for (EObject object : fakeObjects) {
//					EObject realObject = inverseCopier.get(object);
//					if (realObject == null) {
//						provideable = false;
//						break;
//					}
//				}
//				if (provideable) {
//					provideableValues.add(valueProvider);
//				}
//			}
//		}
//
//		//		fakeInterpreter.setProvideableValues(provideableValues);
//
//		for (IValueProvider<?, ?> valueProvider : provideableValues) {
//			valueProvider.setCopier(copier);
//		}
//
//		return fakeInterpreter;
//	}

	/**
	 * @param filteredElements
	 * @param interpreter
	 * @param refactoredModelRS
	 */
	private void fakeInterpreteAndPreCollectValues(RoleMapping mapping, List<? extends EObject> filteredElements, IRefactoringInterpreter interpreter, ResourceSet refactoredModelRS) {
		// copy init start
		Copier copier = new Copier(false, true);
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
		List<EObject> copiedInputSelection = new LinkedList<EObject>();
		for (EObject eObject : filteredElements) {
			copiedInputSelection.add(copier.get(eObject));
		}
		EObject copiedModel = copier.get(model);
		interpreter.setInput(copiedInputSelection);

		IRefactoringFakeInterpreter fakeInterpreter = interpreter.getFakeInterpreter();
		fakeInterpreter.setInput(copiedInputSelection);
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
				//TODO this doesn't need to be done here
//				for (IModelRefactoringWizardPage wizardPage : customWizardPages) {
//					wizardPage.setRoleRuntimeInstanceMap(fakeInterpreter.getRoleRuntimeInstances());
//				}
				
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

	private List<? extends EObject> filterSelectedElements() {
		List<EObject> filteredElements = RoleUtil.filterObjectsByInputRoles(currentSelection, getRoleMapping());
		List<EObject> elementsToRemove = new LinkedList<EObject>();
		for (EObject child : filteredElements) {
			List<EObject> othersList = new LinkedList<EObject>();
			for (EObject eObject : filteredElements) {
				if (!eObject.equals(child)) {
					othersList.add(eObject);
				}
			}
			for (EObject parent : othersList) {
				if (EcoreUtil.isAncestor(parent, child)) {
					elementsToRemove.add(child);
				}
			}
		}
		for (EObject child : elementsToRemove) {
			filteredElements.remove(child);
		}
		Collections.sort(filteredElements, new Comparator<EObject>() {

			public int compare(EObject o1, EObject o2) {
				EObject parent1 = o1.eContainer();
				EObject parent2 = o2.eContainer();
				if (parent1.equals(parent2)) {
					int index1 = ((List<?>) parent1.eGet(o1.eContainingFeature())).indexOf(o1);
					int index2 = ((List<?>) parent1.eGet(o2.eContainingFeature())).indexOf(o2);
					return index1 - index2;
				}
				return 0;
			}
		});
		return filteredElements;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactorer#setInput(org.eclipse.
	 * emf.common.util.EList)
	 */
	public void setInput(List<? extends EObject> selectedElements) {
		currentSelection = selectedElements;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactorer#getPossibleRefactorings
	 * (double)
	 */
	//	public List<RefactoringSpecification> getPossibleRefactorings(double minEquality) {
	//		List<RefactoringSpecification> refSpecs = new LinkedList<RefactoringSpecification>();
	//		List<RoleMapping> possibleMappings = RoleUtil.getPossibleMappingsForInputSelection(currentSelection, roleMappings, minEquality);
	//		for (RoleMapping mapping : possibleMappings) {
	//			RefactoringSpecification refSpec = refSpecRegistry.getRefSpec(mapping.getMappedRoleModel());
	//			if (refSpec != null) {
	//				refSpecs.add(refSpec);
	//			}
	//		}
	//		return refSpecs;
	//	}

	//		public List<RoleMapping> getPossibleRoleMappings(double minEquality) {
	//			return RoleUtil.getPossibleMappingsForInputSelection(currentSelection, roleMappings, minEquality);
	//		}

	/*
	 * (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#occuredErrors()
	 */
	public boolean didErrorsOccur() {
		return occuredErrors;
	}

	public List<Resource> getResourcesToSave() {
		return resourcesToSave;
	}

	public Resource getResource() {
		return resource;
	}

	/*
	 * (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#getStatus()
	 */
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
}
