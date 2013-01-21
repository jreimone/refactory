/**
 */
package families;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link families.Member#getFirstName <em>First Name</em>}</li>
 *   <li>{@link families.Member#getFamilyFather <em>Family Father</em>}</li>
 *   <li>{@link families.Member#getFamilyMother <em>Family Mother</em>}</li>
 *   <li>{@link families.Member#getFamilySon <em>Family Son</em>}</li>
 *   <li>{@link families.Member#getFamilyDaughter <em>Family Daughter</em>}</li>
 * </ul>
 * </p>
 *
 * @see families.FamiliesPackage#getMember()
 * @model
 * @generated
 */
public interface Member extends EObject {
	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see families.FamiliesPackage#getMember_FirstName()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link families.Member#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Family Father</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link families.Family#getFather <em>Father</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Father</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Father</em>' container reference.
	 * @see #setFamilyFather(Family)
	 * @see families.FamiliesPackage#getMember_FamilyFather()
	 * @see families.Family#getFather
	 * @model opposite="father" transient="false" ordered="false"
	 * @generated
	 */
	Family getFamilyFather();

	/**
	 * Sets the value of the '{@link families.Member#getFamilyFather <em>Family Father</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Father</em>' container reference.
	 * @see #getFamilyFather()
	 * @generated
	 */
	void setFamilyFather(Family value);

	/**
	 * Returns the value of the '<em><b>Family Mother</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link families.Family#getMother <em>Mother</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Mother</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Mother</em>' container reference.
	 * @see #setFamilyMother(Family)
	 * @see families.FamiliesPackage#getMember_FamilyMother()
	 * @see families.Family#getMother
	 * @model opposite="mother" transient="false" ordered="false"
	 * @generated
	 */
	Family getFamilyMother();

	/**
	 * Sets the value of the '{@link families.Member#getFamilyMother <em>Family Mother</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Mother</em>' container reference.
	 * @see #getFamilyMother()
	 * @generated
	 */
	void setFamilyMother(Family value);

	/**
	 * Returns the value of the '<em><b>Family Son</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link families.Family#getSons <em>Sons</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Son</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Son</em>' container reference.
	 * @see #setFamilySon(Family)
	 * @see families.FamiliesPackage#getMember_FamilySon()
	 * @see families.Family#getSons
	 * @model opposite="sons" transient="false" ordered="false"
	 * @generated
	 */
	Family getFamilySon();

	/**
	 * Sets the value of the '{@link families.Member#getFamilySon <em>Family Son</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Son</em>' container reference.
	 * @see #getFamilySon()
	 * @generated
	 */
	void setFamilySon(Family value);

	/**
	 * Returns the value of the '<em><b>Family Daughter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link families.Family#getDaughters <em>Daughters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Daughter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Daughter</em>' container reference.
	 * @see #setFamilyDaughter(Family)
	 * @see families.FamiliesPackage#getMember_FamilyDaughter()
	 * @see families.Family#getDaughters
	 * @model opposite="daughters" transient="false" ordered="false"
	 * @generated
	 */
	Family getFamilyDaughter();

	/**
	 * Sets the value of the '{@link families.Member#getFamilyDaughter <em>Family Daughter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Daughter</em>' container reference.
	 * @see #getFamilyDaughter()
	 * @generated
	 */
	void setFamilyDaughter(Family value);

} // Member
