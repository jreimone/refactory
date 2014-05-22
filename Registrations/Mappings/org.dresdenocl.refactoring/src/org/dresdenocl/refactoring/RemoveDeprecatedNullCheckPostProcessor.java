package org.dresdenocl.refactoring;

import java.util.List;
import java.util.Map;

import org.dresdenocl.language.ocl.ClassifierContextDeclarationCS;
import org.dresdenocl.language.ocl.EqualityOperationCallExpCS;
import org.dresdenocl.language.ocl.ImplicitFeatureCallCS;
import org.dresdenocl.language.ocl.ImplicitOperationCallCS;
import org.dresdenocl.language.ocl.IntegerLiteralExpCS;
import org.dresdenocl.language.ocl.NavigationCallExp;
import org.dresdenocl.language.ocl.NullLiteralExpCS;
import org.dresdenocl.language.ocl.OclExpressionCS;
import org.dresdenocl.language.ocl.OclFactory;
import org.dresdenocl.language.ocl.OperationCallBinaryExpCS;
import org.dresdenocl.language.ocl.RelationalOperationCallExpCS;
import org.dresdenocl.pivotmodel.Operation;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

public class RemoveDeprecatedNullCheckPostProcessor extends AbstractRefactoringPostProcessor {

	private ClassifierContextDeclarationCS contextConstraint;
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {
		contextConstraint = RoleUtil.getFirstObjectForRole("Selection", ClassifierContextDeclarationCS.class, roleRuntimeInstanceMap);
		performRemoval();
		return Status.OK_STATUS;
	}

	private void performRemoval() {
		if(contextConstraint != null){
			TreeIterator<EObject> iterator = contextConstraint.eAllContents();
			while (iterator.hasNext()) {
				EObject child = (EObject) iterator.next();
				if(child instanceof EqualityOperationCallExpCS || child instanceof RelationalOperationCallExpCS){
					OperationCallBinaryExpCS equality = (OperationCallBinaryExpCS) child;
					String operation = equality.getOperationName();
					OclExpressionCS source = equality.getSource();
					OclExpressionCS target = equality.getTarget();
					if(source instanceof NavigationCallExp && target instanceof IntegerLiteralExpCS){
						IntegerLiteralExpCS integer = (IntegerLiteralExpCS) target;
						NavigationCallExp navigation = (NavigationCallExp) source;
						List<ImplicitFeatureCallCS> featureCalls = navigation.getFeatureCalls();
						List<String> navigationOperators = navigation.getNavigationOperator();
						ImplicitFeatureCallCS lastFeatureCall = featureCalls.get(featureCalls.size() - 1);
						String lastOperator = navigationOperators.get(navigationOperators.size() - 1);
						if(lastOperator.equals("->") && lastFeatureCall instanceof ImplicitOperationCallCS){
							ImplicitOperationCallCS operationCall = (ImplicitOperationCallCS) lastFeatureCall;
							Operation operationName = operationCall.getOperationName();
							if("size".equals(operationName.getName())){
								navigationOperators.remove(lastOperator);
								featureCalls.remove(lastFeatureCall);
								NullLiteralExpCS nullLiteral = OclFactory.eINSTANCE.createNullLiteralExpCS();
								equality.setTarget(nullLiteral);
								if("=".equals(operation) && integer.getIntegerLiteral() == 0){
									equality.setOperationName("=");
								} else {
									equality.setOperationName("<>");
								}
							}
						}
					}
				}
			}
		}
	}

}
