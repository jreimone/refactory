grammar Guery;

options {
	superClass = GueryANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.qualitune.guery.resource.guery.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.qualitune.guery.resource.guery.mopp;
}

@members{
	private org.qualitune.guery.resource.guery.IGueryTokenResolverFactory tokenResolverFactory = new org.qualitune.guery.resource.guery.mopp.GueryTokenResolverFactory();
	
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
	private java.util.List<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal> expectedElements = new java.util.ArrayList<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
	
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
	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
	
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
		postParseCommands.add(new org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>() {
			public boolean execute(org.qualitune.guery.resource.guery.IGueryTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.qualitune.guery.resource.guery.IGueryProblem() {
					public org.qualitune.guery.resource.guery.GueryEProblemSeverity getSeverity() {
						return org.qualitune.guery.resource.guery.GueryEProblemSeverity.ERROR;
					}
					public org.qualitune.guery.resource.guery.GueryEProblemType getType() {
						return org.qualitune.guery.resource.guery.GueryEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.qualitune.guery.resource.guery.IGueryQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		org.qualitune.guery.resource.guery.IGueryExpectedElement terminal = org.qualitune.guery.resource.guery.grammar.GueryFollowSetProvider.TERMINALS[terminalID];
		org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[] containmentFeatures = new org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.qualitune.guery.resource.guery.grammar.GueryFollowSetProvider.LINKS[ids[i]];
		}
		org.qualitune.guery.resource.guery.grammar.GueryContainmentTrace containmentTrace = new org.qualitune.guery.resource.guery.grammar.GueryContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal expectedElement = new org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal(container, terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
			this.expectedElementsIndexOfLastCompleteElement = 0;
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>() {
			public boolean execute(org.qualitune.guery.resource.guery.IGueryTextResource resource) {
				org.qualitune.guery.resource.guery.IGueryLocationMap locationMap = resource.getLocationMap();
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
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>() {
			public boolean execute(org.qualitune.guery.resource.guery.IGueryTextResource resource) {
				org.qualitune.guery.resource.guery.IGueryLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>() {
			public boolean execute(org.qualitune.guery.resource.guery.IGueryTextResource resource) {
				org.qualitune.guery.resource.guery.IGueryLocationMap locationMap = resource.getLocationMap();
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
	
	public org.qualitune.guery.resource.guery.IGueryTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new GueryParser(new org.antlr.runtime3_4_0.CommonTokenStream(new GueryLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new GueryParser(new org.antlr.runtime3_4_0.CommonTokenStream(new GueryLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public GueryParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((GueryLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((GueryLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.qualitune.guery.MotifModel.class) {
				return parse_org_qualitune_guery_MotifModel();
			}
			if (type.getInstanceClass() == org.qualitune.guery.Motif.class) {
				return parse_org_qualitune_guery_Motif();
			}
			if (type.getInstanceClass() == org.qualitune.guery.PreProcessor.class) {
				return parse_org_qualitune_guery_PreProcessor();
			}
			if (type.getInstanceClass() == org.qualitune.guery.VertexSelection.class) {
				return parse_org_qualitune_guery_VertexSelection();
			}
			if (type.getInstanceClass() == org.qualitune.guery.Role.class) {
				return parse_org_qualitune_guery_Role();
			}
			if (type.getInstanceClass() == org.qualitune.guery.Constraint.class) {
				return parse_org_qualitune_guery_Constraint();
			}
			if (type.getInstanceClass() == org.qualitune.guery.ConnectedBy.class) {
				return parse_org_qualitune_guery_ConnectedBy();
			}
			if (type.getInstanceClass() == org.qualitune.guery.NotConnectedBy.class) {
				return parse_org_qualitune_guery_NotConnectedBy();
			}
			if (type.getInstanceClass() == org.qualitune.guery.Connection.class) {
				return parse_org_qualitune_guery_Connection();
			}
			if (type.getInstanceClass() == org.qualitune.guery.Grouping.class) {
				return parse_org_qualitune_guery_Grouping();
			}
		}
		throw new org.qualitune.guery.resource.guery.mopp.GueryUnexpectedContentTypeException(typeObject);
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
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
			typeObject = options.get(org.qualitune.guery.resource.guery.IGueryOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.qualitune.guery.resource.guery.IGueryParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>>();
		org.qualitune.guery.resource.guery.mopp.GueryParseResult parseResult = new org.qualitune.guery.resource.guery.mopp.GueryParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.qualitune.guery.resource.guery.IGueryTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.qualitune.guery.resource.guery.IGueryParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal>();
		java.util.List<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal> newFollowSet = new java.util.ArrayList<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 59;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.qualitune.guery.resource.guery.util.GueryPair<org.qualitune.guery.resource.guery.IGueryExpectedElement, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.qualitune.guery.resource.guery.util.GueryPair<org.qualitune.guery.resource.guery.IGueryExpectedElement, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[]> newFollowerPair : newFollowers) {
							org.qualitune.guery.resource.guery.IGueryExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.qualitune.guery.resource.guery.grammar.GueryContainmentTrace containmentTrace = new org.qualitune.guery.resource.guery.grammar.GueryContainmentTrace(null, newFollowerPair.getRight());
							org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal newFollowTerminal = new org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	private void startIncompleteElement(Object object) {
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
		}
	}
	
	private void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			boolean exists = this.incompleteObjects.remove(object);
			if (!exists) {
			}
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
		if (incompleteObjects.isEmpty()) {
			return null;
		}
		return incompleteObjects.get(incompleteObjects.size() - 1);
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_qualitune_guery_MotifModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_qualitune_guery_MotifModel returns [org.qualitune.guery.MotifModel element = null]
@init{
}
:
	(
		a0_0 = parse_org_qualitune_guery_Motif		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotifModel();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF_MODEL__MOTIFS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_0_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[1]);
	}
	
	(
		(
			(
				a1_0 = parse_org_qualitune_guery_Motif				{
					if (terminateParsing) {
						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotifModel();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF_MODEL__MOTIFS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_0_0_0_1_0_0_2, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[2]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[3]);
	}
	
;

parse_org_qualitune_guery_Motif returns [org.qualitune.guery.Motif element = null]
@init{
}
:
	a0 = 'motif' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[4]);
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[6]);
	}
	
	(
		(
			a2_0 = parse_org_qualitune_guery_PreProcessor			{
				if (terminateParsing) {
					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
				}
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
					startIncompleteElement(element);
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						Object value = a2_0;
						addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF__PREPARE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_2, a2_0, true);
					copyLocalizationInfos(a2_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[8]);
	}
	
	(
		a3_0 = parse_org_qualitune_guery_VertexSelection		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__VERTEX_SELECTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[12]);
	}
	
	(
		(
			a4_0 = parse_org_qualitune_guery_EdgeSelection			{
				if (terminateParsing) {
					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
				}
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
					startIncompleteElement(element);
				}
				if (a4_0 != null) {
					if (a4_0 != null) {
						Object value = a4_0;
						addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF__EDGE_SELECTIONS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_4, a4_0, true);
					copyLocalizationInfos(a4_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[15]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[16]);
	}
	
	(
		(
			a5_0 = parse_org_qualitune_guery_Grouping			{
				if (terminateParsing) {
					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
				}
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
					startIncompleteElement(element);
				}
				if (a5_0 != null) {
					if (a5_0 != null) {
						Object value = a5_0;
						addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF__GROUP_BY, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_5, a5_0, true);
					copyLocalizationInfos(a5_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[18]);
	}
	
;

parse_org_qualitune_guery_PreProcessor returns [org.qualitune.guery.PreProcessor element = null]
@init{
}
:
	a0 = 'prepare' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createPreProcessor();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[19]);
	}
	
	a1 = 'with' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createPreProcessor();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[20]);
	}
	
	(
		a2 = CLASSNAME		
		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createPreProcessor();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CLASSNAME");
				tokenResolver.setOptions(getOptions());
				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.PRE_PROCESSOR__CLASS_NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.PRE_PROCESSOR__CLASS_NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[22]);
	}
	
;

parse_org_qualitune_guery_VertexSelection returns [org.qualitune.guery.VertexSelection element = null]
@init{
}
:
	a0 = 'select' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[23]);
	}
	
	(
		a1_0 = parse_org_qualitune_guery_Role		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, org.qualitune.guery.GueryPackage.VERTEX_SELECTION__ROLES, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[29]);
	}
	
	(
		(
			a2 = ',' {
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[30]);
			}
			
			(
				a3_0 = parse_org_qualitune_guery_Role				{
					if (terminateParsing) {
						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.qualitune.guery.GueryPackage.VERTEX_SELECTION__ROLES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_3_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[31]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[32]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[33]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[34]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[35]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[36]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[39]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[40]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[41]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[42]);
	}
	
	(
		(
			a4_0 = parse_org_qualitune_guery_Constraint			{
				if (terminateParsing) {
					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
				}
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
					startIncompleteElement(element);
				}
				if (a4_0 != null) {
					if (a4_0 != null) {
						Object value = a4_0;
						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4, a4_0, true);
					copyLocalizationInfos(a4_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[43]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[44]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[45]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[46]);
	}
	
;

parse_org_qualitune_guery_Role returns [org.qualitune.guery.Role element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createRole();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.ROLE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.ROLE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_4_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[50]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[52]);
	}
	
;

parse_org_qualitune_guery_Constraint returns [org.qualitune.guery.Constraint element = null]
@init{
}
:
	a0 = 'where' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[53]);
	}
	
	(
		a1 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConstraint();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					addObjectToList(element, org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS, value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[54]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[55]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[56]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[57]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[58]);
	}
	
	(
		(
			a2 = 'and' {
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[59]);
			}
			
			(
				a3 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.qualitune.guery.GueryFactory.eINSTANCE.createConstraint();
						startIncompleteElement(element);
					}
					if (a3 != null) {
						org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_3_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[60]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[61]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[62]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[63]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[64]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[69]);
	}
	
;

parse_org_qualitune_guery_ConnectedBy returns [org.qualitune.guery.ConnectedBy element = null]
@init{
}
:
	a0 = 'connected' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[70]);
	}
	
	a1 = 'by' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[71]);
	}
	
	(
		a2_0 = parse_org_qualitune_guery_Connection		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					addObjectToList(element, org.qualitune.guery.GueryPackage.CONNECTED_BY__CONNECTIONS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_3, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[72]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[73]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[74]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[76]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[77]);
	}
	
	(
		(
			a3 = 'and' {
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[78]);
			}
			
			(
				a4_0 = parse_org_qualitune_guery_Connection				{
					if (terminateParsing) {
						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, org.qualitune.guery.GueryPackage.CONNECTED_BY__CONNECTIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_4_0_0_1, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[79]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[80]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[81]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[82]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[83]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[84]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[87]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[88]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[90]);
	}
	
	(
		(
			a5_0 = parse_org_qualitune_guery_Constraint			{
				if (terminateParsing) {
					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
				}
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
					startIncompleteElement(element);
				}
				if (a5_0 != null) {
					if (a5_0 != null) {
						Object value = a5_0;
						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONSTRAINT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5, a5_0, true);
					copyLocalizationInfos(a5_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[94]);
	}
	
;

parse_org_qualitune_guery_NotConnectedBy returns [org.qualitune.guery.NotConnectedBy element = null]
@init{
}
:
	a0 = 'not' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[95]);
	}
	
	a1 = 'connected' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[96]);
	}
	
	a2 = 'by' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[97]);
	}
	
	(
		a3_0 = parse_org_qualitune_guery_Connection		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					addObjectToList(element, org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_4, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[101]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[103]);
	}
	
	(
		(
			a4 = 'and' {
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[104]);
			}
			
			(
				a5_0 = parse_org_qualitune_guery_Connection				{
					if (terminateParsing) {
						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[105]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[106]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[107]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[108]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[109]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[110]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[111]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[115]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[116]);
	}
	
	(
		(
			a6_0 = parse_org_qualitune_guery_Constraint			{
				if (terminateParsing) {
					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
				}
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
					startIncompleteElement(element);
				}
				if (a6_0 != null) {
					if (a6_0 != null) {
						Object value = a6_0;
						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_6, a6_0, true);
					copyLocalizationInfos(a6_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[117]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[118]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[120]);
	}
	
;

parse_org_qualitune_guery_Connection returns [org.qualitune.guery.Connection element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
				}
			}
			if (a0 != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__PATH), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__PATH), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[121]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[122]);
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
				}
			}
			if (a2 != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.qualitune.guery.Role proxy = org.qualitune.guery.GueryFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.qualitune.guery.resource.guery.mopp.GueryContextDependentURIFragmentFactory<org.qualitune.guery.Connection, org.qualitune.guery.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionFromReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[123]);
	}
	
	a3 = '>' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[124]);
	}
	
	(
		a4 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
				}
			}
			if (a4 != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.qualitune.guery.Role proxy = org.qualitune.guery.GueryFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.qualitune.guery.resource.guery.mopp.GueryContextDependentURIFragmentFactory<org.qualitune.guery.Connection, org.qualitune.guery.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionToReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[125]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[130]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[131]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[132]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[133]);
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[134]);
	}
	
	(
		(
			a6 = '[' {
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[135]);
			}
			
			(
				a7 = CARDINALITY				
				{
					if (terminateParsing) {
						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
						}
					}
					if (a7 != null) {
						org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
						tokenResolver.setOptions(getOptions());
						org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MIN_LENGTH), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MIN_LENGTH), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[136]);
			}
			
			a8 = ',' {
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[137]);
			}
			
			(
				a9 = CARDINALITY				
				{
					if (terminateParsing) {
						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
						}
					}
					if (a9 != null) {
						org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
						tokenResolver.setOptions(getOptions());
						org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MAX_LENGTH), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MAX_LENGTH), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_3, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[138]);
			}
			
			a10 = ']' {
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[139]);
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[140]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[141]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[142]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[143]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[144]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[145]);
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[146]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[147]);
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[148]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[151]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[153]);
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[154]);
	}
	
	(
		(
			a11 = 'find all' {
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_7, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[161]);
	}
	
;

parse_org_qualitune_guery_Grouping returns [org.qualitune.guery.Grouping element = null]
@init{
}
:
	a0 = 'group' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[162]);
	}
	
	a1 = 'by' {
		if (element == null) {
			element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[163]);
	}
	
	(
		a2 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					addObjectToList(element, org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS, value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[164]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[166]);
	}
	
	(
		(
			a3 = 'and' {
				if (element == null) {
					element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[167]);
			}
			
			(
				a4 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
						startIncompleteElement(element);
					}
					if (a4 != null) {
						org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_4_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[168]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[169]);
				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[170]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[172]);
		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[173]);
	}
	
;

parse_org_qualitune_guery_EdgeSelection returns [org.qualitune.guery.EdgeSelection element = null]
:
	c0 = parse_org_qualitune_guery_ConnectedBy{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_qualitune_guery_NotConnectedBy{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

IDENTIFIER:
	(('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*)
;
CLASSNAME:
	(('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*('.'('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*)*)
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
CARDINALITY:
	(('0')|('-1')|('*')|(('1'..'9')('0'..'9')*))
;
SL_COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

