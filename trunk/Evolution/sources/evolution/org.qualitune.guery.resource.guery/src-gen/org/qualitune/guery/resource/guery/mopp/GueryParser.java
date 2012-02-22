// $ANTLR 3.4

	package org.qualitune.guery.resource.guery.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GueryParser extends GueryANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CARDINALITY", "CLASSNAME", "IDENTIFIER", "LINEBREAK", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "'('", "')'", "','", "'>'", "'['", "']'", "'and'", "'by'", "'connected'", "'find all'", "'group'", "'motif'", "'not'", "'prepare'", "'select'", "'where'", "'with'"
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
    public static final int T__26=26;
    public static final int T__27=27;
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
        this.state.initializeRuleMemo(27 + 1);
         

    }

    public String[] getTokenNames() { return GueryParser.tokenNames; }
    public String getGrammarFileName() { return "Guery.g"; }


    	private org.qualitune.guery.resource.guery.IGueryTokenResolverFactory tokenResolverFactory = new org.qualitune.guery.resource.guery.mopp.GueryTokenResolverFactory();
    	
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
    	private java.util.List<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal> expectedElements = new java.util.ArrayList<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
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
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>() {
    			public boolean execute(org.qualitune.guery.resource.guery.IGueryTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.qualitune.guery.resource.guery.IGueryProblem() {
    					public org.qualitune.guery.resource.guery.GueryEProblemSeverity getSeverity() {
    						return org.qualitune.guery.resource.guery.GueryEProblemSeverity.ERROR;
    					}
    					public org.qualitune.guery.resource.guery.GueryEProblemType getType() {
    						return org.qualitune.guery.resource.guery.GueryEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<org.qualitune.guery.resource.guery.IGueryQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		org.qualitune.guery.resource.guery.IGueryExpectedElement terminal = org.qualitune.guery.resource.guery.grammar.GueryFollowSetProvider.TERMINALS[terminalID];
    		org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[] containmentFeatures = new org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = org.qualitune.guery.resource.guery.grammar.GueryFollowSetProvider.LINKS[ids[i]];
    		}
    		org.qualitune.guery.resource.guery.grammar.GueryContainmentTrace containmentTrace = new org.qualitune.guery.resource.guery.grammar.GueryContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal expectedElement = new org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>() {
    			public boolean execute(org.qualitune.guery.resource.guery.IGueryTextResource resource) {
    				org.qualitune.guery.resource.guery.IGueryLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
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
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>() {
    			public boolean execute(org.qualitune.guery.resource.guery.IGueryTextResource resource) {
    				org.qualitune.guery.resource.guery.IGueryLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
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
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(java.util.Collection<org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>() {
    			public boolean execute(org.qualitune.guery.resource.guery.IGueryTextResource resource) {
    				org.qualitune.guery.resource.guery.IGueryLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.qualitune.guery.resource.guery.IGueryTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new GueryParser(new org.antlr.runtime3_4_0.CommonTokenStream(new GueryLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new GueryParser(new org.antlr.runtime3_4_0.CommonTokenStream(new GueryLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().logError("Error while creating parser.", e);
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
    		((GueryLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.qualitune.guery.MotifModel.class) {
    				return parse_org_qualitune_guery_MotifModel();
    			}
    			if (type.getInstanceClass() == org.qualitune.guery.Motif.class) {
    				return parse_org_qualitune_guery_Motif();
    			}
    			if (type.getInstanceClass() == org.qualitune.guery.PreProcessor.class) {
    				return parse_org_qualitune_guery_PreProcessor();
    			}
    			if (type.getInstanceClass() == org.qualitune.guery.VertexSelection.class) {
    				return parse_org_qualitune_guery_VertexSelection();
    			}
    			if (type.getInstanceClass() == org.qualitune.guery.Role.class) {
    				return parse_org_qualitune_guery_Role();
    			}
    			if (type.getInstanceClass() == org.qualitune.guery.Constraint.class) {
    				return parse_org_qualitune_guery_Constraint();
    			}
    			if (type.getInstanceClass() == org.qualitune.guery.ConnectedBy.class) {
    				return parse_org_qualitune_guery_ConnectedBy();
    			}
    			if (type.getInstanceClass() == org.qualitune.guery.NotConnectedBy.class) {
    				return parse_org_qualitune_guery_NotConnectedBy();
    			}
    			if (type.getInstanceClass() == org.qualitune.guery.Connection.class) {
    				return parse_org_qualitune_guery_Connection();
    			}
    			if (type.getInstanceClass() == org.qualitune.guery.Grouping.class) {
    				return parse_org_qualitune_guery_Grouping();
    			}
    		}
    		throw new org.qualitune.guery.resource.guery.mopp.GueryUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(org.qualitune.guery.resource.guery.IGueryOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.qualitune.guery.resource.guery.IGueryParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>>();
    		org.qualitune.guery.resource.guery.mopp.GueryParseResult parseResult = new org.qualitune.guery.resource.guery.mopp.GueryParseResult();
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    			}
    		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public java.util.List<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.qualitune.guery.resource.guery.IGueryTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		org.qualitune.guery.resource.guery.IGueryParseResult result = parse();
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
    			for (org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal>();
    		java.util.List<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal> newFollowSet = new java.util.ArrayList<org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 59;
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
    				for (org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<org.qualitune.guery.resource.guery.util.GueryPair<org.qualitune.guery.resource.guery.IGueryExpectedElement, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.qualitune.guery.resource.guery.util.GueryPair<org.qualitune.guery.resource.guery.IGueryExpectedElement, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[]> newFollowerPair : newFollowers) {
    							org.qualitune.guery.resource.guery.IGueryExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							org.qualitune.guery.resource.guery.grammar.GueryContainmentTrace containmentTrace = new org.qualitune.guery.resource.guery.grammar.GueryContainmentTrace(null, newFollowerPair.getRight());
    							org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal newFollowTerminal = new org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.qualitune.guery.resource.guery.mopp.GueryExpectedTerminal expectedElement, int tokenIndex) {
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
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
    			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
    			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
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
    // Guery.g:526:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_qualitune_guery_MotifModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.qualitune.guery.MotifModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Guery.g:527:2: ( (c0= parse_org_qualitune_guery_MotifModel ) EOF )
            // Guery.g:528:2: (c0= parse_org_qualitune_guery_MotifModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Guery.g:533:2: (c0= parse_org_qualitune_guery_MotifModel )
            // Guery.g:534:3: c0= parse_org_qualitune_guery_MotifModel
            {
            pushFollow(FOLLOW_parse_org_qualitune_guery_MotifModel_in_start82);
            c0=parse_org_qualitune_guery_MotifModel();

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



    // $ANTLR start "parse_org_qualitune_guery_MotifModel"
    // Guery.g:542:1: parse_org_qualitune_guery_MotifModel returns [org.qualitune.guery.MotifModel element = null] : (a0_0= parse_org_qualitune_guery_Motif ) ( ( (a1_0= parse_org_qualitune_guery_Motif ) ) )* ;
    public final org.qualitune.guery.MotifModel parse_org_qualitune_guery_MotifModel() throws RecognitionException {
        org.qualitune.guery.MotifModel element =  null;

        int parse_org_qualitune_guery_MotifModel_StartIndex = input.index();

        org.qualitune.guery.Motif a0_0 =null;

        org.qualitune.guery.Motif a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Guery.g:545:2: ( (a0_0= parse_org_qualitune_guery_Motif ) ( ( (a1_0= parse_org_qualitune_guery_Motif ) ) )* )
            // Guery.g:546:2: (a0_0= parse_org_qualitune_guery_Motif ) ( ( (a1_0= parse_org_qualitune_guery_Motif ) ) )*
            {
            // Guery.g:546:2: (a0_0= parse_org_qualitune_guery_Motif )
            // Guery.g:547:3: a0_0= parse_org_qualitune_guery_Motif
            {
            pushFollow(FOLLOW_parse_org_qualitune_guery_Motif_in_parse_org_qualitune_guery_MotifModel119);
            a0_0=parse_org_qualitune_guery_Motif();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotifModel();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF_MODEL__MOTIFS, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_0_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[1]);
            	}

            // Guery.g:572:2: ( ( (a1_0= parse_org_qualitune_guery_Motif ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==22) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Guery.g:573:3: ( (a1_0= parse_org_qualitune_guery_Motif ) )
            	    {
            	    // Guery.g:573:3: ( (a1_0= parse_org_qualitune_guery_Motif ) )
            	    // Guery.g:574:4: (a1_0= parse_org_qualitune_guery_Motif )
            	    {
            	    // Guery.g:574:4: (a1_0= parse_org_qualitune_guery_Motif )
            	    // Guery.g:575:5: a1_0= parse_org_qualitune_guery_Motif
            	    {
            	    pushFollow(FOLLOW_parse_org_qualitune_guery_Motif_in_parse_org_qualitune_guery_MotifModel152);
            	    a1_0=parse_org_qualitune_guery_Motif();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotifModel();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a1_0 != null) {
            	    						if (a1_0 != null) {
            	    							Object value = a1_0;
            	    							addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF_MODEL__MOTIFS, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_0_0_0_1_0_0_2, a1_0, true);
            	    						copyLocalizationInfos(a1_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[2]);
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
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[3]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_qualitune_guery_MotifModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_MotifModel"



    // $ANTLR start "parse_org_qualitune_guery_Motif"
    // Guery.g:609:1: parse_org_qualitune_guery_Motif returns [org.qualitune.guery.Motif element = null] : a0= 'motif' (a1= IDENTIFIER ) ( (a2_0= parse_org_qualitune_guery_PreProcessor ) )* (a3_0= parse_org_qualitune_guery_VertexSelection ) ( (a4_0= parse_org_qualitune_guery_EdgeSelection ) )* ( (a5_0= parse_org_qualitune_guery_Grouping ) )* ;
    public final org.qualitune.guery.Motif parse_org_qualitune_guery_Motif() throws RecognitionException {
        org.qualitune.guery.Motif element =  null;

        int parse_org_qualitune_guery_Motif_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        org.qualitune.guery.PreProcessor a2_0 =null;

        org.qualitune.guery.VertexSelection a3_0 =null;

        org.qualitune.guery.EdgeSelection a4_0 =null;

        org.qualitune.guery.Grouping a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Guery.g:612:2: (a0= 'motif' (a1= IDENTIFIER ) ( (a2_0= parse_org_qualitune_guery_PreProcessor ) )* (a3_0= parse_org_qualitune_guery_VertexSelection ) ( (a4_0= parse_org_qualitune_guery_EdgeSelection ) )* ( (a5_0= parse_org_qualitune_guery_Grouping ) )* )
            // Guery.g:613:2: a0= 'motif' (a1= IDENTIFIER ) ( (a2_0= parse_org_qualitune_guery_PreProcessor ) )* (a3_0= parse_org_qualitune_guery_VertexSelection ) ( (a4_0= parse_org_qualitune_guery_EdgeSelection ) )* ( (a5_0= parse_org_qualitune_guery_Grouping ) )*
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_org_qualitune_guery_Motif208); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[4]);
            	}

            // Guery.g:627:2: (a1= IDENTIFIER )
            // Guery.g:628:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Motif226); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[6]);
            	}

            // Guery.g:664:2: ( (a2_0= parse_org_qualitune_guery_PreProcessor ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==24) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Guery.g:665:3: (a2_0= parse_org_qualitune_guery_PreProcessor )
            	    {
            	    // Guery.g:665:3: (a2_0= parse_org_qualitune_guery_PreProcessor )
            	    // Guery.g:666:4: a2_0= parse_org_qualitune_guery_PreProcessor
            	    {
            	    pushFollow(FOLLOW_parse_org_qualitune_guery_PreProcessor_in_parse_org_qualitune_guery_Motif256);
            	    a2_0=parse_org_qualitune_guery_PreProcessor();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a2_0 != null) {
            	    					if (a2_0 != null) {
            	    						Object value = a2_0;
            	    						addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF__PREPARE, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_2, a2_0, true);
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
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[8]);
            	}

            // Guery.g:693:2: (a3_0= parse_org_qualitune_guery_VertexSelection )
            // Guery.g:694:3: a3_0= parse_org_qualitune_guery_VertexSelection
            {
            pushFollow(FOLLOW_parse_org_qualitune_guery_VertexSelection_in_parse_org_qualitune_guery_Motif286);
            a3_0=parse_org_qualitune_guery_VertexSelection();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
            				startIncompleteElement(element);
            			}
            			if (a3_0 != null) {
            				if (a3_0 != null) {
            					Object value = a3_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__VERTEX_SELECTION), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_3, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[12]);
            	}

            // Guery.g:722:2: ( (a4_0= parse_org_qualitune_guery_EdgeSelection ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19||LA3_0==23) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Guery.g:723:3: (a4_0= parse_org_qualitune_guery_EdgeSelection )
            	    {
            	    // Guery.g:723:3: (a4_0= parse_org_qualitune_guery_EdgeSelection )
            	    // Guery.g:724:4: a4_0= parse_org_qualitune_guery_EdgeSelection
            	    {
            	    pushFollow(FOLLOW_parse_org_qualitune_guery_EdgeSelection_in_parse_org_qualitune_guery_Motif313);
            	    a4_0=parse_org_qualitune_guery_EdgeSelection();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a4_0 != null) {
            	    					if (a4_0 != null) {
            	    						Object value = a4_0;
            	    						addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF__EDGE_SELECTIONS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_4, a4_0, true);
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
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[15]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[16]);
            	}

            // Guery.g:753:2: ( (a5_0= parse_org_qualitune_guery_Grouping ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==21) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Guery.g:754:3: (a5_0= parse_org_qualitune_guery_Grouping )
            	    {
            	    // Guery.g:754:3: (a5_0= parse_org_qualitune_guery_Grouping )
            	    // Guery.g:755:4: a5_0= parse_org_qualitune_guery_Grouping
            	    {
            	    pushFollow(FOLLOW_parse_org_qualitune_guery_Grouping_in_parse_org_qualitune_guery_Motif348);
            	    a5_0=parse_org_qualitune_guery_Grouping();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createMotif();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a5_0 != null) {
            	    					if (a5_0 != null) {
            	    						Object value = a5_0;
            	    						addObjectToList(element, org.qualitune.guery.GueryPackage.MOTIF__GROUP_BY, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_5, a5_0, true);
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
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[18]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_qualitune_guery_Motif_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_Motif"



    // $ANTLR start "parse_org_qualitune_guery_PreProcessor"
    // Guery.g:784:1: parse_org_qualitune_guery_PreProcessor returns [org.qualitune.guery.PreProcessor element = null] : a0= 'prepare' a1= 'with' (a2= CLASSNAME ) ;
    public final org.qualitune.guery.PreProcessor parse_org_qualitune_guery_PreProcessor() throws RecognitionException {
        org.qualitune.guery.PreProcessor element =  null;

        int parse_org_qualitune_guery_PreProcessor_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Guery.g:787:2: (a0= 'prepare' a1= 'with' (a2= CLASSNAME ) )
            // Guery.g:788:2: a0= 'prepare' a1= 'with' (a2= CLASSNAME )
            {
            a0=(Token)match(input,24,FOLLOW_24_in_parse_org_qualitune_guery_PreProcessor389); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createPreProcessor();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[19]);
            	}

            a1=(Token)match(input,27,FOLLOW_27_in_parse_org_qualitune_guery_PreProcessor403); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createPreProcessor();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[20]);
            	}

            // Guery.g:816:2: (a2= CLASSNAME )
            // Guery.g:817:3: a2= CLASSNAME
            {
            a2=(Token)match(input,CLASSNAME,FOLLOW_CLASSNAME_in_parse_org_qualitune_guery_PreProcessor421); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createPreProcessor();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CLASSNAME");
            				tokenResolver.setOptions(getOptions());
            				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.PRE_PROCESSOR__CLASS_NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.PRE_PROCESSOR__CLASS_NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[22]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_qualitune_guery_PreProcessor_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_PreProcessor"



    // $ANTLR start "parse_org_qualitune_guery_VertexSelection"
    // Guery.g:855:1: parse_org_qualitune_guery_VertexSelection returns [org.qualitune.guery.VertexSelection element = null] : a0= 'select' (a1_0= parse_org_qualitune_guery_Role ) ( (a2= ',' (a3_0= parse_org_qualitune_guery_Role ) ) )* ( (a4_0= parse_org_qualitune_guery_Constraint ) )? ;
    public final org.qualitune.guery.VertexSelection parse_org_qualitune_guery_VertexSelection() throws RecognitionException {
        org.qualitune.guery.VertexSelection element =  null;

        int parse_org_qualitune_guery_VertexSelection_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        org.qualitune.guery.Role a1_0 =null;

        org.qualitune.guery.Role a3_0 =null;

        org.qualitune.guery.Constraint a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Guery.g:858:2: (a0= 'select' (a1_0= parse_org_qualitune_guery_Role ) ( (a2= ',' (a3_0= parse_org_qualitune_guery_Role ) ) )* ( (a4_0= parse_org_qualitune_guery_Constraint ) )? )
            // Guery.g:859:2: a0= 'select' (a1_0= parse_org_qualitune_guery_Role ) ( (a2= ',' (a3_0= parse_org_qualitune_guery_Role ) ) )* ( (a4_0= parse_org_qualitune_guery_Constraint ) )?
            {
            a0=(Token)match(input,25,FOLLOW_25_in_parse_org_qualitune_guery_VertexSelection457); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[23]);
            	}

            // Guery.g:873:2: (a1_0= parse_org_qualitune_guery_Role )
            // Guery.g:874:3: a1_0= parse_org_qualitune_guery_Role
            {
            pushFollow(FOLLOW_parse_org_qualitune_guery_Role_in_parse_org_qualitune_guery_VertexSelection475);
            a1_0=parse_org_qualitune_guery_Role();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
            				startIncompleteElement(element);
            			}
            			if (a1_0 != null) {
            				if (a1_0 != null) {
            					Object value = a1_0;
            					addObjectToList(element, org.qualitune.guery.GueryPackage.VERTEX_SELECTION__ROLES, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_2, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[29]);
            	}

            // Guery.g:904:2: ( (a2= ',' (a3_0= parse_org_qualitune_guery_Role ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Guery.g:905:3: (a2= ',' (a3_0= parse_org_qualitune_guery_Role ) )
            	    {
            	    // Guery.g:905:3: (a2= ',' (a3_0= parse_org_qualitune_guery_Role ) )
            	    // Guery.g:906:4: a2= ',' (a3_0= parse_org_qualitune_guery_Role )
            	    {
            	    a2=(Token)match(input,13,FOLLOW_13_in_parse_org_qualitune_guery_VertexSelection502); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_3_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[30]);
            	    			}

            	    // Guery.g:920:4: (a3_0= parse_org_qualitune_guery_Role )
            	    // Guery.g:921:5: a3_0= parse_org_qualitune_guery_Role
            	    {
            	    pushFollow(FOLLOW_parse_org_qualitune_guery_Role_in_parse_org_qualitune_guery_VertexSelection528);
            	    a3_0=parse_org_qualitune_guery_Role();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a3_0 != null) {
            	    						if (a3_0 != null) {
            	    							Object value = a3_0;
            	    							addObjectToList(element, org.qualitune.guery.GueryPackage.VERTEX_SELECTION__ROLES, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_3_0_0_1, a3_0, true);
            	    						copyLocalizationInfos(a3_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[31]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[32]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[33]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[34]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[35]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[36]);
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
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[39]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[40]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[41]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[42]);
            	}

            // Guery.g:963:2: ( (a4_0= parse_org_qualitune_guery_Constraint ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Guery.g:964:3: (a4_0= parse_org_qualitune_guery_Constraint )
                    {
                    // Guery.g:964:3: (a4_0= parse_org_qualitune_guery_Constraint )
                    // Guery.g:965:4: a4_0= parse_org_qualitune_guery_Constraint
                    {
                    pushFollow(FOLLOW_parse_org_qualitune_guery_Constraint_in_parse_org_qualitune_guery_VertexSelection578);
                    a4_0=parse_org_qualitune_guery_Constraint();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createVertexSelection();
                    					startIncompleteElement(element);
                    				}
                    				if (a4_0 != null) {
                    					if (a4_0 != null) {
                    						Object value = a4_0;
                    						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINT), value);
                    						completedElement(value, true);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4, a4_0, true);
                    					copyLocalizationInfos(a4_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[46]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_qualitune_guery_VertexSelection_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_VertexSelection"



    // $ANTLR start "parse_org_qualitune_guery_Role"
    // Guery.g:996:1: parse_org_qualitune_guery_Role returns [org.qualitune.guery.Role element = null] : (a0= IDENTIFIER ) ;
    public final org.qualitune.guery.Role parse_org_qualitune_guery_Role() throws RecognitionException {
        org.qualitune.guery.Role element =  null;

        int parse_org_qualitune_guery_Role_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Guery.g:999:2: ( (a0= IDENTIFIER ) )
            // Guery.g:1000:2: (a0= IDENTIFIER )
            {
            // Guery.g:1000:2: (a0= IDENTIFIER )
            // Guery.g:1001:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Role623); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createRole();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.ROLE__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.ROLE__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_4_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[50]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[51]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[52]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_qualitune_guery_Role_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_Role"



    // $ANTLR start "parse_org_qualitune_guery_Constraint"
    // Guery.g:1043:1: parse_org_qualitune_guery_Constraint returns [org.qualitune.guery.Constraint element = null] : a0= 'where' (a1= QUOTED_34_34 ) ( (a2= 'and' (a3= QUOTED_34_34 ) ) )* ;
    public final org.qualitune.guery.Constraint parse_org_qualitune_guery_Constraint() throws RecognitionException {
        org.qualitune.guery.Constraint element =  null;

        int parse_org_qualitune_guery_Constraint_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Guery.g:1046:2: (a0= 'where' (a1= QUOTED_34_34 ) ( (a2= 'and' (a3= QUOTED_34_34 ) ) )* )
            // Guery.g:1047:2: a0= 'where' (a1= QUOTED_34_34 ) ( (a2= 'and' (a3= QUOTED_34_34 ) ) )*
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_org_qualitune_guery_Constraint659); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConstraint();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[53]);
            	}

            // Guery.g:1061:2: (a1= QUOTED_34_34 )
            // Guery.g:1062:3: a1= QUOTED_34_34
            {
            a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_qualitune_guery_Constraint677); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConstraint();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					addObjectToList(element, org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[54]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[55]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[56]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[57]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[58]);
            	}

            // Guery.g:1101:2: ( (a2= 'and' (a3= QUOTED_34_34 ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==17) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Guery.g:1102:3: (a2= 'and' (a3= QUOTED_34_34 ) )
            	    {
            	    // Guery.g:1102:3: (a2= 'and' (a3= QUOTED_34_34 ) )
            	    // Guery.g:1103:4: a2= 'and' (a3= QUOTED_34_34 )
            	    {
            	    a2=(Token)match(input,17,FOLLOW_17_in_parse_org_qualitune_guery_Constraint707); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConstraint();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_3_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[59]);
            	    			}

            	    // Guery.g:1117:4: (a3= QUOTED_34_34 )
            	    // Guery.g:1118:5: a3= QUOTED_34_34
            	    {
            	    a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_qualitune_guery_Constraint733); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.qualitune.guery.GueryFactory.eINSTANCE.createConstraint();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a3 != null) {
            	    						org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	    						tokenResolver.setOptions(getOptions());
            	    						org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            	    						}
            	    						java.lang.String resolved = (java.lang.String) resolvedObject;
            	    						if (resolved != null) {
            	    							Object value = resolved;
            	    							addObjectToList(element, org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS, value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_3_0_0_1, resolved, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[60]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[61]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[62]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[63]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[64]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[69]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_qualitune_guery_Constraint_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_Constraint"



    // $ANTLR start "parse_org_qualitune_guery_ConnectedBy"
    // Guery.g:1170:1: parse_org_qualitune_guery_ConnectedBy returns [org.qualitune.guery.ConnectedBy element = null] : a0= 'connected' a1= 'by' (a2_0= parse_org_qualitune_guery_Connection ) ( (a3= 'and' (a4_0= parse_org_qualitune_guery_Connection ) ) )* ( (a5_0= parse_org_qualitune_guery_Constraint ) )? ;
    public final org.qualitune.guery.ConnectedBy parse_org_qualitune_guery_ConnectedBy() throws RecognitionException {
        org.qualitune.guery.ConnectedBy element =  null;

        int parse_org_qualitune_guery_ConnectedBy_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        org.qualitune.guery.Connection a2_0 =null;

        org.qualitune.guery.Connection a4_0 =null;

        org.qualitune.guery.Constraint a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Guery.g:1173:2: (a0= 'connected' a1= 'by' (a2_0= parse_org_qualitune_guery_Connection ) ( (a3= 'and' (a4_0= parse_org_qualitune_guery_Connection ) ) )* ( (a5_0= parse_org_qualitune_guery_Constraint ) )? )
            // Guery.g:1174:2: a0= 'connected' a1= 'by' (a2_0= parse_org_qualitune_guery_Connection ) ( (a3= 'and' (a4_0= parse_org_qualitune_guery_Connection ) ) )* ( (a5_0= parse_org_qualitune_guery_Constraint ) )?
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_org_qualitune_guery_ConnectedBy794); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[70]);
            	}

            a1=(Token)match(input,18,FOLLOW_18_in_parse_org_qualitune_guery_ConnectedBy808); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[71]);
            	}

            // Guery.g:1202:2: (a2_0= parse_org_qualitune_guery_Connection )
            // Guery.g:1203:3: a2_0= parse_org_qualitune_guery_Connection
            {
            pushFollow(FOLLOW_parse_org_qualitune_guery_Connection_in_parse_org_qualitune_guery_ConnectedBy826);
            a2_0=parse_org_qualitune_guery_Connection();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
            				startIncompleteElement(element);
            			}
            			if (a2_0 != null) {
            				if (a2_0 != null) {
            					Object value = a2_0;
            					addObjectToList(element, org.qualitune.guery.GueryPackage.CONNECTED_BY__CONNECTIONS, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_3, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[72]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[73]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[74]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[76]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[77]);
            	}

            // Guery.g:1233:2: ( (a3= 'and' (a4_0= parse_org_qualitune_guery_Connection ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Guery.g:1234:3: (a3= 'and' (a4_0= parse_org_qualitune_guery_Connection ) )
            	    {
            	    // Guery.g:1234:3: (a3= 'and' (a4_0= parse_org_qualitune_guery_Connection ) )
            	    // Guery.g:1235:4: a3= 'and' (a4_0= parse_org_qualitune_guery_Connection )
            	    {
            	    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_qualitune_guery_ConnectedBy853); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_4_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[78]);
            	    			}

            	    // Guery.g:1249:4: (a4_0= parse_org_qualitune_guery_Connection )
            	    // Guery.g:1250:5: a4_0= parse_org_qualitune_guery_Connection
            	    {
            	    pushFollow(FOLLOW_parse_org_qualitune_guery_Connection_in_parse_org_qualitune_guery_ConnectedBy879);
            	    a4_0=parse_org_qualitune_guery_Connection();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a4_0 != null) {
            	    						if (a4_0 != null) {
            	    							Object value = a4_0;
            	    							addObjectToList(element, org.qualitune.guery.GueryPackage.CONNECTED_BY__CONNECTIONS, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_4_0_0_1, a4_0, true);
            	    						copyLocalizationInfos(a4_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[79]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[80]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[81]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[82]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[83]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[84]);
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
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[90]);
            	}

            // Guery.g:1292:2: ( (a5_0= parse_org_qualitune_guery_Constraint ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Guery.g:1293:3: (a5_0= parse_org_qualitune_guery_Constraint )
                    {
                    // Guery.g:1293:3: (a5_0= parse_org_qualitune_guery_Constraint )
                    // Guery.g:1294:4: a5_0= parse_org_qualitune_guery_Constraint
                    {
                    pushFollow(FOLLOW_parse_org_qualitune_guery_Constraint_in_parse_org_qualitune_guery_ConnectedBy929);
                    a5_0=parse_org_qualitune_guery_Constraint();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnectedBy();
                    					startIncompleteElement(element);
                    				}
                    				if (a5_0 != null) {
                    					if (a5_0 != null) {
                    						Object value = a5_0;
                    						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONSTRAINT), value);
                    						completedElement(value, true);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5, a5_0, true);
                    					copyLocalizationInfos(a5_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[94]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_qualitune_guery_ConnectedBy_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_ConnectedBy"



    // $ANTLR start "parse_org_qualitune_guery_NotConnectedBy"
    // Guery.g:1325:1: parse_org_qualitune_guery_NotConnectedBy returns [org.qualitune.guery.NotConnectedBy element = null] : a0= 'not' a1= 'connected' a2= 'by' (a3_0= parse_org_qualitune_guery_Connection ) ( (a4= 'and' (a5_0= parse_org_qualitune_guery_Connection ) ) )* ( (a6_0= parse_org_qualitune_guery_Constraint ) )? ;
    public final org.qualitune.guery.NotConnectedBy parse_org_qualitune_guery_NotConnectedBy() throws RecognitionException {
        org.qualitune.guery.NotConnectedBy element =  null;

        int parse_org_qualitune_guery_NotConnectedBy_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.qualitune.guery.Connection a3_0 =null;

        org.qualitune.guery.Connection a5_0 =null;

        org.qualitune.guery.Constraint a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Guery.g:1328:2: (a0= 'not' a1= 'connected' a2= 'by' (a3_0= parse_org_qualitune_guery_Connection ) ( (a4= 'and' (a5_0= parse_org_qualitune_guery_Connection ) ) )* ( (a6_0= parse_org_qualitune_guery_Constraint ) )? )
            // Guery.g:1329:2: a0= 'not' a1= 'connected' a2= 'by' (a3_0= parse_org_qualitune_guery_Connection ) ( (a4= 'and' (a5_0= parse_org_qualitune_guery_Connection ) ) )* ( (a6_0= parse_org_qualitune_guery_Constraint ) )?
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_org_qualitune_guery_NotConnectedBy970); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[95]);
            	}

            a1=(Token)match(input,19,FOLLOW_19_in_parse_org_qualitune_guery_NotConnectedBy984); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[96]);
            	}

            a2=(Token)match(input,18,FOLLOW_18_in_parse_org_qualitune_guery_NotConnectedBy998); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[97]);
            	}

            // Guery.g:1371:2: (a3_0= parse_org_qualitune_guery_Connection )
            // Guery.g:1372:3: a3_0= parse_org_qualitune_guery_Connection
            {
            pushFollow(FOLLOW_parse_org_qualitune_guery_Connection_in_parse_org_qualitune_guery_NotConnectedBy1016);
            a3_0=parse_org_qualitune_guery_Connection();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
            				startIncompleteElement(element);
            			}
            			if (a3_0 != null) {
            				if (a3_0 != null) {
            					Object value = a3_0;
            					addObjectToList(element, org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_4, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[101]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[102]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[103]);
            	}

            // Guery.g:1402:2: ( (a4= 'and' (a5_0= parse_org_qualitune_guery_Connection ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==17) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Guery.g:1403:3: (a4= 'and' (a5_0= parse_org_qualitune_guery_Connection ) )
            	    {
            	    // Guery.g:1403:3: (a4= 'and' (a5_0= parse_org_qualitune_guery_Connection ) )
            	    // Guery.g:1404:4: a4= 'and' (a5_0= parse_org_qualitune_guery_Connection )
            	    {
            	    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_qualitune_guery_NotConnectedBy1043); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[104]);
            	    			}

            	    // Guery.g:1418:4: (a5_0= parse_org_qualitune_guery_Connection )
            	    // Guery.g:1419:5: a5_0= parse_org_qualitune_guery_Connection
            	    {
            	    pushFollow(FOLLOW_parse_org_qualitune_guery_Connection_in_parse_org_qualitune_guery_NotConnectedBy1069);
            	    a5_0=parse_org_qualitune_guery_Connection();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a5_0 != null) {
            	    						if (a5_0 != null) {
            	    							Object value = a5_0;
            	    							addObjectToList(element, org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_1, a5_0, true);
            	    						copyLocalizationInfos(a5_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[105]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[106]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[107]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[108]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[109]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[110]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[111]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[113]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[115]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[116]);
            	}

            // Guery.g:1461:2: ( (a6_0= parse_org_qualitune_guery_Constraint ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==26) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Guery.g:1462:3: (a6_0= parse_org_qualitune_guery_Constraint )
                    {
                    // Guery.g:1462:3: (a6_0= parse_org_qualitune_guery_Constraint )
                    // Guery.g:1463:4: a6_0= parse_org_qualitune_guery_Constraint
                    {
                    pushFollow(FOLLOW_parse_org_qualitune_guery_Constraint_in_parse_org_qualitune_guery_NotConnectedBy1119);
                    a6_0=parse_org_qualitune_guery_Constraint();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createNotConnectedBy();
                    					startIncompleteElement(element);
                    				}
                    				if (a6_0 != null) {
                    					if (a6_0 != null) {
                    						Object value = a6_0;
                    						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINT), value);
                    						completedElement(value, true);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_6, a6_0, true);
                    					copyLocalizationInfos(a6_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[117]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[118]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[119]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[120]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_qualitune_guery_NotConnectedBy_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_NotConnectedBy"



    // $ANTLR start "parse_org_qualitune_guery_Connection"
    // Guery.g:1494:1: parse_org_qualitune_guery_Connection returns [org.qualitune.guery.Connection element = null] : (a0= IDENTIFIER ) a1= '(' (a2= IDENTIFIER ) a3= '>' (a4= IDENTIFIER ) a5= ')' ( (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' ) )? ( (a11= 'find all' )? ) ;
    public final org.qualitune.guery.Connection parse_org_qualitune_guery_Connection() throws RecognitionException {
        org.qualitune.guery.Connection element =  null;

        int parse_org_qualitune_guery_Connection_StartIndex = input.index();

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

            // Guery.g:1497:2: ( (a0= IDENTIFIER ) a1= '(' (a2= IDENTIFIER ) a3= '>' (a4= IDENTIFIER ) a5= ')' ( (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' ) )? ( (a11= 'find all' )? ) )
            // Guery.g:1498:2: (a0= IDENTIFIER ) a1= '(' (a2= IDENTIFIER ) a3= '>' (a4= IDENTIFIER ) a5= ')' ( (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' ) )? ( (a11= 'find all' )? )
            {
            // Guery.g:1498:2: (a0= IDENTIFIER )
            // Guery.g:1499:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Connection1164); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
            				startIncompleteElement(element);
            				// initialize boolean attribute
            				{
            					Object value = false;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
            				}
            			}
            			if (a0 != null) {
            				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__PATH), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__PATH), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[121]);
            	}

            a1=(Token)match(input,11,FOLLOW_11_in_parse_org_qualitune_guery_Connection1185); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[122]);
            	}

            // Guery.g:1558:2: (a2= IDENTIFIER )
            // Guery.g:1559:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Connection1203); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
            				startIncompleteElement(element);
            				// initialize boolean attribute
            				{
            					Object value = false;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
            				}
            			}
            			if (a2 != null) {
            				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.qualitune.guery.Role proxy = org.qualitune.guery.GueryFactory.eINSTANCE.createRole();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.qualitune.guery.resource.guery.mopp.GueryContextDependentURIFragmentFactory<org.qualitune.guery.Connection, org.qualitune.guery.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionFromReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[123]);
            	}

            a3=(Token)match(input,14,FOLLOW_14_in_parse_org_qualitune_guery_Connection1224); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[124]);
            	}

            // Guery.g:1622:2: (a4= IDENTIFIER )
            // Guery.g:1623:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Connection1242); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
            				startIncompleteElement(element);
            				// initialize boolean attribute
            				{
            					Object value = false;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
            				}
            			}
            			if (a4 != null) {
            				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.qualitune.guery.Role proxy = org.qualitune.guery.GueryFactory.eINSTANCE.createRole();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.qualitune.guery.resource.guery.mopp.GueryContextDependentURIFragmentFactory<org.qualitune.guery.Connection, org.qualitune.guery.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionToReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[125]);
            	}

            a5=(Token)match(input,12,FOLLOW_12_in_parse_org_qualitune_guery_Connection1263); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[134]);
            	}

            // Guery.g:1694:2: ( (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==15) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Guery.g:1695:3: (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' )
                    {
                    // Guery.g:1695:3: (a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']' )
                    // Guery.g:1696:4: a6= '[' (a7= CARDINALITY ) a8= ',' (a9= CARDINALITY ) a10= ']'
                    {
                    a6=(Token)match(input,15,FOLLOW_15_in_parse_org_qualitune_guery_Connection1286); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[135]);
                    			}

                    // Guery.g:1715:4: (a7= CARDINALITY )
                    // Guery.g:1716:5: a7= CARDINALITY
                    {
                    a7=(Token)match(input,CARDINALITY,FOLLOW_CARDINALITY_in_parse_org_qualitune_guery_Connection1312); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
                    						startIncompleteElement(element);
                    						// initialize boolean attribute
                    						{
                    							Object value = false;
                    							element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
                    						}
                    					}
                    					if (a7 != null) {
                    						org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
                    						tokenResolver.setOptions(getOptions());
                    						org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MIN_LENGTH), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
                    						}
                    						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
                    						if (resolved != null) {
                    							Object value = resolved;
                    							element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MIN_LENGTH), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_1, resolved, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[136]);
                    			}

                    a8=(Token)match(input,13,FOLLOW_13_in_parse_org_qualitune_guery_Connection1345); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_2, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[137]);
                    			}

                    // Guery.g:1775:4: (a9= CARDINALITY )
                    // Guery.g:1776:5: a9= CARDINALITY
                    {
                    a9=(Token)match(input,CARDINALITY,FOLLOW_CARDINALITY_in_parse_org_qualitune_guery_Connection1371); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
                    						startIncompleteElement(element);
                    						// initialize boolean attribute
                    						{
                    							Object value = false;
                    							element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
                    						}
                    					}
                    					if (a9 != null) {
                    						org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
                    						tokenResolver.setOptions(getOptions());
                    						org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MAX_LENGTH), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
                    						}
                    						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
                    						if (resolved != null) {
                    							Object value = resolved;
                    							element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MAX_LENGTH), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_3, resolved, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[138]);
                    			}

                    a10=(Token)match(input,16,FOLLOW_16_in_parse_org_qualitune_guery_Connection1404); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_4, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[139]);
                    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[140]);
                    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[141]);
                    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[142]);
                    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[143]);
                    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[144]);
                    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[145]);
                    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[146]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[147]);
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[148]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[149]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[153]);
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[154]);
            	}

            // Guery.g:1856:2: ( (a11= 'find all' )? )
            // Guery.g:1857:3: (a11= 'find all' )?
            {
            // Guery.g:1857:3: (a11= 'find all' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Guery.g:1858:4: a11= 'find all'
                    {
                    a11=(Token)match(input,20,FOLLOW_20_in_parse_org_qualitune_guery_Connection1446); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createConnection();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_7, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[155]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[156]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[157]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[158]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[159]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[160]);
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[161]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_qualitune_guery_Connection_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_Connection"



    // $ANTLR start "parse_org_qualitune_guery_Grouping"
    // Guery.g:1890:1: parse_org_qualitune_guery_Grouping returns [org.qualitune.guery.Grouping element = null] : a0= 'group' a1= 'by' (a2= QUOTED_34_34 ) ( (a3= 'and' (a4= QUOTED_34_34 ) ) )* ;
    public final org.qualitune.guery.Grouping parse_org_qualitune_guery_Grouping() throws RecognitionException {
        org.qualitune.guery.Grouping element =  null;

        int parse_org_qualitune_guery_Grouping_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Guery.g:1893:2: (a0= 'group' a1= 'by' (a2= QUOTED_34_34 ) ( (a3= 'and' (a4= QUOTED_34_34 ) ) )* )
            // Guery.g:1894:2: a0= 'group' a1= 'by' (a2= QUOTED_34_34 ) ( (a3= 'and' (a4= QUOTED_34_34 ) ) )*
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_org_qualitune_guery_Grouping1482); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[162]);
            	}

            a1=(Token)match(input,18,FOLLOW_18_in_parse_org_qualitune_guery_Grouping1496); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[163]);
            	}

            // Guery.g:1922:2: (a2= QUOTED_34_34 )
            // Guery.g:1923:3: a2= QUOTED_34_34
            {
            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_qualitune_guery_Grouping1514); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					addObjectToList(element, org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[166]);
            	}

            // Guery.g:1960:2: ( (a3= 'and' (a4= QUOTED_34_34 ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==17) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Guery.g:1961:3: (a3= 'and' (a4= QUOTED_34_34 ) )
            	    {
            	    // Guery.g:1961:3: (a3= 'and' (a4= QUOTED_34_34 ) )
            	    // Guery.g:1962:4: a3= 'and' (a4= QUOTED_34_34 )
            	    {
            	    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_qualitune_guery_Grouping1544); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_4_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[167]);
            	    			}

            	    // Guery.g:1976:4: (a4= QUOTED_34_34 )
            	    // Guery.g:1977:5: a4= QUOTED_34_34
            	    {
            	    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_qualitune_guery_Grouping1570); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.qualitune.guery.GueryFactory.eINSTANCE.createGrouping();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a4 != null) {
            	    						org.qualitune.guery.resource.guery.IGueryTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	    						tokenResolver.setOptions(getOptions());
            	    						org.qualitune.guery.resource.guery.IGueryTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            	    						}
            	    						java.lang.String resolved = (java.lang.String) resolvedObject;
            	    						if (resolved != null) {
            	    							Object value = resolved;
            	    							addObjectToList(element, org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS, value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.qualitune.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_4_0_0_1, resolved, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[168]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[169]);
            	    				addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[170]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[171]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[172]);
            		addExpectedElement(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), org.qualitune.guery.resource.guery.mopp.GueryExpectationConstants.EXPECTATIONS[173]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_qualitune_guery_Grouping_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_Grouping"



    // $ANTLR start "parse_org_qualitune_guery_EdgeSelection"
    // Guery.g:2025:1: parse_org_qualitune_guery_EdgeSelection returns [org.qualitune.guery.EdgeSelection element = null] : (c0= parse_org_qualitune_guery_ConnectedBy |c1= parse_org_qualitune_guery_NotConnectedBy );
    public final org.qualitune.guery.EdgeSelection parse_org_qualitune_guery_EdgeSelection() throws RecognitionException {
        org.qualitune.guery.EdgeSelection element =  null;

        int parse_org_qualitune_guery_EdgeSelection_StartIndex = input.index();

        org.qualitune.guery.ConnectedBy c0 =null;

        org.qualitune.guery.NotConnectedBy c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Guery.g:2026:2: (c0= parse_org_qualitune_guery_ConnectedBy |c1= parse_org_qualitune_guery_NotConnectedBy )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==19) ) {
                alt15=1;
            }
            else if ( (LA15_0==23) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // Guery.g:2027:2: c0= parse_org_qualitune_guery_ConnectedBy
                    {
                    pushFollow(FOLLOW_parse_org_qualitune_guery_ConnectedBy_in_parse_org_qualitune_guery_EdgeSelection1627);
                    c0=parse_org_qualitune_guery_ConnectedBy();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Guery.g:2028:4: c1= parse_org_qualitune_guery_NotConnectedBy
                    {
                    pushFollow(FOLLOW_parse_org_qualitune_guery_NotConnectedBy_in_parse_org_qualitune_guery_EdgeSelection1637);
                    c1=parse_org_qualitune_guery_NotConnectedBy();

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
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_qualitune_guery_EdgeSelection_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_qualitune_guery_EdgeSelection"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_qualitune_guery_MotifModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Motif_in_parse_org_qualitune_guery_MotifModel119 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Motif_in_parse_org_qualitune_guery_MotifModel152 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_parse_org_qualitune_guery_Motif208 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Motif226 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_PreProcessor_in_parse_org_qualitune_guery_Motif256 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_VertexSelection_in_parse_org_qualitune_guery_Motif286 = new BitSet(new long[]{0x0000000000A80002L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_EdgeSelection_in_parse_org_qualitune_guery_Motif313 = new BitSet(new long[]{0x0000000000A80002L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Grouping_in_parse_org_qualitune_guery_Motif348 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_24_in_parse_org_qualitune_guery_PreProcessor389 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_org_qualitune_guery_PreProcessor403 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_CLASSNAME_in_parse_org_qualitune_guery_PreProcessor421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_org_qualitune_guery_VertexSelection457 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Role_in_parse_org_qualitune_guery_VertexSelection475 = new BitSet(new long[]{0x0000000004002002L});
    public static final BitSet FOLLOW_13_in_parse_org_qualitune_guery_VertexSelection502 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Role_in_parse_org_qualitune_guery_VertexSelection528 = new BitSet(new long[]{0x0000000004002002L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Constraint_in_parse_org_qualitune_guery_VertexSelection578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Role623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_org_qualitune_guery_Constraint659 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_qualitune_guery_Constraint677 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_qualitune_guery_Constraint707 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_qualitune_guery_Constraint733 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_19_in_parse_org_qualitune_guery_ConnectedBy794 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_qualitune_guery_ConnectedBy808 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Connection_in_parse_org_qualitune_guery_ConnectedBy826 = new BitSet(new long[]{0x0000000004020002L});
    public static final BitSet FOLLOW_17_in_parse_org_qualitune_guery_ConnectedBy853 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Connection_in_parse_org_qualitune_guery_ConnectedBy879 = new BitSet(new long[]{0x0000000004020002L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Constraint_in_parse_org_qualitune_guery_ConnectedBy929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_qualitune_guery_NotConnectedBy970 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_qualitune_guery_NotConnectedBy984 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_qualitune_guery_NotConnectedBy998 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Connection_in_parse_org_qualitune_guery_NotConnectedBy1016 = new BitSet(new long[]{0x0000000004020002L});
    public static final BitSet FOLLOW_17_in_parse_org_qualitune_guery_NotConnectedBy1043 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Connection_in_parse_org_qualitune_guery_NotConnectedBy1069 = new BitSet(new long[]{0x0000000004020002L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_Constraint_in_parse_org_qualitune_guery_NotConnectedBy1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Connection1164 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_org_qualitune_guery_Connection1185 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Connection1203 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_qualitune_guery_Connection1224 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_qualitune_guery_Connection1242 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_qualitune_guery_Connection1263 = new BitSet(new long[]{0x0000000000108002L});
    public static final BitSet FOLLOW_15_in_parse_org_qualitune_guery_Connection1286 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CARDINALITY_in_parse_org_qualitune_guery_Connection1312 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_qualitune_guery_Connection1345 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CARDINALITY_in_parse_org_qualitune_guery_Connection1371 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_qualitune_guery_Connection1404 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_org_qualitune_guery_Connection1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_org_qualitune_guery_Grouping1482 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_qualitune_guery_Grouping1496 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_qualitune_guery_Grouping1514 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_qualitune_guery_Grouping1544 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_qualitune_guery_Grouping1570 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_ConnectedBy_in_parse_org_qualitune_guery_EdgeSelection1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_qualitune_guery_NotConnectedBy_in_parse_org_qualitune_guery_EdgeSelection1637 = new BitSet(new long[]{0x0000000000000002L});

}