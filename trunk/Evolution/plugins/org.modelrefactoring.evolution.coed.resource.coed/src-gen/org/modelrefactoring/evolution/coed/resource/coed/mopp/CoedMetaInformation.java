/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class CoedMetaInformation implements org.modelrefactoring.evolution.coed.resource.coed.ICoedMetaInformation {
	
	public String getSyntaxName() {
		return "coed";
	}
	
	public String getURI() {
		return "http://www.modelrefactoring.org/evolution/coed";
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTextScanner createLexer() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedAntlrScanner(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedLexer());
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTextParser createParser(InputStream inputStream, String encoding) {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedParser().createInstance(inputStream, encoding);
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTextPrinter createPrinter(OutputStream outputStream, org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource) {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedPrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedReferenceResolverSwitch();
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolverFactory getTokenResolverFactory() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.modelrefactoring.evolution.coed/metamodel/coed.cs";
	}
	
	public String[] getTokenNames() {
		return org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedParser.tokenNames;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedBracketPair> getBracketPairs() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResourceFactory();
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedNewFileContentProvider getNewFileContentProvider() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResourceFactoryDelegator());
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
		return "org.modelrefactoring.evolution.coed.resource.coed.ui.launchConfigurationType";
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedNameProvider createNameProvider() {
		return new org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedAntlrTokenHelper tokenHelper = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedAntlrTokenHelper();
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
		highlightableTokens.add(org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
