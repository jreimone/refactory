/**
 */
package org.emftext.refactoring.smell.calculation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationPackage;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Calculation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.CalculationImpl#getMonotonicity <em>Monotonicity</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.CalculationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.CalculationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.CalculationImpl#getSmellMessage <em>Smell Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CalculationImpl extends EObjectImpl implements Calculation {
	/**
	 * The default value of the '{@link #getMonotonicity() <em>Monotonicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonotonicity()
	 * @generated
	 * @ordered
	 */
	protected static final Monotonicity MONOTONICITY_EDEFAULT = Monotonicity.INCREASING;

	/**
	 * The cached value of the '{@link #getMonotonicity() <em>Monotonicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonotonicity()
	 * @generated
	 * @ordered
	 */
	protected Monotonicity monotonicity = MONOTONICITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSmellMessage() <em>Smell Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmellMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String SMELL_MESSAGE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSmellMessage() <em>Smell Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmellMessage()
	 * @generated
	 * @ordered
	 */
	protected String smellMessage = SMELL_MESSAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CalculationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CalculationPackage.Literals.CALCULATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Monotonicity getMonotonicity() {
		return monotonicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonotonicity(Monotonicity newMonotonicity) {
		Monotonicity oldMonotonicity = monotonicity;
		monotonicity = newMonotonicity == null ? MONOTONICITY_EDEFAULT : newMonotonicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculationPackage.CALCULATION__MONOTONICITY, oldMonotonicity, monotonicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculationPackage.CALCULATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculationPackage.CALCULATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSmellMessage() {
		return smellMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmellMessage(String newSmellMessage) {
		String oldSmellMessage = smellMessage;
		smellMessage = newSmellMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculationPackage.CALCULATION__SMELL_MESSAGE, oldSmellMessage, smellMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalculationResult calculate(EObject model, float threshold) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CalculationPackage.CALCULATION__MONOTONICITY:
				return getMonotonicity();
			case CalculationPackage.CALCULATION__DESCRIPTION:
				return getDescription();
			case CalculationPackage.CALCULATION__NAME:
				return getName();
			case CalculationPackage.CALCULATION__SMELL_MESSAGE:
				return getSmellMessage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CalculationPackage.CALCULATION__MONOTONICITY:
				setMonotonicity((Monotonicity)newValue);
				return;
			case CalculationPackage.CALCULATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CalculationPackage.CALCULATION__NAME:
				setName((String)newValue);
				return;
			case CalculationPackage.CALCULATION__SMELL_MESSAGE:
				setSmellMessage((String)newValue);
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
			case CalculationPackage.CALCULATION__MONOTONICITY:
				setMonotonicity(MONOTONICITY_EDEFAULT);
				return;
			case CalculationPackage.CALCULATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CalculationPackage.CALCULATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CalculationPackage.CALCULATION__SMELL_MESSAGE:
				setSmellMessage(SMELL_MESSAGE_EDEFAULT);
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
			case CalculationPackage.CALCULATION__MONOTONICITY:
				return monotonicity != MONOTONICITY_EDEFAULT;
			case CalculationPackage.CALCULATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CalculationPackage.CALCULATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CalculationPackage.CALCULATION__SMELL_MESSAGE:
				return SMELL_MESSAGE_EDEFAULT == null ? smellMessage != null : !SMELL_MESSAGE_EDEFAULT.equals(smellMessage);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (monotonicity: ");
		result.append(monotonicity);
		result.append(", description: ");
		result.append(description);
		result.append(", name: ");
		result.append(name);
		result.append(", smellMessage: ");
		result.append(smellMessage);
		result.append(')');
		return result.toString();
	}

} //CalculationImpl
