/**
 */
package org.emftext.refactoring.smell.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.Quality;
import org.emftext.refactoring.smell.QualitySmell;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quality Smell Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.impl.QualitySmellModelImpl#getSmells <em>Smells</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.impl.QualitySmellModelImpl#getQualities <em>Qualities</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.impl.QualitySmellModelImpl#getConcreteSmells <em>Concrete Smells</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualitySmellModelImpl extends EObjectImpl implements QualitySmellModel {
	/**
	 * The cached value of the '{@link #getSmells() <em>Smells</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmells()
	 * @generated
	 * @ordered
	 */
	protected EList<QualitySmell> smells;

	/**
	 * The cached value of the '{@link #getQualities() <em>Qualities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualities()
	 * @generated
	 * @ordered
	 */
	protected EList<Quality> qualities;

	/**
	 * The cached value of the '{@link #getConcreteSmells() <em>Concrete Smells</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteSmells()
	 * @generated
	 * @ordered
	 */
	protected EList<ConcreteQualitySmell> concreteSmells;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualitySmellModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmellPackage.Literals.QUALITY_SMELL_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QualitySmell> getSmells() {
		if (smells == null) {
			smells = new EObjectContainmentEList<QualitySmell>(QualitySmell.class, this, SmellPackage.QUALITY_SMELL_MODEL__SMELLS);
		}
		return smells;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Quality> getQualities() {
		if (qualities == null) {
			qualities = new EObjectContainmentEList<Quality>(Quality.class, this, SmellPackage.QUALITY_SMELL_MODEL__QUALITIES);
		}
		return qualities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteQualitySmell> getConcreteSmells() {
		if (concreteSmells == null) {
			concreteSmells = new EObjectContainmentEList<ConcreteQualitySmell>(ConcreteQualitySmell.class, this, SmellPackage.QUALITY_SMELL_MODEL__CONCRETE_SMELLS);
		}
		return concreteSmells;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmellPackage.QUALITY_SMELL_MODEL__SMELLS:
				return ((InternalEList<?>)getSmells()).basicRemove(otherEnd, msgs);
			case SmellPackage.QUALITY_SMELL_MODEL__QUALITIES:
				return ((InternalEList<?>)getQualities()).basicRemove(otherEnd, msgs);
			case SmellPackage.QUALITY_SMELL_MODEL__CONCRETE_SMELLS:
				return ((InternalEList<?>)getConcreteSmells()).basicRemove(otherEnd, msgs);
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
			case SmellPackage.QUALITY_SMELL_MODEL__SMELLS:
				return getSmells();
			case SmellPackage.QUALITY_SMELL_MODEL__QUALITIES:
				return getQualities();
			case SmellPackage.QUALITY_SMELL_MODEL__CONCRETE_SMELLS:
				return getConcreteSmells();
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
			case SmellPackage.QUALITY_SMELL_MODEL__SMELLS:
				getSmells().clear();
				getSmells().addAll((Collection<? extends QualitySmell>)newValue);
				return;
			case SmellPackage.QUALITY_SMELL_MODEL__QUALITIES:
				getQualities().clear();
				getQualities().addAll((Collection<? extends Quality>)newValue);
				return;
			case SmellPackage.QUALITY_SMELL_MODEL__CONCRETE_SMELLS:
				getConcreteSmells().clear();
				getConcreteSmells().addAll((Collection<? extends ConcreteQualitySmell>)newValue);
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
			case SmellPackage.QUALITY_SMELL_MODEL__SMELLS:
				getSmells().clear();
				return;
			case SmellPackage.QUALITY_SMELL_MODEL__QUALITIES:
				getQualities().clear();
				return;
			case SmellPackage.QUALITY_SMELL_MODEL__CONCRETE_SMELLS:
				getConcreteSmells().clear();
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
			case SmellPackage.QUALITY_SMELL_MODEL__SMELLS:
				return smells != null && !smells.isEmpty();
			case SmellPackage.QUALITY_SMELL_MODEL__QUALITIES:
				return qualities != null && !qualities.isEmpty();
			case SmellPackage.QUALITY_SMELL_MODEL__CONCRETE_SMELLS:
				return concreteSmells != null && !concreteSmells.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //QualitySmellModelImpl
