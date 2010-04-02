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
	
	public boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
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
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.CREATE.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.MOVE.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.SET.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_SET();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.ASSIGN.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.UPDATE.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.Variable.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.VariableReference.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.VariableAssignment.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.RoleReference.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.TRACE.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.RelationReference.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.ConstantsReference.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.FromClause.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.UPTREE.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.PATH.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.FIRST.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.LAST.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.ConcreteIndex.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoring_specification.IndexVariable.class) {
				return parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable();
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
		int followSetID = 85;
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
	
	// creates a dynamic Java proxy that mimics the interface
	// of the given class.
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_0, 0));
		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
	}
	(
		c0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification{ element = c0; }
	)
	EOF	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification returns [org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification element = null]
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_1, 1));
	}
	
	(
		a1 = UPPER_IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
			}
			if (a1 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("UPPER_IDENTIFIER");
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_2, 2));
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_3, 3));
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_4, 4));
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_5, 5));
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_6, 6, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_7, 6, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_8, 6, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_9, 6, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_10, 6, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_11, 6, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_12, 6, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_13, 6, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
	}
	
	(
		(
			(
				a6_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction				{
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
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 7));
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
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_6, 8, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_7, 8, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_8, 8, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_9, 8, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_10, 8, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_11, 8, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_12, 8, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_13, 8, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_15, 8));
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_6, 9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_7, 9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_8, 9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_9, 9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_10, 9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_11, 9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_12, 9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_13, 9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_15, 9));
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

parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE returns [org.emftext.language.refactoring.refactoring_specification.CREATE element = null]
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_16, 11));
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_17, 12, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_1));
	}
	
	(
		a2_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__VARIABLE), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_18, 13));
	}
	
	a3 = ':' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_19, 14));
	}
	
	(
		a4 = UPPER_IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
			}
			if (a4 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("UPPER_IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.CREATE, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCREATESourceRoleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_20, 15));
	}
	
	a5 = 'in' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 16, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_2));
	}
	
	(
		a6_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
			}
			if (a6_0 != null) {
				if (a6_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT), a6_0);
					completedElement(a6_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a6_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_22, 17));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 17));
	}
	
	(
		(
			a7 = 'at' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_23, 18));
			}
			
			(
				a8 = LOWER_IDENTIFIER				
				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
					}
					if (a8 != null) {
						org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__INDEX), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.language.refactoring.refactoring_specification.IndexVariable proxy = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createIndexVariable();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.ContainmentCommand, org.emftext.language.refactoring.refactoring_specification.IndexVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentCommandIndexReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__INDEX), resolved, proxy);
						if (proxy != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__INDEX), proxy);
							completedElement(proxy);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 19));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 20));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE returns [org.emftext.language.refactoring.refactoring_specification.MOVE element = null]
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 21, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_3));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_24, 21, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_3));
	}
	
	(
		a1_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext		{
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_25, 22));
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 23, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_4));
	}
	
	(
		a3_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext		{
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_26, 24));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 24));
	}
	
	(
		(
			a4 = 'at' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_27, 25));
			}
			
			(
				a5 = LOWER_IDENTIFIER				
				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
					}
					if (a5 != null) {
						org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__INDEX), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.language.refactoring.refactoring_specification.IndexVariable proxy = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createIndexVariable();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.ContainmentCommand, org.emftext.language.refactoring.refactoring_specification.IndexVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentCommandIndexReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__INDEX), resolved, proxy);
						if (proxy != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__INDEX), proxy);
							completedElement(proxy);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 26));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 27));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_SET returns [org.emftext.language.refactoring.refactoring_specification.SET element = null]
@init{
}
:
	a0 = 'set' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_28, 28));
	}
	
	a1 = 'use' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_29, 29));
	}
	
	a2 = 'of' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 30, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_5));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_24, 30, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_5));
	}
	
	(
		a3_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.SET__SOURCE), a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_30, 31));
	}
	
	a4 = 'in' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 32, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_6));
	}
	
	(
		a5_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.SET__TARGET), a5_0);
					completedElement(a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 33));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN returns [org.emftext.language.refactoring.refactoring_specification.ASSIGN element = null]
@init{
}
:
	a0 = 'assign' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createASSIGN();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_31, 34));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_32, 34));
	}
	
	(
		(
			(
				a1 = DOT_NOTATION				
				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createASSIGN();
					}
					if (a1 != null) {
						org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DOT_NOTATION");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__SOURCE_ATTRIBUTE), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.language.refactoring.roles.RoleAttribute proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAttribute();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.ASSIGN, org.emftext.language.refactoring.roles.RoleAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getASSIGNSourceAttributeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__SOURCE_ATTRIBUTE), resolved, proxy);
						if (proxy != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__SOURCE_ATTRIBUTE), proxy);
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
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_33, 35));
			}
			
			a2 = 'for' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createASSIGN();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_32, 36));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_32, 37));
	}
	
	(
		a3 = DOT_NOTATION		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createASSIGN();
			}
			if (a3 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DOT_NOTATION");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__TARGET_ATTRIBUTE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.RoleAttribute proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAttribute();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.ASSIGN, org.emftext.language.refactoring.roles.RoleAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getASSIGNTargetAttributeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__TARGET_ATTRIBUTE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__TARGET_ATTRIBUTE), proxy);
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_34, 38));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 38));
	}
	
	(
		(
			a4 = 'and' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createASSIGN();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_35, 39, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_7));
			}
			
			(
				a5_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createASSIGN();
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__ADDITIONAL_COMMAND), a5_0);
							completedElement(a5_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a5_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 40));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 41));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE returns [org.emftext.language.refactoring.refactoring_specification.UPDATE element = null]
@init{
}
:
	a0 = 'update' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createUPDATE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 42));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable returns [org.emftext.language.refactoring.refactoring_specification.Variable element = null]
@init{
}
:
	(
		a0 = LOWER_IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariable();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_18, 43));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_36, 43));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference returns [org.emftext.language.refactoring.refactoring_specification.VariableReference element = null]
@init{
}
:
	(
		a0 = LOWER_IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableReference();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_22, 44));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 44));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_25, 44));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_30, 44));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_37, 44));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_38, 44));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_39, 44));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_40, 44));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment returns [org.emftext.language.refactoring.refactoring_specification.VariableAssignment element = null]
@init{
}
:
	a0 = 'object' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableAssignment();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_17, 45, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_1));
	}
	
	(
		a1_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableAssignment();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_36, 46));
	}
	
	a2 = ':=' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableAssignment();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_41, 47, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_42, 47, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_8));
	}
	
	(
		a3_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableAssignment();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT), a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 48));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference returns [org.emftext.language.refactoring.refactoring_specification.RoleReference element = null]
@init{
}
:
	(
		a0 = UPPER_IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRoleReference();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("UPPER_IDENTIFIER");
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_43, 49));
	}
	
	a1 = 'from' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRoleReference();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_44, 50, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_10));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_45, 50, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_10));
	}
	
	(
		a2_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRoleReference();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__FROM), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 51));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE returns [org.emftext.language.refactoring.refactoring_specification.TRACE element = null]
@init{
}
:
	(
		a0 = UPPER_IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("UPPER_IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__ROLE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.TRACE, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTRACERoleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__ROLE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__ROLE), proxy);
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_46, 52));
	}
	
	a1 = 'as' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_47, 53));
	}
	
	a2 = 'trace' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_48, 54));
	}
	
	a3 = '(' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 55, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_11));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_49, 55, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_11));
	}
	
	(
		a4_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__REFERENCE), a4_0);
					completedElement(a4_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a4_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_37, 56));
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 57));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference returns [org.emftext.language.refactoring.refactoring_specification.RelationReference element = null]
@init{
}
:
	(
		a0 = DOT_NOTATION		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRelationReference();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DOT_NOTATION");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.MultiplicityRelation proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleUse();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.specification.resource.mopp.RefspecContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoring_specification.RelationReference, org.emftext.language.refactoring.roles.MultiplicityRelation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationReferenceRelationReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION), proxy);
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
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_25, 58));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_30, 58));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference returns [org.emftext.language.refactoring.refactoring_specification.ConstantsReference element = null]
@init{
}
:
	(
		a0 = CONSTANTS		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createConstantsReference();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CONSTANTS");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				org.emftext.language.refactoring.refactoring_specification.Constants resolved = (org.emftext.language.refactoring.refactoring_specification.Constants)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_37, 59));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_38, 59));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_39, 59));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_40, 59));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause returns [org.emftext.language.refactoring.refactoring_specification.FromClause element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFromClause();
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FROM_CLAUSE__OPERATOR), a0_0);
					completedElement(a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_50, 60));
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFromClause();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 61, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_12));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_49, 61, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_12));
	}
	
	(
		a2_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFromClause();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FROM_CLAUSE__REFERENCE), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_38, 62));
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFromClause();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 63));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE returns [org.emftext.language.refactoring.refactoring_specification.UPTREE element = null]
@init{
}
:
	a0 = 'uptree' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createUPTREE();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_50, 64));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH returns [org.emftext.language.refactoring.refactoring_specification.PATH element = null]
@init{
}
:
	a0 = 'path' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createPATH();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_50, 65));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST returns [org.emftext.language.refactoring.refactoring_specification.FIRST element = null]
@init{
}
:
	a0 = 'index' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_51, 66, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_13));
	}
	
	(
		a1_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FIRST__VARIABLE), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_52, 67));
	}
	
	a2 = ':=' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_53, 68));
	}
	
	a3 = 'first' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_54, 69));
	}
	
	a4 = '(' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 70, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_14));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_49, 70, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_14));
	}
	
	(
		a5_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FIRST__REFERENCE), a5_0);
					completedElement(a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_39, 71));
	}
	
	a6 = ')' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 72));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST returns [org.emftext.language.refactoring.refactoring_specification.LAST element = null]
@init{
}
:
	a0 = 'index' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_51, 73, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_13));
	}
	
	(
		a1_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.LAST__VARIABLE), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_55, 74));
	}
	
	a2 = ':=' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_56, 75));
	}
	
	a3 = 'last' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_57, 76));
	}
	
	a4 = '(' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 77, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_14));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_49, 77, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_14));
	}
	
	(
		a5_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.LAST__REFERENCE), a5_0);
					completedElement(a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_40, 78));
	}
	
	a6 = ')' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 79));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex returns [org.emftext.language.refactoring.refactoring_specification.ConcreteIndex element = null]
@init{
}
:
	a0 = 'index' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createConcreteIndex();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_51, 80, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_13));
	}
	
	(
		a1_0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createConcreteIndex();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONCRETE_INDEX__VARIABLE), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_58, 81));
	}
	
	a2 = ':=' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createConcreteIndex();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_59, 82));
	}
	
	(
		a3 = INTEGER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createConcreteIndex();
			}
			if (a3 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONCRETE_INDEX__INDEX), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONCRETE_INDEX__INDEX), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 83));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable returns [org.emftext.language.refactoring.refactoring_specification.IndexVariable element = null]
@init{
}
:
	(
		a0 = LOWER_IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.specification.resource.mopp.RefspecTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createIndexVariable();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.INDEX_VARIABLE__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.INDEX_VARIABLE__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_52, 84));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_55, 84));
		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_58, 84));
	}
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction returns [org.emftext.language.refactoring.refactoring_specification.Instruction element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_refactoring_refactoring_005fspecification_SET{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex{ element = c7; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext returns [org.emftext.language.refactoring.refactoring_specification.TargetContext element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext returns [org.emftext.language.refactoring.refactoring_specification.SourceContext element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand returns [org.emftext.language.refactoring.refactoring_specification.AdditionalCommand element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand returns [org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference returns [org.emftext.language.refactoring.refactoring_specification.FromReference element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator returns [org.emftext.language.refactoring.refactoring_specification.FromOperator element = null]
:
	c0 = parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

COMMENT:
	'//'(~('\n'|'\r'|'\uffff'))* 
	{ _channel = 99; }
;
ML_COMMENT:
	'/*'.*'*/'	{ _channel = 99; }
;
WHITESPACE:
	(' '|'\t'|'\f')
	{ _channel = 99; }
;
LINEBREAKS:
	('\r\n'|'\r'|'\n')
	{ _channel = 99; }
;
INTEGER:
	('1'..'9')('0'..'9')*|'0';
FLOAT:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ 	{ _channel = 99; }
;
CONSTANTS:
	'INPUT';
UPPER_IDENTIFIER:
	('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
LOWER_IDENTIFIER:
	('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
DOT_NOTATION:
	(('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*|('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*)'.'('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
QUOTED_60_62:
	('<')(~('>'))*('>')
;

