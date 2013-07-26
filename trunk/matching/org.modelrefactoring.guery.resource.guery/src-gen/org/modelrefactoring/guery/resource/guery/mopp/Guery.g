grammar Guery;

options {
	superClass = GueryANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.modelrefactoring.guery.resource.guery.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionPositions = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionPositions.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.modelrefactoring.guery.resource.guery.mopp;
}

@members{
	private org.modelrefactoring.guery.resource.guery.IGueryTokenResolverFactory tokenResolverFactory = new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenResolverFactory();
	
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
	private java.util.List<org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal> expectedElements = new java.util.ArrayList<org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<Integer> lexerExceptionPositions = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
	
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
	
	private org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap;
	
	private org.modelrefactoring.guery.resource.guery.mopp.GuerySyntaxErrorMessageConverter syntaxErrorMessageConverter = new org.modelrefactoring.guery.resource.guery.mopp.GuerySyntaxErrorMessageConverter(tokenNames);
	
	@Override	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException re) {
		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
	}
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>() {
			public boolean execute(org.modelrefactoring.guery.resource.guery.IGueryTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.modelrefactoring.guery.resource.guery.IGueryProblem() {
					public org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity getSeverity() {
						return org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity.ERROR;
					}
					public org.modelrefactoring.guery.resource.guery.GueryEProblemType getType() {
						return org.modelrefactoring.guery.resource.guery.GueryEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	protected void addErrorToResource(org.modelrefactoring.guery.resource.guery.mopp.GueryLocalizedMessage message) {
		if (message == null) {
			return;
		}
		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
	}
	
	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		org.modelrefactoring.guery.resource.guery.IGueryExpectedElement terminal = org.modelrefactoring.guery.resource.guery.grammar.GueryFollowSetProvider.TERMINALS[terminalID];
		org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] containmentFeatures = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.modelrefactoring.guery.resource.guery.grammar.GueryFollowSetProvider.LINKS[ids[i]];
		}
		org.modelrefactoring.guery.resource.guery.grammar.GueryContainmentTrace containmentTrace = new org.modelrefactoring.guery.resource.guery.grammar.GueryContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal expectedElement = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		final org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>() {
			public boolean execute(org.modelrefactoring.guery.resource.guery.IGueryTextResource resource) {
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
		final org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>() {
			public boolean execute(org.modelrefactoring.guery.resource.guery.IGueryTextResource resource) {
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
	protected void setLocalizationEnd(java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		final org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>() {
			public boolean execute(org.modelrefactoring.guery.resource.guery.IGueryTextResource resource) {
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new GueryParser(new org.antlr.runtime3_4_0.CommonTokenStream(new GueryLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new GueryParser(new org.antlr.runtime3_4_0.CommonTokenStream(new GueryLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new org.modelrefactoring.guery.resource.guery.util.GueryRuntimeUtil().logError("Error while creating parser.", e);
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
		((GueryLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.modelrefactoring.guery.MotifModel.class) {
				return parse_org_modelrefactoring_guery_MotifModel();
			}
			if (type.getInstanceClass() == org.modelrefactoring.guery.Motif.class) {
				return parse_org_modelrefactoring_guery_Motif();
			}
			if (type.getInstanceClass() == org.modelrefactoring.guery.PreProcessor.class) {
				return parse_org_modelrefactoring_guery_PreProcessor();
			}
			if (type.getInstanceClass() == org.modelrefactoring.guery.VertexSelection.class) {
				return parse_org_modelrefactoring_guery_VertexSelection();
			}
			if (type.getInstanceClass() == org.modelrefactoring.guery.Role.class) {
				return parse_org_modelrefactoring_guery_Role();
			}
			if (type.getInstanceClass() == org.modelrefactoring.guery.Constraint.class) {
				return parse_org_modelrefactoring_guery_Constraint();
			}
			if (type.getInstanceClass() == org.modelrefactoring.guery.ConnectedBy.class) {
				return parse_org_modelrefactoring_guery_ConnectedBy();
			}
			if (type.getInstanceClass() == org.modelrefactoring.guery.NotConnectedBy.class) {
				return parse_org_modelrefactoring_guery_NotConnectedBy();
			}
			if (type.getInstanceClass() == org.modelrefactoring.guery.Connection.class) {
				return parse_org_modelrefactoring_guery_Connection();
			}
			if (type.getInstanceClass() == org.modelrefactoring.guery.Grouping.class) {
				return parse_org_modelrefactoring_guery_Grouping();
			}
		}
		throw new org.modelrefactoring.guery.resource.guery.mopp.GueryUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(org.modelrefactoring.guery.resource.guery.IGueryOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.modelrefactoring.guery.resource.guery.IGueryParseResult parse() {
		// Reset parser state
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>>();
		org.modelrefactoring.guery.resource.guery.mopp.GueryParseResult parseResult = new org.modelrefactoring.guery.resource.guery.mopp.GueryParseResult();
		if (disableLocationMap) {
			locationMap = new org.modelrefactoring.guery.resource.guery.mopp.GueryDevNullLocationMap();
		} else {
			locationMap = new org.modelrefactoring.guery.resource.guery.mopp.GueryLocationMap();
		}
		// Run parser
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
				parseResult.setLocationMap(locationMap);
			}
		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
			addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
			addErrorToResource(syntaxErrorMessageConverter.translateLexicalError(re, lexerExceptions, lexerExceptionPositions));
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.modelrefactoring.guery.resource.guery.IGueryTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.modelrefactoring.guery.resource.guery.IGueryParseResult result = parse();
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
			for (org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal>();
		java.util.List<org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal> newFollowSet = new java.util.ArrayList<org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 65;
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
				for (org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.modelrefactoring.guery.resource.guery.util.GueryPair<org.modelrefactoring.guery.resource.guery.IGueryExpectedElement, org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.modelrefactoring.guery.resource.guery.util.GueryPair<org.modelrefactoring.guery.resource.guery.IGueryExpectedElement, org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[]> newFollowerPair : newFollowers) {
							org.modelrefactoring.guery.resource.guery.IGueryExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.modelrefactoring.guery.resource.guery.grammar.GueryContainmentTrace containmentTrace = new org.modelrefactoring.guery.resource.guery.grammar.GueryContainmentTrace(null, newFollowerPair.getRight());
							org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal newFollowTerminal = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_modelrefactoring_guery_MotifModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_modelrefactoring_guery_MotifModel returns [org.modelrefactoring.guery.MotifModel element = null]
@init{
}
:
	(
		a0_0 = parse_org_modelrefactoring_guery_Motif		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createMotifModel();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.modelrefactoring.guery.GueryPackage.MOTIF_MODEL__MOTIFS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_0_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[1]);
	}
	
	(
		(
			(
				a1_0 = parse_org_modelrefactoring_guery_Motif				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createMotifModel();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, org.modelrefactoring.guery.GueryPackage.MOTIF_MODEL__MOTIFS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_0_0_0_1_0_0_2, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[2]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[3]);
	}
	
;

parse_org_modelrefactoring_guery_Motif returns [org.modelrefactoring.guery.Motif element = null]
@init{
}
:
	a0 = 'motif' {
		if (element == null) {
			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createMotif();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[4]);
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createMotif();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[6]);
	}
	
	(
		(
			a2_0 = parse_org_modelrefactoring_guery_PreProcessor			{
				if (terminateParsing) {
					throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
				}
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createMotif();
					startIncompleteElement(element);
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						Object value = a2_0;
						addObjectToList(element, org.modelrefactoring.guery.GueryPackage.MOTIF__PREPARE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_2, a2_0, true);
					copyLocalizationInfos(a2_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[8]);
	}
	
	(
		a3_0 = parse_org_modelrefactoring_guery_VertexSelection		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createMotif();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__VERTEX_SELECTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[12]);
	}
	
	(
		(
			a4_0 = parse_org_modelrefactoring_guery_EdgeSelection			{
				if (terminateParsing) {
					throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
				}
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createMotif();
					startIncompleteElement(element);
				}
				if (a4_0 != null) {
					if (a4_0 != null) {
						Object value = a4_0;
						addObjectToList(element, org.modelrefactoring.guery.GueryPackage.MOTIF__EDGE_SELECTIONS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_4, a4_0, true);
					copyLocalizationInfos(a4_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[15]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[16]);
	}
	
	(
		(
			a5_0 = parse_org_modelrefactoring_guery_Grouping			{
				if (terminateParsing) {
					throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
				}
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createMotif();
					startIncompleteElement(element);
				}
				if (a5_0 != null) {
					if (a5_0 != null) {
						Object value = a5_0;
						addObjectToList(element, org.modelrefactoring.guery.GueryPackage.MOTIF__GROUP_BY, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_5, a5_0, true);
					copyLocalizationInfos(a5_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[18]);
	}
	
;

parse_org_modelrefactoring_guery_PreProcessor returns [org.modelrefactoring.guery.PreProcessor element = null]
@init{
}
:
	a0 = 'prepare with' {
		if (element == null) {
			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createPreProcessor();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[19]);
	}
	
	(
		a1 = CLASSNAME		
		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createPreProcessor();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CLASSNAME");
				tokenResolver.setOptions(getOptions());
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.PRE_PROCESSOR__CLASS), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.Class resolved = (java.lang.Class) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.PRE_PROCESSOR__CLASS), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[21]);
	}
	
;

parse_org_modelrefactoring_guery_VertexSelection returns [org.modelrefactoring.guery.VertexSelection element = null]
@init{
}
:
	a0 = 'select' {
		if (element == null) {
			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[22]);
	}
	
	(
		a1_0 = parse_org_modelrefactoring_guery_Role		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__ROLES, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[28]);
	}
	
	(
		(
			a2 = ',' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[29]);
			}
			
			(
				a3_0 = parse_org_modelrefactoring_guery_Role				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__ROLES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_3_0_0_2, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[30]);
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[31]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[32]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[33]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[34]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[35]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[39]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[40]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[41]);
	}
	
	(
		(
			a4 = 'where' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[42]);
			}
			
			(
				a5_0 = parse_org_modelrefactoring_guery_Constraint				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4_0_0_2, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[43]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[44]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[45]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[46]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[47]);
			}
			
			(
				(
					a6 = 'and' {
						if (element == null) {
							element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4_0_0_3_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[48]);
					}
					
					(
						a7_0 = parse_org_modelrefactoring_guery_Constraint						{
							if (terminateParsing) {
								throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
							}
							if (element == null) {
								element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
								startIncompleteElement(element);
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									Object value = a7_0;
									addObjectToList(element, org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4_0_0_3_0_0_2, a7_0, true);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[49]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[50]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[51]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[52]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[53]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[54]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[55]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[56]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[57]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[58]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[59]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[61]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[62]);
	}
	
;

parse_org_modelrefactoring_guery_Role returns [org.modelrefactoring.guery.Role element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createRole();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.ROLE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.ROLE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_4_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[68]);
	}
	
;

parse_org_modelrefactoring_guery_Constraint returns [org.modelrefactoring.guery.Constraint element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConstraint();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONSTRAINT__EXPRESSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONSTRAINT__EXPRESSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[71]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[72]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[73]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[74]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[76]);
	}
	
;

parse_org_modelrefactoring_guery_ConnectedBy returns [org.modelrefactoring.guery.ConnectedBy element = null]
@init{
}
:
	a0 = 'connected by' {
		if (element == null) {
			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[77]);
	}
	
	(
		a1_0 = parse_org_modelrefactoring_guery_Connection		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONNECTIONS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_3, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[79]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[80]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[83]);
	}
	
	(
		(
			a2 = 'and' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_4_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[84]);
			}
			
			(
				a3_0 = parse_org_modelrefactoring_guery_Connection				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONNECTIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_4_0_0_2, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[85]);
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[86]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[87]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[88]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[89]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[90]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[96]);
	}
	
	(
		(
			a4 = 'where' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[97]);
			}
			
			(
				a5_0 = parse_org_modelrefactoring_guery_Constraint				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONSTRAINTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5_0_0_2, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[98]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[99]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[100]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[101]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[102]);
			}
			
			(
				(
					a6 = 'and' {
						if (element == null) {
							element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5_0_0_3_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[103]);
					}
					
					(
						a7_0 = parse_org_modelrefactoring_guery_Constraint						{
							if (terminateParsing) {
								throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
							}
							if (element == null) {
								element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
								startIncompleteElement(element);
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									Object value = a7_0;
									addObjectToList(element, org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONSTRAINTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5_0_0_3_0_0_2, a7_0, true);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[104]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[105]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[106]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[107]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[108]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[109]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[110]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[111]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[112]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[113]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[115]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[117]);
	}
	
;

parse_org_modelrefactoring_guery_NotConnectedBy returns [org.modelrefactoring.guery.NotConnectedBy element = null]
@init{
}
:
	a0 = 'not connected by' {
		if (element == null) {
			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[118]);
	}
	
	(
		a1_0 = parse_org_modelrefactoring_guery_Connection		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_3, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[124]);
	}
	
	(
		(
			a2 = 'and' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_4_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[125]);
			}
			
			(
				a3_0 = parse_org_modelrefactoring_guery_Connection				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_4_0_0_2, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[126]);
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[127]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[128]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[129]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[130]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[131]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[132]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[133]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[135]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[136]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[137]);
	}
	
	(
		(
			a4 = 'where' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[138]);
			}
			
			(
				a5_0 = parse_org_modelrefactoring_guery_Constraint				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_2, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[139]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[140]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[141]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[142]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[143]);
			}
			
			(
				(
					a6 = 'and' {
						if (element == null) {
							element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_3_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[144]);
					}
					
					(
						a7_0 = parse_org_modelrefactoring_guery_Constraint						{
							if (terminateParsing) {
								throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
							}
							if (element == null) {
								element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
								startIncompleteElement(element);
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									Object value = a7_0;
									addObjectToList(element, org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_3_0_0_2, a7_0, true);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[145]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[146]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[147]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[148]);
						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[149]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[150]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[151]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[152]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[153]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[154]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[158]);
	}
	
;

parse_org_modelrefactoring_guery_Connection returns [org.modelrefactoring.guery.Connection element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
				}
			}
			if (a0 != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__PATH), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__PATH), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[159]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[160]);
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
				}
			}
			if (a2 != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__FROM), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.modelrefactoring.guery.Role proxy = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.modelrefactoring.guery.resource.guery.mopp.GueryContextDependentURIFragmentFactory<org.modelrefactoring.guery.Connection, org.modelrefactoring.guery.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionFromReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__FROM), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__FROM), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[161]);
	}
	
	a3 = '>' {
		if (element == null) {
			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[162]);
	}
	
	(
		a4 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
				}
			}
			if (a4 != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__TO), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.modelrefactoring.guery.Role proxy = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.modelrefactoring.guery.resource.guery.mopp.GueryContextDependentURIFragmentFactory<org.modelrefactoring.guery.Connection, org.modelrefactoring.guery.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionToReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__TO), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__TO), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[163]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[164]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[166]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[167]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[168]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[169]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[170]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[172]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[173]);
	}
	
	(
		(
			a6 = '[' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[174]);
			}
			
			(
				a7 = CARDINALITY				
				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
						}
					}
					if (a7 != null) {
						org.modelrefactoring.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
						tokenResolver.setOptions(getOptions());
						org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MIN_LENGTH), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MIN_LENGTH), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[175]);
			}
			
			a8 = ',' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[176]);
			}
			
			(
				a9 = CARDINALITY				
				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
						}
					}
					if (a9 != null) {
						org.modelrefactoring.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
						tokenResolver.setOptions(getOptions());
						org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MAX_LENGTH), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MAX_LENGTH), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_3, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[177]);
			}
			
			a10 = ']' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[178]);
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[179]);
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[180]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[181]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[182]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[183]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[184]);
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[185]);
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[186]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[187]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[192]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[194]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[195]);
	}
	
	(
		(
			a11 = 'find all' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnection();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_8, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[196]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[197]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[198]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[199]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[203]);
	}
	
;

parse_org_modelrefactoring_guery_Grouping returns [org.modelrefactoring.guery.Grouping element = null]
@init{
}
:
	a0 = 'group by' {
		if (element == null) {
			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createGrouping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[204]);
	}
	
	(
		a1_0 = parse_org_modelrefactoring_guery_Constraint		{
			if (terminateParsing) {
				throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
			}
			if (element == null) {
				element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createGrouping();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, org.modelrefactoring.guery.GueryPackage.GROUPING__CONSTRAINTS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[205]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[206]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[207]);
	}
	
	(
		(
			a2 = 'and' {
				if (element == null) {
					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createGrouping();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_3_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[208]);
			}
			
			(
				a3_0 = parse_org_modelrefactoring_guery_Constraint				{
					if (terminateParsing) {
						throw new org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException();
					}
					if (element == null) {
						element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createGrouping();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.modelrefactoring.guery.GueryPackage.GROUPING__CONSTRAINTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_3_0_0_2, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[209]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[210]);
				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[211]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[212]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[213]);
		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[214]);
	}
	
;

parse_org_modelrefactoring_guery_EdgeSelection returns [org.modelrefactoring.guery.EdgeSelection element = null]
:
	c0 = parse_org_modelrefactoring_guery_ConnectedBy{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_modelrefactoring_guery_NotConnectedBy{ element = c1; /* this is a subclass or primitive expression choice */ }
	
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

