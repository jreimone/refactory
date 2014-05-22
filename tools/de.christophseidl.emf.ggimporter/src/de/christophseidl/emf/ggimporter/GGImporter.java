package de.christophseidl.emf.ggimporter;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.importer.ecore.EcoreImporter;

//TODO:			genModel.getPackageClassEmitter()

public class GGImporter extends EcoreImporter {
	private boolean useProjectNameAsBasePackage;
	
	public GGImporter() {
		useProjectNameAsBasePackage = true;
	}
	
	@Override
	public String getID() {
		return GGImporterPlugin.PLUGIN_IN;
	}

	@Override
	protected void adjustGenModel(Monitor monitor) {
		super.adjustGenModel(monitor);
		
		adjustBasePackage();
		adjustDirectories();
//		gna();
	}
	
	private void adjustBasePackage() {
		if (useProjectNameAsBasePackage) {
			String projectName = getModelProjectName();

			//Strip last part of project name (that is similar to model name by convention)
			int lastDotIndex = projectName.lastIndexOf(".");
			
			String basePackageName = lastDotIndex != -1 ? projectName.substring(0, lastDotIndex) : projectName;
			
			//Use the resulting string as base package
			for (GenPackage genPackage : genModel.getGenPackages()) {
				//TODO: See if this works with imported packages
				//TODO: What about nested packages?!
				genPackage.setBasePackage(basePackageName);
			}
			
		}
	}
	
	private void adjustDirectories() {
		String modelDirectory = genModel.getModelDirectory();
		modelDirectory += "-gen";
		genModel.setModelDirectory(modelDirectory);
		
		String editDirectory = genModel.getEditDirectory();
		editDirectory += "-gen";
		genModel.setEditDirectory(editDirectory);
		
		String editorDirectory = genModel.getEditorDirectory();
		editorDirectory += "-gen";
		genModel.setEditorDirectory(editorDirectory);
		
		String testsDirectory = genModel.getTestsDirectory();
		testsDirectory += "-gen";
		genModel.setTestsDirectory(testsDirectory);
	}
	
//	private void gna() {
//		//Find all classes that specify operations that do not have an annotation for the implementation
//		
//		//Add annotation to generate separate class
//		
//		//GGCodeGenerator
//		
//	}
}