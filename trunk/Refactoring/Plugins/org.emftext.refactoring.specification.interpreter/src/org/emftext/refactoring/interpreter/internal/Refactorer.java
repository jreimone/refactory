/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.indexconnector.IndexConnector;
import org.emftext.refactoring.indexconnector.IndexConnectorFactory;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;

/**
 * @author Jan Reimann
 *
 */
public class Refactorer implements IRefactorer {

	private EObject model;
	private RoleMappingModel roleMapping;
	private EList<EObject> currentSelection;
	private Map<RefactoringSpecification, IRefactoringInterpreter> interpreterMap;
	
	public Refactorer(EObject model, RoleMappingModel roleMapping){
		this.model = model;
		this.roleMapping = roleMapping;
		initInterpreterMap();
	}
	
	private void initInterpreterMap(){
		interpreterMap = new LinkedHashMap<RefactoringSpecification, IRefactoringInterpreter>();
		EList<Mapping> mappings = roleMapping.getMappings();
		for (Mapping mapping : mappings) {
			RoleModel roleModel = mapping.getMappedRoleModel();
			EcoreUtil.resolveAll(roleModel);
			IndexConnectorFactory factory = IndexConnectorFactory.defaultINSTANCE;
			IndexConnector indexConnector = factory.getIndexConnector();
			RefactoringSpecification refSpec = indexConnector.getRefactoringSpecification(roleModel);
			IRefactoringInterpreter interpreter = new RefactoringInterpreter();
			interpreter.initialize(refSpec, model, currentSelection);
			interpreterMap.put(refSpec, interpreter);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#getPossibleRefactorings()
	 */
	public List<RefactoringSpecification> getPossibleRefactorings() {
		// TODO collect all possible refactorings for the current selection
		return null;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#refactor(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, boolean)
	 */
	public EObject refactor(RefactoringSpecification refSpec, boolean copy) {
		IRefactoringInterpreter interpreter = interpreterMap.get(refSpec);
		EObject refactoredModel = null;
		if(interpreter != null){
			refactoredModel = interpreter.interprete(true);
		}
		return refactoredModel;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#setInput(org.eclipse.emf.common.util.EList)
	 */
	public void setInput(EList<EObject> selectedElements) {
		currentSelection = selectedElements;
	}

}
