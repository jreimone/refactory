/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecPrinter2 implements org.emftext.language.refactoring.specification.resource.IRefspecTextPrinter {
	
	public final static java.lang.String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	// Holds the resource that is associated with this printer. may be null if the printer is used stand alone.
	private org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource;
	private java.io.PrintWriter writer;
	private java.util.Map<?, ?> options;
	private org.emftext.language.refactoring.specification.resource.IRefspecTokenResolverFactory tokenResolverFactory = new org.emftext.language.refactoring.specification.resource.mopp.RefspecTokenResolverFactory();
	private boolean startedPrintingElement = false;
	private java.util.List<org.emftext.language.refactoring.specification.resource.grammar.RefspecFormattingElement> foundFormattingElements = new java.util.ArrayList<org.emftext.language.refactoring.specification.resource.grammar.RefspecFormattingElement>();
	
	public RefspecPrinter2(java.io.OutputStream outputStream, org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource) {
		super();
		this.writer = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		this.resource = resource;
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		foundFormattingElements.clear();
		doPrint(element);
		writer.flush();
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (writer == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		startedPrintingElement = true;
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification((org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.CREATE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_CREATE((org.emftext.language.refactoring.refactoring_specification.CREATE) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.MOVE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_MOVE((org.emftext.language.refactoring.refactoring_specification.MOVE) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.SET) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_SET((org.emftext.language.refactoring.refactoring_specification.SET) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.ASSIGN) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN((org.emftext.language.refactoring.refactoring_specification.ASSIGN) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.UPDATE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE((org.emftext.language.refactoring.refactoring_specification.UPDATE) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.Variable) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_Variable((org.emftext.language.refactoring.refactoring_specification.Variable) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.VariableReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference((org.emftext.language.refactoring.refactoring_specification.VariableReference) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.VariableAssignment) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment((org.emftext.language.refactoring.refactoring_specification.VariableAssignment) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.RoleReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference((org.emftext.language.refactoring.refactoring_specification.RoleReference) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.TRACE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_TRACE((org.emftext.language.refactoring.refactoring_specification.TRACE) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.RelationReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference((org.emftext.language.refactoring.refactoring_specification.RelationReference) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.ConstantsReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference((org.emftext.language.refactoring.refactoring_specification.ConstantsReference) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.FromClause) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_FromClause((org.emftext.language.refactoring.refactoring_specification.FromClause) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.UPTREE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE((org.emftext.language.refactoring.refactoring_specification.UPTREE) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.PATH) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_PATH((org.emftext.language.refactoring.refactoring_specification.PATH) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.FIRST) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_FIRST((org.emftext.language.refactoring.refactoring_specification.FIRST) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.LAST) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_LAST((org.emftext.language.refactoring.refactoring_specification.LAST) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.ConcreteIndex) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex((org.emftext.language.refactoring.refactoring_specification.ConcreteIndex) element);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.IndexVariable) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable((org.emftext.language.refactoring.refactoring_specification.IndexVariable) element);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_0);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_CREATE(org.emftext.language.refactoring.refactoring_specification.CREATE eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_1);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_MOVE(org.emftext.language.refactoring.refactoring_specification.MOVE eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_2);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_SET(org.emftext.language.refactoring.refactoring_specification.SET eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_3);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN(org.emftext.language.refactoring.refactoring_specification.ASSIGN eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_4);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE(org.emftext.language.refactoring.refactoring_specification.UPDATE eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_5);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_Variable(org.emftext.language.refactoring.refactoring_specification.Variable eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_6);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference(org.emftext.language.refactoring.refactoring_specification.VariableReference eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_7);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment(org.emftext.language.refactoring.refactoring_specification.VariableAssignment eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_8);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference(org.emftext.language.refactoring.refactoring_specification.RoleReference eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_9);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_TRACE(org.emftext.language.refactoring.refactoring_specification.TRACE eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_10);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference(org.emftext.language.refactoring.refactoring_specification.RelationReference eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_11);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference(org.emftext.language.refactoring.refactoring_specification.ConstantsReference eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_12);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_FromClause(org.emftext.language.refactoring.refactoring_specification.FromClause eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_13);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE(org.emftext.language.refactoring.refactoring_specification.UPTREE eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_14);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_PATH(org.emftext.language.refactoring.refactoring_specification.PATH eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_15);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_FIRST(org.emftext.language.refactoring.refactoring_specification.FIRST eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_16);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_LAST(org.emftext.language.refactoring.refactoring_specification.LAST eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_17);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex(org.emftext.language.refactoring.refactoring_specification.ConcreteIndex eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_18);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable(org.emftext.language.refactoring.refactoring_specification.IndexVariable eObject) {
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecGrammarInformationProvider.REFSPEC_19);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject);
	}
	
	// creates a tree of decorator objects which reflects the syntax tree that is
	// attached to the given syntax element
	public org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator getDecoratorTree(org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement syntaxElement) {
		org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement[] children = syntaxElement.getChildren();
		int childCount = children.length;
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator[] childDecorators = new org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator[childCount];
		for (int i = 0; i < childCount; i++) {
			childDecorators[i] = getDecoratorTree(children[i]);
		}
		org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decorator = new org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator(syntaxElement, childDecorators);
		return decorator;
	}
	
	public void decorateTree(org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = initializePrintCountingMap(eObject);
		java.util.List<org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator> keywordsToPrint = new java.util.ArrayList<org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator>();
		decorateTreeBasic(decorator, eObject, printCountingMap, keywordsToPrint);
		for (org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator keywordToPrint : keywordsToPrint) {
			// for keywords the concrete index does not matter, but we must add one to indicate that
			// the keyword needs to be printed here
			keywordToPrint.addIndexToPrint(0);
		}
	}
	
	// tries to decorate the decorator with an attribute value, or reference holds by eObject
	// returns true if an attribute value or reference was found
	public boolean decorateTreeBasic(org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap, java.util.List<org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator> keywordsToPrint) {
		boolean foundFeatureToPrint = false;
		org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement syntaxElement = decorator.getDecoratedElement();
		org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality = syntaxElement.getCardinality();
		while (true) {
			java.util.List<org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator> subKeywordsToPrint = new java.util.ArrayList<org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator>();
			boolean keepDecorating = false;
			if (syntaxElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecKeyword) {
				subKeywordsToPrint.add(decorator);
			} else if (syntaxElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecPlaceholder) {
				org.emftext.language.refactoring.specification.resource.grammar.RefspecPlaceholder placeholder = (org.emftext.language.refactoring.specification.resource.grammar.RefspecPlaceholder) syntaxElement;
				org.eclipse.emf.ecore.EStructuralFeature feature = placeholder.getFeature();
				int countLeft = printCountingMap.get(feature.getName());
				if (countLeft > 0) {
					decorator.addIndexToPrint(countLeft);
					printCountingMap.put(feature.getName(), countLeft - 1);
					keepDecorating = true;
				}
			} else if (syntaxElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecContainment) {
				org.emftext.language.refactoring.specification.resource.grammar.RefspecContainment containment = (org.emftext.language.refactoring.specification.resource.grammar.RefspecContainment) syntaxElement;
				org.eclipse.emf.ecore.EStructuralFeature feature = containment.getFeature();
				int countLeft = printCountingMap.get(feature.getName());
				if (countLeft > 0) {
					decorator.addIndexToPrint(countLeft);
					printCountingMap.put(feature.getName(), countLeft - 1);
					keepDecorating = true;
				}
			}
			for (org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);
				if (syntaxElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecChoice) {
					break;
				}
			}
			foundFeatureToPrint |= keepDecorating;
			// we only print keywords if a feature was printed or the syntax element in mandatory
			if (cardinality == org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality.ONE || cardinality == org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality.PLUS) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			} else if (keepDecorating && (cardinality == org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality.STAR || cardinality == org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality.QUESTIONMARK)) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			}
			if (cardinality == org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality.ONE || cardinality == org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality.QUESTIONMARK) {
				break;
			} else if (!keepDecorating) {
				break;
			}
		}
		return foundFeatureToPrint;
	}
	
	public boolean printTree(org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject) {
		org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement printElement = decorator.getDecoratedElement();
		org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality = printElement.getCardinality();
		boolean foundSomethingToPrint;
		while (true) {
			foundSomethingToPrint = false;
			java.lang.Integer indexToPrint = decorator.getNextIndexToPrint();
			if (indexToPrint != null) {
				if (printElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecKeyword) {
					printKeyword((org.emftext.language.refactoring.specification.resource.grammar.RefspecKeyword) printElement, foundFormattingElements);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecPlaceholder) {
					org.emftext.language.refactoring.specification.resource.grammar.RefspecPlaceholder placeholder = (org.emftext.language.refactoring.specification.resource.grammar.RefspecPlaceholder) printElement;
					org.eclipse.emf.ecore.EStructuralFeature feature = placeholder.getFeature();
					printFeature(eObject, feature, placeholder.getTokenName(), indexToPrint, foundFormattingElements);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecContainment) {
					org.emftext.language.refactoring.specification.resource.grammar.RefspecContainment containment = (org.emftext.language.refactoring.specification.resource.grammar.RefspecContainment) printElement;
					org.eclipse.emf.ecore.EStructuralFeature feature = containment.getFeature();
					printContainedObject(eObject, feature, indexToPrint, foundFormattingElements);
					foundSomethingToPrint = true;
				}
			}
			if (printElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecWhiteSpace) {
				foundFormattingElements.add((org.emftext.language.refactoring.specification.resource.grammar.RefspecWhiteSpace) printElement);
			}
			if (printElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecLineBreak) {
				foundFormattingElements.add((org.emftext.language.refactoring.specification.resource.grammar.RefspecLineBreak) printElement);
			}
			for (org.emftext.language.refactoring.specification.resource.mopp.RefspecSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				foundSomethingToPrint |= printTree(childDecorator, eObject);
			}
			if (cardinality == org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality.ONE || cardinality == org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality.QUESTIONMARK) {
				break;
			} else if (!foundSomethingToPrint) {
				break;
			}
		}
		return foundSomethingToPrint;
	}
	
	public void printKeyword(org.emftext.language.refactoring.specification.resource.grammar.RefspecKeyword keyword, java.util.List<org.emftext.language.refactoring.specification.resource.grammar.RefspecFormattingElement> foundFormattingElements) {
		printFormattingElements(foundFormattingElements);
		writer.write(keyword.getValue());
	}
	
	public void printFeature(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, java.lang.String tokenName, int count, java.util.List<org.emftext.language.refactoring.specification.resource.grammar.RefspecFormattingElement> foundFormattingElements) {
		printFormattingElements(foundFormattingElements);
		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			printAttribute(eObject, (org.eclipse.emf.ecore.EAttribute) feature, tokenName, count);
		} else {
			printReference(eObject, (org.eclipse.emf.ecore.EReference) feature, tokenName, count);
		}
	}
	
	public void printAttribute(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EAttribute attribute, String tokenName, int count) {
		java.lang.Object o = getValue(eObject, attribute, count);
		// deresolve token
		org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
		tokenResolver.setOptions(getOptions());
		String deResolvedValue = tokenResolver.deResolve((java.lang.Object) o, attribute, eObject);
		// write result
		writer.write(deResolvedValue);
	}
	
	public void printContainedObject(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature reference, int count, java.util.List<org.emftext.language.refactoring.specification.resource.grammar.RefspecFormattingElement> foundFormattingElements) {
		printFormattingElements(foundFormattingElements);
		java.lang.Object o = getValue(eObject, reference, count);
		doPrint((org.eclipse.emf.ecore.EObject) o);
	}
	
	public void printFormattingElements(java.util.List<org.emftext.language.refactoring.specification.resource.grammar.RefspecFormattingElement> foundFormattingElements) {
		if (foundFormattingElements.size() > 0) {
			for (org.emftext.language.refactoring.specification.resource.grammar.RefspecFormattingElement foundFormattingElement : foundFormattingElements) {
				if (foundFormattingElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecWhiteSpace) {
					int amount = ((org.emftext.language.refactoring.specification.resource.grammar.RefspecWhiteSpace) foundFormattingElement).getAmount();
					for (int i = 0; i < amount; i++) {
						writer.write(" ");
					}
				}
				if (foundFormattingElement instanceof org.emftext.language.refactoring.specification.resource.grammar.RefspecLineBreak) {
					int tabs = ((org.emftext.language.refactoring.specification.resource.grammar.RefspecLineBreak) foundFormattingElement).getTabs();
					writer.write(NEW_LINE);
					for (int i = 0; i < tabs; i++) {
						writer.write("\t");
					}
				}
			}
			foundFormattingElements.clear();
		} else {
			if (startedPrintingElement) {
				startedPrintingElement = false;
			} else {
				writer.write(" ");
			}
		}
	}
	
	private Object getValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int count) {
		// get value of reference
		java.lang.Object o = eObject.eGet(feature);
		if (o instanceof java.util.List<?>) {
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			o = list.get(index);
		}
		return o;
	}
	
	public void printReference(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EReference reference, String tokenName, int count) {
		java.lang.Object o = getValue(eObject, reference, count);
		org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
		tokenResolver.setOptions(getOptions());
		org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver referenceResolver = getReferenceResolverSwitch().getResolver(reference);
		referenceResolver.setOptions(getOptions());
		java.lang.String deresolvedReference = referenceResolver.deResolve((org.eclipse.emf.ecore.EObject) o, eObject, reference);
		java.lang.String deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);
		// write result
		writer.write(deresolvedToken);
	}
	
	public java.util.Map<java.lang.String, java.lang.Integer> initializePrintCountingMap(org.eclipse.emf.ecore.EObject eObject) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
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
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTextResource getResource() {
		return resource;
	}
	
	protected org.emftext.language.refactoring.specification.resource.mopp.RefspecReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.refactoring.specification.resource.mopp.RefspecReferenceResolverSwitch) new org.emftext.language.refactoring.specification.resource.mopp.RefspecMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final java.lang.String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.refactoring.specification.resource.mopp.RefspecProblem(errorMessage, org.emftext.language.refactoring.specification.resource.RefspecEProblemType.ERROR), cause);
	}
	
}
