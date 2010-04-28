/*******************************************************************************
 * Copyright (c) 2008 Hallvard Traetteberg.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Hallvard Traetteberg - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id: WidgetsPackageImpl.java,v 1.5 2009/06/25 11:38:56 htraetteb Exp $
 */
package org.eclipse.e4.tm.widgets.impl;

import org.eclipse.e4.tm.layouts.LayoutsPackage;
import org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl;
import org.eclipse.e4.tm.styles.StylesPackage;
import org.eclipse.e4.tm.styles.impl.StylesPackageImpl;
import org.eclipse.e4.tm.util.UtilPackage;
import org.eclipse.e4.tm.util.impl.UtilPackageImpl;
import org.eclipse.e4.tm.widgets.AbstractComposite;
import org.eclipse.e4.tm.widgets.BoundedValueControl;
import org.eclipse.e4.tm.widgets.Browser;
import org.eclipse.e4.tm.widgets.Button;
import org.eclipse.e4.tm.widgets.CheckBox;
import org.eclipse.e4.tm.widgets.ComboBox;
import org.eclipse.e4.tm.widgets.Composite;
import org.eclipse.e4.tm.widgets.Control;
import org.eclipse.e4.tm.widgets.GroupBox;
import org.eclipse.e4.tm.widgets.Label;
import org.eclipse.e4.tm.widgets.Labeled;
import org.eclipse.e4.tm.widgets.List;
import org.eclipse.e4.tm.widgets.MultipleSelectionList;
import org.eclipse.e4.tm.widgets.PushButton;
import org.eclipse.e4.tm.widgets.Scripted;
import org.eclipse.e4.tm.widgets.Shell;
import org.eclipse.e4.tm.widgets.SingleSelectionList;
import org.eclipse.e4.tm.widgets.Tab;
import org.eclipse.e4.tm.widgets.TabFolder;
import org.eclipse.e4.tm.widgets.Text;
import org.eclipse.e4.tm.widgets.ToggleButton;
import org.eclipse.e4.tm.widgets.WidgetsFactory;
import org.eclipse.e4.tm.widgets.WidgetsPackage;
import org.eclipse.e4.tm.widgets.util.WidgetsValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WidgetsPackageImpl extends EPackageImpl implements WidgetsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labeledEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleSelectionListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comboBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleSelectionListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass browserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buttonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushButtonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toggleButtonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundedValueControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractCompositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tabFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType runtimeEventEDataType = null;

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
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WidgetsPackageImpl() {
		super(eNS_URI, WidgetsFactory.eINSTANCE);
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
	public static WidgetsPackage init() {
		if (isInited) return (WidgetsPackage)EPackage.Registry.INSTANCE.getEPackage(WidgetsPackage.eNS_URI);

		// Obtain or create and register package
		WidgetsPackageImpl theWidgetsPackage = (WidgetsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WidgetsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WidgetsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		StylesPackageImpl theStylesPackage = (StylesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI) instanceof StylesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI) : StylesPackage.eINSTANCE);
		LayoutsPackageImpl theLayoutsPackage = (LayoutsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LayoutsPackage.eNS_URI) instanceof LayoutsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LayoutsPackage.eNS_URI) : LayoutsPackage.eINSTANCE);
		UtilPackageImpl theUtilPackage = (UtilPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) : UtilPackage.eINSTANCE);

		// Create package meta-data objects
		theWidgetsPackage.createPackageContents();
		theStylesPackage.createPackageContents();
		theLayoutsPackage.createPackageContents();
		theUtilPackage.createPackageContents();

		// Initialize created meta-data
		theWidgetsPackage.initializePackageContents();
		theStylesPackage.initializePackageContents();
		theLayoutsPackage.initializePackageContents();
		theUtilPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theWidgetsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return WidgetsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theWidgetsPackage.freeze();

		return theWidgetsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControl() {
		return controlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControl_Composite() {
		return (EReference)controlEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControl_Enabled() {
		return (EAttribute)controlEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControl_Visible() {
		return (EAttribute)controlEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControl_LayoutData() {
		return (EReference)controlEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControl_DataObject() {
		return (EAttribute)controlEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabeled() {
		return labeledEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabeled_Text() {
		return (EAttribute)labeledEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabel() {
		return labelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getText() {
		return textEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getText_Editable() {
		return (EAttribute)textEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getText_Modify() {
		return (EAttribute)textEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getText_KeyUp() {
		return (EAttribute)textEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getText_Text() {
		return (EAttribute)textEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getList() {
		return listEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getList_Items() {
		return (EAttribute)listEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getList_SelectionEvent() {
		return (EAttribute)listEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getList_SelectionIndex() {
		return (EAttribute)listEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getList_SelectionIndices() {
		return (EAttribute)listEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleSelectionList() {
		return singleSelectionListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComboBox() {
		return comboBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultipleSelectionList() {
		return multipleSelectionListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBrowser() {
		return browserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBrowser_Location() {
		return (EAttribute)browserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBrowser_Url() {
		return (EAttribute)browserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBrowser_Text() {
		return (EAttribute)browserEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getButton() {
		return buttonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getButton_SelectionEvent() {
		return (EAttribute)buttonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPushButton() {
		return pushButtonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckBox() {
		return checkBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckBox_Selection() {
		return (EAttribute)checkBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToggleButton() {
		return toggleButtonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToggleButton_Selection() {
		return (EAttribute)toggleButtonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundedValueControl() {
		return boundedValueControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundedValueControl_Minimum() {
		return (EAttribute)boundedValueControlEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundedValueControl_Maximum() {
		return (EAttribute)boundedValueControlEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundedValueControl_ValueEvent() {
		return (EAttribute)boundedValueControlEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundedValueControl_Value() {
		return (EAttribute)boundedValueControlEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractComposite() {
		return abstractCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractComposite_Controls() {
		return (EReference)abstractCompositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractComposite_Styles() {
		return (EReference)abstractCompositeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractComposite_Layout() {
		return (EReference)abstractCompositeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComposite() {
		return compositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupBox() {
		return groupBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTabFolder() {
		return tabFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTabFolder_SelectionEvent() {
		return (EAttribute)tabFolderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTabFolder_SelectionIndex() {
		return (EAttribute)tabFolderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTab() {
		return tabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShell() {
		return shellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScripted() {
		return scriptedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScripted_ScriptSource() {
		return (EAttribute)scriptedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRuntimeEvent() {
		return runtimeEventEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetsFactory getWidgetsFactory() {
		return (WidgetsFactory)getEFactoryInstance();
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
		controlEClass = createEClass(CONTROL);
		createEAttribute(controlEClass, CONTROL__DATA_OBJECT);
		createEReference(controlEClass, CONTROL__COMPOSITE);
		createEAttribute(controlEClass, CONTROL__ENABLED);
		createEAttribute(controlEClass, CONTROL__VISIBLE);
		createEReference(controlEClass, CONTROL__LAYOUT_DATA);

		labeledEClass = createEClass(LABELED);
		createEAttribute(labeledEClass, LABELED__TEXT);

		labelEClass = createEClass(LABEL);

		textEClass = createEClass(TEXT);
		createEAttribute(textEClass, TEXT__EDITABLE);
		createEAttribute(textEClass, TEXT__MODIFY);
		createEAttribute(textEClass, TEXT__KEY_UP);
		createEAttribute(textEClass, TEXT__TEXT);

		listEClass = createEClass(LIST);
		createEAttribute(listEClass, LIST__ITEMS);
		createEAttribute(listEClass, LIST__SELECTION_EVENT);
		createEAttribute(listEClass, LIST__SELECTION_INDEX);
		createEAttribute(listEClass, LIST__SELECTION_INDICES);

		singleSelectionListEClass = createEClass(SINGLE_SELECTION_LIST);

		comboBoxEClass = createEClass(COMBO_BOX);

		multipleSelectionListEClass = createEClass(MULTIPLE_SELECTION_LIST);

		browserEClass = createEClass(BROWSER);
		createEAttribute(browserEClass, BROWSER__LOCATION);
		createEAttribute(browserEClass, BROWSER__URL);
		createEAttribute(browserEClass, BROWSER__TEXT);

		buttonEClass = createEClass(BUTTON);
		createEAttribute(buttonEClass, BUTTON__SELECTION_EVENT);

		pushButtonEClass = createEClass(PUSH_BUTTON);

		checkBoxEClass = createEClass(CHECK_BOX);
		createEAttribute(checkBoxEClass, CHECK_BOX__SELECTION);

		toggleButtonEClass = createEClass(TOGGLE_BUTTON);
		createEAttribute(toggleButtonEClass, TOGGLE_BUTTON__SELECTION);

		boundedValueControlEClass = createEClass(BOUNDED_VALUE_CONTROL);
		createEAttribute(boundedValueControlEClass, BOUNDED_VALUE_CONTROL__MINIMUM);
		createEAttribute(boundedValueControlEClass, BOUNDED_VALUE_CONTROL__MAXIMUM);
		createEAttribute(boundedValueControlEClass, BOUNDED_VALUE_CONTROL__VALUE_EVENT);
		createEAttribute(boundedValueControlEClass, BOUNDED_VALUE_CONTROL__VALUE);

		abstractCompositeEClass = createEClass(ABSTRACT_COMPOSITE);
		createEReference(abstractCompositeEClass, ABSTRACT_COMPOSITE__CONTROLS);
		createEReference(abstractCompositeEClass, ABSTRACT_COMPOSITE__STYLES);
		createEReference(abstractCompositeEClass, ABSTRACT_COMPOSITE__LAYOUT);

		compositeEClass = createEClass(COMPOSITE);

		groupBoxEClass = createEClass(GROUP_BOX);

		tabFolderEClass = createEClass(TAB_FOLDER);
		createEAttribute(tabFolderEClass, TAB_FOLDER__SELECTION_EVENT);
		createEAttribute(tabFolderEClass, TAB_FOLDER__SELECTION_INDEX);

		tabEClass = createEClass(TAB);

		shellEClass = createEClass(SHELL);

		scriptedEClass = createEClass(SCRIPTED);
		createEAttribute(scriptedEClass, SCRIPTED__SCRIPT_SOURCE);

		// Create data types
		runtimeEventEDataType = createEDataType(RUNTIME_EVENT);
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
		StylesPackage theStylesPackage = (StylesPackage)EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI);
		LayoutsPackage theLayoutsPackage = (LayoutsPackage)EPackage.Registry.INSTANCE.getEPackage(LayoutsPackage.eNS_URI);
		UtilPackage theUtilPackage = (UtilPackage)EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);

		// Create type parameters
		ETypeParameter boundedValueControlEClass_T = addETypeParameter(boundedValueControlEClass, "T");
		ETypeParameter abstractCompositeEClass_T = addETypeParameter(abstractCompositeEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getControl());
		abstractCompositeEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		controlEClass.getESuperTypes().add(theStylesPackage.getStyled());
		controlEClass.getESuperTypes().add(this.getScripted());
		labelEClass.getESuperTypes().add(this.getControl());
		labelEClass.getESuperTypes().add(this.getLabeled());
		textEClass.getESuperTypes().add(this.getControl());
		listEClass.getESuperTypes().add(this.getControl());
		singleSelectionListEClass.getESuperTypes().add(this.getList());
		comboBoxEClass.getESuperTypes().add(this.getList());
		comboBoxEClass.getESuperTypes().add(this.getText());
		multipleSelectionListEClass.getESuperTypes().add(this.getList());
		browserEClass.getESuperTypes().add(this.getControl());
		buttonEClass.getESuperTypes().add(this.getControl());
		buttonEClass.getESuperTypes().add(this.getLabeled());
		pushButtonEClass.getESuperTypes().add(this.getButton());
		checkBoxEClass.getESuperTypes().add(this.getButton());
		toggleButtonEClass.getESuperTypes().add(this.getButton());
		boundedValueControlEClass.getESuperTypes().add(this.getControl());
		abstractCompositeEClass.getESuperTypes().add(this.getControl());
		g1 = createEGenericType(this.getAbstractComposite());
		EGenericType g2 = createEGenericType(this.getControl());
		g1.getETypeArguments().add(g2);
		compositeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAbstractComposite());
		g2 = createEGenericType(this.getControl());
		g1.getETypeArguments().add(g2);
		groupBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLabeled());
		groupBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAbstractComposite());
		g2 = createEGenericType(this.getTab());
		g1.getETypeArguments().add(g2);
		tabFolderEClass.getEGenericSuperTypes().add(g1);
		tabEClass.getESuperTypes().add(this.getComposite());
		tabEClass.getESuperTypes().add(this.getLabeled());
		g1 = createEGenericType(this.getAbstractComposite());
		g2 = createEGenericType(this.getControl());
		g1.getETypeArguments().add(g2);
		shellEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(controlEClass, Control.class, "Control", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getControl_DataObject(), ecorePackage.getEJavaObject(), "dataObject", null, 0, 1, Control.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getAbstractComposite());
		g2 = createEGenericType(this.getControl());
		g1.getETypeArguments().add(g2);
		initEReference(getControl_Composite(), g1, this.getAbstractComposite_Controls(), "composite", null, 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getControl_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getControl_Visible(), ecorePackage.getEBoolean(), "visible", "true", 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getControl_LayoutData(), theLayoutsPackage.getLayoutData(), null, "layoutData", null, 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(labeledEClass, Labeled.class, "Labeled", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLabeled_Text(), ecorePackage.getEString(), "text", null, 0, 1, Labeled.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(labelEClass, Label.class, "Label", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getText_Editable(), ecorePackage.getEBoolean(), "editable", "true", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getText_Modify(), this.getRuntimeEvent(), "modify", null, 0, 1, Text.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getText_KeyUp(), this.getRuntimeEvent(), "keyUp", null, 0, 1, Text.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getText_Text(), ecorePackage.getEString(), "text", "", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listEClass, List.class, "List", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getList_Items(), ecorePackage.getEString(), "items", null, 0, -1, List.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getList_SelectionEvent(), this.getRuntimeEvent(), "selectionEvent", null, 0, 1, List.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getList_SelectionIndex(), ecorePackage.getEInt(), "selectionIndex", "-1", 0, 1, List.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getList_SelectionIndices(), ecorePackage.getEInt(), "selectionIndices", null, 0, -1, List.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleSelectionListEClass, SingleSelectionList.class, "SingleSelectionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(comboBoxEClass, ComboBox.class, "ComboBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multipleSelectionListEClass, MultipleSelectionList.class, "MultipleSelectionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(browserEClass, Browser.class, "Browser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBrowser_Location(), this.getRuntimeEvent(), "location", null, 0, 1, Browser.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBrowser_Url(), theUtilPackage.getLimitedString(), "url", null, 0, 1, Browser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBrowser_Text(), ecorePackage.getEString(), "text", null, 0, 1, Browser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(buttonEClass, Button.class, "Button", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getButton_SelectionEvent(), this.getRuntimeEvent(), "selectionEvent", null, 0, 1, Button.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pushButtonEClass, PushButton.class, "PushButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(checkBoxEClass, CheckBox.class, "CheckBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCheckBox_Selection(), ecorePackage.getEBoolean(), "selection", null, 0, 1, CheckBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toggleButtonEClass, ToggleButton.class, "ToggleButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToggleButton_Selection(), ecorePackage.getEBoolean(), "selection", null, 0, 1, ToggleButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boundedValueControlEClass, BoundedValueControl.class, "BoundedValueControl", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(boundedValueControlEClass_T);
		initEAttribute(getBoundedValueControl_Minimum(), g1, "minimum", null, 0, 1, BoundedValueControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(boundedValueControlEClass_T);
		initEAttribute(getBoundedValueControl_Maximum(), g1, "maximum", null, 0, 1, BoundedValueControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundedValueControl_ValueEvent(), this.getRuntimeEvent(), "valueEvent", null, 0, 1, BoundedValueControl.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(boundedValueControlEClass_T);
		initEAttribute(getBoundedValueControl_Value(), g1, "value", null, 0, 1, BoundedValueControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractCompositeEClass, AbstractComposite.class, "AbstractComposite", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(abstractCompositeEClass_T);
		initEReference(getAbstractComposite_Controls(), g1, this.getControl_Composite(), "controls", null, 0, -1, AbstractComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractComposite_Styles(), theStylesPackage.getStyle(), null, "styles", null, 0, -1, AbstractComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theLayoutsPackage.getLayout());
		g2 = createEGenericType(theLayoutsPackage.getLayoutData());
		g1.getETypeArguments().add(g2);
		initEReference(getAbstractComposite_Layout(), g1, null, "layout", null, 0, 1, AbstractComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeEClass, Composite.class, "Composite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(groupBoxEClass, GroupBox.class, "GroupBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tabFolderEClass, TabFolder.class, "TabFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTabFolder_SelectionEvent(), this.getRuntimeEvent(), "selectionEvent", null, 0, 1, TabFolder.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTabFolder_SelectionIndex(), ecorePackage.getEInt(), "selectionIndex", "-1", 0, 1, TabFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tabEClass, Tab.class, "Tab", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shellEClass, Shell.class, "Shell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scriptedEClass, Scripted.class, "Scripted", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScripted_ScriptSource(), ecorePackage.getEString(), "scriptSource", null, 0, 1, Scripted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(runtimeEventEDataType, Object.class, "RuntimeEvent", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/e4/swt.ecore
		createSwtAnnotations();
		// http://www.eclipse.org/e4/swt.ecore#ComboBox
		createSwt_1Annotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/e4/emf/ecore/javascript/scriptSourceFeature
		createScriptSourceFeatureAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/e4/swt.ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSwtAnnotations() {
		String source = "http://www.eclipse.org/e4/swt.ecore";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "javaPackage", "org.eclipse.swt.widgets"
		   });		
		addAnnotation
		  (controlEClass, 
		   source, 
		   new String[] {
			 "access", "property"
		   });		
		addAnnotation
		  (getControl_DataObject(), 
		   source, 
		   new String[] {
			 "access", "binder"
		   });		
		addAnnotation
		  (labeledEClass, 
		   source, 
		   new String[] {
			 "access", "property"
		   });			
		addAnnotation
		  (getText_Modify(), 
		   source, 
		   new String[] {
			 "access", "event",
			 "invalidates", "text",
			 "realName", "Modify"
		   });		
		addAnnotation
		  (getText_KeyUp(), 
		   source, 
		   new String[] {
			 "access", "event"
		   });		
		addAnnotation
		  (getText_Text(), 
		   source, 
		   new String[] {
			 "invalidatedBy", "modify"
		   });		
		addAnnotation
		  (listEClass, 
		   source, 
		   new String[] {
			 "javaClass", "List"
		   });		
		addAnnotation
		  (getList_SelectionEvent(), 
		   source, 
		   new String[] {
			 "realName", "Selection",
			 "access", "event",
			 "invalidates", "selectionIndex selectionIndices"
		   });		
		addAnnotation
		  (getList_SelectionIndex(), 
		   source, 
		   new String[] {
			 "access", "getSelectionIndex setSelection(int)",
			 "invalidatedBy", "selectionEvent"
		   });			
		addAnnotation
		  (getList_SelectionIndices(), 
		   source, 
		   new String[] {
			 "access", "getSelectionIndices setSelection(int[])",
			 "invalidatedBy", "selection"
		   });			
		addAnnotation
		  (singleSelectionListEClass, 
		   source, 
		   new String[] {
			 "style", "SINGLE"
		   });		
		addAnnotation
		  (comboBoxEClass, 
		   source, 
		   new String[] {
			 "javaPackage", "org.eclipse.swt.custom",
				"realName", "CCombo"
		   });		
		addAnnotation
		  (multipleSelectionListEClass, 
		   source, 
		   new String[] {
			 "style", "MULTI"
		   });		
		addAnnotation
		  (browserEClass, 
		   source, 
		   new String[] {
			 "javaPackage", "org.eclipse.swt.browser"
		   });		
		addAnnotation
		  (getBrowser_Location(), 
		   source, 
		   new String[] {
			 "access", "event",
			 "invalidates", "url text"
		   });		
		addAnnotation
		  (getBrowser_Url(), 
		   source, 
		   new String[] {
			 "access", "property",
			 "invalidatedBy", "location"
		   });		
		addAnnotation
		  (getBrowser_Text(), 
		   source, 
		   new String[] {
			 "access", "property",
			 "invalidatedBy", "location"
		   });		
		addAnnotation
		  (buttonEClass, 
		   source, 
		   new String[] {
			 "javaClass", "Button"
		   });		
		addAnnotation
		  (getButton_SelectionEvent(), 
		   source, 
		   new String[] {
			 "realName", "Selection",
			 "access", "event",
			 "invalidates", "selection"
		   });		
		addAnnotation
		  (pushButtonEClass, 
		   source, 
		   new String[] {
			 "style", "PUSH"
		   });		
		addAnnotation
		  (checkBoxEClass, 
		   source, 
		   new String[] {
			 "style", "CHECK"
		   });		
		addAnnotation
		  (getCheckBox_Selection(), 
		   source, 
		   new String[] {
			 "invalidatedBy", "selectionEvent"
		   });		
		addAnnotation
		  (toggleButtonEClass, 
		   source, 
		   new String[] {
			 "style", "TOGGLE"
		   });		
		addAnnotation
		  (getToggleButton_Selection(), 
		   source, 
		   new String[] {
			 "invalidatedBy", "selectionEvent"
		   });		
		addAnnotation
		  (getBoundedValueControl_ValueEvent(), 
		   source, 
		   new String[] {
			 "realName", "Selection",
			 "access", "event",
			 "invalidates", "value"
		   });		
		addAnnotation
		  (getBoundedValueControl_Value(), 
		   source, 
		   new String[] {
			 "realName", "selection",
			 "invalidatedBy", "selectionEvent"
		   });			
		addAnnotation
		  (getAbstractComposite_Controls(), 
		   source, 
		   new String[] {
			 "access", "binder"
		   });		
		addAnnotation
		  (getAbstractComposite_Styles(), 
		   source, 
		   new String[] {
			 "access", "binder"
		   });		
		addAnnotation
		  (compositeEClass, 
		   source, 
		   new String[] {
			 "javaClass", "Composite"
		   });		
		addAnnotation
		  (groupBoxEClass, 
		   source, 
		   new String[] {
			 "realName", "Group"
		   });		
		addAnnotation
		  (getTabFolder_SelectionEvent(), 
		   source, 
		   new String[] {
			 "realName", "Selection",
			 "access", "event",
			 "invalidates", "selectionIndex"
		   });		
		addAnnotation
		  (getTabFolder_SelectionIndex(), 
		   source, 
		   new String[] {
			 "access", "getSelectionIndex setSelection(int)",
			 "invalidatedBy", "selectionEvent"
		   });			
		addAnnotation
		  (getScripted_ScriptSource(), 
		   source, 
		   new String[] {
			 "access", "binder"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/e4/swt.ecore#ComboBox</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSwt_1Annotations() {
		String source = "http://www.eclipse.org/e4/swt.ecore#ComboBox";						
		addAnnotation
		  (getText_Editable(), 
		   source, 
		   new String[] {
			 "access", ""
		   });								
		addAnnotation
		  (getList_SelectionIndex(), 
		   source, 
		   new String[] {
			 "access", "getSelectionIndex select(int)"
		   });			
		addAnnotation
		  (getList_SelectionIndices(), 
		   source, 
		   new String[] {
			 "access", ""
		   });																									
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";																																
		addAnnotation
		  (abstractCompositeEClass, 
		   source, 
		   new String[] {
			 "constraints", "validControls"
		   });								
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/e4/emf/ecore/javascript/scriptSourceFeature</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createScriptSourceFeatureAnnotations() {
		String source = "http://www.eclipse.org/e4/emf/ecore/javascript/scriptSourceFeature";																																							
		addAnnotation
		  (getScripted_ScriptSource(), 
		   source, 
		   new String[] {
			 "js", "eval, listen"
		   });	
	}

} //WidgetsPackageImpl
