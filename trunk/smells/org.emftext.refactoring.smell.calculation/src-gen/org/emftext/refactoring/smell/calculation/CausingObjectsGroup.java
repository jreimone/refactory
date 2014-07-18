/**
 */
package org.emftext.refactoring.smell.calculation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Causing Objects Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.CausingObjectsGroup#getNamedCausingObjects <em>Named Causing Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCausingObjectsGroup()
 * @model
 * @generated
 */
public interface CausingObjectsGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Named Causing Objects</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.calculation.NamedCausingObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Causing Objects</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Causing Objects</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCausingObjectsGroup_NamedCausingObjects()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<NamedCausingObject> getNamedCausingObjects();

} // CausingObjectsGroup
