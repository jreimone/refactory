/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesPrinter2 implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextPrinter {
	
	private class PrintToken {
		
		private String text;
		private String tokenName;
		
		public PrintToken(String text, String tokenName) {
			this.text = text;
			this.tokenName = tokenName;
		}
		
		public String getText() {
			return text;
		}
		
		public String getTokenName() {
			return tokenName;
		}
		
	}
	
	public final static java.lang.String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	
	/**
	 * Holds the resource that is associated with this printer. May be null if the
	 * printer is used stand alone.
	 */
	private org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource;
	
	private java.util.Map<?, ?> options;
	private java.io.OutputStream outputStream;
	private java.util.List<PrintToken> tokenOutputStream;
	private org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolverFactory tokenResolverFactory = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTokenResolverFactory();
	private boolean handleTokenSpaceAutomatically = true;
	private int tokenSpace = 1;
	private boolean startedPrintingElement = false;
	
	public PropertiesPrinter2(java.io.OutputStream outputStream, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		tokenOutputStream = new java.util.ArrayList<PrintToken>();
		doPrint(element);
		java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		if (handleTokenSpaceAutomatically) {
			printSmart(writer);
		} else {
			printBasic(writer);
		}
		writer.flush();
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (outputStream == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		startedPrintingElement = true;
		if (element instanceof org.emftext.refactoring.tests.properties.PropertyModel) {
			printInternal(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_0);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.Category) {
			printInternal(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_1);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.KeyValuePair) {
			printInternal(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_2);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.Key) {
			printInternal(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_3);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.EObjectReferenceValue) {
			printInternal(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_4);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.StringValue) {
			printInternal(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_5);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void printInternal(org.eclipse.emf.ecore.EObject eObject, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement ruleElement) {
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// create a copy of the original list of layout information object in order to be
		// able to remove used informations during printing
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator decoratorTree = getDecoratorTree(ruleElement);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement>(), layoutInformations);
	}
	
	/**
	 * creates a tree of decorator objects which reflects the syntax tree that is
	 * attached to the given syntax element
	 */
	public org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator getDecoratorTree(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement syntaxElement) {
		org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement[] children = syntaxElement.getChildren();
		int childCount = children.length;
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator[] childDecorators = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator[childCount];
		for (int i = 0; i < childCount; i++) {
			childDecorators[i] = getDecoratorTree(children[i]);
		}
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator decorator = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator(syntaxElement, childDecorators);
		return decorator;
	}
	
	public void decorateTree(org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = initializePrintCountingMap(eObject);
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator> keywordsToPrint = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator>();
		decorateTreeBasic(decorator, eObject, printCountingMap, keywordsToPrint);
		for (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator keywordToPrint : keywordsToPrint) {
			// for keywords the concrete index does not matter, but we must add one to
			// indicate that the keyword needs to be printed here. Thus, we use 0 as index.
			keywordToPrint.addIndexToPrint(0);
		}
	}
	
	/**
	 * Tries to decorate the decorator with an attribute value, or reference holded by
	 * eObject. Returns true if an attribute value or reference was found.
	 */
	public boolean decorateTreeBasic(org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator> keywordsToPrint) {
		boolean foundFeatureToPrint = false;
		org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement syntaxElement = decorator.getDecoratedElement();
		org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality = syntaxElement.getCardinality();
		boolean isFirstIteration = true;
		while (true) {
			java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator> subKeywordsToPrint = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator>();
			boolean keepDecorating = false;
			if (syntaxElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword) {
				subKeywordsToPrint.add(decorator);
			} else if (syntaxElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesTerminal) {
				org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesTerminal terminal = (org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesTerminal) syntaxElement;
				org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
				int countLeft = printCountingMap.get(feature.getName());
				if (countLeft > terminal.getMandatoryOccurencesAfter()) {
					decorator.addIndexToPrint(countLeft);
					printCountingMap.put(feature.getName(), countLeft - 1);
					keepDecorating = true;
				}
			}
			for (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);
				if (syntaxElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice) {
					break;
				}
			}
			foundFeatureToPrint |= keepDecorating;
			// only print keywords if a feature was printed or the syntax element is mandatory
			if (cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			} else if (cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.PLUS) {
				if (isFirstIteration) {
					keywordsToPrint.addAll(subKeywordsToPrint);
				} else {
					if (keepDecorating) {
						keywordsToPrint.addAll(subKeywordsToPrint);
					}
				}
			} else if (keepDecorating && (cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.STAR || cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.QUESTIONMARK)) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			}
			if (cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE || cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.QUESTIONMARK) {
				break;
			} else if (!keepDecorating) {
				break;
			}
			isFirstIteration = false;
		}
		return foundFeatureToPrint;
	}
	
	public boolean printTree(org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement> foundFormattingElements, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> layoutInformations) {
		org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement printElement = decorator.getDecoratedElement();
		org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality = printElement.getCardinality();
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement> cloned = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement>();
		cloned.addAll(foundFormattingElements);
		boolean foundSomethingAtAll = false;
		boolean foundSomethingToPrint;
		while (true) {
			foundSomethingToPrint = false;
			java.lang.Integer indexToPrint = decorator.getNextIndexToPrint();
			if (indexToPrint != null) {
				if (printElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword) {
					printKeyword(eObject, (org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword) printElement, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder) {
					org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder placeholder = (org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder) printElement;
					printFeature(eObject, placeholder, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment) {
					org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment containment = (org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment) printElement;
					printContainedObject(eObject, containment, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				}
			}
			if (foundSomethingToPrint) {
				foundSomethingAtAll = true;
			}
			if (printElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesWhiteSpace) {
				foundFormattingElements.add((org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesWhiteSpace) printElement);
			}
			if (printElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak) {
				foundFormattingElements.add((org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak) printElement);
			}
			for (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				foundSomethingToPrint |= printTree(childDecorator, eObject, foundFormattingElements, layoutInformations);
			}
			if (cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE || cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.QUESTIONMARK) {
				break;
			} else if (!foundSomethingToPrint) {
				break;
			}
		}
		// only print formatting elements if a feature was printed or the syntax element
		// is mandatory
		if (!foundSomethingAtAll && (cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.STAR || cardinality == org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.QUESTIONMARK)) {
			foundFormattingElements.clear();
			foundFormattingElements.addAll(cloned);
		}
		return foundSomethingToPrint;
	}
	
	public void printKeyword(org.eclipse.emf.ecore.EObject eObject, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword keyword, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement> foundFormattingElements, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> layoutInformations) {
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, keyword, null, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		String value = keyword.getValue();
		tokenOutputStream.add(new PrintToken(value, "'" + value + "'"));
	}
	
	public void printFeature(org.eclipse.emf.ecore.EObject eObject, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder placeholder, int count, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement> foundFormattingElements, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature feature = placeholder.getFeature();
		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			printAttribute(eObject, (org.eclipse.emf.ecore.EAttribute) feature, placeholder, count, foundFormattingElements, layoutInformations);
		} else {
			printReference(eObject, (org.eclipse.emf.ecore.EReference) feature, placeholder, count, foundFormattingElements, layoutInformations);
		}
	}
	
	public void printAttribute(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EAttribute attribute, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder placeholder, int count, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement> foundFormattingElements, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> layoutInformations) {
		java.lang.String result;
		java.lang.Object attributeValue = getValue(eObject, attribute, count);
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, attributeValue, eObject);
		java.lang.String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the attribute is deresolved to obtain its textual
			// representation
			org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());
			tokenResolver.setOptions(getOptions());
			java.lang.String deResolvedValue = tokenResolver.deResolve(attributeValue, attribute, eObject);
			result = deResolvedValue;
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		}
		// write result to the output stream
		tokenOutputStream.add(new PrintToken(result, placeholder.getTokenName()));
	}
	
	public void printContainedObject(org.eclipse.emf.ecore.EObject eObject, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment containment, int count, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement> foundFormattingElements, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature reference = containment.getFeature();
		java.lang.Object o = getValue(eObject, reference, count);
		doPrint((org.eclipse.emf.ecore.EObject) o);
	}
	
	public void printFormattingElements(java.util.List<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement> foundFormattingElements, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> layoutInformations, org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation layoutInformation) {
		java.lang.String hiddenTokenText = getHiddenTokenText(layoutInformation);
		if (hiddenTokenText != null) {
			// removed used information
			layoutInformations.remove(layoutInformation);
			tokenOutputStream.add(new PrintToken(hiddenTokenText, null));
			foundFormattingElements.clear();
			startedPrintingElement = false;
			return;
		}
		if (foundFormattingElements.size() > 0) {
			for (org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement foundFormattingElement : foundFormattingElements) {
				if (foundFormattingElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesWhiteSpace) {
					int amount = ((org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesWhiteSpace) foundFormattingElement).getAmount();
					for (int i = 0; i < amount; i++) {
						tokenOutputStream.add(new PrintToken(" ", null));
					}
				}
				if (foundFormattingElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak) {
					int tabs = ((org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak) foundFormattingElement).getTabs();
					tokenOutputStream.add(new PrintToken(NEW_LINE, null));
					for (int i = 0; i < tabs; i++) {
						tokenOutputStream.add(new PrintToken("\t", null));
					}
				}
			}
			foundFormattingElements.clear();
			startedPrintingElement = false;
		} else {
			if (startedPrintingElement) {
				startedPrintingElement = false;
			} else {
				if (!handleTokenSpaceAutomatically) {
					tokenOutputStream.add(new PrintToken(getWhiteSpaceString(tokenSpace), null));
				}
			}
		}
	}
	
	private Object getValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int count) {
		// get value of feature
		java.lang.Object o = eObject.eGet(feature);
		if (o instanceof java.util.List<?>) {
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			o = list.get(index);
		}
		return o;
	}
	
	@SuppressWarnings("unchecked")	
	public void printReference(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EReference reference, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder placeholder, int count, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement> foundFormattingElements, java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> layoutInformations) {
		java.lang.Object referencedObject = getValue(eObject, reference, count);
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, referencedObject, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		// NC-References must always be printed by deresolving the reference. We cannot
		// use the visible token information, because deresolving usually depends on
		// attribute values of the referenced object instead of the object itself.
		String tokenName = placeholder.getTokenName();
		org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
		tokenResolver.setOptions(getOptions());
		org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver referenceResolver = getReferenceResolverSwitch().getResolver(reference);
		referenceResolver.setOptions(getOptions());
		java.lang.String deresolvedReference = referenceResolver.deResolve((org.eclipse.emf.ecore.EObject) referencedObject, eObject, reference);
		java.lang.String deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);
		// write result to output stream
		tokenOutputStream.add(new PrintToken(deresolvedToken, tokenName));
	}
	
	public java.util.Map<java.lang.String, java.lang.Integer> initializePrintCountingMap(org.eclipse.emf.ecore.EObject eObject) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>();
		java.util.List<org.eclipse.emf.ecore.EStructuralFeature> features = eObject.eClass().getEAllStructuralFeatures();
		for (org.eclipse.emf.ecore.EStructuralFeature feature : features) {
			int count = 0;
			java.lang.Object featureValue = eObject.eGet(feature);
			if (featureValue != null) {
				if (featureValue instanceof java.util.List<?>) {
					count = ((java.util.List<?>) featureValue).size();
				} else {
					count = 1;
				}
			}
			printCountingMap.put(feature.getName(), count);
		}
		return printCountingMap;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource getResource() {
		return resource;
	}
	
	protected org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesReferenceResolverSwitch) new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final java.lang.String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesProblem(errorMessage, org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType.ERROR), cause);
	}
	
	protected org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformationAdapter getLayoutInformationAdapter(org.eclipse.emf.ecore.EObject element) {
		for (org.eclipse.emf.common.notify.Adapter adapter : element.eAdapters()) {
			if (adapter instanceof org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformationAdapter) {
				return (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformationAdapter) adapter;
			}
		}
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformationAdapter newAdapter = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
	private org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation getLayoutInformation(java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation> layoutInformations, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement syntaxElement, java.lang.Object object, org.eclipse.emf.ecore.EObject container) {
		for (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation layoutInformation : layoutInformations) {
			if (syntaxElement == layoutInformation.getSyntaxElement()) {
				if (object == null) {
					return layoutInformation;
				} else if (object == layoutInformation.getObject(container)) {
					return layoutInformation;
				}
			}
		}
		return null;
	}
	
	private java.lang.String getHiddenTokenText(org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getHiddenTokenText();
		} else {
			return null;
		}
	}
	
	private java.lang.String getVisibleTokenText(org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getVisibleTokenText();
		} else {
			return null;
		}
	}
	
	protected String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < count; i++) {
			result.append(character);
		}
		return result.toString();
	}
	
	public void setHandleTokenSpaceAutomatically(boolean handleTokenSpaceAutomatically) {
		this.handleTokenSpaceAutomatically = handleTokenSpaceAutomatically;
	}
	
	public void setTokenSpace(int tokenSpace) {
		this.tokenSpace = tokenSpace;
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer (as it is).
	 */
	public void printBasic(java.io.PrintWriter writer) throws java.io.IOException {
		for (PrintToken nextToken : tokenOutputStream) {
			writer.write(nextToken.getText());
		}
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer.
	 * 
	 * This methods implements smart whitespace printing. It does so by writing output
	 * to a token stream instead of printing the raw token text to a PrintWriter.
	 * Tokens in this stream hold both the text and the type of the token (i.e., its
	 * name).
	 * 
	 * To decide where whitespace is needed, sequences of successive tokens are
	 * searched that can be printed without separating whitespace. To determine such
	 * groups we start with two successive non-whitespace tokens, concatenate their
	 * text and use the generated ANTLR lexer to split the text. If the resulting
	 * token sequence of the concatenated text is exactly the same as the one that is
	 * to be printed, no whitespace is needed. The tokens in the sequence are checked
	 * both regarding their type and their text. If two tokens successfully form a
	 * group a third one is added and so on.
	 */
	public void printSmart(java.io.PrintWriter writer) throws java.io.IOException {
		// stores the text of the current group of tokens. this text is given to the lexer
		// to check whether it can be correctly scanned.
		StringBuilder currentBlock = new StringBuilder();
		// stores the index of the first token of the current group.
		int currentBlockStart = 0;
		// stores the text that was already successfully checked (i.e., is can be scanned
		// correctly and can thus be printed).
		String validBlock = "";
		for (int i = 0; i < tokenOutputStream.size(); i++) {
			PrintToken tokenI = tokenOutputStream.get(i);
			currentBlock.append(tokenI.getText());
			// if declared or preserved whitespace is found - print block
			if (tokenI.getTokenName() == null) {
				writer.write(currentBlock.toString());
				// reset all values
				currentBlock = new StringBuilder();
				currentBlockStart = i + 1;
				validBlock = "";
				continue;
			}
			// now check whether the current block can be scanned
			org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextScanner scanner = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMetaInformation().createLexer();
			scanner.setText(currentBlock.toString());
			// retrieve all tokens from scanner and add them to list 'tempTokens'
			java.util.List<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextToken> tempTokens = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextToken>();
			org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextToken nextToken = scanner.getNextToken();
			while (nextToken != null) {
				tempTokens.add(nextToken);
			}
			boolean sequenceIsValid = true;
			// check whether the current block was scanned to the same token sequence
			for (int t = 0; t < tempTokens.size(); t++) {
				PrintToken printTokenT = tokenOutputStream.get(currentBlockStart + t);
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextToken tempToken = tempTokens.get(t);
				if (!tempToken.getText().equals(printTokenT.getText())) {
					sequenceIsValid = false;
					break;
				}
				String commonTokenName = tempToken.getName();
				if (!commonTokenName.equals(printTokenT.getTokenName())) {
					sequenceIsValid = false;
					break;
				}
			}
			if (sequenceIsValid) {
				// sequence is still valid, try adding one more token in the next iteration of the
				// loop
				validBlock += tokenI.getText();
			} else {
				// sequence is not valid, must print whitespace to separate tokens
				// print text that is valid so far
				writer.write(validBlock);
				// print separating whitespace
				writer.write(" ");
				// add current token as initial value for next iteration
				currentBlock = new StringBuilder(tokenI.getText());
				currentBlockStart = i;
				validBlock = tokenI.getText();
			}
		}
		// flush remaining valid text to writer
		writer.write(validBlock);
	}
	
}
