/**
 */
package org.qualitune.tracing.umt.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.qualitune.tracing.umt.StInstruction;
import org.qualitune.tracing.umt.UmtPackage;
import org.qualitune.tracing.umt.Variable;
import org.qualitune.tracing.vapoditrace.TraceEntity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>St Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.impl.StInstructionImpl#getSymbols <em>Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StInstructionImpl extends EObjectImpl implements StInstruction {
	/**
	 * The cached value of the '{@link #getSymbols() <em>Symbols</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbols()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> symbols;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StInstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmtPackage.Literals.ST_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getSymbols() {
		if (symbols == null) {
			symbols = new EObjectResolvingEList<Variable>(Variable.class, this, UmtPackage.ST_INSTRUCTION__SYMBOLS);
		}
		return symbols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmtPackage.ST_INSTRUCTION__SYMBOLS:
				return getSymbols();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UmtPackage.ST_INSTRUCTION__SYMBOLS:
				getSymbols().clear();
				getSymbols().addAll((Collection<? extends Variable>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UmtPackage.ST_INSTRUCTION__SYMBOLS:
				getSymbols().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UmtPackage.ST_INSTRUCTION__SYMBOLS:
				return symbols != null && !symbols.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StInstructionImpl
