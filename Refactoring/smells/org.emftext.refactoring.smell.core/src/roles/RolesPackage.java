/**
 */
package roles;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see roles.RolesFactory
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
	RolesPackage eINSTANCE = roles.impl.RolesPackageImpl.init();

	/**
	 * The meta object id for the '{@link roles.impl.CommentableImpl <em>Commentable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.CommentableImpl
	 * @see roles.impl.RolesPackageImpl#getCommentable()
	 * @generated
	 */
	int COMMENTABLE = 12;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENTABLE__COMMENT = 0;

	/**
	 * The number of structural features of the '<em>Commentable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENTABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link roles.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.NamedElementImpl
	 * @see roles.impl.RolesPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__COMMENT = COMMENTABLE__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = COMMENTABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = COMMENTABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link roles.impl.RoleFeatureImpl <em>Role Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.RoleFeatureImpl
	 * @see roles.impl.RolesPackageImpl#getRoleFeature()
	 * @generated
	 */
	int ROLE_FEATURE = 11;

	/**
	 * The number of structural features of the '<em>Role Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link roles.impl.CollaborationImpl <em>Collaboration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.CollaborationImpl
	 * @see roles.impl.RolesPackageImpl#getCollaboration()
	 * @generated
	 */
	int COLLABORATION = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION__SOURCE = ROLE_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION__TARGET = ROLE_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION__MODIFIER = ROLE_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Interpretation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION__INTERPRETATION_CONTEXT = ROLE_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Collaboration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_FEATURE_COUNT = ROLE_FEATURE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link roles.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.RoleImpl
	 * @see roles.impl.RolesPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__COMMENT = NAMED_ELEMENT__COMMENT;

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
	 * The feature id for the '<em><b>Modifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__MODIFIER = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link roles.impl.RoleModelImpl <em>Role Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.RoleModelImpl
	 * @see roles.impl.RolesPackageImpl#getRoleModel()
	 * @generated
	 */
	int ROLE_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MODEL__COMMENT = NAMED_ELEMENT__COMMENT;

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
	 * The feature id for the '<em><b>Collaborations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MODEL__COLLABORATIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Role Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link roles.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.MultiplicityImpl
	 * @see roles.impl.RolesPackageImpl#getMultiplicity()
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
	 * The meta object id for the '{@link roles.impl.MultiplicityCollaborationImpl <em>Multiplicity Collaboration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.MultiplicityCollaborationImpl
	 * @see roles.impl.RolesPackageImpl#getMultiplicityCollaboration()
	 * @generated
	 */
	int MULTIPLICITY_COLLABORATION = 5;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_COLLABORATION__SOURCE = COLLABORATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_COLLABORATION__TARGET = COLLABORATION__TARGET;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_COLLABORATION__MODIFIER = COLLABORATION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Interpretation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_COLLABORATION__INTERPRETATION_CONTEXT = COLLABORATION__INTERPRETATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Source Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_COLLABORATION__SOURCE_MULTIPLICITY = COLLABORATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_COLLABORATION__TARGET_MULTIPLICITY = COLLABORATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_COLLABORATION__SOURCE_NAME = COLLABORATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_COLLABORATION__TARGET_NAME = COLLABORATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Multiplicity Collaboration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_COLLABORATION_FEATURE_COUNT = COLLABORATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link roles.impl.RoleProhibitionImpl <em>Role Prohibition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.RoleProhibitionImpl
	 * @see roles.impl.RolesPackageImpl#getRoleProhibition()
	 * @generated
	 */
	int ROLE_PROHIBITION = 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_PROHIBITION__SOURCE = COLLABORATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_PROHIBITION__TARGET = COLLABORATION__TARGET;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_PROHIBITION__MODIFIER = COLLABORATION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Interpretation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_PROHIBITION__INTERPRETATION_CONTEXT = COLLABORATION__INTERPRETATION_CONTEXT;

	/**
	 * The number of structural features of the '<em>Role Prohibition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_PROHIBITION_FEATURE_COUNT = COLLABORATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link roles.impl.RoleAssociationImpl <em>Role Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.RoleAssociationImpl
	 * @see roles.impl.RolesPackageImpl#getRoleAssociation()
	 * @generated
	 */
	int ROLE_ASSOCIATION = 7;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSOCIATION__SOURCE = MULTIPLICITY_COLLABORATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSOCIATION__TARGET = MULTIPLICITY_COLLABORATION__TARGET;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSOCIATION__MODIFIER = MULTIPLICITY_COLLABORATION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Interpretation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSOCIATION__INTERPRETATION_CONTEXT = MULTIPLICITY_COLLABORATION__INTERPRETATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Source Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSOCIATION__SOURCE_MULTIPLICITY = MULTIPLICITY_COLLABORATION__SOURCE_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Target Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSOCIATION__TARGET_MULTIPLICITY = MULTIPLICITY_COLLABORATION__TARGET_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Source Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSOCIATION__SOURCE_NAME = MULTIPLICITY_COLLABORATION__SOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSOCIATION__TARGET_NAME = MULTIPLICITY_COLLABORATION__TARGET_NAME;

	/**
	 * The number of structural features of the '<em>Role Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSOCIATION_FEATURE_COUNT = MULTIPLICITY_COLLABORATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link roles.impl.RoleCompositionImpl <em>Role Composition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.RoleCompositionImpl
	 * @see roles.impl.RolesPackageImpl#getRoleComposition()
	 * @generated
	 */
	int ROLE_COMPOSITION = 8;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_COMPOSITION__SOURCE = MULTIPLICITY_COLLABORATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_COMPOSITION__TARGET = MULTIPLICITY_COLLABORATION__TARGET;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_COMPOSITION__MODIFIER = MULTIPLICITY_COLLABORATION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Interpretation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_COMPOSITION__INTERPRETATION_CONTEXT = MULTIPLICITY_COLLABORATION__INTERPRETATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Source Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_COMPOSITION__SOURCE_MULTIPLICITY = MULTIPLICITY_COLLABORATION__SOURCE_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Target Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_COMPOSITION__TARGET_MULTIPLICITY = MULTIPLICITY_COLLABORATION__TARGET_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Source Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_COMPOSITION__SOURCE_NAME = MULTIPLICITY_COLLABORATION__SOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_COMPOSITION__TARGET_NAME = MULTIPLICITY_COLLABORATION__TARGET_NAME;

	/**
	 * The number of structural features of the '<em>Role Composition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_COMPOSITION_FEATURE_COUNT = MULTIPLICITY_COLLABORATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link roles.impl.RoleImplicationImpl <em>Role Implication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.RoleImplicationImpl
	 * @see roles.impl.RolesPackageImpl#getRoleImplication()
	 * @generated
	 */
	int ROLE_IMPLICATION = 9;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_IMPLICATION__SOURCE = COLLABORATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_IMPLICATION__TARGET = COLLABORATION__TARGET;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_IMPLICATION__MODIFIER = COLLABORATION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Interpretation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_IMPLICATION__INTERPRETATION_CONTEXT = COLLABORATION__INTERPRETATION_CONTEXT;

	/**
	 * The number of structural features of the '<em>Role Implication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_IMPLICATION_FEATURE_COUNT = COLLABORATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link roles.impl.RoleAttributeImpl <em>Role Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.impl.RoleAttributeImpl
	 * @see roles.impl.RolesPackageImpl#getRoleAttribute()
	 * @generated
	 */
	int ROLE_ATTRIBUTE = 10;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ATTRIBUTE__COMMENT = NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ATTRIBUTE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ATTRIBUTE__MODIFIER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ATTRIBUTE__ATTRIBUTE_ROLE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interpretation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ATTRIBUTE__INTERPRETATION_CONTEXT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Role Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ATTRIBUTE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link roles.RoleModifier <em>Role Modifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.RoleModifier
	 * @see roles.impl.RolesPackageImpl#getRoleModifier()
	 * @generated
	 */
	int ROLE_MODIFIER = 13;

	/**
	 * The meta object id for the '{@link roles.CollaborationModifier <em>Collaboration Modifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roles.CollaborationModifier
	 * @see roles.impl.RolesPackageImpl#getCollaborationModifier()
	 * @generated
	 */
	int COLLABORATION_MODIFIER = 14;


	/**
	 * Returns the meta object for class '{@link roles.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see roles.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link roles.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roles.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link roles.Collaboration <em>Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collaboration</em>'.
	 * @see roles.Collaboration
	 * @generated
	 */
	EClass getCollaboration();

	/**
	 * Returns the meta object for the reference '{@link roles.Collaboration#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see roles.Collaboration#getSource()
	 * @see #getCollaboration()
	 * @generated
	 */
	EReference getCollaboration_Source();

	/**
	 * Returns the meta object for the reference '{@link roles.Collaboration#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see roles.Collaboration#getTarget()
	 * @see #getCollaboration()
	 * @generated
	 */
	EReference getCollaboration_Target();

	/**
	 * Returns the meta object for the attribute list '{@link roles.Collaboration#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Modifier</em>'.
	 * @see roles.Collaboration#getModifier()
	 * @see #getCollaboration()
	 * @generated
	 */
	EAttribute getCollaboration_Modifier();

	/**
	 * Returns the meta object for the reference '{@link roles.Collaboration#getInterpretationContext <em>Interpretation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interpretation Context</em>'.
	 * @see roles.Collaboration#getInterpretationContext()
	 * @see #getCollaboration()
	 * @generated
	 */
	EReference getCollaboration_InterpretationContext();

	/**
	 * Returns the meta object for class '{@link roles.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see roles.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the reference list '{@link roles.Role#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see roles.Role#getOutgoing()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link roles.Role#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see roles.Role#getIncoming()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Incoming();

	/**
	 * Returns the meta object for the attribute list '{@link roles.Role#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Modifier</em>'.
	 * @see roles.Role#getModifier()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Modifier();

	/**
	 * Returns the meta object for the containment reference list '{@link roles.Role#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see roles.Role#getAttributes()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Attributes();

	/**
	 * Returns the meta object for class '{@link roles.RoleModel <em>Role Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Model</em>'.
	 * @see roles.RoleModel
	 * @generated
	 */
	EClass getRoleModel();

	/**
	 * Returns the meta object for the containment reference list '{@link roles.RoleModel#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see roles.RoleModel#getRoles()
	 * @see #getRoleModel()
	 * @generated
	 */
	EReference getRoleModel_Roles();

	/**
	 * Returns the meta object for the containment reference list '{@link roles.RoleModel#getCollaborations <em>Collaborations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collaborations</em>'.
	 * @see roles.RoleModel#getCollaborations()
	 * @see #getRoleModel()
	 * @generated
	 */
	EReference getRoleModel_Collaborations();

	/**
	 * Returns the meta object for class '{@link roles.Multiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity</em>'.
	 * @see roles.Multiplicity
	 * @generated
	 */
	EClass getMultiplicity();

	/**
	 * Returns the meta object for the attribute '{@link roles.Multiplicity#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see roles.Multiplicity#getLowerBound()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link roles.Multiplicity#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see roles.Multiplicity#getUpperBound()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_UpperBound();

	/**
	 * Returns the meta object for class '{@link roles.MultiplicityCollaboration <em>Multiplicity Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Collaboration</em>'.
	 * @see roles.MultiplicityCollaboration
	 * @generated
	 */
	EClass getMultiplicityCollaboration();

	/**
	 * Returns the meta object for the containment reference '{@link roles.MultiplicityCollaboration#getSourceMultiplicity <em>Source Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Multiplicity</em>'.
	 * @see roles.MultiplicityCollaboration#getSourceMultiplicity()
	 * @see #getMultiplicityCollaboration()
	 * @generated
	 */
	EReference getMultiplicityCollaboration_SourceMultiplicity();

	/**
	 * Returns the meta object for the containment reference '{@link roles.MultiplicityCollaboration#getTargetMultiplicity <em>Target Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Multiplicity</em>'.
	 * @see roles.MultiplicityCollaboration#getTargetMultiplicity()
	 * @see #getMultiplicityCollaboration()
	 * @generated
	 */
	EReference getMultiplicityCollaboration_TargetMultiplicity();

	/**
	 * Returns the meta object for the attribute '{@link roles.MultiplicityCollaboration#getSourceName <em>Source Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Name</em>'.
	 * @see roles.MultiplicityCollaboration#getSourceName()
	 * @see #getMultiplicityCollaboration()
	 * @generated
	 */
	EAttribute getMultiplicityCollaboration_SourceName();

	/**
	 * Returns the meta object for the attribute '{@link roles.MultiplicityCollaboration#getTargetName <em>Target Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Name</em>'.
	 * @see roles.MultiplicityCollaboration#getTargetName()
	 * @see #getMultiplicityCollaboration()
	 * @generated
	 */
	EAttribute getMultiplicityCollaboration_TargetName();

	/**
	 * Returns the meta object for class '{@link roles.RoleProhibition <em>Role Prohibition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Prohibition</em>'.
	 * @see roles.RoleProhibition
	 * @generated
	 */
	EClass getRoleProhibition();

	/**
	 * Returns the meta object for class '{@link roles.RoleAssociation <em>Role Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Association</em>'.
	 * @see roles.RoleAssociation
	 * @generated
	 */
	EClass getRoleAssociation();

	/**
	 * Returns the meta object for class '{@link roles.RoleComposition <em>Role Composition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Composition</em>'.
	 * @see roles.RoleComposition
	 * @generated
	 */
	EClass getRoleComposition();

	/**
	 * Returns the meta object for class '{@link roles.RoleImplication <em>Role Implication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Implication</em>'.
	 * @see roles.RoleImplication
	 * @generated
	 */
	EClass getRoleImplication();

	/**
	 * Returns the meta object for class '{@link roles.RoleAttribute <em>Role Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Attribute</em>'.
	 * @see roles.RoleAttribute
	 * @generated
	 */
	EClass getRoleAttribute();

	/**
	 * Returns the meta object for the attribute list '{@link roles.RoleAttribute#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Modifier</em>'.
	 * @see roles.RoleAttribute#getModifier()
	 * @see #getRoleAttribute()
	 * @generated
	 */
	EAttribute getRoleAttribute_Modifier();

	/**
	 * Returns the meta object for the container reference '{@link roles.RoleAttribute#getAttributeRole <em>Attribute Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Attribute Role</em>'.
	 * @see roles.RoleAttribute#getAttributeRole()
	 * @see #getRoleAttribute()
	 * @generated
	 */
	EReference getRoleAttribute_AttributeRole();

	/**
	 * Returns the meta object for the reference '{@link roles.RoleAttribute#getInterpretationContext <em>Interpretation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interpretation Context</em>'.
	 * @see roles.RoleAttribute#getInterpretationContext()
	 * @see #getRoleAttribute()
	 * @generated
	 */
	EReference getRoleAttribute_InterpretationContext();

	/**
	 * Returns the meta object for class '{@link roles.RoleFeature <em>Role Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Feature</em>'.
	 * @see roles.RoleFeature
	 * @generated
	 */
	EClass getRoleFeature();

	/**
	 * Returns the meta object for class '{@link roles.Commentable <em>Commentable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Commentable</em>'.
	 * @see roles.Commentable
	 * @generated
	 */
	EClass getCommentable();

	/**
	 * Returns the meta object for the attribute '{@link roles.Commentable#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see roles.Commentable#getComment()
	 * @see #getCommentable()
	 * @generated
	 */
	EAttribute getCommentable_Comment();

	/**
	 * Returns the meta object for enum '{@link roles.RoleModifier <em>Role Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Role Modifier</em>'.
	 * @see roles.RoleModifier
	 * @generated
	 */
	EEnum getRoleModifier();

	/**
	 * Returns the meta object for enum '{@link roles.CollaborationModifier <em>Collaboration Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collaboration Modifier</em>'.
	 * @see roles.CollaborationModifier
	 * @generated
	 */
	EEnum getCollaborationModifier();

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
		 * The meta object literal for the '{@link roles.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.NamedElementImpl
		 * @see roles.impl.RolesPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link roles.impl.CollaborationImpl <em>Collaboration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.CollaborationImpl
		 * @see roles.impl.RolesPackageImpl#getCollaboration()
		 * @generated
		 */
		EClass COLLABORATION = eINSTANCE.getCollaboration();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLABORATION__SOURCE = eINSTANCE.getCollaboration_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLABORATION__TARGET = eINSTANCE.getCollaboration_Target();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLABORATION__MODIFIER = eINSTANCE.getCollaboration_Modifier();

		/**
		 * The meta object literal for the '<em><b>Interpretation Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLABORATION__INTERPRETATION_CONTEXT = eINSTANCE.getCollaboration_InterpretationContext();

		/**
		 * The meta object literal for the '{@link roles.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.RoleImpl
		 * @see roles.impl.RolesPackageImpl#getRole()
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
		 * The meta object literal for the '<em><b>Modifier</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__MODIFIER = eINSTANCE.getRole_Modifier();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__ATTRIBUTES = eINSTANCE.getRole_Attributes();

		/**
		 * The meta object literal for the '{@link roles.impl.RoleModelImpl <em>Role Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.RoleModelImpl
		 * @see roles.impl.RolesPackageImpl#getRoleModel()
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
		 * The meta object literal for the '<em><b>Collaborations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_MODEL__COLLABORATIONS = eINSTANCE.getRoleModel_Collaborations();

		/**
		 * The meta object literal for the '{@link roles.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.MultiplicityImpl
		 * @see roles.impl.RolesPackageImpl#getMultiplicity()
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
		 * The meta object literal for the '{@link roles.impl.MultiplicityCollaborationImpl <em>Multiplicity Collaboration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.MultiplicityCollaborationImpl
		 * @see roles.impl.RolesPackageImpl#getMultiplicityCollaboration()
		 * @generated
		 */
		EClass MULTIPLICITY_COLLABORATION = eINSTANCE.getMultiplicityCollaboration();

		/**
		 * The meta object literal for the '<em><b>Source Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICITY_COLLABORATION__SOURCE_MULTIPLICITY = eINSTANCE.getMultiplicityCollaboration_SourceMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Target Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICITY_COLLABORATION__TARGET_MULTIPLICITY = eINSTANCE.getMultiplicityCollaboration_TargetMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Source Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_COLLABORATION__SOURCE_NAME = eINSTANCE.getMultiplicityCollaboration_SourceName();

		/**
		 * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_COLLABORATION__TARGET_NAME = eINSTANCE.getMultiplicityCollaboration_TargetName();

		/**
		 * The meta object literal for the '{@link roles.impl.RoleProhibitionImpl <em>Role Prohibition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.RoleProhibitionImpl
		 * @see roles.impl.RolesPackageImpl#getRoleProhibition()
		 * @generated
		 */
		EClass ROLE_PROHIBITION = eINSTANCE.getRoleProhibition();

		/**
		 * The meta object literal for the '{@link roles.impl.RoleAssociationImpl <em>Role Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.RoleAssociationImpl
		 * @see roles.impl.RolesPackageImpl#getRoleAssociation()
		 * @generated
		 */
		EClass ROLE_ASSOCIATION = eINSTANCE.getRoleAssociation();

		/**
		 * The meta object literal for the '{@link roles.impl.RoleCompositionImpl <em>Role Composition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.RoleCompositionImpl
		 * @see roles.impl.RolesPackageImpl#getRoleComposition()
		 * @generated
		 */
		EClass ROLE_COMPOSITION = eINSTANCE.getRoleComposition();

		/**
		 * The meta object literal for the '{@link roles.impl.RoleImplicationImpl <em>Role Implication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.RoleImplicationImpl
		 * @see roles.impl.RolesPackageImpl#getRoleImplication()
		 * @generated
		 */
		EClass ROLE_IMPLICATION = eINSTANCE.getRoleImplication();

		/**
		 * The meta object literal for the '{@link roles.impl.RoleAttributeImpl <em>Role Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.RoleAttributeImpl
		 * @see roles.impl.RolesPackageImpl#getRoleAttribute()
		 * @generated
		 */
		EClass ROLE_ATTRIBUTE = eINSTANCE.getRoleAttribute();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE_ATTRIBUTE__MODIFIER = eINSTANCE.getRoleAttribute_Modifier();

		/**
		 * The meta object literal for the '<em><b>Attribute Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_ATTRIBUTE__ATTRIBUTE_ROLE = eINSTANCE.getRoleAttribute_AttributeRole();

		/**
		 * The meta object literal for the '<em><b>Interpretation Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_ATTRIBUTE__INTERPRETATION_CONTEXT = eINSTANCE.getRoleAttribute_InterpretationContext();

		/**
		 * The meta object literal for the '{@link roles.impl.RoleFeatureImpl <em>Role Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.RoleFeatureImpl
		 * @see roles.impl.RolesPackageImpl#getRoleFeature()
		 * @generated
		 */
		EClass ROLE_FEATURE = eINSTANCE.getRoleFeature();

		/**
		 * The meta object literal for the '{@link roles.impl.CommentableImpl <em>Commentable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.impl.CommentableImpl
		 * @see roles.impl.RolesPackageImpl#getCommentable()
		 * @generated
		 */
		EClass COMMENTABLE = eINSTANCE.getCommentable();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENTABLE__COMMENT = eINSTANCE.getCommentable_Comment();

		/**
		 * The meta object literal for the '{@link roles.RoleModifier <em>Role Modifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.RoleModifier
		 * @see roles.impl.RolesPackageImpl#getRoleModifier()
		 * @generated
		 */
		EEnum ROLE_MODIFIER = eINSTANCE.getRoleModifier();

		/**
		 * The meta object literal for the '{@link roles.CollaborationModifier <em>Collaboration Modifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roles.CollaborationModifier
		 * @see roles.impl.RolesPackageImpl#getCollaborationModifier()
		 * @generated
		 */
		EEnum COLLABORATION_MODIFIER = eINSTANCE.getCollaborationModifier();

	}

} //RolesPackage
