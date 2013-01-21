/**
 */
package org.emftext.refactoring.smelltype;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Smell Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smelltype.SmellType#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.emftext.refactoring.smelltype.SmellType#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link org.emftext.refactoring.smelltype.SmellType#getIncrement <em>Increment</em>}</li>
 *   <li>{@link org.emftext.refactoring.smelltype.SmellType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smelltype.SmelltypePackage#getSmellType()
 * @model abstract="true"
 * @generated
 */
public interface SmellType extends EObject {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines the lower bound of the value range of this type. Must be greater or equal to 0 and less than upperBound.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(float)
	 * @see org.emftext.refactoring.smelltype.SmelltypePackage#getSmellType_LowerBound()
	 * @model required="true"
	 * @generated
	 */
	float getLowerBound();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smelltype.SmellType#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(float value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines the upper bound of the value range of this type. Must be greater or equal to 0 and greater than lowerBound. If upperBound is -1 then the value range is infinite.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(float)
	 * @see org.emftext.refactoring.smelltype.SmelltypePackage#getSmellType_UpperBound()
	 * @model required="true"
	 * @generated
	 */
	float getUpperBound();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smelltype.SmellType#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(float value);

	/**
	 * Returns the value of the '<em><b>Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the value which will be continuously added to lowerBound until upperBound is reached. Value must be greater than 0. If the value is -1 than an infinite value range is assumed.
	 * <br><br>
	 * This way the value range can be counted.
	 * <br><br>
	 * Example:<br>
	 * lowerBound = 0<br>
	 * upperBound = 1<br>
	 * increment = 1<br><br>
	 * Results in the boolean type since it has only two values: 0 and 1.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Increment</em>' attribute.
	 * @see #setIncrement(float)
	 * @see org.emftext.refactoring.smelltype.SmelltypePackage#getSmellType_Increment()
	 * @model required="true"
	 * @generated
	 */
	float getIncrement();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smelltype.SmellType#getIncrement <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increment</em>' attribute.
	 * @see #getIncrement()
	 * @generated
	 */
	void setIncrement(float value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.emftext.refactoring.smelltype.SmelltypePackage#getSmellType_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smelltype.SmellType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SmellType
