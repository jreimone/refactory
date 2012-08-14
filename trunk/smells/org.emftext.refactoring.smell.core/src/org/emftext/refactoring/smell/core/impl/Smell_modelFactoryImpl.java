/**
 */
package org.emftext.refactoring.smell.core.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.emftext.refactoring.smell.core.*;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Smell_modelFactoryImpl extends EFactoryImpl implements Smell_modelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Smell_modelFactory init() {
		try {
			Smell_modelFactory theSmell_modelFactory = (Smell_modelFactory)EPackage.Registry.INSTANCE.getEFactory("http://smell_model/1.0"); 
			if (theSmell_modelFactory != null) {
				return theSmell_modelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Smell_modelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Smell_modelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Smell_modelPackage.MODEL_SMELL: return createModelSmell();
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING: return createModelSmell_Rolemapping_Mapping();
			case Smell_modelPackage.QUALITY: return createQuality();
			case Smell_modelPackage.QUALITY_MODEL_SMELL_MAPPING: return createQuality_ModelSmell_Mapping();
			case Smell_modelPackage.METRIC_QUALITY_MAPPING: return createMetric_Quality_Mapping();
			case Smell_modelPackage.MODEL_SMELL_MODEL: return createModelSmellModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public ModelSmell createModelSmell() {
		ModelSmellImpl modelSmell = new ModelSmellImpl();
		return modelSmell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSmell_Rolemapping_Mapping createModelSmell_Rolemapping_Mapping() {
		ModelSmell_Rolemapping_MappingImpl modelSmell_Rolemapping_Mapping = new ModelSmell_Rolemapping_MappingImpl();
		return modelSmell_Rolemapping_Mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Quality createQuality() {
		QualityImpl quality = new QualityImpl();
		return quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quality_ModelSmell_Mapping createQuality_ModelSmell_Mapping() {
		Quality_ModelSmell_MappingImpl quality_ModelSmell_Mapping = new Quality_ModelSmell_MappingImpl();
		return quality_ModelSmell_Mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric_Quality_Mapping createMetric_Quality_Mapping() {
		Metric_Quality_MappingImpl metric_Quality_Mapping = new Metric_Quality_MappingImpl();
		return metric_Quality_Mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSmellModel createModelSmellModel() {
		ModelSmellModelImpl modelSmellModel = new ModelSmellModelImpl();
		return modelSmellModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleMapping createRoleMapping() {
		RoleMappingImpl roleMapping = new RoleMappingImpl();
		return roleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingConcretisation createMappingConcretisation() {
		MappingConcretisationImpl mappingConcretisation = new MappingConcretisationImpl();
		return mappingConcretisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSmellResult createModelSmellResult() {
		ModelSmellResultImpl modelSmellResult = new ModelSmellResultImpl();
		return modelSmellResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Smell_modelPackage getSmell_modelPackage() {
		return (Smell_modelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Smell_modelPackage getPackage() {
		return Smell_modelPackage.eINSTANCE;
	}

} //Smell_modelFactoryImpl
