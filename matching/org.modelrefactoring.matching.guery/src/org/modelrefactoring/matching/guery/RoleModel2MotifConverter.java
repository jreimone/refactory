package org.modelrefactoring.matching.guery;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
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

public class RoleModel2MotifConverter {

	public static final String INTERMEDIATE_IDENTIFIER	= "_";
	
	private RoleModel initialRolemodel;
	private MotifModel motifModel;

	private int maxPathLength;

	private RoleMapping roleMapping;

	public RoleModel2MotifConverter(RoleModel roleModel){
		this.initialRolemodel = roleModel;
	}
	
	/**
	 * This constructor is used if some roles were mapped manually already
	 * in an existing role mapping. 
	 * @param roleMapping
	 */
	public RoleModel2MotifConverter(RoleMapping roleMapping){
		this(roleMapping.getMappedRoleModel());
		this.roleMapping = roleMapping;
	}

	public MotifModel createMotifModel(int maxPathLength){
		this.maxPathLength = maxPathLength;
		motifModel = GueryFactory.eINSTANCE.createMotifModel();
		transform();
		return motifModel;
	}

	private void transform() {
		motifModel.getMotifs().add(createMotif(initialRolemodel));
		List<Role> roles = initialRolemodel.getRoles();
		List<Role> optionalRoles = new ArrayList<Role>();
		for (Role role : roles) {
			if(role.getModifier().contains(RoleModifier.OPTIONAL)){
				optionalRoles.add(role);
			}
		}
		CombinationGenerator<Role> generator = new CombinationGenerator<Role>();
		List<Role> mappedRoles = null;
		if(roleMapping != null){
			mappedRoles = roleMapping.getAllMappedRoles();
		}
		for (int count = 1; count <= optionalRoles.size(); count++) {
			List<List<Role>> countCombinations = generator.getCombinations(optionalRoles, count);
			for (List<Role> rolesToRemove : countCombinations) {
				if(mappedRoles != null){
					boolean roleAlreadyMapped = false;
					for (Role roleToRemove : rolesToRemove) {
						if(mappedRoles.contains(roleToRemove)){
							roleAlreadyMapped = true;
							break;
						}
					}
					if(roleAlreadyMapped){
						continue;
					}
				}
				EcoreUtil.Copier copier = new EcoreUtil.Copier(true, false);
				RoleModel copiedRoleModel = (RoleModel) copier.copy(initialRolemodel);
				copier.copyReferences();
				for (Role roleToRemove : rolesToRemove) {
					copiedRoleModel.getRoles().remove(copier.get(roleToRemove));
					for (Collaboration collaboration : roleToRemove.getIncoming()) {
						EcoreUtil.delete(copier.get(collaboration));
					}
					for (Collaboration collaboration : roleToRemove.getOutgoing()) {
						EcoreUtil.delete(copier.get(collaboration));
					}
				}
				Motif motif = createMotif(copiedRoleModel);
				motifModel.getMotifs().add(motif);
			}
		}
	}

	private Motif createMotif(RoleModel roleModel) {
		Motif motif = GueryFactory.eINSTANCE.createMotif();
		motif.setName(roleModel.getName());
		VertexSelection vertexSelection = GueryFactory.eINSTANCE.createVertexSelection();
		motif.setVertexSelection(vertexSelection);
		for (Role role : roleModel.getRoles()) {
			createRole(vertexSelection, role);
		}
		if(roleMapping != null){
			List<Constraint> constraints = vertexSelection.getConstraints();
			List<ConcreteMapping> concreteMappings = roleMapping.getRoleToMetaelement();
			for (ConcreteMapping concreteMapping : concreteMappings) {
				Constraint constraint = GueryFactory.eINSTANCE.createConstraint();
				Role role = concreteMapping.getRole();
				EClass metaclass = concreteMapping.getMetaclass();
				constraint.setExpression(role.getName() + ".getEClass().getName() == '" + metaclass.getName() + "'");
				constraints.add(constraint);
			}
		}
		for (Collaboration collaboration : roleModel.getCollaborations()){
			createCollaboration(motif, collaboration);
		}
		return motif;
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
		if((upperBound == -1 || Math.abs(upperBound - targetMultiplicity.getLowerBound()) > 1) && (maxPathLength > 1 || maxPathLength < 0)){
			connection.setMinLength(1);
			connection.setMaxLength(1);
			// create intermediate role
			org.modelrefactoring.guery.Role intermediateRole = GueryFactory.eINSTANCE.createRole();
			intermediateRole.setName(INTERMEDIATE_IDENTIFIER + sourceRole.getName() + INTERMEDIATE_IDENTIFIER + targetRole.getName() + INTERMEDIATE_IDENTIFIER);
			motif.getVertexSelection().getRoles().add(intermediateRole);
			connection.setTo(intermediateRole);
			// create intermediate edge
			Connection intermediateConnection = GueryFactory.eINSTANCE.createConnection();
			int max = 0;
			if(upperBound == -1){
				if(maxPathLength > 0){
					max = maxPathLength - 1;
				} else {
					max = -1;
				}
			} else if(upperBound > 0){
				if(maxPathLength > 0){
					if(upperBound > maxPathLength){
						max = maxPathLength - 1;
					} else {
						max = upperBound - 1;
					}
				} else {
					max = upperBound - 1;
				}
			}
			intermediateConnection.setMaxLength(max);
			intermediateConnection.setComputeAll(true);
			intermediateConnection.setFrom(intermediateRole);
			intermediateConnection.setTo(getGueryRoleFromRole(motif, targetRole));
			intermediateConnection.setMinLength(0);
			intermediateConnection.setPath(INTERMEDIATE_IDENTIFIER + collaborationName + INTERMEDIATE_IDENTIFIER);
			EdgeSelection intermediateEdge = GueryFactory.eINSTANCE.createConnectedBy();
			intermediateEdge.getConnections().add(intermediateConnection);
			motif.getEdgeSelections().add(intermediateEdge);
		} else {
			connection.setMinLength(1);
			connection.setTo(getGueryRoleFromRole(motif, targetRole));
			connection.setMaxLength(1);
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
