grammar Rolestext;

options {
	superClass = RolestextANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.refactoring.roles.resource.rolestext.mopp;
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
	package org.emftext.language.refactoring.roles.resource.rolestext.mopp;
}

@members{
	private org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolverFactory tokenResolverFactory = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTokenResolverFactory();
	@SuppressWarnings("unused")
	
	private int lastPosition;
	private org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTokenResolveResult tokenResolveResult = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTokenResolveResult();
	private boolean rememberExpectedElements = false;
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	private java.util.List<org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal>();
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	//helper lists to allow a lexer to pass errors to its parser
	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private java.util.Collection<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>> postParseCommands;
	private boolean terminateParsing;
	private int tokenIndexOfLastCompleteElement;
	private int expectedElementsIndexOfLastCompleteElement;
	
	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>() {
			public boolean execute(org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for
					// code completion
					return true;
				}
				resource.addProblem(new org.emftext.language.refactoring.roles.resource.rolestext.IRolestextProblem() {
					public org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemType getType() {
						return org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemType.ERROR;
					}
					public java.lang.String getMessage() {
						return errorMessage;
					}
				}, line, charPositionInLine, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal expectedElement) {
		if (!this.rememberExpectedElements) {
			return;
		}
		setPosition(expectedElement, input.index());
		this.expectedElements.add(expectedElement);
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextDummyEObject dummy) {
		java.lang.Object value = element.eGet(structuralFeature);
		java.lang.Object mapKey = dummy.getValueByName("key");
		java.lang.Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextMapUtil.castToEMap(value);
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
			assert(object instanceof org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextDummyEObject);
			org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextDummyEObject dummy = (org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextDummyEObject) object;
			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
		int currentPos = getTokenStream().index();
		if (currentPos == 0) {
			return;
		}
		int endPos = currentPos - 1;
		for (; endPos >= this.lastPosition; endPos--) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(endPos);
			int _channel = token.getChannel();
			if (_channel != 99) {
				break;
			}
		}
		for (int pos = this.lastPosition; pos < endPos; pos++) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(pos);
			int _channel = token.getChannel();
			if (_channel == 99) {
				if (token.getType() == RolestextLexer.SL_COMMENT) {
					org.eclipse.emf.ecore.EStructuralFeature feature = element.eClass().getEStructuralFeature("comments");
					if (feature != null) {
						// call token resolver
						org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolvedResolver = tokenResolverFactory.createCollectInTokenResolver("comments");
						resolvedResolver.setOptions(getOptions());
						org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult resolvedResult = getFreshTokenResolveResult();
						resolvedResolver.resolve(token.getText(), feature, resolvedResult);
						java.lang.Object resolvedObject = resolvedResult.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(resolvedResult.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) token).getLine(), ((org.antlr.runtime3_2_0.CommonToken) token).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) token).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) token).getStopIndex());
						}
						if (java.lang.String.class.isInstance(resolvedObject)) {
							((java.util.List) element.eGet(feature)).add((java.lang.String) resolvedObject);
						} else {
							System.out.println("WARNING: Attribute comments for token " + token + " has wrong type in element " + element + " (expected java.lang.String).");
						}
					} else {
						System.out.println("WARNING: Attribute comments for token " + token + " was not found in element " + element + ".");
					}
				}
				if (token.getType() == RolestextLexer.ML_COMMENT) {
					org.eclipse.emf.ecore.EStructuralFeature feature = element.eClass().getEStructuralFeature("comments");
					if (feature != null) {
						// call token resolver
						org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolvedResolver = tokenResolverFactory.createCollectInTokenResolver("comments");
						resolvedResolver.setOptions(getOptions());
						org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult resolvedResult = getFreshTokenResolveResult();
						resolvedResolver.resolve(token.getText(), feature, resolvedResult);
						java.lang.Object resolvedObject = resolvedResult.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(resolvedResult.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) token).getLine(), ((org.antlr.runtime3_2_0.CommonToken) token).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) token).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) token).getStopIndex());
						}
						if (java.lang.String.class.isInstance(resolvedObject)) {
							((java.util.List) element.eGet(feature)).add((java.lang.String) resolvedObject);
						} else {
							System.out.println("WARNING: Attribute comments for token " + token + " has wrong type in element " + element + " (expected java.lang.String).");
						}
					} else {
						System.out.println("WARNING: Attribute comments for token " + token + " was not found in element " + element + ".");
					}
				}
			}
		}
		this.lastPosition = (endPos < 0 ? 0 : endPos);
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>() {
			public boolean execute(org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource resource) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>() {
			public boolean execute(org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource resource) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextLocationMap locationMap = resource.getLocationMap();
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
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
		try {
			if (encoding == null) {
				return new RolestextParser(new org.antlr.runtime3_2_0.CommonTokenStream(new RolestextLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new RolestextParser(new org.antlr.runtime3_2_0.CommonTokenStream(new RolestextLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextPlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	// This default constructor is only used to call createInstance() on it
	public RolestextParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((RolestextLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((RolestextLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		java.lang.Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.language.refactoring.roles.RoleModel.class) {
				return parse_org_emftext_language_refactoring_roles_RoleModel();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.roles.Role.class) {
				return parse_org_emftext_language_refactoring_roles_Role();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.roles.RoleProhibition.class) {
				return parse_org_emftext_language_refactoring_roles_RoleProhibition();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.roles.RoleImplication.class) {
				return parse_org_emftext_language_refactoring_roles_RoleImplication();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.roles.RoleAssociation.class) {
				return parse_org_emftext_language_refactoring_roles_RoleAssociation();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.roles.RoleComposition.class) {
				return parse_org_emftext_language_refactoring_roles_RoleComposition();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.roles.Multiplicity.class) {
				return parse_org_emftext_language_refactoring_roles_Multiplicity();
			}
		}
		throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextUnexpectedContentTypeException(typeObject);
	}
	
	private org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTokenResolveResult getFreshTokenResolveResult() {
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
	
	public org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation getMetaInformation() {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation();
	}
	
	public java.lang.Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected java.lang.Object getTypeObject() {
		java.lang.Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.language.refactoring.roles.resource.rolestext.IRolestextOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	// Implementation that calls {@link #doParse()}  and handles the thrown
	// RecognitionExceptions.
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>>();
		org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextParseResult parseResult = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextParseResult();
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
	
	public java.util.List<org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource dummyResource) {
		rememberExpectedElements = true;
		parseToIndexTypeObject = type;
		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
		org.emftext.language.refactoring.roles.resource.rolestext.IRolestextParseResult result = parse();
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContents().add(root);
			}
			for (org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal>();
		java.util.List<org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				System.out.println("FOLLOW ELEMENT " + expectedElementI);
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 82;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
			System.out.println("REMAINING TOKEN: " + nextToken);
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected terminals
				// can be set
				for (org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are kept
				for (org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal nextFollow : currentFollowSet) {
					System.out.println("CHECKING : " + nextFollow);
					if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						System.out.println("MATCH! " + nextFollow);
						java.util.Collection<org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextPair<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextPair<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
							org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement newFollower = newFollowerPair.getLeft();
							org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal newFollowTerminal = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
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
		for (org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal expectedElement, int tokenIndex) {
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
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
		postParseCommands.add(new org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>() {
			public boolean execute(org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource resource) {
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
				tokenName = org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextStringUtil.formatTokenName(tokenName);
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
	
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_0 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleModel(), "RoleModel");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_1 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleModel(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleModel().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__NAME), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_2 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleModel(), "{");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_3 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), "role");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_4 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__SOURCE), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_5 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__SOURCE), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_6 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_7 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_8 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleModel(), "}");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_9 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__NAME), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_10 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), "(");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_11 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), ";");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_12 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__OPTIONAL), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_13 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), ",");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_14 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INPUT), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_15 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), ",");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_16 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__SELECT_ON_RUNTIME), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_17 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), ")");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_18 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), "|-|");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_19 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TARGET), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_20 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), "(");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_21 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), ";");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_22 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TRANSITIVE), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_23 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), ",");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_24 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__REFLEXIVE), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_25 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), ")");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_26 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), "->");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_27 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TARGET), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_28 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), "(");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_29 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), ";");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_30 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TRANSITIVE), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_31 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), ",");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_32 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__REFLEXIVE), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_33 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), ")");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_34 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_NAME), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_35 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), "[");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_36 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), "--");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_37 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_38 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_NAME), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_39 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), "(");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_40 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), ";");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_41 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TRANSITIVE), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_42 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), ",");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_43 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__REFLEXIVE), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_44 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), ")");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_45 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_NAME), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_46 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), "<>-");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_47 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_48 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_NAME), "IDENTIFIER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_49 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), "(");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_50 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), ";");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_51 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TRANSITIVE), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_52 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), ",");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_53 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__REFLEXIVE), "BOOLEAN_LITERAL");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_54 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), ")");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_55 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__LOWER_BOUND), "NUMBER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_56 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), "..");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_57 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__UPPER_BOUND), "NUMBER");
	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_58 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), "]");
	
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_0 = org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleModel().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__ROLES);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_1 = org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleModel().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__RELATIONS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_2 = org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicityRelation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_3 = org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicityRelation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY);
	
	private final static org.eclipse.emf.ecore.EStructuralFeature[] EMPTY_FEATURE_ARRAY = new org.eclipse.emf.ecore.EStructuralFeature[0];
	
	public static void wire0() {
		TERMINAL_0.addFollower(TERMINAL_1, EMPTY_FEATURE_ARRAY);
		TERMINAL_1.addFollower(TERMINAL_2, EMPTY_FEATURE_ARRAY);
		TERMINAL_2.addFollower(TERMINAL_3, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_2.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_2.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_2.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_2.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_2.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
		TERMINAL_3.addFollower(TERMINAL_9, EMPTY_FEATURE_ARRAY);
		TERMINAL_9.addFollower(TERMINAL_10, EMPTY_FEATURE_ARRAY);
		TERMINAL_9.addFollower(TERMINAL_11, EMPTY_FEATURE_ARRAY);
		TERMINAL_10.addFollower(TERMINAL_12, EMPTY_FEATURE_ARRAY);
		TERMINAL_10.addFollower(TERMINAL_13, EMPTY_FEATURE_ARRAY);
		TERMINAL_12.addFollower(TERMINAL_13, EMPTY_FEATURE_ARRAY);
		TERMINAL_13.addFollower(TERMINAL_14, EMPTY_FEATURE_ARRAY);
		TERMINAL_13.addFollower(TERMINAL_15, EMPTY_FEATURE_ARRAY);
		TERMINAL_14.addFollower(TERMINAL_15, EMPTY_FEATURE_ARRAY);
		TERMINAL_15.addFollower(TERMINAL_16, EMPTY_FEATURE_ARRAY);
		TERMINAL_15.addFollower(TERMINAL_17, EMPTY_FEATURE_ARRAY);
		TERMINAL_16.addFollower(TERMINAL_17, EMPTY_FEATURE_ARRAY);
		TERMINAL_17.addFollower(TERMINAL_11, EMPTY_FEATURE_ARRAY);
		TERMINAL_11.addFollower(TERMINAL_3, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_11.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_11.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_11.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_11.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_11.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
		TERMINAL_4.addFollower(TERMINAL_18, EMPTY_FEATURE_ARRAY);
		TERMINAL_18.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_19.addFollower(TERMINAL_20, EMPTY_FEATURE_ARRAY);
		TERMINAL_19.addFollower(TERMINAL_21, EMPTY_FEATURE_ARRAY);
		TERMINAL_20.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_20.addFollower(TERMINAL_23, EMPTY_FEATURE_ARRAY);
		TERMINAL_22.addFollower(TERMINAL_23, EMPTY_FEATURE_ARRAY);
		TERMINAL_23.addFollower(TERMINAL_24, EMPTY_FEATURE_ARRAY);
		TERMINAL_23.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_24.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_25.addFollower(TERMINAL_21, EMPTY_FEATURE_ARRAY);
		TERMINAL_21.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_21.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_21.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_21.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_21.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_26, EMPTY_FEATURE_ARRAY);
		TERMINAL_26.addFollower(TERMINAL_27, EMPTY_FEATURE_ARRAY);
		TERMINAL_27.addFollower(TERMINAL_28, EMPTY_FEATURE_ARRAY);
		TERMINAL_27.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_28.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_28.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_30.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_31.addFollower(TERMINAL_32, EMPTY_FEATURE_ARRAY);
		TERMINAL_31.addFollower(TERMINAL_33, EMPTY_FEATURE_ARRAY);
		TERMINAL_32.addFollower(TERMINAL_33, EMPTY_FEATURE_ARRAY);
		TERMINAL_33.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_29.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_29.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_29.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_29.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_29.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
		TERMINAL_6.addFollower(TERMINAL_34, EMPTY_FEATURE_ARRAY);
		TERMINAL_6.addFollower(TERMINAL_35, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_34.addFollower(TERMINAL_35, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_36.addFollower(TERMINAL_37, EMPTY_FEATURE_ARRAY);
		TERMINAL_37.addFollower(TERMINAL_38, EMPTY_FEATURE_ARRAY);
		TERMINAL_37.addFollower(TERMINAL_35, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
		TERMINAL_38.addFollower(TERMINAL_35, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
		TERMINAL_39.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
		TERMINAL_39.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
		TERMINAL_41.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
		TERMINAL_42.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
		TERMINAL_42.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_43.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_44.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
		TERMINAL_40.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_40.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_40.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_40.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_40.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
		TERMINAL_7.addFollower(TERMINAL_45, EMPTY_FEATURE_ARRAY);
		TERMINAL_7.addFollower(TERMINAL_35, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_45.addFollower(TERMINAL_35, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_46.addFollower(TERMINAL_47, EMPTY_FEATURE_ARRAY);
		TERMINAL_47.addFollower(TERMINAL_48, EMPTY_FEATURE_ARRAY);
		TERMINAL_47.addFollower(TERMINAL_35, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
		TERMINAL_48.addFollower(TERMINAL_35, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
		TERMINAL_49.addFollower(TERMINAL_51, EMPTY_FEATURE_ARRAY);
		TERMINAL_49.addFollower(TERMINAL_52, EMPTY_FEATURE_ARRAY);
		TERMINAL_51.addFollower(TERMINAL_52, EMPTY_FEATURE_ARRAY);
		TERMINAL_52.addFollower(TERMINAL_53, EMPTY_FEATURE_ARRAY);
		TERMINAL_52.addFollower(TERMINAL_54, EMPTY_FEATURE_ARRAY);
		TERMINAL_53.addFollower(TERMINAL_54, EMPTY_FEATURE_ARRAY);
		TERMINAL_54.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
		TERMINAL_50.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_50.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_50.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_50.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_50.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
		TERMINAL_35.addFollower(TERMINAL_55, EMPTY_FEATURE_ARRAY);
		TERMINAL_55.addFollower(TERMINAL_56, EMPTY_FEATURE_ARRAY);
		TERMINAL_56.addFollower(TERMINAL_57, EMPTY_FEATURE_ARRAY);
		TERMINAL_57.addFollower(TERMINAL_58, EMPTY_FEATURE_ARRAY);
		TERMINAL_58.addFollower(TERMINAL_36, EMPTY_FEATURE_ARRAY);
		TERMINAL_58.addFollower(TERMINAL_46, EMPTY_FEATURE_ARRAY);
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
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_0, 0));
		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
	}
	(
		c0 = parse_org_emftext_language_refactoring_roles_RoleModel{ element = c0; }
	)
	EOF	
;

parse_org_emftext_language_refactoring_roles_RoleModel returns [org.emftext.language.refactoring.roles.RoleModel element = null]
@init{
}
:
	a0 = 'RoleModel' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_1, 1));
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
			}
			if (a1 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_2, 2));
	}
	
	a2 = '{' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_3, 3, FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 3, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 3, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 3, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 3, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 3));
	}
	
	(
		(
			a3_0 = parse_org_emftext_language_refactoring_roles_Role			{
				if (terminateParsing) {
					throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
				}
				if (a3_0 != null) {
					if (a3_0 != null) {
						addObjectToList(element, org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__ROLES, a3_0);
						completedElement(a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_3, 4, FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 4, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 4, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 4, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 4, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 4));
	}
	
	(
		(
			a4_0 = parse_org_emftext_language_refactoring_roles_Relation			{
				if (terminateParsing) {
					throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
				}
				if (a4_0 != null) {
					if (a4_0 != null) {
						addObjectToList(element, org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__RELATIONS, a4_0);
						completedElement(a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 5, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 5, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 5, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 5, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 5));
	}
	
	a5 = '}' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_org_emftext_language_refactoring_roles_Role returns [org.emftext.language.refactoring.roles.Role element = null]
@init{
}
:
	a0 = 'role' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_9, 7));
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
			}
			if (a1 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_10, 8));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_11, 8));
	}
	
	(
		(
			a2 = '(' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_12, 9));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_13, 9));
			}
			
			(
				(
					(
						a3 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
							}
							if (a3 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__OPTIONAL), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__OPTIONAL), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_13, 10));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_13, 11));
			}
			
			a4 = ',' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_14, 12));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 12));
			}
			
			(
				(
					(
						a5 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
							}
							if (a5 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INPUT), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INPUT), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 13));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 14));
			}
			
			a6 = ',' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_16, 15));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_17, 15));
			}
			
			(
				(
					(
						a7 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
							}
							if (a7 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__SELECT_ON_RUNTIME), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a7).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__SELECT_ON_RUNTIME), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a7, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_17, 16));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_17, 17));
			}
			
			a8 = ')' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_11, 18));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_11, 19));
	}
	
	a9 = ';' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_3, 20, FEATURE_0));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 20, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 20, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 20, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 20, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 20));
	}
	
;

parse_org_emftext_language_refactoring_roles_RoleProhibition returns [org.emftext.language.refactoring.roles.RoleProhibition element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__SOURCE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragmentFactory<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__SOURCE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__SOURCE), proxy);
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
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_18, 21));
	}
	
	a1 = '|-|' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_19, 22));
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
			}
			if (a2 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TARGET), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragmentFactory<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TARGET), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TARGET), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_20, 23));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_21, 23));
	}
	
	(
		(
			a3 = '(' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_22, 24));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_23, 24));
			}
			
			(
				(
					(
						a4 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
							}
							if (a4 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TRANSITIVE), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TRANSITIVE), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_23, 25));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_23, 26));
			}
			
			a5 = ',' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_24, 27));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_25, 27));
			}
			
			(
				(
					(
						a6 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
							}
							if (a6 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__REFLEXIVE), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__REFLEXIVE), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_25, 28));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_25, 29));
			}
			
			a7 = ')' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_21, 30));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_21, 31));
	}
	
	a8 = ';' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 32, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 32, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 32, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 32, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 32));
	}
	
;

parse_org_emftext_language_refactoring_roles_RoleImplication returns [org.emftext.language.refactoring.roles.RoleImplication element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__SOURCE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragmentFactory<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__SOURCE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__SOURCE), proxy);
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
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_26, 33));
	}
	
	a1 = '->' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_27, 34));
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
			}
			if (a2 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TARGET), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragmentFactory<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TARGET), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TARGET), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_28, 35));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 35));
	}
	
	(
		(
			a3 = '(' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_30, 36));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 36));
			}
			
			(
				(
					(
						a4 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
							}
							if (a4 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TRANSITIVE), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TRANSITIVE), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 37));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 38));
			}
			
			a5 = ',' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_32, 39));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_33, 39));
			}
			
			(
				(
					(
						a6 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
							}
							if (a6 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__REFLEXIVE), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__REFLEXIVE), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_33, 40));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_33, 41));
			}
			
			a7 = ')' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 42));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 43));
	}
	
	a8 = ';' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 44, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 44, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 44, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 44, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 44));
	}
	
;

parse_org_emftext_language_refactoring_roles_RoleAssociation returns [org.emftext.language.refactoring.roles.RoleAssociation element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragmentFactory<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE), proxy);
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
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_34, 45));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 45, FEATURE_2));
	}
	
	(
		(
			a1 = IDENTIFIER			
			{
				if (terminateParsing) {
					throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
				}
				if (a1 != null) {
					org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_NAME), result);
					java.lang.Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_NAME), resolved);
						completedElement(resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 46, FEATURE_2));
	}
	
	(
		a2_0 = parse_org_emftext_language_refactoring_roles_Multiplicity		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_MULTIPLICITY), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_36, 47));
	}
	
	a3 = '--' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_37, 48));
	}
	
	(
		a4 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
			}
			if (a4 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragmentFactory<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET), proxy);
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
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_38, 49));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 49, FEATURE_3));
	}
	
	(
		(
			a5 = IDENTIFIER			
			{
				if (terminateParsing) {
					throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
				}
				if (a5 != null) {
					org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_NAME), result);
					java.lang.Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_NAME), resolved);
						completedElement(resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 50, FEATURE_3));
	}
	
	(
		a6_0 = parse_org_emftext_language_refactoring_roles_Multiplicity		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
			}
			if (a6_0 != null) {
				if (a6_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_MULTIPLICITY), a6_0);
					completedElement(a6_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a6_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_39, 51));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_40, 51));
	}
	
	(
		(
			a7 = '(' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_41, 52));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_42, 52));
			}
			
			(
				(
					(
						a8 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
							}
							if (a8 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TRANSITIVE), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TRANSITIVE), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_42, 53));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_42, 54));
			}
			
			a9 = ',' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_43, 55));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_44, 55));
			}
			
			(
				(
					(
						a10 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
							}
							if (a10 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__REFLEXIVE), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__REFLEXIVE), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_44, 56));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_44, 57));
			}
			
			a11 = ')' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_40, 58));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_40, 59));
	}
	
	a12 = ';' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 60, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 60, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 60, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 60, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 60));
	}
	
;

parse_org_emftext_language_refactoring_roles_RoleComposition returns [org.emftext.language.refactoring.roles.RoleComposition element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
			}
			if (a0 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragmentFactory<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE), proxy);
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
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_45, 61));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 61, FEATURE_2));
	}
	
	(
		(
			a1 = IDENTIFIER			
			{
				if (terminateParsing) {
					throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
				}
				if (a1 != null) {
					org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_NAME), result);
					java.lang.Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_NAME), resolved);
						completedElement(resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 62, FEATURE_2));
	}
	
	(
		a2_0 = parse_org_emftext_language_refactoring_roles_Multiplicity		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_MULTIPLICITY), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_46, 63));
	}
	
	a3 = '<>-' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_47, 64));
	}
	
	(
		a4 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
			}
			if (a4 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragmentFactory<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET), proxy);
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
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_48, 65));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 65, FEATURE_3));
	}
	
	(
		(
			a5 = IDENTIFIER			
			{
				if (terminateParsing) {
					throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
				}
				if (a5 != null) {
					org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_NAME), result);
					java.lang.Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_NAME), resolved);
						completedElement(resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 66, FEATURE_3));
	}
	
	(
		a6_0 = parse_org_emftext_language_refactoring_roles_Multiplicity		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
			}
			if (a6_0 != null) {
				if (a6_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_MULTIPLICITY), a6_0);
					completedElement(a6_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a6_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_49, 67));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_50, 67));
	}
	
	(
		(
			a7 = '(' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_51, 68));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_52, 68));
			}
			
			(
				(
					(
						a8 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
							}
							if (a8 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TRANSITIVE), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TRANSITIVE), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_52, 69));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_52, 70));
			}
			
			a9 = ',' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_53, 71));
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_54, 71));
			}
			
			(
				(
					(
						a10 = BOOLEAN_LITERAL						
						{
							if (terminateParsing) {
								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
							}
							if (a10 != null) {
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__REFLEXIVE), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStopIndex());
								}
								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__REFLEXIVE), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_54, 72));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_54, 73));
			}
			
			a11 = ')' {
				if (element == null) {
					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_50, 74));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_50, 75));
	}
	
	a12 = ';' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 76, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 76, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 76, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 76, FEATURE_1));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 76));
	}
	
;

parse_org_emftext_language_refactoring_roles_Multiplicity returns [org.emftext.language.refactoring.roles.Multiplicity element = null]
@init{
}
:
	a0 = '[' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_55, 77));
	}
	
	(
		a1 = NUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
			}
			if (a1 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__LOWER_BOUND), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__LOWER_BOUND), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_56, 78));
	}
	
	a2 = '..' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_57, 79));
	}
	
	(
		a3 = NUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
			}
			if (a3 != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__UPPER_BOUND), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__UPPER_BOUND), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_58, 80));
	}
	
	a4 = ']' {
		if (element == null) {
			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_36, 81));
		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_46, 81));
	}
	
;

parse_org_emftext_language_refactoring_roles_Relation returns [org.emftext.language.refactoring.roles.Relation element = null]
:
	c0 = parse_org_emftext_language_refactoring_roles_RoleProhibition{ element = c0; /* this is a subclass choice */ }
	|	c1 = parse_org_emftext_language_refactoring_roles_RoleImplication{ element = c1; /* this is a subclass choice */ }
	|	c2 = parse_org_emftext_language_refactoring_roles_RoleAssociation{ element = c2; /* this is a subclass choice */ }
	|	c3 = parse_org_emftext_language_refactoring_roles_RoleComposition{ element = c3; /* this is a subclass choice */ }
	
;

SL_COMMENT:
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
BOOLEAN_LITERAL:
	'true'|'false';
IDENTIFIER:
	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NUMBER:
	('0')|('-1')|(('1'..'9')('0'..'9')*)
;

