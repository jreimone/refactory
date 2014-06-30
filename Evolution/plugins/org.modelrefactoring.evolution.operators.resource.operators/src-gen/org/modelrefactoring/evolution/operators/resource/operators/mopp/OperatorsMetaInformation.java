/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class OperatorsMetaInformation implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsMetaInformation {
	
	public String getSyntaxName() {
		return "operators";
	}
	
	public String getURI() {
		return "http://www.modelrefactoring.org/operators";
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextScanner createLexer() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsAntlrScanner(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsLexer());
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextParser createParser(InputStream inputStream, String encoding) {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsParser().createInstance(inputStream, encoding);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextPrinter createPrinter(OutputStream outputStream, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource) {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsPrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsReferenceResolverSwitch();
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolverFactory getTokenResolverFactory() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.modelrefactoring.evolution.operators/metamodel/operators.cs";
	}
	
	public String[] getTokenNames() {
		return org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsParser.tokenNames;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsBracketPair> getBracketPairs() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsResourceFactory();
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsNewFileContentProvider getNewFileContentProvider() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsResourceFactoryDelegator());
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
		return "org.modelrefactoring.evolution.operators.resource.operators.ui.launchConfigurationType";
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsNameProvider createNameProvider() {
		return new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsAntlrTokenHelper tokenHelper = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsAntlrTokenHelper();
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
		highlightableTokens.add(org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
