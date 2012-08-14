/**
 * <copyright>
 * </copyright>
 *
 * $Id: LayoutsValidator.java,v 1.1 2009/05/19 07:21:09 htraetteb Exp $
 */
package org.eclipse.e4.tm.layouts.util;

import java.util.Map;

import org.eclipse.e4.tm.layouts.*;
import org.eclipse.e4.tm.widgets.AbstractComposite;
import org.eclipse.e4.tm.widgets.Control;
import org.eclipse.e4.tm.widgets.WidgetsPackage;
import org.eclipse.e4.tm.widgets.util.WidgetsValidator;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.e4.tm.layouts.LayoutsPackage
 * @generated
 */
public class LayoutsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final LayoutsValidator INSTANCE = new LayoutsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.e4.tm.layouts";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutsValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return LayoutsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case LayoutsPackage.LAYOUT_DATA:
				return validateLayoutData((LayoutData)value, diagnostics, context);
			case LayoutsPackage.LAYOUT:
				return validateLayout((Layout<?>)value, diagnostics, context);
			case LayoutsPackage.RECTANGLE_LAYOUT:
				return validateRectangleLayout((Layout)value, diagnostics, context);
			case LayoutsPackage.RECTANGLE_LAYOUT_DATA:
				return validateRectangleLayoutData((LayoutData)value, diagnostics, context);
			case LayoutsPackage.POSITION:
				return validatePosition((EObject)value, diagnostics, context);
			case LayoutsPackage.DIMENSION:
				return validateDimension((EObject)value, diagnostics, context);
			case LayoutsPackage.RECTANGLE:
				return validateRectangle((EObject)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLayoutData(LayoutData layoutData, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(layoutData, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLayout(Layout<?> layout, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(layout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(layout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(layout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(layout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(layout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(layout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(layout, diagnostics, context);
		if (result || diagnostics != null) result &= validateLayout_validLayoutData(layout, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validLayoutData constraint of '<em>Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateLayout_validLayoutData(Layout<?> layout, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (! validateLayout_validLayoutData(layout)) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "validLayoutData", getObjectLabel(layout, context) },
						 new Object[] { layout },
						 context));
			}
			return false;
		}
		return true;
	}

	private boolean validateLayout_validLayoutData(Layout<?> layout) {
		if (WidgetsPackage.eINSTANCE.getAbstractComposite().isInstance(layout.eContainer())) {
			AbstractComposite<?> abstractComposite = (AbstractComposite<?>)layout.eContainer();
			EClassifier specializedType = WidgetsValidator.getSpecializedType(layout.eClass(), LayoutsPackage.eINSTANCE.getLayout());
			if (specializedType != null) {
				for (Control control : abstractComposite.getControls()) {
					LayoutData layoutData = control.getLayoutData();
					if (layoutData != null && (! specializedType.isInstance(layoutData))) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRectangleLayout(Layout rectangleLayout, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(rectangleLayout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rectangleLayout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rectangleLayout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rectangleLayout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rectangleLayout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rectangleLayout, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rectangleLayout, diagnostics, context);
		if (result || diagnostics != null) result &= validateLayout_validLayoutData(rectangleLayout, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRectangleLayoutData(LayoutData rectangleLayoutData, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rectangleLayoutData, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePosition(EObject position, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(position, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDimension(EObject dimension, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dimension, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRectangle(EObject rectangle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rectangle, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //LayoutsValidator
