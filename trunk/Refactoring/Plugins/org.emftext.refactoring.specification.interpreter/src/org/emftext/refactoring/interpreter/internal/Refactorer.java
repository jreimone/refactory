/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class Refactorer implements IRefactorer {

	private EObject model;
	private Map<String, Mapping> roleMappings;
	private List<? extends EObject> currentSelection;
	private Map<Mapping, IRefactoringInterpreter> interpreterMap;
	private IRefactoringSpecificationRegistry refSpecRegistry;
	private IRoleMappingRegistry roleMappingRegistry;
	private boolean occuredErrors;
	private List<Resource> resourcesToSave;

	public Refactorer(EObject model, Map<String, Mapping> roleMappings){
		this.model = model;
		this.roleMappings = roleMappings;
		refSpecRegistry = IRefactoringSpecificationRegistry.INSTANCE;
		roleMappingRegistry = IRoleMappingRegistry.INSTANCE;
		initInterpreterMap();
	}

	private void initInterpreterMap(){
		interpreterMap = new LinkedHashMap<Mapping, IRefactoringInterpreter>();
		Collection<Mapping> mappings = roleMappings.values();
		for (Mapping mapping : mappings) {
			RoleModel roleModel = mapping.getMappedRoleModel();
			EcoreUtil.resolveAll(roleModel);
			RefactoringSpecification refSpec = refSpecRegistry.getRefSpec(roleModel);
			Mapping firstMapping = roleMappings.values().toArray(new Mapping[0])[0];
			RoleMappingModel roleMapping = (RoleMappingModel) EcoreUtil.getRootContainer(firstMapping);
			IRefactoringPostProcessor postProcessor = roleMappingRegistry.getPostProcessor(roleMapping.getTargetMetamodel(), mapping);
			IRefactoringInterpreter interpreter = new RefactoringInterpreter(postProcessor);
			interpreter.initialize(refSpec, model, mapping);
			interpreterMap.put(mapping, interpreter);
		}
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#getPossibleRefactorings()
	 */
	public List<RefactoringSpecification> getPossibleRefactoringsForNearestRoleModels(double minEquality) {
		List<RefactoringSpecification> refSpecs = new LinkedList<RefactoringSpecification>();
		List<Mapping> possibleMappings = RoleUtil.getPossibleMappingsForSelection(currentSelection, roleMappings, minEquality);
		for (Mapping mapping : possibleMappings) {
			RefactoringSpecification refSpec = refSpecRegistry.getRefSpec(mapping.getMappedRoleModel());
			if(refSpec != null){
				refSpecs.add(refSpec);
			}
		}
		return refSpecs;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#refactor(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, boolean)
	 */
	public EObject refactor(Mapping mapping, boolean copy){
		if(mapping == null){
			return null;
		}
		List<? extends EObject> filteredElements = RoleUtil.filterObjectsByInputRoles(currentSelection, mapping);
		List<EObject> elementsToRemove = new LinkedList<EObject>();
		for (EObject child : filteredElements) {
			List<EObject> othersList = new LinkedList<EObject>();
			for (EObject eObject : filteredElements) {
				if(!eObject.equals(child)){
					othersList.add(eObject);
				}
			}
			for (EObject parent : othersList) {
				if(EcoreUtil.isAncestor(parent, child)){
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
				if(parent1.equals(parent2)){
					int index1 = ((List<?>) parent1.eGet(o1.eContainingFeature())).indexOf(o1);
					int index2 = ((List<?>) parent1.eGet(o2.eContainingFeature())).indexOf(o2);
					return index1 - index2;
				}
				return 0;
			}
		});
		IRefactoringInterpreter interpreter = interpreterMap.get(mapping);
		interpreter.setInput(filteredElements);
		EObject refactoredModel = null;
		if(interpreter != null){
			refactoredModel = interpreter.interprete(copy);
			occuredErrors = interpreter.didErrorsOccur();
			if(!occuredErrors){
				IRefactoringPostProcessor postProcessor = interpreter.getPostProcessor();
				if(postProcessor != null){
					postProcessor.process(interpreter.getRoleRuntimeInstances());
				}
			}
			resourcesToSave = interpreter.getResourcesToSave();
		}
		return refactoredModel;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#setInput(org.eclipse.emf.common.util.EList)
	 */
	public void setInput(List<? extends EObject> selectedElements) {
		currentSelection = selectedElements;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#getPossibleRefactorings(double)
	 */
	public List<RefactoringSpecification> getPossibleRefactorings(double minEquality) {
		List<RefactoringSpecification> refSpecs = new LinkedList<RefactoringSpecification>();
		List<Mapping> possibleMappings = RoleUtil.getPossibleMappingsForInputSelection(currentSelection, roleMappings, minEquality);
		for (Mapping mapping : possibleMappings) {
			RefactoringSpecification refSpec = refSpecRegistry.getRefSpec(mapping.getMappedRoleModel());
			if(refSpec != null){
				refSpecs.add(refSpec);
			}
		}
		return refSpecs;
	}
	
	public List<Mapping> getPossibleMappings(double minEquality){
		return RoleUtil.getPossibleMappingsForInputSelection(currentSelection, roleMappings, minEquality);
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#occuredErrors()
	 */
	public boolean didErrorsOccur() {
		return occuredErrors;
	}

	public List<Resource> getResourcesToSave() {
		return resourcesToSave;
	}
}
