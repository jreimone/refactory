// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.refactoring.specification.resource.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
public class RefspecParser extends RefspecANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "QUOTED_60_62", "COMMENT", "INTEGER", "FLOAT", "WHITESPACE", "LINEBREAK", "'REFACTORING'", "'FOR'", "'STEPS'", "'{'", "';'", "'}'", "'create'", "'new'", "'('", "'->'", "')'", "'in'", "'move'", "'to'", "'.'"
    };
    public static final int INTEGER=7;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int WHITESPACE=9;
    public static final int FLOAT=8;
    public static final int TEXT=4;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int QUOTED_60_62=5;
    public static final int COMMENT=6;
    public static final int LINEBREAK=10;

    // delegates
    // delegators


        public RefspecParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RefspecParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[17+1];
             
             
        }
        

    public String[] getTokenNames() { return RefspecParser.tokenNames; }
    public String getGrammarFileName() { return "Refspec.g"; }


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



    // $ANTLR start "start"
    // Refspec.g:539:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Refspec.g:540:1: ( (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification ) EOF )
            // Refspec.g:541:2: (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_0, 0));
              		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
              	
            }
            // Refspec.g:546:2: (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification )
            // Refspec.g:547:3: c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification_in_start82);
            c0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "start"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification"
    // Refspec.g:552:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification returns [org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification element = null] : a0= 'REFACTORING' (a1= TEXT ) a2= 'FOR' (a3= QUOTED_60_62 ) a4= 'STEPS' a5= '{' ( ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction ) a7= ';' ) )+ a8= '}' ;
    public final org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a7=null;
        Token a8=null;
        org.emftext.language.refactoring.refactoring_specification.Instruction a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // Refspec.g:555:1: (a0= 'REFACTORING' (a1= TEXT ) a2= 'FOR' (a3= QUOTED_60_62 ) a4= 'STEPS' a5= '{' ( ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction ) a7= ';' ) )+ a8= '}' )
            // Refspec.g:556:2: a0= 'REFACTORING' (a1= TEXT ) a2= 'FOR' (a3= QUOTED_60_62 ) a4= 'STEPS' a5= '{' ( ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction ) a7= ';' ) )+ a8= '}'
            {
            a0=(Token)match(input,11,FOLLOW_11_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification112); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_1, 1));
              	
            }
            // Refspec.g:568:2: (a1= TEXT )
            // Refspec.g:569:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification130); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_2, 2));
              	
            }
            a2=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification151); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_3, 3));
              	
            }
            // Refspec.g:613:2: (a3= QUOTED_60_62 )
            // Refspec.g:614:3: a3= QUOTED_60_62
            {
            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification169); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_4, 4));
              	
            }
            a4=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification190); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_5, 5));
              	
            }
            a5=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification204); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_6, 6, FEATURE_0));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_7, 6, FEATURE_0));
              	
            }
            // Refspec.g:675:2: ( ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction ) a7= ';' ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17||LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Refspec.g:676:3: ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction ) a7= ';' )
            	    {
            	    // Refspec.g:676:3: ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction ) a7= ';' )
            	    // Refspec.g:677:4: (a6_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction ) a7= ';'
            	    {
            	    // Refspec.g:677:4: (a6_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction )
            	    // Refspec.g:678:5: a6_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification233);
            	    a6_0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_8, 7));
            	      			
            	    }
            	    a7=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification261); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_6, 8, FEATURE_0));
            	      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_7, 8, FEATURE_0));
            	      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_9, 8));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_6, 9, FEATURE_0));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_7, 9, FEATURE_0));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_9, 9));
              	
            }
            a8=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification294); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE"
    // Refspec.g:735:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE returns [org.emftext.language.refactoring.refactoring_specification.CREATE element = null] : a0= 'create' a1= 'new' (a2_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference ) ( (a3= '(' a4= '->' (a5_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable ) a6= ')' ) )? a7= 'in' (a8_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext ) ;
    public final org.emftext.language.refactoring.refactoring_specification.CREATE parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.CREATE element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        org.emftext.language.refactoring.refactoring_specification.RoleReference a2_0 = null;

        org.emftext.language.refactoring.refactoring_specification.Variable a5_0 = null;

        org.emftext.language.refactoring.refactoring_specification.TargetContext a8_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Refspec.g:738:1: (a0= 'create' a1= 'new' (a2_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference ) ( (a3= '(' a4= '->' (a5_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable ) a6= ')' ) )? a7= 'in' (a8_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext ) )
            // Refspec.g:739:2: a0= 'create' a1= 'new' (a2_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference ) ( (a3= '(' a4= '->' (a5_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable ) a6= ')' ) )? a7= 'in' (a8_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext )
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE323); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_10, 11));
              	
            }
            a1=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE337); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_11, 12, FEATURE_1));
              	
            }
            // Refspec.g:763:2: (a2_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference )
            // Refspec.g:764:3: a2_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE355);
            a2_0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_12, 13));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_13, 13));
              	
            }
            // Refspec.g:786:2: ( (a3= '(' a4= '->' (a5_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable ) a6= ')' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==19) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Refspec.g:787:3: (a3= '(' a4= '->' (a5_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable ) a6= ')' )
                    {
                    // Refspec.g:787:3: (a3= '(' a4= '->' (a5_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable ) a6= ')' )
                    // Refspec.g:788:4: a3= '(' a4= '->' (a5_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable ) a6= ')'
                    {
                    a3=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE382); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_14, 14));
                      			
                    }
                    a4=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE402); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_15, 15, FEATURE_2));
                      			
                    }
                    // Refspec.g:812:4: (a5_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable )
                    // Refspec.g:813:5: a5_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE428);
                    a5_0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_16, 16));
                      			
                    }
                    a6=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE456); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_13, 17));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_13, 18));
              	
            }
            a7=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE489); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_17, 19, FEATURE_3));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_11, 19, FEATURE_3));
              	
            }
            // Refspec.g:866:2: (a8_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext )
            // Refspec.g:867:3: a8_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE507);
            a8_0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_8, 20));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE"
    // Refspec.g:890:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE returns [org.emftext.language.refactoring.refactoring_specification.MOVE element = null] : a0= 'move' (a1_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext ) a2= 'to' (a3_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext ) ;
    public final org.emftext.language.refactoring.refactoring_specification.MOVE parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.MOVE element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.language.refactoring.refactoring_specification.SourceContext a1_0 = null;

        org.emftext.language.refactoring.refactoring_specification.TargetContext a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Refspec.g:893:1: (a0= 'move' (a1_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext ) a2= 'to' (a3_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext ) )
            // Refspec.g:894:2: a0= 'move' (a1_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext ) a2= 'to' (a3_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext )
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE540); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_17, 21, FEATURE_4));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_11, 21, FEATURE_4));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_18, 21, FEATURE_4));
              	
            }
            // Refspec.g:908:2: (a1_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext )
            // Refspec.g:909:3: a1_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE558);
            a1_0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_19, 22));
              	
            }
            a2=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE576); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_17, 23, FEATURE_5));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_11, 23, FEATURE_5));
              	
            }
            // Refspec.g:943:2: (a3_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext )
            // Refspec.g:944:3: a3_0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE594);
            a3_0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_8, 24));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable"
    // Refspec.g:967:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable returns [org.emftext.language.refactoring.refactoring_specification.Variable element = null] : (a0= TEXT ) ;
    public final org.emftext.language.refactoring.refactoring_specification.Variable parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.Variable element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Refspec.g:970:1: ( (a0= TEXT ) )
            // Refspec.g:971:2: (a0= TEXT )
            {
            // Refspec.g:971:2: (a0= TEXT )
            // Refspec.g:972:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable631); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_16, 25));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference"
    // Refspec.g:1006:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference returns [org.emftext.language.refactoring.refactoring_specification.VariableReference element = null] : a0= '->' (a1= TEXT ) ;
    public final org.emftext.language.refactoring.refactoring_specification.VariableReference parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.VariableReference element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Refspec.g:1009:1: (a0= '->' (a1= TEXT ) )
            // Refspec.g:1010:2: a0= '->' (a1= TEXT )
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference667); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableReference();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_20, 26));
              	
            }
            // Refspec.g:1022:2: (a1= TEXT )
            // Refspec.g:1023:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference685); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_8, 27));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_19, 27));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference"
    // Refspec.g:1062:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference returns [org.emftext.language.refactoring.refactoring_specification.RoleReference element = null] : (a0= TEXT ) ;
    public final org.emftext.language.refactoring.refactoring_specification.RoleReference parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.RoleReference element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Refspec.g:1065:1: ( (a0= TEXT ) )
            // Refspec.g:1066:2: (a0= TEXT )
            {
            // Refspec.g:1066:2: (a0= TEXT )
            // Refspec.g:1067:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference725); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_12, 28));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_13, 28));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_19, 28));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference"
    // Refspec.g:1107:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference returns [org.emftext.language.refactoring.refactoring_specification.RelationReference element = null] : a0= '.' (a1= TEXT ) ;
    public final org.emftext.language.refactoring.refactoring_specification.RelationReference parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.RelationReference element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Refspec.g:1110:1: (a0= '.' (a1= TEXT ) )
            // Refspec.g:1111:2: a0= '.' (a1= TEXT )
            {
            a0=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference761); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRelationReference();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_21, 29));
              	
            }
            // Refspec.g:1123:2: (a1= TEXT )
            // Refspec.g:1124:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference779); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(TERMINAL_19, 30));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction"
    // Refspec.g:1162:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction returns [org.emftext.language.refactoring.refactoring_specification.Instruction element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE | c1= parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE );
    public final org.emftext.language.refactoring.refactoring_specification.Instruction parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.Instruction element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.CREATE c0 = null;

        org.emftext.language.refactoring.refactoring_specification.MOVE c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Refspec.g:1163:1: (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE | c1= parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            else if ( (LA3_0==23) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // Refspec.g:1164:2: c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction811);
                    c0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Refspec.g:1165:4: c1= parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction821);
                    c1=parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext"
    // Refspec.g:1169:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext returns [org.emftext.language.refactoring.refactoring_specification.TargetContext element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference | c1= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference );
    public final org.emftext.language.refactoring.refactoring_specification.TargetContext parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.TargetContext element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.VariableReference c0 = null;

        org.emftext.language.refactoring.refactoring_specification.RoleReference c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // Refspec.g:1170:1: (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference | c1= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            else if ( (LA4_0==TEXT) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // Refspec.g:1171:2: c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext842);
                    c0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Refspec.g:1172:4: c1= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext852);
                    c1=parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext"
    // Refspec.g:1176:1: parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext returns [org.emftext.language.refactoring.refactoring_specification.SourceContext element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference | c1= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference | c2= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference );
    public final org.emftext.language.refactoring.refactoring_specification.SourceContext parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.SourceContext element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.VariableReference c0 = null;

        org.emftext.language.refactoring.refactoring_specification.RoleReference c1 = null;

        org.emftext.language.refactoring.refactoring_specification.RelationReference c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // Refspec.g:1177:1: (c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference | c1= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference | c2= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt5=1;
                }
                break;
            case TEXT:
                {
                alt5=2;
                }
                break;
            case 25:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // Refspec.g:1178:2: c0= parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext873);
                    c0=parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Refspec.g:1179:4: c1= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext883);
                    c1=parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Refspec.g:1180:4: c2= parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext893);
                    c2=parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification130 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification151 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification169 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification190 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification204 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification233 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification261 = new BitSet(new long[]{0x0000000000830000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE323 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE337 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE355 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE382 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE402 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE428 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE456 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE489 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE540 = new BitSet(new long[]{0x0000000002100010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE558 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE576 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Variable631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference667 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference761 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference_in_parse_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext893 = new BitSet(new long[]{0x0000000000000002L});

}