/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.refactoring.roles.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAttributeEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleImplicationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleModelEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleProhibitionEditPart;
import org.emftext.language.refactoring.roles.diagram.part.RolesDiagramEditorPlugin;

/**
 * @generated
 */
public class RolesElementTypes {

	/**
	 * @generated
	 */
	private RolesElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType RoleModel_1000 = getElementType("org.emftext.language.refactoring.roles.diagram.RoleModel_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Role_2001 = getElementType("org.emftext.language.refactoring.roles.diagram.Role_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RoleAttribute_3001 = getElementType("org.emftext.language.refactoring.roles.diagram.RoleAttribute_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RoleImplication_4001 = getElementType("org.emftext.language.refactoring.roles.diagram.RoleImplication_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RoleProhibition_4002 = getElementType("org.emftext.language.refactoring.roles.diagram.RoleProhibition_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RoleAssociation_4003 = getElementType("org.emftext.language.refactoring.roles.diagram.RoleAssociation_4003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RoleComposition_4004 = getElementType("org.emftext.language.refactoring.roles.diagram.RoleComposition_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return RolesDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(RoleModel_1000, RolesPackage.eINSTANCE.getRoleModel());

			elements.put(Role_2001, RolesPackage.eINSTANCE.getRole());

			elements.put(RoleAttribute_3001, RolesPackage.eINSTANCE.getRoleAttribute());

			elements.put(RoleImplication_4001, RolesPackage.eINSTANCE.getRoleImplication());

			elements.put(RoleProhibition_4002, RolesPackage.eINSTANCE.getRoleProhibition());

			elements.put(RoleAssociation_4003, RolesPackage.eINSTANCE.getRoleAssociation());

			elements.put(RoleComposition_4004, RolesPackage.eINSTANCE.getRoleComposition());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(RoleModel_1000);
			KNOWN_ELEMENT_TYPES.add(Role_2001);
			KNOWN_ELEMENT_TYPES.add(RoleAttribute_3001);
			KNOWN_ELEMENT_TYPES.add(RoleImplication_4001);
			KNOWN_ELEMENT_TYPES.add(RoleProhibition_4002);
			KNOWN_ELEMENT_TYPES.add(RoleAssociation_4003);
			KNOWN_ELEMENT_TYPES.add(RoleComposition_4004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case RoleModelEditPart.VISUAL_ID:
			return RoleModel_1000;
		case RoleEditPart.VISUAL_ID:
			return Role_2001;
		case RoleAttributeEditPart.VISUAL_ID:
			return RoleAttribute_3001;
		case RoleImplicationEditPart.VISUAL_ID:
			return RoleImplication_4001;
		case RoleProhibitionEditPart.VISUAL_ID:
			return RoleProhibition_4002;
		case RoleAssociationEditPart.VISUAL_ID:
			return RoleAssociation_4003;
		case RoleCompositionEditPart.VISUAL_ID:
			return RoleComposition_4004;
		}
		return null;
	}

}
