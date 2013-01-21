/**
 */
package families;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Family</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link families.Family#getLastName <em>Last Name</em>}</li>
 *   <li>{@link families.Family#getFather <em>Father</em>}</li>
 *   <li>{@link families.Family#getMother <em>Mother</em>}</li>
 *   <li>{@link families.Family#getSons <em>Sons</em>}</li>
 *   <li>{@link families.Family#getDaughters <em>Daughters</em>}</li>
 * </ul>
 * </p>
 *
 * @see families.FamiliesPackage#getFamily()
 * @model
 * @generated
 */
public interface Family extends EObject {
	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see families.FamiliesPackage#getFamily_LastName()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link families.Family#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Father</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link families.Member#getFamilyFather <em>Family Father</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Father</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Father</em>' containment reference.
	 * @see #setFather(Member)
	 * @see families.FamiliesPackage#getFamily_Father()
	 * @see families.Member#getFamilyFather
	 * @model opposite="familyFather" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Member getFather();

	/**
	 * Sets the value of the '{@link families.Family#getFather <em>Father</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Father</em>' containment reference.
	 * @see #getFather()
	 * @generated
	 */
	void setFather(Member value);

	/**
	 * Returns the value of the '<em><b>Mother</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link families.Member#getFamilyMother <em>Family Mother</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mother</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mother</em>' containment reference.
	 * @see #setMother(Member)
	 * @see families.FamiliesPackage#getFamily_Mother()
	 * @see families.Member#getFamilyMother
	 * @model opposite="familyMother" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Member getMother();

	/**
	 * Sets the value of the '{@link families.Family#getMother <em>Mother</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mother</em>' containment reference.
	 * @see #getMother()
	 * @generated
	 */
	void setMother(Member value);

	/**
	 * Returns the value of the '<em><b>Sons</b></em>' containment reference list.
	 * The list contents are of type {@link families.Member}.
	 * It is bidirectional and its opposite is '{@link families.Member#getFamilySon <em>Family Son</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sons</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sons</em>' containment reference list.
	 * @see families.FamiliesPackage#getFamily_Sons()
	 * @see families.Member#getFamilySon
	 * @model opposite="familySon" containment="true" ordered="false"
	 * @generated
	 */
	EList<Member> getSons();

	/**
	 * Returns the value of the '<em><b>Daughters</b></em>' containment reference list.
	 * The list contents are of type {@link families.Member}.
	 * It is bidirectional and its opposite is '{@link families.Member#getFamilyDaughter <em>Family Daughter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Daughters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Daughters</em>' containment reference list.
	 * @see families.FamiliesPackage#getFamily_Daughters()
	 * @see families.Member#getFamilyDaughter
	 * @model opposite="familyDaughter" containment="true" ordered="false"
	 * @generated
	 */
	EList<Member> getDaughters();

} // Family
