/**
 */
package oo.OO;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link oo.OO.StructuralFeature#getIsMany <em>Is Many</em>}</li>
 * </ul>
 * </p>
 *
 * @see oo.OO.OOPackage#getStructuralFeature()
 * @model abstract="true"
 * @generated
 */
public interface StructuralFeature extends Feature {
	/**
	 * Returns the value of the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Many</em>' attribute.
	 * @see #setIsMany(Boolean)
	 * @see oo.OO.OOPackage#getStructuralFeature_IsMany()
	 * @model
	 * @generated
	 */
	Boolean getIsMany();

	/**
	 * Sets the value of the '{@link oo.OO.StructuralFeature#getIsMany <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Many</em>' attribute.
	 * @see #getIsMany()
	 * @generated
	 */
	void setIsMany(Boolean value);

} // StructuralFeature
