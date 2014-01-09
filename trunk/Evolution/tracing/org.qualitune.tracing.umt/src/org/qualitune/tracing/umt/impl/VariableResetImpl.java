/**
 */
package org.qualitune.tracing.umt.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.qualitune.tracing.umt.UmtPackage;
import org.qualitune.tracing.umt.Variable;
import org.qualitune.tracing.umt.VariableReset;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Reset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class VariableResetImpl extends VariableProcessingInstructionImpl implements VariableReset {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableResetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmtPackage.Literals.VARIABLE_RESET;
	}

} //VariableResetImpl
