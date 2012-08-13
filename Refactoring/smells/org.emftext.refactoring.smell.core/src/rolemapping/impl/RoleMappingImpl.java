/**
 */
package rolemapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import rolemapping.ConcreteMapping;
import rolemapping.RoleMapping;
import rolemapping.RoleMappingModel;
import rolemapping.RolemappingPackage;

import roles.Role;
import roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rolemapping.impl.RoleMappingImpl#getName <em>Name</em>}</li>
 *   <li>{@link rolemapping.impl.RoleMappingImpl#getMappedRoleModel <em>Mapped Role Model</em>}</li>
 *   <li>{@link rolemapping.impl.RoleMappingImpl#getRoleToMetaelement <em>Role To Metaelement</em>}</li>
 *   <li>{@link rolemapping.impl.RoleMappingImpl#getOwningMappingModel <em>Owning Mapping Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleMappingImpl extends EObjectImpl implements RoleMapping {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getMappedRoleModel() <em>Mapped Role Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedRoleModel()
	 * @generated
	 * @ordered
	 */
	protected RoleModel mappedRoleModel;

	/**
	 * The cached value of the '{@link #getRoleToMetaelement() <em>Role To Metaelement</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleToMetaelement()
	 * @generated
	 * @ordered
	 */
	protected EList<ConcreteMapping> roleToMetaelement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolemappingPackage.Literals.ROLE_MAPPING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.ROLE_MAPPING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleModel getMappedRoleModel() {
		if (mappedRoleModel != null && mappedRoleModel.eIsProxy()) {
			InternalEObject oldMappedRoleModel = (InternalEObject)mappedRoleModel;
			mappedRoleModel = (RoleModel)eResolveProxy(oldMappedRoleModel);
			if (mappedRoleModel != oldMappedRoleModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.ROLE_MAPPING__MAPPED_ROLE_MODEL, oldMappedRoleModel, mappedRoleModel));
			}
		}
		return mappedRoleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleModel basicGetMappedRoleModel() {
		return mappedRoleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappedRoleModel(RoleModel newMappedRoleModel) {
		RoleModel oldMappedRoleModel = mappedRoleModel;
		mappedRoleModel = newMappedRoleModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.ROLE_MAPPING__MAPPED_ROLE_MODEL, oldMappedRoleModel, mappedRoleModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteMapping> getRoleToMetaelement() {
		if (roleToMetaelement == null) {
			roleToMetaelement = new EObjectContainmentEList<ConcreteMapping>(ConcreteMapping.class, this, RolemappingPackage.ROLE_MAPPING__ROLE_TO_METAELEMENT);
		}
		return roleToMetaelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleMappingModel getOwningMappingModel() {
		if (eContainerFeatureID() != RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL) return null;
		return (RoleMappingModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningMappingModel(RoleMappingModel newOwningMappingModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningMappingModel, RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningMappingModel(RoleMappingModel newOwningMappingModel) {
		if (newOwningMappingModel != eInternalContainer() || (eContainerFeatureID() != RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL && newOwningMappingModel != null)) {
			if (EcoreUtil.isAncestor(this, newOwningMappingModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningMappingModel != null)
				msgs = ((InternalEObject)newOwningMappingModel).eInverseAdd(this, RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS, RoleMappingModel.class, msgs);
			msgs = basicSetOwningMappingModel(newOwningMappingModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL, newOwningMappingModel, newOwningMappingModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Role> getAllMappedRoles() {
		org.eclipse.emf.common.util.EList < roles.Role > roles = new org.eclipse.emf.common.util.BasicEList < roles.Role > ( ) ; 
		org.eclipse.emf.common.util.EList < rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; 
		for ( rolemapping.ConcreteMapping concreteMapping : mappings ) { 
			roles .add ( concreteMapping .getRole ( ) ) ; 
		} 
		return roles ; 
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Role> getMappedRolesForEObject(EObject object) {
		java.util.Set < roles.Role > roleSet = new java.util.LinkedHashSet < roles.Role > ( ) ; 
		ecore.EClass metaclass = (ecore.EClass) object .eClass ( ) ; 
		org.eclipse.emf.common.util.EList < rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; 
		for ( rolemapping.ConcreteMapping concreteMapping : mappings ) { 
			roles.Role mappedRole = concreteMapping .getRole ( ) ; 
			ecore.EClass mappedClass = concreteMapping .getMetaclass ( ) ; 
			if ( mappedClass .equals ( metaclass ) ) { 
				roleSet .add ( mappedRole ) ; 
			} 
			if ( mappedRole .getModifier ( ) .contains ( org.emftext.language.refactoring.roles.RoleModifier .SUPER ) ) { 
				if ( mappedClass .isSuperTypeOf ( metaclass ) ) { 
					roleSet .add ( mappedRole ) ; 
				} 
			} 
		} 
		org.eclipse.emf.common.util.EList < roles.Role > mappedRoles = new org.eclipse.emf.common.util.BasicEList < roles.Role > ( ) ; 
		for ( roles.Role role : roleSet ) { 
			mappedRoles .add ( role ) ; 
		} 
		return mappedRoles ; 
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ecore.EClass getEClassForRole(Role role) {
		org.eclipse.emf.common.util.EList < rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; 
		for ( rolemapping.ConcreteMapping mapping : mappings ) { 
			if ( mapping .getRole ( ) .equals ( role ) ) { 
				return mapping .getMetaclass ( ) ; 
			} 
		} 
		return null ; 
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConcreteMapping getConcreteMappingForRole(Role role) {
		org.eclipse.emf.common.util.EList < rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; 
		for ( rolemapping.ConcreteMapping mapping : mappings ) { 
			if ( mapping .getRole ( ) .equals ( role ) ) { 
				return mapping ; 
			} 
		} 
		return null ; 
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningMappingModel((RoleMappingModel)otherEnd, msgs);
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
			case RolemappingPackage.ROLE_MAPPING__ROLE_TO_METAELEMENT:
				return ((InternalEList<?>)getRoleToMetaelement()).basicRemove(otherEnd, msgs);
			case RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL:
				return basicSetOwningMappingModel(null, msgs);
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
			case RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL:
				return eInternalContainer().eInverseRemove(this, RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS, RoleMappingModel.class, msgs);
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
			case RolemappingPackage.ROLE_MAPPING__NAME:
				return getName();
			case RolemappingPackage.ROLE_MAPPING__MAPPED_ROLE_MODEL:
				if (resolve) return getMappedRoleModel();
				return basicGetMappedRoleModel();
			case RolemappingPackage.ROLE_MAPPING__ROLE_TO_METAELEMENT:
				return getRoleToMetaelement();
			case RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL:
				return getOwningMappingModel();
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
			case RolemappingPackage.ROLE_MAPPING__NAME:
				setName((String)newValue);
				return;
			case RolemappingPackage.ROLE_MAPPING__MAPPED_ROLE_MODEL:
				setMappedRoleModel((RoleModel)newValue);
				return;
			case RolemappingPackage.ROLE_MAPPING__ROLE_TO_METAELEMENT:
				getRoleToMetaelement().clear();
				getRoleToMetaelement().addAll((Collection<? extends ConcreteMapping>)newValue);
				return;
			case RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL:
				setOwningMappingModel((RoleMappingModel)newValue);
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
			case RolemappingPackage.ROLE_MAPPING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RolemappingPackage.ROLE_MAPPING__MAPPED_ROLE_MODEL:
				setMappedRoleModel((RoleModel)null);
				return;
			case RolemappingPackage.ROLE_MAPPING__ROLE_TO_METAELEMENT:
				getRoleToMetaelement().clear();
				return;
			case RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL:
				setOwningMappingModel((RoleMappingModel)null);
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
			case RolemappingPackage.ROLE_MAPPING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RolemappingPackage.ROLE_MAPPING__MAPPED_ROLE_MODEL:
				return mappedRoleModel != null;
			case RolemappingPackage.ROLE_MAPPING__ROLE_TO_METAELEMENT:
				return roleToMetaelement != null && !roleToMetaelement.isEmpty();
			case RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL:
				return getOwningMappingModel() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //RoleMappingImpl
