grammar Refspec;

options {
	superClass = RefspecANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.refactoring.specification.resource.mopp;
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
	package org.emftext.language.refactoring.specification.resource.mopp;
}

@members{
	private org.emftext.language.refactoring.specification.resource.IRefspecTokenResolverFactory tokenResolverFactory = new org.emftext.language.refactoring.specification.resource.mopp.RefspecTokenResolverFactory();
	@SuppressWarnings("unused")
	
	private int lastPosition;
	private org.emftext.language.refactoring.specification.resource.mopp.RefspecTokenResolveResult tokenResolveResult = new org.emftext.language.refactoring.specification.resource.mopp.RefspecTokenResolveResult();
	private boolean rememberExpectedElements = false;
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	private java.util.List<org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal>();
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	//helper lists to allow a lexer to pass errors to its parser
	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private java.util.Collection<org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource>> postParseCommands;
	private boolean terminateParsing;
	private int tokenIndexOfLastCompleteElement;
	private int expectedElementsIndexOfLastCompleteElement;
	
	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource>() {
			public boolean execute(org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for
					// code completion
					return true;
				}
				resource.addProblem(new org.emftext.language.refactoring.specification.resource.IRefspecProblem() {
					public org.emftext.language.refactoring.specification.resource.RefspecEProblemType getType() {
						return org.emftext.language.refactoring.specification.resource.RefspecEProblemType.ERROR;
					}
					public java.lang.String getMessage() {
						return errorMessage;
					}
				}, line, charPositionInLine, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal expectedElement) {
		if (!this.rememberExpectedElements) {
			return;
		}
		setPosition(expectedElement, input.index());
		this.expectedElements.add(expectedElement);
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.language.refactoring.specification.resource.mopp.RefspecDummyEObject dummy) {
		java.lang.Object value = element.eGet(structuralFeature);
		java.lang.Object mapKey = dummy.getValueByName("key");
		java.lang.Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.language.refactoring.specification.resource.util.RefspecMapUtil.castToEMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	
	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
	}
	
	protected org.eclipse.emf.ecore.EObject apply(org.eclipse.emf.ecore.EObject target, java.util.List<org.eclipse.emf.ecore.EObject> dummyEObjects) {
		org.eclipse.emf.ecore.EObject currentTarget = target;
		for (org.eclipse.emf.ecore.EObject object : dummyEObjects) {
			assert(object instanceof org.emftext.language.refactoring.specification.resource.mopp.RefspecDummyEObject);
			org.emftext.language.refactoring.specification.resource.mopp.RefspecDummyEObject dummy = (org.emftext.language.refactoring.specification.resource.mopp.RefspecDummyEObject) object;
			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource>() {
			public boolean execute(org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource) {
				org.emftext.language.refactoring.specification.resource.IRefspecLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for
					// code completion
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
		postParseCommands.add(new org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource>() {
			public boolean execute(org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource) {
				org.emftext.language.refactoring.specification.resource.IRefspecLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for
					// code completion
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
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
		try {
			if (encoding == null) {
				return new RefspecParser(new org.antlr.runtime3_2_0.CommonTokenStream(new RefspecLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new RefspecParser(new org.antlr.runtime3_2_0.CommonTokenStream(new RefspecLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.language.refactoring.specification.resource.mopp.RefspecPlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	// This default constructor is only used to call createInstance() on it
	public RefspecParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((RefspecLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((RefspecLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		java.lang.Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification.class) {
				return parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.CREATE.class) {
				return parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.MOVE.class) {
				return parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.Variable.class) {
				return parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.VariableReference.class) {
				return parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.RoleReference.class) {
				return parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.RelationReference.class) {
				return parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference();
			}
		}
		throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecUnexpectedContentTypeException(typeObject);
	}
	
	private org.emftext.language.refactoring.specification.resource.mopp.RefspecTokenResolveResult getFreshTokenResolveResult() {
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
	
	public org.emftext.language.refactoring.specification.resource.mopp.RefspecMetaInformation getMetaInformation() {
		return new org.emftext.language.refactoring.specification.resource.mopp.RefspecMetaInformation();
	}
	
	public java.lang.Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected org.emftext.language.refactoring.specification.resource.mopp.RefspecReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.refactoring.specification.resource.mopp.RefspecReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected java.lang.Object getTypeObject() {
		java.lang.Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.language.refactoring.specification.resource.IRefspecOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	// Implementation that calls {@link #doParse()}  and handles the thrown
	// RecognitionExceptions.
	public org.emftext.language.refactoring.specification.resource.IRefspecParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource>>();
		org.emftext.language.refactoring.specification.resource.mopp.RefspecParseResult parseResult = new org.emftext.language.refactoring.specification.resource.mopp.RefspecParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_2_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				//? can be caused if a null is set on EMF models where not allowed;
				//? this will just happen if other errors occurred before
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
	
	public java.util.List<org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.refactoring.specification.resource.IRefspecTextResource dummyResource) {
		rememberExpectedElements = true;
		parseToIndexTypeObject = type;
		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
		org.emftext.language.refactoring.specification.resource.IRefspecParseResult result = parse();
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContents().add(root);
			}
			for (org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal>();
		java.util.List<org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				System.out.println("FOLLOW ELEMENT " + expectedElementI);
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 31;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
			System.out.println("REMAINING TOKEN: " + nextToken);
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected terminals
				// can be set
				for (org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are kept
				for (org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal nextFollow : currentFollowSet) {
					System.out.println("CHECKING : " + nextFollow);
					if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						System.out.println("MATCH! " + nextFollow);
						java.util.Collection<org.emftext.language.refactoring.specification.resource.util.RefspecPair<org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.language.refactoring.specification.resource.util.RefspecPair<org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
							org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement newFollower = newFollowerPair.getLeft();
							org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal newFollowTerminal = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
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
		// after the last token in the stream we must set the position for the elements that were
		// added during the last iteration of the loop
		for (org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal expectedElement, int tokenIndex) {
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
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
		postParseCommands.add(new org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource>() {
			public boolean execute(org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for
					// code completion
					return true;
				}
				resource.registerContextDependentProxy(factory, element, reference, id, proxy);
				return true;
			}
		});
	}
	
	// Translates errors thrown by the parser into human readable messages.
	public void reportError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		java.lang.String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			java.lang.String tokenName = "<unknown>";
			if (mte.expecting == Token.EOF) {
				tokenName = "EOF";
			} else {
				tokenName = getTokenNames()[mte.expecting];
				tokenName = org.emftext.language.refactoring.specification.resource.util.RefspecStringUtil.formatTokenName(tokenName);
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
	
	// Translates errors thrown by the lexer into human readable messages.
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
	
	protected void completedElement(Object element) {
		if (element instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_0 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(), "REFACTORING");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_1 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(), org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME), "TEXT");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_2 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(), "FOR");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_3 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(), org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL), "QUOTED_60_62");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_4 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(), "STEPS");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_5 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(), "{");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_6 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE(), "create");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_7 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getMOVE(), "move");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_8 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(), ";");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_9 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(), "}");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_10 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE(), "new");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_11 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRoleReference(), org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRoleReference().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE), "TEXT");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_12 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE(), "(");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_13 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE(), "in");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_14 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE(), "->");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_15 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariable(), org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariable().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__NAME), "TEXT");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_16 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE(), ")");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_17 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariableReference(), "->");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_18 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRelationReference(), ".");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_19 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedCsString(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getMOVE(), "to");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_20 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariableReference(), org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariableReference().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE), "TEXT");
	private final static org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement TERMINAL_21 = new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRelationReference(), org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRelationReference().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION), "TEXT");
	
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_0 = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_1 = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_2 = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__VAR_DECLARATION);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_3 = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_4 = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getMOVE().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__SOURCE);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_5 = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getMOVE().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__TARGET);
	
	private final static org.eclipse.emf.ecore.EStructuralFeature[] EMPTY_FEATURE_ARRAY = new org.eclipse.emf.ecore.EStructuralFeature[0];
	
	public static void wire0() {
		TERMINAL_0.addFollower(TERMINAL_1, EMPTY_FEATURE_ARRAY);
		TERMINAL_1.addFollower(TERMINAL_2, EMPTY_FEATURE_ARRAY);
		TERMINAL_2.addFollower(TERMINAL_3, EMPTY_FEATURE_ARRAY);
		TERMINAL_3.addFollower(TERMINAL_4, EMPTY_FEATURE_ARRAY);
		TERMINAL_4.addFollower(TERMINAL_5, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_5.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_8.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_8.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_8.addFollower(TERMINAL_9, EMPTY_FEATURE_ARRAY);
		TERMINAL_6.addFollower(TERMINAL_10, EMPTY_FEATURE_ARRAY);
		TERMINAL_10.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_12.addFollower(TERMINAL_14, EMPTY_FEATURE_ARRAY);
		TERMINAL_14.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_16.addFollower(TERMINAL_13, EMPTY_FEATURE_ARRAY);
		TERMINAL_13.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
		TERMINAL_13.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
		TERMINAL_7.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, });
		TERMINAL_7.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, });
		TERMINAL_7.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, });
		TERMINAL_19.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_5, });
		TERMINAL_19.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_5, });
		TERMINAL_15.addFollower(TERMINAL_16, EMPTY_FEATURE_ARRAY);
		TERMINAL_17.addFollower(TERMINAL_20, EMPTY_FEATURE_ARRAY);
		TERMINAL_20.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
		TERMINAL_20.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_11.addFollower(TERMINAL_12, EMPTY_FEATURE_ARRAY);
		TERMINAL_11.addFollower(TERMINAL_13, EMPTY_FEATURE_ARRAY);
		TERMINAL_11.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_18.addFollower(TERMINAL_21, EMPTY_FEATURE_ARRAY);
		TERMINAL_21.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
	}
	// wire the terminals
	static {
		wire0();
	}
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_0, 0));
		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
	}
	(
		c0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification{ element = c0; }
	)
	EOF	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification returns [org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification element = null]
@init{
}
:
	a0 = 'REFACTORING' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_1, 1));
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
			}
			if (a1 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_2, 2));
	}
	
	a2 = 'FOR' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_3, 3));
	}
	
	(
		a3 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
			}
			if (a3 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.RoleModel proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, org.emftext.language.refactoring.roles.RoleModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRefactoringSpecificationUsedRoleModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_4, 4));
	}
	
	a4 = 'STEPS' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_5, 5));
	}
	
	a5 = '{' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_6, 6, FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_7, 6, FEATURE_0));
	}
	
	(
		(
			(
				a6_0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							addObjectToList(element, org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS, a6_0);
							completedElement(a6_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a6_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_8, 7));
			}
			
			a7 = ';' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_6, 8, FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_7, 8, FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_9, 8));
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_6, 9, FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_7, 9, FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_9, 9));
	}
	
	a8 = '}' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE returns [org.emftext.language.refactoring.refactoring_specification.CREATE element = null]
@init{
}
:
	a0 = 'create' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_10, 11));
	}
	
	a1 = 'new' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_11, 12, FEATURE_1));
	}
	
	(
		a2_0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_12, 13));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_13, 13));
	}
	
	(
		(
			a3 = '(' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_14, 14));
			}
			
			a4 = '->' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_15, 15, FEATURE_2));
			}
			
			(
				a5_0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__VAR_DECLARATION), a5_0);
							completedElement(a5_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a5_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_16, 16));
			}
			
			a6 = ')' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_13, 17));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_13, 18));
	}
	
	a7 = 'in' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_17, 19, FEATURE_3));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_11, 19, FEATURE_3));
	}
	
	(
		a8_0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
			}
			if (a8_0 != null) {
				if (a8_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT), a8_0);
					completedElement(a8_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a8_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_8, 20));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE returns [org.emftext.language.refactoring.refactoring_specification.MOVE element = null]
@init{
}
:
	a0 = 'move' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_17, 21, FEATURE_4));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_11, 21, FEATURE_4));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_18, 21, FEATURE_4));
	}
	
	(
		a1_0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__SOURCE), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_19, 22));
	}
	
	a2 = 'to' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_17, 23, FEATURE_5));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_11, 23, FEATURE_5));
	}
	
	(
		a3_0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__TARGET), a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_8, 24));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable returns [org.emftext.language.refactoring.refactoring_specification.Variable element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariable();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_16, 25));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference returns [org.emftext.language.refactoring.refactoring_specification.VariableReference element = null]
@init{
}
:
	a0 = '->' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableReference();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_20, 26));
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableReference();
			}
			if (a1 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.refactoring_specification.Variable proxy = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.VariableReference, org.emftext.language.refactoring.refactoring_specification.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getVariableReferenceVariableReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_8, 27));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_19, 27));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference returns [org.emftext.language.refactoring.refactoring_specification.RoleReference element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRoleReference();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.RoleReference, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleReferenceRoleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_12, 28));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_13, 28));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_19, 28));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference returns [org.emftext.language.refactoring.refactoring_specification.RelationReference element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRelationReference();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_21, 29));
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRelationReference();
			}
			if (a1 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.RoleUse proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleUse();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.RelationReference, org.emftext.language.refactoring.roles.MultiplicityRelation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationReferenceRelationReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_19, 30));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction returns [org.emftext.language.refactoring.refactoring_specification.Instruction element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE{ element = c0; /* this is a subclass or expression choice */ }
	|	c1 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE{ element = c1; /* this is a subclass or expression choice */ }
	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext returns [org.emftext.language.refactoring.refactoring_specification.TargetContext element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference{ element = c0; /* this is a subclass or expression choice */ }
	|	c1 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference{ element = c1; /* this is a subclass or expression choice */ }
	
;

parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext returns [org.emftext.language.refactoring.refactoring_specification.SourceContext element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference{ element = c0; /* this is a subclass or expression choice */ }
	|	c1 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference{ element = c1; /* this is a subclass or expression choice */ }
	|	c2 = parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference{ element = c2; /* this is a subclass or expression choice */ }
	
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
QUOTED_60_62:
	('<')(~('>'))*('>')
;

