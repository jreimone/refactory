package de.christophseidl.emf.ggimporter.ui;

import org.eclipse.emf.converter.ModelConverter;
import org.eclipse.emf.importer.ecore.ui.EcoreImporterWizard;

import de.christophseidl.emf.ggimporter.GGImporter;

public class GGImporterWizard extends EcoreImporterWizard {
	@Override
	protected ModelConverter createModelConverter() {
		return new GGImporter();
	}

//  @Override
//  public void addPages()
//  {
////    JavaPackagePage packagePage = new JavaPackagePage(getModelImporter(), "JavaPackages");
////    addPage(packagePage);
//  }
}
