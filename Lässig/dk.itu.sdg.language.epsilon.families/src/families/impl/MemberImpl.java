/**
 */
package families.impl;

import families.FamiliesPackage;
import families.Family;
import families.Member;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link families.impl.MemberImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link families.impl.MemberImpl#getFamilyFather <em>Family Father</em>}</li>
 *   <li>{@link families.impl.MemberImpl#getFamilyMother <em>Family Mother</em>}</li>
 *   <li>{@link families.impl.MemberImpl#getFamilySon <em>Family Son</em>}</li>
 *   <li>{@link families.impl.MemberImpl#getFamilyDaughter <em>Family Daughter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemberImpl extends EObjectImpl implements Member {
	/**
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected String firstName = FIRST_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FamiliesPackage.Literals.MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamiliesPackage.MEMBER__FIRST_NAME, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Family getFamilyFather() {
		if (eContainerFeatureID() != FamiliesPackage.MEMBER__FAMILY_FATHER) return null;
		return (Family)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFamilyFather(Family newFamilyFather, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFamilyFather, FamiliesPackage.MEMBER__FAMILY_FATHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamilyFather(Family newFamilyFather) {
		if (newFamilyFather != eInternalContainer() || (eContainerFeatureID() != FamiliesPackage.MEMBER__FAMILY_FATHER && newFamilyFather != null)) {
			if (EcoreUtil.isAncestor(this, newFamilyFather))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFamilyFather != null)
				msgs = ((InternalEObject)newFamilyFather).eInverseAdd(this, FamiliesPackage.FAMILY__FATHER, Family.class, msgs);
			msgs = basicSetFamilyFather(newFamilyFather, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamiliesPackage.MEMBER__FAMILY_FATHER, newFamilyFather, newFamilyFather));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Family getFamilyMother() {
		if (eContainerFeatureID() != FamiliesPackage.MEMBER__FAMILY_MOTHER) return null;
		return (Family)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFamilyMother(Family newFamilyMother, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFamilyMother, FamiliesPackage.MEMBER__FAMILY_MOTHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamilyMother(Family newFamilyMother) {
		if (newFamilyMother != eInternalContainer() || (eContainerFeatureID() != FamiliesPackage.MEMBER__FAMILY_MOTHER && newFamilyMother != null)) {
			if (EcoreUtil.isAncestor(this, newFamilyMother))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFamilyMother != null)
				msgs = ((InternalEObject)newFamilyMother).eInverseAdd(this, FamiliesPackage.FAMILY__MOTHER, Family.class, msgs);
			msgs = basicSetFamilyMother(newFamilyMother, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamiliesPackage.MEMBER__FAMILY_MOTHER, newFamilyMother, newFamilyMother));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Family getFamilySon() {
		if (eContainerFeatureID() != FamiliesPackage.MEMBER__FAMILY_SON) return null;
		return (Family)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFamilySon(Family newFamilySon, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFamilySon, FamiliesPackage.MEMBER__FAMILY_SON, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamilySon(Family newFamilySon) {
		if (newFamilySon != eInternalContainer() || (eContainerFeatureID() != FamiliesPackage.MEMBER__FAMILY_SON && newFamilySon != null)) {
			if (EcoreUtil.isAncestor(this, newFamilySon))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFamilySon != null)
				msgs = ((InternalEObject)newFamilySon).eInverseAdd(this, FamiliesPackage.FAMILY__SONS, Family.class, msgs);
			msgs = basicSetFamilySon(newFamilySon, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamiliesPackage.MEMBER__FAMILY_SON, newFamilySon, newFamilySon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Family getFamilyDaughter() {
		if (eContainerFeatureID() != FamiliesPackage.MEMBER__FAMILY_DAUGHTER) return null;
		return (Family)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFamilyDaughter(Family newFamilyDaughter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFamilyDaughter, FamiliesPackage.MEMBER__FAMILY_DAUGHTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamilyDaughter(Family newFamilyDaughter) {
		if (newFamilyDaughter != eInternalContainer() || (eContainerFeatureID() != FamiliesPackage.MEMBER__FAMILY_DAUGHTER && newFamilyDaughter != null)) {
			if (EcoreUtil.isAncestor(this, newFamilyDaughter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFamilyDaughter != null)
				msgs = ((InternalEObject)newFamilyDaughter).eInverseAdd(this, FamiliesPackage.FAMILY__DAUGHTERS, Family.class, msgs);
			msgs = basicSetFamilyDaughter(newFamilyDaughter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamiliesPackage.MEMBER__FAMILY_DAUGHTER, newFamilyDaughter, newFamilyDaughter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FamiliesPackage.MEMBER__FAMILY_FATHER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFamilyFather((Family)otherEnd, msgs);
			case FamiliesPackage.MEMBER__FAMILY_MOTHER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFamilyMother((Family)otherEnd, msgs);
			case FamiliesPackage.MEMBER__FAMILY_SON:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFamilySon((Family)otherEnd, msgs);
			case FamiliesPackage.MEMBER__FAMILY_DAUGHTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFamilyDaughter((Family)otherEnd, msgs);
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
			case FamiliesPackage.MEMBER__FAMILY_FATHER:
				return basicSetFamilyFather(null, msgs);
			case FamiliesPackage.MEMBER__FAMILY_MOTHER:
				return basicSetFamilyMother(null, msgs);
			case FamiliesPackage.MEMBER__FAMILY_SON:
				return basicSetFamilySon(null, msgs);
			case FamiliesPackage.MEMBER__FAMILY_DAUGHTER:
				return basicSetFamilyDaughter(null, msgs);
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
			case FamiliesPackage.MEMBER__FAMILY_FATHER:
				return eInternalContainer().eInverseRemove(this, FamiliesPackage.FAMILY__FATHER, Family.class, msgs);
			case FamiliesPackage.MEMBER__FAMILY_MOTHER:
				return eInternalContainer().eInverseRemove(this, FamiliesPackage.FAMILY__MOTHER, Family.class, msgs);
			case FamiliesPackage.MEMBER__FAMILY_SON:
				return eInternalContainer().eInverseRemove(this, FamiliesPackage.FAMILY__SONS, Family.class, msgs);
			case FamiliesPackage.MEMBER__FAMILY_DAUGHTER:
				return eInternalContainer().eInverseRemove(this, FamiliesPackage.FAMILY__DAUGHTERS, Family.class, msgs);
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
			case FamiliesPackage.MEMBER__FIRST_NAME:
				return getFirstName();
			case FamiliesPackage.MEMBER__FAMILY_FATHER:
				return getFamilyFather();
			case FamiliesPackage.MEMBER__FAMILY_MOTHER:
				return getFamilyMother();
			case FamiliesPackage.MEMBER__FAMILY_SON:
				return getFamilySon();
			case FamiliesPackage.MEMBER__FAMILY_DAUGHTER:
				return getFamilyDaughter();
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
			case FamiliesPackage.MEMBER__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case FamiliesPackage.MEMBER__FAMILY_FATHER:
				setFamilyFather((Family)newValue);
				return;
			case FamiliesPackage.MEMBER__FAMILY_MOTHER:
				setFamilyMother((Family)newValue);
				return;
			case FamiliesPackage.MEMBER__FAMILY_SON:
				setFamilySon((Family)newValue);
				return;
			case FamiliesPackage.MEMBER__FAMILY_DAUGHTER:
				setFamilyDaughter((Family)newValue);
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
			case FamiliesPackage.MEMBER__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case FamiliesPackage.MEMBER__FAMILY_FATHER:
				setFamilyFather((Family)null);
				return;
			case FamiliesPackage.MEMBER__FAMILY_MOTHER:
				setFamilyMother((Family)null);
				return;
			case FamiliesPackage.MEMBER__FAMILY_SON:
				setFamilySon((Family)null);
				return;
			case FamiliesPackage.MEMBER__FAMILY_DAUGHTER:
				setFamilyDaughter((Family)null);
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
			case FamiliesPackage.MEMBER__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case FamiliesPackage.MEMBER__FAMILY_FATHER:
				return getFamilyFather() != null;
			case FamiliesPackage.MEMBER__FAMILY_MOTHER:
				return getFamilyMother() != null;
			case FamiliesPackage.MEMBER__FAMILY_SON:
				return getFamilySon() != null;
			case FamiliesPackage.MEMBER__FAMILY_DAUGHTER:
				return getFamilyDaughter() != null;
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
		result.append(" (firstName: ");
		result.append(firstName);
		result.append(')');
		return result.toString();
	}

} //MemberImpl
