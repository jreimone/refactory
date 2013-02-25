/**
 */
package org.emftext.refactoring.smell.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.refactoring.rolemapping.RoleMapping;

import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.QualitySmell;
import org.emftext.refactoring.smell.SmellPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Quality Smell</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.impl.ConcreteQualitySmellImpl#getGenericSmell <em>Generic Smell</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.impl.ConcreteQualitySmellImpl#getConcreteName <em>Concrete Name</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.impl.ConcreteQualitySmellImpl#getQualityCalculations <em>Quality Calculations</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.impl.ConcreteQualitySmellImpl#getRefactoring <em>Refactoring</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteQualitySmellImpl extends EObjectImpl implements ConcreteQualitySmell {
	/**
	 * The cached value of the '{@link #getGenericSmell() <em>Generic Smell</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenericSmell()
	 * @generated
	 * @ordered
	 */
	protected QualitySmell genericSmell;

	/**
	 * The default value of the '{@link #getConcreteName() <em>Concrete Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONCRETE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConcreteName() <em>Concrete Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteName()
	 * @generated
	 * @ordered
	 */
	protected String concreteName = CONCRETE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQualityCalculations() <em>Quality Calculations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityCalculations()
	 * @generated
	 * @ordered
	 */
	protected EList<QualityCalculation> qualityCalculations;

	/**
	 * The cached value of the '{@link #getRefactoring() <em>Refactoring</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefactoring()
	 * @generated
	 * @ordered
	 */
	protected RoleMapping refactoring;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteQualitySmellImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmellPackage.Literals.CONCRETE_QUALITY_SMELL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualitySmell getGenericSmell() {
		if (genericSmell != null && genericSmell.eIsProxy()) {
			InternalEObject oldGenericSmell = (InternalEObject)genericSmell;
			genericSmell = (QualitySmell)eResolveProxy(oldGenericSmell);
			if (genericSmell != oldGenericSmell) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmellPackage.CONCRETE_QUALITY_SMELL__GENERIC_SMELL, oldGenericSmell, genericSmell));
			}
		}
		return genericSmell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualitySmell basicGetGenericSmell() {
		return genericSmell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenericSmell(QualitySmell newGenericSmell) {
		QualitySmell oldGenericSmell = genericSmell;
		genericSmell = newGenericSmell;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmellPackage.CONCRETE_QUALITY_SMELL__GENERIC_SMELL, oldGenericSmell, genericSmell));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConcreteName() {
		return concreteName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcreteName(String newConcreteName) {
		String oldConcreteName = concreteName;
		concreteName = newConcreteName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmellPackage.CONCRETE_QUALITY_SMELL__CONCRETE_NAME, oldConcreteName, concreteName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QualityCalculation> getQualityCalculations() {
		if (qualityCalculations == null) {
			qualityCalculations = new EObjectContainmentWithInverseEList<QualityCalculation>(QualityCalculation.class, this, SmellPackage.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS, SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL);
		}
		return qualityCalculations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleMapping getRefactoring() {
		if (refactoring != null && refactoring.eIsProxy()) {
			InternalEObject oldRefactoring = (InternalEObject)refactoring;
			refactoring = (RoleMapping)eResolveProxy(oldRefactoring);
			if (refactoring != oldRefactoring) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmellPackage.CONCRETE_QUALITY_SMELL__REFACTORING, oldRefactoring, refactoring));
			}
		}
		return refactoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleMapping basicGetRefactoring() {
		return refactoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefactoring(RoleMapping newRefactoring) {
		RoleMapping oldRefactoring = refactoring;
		refactoring = newRefactoring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmellPackage.CONCRETE_QUALITY_SMELL__REFACTORING, oldRefactoring, refactoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmellPackage.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getQualityCalculations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmellPackage.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS:
				return ((InternalEList<?>)getQualityCalculations()).basicRemove(otherEnd, msgs);
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
			case SmellPackage.CONCRETE_QUALITY_SMELL__GENERIC_SMELL:
				if (resolve) return getGenericSmell();
				return basicGetGenericSmell();
			case SmellPackage.CONCRETE_QUALITY_SMELL__CONCRETE_NAME:
				return getConcreteName();
			case SmellPackage.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS:
				return getQualityCalculations();
			case SmellPackage.CONCRETE_QUALITY_SMELL__REFACTORING:
				if (resolve) return getRefactoring();
				return basicGetRefactoring();
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
			case SmellPackage.CONCRETE_QUALITY_SMELL__GENERIC_SMELL:
				setGenericSmell((QualitySmell)newValue);
				return;
			case SmellPackage.CONCRETE_QUALITY_SMELL__CONCRETE_NAME:
				setConcreteName((String)newValue);
				return;
			case SmellPackage.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS:
				getQualityCalculations().clear();
				getQualityCalculations().addAll((Collection<? extends QualityCalculation>)newValue);
				return;
			case SmellPackage.CONCRETE_QUALITY_SMELL__REFACTORING:
				setRefactoring((RoleMapping)newValue);
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
			case SmellPackage.CONCRETE_QUALITY_SMELL__GENERIC_SMELL:
				setGenericSmell((QualitySmell)null);
				return;
			case SmellPackage.CONCRETE_QUALITY_SMELL__CONCRETE_NAME:
				setConcreteName(CONCRETE_NAME_EDEFAULT);
				return;
			case SmellPackage.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS:
				getQualityCalculations().clear();
				return;
			case SmellPackage.CONCRETE_QUALITY_SMELL__REFACTORING:
				setRefactoring((RoleMapping)null);
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
			case SmellPackage.CONCRETE_QUALITY_SMELL__GENERIC_SMELL:
				return genericSmell != null;
			case SmellPackage.CONCRETE_QUALITY_SMELL__CONCRETE_NAME:
				return CONCRETE_NAME_EDEFAULT == null ? concreteName != null : !CONCRETE_NAME_EDEFAULT.equals(concreteName);
			case SmellPackage.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS:
				return qualityCalculations != null && !qualityCalculations.isEmpty();
			case SmellPackage.CONCRETE_QUALITY_SMELL__REFACTORING:
				return refactoring != null;
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
		result.append(" (concreteName: ");
		result.append(concreteName);
		result.append(')');
		return result.toString();
	}

} //ConcreteQualitySmellImpl
