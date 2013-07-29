package org.modelrefactoring.matching.guery;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.CollaborationModifier;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.language.refactoring.roles.RoleProhibition;
import org.modelrefactoring.guery.EdgeSelection;
import org.modelrefactoring.guery.GueryFactory;
import org.modelrefactoring.guery.Motif;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.VertexSelection;
import org.modelrefactoring.guery.graph.ContainmentEdge;

public class RoleModel2Motif {

	private static int maxLength = 3;
	private RoleModel rolemodel;
	private MotifModel motifModel;

	public RoleModel2Motif(RoleModel roleModel){
		this.rolemodel = roleModel;
	}

	public MotifModel createMotifModel(){
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
			createRole(motif, role);
		}
		for (Collaboration collaboration : rolemodel.getCollaborations()){
			createCollaboration(motif, collaboration);
		}
	}

	private void createRole(Motif motif, Role role) {
		org.modelrefactoring.guery.Role gueryRole = GueryFactory.eINSTANCE.createRole();
		gueryRole.setName(role.getName());
		motif.getVertexSelection().getRoles().add(gueryRole);
		int attributes=role.getAttributes().size();
		int optional=0;
		for (RoleAttribute attribut:role.getAttributes()){
			if(attribut.getModifier().contains(RoleModifier.OPTIONAL)){
				optional++;
			}
		}
		if (attributes>0){
			org.modelrefactoring.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
			if (optional>0){ //wenn optionale Attribute
				if (attributes>optional){ //wenn nicht alle Attribute optional
					gueryConstraint.setExpression(role.getName()+".getEClass().getEAttributes().size()>0");
				}
				//wenn alle Attribute optional -> Kein Test auf Attributanzahl
			}
			else{
				gueryConstraint.setExpression(role.getName()+".getEClass().getEAttributes().size()>0");
				motif.getVertexSelection().getConstraints().add(gueryConstraint);
			}
		}
	}

	private void createCollaboration(Motif motif, Collaboration collaboration) {
		EdgeSelection edgeSelection = GueryFactory.eINSTANCE.createConnectedBy();
		EdgeSelection edgeSelection2 = GueryFactory.eINSTANCE.createConnectedBy();
		// Role Composition && Role Association
		if (collaboration instanceof MultiplicityCollaboration){
			createMultiplicityCollaboration(motif, edgeSelection, edgeSelection2, collaboration);
		}

		if (collaboration instanceof RoleProhibition){
			createRoleProhibition(motif, collaboration);
		}

		if (collaboration instanceof RoleImplication){
			createRoleImplication(motif, collaboration);
		}
		motif.getEdgeSelections().add(edgeSelection);
		if (maxLength > 1 || maxLength < 0){
			motif.getEdgeSelections().add(edgeSelection2);
		}
	}


	private void createMultiplicityCollaboration(Motif motif, EdgeSelection edgeSelection, EdgeSelection edgeSelection2, Collaboration collaboration) {
		boolean foundSource=false;
		boolean foundTarget=false;
		org.modelrefactoring.guery.Connection gueryConnection = GueryFactory.eINSTANCE.createConnection();
		gueryConnection.setPath(((MultiplicityCollaboration) collaboration).getTargetName());
		EList<org.modelrefactoring.guery.Role> roleList=motif.getVertexSelection().getRoles();
		for (org.modelrefactoring.guery.Role gueryRole:roleList){
			if (collaboration.getSource().getName().equals(gueryRole.getName())){
				foundSource=true;
				gueryConnection.setFrom(gueryRole);
			}
			if (collaboration.getTarget().getName().equals(gueryRole.getName())){
				foundTarget=true;
				gueryConnection.setTo(gueryRole);
			}
		}
		if (collaboration.getModifier().contains(CollaborationModifier.TRANSITIVE)){
			if (maxLength > 1){
				gueryConnection.setMinLength(1);
				gueryConnection.setMaxLength(1);
				org.modelrefactoring.guery.Role gueryRolePH = GueryFactory.eINSTANCE.createRole();
				gueryRolePH.setName(((MultiplicityCollaboration) collaboration).getTargetName()+"PH");
				motif.getVertexSelection().getRoles().add(gueryRolePH);
				org.modelrefactoring.guery.Connection gueryConnection2 = GueryFactory.eINSTANCE.createConnection();
				gueryConnection2.setPath(((MultiplicityCollaboration) collaboration).getTargetName()+"2");
				gueryConnection2.setFrom(gueryRolePH);
				gueryConnection2.setTo(gueryConnection.getTo());
				gueryConnection.setTo(gueryRolePH);
				gueryConnection2.setMinLength(0);
				gueryConnection2.setMaxLength(maxLength-1);
				gueryConnection2.setComputeAll(true);
				edgeSelection2.getConnections().add(gueryConnection2);
			}
			else{
				if (maxLength==-1){
					gueryConnection.setMinLength(1);
					gueryConnection.setMaxLength(1);
					org.modelrefactoring.guery.Role gueryRolePH = GueryFactory.eINSTANCE.createRole();
					gueryRolePH.setName(((MultiplicityCollaboration) collaboration).getTargetName()+"PH");
					motif.getVertexSelection().getRoles().add(gueryRolePH);

					org.modelrefactoring.guery.Connection gueryConnection2 = GueryFactory.eINSTANCE.createConnection();
					gueryConnection2.setPath(((MultiplicityCollaboration) collaboration).getTargetName()+"2");
					gueryConnection2.setFrom(gueryRolePH);
					gueryConnection2.setTo(gueryConnection.getTo());
					gueryConnection.setTo(gueryRolePH);
					gueryConnection2.setMinLength(0);
					gueryConnection2.setMaxLength(-1);
					gueryConnection2.setComputeAll(true);
					edgeSelection2.getConnections().add(gueryConnection2);
				}
			}
		}
		else{
			gueryConnection.setMinLength(1);
			gueryConnection.setMaxLength(1);
		}
		gueryConnection.setComputeAll(true); //erst alle Connections berechnen
		if (foundSource && foundTarget){
			edgeSelection.getConnections().add(gueryConnection);
			if (collaboration instanceof RoleComposition){
				org.modelrefactoring.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
				gueryConstraint.setExpression(((MultiplicityCollaboration) collaboration).getTargetName()+" is " + ContainmentEdge.class.getName());
				edgeSelection.getConstraints().add(gueryConstraint);
			}
			else{
				org.modelrefactoring.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
				gueryConstraint.setExpression("!("+((MultiplicityCollaboration) collaboration).getTargetName()+" is " + ContainmentEdge.class.getName() + ")");
				edgeSelection.getConstraints().add(gueryConstraint);
			}
		}
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
			gueryConstraint.setExpression(constraintSource+"!="+constraintTarget);
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
			gueryConstraint.setExpression(constraintSource+" == "+constraintTarget);
			motif.getVertexSelection().getConstraints().add(gueryConstraint);
		}
	}


	//	private int countVersions(RoleModel rolemodel){
	//		int result=0;
	//		int countR=0; //Anzahl optionaler Rollen
	//		for (Role role : rolemodel.getRoles()) {
	//			List<RoleModifier> rmlist=role.getModifier();
	//			for (RoleModifier rm: rmlist){
	//				if (rm == RoleModifier.OPTIONAL){
	//					countR++;
	//				}
	//			}
	//		}
	//		/*
	//		 * Wenn keine Paare dann ist Anzahl Varianten
	//		 * 2^(Anzahl optionaler Rollen+Anzahl optionaler Attribute)
	//		 */
	//		result=(int) Math.pow(2,(countR));
	//		return result;
	//	}

	//	private boolean showRole(int version, ArrayList<Role> optionalRoles, Role role){
	//		int pos=optionalRoles.indexOf(role);
	//		if (pos==-1){
	//			return true;
	//		}
	//		String test=Integer.toBinaryString(version);
	//		String dual="";
	//		for (int i3=optionalRoles.size();i3>test.length();i3--){
	//			dual=dual+"0";
	//		}
	//		dual=dual+test;
	//		if (dual.subSequence(pos, pos+1).equals("0")){
	//			return false;
	//		}
	//		else{
	//			return true;
	//		}
	//	}
}
