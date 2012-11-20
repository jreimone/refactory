/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.tracing;

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
 * @see org.qualitune.evolution.tracing.TracingFactory
 * @model kind="package"
 * @generated
 */
public interface TracingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tracing";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.qualitune.org/tracing";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tracing";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracingPackage eINSTANCE = org.qualitune.evolution.tracing.impl.TracingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.tracing.impl.TracingModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.tracing.impl.TracingModelImpl
	 * @see org.qualitune.evolution.tracing.impl.TracingPackageImpl#getTracingModel()
	 * @generated
	 */
	int TRACING_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Trace Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACING_MODEL__TRACE_LINKS = 0;

	/**
	 * The feature id for the '<em><b>Source UR Is</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACING_MODEL__SOURCE_UR_IS = 1;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACING_MODEL__TARGET_URI = 2;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACING_MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.tracing.impl.TraceLinkImpl <em>Trace Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.tracing.impl.TraceLinkImpl
	 * @see org.qualitune.evolution.tracing.impl.TracingPackageImpl#getTraceLink()
	 * @generated
	 */
	int TRACE_LINK = 1;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__SOURCES = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Trace Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.tracing.TracingModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.qualitune.evolution.tracing.TracingModel
	 * @generated
	 */
	EClass getTracingModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.evolution.tracing.TracingModel#getTraceLinks <em>Trace Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trace Links</em>'.
	 * @see org.qualitune.evolution.tracing.TracingModel#getTraceLinks()
	 * @see #getTracingModel()
	 * @generated
	 */
	EReference getTracingModel_TraceLinks();

	/**
	 * Returns the meta object for the attribute list '{@link org.qualitune.evolution.tracing.TracingModel#getSourceURIs <em>Source UR Is</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Source UR Is</em>'.
	 * @see org.qualitune.evolution.tracing.TracingModel#getSourceURIs()
	 * @see #getTracingModel()
	 * @generated
	 */
	EAttribute getTracingModel_SourceURIs();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.evolution.tracing.TracingModel#getTargetURI <em>Target URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target URI</em>'.
	 * @see org.qualitune.evolution.tracing.TracingModel#getTargetURI()
	 * @see #getTracingModel()
	 * @generated
	 */
	EAttribute getTracingModel_TargetURI();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.tracing.TraceLink <em>Trace Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Link</em>'.
	 * @see org.qualitune.evolution.tracing.TraceLink
	 * @generated
	 */
	EClass getTraceLink();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.evolution.tracing.TraceLink#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sources</em>'.
	 * @see org.qualitune.evolution.tracing.TraceLink#getSources()
	 * @see #getTraceLink()
	 * @generated
	 */
	EReference getTraceLink_Sources();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.tracing.TraceLink#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.qualitune.evolution.tracing.TraceLink#getDestination()
	 * @see #getTraceLink()
	 * @generated
	 */
	EReference getTraceLink_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.tracing.TraceLink#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.qualitune.evolution.tracing.TraceLink#getType()
	 * @see #getTraceLink()
	 * @generated
	 */
	EReference getTraceLink_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TracingFactory getTracingFactory();

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
		 * The meta object literal for the '{@link org.qualitune.evolution.tracing.impl.TracingModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.tracing.impl.TracingModelImpl
		 * @see org.qualitune.evolution.tracing.impl.TracingPackageImpl#getTracingModel()
		 * @generated
		 */
		EClass TRACING_MODEL = eINSTANCE.getTracingModel();

		/**
		 * The meta object literal for the '<em><b>Trace Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACING_MODEL__TRACE_LINKS = eINSTANCE.getTracingModel_TraceLinks();

		/**
		 * The meta object literal for the '<em><b>Source UR Is</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACING_MODEL__SOURCE_UR_IS = eINSTANCE.getTracingModel_SourceURIs();

		/**
		 * The meta object literal for the '<em><b>Target URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACING_MODEL__TARGET_URI = eINSTANCE.getTracingModel_TargetURI();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.tracing.impl.TraceLinkImpl <em>Trace Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.tracing.impl.TraceLinkImpl
		 * @see org.qualitune.evolution.tracing.impl.TracingPackageImpl#getTraceLink()
		 * @generated
		 */
		EClass TRACE_LINK = eINSTANCE.getTraceLink();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK__SOURCES = eINSTANCE.getTraceLink_Sources();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK__DESTINATION = eINSTANCE.getTraceLink_Destination();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK__TYPE = eINSTANCE.getTraceLink_Type();

	}

} //TracingPackage
