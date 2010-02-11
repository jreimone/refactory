/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.refactoring.roles.RolesFactory
 * @model kind="package"
 * @generated
 */
public interface RolesPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "roles";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.emftext.org/language/roles";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "roles";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	RolesPackage eINSTANCE = org.emftext.language.refactoring.roles.impl.RolesPackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.NamedElementImpl <em>Named Element</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.NamedElementImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getNamedElement()
   * @generated
   */
	int NAMED_ELEMENT = 0;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NAMED_ELEMENT__NAME = 0;

	/**
   * The number of structural features of the '<em>Named Element</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.RoleModelImpl <em>Role Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.RoleModelImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleModel()
   * @generated
   */
	int ROLE_MODEL = 3;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.RoleImpl <em>Role</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.RoleImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRole()
   * @generated
   */
	int ROLE = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.RelationImpl <em>Relation</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.RelationImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRelation()
   * @generated
   */
	int RELATION = 1;

	/**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATION__SOURCE = 0;

	/**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATION__TARGET = 1;

	/**
   * The feature id for the '<em><b>Transitive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATION__TRANSITIVE = 2;

	/**
   * The feature id for the '<em><b>Reflexive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATION__REFLEXIVE = 3;

	/**
   * The number of structural features of the '<em>Relation</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATION_FEATURE_COUNT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE__OUTGOING = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE__INCOMING = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE__OPTIONAL = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Select On Runtime</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE__SELECT_ON_RUNTIME = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Input</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE__INPUT = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Role</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MODEL__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Roles</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MODEL__ROLES = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MODEL__RELATIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Role Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.RoleImplicationImpl <em>Role Implication</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.RoleImplicationImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleImplication()
   * @generated
   */
	int ROLE_IMPLICATION = 10;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.RoleProhibitionImpl <em>Role Prohibition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.RoleProhibitionImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleProhibition()
   * @generated
   */
	int ROLE_PROHIBITION = 7;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.MultiplicityRelationImpl <em>Multiplicity Relation</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.MultiplicityRelationImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getMultiplicityRelation()
   * @generated
   */
	int MULTIPLICITY_RELATION = 5;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.MultiplicityImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getMultiplicity()
   * @generated
   */
	int MULTIPLICITY = 4;

	/**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY__LOWER_BOUND = 0;

	/**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY__UPPER_BOUND = 1;

	/**
   * The number of structural features of the '<em>Multiplicity</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_FEATURE_COUNT = 2;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_RELATION__SOURCE = RELATION__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_RELATION__TARGET = RELATION__TARGET;

  /**
   * The feature id for the '<em><b>Transitive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_RELATION__TRANSITIVE = RELATION__TRANSITIVE;

  /**
   * The feature id for the '<em><b>Reflexive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_RELATION__REFLEXIVE = RELATION__REFLEXIVE;

  /**
   * The feature id for the '<em><b>Source Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY = RELATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_RELATION__TARGET_MULTIPLICITY = RELATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Source Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_RELATION__SOURCE_NAME = RELATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_RELATION__TARGET_NAME = RELATION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Multiplicity Relation</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MULTIPLICITY_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 4;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.RoleAssociationImpl <em>Role Association</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.RoleAssociationImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleAssociation()
   * @generated
   */
	int ROLE_ASSOCIATION = 8;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.RoleCompositionImpl <em>Role Composition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.RoleCompositionImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleComposition()
   * @generated
   */
	int ROLE_COMPOSITION = 9;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.roles.impl.RoleUseImpl <em>Role Use</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.roles.impl.RoleUseImpl
   * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleUse()
   * @generated
   */
	int ROLE_USE = 6;

	/**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_USE__SOURCE = MULTIPLICITY_RELATION__SOURCE;

	/**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_USE__TARGET = MULTIPLICITY_RELATION__TARGET;

	/**
   * The feature id for the '<em><b>Transitive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_USE__TRANSITIVE = MULTIPLICITY_RELATION__TRANSITIVE;

	/**
   * The feature id for the '<em><b>Reflexive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_USE__REFLEXIVE = MULTIPLICITY_RELATION__REFLEXIVE;

	/**
   * The feature id for the '<em><b>Source Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_USE__SOURCE_MULTIPLICITY = MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY;

	/**
   * The feature id for the '<em><b>Target Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_USE__TARGET_MULTIPLICITY = MULTIPLICITY_RELATION__TARGET_MULTIPLICITY;

	/**
   * The feature id for the '<em><b>Source Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_USE__SOURCE_NAME = MULTIPLICITY_RELATION__SOURCE_NAME;

	/**
   * The feature id for the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_USE__TARGET_NAME = MULTIPLICITY_RELATION__TARGET_NAME;

	/**
   * The number of structural features of the '<em>Role Use</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_USE_FEATURE_COUNT = MULTIPLICITY_RELATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_PROHIBITION__SOURCE = RELATION__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_PROHIBITION__TARGET = RELATION__TARGET;

  /**
   * The feature id for the '<em><b>Transitive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_PROHIBITION__TRANSITIVE = RELATION__TRANSITIVE;

  /**
   * The feature id for the '<em><b>Reflexive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_PROHIBITION__REFLEXIVE = RELATION__REFLEXIVE;

  /**
   * The number of structural features of the '<em>Role Prohibition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_PROHIBITION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_ASSOCIATION__SOURCE = MULTIPLICITY_RELATION__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_ASSOCIATION__TARGET = MULTIPLICITY_RELATION__TARGET;

  /**
   * The feature id for the '<em><b>Transitive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_ASSOCIATION__TRANSITIVE = MULTIPLICITY_RELATION__TRANSITIVE;

  /**
   * The feature id for the '<em><b>Reflexive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_ASSOCIATION__REFLEXIVE = MULTIPLICITY_RELATION__REFLEXIVE;

  /**
   * The feature id for the '<em><b>Source Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_ASSOCIATION__SOURCE_MULTIPLICITY = MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Target Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_ASSOCIATION__TARGET_MULTIPLICITY = MULTIPLICITY_RELATION__TARGET_MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Source Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_ASSOCIATION__SOURCE_NAME = MULTIPLICITY_RELATION__SOURCE_NAME;

  /**
   * The feature id for the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_ASSOCIATION__TARGET_NAME = MULTIPLICITY_RELATION__TARGET_NAME;

  /**
   * The number of structural features of the '<em>Role Association</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_ASSOCIATION_FEATURE_COUNT = MULTIPLICITY_RELATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_COMPOSITION__SOURCE = MULTIPLICITY_RELATION__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_COMPOSITION__TARGET = MULTIPLICITY_RELATION__TARGET;

  /**
   * The feature id for the '<em><b>Transitive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_COMPOSITION__TRANSITIVE = MULTIPLICITY_RELATION__TRANSITIVE;

  /**
   * The feature id for the '<em><b>Reflexive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_COMPOSITION__REFLEXIVE = MULTIPLICITY_RELATION__REFLEXIVE;

  /**
   * The feature id for the '<em><b>Source Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_COMPOSITION__SOURCE_MULTIPLICITY = MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Target Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_COMPOSITION__TARGET_MULTIPLICITY = MULTIPLICITY_RELATION__TARGET_MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Source Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_COMPOSITION__SOURCE_NAME = MULTIPLICITY_RELATION__SOURCE_NAME;

  /**
   * The feature id for the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_COMPOSITION__TARGET_NAME = MULTIPLICITY_RELATION__TARGET_NAME;

  /**
   * The number of structural features of the '<em>Role Composition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_COMPOSITION_FEATURE_COUNT = MULTIPLICITY_RELATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_IMPLICATION__SOURCE = RELATION__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_IMPLICATION__TARGET = RELATION__TARGET;

  /**
   * The feature id for the '<em><b>Transitive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_IMPLICATION__TRANSITIVE = RELATION__TRANSITIVE;

  /**
   * The feature id for the '<em><b>Reflexive</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_IMPLICATION__REFLEXIVE = RELATION__REFLEXIVE;

  /**
   * The number of structural features of the '<em>Role Implication</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_IMPLICATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 0;


	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.RoleModel <em>Role Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Model</em>'.
   * @see org.emftext.language.refactoring.roles.RoleModel
   * @generated
   */
	EClass getRoleModel();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.refactoring.roles.RoleModel#getRoles <em>Roles</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Roles</em>'.
   * @see org.emftext.language.refactoring.roles.RoleModel#getRoles()
   * @see #getRoleModel()
   * @generated
   */
	EReference getRoleModel_Roles();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.refactoring.roles.RoleModel#getRelations <em>Relations</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relations</em>'.
   * @see org.emftext.language.refactoring.roles.RoleModel#getRelations()
   * @see #getRoleModel()
   * @generated
   */
	EReference getRoleModel_Relations();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Element</em>'.
   * @see org.emftext.language.refactoring.roles.NamedElement
   * @generated
   */
	EClass getNamedElement();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.NamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.language.refactoring.roles.NamedElement#getName()
   * @see #getNamedElement()
   * @generated
   */
	EAttribute getNamedElement_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.Role <em>Role</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role</em>'.
   * @see org.emftext.language.refactoring.roles.Role
   * @generated
   */
	EClass getRole();

	/**
   * Returns the meta object for the reference list '{@link org.emftext.language.refactoring.roles.Role#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Outgoing</em>'.
   * @see org.emftext.language.refactoring.roles.Role#getOutgoing()
   * @see #getRole()
   * @generated
   */
	EReference getRole_Outgoing();

	/**
   * Returns the meta object for the reference list '{@link org.emftext.language.refactoring.roles.Role#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Incoming</em>'.
   * @see org.emftext.language.refactoring.roles.Role#getIncoming()
   * @see #getRole()
   * @generated
   */
	EReference getRole_Incoming();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.Role#isOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see org.emftext.language.refactoring.roles.Role#isOptional()
   * @see #getRole()
   * @generated
   */
	EAttribute getRole_Optional();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.Role#isSelectOnRuntime <em>Select On Runtime</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Select On Runtime</em>'.
   * @see org.emftext.language.refactoring.roles.Role#isSelectOnRuntime()
   * @see #getRole()
   * @generated
   */
	EAttribute getRole_SelectOnRuntime();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.Role#isInput <em>Input</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Input</em>'.
   * @see org.emftext.language.refactoring.roles.Role#isInput()
   * @see #getRole()
   * @generated
   */
	EAttribute getRole_Input();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.Relation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation</em>'.
   * @see org.emftext.language.refactoring.roles.Relation
   * @generated
   */
	EClass getRelation();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.refactoring.roles.Relation#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.emftext.language.refactoring.roles.Relation#getSource()
   * @see #getRelation()
   * @generated
   */
	EReference getRelation_Source();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.refactoring.roles.Relation#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.emftext.language.refactoring.roles.Relation#getTarget()
   * @see #getRelation()
   * @generated
   */
	EReference getRelation_Target();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.Relation#isTransitive <em>Transitive</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Transitive</em>'.
   * @see org.emftext.language.refactoring.roles.Relation#isTransitive()
   * @see #getRelation()
   * @generated
   */
	EAttribute getRelation_Transitive();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.Relation#isReflexive <em>Reflexive</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reflexive</em>'.
   * @see org.emftext.language.refactoring.roles.Relation#isReflexive()
   * @see #getRelation()
   * @generated
   */
	EAttribute getRelation_Reflexive();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.RoleImplication <em>Role Implication</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Implication</em>'.
   * @see org.emftext.language.refactoring.roles.RoleImplication
   * @generated
   */
	EClass getRoleImplication();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.RoleProhibition <em>Role Prohibition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Prohibition</em>'.
   * @see org.emftext.language.refactoring.roles.RoleProhibition
   * @generated
   */
	EClass getRoleProhibition();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.MultiplicityRelation <em>Multiplicity Relation</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity Relation</em>'.
   * @see org.emftext.language.refactoring.roles.MultiplicityRelation
   * @generated
   */
	EClass getMultiplicityRelation();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getSourceMultiplicity <em>Source Multiplicity</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source Multiplicity</em>'.
   * @see org.emftext.language.refactoring.roles.MultiplicityRelation#getSourceMultiplicity()
   * @see #getMultiplicityRelation()
   * @generated
   */
	EReference getMultiplicityRelation_SourceMultiplicity();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getTargetMultiplicity <em>Target Multiplicity</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target Multiplicity</em>'.
   * @see org.emftext.language.refactoring.roles.MultiplicityRelation#getTargetMultiplicity()
   * @see #getMultiplicityRelation()
   * @generated
   */
	EReference getMultiplicityRelation_TargetMultiplicity();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getSourceName <em>Source Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source Name</em>'.
   * @see org.emftext.language.refactoring.roles.MultiplicityRelation#getSourceName()
   * @see #getMultiplicityRelation()
   * @generated
   */
	EAttribute getMultiplicityRelation_SourceName();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getTargetName <em>Target Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Name</em>'.
   * @see org.emftext.language.refactoring.roles.MultiplicityRelation#getTargetName()
   * @see #getMultiplicityRelation()
   * @generated
   */
	EAttribute getMultiplicityRelation_TargetName();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity</em>'.
   * @see org.emftext.language.refactoring.roles.Multiplicity
   * @generated
   */
	EClass getMultiplicity();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.Multiplicity#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see org.emftext.language.refactoring.roles.Multiplicity#getLowerBound()
   * @see #getMultiplicity()
   * @generated
   */
	EAttribute getMultiplicity_LowerBound();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.roles.Multiplicity#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see org.emftext.language.refactoring.roles.Multiplicity#getUpperBound()
   * @see #getMultiplicity()
   * @generated
   */
	EAttribute getMultiplicity_UpperBound();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.RoleAssociation <em>Role Association</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Association</em>'.
   * @see org.emftext.language.refactoring.roles.RoleAssociation
   * @generated
   */
	EClass getRoleAssociation();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.RoleComposition <em>Role Composition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Composition</em>'.
   * @see org.emftext.language.refactoring.roles.RoleComposition
   * @generated
   */
	EClass getRoleComposition();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.roles.RoleUse <em>Role Use</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Use</em>'.
   * @see org.emftext.language.refactoring.roles.RoleUse
   * @generated
   */
	EClass getRoleUse();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	RolesFactory getRolesFactory();

	/**
   * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
   * @generated
   */
	interface Literals {
		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.RoleModelImpl <em>Role Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.RoleModelImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleModel()
     * @generated
     */
		EClass ROLE_MODEL = eINSTANCE.getRoleModel();

		/**
     * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ROLE_MODEL__ROLES = eINSTANCE.getRoleModel_Roles();

		/**
     * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ROLE_MODEL__RELATIONS = eINSTANCE.getRoleModel_Relations();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.NamedElementImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getNamedElement()
     * @generated
     */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.RoleImpl <em>Role</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.RoleImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRole()
     * @generated
     */
		EClass ROLE = eINSTANCE.getRole();

		/**
     * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ROLE__OUTGOING = eINSTANCE.getRole_Outgoing();

		/**
     * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ROLE__INCOMING = eINSTANCE.getRole_Incoming();

		/**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ROLE__OPTIONAL = eINSTANCE.getRole_Optional();

		/**
     * The meta object literal for the '<em><b>Select On Runtime</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ROLE__SELECT_ON_RUNTIME = eINSTANCE.getRole_SelectOnRuntime();

		/**
     * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ROLE__INPUT = eINSTANCE.getRole_Input();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.RelationImpl <em>Relation</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.RelationImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRelation()
     * @generated
     */
		EClass RELATION = eINSTANCE.getRelation();

		/**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RELATION__SOURCE = eINSTANCE.getRelation_Source();

		/**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RELATION__TARGET = eINSTANCE.getRelation_Target();

		/**
     * The meta object literal for the '<em><b>Transitive</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute RELATION__TRANSITIVE = eINSTANCE.getRelation_Transitive();

		/**
     * The meta object literal for the '<em><b>Reflexive</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute RELATION__REFLEXIVE = eINSTANCE.getRelation_Reflexive();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.RoleImplicationImpl <em>Role Implication</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.RoleImplicationImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleImplication()
     * @generated
     */
		EClass ROLE_IMPLICATION = eINSTANCE.getRoleImplication();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.RoleProhibitionImpl <em>Role Prohibition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.RoleProhibitionImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleProhibition()
     * @generated
     */
		EClass ROLE_PROHIBITION = eINSTANCE.getRoleProhibition();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.MultiplicityRelationImpl <em>Multiplicity Relation</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.MultiplicityRelationImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getMultiplicityRelation()
     * @generated
     */
		EClass MULTIPLICITY_RELATION = eINSTANCE.getMultiplicityRelation();

		/**
     * The meta object literal for the '<em><b>Source Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY = eINSTANCE.getMultiplicityRelation_SourceMultiplicity();

		/**
     * The meta object literal for the '<em><b>Target Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MULTIPLICITY_RELATION__TARGET_MULTIPLICITY = eINSTANCE.getMultiplicityRelation_TargetMultiplicity();

		/**
     * The meta object literal for the '<em><b>Source Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute MULTIPLICITY_RELATION__SOURCE_NAME = eINSTANCE.getMultiplicityRelation_SourceName();

		/**
     * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute MULTIPLICITY_RELATION__TARGET_NAME = eINSTANCE.getMultiplicityRelation_TargetName();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.MultiplicityImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getMultiplicity()
     * @generated
     */
		EClass MULTIPLICITY = eINSTANCE.getMultiplicity();

		/**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute MULTIPLICITY__LOWER_BOUND = eINSTANCE.getMultiplicity_LowerBound();

		/**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute MULTIPLICITY__UPPER_BOUND = eINSTANCE.getMultiplicity_UpperBound();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.RoleAssociationImpl <em>Role Association</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.RoleAssociationImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleAssociation()
     * @generated
     */
		EClass ROLE_ASSOCIATION = eINSTANCE.getRoleAssociation();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.RoleCompositionImpl <em>Role Composition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.RoleCompositionImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleComposition()
     * @generated
     */
		EClass ROLE_COMPOSITION = eINSTANCE.getRoleComposition();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.roles.impl.RoleUseImpl <em>Role Use</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.roles.impl.RoleUseImpl
     * @see org.emftext.language.refactoring.roles.impl.RolesPackageImpl#getRoleUse()
     * @generated
     */
		EClass ROLE_USE = eINSTANCE.getRoleUse();

	}

} //RolesPackage
