/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.qualitune.evolution.megamodel.MegamodelFactory;
import org.qualitune.evolution.megamodel.MegamodelPackage;

import org.qualitune.evolution.megamodel.architecture.ArchitecturePackage;

import org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl;

import org.qualitune.evolution.megamodel.cods.CodsPackage;

import org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MegamodelPackageImpl extends EPackageImpl implements MegamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dummyEDataType = null;

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
	 * @see org.qualitune.evolution.megamodel.MegamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MegamodelPackageImpl() {
		super(eNS_URI, MegamodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MegamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MegamodelPackage init() {
		if (isInited) return (MegamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MegamodelPackage.eNS_URI);

		// Obtain or create and register package
		MegamodelPackageImpl theMegamodelPackage = (MegamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MegamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MegamodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CodsPackageImpl theCodsPackage = (CodsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CodsPackage.eNS_URI) instanceof CodsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CodsPackage.eNS_URI) : CodsPackage.eINSTANCE);
		ArchitecturePackageImpl theArchitecturePackage = (ArchitecturePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI) instanceof ArchitecturePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI) : ArchitecturePackage.eINSTANCE);

		// Create package meta-data objects
		theMegamodelPackage.createPackageContents();
		theCodsPackage.createPackageContents();
		theArchitecturePackage.createPackageContents();

		// Initialize created meta-data
		theMegamodelPackage.initializePackageContents();
		theCodsPackage.initializePackageContents();
		theArchitecturePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMegamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MegamodelPackage.eNS_URI, theMegamodelPackage);
		return theMegamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDummy() {
		return dummyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MegamodelFactory getMegamodelFactory() {
		return (MegamodelFactory)getEFactoryInstance();
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

		// Create data types
		dummyEDataType = createEDataType(DUMMY);
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
		CodsPackage theCodsPackage = (CodsPackage)EPackage.Registry.INSTANCE.getEPackage(CodsPackage.eNS_URI);
		ArchitecturePackage theArchitecturePackage = (ArchitecturePackage)EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCodsPackage);
		getESubpackages().add(theArchitecturePackage);

		// Initialize data types
		initEDataType(dummyEDataType, Object.class, "Dummy", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //MegamodelPackageImpl
