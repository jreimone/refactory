/**
 */
package oo.OO;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Packageable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link oo.OO.PackageableElement#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see oo.OO.OOPackage#getPackageableElement()
 * @model abstract="true"
 * @generated
 */
public interface PackageableElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link oo.OO.Package#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(oo.OO.Package)
	 * @see oo.OO.OOPackage#getPackageableElement_Package()
	 * @see oo.OO.Package#getContents
	 * @model opposite="contents" transient="false"
	 * @generated
	 */
	oo.OO.Package getPackage();

	/**
	 * Sets the value of the '{@link oo.OO.PackageableElement#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(oo.OO.Package value);

} // PackageableElement
