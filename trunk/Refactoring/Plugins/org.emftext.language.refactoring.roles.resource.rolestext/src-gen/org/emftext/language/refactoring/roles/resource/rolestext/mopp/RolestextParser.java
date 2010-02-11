// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.refactoring.roles.resource.rolestext.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
public class RolestextParser extends RolestextANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "OPTIONAL", "INPUT", "RUNTIME", "TRANSITIVE", "REFLEXIVE", "NUMBER", "SL_COMMENT", "ML_COMMENT", "WHITESPACE", "LINEBREAKS", "'RoleModel'", "'{'", "'}'", "'role'", "'('", "')'", "';'", "'|-|'", "'->'", "'--'", "'<>-'", "'['", "'..'", "']'"
    };
    public static final int TRANSITIVE=8;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int NUMBER=10;
    public static final int INPUT=6;
    public static final int WHITESPACE=13;
    public static final int LINEBREAKS=14;
    public static final int EOF=-1;
    public static final int OPTIONAL=5;
    public static final int RUNTIME=7;
    public static final int ML_COMMENT=12;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int IDENTIFIER=4;
    public static final int SL_COMMENT=11;
    public static final int REFLEXIVE=9;

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
    		int followSetID = 76;
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
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_12 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__OPTIONAL), "OPTIONAL");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_13 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INPUT), "INPUT");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_14 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__SELECT_ON_RUNTIME), "RUNTIME");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_15 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(), ")");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_16 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), "|-|");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_17 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TARGET), "IDENTIFIER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_18 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), "(");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_19 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), ";");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_20 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TRANSITIVE), "TRANSITIVE");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_21 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__REFLEXIVE), "REFLEXIVE");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_22 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(), ")");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_23 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), "->");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_24 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TARGET), "IDENTIFIER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_25 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), "(");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_26 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), ";");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_27 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TRANSITIVE), "TRANSITIVE");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_28 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__REFLEXIVE), "REFLEXIVE");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_29 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(), ")");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_30 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_NAME), "IDENTIFIER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_31 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), "[");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_32 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), "--");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_33 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET), "IDENTIFIER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_34 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_NAME), "IDENTIFIER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_35 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), "(");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_36 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), ";");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_37 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TRANSITIVE), "TRANSITIVE");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_38 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__REFLEXIVE), "REFLEXIVE");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_39 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(), ")");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_40 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_NAME), "IDENTIFIER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_41 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), "<>-");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_42 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET), "IDENTIFIER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_43 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_NAME), "IDENTIFIER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_44 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), "(");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_45 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), ";");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_46 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TRANSITIVE), "TRANSITIVE");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_47 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__REFLEXIVE), "REFLEXIVE");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_48 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(), ")");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_49 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__LOWER_BOUND), "NUMBER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_50 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), "..");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_51 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__UPPER_BOUND), "NUMBER");
    	private final static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement TERMINAL_52 = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedCsString(org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(), "]");
    	
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
    		TERMINAL_10.addFollower(TERMINAL_14, EMPTY_FEATURE_ARRAY);
    		TERMINAL_10.addFollower(TERMINAL_15, EMPTY_FEATURE_ARRAY);
    		TERMINAL_12.addFollower(TERMINAL_13, EMPTY_FEATURE_ARRAY);
    		TERMINAL_12.addFollower(TERMINAL_14, EMPTY_FEATURE_ARRAY);
    		TERMINAL_12.addFollower(TERMINAL_15, EMPTY_FEATURE_ARRAY);
    		TERMINAL_13.addFollower(TERMINAL_14, EMPTY_FEATURE_ARRAY);
    		TERMINAL_13.addFollower(TERMINAL_15, EMPTY_FEATURE_ARRAY);
    		TERMINAL_14.addFollower(TERMINAL_15, EMPTY_FEATURE_ARRAY);
    		TERMINAL_15.addFollower(TERMINAL_11, EMPTY_FEATURE_ARRAY);
    		TERMINAL_11.addFollower(TERMINAL_3, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
    		TERMINAL_11.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_11.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_11.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_11.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_11.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
    		TERMINAL_4.addFollower(TERMINAL_16, EMPTY_FEATURE_ARRAY);
    		TERMINAL_16.addFollower(TERMINAL_17, EMPTY_FEATURE_ARRAY);
    		TERMINAL_17.addFollower(TERMINAL_18, EMPTY_FEATURE_ARRAY);
    		TERMINAL_17.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_18.addFollower(TERMINAL_20, EMPTY_FEATURE_ARRAY);
    		TERMINAL_18.addFollower(TERMINAL_21, EMPTY_FEATURE_ARRAY);
    		TERMINAL_18.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_20.addFollower(TERMINAL_21, EMPTY_FEATURE_ARRAY);
    		TERMINAL_20.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_21.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_22.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_19.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_19.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_19.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_19.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_19.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
    		TERMINAL_5.addFollower(TERMINAL_23, EMPTY_FEATURE_ARRAY);
    		TERMINAL_23.addFollower(TERMINAL_24, EMPTY_FEATURE_ARRAY);
    		TERMINAL_24.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_24.addFollower(TERMINAL_26, EMPTY_FEATURE_ARRAY);
    		TERMINAL_25.addFollower(TERMINAL_27, EMPTY_FEATURE_ARRAY);
    		TERMINAL_25.addFollower(TERMINAL_28, EMPTY_FEATURE_ARRAY);
    		TERMINAL_25.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_27.addFollower(TERMINAL_28, EMPTY_FEATURE_ARRAY);
    		TERMINAL_27.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_28.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_29.addFollower(TERMINAL_26, EMPTY_FEATURE_ARRAY);
    		TERMINAL_26.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_26.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_26.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_26.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_26.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
    		TERMINAL_6.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_6.addFollower(TERMINAL_31, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_30.addFollower(TERMINAL_31, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_32.addFollower(TERMINAL_33, EMPTY_FEATURE_ARRAY);
    		TERMINAL_33.addFollower(TERMINAL_34, EMPTY_FEATURE_ARRAY);
    		TERMINAL_33.addFollower(TERMINAL_31, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
    		TERMINAL_34.addFollower(TERMINAL_31, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
    		TERMINAL_35.addFollower(TERMINAL_37, EMPTY_FEATURE_ARRAY);
    		TERMINAL_35.addFollower(TERMINAL_38, EMPTY_FEATURE_ARRAY);
    		TERMINAL_35.addFollower(TERMINAL_39, EMPTY_FEATURE_ARRAY);
    		TERMINAL_37.addFollower(TERMINAL_38, EMPTY_FEATURE_ARRAY);
    		TERMINAL_37.addFollower(TERMINAL_39, EMPTY_FEATURE_ARRAY);
    		TERMINAL_38.addFollower(TERMINAL_39, EMPTY_FEATURE_ARRAY);
    		TERMINAL_39.addFollower(TERMINAL_36, EMPTY_FEATURE_ARRAY);
    		TERMINAL_36.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_36.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_36.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_36.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_36.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
    		TERMINAL_7.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
    		TERMINAL_7.addFollower(TERMINAL_31, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_40.addFollower(TERMINAL_31, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_41.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
    		TERMINAL_42.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
    		TERMINAL_42.addFollower(TERMINAL_31, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
    		TERMINAL_43.addFollower(TERMINAL_31, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
    		TERMINAL_44.addFollower(TERMINAL_46, EMPTY_FEATURE_ARRAY);
    		TERMINAL_44.addFollower(TERMINAL_47, EMPTY_FEATURE_ARRAY);
    		TERMINAL_44.addFollower(TERMINAL_48, EMPTY_FEATURE_ARRAY);
    		TERMINAL_46.addFollower(TERMINAL_47, EMPTY_FEATURE_ARRAY);
    		TERMINAL_46.addFollower(TERMINAL_48, EMPTY_FEATURE_ARRAY);
    		TERMINAL_47.addFollower(TERMINAL_48, EMPTY_FEATURE_ARRAY);
    		TERMINAL_48.addFollower(TERMINAL_45, EMPTY_FEATURE_ARRAY);
    		TERMINAL_45.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_45.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_45.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_45.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_45.addFollower(TERMINAL_8, EMPTY_FEATURE_ARRAY);
    		TERMINAL_31.addFollower(TERMINAL_49, EMPTY_FEATURE_ARRAY);
    		TERMINAL_49.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
    		TERMINAL_50.addFollower(TERMINAL_51, EMPTY_FEATURE_ARRAY);
    		TERMINAL_51.addFollower(TERMINAL_52, EMPTY_FEATURE_ARRAY);
    		TERMINAL_52.addFollower(TERMINAL_32, EMPTY_FEATURE_ARRAY);
    		TERMINAL_52.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
    	}
    	// wire the terminals
    	static {
    		wire0();
    	}



    // $ANTLR start "start"
    // Rolestext.g:702:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_refactoring_roles_RoleModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.language.refactoring.roles.RoleModel c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Rolestext.g:703:1: ( (c0= parse_org_emftext_language_refactoring_roles_RoleModel ) EOF )
            // Rolestext.g:704:2: (c0= parse_org_emftext_language_refactoring_roles_RoleModel ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_0, 0));
              		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
              	
            }
            // Rolestext.g:709:2: (c0= parse_org_emftext_language_refactoring_roles_RoleModel )
            // Rolestext.g:710:3: c0= parse_org_emftext_language_refactoring_roles_RoleModel
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
    // Rolestext.g:715:1: parse_org_emftext_language_refactoring_roles_RoleModel returns [org.emftext.language.refactoring.roles.RoleModel element = null] : a0= 'RoleModel' (a1= IDENTIFIER ) a2= '{' ( (a3_0= parse_org_emftext_language_refactoring_roles_Role ) )* ( (a4_0= parse_org_emftext_language_refactoring_roles_Relation ) )* a5= '}' ;
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
            // Rolestext.g:718:1: (a0= 'RoleModel' (a1= IDENTIFIER ) a2= '{' ( (a3_0= parse_org_emftext_language_refactoring_roles_Role ) )* ( (a4_0= parse_org_emftext_language_refactoring_roles_Relation ) )* a5= '}' )
            // Rolestext.g:719:2: a0= 'RoleModel' (a1= IDENTIFIER ) a2= '{' ( (a3_0= parse_org_emftext_language_refactoring_roles_Role ) )* ( (a4_0= parse_org_emftext_language_refactoring_roles_Relation ) )* a5= '}'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleModel112); if (state.failed) return element;
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
            // Rolestext.g:731:2: (a1= IDENTIFIER )
            // Rolestext.g:732:3: a1= IDENTIFIER
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
            a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleModel151); if (state.failed) return element;
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
            // Rolestext.g:781:2: ( (a3_0= parse_org_emftext_language_refactoring_roles_Role ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Rolestext.g:782:3: (a3_0= parse_org_emftext_language_refactoring_roles_Role )
            	    {
            	    // Rolestext.g:782:3: (a3_0= parse_org_emftext_language_refactoring_roles_Role )
            	    // Rolestext.g:783:4: a3_0= parse_org_emftext_language_refactoring_roles_Role
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
            // Rolestext.g:810:2: ( (a4_0= parse_org_emftext_language_refactoring_roles_Relation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENTIFIER) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Rolestext.g:811:3: (a4_0= parse_org_emftext_language_refactoring_roles_Relation )
            	    {
            	    // Rolestext.g:811:3: (a4_0= parse_org_emftext_language_refactoring_roles_Relation )
            	    // Rolestext.g:812:4: a4_0= parse_org_emftext_language_refactoring_roles_Relation
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
            a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleModel235); if (state.failed) return element;
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
    // Rolestext.g:851:1: parse_org_emftext_language_refactoring_roles_Role returns [org.emftext.language.refactoring.roles.Role element = null] : a0= 'role' (a1= IDENTIFIER ) ( (a2= '(' ( ( (a3= OPTIONAL ) ) )? ( ( (a4= INPUT ) ) )? ( ( (a5= RUNTIME ) ) )? a6= ')' ) )? a7= ';' ;
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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Rolestext.g:854:1: (a0= 'role' (a1= IDENTIFIER ) ( (a2= '(' ( ( (a3= OPTIONAL ) ) )? ( ( (a4= INPUT ) ) )? ( ( (a5= RUNTIME ) ) )? a6= ')' ) )? a7= ';' )
            // Rolestext.g:855:2: a0= 'role' (a1= IDENTIFIER ) ( (a2= '(' ( ( (a3= OPTIONAL ) ) )? ( ( (a4= INPUT ) ) )? ( ( (a5= RUNTIME ) ) )? a6= ')' ) )? a7= ';'
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_Role264); if (state.failed) return element;
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
            // Rolestext.g:867:2: (a1= IDENTIFIER )
            // Rolestext.g:868:3: a1= IDENTIFIER
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
            // Rolestext.g:901:2: ( (a2= '(' ( ( (a3= OPTIONAL ) ) )? ( ( (a4= INPUT ) ) )? ( ( (a5= RUNTIME ) ) )? a6= ')' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Rolestext.g:902:3: (a2= '(' ( ( (a3= OPTIONAL ) ) )? ( ( (a4= INPUT ) ) )? ( ( (a5= RUNTIME ) ) )? a6= ')' )
                    {
                    // Rolestext.g:902:3: (a2= '(' ( ( (a3= OPTIONAL ) ) )? ( ( (a4= INPUT ) ) )? ( ( (a5= RUNTIME ) ) )? a6= ')' )
                    // Rolestext.g:903:4: a2= '(' ( ( (a3= OPTIONAL ) ) )? ( ( (a4= INPUT ) ) )? ( ( (a5= RUNTIME ) ) )? a6= ')'
                    {
                    a2=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_Role312); if (state.failed) return element;
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
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_14, 9));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 9));
                      			
                    }
                    // Rolestext.g:918:4: ( ( (a3= OPTIONAL ) ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==OPTIONAL) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // Rolestext.g:919:5: ( (a3= OPTIONAL ) )
                            {
                            // Rolestext.g:919:5: ( (a3= OPTIONAL ) )
                            // Rolestext.g:920:6: (a3= OPTIONAL )
                            {
                            // Rolestext.g:920:6: (a3= OPTIONAL )
                            // Rolestext.g:921:7: a3= OPTIONAL
                            {
                            a3=(Token)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_parse_org_emftext_language_refactoring_roles_Role353); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
                              							}
                              							if (a3 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("OPTIONAL");
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
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_14, 10));
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 10));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_13, 11));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_14, 11));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 11));
                      			
                    }
                    // Rolestext.g:964:4: ( ( (a4= INPUT ) ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==INPUT) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // Rolestext.g:965:5: ( (a4= INPUT ) )
                            {
                            // Rolestext.g:965:5: ( (a4= INPUT ) )
                            // Rolestext.g:966:6: (a4= INPUT )
                            {
                            // Rolestext.g:966:6: (a4= INPUT )
                            // Rolestext.g:967:7: a4= INPUT
                            {
                            a4=(Token)match(input,INPUT,FOLLOW_INPUT_in_parse_org_emftext_language_refactoring_roles_Role442); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
                              							}
                              							if (a4 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INPUT");
                              								tokenResolver.setOptions(getOptions());
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
                              								tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INPUT), result);
                              								java.lang.Object resolvedObject = result.getResolvedToken();
                              								if (resolvedObject == null) {
                              									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
                              								}
                              								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
                              								if (resolved != null) {
                              									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INPUT), resolved);
                              									completedElement(resolved);
                              								}
                              								collectHiddenTokens(element);
                              								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
                              							}
                              						
                            }

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_14, 12));
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 12));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_14, 13));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 13));
                      			
                    }
                    // Rolestext.g:1008:4: ( ( (a5= RUNTIME ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==RUNTIME) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // Rolestext.g:1009:5: ( (a5= RUNTIME ) )
                            {
                            // Rolestext.g:1009:5: ( (a5= RUNTIME ) )
                            // Rolestext.g:1010:6: (a5= RUNTIME )
                            {
                            // Rolestext.g:1010:6: (a5= RUNTIME )
                            // Rolestext.g:1011:7: a5= RUNTIME
                            {
                            a5=(Token)match(input,RUNTIME,FOLLOW_RUNTIME_in_parse_org_emftext_language_refactoring_roles_Role531); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
                              							}
                              							if (a5 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("RUNTIME");
                              								tokenResolver.setOptions(getOptions());
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
                              								tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__SELECT_ON_RUNTIME), result);
                              								java.lang.Object resolvedObject = result.getResolvedToken();
                              								if (resolvedObject == null) {
                              									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
                              								}
                              								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
                              								if (resolved != null) {
                              									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__SELECT_ON_RUNTIME), resolved);
                              									completedElement(resolved);
                              								}
                              								collectHiddenTokens(element);
                              								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
                              							}
                              						
                            }

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 14));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_15, 15));
                      			
                    }
                    a6=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_Role599); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_11, 16));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_11, 17));
              	
            }
            a7=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_Role632); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_3, 18, FEATURE_0));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 18, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 18, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 18, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 18, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 18));
              	
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
    // Rolestext.g:1088:1: parse_org_emftext_language_refactoring_roles_RoleProhibition returns [org.emftext.language.refactoring.roles.RoleProhibition element = null] : (a0= IDENTIFIER ) a1= '|-|' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' ) )? a7= ';' ;
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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Rolestext.g:1091:1: ( (a0= IDENTIFIER ) a1= '|-|' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' ) )? a7= ';' )
            // Rolestext.g:1092:2: (a0= IDENTIFIER ) a1= '|-|' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' ) )? a7= ';'
            {
            // Rolestext.g:1092:2: (a0= IDENTIFIER )
            // Rolestext.g:1093:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleProhibition665); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_16, 19));
              	
            }
            a1=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_refactoring_roles_RoleProhibition686); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_17, 20));
              	
            }
            // Rolestext.g:1141:2: (a2= IDENTIFIER )
            // Rolestext.g:1142:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleProhibition704); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_18, 21));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_19, 21));
              	
            }
            // Rolestext.g:1179:2: ( (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Rolestext.g:1180:3: (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' )
                    {
                    // Rolestext.g:1180:3: (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' )
                    // Rolestext.g:1181:4: a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')'
                    {
                    a3=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleProhibition734); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_20, 22));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_21, 22));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_22, 22));
                      			
                    }
                    // Rolestext.g:1195:4: ( ( (a4= TRANSITIVE ) ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==TRANSITIVE) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Rolestext.g:1196:5: ( (a4= TRANSITIVE ) )
                            {
                            // Rolestext.g:1196:5: ( (a4= TRANSITIVE ) )
                            // Rolestext.g:1197:6: (a4= TRANSITIVE )
                            {
                            // Rolestext.g:1197:6: (a4= TRANSITIVE )
                            // Rolestext.g:1198:7: a4= TRANSITIVE
                            {
                            a4=(Token)match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_parse_org_emftext_language_refactoring_roles_RoleProhibition775); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
                              							}
                              							if (a4 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TRANSITIVE");
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
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_21, 23));
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_22, 23));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_21, 24));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_22, 24));
                      			
                    }
                    // Rolestext.g:1239:4: ( ( (a5= REFLEXIVE ) ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==REFLEXIVE) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // Rolestext.g:1240:5: ( (a5= REFLEXIVE ) )
                            {
                            // Rolestext.g:1240:5: ( (a5= REFLEXIVE ) )
                            // Rolestext.g:1241:6: (a5= REFLEXIVE )
                            {
                            // Rolestext.g:1241:6: (a5= REFLEXIVE )
                            // Rolestext.g:1242:7: a5= REFLEXIVE
                            {
                            a5=(Token)match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_parse_org_emftext_language_refactoring_roles_RoleProhibition864); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
                              							}
                              							if (a5 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("REFLEXIVE");
                              								tokenResolver.setOptions(getOptions());
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
                              								tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__REFLEXIVE), result);
                              								java.lang.Object resolvedObject = result.getResolvedToken();
                              								if (resolvedObject == null) {
                              									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
                              								}
                              								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
                              								if (resolved != null) {
                              									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__REFLEXIVE), resolved);
                              									completedElement(resolved);
                              								}
                              								collectHiddenTokens(element);
                              								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
                              							}
                              						
                            }

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_22, 25));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_22, 26));
                      			
                    }
                    a6=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleProhibition932); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_19, 27));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_19, 28));
              	
            }
            a7=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleProhibition965); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleProhibition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 29, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 29, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 29, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 29, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 29));
              	
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
    // Rolestext.g:1318:1: parse_org_emftext_language_refactoring_roles_RoleImplication returns [org.emftext.language.refactoring.roles.RoleImplication element = null] : (a0= IDENTIFIER ) a1= '->' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' ) )? a7= ';' ;
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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Rolestext.g:1321:1: ( (a0= IDENTIFIER ) a1= '->' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' ) )? a7= ';' )
            // Rolestext.g:1322:2: (a0= IDENTIFIER ) a1= '->' (a2= IDENTIFIER ) ( (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' ) )? a7= ';'
            {
            // Rolestext.g:1322:2: (a0= IDENTIFIER )
            // Rolestext.g:1323:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleImplication998); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_23, 30));
              	
            }
            a1=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_refactoring_roles_RoleImplication1019); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_24, 31));
              	
            }
            // Rolestext.g:1371:2: (a2= IDENTIFIER )
            // Rolestext.g:1372:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleImplication1037); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_25, 32));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_26, 32));
              	
            }
            // Rolestext.g:1409:2: ( (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Rolestext.g:1410:3: (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' )
                    {
                    // Rolestext.g:1410:3: (a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')' )
                    // Rolestext.g:1411:4: a3= '(' ( ( (a4= TRANSITIVE ) ) )? ( ( (a5= REFLEXIVE ) ) )? a6= ')'
                    {
                    a3=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleImplication1067); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_27, 33));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_28, 33));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 33));
                      			
                    }
                    // Rolestext.g:1425:4: ( ( (a4= TRANSITIVE ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==TRANSITIVE) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // Rolestext.g:1426:5: ( (a4= TRANSITIVE ) )
                            {
                            // Rolestext.g:1426:5: ( (a4= TRANSITIVE ) )
                            // Rolestext.g:1427:6: (a4= TRANSITIVE )
                            {
                            // Rolestext.g:1427:6: (a4= TRANSITIVE )
                            // Rolestext.g:1428:7: a4= TRANSITIVE
                            {
                            a4=(Token)match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_parse_org_emftext_language_refactoring_roles_RoleImplication1108); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
                              							}
                              							if (a4 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TRANSITIVE");
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
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_28, 34));
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 34));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_28, 35));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 35));
                      			
                    }
                    // Rolestext.g:1469:4: ( ( (a5= REFLEXIVE ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==REFLEXIVE) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // Rolestext.g:1470:5: ( (a5= REFLEXIVE ) )
                            {
                            // Rolestext.g:1470:5: ( (a5= REFLEXIVE ) )
                            // Rolestext.g:1471:6: (a5= REFLEXIVE )
                            {
                            // Rolestext.g:1471:6: (a5= REFLEXIVE )
                            // Rolestext.g:1472:7: a5= REFLEXIVE
                            {
                            a5=(Token)match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_parse_org_emftext_language_refactoring_roles_RoleImplication1197); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
                              							}
                              							if (a5 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("REFLEXIVE");
                              								tokenResolver.setOptions(getOptions());
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
                              								tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__REFLEXIVE), result);
                              								java.lang.Object resolvedObject = result.getResolvedToken();
                              								if (resolvedObject == null) {
                              									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
                              								}
                              								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
                              								if (resolved != null) {
                              									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__REFLEXIVE), resolved);
                              									completedElement(resolved);
                              								}
                              								collectHiddenTokens(element);
                              								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
                              							}
                              						
                            }

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 36));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_29, 37));
                      			
                    }
                    a6=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleImplication1265); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_26, 38));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_26, 39));
              	
            }
            a7=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleImplication1298); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleImplication();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 40, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 40, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 40, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 40, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 40));
              	
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
    // Rolestext.g:1548:1: parse_org_emftext_language_refactoring_roles_RoleAssociation returns [org.emftext.language.refactoring.roles.RoleAssociation element = null] : (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '--' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' ) )? a11= ';' ;
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
        org.emftext.language.refactoring.roles.Multiplicity a2_0 = null;

        org.emftext.language.refactoring.roles.Multiplicity a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Rolestext.g:1551:1: ( (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '--' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' ) )? a11= ';' )
            // Rolestext.g:1552:2: (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '--' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' ) )? a11= ';'
            {
            // Rolestext.g:1552:2: (a0= IDENTIFIER )
            // Rolestext.g:1553:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1331); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_30, 41));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 41, FEATURE_2));
              	
            }
            // Rolestext.g:1590:2: ( (a1= IDENTIFIER ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IDENTIFIER) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Rolestext.g:1591:3: (a1= IDENTIFIER )
                    {
                    // Rolestext.g:1591:3: (a1= IDENTIFIER )
                    // Rolestext.g:1592:4: a1= IDENTIFIER
                    {
                    a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1361); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 42, FEATURE_2));
              	
            }
            // Rolestext.g:1625:2: (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity )
            // Rolestext.g:1626:3: a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1395);
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_32, 43));
              	
            }
            a3=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1413); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_33, 44));
              	
            }
            // Rolestext.g:1659:2: (a4= IDENTIFIER )
            // Rolestext.g:1660:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1431); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_34, 45));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 45, FEATURE_3));
              	
            }
            // Rolestext.g:1697:2: ( (a5= IDENTIFIER ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENTIFIER) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Rolestext.g:1698:3: (a5= IDENTIFIER )
                    {
                    // Rolestext.g:1698:3: (a5= IDENTIFIER )
                    // Rolestext.g:1699:4: a5= IDENTIFIER
                    {
                    a5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1461); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 46, FEATURE_3));
              	
            }
            // Rolestext.g:1732:2: (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity )
            // Rolestext.g:1733:3: a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1495);
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_35, 47));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_36, 47));
              	
            }
            // Rolestext.g:1755:2: ( (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==19) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Rolestext.g:1756:3: (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' )
                    {
                    // Rolestext.g:1756:3: (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' )
                    // Rolestext.g:1757:4: a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')'
                    {
                    a7=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1522); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_37, 48));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_38, 48));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_39, 48));
                      			
                    }
                    // Rolestext.g:1771:4: ( ( (a8= TRANSITIVE ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==TRANSITIVE) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // Rolestext.g:1772:5: ( (a8= TRANSITIVE ) )
                            {
                            // Rolestext.g:1772:5: ( (a8= TRANSITIVE ) )
                            // Rolestext.g:1773:6: (a8= TRANSITIVE )
                            {
                            // Rolestext.g:1773:6: (a8= TRANSITIVE )
                            // Rolestext.g:1774:7: a8= TRANSITIVE
                            {
                            a8=(Token)match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1563); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
                              							}
                              							if (a8 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TRANSITIVE");
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
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_38, 49));
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_39, 49));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_38, 50));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_39, 50));
                      			
                    }
                    // Rolestext.g:1815:4: ( ( (a9= REFLEXIVE ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==REFLEXIVE) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // Rolestext.g:1816:5: ( (a9= REFLEXIVE ) )
                            {
                            // Rolestext.g:1816:5: ( (a9= REFLEXIVE ) )
                            // Rolestext.g:1817:6: (a9= REFLEXIVE )
                            {
                            // Rolestext.g:1817:6: (a9= REFLEXIVE )
                            // Rolestext.g:1818:7: a9= REFLEXIVE
                            {
                            a9=(Token)match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1652); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
                              							}
                              							if (a9 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("REFLEXIVE");
                              								tokenResolver.setOptions(getOptions());
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
                              								tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__REFLEXIVE), result);
                              								java.lang.Object resolvedObject = result.getResolvedToken();
                              								if (resolvedObject == null) {
                              									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStopIndex());
                              								}
                              								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
                              								if (resolved != null) {
                              									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__REFLEXIVE), resolved);
                              									completedElement(resolved);
                              								}
                              								collectHiddenTokens(element);
                              								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, element);
                              							}
                              						
                            }

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_39, 51));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_39, 52));
                      			
                    }
                    a10=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1720); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_36, 53));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_36, 54));
              	
            }
            a11=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1753); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleAssociation();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 55, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 55, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 55, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 55, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 55));
              	
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
    // Rolestext.g:1894:1: parse_org_emftext_language_refactoring_roles_RoleComposition returns [org.emftext.language.refactoring.roles.RoleComposition element = null] : (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '<>-' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' ) )? a11= ';' ;
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
        org.emftext.language.refactoring.roles.Multiplicity a2_0 = null;

        org.emftext.language.refactoring.roles.Multiplicity a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Rolestext.g:1897:1: ( (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '<>-' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' ) )? a11= ';' )
            // Rolestext.g:1898:2: (a0= IDENTIFIER ) ( (a1= IDENTIFIER ) )? (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) a3= '<>-' (a4= IDENTIFIER ) ( (a5= IDENTIFIER ) )? (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity ) ( (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' ) )? a11= ';'
            {
            // Rolestext.g:1898:2: (a0= IDENTIFIER )
            // Rolestext.g:1899:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1786); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_40, 56));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 56, FEATURE_2));
              	
            }
            // Rolestext.g:1936:2: ( (a1= IDENTIFIER ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDENTIFIER) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Rolestext.g:1937:3: (a1= IDENTIFIER )
                    {
                    // Rolestext.g:1937:3: (a1= IDENTIFIER )
                    // Rolestext.g:1938:4: a1= IDENTIFIER
                    {
                    a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1816); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 57, FEATURE_2));
              	
            }
            // Rolestext.g:1971:2: (a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity )
            // Rolestext.g:1972:3: a2_0= parse_org_emftext_language_refactoring_roles_Multiplicity
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleComposition1850);
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_41, 58));
              	
            }
            a3=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_refactoring_roles_RoleComposition1868); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_42, 59));
              	
            }
            // Rolestext.g:2005:2: (a4= IDENTIFIER )
            // Rolestext.g:2006:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1886); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_43, 60));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 60, FEATURE_3));
              	
            }
            // Rolestext.g:2043:2: ( (a5= IDENTIFIER ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDENTIFIER) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Rolestext.g:2044:3: (a5= IDENTIFIER )
                    {
                    // Rolestext.g:2044:3: (a5= IDENTIFIER )
                    // Rolestext.g:2045:4: a5= IDENTIFIER
                    {
                    a5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1916); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_31, 61, FEATURE_3));
              	
            }
            // Rolestext.g:2078:2: (a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity )
            // Rolestext.g:2079:3: a6_0= parse_org_emftext_language_refactoring_roles_Multiplicity
            {
            pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleComposition1950);
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_44, 62));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_45, 62));
              	
            }
            // Rolestext.g:2101:2: ( (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Rolestext.g:2102:3: (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' )
                    {
                    // Rolestext.g:2102:3: (a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')' )
                    // Rolestext.g:2103:4: a7= '(' ( ( (a8= TRANSITIVE ) ) )? ( ( (a9= REFLEXIVE ) ) )? a10= ')'
                    {
                    a7=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleComposition1977); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_46, 63));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_47, 63));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_48, 63));
                      			
                    }
                    // Rolestext.g:2117:4: ( ( (a8= TRANSITIVE ) ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==TRANSITIVE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // Rolestext.g:2118:5: ( (a8= TRANSITIVE ) )
                            {
                            // Rolestext.g:2118:5: ( (a8= TRANSITIVE ) )
                            // Rolestext.g:2119:6: (a8= TRANSITIVE )
                            {
                            // Rolestext.g:2119:6: (a8= TRANSITIVE )
                            // Rolestext.g:2120:7: a8= TRANSITIVE
                            {
                            a8=(Token)match(input,TRANSITIVE,FOLLOW_TRANSITIVE_in_parse_org_emftext_language_refactoring_roles_RoleComposition2018); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
                              							}
                              							if (a8 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TRANSITIVE");
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
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_47, 64));
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_48, 64));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_47, 65));
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_48, 65));
                      			
                    }
                    // Rolestext.g:2161:4: ( ( (a9= REFLEXIVE ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==REFLEXIVE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // Rolestext.g:2162:5: ( (a9= REFLEXIVE ) )
                            {
                            // Rolestext.g:2162:5: ( (a9= REFLEXIVE ) )
                            // Rolestext.g:2163:6: (a9= REFLEXIVE )
                            {
                            // Rolestext.g:2163:6: (a9= REFLEXIVE )
                            // Rolestext.g:2164:7: a9= REFLEXIVE
                            {
                            a9=(Token)match(input,REFLEXIVE,FOLLOW_REFLEXIVE_in_parse_org_emftext_language_refactoring_roles_RoleComposition2107); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
                              							}
                              							if (a9 != null) {
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("REFLEXIVE");
                              								tokenResolver.setOptions(getOptions());
                              								org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result = getFreshTokenResolveResult();
                              								tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__REFLEXIVE), result);
                              								java.lang.Object resolvedObject = result.getResolvedToken();
                              								if (resolvedObject == null) {
                              									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStopIndex());
                              								}
                              								java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
                              								if (resolved != null) {
                              									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__REFLEXIVE), resolved);
                              									completedElement(resolved);
                              								}
                              								collectHiddenTokens(element);
                              								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, element);
                              							}
                              						
                            }

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_48, 66));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_48, 67));
                      			
                    }
                    a10=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleComposition2175); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_45, 68));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_45, 69));
              	
            }
            a11=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleComposition2208); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleComposition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_4, 70, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_5, 70, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_6, 70, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_7, 70, FEATURE_1));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_8, 70));
              	
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
    // Rolestext.g:2240:1: parse_org_emftext_language_refactoring_roles_Multiplicity returns [org.emftext.language.refactoring.roles.Multiplicity element = null] : a0= '[' (a1= NUMBER ) a2= '..' (a3= NUMBER ) a4= ']' ;
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
            // Rolestext.g:2243:1: (a0= '[' (a1= NUMBER ) a2= '..' (a3= NUMBER ) a4= ']' )
            // Rolestext.g:2244:2: a0= '[' (a1= NUMBER ) a2= '..' (a3= NUMBER ) a4= ']'
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_language_refactoring_roles_Multiplicity2237); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_49, 71));
              	
            }
            // Rolestext.g:2256:2: (a1= NUMBER )
            // Rolestext.g:2257:3: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_language_refactoring_roles_Multiplicity2255); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_50, 72));
              	
            }
            a2=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_language_refactoring_roles_Multiplicity2276); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_51, 73));
              	
            }
            // Rolestext.g:2301:2: (a3= NUMBER )
            // Rolestext.g:2302:3: a3= NUMBER
            {
            a3=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_language_refactoring_roles_Multiplicity2294); if (state.failed) return element;
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
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_52, 74));
              	
            }
            a4=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_refactoring_roles_Multiplicity2315); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createMultiplicity();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_32, 75));
              		addExpectedElement(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextExpectedTerminal(TERMINAL_41, 75));
              	
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
    // Rolestext.g:2349:1: parse_org_emftext_language_refactoring_roles_Relation returns [org.emftext.language.refactoring.roles.Relation element = null] : (c0= parse_org_emftext_language_refactoring_roles_RoleProhibition | c1= parse_org_emftext_language_refactoring_roles_RoleImplication | c2= parse_org_emftext_language_refactoring_roles_RoleAssociation | c3= parse_org_emftext_language_refactoring_roles_RoleComposition );
    public final org.emftext.language.refactoring.roles.Relation parse_org_emftext_language_refactoring_roles_Relation() throws RecognitionException {
        org.emftext.language.refactoring.roles.Relation element =  null;
        int parse_org_emftext_language_refactoring_roles_Relation_StartIndex = input.index();
        org.emftext.language.refactoring.roles.RoleProhibition c0 = null;

        org.emftext.language.refactoring.roles.RoleImplication c1 = null;

        org.emftext.language.refactoring.roles.RoleAssociation c2 = null;

        org.emftext.language.refactoring.roles.RoleComposition c3 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Rolestext.g:2350:1: (c0= parse_org_emftext_language_refactoring_roles_RoleProhibition | c1= parse_org_emftext_language_refactoring_roles_RoleImplication | c2= parse_org_emftext_language_refactoring_roles_RoleAssociation | c3= parse_org_emftext_language_refactoring_roles_RoleComposition )
            int alt23=4;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // Rolestext.g:2351:2: c0= parse_org_emftext_language_refactoring_roles_RoleProhibition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_RoleProhibition_in_parse_org_emftext_language_refactoring_roles_Relation2340);
                    c0=parse_org_emftext_language_refactoring_roles_RoleProhibition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Rolestext.g:2352:4: c1= parse_org_emftext_language_refactoring_roles_RoleImplication
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_RoleImplication_in_parse_org_emftext_language_refactoring_roles_Relation2350);
                    c1=parse_org_emftext_language_refactoring_roles_RoleImplication();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Rolestext.g:2353:4: c2= parse_org_emftext_language_refactoring_roles_RoleAssociation
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_RoleAssociation_in_parse_org_emftext_language_refactoring_roles_Relation2360);
                    c2=parse_org_emftext_language_refactoring_roles_RoleAssociation();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 4 :
                    // Rolestext.g:2354:4: c3= parse_org_emftext_language_refactoring_roles_RoleComposition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_refactoring_roles_RoleComposition_in_parse_org_emftext_language_refactoring_roles_Relation2370);
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
        "\2\4\1\uffff\1\32\1\12\1\uffff\1\33\1\12\1\34\1\30\2\uffff";
    static final String DFA23_maxS =
        "\1\4\1\32\1\uffff\1\32\1\12\1\uffff\1\33\1\12\1\34\1\31\2\uffff";
    static final String DFA23_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\4\uffff\1\3\1\4";
    static final String DFA23_specialS =
        "\14\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1",
            "\1\3\21\uffff\1\5\1\2\2\uffff\1\4",
            "",
            "\1\4",
            "\1\6",
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
            return "2349:1: parse_org_emftext_language_refactoring_roles_Relation returns [org.emftext.language.refactoring.roles.Relation element = null] : (c0= parse_org_emftext_language_refactoring_roles_RoleProhibition | c1= parse_org_emftext_language_refactoring_roles_RoleImplication | c2= parse_org_emftext_language_refactoring_roles_RoleAssociation | c3= parse_org_emftext_language_refactoring_roles_RoleComposition );";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_refactoring_roles_RoleModel112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleModel130 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_refactoring_roles_RoleModel151 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Role_in_parse_org_emftext_language_refactoring_roles_RoleModel174 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Relation_in_parse_org_emftext_language_refactoring_roles_RoleModel209 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_refactoring_roles_RoleModel235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_refactoring_roles_Role264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_Role282 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_Role312 = new BitSet(new long[]{0x00000000001000E0L});
    public static final BitSet FOLLOW_OPTIONAL_in_parse_org_emftext_language_refactoring_roles_Role353 = new BitSet(new long[]{0x00000000001000C0L});
    public static final BitSet FOLLOW_INPUT_in_parse_org_emftext_language_refactoring_roles_Role442 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_RUNTIME_in_parse_org_emftext_language_refactoring_roles_Role531 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_Role599 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_Role632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleProhibition665 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_refactoring_roles_RoleProhibition686 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleProhibition704 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleProhibition734 = new BitSet(new long[]{0x0000000000100300L});
    public static final BitSet FOLLOW_TRANSITIVE_in_parse_org_emftext_language_refactoring_roles_RoleProhibition775 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_REFLEXIVE_in_parse_org_emftext_language_refactoring_roles_RoleProhibition864 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleProhibition932 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleProhibition965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleImplication998 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_refactoring_roles_RoleImplication1019 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleImplication1037 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleImplication1067 = new BitSet(new long[]{0x0000000000100300L});
    public static final BitSet FOLLOW_TRANSITIVE_in_parse_org_emftext_language_refactoring_roles_RoleImplication1108 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_REFLEXIVE_in_parse_org_emftext_language_refactoring_roles_RoleImplication1197 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleImplication1265 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleImplication1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1331 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1361 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1395 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1413 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1431 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1461 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1495 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1522 = new BitSet(new long[]{0x0000000000100300L});
    public static final BitSet FOLLOW_TRANSITIVE_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1563 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_REFLEXIVE_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1652 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1720 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleAssociation1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1786 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1816 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleComposition1850 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_refactoring_roles_RoleComposition1868 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1886 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_refactoring_roles_RoleComposition1916 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_Multiplicity_in_parse_org_emftext_language_refactoring_roles_RoleComposition1950 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_refactoring_roles_RoleComposition1977 = new BitSet(new long[]{0x0000000000100300L});
    public static final BitSet FOLLOW_TRANSITIVE_in_parse_org_emftext_language_refactoring_roles_RoleComposition2018 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_REFLEXIVE_in_parse_org_emftext_language_refactoring_roles_RoleComposition2107 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_refactoring_roles_RoleComposition2175 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_refactoring_roles_RoleComposition2208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_language_refactoring_roles_Multiplicity2237 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_language_refactoring_roles_Multiplicity2255 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_language_refactoring_roles_Multiplicity2276 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_language_refactoring_roles_Multiplicity2294 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_refactoring_roles_Multiplicity2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleProhibition_in_parse_org_emftext_language_refactoring_roles_Relation2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleImplication_in_parse_org_emftext_language_refactoring_roles_Relation2350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleAssociation_in_parse_org_emftext_language_refactoring_roles_Relation2360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_refactoring_roles_RoleComposition_in_parse_org_emftext_language_refactoring_roles_Relation2370 = new BitSet(new long[]{0x0000000000000002L});

}