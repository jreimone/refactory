grammar Properties;

options {
	superClass = PropertiesANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.refactoring.tests.properties.resource.properties.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_3_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_3_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_3_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_3_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.refactoring.tests.properties.resource.properties.mopp;
}

@members{
	private org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolverFactory tokenResolverFactory = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	/**
	 * A flag that indicates whether the parser should remember all expected elements.
	 * This flag is set to true when using the parse for code completion. Otherwise it
	 * is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_3_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_3_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	protected java.util.Stack<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	/**
	 * The offset indicating the cursor position when the parser is used for code
	 * completion by calling parseToExpectedElements().
	 */
	private int cursorOffset;
	
	/**
	 * The offset of the first hidden token of the last expected element. This offset
	 * is used to discard expected elements, which are not needed for code completion.
	 */
	private int lastStartIncludingHidden;
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource>() {
			public boolean execute(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.emftext.refactoring.tests.properties.resource.properties.IPropertiesProblem() {
					public org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemSeverity getSeverity() {
						return org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemSeverity.ERROR;
					}
					public org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType getType() {
						return org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
		if (!this.rememberExpectedElements) {
			return;
		}
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal expectedElement = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource>() {
			public boolean execute(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_3_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource>() {
			public boolean execute(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				if (source == null) {
					return true;
				}
				locationMap.setCharStart(target, source.getStartIndex());
				locationMap.setCharEnd(target, source.getStopIndex());
				locationMap.setColumn(target, source.getCharPositionInLine());
				locationMap.setLine(target, source.getLine());
				return true;
			}
		});
	}
	
	/**
	 * Sets the end character index and the last line for the given object in the
	 * location map.
	 */
	protected void setLocalizationEnd(java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource>() {
			public boolean execute(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new PropertiesParser(new org.antlr.runtime3_3_0.CommonTokenStream(new PropertiesLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new PropertiesParser(new org.antlr.runtime3_3_0.CommonTokenStream(new PropertiesLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesPlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public PropertiesParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_3_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((PropertiesLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((PropertiesLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.PropertyModel.class) {
				return parse_org_emftext_refactoring_tests_properties_PropertyModel();
			}
			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.Category.class) {
				return parse_org_emftext_refactoring_tests_properties_Category();
			}
			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.KeyValuePair.class) {
				return parse_org_emftext_refactoring_tests_properties_KeyValuePair();
			}
			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.Key.class) {
				return parse_org_emftext_refactoring_tests_properties_Key();
			}
			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.EObjectReferenceValue.class) {
				return parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue();
			}
			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.StringValue.class) {
				return parse_org_emftext_refactoring_tests_properties_StringValue();
			}
		}
		throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesUnexpectedContentTypeException(typeObject);
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_3_0.IntStream arg0, org.antlr.runtime3_3_0.RecognitionException arg1, int arg2, org.antlr.runtime3_3_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource>>();
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesParseResult parseResult = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_3_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_3_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_3_0.CommonTokenStream tokenStream = (org.antlr.runtime3_3_0.CommonTokenStream) getTokenStream();
		org.emftext.refactoring.tests.properties.resource.properties.IPropertiesParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_3_0.Lexer lexer = (org.antlr.runtime3_3_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal>();
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 12;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_3_0.CommonToken nextToken = (org.antlr.runtime3_3_0.CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesPair<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesPair<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
							org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement newFollower = newFollowerPair.getLeft();
							org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal newFollowTerminal = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
							newFollowSet.add(newFollowTerminal);
							expectedElements.add(newFollowTerminal);
						}
					}
				}
				currentFollowSet.clear();
				currentFollowSet.addAll(newFollowSet);
			}
			followSetID++;
		}
		// after the last token in the stream we must set the position for the elements
		// that were added during the last iteration of the loop
		for (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_3_0.CommonToken tokenAtIndex = (org.antlr.runtime3_3_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_3_0.IntStream input, int ttype, org.antlr.runtime3_3_0.BitSet follow) throws org.antlr.runtime3_3_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_3_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_3_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_3_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_3_0.CommonToken) {
			final org.antlr.runtime3_3_0.CommonToken ct = (org.antlr.runtime3_3_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_3_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
			org.antlr.runtime3_3_0.EarlyExitException eee = (org.antlr.runtime3_3_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedRangeException) {
			org.antlr.runtime3_3_0.MismatchedRangeException mre = (org.antlr.runtime3_3_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	protected void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			this.incompleteObjects.pop();
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_emftext_refactoring_tests_properties_PropertyModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_emftext_refactoring_tests_properties_PropertyModel returns [org.emftext.refactoring.tests.properties.PropertyModel element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_refactoring_tests_properties_Category				{
					if (terminateParsing) {
						throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createPropertyModel();
						incompleteObjects.push(element);
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							Object value = a0_0;
							addObjectToList(element, org.emftext.refactoring.tests.properties.PropertiesPackage.PROPERTY_MODEL__CATEGORIES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_0_0_0_0_0_0_0, a0_0, true);
						copyLocalizationInfos(a0_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 2, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_refactoring_tests_properties_Category returns [org.emftext.refactoring.tests.properties.Category element = null]
@init{
}
:
	(
		a0 = QUOTED_91_93		
		{
			if (terminateParsing) {
				throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createCategory();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_91_93");
				tokenResolver.setOptions(getOptions());
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_1_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0);
	}
	
	(
		(
			a1_0 = parse_org_emftext_refactoring_tests_properties_KeyValuePair			{
				if (terminateParsing) {
					throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createCategory();
					incompleteObjects.push(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__PAIRS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_1_0_0_2, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 4, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 4, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 4, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 4, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_refactoring_tests_properties_KeyValuePair returns [org.emftext.refactoring.tests.properties.KeyValuePair element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_refactoring_tests_properties_Key				{
					if (terminateParsing) {
						throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKeyValuePair();
						incompleteObjects.push(element);
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							Object value = a0_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__KEY), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_2_0_0_0_0_0_0, a0_0, true);
						copyLocalizationInfos(a0_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_4, 5);
			}
			
			a1 = '=' {
				if (element == null) {
					element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKeyValuePair();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_2_0_0_0_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 6, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 6, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 7, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 7, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3);
	}
	
	(
		a2_0 = parse_org_emftext_refactoring_tests_properties_Value		{
			if (terminateParsing) {
				throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKeyValuePair();
				incompleteObjects.push(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_2_0_0_1, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 8, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 8, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 8, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 8, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_refactoring_tests_properties_Key returns [org.emftext.refactoring.tests.properties.Key element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKey();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_3_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_4, 9);
	}
	
;

parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue returns [org.emftext.refactoring.tests.properties.EObjectReferenceValue element = null]
@init{
}
:
	(
		a0 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createEObjectReferenceValue();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EObject proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEObject();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesContextDependentURIFragmentFactory<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEObjectReferenceValueObjectReferenceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_4_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 10, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 10, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 10, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 10, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_refactoring_tests_properties_StringValue returns [org.emftext.refactoring.tests.properties.StringValue element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createStringValue();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_5_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 11, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 11, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 11, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2);
		addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 11, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_refactoring_tests_properties_Value returns [org.emftext.refactoring.tests.properties.Value element = null]
:
	c0 = parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_refactoring_tests_properties_StringValue{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
INTEGER:
	(('-')?('1'..'9')('0'..'9')*|'0')
	{ _channel = 99; }
;
FLOAT:
	(('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ )
	{ _channel = 99; }
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
QUOTED_91_93:
	(('[')(~(']'))*(']'))
;
QUOTED_60_62:
	(('<')(~('>'))*('>'))
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

