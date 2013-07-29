package org.modelrefactoring.matching.guery;

import java.util.List;

import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifInstance;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RolemappingFactory;
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
		Motif<MetamodelVertex, EReferenceEdge> motif = instance.getMotif();
		List<String> roles = motif.getRoles();
		RoleMapping roleMapping = RolemappingFactory.eINSTANCE.createRoleMapping();
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
			}
		}
		return roleMapping;
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
}
