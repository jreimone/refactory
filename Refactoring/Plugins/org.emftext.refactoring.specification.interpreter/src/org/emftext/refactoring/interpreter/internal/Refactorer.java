/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class Refactorer implements IRefactorer {

	private EObject model;
	private RoleMappingModel roleMapping;
	private List<? extends EObject> currentSelection;
	private Map<RefactoringSpecification, IRefactoringInterpreter> interpreterMap;
	private IRefactoringSpecificationRegistry registry;
//	private IndexConnector indexConnector;

	public Refactorer(EObject model, RoleMappingModel roleMapping){
		this.model = model;
		this.roleMapping = roleMapping;
		registry = IRefactoringSpecificationRegistry.INSTANCE;
		initInterpreterMap();
	}

	private void initInterpreterMap(){
		interpreterMap = new LinkedHashMap<RefactoringSpecification, IRefactoringInterpreter>();
		EList<Mapping> mappings = roleMapping.getMappings();
		for (Mapping mapping : mappings) {
			RoleModel roleModel = mapping.getMappedRoleModel();
			EcoreUtil.resolveAll(roleModel);
//			IndexConnectorFactory factory = IndexConnectorFactory.defaultINSTANCE;
//			indexConnector = factory.getIndexConnector();
			RefactoringSpecification refSpec = registry.getRefSpec(roleModel);
			IRefactoringInterpreter interpreter = new RefactoringInterpreter();
			interpreter.initialize(refSpec, model, currentSelection);
			interpreterMap.put(refSpec, interpreter);
		}
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#getPossibleRefactorings()
	 */
	public List<RefactoringSpecification> getPossibleRefactoringsForNearestRoleModels(double minEquality) {
		List<RefactoringSpecification> refSpecs = new LinkedList<RefactoringSpecification>();
		List<Mapping> possibleMappings = RoleUtil.getPossibleMappingsForSelection(currentSelection, roleMapping, minEquality);
		for (Mapping mapping : possibleMappings) {
			RefactoringSpecification refSpec = registry.getRefSpec(mapping.getMappedRoleModel());
			if(refSpec != null){
				refSpecs.add(refSpec);
			}
		}
		return refSpecs;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#refactor(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, boolean)
	 */
	public EObject refactor(RefactoringSpecification refSpec, boolean copy) {
		if(refSpec == null){
			return null;
		}
		IRefactoringInterpreter interpreter = interpreterMap.get(refSpec);
		EObject refactoredModel = null;
		if(interpreter != null){
			refactoredModel = interpreter.interprete(copy);
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
		List<Mapping> possibleMappings = RoleUtil.getPossibleMappingsForInputSelection(currentSelection, roleMapping, minEquality);
		for (Mapping mapping : possibleMappings) {
			RefactoringSpecification refSpec = registry.getRefSpec(mapping.getMappedRoleModel());
			if(refSpec != null){
				refSpecs.add(refSpec);
			}
		}
		return refSpecs;
	}
}
