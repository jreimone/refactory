/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextMetaInformation implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextMetaInformation {
	
	public java.lang.String getSyntaxName() {
		return "rolestext";
	}
	
	public java.lang.String getURI() {
		return "http://www.emftext.org/language/roles";
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextScanner createLexer() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextAntlrScanner(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextLexer());
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource resource) {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextPrinter(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextReferenceResolverSwitch();
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTokenResolverFactory();
	}
	
	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.language.refactoring.roles/metamodel/roles.cs";
	}
	
	public java.lang.String[] getTokenNames() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextParser(null).getTokenNames();
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBracketPair> getBracketPairs() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextHoverTextProvider();
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextColorManager createColorManager() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextColorManager();
	}
	
	public org.eclipse.jface.text.rules.ITokenScanner createTokenScanner(org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextColorManager colorManager) {
		return new org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextTokenScanner(colorManager);
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory();
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextNewFileContentProvider();
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextCodeCompletionHelper();
	}
	
}
