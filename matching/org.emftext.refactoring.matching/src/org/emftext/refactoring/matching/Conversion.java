package org.emftext.refactoring.matching;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.CollaborationModifier;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleProhibition;
import org.qualitune.guery.EdgeSelection;
import org.qualitune.guery.GueryFactory;
import org.qualitune.guery.Motif;
import org.qualitune.guery.MotifModel;
import org.qualitune.guery.VertexSelection;

public class Conversion {
	
	private ArrayList<File> fileList;
	
	public Conversion(ArrayList<File> fileList){
		this.fileList=fileList;
	}
	
	public void simpleRoleModel2GueryTransformation(){
		for (File sourceFile : fileList){
			
			assertTrue(sourceFile.exists());
			System.out.println(sourceFile.getAbsolutePath());
			URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			EObject model = resource.getContents().get(0);
			RoleModel rolemodel = (RoleModel) model;

			// transformation
			MotifModel motifModel = GueryFactory.eINSTANCE.createMotifModel();
			Motif motif = GueryFactory.eINSTANCE.createMotif();
			motifModel.getMotifs().add(motif);
			motif.setName(rolemodel.getName());
			VertexSelection vertexSelection = GueryFactory.eINSTANCE.createVertexSelection();
			motif.setVertexSelection(vertexSelection);
			for (Role role : rolemodel.getRoles()) {
				org.qualitune.guery.Role gueryRole = GueryFactory.eINSTANCE.createRole();
				gueryRole.setName(role.getName());
				vertexSelection.getRoles().add(gueryRole);
				// usw.
			}
			EdgeSelection edgeSelection = GueryFactory.eINSTANCE.createConnectedBy();
			motif.getEdgeSelections().add(edgeSelection);
			for (Collaboration collaboration : rolemodel.getCollaborations()){
				// Role Composition && Role Association
				if (collaboration instanceof MultiplicityCollaboration){
					org.qualitune.guery.Connection gueryConnection = GueryFactory.eINSTANCE.createConnection();
					gueryConnection.setTo(vertexSelection.getRoles().get(1));
					gueryConnection.setPath(((MultiplicityCollaboration) collaboration).getTargetName());
					EList<org.qualitune.guery.Role> roleList=vertexSelection.getRoles();
					for (org.qualitune.guery.Role gueryRole:roleList){
//						System.out.println("Source: "+collaboration.getSource().getName());
						if (collaboration.getSource().getName().equals(gueryRole.getName())){
							gueryConnection.setFrom(gueryRole);
						}
//						System.out.println("Target: "+collaboration.getTarget().getName());
						if (collaboration.getTarget().getName().equals(gueryRole.getName())){
							gueryConnection.setTo(gueryRole);
						}
					}
					if (collaboration.getModifier().contains(CollaborationModifier.TRANSITIVE)){
						System.out.println("CM contains it!: ");
						gueryConnection.setMaxLength(-1);
					}
					else{
						gueryConnection.setMaxLength(1);
					}
//					for (CollaborationModifier m: collaboration.getModifier()){
//						System.out.println("CM: "+m);
////						collaboration.getModifier().contains(CollaborationModifier.TRANSITIVE);
//						if (m.getName().equals("transitive")){
//							gueryConnection.setMaxLength(-1);
//						}
//					}
					gueryConnection.setMinLength(1); //Minimale Länge 1
//					gueryConnection.setMaxLength(-1); //Maximale Länge *
					gueryConnection.setComputeAll(true); //erst alle Connections berechnen
					edgeSelection.getConnections().add(gueryConnection);
				}
				if (collaboration instanceof RoleProhibition){
					EList<org.qualitune.guery.Role> roleList=vertexSelection.getRoles();
					org.qualitune.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
					String constraintSource=null;
					String constraintTarget=null;
					for (org.qualitune.guery.Role gueryRole:roleList){
						if (collaboration.getSource().getName().equals(gueryRole.getName())){
							constraintSource=collaboration.getSource().getName();
						}
						if (collaboration.getTarget().getName().equals(gueryRole.getName())){
							constraintTarget=collaboration.getTarget().getName();
						}
					}
					gueryConstraint.setExpression(constraintSource+"!="+constraintTarget);
					vertexSelection.getConstraints().add(gueryConstraint);
				}
				if (collaboration instanceof RoleImplication){
					EList<org.qualitune.guery.Role> roleList=vertexSelection.getRoles();
					org.qualitune.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
					String constraintSource=null;
					String constraintTarget=null;
					for (org.qualitune.guery.Role gueryRole:roleList){
						if (collaboration.getSource().getName().equals(gueryRole.getName())){
							constraintSource=collaboration.getSource().getName();
						}
						if (collaboration.getTarget().getName().equals(gueryRole.getName())){
							constraintTarget=collaboration.getTarget().getName();
						}
					}
					gueryConstraint.setExpression(constraintSource+" instanceof "+constraintTarget);
					vertexSelection.getConstraints().add(gueryConstraint);
				}
				//TODO RoleProhibition
				//TODO RoleImplication
			}
			File targetFile = new File(rolemodel.getName() + ".guery");
			if(targetFile.exists()){
				targetFile.delete();
			} 
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			assertTrue(targetFile.exists());
			URI targetUri = URI.createFileURI(targetFile.getAbsolutePath());
			Resource targetResource = resourceSet.createResource(targetUri);
			assertNotNull(targetResource);
			targetResource.getContents().add(motifModel);
			try {
				targetResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
	}

}
