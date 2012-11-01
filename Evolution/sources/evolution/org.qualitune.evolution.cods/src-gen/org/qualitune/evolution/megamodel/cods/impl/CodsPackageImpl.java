/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.cods.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.qualitune.evolution.megamodel.MegamodelPackage;
import org.qualitune.evolution.megamodel.architecture.ArchitecturePackage;

import org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl;

import org.qualitune.evolution.megamodel.cods.CoEvolutionDefinition;
import org.qualitune.evolution.megamodel.cods.CodsFactory;
import org.qualitune.evolution.megamodel.cods.CodsPackage;
import org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification;
import org.qualitune.evolution.megamodel.cods.EvolutionDefinition;
import org.qualitune.evolution.megamodel.impl.MegamodelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodsPackageImpl extends EPackageImpl implements CodsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainSpecificEvolutionSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evolutionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coEvolutionDefinitionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.qualitune.evolution.megamodel.cods.CodsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CodsPackageImpl() {
		super(eNS_URI, CodsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CodsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CodsPackage init() {
		if (isInited) return (CodsPackage)EPackage.Registry.INSTANCE.getEPackage(CodsPackage.eNS_URI);

		// Obtain or create and register package
		CodsPackageImpl theCodsPackage = (CodsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CodsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CodsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		MegamodelPackageImpl theMegamodelPackage = (MegamodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MegamodelPackage.eNS_URI) instanceof MegamodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MegamodelPackage.eNS_URI) : MegamodelPackage.eINSTANCE);
		ArchitecturePackageImpl theArchitecturePackage = (ArchitecturePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI) instanceof ArchitecturePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI) : ArchitecturePackage.eINSTANCE);

		// Create package meta-data objects
		theCodsPackage.createPackageContents();
		theMegamodelPackage.createPackageContents();
		theArchitecturePackage.createPackageContents();

		// Initialize created meta-data
		theCodsPackage.initializePackageContents();
		theMegamodelPackage.initializePackageContents();
		theArchitecturePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCodsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CodsPackage.eNS_URI, theCodsPackage);
		return theCodsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCODS() {
		return codsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCODS_DSES() {
		return (EReference)codsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainSpecificEvolutionSpecification() {
		return domainSpecificEvolutionSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificEvolutionSpecification_Metamodel() {
		return (EReference)domainSpecificEvolutionSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificEvolutionSpecification_ED() {
		return (EReference)domainSpecificEvolutionSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificEvolutionSpecification_CoED() {
		return (EReference)domainSpecificEvolutionSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvolutionDefinition() {
		return evolutionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoEvolutionDefinition() {
		return coEvolutionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodsFactory getCodsFactory() {
		return (CodsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		codsEClass = createEClass(CODS);
		createEReference(codsEClass, CODS__DSES);

		domainSpecificEvolutionSpecificationEClass = createEClass(DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION);
		createEReference(domainSpecificEvolutionSpecificationEClass, DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__METAMODEL);
		createEReference(domainSpecificEvolutionSpecificationEClass, DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED);
		createEReference(domainSpecificEvolutionSpecificationEClass, DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED);

		evolutionDefinitionEClass = createEClass(EVOLUTION_DEFINITION);

		coEvolutionDefinitionEClass = createEClass(CO_EVOLUTION_DEFINITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ArchitecturePackage theArchitecturePackage = (ArchitecturePackage)EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		codsEClass.getESuperTypes().add(theArchitecturePackage.getMegaModel());

		// Initialize classes and features; add operations and parameters
		initEClass(codsEClass, org.qualitune.evolution.megamodel.cods.CODS.class, "CODS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCODS_DSES(), this.getDomainSpecificEvolutionSpecification(), null, "DSES", null, 0, -1, org.qualitune.evolution.megamodel.cods.CODS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainSpecificEvolutionSpecificationEClass, DomainSpecificEvolutionSpecification.class, "DomainSpecificEvolutionSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainSpecificEvolutionSpecification_Metamodel(), theArchitecturePackage.getMetaModel(), null, "metamodel", null, 1, 1, DomainSpecificEvolutionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainSpecificEvolutionSpecification_ED(), this.getEvolutionDefinition(), null, "ED", null, 0, 1, DomainSpecificEvolutionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainSpecificEvolutionSpecification_CoED(), this.getCoEvolutionDefinition(), null, "CoED", null, 0, 1, DomainSpecificEvolutionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evolutionDefinitionEClass, EvolutionDefinition.class, "EvolutionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(coEvolutionDefinitionEClass, CoEvolutionDefinition.class, "CoEvolutionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //CodsPackageImpl
