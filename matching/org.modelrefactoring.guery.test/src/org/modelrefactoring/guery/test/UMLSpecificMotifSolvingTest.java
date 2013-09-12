package org.modelrefactoring.guery.test;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLSpecificMotifSolvingTest extends AbstractSpecificMotifSolvingTestFragment{

	private static final String GUERY_FILE_NAME		= "queries/ExtractXwithReferenceClass_uml_MPL2__without_optional_specialised.guery";
	private static final String ROLEMODEL_FILE_NAME	= "rolemodels/ExtractXwithReferenceClass.rolestext";
	private static final int MAX_RESULTS 				= 10000;

	private UMLPackage umlMM = UMLPackage.eINSTANCE;;

	@Override
	protected String getGUERYFileName() {
		return GUERY_FILE_NAME;
	}

	@Override
	protected String getRoleModelFileName() {
		return ROLEMODEL_FILE_NAME;
	}

	@Override
	protected int getMaxResults() {
		return MAX_RESULTS;
	}

	@Override
	protected EPackage getTargetMetamodel() {
		return umlMM;
	}

	@Override
	protected void initAdditionalLanguages() {
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);		
	}
}
