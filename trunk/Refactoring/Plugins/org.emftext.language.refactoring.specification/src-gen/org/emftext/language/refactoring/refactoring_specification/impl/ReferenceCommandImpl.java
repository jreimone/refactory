/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.ReferenceCommand;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ReferenceCommandImpl extends InstructionImpl implements ReferenceCommand {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceCommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringSpecificationPackage.Literals.REFERENCE_COMMAND;
	}

} //ReferenceCommandImpl
