// $ANTLR 3.4

	package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TestpropertiesParser extends TestpropertiesANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "FLOAT", "INTEGER", "LINEBREAK", "QUOTED_34_34", "QUOTED_60_62", "QUOTED_91_93", "TEXT", "WHITESPACE", "'='"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int COMMENT=4;
    public static final int FLOAT=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_34_34=8;
    public static final int QUOTED_60_62=9;
    public static final int QUOTED_91_93=10;
    public static final int TEXT=11;
    public static final int WHITESPACE=12;

    // delegates
    public TestpropertiesANTLRParserBase[] getDelegates() {
        return new TestpropertiesANTLRParserBase[] {};
    }

    // delegators


    public TestpropertiesParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TestpropertiesParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(12 + 1);
         

    }

    public String[] getTokenNames() { return TestpropertiesParser.tokenNames; }
    public String getGrammarFileName() { return "Testproperties.g"; }


    	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolverFactory tokenResolverFactory = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenResolverFactory();
    	
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
    	private java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal>();
    	
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
    	
    	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap;
    	
    	private org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesSyntaxErrorMessageConverter syntaxErrorMessageConverter = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>() {
    			public boolean execute(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem() {
    					public org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity getSeverity() {
    						return org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity.ERROR;
    					}
    					public org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType getType() {
    						return org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesLocalizedMessage message) {
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
    		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement terminal = org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesFollowSetProvider.TERMINALS[terminalID];
    		org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] containmentFeatures = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesFollowSetProvider.LINKS[ids[i]];
    		}
    		org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainmentTrace containmentTrace = new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal expectedElement = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>() {
    			public boolean execute(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource) {
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
    		final org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>() {
    			public boolean execute(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource) {
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
    	protected void setLocalizationEnd(java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>() {
    			public boolean execute(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new TestpropertiesParser(new org.antlr.runtime3_4_0.CommonTokenStream(new TestpropertiesLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new TestpropertiesParser(new org.antlr.runtime3_4_0.CommonTokenStream(new TestpropertiesLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public TestpropertiesParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((TestpropertiesLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((TestpropertiesLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.PropertyModel.class) {
    				return parse_org_emftext_refactoring_tests_properties_PropertyModel();
    			}
    			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.Category.class) {
    				return parse_org_emftext_refactoring_tests_properties_Category();
    			}
    			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.KeyValuePair.class) {
    				return parse_org_emftext_refactoring_tests_properties_KeyValuePair();
    			}
    			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.Key.class) {
    				return parse_org_emftext_refactoring_tests_properties_Key();
    			}
    			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.EObjectReferenceValue.class) {
    				return parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue();
    			}
    			if (type.getInstanceClass() == org.emftext.refactoring.tests.properties.StringValue.class) {
    				return parse_org_emftext_refactoring_tests_properties_StringValue();
    			}
    		}
    		throw new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>>();
    		org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesParseResult parseResult = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesParseResult();
    		if (disableLocationMap) {
    			locationMap = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesDevNullLocationMap();
    		} else {
    			locationMap = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesLocationMap();
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
    	
    	public java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesParseResult result = parse();
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
    			for (org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal>();
    		java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 12;
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
    				for (org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesPair<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesPair<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[]> newFollowerPair : newFollowers) {
    							org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainmentTrace containmentTrace = new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainmentTrace(null, newFollowerPair.getRight());
    							org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal newFollowTerminal = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedTerminal expectedElement, int tokenIndex) {
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
    // Testproperties.g:471:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_refactoring_tests_properties_PropertyModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.emftext.refactoring.tests.properties.PropertyModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Testproperties.g:472:2: ( (c0= parse_org_emftext_refactoring_tests_properties_PropertyModel ) EOF )
            // Testproperties.g:473:2: (c0= parse_org_emftext_refactoring_tests_properties_PropertyModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Testproperties.g:478:2: (c0= parse_org_emftext_refactoring_tests_properties_PropertyModel )
            // Testproperties.g:479:3: c0= parse_org_emftext_refactoring_tests_properties_PropertyModel
            {
            pushFollow(FOLLOW_parse_org_emftext_refactoring_tests_properties_PropertyModel_in_start82);
            c0=parse_org_emftext_refactoring_tests_properties_PropertyModel();

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



    // $ANTLR start "parse_org_emftext_refactoring_tests_properties_PropertyModel"
    // Testproperties.g:487:1: parse_org_emftext_refactoring_tests_properties_PropertyModel returns [org.emftext.refactoring.tests.properties.PropertyModel element = null] : ( ( (a0_0= parse_org_emftext_refactoring_tests_properties_Category ) ) )* ;
    public final org.emftext.refactoring.tests.properties.PropertyModel parse_org_emftext_refactoring_tests_properties_PropertyModel() throws RecognitionException {
        org.emftext.refactoring.tests.properties.PropertyModel element =  null;

        int parse_org_emftext_refactoring_tests_properties_PropertyModel_StartIndex = input.index();

        org.emftext.refactoring.tests.properties.Category a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Testproperties.g:490:2: ( ( ( (a0_0= parse_org_emftext_refactoring_tests_properties_Category ) ) )* )
            // Testproperties.g:491:2: ( ( (a0_0= parse_org_emftext_refactoring_tests_properties_Category ) ) )*
            {
            // Testproperties.g:491:2: ( ( (a0_0= parse_org_emftext_refactoring_tests_properties_Category ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==QUOTED_91_93) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Testproperties.g:492:3: ( (a0_0= parse_org_emftext_refactoring_tests_properties_Category ) )
            	    {
            	    // Testproperties.g:492:3: ( (a0_0= parse_org_emftext_refactoring_tests_properties_Category ) )
            	    // Testproperties.g:493:4: (a0_0= parse_org_emftext_refactoring_tests_properties_Category )
            	    {
            	    // Testproperties.g:493:4: (a0_0= parse_org_emftext_refactoring_tests_properties_Category )
            	    // Testproperties.g:494:5: a0_0= parse_org_emftext_refactoring_tests_properties_Category
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_refactoring_tests_properties_Category_in_parse_org_emftext_refactoring_tests_properties_PropertyModel130);
            	    a0_0=parse_org_emftext_refactoring_tests_properties_Category();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createPropertyModel();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a0_0 != null) {
            	    						if (a0_0 != null) {
            	    							Object value = a0_0;
            	    							addObjectToList(element, org.emftext.refactoring.tests.properties.PropertiesPackage.PROPERTY_MODEL__CATEGORIES, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_0_0_0_0_0_0_0, a0_0, true);
            	    						copyLocalizationInfos(a0_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[1]);
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
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[2]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_refactoring_tests_properties_PropertyModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_refactoring_tests_properties_PropertyModel"



    // $ANTLR start "parse_org_emftext_refactoring_tests_properties_Category"
    // Testproperties.g:528:1: parse_org_emftext_refactoring_tests_properties_Category returns [org.emftext.refactoring.tests.properties.Category element = null] : (a0= QUOTED_91_93 ) ( (a1_0= parse_org_emftext_refactoring_tests_properties_KeyValuePair ) )* ;
    public final org.emftext.refactoring.tests.properties.Category parse_org_emftext_refactoring_tests_properties_Category() throws RecognitionException {
        org.emftext.refactoring.tests.properties.Category element =  null;

        int parse_org_emftext_refactoring_tests_properties_Category_StartIndex = input.index();

        Token a0=null;
        org.emftext.refactoring.tests.properties.KeyValuePair a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Testproperties.g:531:2: ( (a0= QUOTED_91_93 ) ( (a1_0= parse_org_emftext_refactoring_tests_properties_KeyValuePair ) )* )
            // Testproperties.g:532:2: (a0= QUOTED_91_93 ) ( (a1_0= parse_org_emftext_refactoring_tests_properties_KeyValuePair ) )*
            {
            // Testproperties.g:532:2: (a0= QUOTED_91_93 )
            // Testproperties.g:533:3: a0= QUOTED_91_93
            {
            a0=(Token)match(input,QUOTED_91_93,FOLLOW_QUOTED_91_93_in_parse_org_emftext_refactoring_tests_properties_Category190); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createCategory();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_91_93");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_1_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[6]);
            	}

            // Testproperties.g:571:2: ( (a1_0= parse_org_emftext_refactoring_tests_properties_KeyValuePair ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= QUOTED_34_34 && LA2_0 <= QUOTED_60_62)||LA2_0==TEXT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Testproperties.g:572:3: (a1_0= parse_org_emftext_refactoring_tests_properties_KeyValuePair )
            	    {
            	    // Testproperties.g:572:3: (a1_0= parse_org_emftext_refactoring_tests_properties_KeyValuePair )
            	    // Testproperties.g:573:4: a1_0= parse_org_emftext_refactoring_tests_properties_KeyValuePair
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_refactoring_tests_properties_KeyValuePair_in_parse_org_emftext_refactoring_tests_properties_Category220);
            	    a1_0=parse_org_emftext_refactoring_tests_properties_KeyValuePair();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createCategory();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a1_0 != null) {
            	    					if (a1_0 != null) {
            	    						Object value = a1_0;
            	    						addObjectToList(element, org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__PAIRS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_1_0_0_2, a1_0, true);
            	    					copyLocalizationInfos(a1_0, element);
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
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[10]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_refactoring_tests_properties_Category_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_refactoring_tests_properties_Category"



    // $ANTLR start "parse_org_emftext_refactoring_tests_properties_KeyValuePair"
    // Testproperties.g:604:1: parse_org_emftext_refactoring_tests_properties_KeyValuePair returns [org.emftext.refactoring.tests.properties.KeyValuePair element = null] : ( ( (a0_0= parse_org_emftext_refactoring_tests_properties_Key ) a1= '=' ) )? (a2_0= parse_org_emftext_refactoring_tests_properties_Value ) ;
    public final org.emftext.refactoring.tests.properties.KeyValuePair parse_org_emftext_refactoring_tests_properties_KeyValuePair() throws RecognitionException {
        org.emftext.refactoring.tests.properties.KeyValuePair element =  null;

        int parse_org_emftext_refactoring_tests_properties_KeyValuePair_StartIndex = input.index();

        Token a1=null;
        org.emftext.refactoring.tests.properties.Key a0_0 =null;

        org.emftext.refactoring.tests.properties.Value a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Testproperties.g:607:2: ( ( ( (a0_0= parse_org_emftext_refactoring_tests_properties_Key ) a1= '=' ) )? (a2_0= parse_org_emftext_refactoring_tests_properties_Value ) )
            // Testproperties.g:608:2: ( ( (a0_0= parse_org_emftext_refactoring_tests_properties_Key ) a1= '=' ) )? (a2_0= parse_org_emftext_refactoring_tests_properties_Value )
            {
            // Testproperties.g:608:2: ( ( (a0_0= parse_org_emftext_refactoring_tests_properties_Key ) a1= '=' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==TEXT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Testproperties.g:609:3: ( (a0_0= parse_org_emftext_refactoring_tests_properties_Key ) a1= '=' )
                    {
                    // Testproperties.g:609:3: ( (a0_0= parse_org_emftext_refactoring_tests_properties_Key ) a1= '=' )
                    // Testproperties.g:610:4: (a0_0= parse_org_emftext_refactoring_tests_properties_Key ) a1= '='
                    {
                    // Testproperties.g:610:4: (a0_0= parse_org_emftext_refactoring_tests_properties_Key )
                    // Testproperties.g:611:5: a0_0= parse_org_emftext_refactoring_tests_properties_Key
                    {
                    pushFollow(FOLLOW_parse_org_emftext_refactoring_tests_properties_Key_in_parse_org_emftext_refactoring_tests_properties_KeyValuePair276);
                    a0_0=parse_org_emftext_refactoring_tests_properties_Key();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKeyValuePair();
                    						startIncompleteElement(element);
                    					}
                    					if (a0_0 != null) {
                    						if (a0_0 != null) {
                    							Object value = a0_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__KEY), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_2_0_0_0_0_0_0, a0_0, true);
                    						copyLocalizationInfos(a0_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[11]);
                    			}

                    a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_refactoring_tests_properties_KeyValuePair304); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKeyValuePair();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_2_0_0_0_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[12]);
                    				addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[13]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[15]);
            	}

            // Testproperties.g:659:2: (a2_0= parse_org_emftext_refactoring_tests_properties_Value )
            // Testproperties.g:660:3: a2_0= parse_org_emftext_refactoring_tests_properties_Value
            {
            pushFollow(FOLLOW_parse_org_emftext_refactoring_tests_properties_Value_in_parse_org_emftext_refactoring_tests_properties_KeyValuePair341);
            a2_0=parse_org_emftext_refactoring_tests_properties_Value();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKeyValuePair();
            				startIncompleteElement(element);
            			}
            			if (a2_0 != null) {
            				if (a2_0 != null) {
            					Object value = a2_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__VALUE), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_2_0_0_1, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[16]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[19]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_refactoring_tests_properties_KeyValuePair_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_refactoring_tests_properties_KeyValuePair"



    // $ANTLR start "parse_org_emftext_refactoring_tests_properties_Key"
    // Testproperties.g:690:1: parse_org_emftext_refactoring_tests_properties_Key returns [org.emftext.refactoring.tests.properties.Key element = null] : (a0= TEXT ) ;
    public final org.emftext.refactoring.tests.properties.Key parse_org_emftext_refactoring_tests_properties_Key() throws RecognitionException {
        org.emftext.refactoring.tests.properties.Key element =  null;

        int parse_org_emftext_refactoring_tests_properties_Key_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Testproperties.g:693:2: ( (a0= TEXT ) )
            // Testproperties.g:694:2: (a0= TEXT )
            {
            // Testproperties.g:694:2: (a0= TEXT )
            // Testproperties.g:695:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_refactoring_tests_properties_Key378); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createKey();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_3_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[20]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_refactoring_tests_properties_Key_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_refactoring_tests_properties_Key"



    // $ANTLR start "parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue"
    // Testproperties.g:732:1: parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue returns [org.emftext.refactoring.tests.properties.EObjectReferenceValue element = null] : (a0= QUOTED_60_62 ) ;
    public final org.emftext.refactoring.tests.properties.EObjectReferenceValue parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue() throws RecognitionException {
        org.emftext.refactoring.tests.properties.EObjectReferenceValue element =  null;

        int parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Testproperties.g:735:2: ( (a0= QUOTED_60_62 ) )
            // Testproperties.g:736:2: (a0= QUOTED_60_62 )
            {
            // Testproperties.g:736:2: (a0= QUOTED_60_62 )
            // Testproperties.g:737:3: a0= QUOTED_60_62
            {
            a0=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue418); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createEObjectReferenceValue();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EObject proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEObject();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContextDependentURIFragmentFactory<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEObjectReferenceValueObjectReferenceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_4_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[23]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[24]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue"



    // $ANTLR start "parse_org_emftext_refactoring_tests_properties_StringValue"
    // Testproperties.g:781:1: parse_org_emftext_refactoring_tests_properties_StringValue returns [org.emftext.refactoring.tests.properties.StringValue element = null] : (a0= QUOTED_34_34 ) ;
    public final org.emftext.refactoring.tests.properties.StringValue parse_org_emftext_refactoring_tests_properties_StringValue() throws RecognitionException {
        org.emftext.refactoring.tests.properties.StringValue element =  null;

        int parse_org_emftext_refactoring_tests_properties_StringValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Testproperties.g:784:2: ( (a0= QUOTED_34_34 ) )
            // Testproperties.g:785:2: (a0= QUOTED_34_34 )
            {
            // Testproperties.g:785:2: (a0= QUOTED_34_34 )
            // Testproperties.g:786:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_refactoring_tests_properties_StringValue458); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.refactoring.tests.properties.PropertiesFactory.eINSTANCE.createStringValue();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_5_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectationConstants.EXPECTATIONS[28]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_refactoring_tests_properties_StringValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_refactoring_tests_properties_StringValue"



    // $ANTLR start "parse_org_emftext_refactoring_tests_properties_Value"
    // Testproperties.g:826:1: parse_org_emftext_refactoring_tests_properties_Value returns [org.emftext.refactoring.tests.properties.Value element = null] : (c0= parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue |c1= parse_org_emftext_refactoring_tests_properties_StringValue );
    public final org.emftext.refactoring.tests.properties.Value parse_org_emftext_refactoring_tests_properties_Value() throws RecognitionException {
        org.emftext.refactoring.tests.properties.Value element =  null;

        int parse_org_emftext_refactoring_tests_properties_Value_StartIndex = input.index();

        org.emftext.refactoring.tests.properties.EObjectReferenceValue c0 =null;

        org.emftext.refactoring.tests.properties.StringValue c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Testproperties.g:827:2: (c0= parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue |c1= parse_org_emftext_refactoring_tests_properties_StringValue )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==QUOTED_60_62) ) {
                alt4=1;
            }
            else if ( (LA4_0==QUOTED_34_34) ) {
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
                    // Testproperties.g:828:2: c0= parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue
                    {
                    pushFollow(FOLLOW_parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue_in_parse_org_emftext_refactoring_tests_properties_Value490);
                    c0=parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Testproperties.g:829:4: c1= parse_org_emftext_refactoring_tests_properties_StringValue
                    {
                    pushFollow(FOLLOW_parse_org_emftext_refactoring_tests_properties_StringValue_in_parse_org_emftext_refactoring_tests_properties_Value500);
                    c1=parse_org_emftext_refactoring_tests_properties_StringValue();

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
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_refactoring_tests_properties_Value_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_refactoring_tests_properties_Value"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_emftext_refactoring_tests_properties_PropertyModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_refactoring_tests_properties_Category_in_parse_org_emftext_refactoring_tests_properties_PropertyModel130 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_QUOTED_91_93_in_parse_org_emftext_refactoring_tests_properties_Category190 = new BitSet(new long[]{0x0000000000000B02L});
    public static final BitSet FOLLOW_parse_org_emftext_refactoring_tests_properties_KeyValuePair_in_parse_org_emftext_refactoring_tests_properties_Category220 = new BitSet(new long[]{0x0000000000000B02L});
    public static final BitSet FOLLOW_parse_org_emftext_refactoring_tests_properties_Key_in_parse_org_emftext_refactoring_tests_properties_KeyValuePair276 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_refactoring_tests_properties_KeyValuePair304 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_parse_org_emftext_refactoring_tests_properties_Value_in_parse_org_emftext_refactoring_tests_properties_KeyValuePair341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_refactoring_tests_properties_Key378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_refactoring_tests_properties_StringValue458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_refactoring_tests_properties_EObjectReferenceValue_in_parse_org_emftext_refactoring_tests_properties_Value490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_refactoring_tests_properties_StringValue_in_parse_org_emftext_refactoring_tests_properties_Value500 = new BitSet(new long[]{0x0000000000000002L});

}