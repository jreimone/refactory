/**
 * <copyright>
 * </copyright>
 *
 * $Id: WidgetsValidator.java,v 1.1 2009/05/19 07:31:08 htraetteb Exp $
 */
package org.eclipse.e4.tm.widgets.util;

import java.util.Map;

import org.eclipse.e4.tm.widgets.*;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.e4.tm.widgets.WidgetsPackage
 * @generated
 */
public class WidgetsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final WidgetsValidator INSTANCE = new WidgetsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.e4.tm.widgets";

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
	public WidgetsValidator() {
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
	  return WidgetsPackage.eINSTANCE;
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
			case WidgetsPackage.CONTROL:
				return validateControl((Control)value, diagnostics, context);
			case WidgetsPackage.LABELED:
				return validateLabeled((Labeled)value, diagnostics, context);
			case WidgetsPackage.LABEL:
				return validateLabel((Label)value, diagnostics, context);
			case WidgetsPackage.TEXT:
				return validateText((Text)value, diagnostics, context);
			case WidgetsPackage.LIST:
				return validateList((List)value, diagnostics, context);
			case WidgetsPackage.SINGLE_SELECTION_LIST:
				return validateSingleSelectionList((SingleSelectionList)value, diagnostics, context);
			case WidgetsPackage.COMBO_BOX:
				return validateComboBox((ComboBox)value, diagnostics, context);
			case WidgetsPackage.MULTIPLE_SELECTION_LIST:
				return validateMultipleSelectionList((MultipleSelectionList)value, diagnostics, context);
			case WidgetsPackage.BROWSER:
				return validateBrowser((Browser)value, diagnostics, context);
			case WidgetsPackage.BUTTON:
				return validateButton((Button)value, diagnostics, context);
			case WidgetsPackage.PUSH_BUTTON:
				return validatePushButton((PushButton)value, diagnostics, context);
			case WidgetsPackage.CHECK_BOX:
				return validateCheckBox((CheckBox)value, diagnostics, context);
			case WidgetsPackage.TOGGLE_BUTTON:
				return validateToggleButton((ToggleButton)value, diagnostics, context);
			case WidgetsPackage.BOUNDED_VALUE_CONTROL:
				return validateBoundedValueControl((BoundedValueControl<?>)value, diagnostics, context);
			case WidgetsPackage.ABSTRACT_COMPOSITE:
				return validateAbstractComposite((AbstractComposite<?>)value, diagnostics, context);
			case WidgetsPackage.COMPOSITE:
				return validateComposite((Composite)value, diagnostics, context);
			case WidgetsPackage.GROUP_BOX:
				return validateGroupBox((GroupBox)value, diagnostics, context);
			case WidgetsPackage.TAB_FOLDER:
				return validateTabFolder((TabFolder)value, diagnostics, context);
			case WidgetsPackage.TAB:
				return validateTab((Tab)value, diagnostics, context);
			case WidgetsPackage.SHELL:
				return validateShell((Shell)value, diagnostics, context);
			case WidgetsPackage.SCRIPTED:
				return validateScripted((Scripted)value, diagnostics, context);
			case WidgetsPackage.RUNTIME_EVENT:
				return validateRuntimeEvent(value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateControl(Control control, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(control, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLabeled(Labeled labeled, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(labeled, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLabel(Label label, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(label, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateText(Text text, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(text, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateList(List list, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(list, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleSelectionList(SingleSelectionList singleSelectionList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(singleSelectionList, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComboBox(ComboBox comboBox, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(comboBox, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultipleSelectionList(MultipleSelectionList multipleSelectionList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(multipleSelectionList, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBrowser(Browser browser, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(browser, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateButton(Button button, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(button, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePushButton(PushButton pushButton, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pushButton, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCheckBox(CheckBox checkBox, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(checkBox, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateToggleButton(ToggleButton toggleButton, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(toggleButton, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBoundedValueControl(BoundedValueControl<?> boundedValueControl, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(boundedValueControl, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractComposite(AbstractComposite<?> abstractComposite, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(abstractComposite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractComposite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractComposite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractComposite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(abstractComposite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractComposite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractComposite, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractComposite_validControls(abstractComposite, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validControls constraint of '<em>Abstract Composite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateAbstractComposite_validControls(AbstractComposite<?> abstractComposite, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (! validateAbstractComposite_validControls(abstractComposite)) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "validControls", getObjectLabel(abstractComposite, context) },
						 new Object[] { abstractComposite },
						 context));
			}
			return false;
		}
		return true;
	}

	private boolean validateAbstractComposite_validControls(AbstractComposite<?> abstractComposite) {
		EClassifier specializedType = getSpecializedType(abstractComposite.eClass(), WidgetsPackage.eINSTANCE.getAbstractComposite());
		if (specializedType != null) {
			for (Control control : abstractComposite.getControls()) {
				if (! specializedType.isInstance(control)) {
					return false;
				}
			}
		}
		return true;
	}

	public static EClassifier getSpecializedType(EClass eClass, EClass parameterizedClass) {
		for (EGenericType genericType: eClass.getEGenericSuperTypes()) {
			if (genericType.getEClassifier() == parameterizedClass) {
				for (EGenericType typeParameter: genericType.getETypeArguments()) {
					return typeParameter.getEClassifier();
				}
			}
		}
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComposite(Composite composite, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(composite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(composite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(composite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(composite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(composite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(composite, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(composite, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractComposite_validControls(composite, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupBox(GroupBox groupBox, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(groupBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(groupBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(groupBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(groupBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(groupBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(groupBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(groupBox, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractComposite_validControls(groupBox, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTabFolder(TabFolder tabFolder, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(tabFolder, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tabFolder, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tabFolder, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(tabFolder, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(tabFolder, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(tabFolder, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tabFolder, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractComposite_validControls(tabFolder, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTab(Tab tab, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(tab, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tab, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tab, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(tab, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(tab, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(tab, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tab, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractComposite_validControls(tab, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShell(Shell shell, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(shell, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(shell, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(shell, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shell, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shell, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shell, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shell, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractComposite_validControls(shell, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScripted(Scripted scripted, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(scripted, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRuntimeEvent(Object runtimeEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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

} //WidgetsValidator
