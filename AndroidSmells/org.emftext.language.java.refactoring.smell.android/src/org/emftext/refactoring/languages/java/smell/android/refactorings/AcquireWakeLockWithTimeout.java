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
import org.emftext.language.java.expressions.ExpressionsPackage;
import org.emftext.language.java.expressions.MultiplicativeExpression;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;


public class AcquireWakeLockWithTimeout extends
		AbstractRefactoringPostProcessor {

	private final static String ACQUIRE_WITH_TIMEOUT = "60*1000*10";

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			EObject refactoredModel, ResourceSet resourceSet,
			ChangeDescription change, RefactoringSpecification refSpec,
			List<IModelRefactoringWizardPage> customWizardPages,
			boolean isFakeRun, Map<EObject, EObject> copier,
			List<? extends EObject> initialSelection) {

		MethodCall acquireMethodCall = RoleUtil.getFirstObjectForRole(
				"Selection", MethodCall.class, roleRuntimeInstanceMap);

		MultiplicativeExpression me = parsePartialFragment(
				ACQUIRE_WITH_TIMEOUT,
				ExpressionsPackage.Literals.MULTIPLICATIVE_EXPRESSION,
				MultiplicativeExpression.class).get(0);

		acquireMethodCall.getArguments().add(me);

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
