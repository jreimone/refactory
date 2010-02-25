/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.language.refactoring.refactoring_specification.ContainmentCommand;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containment Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ContainmentCommandImpl extends InstructionImpl implements ContainmentCommand {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainmentCommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringSpecificationPackage.Literals.CONTAINMENT_COMMAND;
	}

} //ContainmentCommandImpl
