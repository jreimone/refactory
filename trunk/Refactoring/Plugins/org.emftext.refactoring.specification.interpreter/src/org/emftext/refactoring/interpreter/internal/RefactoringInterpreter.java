/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.SET;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter;

/**
 * Interpreter for a RefactoringSpecification.
 * 
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreter extends AbstractRefspecInterpreter<RefactoringInterpreterContext> {

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, java.lang.Object)
	 */
	@Override
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification(
			RefactoringSpecification object,
			RefactoringInterpreterContext context) {
		RoleModel roleModel = object.getUsedRoleModel();
		EcoreUtil.resolveAll(roleModel);
		context.initializeVariables(object);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_ASSIGN(org.emftext.language.refactoring.refactoring_specification.ASSIGN, java.lang.Object)
	 */
	@Override
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_ASSIGN(
			ASSIGN object, RefactoringInterpreterContext context) {
		// TODO Auto-generated method stub
		return super
				.interprete_org_emftext_language_refactoring_refactoring_005Fspecification_ASSIGN(
						object, context);
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE(org.emftext.language.refactoring.refactoring_specification.CREATE, java.lang.Object)
	 */
	@Override
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE(
			CREATE object, RefactoringInterpreterContext context) {
		// TODO Auto-generated method stub
		return super
				.interprete_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE(
						object, context);
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE(org.emftext.language.refactoring.refactoring_specification.MOVE, java.lang.Object)
	 */
	@Override
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE(
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
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_SET(
			SET object, RefactoringInterpreterContext context) {
		// TODO Auto-generated method stub
		return super
				.interprete_org_emftext_language_refactoring_refactoring_005Fspecification_SET(
						object, context);
	}

	
}
