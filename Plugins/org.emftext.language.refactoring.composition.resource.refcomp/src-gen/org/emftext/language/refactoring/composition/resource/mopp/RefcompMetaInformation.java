/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class RefcompMetaInformation implements org.emftext.language.refactoring.composition.resource.IRefcompMetaInformation {
	
	public String getSyntaxName() {
		return "refcomp";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/refactoringcomposition";
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTextScanner createLexer() {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompAntlrScanner(new org.emftext.language.refactoring.composition.resource.mopp.RefcompLexer());
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTextParser createParser(InputStream inputStream, String encoding) {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTextPrinter createPrinter(OutputStream outputStream, org.emftext.language.refactoring.composition.resource.IRefcompTextResource resource) {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompPrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompReferenceResolverSwitch();
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.refactoring.composition/metamodel/refactoringcomposition.cs";
	}
	
	public String[] getTokenNames() {
		return org.emftext.language.refactoring.composition.resource.mopp.RefcompParser.tokenNames;
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<org.emftext.language.refactoring.composition.resource.IRefcompBracketPair> getBracketPairs() {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompResourceFactory();
	}
	
	public org.emftext.language.refactoring.composition.resource.mopp.RefcompNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.language.refactoring.composition.resource.mopp.RefcompResourceFactoryDelegator());
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
		return "org.emftext.language.refactoring.composition.resource.refcomp.ui.launchConfigurationType";
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompNameProvider createNameProvider() {
		return new org.emftext.language.refactoring.composition.resource.analysis.RefcompDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.emftext.language.refactoring.composition.resource.mopp.RefcompAntlrTokenHelper tokenHelper = new org.emftext.language.refactoring.composition.resource.mopp.RefcompAntlrTokenHelper();
		List<String> highlightableTokens = new ArrayList<String>();
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
		highlightableTokens.add(org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
