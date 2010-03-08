/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.FromOperator;
import org.emftext.language.refactoring.refactoring_specification.FromReference;
import org.emftext.language.refactoring.refactoring_specification.Instruction;
import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.SET;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.UPTREE;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter;
import org.emftext.refactoring.graph.IShortestPathAlgorithm;
import org.emftext.refactoring.graph.util.IPath;
import org.emftext.refactoring.graph.util.PathAlgorithmFactory;
import org.emftext.refactoring.graph.util.TreeNode;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.util.ModelUtil;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * Interpreter for a RefactoringSpecification.
 * 
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreter extends AbstractRefspecInterpreter<Boolean, RefactoringInterpreterContext> implements IRefactoringInterpreter{

	private RefactoringSpecification refSpec;
	private EObject model;
	private List<? extends EObject> selection;
	private RefactoringInterpreterContext context;
	private RoleMappingModel roleMapping;
	private Mapping mapping;

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#initialize(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, org.eclipse.emf.ecore.EObject)
	 */
	public void initialize(RefactoringSpecification refSpec, EObject model, RoleMappingModel roleMapping, Mapping mapping) {
		this.refSpec = refSpec;
		this.model = model;
		this.roleMapping = roleMapping;
		this.mapping = mapping;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#interprete()
	 */
	public EObject interprete(boolean copy) {
		context = new RefactoringInterpreterContext();
		EObject initialModel = model;
		if(copy){
			Copier copier = new Copier();
			EObject copiedModel = copier.copy(model);
			initialModel = copiedModel;
		}
		context.setInitialContext(initialModel, selection, roleMapping, mapping);
		initInterpretationStack();
		interprete(context);
		return context.getModel();
	}	

	private void initInterpretationStack(){
		TreeIterator<EObject> it = refSpec.eAllContents();
		List<Instruction> instructions = new LinkedList<Instruction>();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			if(eObject instanceof Instruction){
				instructions.add((Instruction) eObject);
			}
		}
		Collections.reverse(instructions);
		for (Instruction instruction : instructions) {
			addObjectToInterprete(instruction);
		}
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification(
			RefactoringSpecification object,
			RefactoringInterpreterContext context) {
		RoleModel roleModel = object.getUsedRoleModel();
		EcoreUtil.resolveAll(roleModel);
		//		context.initializeVariables(object);
		return true;
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_ASSIGN(org.emftext.language.refactoring.refactoring_specification.ASSIGN, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_ASSIGN(
			ASSIGN object, RefactoringInterpreterContext context) {
		//		object.get
		return super
		.interprete_org_emftext_language_refactoring_refactoring_005Fspecification_ASSIGN(
				object, context);
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE(org.emftext.language.refactoring.refactoring_specification.CREATE, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE(
			CREATE object, RefactoringInterpreterContext context) {
		Variable sourceVar = object.getVarDeclaration();
		if(sourceVar != null){
			context.addEObjectForVariable(sourceVar);
		}
		Role childRole = object.getSourceRoleReference().getRole();
		TargetContext target = object.getTargetContext();
		if(target instanceof VariableReference){
			return handleCREATETargetVariable(context, childRole, target);
		}
		if(target instanceof RoleReference){
			FromClause from = target.getFrom();
			FromOperator operator = from.getOperator();
			if(operator != null && (operator instanceof UPTREE)){
				return handleFromOperatorUPTREE(childRole, target, from);
			}

		}
		return false;
	}

	/**
	 * @param childRole
	 * @param target
	 * @param from
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Boolean handleFromOperatorUPTREE(Role childRole, TargetContext target, FromClause from) {
		Role targetRole = ((RoleReference) target).getRole();
		List<? extends EObject> fromObjects = getFromReferenceObject(from);
		List<?>[] rootPaths = new List<?>[fromObjects.size()];
		int i = 0;
		for (EObject eObject : fromObjects) {
			List<EObject> rootPath = ModelUtil.getPathToRoot(eObject);
			rootPaths[i] = rootPath;
			i++;
		}
		// build up uptree
		EObject targetObject = RoleUtil.getFirstCommonObjectWithRoleFromPaths(targetRole, mapping, (List<? extends EObject>[]) rootPaths);
		RelationMapping relationMapping = mapping.getConcreteMappingForRole(targetRole).getRelationMappingForTargetRole(childRole);
		EClass childClass = mapping.getEClassForRole(childRole);
		EObject childObject = EcoreUtil.create(childClass);
		return createPath(targetObject, (relationMapping == null) ? null : relationMapping.getReferences(), childObject, false);
	}

	private List<? extends EObject> getFromReferenceObject(FromClause from){
		FromReference reference = from.getReference();
		if(reference instanceof ConstantsReference){
			Constants constant = ((ConstantsReference) reference).getReferencedConstant();
			switch (constant) {
			case INPUT:
				return selection;
			default:
				break;
			}
		}
		if(reference instanceof VariableReference){
			Variable variable = ((VariableReference) reference).getVariable();
			List<EObject> temp = new ArrayList<EObject>();
			temp.add(context.getEObjectForVariable(variable));
			return temp;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private boolean handleCREATETargetVariable(RefactoringInterpreterContext context, Role childRole, TargetContext target) {
		Variable targetVar = ((VariableReference) target).getVariable();
		EObject parentObject = context.getEObjectForVariable(targetVar);
		EClass childClass = mapping.getEClassForRole(childRole);
		EObject childObject = EcoreUtil.create(childClass);
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetVar.getCreateCommand().getSourceRoleReference().getRole());
		RelationMapping relationMapping = concreteMapping.getRelationMappingForTargetRole(childRole);
		if(relationMapping == null){
			// add directly to parent
			EClass parentClass = parentObject.eClass();
			EList<EReference> references = parentClass.getEAllReferences();
			for (EReference eReference : references) {
				if(eReference.isContainment() && eReference.getEContainingClass().equals(childClass)){
					return ((List<EObject>)parentObject.eGet(eReference)).add(childObject);
				}
			}
		} else {
			// add with path
			EList<EReference> references = relationMapping.getReferences();
			List<EReference> tempList = new LinkedList<EReference>();
			for (EReference eReference : references) {
				tempList.add(eReference);
			}
			return createPath(parentObject, references, childObject, false);
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private boolean createPath(EObject parent, List<EReference> remainingReferences, EObject child, boolean setCommand){
		if(remainingReferences == null){
			IShortestPathAlgorithm algo = (new PathAlgorithmFactory()).getAlgorithm();
			List<IPath> paths = algo.calculatePaths(parent, child);
			if(paths != null && paths.size() > 0){
				IPath path = paths.get(0);
				path.removeAbstractEClasses();
				List<EReference> references = new LinkedList<EReference>();
				for (int i = 0; i < (path.size() - 1); i++) {
					references.add(path.get(i).getReference());
				}
				return createPath(parent, references, child, setCommand);
			} else {
				RegistryUtil.log("Couldn't find a shortest path between " + child + " and " + parent, IStatus.ERROR);
				return false;
			}
		} else if(remainingReferences.size() == 1){
			EReference reference = remainingReferences.get(0);
			if(!setCommand){
				Object feature = parent.eGet(reference);
				return ((List<EObject>) feature).add(child);
			} else {
				try {
					parent.eSet(reference, child);	
				} catch (Exception e) {
					RegistryUtil.log("Couldn't set feature " + child + " for " + parent, IStatus.ERROR);
					return false;
				}
				return true;
			}
		} else {
			EReference reference = remainingReferences.get(0);
			remainingReferences.remove(reference);
			Object feature = parent.eGet(reference);
			EClass tempParentClass = reference.getEContainingClass();
			EObject tempParent = EcoreUtil.create(tempParentClass);
			((List<EObject>) feature).add(tempParent);
			return createPath(tempParent, remainingReferences, child, setCommand);
		}
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE(org.emftext.language.refactoring.refactoring_specification.MOVE, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE(
			MOVE object, RefactoringInterpreterContext context) {
		// TODO Auto-generated method stub
		return super
		.interprete_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE(
				object, context);
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_SET(org.emftext.language.refactoring.refactoring_specification.SET, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_SET(
			SET object, RefactoringInterpreterContext context) {
		SourceContext source = object.getSource();
		TargetContext target = object.getTarget();
		EObject sourceObject = null;
		EObject targetObject = null;
		Role targetRole = null;
		Role sourceRole = null;
		if(source instanceof VariableReference){
			sourceObject = context.getEObjectForVariable(((VariableReference) source).getVariable());
			sourceRole = ((VariableReference) source).getVariable().getCreateCommand().getSourceRoleReference().getRole();
		}
		if(target instanceof VariableReference){
			targetObject = context.getEObjectForVariable(((VariableReference) target).getVariable());
			targetRole = ((VariableReference) target).getVariable().getCreateCommand().getSourceRoleReference().getRole();
		} 
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetRole);
		RelationMapping relationMapping = concreteMapping.getRelationMappingForTargetRole(sourceRole);
		return createPath(targetObject, (relationMapping == null) ? null : relationMapping.getReferences(), sourceObject, true);
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_FromOperator(org.emftext.language.refactoring.refactoring_specification.FromOperator, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_FromOperator(
			FromOperator object, RefactoringInterpreterContext context) {
		// TODO Auto-generated method stub
		return super
		.interprete_org_emftext_language_refactoring_refactoring_005Fspecification_FromOperator(
				object, context);
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_UPTREE(org.emftext.language.refactoring.refactoring_specification.UPTREE, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_UPTREE(
			UPTREE object, RefactoringInterpreterContext context) {
		// TODO Auto-generated method stub
		return super
		.interprete_org_emftext_language_refactoring_refactoring_005Fspecification_UPTREE(
				object, context);
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#setInput(java.util.List)
	 */
	public void setInput(List<? extends EObject> currentSelection) {
		this.selection = currentSelection;
	}
}
