/**
 */
package org.qualitune.tracing.vapoditrace;

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
 * @see org.qualitune.tracing.vapoditrace.vapoditraceFactory
 * @model kind="package"
 * @generated
 */
public interface vapoditracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vapoditrace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://smt.inf.tu-dresden.de/fab/vapoditrace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "vapoditrace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	vapoditracePackage eINSTANCE = org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.vapoditrace.impl.TraceLinkImpl <em>Trace Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.vapoditrace.impl.TraceLinkImpl
	 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getTraceLink()
	 * @generated
	 */
	int TRACE_LINK = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__DESTINATION = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__SOURCE = 1;

	/**
	 * The number of structural features of the '<em>Trace Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.vapoditrace.impl.TraceCollectionImpl <em>Trace Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.vapoditrace.impl.TraceCollectionImpl
	 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getTraceCollection()
	 * @generated
	 */
	int TRACE_COLLECTION = 1;

	/**
	 * The feature id for the '<em><b>Trace Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COLLECTION__TRACE_LINKS = 0;

	/**
	 * The feature id for the '<em><b>Shadow Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COLLECTION__SHADOW_OBJECTS = 1;

	/**
	 * The feature id for the '<em><b>Trash</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COLLECTION__TRASH = 2;

	/**
	 * The number of structural features of the '<em>Trace Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COLLECTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.vapoditrace.impl.EEntityImpl <em>EEntity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.vapoditrace.impl.EEntityImpl
	 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getEEntity()
	 * @generated
	 */
	int EENTITY = 2;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY__ATTRIBUTE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Concern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY__CONCERN = 1;

	/**
	 * The number of structural features of the '<em>EEntity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.vapoditrace.impl.TraceEntityImpl <em>Trace Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.vapoditrace.impl.TraceEntityImpl
	 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getTraceEntity()
	 * @generated
	 */
	int TRACE_ENTITY = 3;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTITY__ATTRIBUTE_NAME = EENTITY__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Concern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTITY__CONCERN = EENTITY__CONCERN;

	/**
	 * The feature id for the '<em><b>Semantics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTITY__SEMANTICS = EENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Universe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTITY__UNIVERSE = EENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Trace Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTITY_FEATURE_COUNT = EENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.vapoditrace.impl.DynamicEntityImpl <em>Dynamic Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.vapoditrace.impl.DynamicEntityImpl
	 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getDynamicEntity()
	 * @generated
	 */
	int DYNAMIC_ENTITY = 4;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ENTITY__ATTRIBUTE_NAME = TRACE_ENTITY__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Concern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ENTITY__CONCERN = TRACE_ENTITY__CONCERN;

	/**
	 * The feature id for the '<em><b>Semantics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ENTITY__SEMANTICS = TRACE_ENTITY__SEMANTICS;

	/**
	 * The feature id for the '<em><b>Universe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ENTITY__UNIVERSE = TRACE_ENTITY__UNIVERSE;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ENTITY__ATTRIBUTE = TRACE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Esf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ENTITY__ESF = TRACE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ENTITY__OBJECT = TRACE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dynamic Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ENTITY_FEATURE_COUNT = TRACE_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.vapoditrace.impl.StaticEntityImpl <em>Static Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.vapoditrace.impl.StaticEntityImpl
	 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getStaticEntity()
	 * @generated
	 */
	int STATIC_ENTITY = 5;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_ENTITY__ATTRIBUTE_NAME = TRACE_ENTITY__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Concern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_ENTITY__CONCERN = TRACE_ENTITY__CONCERN;

	/**
	 * The feature id for the '<em><b>Semantics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_ENTITY__SEMANTICS = TRACE_ENTITY__SEMANTICS;

	/**
	 * The feature id for the '<em><b>Universe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_ENTITY__UNIVERSE = TRACE_ENTITY__UNIVERSE;

	/**
	 * The feature id for the '<em><b>Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_ENTITY__OBJECT_NAME = TRACE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_ENTITY__TYPE = TRACE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Static Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_ENTITY_FEATURE_COUNT = TRACE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.vapoditrace.TraceType <em>Trace Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.vapoditrace.TraceType
	 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getTraceType()
	 * @generated
	 */
	int TRACE_TYPE = 6;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.vapoditrace.ConcernType <em>Concern Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.vapoditrace.ConcernType
	 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getConcernType()
	 * @generated
	 */
	int CONCERN_TYPE = 7;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.vapoditrace.UniverseType <em>Universe Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.vapoditrace.UniverseType
	 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getUniverseType()
	 * @generated
	 */
	int UNIVERSE_TYPE = 8;


	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.vapoditrace.TraceLink <em>Trace Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Link</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceLink
	 * @generated
	 */
	EClass getTraceLink();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.tracing.vapoditrace.TraceLink#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceLink#getDestination()
	 * @see #getTraceLink()
	 * @generated
	 */
	EReference getTraceLink_Destination();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.vapoditrace.TraceLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceLink#getSource()
	 * @see #getTraceLink()
	 * @generated
	 */
	EReference getTraceLink_Source();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.vapoditrace.TraceCollection <em>Trace Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Collection</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceCollection
	 * @generated
	 */
	EClass getTraceCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.vapoditrace.TraceCollection#getTraceLinks <em>Trace Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trace Links</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceCollection#getTraceLinks()
	 * @see #getTraceCollection()
	 * @generated
	 */
	EReference getTraceCollection_TraceLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.vapoditrace.TraceCollection#getShadowObjects <em>Shadow Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Shadow Objects</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceCollection#getShadowObjects()
	 * @see #getTraceCollection()
	 * @generated
	 */
	EReference getTraceCollection_ShadowObjects();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.vapoditrace.TraceCollection#getTrash <em>Trash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trash</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceCollection#getTrash()
	 * @see #getTraceCollection()
	 * @generated
	 */
	EReference getTraceCollection_Trash();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.vapoditrace.EEntity <em>EEntity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEntity</em>'.
	 * @see org.qualitune.tracing.vapoditrace.EEntity
	 * @generated
	 */
	EClass getEEntity();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.vapoditrace.EEntity#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see org.qualitune.tracing.vapoditrace.EEntity#getAttributeName()
	 * @see #getEEntity()
	 * @generated
	 */
	EAttribute getEEntity_AttributeName();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.vapoditrace.EEntity#getConcern <em>Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Concern</em>'.
	 * @see org.qualitune.tracing.vapoditrace.EEntity#getConcern()
	 * @see #getEEntity()
	 * @generated
	 */
	EAttribute getEEntity_Concern();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.vapoditrace.TraceEntity <em>Trace Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Entity</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceEntity
	 * @generated
	 */
	EClass getTraceEntity();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.vapoditrace.TraceEntity#getSemantics <em>Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Semantics</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceEntity#getSemantics()
	 * @see #getTraceEntity()
	 * @generated
	 */
	EAttribute getTraceEntity_Semantics();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.vapoditrace.TraceEntity#getUniverse <em>Universe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Universe</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceEntity#getUniverse()
	 * @see #getTraceEntity()
	 * @generated
	 */
	EAttribute getTraceEntity_Universe();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.vapoditrace.DynamicEntity <em>Dynamic Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Entity</em>'.
	 * @see org.qualitune.tracing.vapoditrace.DynamicEntity
	 * @generated
	 */
	EClass getDynamicEntity();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.vapoditrace.DynamicEntity#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see org.qualitune.tracing.vapoditrace.DynamicEntity#getAttribute()
	 * @see #getDynamicEntity()
	 * @generated
	 */
	EReference getDynamicEntity_Attribute();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.vapoditrace.DynamicEntity#getEsf <em>Esf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Esf</em>'.
	 * @see org.qualitune.tracing.vapoditrace.DynamicEntity#getEsf()
	 * @see #getDynamicEntity()
	 * @generated
	 */
	EReference getDynamicEntity_Esf();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.vapoditrace.DynamicEntity#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.qualitune.tracing.vapoditrace.DynamicEntity#getObject()
	 * @see #getDynamicEntity()
	 * @generated
	 */
	EReference getDynamicEntity_Object();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.vapoditrace.StaticEntity <em>Static Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Entity</em>'.
	 * @see org.qualitune.tracing.vapoditrace.StaticEntity
	 * @generated
	 */
	EClass getStaticEntity();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.vapoditrace.StaticEntity#getObjectName <em>Object Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Name</em>'.
	 * @see org.qualitune.tracing.vapoditrace.StaticEntity#getObjectName()
	 * @see #getStaticEntity()
	 * @generated
	 */
	EAttribute getStaticEntity_ObjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.vapoditrace.StaticEntity#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.qualitune.tracing.vapoditrace.StaticEntity#getType()
	 * @see #getStaticEntity()
	 * @generated
	 */
	EAttribute getStaticEntity_Type();

	/**
	 * Returns the meta object for enum '{@link org.qualitune.tracing.vapoditrace.TraceType <em>Trace Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trace Type</em>'.
	 * @see org.qualitune.tracing.vapoditrace.TraceType
	 * @generated
	 */
	EEnum getTraceType();

	/**
	 * Returns the meta object for enum '{@link org.qualitune.tracing.vapoditrace.ConcernType <em>Concern Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Concern Type</em>'.
	 * @see org.qualitune.tracing.vapoditrace.ConcernType
	 * @generated
	 */
	EEnum getConcernType();

	/**
	 * Returns the meta object for enum '{@link org.qualitune.tracing.vapoditrace.UniverseType <em>Universe Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Universe Type</em>'.
	 * @see org.qualitune.tracing.vapoditrace.UniverseType
	 * @generated
	 */
	EEnum getUniverseType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	vapoditraceFactory getvapoditraceFactory();

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
		 * The meta object literal for the '{@link org.qualitune.tracing.vapoditrace.impl.TraceLinkImpl <em>Trace Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.vapoditrace.impl.TraceLinkImpl
		 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getTraceLink()
		 * @generated
		 */
		EClass TRACE_LINK = eINSTANCE.getTraceLink();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK__DESTINATION = eINSTANCE.getTraceLink_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK__SOURCE = eINSTANCE.getTraceLink_Source();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.vapoditrace.impl.TraceCollectionImpl <em>Trace Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.vapoditrace.impl.TraceCollectionImpl
		 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getTraceCollection()
		 * @generated
		 */
		EClass TRACE_COLLECTION = eINSTANCE.getTraceCollection();

		/**
		 * The meta object literal for the '<em><b>Trace Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_COLLECTION__TRACE_LINKS = eINSTANCE.getTraceCollection_TraceLinks();

		/**
		 * The meta object literal for the '<em><b>Shadow Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_COLLECTION__SHADOW_OBJECTS = eINSTANCE.getTraceCollection_ShadowObjects();

		/**
		 * The meta object literal for the '<em><b>Trash</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_COLLECTION__TRASH = eINSTANCE.getTraceCollection_Trash();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.vapoditrace.impl.EEntityImpl <em>EEntity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.vapoditrace.impl.EEntityImpl
		 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getEEntity()
		 * @generated
		 */
		EClass EENTITY = eINSTANCE.getEEntity();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENTITY__ATTRIBUTE_NAME = eINSTANCE.getEEntity_AttributeName();

		/**
		 * The meta object literal for the '<em><b>Concern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENTITY__CONCERN = eINSTANCE.getEEntity_Concern();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.vapoditrace.impl.TraceEntityImpl <em>Trace Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.vapoditrace.impl.TraceEntityImpl
		 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getTraceEntity()
		 * @generated
		 */
		EClass TRACE_ENTITY = eINSTANCE.getTraceEntity();

		/**
		 * The meta object literal for the '<em><b>Semantics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ENTITY__SEMANTICS = eINSTANCE.getTraceEntity_Semantics();

		/**
		 * The meta object literal for the '<em><b>Universe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ENTITY__UNIVERSE = eINSTANCE.getTraceEntity_Universe();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.vapoditrace.impl.DynamicEntityImpl <em>Dynamic Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.vapoditrace.impl.DynamicEntityImpl
		 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getDynamicEntity()
		 * @generated
		 */
		EClass DYNAMIC_ENTITY = eINSTANCE.getDynamicEntity();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_ENTITY__ATTRIBUTE = eINSTANCE.getDynamicEntity_Attribute();

		/**
		 * The meta object literal for the '<em><b>Esf</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_ENTITY__ESF = eINSTANCE.getDynamicEntity_Esf();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_ENTITY__OBJECT = eINSTANCE.getDynamicEntity_Object();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.vapoditrace.impl.StaticEntityImpl <em>Static Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.vapoditrace.impl.StaticEntityImpl
		 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getStaticEntity()
		 * @generated
		 */
		EClass STATIC_ENTITY = eINSTANCE.getStaticEntity();

		/**
		 * The meta object literal for the '<em><b>Object Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_ENTITY__OBJECT_NAME = eINSTANCE.getStaticEntity_ObjectName();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_ENTITY__TYPE = eINSTANCE.getStaticEntity_Type();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.vapoditrace.TraceType <em>Trace Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.vapoditrace.TraceType
		 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getTraceType()
		 * @generated
		 */
		EEnum TRACE_TYPE = eINSTANCE.getTraceType();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.vapoditrace.ConcernType <em>Concern Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.vapoditrace.ConcernType
		 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getConcernType()
		 * @generated
		 */
		EEnum CONCERN_TYPE = eINSTANCE.getConcernType();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.vapoditrace.UniverseType <em>Universe Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.vapoditrace.UniverseType
		 * @see org.qualitune.tracing.vapoditrace.impl.vapoditracePackageImpl#getUniverseType()
		 * @generated
		 */
		EEnum UNIVERSE_TYPE = eINSTANCE.getUniverseType();

	}

} //vapoditracePackage
