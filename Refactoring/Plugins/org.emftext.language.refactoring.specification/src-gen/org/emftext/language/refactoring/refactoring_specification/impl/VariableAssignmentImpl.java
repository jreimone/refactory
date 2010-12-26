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

import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;
import org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableAssignmentImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableAssignmentImpl#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableAssignmentImpl extends InstructionImpl implements VariableAssignment
{
  /**
   * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected Variable variable;

  /**
   * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignment()
   * @generated
   * @ordered
   */
  protected ObjectAssignmentCommand assignment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableAssignmentImpl()
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
    return RefactoringSpecificationPackage.Literals.VARIABLE_ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable getVariable()
  {
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariable(Variable newVariable, NotificationChain msgs)
  {
    Variable oldVariable = variable;
    variable = newVariable;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE, oldVariable, newVariable);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariable(Variable newVariable)
  {
    if (newVariable != variable)
    {
      NotificationChain msgs = null;
      if (variable != null)
        msgs = ((InternalEObject)variable).eInverseRemove(this, RefactoringSpecificationPackage.VARIABLE__CONTAINER_COMMAND, Variable.class, msgs);
      if (newVariable != null)
        msgs = ((InternalEObject)newVariable).eInverseAdd(this, RefactoringSpecificationPackage.VARIABLE__CONTAINER_COMMAND, Variable.class, msgs);
      msgs = basicSetVariable(newVariable, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE, newVariable, newVariable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectAssignmentCommand getAssignment()
  {
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssignment(ObjectAssignmentCommand newAssignment, NotificationChain msgs)
  {
    ObjectAssignmentCommand oldAssignment = assignment;
    assignment = newAssignment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT, oldAssignment, newAssignment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignment(ObjectAssignmentCommand newAssignment)
  {
    if (newAssignment != assignment)
    {
      NotificationChain msgs = null;
      if (assignment != null)
        msgs = ((InternalEObject)assignment).eInverseRemove(this, RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION, ObjectAssignmentCommand.class, msgs);
      if (newAssignment != null)
        msgs = ((InternalEObject)newAssignment).eInverseAdd(this, RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION, ObjectAssignmentCommand.class, msgs);
      msgs = basicSetAssignment(newAssignment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT, newAssignment, newAssignment));
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
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE:
        if (variable != null)
          msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE, null, msgs);
        return basicSetVariable((Variable)otherEnd, msgs);
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT:
        if (assignment != null)
          msgs = ((InternalEObject)assignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT, null, msgs);
        return basicSetAssignment((ObjectAssignmentCommand)otherEnd, msgs);
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
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE:
        return basicSetVariable(null, msgs);
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT:
        return basicSetAssignment(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE:
        return getVariable();
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT:
        return getAssignment();
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
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE:
        setVariable((Variable)newValue);
        return;
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT:
        setAssignment((ObjectAssignmentCommand)newValue);
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
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE:
        setVariable((Variable)null);
        return;
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT:
        setAssignment((ObjectAssignmentCommand)null);
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
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE:
        return variable != null;
      case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT:
        return assignment != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == VariableDeclarationCommand.class)
    {
      switch (derivedFeatureID)
      {
        case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE: return RefactoringSpecificationPackage.VARIABLE_DECLARATION_COMMAND__VARIABLE;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == VariableDeclarationCommand.class)
    {
      switch (baseFeatureID)
      {
        case RefactoringSpecificationPackage.VARIABLE_DECLARATION_COMMAND__VARIABLE: return RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //VariableAssignmentImpl
