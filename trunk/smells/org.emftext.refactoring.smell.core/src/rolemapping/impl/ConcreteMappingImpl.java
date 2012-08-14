/**
 */
package rolemapping.impl;

import ecore.EClass;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rolemapping.AttributeMapping;
import rolemapping.CollaborationMapping;
import rolemapping.ConcreteMapping;
import rolemapping.RolemappingPackage;

import roles.MultiplicityCollaboration;
import roles.Role;
import roles.RoleAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rolemapping.impl.ConcreteMappingImpl#getRole <em>Role</em>}</li>
 *   <li>{@link rolemapping.impl.ConcreteMappingImpl#getMetaclass <em>Metaclass</em>}</li>
 *   <li>{@link rolemapping.impl.ConcreteMappingImpl#getCollaborationMappings <em>Collaboration Mappings</em>}</li>
 *   <li>{@link rolemapping.impl.ConcreteMappingImpl#getAttributeMappings <em>Attribute Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteMappingImpl extends EObjectImpl implements ConcreteMapping {
	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected Role role;

	/**
	 * The cached value of the '{@link #getMetaclass() <em>Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaclass()
	 * @generated
	 * @ordered
	 */
	protected EClass metaclass;

	/**
	 * The cached value of the '{@link #getCollaborationMappings() <em>Collaboration Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollaborationMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<CollaborationMapping> collaborationMappings;

	/**
	 * The cached value of the '{@link #getAttributeMappings() <em>Attribute Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeMapping> attributeMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected org.eclipse.emf.ecore.EClass eStaticClass() {
		return RolemappingPackage.Literals.CONCRETE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (Role)eResolveProxy(oldRole);
			if (role != oldRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.CONCRETE_MAPPING__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(Role newRole) {
		Role oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.CONCRETE_MAPPING__ROLE, oldRole, role));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaclass() {
		if (metaclass != null && metaclass.eIsProxy()) {
			InternalEObject oldMetaclass = (InternalEObject)metaclass;
			metaclass = (EClass)eResolveProxy(oldMetaclass);
			if (metaclass != oldMetaclass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.CONCRETE_MAPPING__METACLASS, oldMetaclass, metaclass));
			}
		}
		return metaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetMetaclass() {
		return metaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaclass(EClass newMetaclass) {
		EClass oldMetaclass = metaclass;
		metaclass = newMetaclass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.CONCRETE_MAPPING__METACLASS, oldMetaclass, metaclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollaborationMapping> getCollaborationMappings() {
		if (collaborationMappings == null) {
			collaborationMappings = new EObjectContainmentEList<CollaborationMapping>(CollaborationMapping.class, this, RolemappingPackage.CONCRETE_MAPPING__COLLABORATION_MAPPINGS);
		}
		return collaborationMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeMapping> getAttributeMappings() {
		if (attributeMappings == null) {
			attributeMappings = new EObjectContainmentEList<AttributeMapping>(AttributeMapping.class, this, RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS);
		}
		return attributeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CollaborationMapping getCollaborationMappingForTargetRole(Role role) {
		 
					 org.eclipse.emf.common.util.EList <rolemapping.CollaborationMapping > mappings = getCollaborationMappings ( ) ;
		 
					for ( rolemapping.CollaborationMapping relationMapping : mappings ) { 
						 org.eclipse.emf.ecore.util.EcoreUtil .resolveAll ( relationMapping ) ; 
						 roles.MultiplicityCollaboration collaboration = relationMapping .getCollaboration ( ) ; 
						if ( collaboration .getTarget ( ) .equals ( role ) ) { 
							return relationMapping ; 
						} 
					}
		 
					return null ;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AttributeMapping getAttributeMappingForAttribute(RoleAttribute attribute) {
		 
					if ( attribute == null ) { 
						return null ; 
					}
		 
					 java.util.List < rolemapping.AttributeMapping > attributeMappings = getAttributeMappings ( ) ;
		 
					for ( rolemapping.AttributeMapping attributeMapping : attributeMappings ) { 
						if ( attributeMapping .getRoleAttribute ( ) .equals ( attribute ) ) { 
							return attributeMapping ; 
						} 
					}
		 
					return null ;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CollaborationMapping getCollaborationMappingForCollaboration(MultiplicityCollaboration collaboration) {
		 
					 java.util.List <  rolemapping.CollaborationMapping > relationMappings = getCollaborationMappings ( ) ;
		 
					for ( rolemapping.CollaborationMapping collaborationMapping : relationMappings ) { 
						 roles.MultiplicityCollaboration mappedCollaboration = collaborationMapping .getCollaboration ( ) ; 
						if ( mappedCollaboration .equals ( collaboration ) ) { 
							return collaborationMapping ; 
						} 
					}
		 
					return null ;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<CollaborationMapping> getCollaborationMappingsForTargetRole(Role role) {
		 
					 org.eclipse.emf.common.util.EList < rolemapping.CollaborationMapping > mappings = getCollaborationMappings ( ) ;
		
					 org.eclipse.emf.common.util.EList < rolemapping.CollaborationMapping> targetMappings = new  org.eclipse.emf.common.util.BasicEList< rolemapping.CollaborationMapping>();
		 
					for (  rolemapping.CollaborationMapping relationMapping : mappings ) { 
						 org.eclipse.emf.ecore.util.EcoreUtil .resolveAll ( relationMapping ) ; 
						 roles.MultiplicityCollaboration collaboration = relationMapping .getCollaboration ( ) ; 
						if ( collaboration .getTarget ( ) .equals ( role ) ) { 
							targetMappings.add(relationMapping); 
						} 
					}
		 
					return targetMappings ;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RolemappingPackage.CONCRETE_MAPPING__COLLABORATION_MAPPINGS:
				return ((InternalEList<?>)getCollaborationMappings()).basicRemove(otherEnd, msgs);
			case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
				return ((InternalEList<?>)getAttributeMappings()).basicRemove(otherEnd, msgs);
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
			case RolemappingPackage.CONCRETE_MAPPING__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case RolemappingPackage.CONCRETE_MAPPING__METACLASS:
				if (resolve) return getMetaclass();
				return basicGetMetaclass();
			case RolemappingPackage.CONCRETE_MAPPING__COLLABORATION_MAPPINGS:
				return getCollaborationMappings();
			case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
				return getAttributeMappings();
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
			case RolemappingPackage.CONCRETE_MAPPING__ROLE:
				setRole((Role)newValue);
				return;
			case RolemappingPackage.CONCRETE_MAPPING__METACLASS:
				setMetaclass((EClass)newValue);
				return;
			case RolemappingPackage.CONCRETE_MAPPING__COLLABORATION_MAPPINGS:
				getCollaborationMappings().clear();
				getCollaborationMappings().addAll((Collection<? extends CollaborationMapping>)newValue);
				return;
			case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
				getAttributeMappings().clear();
				getAttributeMappings().addAll((Collection<? extends AttributeMapping>)newValue);
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
			case RolemappingPackage.CONCRETE_MAPPING__ROLE:
				setRole((Role)null);
				return;
			case RolemappingPackage.CONCRETE_MAPPING__METACLASS:
				setMetaclass((EClass)null);
				return;
			case RolemappingPackage.CONCRETE_MAPPING__COLLABORATION_MAPPINGS:
				getCollaborationMappings().clear();
				return;
			case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
				getAttributeMappings().clear();
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
			case RolemappingPackage.CONCRETE_MAPPING__ROLE:
				return role != null;
			case RolemappingPackage.CONCRETE_MAPPING__METACLASS:
				return metaclass != null;
			case RolemappingPackage.CONCRETE_MAPPING__COLLABORATION_MAPPINGS:
				return collaborationMappings != null && !collaborationMappings.isEmpty();
			case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
				return attributeMappings != null && !attributeMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConcreteMappingImpl
