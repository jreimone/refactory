/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.IndexVariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.IndexVariableImpl#getIndexCommand <em>Index Command</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexVariableImpl extends EObjectImpl implements IndexVariable
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IndexVariableImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RefactoringSpecificationPackage.Literals.INDEX_VARIABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.INDEX_VARIABLE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndexAssignmentCommand getIndexCommand()
  {
    if (eContainerFeatureID() != RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND) return null;
    return (IndexAssignmentCommand)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndexCommand(IndexAssignmentCommand newIndexCommand, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newIndexCommand, RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndexCommand(IndexAssignmentCommand newIndexCommand)
  {
    if (newIndexCommand != eInternalContainer() || (eContainerFeatureID() != RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND && newIndexCommand != null))
    {
      if (EcoreUtil.isAncestor(this, newIndexCommand))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newIndexCommand != null)
        msgs = ((InternalEObject)newIndexCommand).eInverseAdd(this, RefactoringSpecificationPackage.INDEX_ASSIGNMENT_COMMAND__VARIABLE, IndexAssignmentCommand.class, msgs);
      msgs = basicSetIndexCommand(newIndexCommand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND, newIndexCommand, newIndexCommand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetIndexCommand((IndexAssignmentCommand)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND:
        return basicSetIndexCommand(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND:
        return eInternalContainer().eInverseRemove(this, RefactoringSpecificationPackage.INDEX_ASSIGNMENT_COMMAND__VARIABLE, IndexAssignmentCommand.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RefactoringSpecificationPackage.INDEX_VARIABLE__NAME:
        return getName();
      case RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND:
        return getIndexCommand();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RefactoringSpecificationPackage.INDEX_VARIABLE__NAME:
        setName((String)newValue);
        return;
      case RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND:
        setIndexCommand((IndexAssignmentCommand)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RefactoringSpecificationPackage.INDEX_VARIABLE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND:
        setIndexCommand((IndexAssignmentCommand)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RefactoringSpecificationPackage.INDEX_VARIABLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND:
        return getIndexCommand() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //IndexVariableImpl
