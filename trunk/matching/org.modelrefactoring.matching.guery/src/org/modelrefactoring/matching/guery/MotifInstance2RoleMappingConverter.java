package org.modelrefactoring.matching.guery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifInstance;
import nz.ac.massey.cs.guery.Path;
import nz.ac.massey.cs.guery.ResultListener;

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

public class MotifInstance2RoleMappingConverter implements ResultListener<MetamodelVertex, EReferenceEdge>{

	private RoleModel roleModel;

	private int count = 0;
	private int maxResultCount;
	
	private List<RoleMapping> foundRoleMappings;
	
	public MotifInstance2RoleMappingConverter(RoleModel roleModel, int maxResultCount){
		this.roleModel = roleModel;
		this.maxResultCount = maxResultCount;
		foundRoleMappings = new ArrayList<RoleMapping>();
	}

	private RoleMapping createRoleMapping(MotifInstance<MetamodelVertex, EReferenceEdge> instance){
		RoleMapping roleMapping = RolemappingFactory.eINSTANCE.createRoleMapping();
		createRoleMappings(instance, roleMapping);
		createCollaborationMappings(instance, roleMapping);
		return roleMapping;
	}

	private void createRoleMappings(MotifInstance<MetamodelVertex, EReferenceEdge> instance, RoleMapping roleMapping) {
		Motif<MetamodelVertex, EReferenceEdge> motif = instance.getMotif();
		List<String> roles = motif.getRoles();
		roleMapping.setMappedRoleModel(roleModel);
		for (String role : roles) {
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
	}

	private void createCollaborationMappings(MotifInstance<MetamodelVertex, EReferenceEdge> instance, RoleMapping roleMapping) {
		Motif<MetamodelVertex, EReferenceEdge> motif = instance.getMotif();
		Map<String, List<ReferenceMetaClassPair>> referencePathMap = new HashMap<String, List<ReferenceMetaClassPair>>();
		List<String> pathRoles = motif.getPathRoles();
		for (String pathRole : pathRoles) {
			String realPathRole = null;
			boolean isIntermediate = pathRole.startsWith(RoleModel2MotifConverter.INTERMEDIATE_IDENTIFIER) && pathRole.endsWith(RoleModel2MotifConverter.INTERMEDIATE_IDENTIFIER);
			if(isIntermediate){
				realPathRole = pathRole.replaceAll(RoleModel2MotifConverter.INTERMEDIATE_IDENTIFIER, "");
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

	@Override
	public boolean found(MotifInstance<MetamodelVertex, EReferenceEdge> instance) {
		count++;
		RoleMapping roleMapping = createRoleMapping(instance);
		if(roleMapping != null){
			foundRoleMappings.add(roleMapping);
		}
		if(count <= maxResultCount){
			return true;
		}
		return false;
	}

	@Override
	public void progressMade(int progress, int total) {
		System.out.println(progress + "/" + total);
	}

	@Override
	public void done() {
		System.out.println("done");
	}
	
	public List<RoleMapping> getFoundRoleMappings(){
		return foundRoleMappings;
	}
}
