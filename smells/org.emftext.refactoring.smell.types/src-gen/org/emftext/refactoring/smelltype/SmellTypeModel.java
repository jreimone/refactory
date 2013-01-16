/**
 */
package org.emftext.refactoring.smelltype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Smell Type Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smelltype.SmellTypeModel#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smelltype.SmelltypePackage#getSmellTypeModel()
 * @model
 * @generated
 */
public interface SmellTypeModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smelltype.SmellType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.emftext.refactoring.smelltype.SmelltypePackage#getSmellTypeModel_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<SmellType> getTypes();

} // SmellTypeModel
