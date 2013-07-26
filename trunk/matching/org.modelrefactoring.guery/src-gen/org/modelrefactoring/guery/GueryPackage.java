/**
 */
package org.modelrefactoring.guery;

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
 * @see org.modelrefactoring.guery.GueryFactory
 * @model kind="package"
 * @generated
 */
public interface GueryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "guery";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.modelrefactoring.org/guery";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "guery";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GueryPackage eINSTANCE = org.modelrefactoring.guery.impl.GueryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.MotifModelImpl <em>Motif Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.MotifModelImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getMotifModel()
	 * @generated
	 */
	int MOTIF_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Motifs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIF_MODEL__MOTIFS = 0;

	/**
	 * The number of structural features of the '<em>Motif Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIF_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.MotifImpl <em>Motif</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.MotifImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getMotif()
	 * @generated
	 */
	int MOTIF = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIF__NAME = 0;

	/**
	 * The feature id for the '<em><b>Vertex Selection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIF__VERTEX_SELECTION = 1;

	/**
	 * The feature id for the '<em><b>Group By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIF__GROUP_BY = 2;

	/**
	 * The feature id for the '<em><b>Prepare</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIF__PREPARE = 3;

	/**
	 * The feature id for the '<em><b>Edge Selections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIF__EDGE_SELECTIONS = 4;

	/**
	 * The number of structural features of the '<em>Motif</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIF_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.RoleImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.ConstraintImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.ConstrainableImpl <em>Constrainable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.ConstrainableImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getConstrainable()
	 * @generated
	 */
	int CONSTRAINABLE = 11;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINABLE__CONSTRAINTS = 0;

	/**
	 * The number of structural features of the '<em>Constrainable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.VertexSelectionImpl <em>Vertex Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.VertexSelectionImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getVertexSelection()
	 * @generated
	 */
	int VERTEX_SELECTION = 4;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_SELECTION__CONSTRAINTS = CONSTRAINABLE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_SELECTION__ROLES = CONSTRAINABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Vertex Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_SELECTION_FEATURE_COUNT = CONSTRAINABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.EdgeSelectionImpl <em>Edge Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.EdgeSelectionImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getEdgeSelection()
	 * @generated
	 */
	int EDGE_SELECTION = 10;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SELECTION__CONSTRAINTS = CONSTRAINABLE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SELECTION__CONNECTIONS = CONSTRAINABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edge Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SELECTION_FEATURE_COUNT = CONSTRAINABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.ConnectedByImpl <em>Connected By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.ConnectedByImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getConnectedBy()
	 * @generated
	 */
	int CONNECTED_BY = 5;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTED_BY__CONSTRAINTS = EDGE_SELECTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTED_BY__CONNECTIONS = EDGE_SELECTION__CONNECTIONS;

	/**
	 * The number of structural features of the '<em>Connected By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTED_BY_FEATURE_COUNT = EDGE_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.ConnectionImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 6;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TO = 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__FROM = 1;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__MIN_LENGTH = 2;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__MAX_LENGTH = 3;

	/**
	 * The feature id for the '<em><b>Compute All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__COMPUTE_ALL = 4;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__PATH = 5;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.NotConnectedByImpl <em>Not Connected By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.NotConnectedByImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getNotConnectedBy()
	 * @generated
	 */
	int NOT_CONNECTED_BY = 7;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONNECTED_BY__CONSTRAINTS = EDGE_SELECTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONNECTED_BY__CONNECTIONS = EDGE_SELECTION__CONNECTIONS;

	/**
	 * The number of structural features of the '<em>Not Connected By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONNECTED_BY_FEATURE_COUNT = EDGE_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.GroupingImpl <em>Grouping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.GroupingImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getGrouping()
	 * @generated
	 */
	int GROUPING = 8;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING__CONSTRAINTS = CONSTRAINABLE__CONSTRAINTS;

	/**
	 * The number of structural features of the '<em>Grouping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_FEATURE_COUNT = CONSTRAINABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.PreProcessorImpl <em>Pre Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.PreProcessorImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getPreProcessor()
	 * @generated
	 */
	int PRE_PROCESSOR = 9;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_PROCESSOR__CLASS = 0;

	/**
	 * The number of structural features of the '<em>Pre Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_PROCESSOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.modelrefactoring.guery.impl.StringToEObjectMapImpl <em>String To EObject Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.guery.impl.StringToEObjectMapImpl
	 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getStringToEObjectMap()
	 * @generated
	 */
	int STRING_TO_EOBJECT_MAP = 12;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To EObject Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.MotifModel <em>Motif Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motif Model</em>'.
	 * @see org.modelrefactoring.guery.MotifModel
	 * @generated
	 */
	EClass getMotifModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelrefactoring.guery.MotifModel#getMotifs <em>Motifs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Motifs</em>'.
	 * @see org.modelrefactoring.guery.MotifModel#getMotifs()
	 * @see #getMotifModel()
	 * @generated
	 */
	EReference getMotifModel_Motifs();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.Motif <em>Motif</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motif</em>'.
	 * @see org.modelrefactoring.guery.Motif
	 * @generated
	 */
	EClass getMotif();

	/**
	 * Returns the meta object for the attribute '{@link org.modelrefactoring.guery.Motif#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.modelrefactoring.guery.Motif#getName()
	 * @see #getMotif()
	 * @generated
	 */
	EAttribute getMotif_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.modelrefactoring.guery.Motif#getVertexSelection <em>Vertex Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vertex Selection</em>'.
	 * @see org.modelrefactoring.guery.Motif#getVertexSelection()
	 * @see #getMotif()
	 * @generated
	 */
	EReference getMotif_VertexSelection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelrefactoring.guery.Motif#getGroupBy <em>Group By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Group By</em>'.
	 * @see org.modelrefactoring.guery.Motif#getGroupBy()
	 * @see #getMotif()
	 * @generated
	 */
	EReference getMotif_GroupBy();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelrefactoring.guery.Motif#getPrepare <em>Prepare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Prepare</em>'.
	 * @see org.modelrefactoring.guery.Motif#getPrepare()
	 * @see #getMotif()
	 * @generated
	 */
	EReference getMotif_Prepare();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelrefactoring.guery.Motif#getEdgeSelections <em>Edge Selections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edge Selections</em>'.
	 * @see org.modelrefactoring.guery.Motif#getEdgeSelections()
	 * @see #getMotif()
	 * @generated
	 */
	EReference getMotif_EdgeSelections();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.modelrefactoring.guery.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link org.modelrefactoring.guery.Role#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.modelrefactoring.guery.Role#getName()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Name();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.modelrefactoring.guery.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.modelrefactoring.guery.Constraint#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.modelrefactoring.guery.Constraint#getExpression()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Expression();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.VertexSelection <em>Vertex Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex Selection</em>'.
	 * @see org.modelrefactoring.guery.VertexSelection
	 * @generated
	 */
	EClass getVertexSelection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelrefactoring.guery.VertexSelection#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see org.modelrefactoring.guery.VertexSelection#getRoles()
	 * @see #getVertexSelection()
	 * @generated
	 */
	EReference getVertexSelection_Roles();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.ConnectedBy <em>Connected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connected By</em>'.
	 * @see org.modelrefactoring.guery.ConnectedBy
	 * @generated
	 */
	EClass getConnectedBy();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.modelrefactoring.guery.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the reference '{@link org.modelrefactoring.guery.Connection#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.modelrefactoring.guery.Connection#getTo()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_To();

	/**
	 * Returns the meta object for the reference '{@link org.modelrefactoring.guery.Connection#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.modelrefactoring.guery.Connection#getFrom()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_From();

	/**
	 * Returns the meta object for the attribute '{@link org.modelrefactoring.guery.Connection#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see org.modelrefactoring.guery.Connection#getMinLength()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link org.modelrefactoring.guery.Connection#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see org.modelrefactoring.guery.Connection#getMaxLength()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link org.modelrefactoring.guery.Connection#isComputeAll <em>Compute All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compute All</em>'.
	 * @see org.modelrefactoring.guery.Connection#isComputeAll()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ComputeAll();

	/**
	 * Returns the meta object for the attribute '{@link org.modelrefactoring.guery.Connection#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.modelrefactoring.guery.Connection#getPath()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Path();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.NotConnectedBy <em>Not Connected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Connected By</em>'.
	 * @see org.modelrefactoring.guery.NotConnectedBy
	 * @generated
	 */
	EClass getNotConnectedBy();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.Grouping <em>Grouping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grouping</em>'.
	 * @see org.modelrefactoring.guery.Grouping
	 * @generated
	 */
	EClass getGrouping();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.PreProcessor <em>Pre Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Processor</em>'.
	 * @see org.modelrefactoring.guery.PreProcessor
	 * @generated
	 */
	EClass getPreProcessor();

	/**
	 * Returns the meta object for the attribute '{@link org.modelrefactoring.guery.PreProcessor#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.modelrefactoring.guery.PreProcessor#getClass_()
	 * @see #getPreProcessor()
	 * @generated
	 */
	EAttribute getPreProcessor_Class();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.EdgeSelection <em>Edge Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Selection</em>'.
	 * @see org.modelrefactoring.guery.EdgeSelection
	 * @generated
	 */
	EClass getEdgeSelection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelrefactoring.guery.EdgeSelection#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see org.modelrefactoring.guery.EdgeSelection#getConnections()
	 * @see #getEdgeSelection()
	 * @generated
	 */
	EReference getEdgeSelection_Connections();

	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.guery.Constrainable <em>Constrainable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrainable</em>'.
	 * @see org.modelrefactoring.guery.Constrainable
	 * @generated
	 */
	EClass getConstrainable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelrefactoring.guery.Constrainable#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.modelrefactoring.guery.Constrainable#getConstraints()
	 * @see #getConstrainable()
	 * @generated
	 */
	EReference getConstrainable_Constraints();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To EObject Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To EObject Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="org.eclipse.emf.ecore.EObject"
	 * @generated
	 */
	EClass getStringToEObjectMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEObjectMap()
	 * @generated
	 */
	EAttribute getStringToEObjectMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEObjectMap()
	 * @generated
	 */
	EReference getStringToEObjectMap_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GueryFactory getGueryFactory();

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
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.MotifModelImpl <em>Motif Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.MotifModelImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getMotifModel()
		 * @generated
		 */
		EClass MOTIF_MODEL = eINSTANCE.getMotifModel();

		/**
		 * The meta object literal for the '<em><b>Motifs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTIF_MODEL__MOTIFS = eINSTANCE.getMotifModel_Motifs();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.MotifImpl <em>Motif</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.MotifImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getMotif()
		 * @generated
		 */
		EClass MOTIF = eINSTANCE.getMotif();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTIF__NAME = eINSTANCE.getMotif_Name();

		/**
		 * The meta object literal for the '<em><b>Vertex Selection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTIF__VERTEX_SELECTION = eINSTANCE.getMotif_VertexSelection();

		/**
		 * The meta object literal for the '<em><b>Group By</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTIF__GROUP_BY = eINSTANCE.getMotif_GroupBy();

		/**
		 * The meta object literal for the '<em><b>Prepare</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTIF__PREPARE = eINSTANCE.getMotif_Prepare();

		/**
		 * The meta object literal for the '<em><b>Edge Selections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTIF__EDGE_SELECTIONS = eINSTANCE.getMotif_EdgeSelections();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.RoleImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__NAME = eINSTANCE.getRole_Name();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.ConstraintImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__EXPRESSION = eINSTANCE.getConstraint_Expression();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.VertexSelectionImpl <em>Vertex Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.VertexSelectionImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getVertexSelection()
		 * @generated
		 */
		EClass VERTEX_SELECTION = eINSTANCE.getVertexSelection();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX_SELECTION__ROLES = eINSTANCE.getVertexSelection_Roles();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.ConnectedByImpl <em>Connected By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.ConnectedByImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getConnectedBy()
		 * @generated
		 */
		EClass CONNECTED_BY = eINSTANCE.getConnectedBy();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.ConnectionImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__TO = eINSTANCE.getConnection_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__FROM = eINSTANCE.getConnection_From();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__MIN_LENGTH = eINSTANCE.getConnection_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__MAX_LENGTH = eINSTANCE.getConnection_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Compute All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__COMPUTE_ALL = eINSTANCE.getConnection_ComputeAll();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__PATH = eINSTANCE.getConnection_Path();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.NotConnectedByImpl <em>Not Connected By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.NotConnectedByImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getNotConnectedBy()
		 * @generated
		 */
		EClass NOT_CONNECTED_BY = eINSTANCE.getNotConnectedBy();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.GroupingImpl <em>Grouping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.GroupingImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getGrouping()
		 * @generated
		 */
		EClass GROUPING = eINSTANCE.getGrouping();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.PreProcessorImpl <em>Pre Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.PreProcessorImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getPreProcessor()
		 * @generated
		 */
		EClass PRE_PROCESSOR = eINSTANCE.getPreProcessor();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRE_PROCESSOR__CLASS = eINSTANCE.getPreProcessor_Class();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.EdgeSelectionImpl <em>Edge Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.EdgeSelectionImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getEdgeSelection()
		 * @generated
		 */
		EClass EDGE_SELECTION = eINSTANCE.getEdgeSelection();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_SELECTION__CONNECTIONS = eINSTANCE.getEdgeSelection_Connections();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.ConstrainableImpl <em>Constrainable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.ConstrainableImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getConstrainable()
		 * @generated
		 */
		EClass CONSTRAINABLE = eINSTANCE.getConstrainable();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINABLE__CONSTRAINTS = eINSTANCE.getConstrainable_Constraints();

		/**
		 * The meta object literal for the '{@link org.modelrefactoring.guery.impl.StringToEObjectMapImpl <em>String To EObject Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.guery.impl.StringToEObjectMapImpl
		 * @see org.modelrefactoring.guery.impl.GueryPackageImpl#getStringToEObjectMap()
		 * @generated
		 */
		EClass STRING_TO_EOBJECT_MAP = eINSTANCE.getStringToEObjectMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_EOBJECT_MAP__KEY = eINSTANCE.getStringToEObjectMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_EOBJECT_MAP__VALUE = eINSTANCE.getStringToEObjectMap_Value();

	}

} //GueryPackage
