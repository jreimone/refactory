/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfMetaInformation implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfMetaInformation {
	
	public String getSyntaxName() {
		return "xwpf";
	}
	
	public String getURI() {
		return "http://www.itu.dk/sdg/language/xwpf";
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextScanner createLexer() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfAntlrScanner(new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfLexer());
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfParser().createInstance(inputStream, encoding);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextPrinter createPrinter(java.io.OutputStream outputStream, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource) {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolverSwitch getReferenceResolverSwitch() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfReferenceResolverSwitch();
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolverFactory getTokenResolverFactory() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "dk.itu.sdg.language.xwpf/metamodel/xwpf.cs";
	}
	
	public String[] getTokenNames() {
		return dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfParser.tokenNames;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle getDefaultTokenStyle(String tokenName) {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBracketPair> getBracketPairs() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResourceFactory();
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfNewFileContentProvider getNewFileContentProvider() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResourceFactory());
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
		return "dk.itu.sdg.language.xwpf.resource.xwpf.ui.launchConfigurationType";
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfNameProvider createNameProvider() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfAntlrTokenHelper tokenHelper = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfAntlrTokenHelper();
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
		highlightableTokens.add(dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
