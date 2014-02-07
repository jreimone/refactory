// $ANTLR 3.4

	package org.modelrefactoring.evolution.coed.resource.coed.mopp;
	
	import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.antlr.runtime3_4_0.ANTLRInputStream;
import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.CommonTokenStream;
import org.antlr.runtime3_4_0.IntStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.RecognitionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CoedParser extends CoedANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "IDENTIFIER", "LINEBREAK", "QUOTED_123_125", "QUOTED_60_62", "SL_COMMENT", "WHITESPACE", "':'", "'CoED'", "'condition'", "'corefactoring'", "'for'", "'import'", "'incoming'", "'outgoing'", "'refactoring'", "'{'", "'}'"
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
    public static final int FLOAT=4;
    public static final int IDENTIFIER=5;
    public static final int LINEBREAK=6;
    public static final int QUOTED_123_125=7;
    public static final int QUOTED_60_62=8;
    public static final int SL_COMMENT=9;
    public static final int WHITESPACE=10;

    // delegates
    public CoedANTLRParserBase[] getDelegates() {
        return new CoedANTLRParserBase[] {};
    }

    // delegators


    public CoedParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CoedParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(12 + 1);
         

    }

    public String[] getTokenNames() { return CoedParser.tokenNames; }
    public String getGrammarFileName() { return "Coed.g"; }


    	private org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolverFactory tokenResolverFactory = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenResolverFactory();
    	
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
    	private List<org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal> expectedElements = new ArrayList<org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected List<RecognitionException> lexerExceptions = Collections.synchronizedList(new ArrayList<RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected List<Integer> lexerExceptionPositions = Collections.synchronizedList(new ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	java.util.List<EObject> incompleteObjects = new java.util.ArrayList<EObject>();
    	
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
    	
    	private org.modelrefactoring.evolution.coed.resource.coed.ICoedLocationMap locationMap;
    	
    	private org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedSyntaxErrorMessageConverter syntaxErrorMessageConverter = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource>() {
    			public boolean execute(org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.modelrefactoring.evolution.coed.resource.coed.ICoedProblem() {
    					public org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity getSeverity() {
    						return org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity.ERROR;
    					}
    					public org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType getType() {
    						return org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedLocalizedMessage message) {
    		if (message == null) {
    			return;
    		}
    		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
    	}
    	
    	public void addExpectedElement(EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement terminal = org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedFollowSetProvider.TERMINALS[terminalID];
    		org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] containmentFeatures = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedFollowSetProvider.LINKS[ids[i]];
    		}
    		org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainmentTrace containmentTrace = new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal expectedElement = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    	
    	protected void collectHiddenTokens(EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final EObject source, final EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		final org.modelrefactoring.evolution.coed.resource.coed.ICoedLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource>() {
    			public boolean execute(org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource) {
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final CommonToken source, final EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		final org.modelrefactoring.evolution.coed.resource.coed.ICoedLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource>() {
    			public boolean execute(org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource) {
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
    	protected void setLocalizationEnd(Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final org.modelrefactoring.evolution.coed.resource.coed.ICoedLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource>() {
    			public boolean execute(org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new CoedParser(new CommonTokenStream(new CoedLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new CoedParser(new CommonTokenStream(new CoedLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new org.modelrefactoring.evolution.coed.resource.coed.util.CoedRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public CoedParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((CoedLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CoedLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.coed.CoEvolutionDefinition.class) {
    				return parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.coed.MetamodelImport.class) {
    				return parse_org_modelrefactoring_evolution_coed_MetamodelImport();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.coed.PlainCondition.class) {
    				return parse_org_modelrefactoring_evolution_coed_PlainCondition();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.coed.RoleMappingEvent.class) {
    				return parse_org_modelrefactoring_evolution_coed_RoleMappingEvent();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.coed.RoleMappingAction.class) {
    				return parse_org_modelrefactoring_evolution_coed_RoleMappingAction();
    			}
    		}
    		throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(IntStream arg0, RecognitionException arg1, int arg2, BitSet arg3) {
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
    		Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(org.modelrefactoring.evolution.coed.resource.coed.ICoedOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.modelrefactoring.evolution.coed.resource.coed.ICoedParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource>>();
    		org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedParseResult parseResult = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedParseResult();
    		if (disableLocationMap) {
    			locationMap = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedDevNullLocationMap();
    		} else {
    			locationMap = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedLocationMap();
    		}
    		// Run parser
    		try {
    			EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    				parseResult.setLocationMap(locationMap);
    			}
    		} catch (RecognitionException re) {
    			addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    		} catch (IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (RecognitionException re : lexerExceptions) {
    			addErrorToResource(syntaxErrorMessageConverter.translateLexicalError(re, lexerExceptions, lexerExceptionPositions));
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public List<org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal> parseToExpectedElements(EClass type, org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		org.modelrefactoring.evolution.coed.resource.coed.ICoedParseResult result = parse();
    		for (EObject incompleteObject : incompleteObjects) {
    			Lexer lexer = (Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal> currentFollowSet = new LinkedHashSet<org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal>();
    		List<org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal> newFollowSet = new ArrayList<org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 27;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			CommonToken nextToken = (CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<org.modelrefactoring.evolution.coed.resource.coed.util.CoedPair<org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.modelrefactoring.evolution.coed.resource.coed.util.CoedPair<org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[]> newFollowerPair : newFollowers) {
    							org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainmentTrace containmentTrace = new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainmentTrace(null, newFollowerPair.getRight());
    							org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal newFollowTerminal = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			CommonToken tokenAtIndex = (CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	private void startIncompleteElement(Object object) {
    		if (object instanceof EObject) {
    			this.incompleteObjects.add((EObject) object);
    		}
    	}
    	
    	private void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			boolean exists = this.incompleteObjects.remove(object);
    			if (!exists) {
    			}
    		}
    		if (object instanceof EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private EObject getLastIncompleteElement() {
    		if (incompleteObjects.isEmpty()) {
    			return null;
    		}
    		return incompleteObjects.get(incompleteObjects.size() - 1);
    	}
    	



    // $ANTLR start "start"
    // Coed.g:493:1: start returns [ EObject element = null] : (c0= parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        org.modelrefactoring.evolution.coed.CoEvolutionDefinition c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Coed.g:494:2: ( (c0= parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition ) EOF )
            // Coed.g:495:2: (c0= parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Coed.g:500:2: (c0= parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition )
            // Coed.g:501:3: c0= parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition_in_start82);
            c0=parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition();

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



    // $ANTLR start "parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition"
    // Coed.g:509:1: parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition returns [org.modelrefactoring.evolution.coed.CoEvolutionDefinition element = null] : a0= 'CoED' a1= 'for' (a2= QUOTED_60_62 ) ( (a3= 'import' (a4_0= parse_org_modelrefactoring_evolution_coed_MetamodelImport ) ) )* a5= '{' a6= 'incoming' (a7_0= parse_org_modelrefactoring_evolution_coed_Event ) ( (a8_0= parse_org_modelrefactoring_evolution_coed_Condition ) )? a9= 'outgoing' (a10_0= parse_org_modelrefactoring_evolution_coed_Action ) a11= '}' ;
    public final org.modelrefactoring.evolution.coed.CoEvolutionDefinition parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition() throws RecognitionException {
        org.modelrefactoring.evolution.coed.CoEvolutionDefinition element =  null;

        int parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        Token a9=null;
        Token a11=null;
        org.modelrefactoring.evolution.coed.MetamodelImport a4_0 =null;

        org.modelrefactoring.evolution.coed.Event a7_0 =null;

        org.modelrefactoring.evolution.coed.Condition a8_0 =null;

        org.modelrefactoring.evolution.coed.Action a10_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Coed.g:512:2: (a0= 'CoED' a1= 'for' (a2= QUOTED_60_62 ) ( (a3= 'import' (a4_0= parse_org_modelrefactoring_evolution_coed_MetamodelImport ) ) )* a5= '{' a6= 'incoming' (a7_0= parse_org_modelrefactoring_evolution_coed_Event ) ( (a8_0= parse_org_modelrefactoring_evolution_coed_Condition ) )? a9= 'outgoing' (a10_0= parse_org_modelrefactoring_evolution_coed_Action ) a11= '}' )
            // Coed.g:513:2: a0= 'CoED' a1= 'for' (a2= QUOTED_60_62 ) ( (a3= 'import' (a4_0= parse_org_modelrefactoring_evolution_coed_MetamodelImport ) ) )* a5= '{' a6= 'incoming' (a7_0= parse_org_modelrefactoring_evolution_coed_Event ) ( (a8_0= parse_org_modelrefactoring_evolution_coed_Condition ) )? a9= 'outgoing' (a10_0= parse_org_modelrefactoring_evolution_coed_Action ) a11= '}'
            {
            a0=(Token)match(input,12,FOLLOW_12_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[2]);
            	}

            // Coed.g:541:2: (a2= QUOTED_60_62 )
            // Coed.g:542:3: a2= QUOTED_60_62
            {
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EPackage proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEPackage();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContextDependentURIFragmentFactory<org.modelrefactoring.evolution.coed.CoEvolutionDefinition, org.eclipse.emf.ecore.EPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCoEvolutionDefinitionMetamodelReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_4, proxy, true);
            				copyLocalizationInfos((CommonToken) a2, element);
            				copyLocalizationInfos((CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[4]);
            	}

            // Coed.g:582:2: ( (a3= 'import' (a4_0= parse_org_modelrefactoring_evolution_coed_MetamodelImport ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Coed.g:583:3: (a3= 'import' (a4_0= parse_org_modelrefactoring_evolution_coed_MetamodelImport ) )
            	    {
            	    // Coed.g:583:3: (a3= 'import' (a4_0= parse_org_modelrefactoring_evolution_coed_MetamodelImport ) )
            	    // Coed.g:584:4: a3= 'import' (a4_0= parse_org_modelrefactoring_evolution_coed_MetamodelImport )
            	    {
            	    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition177); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_6_0_0_0, null, true);
            	    				copyLocalizationInfos((CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition(), org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[5]);
            	    			}

            	    // Coed.g:598:4: (a4_0= parse_org_modelrefactoring_evolution_coed_MetamodelImport )
            	    // Coed.g:599:5: a4_0= parse_org_modelrefactoring_evolution_coed_MetamodelImport
            	    {
            	    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_coed_MetamodelImport_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition203);
            	    a4_0=parse_org_modelrefactoring_evolution_coed_MetamodelImport();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a4_0 != null) {
            	    						if (a4_0 != null) {
            	    							Object value = a4_0;
            	    							addObjectToList(element, org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_6_0_0_2, a4_0, true);
            	    						copyLocalizationInfos(a4_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[6]);
            	    				addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[7]);
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
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[9]);
            	}

            a5=(Token)match(input,20,FOLLOW_20_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition244); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_7, null, true);
            		copyLocalizationInfos((CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[10]);
            	}

            a6=(Token)match(input,17,FOLLOW_17_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition258); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_9, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition(), org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[11]);
            	}

            // Coed.g:661:2: (a7_0= parse_org_modelrefactoring_evolution_coed_Event )
            // Coed.g:662:3: a7_0= parse_org_modelrefactoring_evolution_coed_Event
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_coed_Event_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition276);
            a7_0=parse_org_modelrefactoring_evolution_coed_Event();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            				startIncompleteElement(element);
            			}
            			if (a7_0 != null) {
            				if (a7_0 != null) {
            					Object value = a7_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__EVENT), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_11, a7_0, true);
            				copyLocalizationInfos(a7_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition(), org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[12]);
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[13]);
            	}

            // Coed.g:688:2: ( (a8_0= parse_org_modelrefactoring_evolution_coed_Condition ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Coed.g:689:3: (a8_0= parse_org_modelrefactoring_evolution_coed_Condition )
                    {
                    // Coed.g:689:3: (a8_0= parse_org_modelrefactoring_evolution_coed_Condition )
                    // Coed.g:690:4: a8_0= parse_org_modelrefactoring_evolution_coed_Condition
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_coed_Condition_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition303);
                    a8_0=parse_org_modelrefactoring_evolution_coed_Condition();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
                    					startIncompleteElement(element);
                    				}
                    				if (a8_0 != null) {
                    					if (a8_0 != null) {
                    						Object value = a8_0;
                    						element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION), value);
                    						completedElement(value, true);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_13, a8_0, true);
                    					copyLocalizationInfos(a8_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[14]);
            	}

            a9=(Token)match(input,18,FOLLOW_18_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition329); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_15, null, true);
            		copyLocalizationInfos((CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition(), org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[15]);
            	}

            // Coed.g:730:2: (a10_0= parse_org_modelrefactoring_evolution_coed_Action )
            // Coed.g:731:3: a10_0= parse_org_modelrefactoring_evolution_coed_Action
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_coed_Action_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition347);
            a10_0=parse_org_modelrefactoring_evolution_coed_Action();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            				startIncompleteElement(element);
            			}
            			if (a10_0 != null) {
            				if (a10_0 != null) {
            					Object value = a10_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__ACTION), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_17, a10_0, true);
            				copyLocalizationInfos(a10_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[16]);
            	}

            a11=(Token)match(input,21,FOLLOW_21_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition365); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createCoEvolutionDefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_19, null, true);
            		copyLocalizationInfos((CommonToken)a11, element);
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition"



    // $ANTLR start "parse_org_modelrefactoring_evolution_coed_MetamodelImport"
    // Coed.g:771:1: parse_org_modelrefactoring_evolution_coed_MetamodelImport returns [org.modelrefactoring.evolution.coed.MetamodelImport element = null] : (a0= IDENTIFIER ) a1= ':' (a2= QUOTED_60_62 ) ;
    public final org.modelrefactoring.evolution.coed.MetamodelImport parse_org_modelrefactoring_evolution_coed_MetamodelImport() throws RecognitionException {
        org.modelrefactoring.evolution.coed.MetamodelImport element =  null;

        int parse_org_modelrefactoring_evolution_coed_MetamodelImport_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Coed.g:774:2: ( (a0= IDENTIFIER ) a1= ':' (a2= QUOTED_60_62 ) )
            // Coed.g:775:2: (a0= IDENTIFIER ) a1= ':' (a2= QUOTED_60_62 )
            {
            // Coed.g:775:2: (a0= IDENTIFIER )
            // Coed.g:776:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_coed_MetamodelImport398); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createMetamodelImport();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__SHORTCUT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__SHORTCUT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_1_0_0_0, resolved, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[17]);
            	}

            a1=(Token)match(input,11,FOLLOW_11_in_parse_org_modelrefactoring_evolution_coed_MetamodelImport419); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createMetamodelImport();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_1_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[18]);
            	}

            // Coed.g:825:2: (a2= QUOTED_60_62 )
            // Coed.g:826:3: a2= QUOTED_60_62
            {
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_coed_MetamodelImport437); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createMetamodelImport();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EPackage proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEPackage();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContextDependentURIFragmentFactory<org.modelrefactoring.evolution.coed.MetamodelImport, org.eclipse.emf.ecore.EPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetamodelImportMetamodelReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__METAMODEL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_1_0_0_4, proxy, true);
            				copyLocalizationInfos((CommonToken) a2, element);
            				copyLocalizationInfos((CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[20]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_modelrefactoring_evolution_coed_MetamodelImport_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_coed_MetamodelImport"



    // $ANTLR start "parse_org_modelrefactoring_evolution_coed_PlainCondition"
    // Coed.g:868:1: parse_org_modelrefactoring_evolution_coed_PlainCondition returns [org.modelrefactoring.evolution.coed.PlainCondition element = null] : a0= 'condition' (a1= QUOTED_123_125 ) ;
    public final org.modelrefactoring.evolution.coed.PlainCondition parse_org_modelrefactoring_evolution_coed_PlainCondition() throws RecognitionException {
        org.modelrefactoring.evolution.coed.PlainCondition element =  null;

        int parse_org_modelrefactoring_evolution_coed_PlainCondition_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Coed.g:871:2: (a0= 'condition' (a1= QUOTED_123_125 ) )
            // Coed.g:872:2: a0= 'condition' (a1= QUOTED_123_125 )
            {
            a0=(Token)match(input,13,FOLLOW_13_in_parse_org_modelrefactoring_evolution_coed_PlainCondition473); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createPlainCondition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_2_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[21]);
            	}

            // Coed.g:886:2: (a1= QUOTED_123_125 )
            // Coed.g:887:3: a1= QUOTED_123_125
            {
            a1=(Token)match(input,QUOTED_123_125,FOLLOW_QUOTED_123_125_in_parse_org_modelrefactoring_evolution_coed_PlainCondition491); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createPlainCondition();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_123_125");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.PLAIN_CONDITION__CONDITION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.PLAIN_CONDITION__CONDITION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_2_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[22]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_modelrefactoring_evolution_coed_PlainCondition_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_coed_PlainCondition"



    // $ANTLR start "parse_org_modelrefactoring_evolution_coed_RoleMappingEvent"
    // Coed.g:924:1: parse_org_modelrefactoring_evolution_coed_RoleMappingEvent returns [org.modelrefactoring.evolution.coed.RoleMappingEvent element = null] : a0= 'refactoring' (a1= IDENTIFIER ) a2= ':' (a3= QUOTED_60_62 ) ;
    public final org.modelrefactoring.evolution.coed.RoleMappingEvent parse_org_modelrefactoring_evolution_coed_RoleMappingEvent() throws RecognitionException {
        org.modelrefactoring.evolution.coed.RoleMappingEvent element =  null;

        int parse_org_modelrefactoring_evolution_coed_RoleMappingEvent_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Coed.g:927:2: (a0= 'refactoring' (a1= IDENTIFIER ) a2= ':' (a3= QUOTED_60_62 ) )
            // Coed.g:928:2: a0= 'refactoring' (a1= IDENTIFIER ) a2= ':' (a3= QUOTED_60_62 )
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent527); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createRoleMappingEvent();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[23]);
            	}

            // Coed.g:942:2: (a1= IDENTIFIER )
            // Coed.g:943:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent545); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createRoleMappingEvent();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.modelrefactoring.evolution.coed.MetamodelImport proxy = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createMetamodelImport();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContextDependentURIFragmentFactory<org.modelrefactoring.evolution.coed.RoleMappingEvent, org.modelrefactoring.evolution.coed.MetamodelImport>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleMappingEventMetamodelImportReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            				copyLocalizationInfos((CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[24]);
            	}

            a2=(Token)match(input,11,FOLLOW_11_in_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent566); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createRoleMappingEvent();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[25]);
            	}

            // Coed.g:996:2: (a3= QUOTED_60_62 )
            // Coed.g:997:3: a3= QUOTED_60_62
            {
            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent584); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createRoleMappingEvent();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.refactoring.rolemapping.RoleMapping proxy = org.emftext.language.refactoring.rolemapping.RolemappingFactory.eINSTANCE.createRoleMapping();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContextDependentURIFragmentFactory<org.modelrefactoring.evolution.coed.RoleMappingEvent, org.emftext.language.refactoring.rolemapping.RoleMapping>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleMappingEventConcreteRefactoringReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_6, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition(), org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[27]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_modelrefactoring_evolution_coed_RoleMappingEvent_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_coed_RoleMappingEvent"



    // $ANTLR start "parse_org_modelrefactoring_evolution_coed_RoleMappingAction"
    // Coed.g:1039:1: parse_org_modelrefactoring_evolution_coed_RoleMappingAction returns [org.modelrefactoring.evolution.coed.RoleMappingAction element = null] : a0= 'corefactoring' (a1= QUOTED_60_62 ) ( ( (a2= QUOTED_123_125 ) ) )? ;
    public final org.modelrefactoring.evolution.coed.RoleMappingAction parse_org_modelrefactoring_evolution_coed_RoleMappingAction() throws RecognitionException {
        org.modelrefactoring.evolution.coed.RoleMappingAction element =  null;

        int parse_org_modelrefactoring_evolution_coed_RoleMappingAction_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Coed.g:1042:2: (a0= 'corefactoring' (a1= QUOTED_60_62 ) ( ( (a2= QUOTED_123_125 ) ) )? )
            // Coed.g:1043:2: a0= 'corefactoring' (a1= QUOTED_60_62 ) ( ( (a2= QUOTED_123_125 ) ) )?
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_org_modelrefactoring_evolution_coed_RoleMappingAction620); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createRoleMappingAction();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[28]);
            	}

            // Coed.g:1057:2: (a1= QUOTED_60_62 )
            // Coed.g:1058:3: a1= QUOTED_60_62
            {
            a1=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_coed_RoleMappingAction638); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createRoleMappingAction();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.refactoring.rolemapping.RoleMapping proxy = org.emftext.language.refactoring.rolemapping.RolemappingFactory.eINSTANCE.createRoleMapping();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContextDependentURIFragmentFactory<org.modelrefactoring.evolution.coed.RoleMappingAction, org.emftext.language.refactoring.rolemapping.RoleMapping>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleMappingActionConcreteRefactoringReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_4_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            				copyLocalizationInfos((CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[30]);
            	}

            // Coed.g:1098:2: ( ( (a2= QUOTED_123_125 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QUOTED_123_125) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Coed.g:1099:3: ( (a2= QUOTED_123_125 ) )
                    {
                    // Coed.g:1099:3: ( (a2= QUOTED_123_125 ) )
                    // Coed.g:1100:4: (a2= QUOTED_123_125 )
                    {
                    // Coed.g:1100:4: (a2= QUOTED_123_125 )
                    // Coed.g:1101:5: a2= QUOTED_123_125
                    {
                    a2=(Token)match(input,QUOTED_123_125,FOLLOW_QUOTED_123_125_in_parse_org_modelrefactoring_evolution_coed_RoleMappingAction674); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.modelrefactoring.evolution.coed.CoedFactory.eINSTANCE.createRoleMappingAction();
                    						startIncompleteElement(element);
                    					}
                    					if (a2 != null) {
                    						org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_123_125");
                    						tokenResolver.setOptions(getOptions());
                    						org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__BINDING), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    						}
                    						java.lang.String resolved = (java.lang.String) resolvedObject;
                    						if (resolved != null) {
                    							Object value = resolved;
                    							element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__BINDING), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_4_0_0_3_0_0_1, resolved, true);
                    						copyLocalizationInfos((CommonToken) a2, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[31]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectationConstants.EXPECTATIONS[32]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_modelrefactoring_evolution_coed_RoleMappingAction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_coed_RoleMappingAction"



    // $ANTLR start "parse_org_modelrefactoring_evolution_coed_Event"
    // Coed.g:1145:1: parse_org_modelrefactoring_evolution_coed_Event returns [org.modelrefactoring.evolution.coed.Event element = null] : c0= parse_org_modelrefactoring_evolution_coed_RoleMappingEvent ;
    public final org.modelrefactoring.evolution.coed.Event parse_org_modelrefactoring_evolution_coed_Event() throws RecognitionException {
        org.modelrefactoring.evolution.coed.Event element =  null;

        int parse_org_modelrefactoring_evolution_coed_Event_StartIndex = input.index();

        org.modelrefactoring.evolution.coed.RoleMappingEvent c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Coed.g:1146:2: (c0= parse_org_modelrefactoring_evolution_coed_RoleMappingEvent )
            // Coed.g:1147:2: c0= parse_org_modelrefactoring_evolution_coed_RoleMappingEvent
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent_in_parse_org_modelrefactoring_evolution_coed_Event731);
            c0=parse_org_modelrefactoring_evolution_coed_RoleMappingEvent();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_modelrefactoring_evolution_coed_Event_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_coed_Event"



    // $ANTLR start "parse_org_modelrefactoring_evolution_coed_Condition"
    // Coed.g:1151:1: parse_org_modelrefactoring_evolution_coed_Condition returns [org.modelrefactoring.evolution.coed.Condition element = null] : c0= parse_org_modelrefactoring_evolution_coed_PlainCondition ;
    public final org.modelrefactoring.evolution.coed.Condition parse_org_modelrefactoring_evolution_coed_Condition() throws RecognitionException {
        org.modelrefactoring.evolution.coed.Condition element =  null;

        int parse_org_modelrefactoring_evolution_coed_Condition_StartIndex = input.index();

        org.modelrefactoring.evolution.coed.PlainCondition c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Coed.g:1152:2: (c0= parse_org_modelrefactoring_evolution_coed_PlainCondition )
            // Coed.g:1153:2: c0= parse_org_modelrefactoring_evolution_coed_PlainCondition
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_coed_PlainCondition_in_parse_org_modelrefactoring_evolution_coed_Condition752);
            c0=parse_org_modelrefactoring_evolution_coed_PlainCondition();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_modelrefactoring_evolution_coed_Condition_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_coed_Condition"



    // $ANTLR start "parse_org_modelrefactoring_evolution_coed_Action"
    // Coed.g:1157:1: parse_org_modelrefactoring_evolution_coed_Action returns [org.modelrefactoring.evolution.coed.Action element = null] : c0= parse_org_modelrefactoring_evolution_coed_RoleMappingAction ;
    public final org.modelrefactoring.evolution.coed.Action parse_org_modelrefactoring_evolution_coed_Action() throws RecognitionException {
        org.modelrefactoring.evolution.coed.Action element =  null;

        int parse_org_modelrefactoring_evolution_coed_Action_StartIndex = input.index();

        org.modelrefactoring.evolution.coed.RoleMappingAction c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Coed.g:1158:2: (c0= parse_org_modelrefactoring_evolution_coed_RoleMappingAction )
            // Coed.g:1159:2: c0= parse_org_modelrefactoring_evolution_coed_RoleMappingAction
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_coed_RoleMappingAction_in_parse_org_modelrefactoring_evolution_coed_Action773);
            c0=parse_org_modelrefactoring_evolution_coed_RoleMappingAction();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_modelrefactoring_evolution_coed_Action_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_coed_Action"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition115 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition129 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition147 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition177 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_coed_MetamodelImport_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition203 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition244 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition258 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_coed_Event_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition276 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_coed_Condition_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition303 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition329 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_coed_Action_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition347 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_modelrefactoring_evolution_coed_CoEvolutionDefinition365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_coed_MetamodelImport398 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_org_modelrefactoring_evolution_coed_MetamodelImport419 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_coed_MetamodelImport437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_org_modelrefactoring_evolution_coed_PlainCondition473 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_123_125_in_parse_org_modelrefactoring_evolution_coed_PlainCondition491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent527 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent545 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent566 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_modelrefactoring_evolution_coed_RoleMappingAction620 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_coed_RoleMappingAction638 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_QUOTED_123_125_in_parse_org_modelrefactoring_evolution_coed_RoleMappingAction674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_coed_RoleMappingEvent_in_parse_org_modelrefactoring_evolution_coed_Event731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_coed_PlainCondition_in_parse_org_modelrefactoring_evolution_coed_Condition752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_coed_RoleMappingAction_in_parse_org_modelrefactoring_evolution_coed_Action773 = new BitSet(new long[]{0x0000000000000002L});

}