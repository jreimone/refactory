// $ANTLR 3.4

	package org.modelrefactoring.guery.resource.guery.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GueryParser extends GueryANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CARDINALITY", "CLASSNAME", "IDENTIFIER", "LINEBREAK", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "'('", "')'", "','", "'>'", "'['", "']'", "'and'", "'connected by'", "'find all'", "'group by'", "'motif'", "'not connected by'", "'prepare with'", "'select'", "'where'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int CARDINALITY=4;
    public static final int CLASSNAME=5;
    public static final int IDENTIFIER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_34_34=8;
    public static final int SL_COMMENT=9;
    public static final int WHITESPACE=10;

    // delegates
    public GueryANTLRParserBase[] getDelegates() {
        return new GueryANTLRParserBase[] {};
    }

    // delegators


    public GueryParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public GueryParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(29 + 1);
         

    }

    public String[] getTokenNames() { return GueryParser.tokenNames; }
    public String getGrammarFileName() { return "Guery.g"; }


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
    	



    // $ANTLR start "start"
    // Guery.g:483:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_modelrefactoring_guery_MotifModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.modelrefactoring.guery.MotifModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Guery.g:484:2: ( (c0= parse_org_modelrefactoring_guery_MotifModel ) EOF )
            // Guery.g:485:2: (c0= parse_org_modelrefactoring_guery_MotifModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Guery.g:490:2: (c0= parse_org_modelrefactoring_guery_MotifModel )
            // Guery.g:491:3: c0= parse_org_modelrefactoring_guery_MotifModel
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_guery_MotifModel_in_start82);
            c0=parse_org_modelrefactoring_guery_MotifModel();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_org_modelrefactoring_guery_MotifModel"
    // Guery.g:499:1: parse_org_modelrefactoring_guery_MotifModel returns [org.modelrefactoring.guery.MotifModel element = null] : (a0_0= parse_org_modelrefactoring_guery_Motif ) ( ( (a1_0= parse_org_modelrefactoring_guery_Motif ) ) )* ;
    public final org.modelrefactoring.guery.MotifModel parse_org_modelrefactoring_guery_MotifModel() throws RecognitionException {
        org.modelrefactoring.guery.MotifModel element =  null;

        int parse_org_modelrefactoring_guery_MotifModel_StartIndex = input.index();

        org.modelrefactoring.guery.Motif a0_0 =null;

        org.modelrefactoring.guery.Motif a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Guery.g:502:2: ( (a0_0= parse_org_modelrefactoring_guery_Motif ) ( ( (a1_0= parse_org_modelrefactoring_guery_Motif ) ) )* )
            // Guery.g:503:2: (a0_0= parse_org_modelrefactoring_guery_Motif ) ( ( (a1_0= parse_org_modelrefactoring_guery_Motif ) ) )*
            {
            // Guery.g:503:2: (a0_0= parse_org_modelrefactoring_guery_Motif )
            // Guery.g:504:3: a0_0= parse_org_modelrefactoring_guery_Motif
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Motif_in_parse_org_modelrefactoring_guery_MotifModel119);
            a0_0=parse_org_modelrefactoring_guery_Motif();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[1]);
            	}

            // Guery.g:529:2: ( ( (a1_0= parse_org_modelrefactoring_guery_Motif ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==21) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Guery.g:530:3: ( (a1_0= parse_org_modelrefactoring_guery_Motif ) )
            	    {
            	    // Guery.g:530:3: ( (a1_0= parse_org_modelrefactoring_guery_Motif ) )
            	    // Guery.g:531:4: (a1_0= parse_org_modelrefactoring_guery_Motif )
            	    {
            	    // Guery.g:531:4: (a1_0= parse_org_modelrefactoring_guery_Motif )
            	    // Guery.g:532:5: a1_0= parse_org_modelrefactoring_guery_Motif
            	    {
            	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Motif_in_parse_org_modelrefactoring_guery_MotifModel152);
            	    a1_0=parse_org_modelrefactoring_guery_Motif();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[2]);
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
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[3]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_modelrefactoring_guery_MotifModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_MotifModel"



    // $ANTLR start "parse_org_modelrefactoring_guery_Motif"
    // Guery.g:566:1: parse_org_modelrefactoring_guery_Motif returns [org.modelrefactoring.guery.Motif element = null] : a0= 'motif' (a1= IDENTIFIER ) ( (a2_0= parse_org_modelrefactoring_guery_PreProcessor ) )* (a3_0= parse_org_modelrefactoring_guery_VertexSelection ) ( (a4_0= parse_org_modelrefactoring_guery_EdgeSelection ) )* ( (a5_0= parse_org_modelrefactoring_guery_Grouping ) )* ;
    public final org.modelrefactoring.guery.Motif parse_org_modelrefactoring_guery_Motif() throws RecognitionException {
        org.modelrefactoring.guery.Motif element =  null;

        int parse_org_modelrefactoring_guery_Motif_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        org.modelrefactoring.guery.PreProcessor a2_0 =null;

        org.modelrefactoring.guery.VertexSelection a3_0 =null;

        org.modelrefactoring.guery.EdgeSelection a4_0 =null;

        org.modelrefactoring.guery.Grouping a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Guery.g:569:2: (a0= 'motif' (a1= IDENTIFIER ) ( (a2_0= parse_org_modelrefactoring_guery_PreProcessor ) )* (a3_0= parse_org_modelrefactoring_guery_VertexSelection ) ( (a4_0= parse_org_modelrefactoring_guery_EdgeSelection ) )* ( (a5_0= parse_org_modelrefactoring_guery_Grouping ) )* )
            // Guery.g:570:2: a0= 'motif' (a1= IDENTIFIER ) ( (a2_0= parse_org_modelrefactoring_guery_PreProcessor ) )* (a3_0= parse_org_modelrefactoring_guery_VertexSelection ) ( (a4_0= parse_org_modelrefactoring_guery_EdgeSelection ) )* ( (a5_0= parse_org_modelrefactoring_guery_Grouping ) )*
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_org_modelrefactoring_guery_Motif208); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createMotif();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[4]);
            	}

            // Guery.g:584:2: (a1= IDENTIFIER )
            // Guery.g:585:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Motif226); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[6]);
            	}

            // Guery.g:621:2: ( (a2_0= parse_org_modelrefactoring_guery_PreProcessor ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==23) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Guery.g:622:3: (a2_0= parse_org_modelrefactoring_guery_PreProcessor )
            	    {
            	    // Guery.g:622:3: (a2_0= parse_org_modelrefactoring_guery_PreProcessor )
            	    // Guery.g:623:4: a2_0= parse_org_modelrefactoring_guery_PreProcessor
            	    {
            	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_PreProcessor_in_parse_org_modelrefactoring_guery_Motif256);
            	    a2_0=parse_org_modelrefactoring_guery_PreProcessor();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[8]);
            	}

            // Guery.g:650:2: (a3_0= parse_org_modelrefactoring_guery_VertexSelection )
            // Guery.g:651:3: a3_0= parse_org_modelrefactoring_guery_VertexSelection
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_guery_VertexSelection_in_parse_org_modelrefactoring_guery_Motif286);
            a3_0=parse_org_modelrefactoring_guery_VertexSelection();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[12]);
            	}

            // Guery.g:679:2: ( (a4_0= parse_org_modelrefactoring_guery_EdgeSelection ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18||LA3_0==22) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Guery.g:680:3: (a4_0= parse_org_modelrefactoring_guery_EdgeSelection )
            	    {
            	    // Guery.g:680:3: (a4_0= parse_org_modelrefactoring_guery_EdgeSelection )
            	    // Guery.g:681:4: a4_0= parse_org_modelrefactoring_guery_EdgeSelection
            	    {
            	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_EdgeSelection_in_parse_org_modelrefactoring_guery_Motif313);
            	    a4_0=parse_org_modelrefactoring_guery_EdgeSelection();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[15]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[16]);
            	}

            // Guery.g:710:2: ( (a5_0= parse_org_modelrefactoring_guery_Grouping ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Guery.g:711:3: (a5_0= parse_org_modelrefactoring_guery_Grouping )
            	    {
            	    // Guery.g:711:3: (a5_0= parse_org_modelrefactoring_guery_Grouping )
            	    // Guery.g:712:4: a5_0= parse_org_modelrefactoring_guery_Grouping
            	    {
            	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Grouping_in_parse_org_modelrefactoring_guery_Motif348);
            	    a5_0=parse_org_modelrefactoring_guery_Grouping();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[18]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_modelrefactoring_guery_Motif_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_Motif"



    // $ANTLR start "parse_org_modelrefactoring_guery_PreProcessor"
    // Guery.g:741:1: parse_org_modelrefactoring_guery_PreProcessor returns [org.modelrefactoring.guery.PreProcessor element = null] : a0= 'prepare with' (a1= CLASSNAME ) ;
    public final org.modelrefactoring.guery.PreProcessor parse_org_modelrefactoring_guery_PreProcessor() throws RecognitionException {
        org.modelrefactoring.guery.PreProcessor element =  null;

        int parse_org_modelrefactoring_guery_PreProcessor_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Guery.g:744:2: (a0= 'prepare with' (a1= CLASSNAME ) )
            // Guery.g:745:2: a0= 'prepare with' (a1= CLASSNAME )
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_org_modelrefactoring_guery_PreProcessor389); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createPreProcessor();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[19]);
            	}

            // Guery.g:759:2: (a1= CLASSNAME )
            // Guery.g:760:3: a1= CLASSNAME
            {
            a1=(Token)match(input,CLASSNAME,FOLLOW_CLASSNAME_in_parse_org_modelrefactoring_guery_PreProcessor407); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[21]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_modelrefactoring_guery_PreProcessor_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_PreProcessor"



    // $ANTLR start "parse_org_modelrefactoring_guery_VertexSelection"
    // Guery.g:798:1: parse_org_modelrefactoring_guery_VertexSelection returns [org.modelrefactoring.guery.VertexSelection element = null] : a0= 'select' (a1_0= parse_org_modelrefactoring_guery_Role ) ( (a2= ',' (a3_0= parse_org_modelrefactoring_guery_Role ) ) )* ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )? ;
    public final org.modelrefactoring.guery.VertexSelection parse_org_modelrefactoring_guery_VertexSelection() throws RecognitionException {
        org.modelrefactoring.guery.VertexSelection element =  null;

        int parse_org_modelrefactoring_guery_VertexSelection_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        org.modelrefactoring.guery.Role a1_0 =null;

        org.modelrefactoring.guery.Role a3_0 =null;

        org.modelrefactoring.guery.Constraint a5_0 =null;

        org.modelrefactoring.guery.Constraint a7_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Guery.g:801:2: (a0= 'select' (a1_0= parse_org_modelrefactoring_guery_Role ) ( (a2= ',' (a3_0= parse_org_modelrefactoring_guery_Role ) ) )* ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )? )
            // Guery.g:802:2: a0= 'select' (a1_0= parse_org_modelrefactoring_guery_Role ) ( (a2= ',' (a3_0= parse_org_modelrefactoring_guery_Role ) ) )* ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )?
            {
            a0=(Token)match(input,24,FOLLOW_24_in_parse_org_modelrefactoring_guery_VertexSelection443); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[22]);
            	}

            // Guery.g:816:2: (a1_0= parse_org_modelrefactoring_guery_Role )
            // Guery.g:817:3: a1_0= parse_org_modelrefactoring_guery_Role
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Role_in_parse_org_modelrefactoring_guery_VertexSelection461);
            a1_0=parse_org_modelrefactoring_guery_Role();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[23]);
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[28]);
            	}

            // Guery.g:847:2: ( (a2= ',' (a3_0= parse_org_modelrefactoring_guery_Role ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Guery.g:848:3: (a2= ',' (a3_0= parse_org_modelrefactoring_guery_Role ) )
            	    {
            	    // Guery.g:848:3: (a2= ',' (a3_0= parse_org_modelrefactoring_guery_Role ) )
            	    // Guery.g:849:4: a2= ',' (a3_0= parse_org_modelrefactoring_guery_Role )
            	    {
            	    a2=(Token)match(input,13,FOLLOW_13_in_parse_org_modelrefactoring_guery_VertexSelection488); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_3_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[29]);
            	    			}

            	    // Guery.g:863:4: (a3_0= parse_org_modelrefactoring_guery_Role )
            	    // Guery.g:864:5: a3_0= parse_org_modelrefactoring_guery_Role
            	    {
            	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Role_in_parse_org_modelrefactoring_guery_VertexSelection514);
            	    a3_0=parse_org_modelrefactoring_guery_Role();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[30]);
            	    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[31]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[32]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[33]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[34]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[35]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[36]);
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[39]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[40]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[41]);
            	}

            // Guery.g:906:2: ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Guery.g:907:3: (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* )
                    {
                    // Guery.g:907:3: (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* )
                    // Guery.g:908:4: a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )*
                    {
                    a4=(Token)match(input,25,FOLLOW_25_in_parse_org_modelrefactoring_guery_VertexSelection564); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[42]);
                    			}

                    // Guery.g:922:4: (a5_0= parse_org_modelrefactoring_guery_Constraint )
                    // Guery.g:923:5: a5_0= parse_org_modelrefactoring_guery_Constraint
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_VertexSelection590);
                    a5_0=parse_org_modelrefactoring_guery_Constraint();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[43]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[44]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[45]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[46]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[47]);
                    			}

                    // Guery.g:952:4: ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Guery.g:953:5: (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) )
                    	    {
                    	    // Guery.g:953:5: (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) )
                    	    // Guery.g:954:6: a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint )
                    	    {
                    	    a6=(Token)match(input,17,FOLLOW_17_in_parse_org_modelrefactoring_guery_VertexSelection631); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createVertexSelection();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4_0_0_3_0_0_1, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[48]);
                    	    					}

                    	    // Guery.g:968:6: (a7_0= parse_org_modelrefactoring_guery_Constraint )
                    	    // Guery.g:969:7: a7_0= parse_org_modelrefactoring_guery_Constraint
                    	    {
                    	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_VertexSelection665);
                    	    a7_0=parse_org_modelrefactoring_guery_Constraint();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[49]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[50]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[51]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[52]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[53]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[54]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[55]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[56]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[57]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[58]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[59]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[61]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[62]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_modelrefactoring_guery_VertexSelection_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_VertexSelection"



    // $ANTLR start "parse_org_modelrefactoring_guery_Role"
    // Guery.g:1021:1: parse_org_modelrefactoring_guery_Role returns [org.modelrefactoring.guery.Role element = null] : (a0= IDENTIFIER ) ;
    public final org.modelrefactoring.guery.Role parse_org_modelrefactoring_guery_Role() throws RecognitionException {
        org.modelrefactoring.guery.Role element =  null;

        int parse_org_modelrefactoring_guery_Role_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Guery.g:1024:2: ( (a0= IDENTIFIER ) )
            // Guery.g:1025:2: (a0= IDENTIFIER )
            {
            // Guery.g:1025:2: (a0= IDENTIFIER )
            // Guery.g:1026:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Role758); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[63]);
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[68]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_modelrefactoring_guery_Role_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_Role"



    // $ANTLR start "parse_org_modelrefactoring_guery_Constraint"
    // Guery.g:1068:1: parse_org_modelrefactoring_guery_Constraint returns [org.modelrefactoring.guery.Constraint element = null] : (a0= QUOTED_34_34 ) ;
    public final org.modelrefactoring.guery.Constraint parse_org_modelrefactoring_guery_Constraint() throws RecognitionException {
        org.modelrefactoring.guery.Constraint element =  null;

        int parse_org_modelrefactoring_guery_Constraint_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Guery.g:1071:2: ( (a0= QUOTED_34_34 ) )
            // Guery.g:1072:2: (a0= QUOTED_34_34 )
            {
            // Guery.g:1072:2: (a0= QUOTED_34_34 )
            // Guery.g:1073:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_modelrefactoring_guery_Constraint798); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_modelrefactoring_guery_Constraint_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_Constraint"



    // $ANTLR start "parse_org_modelrefactoring_guery_ConnectedBy"
    // Guery.g:1117:1: parse_org_modelrefactoring_guery_ConnectedBy returns [org.modelrefactoring.guery.ConnectedBy element = null] : a0= 'connected by' (a1_0= parse_org_modelrefactoring_guery_Connection ) ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) ) )* ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )? ;
    public final org.modelrefactoring.guery.ConnectedBy parse_org_modelrefactoring_guery_ConnectedBy() throws RecognitionException {
        org.modelrefactoring.guery.ConnectedBy element =  null;

        int parse_org_modelrefactoring_guery_ConnectedBy_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        org.modelrefactoring.guery.Connection a1_0 =null;

        org.modelrefactoring.guery.Connection a3_0 =null;

        org.modelrefactoring.guery.Constraint a5_0 =null;

        org.modelrefactoring.guery.Constraint a7_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Guery.g:1120:2: (a0= 'connected by' (a1_0= parse_org_modelrefactoring_guery_Connection ) ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) ) )* ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )? )
            // Guery.g:1121:2: a0= 'connected by' (a1_0= parse_org_modelrefactoring_guery_Connection ) ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) ) )* ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )?
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_org_modelrefactoring_guery_ConnectedBy834); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[77]);
            	}

            // Guery.g:1135:2: (a1_0= parse_org_modelrefactoring_guery_Connection )
            // Guery.g:1136:3: a1_0= parse_org_modelrefactoring_guery_Connection
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Connection_in_parse_org_modelrefactoring_guery_ConnectedBy852);
            a1_0=parse_org_modelrefactoring_guery_Connection();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[80]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[81]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[82]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[83]);
            	}

            // Guery.g:1166:2: ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Guery.g:1167:3: (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) )
            	    {
            	    // Guery.g:1167:3: (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) )
            	    // Guery.g:1168:4: a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection )
            	    {
            	    a2=(Token)match(input,17,FOLLOW_17_in_parse_org_modelrefactoring_guery_ConnectedBy879); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_4_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[84]);
            	    			}

            	    // Guery.g:1182:4: (a3_0= parse_org_modelrefactoring_guery_Connection )
            	    // Guery.g:1183:5: a3_0= parse_org_modelrefactoring_guery_Connection
            	    {
            	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Connection_in_parse_org_modelrefactoring_guery_ConnectedBy905);
            	    a3_0=parse_org_modelrefactoring_guery_Connection();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[85]);
            	    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[86]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[87]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[88]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[89]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[90]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[96]);
            	}

            // Guery.g:1225:2: ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Guery.g:1226:3: (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* )
                    {
                    // Guery.g:1226:3: (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* )
                    // Guery.g:1227:4: a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )*
                    {
                    a4=(Token)match(input,25,FOLLOW_25_in_parse_org_modelrefactoring_guery_ConnectedBy955); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[97]);
                    			}

                    // Guery.g:1241:4: (a5_0= parse_org_modelrefactoring_guery_Constraint )
                    // Guery.g:1242:5: a5_0= parse_org_modelrefactoring_guery_Constraint
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_ConnectedBy981);
                    a5_0=parse_org_modelrefactoring_guery_Constraint();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[98]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[99]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[100]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[101]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[102]);
                    			}

                    // Guery.g:1271:4: ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==17) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Guery.g:1272:5: (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) )
                    	    {
                    	    // Guery.g:1272:5: (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) )
                    	    // Guery.g:1273:6: a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint )
                    	    {
                    	    a6=(Token)match(input,17,FOLLOW_17_in_parse_org_modelrefactoring_guery_ConnectedBy1022); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createConnectedBy();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5_0_0_3_0_0_1, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[103]);
                    	    					}

                    	    // Guery.g:1287:6: (a7_0= parse_org_modelrefactoring_guery_Constraint )
                    	    // Guery.g:1288:7: a7_0= parse_org_modelrefactoring_guery_Constraint
                    	    {
                    	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_ConnectedBy1056);
                    	    a7_0=parse_org_modelrefactoring_guery_Constraint();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[104]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[105]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[106]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[107]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[108]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[109]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[110]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[111]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[112]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[113]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[115]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[116]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[117]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_modelrefactoring_guery_ConnectedBy_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_ConnectedBy"



    // $ANTLR start "parse_org_modelrefactoring_guery_NotConnectedBy"
    // Guery.g:1340:1: parse_org_modelrefactoring_guery_NotConnectedBy returns [org.modelrefactoring.guery.NotConnectedBy element = null] : a0= 'not connected by' (a1_0= parse_org_modelrefactoring_guery_Connection ) ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) ) )* ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )? ;
    public final org.modelrefactoring.guery.NotConnectedBy parse_org_modelrefactoring_guery_NotConnectedBy() throws RecognitionException {
        org.modelrefactoring.guery.NotConnectedBy element =  null;

        int parse_org_modelrefactoring_guery_NotConnectedBy_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        org.modelrefactoring.guery.Connection a1_0 =null;

        org.modelrefactoring.guery.Connection a3_0 =null;

        org.modelrefactoring.guery.Constraint a5_0 =null;

        org.modelrefactoring.guery.Constraint a7_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Guery.g:1343:2: (a0= 'not connected by' (a1_0= parse_org_modelrefactoring_guery_Connection ) ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) ) )* ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )? )
            // Guery.g:1344:2: a0= 'not connected by' (a1_0= parse_org_modelrefactoring_guery_Connection ) ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) ) )* ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )?
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_org_modelrefactoring_guery_NotConnectedBy1145); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[118]);
            	}

            // Guery.g:1358:2: (a1_0= parse_org_modelrefactoring_guery_Connection )
            // Guery.g:1359:3: a1_0= parse_org_modelrefactoring_guery_Connection
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Connection_in_parse_org_modelrefactoring_guery_NotConnectedBy1163);
            a1_0=parse_org_modelrefactoring_guery_Connection();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[119]);
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[120]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[122]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[124]);
            	}

            // Guery.g:1389:2: ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==17) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Guery.g:1390:3: (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) )
            	    {
            	    // Guery.g:1390:3: (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection ) )
            	    // Guery.g:1391:4: a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Connection )
            	    {
            	    a2=(Token)match(input,17,FOLLOW_17_in_parse_org_modelrefactoring_guery_NotConnectedBy1190); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_4_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[125]);
            	    			}

            	    // Guery.g:1405:4: (a3_0= parse_org_modelrefactoring_guery_Connection )
            	    // Guery.g:1406:5: a3_0= parse_org_modelrefactoring_guery_Connection
            	    {
            	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Connection_in_parse_org_modelrefactoring_guery_NotConnectedBy1216);
            	    a3_0=parse_org_modelrefactoring_guery_Connection();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[126]);
            	    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[127]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[128]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[129]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[130]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[131]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[137]);
            	}

            // Guery.g:1448:2: ( (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Guery.g:1449:3: (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* )
                    {
                    // Guery.g:1449:3: (a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )* )
                    // Guery.g:1450:4: a4= 'where' (a5_0= parse_org_modelrefactoring_guery_Constraint ) ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )*
                    {
                    a4=(Token)match(input,25,FOLLOW_25_in_parse_org_modelrefactoring_guery_NotConnectedBy1266); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[138]);
                    			}

                    // Guery.g:1464:4: (a5_0= parse_org_modelrefactoring_guery_Constraint )
                    // Guery.g:1465:5: a5_0= parse_org_modelrefactoring_guery_Constraint
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_NotConnectedBy1292);
                    a5_0=parse_org_modelrefactoring_guery_Constraint();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[139]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[140]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[141]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[142]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[143]);
                    			}

                    // Guery.g:1494:4: ( (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==17) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Guery.g:1495:5: (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) )
                    	    {
                    	    // Guery.g:1495:5: (a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint ) )
                    	    // Guery.g:1496:6: a6= 'and' (a7_0= parse_org_modelrefactoring_guery_Constraint )
                    	    {
                    	    a6=(Token)match(input,17,FOLLOW_17_in_parse_org_modelrefactoring_guery_NotConnectedBy1333); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_3_0_0_1, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[144]);
                    	    					}

                    	    // Guery.g:1510:6: (a7_0= parse_org_modelrefactoring_guery_Constraint )
                    	    // Guery.g:1511:7: a7_0= parse_org_modelrefactoring_guery_Constraint
                    	    {
                    	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_NotConnectedBy1367);
                    	    a7_0=parse_org_modelrefactoring_guery_Constraint();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[145]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[146]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[147]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[148]);
                    	    						addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[149]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[150]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[151]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[152]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[153]);
                    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[154]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[155]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[156]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[157]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[158]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_modelrefactoring_guery_NotConnectedBy_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_NotConnectedBy"



    // $ANTLR start "parse_org_modelrefactoring_guery_Connection"
    // Guery.g:1563:1: parse_org_modelrefactoring_guery_Connection returns [org.modelrefactoring.guery.Connection element = null] : (a0= IDENTIFIER ) a1= '(' (a2= IDENTIFIER ) a3= '>' (a4= IDENTIFIER ) a5= ')' ( (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' ) )? ( (a11= 'find all' )? ) ;
    public final org.modelrefactoring.guery.Connection parse_org_modelrefactoring_guery_Connection() throws RecognitionException {
        org.modelrefactoring.guery.Connection element =  null;

        int parse_org_modelrefactoring_guery_Connection_StartIndex = input.index();

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
        Token a10=null;
        Token a11=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Guery.g:1566:2: ( (a0= IDENTIFIER ) a1= '(' (a2= IDENTIFIER ) a3= '>' (a4= IDENTIFIER ) a5= ')' ( (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' ) )? ( (a11= 'find all' )? ) )
            // Guery.g:1567:2: (a0= IDENTIFIER ) a1= '(' (a2= IDENTIFIER ) a3= '>' (a4= IDENTIFIER ) a5= ')' ( (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' ) )? ( (a11= 'find all' )? )
            {
            // Guery.g:1567:2: (a0= IDENTIFIER )
            // Guery.g:1568:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Connection1460); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[159]);
            	}

            a1=(Token)match(input,11,FOLLOW_11_in_parse_org_modelrefactoring_guery_Connection1481); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[160]);
            	}

            // Guery.g:1627:2: (a2= IDENTIFIER )
            // Guery.g:1628:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Connection1499); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[161]);
            	}

            a3=(Token)match(input,14,FOLLOW_14_in_parse_org_modelrefactoring_guery_Connection1520); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[162]);
            	}

            // Guery.g:1691:2: (a4= IDENTIFIER )
            // Guery.g:1692:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Connection1538); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[163]);
            	}

            a5=(Token)match(input,12,FOLLOW_12_in_parse_org_modelrefactoring_guery_Connection1559); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
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

            // Guery.g:1764:2: ( (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==15) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Guery.g:1765:3: (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' )
                    {
                    // Guery.g:1765:3: (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' )
                    // Guery.g:1766:4: a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']'
                    {
                    a6=(Token)match(input,15,FOLLOW_15_in_parse_org_modelrefactoring_guery_Connection1582); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[174]);
                    			}

                    // Guery.g:1785:4: (a7= CARDINALITY )
                    // Guery.g:1786:5: a7= CARDINALITY
                    {
                    a7=(Token)match(input,CARDINALITY,FOLLOW_CARDINALITY_in_parse_org_modelrefactoring_guery_Connection1608); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[175]);
                    			}

                    a8=(Token)match(input,13,FOLLOW_13_in_parse_org_modelrefactoring_guery_Connection1641); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[176]);
                    			}

                    // Guery.g:1845:4: (a9= CARDINALITY )
                    // Guery.g:1846:5: a9= CARDINALITY
                    {
                    a9=(Token)match(input,CARDINALITY,FOLLOW_CARDINALITY_in_parse_org_modelrefactoring_guery_Connection1667); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[177]);
                    			}

                    a10=(Token)match(input,16,FOLLOW_16_in_parse_org_modelrefactoring_guery_Connection1700); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
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

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
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

            // Guery.g:1928:2: ( (a11= 'find all' )? )
            // Guery.g:1929:3: (a11= 'find all' )?
            {
            // Guery.g:1929:3: (a11= 'find all' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==19) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // Guery.g:1930:4: a11= 'find all'
                    {
                    a11=(Token)match(input,19,FOLLOW_19_in_parse_org_modelrefactoring_guery_Connection1742); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_modelrefactoring_guery_Connection_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_Connection"



    // $ANTLR start "parse_org_modelrefactoring_guery_Grouping"
    // Guery.g:1963:1: parse_org_modelrefactoring_guery_Grouping returns [org.modelrefactoring.guery.Grouping element = null] : a0= 'group by' (a1_0= parse_org_modelrefactoring_guery_Constraint ) ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Constraint ) ) )* ;
    public final org.modelrefactoring.guery.Grouping parse_org_modelrefactoring_guery_Grouping() throws RecognitionException {
        org.modelrefactoring.guery.Grouping element =  null;

        int parse_org_modelrefactoring_guery_Grouping_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        org.modelrefactoring.guery.Constraint a1_0 =null;

        org.modelrefactoring.guery.Constraint a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Guery.g:1966:2: (a0= 'group by' (a1_0= parse_org_modelrefactoring_guery_Constraint ) ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Constraint ) ) )* )
            // Guery.g:1967:2: a0= 'group by' (a1_0= parse_org_modelrefactoring_guery_Constraint ) ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Constraint ) ) )*
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_org_modelrefactoring_guery_Grouping1778); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createGrouping();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[204]);
            	}

            // Guery.g:1981:2: (a1_0= parse_org_modelrefactoring_guery_Constraint )
            // Guery.g:1982:3: a1_0= parse_org_modelrefactoring_guery_Constraint
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_Grouping1796);
            a1_0=parse_org_modelrefactoring_guery_Constraint();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[205]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[206]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[207]);
            	}

            // Guery.g:2009:2: ( (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Constraint ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==17) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // Guery.g:2010:3: (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Constraint ) )
            	    {
            	    // Guery.g:2010:3: (a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Constraint ) )
            	    // Guery.g:2011:4: a2= 'and' (a3_0= parse_org_modelrefactoring_guery_Constraint )
            	    {
            	    a2=(Token)match(input,17,FOLLOW_17_in_parse_org_modelrefactoring_guery_Grouping1823); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.modelrefactoring.guery.GueryFactory.eINSTANCE.createGrouping();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_3_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[208]);
            	    			}

            	    // Guery.g:2025:4: (a3_0= parse_org_modelrefactoring_guery_Constraint )
            	    // Guery.g:2026:5: a3_0= parse_org_modelrefactoring_guery_Constraint
            	    {
            	    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_Grouping1849);
            	    a3_0=parse_org_modelrefactoring_guery_Constraint();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[209]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[210]);
            	    				addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[211]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[212]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[213]);
            		addExpectedElement(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), org.modelrefactoring.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[214]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_modelrefactoring_guery_Grouping_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_Grouping"



    // $ANTLR start "parse_org_modelrefactoring_guery_EdgeSelection"
    // Guery.g:2064:1: parse_org_modelrefactoring_guery_EdgeSelection returns [org.modelrefactoring.guery.EdgeSelection element = null] : (c0= parse_org_modelrefactoring_guery_ConnectedBy |c1= parse_org_modelrefactoring_guery_NotConnectedBy );
    public final org.modelrefactoring.guery.EdgeSelection parse_org_modelrefactoring_guery_EdgeSelection() throws RecognitionException {
        org.modelrefactoring.guery.EdgeSelection element =  null;

        int parse_org_modelrefactoring_guery_EdgeSelection_StartIndex = input.index();

        org.modelrefactoring.guery.ConnectedBy c0 =null;

        org.modelrefactoring.guery.NotConnectedBy c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Guery.g:2065:2: (c0= parse_org_modelrefactoring_guery_ConnectedBy |c1= parse_org_modelrefactoring_guery_NotConnectedBy )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==18) ) {
                alt17=1;
            }
            else if ( (LA17_0==22) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // Guery.g:2066:2: c0= parse_org_modelrefactoring_guery_ConnectedBy
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_ConnectedBy_in_parse_org_modelrefactoring_guery_EdgeSelection1901);
                    c0=parse_org_modelrefactoring_guery_ConnectedBy();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Guery.g:2067:4: c1= parse_org_modelrefactoring_guery_NotConnectedBy
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_guery_NotConnectedBy_in_parse_org_modelrefactoring_guery_EdgeSelection1911);
                    c1=parse_org_modelrefactoring_guery_NotConnectedBy();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_modelrefactoring_guery_EdgeSelection_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_guery_EdgeSelection"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_MotifModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Motif_in_parse_org_modelrefactoring_guery_MotifModel119 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Motif_in_parse_org_modelrefactoring_guery_MotifModel152 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parse_org_modelrefactoring_guery_Motif208 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Motif226 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_PreProcessor_in_parse_org_modelrefactoring_guery_Motif256 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_VertexSelection_in_parse_org_modelrefactoring_guery_Motif286 = new BitSet(new long[]{0x0000000000540002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_EdgeSelection_in_parse_org_modelrefactoring_guery_Motif313 = new BitSet(new long[]{0x0000000000540002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Grouping_in_parse_org_modelrefactoring_guery_Motif348 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_23_in_parse_org_modelrefactoring_guery_PreProcessor389 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_CLASSNAME_in_parse_org_modelrefactoring_guery_PreProcessor407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_parse_org_modelrefactoring_guery_VertexSelection443 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Role_in_parse_org_modelrefactoring_guery_VertexSelection461 = new BitSet(new long[]{0x0000000002002002L});
    public static final BitSet FOLLOW_13_in_parse_org_modelrefactoring_guery_VertexSelection488 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Role_in_parse_org_modelrefactoring_guery_VertexSelection514 = new BitSet(new long[]{0x0000000002002002L});
    public static final BitSet FOLLOW_25_in_parse_org_modelrefactoring_guery_VertexSelection564 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_VertexSelection590 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_modelrefactoring_guery_VertexSelection631 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_VertexSelection665 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Role758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_modelrefactoring_guery_Constraint798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_org_modelrefactoring_guery_ConnectedBy834 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Connection_in_parse_org_modelrefactoring_guery_ConnectedBy852 = new BitSet(new long[]{0x0000000002020002L});
    public static final BitSet FOLLOW_17_in_parse_org_modelrefactoring_guery_ConnectedBy879 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Connection_in_parse_org_modelrefactoring_guery_ConnectedBy905 = new BitSet(new long[]{0x0000000002020002L});
    public static final BitSet FOLLOW_25_in_parse_org_modelrefactoring_guery_ConnectedBy955 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_ConnectedBy981 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_modelrefactoring_guery_ConnectedBy1022 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_ConnectedBy1056 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_22_in_parse_org_modelrefactoring_guery_NotConnectedBy1145 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Connection_in_parse_org_modelrefactoring_guery_NotConnectedBy1163 = new BitSet(new long[]{0x0000000002020002L});
    public static final BitSet FOLLOW_17_in_parse_org_modelrefactoring_guery_NotConnectedBy1190 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Connection_in_parse_org_modelrefactoring_guery_NotConnectedBy1216 = new BitSet(new long[]{0x0000000002020002L});
    public static final BitSet FOLLOW_25_in_parse_org_modelrefactoring_guery_NotConnectedBy1266 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_NotConnectedBy1292 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_modelrefactoring_guery_NotConnectedBy1333 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_NotConnectedBy1367 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Connection1460 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_org_modelrefactoring_guery_Connection1481 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Connection1499 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_modelrefactoring_guery_Connection1520 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_guery_Connection1538 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_modelrefactoring_guery_Connection1559 = new BitSet(new long[]{0x0000000000088002L});
    public static final BitSet FOLLOW_15_in_parse_org_modelrefactoring_guery_Connection1582 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CARDINALITY_in_parse_org_modelrefactoring_guery_Connection1608 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_modelrefactoring_guery_Connection1641 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CARDINALITY_in_parse_org_modelrefactoring_guery_Connection1667 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_modelrefactoring_guery_Connection1700 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_parse_org_modelrefactoring_guery_Connection1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_org_modelrefactoring_guery_Grouping1778 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_Grouping1796 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_modelrefactoring_guery_Grouping1823 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_Constraint_in_parse_org_modelrefactoring_guery_Grouping1849 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_ConnectedBy_in_parse_org_modelrefactoring_guery_EdgeSelection1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_guery_NotConnectedBy_in_parse_org_modelrefactoring_guery_EdgeSelection1911 = new BitSet(new long[]{0x0000000000000002L});

}