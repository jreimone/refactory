/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.guery;

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
 * @see org.qualitune.guery.GueryFactory
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
	String eNS_URI = "http://www.qualitune.org/guery";

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
	GueryPackage eINSTANCE = org.qualitune.guery.impl.GueryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.qualitune.guery.impl.MotifModelImpl <em>Motif Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.MotifModelImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getMotifModel()
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
	 * The meta object id for the '{@link org.qualitune.guery.impl.MotifImpl <em>Motif</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.MotifImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getMotif()
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
	 * The meta object id for the '{@link org.qualitune.guery.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.RoleImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getRole()
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
	 * The meta object id for the '{@link org.qualitune.guery.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.ConstraintImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__EXPRESSIONS = 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.qualitune.guery.impl.VertexSelectionImpl <em>Vertex Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.VertexSelectionImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getVertexSelection()
	 * @generated
	 */
	int VERTEX_SELECTION = 4;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_SELECTION__ROLES = 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_SELECTION__CONSTRAINT = 1;

	/**
	 * The number of structural features of the '<em>Vertex Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_SELECTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.qualitune.guery.impl.EdgeSelectionImpl <em>Edge Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.EdgeSelectionImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getEdgeSelection()
	 * @generated
	 */
	int EDGE_SELECTION = 10;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SELECTION__CONNECTIONS = 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SELECTION__CONSTRAINT = 1;

	/**
	 * The number of structural features of the '<em>Edge Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SELECTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.qualitune.guery.impl.ConnectedByImpl <em>Connected By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.ConnectedByImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getConnectedBy()
	 * @generated
	 */
	int CONNECTED_BY = 5;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTED_BY__CONNECTIONS = EDGE_SELECTION__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTED_BY__CONSTRAINT = EDGE_SELECTION__CONSTRAINT;

	/**
	 * The number of structural features of the '<em>Connected By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTED_BY_FEATURE_COUNT = EDGE_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.guery.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.ConnectionImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getConnection()
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
	 * The meta object id for the '{@link org.qualitune.guery.impl.NotConnectedByImpl <em>Not Connected By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.NotConnectedByImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getNotConnectedBy()
	 * @generated
	 */
	int NOT_CONNECTED_BY = 7;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONNECTED_BY__CONNECTIONS = EDGE_SELECTION__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONNECTED_BY__CONSTRAINT = EDGE_SELECTION__CONSTRAINT;

	/**
	 * The number of structural features of the '<em>Not Connected By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CONNECTED_BY_FEATURE_COUNT = EDGE_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.guery.impl.GroupingImpl <em>Grouping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.GroupingImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getGrouping()
	 * @generated
	 */
	int GROUPING = 8;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING__EXPRESSIONS = 0;

	/**
	 * The number of structural features of the '<em>Grouping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.qualitune.guery.impl.PreProcessorImpl <em>Pre Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.guery.impl.PreProcessorImpl
	 * @see org.qualitune.guery.impl.GueryPackageImpl#getPreProcessor()
	 * @generated
	 */
	int PRE_PROCESSOR = 9;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_PROCESSOR__CLASS_NAME = 0;

	/**
	 * The number of structural features of the '<em>Pre Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_PROCESSOR_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.MotifModel <em>Motif Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motif Model</em>'.
	 * @see org.qualitune.guery.MotifModel
	 * @generated
	 */
	EClass getMotifModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.guery.MotifModel#getMotifs <em>Motifs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Motifs</em>'.
	 * @see org.qualitune.guery.MotifModel#getMotifs()
	 * @see #getMotifModel()
	 * @generated
	 */
	EReference getMotifModel_Motifs();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.Motif <em>Motif</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motif</em>'.
	 * @see org.qualitune.guery.Motif
	 * @generated
	 */
	EClass getMotif();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.guery.Motif#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.qualitune.guery.Motif#getName()
	 * @see #getMotif()
	 * @generated
	 */
	EAttribute getMotif_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.guery.Motif#getVertexSelection <em>Vertex Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vertex Selection</em>'.
	 * @see org.qualitune.guery.Motif#getVertexSelection()
	 * @see #getMotif()
	 * @generated
	 */
	EReference getMotif_VertexSelection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.guery.Motif#getGroupBy <em>Group By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Group By</em>'.
	 * @see org.qualitune.guery.Motif#getGroupBy()
	 * @see #getMotif()
	 * @generated
	 */
	EReference getMotif_GroupBy();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.guery.Motif#getPrepare <em>Prepare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Prepare</em>'.
	 * @see org.qualitune.guery.Motif#getPrepare()
	 * @see #getMotif()
	 * @generated
	 */
	EReference getMotif_Prepare();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.guery.Motif#getEdgeSelections <em>Edge Selections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edge Selections</em>'.
	 * @see org.qualitune.guery.Motif#getEdgeSelections()
	 * @see #getMotif()
	 * @generated
	 */
	EReference getMotif_EdgeSelections();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.qualitune.guery.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.guery.Role#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.qualitune.guery.Role#getName()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Name();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.qualitune.guery.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute list '{@link org.qualitune.guery.Constraint#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Expressions</em>'.
	 * @see org.qualitune.guery.Constraint#getExpressions()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Expressions();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.VertexSelection <em>Vertex Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex Selection</em>'.
	 * @see org.qualitune.guery.VertexSelection
	 * @generated
	 */
	EClass getVertexSelection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.guery.VertexSelection#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see org.qualitune.guery.VertexSelection#getRoles()
	 * @see #getVertexSelection()
	 * @generated
	 */
	EReference getVertexSelection_Roles();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.guery.VertexSelection#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see org.qualitune.guery.VertexSelection#getConstraint()
	 * @see #getVertexSelection()
	 * @generated
	 */
	EReference getVertexSelection_Constraint();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.ConnectedBy <em>Connected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connected By</em>'.
	 * @see org.qualitune.guery.ConnectedBy
	 * @generated
	 */
	EClass getConnectedBy();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.qualitune.guery.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.guery.Connection#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.qualitune.guery.Connection#getTo()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_To();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.guery.Connection#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.qualitune.guery.Connection#getFrom()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_From();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.guery.Connection#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see org.qualitune.guery.Connection#getMinLength()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.guery.Connection#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see org.qualitune.guery.Connection#getMaxLength()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.guery.Connection#isComputeAll <em>Compute All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compute All</em>'.
	 * @see org.qualitune.guery.Connection#isComputeAll()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ComputeAll();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.guery.Connection#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.qualitune.guery.Connection#getPath()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Path();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.NotConnectedBy <em>Not Connected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Connected By</em>'.
	 * @see org.qualitune.guery.NotConnectedBy
	 * @generated
	 */
	EClass getNotConnectedBy();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.Grouping <em>Grouping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grouping</em>'.
	 * @see org.qualitune.guery.Grouping
	 * @generated
	 */
	EClass getGrouping();

	/**
	 * Returns the meta object for the attribute list '{@link org.qualitune.guery.Grouping#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Expressions</em>'.
	 * @see org.qualitune.guery.Grouping#getExpressions()
	 * @see #getGrouping()
	 * @generated
	 */
	EAttribute getGrouping_Expressions();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.PreProcessor <em>Pre Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Processor</em>'.
	 * @see org.qualitune.guery.PreProcessor
	 * @generated
	 */
	EClass getPreProcessor();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.guery.PreProcessor#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.qualitune.guery.PreProcessor#getClassName()
	 * @see #getPreProcessor()
	 * @generated
	 */
	EAttribute getPreProcessor_ClassName();

	/**
	 * Returns the meta object for class '{@link org.qualitune.guery.EdgeSelection <em>Edge Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Selection</em>'.
	 * @see org.qualitune.guery.EdgeSelection
	 * @generated
	 */
	EClass getEdgeSelection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.guery.EdgeSelection#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see org.qualitune.guery.EdgeSelection#getConnections()
	 * @see #getEdgeSelection()
	 * @generated
	 */
	EReference getEdgeSelection_Connections();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.guery.EdgeSelection#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see org.qualitune.guery.EdgeSelection#getConstraint()
	 * @see #getEdgeSelection()
	 * @generated
	 */
	EReference getEdgeSelection_Constraint();

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
		 * The meta object literal for the '{@link org.qualitune.guery.impl.MotifModelImpl <em>Motif Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.MotifModelImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getMotifModel()
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
		 * The meta object literal for the '{@link org.qualitune.guery.impl.MotifImpl <em>Motif</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.MotifImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getMotif()
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
		 * The meta object literal for the '{@link org.qualitune.guery.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.RoleImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getRole()
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
		 * The meta object literal for the '{@link org.qualitune.guery.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.ConstraintImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__EXPRESSIONS = eINSTANCE.getConstraint_Expressions();

		/**
		 * The meta object literal for the '{@link org.qualitune.guery.impl.VertexSelectionImpl <em>Vertex Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.VertexSelectionImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getVertexSelection()
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
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX_SELECTION__CONSTRAINT = eINSTANCE.getVertexSelection_Constraint();

		/**
		 * The meta object literal for the '{@link org.qualitune.guery.impl.ConnectedByImpl <em>Connected By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.ConnectedByImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getConnectedBy()
		 * @generated
		 */
		EClass CONNECTED_BY = eINSTANCE.getConnectedBy();

		/**
		 * The meta object literal for the '{@link org.qualitune.guery.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.ConnectionImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getConnection()
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
		 * The meta object literal for the '{@link org.qualitune.guery.impl.NotConnectedByImpl <em>Not Connected By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.NotConnectedByImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getNotConnectedBy()
		 * @generated
		 */
		EClass NOT_CONNECTED_BY = eINSTANCE.getNotConnectedBy();

		/**
		 * The meta object literal for the '{@link org.qualitune.guery.impl.GroupingImpl <em>Grouping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.GroupingImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getGrouping()
		 * @generated
		 */
		EClass GROUPING = eINSTANCE.getGrouping();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUPING__EXPRESSIONS = eINSTANCE.getGrouping_Expressions();

		/**
		 * The meta object literal for the '{@link org.qualitune.guery.impl.PreProcessorImpl <em>Pre Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.PreProcessorImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getPreProcessor()
		 * @generated
		 */
		EClass PRE_PROCESSOR = eINSTANCE.getPreProcessor();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRE_PROCESSOR__CLASS_NAME = eINSTANCE.getPreProcessor_ClassName();

		/**
		 * The meta object literal for the '{@link org.qualitune.guery.impl.EdgeSelectionImpl <em>Edge Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.guery.impl.EdgeSelectionImpl
		 * @see org.qualitune.guery.impl.GueryPackageImpl#getEdgeSelection()
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
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_SELECTION__CONSTRAINT = eINSTANCE.getEdgeSelection_Constraint();

	}

} //GueryPackage
