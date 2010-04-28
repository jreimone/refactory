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
	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
	public java.util.List<java.lang.Integer> lexerExceptionsPosition = new java.util.ArrayList<java.lang.Integer>();
	
	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
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
	@SuppressWarnings("unused")
	private int lastPosition;
	
	/**
	 * the index of the last token that was handled by retrieveLayoutInformation()
	 */
	private int lastPosition2;
	
	private org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTokenResolveResult tokenResolveResult = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTokenResolveResult();
	
	/**
	 * A flag that indicateds whether the parser should remember all expected
	 * elements. This flag is set to true when using the parse for code completion.
	 * Otherwise it is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used only when the parser is used
	 * for code completion. Whenever the parser starts to read an object it is pushed
	 * on the stack. Once the element was parser completely it is popped for the stack.
	 */
	protected java.util.Stack<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	/**
	 * A collection that is filled with commands to be exectued after parsing. This
	 * collection is cleared before parsing starts and returned as part of the parse
	 * result object.
	 */
	private java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource>> postParseCommands;
	
	/**
	 * A flag to indicate that the parser should stop parsing as soon as possible. The
	 * flag is set to false before parsing starts. It can be set to true by invoking
	 * the terminateParsing() method from another thread. This feature is used, when
	 * documents are parsed in the background (i.e., while editing them). In order to
	 * cancel running parsers, the parsing process can be terminated. This is done
	 * whenever a document changes, because the previous content of the document is
	 * not valid anymore and parsing the old content is not necessary any longer.
	 */
	private boolean terminateParsing;
	
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource>() {
			public boolean execute(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.emftext.refactoring.tests.properties.resource.properties.IPropertiesProblem() {
					public org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType getType() {
						return org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType.ERROR;
					}
					public java.lang.String getMessage() {
						return errorMessage;
					}
				}, line, charPositionInLine, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal expectedElement) {
		if (!this.rememberExpectedElements) {
			return;
		}
		setPosition(expectedElement, input.index());
		this.expectedElements.add(expectedElement);
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesDummyEObject dummy) {
		java.lang.Object value = element.eGet(structuralFeature);
		java.lang.Object mapKey = dummy.getValueByName("key");
		java.lang.Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesMapUtil.castToEMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
	}
	
	protected org.eclipse.emf.ecore.EObject apply(org.eclipse.emf.ecore.EObject target, java.util.List<org.eclipse.emf.ecore.EObject> dummyEObjects) {
		org.eclipse.emf.ecore.EObject currentTarget = target;
		for (org.eclipse.emf.ecore.EObject object : dummyEObjects) {
			assert(object instanceof org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesDummyEObject);
			org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesDummyEObject dummy = (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesDummyEObject) object;
			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
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
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_2_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
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
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
		try {
			if (encoding == null) {
				return new PropertiesParser(new org.antlr.runtime3_2_0.CommonTokenStream(new PropertiesLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new PropertiesParser(new org.antlr.runtime3_2_0.CommonTokenStream(new PropertiesLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
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
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((PropertiesLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((PropertiesLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		java.lang.Object typeObject = getTypeObject();
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
	
	private org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public java.lang.Object getMissingSymbol(org.antlr.runtime3_2_0.IntStream arg0, org.antlr.runtime3_2_0.RecognitionException arg1, int arg2, org.antlr.runtime3_2_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	protected java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMetaInformation getMetaInformation() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMetaInformation();
	}
	
	public java.lang.Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected java.lang.Object getTypeObject() {
		java.lang.Object typeObject = getParseToIndexTypeObject();
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
		} catch (org.antlr.runtime3_2_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_2_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource dummyResource) {
		rememberExpectedElements = true;
		parseToIndexTypeObject = type;
		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
		org.emftext.refactoring.tests.properties.resource.properties.IPropertiesParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_2_0.Lexer lexer = (org.antlr.runtime3_2_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContents().add(root);
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
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
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
					if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {
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
		int currentIndex = java.lang.Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_2_0.CommonToken tokenAtIndex = (org.antlr.runtime3_2_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = java.lang.Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public java.lang.Object recoverFromMismatchedToken(org.antlr.runtime3_2_0.IntStream input, int ttype, org.antlr.runtime3_2_0.BitSet follow) throws org.antlr.runtime3_2_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.properties.IPropertiesCommand<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource>() {
			public boolean execute(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.registerContextDependentProxy(factory, element, reference, id, proxy);
				return true;
			}
		});
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		java.lang.String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			java.lang.String tokenName = "<unknown>";
			if (mte.expecting == Token.EOF) {
				tokenName = "EOF";
			} else {
				tokenName = getTokenNames()[mte.expecting];
				tokenName = org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesStringUtil.formatTokenName(tokenName);
			}
			message = "Syntax error on token \"" + e.token.getText() + "\", \"" + tokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_2_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_2_0.MismatchedTreeNodeException) e;
			java.lang.String tokenName = "<unknown>";
			if (mtne.expecting == Token.EOF) {
				tokenName = "EOF";
			} else {
				tokenName = getTokenNames()[mtne.expecting];
			}
			message = "mismatched tree node: "+"xxx" +"; expecting " + tokenName;
		} else if (e instanceof org.antlr.runtime3_2_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_2_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText+"}?";
		}
		// the resource may be null if the parse is used for code completion
		final java.lang.String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_2_0.CommonToken) {
			final org.antlr.runtime3_2_0.CommonToken ct = (org.antlr.runtime3_2_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		java.lang.String message = "";
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_2_0.EarlyExitException) {
			org.antlr.runtime3_2_0.EarlyExitException eee = (org.antlr.runtime3_2_0.EarlyExitException) e;
			message ="required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedRangeException) {
			org.antlr.runtime3_2_0.MismatchedRangeException mre = (org.antlr.runtime3_2_0.MismatchedRangeException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message ="rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.index, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public void terminate() {
		terminateParsing = true;
	}
	
	protected void completedElement(java.lang.Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			this.incompleteObjects.pop();
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	/**
	 * Creates a dynamic Java proxy that mimics the interface of the given class.
	 */
	@SuppressWarnings("unchecked")
	
	public <T> T createDynamicProxy(java.lang.Class<T> clazz) {
		java.lang.Object proxy = java.lang.reflect.Proxy.newProxyInstance(this.getClass().getClassLoader(), new java.lang.Class<?>[]{clazz, org.eclipse.emf.ecore.EObject.class, org.eclipse.emf.ecore.InternalEObject.class}, new java.lang.reflect.InvocationHandler() {
			
			private org.eclipse.emf.ecore.EObject dummyObject = new org.eclipse.emf.ecore.impl.EObjectImpl() {};
			
			public java.lang.Object invoke(java.lang.Object object, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
				// search in dummyObject for the requested method
				java.lang.reflect.Method[] methodsInDummy = dummyObject.getClass().getMethods();
				for (java.lang.reflect.Method methodInDummy : methodsInDummy) {
					boolean matches = true;
					if (methodInDummy.getName().equals(method.getName())) {
						java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
						java.lang.Class<?>[] parameterTypesInDummy = methodInDummy.getParameterTypes();
						if (parameterTypes.length == parameterTypesInDummy.length) {
							for (int p = 0; p < parameterTypes.length; p++) {
								java.lang.Class<?> parameterType = parameterTypes[p];
								java.lang.Class<?> parameterTypeInDummy = parameterTypesInDummy[p];
								if (!parameterType.equals(parameterTypeInDummy)) {
									matches = false;
								}
							}
						} else {
							matches = false;
						}
					} else {
						matches = false;
					}
					if (matches) {
						return methodInDummy.invoke(dummyObject, args);
					}
				}
				return null;
			}
					});
		return (T) proxy;
	}
	
	protected void retrieveLayoutInformation(org.eclipse.emf.ecore.EObject element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement syntaxElement, java.lang.Object object) {
		if (!(syntaxElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder) && !(syntaxElement instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword)) {
			return;
		}
		int currentPos = getTokenStream().index();
		if (currentPos == 0) {
			return;
		}
		int endPos = currentPos - 1;
		for (; endPos >= this.lastPosition2; endPos--) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(endPos);
			int _channel = token.getChannel();
			if (_channel != 99) {
				break;
			}
		}
		java.lang.StringBuilder hiddenTokenText = new java.lang.StringBuilder();
		java.lang.StringBuilder visibleTokenText = new java.lang.StringBuilder();
		for (int pos = this.lastPosition2; pos <= endPos; pos++) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(pos);
			int _channel = token.getChannel();
			if (_channel == 99) {
				hiddenTokenText.append(token.getText());
			} else {
				visibleTokenText.append(token.getText());
			}
		}
		org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(element);
		layoutInformationAdapter.addLayoutInformation(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesLayoutInformation(syntaxElement, object, hiddenTokenText.toString(), visibleTokenText.toString()));
		this.lastPosition2 = (endPos < 0 ? 0 : endPos + 1);
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0));
		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
	}
	(
		c0 = parse_org_emftext_refactoring_tests_properties_PropertyModel{ element = c0; }
	)
	EOF	
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
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.refactoring.tests.properties.PropertiesPackage.PROPERTY_MODEL__CATEGORIES, a0_0);
							completedElement(a0_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_0_0_0_0_0_0_0, a0_0);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 2, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0));
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
			}
			if (a0 != null) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_91_93");
				tokenResolver.setOptions(getOptions());
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_1_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0));
	}
	
	(
		(
			a1_0 = parse_org_emftext_refactoring_tests_properties_KeyValuePair			{
				if (terminateParsing) {
					throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createCategory();
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__PAIRS, a1_0);
						completedElement(a1_0, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_1_0_0_2, a1_0);
					copyLocalizationInfos(a1_0, element); 				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 4, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 4, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 4, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 4, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0));
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
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__KEY), a0_0);
							completedElement(a0_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_2_0_0_0_0_0_0, a0_0);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_4, 5));
			}
			
			a1 = '=' {
				if (element == null) {
					element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKeyValuePair();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_2_0_0_0_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 6, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3));
				addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 6, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 7, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 7, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3));
	}
	
	(
		a2_0 = parse_org_emftext_refactoring_tests_properties_Value		{
			if (terminateParsing) {
				throw new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKeyValuePair();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__VALUE), a2_0);
					completedElement(a2_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_2_0_0_1, a2_0);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 8, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 8, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 8, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 8, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0));
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
			}
			if (a0 != null) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__KEY), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__KEY), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_3_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_4, 9));
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
			}
			if (a0 != null) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EObject proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEObject();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesContextDependentURIFragmentFactory<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEObjectReferenceValueObjectReferenceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_4_0_0_0, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 10, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 10, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 10, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 10, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0));
	}
	
;

parse_org_emftext_refactoring_tests_properties_StringValue returns [org.emftext.refactoring.tests.properties.StringValue element = null]
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
				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createStringValue();
			}
			if (a0 != null) {
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_5_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_1, 11, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_1, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_2, 11, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_3, 11, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_3, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedTerminal(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.TERMINAL_0, 11, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFollowSetProvider.FEATURE_0));
	}
	
;

parse_org_emftext_refactoring_tests_properties_Value returns [org.emftext.refactoring.tests.properties.Value element = null]
:
	c0 = parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_refactoring_tests_properties_StringValue{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

COMMENT:
	'//'(~('\n'|'\r'|'\uffff'))*
	{ _channel = 99; }
;
INTEGER:
	('-')?('1'..'9')('0'..'9')*|'0'	{ _channel = 99; }
;
FLOAT:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ 	{ _channel = 99; }
;
TEXT:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+;
WHITESPACE:
	(' ' | '\t' | '\f')
	{ _channel = 99; }
;
LINEBREAK:
	('\r\n' | '\r' | '\n')
	{ _channel = 99; }
;
QUOTED_91_93:
	('[')(~(']'))*(']')
;
QUOTED_60_62:
	('<')(~('>'))*('>')
;

