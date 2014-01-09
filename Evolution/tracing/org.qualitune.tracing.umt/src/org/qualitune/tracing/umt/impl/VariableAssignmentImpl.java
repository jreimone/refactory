/**
 */
package org.qualitune.tracing.umt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.qualitune.tracing.umt.Expression;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.qualitune.tracing.umt.UmtPackage;
import org.qualitune.tracing.umt.Variable;
import org.qualitune.tracing.umt.VariableAssignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.impl.VariableAssignmentImpl#getAssignedExpression <em>Assigned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableAssignmentImpl extends VariableProcessingInstructionImpl implements VariableAssignment {
	/**
	 * The cached value of the '{@link #getAssignedExpression() <em>Assigned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignedExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression assignedExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmtPackage.Literals.VARIABLE_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAssignedExpression() {
		return assignedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignedExpression(Expression newAssignedExpression, NotificationChain msgs) {
		Expression oldAssignedExpression = assignedExpression;
		assignedExpression = newAssignedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmtPackage.VARIABLE_ASSIGNMENT__ASSIGNED_EXPRESSION, oldAssignedExpression, newAssignedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignedExpression(Expression newAssignedExpression) {
		if (newAssignedExpression != assignedExpression) {
			NotificationChain msgs = null;
			if (assignedExpression != null)
				msgs = ((InternalEObject)assignedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmtPackage.VARIABLE_ASSIGNMENT__ASSIGNED_EXPRESSION, null, msgs);
			if (newAssignedExpression != null)
				msgs = ((InternalEObject)newAssignedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmtPackage.VARIABLE_ASSIGNMENT__ASSIGNED_EXPRESSION, null, msgs);
			msgs = basicSetAssignedExpression(newAssignedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.VARIABLE_ASSIGNMENT__ASSIGNED_EXPRESSION, newAssignedExpression, newAssignedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmtPackage.VARIABLE_ASSIGNMENT__ASSIGNED_EXPRESSION:
				return basicSetAssignedExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmtPackage.VARIABLE_ASSIGNMENT__ASSIGNED_EXPRESSION:
				return getAssignedExpression();
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
			case UmtPackage.VARIABLE_ASSIGNMENT__ASSIGNED_EXPRESSION:
				setAssignedExpression((Expression)newValue);
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
			case UmtPackage.VARIABLE_ASSIGNMENT__ASSIGNED_EXPRESSION:
				setAssignedExpression((Expression)null);
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
			case UmtPackage.VARIABLE_ASSIGNMENT__ASSIGNED_EXPRESSION:
				return assignedExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableAssignmentImpl
