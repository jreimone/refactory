/**
 */
package roles.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import roles.Collaboration;
import roles.Role;
import roles.RoleModel;
import roles.RolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link roles.impl.RoleModelImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link roles.impl.RoleModelImpl#getCollaborations <em>Collaborations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleModelImpl extends NamedElementImpl implements RoleModel {
	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getCollaborations() <em>Collaborations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollaborations()
	 * @generated
	 * @ordered
	 */
	protected EList<Collaboration> collaborations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolesPackage.Literals.ROLE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList<Role>(Role.class, this, RolesPackage.ROLE_MODEL__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Collaboration> getCollaborations() {
		if (collaborations == null) {
			collaborations = new EObjectContainmentEList<Collaboration>(Collaboration.class, this, RolesPackage.ROLE_MODEL__COLLABORATIONS);
		}
		return collaborations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RolesPackage.ROLE_MODEL__ROLES:
				return ((InternalEList<?>)getRoles()).basicRemove(otherEnd, msgs);
			case RolesPackage.ROLE_MODEL__COLLABORATIONS:
				return ((InternalEList<?>)getCollaborations()).basicRemove(otherEnd, msgs);
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
			case RolesPackage.ROLE_MODEL__ROLES:
				return getRoles();
			case RolesPackage.ROLE_MODEL__COLLABORATIONS:
				return getCollaborations();
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
			case RolesPackage.ROLE_MODEL__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case RolesPackage.ROLE_MODEL__COLLABORATIONS:
				getCollaborations().clear();
				getCollaborations().addAll((Collection<? extends Collaboration>)newValue);
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
			case RolesPackage.ROLE_MODEL__ROLES:
				getRoles().clear();
				return;
			case RolesPackage.ROLE_MODEL__COLLABORATIONS:
				getCollaborations().clear();
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
			case RolesPackage.ROLE_MODEL__ROLES:
				return roles != null && !roles.isEmpty();
			case RolesPackage.ROLE_MODEL__COLLABORATIONS:
				return collaborations != null && !collaborations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoleModelImpl
