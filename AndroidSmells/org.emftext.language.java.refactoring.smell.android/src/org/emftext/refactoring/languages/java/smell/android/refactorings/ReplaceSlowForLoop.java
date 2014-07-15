package org.emftext.refactoring.languages.java.smell.android.refactorings;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.annotations.AnnotationAttribute;
import org.emftext.language.java.expressions.AdditiveExpression;
import org.emftext.language.java.expressions.AssignmentExpression;
import org.emftext.language.java.expressions.AssignmentExpressionChild;
import org.emftext.language.java.expressions.ExpressionList;
import org.emftext.language.java.expressions.RelationExpression;
import org.emftext.language.java.expressions.RelationExpressionChild;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.statements.ForEachLoop;
import org.emftext.language.java.statements.ForLoop;
import org.emftext.language.java.statements.ForLoopInitializer;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.statements.impl.StatementsFactoryImpl;
import org.emftext.language.java.variables.LocalVariable;
import org.emftext.language.java.variables.Variable;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

public class ReplaceSlowForLoop extends AbstractRefactoringPostProcessor {
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleBindings,
			EObject refactoredModel, ResourceSet resourceSet,
			ChangeDescription change, RefactoringSpecification refSpec,
			List<IModelRefactoringWizardPage> customWizardPages,
			boolean isFakeRun, Map<EObject, EObject> copier) {

		ForLoop fi = RoleUtil.getFirstObjectForRole("Selection", ForLoop.class, roleBindings);

		Variable indexVariable = getIndexVariable(fi.getInit());
		Variable iterableVariable = getIterableVariable(indexVariable, (RelationExpression)fi.getCondition());
		ForEachLoop extendedLoop = createExtendedForLoop(fi.getStatement());

		fi.addBeforeContainingStatement(extendedLoop);

		return Status.OK_STATUS;

		/*return super.process(roleBindings, refactoredModel, resourceSet, change,
				refSpec, customWizardPages, isFakeRun, copier);
		 */
	}

	private Variable getIterableVariable(Variable indexVariable, RelationExpression condition){
		Variable result = null;

		for(RelationExpressionChild relationExpressionChild : condition.getChildren()){
			if (relationExpressionChild instanceof IdentifierReference){
				IdentifierReference ref = (IdentifierReference)relationExpressionChild;
				test(ref);

			}
			if (relationExpressionChild instanceof AdditiveExpression){
				//relationExpressionChild
				throw new RuntimeException("AdditiveExpressions in the for loop "
						+ "condition are not yet supported.");
			}
		}

		return result;
	}

	private void test(IdentifierReference ref){
		System.out.println(ref.eClass().getEAllAttributes().size());
		System.out.println(ref.eClass().getEAllContainments().size());
		System.out.println(ref.eClass().getName());
		System.out.println(ref.getContainingConcreteClassifier());
		System.out.println(ref.getTarget().eClass().getName());

		System.out.println(ref.getTarget().eClass().getEAllContainments().size());

		AnnotationAttribute att = (AnnotationAttribute) ref.getTarget();

		System.out.println(att.getDefaultValue());
		System.out.println(att.getName());
		System.out.println(att.getTypeReference());
		System.out.println(att.getTypeParameters().size());
		System.out.println(att.eClass().getName());

		LocalVariable dings = (LocalVariable)att;

		System.out.println(dings.getTypeReference());

		for (EReference r : ref.getTarget().eClass().getEAllContainments()){
			System.out.println(r.getName());
		}

		for (EReference r : ref.eClass().getEAllContainments()){
			System.out.println(r.getName());
		}
		System.out.println(ref.eClass().getEAttributes().size());

	}

	private LocalVariable getIndexVariable(ForLoopInitializer init) {
		LocalVariable result = null;

		if(init instanceof LocalVariable){
			result = (LocalVariable)init;
		}
		if(init instanceof AssignmentExpression){
			AssignmentExpression assignmentExpression = (AssignmentExpression)init;
			AssignmentExpressionChild child = assignmentExpression.getChild();
			System.out.println(child.getType());
			System.out.println(child.eClass().getName());
		}
		if(init instanceof ExpressionList){
			ExpressionList expressionList = (ExpressionList)init;

			AssignmentExpression assignmentExpression = 
					(AssignmentExpression)expressionList.getExpressions().get(0);
			System.out.println(assignmentExpression.getChild().eClass().getName());
			IdentifierReference ref = (IdentifierReference)assignmentExpression.getChild();
			EStructuralFeature feature = ref.eClass().getEStructuralFeature("target");
			Object test = ref.eGet(feature);
			System.out.println(test);
		}


		return result;
	}

	private ForEachLoop createExtendedForLoop(Statement statement){
		ForEachLoop result = null; 
		StatementsFactoryImpl statementsFactory = new StatementsFactoryImpl();


		result = statementsFactory.createForEachLoop();
		result.setStatement(statement);

		return result;
	}

	/**
	 * Parses the given <code>fragment</code> and returns the according model
	 * elements. The parameter <code>startRule</code> specifies the
	 * {@link EClass} which should be the starting rule.
	 * 
	 * @param fragment
	 * @param startRule
	 * @return
	 */
	public static <RuleType extends EObject> List<RuleType> parsePartialFragment(
			String fragment, EClass startRule, Class<RuleType> type) {
		URI uri = URI.createURI("temp.java");
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				fragment.getBytes());
		Map<?, ?> typeOption = Collections.singletonMap(
				IJavaOptions.RESOURCE_CONTENT_TYPE, startRule);
		try {
			resource.load(inputStream, typeOption);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<RuleType> result = new ArrayList<RuleType>();
		for (EObject parseResult : resource.getContents()) {
			if (type.isInstance(parseResult)) {
				result.add(type.cast(parseResult));
			}
		}
		return result;
	}

}
