/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.architecture.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.qualitune.evolution.megamodel.architecture.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage
 * @generated
 */
public class ArchitectureSwitch<T> extends Switch<T> {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static ArchitecturePackage modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ArchitectureSwitch() {
    if (modelPackage == null)
    {
      modelPackage = ArchitecturePackage.eINSTANCE;
    }
  }

	/**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

	/**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID)
    {
      case ArchitecturePackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ArchitecturePackage.REFERENCE_MODEL:
      {
        ReferenceModel referenceModel = (ReferenceModel)theEObject;
        T result = caseReferenceModel(referenceModel);
        if (result == null) result = caseModel(referenceModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ArchitecturePackage.TERMINAL_MODEL:
      {
        TerminalModel terminalModel = (TerminalModel)theEObject;
        T result = caseTerminalModel(terminalModel);
        if (result == null) result = caseModel(terminalModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ArchitecturePackage.TRANSFORMATION_MODEL:
      {
        TransformationModel transformationModel = (TransformationModel)theEObject;
        T result = caseTransformationModel(transformationModel);
        if (result == null) result = caseTerminalModel(transformationModel);
        if (result == null) result = caseModel(transformationModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ArchitecturePackage.MEGA_MODEL:
      {
        MegaModel megaModel = (MegaModel)theEObject;
        T result = caseMegaModel(megaModel);
        if (result == null) result = caseTerminalModel(megaModel);
        if (result == null) result = caseModel(megaModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ArchitecturePackage.META_META_MODEL:
      {
        MetaMetaModel metaMetaModel = (MetaMetaModel)theEObject;
        T result = caseMetaMetaModel(metaMetaModel);
        if (result == null) result = caseReferenceModel(metaMetaModel);
        if (result == null) result = caseModel(metaMetaModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ArchitecturePackage.META_MODEL:
      {
        MetaModel metaModel = (MetaModel)theEObject;
        T result = caseMetaModel(metaModel);
        if (result == null) result = caseReferenceModel(metaModel);
        if (result == null) result = caseModel(metaModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ArchitecturePackage.INSTANCE_MODEL:
      {
        InstanceModel instanceModel = (InstanceModel)theEObject;
        T result = caseInstanceModel(instanceModel);
        if (result == null) result = caseTerminalModel(instanceModel);
        if (result == null) result = caseModel(instanceModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseModel(Model object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Reference Model</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseReferenceModel(ReferenceModel object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Terminal Model</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Terminal Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTerminalModel(TerminalModel object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Transformation Model</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTransformationModel(TransformationModel object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Mega Model</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mega Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMegaModel(MegaModel object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Meta Meta Model</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Meta Meta Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMetaMetaModel(MetaMetaModel object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Meta Model</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Meta Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMetaModel(MetaModel object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Instance Model</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseInstanceModel(InstanceModel object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
	@Override
	public T defaultCase(EObject object) {
    return null;
  }

} //ArchitectureSwitch
