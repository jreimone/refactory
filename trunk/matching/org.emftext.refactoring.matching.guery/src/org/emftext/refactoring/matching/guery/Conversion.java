package org.emftext.refactoring.matching.guery;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.pl0.PL0Package;
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
import org.qualitune.guery.Connection;
import org.qualitune.guery.EdgeSelection;
import org.qualitune.guery.GueryFactory;
import org.qualitune.guery.Motif;
import org.qualitune.guery.MotifModel;
import org.qualitune.guery.VertexSelection;

public class Conversion {
	
	private ArrayList<File> fileList;
	private static int maxLength=3;
//	private boolean debug=true;
	private boolean debug=false;
	
	public Conversion(ArrayList<File> fileList){
		this.fileList=fileList;
	}
	
	public void simpleRoleModel2GueryTransformation(){
		for (File sourceFile : fileList){
			assertTrue(sourceFile.exists());
			if (debug){
				System.out.println(sourceFile.getAbsolutePath());
			}
			URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			EObject model = resource.getContents().get(0);
			RoleModel rolemodel = (RoleModel) model;
			
			int versions=countVersions(rolemodel);
			if (debug){
				System.out.println("Anzahl Versionen: "+versions);
			}
			
			for (int i=1;i<=versions;i++){
				MotifModel motifModel = GueryFactory.eINSTANCE.createMotifModel();
				Motif motif = GueryFactory.eINSTANCE.createMotif();
				motifModel.getMotifs().add(motif);
				motif.setName(rolemodel.getName());
				VertexSelection vertexSelection = GueryFactory.eINSTANCE.createVertexSelection();
				motif.setVertexSelection(vertexSelection);
				ArrayList<Role> optionalRoles=new ArrayList<Role>();
				for (Role role : rolemodel.getRoles()){
					if (debug){
						System.out.println("Rolle: "+role.getName());
						System.out.println("Modifier: "+role.getModifier());
					}
					for (RoleModifier rm:role.getModifier()){
						if (rm.getValue()==0){
							optionalRoles.add(role);
						}
					}
					if (debug){
						for (Role r:optionalRoles)
							System.out.println("Optionale Rolle: "+r);
					}
				}
				for (Role role : rolemodel.getRoles()) {
					if (showRole(i-1,optionalRoles,role)){
						org.qualitune.guery.Role gueryRole = GueryFactory.eINSTANCE.createRole();
						gueryRole.setName(role.getName());
						vertexSelection.getRoles().add(gueryRole);
						
//						org.qualitune.guery.Constraint gueryRoleConstraint = GueryFactory.eINSTANCE.createConstraint();
//						gueryRoleConstraint.setExpression(role.getName()+"!=null");
//						vertexSelection.getConstraints().add(gueryRoleConstraint);

						int attributes=role.getAttributes().size();
						int optional=0;
						for (RoleAttribute attribut:role.getAttributes()){
							for (RoleModifier rm:attribut.getModifier()){
								if (rm.getValue()==0){
									optional++;
								}
							}
						}
						if (attributes>0){
							org.qualitune.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
							if (optional>0){ //wenn optionale Attribute
								if (attributes>optional){ //wenn nicht alle Attribute optional
									gueryConstraint.setExpression(role.getName()+".getEClass().getEAttributes().size()>0");
								}
								//wenn alle Attribute optional -> Kein Test auf Attributanzahl
							}
							else{
								gueryConstraint.setExpression(role.getName()+".getEClass().getEAttributes().size()>0");
								vertexSelection.getConstraints().add(gueryConstraint);
							}
						}
					}
				}
//				EdgeSelection edgeSelection = GueryFactory.eINSTANCE.createConnectedBy();
//				if (rolemodel.getCollaborations().size()>0){
//					motif.getEdgeSelections().add(edgeSelection);
//				}
				for (Collaboration collaboration : rolemodel.getCollaborations()){
					EdgeSelection edgeSelection = GueryFactory.eINSTANCE.createConnectedBy();
					EdgeSelection edgeSelection2 = GueryFactory.eINSTANCE.createConnectedBy();
					boolean showCol=true;
					boolean foundSource=false;
					boolean foundTarget=false;
					// Role Composition && Role Association
					if (collaboration instanceof MultiplicityCollaboration){
						org.qualitune.guery.Connection gueryConnection = GueryFactory.eINSTANCE.createConnection();
						gueryConnection.setPath(((MultiplicityCollaboration) collaboration).getTargetName());
						EList<org.qualitune.guery.Role> roleList=vertexSelection.getRoles();
						for (org.qualitune.guery.Role gueryRole:roleList){
//							System.out.println("Source: "+collaboration.getSource().getName());
							if (collaboration.getSource().getName().equals(gueryRole.getName())){
								foundSource=true;
								if (optionalRoles.contains(collaboration.getSource())){
									showCol=showRole(i-1,optionalRoles,collaboration.getSource());
								}
								gueryConnection.setFrom(gueryRole);
							}
//							System.out.println("Target: "+collaboration.getTarget().getName());
							if (collaboration.getTarget().getName().equals(gueryRole.getName())){
								foundTarget=true;
								if (optionalRoles.contains(collaboration.getTarget())){
									showCol=showRole(i-1,optionalRoles,collaboration.getSource());
								}
								gueryConnection.setTo(gueryRole);
							}
						}
						//TODO richtig so?
						if (collaboration.getModifier().contains(CollaborationModifier.TRANSITIVE)){
							if (maxLength>1&&showCol){
								gueryConnection.setMinLength(1);
								gueryConnection.setMaxLength(1);
								org.qualitune.guery.Role gueryRolePH = GueryFactory.eINSTANCE.createRole();
								gueryRolePH.setName(((MultiplicityCollaboration) collaboration).getTargetName()+"PH");
								vertexSelection.getRoles().add(gueryRolePH);
								
								org.qualitune.guery.Connection gueryConnection2 = GueryFactory.eINSTANCE.createConnection();
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
									org.qualitune.guery.Role gueryRolePH = GueryFactory.eINSTANCE.createRole();
									gueryRolePH.setName(((MultiplicityCollaboration) collaboration).getTargetName()+"PH");
									vertexSelection.getRoles().add(gueryRolePH);
									
									org.qualitune.guery.Connection gueryConnection2 = GueryFactory.eINSTANCE.createConnection();
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

//						gueryConnection.setMinLength(0); //Minimale Länge 1
//						gueryConnection.setMaxLength(1); //Maximale Länge *
						gueryConnection.setComputeAll(true); //erst alle Connections berechnen
						if (showCol&&foundSource&&foundTarget){
							edgeSelection.getConnections().add(gueryConnection);
							if (collaboration instanceof RoleComposition){
								org.qualitune.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
								gueryConstraint.setExpression(((MultiplicityCollaboration) collaboration).getTargetName()+" is org.qualitune.evolution.guery.graph.ContainmentEdge");
								edgeSelection.getConstraints().add(gueryConstraint);
							}
							else{
								org.qualitune.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
								gueryConstraint.setExpression("!("+((MultiplicityCollaboration) collaboration).getTargetName()+" is org.qualitune.evolution.guery.graph.ContainmentEdge)");
								edgeSelection.getConstraints().add(gueryConstraint);
							}
						}
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
						if ((constraintSource!=null)&&(constraintTarget!=null)){
							gueryConstraint.setExpression(constraintSource+"!="+constraintTarget);
							vertexSelection.getConstraints().add(gueryConstraint);
						}
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
						if ((constraintSource!=null)&&(constraintTarget!=null)){
							gueryConstraint.setExpression(constraintSource+" == "+constraintTarget);
							vertexSelection.getConstraints().add(gueryConstraint);
						}
					}
					if (showCol){
						motif.getEdgeSelections().add(edgeSelection);
						if (maxLength>1||maxLength<0){
							motif.getEdgeSelections().add(edgeSelection2);
						}
					}
				}
				File targetFile = new File(rolemodel.getName() +"V"+i+ ".guery");
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
				//				OutputStream os=new OutputStream();
				ByteArrayOutputStream os=new ByteArrayOutputStream() ;
//				BufferedOutputStream outputStream = new BufferedOutputStream(os);
				try {
					targetResource.save(Collections.EMPTY_MAP);
					targetResource.save(os, Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (debug){
					System.out.println("Optionale Rollen: "+optionalRoles);
					System.out.println(os);
				}
				System.out.println(os);
				System.out.println("~~~");
				for (EdgeSelection es:motif.getEdgeSelections()){
					for (Connection c:es.getConnections()){
						System.out.println(c);
					}
				}
				Resource pl0resource = PL0Package.eINSTANCE.eResource();
				SolvingMotif solver = new SolvingMotif(pl0resource,os);
				solver.findMotifInstancesFromOutputStream();
			}
		}
	}
	
	public int countVersions(RoleModel rolemodel){
		int result=0;
		int countR=0; //Anzahl optionaler Rollen
		for (Role role : rolemodel.getRoles()) {
			EList<RoleModifier> rmlist=role.getModifier();
			for (RoleModifier rm: rmlist){
				if (rm.getValue()==0){
					countR++;
				}
			}
		}
		/**
		 * Wenn keine Paare dann ist Anzahl Varianten 
		 * 2^(Anzahl optionaler Rollen+Anzahl optionaler Attribute)
		 */
		result=(int) Math.pow(2,(countR));
		return result;
	}
	
	public boolean showRole(int version, ArrayList<Role> optionalRoles, Role role){
		String test=Integer.toBinaryString(version);
		String dual="";
//			System.out.println(test.length());
		for (int i3=optionalRoles.size();i3>test.length();i3--){
			dual=dual+"0";
		}
		dual=dual+test;
		int pos=optionalRoles.indexOf(role);
		if (pos==-1){
			return true;
		}
		if (dual.subSequence(pos, pos+1).equals("0")){
			if (debug){
				System.out.println("Dual: "+dual);
				System.out.println("False");
			}
			return false;
		}
		else{
			if (debug){
				System.out.println("Dual: "+dual);
				System.out.println("True");
			}
			return true;
		}
	}
		
	public boolean showRole(int version, ArrayList<Role> optionalRoles, String rolename){
		ArrayList<String> optionalRolesNames=new ArrayList<String>();
		for (Role r:optionalRoles){
			optionalRolesNames.add(r.getName());
		}
		String test=Integer.toBinaryString(version);
		String dual="";
//			System.out.println(test.length());
		for (int i3=optionalRoles.size();i3>test.length();i3--){
			dual=dual+"0";
		}
		dual=dual+test;
		int pos=optionalRolesNames.indexOf(rolename);
		if (pos==-1){
			return true;
		}
		if (dual.subSequence(pos, pos+1).equals("0")){
			if (debug){
				System.out.println("Dual: "+dual);
				System.out.println("False");
			}
			return false;
		}
		else{
			if (debug){
				System.out.println("Dual: "+dual);
				System.out.println("True");
			}
			return true;
		}
	}

}
