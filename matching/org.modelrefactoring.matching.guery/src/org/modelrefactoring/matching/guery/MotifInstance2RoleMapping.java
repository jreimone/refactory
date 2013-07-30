package org.modelrefactoring.matching.guery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifInstance;
import nz.ac.massey.cs.guery.Path;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RolemappingFactory;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;

public class MotifInstance2RoleMapping {

	private RoleModel roleModel;
	private MotifInstance<MetamodelVertex, EReferenceEdge> instance;

	public MotifInstance2RoleMapping(MotifInstance<MetamodelVertex, EReferenceEdge> instance, RoleModel roleModel){
		this.instance = instance;
		this.roleModel = roleModel;
	}

	public RoleMapping createRoleMapping(){
		RoleMapping roleMapping = RolemappingFactory.eINSTANCE.createRoleMapping();
		createConcreteMappings(roleMapping);
		return roleMapping;
	}

	private void createConcreteMappings(RoleMapping roleMapping) {
		Motif<MetamodelVertex, EReferenceEdge> motif = instance.getMotif();
		List<String> roles = motif.getRoles();
		roleMapping.setMappedRoleModel(roleModel);
		for (String role : roles) {
			//			if(role.startsWith(RoleModel2Motif.INTERMEDIATE_IDENTIFIER) && role.endsWith(RoleModel2Motif.INTERMEDIATE_IDENTIFIER)){
			//				 String[] roleNames = role.substring(1, role.length() - 1).split(RoleModel2Motif.INTERMEDIATE_IDENTIFIER);
			//				 String sourceName = roleNames[0];
			//				 String targetName = roleNames[1];
			//			} else {
			Role roleByName = getRoleByName(role);
			MetamodelVertex vertex = instance.getVertex(role);
			EObject modelElement = vertex.getModelElement();
			if(modelElement instanceof EClass && roleByName != null){
				EClass metaclass = (EClass) modelElement;
				roleMapping.setName(roleModel.getName() + " for " + metaclass.getEPackage().getName());
				ConcreteMapping concreteMapping = RolemappingFactory.eINSTANCE.createConcreteMapping();
				concreteMapping.setMetaclass(metaclass);
				concreteMapping.setRole(roleByName);
				roleMapping.getRoleToMetaelement().add(concreteMapping);
				//				}
			}
		}
		Map<String, List<ReferenceMetaClassPair>> referencePathMap = new HashMap<String, List<ReferenceMetaClassPair>>();
		List<String> pathRoles = motif.getPathRoles();
		for (String pathRole : pathRoles) {
			String realPathRole = null;
			boolean isIntermediate = pathRole.startsWith(RoleModel2Motif.INTERMEDIATE_IDENTIFIER) && pathRole.endsWith(RoleModel2Motif.INTERMEDIATE_IDENTIFIER);
			if(isIntermediate){
				realPathRole = pathRole.replaceAll(RoleModel2Motif.INTERMEDIATE_IDENTIFIER, "");
			} else {
				realPathRole = pathRole;
			}
			List<ReferenceMetaClassPair> referencePath = referencePathMap.get(realPathRole);
			if(referencePath == null){ 
				referencePath = new ArrayList<ReferenceMetaClassPair>();
				referencePathMap.put(realPathRole, referencePath);
			}
			Path<MetamodelVertex, EReferenceEdge> edgePath = instance.getPath(pathRole);
			if(!isIntermediate){
				assert edgePath.size() == 1;
			}
			for (EReferenceEdge edge : edgePath.getEdges()) {
				EReference reference = edge.getReference();
				EObject element = edge.getEnd().getModelElement();
				if(element instanceof EClass){
					EClass metaclass = (EClass) element;
					ReferenceMetaClassPair referenceMetaClassPair = RolemappingFactory.eINSTANCE.createReferenceMetaClassPair();
					referenceMetaClassPair.setMetaClass(metaclass);
					referenceMetaClassPair.setReference(reference);
					if(isIntermediate){
						referencePath.add(referenceMetaClassPair);
					} else {
						referencePath.add(0, referenceMetaClassPair);
					}
				}
			}

			//			if(pathRole.startsWith(RoleModel2Motif.INTERMEDIATE_IDENTIFIER) && pathRole.endsWith(RoleModel2Motif.INTERMEDIATE_IDENTIFIER)){
			//				String realPathRole = pathRole.replaceAll(RoleModel2Motif.INTERMEDIATE_IDENTIFIER, "");
			//				List<ReferenceMetaClassPair> referencePath = referencePathMap.get(realPathRole);
			//				if(referencePath == null){ // first edge of the path wasn't iterated yet
			//					referencePath = new ArrayList<ReferenceMetaClassPair>();
			//					referencePathMap.put(realPathRole, referencePath);
			//				}
			//				Path<MetamodelVertex, EReferenceEdge> intermediatePath = instance.getPath(pathRole);
			//				for (EReferenceEdge intermediateEdge : intermediatePath.getEdges()) {
			//					EReference reference = intermediateEdge.getReference();
			//					EObject element = intermediateEdge.getEnd().getModelElement();
			//					if(element instanceof EClass){
			//						EClass metaclass = (EClass) element;
			//						ReferenceMetaClassPair referenceMetaClassPair = RolemappingFactory.eINSTANCE.createReferenceMetaClassPair();
			//						referenceMetaClassPair.setMetaClass(metaclass);
			//						referenceMetaClassPair.setReference(reference);
			//						referencePath.add(referenceMetaClassPair);
			//					}
			//				}
			//			} else {
			//				List<ReferenceMetaClassPair> referencePath = referencePathMap.get(pathRole);
			//				if(referencePath == null){ // intermediate path wasn't iterated yet
			//					referencePath = new ArrayList<ReferenceMetaClassPair>();
			//					referencePathMap.put(pathRole, referencePath);
			//				}
			//				Path<MetamodelVertex, EReferenceEdge> firstEdgePath = instance.getPath(pathRole);
			//				assert firstEdgePath.size() == 1;
			//				for (EReferenceEdge firstEdge : firstEdgePath.getEdges()) {
			//					EReference reference = firstEdge.getReference();
			//					EObject element = firstEdge.getEnd().getModelElement();
			//					if(element instanceof EClass){
			//						EClass metaclass = (EClass) element;
			//						ReferenceMetaClassPair referenceMetaClassPair = RolemappingFactory.eINSTANCE.createReferenceMetaClassPair();
			//						referenceMetaClassPair.setMetaClass(metaclass);
			//						referenceMetaClassPair.setReference(reference);
			//						referencePath.add(0, referenceMetaClassPair);
			//					}
			//				}
			//			}
		}
		for (String edgeName : referencePathMap.keySet()) {
			List<ReferenceMetaClassPair> referenceMetaclassPairs = referencePathMap.get(edgeName);
			Collaboration collaboration = getCollaborationByName(edgeName);
			if(collaboration instanceof MultiplicityCollaboration){
				MultiplicityCollaboration multiplicityCollaboration = (MultiplicityCollaboration) collaboration;
				Role sourceRole = multiplicityCollaboration.getSource();
				ConcreteMapping concreteMapping = roleMapping.getConcreteMappingForRole(sourceRole);
				CollaborationMapping collaborationMapping = RolemappingFactory.eINSTANCE.createCollaborationMapping();
				collaborationMapping.setCollaboration(multiplicityCollaboration);
				collaborationMapping.getReferenceMetaClassPair().addAll(referenceMetaclassPairs);
				concreteMapping.getCollaborationMappings().add(collaborationMapping);
			}
		}
	}

	private Role getRoleByName(String name){
		List<Role> roles = roleModel.getRoles();
		for (Role role : roles) {
			if(role.getName().equals(name)){
				return role;
			}
		}
		return null;
	}

	private Collaboration getCollaborationByName(String name){
		List<Collaboration> collaborations = roleModel.getCollaborations();
		for (Collaboration collaboration : collaborations) {
			if(collaboration instanceof MultiplicityCollaboration){
				MultiplicityCollaboration multiplicityCollaboration = (MultiplicityCollaboration) collaboration;
				if(multiplicityCollaboration.getTargetName().equals(name)){
					return collaboration;
				} 
			}
		}
		return null;
	}
}
