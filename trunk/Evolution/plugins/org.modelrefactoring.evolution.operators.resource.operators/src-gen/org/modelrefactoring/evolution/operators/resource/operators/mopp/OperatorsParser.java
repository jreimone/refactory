// $ANTLR 3.4

	package org.modelrefactoring.evolution.operators.resource.operators.mopp;
	
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
public class OperatorsParser extends OperatorsANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "IDENTIFIER", "INTEGER", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "QUOTED_60_62", "SL_COMMENT", "WHITESPACE", "','", "'.'", "'='", "'create'", "'delete'", "'in'", "'move'", "'new'", "'to'", "'var'"
    };

    public static final int EOF=-1;
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
    public static final int FLOAT=4;
    public static final int IDENTIFIER=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int ML_COMMENT=8;
    public static final int QUOTED_34_34=9;
    public static final int QUOTED_60_62=10;
    public static final int SL_COMMENT=11;
    public static final int WHITESPACE=12;

    // delegates
    public OperatorsANTLRParserBase[] getDelegates() {
        return new OperatorsANTLRParserBase[] {};
    }

    // delegators


    public OperatorsParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public OperatorsParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(23 + 1);
         

    }

    public String[] getTokenNames() { return OperatorsParser.tokenNames; }
    public String getGrammarFileName() { return "Operators.g"; }


    	private org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolverFactory tokenResolverFactory = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenResolverFactory();
    	
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
    	private List<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal> expectedElements = new ArrayList<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal>();
    	
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
    	
    	private org.modelrefactoring.evolution.operators.resource.operators.IOperatorsLocationMap locationMap;
    	
    	private org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsSyntaxErrorMessageConverter syntaxErrorMessageConverter = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>() {
    			public boolean execute(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.modelrefactoring.evolution.operators.resource.operators.IOperatorsProblem() {
    					public org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemSeverity getSeverity() {
    						return org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemSeverity.ERROR;
    					}
    					public org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType getType() {
    						return org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsLocalizedMessage message) {
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
    		org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement terminal = org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsFollowSetProvider.TERMINALS[terminalID];
    		org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[] containmentFeatures = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsFollowSetProvider.LINKS[ids[i]];
    		}
    		org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainmentTrace containmentTrace = new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal expectedElement = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final org.modelrefactoring.evolution.operators.resource.operators.IOperatorsLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>() {
    			public boolean execute(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource) {
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
    		final org.modelrefactoring.evolution.operators.resource.operators.IOperatorsLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>() {
    			public boolean execute(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource) {
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
    	protected void setLocalizationEnd(Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final org.modelrefactoring.evolution.operators.resource.operators.IOperatorsLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>() {
    			public boolean execute(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new OperatorsParser(new CommonTokenStream(new OperatorsLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new OperatorsParser(new CommonTokenStream(new OperatorsLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public OperatorsParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((OperatorsLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((OperatorsLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.EObjectReference.class) {
    				return parse_org_modelrefactoring_evolution_operators_EObjectReference();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.VariableReference.class) {
    				return parse_org_modelrefactoring_evolution_operators_VariableReference();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.VAR.class) {
    				return parse_org_modelrefactoring_evolution_operators_VAR();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.QueryVariable.class) {
    				return parse_org_modelrefactoring_evolution_operators_QueryVariable();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.EReferenceQualifier.class) {
    				return parse_org_modelrefactoring_evolution_operators_EReferenceQualifier();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.EOperationQualifier.class) {
    				return parse_org_modelrefactoring_evolution_operators_EOperationQualifier();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.CREATE.class) {
    				return parse_org_modelrefactoring_evolution_operators_CREATE();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.TypeVariable.class) {
    				return parse_org_modelrefactoring_evolution_operators_TypeVariable();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.DELETE.class) {
    				return parse_org_modelrefactoring_evolution_operators_DELETE();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.ASSIGN.class) {
    				return parse_org_modelrefactoring_evolution_operators_ASSIGN();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.SET.class) {
    				return parse_org_modelrefactoring_evolution_operators_SET();
    			}
    			if (type.getInstanceClass() == org.modelrefactoring.evolution.operators.MOVE.class) {
    				return parse_org_modelrefactoring_evolution_operators_MOVE();
    			}
    		}
    		throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>>();
    		org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsParseResult parseResult = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsParseResult();
    		if (disableLocationMap) {
    			locationMap = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsDevNullLocationMap();
    		} else {
    			locationMap = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsLocationMap();
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
    	
    	public List<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal> parseToExpectedElements(EClass type, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		org.modelrefactoring.evolution.operators.resource.operators.IOperatorsParseResult result = parse();
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
    			for (org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal> currentFollowSet = new LinkedHashSet<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal>();
    		List<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal> newFollowSet = new ArrayList<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 43;
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
    				for (org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsPair<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsPair<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[]> newFollowerPair : newFollowers) {
    							org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainmentTrace containmentTrace = new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainmentTrace(null, newFollowerPair.getRight());
    							org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal newFollowTerminal = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectedTerminal expectedElement, int tokenIndex) {
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
    // Operators.g:514:1: start returns [ EObject element = null] : (c0= parse_org_modelrefactoring_evolution_operators_CREATE |c1= parse_org_modelrefactoring_evolution_operators_DELETE |c2= parse_org_modelrefactoring_evolution_operators_ASSIGN |c3= parse_org_modelrefactoring_evolution_operators_SET |c4= parse_org_modelrefactoring_evolution_operators_MOVE |c5= parse_org_modelrefactoring_evolution_operators_VAR ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        org.modelrefactoring.evolution.operators.CREATE c0 =null;

        org.modelrefactoring.evolution.operators.DELETE c1 =null;

        org.modelrefactoring.evolution.operators.ASSIGN c2 =null;

        org.modelrefactoring.evolution.operators.SET c3 =null;

        org.modelrefactoring.evolution.operators.MOVE c4 =null;

        org.modelrefactoring.evolution.operators.VAR c5 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Operators.g:515:2: ( (c0= parse_org_modelrefactoring_evolution_operators_CREATE |c1= parse_org_modelrefactoring_evolution_operators_DELETE |c2= parse_org_modelrefactoring_evolution_operators_ASSIGN |c3= parse_org_modelrefactoring_evolution_operators_SET |c4= parse_org_modelrefactoring_evolution_operators_MOVE |c5= parse_org_modelrefactoring_evolution_operators_VAR ) EOF )
            // Operators.g:516:2: (c0= parse_org_modelrefactoring_evolution_operators_CREATE |c1= parse_org_modelrefactoring_evolution_operators_DELETE |c2= parse_org_modelrefactoring_evolution_operators_ASSIGN |c3= parse_org_modelrefactoring_evolution_operators_SET |c4= parse_org_modelrefactoring_evolution_operators_MOVE |c5= parse_org_modelrefactoring_evolution_operators_VAR ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[7]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Operators.g:528:2: (c0= parse_org_modelrefactoring_evolution_operators_CREATE |c1= parse_org_modelrefactoring_evolution_operators_DELETE |c2= parse_org_modelrefactoring_evolution_operators_ASSIGN |c3= parse_org_modelrefactoring_evolution_operators_SET |c4= parse_org_modelrefactoring_evolution_operators_MOVE |c5= parse_org_modelrefactoring_evolution_operators_VAR )
            int alt1=6;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // Operators.g:529:3: c0= parse_org_modelrefactoring_evolution_operators_CREATE
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_CREATE_in_start82);
                    c0=parse_org_modelrefactoring_evolution_operators_CREATE();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; }

                    }
                    break;
                case 2 :
                    // Operators.g:530:8: c1= parse_org_modelrefactoring_evolution_operators_DELETE
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_DELETE_in_start96);
                    c1=parse_org_modelrefactoring_evolution_operators_DELETE();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; }

                    }
                    break;
                case 3 :
                    // Operators.g:531:8: c2= parse_org_modelrefactoring_evolution_operators_ASSIGN
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_ASSIGN_in_start110);
                    c2=parse_org_modelrefactoring_evolution_operators_ASSIGN();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; }

                    }
                    break;
                case 4 :
                    // Operators.g:532:8: c3= parse_org_modelrefactoring_evolution_operators_SET
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_SET_in_start124);
                    c3=parse_org_modelrefactoring_evolution_operators_SET();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; }

                    }
                    break;
                case 5 :
                    // Operators.g:533:8: c4= parse_org_modelrefactoring_evolution_operators_MOVE
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_MOVE_in_start138);
                    c4=parse_org_modelrefactoring_evolution_operators_MOVE();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; }

                    }
                    break;
                case 6 :
                    // Operators.g:534:8: c5= parse_org_modelrefactoring_evolution_operators_VAR
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_VAR_in_start152);
                    c5=parse_org_modelrefactoring_evolution_operators_VAR();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; }

                    }
                    break;

            }


            match(input,EOF,FOLLOW_EOF_in_start159); if (state.failed) return element;

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



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_EObjectReference"
    // Operators.g:542:1: parse_org_modelrefactoring_evolution_operators_EObjectReference returns [org.modelrefactoring.evolution.operators.EObjectReference element = null] : (a0= QUOTED_60_62 ) ( (a1= ',' (a2= QUOTED_60_62 ) ) )* ;
    public final org.modelrefactoring.evolution.operators.EObjectReference parse_org_modelrefactoring_evolution_operators_EObjectReference() throws RecognitionException {
        org.modelrefactoring.evolution.operators.EObjectReference element =  null;

        int parse_org_modelrefactoring_evolution_operators_EObjectReference_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Operators.g:545:2: ( (a0= QUOTED_60_62 ) ( (a1= ',' (a2= QUOTED_60_62 ) ) )* )
            // Operators.g:546:2: (a0= QUOTED_60_62 ) ( (a1= ',' (a2= QUOTED_60_62 ) ) )*
            {
            // Operators.g:546:2: (a0= QUOTED_60_62 )
            // Operators.g:547:3: a0= QUOTED_60_62
            {
            a0=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_operators_EObjectReference189); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createEObjectReference();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EObject proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEObject();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.EObjectReference, org.eclipse.emf.ecore.EObject>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEObjectReferenceElementsReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_0_0_0_0, proxy, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            				copyLocalizationInfos((CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[12]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[13]);
            	}

            // Operators.g:591:2: ( (a1= ',' (a2= QUOTED_60_62 ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Operators.g:592:3: (a1= ',' (a2= QUOTED_60_62 ) )
            	    {
            	    // Operators.g:592:3: (a1= ',' (a2= QUOTED_60_62 ) )
            	    // Operators.g:593:4: a1= ',' (a2= QUOTED_60_62 )
            	    {
            	    a1=(Token)match(input,13,FOLLOW_13_in_parse_org_modelrefactoring_evolution_operators_EObjectReference219); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createEObjectReference();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_0_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[14]);
            	    			}

            	    // Operators.g:607:4: (a2= QUOTED_60_62 )
            	    // Operators.g:608:5: a2= QUOTED_60_62
            	    {
            	    a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_operators_EObjectReference245); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createEObjectReference();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2 != null) {
            	    						org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            	    						tokenResolver.setOptions(getOptions());
            	    						org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
            	    						}
            	    						String resolved = (String) resolvedObject;
            	    						org.eclipse.emf.ecore.EObject proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEObject();
            	    						collectHiddenTokens(element);
            	    						registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.EObjectReference, org.eclipse.emf.ecore.EObject>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEObjectReferenceElementsReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS), resolved, proxy);
            	    						if (proxy != null) {
            	    							Object value = proxy;
            	    							addObjectToList(element, org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS, value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_0_0_0_1_0_0_2, proxy, true);
            	    						copyLocalizationInfos((CommonToken) a2, element);
            	    						copyLocalizationInfos((CommonToken) a2, proxy);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[15]);
            	    				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[16]);
            	    				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[17]);
            	    				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[18]);
            	    				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[19]);
            	    				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[20]);
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
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[23]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[26]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_modelrefactoring_evolution_operators_EObjectReference_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_EObjectReference"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_VariableReference"
    // Operators.g:666:1: parse_org_modelrefactoring_evolution_operators_VariableReference returns [org.modelrefactoring.evolution.operators.VariableReference element = null] : (a0= IDENTIFIER ) ;
    public final org.modelrefactoring.evolution.operators.VariableReference parse_org_modelrefactoring_evolution_operators_VariableReference() throws RecognitionException {
        org.modelrefactoring.evolution.operators.VariableReference element =  null;

        int parse_org_modelrefactoring_evolution_operators_VariableReference_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Operators.g:669:2: ( (a0= IDENTIFIER ) )
            // Operators.g:670:2: (a0= IDENTIFIER )
            {
            // Operators.g:670:2: (a0= IDENTIFIER )
            // Operators.g:671:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_VariableReference310); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createVariableReference();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.modelrefactoring.evolution.operators.Variable proxy = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createTypeVariable();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.VariableReference, org.modelrefactoring.evolution.operators.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getVariableReferenceReferencedVariableReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_1_0_0_0, proxy, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            				copyLocalizationInfos((CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[31]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_modelrefactoring_evolution_operators_VariableReference_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_VariableReference"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_VAR"
    // Operators.g:716:1: parse_org_modelrefactoring_evolution_operators_VAR returns [org.modelrefactoring.evolution.operators.VAR element = null] : a0= 'var' (a1_0= parse_org_modelrefactoring_evolution_operators_QueryVariable ) ;
    public final org.modelrefactoring.evolution.operators.VAR parse_org_modelrefactoring_evolution_operators_VAR() throws RecognitionException {
        org.modelrefactoring.evolution.operators.VAR element =  null;

        int parse_org_modelrefactoring_evolution_operators_VAR_StartIndex = input.index();

        Token a0=null;
        org.modelrefactoring.evolution.operators.QueryVariable a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Operators.g:719:2: (a0= 'var' (a1_0= parse_org_modelrefactoring_evolution_operators_QueryVariable ) )
            // Operators.g:720:2: a0= 'var' (a1_0= parse_org_modelrefactoring_evolution_operators_QueryVariable )
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_org_modelrefactoring_evolution_operators_VAR346); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createVAR();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_2_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVAR(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[32]);
            	}

            // Operators.g:734:2: (a1_0= parse_org_modelrefactoring_evolution_operators_QueryVariable )
            // Operators.g:735:3: a1_0= parse_org_modelrefactoring_evolution_operators_QueryVariable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_QueryVariable_in_parse_org_modelrefactoring_evolution_operators_VAR364);
            a1_0=parse_org_modelrefactoring_evolution_operators_QueryVariable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createVAR();
            				startIncompleteElement(element);
            			}
            			if (a1_0 != null) {
            				if (a1_0 != null) {
            					Object value = a1_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VAR__VARIABLE), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_2_0_0_2, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_modelrefactoring_evolution_operators_VAR_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_VAR"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_QueryVariable"
    // Operators.g:761:1: parse_org_modelrefactoring_evolution_operators_QueryVariable returns [org.modelrefactoring.evolution.operators.QueryVariable element = null] : (a0= IDENTIFIER ) a1= '=' (a2_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a3= '.' (a4_0= parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier ) ;
    public final org.modelrefactoring.evolution.operators.QueryVariable parse_org_modelrefactoring_evolution_operators_QueryVariable() throws RecognitionException {
        org.modelrefactoring.evolution.operators.QueryVariable element =  null;

        int parse_org_modelrefactoring_evolution_operators_QueryVariable_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        org.modelrefactoring.evolution.operators.Referrable a2_0 =null;

        org.modelrefactoring.evolution.operators.QueryVariableQualifier a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Operators.g:764:2: ( (a0= IDENTIFIER ) a1= '=' (a2_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a3= '.' (a4_0= parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier ) )
            // Operators.g:765:2: (a0= IDENTIFIER ) a1= '=' (a2_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a3= '.' (a4_0= parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier )
            {
            // Operators.g:765:2: (a0= IDENTIFIER )
            // Operators.g:766:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_QueryVariable401); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createQueryVariable();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_3_0_0_0, resolved, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[33]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_org_modelrefactoring_evolution_operators_QueryVariable422); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createQueryVariable();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[35]);
            	}

            // Operators.g:816:2: (a2_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            // Operators.g:817:3: a2_0= parse_org_modelrefactoring_evolution_operators_Referrable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_QueryVariable440);
            a2_0=parse_org_modelrefactoring_evolution_operators_Referrable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createQueryVariable();
            				startIncompleteElement(element);
            			}
            			if (a2_0 != null) {
            				if (a2_0 != null) {
            					Object value = a2_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_3_0_0_4, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[36]);
            	}

            a3=(Token)match(input,14,FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_QueryVariable458); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createQueryVariable();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_3_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[38]);
            	}

            // Operators.g:857:2: (a4_0= parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier )
            // Operators.g:858:3: a4_0= parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier_in_parse_org_modelrefactoring_evolution_operators_QueryVariable476);
            a4_0=parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createQueryVariable();
            				startIncompleteElement(element);
            			}
            			if (a4_0 != null) {
            				if (a4_0 != null) {
            					Object value = a4_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__QUALIFIER), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_3_0_0_8, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_modelrefactoring_evolution_operators_QueryVariable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_QueryVariable"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_EReferenceQualifier"
    // Operators.g:884:1: parse_org_modelrefactoring_evolution_operators_EReferenceQualifier returns [org.modelrefactoring.evolution.operators.EReferenceQualifier element = null] : (a0= IDENTIFIER ) ;
    public final org.modelrefactoring.evolution.operators.EReferenceQualifier parse_org_modelrefactoring_evolution_operators_EReferenceQualifier() throws RecognitionException {
        org.modelrefactoring.evolution.operators.EReferenceQualifier element =  null;

        int parse_org_modelrefactoring_evolution_operators_EReferenceQualifier_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Operators.g:887:2: ( (a0= IDENTIFIER ) )
            // Operators.g:888:2: (a0= IDENTIFIER )
            {
            // Operators.g:888:2: (a0= IDENTIFIER )
            // Operators.g:889:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_EReferenceQualifier513); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createEReferenceQualifier();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EREFERENCE_QUALIFIER__REFERENCE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.EReferenceQualifier, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEReferenceQualifierReferenceReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EREFERENCE_QUALIFIER__REFERENCE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EREFERENCE_QUALIFIER__REFERENCE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_4_0_0_0, proxy, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            				copyLocalizationInfos((CommonToken) a0, proxy);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_modelrefactoring_evolution_operators_EReferenceQualifier_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_EReferenceQualifier"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_EOperationQualifier"
    // Operators.g:929:1: parse_org_modelrefactoring_evolution_operators_EOperationQualifier returns [org.modelrefactoring.evolution.operators.EOperationQualifier element = null] : (a0= IDENTIFIER ) ;
    public final org.modelrefactoring.evolution.operators.EOperationQualifier parse_org_modelrefactoring_evolution_operators_EOperationQualifier() throws RecognitionException {
        org.modelrefactoring.evolution.operators.EOperationQualifier element =  null;

        int parse_org_modelrefactoring_evolution_operators_EOperationQualifier_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Operators.g:932:2: ( (a0= IDENTIFIER ) )
            // Operators.g:933:2: (a0= IDENTIFIER )
            {
            // Operators.g:933:2: (a0= IDENTIFIER )
            // Operators.g:934:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_EOperationQualifier553); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createEOperationQualifier();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOPERATION_QUALIFIER__OPERATION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EOperation proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEOperation();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.EOperationQualifier, org.eclipse.emf.ecore.EOperation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEOperationQualifierOperationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOPERATION_QUALIFIER__OPERATION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOPERATION_QUALIFIER__OPERATION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_5_0_0_0, proxy, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            				copyLocalizationInfos((CommonToken) a0, proxy);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_modelrefactoring_evolution_operators_EOperationQualifier_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_EOperationQualifier"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_CREATE"
    // Operators.g:974:1: parse_org_modelrefactoring_evolution_operators_CREATE returns [org.modelrefactoring.evolution.operators.CREATE element = null] : a0= 'create' (a1_0= parse_org_modelrefactoring_evolution_operators_TypeVariable ) a2= 'in' (a3_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a4= '.' (a5= IDENTIFIER ) ;
    public final org.modelrefactoring.evolution.operators.CREATE parse_org_modelrefactoring_evolution_operators_CREATE() throws RecognitionException {
        org.modelrefactoring.evolution.operators.CREATE element =  null;

        int parse_org_modelrefactoring_evolution_operators_CREATE_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a5=null;
        org.modelrefactoring.evolution.operators.TypeVariable a1_0 =null;

        org.modelrefactoring.evolution.operators.Referrable a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Operators.g:977:2: (a0= 'create' (a1_0= parse_org_modelrefactoring_evolution_operators_TypeVariable ) a2= 'in' (a3_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a4= '.' (a5= IDENTIFIER ) )
            // Operators.g:978:2: a0= 'create' (a1_0= parse_org_modelrefactoring_evolution_operators_TypeVariable ) a2= 'in' (a3_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a4= '.' (a5= IDENTIFIER )
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_org_modelrefactoring_evolution_operators_CREATE589); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createCREATE();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_6_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[39]);
            	}

            // Operators.g:992:2: (a1_0= parse_org_modelrefactoring_evolution_operators_TypeVariable )
            // Operators.g:993:3: a1_0= parse_org_modelrefactoring_evolution_operators_TypeVariable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_TypeVariable_in_parse_org_modelrefactoring_evolution_operators_CREATE607);
            a1_0=parse_org_modelrefactoring_evolution_operators_TypeVariable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createCREATE();
            				startIncompleteElement(element);
            			}
            			if (a1_0 != null) {
            				if (a1_0 != null) {
            					Object value = a1_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_6_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[40]);
            	}

            a2=(Token)match(input,18,FOLLOW_18_in_parse_org_modelrefactoring_evolution_operators_CREATE625); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createCREATE();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_6_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[41]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[42]);
            	}

            // Operators.g:1033:2: (a3_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            // Operators.g:1034:3: a3_0= parse_org_modelrefactoring_evolution_operators_Referrable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_CREATE643);
            a3_0=parse_org_modelrefactoring_evolution_operators_Referrable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createCREATE();
            				startIncompleteElement(element);
            			}
            			if (a3_0 != null) {
            				if (a3_0 != null) {
            					Object value = a3_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_6_0_0_5, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[43]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_CREATE661); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createCREATE();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_6_0_0_7, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[44]);
            	}

            // Operators.g:1073:2: (a5= IDENTIFIER )
            // Operators.g:1074:3: a5= IDENTIFIER
            {
            a5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_CREATE679); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createCREATE();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.CREATE, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCREATEParentCompositeReferenceReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_6_0_0_9, proxy, true);
            				copyLocalizationInfos((CommonToken) a5, element);
            				copyLocalizationInfos((CommonToken) a5, proxy);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_modelrefactoring_evolution_operators_CREATE_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_CREATE"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_TypeVariable"
    // Operators.g:1114:1: parse_org_modelrefactoring_evolution_operators_TypeVariable returns [org.modelrefactoring.evolution.operators.TypeVariable element = null] : (a0= IDENTIFIER ) a1= '=' a2= 'new' (a3= IDENTIFIER ) ;
    public final org.modelrefactoring.evolution.operators.TypeVariable parse_org_modelrefactoring_evolution_operators_TypeVariable() throws RecognitionException {
        org.modelrefactoring.evolution.operators.TypeVariable element =  null;

        int parse_org_modelrefactoring_evolution_operators_TypeVariable_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Operators.g:1117:2: ( (a0= IDENTIFIER ) a1= '=' a2= 'new' (a3= IDENTIFIER ) )
            // Operators.g:1118:2: (a0= IDENTIFIER ) a1= '=' a2= 'new' (a3= IDENTIFIER )
            {
            // Operators.g:1118:2: (a0= IDENTIFIER )
            // Operators.g:1119:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_TypeVariable719); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createTypeVariable();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_7_0_0_0, resolved, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[45]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_org_modelrefactoring_evolution_operators_TypeVariable740); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createTypeVariable();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_7_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[46]);
            	}

            a2=(Token)match(input,20,FOLLOW_20_in_parse_org_modelrefactoring_evolution_operators_TypeVariable754); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createTypeVariable();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_7_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[47]);
            	}

            // Operators.g:1182:2: (a3= IDENTIFIER )
            // Operators.g:1183:3: a3= IDENTIFIER
            {
            a3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_TypeVariable772); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createTypeVariable();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.TypeVariable, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypeVariableTypeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__TYPE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_7_0_0_6, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[48]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_modelrefactoring_evolution_operators_TypeVariable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_TypeVariable"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_DELETE"
    // Operators.g:1224:1: parse_org_modelrefactoring_evolution_operators_DELETE returns [org.modelrefactoring.evolution.operators.DELETE element = null] : a0= 'delete' (a1_0= parse_org_modelrefactoring_evolution_operators_Referrable ) ;
    public final org.modelrefactoring.evolution.operators.DELETE parse_org_modelrefactoring_evolution_operators_DELETE() throws RecognitionException {
        org.modelrefactoring.evolution.operators.DELETE element =  null;

        int parse_org_modelrefactoring_evolution_operators_DELETE_StartIndex = input.index();

        Token a0=null;
        org.modelrefactoring.evolution.operators.Referrable a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Operators.g:1227:2: (a0= 'delete' (a1_0= parse_org_modelrefactoring_evolution_operators_Referrable ) )
            // Operators.g:1228:2: a0= 'delete' (a1_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_org_modelrefactoring_evolution_operators_DELETE808); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createDELETE();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_8_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getDELETE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getDELETE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[50]);
            	}

            // Operators.g:1243:2: (a1_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            // Operators.g:1244:3: a1_0= parse_org_modelrefactoring_evolution_operators_Referrable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_DELETE826);
            a1_0=parse_org_modelrefactoring_evolution_operators_Referrable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createDELETE();
            				startIncompleteElement(element);
            			}
            			if (a1_0 != null) {
            				if (a1_0 != null) {
            					Object value = a1_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.DELETE__DELETION), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_8_0_0_2, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_modelrefactoring_evolution_operators_DELETE_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_DELETE"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_ASSIGN"
    // Operators.g:1270:1: parse_org_modelrefactoring_evolution_operators_ASSIGN returns [org.modelrefactoring.evolution.operators.ASSIGN element = null] : (a0_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4= QUOTED_34_34 ) ;
    public final org.modelrefactoring.evolution.operators.ASSIGN parse_org_modelrefactoring_evolution_operators_ASSIGN() throws RecognitionException {
        org.modelrefactoring.evolution.operators.ASSIGN element =  null;

        int parse_org_modelrefactoring_evolution_operators_ASSIGN_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        org.modelrefactoring.evolution.operators.Referrable a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Operators.g:1273:2: ( (a0_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4= QUOTED_34_34 ) )
            // Operators.g:1274:2: (a0_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4= QUOTED_34_34 )
            {
            // Operators.g:1274:2: (a0_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            // Operators.g:1275:3: a0_0= parse_org_modelrefactoring_evolution_operators_Referrable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_ASSIGN863);
            a0_0=parse_org_modelrefactoring_evolution_operators_Referrable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createASSIGN();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_9_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[51]);
            	}

            a1=(Token)match(input,14,FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_ASSIGN881); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createASSIGN();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_9_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[52]);
            	}

            // Operators.g:1314:2: (a2= IDENTIFIER )
            // Operators.g:1315:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_ASSIGN899); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createASSIGN();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EAttribute proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.ASSIGN, org.eclipse.emf.ecore.EAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getASSIGNAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_9_0_0_4, proxy, true);
            				copyLocalizationInfos((CommonToken) a2, element);
            				copyLocalizationInfos((CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[53]);
            	}

            a3=(Token)match(input,15,FOLLOW_15_in_parse_org_modelrefactoring_evolution_operators_ASSIGN920); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createASSIGN();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_9_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[54]);
            	}

            // Operators.g:1368:2: (a4= QUOTED_34_34 )
            // Operators.g:1369:3: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_modelrefactoring_evolution_operators_ASSIGN938); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createASSIGN();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__VALUE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
            				}
            				java.lang.Object resolved = (java.lang.Object) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__VALUE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_9_0_0_8, resolved, true);
            				copyLocalizationInfos((CommonToken) a4, element);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_modelrefactoring_evolution_operators_ASSIGN_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_ASSIGN"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_SET"
    // Operators.g:1405:1: parse_org_modelrefactoring_evolution_operators_SET returns [org.modelrefactoring.evolution.operators.SET element = null] : (a0_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4_0= parse_org_modelrefactoring_evolution_operators_Referrable ) ;
    public final org.modelrefactoring.evolution.operators.SET parse_org_modelrefactoring_evolution_operators_SET() throws RecognitionException {
        org.modelrefactoring.evolution.operators.SET element =  null;

        int parse_org_modelrefactoring_evolution_operators_SET_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.modelrefactoring.evolution.operators.Referrable a0_0 =null;

        org.modelrefactoring.evolution.operators.Referrable a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Operators.g:1408:2: ( (a0_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4_0= parse_org_modelrefactoring_evolution_operators_Referrable ) )
            // Operators.g:1409:2: (a0_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            {
            // Operators.g:1409:2: (a0_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            // Operators.g:1410:3: a0_0= parse_org_modelrefactoring_evolution_operators_Referrable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_SET978);
            a0_0=parse_org_modelrefactoring_evolution_operators_Referrable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createSET();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE_OWNER), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_10_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[55]);
            	}

            a1=(Token)match(input,14,FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_SET996); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createSET();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_10_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[56]);
            	}

            // Operators.g:1449:2: (a2= IDENTIFIER )
            // Operators.g:1450:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_SET1014); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createSET();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.SET, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSETReferenceReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_10_0_0_4, proxy, true);
            				copyLocalizationInfos((CommonToken) a2, element);
            				copyLocalizationInfos((CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[57]);
            	}

            a3=(Token)match(input,15,FOLLOW_15_in_parse_org_modelrefactoring_evolution_operators_SET1035); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createSET();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_10_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[58]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[59]);
            	}

            // Operators.g:1504:2: (a4_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            // Operators.g:1505:3: a4_0= parse_org_modelrefactoring_evolution_operators_Referrable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_SET1053);
            a4_0=parse_org_modelrefactoring_evolution_operators_Referrable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createSET();
            				startIncompleteElement(element);
            			}
            			if (a4_0 != null) {
            				if (a4_0 != null) {
            					Object value = a4_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__VALUE), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_10_0_0_8, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_modelrefactoring_evolution_operators_SET_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_SET"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_MOVE"
    // Operators.g:1531:1: parse_org_modelrefactoring_evolution_operators_MOVE returns [org.modelrefactoring.evolution.operators.MOVE element = null] : a0= 'move' (a1_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a2= 'to' (a3_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a4= '.' (a5= IDENTIFIER ) ;
    public final org.modelrefactoring.evolution.operators.MOVE parse_org_modelrefactoring_evolution_operators_MOVE() throws RecognitionException {
        org.modelrefactoring.evolution.operators.MOVE element =  null;

        int parse_org_modelrefactoring_evolution_operators_MOVE_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a5=null;
        org.modelrefactoring.evolution.operators.Referrable a1_0 =null;

        org.modelrefactoring.evolution.operators.Referrable a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Operators.g:1534:2: (a0= 'move' (a1_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a2= 'to' (a3_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a4= '.' (a5= IDENTIFIER ) )
            // Operators.g:1535:2: a0= 'move' (a1_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a2= 'to' (a3_0= parse_org_modelrefactoring_evolution_operators_Referrable ) a4= '.' (a5= IDENTIFIER )
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_org_modelrefactoring_evolution_operators_MOVE1086); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createMOVE();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_11_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[61]);
            	}

            // Operators.g:1550:2: (a1_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            // Operators.g:1551:3: a1_0= parse_org_modelrefactoring_evolution_operators_Referrable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_MOVE1104);
            a1_0=parse_org_modelrefactoring_evolution_operators_Referrable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createMOVE();
            				startIncompleteElement(element);
            			}
            			if (a1_0 != null) {
            				if (a1_0 != null) {
            					Object value = a1_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__MOVEE), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_11_0_0_2, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[62]);
            	}

            a2=(Token)match(input,21,FOLLOW_21_in_parse_org_modelrefactoring_evolution_operators_MOVE1122); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createMOVE();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_11_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[63]);
            		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[64]);
            	}

            // Operators.g:1591:2: (a3_0= parse_org_modelrefactoring_evolution_operators_Referrable )
            // Operators.g:1592:3: a3_0= parse_org_modelrefactoring_evolution_operators_Referrable
            {
            pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_MOVE1140);
            a3_0=parse_org_modelrefactoring_evolution_operators_Referrable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createMOVE();
            				startIncompleteElement(element);
            			}
            			if (a3_0 != null) {
            				if (a3_0 != null) {
            					Object value = a3_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__NEW_PARENT), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_11_0_0_6, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[65]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_MOVE1158); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createMOVE();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_11_0_0_8, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[66]);
            	}

            // Operators.g:1631:2: (a5= IDENTIFIER )
            // Operators.g:1632:3: a5= IDENTIFIER
            {
            a5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_MOVE1176); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createMOVE();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__PARENT_REFERENCE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragmentFactory<org.modelrefactoring.evolution.operators.MOVE, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMOVEParentReferenceReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__PARENT_REFERENCE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__PARENT_REFERENCE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_11_0_0_10, proxy, true);
            				copyLocalizationInfos((CommonToken) a5, element);
            				copyLocalizationInfos((CommonToken) a5, proxy);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_modelrefactoring_evolution_operators_MOVE_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_MOVE"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_Referrable"
    // Operators.g:1672:1: parse_org_modelrefactoring_evolution_operators_Referrable returns [org.modelrefactoring.evolution.operators.Referrable element = null] : (c0= parse_org_modelrefactoring_evolution_operators_EObjectReference |c1= parse_org_modelrefactoring_evolution_operators_VariableReference );
    public final org.modelrefactoring.evolution.operators.Referrable parse_org_modelrefactoring_evolution_operators_Referrable() throws RecognitionException {
        org.modelrefactoring.evolution.operators.Referrable element =  null;

        int parse_org_modelrefactoring_evolution_operators_Referrable_StartIndex = input.index();

        org.modelrefactoring.evolution.operators.EObjectReference c0 =null;

        org.modelrefactoring.evolution.operators.VariableReference c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Operators.g:1673:2: (c0= parse_org_modelrefactoring_evolution_operators_EObjectReference |c1= parse_org_modelrefactoring_evolution_operators_VariableReference )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QUOTED_60_62) ) {
                alt3=1;
            }
            else if ( (LA3_0==IDENTIFIER) ) {
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
                    // Operators.g:1674:2: c0= parse_org_modelrefactoring_evolution_operators_EObjectReference
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_EObjectReference_in_parse_org_modelrefactoring_evolution_operators_Referrable1208);
                    c0=parse_org_modelrefactoring_evolution_operators_EObjectReference();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Operators.g:1675:4: c1= parse_org_modelrefactoring_evolution_operators_VariableReference
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_VariableReference_in_parse_org_modelrefactoring_evolution_operators_Referrable1218);
                    c1=parse_org_modelrefactoring_evolution_operators_VariableReference();

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
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_modelrefactoring_evolution_operators_Referrable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_Referrable"



    // $ANTLR start "parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier"
    // Operators.g:1679:1: parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier returns [org.modelrefactoring.evolution.operators.QueryVariableQualifier element = null] : (c0= parse_org_modelrefactoring_evolution_operators_EReferenceQualifier |c1= parse_org_modelrefactoring_evolution_operators_EOperationQualifier );
    public final org.modelrefactoring.evolution.operators.QueryVariableQualifier parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier() throws RecognitionException {
        org.modelrefactoring.evolution.operators.QueryVariableQualifier element =  null;

        int parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier_StartIndex = input.index();

        org.modelrefactoring.evolution.operators.EReferenceQualifier c0 =null;

        org.modelrefactoring.evolution.operators.EOperationQualifier c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Operators.g:1680:2: (c0= parse_org_modelrefactoring_evolution_operators_EReferenceQualifier |c1= parse_org_modelrefactoring_evolution_operators_EOperationQualifier )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                int LA4_1 = input.LA(2);

                if ( (synpred8_Operators()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // Operators.g:1681:2: c0= parse_org_modelrefactoring_evolution_operators_EReferenceQualifier
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_EReferenceQualifier_in_parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier1239);
                    c0=parse_org_modelrefactoring_evolution_operators_EReferenceQualifier();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Operators.g:1682:4: c1= parse_org_modelrefactoring_evolution_operators_EOperationQualifier
                    {
                    pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_EOperationQualifier_in_parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier1249);
                    c1=parse_org_modelrefactoring_evolution_operators_EOperationQualifier();

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
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier"

    // $ANTLR start synpred8_Operators
    public final void synpred8_Operators_fragment() throws RecognitionException {
        org.modelrefactoring.evolution.operators.EReferenceQualifier c0 =null;


        // Operators.g:1681:2: (c0= parse_org_modelrefactoring_evolution_operators_EReferenceQualifier )
        // Operators.g:1681:2: c0= parse_org_modelrefactoring_evolution_operators_EReferenceQualifier
        {
        pushFollow(FOLLOW_parse_org_modelrefactoring_evolution_operators_EReferenceQualifier_in_synpred8_Operators1239);
        c0=parse_org_modelrefactoring_evolution_operators_EReferenceQualifier();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred8_Operators

    // Delegated rules

    public final boolean synpred8_Operators() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_Operators_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\16\uffff";
    static final String DFA1_eofS =
        "\16\uffff";
    static final String DFA1_minS =
        "\1\5\2\uffff\1\15\1\16\2\uffff\1\12\1\5\1\15\1\17\1\5\2\uffff";
    static final String DFA1_maxS =
        "\1\26\2\uffff\2\16\2\uffff\1\12\1\5\1\16\1\17\1\12\2\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\5\1\6\5\uffff\1\3\1\4";
    static final String DFA1_specialS =
        "\16\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\4\4\uffff\1\3\5\uffff\1\1\1\2\1\uffff\1\5\2\uffff\1\6",
            "",
            "",
            "\1\7\1\10",
            "\1\10",
            "",
            "",
            "\1\11",
            "\1\12",
            "\1\7\1\10",
            "\1\13",
            "\1\15\3\uffff\1\14\1\15",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "528:2: (c0= parse_org_modelrefactoring_evolution_operators_CREATE |c1= parse_org_modelrefactoring_evolution_operators_DELETE |c2= parse_org_modelrefactoring_evolution_operators_ASSIGN |c3= parse_org_modelrefactoring_evolution_operators_SET |c4= parse_org_modelrefactoring_evolution_operators_MOVE |c5= parse_org_modelrefactoring_evolution_operators_VAR )";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_CREATE_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_DELETE_in_start96 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_ASSIGN_in_start110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_SET_in_start124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_MOVE_in_start138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_VAR_in_start152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_operators_EObjectReference189 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_parse_org_modelrefactoring_evolution_operators_EObjectReference219 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_modelrefactoring_evolution_operators_EObjectReference245 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_VariableReference310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_org_modelrefactoring_evolution_operators_VAR346 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_QueryVariable_in_parse_org_modelrefactoring_evolution_operators_VAR364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_QueryVariable401 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_modelrefactoring_evolution_operators_QueryVariable422 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_QueryVariable440 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_QueryVariable458 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier_in_parse_org_modelrefactoring_evolution_operators_QueryVariable476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_EReferenceQualifier513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_EOperationQualifier553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_modelrefactoring_evolution_operators_CREATE589 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_TypeVariable_in_parse_org_modelrefactoring_evolution_operators_CREATE607 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_modelrefactoring_evolution_operators_CREATE625 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_CREATE643 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_CREATE661 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_CREATE679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_TypeVariable719 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_modelrefactoring_evolution_operators_TypeVariable740 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_modelrefactoring_evolution_operators_TypeVariable754 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_TypeVariable772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_org_modelrefactoring_evolution_operators_DELETE808 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_DELETE826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_ASSIGN863 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_ASSIGN881 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_ASSIGN899 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_modelrefactoring_evolution_operators_ASSIGN920 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_modelrefactoring_evolution_operators_ASSIGN938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_SET978 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_SET996 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_SET1014 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_modelrefactoring_evolution_operators_SET1035 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_SET1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_org_modelrefactoring_evolution_operators_MOVE1086 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_MOVE1104 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_modelrefactoring_evolution_operators_MOVE1122 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_Referrable_in_parse_org_modelrefactoring_evolution_operators_MOVE1140 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_modelrefactoring_evolution_operators_MOVE1158 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_modelrefactoring_evolution_operators_MOVE1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_EObjectReference_in_parse_org_modelrefactoring_evolution_operators_Referrable1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_VariableReference_in_parse_org_modelrefactoring_evolution_operators_Referrable1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_EReferenceQualifier_in_parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_EOperationQualifier_in_parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_modelrefactoring_evolution_operators_EReferenceQualifier_in_synpred8_Operators1239 = new BitSet(new long[]{0x0000000000000002L});

}