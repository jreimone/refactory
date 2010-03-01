/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage
 * @generated
 */
public interface RolemappingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RolemappingFactory eINSTANCE = org.emftext.language.refactoring.rolemapping.impl.RolemappingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Role Mapping Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Mapping Model</em>'.
	 * @generated
	 */
	RoleMappingModel createRoleMappingModel();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Concrete Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Mapping</em>'.
	 * @generated
	 */
	ConcreteMapping createConcreteMapping();

	/**
	 * Returns a new object of class '<em>Relation Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Mapping</em>'.
	 * @generated
	 */
	RelationMapping createRelationMapping();

	/**
	 * Returns a new object of class '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Mapping</em>'.
	 * @generated
	 */
	AttributeMapping createAttributeMapping();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RolemappingPackage getRolemappingPackage();

} //RolemappingFactory
