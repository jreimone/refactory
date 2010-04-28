/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.refactoring.tests.properties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.tests.properties.PropertiesFactory
 * @model kind="package"
 * @generated
 */
public interface PropertiesPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "properties";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.emftext.org/language/properties";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "properties";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	PropertiesPackage eINSTANCE = org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.refactoring.tests.properties.impl.PropertyModelImpl <em>Property Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.refactoring.tests.properties.impl.PropertyModelImpl
   * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getPropertyModel()
   * @generated
   */
	int PROPERTY_MODEL = 0;

	/**
   * The feature id for the '<em><b>Categories</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PROPERTY_MODEL__CATEGORIES = 0;

	/**
   * The number of structural features of the '<em>Property Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PROPERTY_MODEL_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.refactoring.tests.properties.impl.CategoryImpl <em>Category</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.refactoring.tests.properties.impl.CategoryImpl
   * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getCategory()
   * @generated
   */
	int CATEGORY = 1;

	/**
   * The feature id for the '<em><b>Pairs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CATEGORY__PAIRS = 0;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CATEGORY__NAME = 1;

	/**
   * The number of structural features of the '<em>Category</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CATEGORY_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.refactoring.tests.properties.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.refactoring.tests.properties.impl.ValueImpl
   * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getValue()
   * @generated
   */
	int VALUE = 2;

	/**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VALUE_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.refactoring.tests.properties.impl.KeyValuePairImpl <em>Key Value Pair</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.refactoring.tests.properties.impl.KeyValuePairImpl
   * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getKeyValuePair()
   * @generated
   */
	int KEY_VALUE_PAIR = 3;

	/**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int KEY_VALUE_PAIR__VALUE = 0;

	/**
   * The feature id for the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int KEY_VALUE_PAIR__KEY = 1;

	/**
   * The number of structural features of the '<em>Key Value Pair</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int KEY_VALUE_PAIR_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.refactoring.tests.properties.impl.KeyImpl <em>Key</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.refactoring.tests.properties.impl.KeyImpl
   * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getKey()
   * @generated
   */
	int KEY = 4;

	/**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int KEY__KEY = 0;

	/**
   * The number of structural features of the '<em>Key</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int KEY_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.refactoring.tests.properties.impl.EObjectReferenceValueImpl <em>EObject Reference Value</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.refactoring.tests.properties.impl.EObjectReferenceValueImpl
   * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getEObjectReferenceValue()
   * @generated
   */
	int EOBJECT_REFERENCE_VALUE = 5;

	/**
   * The feature id for the '<em><b>Object Reference</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE = VALUE_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>EObject Reference Value</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EOBJECT_REFERENCE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;


	/**
   * The meta object id for the '{@link org.emftext.refactoring.tests.properties.impl.StringValueImpl <em>String Value</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.refactoring.tests.properties.impl.StringValueImpl
   * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getStringValue()
   * @generated
   */
	int STRING_VALUE = 6;

	/**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STRING_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>String Value</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STRING_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;


	/**
   * Returns the meta object for class '{@link org.emftext.refactoring.tests.properties.PropertyModel <em>Property Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Model</em>'.
   * @see org.emftext.refactoring.tests.properties.PropertyModel
   * @generated
   */
	EClass getPropertyModel();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.tests.properties.PropertyModel#getCategories <em>Categories</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Categories</em>'.
   * @see org.emftext.refactoring.tests.properties.PropertyModel#getCategories()
   * @see #getPropertyModel()
   * @generated
   */
	EReference getPropertyModel_Categories();

	/**
   * Returns the meta object for class '{@link org.emftext.refactoring.tests.properties.Category <em>Category</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Category</em>'.
   * @see org.emftext.refactoring.tests.properties.Category
   * @generated
   */
	EClass getCategory();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.tests.properties.Category#getPairs <em>Pairs</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pairs</em>'.
   * @see org.emftext.refactoring.tests.properties.Category#getPairs()
   * @see #getCategory()
   * @generated
   */
	EReference getCategory_Pairs();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.refactoring.tests.properties.Category#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.refactoring.tests.properties.Category#getName()
   * @see #getCategory()
   * @generated
   */
	EAttribute getCategory_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.refactoring.tests.properties.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see org.emftext.refactoring.tests.properties.Value
   * @generated
   */
	EClass getValue();

	/**
   * Returns the meta object for class '{@link org.emftext.refactoring.tests.properties.KeyValuePair <em>Key Value Pair</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key Value Pair</em>'.
   * @see org.emftext.refactoring.tests.properties.KeyValuePair
   * @generated
   */
	EClass getKeyValuePair();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.refactoring.tests.properties.KeyValuePair#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.emftext.refactoring.tests.properties.KeyValuePair#getValue()
   * @see #getKeyValuePair()
   * @generated
   */
	EReference getKeyValuePair_Value();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.refactoring.tests.properties.KeyValuePair#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Key</em>'.
   * @see org.emftext.refactoring.tests.properties.KeyValuePair#getKey()
   * @see #getKeyValuePair()
   * @generated
   */
	EReference getKeyValuePair_Key();

	/**
   * Returns the meta object for class '{@link org.emftext.refactoring.tests.properties.Key <em>Key</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key</em>'.
   * @see org.emftext.refactoring.tests.properties.Key
   * @generated
   */
	EClass getKey();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.refactoring.tests.properties.Key#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.emftext.refactoring.tests.properties.Key#getKey()
   * @see #getKey()
   * @generated
   */
	EAttribute getKey_Key();

	/**
   * Returns the meta object for class '{@link org.emftext.refactoring.tests.properties.EObjectReferenceValue <em>EObject Reference Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>EObject Reference Value</em>'.
   * @see org.emftext.refactoring.tests.properties.EObjectReferenceValue
   * @generated
   */
	EClass getEObjectReferenceValue();

	/**
   * Returns the meta object for the reference '{@link org.emftext.refactoring.tests.properties.EObjectReferenceValue#getObjectReference <em>Object Reference</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object Reference</em>'.
   * @see org.emftext.refactoring.tests.properties.EObjectReferenceValue#getObjectReference()
   * @see #getEObjectReferenceValue()
   * @generated
   */
	EReference getEObjectReferenceValue_ObjectReference();

	/**
   * Returns the meta object for class '{@link org.emftext.refactoring.tests.properties.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Value</em>'.
   * @see org.emftext.refactoring.tests.properties.StringValue
   * @generated
   */
	EClass getStringValue();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.refactoring.tests.properties.StringValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.emftext.refactoring.tests.properties.StringValue#getValue()
   * @see #getStringValue()
   * @generated
   */
	EAttribute getStringValue_Value();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	PropertiesFactory getPropertiesFactory();

	/**
   * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
   * @generated
   */
	interface Literals {
		/**
     * The meta object literal for the '{@link org.emftext.refactoring.tests.properties.impl.PropertyModelImpl <em>Property Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.refactoring.tests.properties.impl.PropertyModelImpl
     * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getPropertyModel()
     * @generated
     */
		EClass PROPERTY_MODEL = eINSTANCE.getPropertyModel();

		/**
     * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference PROPERTY_MODEL__CATEGORIES = eINSTANCE.getPropertyModel_Categories();

		/**
     * The meta object literal for the '{@link org.emftext.refactoring.tests.properties.impl.CategoryImpl <em>Category</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.refactoring.tests.properties.impl.CategoryImpl
     * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getCategory()
     * @generated
     */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
     * The meta object literal for the '<em><b>Pairs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CATEGORY__PAIRS = eINSTANCE.getCategory_Pairs();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
     * The meta object literal for the '{@link org.emftext.refactoring.tests.properties.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.refactoring.tests.properties.impl.ValueImpl
     * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getValue()
     * @generated
     */
		EClass VALUE = eINSTANCE.getValue();

		/**
     * The meta object literal for the '{@link org.emftext.refactoring.tests.properties.impl.KeyValuePairImpl <em>Key Value Pair</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.refactoring.tests.properties.impl.KeyValuePairImpl
     * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getKeyValuePair()
     * @generated
     */
		EClass KEY_VALUE_PAIR = eINSTANCE.getKeyValuePair();

		/**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference KEY_VALUE_PAIR__VALUE = eINSTANCE.getKeyValuePair_Value();

		/**
     * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference KEY_VALUE_PAIR__KEY = eINSTANCE.getKeyValuePair_Key();

		/**
     * The meta object literal for the '{@link org.emftext.refactoring.tests.properties.impl.KeyImpl <em>Key</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.refactoring.tests.properties.impl.KeyImpl
     * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getKey()
     * @generated
     */
		EClass KEY = eINSTANCE.getKey();

		/**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute KEY__KEY = eINSTANCE.getKey_Key();

		/**
     * The meta object literal for the '{@link org.emftext.refactoring.tests.properties.impl.EObjectReferenceValueImpl <em>EObject Reference Value</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.refactoring.tests.properties.impl.EObjectReferenceValueImpl
     * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getEObjectReferenceValue()
     * @generated
     */
		EClass EOBJECT_REFERENCE_VALUE = eINSTANCE.getEObjectReferenceValue();

		/**
     * The meta object literal for the '<em><b>Object Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE = eINSTANCE.getEObjectReferenceValue_ObjectReference();

		/**
     * The meta object literal for the '{@link org.emftext.refactoring.tests.properties.impl.StringValueImpl <em>String Value</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.refactoring.tests.properties.impl.StringValueImpl
     * @see org.emftext.refactoring.tests.properties.impl.PropertiesPackageImpl#getStringValue()
     * @generated
     */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

	}

} //PropertiesPackage
