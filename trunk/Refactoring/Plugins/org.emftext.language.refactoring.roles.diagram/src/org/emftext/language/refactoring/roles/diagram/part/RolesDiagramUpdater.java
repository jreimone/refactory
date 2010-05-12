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
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleProhibition;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleImplicationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleModelEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleProhibitionEditPart;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;

/**
 * @generated
 */
public class RolesDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleModelEditPart.VISUAL_ID:
			return getRoleModel_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleModel_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		RoleModel modelElement = (RoleModel) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getRoles().iterator(); it.hasNext();) {
			Role childElement = (Role) it.next();
			int visualID = RolesVisualIDRegistry.getNodeVisualID(view,
					childElement);
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
	public static List getContainedLinks(View view) {
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleModelEditPart.VISUAL_ID:
			return getRoleModel_1000ContainedLinks(view);
		case RoleEditPart.VISUAL_ID:
			return getRole_2001ContainedLinks(view);
		case RoleImplicationEditPart.VISUAL_ID:
			return getRoleImplication_4001ContainedLinks(view);
		case RoleProhibitionEditPart.VISUAL_ID:
			return getRoleProhibition_4002ContainedLinks(view);
		case RoleAssociationEditPart.VISUAL_ID:
			return getRoleAssociation_4003ContainedLinks(view);
		case RoleCompositionEditPart.VISUAL_ID:
			return getRoleComposition_4004ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleEditPart.VISUAL_ID:
			return getRole_2001IncomingLinks(view);
		case RoleImplicationEditPart.VISUAL_ID:
			return getRoleImplication_4001IncomingLinks(view);
		case RoleProhibitionEditPart.VISUAL_ID:
			return getRoleProhibition_4002IncomingLinks(view);
		case RoleAssociationEditPart.VISUAL_ID:
			return getRoleAssociation_4003IncomingLinks(view);
		case RoleCompositionEditPart.VISUAL_ID:
			return getRoleComposition_4004IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleEditPart.VISUAL_ID:
			return getRole_2001OutgoingLinks(view);
		case RoleImplicationEditPart.VISUAL_ID:
			return getRoleImplication_4001OutgoingLinks(view);
		case RoleProhibitionEditPart.VISUAL_ID:
			return getRoleProhibition_4002OutgoingLinks(view);
		case RoleAssociationEditPart.VISUAL_ID:
			return getRoleAssociation_4003OutgoingLinks(view);
		case RoleCompositionEditPart.VISUAL_ID:
			return getRoleComposition_4004OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleModel_1000ContainedLinks(View view) {
		RoleModel modelElement = (RoleModel) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_RoleImplication_4001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RoleProhibition_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RoleAssociation_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RoleComposition_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRole_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleImplication_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleProhibition_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleAssociation_4003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleComposition_4004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRole_2001IncomingLinks(View view) {
		Role modelElement = (Role) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_RoleImplication_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_RoleProhibition_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_RoleAssociation_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_RoleComposition_4004(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRoleImplication_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleProhibition_4002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleAssociation_4003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleComposition_4004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRole_2001OutgoingLinks(View view) {
		Role modelElement = (Role) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_RoleImplication_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_RoleProhibition_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_RoleAssociation_4003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_RoleComposition_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRoleImplication_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleProhibition_4002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleAssociation_4003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoleComposition_4004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_RoleImplication_4001(
			RoleModel container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getCollaborations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleImplication) {
				continue;
			}
			RoleImplication link = (RoleImplication) linkObject;
			if (RoleImplicationEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, dst, link,
					RolesElementTypes.RoleImplication_4001,
					RoleImplicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_RoleProhibition_4002(
			RoleModel container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getCollaborations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleProhibition) {
				continue;
			}
			RoleProhibition link = (RoleProhibition) linkObject;
			if (RoleProhibitionEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, dst, link,
					RolesElementTypes.RoleProhibition_4002,
					RoleProhibitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_RoleAssociation_4003(
			RoleModel container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getCollaborations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleAssociation) {
				continue;
			}
			RoleAssociation link = (RoleAssociation) linkObject;
			if (RoleAssociationEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, dst, link,
					RolesElementTypes.RoleAssociation_4003,
					RoleAssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_RoleComposition_4004(
			RoleModel container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getCollaborations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleComposition) {
				continue;
			}
			RoleComposition link = (RoleComposition) linkObject;
			if (RoleCompositionEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, dst, link,
					RolesElementTypes.RoleComposition_4004,
					RoleCompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_RoleImplication_4001(
			Role target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != RolesPackage.eINSTANCE
					.getCollaboration_Target()
					|| false == setting.getEObject() instanceof RoleImplication) {
				continue;
			}
			RoleImplication link = (RoleImplication) setting.getEObject();
			if (RoleImplicationEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, target, link,
					RolesElementTypes.RoleImplication_4001,
					RoleImplicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_RoleProhibition_4002(
			Role target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != RolesPackage.eINSTANCE
					.getCollaboration_Target()
					|| false == setting.getEObject() instanceof RoleProhibition) {
				continue;
			}
			RoleProhibition link = (RoleProhibition) setting.getEObject();
			if (RoleProhibitionEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, target, link,
					RolesElementTypes.RoleProhibition_4002,
					RoleProhibitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_RoleAssociation_4003(
			Role target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != RolesPackage.eINSTANCE
					.getCollaboration_Target()
					|| false == setting.getEObject() instanceof RoleAssociation) {
				continue;
			}
			RoleAssociation link = (RoleAssociation) setting.getEObject();
			if (RoleAssociationEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, target, link,
					RolesElementTypes.RoleAssociation_4003,
					RoleAssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_RoleComposition_4004(
			Role target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != RolesPackage.eINSTANCE
					.getCollaboration_Target()
					|| false == setting.getEObject() instanceof RoleComposition) {
				continue;
			}
			RoleComposition link = (RoleComposition) setting.getEObject();
			if (RoleCompositionEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role src = link.getSource();
			result.add(new RolesLinkDescriptor(src, target, link,
					RolesElementTypes.RoleComposition_4004,
					RoleCompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_RoleImplication_4001(
			Role source) {
		RoleModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof RoleModel) {
				container = (RoleModel) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getCollaborations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleImplication) {
				continue;
			}
			RoleImplication link = (RoleImplication) linkObject;
			if (RoleImplicationEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new RolesLinkDescriptor(src, dst, link,
					RolesElementTypes.RoleImplication_4001,
					RoleImplicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_RoleProhibition_4002(
			Role source) {
		RoleModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof RoleModel) {
				container = (RoleModel) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getCollaborations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleProhibition) {
				continue;
			}
			RoleProhibition link = (RoleProhibition) linkObject;
			if (RoleProhibitionEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new RolesLinkDescriptor(src, dst, link,
					RolesElementTypes.RoleProhibition_4002,
					RoleProhibitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_RoleAssociation_4003(
			Role source) {
		RoleModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof RoleModel) {
				container = (RoleModel) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getCollaborations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleAssociation) {
				continue;
			}
			RoleAssociation link = (RoleAssociation) linkObject;
			if (RoleAssociationEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new RolesLinkDescriptor(src, dst, link,
					RolesElementTypes.RoleAssociation_4003,
					RoleAssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_RoleComposition_4004(
			Role source) {
		RoleModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof RoleModel) {
				container = (RoleModel) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getCollaborations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RoleComposition) {
				continue;
			}
			RoleComposition link = (RoleComposition) linkObject;
			if (RoleCompositionEditPart.VISUAL_ID != RolesVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Role dst = link.getTarget();
			Role src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new RolesLinkDescriptor(src, dst, link,
					RolesElementTypes.RoleComposition_4004,
					RoleCompositionEditPart.VISUAL_ID));
		}
		return result;
	}

}
