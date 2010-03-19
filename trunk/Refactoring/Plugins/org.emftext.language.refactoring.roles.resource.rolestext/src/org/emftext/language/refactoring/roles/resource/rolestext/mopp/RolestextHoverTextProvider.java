/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

import java.util.List;

import org.emftext.language.refactoring.roles.Relation;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAssociation;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.language.refactoring.roles.RoleProhibition;

public class RolestextHoverTextProvider implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextHoverTextProvider {
	
	private org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextDefaultHoverTextProvider defaultProvider = new org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		if(object instanceof Role){
			return handleRole((Role) object);
		} else if(object instanceof RoleAttribute){
			return handleRoleAttribute((RoleAttribute) object);
		}
		return defaultProvider.getHoverText(object);
	}

	private String handleRoleAttribute(RoleAttribute attribute){
		StringBuilder builder = new StringBuilder();
		builder.append("<strong>" + attribute.getAttributeRole().getName() + " Attribute: </strong>" + attribute.getName());
		String comment = attribute.getComment();
		if(comment != null && !"".equals(comment.trim())){
			builder.append("<br>");
			builder.append(comment);
		}
		handleRoleModifiers(builder, attribute.getModifier());
		return builder.toString();
	}
	
	private java.lang.String handleRole(Role role) {
		StringBuilder builder = new StringBuilder();
		builder.append("<strong>Role: </strong>" + role.getName());
		String comment = role.getComment();
		if(comment != null && !"".equals(comment.trim())){
			builder.append("<br>");
			builder.append(comment);
		}
		List<RoleModifier> modifiers = role.getModifier();
		handleRoleModifiers(builder, modifiers);
		List<RoleAttribute> attributes = role.getAttributes();
		if(attributes != null && attributes.size() > 0){
			builder.append("<br><br>");
			builder.append("<strong>Role Attributes: </strong>");
			for (RoleAttribute roleAttribute : attributes) {
				handleRoleAttribute(builder, roleAttribute);
			}
		}
		List<Relation> outgoings = role.getOutgoing();
		if(outgoings != null && outgoings.size() > 0){
			builder.append("<br><br>");
			builder.append("<strong>Outgoing Relations: </strong>");
			for (Relation relation : outgoings) {
				handleRelation(builder, relation);
			}
		}	
		return builder.toString();
	}

	private void handleRelation(StringBuilder builder, Relation relation) {
		builder.append("<br>");
		String relationType = "";
		if(relation instanceof RoleProhibition){
			relationType = "|-|";
		} else if(relation instanceof RoleComposition){
			relationType = "<>- " + "<i>" + ((RoleComposition) relation).getTargetName() + "</i>  : " ;
		} else if(relation instanceof RoleAssociation){
			relationType = "-- " + "<i>" + ((RoleAssociation) relation).getTargetName() + "</i>  : ";
		} else if(relation instanceof RoleImplication){
			relationType = "->";
		}
		builder.append(relationType + " " + relation.getTarget().getName());
	}

	private void handleRoleModifiers(StringBuilder builder,
			List<RoleModifier> modifiers) {
		if(modifiers != null && modifiers.size() > 0){
			builder.append("<br><br>");
			builder.append("<strong>Modifier: </strong>" + modifiers.get(0));
			for (int i = 1; i < modifiers.size(); i++) {
				builder.append(", " + modifiers.get(i));
			}
		}
	}

	private void handleRoleAttribute(StringBuilder builder, RoleAttribute roleAttribute) {
		builder.append("<br>");
		builder.append("<i>" + roleAttribute.getName() + "</i>");
		String attributeComment = roleAttribute.getComment();
		if(attributeComment != null && !"".equals(attributeComment.trim())){
			builder.append(" : " + attributeComment);
		}
	}
	
}
