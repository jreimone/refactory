/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

public class TestpropertiesMetaInformation implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesMetaInformation {
	
	public String getSyntaxName() {
		return "testproperties";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/properties";
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextScanner createLexer() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesAntlrScanner(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesLexer());
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource) {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesReferenceResolverSwitch();
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.refactoring.tests.properties/metamodel/Properties.cs";
	}
	
	public String[] getTokenNames() {
		return org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesParser.tokenNames;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBracketPair> getBracketPairs() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResourceFactory();
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResourceFactoryDelegator());
		}
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.emftext.refactoring.tests.properties.resource.testproperties.ui.launchConfigurationType";
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesNameProvider createNameProvider() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesAntlrTokenHelper tokenHelper = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
