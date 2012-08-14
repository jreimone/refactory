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
package org.emftext.language.refactoring.roles.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAssociation;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleProhibition;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAttributeEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleImplicationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleModelEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleProhibitionEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleRoleAttributeCompartmentEditPart;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;

/**
 * @generated
 */
public class RolesDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<RolesNodeDescriptor> getSemanticChildren(View view) {
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleModelEditPart.VISUAL_ID:
			return getRoleModel_1000SemanticChildren(view);
		case RoleRoleAttributeCompartmentEditPart.VISUAL_ID:
			return getRoleAttributeCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesNodeDescriptor> getRoleAttributeCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Role modelElement = (Role) containerView.getElement();
		LinkedList<RolesNodeDescriptor> result = new LinkedList<RolesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getAttributes().iterator(); it.hasNext();) {
			RoleAttribute childElement = (RoleAttribute) it.next();
			int visualID = RolesVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RoleAttributeEditPart.VISUAL_ID) {
				result.add(new RolesNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RolesNodeDescriptor> getRoleModel_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RoleModel modelElement = (RoleModel) view.getElement();
		LinkedList<RolesNodeDescriptor> result = new LinkedList<RolesNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRoles().iterator(); it.hasNext();) {
			Role childElement = (Role) it.next();
			int visualID = RolesVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RoleEditPart.VISUAL_ID) {
				result.add(new RolesNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getContainedLinks(View view) {
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleModelEditPart.VISUAL_ID:
			return getRoleModel_1000ContainedLinks(view);
		case RoleEditPart.VISUAL_ID:
			return getRole_2001ContainedLinks(view);
		case RoleAttributeEditPart.VISUAL_ID:
			return getRoleAttribute_3001ContainedLinks(view);
		case RoleImplicationEditPart.VISUAL_ID:
			return getRoleImplication_4001ContainedLinks(view);
		case RoleProhibitionEditPart.VISUAL_ID:
			return getRoleProhibition_4002ContainedLinks(view);
		case RoleAssociationEditPart.VISUAL_ID:
			return getRoleAssociation_4003ContainedLinks(view);
		case RoleCompositionEditPart.VISUAL_ID:
			return getRoleComposition_4004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getIncomingLinks(View view) {
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleEditPart.VISUAL_ID:
			return getRole_2001IncomingLinks(view);
		case RoleAttributeEditPart.VISUAL_ID:
			return getRoleAttribute_3001IncomingLinks(view);
		case RoleImplicationEditPart.VISUAL_ID:
			return getRoleImplication_4001IncomingLinks(view);
		case RoleProhibitionEditPart.VISUAL_ID:
			return getRoleProhibition_4002IncomingLinks(view);
		case RoleAssociationEditPart.VISUAL_ID:
			return getRoleAssociation_4003IncomingLinks(view);
		case RoleCompositionEditPart.VISUAL_ID:
			return getRoleComposition_4004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getOutgoingLinks(View view) {
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleEditPart.VISUAL_ID:
			return getRole_2001OutgoingLinks(view);
		case RoleAttributeEditPart.VISUAL_ID:
			return getRoleAttribute_3001OutgoingLinks(view);
		case RoleImplicationEditPart.VISUAL_ID:
			return getRoleImplication_4001OutgoingLinks(view);
		case RoleProhibitionEditPart.VISUAL_ID:
			return getRoleProhibition_4002OutgoingLinks(view);
		case RoleAssociationEditPart.VISUAL_ID:
			return getRoleAssociation_4003OutgoingLinks(view);
		case RoleCompositionEditPart.VISUAL_ID:
			return getRoleComposition_4004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleModel_1000ContainedLinks(View view) {
		RoleModel modelElement = (RoleModel) view.getElement();
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_RoleImplication_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_RoleProhibition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_RoleAssociation_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_RoleComposition_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRole_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleAttribute_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleImplication_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleProhibition_4002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleAssociation_4003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleComposition_4004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRole_2001IncomingLinks(View view) {
		Role modelElement = (Role) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_RoleImplication_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_RoleProhibition_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_RoleAssociation_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_RoleComposition_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleAttribute_3001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleImplication_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleProhibition_4002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleAssociation_4003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleComposition_4004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRole_2001OutgoingLinks(View view) {
		Role modelElement = (Role) view.getElement();
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_RoleImplication_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_RoleProhibition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_RoleAssociation_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_RoleComposition_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleAttribute_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleImplication_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleProhibition_4002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleAssociation_4003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RolesLinkDescriptor> getRoleComposition_4004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getContainedTypeModelFacetLinks_RoleImplication_4001(RoleModel container) {
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		for (Iterator<?> links = container.getCollaborations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleImplication) {
				continue;
			}
			RoleImplication link = (RoleImplication) linkObject;
			if (RoleImplicationEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, dst, link, RolesElementTypes.RoleImplication_4001, RoleImplicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getContainedTypeModelFacetLinks_RoleProhibition_4002(RoleModel container) {
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		for (Iterator<?> links = container.getCollaborations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleProhibition) {
				continue;
			}
			RoleProhibition link = (RoleProhibition) linkObject;
			if (RoleProhibitionEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, dst, link, RolesElementTypes.RoleProhibition_4002, RoleProhibitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getContainedTypeModelFacetLinks_RoleAssociation_4003(RoleModel container) {
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		for (Iterator<?> links = container.getCollaborations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleAssociation) {
				continue;
			}
			RoleAssociation link = (RoleAssociation) linkObject;
			if (RoleAssociationEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, dst, link, RolesElementTypes.RoleAssociation_4003, RoleAssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getContainedTypeModelFacetLinks_RoleComposition_4004(RoleModel container) {
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		for (Iterator<?> links = container.getCollaborations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleComposition) {
				continue;
			}
			RoleComposition link = (RoleComposition) linkObject;
			if (RoleCompositionEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, dst, link, RolesElementTypes.RoleComposition_4004, RoleCompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getIncomingTypeModelFacetLinks_RoleImplication_4001(Role target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RolesPackage.eINSTANCE.getCollaboration_Target()
					|| false == setting.getEObject() instanceof RoleImplication) {
				continue;
			}
			RoleImplication link = (RoleImplication) setting.getEObject();
			if (RoleImplicationEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, target, link, RolesElementTypes.RoleImplication_4001, RoleImplicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getIncomingTypeModelFacetLinks_RoleProhibition_4002(Role target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RolesPackage.eINSTANCE.getCollaboration_Target()
					|| false == setting.getEObject() instanceof RoleProhibition) {
				continue;
			}
			RoleProhibition link = (RoleProhibition) setting.getEObject();
			if (RoleProhibitionEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, target, link, RolesElementTypes.RoleProhibition_4002, RoleProhibitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getIncomingTypeModelFacetLinks_RoleAssociation_4003(Role target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RolesPackage.eINSTANCE.getCollaboration_Target()
					|| false == setting.getEObject() instanceof RoleAssociation) {
				continue;
			}
			RoleAssociation link = (RoleAssociation) setting.getEObject();
			if (RoleAssociationEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, target, link, RolesElementTypes.RoleAssociation_4003, RoleAssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getIncomingTypeModelFacetLinks_RoleComposition_4004(Role target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RolesPackage.eINSTANCE.getCollaboration_Target()
					|| false == setting.getEObject() instanceof RoleComposition) {
				continue;
			}
			RoleComposition link = (RoleComposition) setting.getEObject();
			if (RoleCompositionEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, target, link, RolesElementTypes.RoleComposition_4004, RoleCompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getOutgoingTypeModelFacetLinks_RoleImplication_4001(Role source) {
		RoleModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof RoleModel) {
				container = (RoleModel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		for (Iterator<?> links = container.getCollaborations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleImplication) {
				continue;
			}
			RoleImplication link = (RoleImplication) linkObject;
			if (RoleImplicationEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new RolesLinkDescriptor(src, dst, link, RolesElementTypes.RoleImplication_4001, RoleImplicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getOutgoingTypeModelFacetLinks_RoleProhibition_4002(Role source) {
		RoleModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof RoleModel) {
				container = (RoleModel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		for (Iterator<?> links = container.getCollaborations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleProhibition) {
				continue;
			}
			RoleProhibition link = (RoleProhibition) linkObject;
			if (RoleProhibitionEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new RolesLinkDescriptor(src, dst, link, RolesElementTypes.RoleProhibition_4002, RoleProhibitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getOutgoingTypeModelFacetLinks_RoleAssociation_4003(Role source) {
		RoleModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof RoleModel) {
				container = (RoleModel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		for (Iterator<?> links = container.getCollaborations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleAssociation) {
				continue;
			}
			RoleAssociation link = (RoleAssociation) linkObject;
			if (RoleAssociationEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new RolesLinkDescriptor(src, dst, link, RolesElementTypes.RoleAssociation_4003, RoleAssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RolesLinkDescriptor> getOutgoingTypeModelFacetLinks_RoleComposition_4004(Role source) {
		RoleModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof RoleModel) {
				container = (RoleModel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<RolesLinkDescriptor> result = new LinkedList<RolesLinkDescriptor>();
		for (Iterator<?> links = container.getCollaborations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleComposition) {
				continue;
			}
			RoleComposition link = (RoleComposition) linkObject;
			if (RoleCompositionEditPart.VISUAL_ID != RolesVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new RolesLinkDescriptor(src, dst, link, RolesElementTypes.RoleComposition_4004, RoleCompositionEditPart.VISUAL_ID));
		}
		return result;
	}

}
