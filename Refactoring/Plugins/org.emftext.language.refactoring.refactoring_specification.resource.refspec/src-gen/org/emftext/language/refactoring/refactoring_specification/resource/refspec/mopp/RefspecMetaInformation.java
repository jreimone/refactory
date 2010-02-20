/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecMetaInformation implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecMetaInformation {
	
	public java.lang.String getSyntaxName() {
		return "refspec";
	}
	
	public java.lang.String getURI() {
		return "http://www.emftext.org/language/refactoring_specification";
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextScanner createLexer() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecAntlrScanner(new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecLexer());
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource resource) {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecPrinter(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecReferenceResolverSwitch();
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecTokenResolverFactory();
	}
	
	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.language.refactoring.specification/metamodel/refactoring_specification.cs";
	}
	
	public java.lang.String[] getTokenNames() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecParser(null).getTokenNames();
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecBracketPair> getBracketPairs() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecHoverTextProvider();
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.ui.RefspecColorManager createColorManager() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.ui.RefspecColorManager();
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.ui.RefspecTokenScanner createTokenScanner(org.emftext.language.refactoring.refactoring_specification.resource.refspec.ui.RefspecColorManager colorManager) {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.ui.RefspecTokenScanner(colorManager);
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecResourceFactory();
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecNewFileContentProvider();
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecCodeCompletionHelper();
	}
	
}
