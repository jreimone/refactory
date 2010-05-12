package org.emftext.language.refactoring.roles.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationSourceNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationTargetNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAttributeNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionSourceNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionTargetNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleNameEditPart;
import org.emftext.language.refactoring.roles.diagram.parsers.MessageFormatParser;
import org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry;

/**
 * @generated
 */
public class RolesParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser roleName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getRoleName_5001Parser() {
		if (roleName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { RolesPackage.eINSTANCE
					.getNamedElement_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { RolesPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			roleName_5001Parser = parser;
		}
		return roleName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser roleAttributeName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getRoleAttributeName_5002Parser() {
		if (roleAttributeName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { RolesPackage.eINSTANCE
					.getNamedElement_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { RolesPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			roleAttributeName_5002Parser = parser;
		}
		return roleAttributeName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser roleAssociationSourceName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getRoleAssociationSourceName_6001Parser() {
		if (roleAssociationSourceName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { RolesPackage.eINSTANCE
					.getMultiplicityCollaboration_SourceName() };
			EAttribute[] editableFeatures = new EAttribute[] { RolesPackage.eINSTANCE
					.getMultiplicityCollaboration_SourceName() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			roleAssociationSourceName_6001Parser = parser;
		}
		return roleAssociationSourceName_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser roleAssociationTargetName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getRoleAssociationTargetName_6002Parser() {
		if (roleAssociationTargetName_6002Parser == null) {
			EAttribute[] features = new EAttribute[] { RolesPackage.eINSTANCE
					.getMultiplicityCollaboration_TargetName() };
			EAttribute[] editableFeatures = new EAttribute[] { RolesPackage.eINSTANCE
					.getMultiplicityCollaboration_TargetName() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			roleAssociationTargetName_6002Parser = parser;
		}
		return roleAssociationTargetName_6002Parser;
	}

	/**
	 * @generated
	 */
	private IParser roleCompositionSourceName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getRoleCompositionSourceName_6003Parser() {
		if (roleCompositionSourceName_6003Parser == null) {
			EAttribute[] features = new EAttribute[] { RolesPackage.eINSTANCE
					.getMultiplicityCollaboration_SourceName() };
			EAttribute[] editableFeatures = new EAttribute[] { RolesPackage.eINSTANCE
					.getMultiplicityCollaboration_SourceName() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			roleCompositionSourceName_6003Parser = parser;
		}
		return roleCompositionSourceName_6003Parser;
	}

	/**
	 * @generated
	 */
	private IParser roleCompositionTargetName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getRoleCompositionTargetName_6004Parser() {
		if (roleCompositionTargetName_6004Parser == null) {
			EAttribute[] features = new EAttribute[] { RolesPackage.eINSTANCE
					.getMultiplicityCollaboration_TargetName() };
			EAttribute[] editableFeatures = new EAttribute[] { RolesPackage.eINSTANCE
					.getMultiplicityCollaboration_TargetName() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			roleCompositionTargetName_6004Parser = parser;
		}
		return roleCompositionTargetName_6004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case RoleNameEditPart.VISUAL_ID:
			return getRoleName_5001Parser();
		case RoleAttributeNameEditPart.VISUAL_ID:
			return getRoleAttributeName_5002Parser();
		case RoleAssociationSourceNameEditPart.VISUAL_ID:
			return getRoleAssociationSourceName_6001Parser();
		case RoleAssociationTargetNameEditPart.VISUAL_ID:
			return getRoleAssociationTargetName_6002Parser();
		case RoleCompositionSourceNameEditPart.VISUAL_ID:
			return getRoleCompositionSourceName_6003Parser();
		case RoleCompositionTargetNameEditPart.VISUAL_ID:
			return getRoleCompositionTargetName_6004Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(RolesVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(RolesVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (RolesElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
