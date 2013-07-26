package org.emftext.refactoring.matching.guery;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.qualitune.guery.GueryPackage;
import org.qualitune.guery.resource.guery.mopp.GueryResourceFactory;

public class ConversionTest {

	public void testTransformationSimple(){
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("rolestext", new RolestextResourceFactory());
		extensionToFactoryMap.put("guery", new GueryResourceFactory());

		ArrayList<File> fileList=new ArrayList<File>();
		File sourceFile0 = new File("..\\org.emftext.refactoring.duplicateX\\rolemodel\\DuplicateX.rolestext");
		File sourceFile1 = new File("..\\org.emftext.refactoring.extractSubX\\rolemodel\\ExtractSubX.rolestext");
		File sourceFile2 = new File("..\\org.emftext.refactoring.extractX\\rolemodel\\ExtractX.rolestext");
		File sourceFile3 = new File("..\\org.emftext.refactoring.extractX\\rolemodel\\ExtractXtoNewParent.rolestext");
		File sourceFile4 = new File("..\\org.emftext.refactoring.extractX\\rolemodel\\ExtractXtoNewParentWithRestriction.rolestext");
		File sourceFile5= new File("..\\org.emftext.refactoring.extractXfromChildren\\rolemodel\\extractXfromChildren.rolestext");
		File sourceFile6 = new File("..\\org.emftext.refactoring.extractXwithReferenceClass\\rolemodel\\ExtractXwithReferenceClass.rolestext");
		File sourceFile7 = new File("..\\org.emftext.refactoring.introduceReferenceClass\\rolemodel\\IntroduceReferenceClass.rolestext");
		File sourceFile8 = new File("..\\org.emftext.refactoring.introduceSimpleReferenceClass\\rolemodel\\IntroduceSimpleReferenceClass.rolestext");
		File sourceFile9 = new File("..\\org.emftext.refactoring.moveX\\rolemodel\\MoveX.rolestext");
		File sourceFile10 = new File("..\\org.emftext.refactoring.moveXloosely\\rolemodel\\moveXloosely.rolestext");
		File sourceFile11 = new File("..\\org.emftext.refactoring.moveXTowards\\rolemodel\\MoveXTowardsBack.rolestext");
		File sourceFile12 = new File("..\\org.emftext.refactoring.moveXTowards\\rolemodel\\MoveXTowardsFront.rolestext");
		File sourceFile13 = new File("..\\org.emftext.refactoring.removeEmptyContainedX\\rolemodel\\removeEmptyContainedX.rolestext");
		File sourceFile14 = new File("..\\org.emftext.refactoring.removeUnusedContainedX\\rolemodel\\removeUnusedContainedX.rolestext");
		File sourceFile15 = new File("..\\org.emftext.refactoring.renameX\\rolemodel\\RenameX.rolestext");
		File sourceFile16 = new File("..\\org.emftext.refactoring.rereferenceSubX\\rolemodel\\rereferenceSubX.rolestext");
		File sourceFile17 = new File("..\\org.emftext.refactoring.selectX\\rolemodel\\SelectX.rolestext");
		File sourceFile18 = new File("..\\org.emftext.refactoring.selectXWith2Vars\\rolemodel\\SelectXWith2Vars.rolestext");
		File sourceFile19 = new File("..\\org.emftext.refactoring.selectXWithVar\\rolemodel\\SelectXWithVar.rolestext");
		File sourceFile20 = new File("..\\org.emftext.refactoring.extractXwithReferenceClass\\rolemodel\\ExtractXwithReferenceClassTest.rolestext");
		File sourceFile21 = new File("..\\org.emftext.refactoring.moveXloosely\\rolemodel\\moveXlooselyTest.rolestext");
		File sourceFile22 = new File("..\\org.emftext.refactoring.extractX\\rolemodel\\ExtractXtoNewParentWithRestrictionTest.rolestext");
//		fileList.add(sourceFile0);
//		fileList.add(sourceFile1);
		fileList.add(sourceFile2);
//		fileList.add(sourceFile3);
//		fileList.add(sourceFile4);
//		fileList.add(sourceFile5);
//		fileList.add(sourceFile6);
//		fileList.add(sourceFile7);
//		fileList.add(sourceFile8);
//		fileList.add(sourceFile9);
//		fileList.add(sourceFile10);
//		fileList.add(sourceFile11);
//		fileList.add(sourceFile12);
//		fileList.add(sourceFile13);
//		fileList.add(sourceFile14);
//		fileList.add(sourceFile15);
//		fileList.add(sourceFile16);
//		fileList.add(sourceFile17);
//		fileList.add(sourceFile18);
//		fileList.add(sourceFile19);
//		fileList.add(sourceFile20);
//		fileList.add(sourceFile21);
//		fileList.add(sourceFile22);
		
		Conversion conversion=new Conversion(fileList);
		conversion.roleModel2GueryTransformation();
	}
}
