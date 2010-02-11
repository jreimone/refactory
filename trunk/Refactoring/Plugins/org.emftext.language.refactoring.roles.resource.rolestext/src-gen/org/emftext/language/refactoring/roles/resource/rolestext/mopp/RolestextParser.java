// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.refactoring.roles.resource.rolestext.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
public class RolestextParser extends RolestextANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "BOOLEAN_LITERAL", "NUMBER", "SL_COMMENT", "ML_COMMENT", "WHITESPACE", "LINEBREAKS", "'RoleModel'", "'{'", "'}'", "'role'", "'('", "','", "')'", "';'", "'|-|'", "'->'", "'--'", "'<>-'", "'['", "'..'", "']'"
    };
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int NUMBER=6;
    public static final int WHITESPACE=9;
    public static final int LINEBREAKS=10;
    public static final int EOF=-1;
    public static final int BOOLEAN_LITERAL=5;
    public static final int ML_COMMENT=8;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int IDENTIFIER=4;
    public static final int SL_COMMENT=7;

    // delegates
    // delegators


        public RolestextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RolestextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[34+1];
             
             
        }
        

    public String[] getTokenNames() { return RolestextParser.tokenNames; }
    public String getGrammarFileName() { return "Rolestext.g"; }


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



    // $ANTLR start "start"
    // Rolestext.g:707:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_refactoring_roles_RoleModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.language.refactoring.roles.RoleModel c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Rolestext.g:708:1: ( (c0= parse_org_emftext_language_refactoring_roles_RoleModel ) EOF )
            // Rolestext.g:709:2: (c0= parse_org_emftext_language_refactoring_roles_RoleModel ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_0, 0));
              		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
              	
            }
            // Rolestext.g:714:2: (c0= parse_org_emftext_language_refactoring_roles_RoleModel )
            // Rolestext.g:715:3: c0= parse_org_emftext_language_refactoring_roles_RoleModel
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_RoleModel_in_start82);
            c0=parse_org_emftext_language_refactoring_roles_RoleModel();

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


    // $ANTLR start "parse_org_emftext_language_refactoring_roles_RoleModel"
    // Rolestext.g:720:1: parse_org_emftext_language_refactoring_roles_RoleModel returns [org.emftext.language.refactoring.roles.RoleModel element = null] : a0= 'RoleModel' (a1= IDENTIFIER ) a2= '{' ( (a3_0= parse_org_emftext_language_refactoring_roles_Role ) )* ( (a4_0= parse_org_emftext_language_refactoring_roles_Relation ) )* a5= '}' ;
    public final org.emftext.language.refactoring.roles.RoleModel parse_org_emftext_language_refactoring_roles_RoleModel() throws RecognitionException {
        org.emftext.language.refactoring.roles.RoleModel element =  null;
        int parse_org_emftext_language_refactoring_roles_RoleModel_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a5=null;
        org.emftext.language.refactoring.roles.Role a3_0 = null;

        org.emftext.language.refactoring.roles.Relation a4_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // Rolestext.g:723:1: (a0= 'RoleModel' (a1= IDENTIFIER ) a2= '{' ( (a3_0= parse_org_emftext_language_refactoring_roles_Role ) )* ( (a4_0= parse_org_emftext_language_refactoring_roles_Relation ) )* a5= '}' )
            // Rolestext.g:724:2: a0= 'RoleModel' (a1= IDENTIFIER ) a2= '{' ( (a3_0= parse_org_emftext_language_refactoring_roles_Role ) )* ( (a4_0= parse_org_emftext_language_refactoring_roles_Relation ) )* a5= '}'
            {
            a0=(Token)match(input,11,FOLLOW_11_in_parse_org_emftext_language_refactoring_roles_RoleModel112); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_1, 1));
              	
            }
            // Rolestext.g:736:2: (a1= IDENTIFIER )
            // Rolestext.g:737:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleModel130); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_2, 2));
              	
            }
            a2=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_refactoring_roles_RoleModel151); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_3, 3, FEATURE_0));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 3, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 3, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 3, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 3, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 3));
              	
            }
            // Rolestext.g:786:2: ( (a3_0= parse_org_emftext_language_refactoring_roles_Role ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Rolestext.g:787:3: (a3_0= parse_org_emftext_language_refactoring_roles_Role )
            	    {
            	    // Rolestext.g:787:3: (a3_0= parse_org_emftext_language_refactoring_roles_Role )
            	    // Rolestext.g:788:4: a3_0= parse_org_emftext_language_refactoring_roles_Role
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Role_in_parse_org_emftext_language_refactoring_roles_RoleModel174);
            	    a3_0=parse_org_emftext_language_refactoring_roles_Role();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_3, 4, FEATURE_0));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 4, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 4, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 4, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 4, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 4));
              	
            }
            // Rolestext.g:815:2: ( (a4_0= parse_org_emftext_language_refactoring_roles_Relation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENTIFIER) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Rolestext.g:816:3: (a4_0= parse_org_emftext_language_refactoring_roles_Relation )
            	    {
            	    // Rolestext.g:816:3: (a4_0= parse_org_emftext_language_refactoring_roles_Relation )
            	    // Rolestext.g:817:4: a4_0= parse_org_emftext_language_refactoring_roles_Relation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Relation_in_parse_org_emftext_language_refactoring_roles_RoleModel209);
            	    a4_0=parse_org_emftext_language_refactoring_roles_Relation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 5, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 5, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 5, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 5, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 5));
              	
            }
            a5=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_refactoring_roles_RoleModel235); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_refactoring_roles_RoleModel_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_roles_RoleModel"


    // $ANTLR start "parse_org_emftext_language_refactoring_roles_Role"
    // Rolestext.g:856:1: parse_org_emftext_language_refactoring_roles_Role returns [org.emftext.language.refactoring.roles.Role element = null] : a0= 'role' (a1= IDENTIFIER ) ( (a2= '(' ( ( (a3= BOOLEAN_LITERAL ) ) )? a4= ',' ( ( (a5= BOOLEAN_LITERAL ) ) )? a6= ',' ( ( (a7= BOOLEAN_LITERAL ) ) )? a8= ')' ) )? a9= ';' ;
    public final org.emftext.language.refactoring.roles.Role parse_org_emftext_language_refactoring_roles_Role() throws RecognitionException {
        org.emftext.language.refactoring.roles.Role element =  null;
        int parse_org_emftext_language_refactoring_roles_Role_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Rolestext.g:859:1: (a0= 'role' (a1= IDENTIFIER ) ( (a2= '(' ( ( (a3= BOOLEAN_LITERAL ) ) )? a4= ',' ( ( (a5= BOOLEAN_LITERAL ) ) )? a6= ',' ( ( (a7= BOOLEAN_LITERAL ) ) )? a8= ')' ) )? a9= ';' )
            // Rolestext.g:860:2: a0= 'role' (a1= IDENTIFIER ) ( (a2= '(' ( ( (a3= BOOLEAN_LITERAL ) ) )? a4= ',' ( ( (a5= BOOLEAN_LITERAL ) ) )? a6= ',' ( ( (a7= BOOLEAN_LITERAL ) ) )? a8= ')' ) )? a9= ';'
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_refactoring_roles_Role264); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_9, 7));
              	
            }
            // Rolestext.g:872:2: (a1= IDENTIFIER )
            // Rolestext.g:873:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_Role282); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_10, 8));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_11, 8));
              	
            }
            // Rolestext.g:906:2: ( (a2= '(' ( ( (a3= BOOLEAN_LITERAL ) ) )? a4= ',' ( ( (a5= BOOLEAN_LITERAL ) ) )? a6= ',' ( ( (a7= BOOLEAN_LITERAL ) ) )? a8= ')' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Rolestext.g:907:3: (a2= '(' ( ( (a3= BOOLEAN_LITERAL ) ) )? a4= ',' ( ( (a5= BOOLEAN_LITERAL ) ) )? a6= ',' ( ( (a7= BOOLEAN_LITERAL ) ) )? a8= ')' )
                    {
                    // Rolestext.g:907:3: (a2= '(' ( ( (a3= BOOLEAN_LITERAL ) ) )? a4= ',' ( ( (a5= BOOLEAN_LITERAL ) ) )? a6= ',' ( ( (a7= BOOLEAN_LITERAL ) ) )? a8= ')' )
                    // Rolestext.g:908:4: a2= '(' ( ( (a3= BOOLEAN_LITERAL ) ) )? a4= ',' ( ( (a5= BOOLEAN_LITERAL ) ) )? a6= ',' ( ( (a7= BOOLEAN_LITERAL ) ) )? a8= ')'
                    {
                    a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_Role312); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_12, 9));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_13, 9));
                      			
                    }
                    // Rolestext.g:921:4: ( ( (a3= BOOLEAN_LITERAL ) ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==BOOLEAN_LITERAL) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // Rolestext.g:922:5: ( (a3= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:922:5: ( (a3= BOOLEAN_LITERAL ) )
                            // Rolestext.g:923:6: (a3= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:923:6: (a3= BOOLEAN_LITERAL )
                            // Rolestext.g:924:7: a3= BOOLEAN_LITERAL
                            {
                            a3=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_Role353); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_13, 10));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_13, 11));
                      			
                    }
                    a4=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_Role421); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_14, 12));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 12));
                      			
                    }
                    // Rolestext.g:976:4: ( ( (a5= BOOLEAN_LITERAL ) ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==BOOLEAN_LITERAL) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // Rolestext.g:977:5: ( (a5= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:977:5: ( (a5= BOOLEAN_LITERAL ) )
                            // Rolestext.g:978:6: (a5= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:978:6: (a5= BOOLEAN_LITERAL )
                            // Rolestext.g:979:7: a5= BOOLEAN_LITERAL
                            {
                            a5=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_Role462); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 13));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 14));
                      			
                    }
                    a6=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_Role530); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_16, 15));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_17, 15));
                      			
                    }
                    // Rolestext.g:1031:4: ( ( (a7= BOOLEAN_LITERAL ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==BOOLEAN_LITERAL) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // Rolestext.g:1032:5: ( (a7= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:1032:5: ( (a7= BOOLEAN_LITERAL ) )
                            // Rolestext.g:1033:6: (a7= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:1033:6: (a7= BOOLEAN_LITERAL )
                            // Rolestext.g:1034:7: a7= BOOLEAN_LITERAL
                            {
                            a7=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_Role571); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_17, 16));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_17, 17));
                      			
                    }
                    a8=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_Role639); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_11, 18));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_11, 19));
              	
            }
            a9=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_Role672); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_3, 20, FEATURE_0));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 20, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 20, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 20, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 20, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 20));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_refactoring_roles_Role_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_roles_Role"


    // $ANTLR start "parse_org_emftext_language_refactoring_roles_RoleProhibition"
    // Rolestext.g:1111:1: parse_org_emftext_language_refactoring_roles_RoleProhibition returns [org.emftext.language.refactoring.roles.RoleProhibition element = null] : (a0= IDENTIFIER ) a1= '|-|' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' ) )? a8= ';' ;
    public final org.emftext.language.refactoring.roles.RoleProhibition parse_org_emftext_language_refactoring_roles_RoleProhibition() throws RecognitionException {
        org.emftext.language.refactoring.roles.RoleProhibition element =  null;
        int parse_org_emftext_language_refactoring_roles_RoleProhibition_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Rolestext.g:1114:1: ( (a0= IDENTIFIER ) a1= '|-|' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' ) )? a8= ';' )
            // Rolestext.g:1115:2: (a0= IDENTIFIER ) a1= '|-|' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' ) )? a8= ';'
            {
            // Rolestext.g:1115:2: (a0= IDENTIFIER )
            // Rolestext.g:1116:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleProhibition705); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_18, 21));
              	
            }
            a1=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleProhibition726); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_19, 22));
              	
            }
            // Rolestext.g:1164:2: (a2= IDENTIFIER )
            // Rolestext.g:1165:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleProhibition744); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_20, 23));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_21, 23));
              	
            }
            // Rolestext.g:1202:2: ( (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Rolestext.g:1203:3: (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' )
                    {
                    // Rolestext.g:1203:3: (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' )
                    // Rolestext.g:1204:4: a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')'
                    {
                    a3=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleProhibition774); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_22, 24));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_23, 24));
                      			
                    }
                    // Rolestext.g:1217:4: ( ( (a4= BOOLEAN_LITERAL ) ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==BOOLEAN_LITERAL) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Rolestext.g:1218:5: ( (a4= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:1218:5: ( (a4= BOOLEAN_LITERAL ) )
                            // Rolestext.g:1219:6: (a4= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:1219:6: (a4= BOOLEAN_LITERAL )
                            // Rolestext.g:1220:7: a4= BOOLEAN_LITERAL
                            {
                            a4=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleProhibition815); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_23, 25));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_23, 26));
                      			
                    }
                    a5=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleProhibition883); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_24, 27));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_25, 27));
                      			
                    }
                    // Rolestext.g:1272:4: ( ( (a6= BOOLEAN_LITERAL ) ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==BOOLEAN_LITERAL) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // Rolestext.g:1273:5: ( (a6= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:1273:5: ( (a6= BOOLEAN_LITERAL ) )
                            // Rolestext.g:1274:6: (a6= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:1274:6: (a6= BOOLEAN_LITERAL )
                            // Rolestext.g:1275:7: a6= BOOLEAN_LITERAL
                            {
                            a6=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleProhibition924); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_25, 28));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_25, 29));
                      			
                    }
                    a7=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleProhibition992); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_21, 30));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_21, 31));
              	
            }
            a8=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_RoleProhibition1025); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 32, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 32, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 32, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 32, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 32));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_refactoring_roles_RoleProhibition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_roles_RoleProhibition"


    // $ANTLR start "parse_org_emftext_language_refactoring_roles_RoleImplication"
    // Rolestext.g:1351:1: parse_org_emftext_language_refactoring_roles_RoleImplication returns [org.emftext.language.refactoring.roles.RoleImplication element = null] : (a0= IDENTIFIER ) a1= '->' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' ) )? a8= ';' ;
    public final org.emftext.language.refactoring.roles.RoleImplication parse_org_emftext_language_refactoring_roles_RoleImplication() throws RecognitionException {
        org.emftext.language.refactoring.roles.RoleImplication element =  null;
        int parse_org_emftext_language_refactoring_roles_RoleImplication_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Rolestext.g:1354:1: ( (a0= IDENTIFIER ) a1= '->' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' ) )? a8= ';' )
            // Rolestext.g:1355:2: (a0= IDENTIFIER ) a1= '->' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' ) )? a8= ';'
            {
            // Rolestext.g:1355:2: (a0= IDENTIFIER )
            // Rolestext.g:1356:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleImplication1058); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_26, 33));
              	
            }
            a1=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleImplication1079); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_27, 34));
              	
            }
            // Rolestext.g:1404:2: (a2= IDENTIFIER )
            // Rolestext.g:1405:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleImplication1097); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_28, 35));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 35));
              	
            }
            // Rolestext.g:1442:2: ( (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==15) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Rolestext.g:1443:3: (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' )
                    {
                    // Rolestext.g:1443:3: (a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')' )
                    // Rolestext.g:1444:4: a3= '(' ( ( (a4= BOOLEAN_LITERAL ) ) )? a5= ',' ( ( (a6= BOOLEAN_LITERAL ) ) )? a7= ')'
                    {
                    a3=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleImplication1127); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_30, 36));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 36));
                      			
                    }
                    // Rolestext.g:1457:4: ( ( (a4= BOOLEAN_LITERAL ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==BOOLEAN_LITERAL) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // Rolestext.g:1458:5: ( (a4= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:1458:5: ( (a4= BOOLEAN_LITERAL ) )
                            // Rolestext.g:1459:6: (a4= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:1459:6: (a4= BOOLEAN_LITERAL )
                            // Rolestext.g:1460:7: a4= BOOLEAN_LITERAL
                            {
                            a4=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleImplication1168); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 37));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 38));
                      			
                    }
                    a5=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleImplication1236); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_32, 39));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_33, 39));
                      			
                    }
                    // Rolestext.g:1512:4: ( ( (a6= BOOLEAN_LITERAL ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==BOOLEAN_LITERAL) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // Rolestext.g:1513:5: ( (a6= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:1513:5: ( (a6= BOOLEAN_LITERAL ) )
                            // Rolestext.g:1514:6: (a6= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:1514:6: (a6= BOOLEAN_LITERAL )
                            // Rolestext.g:1515:7: a6= BOOLEAN_LITERAL
                            {
                            a6=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleImplication1277); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_33, 40));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_33, 41));
                      			
                    }
                    a7=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleImplication1345); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 42));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 43));
              	
            }
            a8=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_RoleImplication1378); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 44, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 44, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 44, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 44, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 44));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_refactoring_roles_RoleImplication_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_roles_RoleImplication"


    // $ANTLR start "parse_org_emftext_language_refactoring_roles_RoleAssociation"
    // Rolestext.g:1591:1: parse_org_emftext_language_refactoring_roles_RoleAssociation returns [org.emftext.language.refactoring.roles.RoleAssociation element = null] : (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '--' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' ) )? a12= ';' ;
    public final org.emftext.language.refactoring.roles.RoleAssociation parse_org_emftext_language_refactoring_roles_RoleAssociation() throws RecognitionException {
        org.emftext.language.refactoring.roles.RoleAssociation element =  null;
        int parse_org_emftext_language_refactoring_roles_RoleAssociation_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        org.emftext.language.refactoring.roles.Multiplicity a2_0 = null;

        org.emftext.language.refactoring.roles.Multiplicity a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Rolestext.g:1594:1: ( (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '--' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' ) )? a12= ';' )
            // Rolestext.g:1595:2: (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '--' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' ) )? a12= ';'
            {
            // Rolestext.g:1595:2: (a0= IDENTIFIER )
            // Rolestext.g:1596:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1411); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_34, 45));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 45, FEATURE_2));
              	
            }
            // Rolestext.g:1633:2: ( (a1= IDENTIFIER ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IDENTIFIER) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Rolestext.g:1634:3: (a1= IDENTIFIER )
                    {
                    // Rolestext.g:1634:3: (a1= IDENTIFIER )
                    // Rolestext.g:1635:4: a1= IDENTIFIER
                    {
                    a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1441); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 46, FEATURE_2));
              	
            }
            // Rolestext.g:1668:2: (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity )
            // Rolestext.g:1669:3: a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1475);
            a2_0=parse_org_emftext_language_refactoring_roles_Multiplicity();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_36, 47));
              	
            }
            a3=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1493); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_37, 48));
              	
            }
            // Rolestext.g:1702:2: (a4= IDENTIFIER )
            // Rolestext.g:1703:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1511); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_38, 49));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 49, FEATURE_3));
              	
            }
            // Rolestext.g:1740:2: ( (a5= IDENTIFIER ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENTIFIER) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Rolestext.g:1741:3: (a5= IDENTIFIER )
                    {
                    // Rolestext.g:1741:3: (a5= IDENTIFIER )
                    // Rolestext.g:1742:4: a5= IDENTIFIER
                    {
                    a5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1541); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 50, FEATURE_3));
              	
            }
            // Rolestext.g:1775:2: (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity )
            // Rolestext.g:1776:3: a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1575);
            a6_0=parse_org_emftext_language_refactoring_roles_Multiplicity();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_39, 51));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_40, 51));
              	
            }
            // Rolestext.g:1798:2: ( (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==15) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Rolestext.g:1799:3: (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' )
                    {
                    // Rolestext.g:1799:3: (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' )
                    // Rolestext.g:1800:4: a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')'
                    {
                    a7=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1602); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_41, 52));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_42, 52));
                      			
                    }
                    // Rolestext.g:1813:4: ( ( (a8= BOOLEAN_LITERAL ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==BOOLEAN_LITERAL) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // Rolestext.g:1814:5: ( (a8= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:1814:5: ( (a8= BOOLEAN_LITERAL ) )
                            // Rolestext.g:1815:6: (a8= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:1815:6: (a8= BOOLEAN_LITERAL )
                            // Rolestext.g:1816:7: a8= BOOLEAN_LITERAL
                            {
                            a8=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1643); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_42, 53));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_42, 54));
                      			
                    }
                    a9=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1711); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_43, 55));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_44, 55));
                      			
                    }
                    // Rolestext.g:1868:4: ( ( (a10= BOOLEAN_LITERAL ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==BOOLEAN_LITERAL) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // Rolestext.g:1869:5: ( (a10= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:1869:5: ( (a10= BOOLEAN_LITERAL ) )
                            // Rolestext.g:1870:6: (a10= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:1870:6: (a10= BOOLEAN_LITERAL )
                            // Rolestext.g:1871:7: a10= BOOLEAN_LITERAL
                            {
                            a10=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1752); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_44, 56));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_44, 57));
                      			
                    }
                    a11=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1820); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_40, 58));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_40, 59));
              	
            }
            a12=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1853); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 60, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 60, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 60, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 60, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 60));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_refactoring_roles_RoleAssociation_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_roles_RoleAssociation"


    // $ANTLR start "parse_org_emftext_language_refactoring_roles_RoleComposition"
    // Rolestext.g:1947:1: parse_org_emftext_language_refactoring_roles_RoleComposition returns [org.emftext.language.refactoring.roles.RoleComposition element = null] : (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '<>-' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' ) )? a12= ';' ;
    public final org.emftext.language.refactoring.roles.RoleComposition parse_org_emftext_language_refactoring_roles_RoleComposition() throws RecognitionException {
        org.emftext.language.refactoring.roles.RoleComposition element =  null;
        int parse_org_emftext_language_refactoring_roles_RoleComposition_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        org.emftext.language.refactoring.roles.Multiplicity a2_0 = null;

        org.emftext.language.refactoring.roles.Multiplicity a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Rolestext.g:1950:1: ( (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '<>-' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' ) )? a12= ';' )
            // Rolestext.g:1951:2: (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '<>-' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' ) )? a12= ';'
            {
            // Rolestext.g:1951:2: (a0= IDENTIFIER )
            // Rolestext.g:1952:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1886); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_45, 61));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 61, FEATURE_2));
              	
            }
            // Rolestext.g:1989:2: ( (a1= IDENTIFIER ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDENTIFIER) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Rolestext.g:1990:3: (a1= IDENTIFIER )
                    {
                    // Rolestext.g:1990:3: (a1= IDENTIFIER )
                    // Rolestext.g:1991:4: a1= IDENTIFIER
                    {
                    a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1916); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 62, FEATURE_2));
              	
            }
            // Rolestext.g:2024:2: (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity )
            // Rolestext.g:2025:3: a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleComposition1950);
            a2_0=parse_org_emftext_language_refactoring_roles_Multiplicity();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_46, 63));
              	
            }
            a3=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_refactoring_roles_RoleComposition1968); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_47, 64));
              	
            }
            // Rolestext.g:2058:2: (a4= IDENTIFIER )
            // Rolestext.g:2059:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1986); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_48, 65));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 65, FEATURE_3));
              	
            }
            // Rolestext.g:2096:2: ( (a5= IDENTIFIER ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDENTIFIER) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Rolestext.g:2097:3: (a5= IDENTIFIER )
                    {
                    // Rolestext.g:2097:3: (a5= IDENTIFIER )
                    // Rolestext.g:2098:4: a5= IDENTIFIER
                    {
                    a5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition2016); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 66, FEATURE_3));
              	
            }
            // Rolestext.g:2131:2: (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity )
            // Rolestext.g:2132:3: a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleComposition2050);
            a6_0=parse_org_emftext_language_refactoring_roles_Multiplicity();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_49, 67));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_50, 67));
              	
            }
            // Rolestext.g:2154:2: ( (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==15) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Rolestext.g:2155:3: (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' )
                    {
                    // Rolestext.g:2155:3: (a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')' )
                    // Rolestext.g:2156:4: a7= '(' ( ( (a8= BOOLEAN_LITERAL ) ) )? a9= ',' ( ( (a10= BOOLEAN_LITERAL ) ) )? a11= ')'
                    {
                    a7=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleComposition2077); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_51, 68));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_52, 68));
                      			
                    }
                    // Rolestext.g:2169:4: ( ( (a8= BOOLEAN_LITERAL ) ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BOOLEAN_LITERAL) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // Rolestext.g:2170:5: ( (a8= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:2170:5: ( (a8= BOOLEAN_LITERAL ) )
                            // Rolestext.g:2171:6: (a8= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:2171:6: (a8= BOOLEAN_LITERAL )
                            // Rolestext.g:2172:7: a8= BOOLEAN_LITERAL
                            {
                            a8=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleComposition2118); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_52, 69));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_52, 70));
                      			
                    }
                    a9=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleComposition2186); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_53, 71));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_54, 71));
                      			
                    }
                    // Rolestext.g:2224:4: ( ( (a10= BOOLEAN_LITERAL ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==BOOLEAN_LITERAL) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // Rolestext.g:2225:5: ( (a10= BOOLEAN_LITERAL ) )
                            {
                            // Rolestext.g:2225:5: ( (a10= BOOLEAN_LITERAL ) )
                            // Rolestext.g:2226:6: (a10= BOOLEAN_LITERAL )
                            {
                            // Rolestext.g:2226:6: (a10= BOOLEAN_LITERAL )
                            // Rolestext.g:2227:7: a10= BOOLEAN_LITERAL
                            {
                            a10=(Token)match(input,BOOLEAN_LITERAL,FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleComposition2227); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_54, 72));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_54, 73));
                      			
                    }
                    a11=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleComposition2295); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_50, 74));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_50, 75));
              	
            }
            a12=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_RoleComposition2328); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 76, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 76, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 76, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 76, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 76));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_refactoring_roles_RoleComposition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_roles_RoleComposition"


    // $ANTLR start "parse_org_emftext_language_refactoring_roles_Multiplicity"
    // Rolestext.g:2303:1: parse_org_emftext_language_refactoring_roles_Multiplicity returns [org.emftext.language.refactoring.roles.Multiplicity element = null] : a0= '[' (a1= NUMBER ) a2= '..' (a3= NUMBER ) a4= ']' ;
    public final org.emftext.language.refactoring.roles.Multiplicity parse_org_emftext_language_refactoring_roles_Multiplicity() throws RecognitionException {
        org.emftext.language.refactoring.roles.Multiplicity element =  null;
        int parse_org_emftext_language_refactoring_roles_Multiplicity_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Rolestext.g:2306:1: (a0= '[' (a1= NUMBER ) a2= '..' (a3= NUMBER ) a4= ']' )
            // Rolestext.g:2307:2: a0= '[' (a1= NUMBER ) a2= '..' (a3= NUMBER ) a4= ']'
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_refactoring_roles_Multiplicity2357); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_55, 77));
              	
            }
            // Rolestext.g:2319:2: (a1= NUMBER )
            // Rolestext.g:2320:3: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_language_refactoring_roles_Multiplicity2375); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_56, 78));
              	
            }
            a2=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_refactoring_roles_Multiplicity2396); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_57, 79));
              	
            }
            // Rolestext.g:2364:2: (a3= NUMBER )
            // Rolestext.g:2365:3: a3= NUMBER
            {
            a3=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_language_refactoring_roles_Multiplicity2414); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_58, 80));
              	
            }
            a4=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_refactoring_roles_Multiplicity2435); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_36, 81));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_46, 81));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_refactoring_roles_Multiplicity_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_roles_Multiplicity"


    // $ANTLR start "parse_org_emftext_language_refactoring_roles_Relation"
    // Rolestext.g:2412:1: parse_org_emftext_language_refactoring_roles_Relation returns [org.emftext.language.refactoring.roles.Relation element = null] : (c0= parse_org_emftext_language_refactoring_roles_RoleProhibition | c1= parse_org_emftext_language_refactoring_roles_RoleImplication | c2= parse_org_emftext_language_refactoring_roles_RoleAssociation | c3= parse_org_emftext_language_refactoring_roles_RoleComposition );
    public final org.emftext.language.refactoring.roles.Relation parse_org_emftext_language_refactoring_roles_Relation() throws RecognitionException {
        org.emftext.language.refactoring.roles.Relation element =  null;
        int parse_org_emftext_language_refactoring_roles_Relation_StartIndex = input.index();
        org.emftext.language.refactoring.roles.RoleProhibition c0 = null;

        org.emftext.language.refactoring.roles.RoleImplication c1 = null;

        org.emftext.language.refactoring.roles.RoleAssociation c2 = null;

        org.emftext.language.refactoring.roles.RoleComposition c3 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Rolestext.g:2413:1: (c0= parse_org_emftext_language_refactoring_roles_RoleProhibition | c1= parse_org_emftext_language_refactoring_roles_RoleImplication | c2= parse_org_emftext_language_refactoring_roles_RoleAssociation | c3= parse_org_emftext_language_refactoring_roles_RoleComposition )
            int alt23=4;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // Rolestext.g:2414:2: c0= parse_org_emftext_language_refactoring_roles_RoleProhibition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_RoleProhibition_in_parse_org_emftext_language_refactoring_roles_Relation2460);
                    c0=parse_org_emftext_language_refactoring_roles_RoleProhibition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Rolestext.g:2415:4: c1= parse_org_emftext_language_refactoring_roles_RoleImplication
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_RoleImplication_in_parse_org_emftext_language_refactoring_roles_Relation2470);
                    c1=parse_org_emftext_language_refactoring_roles_RoleImplication();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Rolestext.g:2416:4: c2= parse_org_emftext_language_refactoring_roles_RoleAssociation
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_RoleAssociation_in_parse_org_emftext_language_refactoring_roles_Relation2480);
                    c2=parse_org_emftext_language_refactoring_roles_RoleAssociation();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 4 :
                    // Rolestext.g:2417:4: c3= parse_org_emftext_language_refactoring_roles_RoleComposition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_RoleComposition_in_parse_org_emftext_language_refactoring_roles_Relation2490);
                    c3=parse_org_emftext_language_refactoring_roles_RoleComposition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_refactoring_roles_Relation_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_refactoring_roles_Relation"

    // Delegated rules


    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA23_eotS =
        "\14\uffff";
    static final String DFA23_eofS =
        "\14\uffff";
    static final String DFA23_minS =
        "\2\4\1\27\1\6\2\uffff\1\30\1\6\1\31\1\25\2\uffff";
    static final String DFA23_maxS =
        "\1\4\2\27\1\6\2\uffff\1\30\1\6\1\31\1\26\2\uffff";
    static final String DFA23_acceptS =
        "\4\uffff\1\2\1\1\4\uffff\1\3\1\4";
    static final String DFA23_specialS =
        "\14\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1",
            "\1\2\16\uffff\1\5\1\4\2\uffff\1\3",
            "\1\3",
            "\1\6",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12\1\13",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "2412:1: parse_org_emftext_language_refactoring_roles_Relation returns [org.emftext.language.refactoring.roles.Relation element = null] : (c0= parse_org_emftext_language_refactoring_roles_RoleProhibition | c1= parse_org_emftext_language_refactoring_roles_RoleImplication | c2= parse_org_emftext_language_refactoring_roles_RoleAssociation | c3= parse_org_emftext_language_refactoring_roles_RoleComposition );";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_parse_org_emftext_language_refactoring_roles_RoleModel112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleModel130 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_refactoring_roles_RoleModel151 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Role_in_parse_org_emftext_language_refactoring_roles_RoleModel174 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Relation_in_parse_org_emftext_language_refactoring_roles_RoleModel209 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_refactoring_roles_RoleModel235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_refactoring_roles_Role264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_Role282 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_Role312 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_Role353 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_Role421 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_Role462 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_Role530 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_Role571 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_Role639 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_Role672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleProhibition705 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleProhibition726 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleProhibition744 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleProhibition774 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleProhibition815 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleProhibition883 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleProhibition924 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleProhibition992 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_RoleProhibition1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleImplication1058 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleImplication1079 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleImplication1097 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleImplication1127 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleImplication1168 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleImplication1236 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleImplication1277 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleImplication1345 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_RoleImplication1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1411 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1441 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1475 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1493 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1511 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1541 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1575 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1602 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1643 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1711 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1752 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1820 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1886 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1916 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleComposition1950 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_refactoring_roles_RoleComposition1968 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1986 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition2016 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleComposition2050 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleComposition2077 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleComposition2118 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleComposition2186 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_BOOLEAN_LITERAL_in_parse_org_emftext_language_refactoring_roles_RoleComposition2227 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleComposition2295 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_RoleComposition2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_refactoring_roles_Multiplicity2357 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_language_refactoring_roles_Multiplicity2375 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_refactoring_roles_Multiplicity2396 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_language_refactoring_roles_Multiplicity2414 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_refactoring_roles_Multiplicity2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleProhibition_in_parse_org_emftext_language_refactoring_roles_Relation2460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleImplication_in_parse_org_emftext_language_refactoring_roles_Relation2470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleAssociation_in_parse_org_emftext_language_refactoring_roles_Relation2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleComposition_in_parse_org_emftext_language_refactoring_roles_Relation2490 = new BitSet(new long[]{0x0000000000000002L});

}