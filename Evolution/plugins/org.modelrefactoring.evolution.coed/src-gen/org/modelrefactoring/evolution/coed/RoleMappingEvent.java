/**
 */
package org.modelrefactoring.evolution.coed;

import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Mapping Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.RoleMappingEvent#getConcreteRefactoring <em>Concrete Refactoring</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.RoleMappingEvent#getMetamodelImport <em>Metamodel Import</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.evolution.coed.CoedPackage#getRoleMappingEvent()
 * @model
 * @generated
 */
public interface RoleMappingEvent extends Event {
	/**
   * Returns the value of the '<em><b>Concrete Refactoring</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Refactoring</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Concrete Refactoring</em>' reference.
   * @see #setConcreteRefactoring(RoleMapping)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getRoleMappingEvent_ConcreteRefactoring()
   * @model required="true"
   * @generated
   */
	RoleMapping getConcreteRefactoring();

	/**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.RoleMappingEvent#getConcreteRefactoring <em>Concrete Refactoring</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Concrete Refactoring</em>' reference.
   * @see #getConcreteRefactoring()
   * @generated
   */
	void setConcreteRefactoring(RoleMapping value);

  /**
   * Returns the value of the '<em><b>Metamodel Import</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel Import</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel Import</em>' reference.
   * @see #setMetamodelImport(MetamodelImport)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getRoleMappingEvent_MetamodelImport()
   * @model required="true"
   * @generated
   */
  MetamodelImport getMetamodelImport();

  /**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.RoleMappingEvent#getMetamodelImport <em>Metamodel Import</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel Import</em>' reference.
   * @see #getMetamodelImport()
   * @generated
   */
  void setMetamodelImport(MetamodelImport value);

} // RoleMappingEvent
