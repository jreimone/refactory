package org.emftext.refactoring.matching.guery;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
import org.qualitune.evolution.guery.graph.ContainmentEdge;
import org.qualitune.guery.EdgeSelection;
import org.qualitune.guery.GueryFactory;
import org.qualitune.guery.Motif;
import org.qualitune.guery.MotifModel;
import org.qualitune.guery.VertexSelection;
import org.qualitune.guery.resource.guery.IGueryTextResource;
import org.qualitune.guery.resource.guery.mopp.GueryPrinter2;

public class Conversion {

	private static int maxLength=3;
	private static boolean saveAsFile=true;
	private ArrayList<File> fileList;
	private EPackage epackage;
	private ResourceSet resourceSet;
	private RoleModel rolemodel;
	private Motif motif;
	private MotifModel motifModel;
	private VertexSelection vertexSelection;
	private ByteArrayOutputStream os;

	public Conversion(ArrayList<File> fileList){
		this.fileList=fileList;
//		this.epackage = (EPackage) EPackage.Registry.INSTANCE.get(PL0Package.eNS_URI);
//		this.epackage=EPackage.Registry.INSTANCE.getEPackage(PL0Package.eNS_URI);
		epackage=PL0Package.eINSTANCE;
		System.out.println("EPackage: "+epackage);
	}

	public void roleModel2GueryTransformation(){
		for (File sourceFile : fileList){
			assertTrue(sourceFile.exists());
			URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
			resourceSet = new ResourceSetImpl();
			resourceSet.createResource(uri);
			Resource resource = resourceSet.getResource(uri, true);
			EObject model = resource.getContents().get(0);
			rolemodel = (RoleModel) model;
			calculateVersions();
		}
	}

	private void calculateVersions() {
		int versions=countVersions(rolemodel);
		for (int i=1;i<=versions;i++){
			transform(i);
		}
	}

	private void transform(int version) {
		motifModel = GueryFactory.eINSTANCE.createMotifModel();
		motif = GueryFactory.eINSTANCE.createMotif();
		motifModel.getMotifs().add(motif);
		motif.setName(rolemodel.getName());
		vertexSelection = GueryFactory.eINSTANCE.createVertexSelection();
		motif.setVertexSelection(vertexSelection);
		ArrayList<Role> optionalRoles=new ArrayList<Role>();
		for (Role role : rolemodel.getRoles()){
			for (RoleModifier rm:role.getModifier()){
				if (rm == RoleModifier.OPTIONAL){
					optionalRoles.add(role);
				}
			}
		}
		for (Role role : rolemodel.getRoles()) {
			createRole(version, optionalRoles, role);
		}
		for (Collaboration collaboration : rolemodel.getCollaborations()){
			createCollaboration(version, optionalRoles, collaboration);
		}

		saveMotif(version);
		startSolver();
	}

	private void createRole(int version, ArrayList<Role> optionalRoles, Role role) {
		if (showRole(version-1,optionalRoles,role)){
			org.qualitune.guery.Role gueryRole = GueryFactory.eINSTANCE.createRole();
			gueryRole.setName(role.getName());
			vertexSelection.getRoles().add(gueryRole);
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

	private void createCollaboration(int version, ArrayList<Role> optionalRoles, Collaboration collaboration) {
		EdgeSelection edgeSelection = GueryFactory.eINSTANCE.createConnectedBy();
		EdgeSelection edgeSelection2 = GueryFactory.eINSTANCE.createConnectedBy();
		boolean showCol=true;
		// Role Composition && Role Association
		if (collaboration instanceof MultiplicityCollaboration){
			showCol=createMultiplicityCollaboration(edgeSelection, edgeSelection2,version, optionalRoles, collaboration);
		}

		if (collaboration instanceof RoleProhibition){
			createRoleProhibition(collaboration);
		}

		if (collaboration instanceof RoleImplication){
			createRoleImplication(collaboration);
		}
		if (showCol){
			motif.getEdgeSelections().add(edgeSelection);
			if (maxLength>1||maxLength<0){
				motif.getEdgeSelections().add(edgeSelection2);
			}
		}
	}


	private boolean createMultiplicityCollaboration(EdgeSelection edgeSelection, EdgeSelection edgeSelection2,int version, ArrayList<Role> optionalRoles, Collaboration collaboration) {
		boolean showCol=true;
		boolean foundSource=false;
		boolean foundTarget=false;
		org.qualitune.guery.Connection gueryConnection = GueryFactory.eINSTANCE.createConnection();
		gueryConnection.setPath(((MultiplicityCollaboration) collaboration).getTargetName());
		EList<org.qualitune.guery.Role> roleList=vertexSelection.getRoles();
		for (org.qualitune.guery.Role gueryRole:roleList){
			if (collaboration.getSource().getName().equals(gueryRole.getName())){
				foundSource=true;
				if (optionalRoles.contains(collaboration.getSource())){
					showCol=showRole(version-1,optionalRoles,collaboration.getSource());
				}
				gueryConnection.setFrom(gueryRole);
			}
			if (collaboration.getTarget().getName().equals(gueryRole.getName())){
				foundTarget=true;
				if (optionalRoles.contains(collaboration.getTarget())){
					showCol=showRole(version-1,optionalRoles,collaboration.getSource());
				}
				gueryConnection.setTo(gueryRole);
			}
		}
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
		gueryConnection.setComputeAll(true); //erst alle Connections berechnen
		if (showCol&&foundSource&&foundTarget){
			edgeSelection.getConnections().add(gueryConnection);
			if (collaboration instanceof RoleComposition){
				org.qualitune.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
				gueryConstraint.setExpression(((MultiplicityCollaboration) collaboration).getTargetName()+" is " + ContainmentEdge.class.getName());
				edgeSelection.getConstraints().add(gueryConstraint);
			}
			else{
				org.qualitune.guery.Constraint gueryConstraint = GueryFactory.eINSTANCE.createConstraint();
				gueryConstraint.setExpression("!("+((MultiplicityCollaboration) collaboration).getTargetName()+" is " + ContainmentEdge.class.getName() + ")");
				edgeSelection.getConstraints().add(gueryConstraint);
			}
		}
		return showCol;
	}

	private void createRoleProhibition(Collaboration collaboration) {
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

	private void createRoleImplication(Collaboration collaboration) {
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

	private void saveMotif(int version) {
		File targetFile = new File(rolemodel.getName() +"V"+version+ ".guery");
		if (saveAsFile){
			if(targetFile.exists()){
				targetFile.delete();
			}
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			assertTrue(targetFile.exists());
		}
		URI targetUri = URI.createFileURI(targetFile.getAbsolutePath());
		Resource targetResource = resourceSet.createResource(targetUri);
		assertNotNull(targetResource);
		targetResource.getContents().add(motifModel);
		os=new ByteArrayOutputStream() ;
		try {
			if (saveAsFile){
				targetResource.save(Collections.EMPTY_MAP);
			}
			targetResource.save(os, Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private OutputStream getStreamFromMotif(MotifModel motifModel){
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		GueryPrinter2 printer = new GueryPrinter2(os, (IGueryTextResource) motifModel.eResource());
		try {
			printer.print(motifModel);
			return os;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void startSolver() {
		Resource pl0resource = PL0Package.eINSTANCE.eResource();
		SolvingMotif solver = new SolvingMotif(pl0resource, epackage, os, rolemodel);
		solver.findMotifInstancesFromOutputStream();
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

	private boolean showRole(int version, ArrayList<Role> optionalRoles, Role role){
		int pos=optionalRoles.indexOf(role);
		if (pos==-1){
			return true;
		}
		String test=Integer.toBinaryString(version);
		String dual="";
		for (int i3=optionalRoles.size();i3>test.length();i3--){
			dual=dual+"0";
		}
		dual=dual+test;
		if (dual.subSequence(pos, pos+1).equals("0")){
			return false;
		}
		else{
			return true;
		}
	}
}
