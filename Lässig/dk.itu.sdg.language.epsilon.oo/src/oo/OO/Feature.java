/**
 */
package oo.OO;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link oo.OO.Feature#getOwner <em>Owner</em>}</li>
 *   <li>{@link oo.OO.Feature#getType <em>Type</em>}</li>
 *   <li>{@link oo.OO.Feature#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @see oo.OO.OOPackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link oo.OO.Class#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(oo.OO.Class)
	 * @see oo.OO.OOPackage#getFeature_Owner()
	 * @see oo.OO.Class#getFeatures
	 * @model opposite="features" transient="false"
	 * @generated
	 */
	oo.OO.Class getOwner();

	/**
	 * Sets the value of the '{@link oo.OO.Feature#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(oo.OO.Class value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Classifier)
	 * @see oo.OO.OOPackage#getFeature_Type()
	 * @model
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '{@link oo.OO.Feature#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link oo.OO.VisibilityEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see oo.OO.VisibilityEnum
	 * @see #setVisibility(VisibilityEnum)
	 * @see oo.OO.OOPackage#getFeature_Visibility()
	 * @model
	 * @generated
	 */
	VisibilityEnum getVisibility();

	/**
	 * Sets the value of the '{@link oo.OO.Feature#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see oo.OO.VisibilityEnum
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisibilityEnum value);

} // Feature
