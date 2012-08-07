package org.emftext.refactoring.matching;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.junit.Test;
import org.qualitune.guery.GueryFactory;
import org.qualitune.guery.GueryPackage;
import org.qualitune.guery.Motif;
import org.qualitune.guery.MotifModel;
import org.qualitune.guery.VertexSelection;
import org.qualitune.guery.resource.guery.mopp.GueryResourceFactory;

public class Conversion {

	@Test
	public void testTransformationSimple(){
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("rolestext", new RolestextResourceFactory());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("guery", new GueryResourceFactory());

		File sourceFile = new File("..\\org.emftext.refactoring.extractX\\rolemodel\\ExtractX.rolestext");
		assertTrue(sourceFile.exists());
		System.out.println(sourceFile.getAbsolutePath());
		URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
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
