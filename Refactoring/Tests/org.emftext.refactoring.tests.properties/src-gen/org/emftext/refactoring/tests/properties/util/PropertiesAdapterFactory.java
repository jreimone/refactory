/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.refactoring.tests.properties.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.refactoring.tests.properties.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.tests.properties.PropertiesPackage
 * @generated
 */
public class PropertiesAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static PropertiesPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PropertiesAdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = PropertiesPackage.eINSTANCE;
    }
  }

	/**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
	@Override
	public boolean isFactoryForType(Object object) {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

	/**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected PropertiesSwitch<Adapter> modelSwitch =
		new PropertiesSwitch<Adapter>()
    {
      @Override
      public Adapter casePropertyModel(PropertyModel object)
      {
        return createPropertyModelAdapter();
      }
      @Override
      public Adapter caseCategory(Category object)
      {
        return createCategoryAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseKeyValuePair(KeyValuePair object)
      {
        return createKeyValuePairAdapter();
      }
      @Override
      public Adapter caseKey(Key object)
      {
        return createKeyAdapter();
      }
      @Override
      public Adapter caseEObjectReferenceValue(EObjectReferenceValue object)
      {
        return createEObjectReferenceValueAdapter();
      }
      @Override
      public Adapter caseStringValue(StringValue object)
      {
        return createStringValueAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

	/**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
	@Override
	public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


	/**
   * Creates a new adapter for an object of class '{@link org.emftext.refactoring.tests.properties.PropertyModel <em>Property Model</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.refactoring.tests.properties.PropertyModel
   * @generated
   */
	public Adapter createPropertyModelAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.refactoring.tests.properties.Category <em>Category</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.refactoring.tests.properties.Category
   * @generated
   */
	public Adapter createCategoryAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.refactoring.tests.properties.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.refactoring.tests.properties.Value
   * @generated
   */
	public Adapter createValueAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.refactoring.tests.properties.KeyValuePair <em>Key Value Pair</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.refactoring.tests.properties.KeyValuePair
   * @generated
   */
	public Adapter createKeyValuePairAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.refactoring.tests.properties.Key <em>Key</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.refactoring.tests.properties.Key
   * @generated
   */
	public Adapter createKeyAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.refactoring.tests.properties.EObjectReferenceValue <em>EObject Reference Value</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.refactoring.tests.properties.EObjectReferenceValue
   * @generated
   */
	public Adapter createEObjectReferenceValueAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.refactoring.tests.properties.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.refactoring.tests.properties.StringValue
   * @generated
   */
	public Adapter createStringValueAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
	public Adapter createEObjectAdapter() {
    return null;
  }

} //PropertiesAdapterFactory
