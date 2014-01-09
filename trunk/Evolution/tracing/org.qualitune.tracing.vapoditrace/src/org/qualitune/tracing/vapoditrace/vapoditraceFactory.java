/**
 */
package org.qualitune.tracing.vapoditrace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage
 * @generated
 */
public interface vapoditraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	vapoditraceFactory eINSTANCE = org.qualitune.tracing.vapoditrace.impl.vapoditraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Trace Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Link</em>'.
	 * @generated
	 */
	TraceLink createTraceLink();

	/**
	 * Returns a new object of class '<em>Trace Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Collection</em>'.
	 * @generated
	 */
	TraceCollection createTraceCollection();

	/**
	 * Returns a new object of class '<em>Dynamic Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Entity</em>'.
	 * @generated
	 */
	DynamicEntity createDynamicEntity();

	/**
	 * Returns a new object of class '<em>Static Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Entity</em>'.
	 * @generated
	 */
	StaticEntity createStaticEntity();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	vapoditracePackage getvapoditracePackage();

} //vapoditraceFactory
