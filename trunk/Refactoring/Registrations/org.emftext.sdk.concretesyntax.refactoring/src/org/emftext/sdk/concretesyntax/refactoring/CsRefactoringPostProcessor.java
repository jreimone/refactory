package org.emftext.sdk.concretesyntax.refactoring;

import java.util.Map;

import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

public class CsRefactoringPostProcessor implements IRefactoringPostProcessor {

	public CsRefactoringPostProcessor() {
		super();
	}

	public void process(Map<Role, Object> roleRuntimeInstanceMap) {
		System.out.println("CsRefactoringPostProcessor.process() " + roleRuntimeInstanceMap);
	}
}
