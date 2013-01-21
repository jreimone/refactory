/**
 */
package oo.OO;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link oo.OO.Package#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see oo.OO.OOPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends PackageableElement {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link oo.OO.PackageableElement}.
	 * It is bidirectional and its opposite is '{@link oo.OO.PackageableElement#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see oo.OO.OOPackage#getPackage_Contents()
	 * @see oo.OO.PackageableElement#getPackage
	 * @model opposite="package" containment="true"
	 * @generated
	 */
	EList<PackageableElement> getContents();

} // Package
