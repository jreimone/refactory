/**
 */
package rolemapping;

import ecore.EClass;
import ecore.EReference;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Meta Class Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rolemapping.ReferenceMetaClassPair#getReference <em>Reference</em>}</li>
 *   <li>{@link rolemapping.ReferenceMetaClassPair#getMetaClass <em>Meta Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see rolemapping.RolemappingPackage#getReferenceMetaClassPair()
 * @model
 * @generated
 */
public interface ReferenceMetaClassPair extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(EReference)
	 * @see rolemapping.RolemappingPackage#getReferenceMetaClassPair_Reference()
	 * @model required="true"
	 * @generated
	 */
	EReference getReference();

	/**
	 * Sets the value of the '{@link rolemapping.ReferenceMetaClassPair#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(EReference value);

	/**
	 * Returns the value of the '<em><b>Meta Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Class</em>' reference.
	 * @see #setMetaClass(EClass)
	 * @see rolemapping.RolemappingPackage#getReferenceMetaClassPair_MetaClass()
	 * @model
	 * @generated
	 */
	EClass getMetaClass();

	/**
	 * Sets the value of the '{@link rolemapping.ReferenceMetaClassPair#getMetaClass <em>Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Class</em>' reference.
	 * @see #getMetaClass()
	 * @generated
	 */
	void setMetaClass(EClass value);

} // ReferenceMetaClassPair
