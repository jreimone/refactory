/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesMetaInformation implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesMetaInformation {
	
	public java.lang.String getSyntaxName() {
		return "properties";
	}
	
	public java.lang.String getURI() {
		return "http://www.emftext.org/language/properties";
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextScanner createLexer() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesAntlrScanner(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLexer());
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource) {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesPrinter(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesReferenceResolverSwitch();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTokenResolverFactory();
	}
	
	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.refactoring.tests.properties/metamodel/Properties.cs";
	}
	
	public java.lang.String[] getTokenNames() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesParser(null).getTokenNames();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBracketPair> getBracketPairs() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesHoverTextProvider getHoverTextProvider() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesHoverTextProvider();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager createColorManager() {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesTokenScanner createTokenScanner(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager colorManager) {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesTokenScanner(colorManager);
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResourceFactory();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesNewFileContentProvider();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesCodeCompletionHelper();
	}
	
}
