package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecNewFileContentProvider {
	
	public org.emftext.language.refactoring.specification.resource.IRefspecMetaInformation getMetaInformation() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecMetaInformation();
	}
	
	public java.lang.String getNewFileContent(java.lang.String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, java.lang.String newFileName) {
		String content = "";
		for (org.eclipse.emf.ecore.EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, java.lang.String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.emftext.language.refactoring.specification.resource.util.RefspecMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.emftext.language.refactoring.specification.resource.IRefspecTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			org.emftext.language.refactoring.specification.resource.mopp.RefspecPlugin.logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.emftext.language.refactoring.specification.resource.mopp.RefspecResource());
	}
	
}
