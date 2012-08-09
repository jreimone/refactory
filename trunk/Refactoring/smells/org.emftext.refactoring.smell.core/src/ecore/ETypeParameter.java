/**
 */
package ecore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EType Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ecore.ETypeParameter#getEBounds <em>EBounds</em>}</li>
 * </ul>
 * </p>
 *
 * @see ecore.EcorePackage#getETypeParameter()
 * @model
 * @generated
 */
public interface ETypeParameter extends ENamedElement {
	/**
	 * Returns the value of the '<em><b>EBounds</b></em>' containment reference list.
	 * The list contents are of type {@link ecore.EGenericType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EBounds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EBounds</em>' containment reference list.
	 * @see ecore.EcorePackage#getETypeParameter_EBounds()
	 * @model containment="true"
	 * @generated
	 */
	EList<EGenericType> getEBounds();

} // ETypeParameter
