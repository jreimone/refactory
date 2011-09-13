package org.emftext.refactoring.rolemodelmatching;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.roles.RoleModel;


public class RolemodelMatchingTestSuite {

	public static final int MAX_MAPPINGS_COUNT		= 20;
	
	public static final String ROLE_CONNECTOR 		= ":";
	public static final String COLL_CONNECTOR 		= "#";
	public static final String MAPPING_SEPARATOR	= ";";
	
	public static final String MAPPING_FILE 				= "mappings";
	public static final String ALL_VALID_MAPPINGS_FILE 		= "avm";
	public static final String FILTERED_MATCHES_FILE 		= "fm";
	public static final String FILTERED_MATCHES_FILE_SHORT 	= "fms";
	public static final String FILTERED_MAPPING_FILE 		= "filtered";
	public static final String FILE_EXT 					= "txt";
	public static final String FILE_CSV_EXT					= "csv";
	public static final String RESULTS_DIR 					= "test_results/";
	public static final String HUDSON_RESULTS_DIR 			= "/srv/hudson/jobs/Dropsbox Build/workspace/build/" + RESULTS_DIR;
	public static String MATCHING_RESULTS_ROOT 				= "results-org.emftext.refactoring.rolemodelmatching.test/";
	public static final String MATCHING_RESULTS 			= "matching_results/";
	
	
	public static final String RM_RENAME_X 						= "platform:/resource/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext";
	public static final String RM_REMOVE_UNUSED_CONTAINED_X 	= "platform:/resource/org.emftext.refactoring.removeUnusedContainedX/rolemodel/removeUnusedContainedX.rolestext";
	public static final String RM_REMOVE_EMPTY_CONTAINED_X 		= "platform:/resource/org.emftext.refactoring.removeEmptyContainedX/rolemodel/removeEmptyContainedX.rolestext";
	public static final String RM_MOVE_XLOOSELY 				= "platform:/resource/org.emftext.refactoring.moveXloosely/rolemodel/moveXloosely.rolestext";
	public static final String RM_MOVE_X 						= "platform:/resource/org.emftext.refactoring.moveX/rolemodel/moveX.rolestext";
	public static final String RM_INTRODUCE_REFERENCE_CLASS 	= "platform:/resource/org.emftext.refactoring.introduceReferenceClass/rolemodel/IntroduceReferenceClass.rolestext";
	public static final String RM_EXTRACT_XWITH_REFERENCE_CLASS = "platform:/resource/org.emftext.refactoring.extractXwithReferenceClass/rolemodel/ExtractXwithReferenceClass.rolestext";
	public static final String RM_EXTRACT_SUB_X 				= "platform:/resource/org.emftext.refactoring.extractSubX/rolemodel/ExtractSubX.rolestext";
	public static final String RM_EXTRACT_X 					= "platform:/resource/org.emftext.refactoring.extractX/rolemodel/ExtractX.rolestext";
	
	
	public static final String MM_UML 				= "http://www.eclipse.org/uml2/3.0.0/UML";
	public static final String MM_ECORE 			= "http://www.eclipse.org/emf/2002/Ecore";
	public static final String MM_JAVA 				= "platform:/resource/org.emftext.language.java/metamodel/java.ecore";
	public static final String MM_TEXTADVENTURE 	= "platform:/resource/org.emftext.language.textadventure/metamodel/textadventure.ecore";
	public static final String MM_FORMS 			= "platform:/resource/org.emftext.language.forms/metamodel/forms.ecore";
	public static final String MM_PL0 				= "platform:/resource/org.emftext.language.pl0/metamodel/pl0.ecore";
	public static final String MM_TESTMM 			= "platform:/resource/org.emftext.refactoring.rolematching.testmm/metamodel/testmm.ecore";
	public static final String MM_APPFLOW 			= "platform:/resource/org.emftext.language.appflow/metamodel/appflow.text.ecore";
	public static final String MM_CS 				= "platform:/resource/org.emftext.sdk.concretesyntax/metamodel/concretesyntax.ecore";
	public static final String MM_FEATURE 			= "platform:/resource/org.featuremapper.models.feature/model/feature.ecore";
	public static final String MM_TA 				= "platform:/resource/org.emftext.language.timedautomata/metamodel/timedAutomata.ecore";
	public static final String MM_OWL 				= "platform:/resource/org.emftext.language.owl/metamodel/owl.text.ecore";
	public static final String MM_ROLES 			= "platform:/resource/org.emftext.language.refactoring.roles/metamodel/roles.ecore";
	public static final String MM_REFSPEC 			= "platform:/resource/org.emftext.language.refactoring.specification/metamodel/refactoring_specification.ecore";
	public static final String MM_ROLEMAPPING 		= "platform:/resource/org.emftext.language.refactoring.rolemapping/metamodel/rolemapping.ecore";
	public static final String MM_CONFERENCE 		= "platform:/resource/org.emftext.language.conference/metamodel/conference.ecore";
	public static final String MM_OFFICE 			= "platform:/resource/org.emftext.language.office/metamodel/office.ecore";
	public static final String MM_SIMPLEGUI 		= "platform:/resource/org.emftext.language.simplegui/metamodel/simplegui.ecore";
	public static final String MM_SANDWICH 			= "platform:/resource/org.emftext.language.sandwich/metamodel/sandwich_simple.ecore";
	public static final String MM_BPMN 				= "http://stp.eclipse.org/bpmn";
	
	public static final String[] rolemodelURIs = new String[] { 
			RM_EXTRACT_X
			,RM_EXTRACT_SUB_X 
			,RM_EXTRACT_XWITH_REFERENCE_CLASS 
			,RM_INTRODUCE_REFERENCE_CLASS 
			,RM_MOVE_X 
			,RM_MOVE_XLOOSELY 
			,RM_REMOVE_EMPTY_CONTAINED_X 
			,RM_REMOVE_UNUSED_CONTAINED_X
			,RM_RENAME_X
		};
	
	public static final String[] metamodelURIs = new String[] { 
			//		MM_APPFLOW
			MM_TESTMM
			,MM_PL0
			,MM_FORMS
			,MM_TEXTADVENTURE
			,MM_JAVA
			,MM_FEATURE
			,MM_TA
			,MM_OWL
			,MM_ROLES
			,MM_REFSPEC
			,MM_ROLEMAPPING
			,MM_CONFERENCE
			,MM_OFFICE
			,MM_SIMPLEGUI
			,MM_SANDWICH
			,MM_CS
		};

	public FileWriter getFileWriter(String fileNamePrefix, RoleModel rolemodel, EPackage metamodel) {
		return getFileWriter(fileNamePrefix, rolemodel, metamodel, FILE_EXT);
	}
	
	public FileWriter getFileWriter(String fileNamePrefix, RoleModel rolemodel, EPackage metamodel, String fileExtension) {
		File file = null;
		final String fileName = getFileName(fileNamePrefix, rolemodel, metamodel, fileExtension);
		file = getFile(fileName);
		try {
			File parentFolder = file.getParentFile();
			File[] files = parentFolder.listFiles(new FilenameFilter() {
	
				public boolean accept(File dir, String name) {
					if(name.equals(fileName)){
						return true;
					}
					return false;
				}
			});
			for (File fileToDelete : files) {
				fileToDelete.delete();
			}
			if(file.createNewFile()){
				FileWriter writer = new FileWriter(file);
				return writer;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public File getFile(final String fileName) {
		File file;
		File hudsonDir = new File(HUDSON_RESULTS_DIR);
		if(hudsonDir.exists() && hudsonDir.isDirectory()){
			String path = "";
			File matchingDirRoot = new File(HUDSON_RESULTS_DIR + MATCHING_RESULTS_ROOT);
			if(!matchingDirRoot.exists()){
				if(matchingDirRoot.mkdir()){
					path += HUDSON_RESULTS_DIR + MATCHING_RESULTS_ROOT;
				} else {
					path += HUDSON_RESULTS_DIR;
				}
			} else {
				path += HUDSON_RESULTS_DIR + MATCHING_RESULTS_ROOT;
			}
			File matchingDir = new File(path + MATCHING_RESULTS);
			if(!matchingDir.exists()){
				if(matchingDir.mkdir()){
					path += MATCHING_RESULTS + fileName;
				} else {
					path += fileName;
				}
			} else {
				path += MATCHING_RESULTS + fileName;
			}
			file = new File(path);
		} else {
			file = new File(RESULTS_DIR + fileName);
		}
		return file;
	}

	public String getFileName(String fileNamePrefix, RoleModel rolemodel, EPackage metamodel, String fileExtension) {
		String prefix = fileNamePrefix + "_" + metamodel.getName() + "_" + rolemodel.getName();
		String fileName = prefix + "." + fileExtension;
		return fileName;
	}

}
