/**
 */
package org.qualitune.tracing.vapoditrace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.qualitune.tracing.vapoditrace.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class vapoditraceFactoryImpl extends EFactoryImpl implements vapoditraceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static vapoditraceFactory init() {
		try {
			vapoditraceFactory thevapoditraceFactory = (vapoditraceFactory)EPackage.Registry.INSTANCE.getEFactory("http://smt.inf.tu-dresden.de/fab/vapoditrace"); 
			if (thevapoditraceFactory != null) {
				return thevapoditraceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new vapoditraceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public vapoditraceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case vapoditracePackage.TRACE_LINK: return createTraceLink();
			case vapoditracePackage.TRACE_COLLECTION: return createTraceCollection();
			case vapoditracePackage.DYNAMIC_ENTITY: return createDynamicEntity();
			case vapoditracePackage.STATIC_ENTITY: return createStaticEntity();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case vapoditracePackage.TRACE_TYPE:
				return createTraceTypeFromString(eDataType, initialValue);
			case vapoditracePackage.CONCERN_TYPE:
				return createConcernTypeFromString(eDataType, initialValue);
			case vapoditracePackage.UNIVERSE_TYPE:
				return createUniverseTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case vapoditracePackage.TRACE_TYPE:
				return convertTraceTypeToString(eDataType, instanceValue);
			case vapoditracePackage.CONCERN_TYPE:
				return convertConcernTypeToString(eDataType, instanceValue);
			case vapoditracePackage.UNIVERSE_TYPE:
				return convertUniverseTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLink createTraceLink() {
		TraceLinkImpl traceLink = new TraceLinkImpl();
		return traceLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceCollection createTraceCollection() {
		TraceCollectionImpl traceCollection = new TraceCollectionImpl();
		return traceCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicEntity createDynamicEntity() {
		DynamicEntityImpl dynamicEntity = new DynamicEntityImpl();
		return dynamicEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticEntity createStaticEntity() {
		StaticEntityImpl staticEntity = new StaticEntityImpl();
		return staticEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceType createTraceTypeFromString(EDataType eDataType, String initialValue) {
		TraceType result = TraceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTraceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcernType createConcernTypeFromString(EDataType eDataType, String initialValue) {
		ConcernType result = ConcernType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConcernTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniverseType createUniverseTypeFromString(EDataType eDataType, String initialValue) {
		UniverseType result = UniverseType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUniverseTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public vapoditracePackage getvapoditracePackage() {
		return (vapoditracePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static vapoditracePackage getPackage() {
		return vapoditracePackage.eINSTANCE;
	}

} //vapoditraceFactoryImpl
