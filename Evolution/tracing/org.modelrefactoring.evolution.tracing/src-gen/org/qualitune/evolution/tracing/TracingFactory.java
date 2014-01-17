/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.tracing;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.evolution.tracing.TracingPackage
 * @generated
 */
public interface TracingFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	TracingFactory eINSTANCE = org.qualitune.evolution.tracing.impl.TracingFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
	TracingModel createTracingModel();

	/**
   * Returns a new object of class '<em>Trace Link</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Link</em>'.
   * @generated
   */
	TraceLink createTraceLink();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	TracingPackage getTracingPackage();

} //TracingFactory
