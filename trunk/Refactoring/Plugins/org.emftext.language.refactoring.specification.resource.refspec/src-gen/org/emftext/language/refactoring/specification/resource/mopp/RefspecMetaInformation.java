/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecMetaInformation implements org.emftext.language.refactoring.specification.resource.IRefspecMetaInformation {
	
	public java.lang.String getSyntaxName() {
		return "refspec";
	}
	
	public java.lang.String getURI() {
		return "http://www.emftext.org/language/refactoring_specification";
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTextScanner createLexer() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecAntlrScanner(new org.emftext.language.refactoring.specification.resource.mopp.RefspecLexer());
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource) {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecPrinter(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecReferenceResolverSwitch();
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecTokenResolverFactory();
	}
	
	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.language.refactoring.specification/metamodel/refactoring_specification.cs";
	}
	
	public java.lang.String[] getTokenNames() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecParser(null).getTokenNames();
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.refactoring.specification.resource.IRefspecBracketPair> getBracketPairs() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecHoverTextProvider();
	}
	
	public org.emftext.language.refactoring.specification.resource.ui.RefspecColorManager createColorManager() {
		return new org.emftext.language.refactoring.specification.resource.ui.RefspecColorManager();
	}
	
	public org.emftext.language.refactoring.specification.resource.ui.RefspecTokenScanner createTokenScanner(org.emftext.language.refactoring.specification.resource.ui.RefspecColorManager colorManager) {
		return new org.emftext.language.refactoring.specification.resource.ui.RefspecTokenScanner(colorManager);
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecResourceFactory();
	}
	
	public org.emftext.language.refactoring.specification.resource.mopp.RefspecNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecNewFileContentProvider();
	}
	
	public org.emftext.language.refactoring.specification.resource.mopp.RefspecCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecCodeCompletionHelper();
	}
	
}
