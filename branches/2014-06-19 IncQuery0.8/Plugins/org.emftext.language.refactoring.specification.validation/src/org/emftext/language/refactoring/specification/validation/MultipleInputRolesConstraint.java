package org.emftext.language.refactoring.specification.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.FILTER;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.FromOperator;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.util.RoleUtil;

public class MultipleInputRolesConstraint extends AbstractModelConstraint implements IModelConstraint{

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();
		if(target instanceof ConstantsReference){
			ConstantsReference constantsReference = (ConstantsReference) target;
			EObject parent = constantsReference.eContainer();
			if(parent instanceof FromClause){
				FromClause fromClause = (FromClause) parent;
				FromOperator operator = fromClause.getOperator();
				if(!(operator instanceof FILTER)){
					RefactoringSpecification refSpec = (RefactoringSpecification) EcoreUtil.getRootContainer(constantsReference);
					RoleModel roleModel = refSpec.getUsedRoleModel();
					List<Role> inputRoles = RoleUtil.getAllInputRoles(roleModel);
					if(inputRoles.size() > 1){
						Role qualifierRole = constantsReference.getQualifierRole();
						Set<EObject> failingElements = new HashSet<EObject>();
						if(qualifierRole == null){
							failingElements.add(constantsReference);
							ConstraintStatus status = new ConstraintStatus(this, target, "If used role model contains more than one input role the constant references must specify a input role as qualifier.", failingElements);
							return status;
						} else {
							Constants constant = constantsReference.getReferencedConstant();
							if(constant == Constants.INPUT){
								if(!qualifierRole.getModifier().contains(RoleModifier.INPUT)){
									failingElements.add(constantsReference);
									ConstraintStatus status = new ConstraintStatus(this, target, "The qualifier role of the INPUT reference must be an input role.", failingElements);
									return status;
								}
							}
						}
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	@Override
	public IConstraintDescriptor getDescriptor() {
		return new AbstractConstraintDescriptor() {
			public boolean targetsTypeOf(EObject eObject) {
				return true;
			}

			public boolean targetsEvent(Notification notification) {
				return false;
			}

			public void removeCategory(Category category) {
			}

			public boolean isLive() {
				return false;
			}

			public boolean isBatch() {
				return true;
			}

			public int getStatusCode() {
				return 0;
			}

			public ConstraintSeverity getSeverity() {
				return ConstraintSeverity.ERROR;
			}

			public String getPluginId() {
				return "org.emftext.language.refactoring.specification.validation";
			}

			public String getName() {
				return "name";
			}

			public String getMessagePattern() {
				return "message";
			}

			public String getId() {
				return null;
			}

			public EvaluationMode<?> getEvaluationMode() {
				return EvaluationMode.BATCH;
			}

			public String getDescription() {
				return "description";
			}

			public Set<Category> getCategories() {
				return null;
			}

			public String getBody() {
				return null;
			}

			public void addCategory(Category category) {
			}
		};
	}

}
