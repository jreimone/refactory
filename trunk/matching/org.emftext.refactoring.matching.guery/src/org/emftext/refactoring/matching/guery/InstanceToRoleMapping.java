package org.emftext.refactoring.matching.guery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifInstance;
import nz.ac.massey.cs.guery.Path;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingFactory;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.qualitune.evolution.guery.graph.MetamodelVertex;
import org.qualitune.evolution.guery.registry.EObjectVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;
import org.qualitune.guery.GueryPackage;
import org.qualitune.guery.resource.guery.mopp.GueryResourceFactory;

public class InstanceToRoleMapping {

	private MotifInstance<MetamodelVertex,EReferenceEdge> instance;
	private RoleModel rolemodel;
	private Motif<MetamodelVertex,EReferenceEdge> motif;
	private EPackage epackage;

	public InstanceToRoleMapping(MotifInstance<MetamodelVertex,EReferenceEdge> instance, RoleModel rolemodel, EPackage epackage/*, Resource targetMetamodel*/){
		this.rolemodel=rolemodel;
		this.epackage=epackage;
		EPackage.Registry.INSTANCE.put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("rolemapping", new RolemappingResourceFactory());
		extensionToFactoryMap.put("guery", new GueryResourceFactory());
		this.instance=instance;
	}

	public Collection<CollaborationMapping> getAllCollaborationMappings(EClass modelElement, Role role){
		ArrayList<CollaborationMapping> colm=new ArrayList<CollaborationMapping>();
		EList<Collaboration> test=role.getOutgoing();
		ArrayList<String> targets=new ArrayList<String>();
		for (Collaboration c:test){
			targets.add(((MultiplicityCollaboration) c).getTargetName());
		}
		HashMap<String,ArrayList<EReferenceEdge>> edgeMap=new HashMap<String, ArrayList<EReferenceEdge>>();
		for (String edgeRole:motif.getPathRoles()) {
			if (!edgeRole.endsWith("2")&&targets.contains(edgeRole)){
				ArrayList<EReferenceEdge> edgeList=new ArrayList<EReferenceEdge>();
				Path<MetamodelVertex,EReferenceEdge> path = instance.getPath(edgeRole);
				List<EReferenceEdge> edges = path.getEdges();
				if (edges.get(0).getStart().getModelElement().equals(modelElement)){
					for (EReferenceEdge edge : edges) {
						edgeList.add(edge);
						if (edgeMap.containsKey(edgeRole)){
							edgeMap.get(edgeRole).add(edge);
						}
						else{
							edgeMap.put(edgeRole, edgeList);
						}
					}
				}
			}
			else{
				if (edgeRole.endsWith("2")&&targets.contains(edgeRole.substring(0, edgeRole.length()-1))){
					ArrayList<EReferenceEdge> edgeList=new ArrayList<EReferenceEdge>();
					Path<MetamodelVertex,EReferenceEdge> path = instance.getPath(edgeRole);
					List<EReferenceEdge> edges = path.getEdges();
					if (edges.size()!=0){
						for (EReferenceEdge edge : edges) {
							edgeList.add(edge);
							if (edgeMap.containsKey(edgeRole.substring(0, edgeRole.length()-1))){
								edgeMap.get(edgeRole.substring(0, edgeRole.length()-1)).add(edge);
							}
							else{
								edgeMap.put(edgeRole.substring(0, edgeRole.length()-1), edgeList);
							}
						}
					}
				}
			}
		}
		for (String s:edgeMap.keySet()){
			CollaborationMapping cm=RolemappingFactory.eINSTANCE.createCollaborationMapping();
			for (Collaboration c:test){
				if (((MultiplicityCollaboration) c).getTargetName().equals(s)){
					cm.setCollaboration((MultiplicityCollaboration)c);
				}
			}
			ArrayList<EReferenceEdge> list=edgeMap.get(s);
			cm.getReferenceMetaClassPair().addAll(getAllReferenceMetaClassPairs(list));
			colm.add(cm);
		}
		return colm;
	}

	public Collection<ReferenceMetaClassPair> getAllReferenceMetaClassPairs(ArrayList<EReferenceEdge> list){
		ArrayList<ReferenceMetaClassPair> rmcp=new ArrayList<ReferenceMetaClassPair>();
		for (EReferenceEdge eref:list){
			ReferenceMetaClassPair pair=RolemappingFactory.eINSTANCE.createReferenceMetaClassPair();
			pair.setMetaClass((EClass)eref.getStart().getModelElement());
			pair.setReference(eref.getReference());
			rmcp.add(pair);
		}
		return rmcp;
	}
	
	public void transform2RoleMapping(){
		RoleMapping roleMapping = RolemappingFactory.eINSTANCE.createRoleMapping();
		RoleMappingModel roleMappingModel = RolemappingFactory.eINSTANCE.createRoleMappingModel();
		
//		AttributeMapping attributeMapping = RolemappingFactory.eINSTANCE.createAttributeMapping();
//		CollaborationMapping collaborationMapping = RolemappingFactory.eINSTANCE.createCollaborationMapping();
//		ReferenceMetaClassPair referenceMetaClassPair = RolemappingFactory.eINSTANCE.createReferenceMetaClassPair();
		
		motif=instance.getMotif();
		for (Role role : rolemodel.getRoles()){
			ConcreteMapping concreteMapping = RolemappingFactory.eINSTANCE.createConcreteMapping();
			MetamodelVertex mv =instance.getVertex(role.getName());
			concreteMapping.setMetaclass((EClass)mv.getModelElement());
			concreteMapping.setRole(role);
			concreteMapping.getCollaborationMappings().addAll(getAllCollaborationMappings((EClass)mv.getModelElement(),role));
			//TODO Attributmapping
			roleMapping.getRoleToMetaelement().add(concreteMapping);
		}
		
		roleMappingModel.setTargetMetamodel(epackage);
		roleMapping.setOwningMappingModel(roleMappingModel);
		roleMapping.setMappedRoleModel(rolemodel);
		roleMapping.setName("ChoiceOfDeveloper");
		
		
		printMotifInstance();
	}
	
	public void printMotifInstance(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		motif = instance.getMotif();
		List<String> edges = motif.getPathRoles();
		for (String edge : edges) {
			System.out.println("Edge: " + edge);
			Path<MetamodelVertex, EReferenceEdge> path = instance.getPath(edge);
			List<EReferenceEdge> realEdges = path.getEdges();
			for (EReferenceEdge referenceEdge : realEdges) {
				EObjectVertex start = referenceEdge.getStart();
				EObjectVertex end = referenceEdge.getEnd();
				EReference reference = referenceEdge.getReference();
				EClass startMC = (EClass) start.getModelElement();
				EClass endMC = (EClass) end.getModelElement();
				System.out.println("Reference: " + reference.getName());
				System.out.println("Start:" + startMC.getName());
				System.out.println("End: " + endMC.getName());
				System.out.println("~~~~");
			}
			System.out.println("-------------");
		}
	}
}