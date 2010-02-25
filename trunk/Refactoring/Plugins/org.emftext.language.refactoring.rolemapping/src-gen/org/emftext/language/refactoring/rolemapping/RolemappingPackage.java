/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping;

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
 * @see org.emftext.language.refactoring.rolemapping.RolemappingFactory
 * @model kind="package"
 * @generated
 */
public interface RolemappingPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "rolemapping";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.emftext.org/language/rolemapping";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "rolemapping";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	RolemappingPackage eINSTANCE = org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.rolemapping.impl.RoleMappingModelImpl <em>Role Mapping Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.rolemapping.impl.RoleMappingModelImpl
   * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getRoleMappingModel()
   * @generated
   */
	int ROLE_MAPPING_MODEL = 0;

	/**
   * The feature id for the '<em><b>Target Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_MODEL__TARGET_METAMODEL = 0;

	/**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_MODEL__MAPPINGS = 1;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_MODEL__NAME = 2;

	/**
   * The number of structural features of the '<em>Role Mapping Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_MODEL_FEATURE_COUNT = 3;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.rolemapping.impl.MappingImpl <em>Mapping</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.rolemapping.impl.MappingImpl
   * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getMapping()
   * @generated
   */
	int MAPPING = 1;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAPPING__NAME = 0;

	/**
   * The feature id for the '<em><b>Mapped Role Model</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAPPING__MAPPED_ROLE_MODEL = 1;

	/**
   * The feature id for the '<em><b>Role To Metaelement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAPPING__ROLE_TO_METAELEMENT = 2;

	/**
   * The number of structural features of the '<em>Mapping</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAPPING_FEATURE_COUNT = 3;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.rolemapping.impl.ConcreteMappingImpl <em>Concrete Mapping</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.rolemapping.impl.ConcreteMappingImpl
   * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getConcreteMapping()
   * @generated
   */
	int CONCRETE_MAPPING = 2;

	/**
   * The feature id for the '<em><b>Role</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONCRETE_MAPPING__ROLE = 0;

	/**
   * The feature id for the '<em><b>Metaclass</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONCRETE_MAPPING__METACLASS = 1;

	/**
   * The feature id for the '<em><b>Outgoing Relation Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONCRETE_MAPPING__OUTGOING_RELATION_MAPPINGS = 2;

	/**
   * The feature id for the '<em><b>Attribute Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS = 3;

	/**
   * The number of structural features of the '<em>Concrete Mapping</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONCRETE_MAPPING_FEATURE_COUNT = 4;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.rolemapping.impl.RelationMappingImpl <em>Relation Mapping</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.rolemapping.impl.RelationMappingImpl
   * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getRelationMapping()
   * @generated
   */
	int RELATION_MAPPING = 3;

	/**
   * The feature id for the '<em><b>Relation</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATION_MAPPING__RELATION = 0;

	/**
   * The feature id for the '<em><b>References</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATION_MAPPING__REFERENCES = 1;

	/**
   * The number of structural features of the '<em>Relation Mapping</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATION_MAPPING_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.refactoring.rolemapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.refactoring.rolemapping.impl.AttributeMappingImpl
   * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getAttributeMapping()
   * @generated
   */
	int ATTRIBUTE_MAPPING = 4;

	/**
   * The feature id for the '<em><b>Role Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE = 0;

	/**
   * The feature id for the '<em><b>Class Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE = 1;

	/**
   * The number of structural features of the '<em>Attribute Mapping</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE_MAPPING_FEATURE_COUNT = 2;


	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.rolemapping.RoleMappingModel <em>Role Mapping Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Mapping Model</em>'.
   * @see org.emftext.language.refactoring.rolemapping.RoleMappingModel
   * @generated
   */
	EClass getRoleMappingModel();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.refactoring.rolemapping.RoleMappingModel#getTargetMetamodel <em>Target Metamodel</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Metamodel</em>'.
   * @see org.emftext.language.refactoring.rolemapping.RoleMappingModel#getTargetMetamodel()
   * @see #getRoleMappingModel()
   * @generated
   */
	EReference getRoleMappingModel_TargetMetamodel();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.refactoring.rolemapping.RoleMappingModel#getMappings <em>Mappings</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mappings</em>'.
   * @see org.emftext.language.refactoring.rolemapping.RoleMappingModel#getMappings()
   * @see #getRoleMappingModel()
   * @generated
   */
	EReference getRoleMappingModel_Mappings();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.rolemapping.RoleMappingModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.language.refactoring.rolemapping.RoleMappingModel#getName()
   * @see #getRoleMappingModel()
   * @generated
   */
	EAttribute getRoleMappingModel_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.rolemapping.Mapping <em>Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mapping</em>'.
   * @see org.emftext.language.refactoring.rolemapping.Mapping
   * @generated
   */
	EClass getMapping();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.rolemapping.Mapping#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.language.refactoring.rolemapping.Mapping#getName()
   * @see #getMapping()
   * @generated
   */
	EAttribute getMapping_Name();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.refactoring.rolemapping.Mapping#getMappedRoleModel <em>Mapped Role Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Mapped Role Model</em>'.
   * @see org.emftext.language.refactoring.rolemapping.Mapping#getMappedRoleModel()
   * @see #getMapping()
   * @generated
   */
	EReference getMapping_MappedRoleModel();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.refactoring.rolemapping.Mapping#getRoleToMetaelement <em>Role To Metaelement</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Role To Metaelement</em>'.
   * @see org.emftext.language.refactoring.rolemapping.Mapping#getRoleToMetaelement()
   * @see #getMapping()
   * @generated
   */
	EReference getMapping_RoleToMetaelement();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping <em>Concrete Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concrete Mapping</em>'.
   * @see org.emftext.language.refactoring.rolemapping.ConcreteMapping
   * @generated
   */
	EClass getConcreteMapping();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getRole <em>Role</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Role</em>'.
   * @see org.emftext.language.refactoring.rolemapping.ConcreteMapping#getRole()
   * @see #getConcreteMapping()
   * @generated
   */
	EReference getConcreteMapping_Role();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getMetaclass <em>Metaclass</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Metaclass</em>'.
   * @see org.emftext.language.refactoring.rolemapping.ConcreteMapping#getMetaclass()
   * @see #getConcreteMapping()
   * @generated
   */
	EReference getConcreteMapping_Metaclass();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getOutgoingRelationMappings <em>Outgoing Relation Mappings</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Outgoing Relation Mappings</em>'.
   * @see org.emftext.language.refactoring.rolemapping.ConcreteMapping#getOutgoingRelationMappings()
   * @see #getConcreteMapping()
   * @generated
   */
	EReference getConcreteMapping_OutgoingRelationMappings();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getAttributeMappings <em>Attribute Mappings</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute Mappings</em>'.
   * @see org.emftext.language.refactoring.rolemapping.ConcreteMapping#getAttributeMappings()
   * @see #getConcreteMapping()
   * @generated
   */
	EReference getConcreteMapping_AttributeMappings();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.rolemapping.RelationMapping <em>Relation Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation Mapping</em>'.
   * @see org.emftext.language.refactoring.rolemapping.RelationMapping
   * @generated
   */
	EClass getRelationMapping();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.refactoring.rolemapping.RelationMapping#getRelation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Relation</em>'.
   * @see org.emftext.language.refactoring.rolemapping.RelationMapping#getRelation()
   * @see #getRelationMapping()
   * @generated
   */
	EReference getRelationMapping_Relation();

	/**
   * Returns the meta object for the reference list '{@link org.emftext.language.refactoring.rolemapping.RelationMapping#getReferences <em>References</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>References</em>'.
   * @see org.emftext.language.refactoring.rolemapping.RelationMapping#getReferences()
   * @see #getRelationMapping()
   * @generated
   */
	EReference getRelationMapping_References();

	/**
   * Returns the meta object for class '{@link org.emftext.language.refactoring.rolemapping.AttributeMapping <em>Attribute Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Mapping</em>'.
   * @see org.emftext.language.refactoring.rolemapping.AttributeMapping
   * @generated
   */
	EClass getAttributeMapping();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.refactoring.rolemapping.AttributeMapping#getRoleAttribute <em>Role Attribute</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Role Attribute</em>'.
   * @see org.emftext.language.refactoring.rolemapping.AttributeMapping#getRoleAttribute()
   * @see #getAttributeMapping()
   * @generated
   */
	EReference getAttributeMapping_RoleAttribute();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.refactoring.rolemapping.AttributeMapping#getClassAttribute <em>Class Attribute</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Class Attribute</em>'.
   * @see org.emftext.language.refactoring.rolemapping.AttributeMapping#getClassAttribute()
   * @see #getAttributeMapping()
   * @generated
   */
	EReference getAttributeMapping_ClassAttribute();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	RolemappingFactory getRolemappingFactory();

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
     * The meta object literal for the '{@link org.emftext.language.refactoring.rolemapping.impl.RoleMappingModelImpl <em>Role Mapping Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.rolemapping.impl.RoleMappingModelImpl
     * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getRoleMappingModel()
     * @generated
     */
		EClass ROLE_MAPPING_MODEL = eINSTANCE.getRoleMappingModel();

		/**
     * The meta object literal for the '<em><b>Target Metamodel</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ROLE_MAPPING_MODEL__TARGET_METAMODEL = eINSTANCE.getRoleMappingModel_TargetMetamodel();

		/**
     * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ROLE_MAPPING_MODEL__MAPPINGS = eINSTANCE.getRoleMappingModel_Mappings();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ROLE_MAPPING_MODEL__NAME = eINSTANCE.getRoleMappingModel_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.rolemapping.impl.MappingImpl <em>Mapping</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.rolemapping.impl.MappingImpl
     * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getMapping()
     * @generated
     */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute MAPPING__NAME = eINSTANCE.getMapping_Name();

		/**
     * The meta object literal for the '<em><b>Mapped Role Model</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MAPPING__MAPPED_ROLE_MODEL = eINSTANCE.getMapping_MappedRoleModel();

		/**
     * The meta object literal for the '<em><b>Role To Metaelement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MAPPING__ROLE_TO_METAELEMENT = eINSTANCE.getMapping_RoleToMetaelement();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.rolemapping.impl.ConcreteMappingImpl <em>Concrete Mapping</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.rolemapping.impl.ConcreteMappingImpl
     * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getConcreteMapping()
     * @generated
     */
		EClass CONCRETE_MAPPING = eINSTANCE.getConcreteMapping();

		/**
     * The meta object literal for the '<em><b>Role</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CONCRETE_MAPPING__ROLE = eINSTANCE.getConcreteMapping_Role();

		/**
     * The meta object literal for the '<em><b>Metaclass</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CONCRETE_MAPPING__METACLASS = eINSTANCE.getConcreteMapping_Metaclass();

		/**
     * The meta object literal for the '<em><b>Outgoing Relation Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CONCRETE_MAPPING__OUTGOING_RELATION_MAPPINGS = eINSTANCE.getConcreteMapping_OutgoingRelationMappings();

		/**
     * The meta object literal for the '<em><b>Attribute Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS = eINSTANCE.getConcreteMapping_AttributeMappings();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.rolemapping.impl.RelationMappingImpl <em>Relation Mapping</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.rolemapping.impl.RelationMappingImpl
     * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getRelationMapping()
     * @generated
     */
		EClass RELATION_MAPPING = eINSTANCE.getRelationMapping();

		/**
     * The meta object literal for the '<em><b>Relation</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RELATION_MAPPING__RELATION = eINSTANCE.getRelationMapping_Relation();

		/**
     * The meta object literal for the '<em><b>References</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RELATION_MAPPING__REFERENCES = eINSTANCE.getRelationMapping_References();

		/**
     * The meta object literal for the '{@link org.emftext.language.refactoring.rolemapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.refactoring.rolemapping.impl.AttributeMappingImpl
     * @see org.emftext.language.refactoring.rolemapping.impl.RolemappingPackageImpl#getAttributeMapping()
     * @generated
     */
		EClass ATTRIBUTE_MAPPING = eINSTANCE.getAttributeMapping();

		/**
     * The meta object literal for the '<em><b>Role Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE = eINSTANCE.getAttributeMapping_RoleAttribute();

		/**
     * The meta object literal for the '<em><b>Class Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE = eINSTANCE.getAttributeMapping_ClassAttribute();

	}

} //RolemappingPackage
