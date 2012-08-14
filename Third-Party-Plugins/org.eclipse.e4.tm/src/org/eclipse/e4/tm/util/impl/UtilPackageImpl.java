/**
 * <copyright>
 * </copyright>
 *
 * $Id: UtilPackageImpl.java,v 1.2 2009/06/24 20:22:06 htraetteb Exp $
 */
package org.eclipse.e4.tm.util.impl;

import org.eclipse.e4.tm.layouts.LayoutsPackage;

import org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl;

import org.eclipse.e4.tm.styles.StylesPackage;

import org.eclipse.e4.tm.styles.impl.StylesPackageImpl;

import org.eclipse.e4.tm.util.UtilFactory;
import org.eclipse.e4.tm.util.UtilPackage;

import org.eclipse.e4.tm.widgets.WidgetsPackage;

import org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UtilPackageImpl extends EPackageImpl implements UtilPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType limitedStringEDataType = null;

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
	 * @see org.eclipse.e4.tm.util.UtilPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UtilPackageImpl() {
		super(eNS_URI, UtilFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UtilPackage init() {
		if (isInited) return (UtilPackage)EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);

		// Obtain or create and register package
		UtilPackageImpl theUtilPackage = (UtilPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UtilPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		WidgetsPackageImpl theWidgetsPackage = (WidgetsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WidgetsPackage.eNS_URI) instanceof WidgetsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WidgetsPackage.eNS_URI) : WidgetsPackage.eINSTANCE);
		StylesPackageImpl theStylesPackage = (StylesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI) instanceof StylesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI) : StylesPackage.eINSTANCE);
		LayoutsPackageImpl theLayoutsPackage = (LayoutsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LayoutsPackage.eNS_URI) instanceof LayoutsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LayoutsPackage.eNS_URI) : LayoutsPackage.eINSTANCE);

		// Create package meta-data objects
		theUtilPackage.createPackageContents();
		theWidgetsPackage.createPackageContents();
		theStylesPackage.createPackageContents();
		theLayoutsPackage.createPackageContents();

		// Initialize created meta-data
		theUtilPackage.initializePackageContents();
		theWidgetsPackage.initializePackageContents();
		theStylesPackage.initializePackageContents();
		theLayoutsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUtilPackage.freeze();

		return theUtilPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLimitedString() {
		return limitedStringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UtilFactory getUtilFactory() {
		return (UtilFactory)getEFactoryInstance();
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
		limitedStringEDataType = createEDataType(LIMITED_STRING);
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

		// Initialize data types
		initEDataType(limitedStringEDataType, String.class, "LimitedString", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/e4/tm/util.ecore
		createUtilAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/e4/tm/util.ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUtilAnnotations() {
		String source = "http://www.eclipse.org/e4/tm/util.ecore";		
		addAnnotation
		  (limitedStringEDataType, 
		   source, 
		   new String[] {
			 "stringPattern", ".+"
		   });
	}

} //UtilPackageImpl
