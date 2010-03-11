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
import org.emftext.language.refactoring.refactoring_specification.Context;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.FromOperator;
import org.emftext.language.refactoring.refactoring_specification.FromReference;
import org.emftext.language.refactoring.refactoring_specification.Instruction;
import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RelationReference;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.SET;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.UPTREE;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingFactory;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter;
import org.emftext.refactoring.graph.IShortestPathAlgorithm;
import org.emftext.refactoring.graph.util.IPath;
import org.emftext.refactoring.graph.util.PathAlgorithmFactory;
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
	private EObject originalModel;
	private List<? extends EObject> selection;
	private RefactoringInterpreterContext context;
	private RoleMappingModel roleMapping;
	private Mapping mapping;

	@Override
	public Boolean interprete(EObject object, RefactoringInterpreterContext context) {
		EcoreUtil.resolveAll(object);
		if(object instanceof CREATE){
			CREATE create = (CREATE) object;
			Role childRole = create.getSourceRoleReference().getRole();
			if(containsModifierOPTIONAL(childRole)){return true;}
			FromClause from = create.getFrom();
			if(from != null){
				FromReference fromReference = from.getReference();
				if(fromReference instanceof VariableReference){
					Role role = ((VariableReference) fromReference).getVariable().getCreateCommand().getSourceRoleReference().getRole();
					if(containsModifierOPTIONAL(role)){return true;}
				}
			}
			TargetContext targetContext = create.getTargetContext();
			if(contextIsOptional(targetContext)){return true;}
		} else if(object instanceof ASSIGN){
			RoleAttribute attribute = ((ASSIGN) object).getSourceAttribute();
			if(attribute != null){
				Role sourceAttRole = attribute.getAttributeRole();
				if(containsModifierOPTIONAL(sourceAttRole)){return true;}
			}
			Role targetRole = ((ASSIGN) object).getTargetAttribute().getAttributeRole();
			if(containsModifierOPTIONAL(targetRole)){return true;}
		} else if(object instanceof SET){
			if(sourceContextIsOptional(((SET) object).getSource())){return true;}
			if(contextIsOptional(((SET) object).getTarget())){return true;}
		}else if(object instanceof MOVE){
			if(sourceContextIsOptional(((MOVE) object).getSource())){return true;}
			if(contextIsOptional(((MOVE) object).getTarget())){return true;}
		}
		return super.interprete(object, context);
	}
	
	private boolean sourceContextIsOptional(SourceContext context){
		if(contextIsOptional(context)){
			return true;
		}
		if(context instanceof RelationReference){
			MultiplicityRelation relation = ((RelationReference) context).getRelation();
			Role role = relation.getSource();
			if(containsModifierOPTIONAL(role)){return true;}
			role = relation.getTarget();
			if(containsModifierOPTIONAL(role)){return true;}
		}
		return false;
	}
	
	private boolean contextIsOptional(Context context){
		if(context instanceof VariableReference){
			Role role = ((VariableReference) context).getVariable().getCreateCommand().getSourceRoleReference().getRole();
			if(containsModifierOPTIONAL(role)){return true;}
		} else if(context instanceof RoleReference){
			Role role = ((RoleReference) context).getRole();
			if(containsModifierOPTIONAL(role)){return true;}
		}
		return false;
	}
	

	private boolean containsModifierOPTIONAL(Role sourceAttRole) {
		if(sourceAttRole.getModifier().contains(RoleModifier.OPTIONAL)){
			if(mapping.getEClassForRole(sourceAttRole) == null){
				RegistryUtil.log("Role '" + sourceAttRole.getName() + "' is optional and not set -> instruction will not be performed", IStatus.INFO);
				return true;
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#initialize(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, org.eclipse.emf.ecore.EObject)
	 */
	public void initialize(RefactoringSpecification refSpec, EObject model, RoleMappingModel roleMapping, Mapping mapping) {
		this.refSpec = refSpec;
		this.model = model;
		this.originalModel = model;
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
			// must be done so because refactorings always will be performed on the initial model
			// because the selection referres to the initial model 
			originalModel = copier.copy(model);
		}
		model = initialModel;
		context.setInitialContext(model, selection, roleMapping, mapping);
		initInterpretationStack();
		interprete(context);
		return getModel();
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
		Role childRole = object.getSourceRoleReference().getRole();
		Variable sourceVar = object.getVarDeclaration();
		if(sourceVar != null){
			context.addEObjectForVariable(sourceVar);
		}
		TargetContext target = object.getTargetContext();
		if(target instanceof VariableReference){
			return handleCREATETargetVariable(context, childRole, target);
		}
		if(target instanceof RoleReference){
			return handleCREATETargetRole(childRole, (RoleReference) target, object.getFrom(), sourceVar);
		}
		return false;
	}

	private Boolean handleCREATETargetRole(Role childRole, RoleReference target, FromClause from, Variable variable) {
		if(from == null){
			EClass metaclass = mapping.getEClassForRole(childRole);
			EObject childObject = ModelUtil.create(metaclass);
			Role targetRole = target.getRole();
			if(targetRole.getModifier().contains(RoleModifier.INPUT)){
				if(selection.size() == 1){
					EObject targetObject = selection.get(0);
					ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetRole);
					RelationMapping relationMapping = concreteMapping.getRelationMappingForTargetRole(childRole);
					List<ReferenceMetaClassPair> referencePairs = null;
					if(relationMapping != null){
						referencePairs = relationMapping.getReferenceMetaClassPair();
					}
					return createPath(targetObject, referencePairs, childObject);
				}
			} else {
				// TODO ask the user
			}
		} else {
			FromOperator operator = from.getOperator();
			List<? extends EObject> fromObjects = getFromReferenceObject(from);
			if(operator instanceof UPTREE){
				return handleFromOperatorUPTREE(childRole, target, fromObjects, variable);
			}
		}
		return false;
	}


	@SuppressWarnings("unchecked")
	private Boolean handleFromOperatorUPTREE(Role childRole, RoleReference target, List<? extends EObject> fromObjects, Variable variable) {
		Role targetRole = target.getRole();
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
		EObject childObject = null;
		if(variable != null && context.getEObjectForVariable(variable) != null){
			childObject = context.getEObjectForVariable(variable);
		} else {
			childObject = ModelUtil.create(childClass);
		}
		List<ReferenceMetaClassPair> referencePairs = null;
		if(relationMapping != null){
			referencePairs = relationMapping.getReferenceMetaClassPair();
		}
		return createPath(targetObject, referencePairs, childObject);
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
		EObject childObject = ModelUtil.create(childClass);
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
//			EList<EReference> references = relationMapping.getReferences();
//			List<EReference> tempList = new LinkedList<EReference>();
//			for (EReference eReference : references) {
//				tempList.add(eReference);
//			}
			return createPath(parentObject, relationMapping.getReferenceMetaClassPair(), childObject);
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private boolean createPath(EObject parent, List<ReferenceMetaClassPair> remainingReferences, EObject child){
		if(remainingReferences == null){
			IShortestPathAlgorithm algo = (new PathAlgorithmFactory()).getAlgorithm();
			List<IPath> paths = algo.calculatePaths(parent, child);
			if(paths != null && paths.size() > 0){
				IPath path = paths.get(0);
				path.removeAbstractEClasses();
				List<ReferenceMetaClassPair> references = new LinkedList<ReferenceMetaClassPair>();
				for (int i = 1; i < path.size(); i++) {
					ReferenceMetaClassPair referencePair = RolemappingFactory.eINSTANCE.createReferenceMetaClassPair();
					referencePair.setMetaClass(path.get(i).getEClass());
					referencePair.setReference(path.get(i).getReference());
					references.add(referencePair);
				}
				return createPath(parent, references, child);
			} else {
				RegistryUtil.log("Couldn't find a shortest path between " + child + " and " + parent, IStatus.ERROR);
				return false;
			}
		} else if(remainingReferences.size() == 1){
			ReferenceMetaClassPair referencePair = remainingReferences.get(0);
			try{
				if(referencePair.getReference().isMany()){
					Object feature = parent.eGet(referencePair.getReference());
					return ((List<EObject>) feature).add(child);
				} else {
					parent.eSet(referencePair.getReference(), child);
					return true;
				}
			} catch (Exception e) {
				RegistryUtil.log("Couldn't set feature " + child + " for " + parent, IStatus.ERROR);
				e.printStackTrace();
				return false;
			}
		} else {
			ReferenceMetaClassPair referencePair = remainingReferences.get(0);
			remainingReferences.remove(referencePair);
			Object feature = parent.eGet(referencePair.getReference());
			EClass featureClass = referencePair.getMetaClass();
			if(featureClass == null){
				featureClass = referencePair.getReference().getEReferenceType();
			}
			if(featureClass.isAbstract()){
				// TODO ask user
				return false;
			}
			EObject featureObject = ModelUtil.create(featureClass);
			((List<EObject>) feature).add(featureObject);
			return createPath(featureObject, remainingReferences, child);
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
		List<ReferenceMetaClassPair> referencePairs = null;
		if(relationMapping != null){
			referencePairs = relationMapping.getReferenceMetaClassPair();
		}
		return createPath(targetObject, referencePairs, sourceObject);
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#setInput(java.util.List)
	 */
	public void setInput(List<? extends EObject> currentSelection) {
		this.selection = currentSelection;
	}

	public EObject getModel() {
		return model;
	}

	public EObject getOriginalModel() {
		return originalModel;
	}
}
