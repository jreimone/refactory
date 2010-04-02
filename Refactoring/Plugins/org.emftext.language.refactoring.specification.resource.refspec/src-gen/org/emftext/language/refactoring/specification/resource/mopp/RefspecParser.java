// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.refactoring.specification.resource.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
public class RefspecParser extends RefspecANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "UPPER_IDENTIFIER", "QUOTED_60_62", "LOWER_IDENTIFIER", "DOT_NOTATION", "CONSTANTS", "INTEGER", "COMMENT", "ML_COMMENT", "WHITESPACE", "LINEBREAKS", "FLOAT", "'REFACTORING'", "'FOR'", "'STEPS'", "'{'", "';'", "'}'", "'create'", "'new'", "':'", "'in'", "'at'", "'move'", "'to'", "'set'", "'use'", "'of'", "'assign'", "'for'", "'and'", "'update'", "'object'", "':='", "'from'", "'as'", "'trace'", "'('", "')'", "'uptree'", "'path'", "'index'", "'first'", "'last'"
    };
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int FLOAT=14;
    public static final int T__21=21;
    public static final int UPPER_IDENTIFIER=4;
    public static final int T__19=19;
    public static final int T__39=39;
    public static final int INTEGER=9;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int T__17=17;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int ML_COMMENT=11;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int DOT_NOTATION=7;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int LOWER_IDENTIFIER=6;
    public static final int LINEBREAKS=13;
    public static final int T__44=44;
    public static final int CONSTANTS=8;
    public static final int COMMENT=10;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int QUOTED_60_62=5;
    public static final int WHITESPACE=12;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators


        public RefspecParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RefspecParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[44+1];
             
             
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
    	



    // $ANTLR start "start"
    // Refspec.g:550:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Refspec.g:551:1: ( (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification ) EOF )
            // Refspec.g:552:2: (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_0, 0));
              		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
              	
            }
            // Refspec.g:557:2: (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification )
            // Refspec.g:558:3: c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification_in_start82);
            c0=parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification();

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


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification"
    // Refspec.g:563:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification returns [org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification element = null] : a0= 'REFACTORING' (a1= UPPER_IDENTIFIER ) a2= 'FOR' (a3= QUOTED_60_62 ) a4= 'STEPS' a5= '{' ( ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction ) a7= ';' ) )+ a8= '}' ;
    public final org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification_StartIndex = input.index();
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
            // Refspec.g:566:1: (a0= 'REFACTORING' (a1= UPPER_IDENTIFIER ) a2= 'FOR' (a3= QUOTED_60_62 ) a4= 'STEPS' a5= '{' ( ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction ) a7= ';' ) )+ a8= '}' )
            // Refspec.g:567:2: a0= 'REFACTORING' (a1= UPPER_IDENTIFIER ) a2= 'FOR' (a3= QUOTED_60_62 ) a4= 'STEPS' a5= '{' ( ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction ) a7= ';' ) )+ a8= '}'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification112); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_1, 1));
              	
            }
            // Refspec.g:579:2: (a1= UPPER_IDENTIFIER )
            // Refspec.g:580:3: a1= UPPER_IDENTIFIER
            {
            a1=(Token)match(input,UPPER_IDENTIFIER,FOLLOW_UPPER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification130); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_2, 2));
              	
            }
            a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification151); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_3, 3));
              	
            }
            // Refspec.g:624:2: (a3= QUOTED_60_62 )
            // Refspec.g:625:3: a3= QUOTED_60_62
            {
            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification169); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_4, 4));
              	
            }
            a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification190); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_5, 5));
              	
            }
            a5=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification204); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Refspec.g:692:2: ( ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction ) a7= ';' ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==21||LA1_0==26||LA1_0==28||LA1_0==31||LA1_0==35||LA1_0==44) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Refspec.g:693:3: ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction ) a7= ';' )
            	    {
            	    // Refspec.g:693:3: ( (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction ) a7= ';' )
            	    // Refspec.g:694:4: (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction ) a7= ';'
            	    {
            	    // Refspec.g:694:4: (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction )
            	    // Refspec.g:695:5: a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification233);
            	    a6_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction();

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
            	      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 7));
            	      			
            	    }
            	    a7=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification261); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRefactoringSpecification();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

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
            a8=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification294); if (state.failed) return element;
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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE"
    // Refspec.g:764:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE returns [org.emftext.language.refactoring.refactoring_specification.CREATE element = null] : a0= 'create' a1= 'new' (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable ) a3= ':' (a4= UPPER_IDENTIFIER ) a5= 'in' (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext ) ( (a7= 'at' (a8= LOWER_IDENTIFIER ) ) )? ;
    public final org.emftext.language.refactoring.refactoring_specification.CREATE parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.CREATE element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a7=null;
        Token a8=null;
        org.emftext.language.refactoring.refactoring_specification.Variable a2_0 = null;

        org.emftext.language.refactoring.refactoring_specification.TargetContext a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Refspec.g:767:1: (a0= 'create' a1= 'new' (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable ) a3= ':' (a4= UPPER_IDENTIFIER ) a5= 'in' (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext ) ( (a7= 'at' (a8= LOWER_IDENTIFIER ) ) )? )
            // Refspec.g:768:2: a0= 'create' a1= 'new' (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable ) a3= ':' (a4= UPPER_IDENTIFIER ) a5= 'in' (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext ) ( (a7= 'at' (a8= LOWER_IDENTIFIER ) ) )?
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE323); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_16, 11));
              	
            }
            a1=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE337); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_17, 12, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_1));
              	
            }
            // Refspec.g:792:2: (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable )
            // Refspec.g:793:3: a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE355);
            a2_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable();

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
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__VARIABLE), a2_0);
              					completedElement(a2_0);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos(a2_0, element); 			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_18, 13));
              	
            }
            a3=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE373); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_19, 14));
              	
            }
            // Refspec.g:826:2: (a4= UPPER_IDENTIFIER )
            // Refspec.g:827:3: a4= UPPER_IDENTIFIER
            {
            a4=(Token)match(input,UPPER_IDENTIFIER,FOLLOW_UPPER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE391); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_20, 15));
              	
            }
            a5=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE412); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 16, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_2));
              	
            }
            // Refspec.g:875:2: (a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext )
            // Refspec.g:876:3: a6_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE430);
            a6_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_22, 17));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 17));
              	
            }
            // Refspec.g:898:2: ( (a7= 'at' (a8= LOWER_IDENTIFIER ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Refspec.g:899:3: (a7= 'at' (a8= LOWER_IDENTIFIER ) )
                    {
                    // Refspec.g:899:3: (a7= 'at' (a8= LOWER_IDENTIFIER ) )
                    // Refspec.g:900:4: a7= 'at' (a8= LOWER_IDENTIFIER )
                    {
                    a7=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE457); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createCREATE();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_23, 18));
                      			
                    }
                    // Refspec.g:912:4: (a8= LOWER_IDENTIFIER )
                    // Refspec.g:913:5: a8= LOWER_IDENTIFIER
                    {
                    a8=(Token)match(input,LOWER_IDENTIFIER,FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE483); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 19));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 20));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE"
    // Refspec.g:958:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE returns [org.emftext.language.refactoring.refactoring_specification.MOVE element = null] : a0= 'move' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext ) a2= 'to' (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext ) ( (a4= 'at' (a5= LOWER_IDENTIFIER ) ) )? ;
    public final org.emftext.language.refactoring.refactoring_specification.MOVE parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.MOVE element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a5=null;
        org.emftext.language.refactoring.refactoring_specification.SourceContext a1_0 = null;

        org.emftext.language.refactoring.refactoring_specification.TargetContext a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Refspec.g:961:1: (a0= 'move' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext ) a2= 'to' (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext ) ( (a4= 'at' (a5= LOWER_IDENTIFIER ) ) )? )
            // Refspec.g:962:2: a0= 'move' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext ) a2= 'to' (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext ) ( (a4= 'at' (a5= LOWER_IDENTIFIER ) ) )?
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE544); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 21, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_3));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_24, 21, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_3));
              	
            }
            // Refspec.g:975:2: (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext )
            // Refspec.g:976:3: a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE562);
            a1_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext();

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
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_25, 22));
              	
            }
            a2=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE580); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 23, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_4));
              	
            }
            // Refspec.g:1009:2: (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext )
            // Refspec.g:1010:3: a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE598);
            a3_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext();

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
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_26, 24));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 24));
              	
            }
            // Refspec.g:1032:2: ( (a4= 'at' (a5= LOWER_IDENTIFIER ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==25) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Refspec.g:1033:3: (a4= 'at' (a5= LOWER_IDENTIFIER ) )
                    {
                    // Refspec.g:1033:3: (a4= 'at' (a5= LOWER_IDENTIFIER ) )
                    // Refspec.g:1034:4: a4= 'at' (a5= LOWER_IDENTIFIER )
                    {
                    a4=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE625); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createMOVE();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_27, 25));
                      			
                    }
                    // Refspec.g:1046:4: (a5= LOWER_IDENTIFIER )
                    // Refspec.g:1047:5: a5= LOWER_IDENTIFIER
                    {
                    a5=(Token)match(input,LOWER_IDENTIFIER,FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE651); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 26));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 27));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_SET"
    // Refspec.g:1092:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_SET returns [org.emftext.language.refactoring.refactoring_specification.SET element = null] : a0= 'set' a1= 'use' a2= 'of' (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext ) a4= 'in' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext ) ;
    public final org.emftext.language.refactoring.refactoring_specification.SET parse_org_emftext_language_refactoring_refactoring_005fspecification_SET() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.SET element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_SET_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.language.refactoring.refactoring_specification.SourceContext a3_0 = null;

        org.emftext.language.refactoring.refactoring_specification.TargetContext a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Refspec.g:1095:1: (a0= 'set' a1= 'use' a2= 'of' (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext ) a4= 'in' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext ) )
            // Refspec.g:1096:2: a0= 'set' a1= 'use' a2= 'of' (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext ) a4= 'in' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext )
            {
            a0=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET712); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_28, 28));
              	
            }
            a1=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET726); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_29, 29));
              	
            }
            a2=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET740); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 30, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_5));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_24, 30, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_5));
              	
            }
            // Refspec.g:1133:2: (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext )
            // Refspec.g:1134:3: a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET758);
            a3_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_30, 31));
              	
            }
            a4=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET776); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createSET();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 32, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_6));
              	
            }
            // Refspec.g:1167:2: (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext )
            // Refspec.g:1168:3: a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET794);
            a5_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 33));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_refactoring_refactoring_005fspecification_SET_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_SET"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN"
    // Refspec.g:1191:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN returns [org.emftext.language.refactoring.refactoring_specification.ASSIGN element = null] : a0= 'assign' ( ( (a1= DOT_NOTATION ) a2= 'for' ) )? (a3= DOT_NOTATION ) ( (a4= 'and' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand ) ) )? ;
    public final org.emftext.language.refactoring.refactoring_specification.ASSIGN parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.ASSIGN element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        org.emftext.language.refactoring.refactoring_specification.AdditionalCommand a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Refspec.g:1194:1: (a0= 'assign' ( ( (a1= DOT_NOTATION ) a2= 'for' ) )? (a3= DOT_NOTATION ) ( (a4= 'and' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand ) ) )? )
            // Refspec.g:1195:2: a0= 'assign' ( ( (a1= DOT_NOTATION ) a2= 'for' ) )? (a3= DOT_NOTATION ) ( (a4= 'and' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand ) ) )?
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN827); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createASSIGN();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_31, 34));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_32, 34));
              	
            }
            // Refspec.g:1208:2: ( ( (a1= DOT_NOTATION ) a2= 'for' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DOT_NOTATION) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==32) ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // Refspec.g:1209:3: ( (a1= DOT_NOTATION ) a2= 'for' )
                    {
                    // Refspec.g:1209:3: ( (a1= DOT_NOTATION ) a2= 'for' )
                    // Refspec.g:1210:4: (a1= DOT_NOTATION ) a2= 'for'
                    {
                    // Refspec.g:1210:4: (a1= DOT_NOTATION )
                    // Refspec.g:1211:5: a1= DOT_NOTATION
                    {
                    a1=(Token)match(input,DOT_NOTATION,FOLLOW_DOT_NOTATION_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN856); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_33, 35));
                      			
                    }
                    a2=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN889); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createASSIGN();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_32, 36));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_32, 37));
              	
            }
            // Refspec.g:1266:2: (a3= DOT_NOTATION )
            // Refspec.g:1267:3: a3= DOT_NOTATION
            {
            a3=(Token)match(input,DOT_NOTATION,FOLLOW_DOT_NOTATION_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN926); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_34, 38));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 38));
              	
            }
            // Refspec.g:1304:2: ( (a4= 'and' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==33) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Refspec.g:1305:3: (a4= 'and' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand ) )
                    {
                    // Refspec.g:1305:3: (a4= 'and' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand ) )
                    // Refspec.g:1306:4: a4= 'and' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand )
                    {
                    a4=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN956); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createASSIGN();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_35, 39, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_7));
                      			
                    }
                    // Refspec.g:1318:4: (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand )
                    // Refspec.g:1319:5: a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN982);
                    a5_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 40));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 41));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE"
    // Refspec.g:1349:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE returns [org.emftext.language.refactoring.refactoring_specification.UPDATE element = null] : a0= 'update' ;
    public final org.emftext.language.refactoring.refactoring_specification.UPDATE parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.UPDATE element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Refspec.g:1352:1: (a0= 'update' )
            // Refspec.g:1353:2: a0= 'update'
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE1038); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createUPDATE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 42));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable"
    // Refspec.g:1367:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable returns [org.emftext.language.refactoring.refactoring_specification.Variable element = null] : (a0= LOWER_IDENTIFIER ) ;
    public final org.emftext.language.refactoring.refactoring_specification.Variable parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.Variable element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Refspec.g:1370:1: ( (a0= LOWER_IDENTIFIER ) )
            // Refspec.g:1371:2: (a0= LOWER_IDENTIFIER )
            {
            // Refspec.g:1371:2: (a0= LOWER_IDENTIFIER )
            // Refspec.g:1372:3: a0= LOWER_IDENTIFIER
            {
            a0=(Token)match(input,LOWER_IDENTIFIER,FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable1071); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_18, 43));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_36, 43));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference"
    // Refspec.g:1407:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference returns [org.emftext.language.refactoring.refactoring_specification.VariableReference element = null] : (a0= LOWER_IDENTIFIER ) ;
    public final org.emftext.language.refactoring.refactoring_specification.VariableReference parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.VariableReference element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Refspec.g:1410:1: ( (a0= LOWER_IDENTIFIER ) )
            // Refspec.g:1411:2: (a0= LOWER_IDENTIFIER )
            {
            // Refspec.g:1411:2: (a0= LOWER_IDENTIFIER )
            // Refspec.g:1412:3: a0= LOWER_IDENTIFIER
            {
            a0=(Token)match(input,LOWER_IDENTIFIER,FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference1111); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment"
    // Refspec.g:1457:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment returns [org.emftext.language.refactoring.refactoring_specification.VariableAssignment element = null] : a0= 'object' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable ) a2= ':=' (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand ) ;
    public final org.emftext.language.refactoring.refactoring_specification.VariableAssignment parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.VariableAssignment element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.language.refactoring.refactoring_specification.Variable a1_0 = null;

        org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // Refspec.g:1460:1: (a0= 'object' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable ) a2= ':=' (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand ) )
            // Refspec.g:1461:2: a0= 'object' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable ) a2= ':=' (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand )
            {
            a0=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment1147); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableAssignment();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_17, 45, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_1));
              	
            }
            // Refspec.g:1473:2: (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable )
            // Refspec.g:1474:3: a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment1165);
            a1_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_36, 46));
              	
            }
            a2=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment1183); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createVariableAssignment();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_41, 47, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_8));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_42, 47, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_8));
              	
            }
            // Refspec.g:1508:2: (a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand )
            // Refspec.g:1509:3: a3_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment1201);
            a3_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 48));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference"
    // Refspec.g:1532:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference returns [org.emftext.language.refactoring.refactoring_specification.RoleReference element = null] : (a0= UPPER_IDENTIFIER ) a1= 'from' (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause ) ;
    public final org.emftext.language.refactoring.refactoring_specification.RoleReference parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.RoleReference element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        org.emftext.language.refactoring.refactoring_specification.FromClause a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // Refspec.g:1535:1: ( (a0= UPPER_IDENTIFIER ) a1= 'from' (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause ) )
            // Refspec.g:1536:2: (a0= UPPER_IDENTIFIER ) a1= 'from' (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause )
            {
            // Refspec.g:1536:2: (a0= UPPER_IDENTIFIER )
            // Refspec.g:1537:3: a0= UPPER_IDENTIFIER
            {
            a0=(Token)match(input,UPPER_IDENTIFIER,FOLLOW_UPPER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference1238); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_43, 49));
              	
            }
            a1=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference1259); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createRoleReference();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_44, 50, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_10));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_45, 50, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_9, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_10));
              	
            }
            // Refspec.g:1586:2: (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause )
            // Refspec.g:1587:3: a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference1277);
            a2_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 51));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE"
    // Refspec.g:1610:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE returns [org.emftext.language.refactoring.refactoring_specification.TRACE element = null] : (a0= UPPER_IDENTIFIER ) a1= 'as' a2= 'trace' a3= '(' (a4_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a5= ')' ;
    public final org.emftext.language.refactoring.refactoring_specification.TRACE parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.TRACE element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        org.emftext.language.refactoring.refactoring_specification.FromReference a4_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // Refspec.g:1613:1: ( (a0= UPPER_IDENTIFIER ) a1= 'as' a2= 'trace' a3= '(' (a4_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a5= ')' )
            // Refspec.g:1614:2: (a0= UPPER_IDENTIFIER ) a1= 'as' a2= 'trace' a3= '(' (a4_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a5= ')'
            {
            // Refspec.g:1614:2: (a0= UPPER_IDENTIFIER )
            // Refspec.g:1615:3: a0= UPPER_IDENTIFIER
            {
            a0=(Token)match(input,UPPER_IDENTIFIER,FOLLOW_UPPER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1314); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_46, 52));
              	
            }
            a1=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1335); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_47, 53));
              	
            }
            a2=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1349); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_48, 54));
              	
            }
            a3=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1363); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 55, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_11));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_49, 55, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_11));
              	
            }
            // Refspec.g:1688:2: (a4_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference )
            // Refspec.g:1689:3: a4_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1381);
            a4_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_37, 56));
              	
            }
            a5=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1399); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createTRACE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 57));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference"
    // Refspec.g:1724:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference returns [org.emftext.language.refactoring.refactoring_specification.RelationReference element = null] : (a0= DOT_NOTATION ) ;
    public final org.emftext.language.refactoring.refactoring_specification.RelationReference parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.RelationReference element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // Refspec.g:1727:1: ( (a0= DOT_NOTATION ) )
            // Refspec.g:1728:2: (a0= DOT_NOTATION )
            {
            // Refspec.g:1728:2: (a0= DOT_NOTATION )
            // Refspec.g:1729:3: a0= DOT_NOTATION
            {
            a0=(Token)match(input,DOT_NOTATION,FOLLOW_DOT_NOTATION_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference1432); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_25, 58));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_30, 58));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference"
    // Refspec.g:1768:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference returns [org.emftext.language.refactoring.refactoring_specification.ConstantsReference element = null] : (a0= CONSTANTS ) ;
    public final org.emftext.language.refactoring.refactoring_specification.ConstantsReference parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.ConstantsReference element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // Refspec.g:1771:1: ( (a0= CONSTANTS ) )
            // Refspec.g:1772:2: (a0= CONSTANTS )
            {
            // Refspec.g:1772:2: (a0= CONSTANTS )
            // Refspec.g:1773:3: a0= CONSTANTS
            {
            a0=(Token)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference1472); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_37, 59));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_38, 59));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_39, 59));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_40, 59));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause"
    // Refspec.g:1810:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause returns [org.emftext.language.refactoring.refactoring_specification.FromClause element = null] : (a0_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator ) a1= '(' (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a3= ')' ;
    public final org.emftext.language.refactoring.refactoring_specification.FromClause parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.FromClause element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause_StartIndex = input.index();
        Token a1=null;
        Token a3=null;
        org.emftext.language.refactoring.refactoring_specification.FromOperator a0_0 = null;

        org.emftext.language.refactoring.refactoring_specification.FromReference a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // Refspec.g:1813:1: ( (a0_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator ) a1= '(' (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a3= ')' )
            // Refspec.g:1814:2: (a0_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator ) a1= '(' (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a3= ')'
            {
            // Refspec.g:1814:2: (a0_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator )
            // Refspec.g:1815:3: a0_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause1512);
            a0_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_50, 60));
              	
            }
            a1=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause1530); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFromClause();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 61, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_12));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_49, 61, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_12));
              	
            }
            // Refspec.g:1849:2: (a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference )
            // Refspec.g:1850:3: a2_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause1548);
            a2_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_38, 62));
              	
            }
            a3=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause1566); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFromClause();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 63));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE"
    // Refspec.g:1885:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE returns [org.emftext.language.refactoring.refactoring_specification.UPTREE element = null] : a0= 'uptree' ;
    public final org.emftext.language.refactoring.refactoring_specification.UPTREE parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.UPTREE element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // Refspec.g:1888:1: (a0= 'uptree' )
            // Refspec.g:1889:2: a0= 'uptree'
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE1595); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createUPTREE();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_50, 64));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH"
    // Refspec.g:1903:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH returns [org.emftext.language.refactoring.refactoring_specification.PATH element = null] : a0= 'path' ;
    public final org.emftext.language.refactoring.refactoring_specification.PATH parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.PATH element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // Refspec.g:1906:1: (a0= 'path' )
            // Refspec.g:1907:2: a0= 'path'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH1624); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createPATH();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_50, 65));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST"
    // Refspec.g:1921:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST returns [org.emftext.language.refactoring.refactoring_specification.FIRST element = null] : a0= 'index' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable ) a2= ':=' a3= 'first' a4= '(' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a6= ')' ;
    public final org.emftext.language.refactoring.refactoring_specification.FIRST parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.FIRST element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        org.emftext.language.refactoring.refactoring_specification.IndexVariable a1_0 = null;

        org.emftext.language.refactoring.refactoring_specification.FromReference a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // Refspec.g:1924:1: (a0= 'index' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable ) a2= ':=' a3= 'first' a4= '(' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a6= ')' )
            // Refspec.g:1925:2: a0= 'index' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable ) a2= ':=' a3= 'first' a4= '(' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a6= ')'
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1653); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_51, 66, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_13));
              	
            }
            // Refspec.g:1937:2: (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable )
            // Refspec.g:1938:3: a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1671);
            a1_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_52, 67));
              	
            }
            a2=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1689); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_53, 68));
              	
            }
            a3=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1703); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_54, 69));
              	
            }
            a4=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1717); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 70, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_14));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_49, 70, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_14));
              	
            }
            // Refspec.g:1996:2: (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference )
            // Refspec.g:1997:3: a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1735);
            a5_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_39, 71));
              	
            }
            a6=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1753); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createFIRST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 72));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST"
    // Refspec.g:2032:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST returns [org.emftext.language.refactoring.refactoring_specification.LAST element = null] : a0= 'index' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable ) a2= ':=' a3= 'last' a4= '(' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a6= ')' ;
    public final org.emftext.language.refactoring.refactoring_specification.LAST parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.LAST element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        org.emftext.language.refactoring.refactoring_specification.IndexVariable a1_0 = null;

        org.emftext.language.refactoring.refactoring_specification.FromReference a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // Refspec.g:2035:1: (a0= 'index' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable ) a2= ':=' a3= 'last' a4= '(' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a6= ')' )
            // Refspec.g:2036:2: a0= 'index' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable ) a2= ':=' a3= 'last' a4= '(' (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference ) a6= ')'
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1782); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_51, 73, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_13));
              	
            }
            // Refspec.g:2048:2: (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable )
            // Refspec.g:2049:3: a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1800);
            a1_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_55, 74));
              	
            }
            a2=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1818); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_56, 75));
              	
            }
            a3=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1832); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_57, 76));
              	
            }
            a4=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1846); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_21, 77, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_14));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_49, 77, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_14));
              	
            }
            // Refspec.g:2107:2: (a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference )
            // Refspec.g:2108:3: a5_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1864);
            a5_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_40, 78));
              	
            }
            a6=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1882); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createLAST();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 79));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex"
    // Refspec.g:2143:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex returns [org.emftext.language.refactoring.refactoring_specification.ConcreteIndex element = null] : a0= 'index' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable ) a2= ':=' (a3= INTEGER ) ;
    public final org.emftext.language.refactoring.refactoring_specification.ConcreteIndex parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.ConcreteIndex element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        Token a3=null;
        org.emftext.language.refactoring.refactoring_specification.IndexVariable a1_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // Refspec.g:2146:1: (a0= 'index' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable ) a2= ':=' (a3= INTEGER ) )
            // Refspec.g:2147:2: a0= 'index' (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable ) a2= ':=' (a3= INTEGER )
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex1911); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createConcreteIndex();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_51, 80, org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.FEATURE_13));
              	
            }
            // Refspec.g:2159:2: (a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable )
            // Refspec.g:2160:3: a1_0= parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex1929);
            a1_0=parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_58, 81));
              	
            }
            a2=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex1947); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory.eINSTANCE.createConcreteIndex();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_59, 82));
              	
            }
            // Refspec.g:2193:2: (a3= INTEGER )
            // Refspec.g:2194:3: a3= INTEGER
            {
            a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex1965); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_14, 83));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable"
    // Refspec.g:2228:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable returns [org.emftext.language.refactoring.refactoring_specification.IndexVariable element = null] : (a0= LOWER_IDENTIFIER ) ;
    public final org.emftext.language.refactoring.refactoring_specification.IndexVariable parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.IndexVariable element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // Refspec.g:2231:1: ( (a0= LOWER_IDENTIFIER ) )
            // Refspec.g:2232:2: (a0= LOWER_IDENTIFIER )
            {
            // Refspec.g:2232:2: (a0= LOWER_IDENTIFIER )
            // Refspec.g:2233:3: a0= LOWER_IDENTIFIER
            {
            a0=(Token)match(input,LOWER_IDENTIFIER,FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable2005); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_52, 84));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_55, 84));
              		addExpectedElement(new org.emftext.language.refactoring.specification.resource.mopp.RefspecExpectedTerminal(org.emftext.language.refactoring.specification.resource.grammar.RefspecFollowSetProvider.TERMINAL_58, 84));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction"
    // Refspec.g:2269:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction returns [org.emftext.language.refactoring.refactoring_specification.Instruction element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE | c2= parse_org_emftext_language_refactoring_refactoring_005fspecification_SET | c3= parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN | c4= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment | c5= parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST | c6= parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST | c7= parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex );
    public final org.emftext.language.refactoring.refactoring_specification.Instruction parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.Instruction element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.CREATE c0 = null;

        org.emftext.language.refactoring.refactoring_specification.MOVE c1 = null;

        org.emftext.language.refactoring.refactoring_specification.SET c2 = null;

        org.emftext.language.refactoring.refactoring_specification.ASSIGN c3 = null;

        org.emftext.language.refactoring.refactoring_specification.VariableAssignment c4 = null;

        org.emftext.language.refactoring.refactoring_specification.FIRST c5 = null;

        org.emftext.language.refactoring.refactoring_specification.LAST c6 = null;

        org.emftext.language.refactoring.refactoring_specification.ConcreteIndex c7 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // Refspec.g:2270:1: (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE | c2= parse_org_emftext_language_refactoring_refactoring_005fspecification_SET | c3= parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN | c4= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment | c5= parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST | c6= parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST | c7= parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex )
            int alt6=8;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // Refspec.g:2271:2: c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2037);
                    c0=parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Refspec.g:2272:4: c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2047);
                    c1=parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Refspec.g:2273:4: c2= parse_org_emftext_language_refactoring_refactoring_005fspecification_SET
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2057);
                    c2=parse_org_emftext_language_refactoring_refactoring_005fspecification_SET();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 4 :
                    // Refspec.g:2274:4: c3= parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2067);
                    c3=parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 5 :
                    // Refspec.g:2275:4: c4= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2077);
                    c4=parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 6 :
                    // Refspec.g:2276:4: c5= parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2087);
                    c5=parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 7 :
                    // Refspec.g:2277:4: c6= parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2097);
                    c6=parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c6; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 8 :
                    // Refspec.g:2278:4: c7= parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2107);
                    c7=parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c7; /* this is a subclass or primitive expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 22, parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext"
    // Refspec.g:2282:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext returns [org.emftext.language.refactoring.refactoring_specification.TargetContext element = null] : c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference ;
    public final org.emftext.language.refactoring.refactoring_specification.TargetContext parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.TargetContext element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.VariableReference c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // Refspec.g:2283:1: (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference )
            // Refspec.g:2284:2: c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext2128);
            c0=parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; /* this is a subclass or primitive expression choice */ 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext"
    // Refspec.g:2288:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext returns [org.emftext.language.refactoring.refactoring_specification.SourceContext element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference );
    public final org.emftext.language.refactoring.refactoring_specification.SourceContext parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.SourceContext element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.VariableReference c0 = null;

        org.emftext.language.refactoring.refactoring_specification.RelationReference c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // Refspec.g:2289:1: (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LOWER_IDENTIFIER) ) {
                alt7=1;
            }
            else if ( (LA7_0==DOT_NOTATION) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // Refspec.g:2290:2: c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext2149);
                    c0=parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Refspec.g:2291:4: c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext2159);
                    c1=parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 24, parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand"
    // Refspec.g:2295:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand returns [org.emftext.language.refactoring.refactoring_specification.AdditionalCommand element = null] : c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE ;
    public final org.emftext.language.refactoring.refactoring_specification.AdditionalCommand parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.AdditionalCommand element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.UPDATE c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }
            // Refspec.g:2296:1: (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE )
            // Refspec.g:2297:2: c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand2180);
            c0=parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; /* this is a subclass or primitive expression choice */ 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand"
    // Refspec.g:2301:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand returns [org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE );
    public final org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.RoleReference c0 = null;

        org.emftext.language.refactoring.refactoring_specification.TRACE c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }
            // Refspec.g:2302:1: (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==UPPER_IDENTIFIER) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==37) ) {
                    alt8=1;
                }
                else if ( (LA8_1==38) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // Refspec.g:2303:2: c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand2201);
                    c0=parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Refspec.g:2304:4: c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand2211);
                    c1=parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 26, parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference"
    // Refspec.g:2308:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference returns [org.emftext.language.refactoring.refactoring_specification.FromReference element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference );
    public final org.emftext.language.refactoring.refactoring_specification.FromReference parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.FromReference element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.VariableReference c0 = null;

        org.emftext.language.refactoring.refactoring_specification.ConstantsReference c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }
            // Refspec.g:2309:1: (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LOWER_IDENTIFIER) ) {
                alt9=1;
            }
            else if ( (LA9_0==CONSTANTS) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // Refspec.g:2310:2: c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference2232);
                    c0=parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Refspec.g:2311:4: c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference2242);
                    c1=parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 27, parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference"


    // $ANTLR start "parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator"
    // Refspec.g:2315:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator returns [org.emftext.language.refactoring.refactoring_specification.FromOperator element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH );
    public final org.emftext.language.refactoring.refactoring_specification.FromOperator parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator() throws RecognitionException {
        org.emftext.language.refactoring.refactoring_specification.FromOperator element =  null;
        int parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator_StartIndex = input.index();
        org.emftext.language.refactoring.refactoring_specification.UPTREE c0 = null;

        org.emftext.language.refactoring.refactoring_specification.PATH c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }
            // Refspec.g:2316:1: (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==42) ) {
                alt10=1;
            }
            else if ( (LA10_0==43) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // Refspec.g:2317:2: c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator2263);
                    c0=parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Refspec.g:2318:4: c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator2273);
                    c1=parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 28, parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\14\uffff";
    static final String DFA6_eofS =
        "\14\uffff";
    static final String DFA6_minS =
        "\1\25\5\uffff\1\6\1\44\1\11\3\uffff";
    static final String DFA6_maxS =
        "\1\54\5\uffff\1\6\1\44\1\56\3\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\3\uffff\1\7\1\6\1\10";
    static final String DFA6_specialS =
        "\14\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\4\uffff\1\2\1\uffff\1\3\2\uffff\1\4\3\uffff\1\5\10\uffff"+
            "\1\6",
            "",
            "",
            "",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\13\43\uffff\1\12\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "2269:1: parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction returns [org.emftext.language.refactoring.refactoring_specification.Instruction element = null] : (c0= parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE | c1= parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE | c2= parse_org_emftext_language_refactoring_refactoring_005fspecification_SET | c3= parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN | c4= parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment | c5= parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST | c6= parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST | c7= parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex );";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_UPPER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification130 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification151 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification169 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification190 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification204 = new BitSet(new long[]{0x0000100894200000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification233 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification261 = new BitSet(new long[]{0x0000100894300000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE323 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE337 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE355 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE373 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_UPPER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE391 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE412 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE430 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE457 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE544 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE562 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE580 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE598 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE625 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET712 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET726 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET740 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET758 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET776 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN827 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DOT_NOTATION_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN856 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN889 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DOT_NOTATION_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN926 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN956 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment1147 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_Variable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment1165 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment1183 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPPER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference1238 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference1259 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPPER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1314 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1335 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1349 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1363 = new BitSet(new long[]{0x0000000000000140L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1381 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_NOTATION_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause1512 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause1530 = new BitSet(new long[]{0x0000000000000140L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause1548 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromClause1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1653 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1671 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1689 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1703 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1717 = new BitSet(new long[]{0x0000000000000140L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1735 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1782 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1800 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1818 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1832 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1846 = new BitSet(new long[]{0x0000000000000140L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1864 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex1911 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex1929 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex1947 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex1965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOWER_IDENTIFIER_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_CREATE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_MOVE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_SET_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_FIRST_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_LAST_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_Instruction2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_TRACE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference2232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromReference2242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_refactoring_005fspecification_PATH_in_parse_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator2273 = new BitSet(new long[]{0x0000000000000002L});

}