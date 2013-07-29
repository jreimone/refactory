package org.modelrefactoring.matching.guery;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.Multiplicity;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.language.refactoring.roles.RoleProhibition;
import org.modelrefactoring.guery.Connection;
import org.modelrefactoring.guery.Constraint;
import org.modelrefactoring.guery.EdgeSelection;
import org.modelrefactoring.guery.GueryFactory;
import org.modelrefactoring.guery.Motif;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.VertexSelection;
import org.modelrefactoring.guery.graph.ContainmentEdge;

public class RoleModel2Motif {

	private static final String INTERMEDIATE_IDENTIFIER	= "_";
	
	private RoleModel rolemodel;
	private MotifModel motifModel;

	private int maxPathLength;

	public RoleModel2Motif(RoleModel roleModel){
		this.rolemodel = roleModel;
	}

	public MotifModel createMotifModel(int maxPathLength){
		this.maxPathLength = maxPathLength;
		motifModel = GueryFactory.eINSTANCE.createMotifModel();
		transform();
		return motifModel;
	}

	private void transform() {
		Motif motif = GueryFactory.eINSTANCE.createMotif();
		motifModel.getMotifs().add(motif);
		motif.setName(rolemodel.getName());
		VertexSelection vertexSelection = GueryFactory.eINSTANCE.createVertexSelection();
		motif.setVertexSelection(vertexSelection);
		for (Role role : rolemodel.getRoles()) {
			createRole(vertexSelection, role);
		}
		for (Collaboration collaboration : rolemodel.getCollaborations()){
			createCollaboration(motif, collaboration);
		}
	}

	private void createRole(VertexSelection vertexSelection, Role role) {
		org.modelrefactoring.guery.Role gueryRole = GueryFactory.eINSTANCE.createRole();
		gueryRole.setName(role.getName());
		vertexSelection.getRoles().add(gueryRole);
		int attributes = role.getAttributes().size();
		int optional = 0;
		for (RoleAttribute attribut:role.getAttributes()){
			if(attribut.getModifier().contains(RoleModifier.OPTIONAL)){
				optional++;
			}
		}
		if (attributes > 0){
			org.modelrefactoring.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
			if (optional < attributes){
				gueryConstraint.setExpression(role.getName() + ".getEClass().getEAttributes().size() > 0");
				vertexSelection.getConstraints().add(gueryConstraint);
			}
		}
	}

	private void createCollaboration(Motif motif, Collaboration collaboration) {
		// Role Composition && Role Association
		if (collaboration instanceof MultiplicityCollaboration){
			createMultiplicityCollaboration(motif, (MultiplicityCollaboration) collaboration);
		}

		if (collaboration instanceof RoleProhibition){
			createRoleProhibition(motif, collaboration);
		}

		if (collaboration instanceof RoleImplication){
			createRoleImplication(motif, collaboration);
		}
	}

	private org.modelrefactoring.guery.Role getGueryRoleFromRole(Motif motif, Role role){
		List<org.modelrefactoring.guery.Role> roles = motif.getVertexSelection().getRoles();
		for (org.modelrefactoring.guery.Role motifRole : roles) {
			if(motifRole.getName().equals(role.getName())){
				return motifRole;
			}
		}
		return null;
	}
	
	private void createMultiplicityCollaboration(Motif motif, MultiplicityCollaboration collaboration) {
		Role sourceRole = collaboration.getSource();
		Role targetRole = collaboration.getTarget();
		String collaborationName = collaboration.getTargetName();
		Multiplicity targetMultiplicity = collaboration.getTargetMultiplicity();
		EdgeSelection edgeSelection = GueryFactory.eINSTANCE.createConnectedBy();
		motif.getEdgeSelections().add(edgeSelection);
		Connection connection = GueryFactory.eINSTANCE.createConnection();
		edgeSelection.getConnections().add(connection);
		connection.setComputeAll(true);
		connection.setFrom(getGueryRoleFromRole(motif, sourceRole));
		connection.setPath(collaborationName);
		int upperBound = targetMultiplicity.getUpperBound();
		if(upperBound == -1 || Math.abs(upperBound - targetMultiplicity.getLowerBound()) > 1){
			connection.setMinLength(1);
			connection.setMaxLength(1);
			// create intermediate role
			org.modelrefactoring.guery.Role intermediateRole = GueryFactory.eINSTANCE.createRole();
			intermediateRole.setName(INTERMEDIATE_IDENTIFIER + sourceRole.getName() + INTERMEDIATE_IDENTIFIER + targetRole.getName() + INTERMEDIATE_IDENTIFIER);
			motif.getVertexSelection().getRoles().add(intermediateRole);
			connection.setTo(intermediateRole);
			// create intermediate edge
			Connection intermediateConnection = GueryFactory.eINSTANCE.createConnection();
			intermediateConnection.setMaxLength(upperBound == -1 || upperBound > maxPathLength ? maxPathLength - 1 : upperBound - 1);
			intermediateConnection.setFrom(intermediateRole);
			intermediateConnection.setTo(getGueryRoleFromRole(motif, targetRole));
			intermediateConnection.setMinLength(0);
			intermediateConnection.setPath(INTERMEDIATE_IDENTIFIER + collaborationName + INTERMEDIATE_IDENTIFIER);
			EdgeSelection intermediateEdge = GueryFactory.eINSTANCE.createConnectedBy();
			intermediateEdge.getConnections().add(intermediateConnection);
			motif.getEdgeSelections().add(intermediateEdge);
		} else {
			connection.setMinLength(targetMultiplicity.getLowerBound());
			connection.setTo(getGueryRoleFromRole(motif, targetRole));
			connection.setMaxLength(upperBound);
		}
		Constraint edgeConstraint = GueryFactory.eINSTANCE.createConstraint();
		if(collaboration instanceof RoleComposition){
			edgeConstraint.setExpression(connection.getPath() + " is " + ContainmentEdge.class.getCanonicalName());
		} else {
			edgeConstraint.setExpression("!(" + connection.getPath() + " is " + ContainmentEdge.class.getCanonicalName() + ")");
		}
		edgeSelection.getConstraints().add(edgeConstraint);
	}

	private void createRoleProhibition(Motif motif, Collaboration collaboration) {
		EList<org.modelrefactoring.guery.Role> roleList=motif.getVertexSelection().getRoles();
		org.modelrefactoring.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
		String constraintSource=null;
		String constraintTarget=null;
		for (org.modelrefactoring.guery.Role gueryRole:roleList){
			if (collaboration.getSource().getName().equals(gueryRole.getName())){
				constraintSource=collaboration.getSource().getName();
			}
			if (collaboration.getTarget().getName().equals(gueryRole.getName())){
				constraintTarget=collaboration.getTarget().getName();
			}
		}
		if ((constraintSource!=null)&&(constraintTarget!=null)){
			gueryConstraint.setExpression(constraintSource + "!=" + constraintTarget);
			motif.getVertexSelection().getConstraints().add(gueryConstraint);
		}
	}

	private void createRoleImplication(Motif motif, Collaboration collaboration) {
		EList<org.modelrefactoring.guery.Role> roleList = motif.getVertexSelection().getRoles();
		org.modelrefactoring.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
		String constraintSource = null;
		String constraintTarget = null;
		for (org.modelrefactoring.guery.Role gueryRole:roleList){
			if (collaboration.getSource().getName().equals(gueryRole.getName())){
				constraintSource = collaboration.getSource().getName();
			}
			if (collaboration.getTarget().getName().equals(gueryRole.getName())){
				constraintTarget = collaboration.getTarget().getName();
			}
		}
		if ((constraintSource != null) && (constraintTarget != null)){
			gueryConstraint.setExpression(constraintSource + " == " + constraintTarget);
			motif.getVertexSelection().getConstraints().add(gueryConstraint);
		}
	}
}
