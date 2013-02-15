/**
 */
package org.emftext.refactoring.smell.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
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
 *   <li>{@link org.emftext.refactoring.smell.impl.QualitySmellModelImpl#getSmellingMetamodels <em>Smelling Metamodels</em>}</li>
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
	 * The cached value of the '{@link #getSmellingMetamodels() <em>Smelling Metamodels</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmellingMetamodels()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> smellingMetamodels;

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
	public EList<EPackage> getSmellingMetamodels() {
		if (smellingMetamodels == null) {
			smellingMetamodels = new EObjectResolvingEList<EPackage>(EPackage.class, this, SmellPackage.QUALITY_SMELL_MODEL__SMELLING_METAMODELS);
		}
		return smellingMetamodels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteQualitySmell> getSmellsForMetamodel(EPackage metamodel) {
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
			case SmellPackage.QUALITY_SMELL_MODEL__SMELLING_METAMODELS:
				return getSmellingMetamodels();
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
			case SmellPackage.QUALITY_SMELL_MODEL__SMELLING_METAMODELS:
				getSmellingMetamodels().clear();
				getSmellingMetamodels().addAll((Collection<? extends EPackage>)newValue);
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
			case SmellPackage.QUALITY_SMELL_MODEL__SMELLING_METAMODELS:
				getSmellingMetamodels().clear();
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
			case SmellPackage.QUALITY_SMELL_MODEL__SMELLING_METAMODELS:
				return smellingMetamodels != null && !smellingMetamodels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	// this method must be overridden when adding a derived feature and implemented 
	// with respect to the following pattern
	@Override
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		if(SmellPackage.Literals.QUALITY_SMELL_MODEL__CONCRETE_SMELLS.equals(notification.getFeature())){
			int eventType = notification.getEventType();
			switch (eventType) {
			case Notification.ADD:
				EObject newValue = (EObject) notification.getNewValue();
				if(newValue instanceof ConcreteQualitySmell){
					RoleMapping roleMapping = ((ConcreteQualitySmell) newValue).getRefactoring();
					if(roleMapping != null){
						EPackage metamodel = roleMapping.getOwningMappingModel().getTargetMetamodel();
						if(!getSmellingMetamodels().contains(metamodel)){
							getSmellingMetamodels().add((EPackage) metamodel);
						}
					}
				}
				break;
			case Notification.REMOVE:
				EObject oldValue = (EObject) notification.getOldValue();
				if(oldValue instanceof ConcreteQualitySmell){
					EPackage metamodelOldValue = ((ConcreteQualitySmell) oldValue).getRefactoring().getOwningMappingModel().getTargetMetamodel();
					Set<EPackage> smellingMetamodels = new HashSet<>();
					for (ConcreteQualitySmell existingSmell : getConcreteSmells()) {
						EPackage smellingMetamodel = existingSmell.getRefactoring().getOwningMappingModel().getTargetMetamodel();
						smellingMetamodels.add(smellingMetamodel);
					}
					if(!smellingMetamodels.contains(metamodelOldValue)){
						getSmellingMetamodels().remove(metamodelOldValue);
					}
				}
				break;
			default:
				break;
			}
		}
	}

	@Override
	public boolean eNotificationRequired() {
//		return super.eNotificationRequired();
		return true;
	}

} //QualitySmellModelImpl
