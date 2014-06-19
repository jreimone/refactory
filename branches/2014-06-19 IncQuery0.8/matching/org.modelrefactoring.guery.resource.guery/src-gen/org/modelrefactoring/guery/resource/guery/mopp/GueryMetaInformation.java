/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryMetaInformation implements org.modelrefactoring.guery.resource.guery.IGueryMetaInformation {
	
	public String getSyntaxName() {
		return "guery";
	}
	
	public String getURI() {
		return "http://www.modelrefactoring.org/guery";
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryTextScanner createLexer() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryAntlrScanner(new org.modelrefactoring.guery.resource.guery.mopp.GueryLexer());
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryParser().createInstance(inputStream, encoding);
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryTextPrinter createPrinter(java.io.OutputStream outputStream, org.modelrefactoring.guery.resource.guery.IGueryTextResource resource) {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GuerySyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GuerySyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryReferenceResolverSwitch();
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryTokenResolverFactory getTokenResolverFactory() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.modelrefactoring.guery/metamodel/guery.cs";
	}
	
	public String[] getTokenNames() {
		return org.modelrefactoring.guery.resource.guery.mopp.GueryParser.tokenNames;
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryBracketPair> getBracketPairs() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryResourceFactory();
	}
	
	public org.modelrefactoring.guery.resource.guery.mopp.GueryNewFileContentProvider getNewFileContentProvider() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.modelrefactoring.guery.resource.guery.mopp.GueryResourceFactoryDelegator());
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
		return "org.modelrefactoring.guery.resource.guery.ui.launchConfigurationType";
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryNameProvider createNameProvider() {
		return new org.modelrefactoring.guery.resource.guery.analysis.GueryDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.modelrefactoring.guery.resource.guery.mopp.GueryAntlrTokenHelper tokenHelper = new org.modelrefactoring.guery.resource.guery.mopp.GueryAntlrTokenHelper();
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
		highlightableTokens.add(org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
