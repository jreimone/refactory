/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesMetaInformation implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesMetaInformation {
	
	public String getSyntaxName() {
		return "properties";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/properties";
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextScanner createLexer() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesAntlrScanner(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLexer());
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource) {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesPrinter2(outputStream, resource);
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
	
	public String getPathToCSDefinition() {
		return "org.emftext.refactoring.tests.properties/metamodel/Properties.cs";
	}
	
	public String[] getTokenNames() {
		return org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesParser.tokenNames;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBracketPair> getBracketPairs() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResourceFactory();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResourceFactory());
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
		return "org.emftext.refactoring.tests.properties.resource.properties.ui.launchConfigurationType";
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesNameProvider createNameProvider() {
		return new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesAntlrTokenHelper tokenHelper = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesAntlrTokenHelper();
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
		highlightableTokens.add(org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
