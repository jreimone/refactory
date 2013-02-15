/**
 */
package org.emftext.refactoring.smell.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.Quality;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.SmellPackage;

import org.emftext.refactoring.smell.calculation.Calculation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quality Calculation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.impl.QualityCalculationImpl#getConcreteSmell <em>Concrete Smell</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.impl.QualityCalculationImpl#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.impl.QualityCalculationImpl#getInfluence <em>Influence</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.impl.QualityCalculationImpl#getCalculation <em>Calculation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualityCalculationImpl extends EObjectImpl implements QualityCalculation {
	/**
	 * The cached value of the '{@link #getQuality() <em>Quality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuality()
	 * @generated
	 * @ordered
	 */
	protected Quality quality;

	/**
	 * The default value of the '{@link #getInfluence() <em>Influence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluence()
	 * @generated
	 * @ordered
	 */
	protected static final float INFLUENCE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getInfluence() <em>Influence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluence()
	 * @generated
	 * @ordered
	 */
	protected float influence = INFLUENCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCalculation() <em>Calculation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalculation()
	 * @generated
	 * @ordered
	 */
	protected Calculation calculation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualityCalculationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmellPackage.Literals.QUALITY_CALCULATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteQualitySmell getConcreteSmell() {
		if (eContainerFeatureID() != SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL) return null;
		return (ConcreteQualitySmell)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcreteSmell(ConcreteQualitySmell newConcreteSmell, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConcreteSmell, SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcreteSmell(ConcreteQualitySmell newConcreteSmell) {
		if (newConcreteSmell != eInternalContainer() || (eContainerFeatureID() != SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL && newConcreteSmell != null)) {
			if (EcoreUtil.isAncestor(this, newConcreteSmell))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConcreteSmell != null)
				msgs = ((InternalEObject)newConcreteSmell).eInverseAdd(this, SmellPackage.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS, ConcreteQualitySmell.class, msgs);
			msgs = basicSetConcreteSmell(newConcreteSmell, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL, newConcreteSmell, newConcreteSmell));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quality getQuality() {
		if (quality != null && quality.eIsProxy()) {
			InternalEObject oldQuality = (InternalEObject)quality;
			quality = (Quality)eResolveProxy(oldQuality);
			if (quality != oldQuality) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmellPackage.QUALITY_CALCULATION__QUALITY, oldQuality, quality));
			}
		}
		return quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quality basicGetQuality() {
		return quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQuality(Quality newQuality, NotificationChain msgs) {
		Quality oldQuality = quality;
		quality = newQuality;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmellPackage.QUALITY_CALCULATION__QUALITY, oldQuality, newQuality);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuality(Quality newQuality) {
		if (newQuality != quality) {
			NotificationChain msgs = null;
			if (quality != null)
				msgs = ((InternalEObject)quality).eInverseRemove(this, SmellPackage.QUALITY__CALCULATIONS, Quality.class, msgs);
			if (newQuality != null)
				msgs = ((InternalEObject)newQuality).eInverseAdd(this, SmellPackage.QUALITY__CALCULATIONS, Quality.class, msgs);
			msgs = basicSetQuality(newQuality, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmellPackage.QUALITY_CALCULATION__QUALITY, newQuality, newQuality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInfluence() {
		return influence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfluence(float newInfluence) {
		float oldInfluence = influence;
		influence = newInfluence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmellPackage.QUALITY_CALCULATION__INFLUENCE, oldInfluence, influence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Calculation getCalculation() {
		return calculation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCalculation(Calculation newCalculation, NotificationChain msgs) {
		Calculation oldCalculation = calculation;
		calculation = newCalculation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmellPackage.QUALITY_CALCULATION__CALCULATION, oldCalculation, newCalculation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalculation(Calculation newCalculation) {
		if (newCalculation != calculation) {
			NotificationChain msgs = null;
			if (calculation != null)
				msgs = ((InternalEObject)calculation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmellPackage.QUALITY_CALCULATION__CALCULATION, null, msgs);
			if (newCalculation != null)
				msgs = ((InternalEObject)newCalculation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmellPackage.QUALITY_CALCULATION__CALCULATION, null, msgs);
			msgs = basicSetCalculation(newCalculation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmellPackage.QUALITY_CALCULATION__CALCULATION, newCalculation, newCalculation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConcreteSmell((ConcreteQualitySmell)otherEnd, msgs);
			case SmellPackage.QUALITY_CALCULATION__QUALITY:
				if (quality != null)
					msgs = ((InternalEObject)quality).eInverseRemove(this, SmellPackage.QUALITY__CALCULATIONS, Quality.class, msgs);
				return basicSetQuality((Quality)otherEnd, msgs);
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
			case SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL:
				return basicSetConcreteSmell(null, msgs);
			case SmellPackage.QUALITY_CALCULATION__QUALITY:
				return basicSetQuality(null, msgs);
			case SmellPackage.QUALITY_CALCULATION__CALCULATION:
				return basicSetCalculation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL:
				return eInternalContainer().eInverseRemove(this, SmellPackage.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS, ConcreteQualitySmell.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL:
				return getConcreteSmell();
			case SmellPackage.QUALITY_CALCULATION__QUALITY:
				if (resolve) return getQuality();
				return basicGetQuality();
			case SmellPackage.QUALITY_CALCULATION__INFLUENCE:
				return getInfluence();
			case SmellPackage.QUALITY_CALCULATION__CALCULATION:
				return getCalculation();
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
			case SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL:
				setConcreteSmell((ConcreteQualitySmell)newValue);
				return;
			case SmellPackage.QUALITY_CALCULATION__QUALITY:
				setQuality((Quality)newValue);
				return;
			case SmellPackage.QUALITY_CALCULATION__INFLUENCE:
				setInfluence((Float)newValue);
				return;
			case SmellPackage.QUALITY_CALCULATION__CALCULATION:
				setCalculation((Calculation)newValue);
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
			case SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL:
				setConcreteSmell((ConcreteQualitySmell)null);
				return;
			case SmellPackage.QUALITY_CALCULATION__QUALITY:
				setQuality((Quality)null);
				return;
			case SmellPackage.QUALITY_CALCULATION__INFLUENCE:
				setInfluence(INFLUENCE_EDEFAULT);
				return;
			case SmellPackage.QUALITY_CALCULATION__CALCULATION:
				setCalculation((Calculation)null);
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
			case SmellPackage.QUALITY_CALCULATION__CONCRETE_SMELL:
				return getConcreteSmell() != null;
			case SmellPackage.QUALITY_CALCULATION__QUALITY:
				return quality != null;
			case SmellPackage.QUALITY_CALCULATION__INFLUENCE:
				return influence != INFLUENCE_EDEFAULT;
			case SmellPackage.QUALITY_CALCULATION__CALCULATION:
				return calculation != null;
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
		result.append(" (influence: ");
		result.append(influence);
		result.append(')');
		return result.toString();
	}

} //QualityCalculationImpl
