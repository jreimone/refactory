/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.ui;

import java.util.List;

import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.Commentable;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAssociation;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.language.refactoring.roles.RoleProhibition;

public class RolestextHoverTextProvider implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextHoverTextProvider {
	
private org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextDefaultHoverTextProvider defaultProvider = new org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		if(object instanceof Role){
			return handleRole((Role) object);
		} else if(object instanceof RoleAttribute){
			return handleRoleAttribute((RoleAttribute) object);
		} else if(object instanceof RoleModel){
			return handleRoleModel((RoleModel) object);
		}
		return defaultProvider.getHoverText(object);
	}

	private String handleRoleModel(RoleModel roleModel){
		StringBuilder builder = new StringBuilder();
		builder.append("<strong>Role Model: </strong>" + roleModel.getName());
		builder.append(handleComment(roleModel));
		return builder.toString();
	}
	
	private String handleRoleAttribute(RoleAttribute attribute){
		StringBuilder builder = new StringBuilder();
		builder.append("<strong>" + attribute.getAttributeRole().getName() + "</strong> Attribute: <strong>" + attribute.getName() + "</strong>");
		builder.append(handleComment(attribute));
		builder.append(handleRoleModifiers(attribute.getModifier()));
		return builder.toString();
	}

	/**
	 * @param commentable
	 * @param builder
	 */
	private String handleComment(Commentable commentable) {
		StringBuilder builder = new StringBuilder();
		String comment = commentable.getComment();
		if(comment != null && !"".equals(comment.trim())){
			builder.append("<br>");
			builder.append(comment);
		}
		return builder.toString();
	}
	
	private String handleRole(Role role) {
		StringBuilder builder = new StringBuilder();
		builder.append("<strong>Role: </strong>" + role.getName());
		builder.append(handleComment(role));
		List<RoleModifier> modifiers = role.getModifier();
		builder.append(handleRoleModifiers(modifiers));
		List<RoleAttribute> attributes = role.getAttributes();
		if(attributes != null && attributes.size() > 0){
			builder.append("<br><br>");
			builder.append("<strong>Role Attributes: </strong>");
			for (RoleAttribute roleAttribute : attributes) {
				builder.append(handleRoleAttributeShort(roleAttribute));
			}
		}
		List<Collaboration> outgoings = role.getOutgoing();
		if(outgoings != null && outgoings.size() > 0){
			builder.append("<br><br>");
			builder.append("<strong>Outgoing Relations: </strong>");
			for (Collaboration collaboration : outgoings) {
				builder.append(handleRelation(collaboration));
			}
		}	
		return builder.toString();
	}

	private String handleRelation(Collaboration collaboration) {
		StringBuilder builder = new StringBuilder();
		builder.append("<br>");
		String relationType = "";
		if(collaboration instanceof RoleProhibition){
			relationType = "|-|";
		} else if(collaboration instanceof RoleComposition){
			relationType = "<>- " + "<i>" + ((RoleComposition) collaboration).getTargetName() + "</i>  : " ;
		} else if(collaboration instanceof RoleAssociation){
			relationType = "-- " + "<i>" + ((RoleAssociation) collaboration).getTargetName() + "</i>  : ";
		} else if(collaboration instanceof RoleImplication){
			relationType = "->";
		}
		builder.append(relationType + " " + collaboration.getTarget().getName());
		return builder.toString();
	}

	private String handleRoleModifiers(List<RoleModifier> modifiers) {
		StringBuilder builder = new StringBuilder();
		if(modifiers != null && modifiers.size() > 0){
			builder.append("<br><br>");
			builder.append("<strong>Modifier: </strong>" + modifiers.get(0));
			for (int i = 1; i < modifiers.size(); i++) {
				builder.append(", " + modifiers.get(i));
			}
		}
		return builder.toString();
	}

	private String handleRoleAttributeShort(RoleAttribute roleAttribute) {
		StringBuilder builder = new StringBuilder();
		builder.append("<br>");
		builder.append("<i>" + roleAttribute.getName() + "</i>");
		builder.append(handleComment(roleAttribute));
		return builder.toString();
	}
}
