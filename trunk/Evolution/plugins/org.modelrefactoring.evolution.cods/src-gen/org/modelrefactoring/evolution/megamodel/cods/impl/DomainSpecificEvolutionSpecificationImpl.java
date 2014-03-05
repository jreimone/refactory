/**
 */
package org.modelrefactoring.evolution.megamodel.cods.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;

import org.modelrefactoring.evolution.megamodel.architecture.MetaModel;

import org.modelrefactoring.evolution.megamodel.architecture.ReferenceModel;
import org.modelrefactoring.evolution.megamodel.cods.CodsPackage;
import org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification;
import org.modelrefactoring.evolution.megamodel.cods.EvolutionDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Specific Evolution Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl#getReferenceModel <em>Reference Model</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl#getED <em>ED</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl#getCoEvolutionDefinition <em>Co Evolution Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainSpecificEvolutionSpecificationImpl extends EObjectImpl implements DomainSpecificEvolutionSpecification {
	/**
	 * The cached value of the '{@link #getReferenceModel() <em>Reference Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceModel()
	 * @generated
	 * @ordered
	 */
	protected ReferenceModel referenceModel;

	/**
	 * The cached value of the '{@link #getED() <em>ED</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getED()
	 * @generated
	 * @ordered
	 */
	protected EvolutionDefinition ed;

	/**
	 * The cached value of the '{@link #getCoEvolutionDefinition() <em>Co Evolution Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoEvolutionDefinition()
	 * @generated
	 * @ordered
	 */
	protected CoEvolutionDefinition coEvolutionDefinition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainSpecificEvolutionSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodsPackage.Literals.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceModel getReferenceModel() {
		if (referenceModel != null && referenceModel.eIsProxy()) {
			InternalEObject oldReferenceModel = (InternalEObject)referenceModel;
			referenceModel = (ReferenceModel)eResolveProxy(oldReferenceModel);
			if (referenceModel != oldReferenceModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__REFERENCE_MODEL, oldReferenceModel, referenceModel));
			}
		}
		return referenceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceModel basicGetReferenceModel() {
		return referenceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceModel(ReferenceModel newReferenceModel) {
		ReferenceModel oldReferenceModel = referenceModel;
		referenceModel = newReferenceModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__REFERENCE_MODEL, oldReferenceModel, referenceModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvolutionDefinition getED() {
		return ed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetED(EvolutionDefinition newED, NotificationChain msgs) {
		EvolutionDefinition oldED = ed;
		ed = newED;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED, oldED, newED);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setED(EvolutionDefinition newED) {
		if (newED != ed) {
			NotificationChain msgs = null;
			if (ed != null)
				msgs = ((InternalEObject)ed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED, null, msgs);
			if (newED != null)
				msgs = ((InternalEObject)newED).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED, null, msgs);
			msgs = basicSetED(newED, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED, newED, newED));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoEvolutionDefinition getCoEvolutionDefinition() {
		return coEvolutionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCoEvolutionDefinition(CoEvolutionDefinition newCoEvolutionDefinition, NotificationChain msgs) {
		CoEvolutionDefinition oldCoEvolutionDefinition = coEvolutionDefinition;
		coEvolutionDefinition = newCoEvolutionDefinition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_EVOLUTION_DEFINITION, oldCoEvolutionDefinition, newCoEvolutionDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoEvolutionDefinition(CoEvolutionDefinition newCoEvolutionDefinition) {
		if (newCoEvolutionDefinition != coEvolutionDefinition) {
			NotificationChain msgs = null;
			if (coEvolutionDefinition != null)
				msgs = ((InternalEObject)coEvolutionDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_EVOLUTION_DEFINITION, null, msgs);
			if (newCoEvolutionDefinition != null)
				msgs = ((InternalEObject)newCoEvolutionDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_EVOLUTION_DEFINITION, null, msgs);
			msgs = basicSetCoEvolutionDefinition(newCoEvolutionDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_EVOLUTION_DEFINITION, newCoEvolutionDefinition, newCoEvolutionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
				return basicSetED(null, msgs);
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_EVOLUTION_DEFINITION:
				return basicSetCoEvolutionDefinition(null, msgs);
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
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__REFERENCE_MODEL:
				if (resolve) return getReferenceModel();
				return basicGetReferenceModel();
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
				return getED();
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_EVOLUTION_DEFINITION:
				return getCoEvolutionDefinition();
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
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__REFERENCE_MODEL:
				setReferenceModel((ReferenceModel)newValue);
				return;
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
				setED((EvolutionDefinition)newValue);
				return;
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_EVOLUTION_DEFINITION:
				setCoEvolutionDefinition((CoEvolutionDefinition)newValue);
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
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__REFERENCE_MODEL:
				setReferenceModel((ReferenceModel)null);
				return;
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
				setED((EvolutionDefinition)null);
				return;
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_EVOLUTION_DEFINITION:
				setCoEvolutionDefinition((CoEvolutionDefinition)null);
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
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__REFERENCE_MODEL:
				return referenceModel != null;
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
				return ed != null;
			case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_EVOLUTION_DEFINITION:
				return coEvolutionDefinition != null;
		}
		return super.eIsSet(featureID);
	}

} //DomainSpecificEvolutionSpecificationImpl
