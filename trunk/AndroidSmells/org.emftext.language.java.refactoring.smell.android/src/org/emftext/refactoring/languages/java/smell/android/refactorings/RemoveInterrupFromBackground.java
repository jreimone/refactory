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
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.LocalVariableStatement;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

public class RemoveInterrupFromBackground extends AbstractRefactoringPostProcessor {

	private static String[] NOTIFIER_STATEMENTS	= new String[]{
													"\n\t\tNotification notification = new Notification.Builder(this)\n\t\t\t.setContentTitle(\"%s\")\n\t\t\t.build();\n", 
													"\n\t\tNotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);\n", 
												   	"\n\t\tnotificationManager.notify(1, notification);"
													};

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {
		ExpressionStatement expressionStatement = RoleUtil.getFirstObjectForRole("Selection", ExpressionStatement.class, roleRuntimeInstanceMap);
		Expression expression = expressionStatement.getExpression();
		if(expression instanceof IdentifierReference){
			IdentifierReference identifierReference = (IdentifierReference) expression;
			if(identifierReference.getTarget().getName().equals("Toast")){
				Reference next = identifierReference.getNext();
				if(next instanceof MethodCall){
					MethodCall methodCall = (MethodCall) next;
					String value = null;
					List<Expression> arguments = methodCall.getArguments();
					for (Expression argument : arguments) {
						if(argument instanceof StringReference){
							value = ((StringReference) argument).getValue();
							break;
						}
					}
					List<Statement> statements = new ArrayList<>();
					for (int i = 0; i < NOTIFIER_STATEMENTS.length - 1; i++) {
						String statementString = String.format(NOTIFIER_STATEMENTS[i], value);
						LocalVariableStatement statement = parsePartialFragment(statementString, StatementsPackage.Literals.LOCAL_VARIABLE_STATEMENT, LocalVariableStatement.class).get(0);
						statements.add(statement);
					}
					ExpressionStatement statement = parsePartialFragment(NOTIFIER_STATEMENTS[NOTIFIER_STATEMENTS.length - 1], StatementsPackage.Literals.EXPRESSION_STATEMENT, ExpressionStatement.class).get(0);
					statements.add(statement);
					ClassMethod parent = expressionStatement.getParentByType(ClassMethod.class);
					if(parent != null) {
						List<Statement> targetStatements = parent.getStatements();
						int oldIndex = targetStatements.indexOf(expressionStatement);
						targetStatements.remove(expressionStatement);
						for (int i = 0; i < statements.size(); i++) {
							targetStatements.add(oldIndex + i, statements.get(i));
						}
					}
				}
			}
		}
		return Status.OK_STATUS;
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
