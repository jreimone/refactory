/**
 */
package oo.OO;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link oo.OO.Class#getExtends <em>Extends</em>}</li>
 *   <li>{@link oo.OO.Class#getExtendedBy <em>Extended By</em>}</li>
 *   <li>{@link oo.OO.Class#getFeatures <em>Features</em>}</li>
 *   <li>{@link oo.OO.Class#getIsAbstract <em>Is Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @see oo.OO.OOPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link oo.OO.Class#getExtendedBy <em>Extended By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference.
	 * @see #setExtends(Class)
	 * @see oo.OO.OOPackage#getClass_Extends()
	 * @see oo.OO.Class#getExtendedBy
	 * @model opposite="extendedBy"
	 * @generated
	 */
	Class getExtends();

	/**
	 * Sets the value of the '{@link oo.OO.Class#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(Class value);

	/**
	 * Returns the value of the '<em><b>Extended By</b></em>' reference list.
	 * The list contents are of type {@link oo.OO.Class}.
	 * It is bidirectional and its opposite is '{@link oo.OO.Class#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended By</em>' reference list.
	 * @see oo.OO.OOPackage#getClass_ExtendedBy()
	 * @see oo.OO.Class#getExtends
	 * @model opposite="extends"
	 * @generated
	 */
	EList<Class> getExtendedBy();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link oo.OO.Feature}.
	 * It is bidirectional and its opposite is '{@link oo.OO.Feature#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see oo.OO.OOPackage#getClass_Features()
	 * @see oo.OO.Feature#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(Boolean)
	 * @see oo.OO.OOPackage#getClass_IsAbstract()
	 * @model
	 * @generated
	 */
	Boolean getIsAbstract();

	/**
	 * Sets the value of the '{@link oo.OO.Class#getIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #getIsAbstract()
	 * @generated
	 */
	void setIsAbstract(Boolean value);

} // Class
