// $ANTLR 3.4

	package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class XwpfParser extends XwpfANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "FLOAT", "INTEGER", "LINEBREAK", "QUOTED_34_34", "TEXT", "WHITESPACE", "':'", "';'", "'Body'", "'BodyElement'", "'Comment'", "'Content'", "'Document'", "'Footer'", "'Footnote'", "'Header'", "'Heading1'", "'Heading2'", "'Hyperlink'", "'ListParagraph'", "'Numbering'", "'Paragraph'", "'Part'", "'PictureData'", "'Run'", "'Table'", "'body'", "'bodyElements'", "'comments'", "'endnotes'", "'footers'", "'footnotes'", "'headers'", "'hyperlinks'", "'isBold'", "'isItalic'", "'isStrike'", "'null'", "'numbering'", "'packagePictures'", "'paragraphs'", "'part'", "'pictures'", "'runs'", "'tables'", "'unrecognized'", "'{'", "'}'"
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
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int COMMENT=4;
    public static final int FLOAT=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_34_34=8;
    public static final int TEXT=9;
    public static final int WHITESPACE=10;

    // delegates
    public XwpfANTLRParserBase[] getDelegates() {
        return new XwpfANTLRParserBase[] {};
    }

    // delegators


    public XwpfParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public XwpfParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(89 + 1);
         

    }

    public String[] getTokenNames() { return XwpfParser.tokenNames; }
    public String getGrammarFileName() { return "Xwpf.g"; }


    	private dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolverFactory tokenResolverFactory = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenResolverFactory();
    	
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
    	private java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal> expectedElements = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal>();
    	
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
    		postParseCommands.add(new dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>() {
    			public boolean execute(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfProblem() {
    					public dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity getSeverity() {
    						return dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity.ERROR;
    					}
    					public dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType getType() {
    						return dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> getQuickFixes() {
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
    		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement terminal = dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfFollowSetProvider.TERMINALS[terminalID];
    		dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[] containmentFeatures = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfFollowSetProvider.LINKS[ids[i]];
    		}
    		dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfContainmentTrace containmentTrace = new dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal expectedElement = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>() {
    			public boolean execute(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource) {
    				dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfLocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>() {
    			public boolean execute(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource) {
    				dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfLocationMap locationMap = resource.getLocationMap();
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
    	protected void setLocalizationEnd(java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>() {
    			public boolean execute(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource) {
    				dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfLocationMap locationMap = resource.getLocationMap();
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
    	
    	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new XwpfParser(new org.antlr.runtime3_4_0.CommonTokenStream(new XwpfLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new XwpfParser(new org.antlr.runtime3_4_0.CommonTokenStream(new XwpfLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public XwpfParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((XwpfLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((XwpfLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Content.class) {
    				return parse_dk_itu_sdg_language_xwpf_Content();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Document.class) {
    				return parse_dk_itu_sdg_language_xwpf_Document();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.BodyElement.class) {
    				return parse_dk_itu_sdg_language_xwpf_BodyElement();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Comment.class) {
    				return parse_dk_itu_sdg_language_xwpf_Comment();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Footnote.class) {
    				return parse_dk_itu_sdg_language_xwpf_Footnote();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Footer.class) {
    				return parse_dk_itu_sdg_language_xwpf_Footer();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Header.class) {
    				return parse_dk_itu_sdg_language_xwpf_Header();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Hyperlink.class) {
    				return parse_dk_itu_sdg_language_xwpf_Hyperlink();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Numbering.class) {
    				return parse_dk_itu_sdg_language_xwpf_Numbering();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.PictureData.class) {
    				return parse_dk_itu_sdg_language_xwpf_PictureData();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Paragraph.class) {
    				return parse_dk_itu_sdg_language_xwpf_Paragraph();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Table.class) {
    				return parse_dk_itu_sdg_language_xwpf_Table();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Run.class) {
    				return parse_dk_itu_sdg_language_xwpf_Run();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Part.class) {
    				return parse_dk_itu_sdg_language_xwpf_Part();
    			}
    			if (type.getInstanceClass() == dk.itu.sdg.language.xwpf.Body.class) {
    				return parse_dk_itu_sdg_language_xwpf_Body();
    			}
    		}
    		throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>>();
    		dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfParseResult parseResult = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfParseResult();
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
    	
    	public java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfParseResult result = parse();
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
    			for (dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal>();
    		java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal> newFollowSet = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 130;
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
    				for (dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]> newFollowerPair : newFollowers) {
    							dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfContainmentTrace containmentTrace = new dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfContainmentTrace(null, newFollowerPair.getRight());
    							dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal newFollowTerminal = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectedTerminal expectedElement, int tokenIndex) {
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
    // Xwpf.g:541:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_dk_itu_sdg_language_xwpf_Content |c1= parse_dk_itu_sdg_language_xwpf_Comment |c2= parse_dk_itu_sdg_language_xwpf_Footnote |c3= parse_dk_itu_sdg_language_xwpf_Footer |c4= parse_dk_itu_sdg_language_xwpf_Header |c5= parse_dk_itu_sdg_language_xwpf_Paragraph |c6= parse_dk_itu_sdg_language_xwpf_Run |c7= parse_dk_itu_sdg_language_xwpf_Document ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        dk.itu.sdg.language.xwpf.Content c0 =null;

        dk.itu.sdg.language.xwpf.Comment c1 =null;

        dk.itu.sdg.language.xwpf.Footnote c2 =null;

        dk.itu.sdg.language.xwpf.Footer c3 =null;

        dk.itu.sdg.language.xwpf.Header c4 =null;

        dk.itu.sdg.language.xwpf.Paragraph c5 =null;

        dk.itu.sdg.language.xwpf.Run c6 =null;

        dk.itu.sdg.language.xwpf.Document c7 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Xwpf.g:542:2: ( (c0= parse_dk_itu_sdg_language_xwpf_Content |c1= parse_dk_itu_sdg_language_xwpf_Comment |c2= parse_dk_itu_sdg_language_xwpf_Footnote |c3= parse_dk_itu_sdg_language_xwpf_Footer |c4= parse_dk_itu_sdg_language_xwpf_Header |c5= parse_dk_itu_sdg_language_xwpf_Paragraph |c6= parse_dk_itu_sdg_language_xwpf_Run |c7= parse_dk_itu_sdg_language_xwpf_Document ) EOF )
            // Xwpf.g:543:2: (c0= parse_dk_itu_sdg_language_xwpf_Content |c1= parse_dk_itu_sdg_language_xwpf_Comment |c2= parse_dk_itu_sdg_language_xwpf_Footnote |c3= parse_dk_itu_sdg_language_xwpf_Footer |c4= parse_dk_itu_sdg_language_xwpf_Header |c5= parse_dk_itu_sdg_language_xwpf_Paragraph |c6= parse_dk_itu_sdg_language_xwpf_Run |c7= parse_dk_itu_sdg_language_xwpf_Document ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[10]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Xwpf.g:558:2: (c0= parse_dk_itu_sdg_language_xwpf_Content |c1= parse_dk_itu_sdg_language_xwpf_Comment |c2= parse_dk_itu_sdg_language_xwpf_Footnote |c3= parse_dk_itu_sdg_language_xwpf_Footer |c4= parse_dk_itu_sdg_language_xwpf_Header |c5= parse_dk_itu_sdg_language_xwpf_Paragraph |c6= parse_dk_itu_sdg_language_xwpf_Run |c7= parse_dk_itu_sdg_language_xwpf_Document )
            int alt1=8;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // Xwpf.g:559:3: c0= parse_dk_itu_sdg_language_xwpf_Content
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Content_in_start82);
                    c0=parse_dk_itu_sdg_language_xwpf_Content();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; }

                    }
                    break;
                case 2 :
                    // Xwpf.g:560:8: c1= parse_dk_itu_sdg_language_xwpf_Comment
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Comment_in_start96);
                    c1=parse_dk_itu_sdg_language_xwpf_Comment();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; }

                    }
                    break;
                case 3 :
                    // Xwpf.g:561:8: c2= parse_dk_itu_sdg_language_xwpf_Footnote
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_start110);
                    c2=parse_dk_itu_sdg_language_xwpf_Footnote();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; }

                    }
                    break;
                case 4 :
                    // Xwpf.g:562:8: c3= parse_dk_itu_sdg_language_xwpf_Footer
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Footer_in_start124);
                    c3=parse_dk_itu_sdg_language_xwpf_Footer();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; }

                    }
                    break;
                case 5 :
                    // Xwpf.g:563:8: c4= parse_dk_itu_sdg_language_xwpf_Header
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Header_in_start138);
                    c4=parse_dk_itu_sdg_language_xwpf_Header();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; }

                    }
                    break;
                case 6 :
                    // Xwpf.g:564:8: c5= parse_dk_itu_sdg_language_xwpf_Paragraph
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Paragraph_in_start152);
                    c5=parse_dk_itu_sdg_language_xwpf_Paragraph();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; }

                    }
                    break;
                case 7 :
                    // Xwpf.g:565:8: c6= parse_dk_itu_sdg_language_xwpf_Run
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Run_in_start166);
                    c6=parse_dk_itu_sdg_language_xwpf_Run();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; }

                    }
                    break;
                case 8 :
                    // Xwpf.g:566:8: c7= parse_dk_itu_sdg_language_xwpf_Document
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Document_in_start180);
                    c7=parse_dk_itu_sdg_language_xwpf_Document();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; }

                    }
                    break;

            }


            match(input,EOF,FOLLOW_EOF_in_start187); if (state.failed) return element;

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



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Content"
    // Xwpf.g:574:1: parse_dk_itu_sdg_language_xwpf_Content returns [dk.itu.sdg.language.xwpf.Content element = null] : (a0= 'Content' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}' |c0= parse_dk_itu_sdg_language_xwpf_Comment |c1= parse_dk_itu_sdg_language_xwpf_Footnote |c2= parse_dk_itu_sdg_language_xwpf_Footer |c3= parse_dk_itu_sdg_language_xwpf_Header |c4= parse_dk_itu_sdg_language_xwpf_Paragraph |c5= parse_dk_itu_sdg_language_xwpf_Run );
    public final dk.itu.sdg.language.xwpf.Content parse_dk_itu_sdg_language_xwpf_Content() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Content element =  null;

        int parse_dk_itu_sdg_language_xwpf_Content_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        dk.itu.sdg.language.xwpf.Comment c0 =null;

        dk.itu.sdg.language.xwpf.Footnote c1 =null;

        dk.itu.sdg.language.xwpf.Footer c2 =null;

        dk.itu.sdg.language.xwpf.Header c3 =null;

        dk.itu.sdg.language.xwpf.Paragraph c4 =null;

        dk.itu.sdg.language.xwpf.Run c5 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Xwpf.g:577:2: (a0= 'Content' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}' |c0= parse_dk_itu_sdg_language_xwpf_Comment |c1= parse_dk_itu_sdg_language_xwpf_Footnote |c2= parse_dk_itu_sdg_language_xwpf_Footer |c3= parse_dk_itu_sdg_language_xwpf_Header |c4= parse_dk_itu_sdg_language_xwpf_Paragraph |c5= parse_dk_itu_sdg_language_xwpf_Run )
            int alt3=7;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt3=1;
                }
                break;
            case 15:
                {
                alt3=2;
                }
                break;
            case 19:
                {
                alt3=3;
                }
                break;
            case 18:
                {
                alt3=4;
                }
                break;
            case 20:
                {
                alt3=5;
                }
                break;
            case 26:
                {
                alt3=6;
                }
                break;
            case 29:
            case 39:
            case 40:
            case 41:
                {
                alt3=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // Xwpf.g:578:2: a0= 'Content' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}'
                    {
                    a0=(Token)match(input,16,FOLLOW_16_in_parse_dk_itu_sdg_language_xwpf_Content213); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createContent();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_0_0_0_0, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[11]);
                    	}

                    a1=(Token)match(input,51,FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Content227); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createContent();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_0_0_0_1, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[12]);
                    		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[13]);
                    	}

                    // Xwpf.g:607:2: ( ( (a2= QUOTED_34_34 ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==QUOTED_34_34) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Xwpf.g:608:3: ( (a2= QUOTED_34_34 ) )
                    	    {
                    	    // Xwpf.g:608:3: ( (a2= QUOTED_34_34 ) )
                    	    // Xwpf.g:609:4: (a2= QUOTED_34_34 )
                    	    {
                    	    // Xwpf.g:609:4: (a2= QUOTED_34_34 )
                    	    // Xwpf.g:610:5: a2= QUOTED_34_34
                    	    {
                    	    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Content256); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    					if (terminateParsing) {
                    	    						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
                    	    					}
                    	    					if (element == null) {
                    	    						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createContent();
                    	    						startIncompleteElement(element);
                    	    					}
                    	    					if (a2 != null) {
                    	    						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    	    						tokenResolver.setOptions(getOptions());
                    	    						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
                    	    						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.CONTENT__TEXT), result);
                    	    						Object resolvedObject = result.getResolvedToken();
                    	    						if (resolvedObject == null) {
                    	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
                    	    						}
                    	    						java.lang.String resolved = (java.lang.String) resolvedObject;
                    	    						if (resolved != null) {
                    	    							Object value = resolved;
                    	    							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.CONTENT__TEXT), value);
                    	    							completedElement(value, false);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_0_0_0_2_0_0_0, resolved, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
                    	    					}
                    	    				}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    				// expected elements (follow set)
                    	    				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[14]);
                    	    				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[15]);
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
                    		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[16]);
                    		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[17]);
                    	}

                    a3=(Token)match(input,52,FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Content302); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createContent();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_0_0_0_3, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    	}

                    }
                    break;
                case 2 :
                    // Xwpf.g:669:2: c0= parse_dk_itu_sdg_language_xwpf_Comment
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Comment_in_parse_dk_itu_sdg_language_xwpf_Content321);
                    c0=parse_dk_itu_sdg_language_xwpf_Comment();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xwpf.g:670:4: c1= parse_dk_itu_sdg_language_xwpf_Footnote
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_parse_dk_itu_sdg_language_xwpf_Content331);
                    c1=parse_dk_itu_sdg_language_xwpf_Footnote();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xwpf.g:671:4: c2= parse_dk_itu_sdg_language_xwpf_Footer
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Footer_in_parse_dk_itu_sdg_language_xwpf_Content341);
                    c2=parse_dk_itu_sdg_language_xwpf_Footer();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xwpf.g:672:4: c3= parse_dk_itu_sdg_language_xwpf_Header
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Header_in_parse_dk_itu_sdg_language_xwpf_Content351);
                    c3=parse_dk_itu_sdg_language_xwpf_Header();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xwpf.g:673:4: c4= parse_dk_itu_sdg_language_xwpf_Paragraph
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Paragraph_in_parse_dk_itu_sdg_language_xwpf_Content361);
                    c4=parse_dk_itu_sdg_language_xwpf_Paragraph();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xwpf.g:674:4: c5= parse_dk_itu_sdg_language_xwpf_Run
                    {
                    pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Run_in_parse_dk_itu_sdg_language_xwpf_Content371);
                    c5=parse_dk_itu_sdg_language_xwpf_Run();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_dk_itu_sdg_language_xwpf_Content_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Content"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Document"
    // Xwpf.g:678:1: parse_dk_itu_sdg_language_xwpf_Document returns [dk.itu.sdg.language.xwpf.Document element = null] : a0= 'Document' a1= '{' ( (a2= 'bodyElements' a3= ':' (a4_0= parse_dk_itu_sdg_language_xwpf_BodyElement ) |a5= 'comments' a6= ':' (a7_0= parse_dk_itu_sdg_language_xwpf_Comment ) |a8= 'endnotes' a9= ':' (a10_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a11= 'footers' a12= ':' (a13_0= parse_dk_itu_sdg_language_xwpf_Footer ) |a14= 'footnotes' a15= ':' (a16_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a17= 'headers' a18= ':' (a19_0= parse_dk_itu_sdg_language_xwpf_Header ) |a20= 'hyperlinks' a21= ':' (a22_0= parse_dk_itu_sdg_language_xwpf_Hyperlink ) |a23= 'numbering' a24= ':' (a25_0= parse_dk_itu_sdg_language_xwpf_Numbering ) |a26= 'packagePictures' a27= ':' (a28_0= parse_dk_itu_sdg_language_xwpf_PictureData ) |a29= 'paragraphs' a30= ':' (a31_0= parse_dk_itu_sdg_language_xwpf_Paragraph ) |a32= 'pictures' a33= ':' (a34_0= parse_dk_itu_sdg_language_xwpf_PictureData ) | ( (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' ) ) |a42= 'tables' a43= ':' (a44_0= parse_dk_itu_sdg_language_xwpf_Table ) ) )* a45= '}' ;
    public final dk.itu.sdg.language.xwpf.Document parse_dk_itu_sdg_language_xwpf_Document() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Document element =  null;

        int parse_dk_itu_sdg_language_xwpf_Document_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        Token a9=null;
        Token a11=null;
        Token a12=null;
        Token a14=null;
        Token a15=null;
        Token a17=null;
        Token a18=null;
        Token a20=null;
        Token a21=null;
        Token a23=null;
        Token a24=null;
        Token a26=null;
        Token a27=null;
        Token a29=null;
        Token a30=null;
        Token a32=null;
        Token a33=null;
        Token a35=null;
        Token a36=null;
        Token a37=null;
        Token a38=null;
        Token a39=null;
        Token a42=null;
        Token a43=null;
        Token a45=null;
        dk.itu.sdg.language.xwpf.BodyElement a4_0 =null;

        dk.itu.sdg.language.xwpf.Comment a7_0 =null;

        dk.itu.sdg.language.xwpf.Footnote a10_0 =null;

        dk.itu.sdg.language.xwpf.Footer a13_0 =null;

        dk.itu.sdg.language.xwpf.Footnote a16_0 =null;

        dk.itu.sdg.language.xwpf.Header a19_0 =null;

        dk.itu.sdg.language.xwpf.Hyperlink a22_0 =null;

        dk.itu.sdg.language.xwpf.Numbering a25_0 =null;

        dk.itu.sdg.language.xwpf.PictureData a28_0 =null;

        dk.itu.sdg.language.xwpf.Paragraph a31_0 =null;

        dk.itu.sdg.language.xwpf.PictureData a34_0 =null;

        dk.itu.sdg.language.xwpf.Table a44_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Xwpf.g:681:2: (a0= 'Document' a1= '{' ( (a2= 'bodyElements' a3= ':' (a4_0= parse_dk_itu_sdg_language_xwpf_BodyElement ) |a5= 'comments' a6= ':' (a7_0= parse_dk_itu_sdg_language_xwpf_Comment ) |a8= 'endnotes' a9= ':' (a10_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a11= 'footers' a12= ':' (a13_0= parse_dk_itu_sdg_language_xwpf_Footer ) |a14= 'footnotes' a15= ':' (a16_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a17= 'headers' a18= ':' (a19_0= parse_dk_itu_sdg_language_xwpf_Header ) |a20= 'hyperlinks' a21= ':' (a22_0= parse_dk_itu_sdg_language_xwpf_Hyperlink ) |a23= 'numbering' a24= ':' (a25_0= parse_dk_itu_sdg_language_xwpf_Numbering ) |a26= 'packagePictures' a27= ':' (a28_0= parse_dk_itu_sdg_language_xwpf_PictureData ) |a29= 'paragraphs' a30= ':' (a31_0= parse_dk_itu_sdg_language_xwpf_Paragraph ) |a32= 'pictures' a33= ':' (a34_0= parse_dk_itu_sdg_language_xwpf_PictureData ) | ( (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' ) ) |a42= 'tables' a43= ':' (a44_0= parse_dk_itu_sdg_language_xwpf_Table ) ) )* a45= '}' )
            // Xwpf.g:682:2: a0= 'Document' a1= '{' ( (a2= 'bodyElements' a3= ':' (a4_0= parse_dk_itu_sdg_language_xwpf_BodyElement ) |a5= 'comments' a6= ':' (a7_0= parse_dk_itu_sdg_language_xwpf_Comment ) |a8= 'endnotes' a9= ':' (a10_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a11= 'footers' a12= ':' (a13_0= parse_dk_itu_sdg_language_xwpf_Footer ) |a14= 'footnotes' a15= ':' (a16_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a17= 'headers' a18= ':' (a19_0= parse_dk_itu_sdg_language_xwpf_Header ) |a20= 'hyperlinks' a21= ':' (a22_0= parse_dk_itu_sdg_language_xwpf_Hyperlink ) |a23= 'numbering' a24= ':' (a25_0= parse_dk_itu_sdg_language_xwpf_Numbering ) |a26= 'packagePictures' a27= ':' (a28_0= parse_dk_itu_sdg_language_xwpf_PictureData ) |a29= 'paragraphs' a30= ':' (a31_0= parse_dk_itu_sdg_language_xwpf_Paragraph ) |a32= 'pictures' a33= ':' (a34_0= parse_dk_itu_sdg_language_xwpf_PictureData ) | ( (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' ) ) |a42= 'tables' a43= ':' (a44_0= parse_dk_itu_sdg_language_xwpf_Table ) ) )* a45= '}'
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_dk_itu_sdg_language_xwpf_Document396); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[18]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Document410); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[23]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[32]);
            	}

            // Xwpf.g:723:2: ( (a2= 'bodyElements' a3= ':' (a4_0= parse_dk_itu_sdg_language_xwpf_BodyElement ) |a5= 'comments' a6= ':' (a7_0= parse_dk_itu_sdg_language_xwpf_Comment ) |a8= 'endnotes' a9= ':' (a10_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a11= 'footers' a12= ':' (a13_0= parse_dk_itu_sdg_language_xwpf_Footer ) |a14= 'footnotes' a15= ':' (a16_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a17= 'headers' a18= ':' (a19_0= parse_dk_itu_sdg_language_xwpf_Header ) |a20= 'hyperlinks' a21= ':' (a22_0= parse_dk_itu_sdg_language_xwpf_Hyperlink ) |a23= 'numbering' a24= ':' (a25_0= parse_dk_itu_sdg_language_xwpf_Numbering ) |a26= 'packagePictures' a27= ':' (a28_0= parse_dk_itu_sdg_language_xwpf_PictureData ) |a29= 'paragraphs' a30= ':' (a31_0= parse_dk_itu_sdg_language_xwpf_Paragraph ) |a32= 'pictures' a33= ':' (a34_0= parse_dk_itu_sdg_language_xwpf_PictureData ) | ( (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' ) ) |a42= 'tables' a43= ':' (a44_0= parse_dk_itu_sdg_language_xwpf_Table ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 21 && LA6_0 <= 22)||LA6_0==24||(LA6_0 >= 32 && LA6_0 <= 38)||(LA6_0 >= 42 && LA6_0 <= 45)||LA6_0==47||(LA6_0 >= 49 && LA6_0 <= 50)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Xwpf.g:724:3: (a2= 'bodyElements' a3= ':' (a4_0= parse_dk_itu_sdg_language_xwpf_BodyElement ) |a5= 'comments' a6= ':' (a7_0= parse_dk_itu_sdg_language_xwpf_Comment ) |a8= 'endnotes' a9= ':' (a10_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a11= 'footers' a12= ':' (a13_0= parse_dk_itu_sdg_language_xwpf_Footer ) |a14= 'footnotes' a15= ':' (a16_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a17= 'headers' a18= ':' (a19_0= parse_dk_itu_sdg_language_xwpf_Header ) |a20= 'hyperlinks' a21= ':' (a22_0= parse_dk_itu_sdg_language_xwpf_Hyperlink ) |a23= 'numbering' a24= ':' (a25_0= parse_dk_itu_sdg_language_xwpf_Numbering ) |a26= 'packagePictures' a27= ':' (a28_0= parse_dk_itu_sdg_language_xwpf_PictureData ) |a29= 'paragraphs' a30= ':' (a31_0= parse_dk_itu_sdg_language_xwpf_Paragraph ) |a32= 'pictures' a33= ':' (a34_0= parse_dk_itu_sdg_language_xwpf_PictureData ) | ( (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' ) ) |a42= 'tables' a43= ':' (a44_0= parse_dk_itu_sdg_language_xwpf_Table ) )
            	    {
            	    // Xwpf.g:724:3: (a2= 'bodyElements' a3= ':' (a4_0= parse_dk_itu_sdg_language_xwpf_BodyElement ) |a5= 'comments' a6= ':' (a7_0= parse_dk_itu_sdg_language_xwpf_Comment ) |a8= 'endnotes' a9= ':' (a10_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a11= 'footers' a12= ':' (a13_0= parse_dk_itu_sdg_language_xwpf_Footer ) |a14= 'footnotes' a15= ':' (a16_0= parse_dk_itu_sdg_language_xwpf_Footnote ) |a17= 'headers' a18= ':' (a19_0= parse_dk_itu_sdg_language_xwpf_Header ) |a20= 'hyperlinks' a21= ':' (a22_0= parse_dk_itu_sdg_language_xwpf_Hyperlink ) |a23= 'numbering' a24= ':' (a25_0= parse_dk_itu_sdg_language_xwpf_Numbering ) |a26= 'packagePictures' a27= ':' (a28_0= parse_dk_itu_sdg_language_xwpf_PictureData ) |a29= 'paragraphs' a30= ':' (a31_0= parse_dk_itu_sdg_language_xwpf_Paragraph ) |a32= 'pictures' a33= ':' (a34_0= parse_dk_itu_sdg_language_xwpf_PictureData ) | ( (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' ) ) |a42= 'tables' a43= ':' (a44_0= parse_dk_itu_sdg_language_xwpf_Table ) )
            	    int alt5=13;
            	    switch ( input.LA(1) ) {
            	    case 32:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    case 35:
            	        {
            	        alt5=4;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt5=5;
            	        }
            	        break;
            	    case 37:
            	        {
            	        alt5=6;
            	        }
            	        break;
            	    case 38:
            	        {
            	        alt5=7;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt5=8;
            	        }
            	        break;
            	    case 44:
            	        {
            	        alt5=9;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt5=10;
            	        }
            	        break;
            	    case 47:
            	        {
            	        alt5=11;
            	        }
            	        break;
            	    case 21:
            	    case 22:
            	    case 24:
            	    case 42:
            	    case 50:
            	        {
            	        alt5=12;
            	        }
            	        break;
            	    case 49:
            	        {
            	        alt5=13;
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
            	            // Xwpf.g:725:4: a2= 'bodyElements' a3= ':' (a4_0= parse_dk_itu_sdg_language_xwpf_BodyElement )
            	            {
            	            a2=(Token)match(input,32,FOLLOW_32_in_parse_dk_itu_sdg_language_xwpf_Document433); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_0_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[33]);
            	            			}

            	            a3=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document453); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_0_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[34]);
            	            			}

            	            // Xwpf.g:753:4: (a4_0= parse_dk_itu_sdg_language_xwpf_BodyElement )
            	            // Xwpf.g:754:5: a4_0= parse_dk_itu_sdg_language_xwpf_BodyElement
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_BodyElement_in_parse_dk_itu_sdg_language_xwpf_Document479);
            	            a4_0=parse_dk_itu_sdg_language_xwpf_BodyElement();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a4_0 != null) {
            	            						if (a4_0 != null) {
            	            							Object value = a4_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__BODY_ELEMENTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_0_2, a4_0, true);
            	            						copyLocalizationInfos(a4_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[35]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[36]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[37]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[38]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[39]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[40]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[41]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[42]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[43]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[44]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[45]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[46]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[47]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[48]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Xwpf.g:793:8: a5= 'comments' a6= ':' (a7_0= parse_dk_itu_sdg_language_xwpf_Comment )
            	            {
            	            a5=(Token)match(input,33,FOLLOW_33_in_parse_dk_itu_sdg_language_xwpf_Document515); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_1_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[49]);
            	            			}

            	            a6=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document535); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_1_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[50]);
            	            			}

            	            // Xwpf.g:821:4: (a7_0= parse_dk_itu_sdg_language_xwpf_Comment )
            	            // Xwpf.g:822:5: a7_0= parse_dk_itu_sdg_language_xwpf_Comment
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Comment_in_parse_dk_itu_sdg_language_xwpf_Document561);
            	            a7_0=parse_dk_itu_sdg_language_xwpf_Comment();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a7_0 != null) {
            	            						if (a7_0 != null) {
            	            							Object value = a7_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__COMMENTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_1_2, a7_0, true);
            	            						copyLocalizationInfos(a7_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[51]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[52]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[53]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[54]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[55]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[56]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[57]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[58]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[59]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[60]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[61]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[62]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[63]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[64]);
            	            			}

            	            }
            	            break;
            	        case 3 :
            	            // Xwpf.g:861:8: a8= 'endnotes' a9= ':' (a10_0= parse_dk_itu_sdg_language_xwpf_Footnote )
            	            {
            	            a8=(Token)match(input,34,FOLLOW_34_in_parse_dk_itu_sdg_language_xwpf_Document597); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_2_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[65]);
            	            			}

            	            a9=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document617); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_2_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[66]);
            	            			}

            	            // Xwpf.g:889:4: (a10_0= parse_dk_itu_sdg_language_xwpf_Footnote )
            	            // Xwpf.g:890:5: a10_0= parse_dk_itu_sdg_language_xwpf_Footnote
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_parse_dk_itu_sdg_language_xwpf_Document643);
            	            a10_0=parse_dk_itu_sdg_language_xwpf_Footnote();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a10_0 != null) {
            	            						if (a10_0 != null) {
            	            							Object value = a10_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__ENDNOTES, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_2_2, a10_0, true);
            	            						copyLocalizationInfos(a10_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[67]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[68]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[69]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[70]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[71]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[72]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[73]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[74]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[75]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[76]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[77]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[78]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[79]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[80]);
            	            			}

            	            }
            	            break;
            	        case 4 :
            	            // Xwpf.g:929:8: a11= 'footers' a12= ':' (a13_0= parse_dk_itu_sdg_language_xwpf_Footer )
            	            {
            	            a11=(Token)match(input,35,FOLLOW_35_in_parse_dk_itu_sdg_language_xwpf_Document679); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_3_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[81]);
            	            			}

            	            a12=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document699); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_3_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[82]);
            	            			}

            	            // Xwpf.g:957:4: (a13_0= parse_dk_itu_sdg_language_xwpf_Footer )
            	            // Xwpf.g:958:5: a13_0= parse_dk_itu_sdg_language_xwpf_Footer
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Footer_in_parse_dk_itu_sdg_language_xwpf_Document725);
            	            a13_0=parse_dk_itu_sdg_language_xwpf_Footer();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a13_0 != null) {
            	            						if (a13_0 != null) {
            	            							Object value = a13_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__FOOTERS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_3_2, a13_0, true);
            	            						copyLocalizationInfos(a13_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[83]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[84]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[85]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[86]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[87]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[88]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[89]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[90]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[91]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[92]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[93]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[94]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[95]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[96]);
            	            			}

            	            }
            	            break;
            	        case 5 :
            	            // Xwpf.g:997:8: a14= 'footnotes' a15= ':' (a16_0= parse_dk_itu_sdg_language_xwpf_Footnote )
            	            {
            	            a14=(Token)match(input,36,FOLLOW_36_in_parse_dk_itu_sdg_language_xwpf_Document761); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_4_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[97]);
            	            			}

            	            a15=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document781); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_4_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[98]);
            	            			}

            	            // Xwpf.g:1025:4: (a16_0= parse_dk_itu_sdg_language_xwpf_Footnote )
            	            // Xwpf.g:1026:5: a16_0= parse_dk_itu_sdg_language_xwpf_Footnote
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_parse_dk_itu_sdg_language_xwpf_Document807);
            	            a16_0=parse_dk_itu_sdg_language_xwpf_Footnote();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a16_0 != null) {
            	            						if (a16_0 != null) {
            	            							Object value = a16_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__FOOTNOTES, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_4_2, a16_0, true);
            	            						copyLocalizationInfos(a16_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[99]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[100]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[101]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[102]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[103]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[104]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[105]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[106]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[107]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[108]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[109]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[110]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[111]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[112]);
            	            			}

            	            }
            	            break;
            	        case 6 :
            	            // Xwpf.g:1065:8: a17= 'headers' a18= ':' (a19_0= parse_dk_itu_sdg_language_xwpf_Header )
            	            {
            	            a17=(Token)match(input,37,FOLLOW_37_in_parse_dk_itu_sdg_language_xwpf_Document843); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_5_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[113]);
            	            			}

            	            a18=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document863); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_5_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[114]);
            	            			}

            	            // Xwpf.g:1093:4: (a19_0= parse_dk_itu_sdg_language_xwpf_Header )
            	            // Xwpf.g:1094:5: a19_0= parse_dk_itu_sdg_language_xwpf_Header
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Header_in_parse_dk_itu_sdg_language_xwpf_Document889);
            	            a19_0=parse_dk_itu_sdg_language_xwpf_Header();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a19_0 != null) {
            	            						if (a19_0 != null) {
            	            							Object value = a19_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__HEADERS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_5_2, a19_0, true);
            	            						copyLocalizationInfos(a19_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[115]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[116]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[117]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[118]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[119]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[120]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[121]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[122]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[123]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[124]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[125]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[126]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[127]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[128]);
            	            			}

            	            }
            	            break;
            	        case 7 :
            	            // Xwpf.g:1133:8: a20= 'hyperlinks' a21= ':' (a22_0= parse_dk_itu_sdg_language_xwpf_Hyperlink )
            	            {
            	            a20=(Token)match(input,38,FOLLOW_38_in_parse_dk_itu_sdg_language_xwpf_Document925); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_6_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[129]);
            	            			}

            	            a21=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document945); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_6_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[130]);
            	            			}

            	            // Xwpf.g:1161:4: (a22_0= parse_dk_itu_sdg_language_xwpf_Hyperlink )
            	            // Xwpf.g:1162:5: a22_0= parse_dk_itu_sdg_language_xwpf_Hyperlink
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Hyperlink_in_parse_dk_itu_sdg_language_xwpf_Document971);
            	            a22_0=parse_dk_itu_sdg_language_xwpf_Hyperlink();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a22_0 != null) {
            	            						if (a22_0 != null) {
            	            							Object value = a22_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__HYPERLINKS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_6_2, a22_0, true);
            	            						copyLocalizationInfos(a22_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[131]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[132]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[133]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[134]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[135]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[136]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[137]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[138]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[139]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[140]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[141]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[142]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[143]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[144]);
            	            			}

            	            }
            	            break;
            	        case 8 :
            	            // Xwpf.g:1201:8: a23= 'numbering' a24= ':' (a25_0= parse_dk_itu_sdg_language_xwpf_Numbering )
            	            {
            	            a23=(Token)match(input,43,FOLLOW_43_in_parse_dk_itu_sdg_language_xwpf_Document1007); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_7_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a23, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[145]);
            	            			}

            	            a24=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1027); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_7_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[146]);
            	            			}

            	            // Xwpf.g:1229:4: (a25_0= parse_dk_itu_sdg_language_xwpf_Numbering )
            	            // Xwpf.g:1230:5: a25_0= parse_dk_itu_sdg_language_xwpf_Numbering
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Numbering_in_parse_dk_itu_sdg_language_xwpf_Document1053);
            	            a25_0=parse_dk_itu_sdg_language_xwpf_Numbering();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a25_0 != null) {
            	            						if (a25_0 != null) {
            	            							Object value = a25_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__NUMBERING, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_7_2, a25_0, true);
            	            						copyLocalizationInfos(a25_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[147]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[148]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[149]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[150]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[151]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[152]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[153]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[154]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[155]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[156]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[157]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[158]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[159]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[160]);
            	            			}

            	            }
            	            break;
            	        case 9 :
            	            // Xwpf.g:1269:8: a26= 'packagePictures' a27= ':' (a28_0= parse_dk_itu_sdg_language_xwpf_PictureData )
            	            {
            	            a26=(Token)match(input,44,FOLLOW_44_in_parse_dk_itu_sdg_language_xwpf_Document1089); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_8_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a26, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[161]);
            	            			}

            	            a27=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1109); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_8_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a27, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[162]);
            	            			}

            	            // Xwpf.g:1297:4: (a28_0= parse_dk_itu_sdg_language_xwpf_PictureData )
            	            // Xwpf.g:1298:5: a28_0= parse_dk_itu_sdg_language_xwpf_PictureData
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_PictureData_in_parse_dk_itu_sdg_language_xwpf_Document1135);
            	            a28_0=parse_dk_itu_sdg_language_xwpf_PictureData();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a28_0 != null) {
            	            						if (a28_0 != null) {
            	            							Object value = a28_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__PACKAGE_PICTURES, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_8_2, a28_0, true);
            	            						copyLocalizationInfos(a28_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[163]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[164]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[165]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[166]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[167]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[168]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[169]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[170]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[171]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[172]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[173]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[174]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[175]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[176]);
            	            			}

            	            }
            	            break;
            	        case 10 :
            	            // Xwpf.g:1337:8: a29= 'paragraphs' a30= ':' (a31_0= parse_dk_itu_sdg_language_xwpf_Paragraph )
            	            {
            	            a29=(Token)match(input,45,FOLLOW_45_in_parse_dk_itu_sdg_language_xwpf_Document1171); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_9_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a29, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[177]);
            	            			}

            	            a30=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1191); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_9_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a30, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[178]);
            	            			}

            	            // Xwpf.g:1365:4: (a31_0= parse_dk_itu_sdg_language_xwpf_Paragraph )
            	            // Xwpf.g:1366:5: a31_0= parse_dk_itu_sdg_language_xwpf_Paragraph
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Paragraph_in_parse_dk_itu_sdg_language_xwpf_Document1217);
            	            a31_0=parse_dk_itu_sdg_language_xwpf_Paragraph();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a31_0 != null) {
            	            						if (a31_0 != null) {
            	            							Object value = a31_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__PARAGRAPHS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_9_2, a31_0, true);
            	            						copyLocalizationInfos(a31_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[179]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[180]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[181]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[182]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[183]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[184]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[185]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[186]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[187]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[188]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[189]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[190]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[191]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[192]);
            	            			}

            	            }
            	            break;
            	        case 11 :
            	            // Xwpf.g:1405:8: a32= 'pictures' a33= ':' (a34_0= parse_dk_itu_sdg_language_xwpf_PictureData )
            	            {
            	            a32=(Token)match(input,47,FOLLOW_47_in_parse_dk_itu_sdg_language_xwpf_Document1253); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_10_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a32, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[193]);
            	            			}

            	            a33=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1273); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_10_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a33, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[194]);
            	            			}

            	            // Xwpf.g:1433:4: (a34_0= parse_dk_itu_sdg_language_xwpf_PictureData )
            	            // Xwpf.g:1434:5: a34_0= parse_dk_itu_sdg_language_xwpf_PictureData
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_PictureData_in_parse_dk_itu_sdg_language_xwpf_Document1299);
            	            a34_0=parse_dk_itu_sdg_language_xwpf_PictureData();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a34_0 != null) {
            	            						if (a34_0 != null) {
            	            							Object value = a34_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__PICTURES, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_10_2, a34_0, true);
            	            						copyLocalizationInfos(a34_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[195]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[196]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[197]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[198]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[199]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[200]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[201]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[202]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[203]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[204]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[205]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[206]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[207]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[208]);
            	            			}

            	            }
            	            break;
            	        case 12 :
            	            // Xwpf.g:1473:8: ( (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' ) )
            	            {
            	            // Xwpf.g:1473:8: ( (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' ) )
            	            // Xwpf.g:1474:5: (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' )
            	            {
            	            // Xwpf.g:1474:5: (a35= 'unrecognized' |a36= 'Heading1' |a37= 'Heading2' |a38= 'ListParagraph' |a39= 'null' )
            	            int alt4=5;
            	            switch ( input.LA(1) ) {
            	            case 50:
            	                {
            	                alt4=1;
            	                }
            	                break;
            	            case 21:
            	                {
            	                alt4=2;
            	                }
            	                break;
            	            case 22:
            	                {
            	                alt4=3;
            	                }
            	                break;
            	            case 24:
            	                {
            	                alt4=4;
            	                }
            	                break;
            	            case 42:
            	                {
            	                alt4=5;
            	                }
            	                break;
            	            default:
            	                if (state.backtracking>0) {state.failed=true; return element;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 4, 0, input);

            	                throw nvae;

            	            }

            	            switch (alt4) {
            	                case 1 :
            	                    // Xwpf.g:1475:6: a35= 'unrecognized'
            	                    {
            	                    a35=(Token)match(input,50,FOLLOW_50_in_parse_dk_itu_sdg_language_xwpf_Document1348); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_11_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a35, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.UNRECOGNIZED_VALUE).getInstance();
            	                    						addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__STYLES, value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 2 :
            	                    // Xwpf.g:1488:12: a36= 'Heading1'
            	                    {
            	                    a36=(Token)match(input,21,FOLLOW_21_in_parse_dk_itu_sdg_language_xwpf_Document1367); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_11_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a36, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.HEADING1_VALUE).getInstance();
            	                    						addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__STYLES, value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 3 :
            	                    // Xwpf.g:1501:12: a37= 'Heading2'
            	                    {
            	                    a37=(Token)match(input,22,FOLLOW_22_in_parse_dk_itu_sdg_language_xwpf_Document1386); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_11_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a37, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.HEADING2_VALUE).getInstance();
            	                    						addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__STYLES, value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 4 :
            	                    // Xwpf.g:1514:12: a38= 'ListParagraph'
            	                    {
            	                    a38=(Token)match(input,24,FOLLOW_24_in_parse_dk_itu_sdg_language_xwpf_Document1405); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_11_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a38, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.LIST_PARAGRAPH_VALUE).getInstance();
            	                    						addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__STYLES, value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 5 :
            	                    // Xwpf.g:1527:12: a39= 'null'
            	                    {
            	                    a39=(Token)match(input,42,FOLLOW_42_in_parse_dk_itu_sdg_language_xwpf_Document1424); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_11_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a39, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.NORMAL_VALUE).getInstance();
            	                    						addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__STYLES, value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;

            	            }


            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[209]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[210]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[211]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[212]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[213]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[214]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[215]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[216]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[217]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[218]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[219]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[220]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[221]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[222]);
            	            			}

            	            }
            	            break;
            	        case 13 :
            	            // Xwpf.g:1561:8: a42= 'tables' a43= ':' (a44_0= parse_dk_itu_sdg_language_xwpf_Table )
            	            {
            	            a42=(Token)match(input,49,FOLLOW_49_in_parse_dk_itu_sdg_language_xwpf_Document1463); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_12_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a42, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[223]);
            	            			}

            	            a43=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1483); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_12_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a43, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[224]);
            	            			}

            	            // Xwpf.g:1589:4: (a44_0= parse_dk_itu_sdg_language_xwpf_Table )
            	            // Xwpf.g:1590:5: a44_0= parse_dk_itu_sdg_language_xwpf_Table
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Table_in_parse_dk_itu_sdg_language_xwpf_Document1509);
            	            a44_0=parse_dk_itu_sdg_language_xwpf_Table();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a44_0 != null) {
            	            						if (a44_0 != null) {
            	            							Object value = a44_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__TABLES, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_12_2, a44_0, true);
            	            						copyLocalizationInfos(a44_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[225]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[226]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[227]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[228]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[229]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[230]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[231]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[232]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[233]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[234]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[235]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[236]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[237]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[238]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[241]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[242]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[243]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[245]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[246]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[247]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[248]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[249]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[250]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[251]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[252]);
            	}

            a45=(Token)match(input,52,FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Document1550); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a45, element);
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
            if ( state.backtracking>0 ) { memoize(input, 3, parse_dk_itu_sdg_language_xwpf_Document_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Document"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_BodyElement"
    // Xwpf.g:1663:1: parse_dk_itu_sdg_language_xwpf_BodyElement returns [dk.itu.sdg.language.xwpf.BodyElement element = null] : a0= 'BodyElement' a1= ';' ;
    public final dk.itu.sdg.language.xwpf.BodyElement parse_dk_itu_sdg_language_xwpf_BodyElement() throws RecognitionException {
        dk.itu.sdg.language.xwpf.BodyElement element =  null;

        int parse_dk_itu_sdg_language_xwpf_BodyElement_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Xwpf.g:1666:2: (a0= 'BodyElement' a1= ';' )
            // Xwpf.g:1667:2: a0= 'BodyElement' a1= ';'
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_dk_itu_sdg_language_xwpf_BodyElement1579); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createBodyElement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[253]);
            	}

            a1=(Token)match(input,12,FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_BodyElement1593); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createBodyElement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[254]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[255]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[256]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[257]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[258]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[259]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[260]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[261]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[262]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[263]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[264]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[265]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[266]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[267]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_dk_itu_sdg_language_xwpf_BodyElement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_BodyElement"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Comment"
    // Xwpf.g:1710:1: parse_dk_itu_sdg_language_xwpf_Comment returns [dk.itu.sdg.language.xwpf.Comment element = null] : a0= 'Comment' a1= '{' ( ( (a2= QUOTED_34_34 ) | (a3= QUOTED_34_34 ) | (a4= QUOTED_34_34 ) ) )* a5= '}' ;
    public final dk.itu.sdg.language.xwpf.Comment parse_dk_itu_sdg_language_xwpf_Comment() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Comment element =  null;

        int parse_dk_itu_sdg_language_xwpf_Comment_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Xwpf.g:1713:2: (a0= 'Comment' a1= '{' ( ( (a2= QUOTED_34_34 ) | (a3= QUOTED_34_34 ) | (a4= QUOTED_34_34 ) ) )* a5= '}' )
            // Xwpf.g:1714:2: a0= 'Comment' a1= '{' ( ( (a2= QUOTED_34_34 ) | (a3= QUOTED_34_34 ) | (a4= QUOTED_34_34 ) ) )* a5= '}'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_dk_itu_sdg_language_xwpf_Comment1622); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createComment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[268]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Comment1636); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createComment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_3_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[269]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[270]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[271]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[272]);
            	}

            // Xwpf.g:1745:2: ( ( (a2= QUOTED_34_34 ) | (a3= QUOTED_34_34 ) | (a4= QUOTED_34_34 ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTED_34_34) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Xwpf.g:1746:3: ( (a2= QUOTED_34_34 ) | (a3= QUOTED_34_34 ) | (a4= QUOTED_34_34 ) )
            	    {
            	    // Xwpf.g:1746:3: ( (a2= QUOTED_34_34 ) | (a3= QUOTED_34_34 ) | (a4= QUOTED_34_34 ) )
            	    int alt7=3;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==QUOTED_34_34) ) {
            	        int LA7_1 = input.LA(2);

            	        if ( (synpred32_Xwpf()) ) {
            	            alt7=1;
            	        }
            	        else if ( (synpred33_Xwpf()) ) {
            	            alt7=2;
            	        }
            	        else if ( (true) ) {
            	            alt7=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 7, 1, input);

            	            throw nvae;

            	        }
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // Xwpf.g:1747:4: (a2= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:1747:4: (a2= QUOTED_34_34 )
            	            // Xwpf.g:1748:5: a2= QUOTED_34_34
            	            {
            	            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Comment1665); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createComment();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a2 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__TEXT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__TEXT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_3_0_0_2_0_0_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[273]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[274]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[275]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[276]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Xwpf.g:1787:8: (a3= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:1787:8: (a3= QUOTED_34_34 )
            	            // Xwpf.g:1788:5: a3= QUOTED_34_34
            	            {
            	            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Comment1712); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createComment();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a3 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__AUTHOR), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__AUTHOR), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_3_0_0_2_0_1_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[277]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[278]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[279]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[280]);
            	            			}

            	            }
            	            break;
            	        case 3 :
            	            // Xwpf.g:1827:8: (a4= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:1827:8: (a4= QUOTED_34_34 )
            	            // Xwpf.g:1828:5: a4= QUOTED_34_34
            	            {
            	            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Comment1759); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createComment();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a4 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__IDENTIFIER), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__IDENTIFIER), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_3_0_0_2_0_2_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[281]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[282]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[283]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[284]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[285]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[286]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[287]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[288]);
            	}

            a5=(Token)match(input,52,FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Comment1805); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createComment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[289]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[290]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[291]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[292]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[293]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[294]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[295]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[296]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[297]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[298]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[299]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[300]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[301]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[302]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_dk_itu_sdg_language_xwpf_Comment_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Comment"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Footnote"
    // Xwpf.g:1905:1: parse_dk_itu_sdg_language_xwpf_Footnote returns [dk.itu.sdg.language.xwpf.Footnote element = null] : a0= 'Footnote' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}' ;
    public final dk.itu.sdg.language.xwpf.Footnote parse_dk_itu_sdg_language_xwpf_Footnote() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Footnote element =  null;

        int parse_dk_itu_sdg_language_xwpf_Footnote_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Xwpf.g:1908:2: (a0= 'Footnote' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}' )
            // Xwpf.g:1909:2: a0= 'Footnote' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}'
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_dk_itu_sdg_language_xwpf_Footnote1834); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFootnote();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_4_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[303]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Footnote1848); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFootnote();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_4_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[304]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[305]);
            	}

            // Xwpf.g:1938:2: ( ( (a2= QUOTED_34_34 ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTED_34_34) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Xwpf.g:1939:3: ( (a2= QUOTED_34_34 ) )
            	    {
            	    // Xwpf.g:1939:3: ( (a2= QUOTED_34_34 ) )
            	    // Xwpf.g:1940:4: (a2= QUOTED_34_34 )
            	    {
            	    // Xwpf.g:1940:4: (a2= QUOTED_34_34 )
            	    // Xwpf.g:1941:5: a2= QUOTED_34_34
            	    {
            	    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Footnote1877); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFootnote();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2 != null) {
            	    						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	    						tokenResolver.setOptions(getOptions());
            	    						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTNOTE__TEXT), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            	    						}
            	    						java.lang.String resolved = (java.lang.String) resolvedObject;
            	    						if (resolved != null) {
            	    							Object value = resolved;
            	    							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTNOTE__TEXT), value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_4_0_0_2_0_0_0, resolved, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[306]);
            	    				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[307]);
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
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[308]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[309]);
            	}

            a3=(Token)match(input,52,FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Footnote1923); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFootnote();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_4_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[310]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[311]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[312]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[313]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[314]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[315]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[316]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[317]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[318]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[319]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[320]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[321]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[322]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[323]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_dk_itu_sdg_language_xwpf_Footnote_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Footnote"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Footer"
    // Xwpf.g:2014:1: parse_dk_itu_sdg_language_xwpf_Footer returns [dk.itu.sdg.language.xwpf.Footer element = null] : a0= 'Footer' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}' ;
    public final dk.itu.sdg.language.xwpf.Footer parse_dk_itu_sdg_language_xwpf_Footer() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Footer element =  null;

        int parse_dk_itu_sdg_language_xwpf_Footer_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Xwpf.g:2017:2: (a0= 'Footer' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}' )
            // Xwpf.g:2018:2: a0= 'Footer' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}'
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_dk_itu_sdg_language_xwpf_Footer1952); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFooter();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_5_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[324]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Footer1966); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFooter();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_5_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[325]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[326]);
            	}

            // Xwpf.g:2047:2: ( ( (a2= QUOTED_34_34 ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTED_34_34) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Xwpf.g:2048:3: ( (a2= QUOTED_34_34 ) )
            	    {
            	    // Xwpf.g:2048:3: ( (a2= QUOTED_34_34 ) )
            	    // Xwpf.g:2049:4: (a2= QUOTED_34_34 )
            	    {
            	    // Xwpf.g:2049:4: (a2= QUOTED_34_34 )
            	    // Xwpf.g:2050:5: a2= QUOTED_34_34
            	    {
            	    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Footer1995); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFooter();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2 != null) {
            	    						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	    						tokenResolver.setOptions(getOptions());
            	    						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTER__TEXT), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            	    						}
            	    						java.lang.String resolved = (java.lang.String) resolvedObject;
            	    						if (resolved != null) {
            	    							Object value = resolved;
            	    							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTER__TEXT), value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_5_0_0_2_0_0_0, resolved, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[327]);
            	    				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[328]);
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
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[329]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[330]);
            	}

            a3=(Token)match(input,52,FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Footer2041); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFooter();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_5_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[331]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[332]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[333]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[334]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[335]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[336]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[337]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[338]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[339]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[340]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[341]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[342]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[343]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[344]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_dk_itu_sdg_language_xwpf_Footer_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Footer"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Header"
    // Xwpf.g:2123:1: parse_dk_itu_sdg_language_xwpf_Header returns [dk.itu.sdg.language.xwpf.Header element = null] : a0= 'Header' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}' ;
    public final dk.itu.sdg.language.xwpf.Header parse_dk_itu_sdg_language_xwpf_Header() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Header element =  null;

        int parse_dk_itu_sdg_language_xwpf_Header_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Xwpf.g:2126:2: (a0= 'Header' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}' )
            // Xwpf.g:2127:2: a0= 'Header' a1= '{' ( ( (a2= QUOTED_34_34 ) ) )* a3= '}'
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_dk_itu_sdg_language_xwpf_Header2070); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHeader();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_6_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[345]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Header2084); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHeader();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_6_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[346]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[347]);
            	}

            // Xwpf.g:2156:2: ( ( (a2= QUOTED_34_34 ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==QUOTED_34_34) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Xwpf.g:2157:3: ( (a2= QUOTED_34_34 ) )
            	    {
            	    // Xwpf.g:2157:3: ( (a2= QUOTED_34_34 ) )
            	    // Xwpf.g:2158:4: (a2= QUOTED_34_34 )
            	    {
            	    // Xwpf.g:2158:4: (a2= QUOTED_34_34 )
            	    // Xwpf.g:2159:5: a2= QUOTED_34_34
            	    {
            	    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Header2113); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHeader();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2 != null) {
            	    						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	    						tokenResolver.setOptions(getOptions());
            	    						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HEADER__TEXT), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            	    						}
            	    						java.lang.String resolved = (java.lang.String) resolvedObject;
            	    						if (resolved != null) {
            	    							Object value = resolved;
            	    							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HEADER__TEXT), value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_6_0_0_2_0_0_0, resolved, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[348]);
            	    				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[349]);
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
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[350]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[351]);
            	}

            a3=(Token)match(input,52,FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Header2159); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHeader();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_6_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[352]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[353]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[354]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[355]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[356]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[357]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[358]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[359]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[360]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[361]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[362]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[363]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[364]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[365]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_dk_itu_sdg_language_xwpf_Header_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Header"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Hyperlink"
    // Xwpf.g:2232:1: parse_dk_itu_sdg_language_xwpf_Hyperlink returns [dk.itu.sdg.language.xwpf.Hyperlink element = null] : a0= 'Hyperlink' ( ( (a1= QUOTED_34_34 ) | (a2= QUOTED_34_34 ) ) )* a3= ';' ;
    public final dk.itu.sdg.language.xwpf.Hyperlink parse_dk_itu_sdg_language_xwpf_Hyperlink() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Hyperlink element =  null;

        int parse_dk_itu_sdg_language_xwpf_Hyperlink_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Xwpf.g:2235:2: (a0= 'Hyperlink' ( ( (a1= QUOTED_34_34 ) | (a2= QUOTED_34_34 ) ) )* a3= ';' )
            // Xwpf.g:2236:2: a0= 'Hyperlink' ( ( (a1= QUOTED_34_34 ) | (a2= QUOTED_34_34 ) ) )* a3= ';'
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_dk_itu_sdg_language_xwpf_Hyperlink2188); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHyperlink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_7_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[366]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[367]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[368]);
            	}

            // Xwpf.g:2252:2: ( ( (a1= QUOTED_34_34 ) | (a2= QUOTED_34_34 ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==QUOTED_34_34) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Xwpf.g:2253:3: ( (a1= QUOTED_34_34 ) | (a2= QUOTED_34_34 ) )
            	    {
            	    // Xwpf.g:2253:3: ( (a1= QUOTED_34_34 ) | (a2= QUOTED_34_34 ) )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==QUOTED_34_34) ) {
            	        int LA12_1 = input.LA(2);

            	        if ( (synpred38_Xwpf()) ) {
            	            alt12=1;
            	        }
            	        else if ( (true) ) {
            	            alt12=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 12, 1, input);

            	            throw nvae;

            	        }
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // Xwpf.g:2254:4: (a1= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:2254:4: (a1= QUOTED_34_34 )
            	            // Xwpf.g:2255:5: a1= QUOTED_34_34
            	            {
            	            a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Hyperlink2217); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHyperlink();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a1 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__IDENTIFIER), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__IDENTIFIER), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_7_0_0_1_0_0_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[369]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[370]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[371]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Xwpf.g:2293:8: (a2= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:2293:8: (a2= QUOTED_34_34 )
            	            // Xwpf.g:2294:5: a2= QUOTED_34_34
            	            {
            	            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Hyperlink2264); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHyperlink();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a2 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__URL), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__URL), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_7_0_0_1_0_1_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[372]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[373]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[374]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[375]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[376]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[377]);
            	}

            a3=(Token)match(input,12,FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Hyperlink2310); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHyperlink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_7_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[378]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[379]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[380]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[381]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[382]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[383]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[384]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[385]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[386]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[387]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[388]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[389]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[390]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[391]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_dk_itu_sdg_language_xwpf_Hyperlink_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Hyperlink"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Numbering"
    // Xwpf.g:2369:1: parse_dk_itu_sdg_language_xwpf_Numbering returns [dk.itu.sdg.language.xwpf.Numbering element = null] : a0= 'Numbering' a1= ';' ;
    public final dk.itu.sdg.language.xwpf.Numbering parse_dk_itu_sdg_language_xwpf_Numbering() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Numbering element =  null;

        int parse_dk_itu_sdg_language_xwpf_Numbering_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Xwpf.g:2372:2: (a0= 'Numbering' a1= ';' )
            // Xwpf.g:2373:2: a0= 'Numbering' a1= ';'
            {
            a0=(Token)match(input,25,FOLLOW_25_in_parse_dk_itu_sdg_language_xwpf_Numbering2339); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createNumbering();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_8_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[392]);
            	}

            a1=(Token)match(input,12,FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Numbering2353); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createNumbering();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_8_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[393]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[394]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[395]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[396]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[397]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[398]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[399]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[400]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[401]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[402]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[403]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[404]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[405]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[406]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_dk_itu_sdg_language_xwpf_Numbering_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Numbering"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_PictureData"
    // Xwpf.g:2416:1: parse_dk_itu_sdg_language_xwpf_PictureData returns [dk.itu.sdg.language.xwpf.PictureData element = null] : a0= 'PictureData' a1= ';' ;
    public final dk.itu.sdg.language.xwpf.PictureData parse_dk_itu_sdg_language_xwpf_PictureData() throws RecognitionException {
        dk.itu.sdg.language.xwpf.PictureData element =  null;

        int parse_dk_itu_sdg_language_xwpf_PictureData_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Xwpf.g:2419:2: (a0= 'PictureData' a1= ';' )
            // Xwpf.g:2420:2: a0= 'PictureData' a1= ';'
            {
            a0=(Token)match(input,28,FOLLOW_28_in_parse_dk_itu_sdg_language_xwpf_PictureData2382); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createPictureData();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_9_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[407]);
            	}

            a1=(Token)match(input,12,FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_PictureData2396); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createPictureData();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_9_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[408]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[409]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[410]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[411]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[412]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[413]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[414]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[415]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[416]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[417]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[418]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[419]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[420]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[421]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_dk_itu_sdg_language_xwpf_PictureData_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_PictureData"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Paragraph"
    // Xwpf.g:2463:1: parse_dk_itu_sdg_language_xwpf_Paragraph returns [dk.itu.sdg.language.xwpf.Paragraph element = null] : a0= 'Paragraph' a1= '{' ( ( (a2= QUOTED_34_34 ) |a3= 'runs' a4= ':' (a5_0= parse_dk_itu_sdg_language_xwpf_Run ) |a6= 'part' a7= ':' (a8_0= parse_dk_itu_sdg_language_xwpf_Part ) |a9= 'body' a10= ':' (a11_0= parse_dk_itu_sdg_language_xwpf_Body ) | (a12= TEXT ) | (a13= TEXT ) | (a14= TEXT ) | (a15= TEXT ) | (a16= TEXT ) | (a17= TEXT ) | (a18= TEXT ) | (a19= QUOTED_34_34 ) | (a20= TEXT ) | (a21= TEXT ) | (a22= TEXT ) | (a23= TEXT ) | (a24= TEXT ) | (a25= TEXT ) | (a26= TEXT ) | (a27= TEXT ) | (a28= TEXT ) | ( (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' ) ) ) )* a36= '}' ;
    public final dk.itu.sdg.language.xwpf.Paragraph parse_dk_itu_sdg_language_xwpf_Paragraph() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Paragraph element =  null;

        int parse_dk_itu_sdg_language_xwpf_Paragraph_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a9=null;
        Token a10=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;
        Token a19=null;
        Token a20=null;
        Token a21=null;
        Token a22=null;
        Token a23=null;
        Token a24=null;
        Token a25=null;
        Token a26=null;
        Token a27=null;
        Token a28=null;
        Token a29=null;
        Token a30=null;
        Token a31=null;
        Token a32=null;
        Token a33=null;
        Token a36=null;
        dk.itu.sdg.language.xwpf.Run a5_0 =null;

        dk.itu.sdg.language.xwpf.Part a8_0 =null;

        dk.itu.sdg.language.xwpf.Body a11_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Xwpf.g:2466:2: (a0= 'Paragraph' a1= '{' ( ( (a2= QUOTED_34_34 ) |a3= 'runs' a4= ':' (a5_0= parse_dk_itu_sdg_language_xwpf_Run ) |a6= 'part' a7= ':' (a8_0= parse_dk_itu_sdg_language_xwpf_Part ) |a9= 'body' a10= ':' (a11_0= parse_dk_itu_sdg_language_xwpf_Body ) | (a12= TEXT ) | (a13= TEXT ) | (a14= TEXT ) | (a15= TEXT ) | (a16= TEXT ) | (a17= TEXT ) | (a18= TEXT ) | (a19= QUOTED_34_34 ) | (a20= TEXT ) | (a21= TEXT ) | (a22= TEXT ) | (a23= TEXT ) | (a24= TEXT ) | (a25= TEXT ) | (a26= TEXT ) | (a27= TEXT ) | (a28= TEXT ) | ( (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' ) ) ) )* a36= '}' )
            // Xwpf.g:2467:2: a0= 'Paragraph' a1= '{' ( ( (a2= QUOTED_34_34 ) |a3= 'runs' a4= ':' (a5_0= parse_dk_itu_sdg_language_xwpf_Run ) |a6= 'part' a7= ':' (a8_0= parse_dk_itu_sdg_language_xwpf_Part ) |a9= 'body' a10= ':' (a11_0= parse_dk_itu_sdg_language_xwpf_Body ) | (a12= TEXT ) | (a13= TEXT ) | (a14= TEXT ) | (a15= TEXT ) | (a16= TEXT ) | (a17= TEXT ) | (a18= TEXT ) | (a19= QUOTED_34_34 ) | (a20= TEXT ) | (a21= TEXT ) | (a22= TEXT ) | (a23= TEXT ) | (a24= TEXT ) | (a25= TEXT ) | (a26= TEXT ) | (a27= TEXT ) | (a28= TEXT ) | ( (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' ) ) ) )* a36= '}'
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_dk_itu_sdg_language_xwpf_Paragraph2425); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[422]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Paragraph2439); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[423]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[424]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[425]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[426]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[427]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[428]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[429]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[430]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[431]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[432]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[433]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[434]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[435]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[436]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[437]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[438]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[439]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[440]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[441]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[442]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[443]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[444]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[445]);
            	}

            // Xwpf.g:2517:2: ( ( (a2= QUOTED_34_34 ) |a3= 'runs' a4= ':' (a5_0= parse_dk_itu_sdg_language_xwpf_Run ) |a6= 'part' a7= ':' (a8_0= parse_dk_itu_sdg_language_xwpf_Part ) |a9= 'body' a10= ':' (a11_0= parse_dk_itu_sdg_language_xwpf_Body ) | (a12= TEXT ) | (a13= TEXT ) | (a14= TEXT ) | (a15= TEXT ) | (a16= TEXT ) | (a17= TEXT ) | (a18= TEXT ) | (a19= QUOTED_34_34 ) | (a20= TEXT ) | (a21= TEXT ) | (a22= TEXT ) | (a23= TEXT ) | (a24= TEXT ) | (a25= TEXT ) | (a26= TEXT ) | (a27= TEXT ) | (a28= TEXT ) | ( (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' ) ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= QUOTED_34_34 && LA16_0 <= TEXT)||(LA16_0 >= 21 && LA16_0 <= 22)||LA16_0==24||LA16_0==31||LA16_0==42||LA16_0==46||LA16_0==48||LA16_0==50) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // Xwpf.g:2518:3: ( (a2= QUOTED_34_34 ) |a3= 'runs' a4= ':' (a5_0= parse_dk_itu_sdg_language_xwpf_Run ) |a6= 'part' a7= ':' (a8_0= parse_dk_itu_sdg_language_xwpf_Part ) |a9= 'body' a10= ':' (a11_0= parse_dk_itu_sdg_language_xwpf_Body ) | (a12= TEXT ) | (a13= TEXT ) | (a14= TEXT ) | (a15= TEXT ) | (a16= TEXT ) | (a17= TEXT ) | (a18= TEXT ) | (a19= QUOTED_34_34 ) | (a20= TEXT ) | (a21= TEXT ) | (a22= TEXT ) | (a23= TEXT ) | (a24= TEXT ) | (a25= TEXT ) | (a26= TEXT ) | (a27= TEXT ) | (a28= TEXT ) | ( (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' ) ) )
            	    {
            	    // Xwpf.g:2518:3: ( (a2= QUOTED_34_34 ) |a3= 'runs' a4= ':' (a5_0= parse_dk_itu_sdg_language_xwpf_Run ) |a6= 'part' a7= ':' (a8_0= parse_dk_itu_sdg_language_xwpf_Part ) |a9= 'body' a10= ':' (a11_0= parse_dk_itu_sdg_language_xwpf_Body ) | (a12= TEXT ) | (a13= TEXT ) | (a14= TEXT ) | (a15= TEXT ) | (a16= TEXT ) | (a17= TEXT ) | (a18= TEXT ) | (a19= QUOTED_34_34 ) | (a20= TEXT ) | (a21= TEXT ) | (a22= TEXT ) | (a23= TEXT ) | (a24= TEXT ) | (a25= TEXT ) | (a26= TEXT ) | (a27= TEXT ) | (a28= TEXT ) | ( (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' ) ) )
            	    int alt15=22;
            	    switch ( input.LA(1) ) {
            	    case QUOTED_34_34:
            	        {
            	        int LA15_1 = input.LA(2);

            	        if ( (synpred40_Xwpf()) ) {
            	            alt15=1;
            	        }
            	        else if ( (synpred51_Xwpf()) ) {
            	            alt15=12;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 15, 1, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 48:
            	        {
            	        alt15=2;
            	        }
            	        break;
            	    case 46:
            	        {
            	        alt15=3;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt15=4;
            	        }
            	        break;
            	    case TEXT:
            	        {
            	        int LA15_5 = input.LA(2);

            	        if ( (synpred44_Xwpf()) ) {
            	            alt15=5;
            	        }
            	        else if ( (synpred45_Xwpf()) ) {
            	            alt15=6;
            	        }
            	        else if ( (synpred46_Xwpf()) ) {
            	            alt15=7;
            	        }
            	        else if ( (synpred47_Xwpf()) ) {
            	            alt15=8;
            	        }
            	        else if ( (synpred48_Xwpf()) ) {
            	            alt15=9;
            	        }
            	        else if ( (synpred49_Xwpf()) ) {
            	            alt15=10;
            	        }
            	        else if ( (synpred50_Xwpf()) ) {
            	            alt15=11;
            	        }
            	        else if ( (synpred52_Xwpf()) ) {
            	            alt15=13;
            	        }
            	        else if ( (synpred53_Xwpf()) ) {
            	            alt15=14;
            	        }
            	        else if ( (synpred54_Xwpf()) ) {
            	            alt15=15;
            	        }
            	        else if ( (synpred55_Xwpf()) ) {
            	            alt15=16;
            	        }
            	        else if ( (synpred56_Xwpf()) ) {
            	            alt15=17;
            	        }
            	        else if ( (synpred57_Xwpf()) ) {
            	            alt15=18;
            	        }
            	        else if ( (synpred58_Xwpf()) ) {
            	            alt15=19;
            	        }
            	        else if ( (synpred59_Xwpf()) ) {
            	            alt15=20;
            	        }
            	        else if ( (synpred60_Xwpf()) ) {
            	            alt15=21;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 15, 5, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 21:
            	    case 22:
            	    case 24:
            	    case 42:
            	    case 50:
            	        {
            	        alt15=22;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt15) {
            	        case 1 :
            	            // Xwpf.g:2519:4: (a2= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:2519:4: (a2= QUOTED_34_34 )
            	            // Xwpf.g:2520:5: a2= QUOTED_34_34
            	            {
            	            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Paragraph2468); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a2 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__TEXT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__TEXT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_0_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[446]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[447]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[448]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[449]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[450]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[451]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[452]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[453]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[454]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[455]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[456]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[457]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[458]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[459]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[460]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[461]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[462]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[463]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[464]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[465]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[466]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[467]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[468]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Xwpf.g:2578:8: a3= 'runs' a4= ':' (a5_0= parse_dk_itu_sdg_language_xwpf_Run )
            	            {
            	            a3=(Token)match(input,48,FOLLOW_48_in_parse_dk_itu_sdg_language_xwpf_Paragraph2509); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_1_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[469]);
            	            			}

            	            a4=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Paragraph2529); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_1_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[470]);
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[471]);
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[472]);
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[473]);
            	            			}

            	            // Xwpf.g:2609:4: (a5_0= parse_dk_itu_sdg_language_xwpf_Run )
            	            // Xwpf.g:2610:5: a5_0= parse_dk_itu_sdg_language_xwpf_Run
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Run_in_parse_dk_itu_sdg_language_xwpf_Paragraph2555);
            	            a5_0=parse_dk_itu_sdg_language_xwpf_Run();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a5_0 != null) {
            	            						if (a5_0 != null) {
            	            							Object value = a5_0;
            	            							addObjectToList(element, dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__RUNS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_1_2, a5_0, true);
            	            						copyLocalizationInfos(a5_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[474]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[475]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[476]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[477]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[478]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[479]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[480]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[481]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[482]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[483]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[484]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[485]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[486]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[487]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[488]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[489]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[490]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[491]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[492]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[493]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[494]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[495]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[496]);
            	            			}

            	            }
            	            break;
            	        case 3 :
            	            // Xwpf.g:2658:8: a6= 'part' a7= ':' (a8_0= parse_dk_itu_sdg_language_xwpf_Part )
            	            {
            	            a6=(Token)match(input,46,FOLLOW_46_in_parse_dk_itu_sdg_language_xwpf_Paragraph2591); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_2_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[497]);
            	            			}

            	            a7=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Paragraph2611); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_2_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[498]);
            	            			}

            	            // Xwpf.g:2686:4: (a8_0= parse_dk_itu_sdg_language_xwpf_Part )
            	            // Xwpf.g:2687:5: a8_0= parse_dk_itu_sdg_language_xwpf_Part
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Part_in_parse_dk_itu_sdg_language_xwpf_Paragraph2637);
            	            a8_0=parse_dk_itu_sdg_language_xwpf_Part();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a8_0 != null) {
            	            						if (a8_0 != null) {
            	            							Object value = a8_0;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__PART), value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_2_2, a8_0, true);
            	            						copyLocalizationInfos(a8_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[499]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[500]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[501]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[502]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[503]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[504]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[505]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[506]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[507]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[508]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[509]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[510]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[511]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[512]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[513]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[514]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[515]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[516]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[517]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[518]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[519]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[520]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[521]);
            	            			}

            	            }
            	            break;
            	        case 4 :
            	            // Xwpf.g:2735:8: a9= 'body' a10= ':' (a11_0= parse_dk_itu_sdg_language_xwpf_Body )
            	            {
            	            a9=(Token)match(input,31,FOLLOW_31_in_parse_dk_itu_sdg_language_xwpf_Paragraph2673); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_3_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[522]);
            	            			}

            	            a10=(Token)match(input,11,FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Paragraph2693); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_3_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[523]);
            	            			}

            	            // Xwpf.g:2763:4: (a11_0= parse_dk_itu_sdg_language_xwpf_Body )
            	            // Xwpf.g:2764:5: a11_0= parse_dk_itu_sdg_language_xwpf_Body
            	            {
            	            pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Body_in_parse_dk_itu_sdg_language_xwpf_Paragraph2719);
            	            a11_0=parse_dk_itu_sdg_language_xwpf_Body();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a11_0 != null) {
            	            						if (a11_0 != null) {
            	            							Object value = a11_0;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BODY), value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_3_2, a11_0, true);
            	            						copyLocalizationInfos(a11_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[524]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[525]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[526]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[527]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[528]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[529]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[530]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[531]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[532]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[533]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[534]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[535]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[536]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[537]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[538]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[539]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[540]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[541]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[542]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[543]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[544]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[545]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[546]);
            	            			}

            	            }
            	            break;
            	        case 5 :
            	            // Xwpf.g:2812:8: (a12= TEXT )
            	            {
            	            // Xwpf.g:2812:8: (a12= TEXT )
            	            // Xwpf.g:2813:5: a12= TEXT
            	            {
            	            a12=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2761); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a12 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__ALIGNMENT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__ALIGNMENT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_4_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[547]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[548]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[549]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[550]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[551]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[552]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[553]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[554]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[555]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[556]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[557]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[558]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[559]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[560]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[561]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[562]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[563]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[564]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[565]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[566]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[567]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[568]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[569]);
            	            			}

            	            }
            	            break;
            	        case 6 :
            	            // Xwpf.g:2871:8: (a13= TEXT )
            	            {
            	            // Xwpf.g:2871:8: (a13= TEXT )
            	            // Xwpf.g:2872:5: a13= TEXT
            	            {
            	            a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2808); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a13 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BOTTOM), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BOTTOM), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_5_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[570]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[571]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[572]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[573]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[574]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[575]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[576]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[577]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[578]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[579]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[580]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[581]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[582]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[583]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[584]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[585]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[586]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[587]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[588]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[589]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[590]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[591]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[592]);
            	            			}

            	            }
            	            break;
            	        case 7 :
            	            // Xwpf.g:2930:8: (a14= TEXT )
            	            {
            	            // Xwpf.g:2930:8: (a14= TEXT )
            	            // Xwpf.g:2931:5: a14= TEXT
            	            {
            	            a14=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2855); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a14 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_TOP), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_TOP), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_6_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[593]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[594]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[595]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[596]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[597]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[598]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[599]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[600]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[601]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[602]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[603]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[604]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[605]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[606]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[607]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[608]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[609]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[610]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[611]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[612]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[613]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[614]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[615]);
            	            			}

            	            }
            	            break;
            	        case 8 :
            	            // Xwpf.g:2989:8: (a15= TEXT )
            	            {
            	            // Xwpf.g:2989:8: (a15= TEXT )
            	            // Xwpf.g:2990:5: a15= TEXT
            	            {
            	            a15=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2902); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a15 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BETWEEN), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a15).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BETWEEN), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_7_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a15, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[616]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[617]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[618]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[619]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[620]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[621]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[622]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[623]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[624]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[625]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[626]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[627]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[628]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[629]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[630]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[631]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[632]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[633]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[634]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[635]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[636]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[637]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[638]);
            	            			}

            	            }
            	            break;
            	        case 9 :
            	            // Xwpf.g:3048:8: (a16= TEXT )
            	            {
            	            // Xwpf.g:3048:8: (a16= TEXT )
            	            // Xwpf.g:3049:5: a16= TEXT
            	            {
            	            a16=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2949); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a16 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_LEFT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a16).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_LEFT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_8_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[639]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[640]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[641]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[642]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[643]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[644]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[645]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[646]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[647]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[648]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[649]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[650]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[651]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[652]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[653]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[654]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[655]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[656]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[657]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[658]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[659]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[660]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[661]);
            	            			}

            	            }
            	            break;
            	        case 10 :
            	            // Xwpf.g:3107:8: (a17= TEXT )
            	            {
            	            // Xwpf.g:3107:8: (a17= TEXT )
            	            // Xwpf.g:3108:5: a17= TEXT
            	            {
            	            a17=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2996); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a17 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a17.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_RIGHT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a17).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a17).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a17).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a17).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_RIGHT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_9_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a17, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[662]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[663]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[664]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[665]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[666]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[667]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[668]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[669]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[670]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[671]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[672]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[673]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[674]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[675]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[676]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[677]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[678]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[679]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[680]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[681]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[682]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[683]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[684]);
            	            			}

            	            }
            	            break;
            	        case 11 :
            	            // Xwpf.g:3166:8: (a18= TEXT )
            	            {
            	            // Xwpf.g:3166:8: (a18= TEXT )
            	            // Xwpf.g:3167:5: a18= TEXT
            	            {
            	            a18=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3043); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a18 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a18.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a18).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a18).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a18).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a18).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_10_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a18, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[685]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[686]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[687]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[688]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[689]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[690]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[691]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[692]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[693]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[694]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[695]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[696]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[697]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[698]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[699]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[700]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[701]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[702]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[703]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[704]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[705]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[706]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[707]);
            	            			}

            	            }
            	            break;
            	        case 12 :
            	            // Xwpf.g:3225:8: (a19= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:3225:8: (a19= QUOTED_34_34 )
            	            // Xwpf.g:3226:5: a19= QUOTED_34_34
            	            {
            	            a19=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Paragraph3090); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a19 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a19.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a19).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a19).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a19).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a19).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_11_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a19, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[708]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[709]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[710]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[711]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[712]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[713]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[714]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[715]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[716]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[717]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[718]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[719]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[720]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[721]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[722]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[723]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[724]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[725]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[726]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[727]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[728]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[729]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[730]);
            	            			}

            	            }
            	            break;
            	        case 13 :
            	            // Xwpf.g:3284:8: (a20= TEXT )
            	            {
            	            // Xwpf.g:3284:8: (a20= TEXT )
            	            // Xwpf.g:3285:5: a20= TEXT
            	            {
            	            a20=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3137); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a20 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a20.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_FST_LINE), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a20).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a20).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a20).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a20).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_FST_LINE), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_12_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a20, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[731]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[732]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[733]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[734]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[735]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[736]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[737]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[738]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[739]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[740]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[741]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[742]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[743]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[744]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[745]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[746]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[747]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[748]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[749]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[750]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[751]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[752]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[753]);
            	            			}

            	            }
            	            break;
            	        case 14 :
            	            // Xwpf.g:3343:8: (a21= TEXT )
            	            {
            	            // Xwpf.g:3343:8: (a21= TEXT )
            	            // Xwpf.g:3344:5: a21= TEXT
            	            {
            	            a21=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3184); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a21 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a21.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_HANGING), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a21).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a21).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a21).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a21).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_HANGING), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_13_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a21, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[754]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[755]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[756]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[757]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[758]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[759]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[760]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[761]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[762]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[763]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[764]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[765]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[766]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[767]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[768]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[769]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[770]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[771]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[772]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[773]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[774]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[775]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[776]);
            	            			}

            	            }
            	            break;
            	        case 15 :
            	            // Xwpf.g:3402:8: (a22= TEXT )
            	            {
            	            // Xwpf.g:3402:8: (a22= TEXT )
            	            // Xwpf.g:3403:5: a22= TEXT
            	            {
            	            a22=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3231); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a22 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a22.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_LEFT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a22).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a22).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a22).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a22).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_LEFT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_14_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a22, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[777]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[778]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[779]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[780]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[781]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[782]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[783]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[784]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[785]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[786]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[787]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[788]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[789]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[790]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[791]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[792]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[793]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[794]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[795]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[796]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[797]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[798]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[799]);
            	            			}

            	            }
            	            break;
            	        case 16 :
            	            // Xwpf.g:3461:8: (a23= TEXT )
            	            {
            	            // Xwpf.g:3461:8: (a23= TEXT )
            	            // Xwpf.g:3462:5: a23= TEXT
            	            {
            	            a23=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3278); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a23 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a23.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_RIGHT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a23).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a23).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a23).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a23).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_RIGHT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_15_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a23, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[800]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[801]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[802]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[803]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[804]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[805]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[806]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[807]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[808]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[809]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[810]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[811]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[812]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[813]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[814]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[815]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[816]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[817]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[818]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[819]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[820]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[821]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[822]);
            	            			}

            	            }
            	            break;
            	        case 17 :
            	            // Xwpf.g:3520:8: (a24= TEXT )
            	            {
            	            // Xwpf.g:3520:8: (a24= TEXT )
            	            // Xwpf.g:3521:5: a24= TEXT
            	            {
            	            a24=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3325); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a24 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a24.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a24).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a24).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a24).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a24).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_16_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a24, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[823]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[824]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[825]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[826]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[827]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[828]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[829]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[830]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[831]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[832]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[833]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[834]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[835]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[836]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[837]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[838]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[839]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[840]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[841]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[842]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[843]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[844]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[845]);
            	            			}

            	            }
            	            break;
            	        case 18 :
            	            // Xwpf.g:3579:8: (a25= TEXT )
            	            {
            	            // Xwpf.g:3579:8: (a25= TEXT )
            	            // Xwpf.g:3580:5: a25= TEXT
            	            {
            	            a25=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3372); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a25 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a25.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a25).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a25).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a25).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a25).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_17_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a25, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[846]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[847]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[848]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[849]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[850]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[851]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[852]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[853]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[854]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[855]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[856]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[857]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[858]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[859]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[860]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[861]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[862]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[863]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[864]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[865]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[866]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[867]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[868]);
            	            			}

            	            }
            	            break;
            	        case 19 :
            	            // Xwpf.g:3638:8: (a26= TEXT )
            	            {
            	            // Xwpf.g:3638:8: (a26= TEXT )
            	            // Xwpf.g:3639:5: a26= TEXT
            	            {
            	            a26=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3419); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a26 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a26.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a26).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a26).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a26).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a26).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_18_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a26, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[869]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[870]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[871]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[872]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[873]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[874]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[875]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[876]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[877]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[878]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[879]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[880]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[881]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[882]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[883]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[884]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[885]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[886]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[887]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[888]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[889]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[890]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[891]);
            	            			}

            	            }
            	            break;
            	        case 20 :
            	            // Xwpf.g:3697:8: (a27= TEXT )
            	            {
            	            // Xwpf.g:3697:8: (a27= TEXT )
            	            // Xwpf.g:3698:5: a27= TEXT
            	            {
            	            a27=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3466); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a27 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a27.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a27).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a27).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a27).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a27).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_19_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a27, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[892]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[893]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[894]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[895]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[896]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[897]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[898]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[899]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[900]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[901]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[902]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[903]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[904]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[905]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[906]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[907]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[908]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[909]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[910]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[911]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[912]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[913]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[914]);
            	            			}

            	            }
            	            break;
            	        case 21 :
            	            // Xwpf.g:3756:8: (a28= TEXT )
            	            {
            	            // Xwpf.g:3756:8: (a28= TEXT )
            	            // Xwpf.g:3757:5: a28= TEXT
            	            {
            	            a28=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3513); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a28 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a28.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_LINE_RULE), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a28).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a28).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a28).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a28).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_LINE_RULE), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_20_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a28, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[915]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[916]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[917]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[918]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[919]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[920]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[921]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[922]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[923]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[924]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[925]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[926]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[927]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[928]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[929]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[930]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[931]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[932]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[933]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[934]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[935]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[936]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[937]);
            	            			}

            	            }
            	            break;
            	        case 22 :
            	            // Xwpf.g:3815:8: ( (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' ) )
            	            {
            	            // Xwpf.g:3815:8: ( (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' ) )
            	            // Xwpf.g:3816:5: (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' )
            	            {
            	            // Xwpf.g:3816:5: (a29= 'unrecognized' |a30= 'Heading1' |a31= 'Heading2' |a32= 'ListParagraph' |a33= 'null' )
            	            int alt14=5;
            	            switch ( input.LA(1) ) {
            	            case 50:
            	                {
            	                alt14=1;
            	                }
            	                break;
            	            case 21:
            	                {
            	                alt14=2;
            	                }
            	                break;
            	            case 22:
            	                {
            	                alt14=3;
            	                }
            	                break;
            	            case 24:
            	                {
            	                alt14=4;
            	                }
            	                break;
            	            case 42:
            	                {
            	                alt14=5;
            	                }
            	                break;
            	            default:
            	                if (state.backtracking>0) {state.failed=true; return element;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 14, 0, input);

            	                throw nvae;

            	            }

            	            switch (alt14) {
            	                case 1 :
            	                    // Xwpf.g:3817:6: a29= 'unrecognized'
            	                    {
            	                    a29=(Token)match(input,50,FOLLOW_50_in_parse_dk_itu_sdg_language_xwpf_Paragraph3567); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_21_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a29, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.UNRECOGNIZED_VALUE).getInstance();
            	                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__STYLE), value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 2 :
            	                    // Xwpf.g:3830:12: a30= 'Heading1'
            	                    {
            	                    a30=(Token)match(input,21,FOLLOW_21_in_parse_dk_itu_sdg_language_xwpf_Paragraph3586); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_21_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a30, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.HEADING1_VALUE).getInstance();
            	                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__STYLE), value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 3 :
            	                    // Xwpf.g:3843:12: a31= 'Heading2'
            	                    {
            	                    a31=(Token)match(input,22,FOLLOW_22_in_parse_dk_itu_sdg_language_xwpf_Paragraph3605); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_21_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a31, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.HEADING2_VALUE).getInstance();
            	                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__STYLE), value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 4 :
            	                    // Xwpf.g:3856:12: a32= 'ListParagraph'
            	                    {
            	                    a32=(Token)match(input,24,FOLLOW_24_in_parse_dk_itu_sdg_language_xwpf_Paragraph3624); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_21_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a32, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.LIST_PARAGRAPH_VALUE).getInstance();
            	                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__STYLE), value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 5 :
            	                    // Xwpf.g:3869:12: a33= 'null'
            	                    {
            	                    a33=(Token)match(input,42,FOLLOW_42_in_parse_dk_itu_sdg_language_xwpf_Paragraph3643); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_21_0, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a33, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getStyle().getEEnumLiteral(dk.itu.sdg.language.xwpf.Style.NORMAL_VALUE).getInstance();
            	                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__STYLE), value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;

            	            }


            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[938]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[939]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[940]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[941]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[942]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[943]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[944]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[945]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[946]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[947]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[948]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[949]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[950]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[951]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[952]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[953]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[954]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[955]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[956]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[957]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[958]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[959]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[960]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[961]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[962]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[963]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[964]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[965]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[966]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[967]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[968]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[969]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[970]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[971]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[972]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[973]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[974]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[975]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[976]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[977]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[978]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[979]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[980]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[981]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[982]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[983]);
            	}

            a36=(Token)match(input,52,FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Paragraph3687); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a36, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[984]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[985]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[986]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[987]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[988]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[989]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[990]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[991]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[992]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[993]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[994]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[995]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[996]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[997]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_dk_itu_sdg_language_xwpf_Paragraph_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Paragraph"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Table"
    // Xwpf.g:3969:1: parse_dk_itu_sdg_language_xwpf_Table returns [dk.itu.sdg.language.xwpf.Table element = null] : a0= 'Table' a1= ';' ;
    public final dk.itu.sdg.language.xwpf.Table parse_dk_itu_sdg_language_xwpf_Table() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Table element =  null;

        int parse_dk_itu_sdg_language_xwpf_Table_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Xwpf.g:3972:2: (a0= 'Table' a1= ';' )
            // Xwpf.g:3973:2: a0= 'Table' a1= ';'
            {
            a0=(Token)match(input,30,FOLLOW_30_in_parse_dk_itu_sdg_language_xwpf_Table3716); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createTable();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_11_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[998]);
            	}

            a1=(Token)match(input,12,FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Table3730); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createTable();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_11_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[999]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1000]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1001]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1002]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1003]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1004]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1005]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1006]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1007]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1008]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1009]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1010]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1011]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1012]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_dk_itu_sdg_language_xwpf_Table_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Table"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Run"
    // Xwpf.g:4016:1: parse_dk_itu_sdg_language_xwpf_Run returns [dk.itu.sdg.language.xwpf.Run element = null] : ( (a0= 'isBold' )? ) ( (a3= 'isItalic' )? ) ( (a6= 'isStrike' )? ) a9= 'Run' a10= '{' ( ( (a11= QUOTED_34_34 ) | (a12= QUOTED_34_34 ) | (a13= TEXT ) | (a14= QUOTED_34_34 ) | (a15= TEXT ) ) )* a16= '}' ;
    public final dk.itu.sdg.language.xwpf.Run parse_dk_itu_sdg_language_xwpf_Run() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Run element =  null;

        int parse_dk_itu_sdg_language_xwpf_Run_StartIndex = input.index();

        Token a0=null;
        Token a3=null;
        Token a6=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Xwpf.g:4019:2: ( ( (a0= 'isBold' )? ) ( (a3= 'isItalic' )? ) ( (a6= 'isStrike' )? ) a9= 'Run' a10= '{' ( ( (a11= QUOTED_34_34 ) | (a12= QUOTED_34_34 ) | (a13= TEXT ) | (a14= QUOTED_34_34 ) | (a15= TEXT ) ) )* a16= '}' )
            // Xwpf.g:4020:2: ( (a0= 'isBold' )? ) ( (a3= 'isItalic' )? ) ( (a6= 'isStrike' )? ) a9= 'Run' a10= '{' ( ( (a11= QUOTED_34_34 ) | (a12= QUOTED_34_34 ) | (a13= TEXT ) | (a14= QUOTED_34_34 ) | (a15= TEXT ) ) )* a16= '}'
            {
            // Xwpf.g:4020:2: ( (a0= 'isBold' )? )
            // Xwpf.g:4021:3: (a0= 'isBold' )?
            {
            // Xwpf.g:4021:3: (a0= 'isBold' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Xwpf.g:4022:4: a0= 'isBold'
                    {
                    a0=(Token)match(input,39,FOLLOW_39_in_parse_dk_itu_sdg_language_xwpf_Run3768); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_0, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1013]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1014]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1015]);
            	}

            // Xwpf.g:4058:2: ( (a3= 'isItalic' )? )
            // Xwpf.g:4059:3: (a3= 'isItalic' )?
            {
            // Xwpf.g:4059:3: (a3= 'isItalic' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==40) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Xwpf.g:4060:4: a3= 'isItalic'
                    {
                    a3=(Token)match(input,40,FOLLOW_40_in_parse_dk_itu_sdg_language_xwpf_Run3798); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_1, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1016]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1017]);
            	}

            // Xwpf.g:4095:2: ( (a6= 'isStrike' )? )
            // Xwpf.g:4096:3: (a6= 'isStrike' )?
            {
            // Xwpf.g:4096:3: (a6= 'isStrike' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==41) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Xwpf.g:4097:4: a6= 'isStrike'
                    {
                    a6=(Token)match(input,41,FOLLOW_41_in_parse_dk_itu_sdg_language_xwpf_Run3828); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_2, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1018]);
            	}

            a9=(Token)match(input,29,FOLLOW_29_in_parse_dk_itu_sdg_language_xwpf_Run3849); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1019]);
            	}

            a10=(Token)match(input,51,FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Run3863); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1020]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1021]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1022]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1023]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1024]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1025]);
            	}

            // Xwpf.g:4194:2: ( ( (a11= QUOTED_34_34 ) | (a12= QUOTED_34_34 ) | (a13= TEXT ) | (a14= QUOTED_34_34 ) | (a15= TEXT ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0 >= QUOTED_34_34 && LA21_0 <= TEXT)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Xwpf.g:4195:3: ( (a11= QUOTED_34_34 ) | (a12= QUOTED_34_34 ) | (a13= TEXT ) | (a14= QUOTED_34_34 ) | (a15= TEXT ) )
            	    {
            	    // Xwpf.g:4195:3: ( (a11= QUOTED_34_34 ) | (a12= QUOTED_34_34 ) | (a13= TEXT ) | (a14= QUOTED_34_34 ) | (a15= TEXT ) )
            	    int alt20=5;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==QUOTED_34_34) ) {
            	        int LA20_1 = input.LA(2);

            	        if ( (synpred69_Xwpf()) ) {
            	            alt20=1;
            	        }
            	        else if ( (synpred70_Xwpf()) ) {
            	            alt20=2;
            	        }
            	        else if ( (synpred72_Xwpf()) ) {
            	            alt20=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 20, 1, input);

            	            throw nvae;

            	        }
            	    }
            	    else if ( (LA20_0==TEXT) ) {
            	        int LA20_2 = input.LA(2);

            	        if ( (synpred71_Xwpf()) ) {
            	            alt20=3;
            	        }
            	        else if ( (true) ) {
            	            alt20=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 20, 2, input);

            	            throw nvae;

            	        }
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // Xwpf.g:4196:4: (a11= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:4196:4: (a11= QUOTED_34_34 )
            	            // Xwpf.g:4197:5: a11= QUOTED_34_34
            	            {
            	            a11=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Run3892); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
            	            						startIncompleteElement(element);
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
            	            						}
            	            					}
            	            					if (a11 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_5_0_0_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1026]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1027]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1028]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1029]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1030]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1031]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Xwpf.g:4253:8: (a12= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:4253:8: (a12= QUOTED_34_34 )
            	            // Xwpf.g:4254:5: a12= QUOTED_34_34
            	            {
            	            a12=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Run3939); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
            	            						startIncompleteElement(element);
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
            	            						}
            	            					}
            	            					if (a12 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_FAMILY), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_FAMILY), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_5_0_1_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1032]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1033]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1034]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1035]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1036]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1037]);
            	            			}

            	            }
            	            break;
            	        case 3 :
            	            // Xwpf.g:4310:8: (a13= TEXT )
            	            {
            	            // Xwpf.g:4310:8: (a13= TEXT )
            	            // Xwpf.g:4311:5: a13= TEXT
            	            {
            	            a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Run3986); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
            	            						startIncompleteElement(element);
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
            	            						}
            	            					}
            	            					if (a13 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_SIZE), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_SIZE), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_5_0_2_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1038]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1039]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1040]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1041]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1042]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1043]);
            	            			}

            	            }
            	            break;
            	        case 4 :
            	            // Xwpf.g:4367:8: (a14= QUOTED_34_34 )
            	            {
            	            // Xwpf.g:4367:8: (a14= QUOTED_34_34 )
            	            // Xwpf.g:4368:5: a14= QUOTED_34_34
            	            {
            	            a14=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Run4033); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
            	            						startIncompleteElement(element);
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
            	            						}
            	            					}
            	            					if (a14 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__COLOR), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__COLOR), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_5_0_3_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1044]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1045]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1046]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1047]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1048]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1049]);
            	            			}

            	            }
            	            break;
            	        case 5 :
            	            // Xwpf.g:4424:8: (a15= TEXT )
            	            {
            	            // Xwpf.g:4424:8: (a15= TEXT )
            	            // Xwpf.g:4425:5: a15= TEXT
            	            {
            	            a15=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Run4080); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
            	            						startIncompleteElement(element);
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
            	            						}
            	            						// initialize boolean attribute
            	            						{
            	            							Object value = false;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
            	            						}
            	            					}
            	            					if (a15 != null) {
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT_POSITION), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a15).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStopIndex());
            	            						}
            	            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT_POSITION), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_5_0_4_0, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a15, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1050]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1051]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1052]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1053]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1054]);
            	            				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1055]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1056]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1057]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1058]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1059]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1060]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1061]);
            	}

            a16=(Token)match(input,52,FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Run4126); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createRun();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_12_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1062]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1063]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1064]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1065]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1066]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1067]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1068]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1069]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1070]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1071]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1072]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1073]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1074]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1075]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1076]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1077]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1078]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1079]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1080]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1081]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1082]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1083]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1084]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_dk_itu_sdg_language_xwpf_Run_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Run"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Part"
    // Xwpf.g:4545:1: parse_dk_itu_sdg_language_xwpf_Part returns [dk.itu.sdg.language.xwpf.Part element = null] : a0= 'Part' a1= ';' ;
    public final dk.itu.sdg.language.xwpf.Part parse_dk_itu_sdg_language_xwpf_Part() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Part element =  null;

        int parse_dk_itu_sdg_language_xwpf_Part_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Xwpf.g:4548:2: (a0= 'Part' a1= ';' )
            // Xwpf.g:4549:2: a0= 'Part' a1= ';'
            {
            a0=(Token)match(input,27,FOLLOW_27_in_parse_dk_itu_sdg_language_xwpf_Part4155); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createPart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_13_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1085]);
            	}

            a1=(Token)match(input,12,FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Part4169); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createPart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_13_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1086]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1087]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1088]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1089]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1090]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1091]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1092]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1093]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1094]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1095]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1096]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1097]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1098]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1099]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1100]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1101]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1102]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1103]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1104]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1105]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1106]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1107]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1108]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_dk_itu_sdg_language_xwpf_Part_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Part"



    // $ANTLR start "parse_dk_itu_sdg_language_xwpf_Body"
    // Xwpf.g:4601:1: parse_dk_itu_sdg_language_xwpf_Body returns [dk.itu.sdg.language.xwpf.Body element = null] : a0= 'Body' a1= ';' ;
    public final dk.itu.sdg.language.xwpf.Body parse_dk_itu_sdg_language_xwpf_Body() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Body element =  null;

        int parse_dk_itu_sdg_language_xwpf_Body_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Xwpf.g:4604:2: (a0= 'Body' a1= ';' )
            // Xwpf.g:4605:2: a0= 'Body' a1= ';'
            {
            a0=(Token)match(input,13,FOLLOW_13_in_parse_dk_itu_sdg_language_xwpf_Body4198); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createBody();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_14_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1109]);
            	}

            a1=(Token)match(input,12,FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Body4212); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createBody();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_14_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1110]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1111]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1112]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1113]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1114]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1115]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1116]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1117]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1118]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1119]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1120]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1121]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1122]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1123]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1124]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1125]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1126]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1127]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1128]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1129]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1130]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1131]);
            		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1132]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_dk_itu_sdg_language_xwpf_Body_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_dk_itu_sdg_language_xwpf_Body"

    // $ANTLR start synpred1_Xwpf
    public final void synpred1_Xwpf_fragment() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Content c0 =null;


        // Xwpf.g:559:3: (c0= parse_dk_itu_sdg_language_xwpf_Content )
        // Xwpf.g:559:3: c0= parse_dk_itu_sdg_language_xwpf_Content
        {
        pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Content_in_synpred1_Xwpf82);
        c0=parse_dk_itu_sdg_language_xwpf_Content();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_Xwpf

    // $ANTLR start synpred2_Xwpf
    public final void synpred2_Xwpf_fragment() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Comment c1 =null;


        // Xwpf.g:560:8: (c1= parse_dk_itu_sdg_language_xwpf_Comment )
        // Xwpf.g:560:8: c1= parse_dk_itu_sdg_language_xwpf_Comment
        {
        pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Comment_in_synpred2_Xwpf96);
        c1=parse_dk_itu_sdg_language_xwpf_Comment();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_Xwpf

    // $ANTLR start synpred3_Xwpf
    public final void synpred3_Xwpf_fragment() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Footnote c2 =null;


        // Xwpf.g:561:8: (c2= parse_dk_itu_sdg_language_xwpf_Footnote )
        // Xwpf.g:561:8: c2= parse_dk_itu_sdg_language_xwpf_Footnote
        {
        pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_synpred3_Xwpf110);
        c2=parse_dk_itu_sdg_language_xwpf_Footnote();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_Xwpf

    // $ANTLR start synpred4_Xwpf
    public final void synpred4_Xwpf_fragment() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Footer c3 =null;


        // Xwpf.g:562:8: (c3= parse_dk_itu_sdg_language_xwpf_Footer )
        // Xwpf.g:562:8: c3= parse_dk_itu_sdg_language_xwpf_Footer
        {
        pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Footer_in_synpred4_Xwpf124);
        c3=parse_dk_itu_sdg_language_xwpf_Footer();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_Xwpf

    // $ANTLR start synpred5_Xwpf
    public final void synpred5_Xwpf_fragment() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Header c4 =null;


        // Xwpf.g:563:8: (c4= parse_dk_itu_sdg_language_xwpf_Header )
        // Xwpf.g:563:8: c4= parse_dk_itu_sdg_language_xwpf_Header
        {
        pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Header_in_synpred5_Xwpf138);
        c4=parse_dk_itu_sdg_language_xwpf_Header();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_Xwpf

    // $ANTLR start synpred6_Xwpf
    public final void synpred6_Xwpf_fragment() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Paragraph c5 =null;


        // Xwpf.g:564:8: (c5= parse_dk_itu_sdg_language_xwpf_Paragraph )
        // Xwpf.g:564:8: c5= parse_dk_itu_sdg_language_xwpf_Paragraph
        {
        pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Paragraph_in_synpred6_Xwpf152);
        c5=parse_dk_itu_sdg_language_xwpf_Paragraph();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_Xwpf

    // $ANTLR start synpred7_Xwpf
    public final void synpred7_Xwpf_fragment() throws RecognitionException {
        dk.itu.sdg.language.xwpf.Run c6 =null;


        // Xwpf.g:565:8: (c6= parse_dk_itu_sdg_language_xwpf_Run )
        // Xwpf.g:565:8: c6= parse_dk_itu_sdg_language_xwpf_Run
        {
        pushFollow(FOLLOW_parse_dk_itu_sdg_language_xwpf_Run_in_synpred7_Xwpf166);
        c6=parse_dk_itu_sdg_language_xwpf_Run();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_Xwpf

    // $ANTLR start synpred32_Xwpf
    public final void synpred32_Xwpf_fragment() throws RecognitionException {
        Token a2=null;

        // Xwpf.g:1747:4: ( (a2= QUOTED_34_34 ) )
        // Xwpf.g:1747:4: (a2= QUOTED_34_34 )
        {
        // Xwpf.g:1747:4: (a2= QUOTED_34_34 )
        // Xwpf.g:1748:5: a2= QUOTED_34_34
        {
        a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_synpred32_Xwpf1665); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred32_Xwpf

    // $ANTLR start synpred33_Xwpf
    public final void synpred33_Xwpf_fragment() throws RecognitionException {
        Token a3=null;

        // Xwpf.g:1787:8: ( (a3= QUOTED_34_34 ) )
        // Xwpf.g:1787:8: (a3= QUOTED_34_34 )
        {
        // Xwpf.g:1787:8: (a3= QUOTED_34_34 )
        // Xwpf.g:1788:5: a3= QUOTED_34_34
        {
        a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_synpred33_Xwpf1712); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred33_Xwpf

    // $ANTLR start synpred38_Xwpf
    public final void synpred38_Xwpf_fragment() throws RecognitionException {
        Token a1=null;

        // Xwpf.g:2254:4: ( (a1= QUOTED_34_34 ) )
        // Xwpf.g:2254:4: (a1= QUOTED_34_34 )
        {
        // Xwpf.g:2254:4: (a1= QUOTED_34_34 )
        // Xwpf.g:2255:5: a1= QUOTED_34_34
        {
        a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_synpred38_Xwpf2217); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred38_Xwpf

    // $ANTLR start synpred40_Xwpf
    public final void synpred40_Xwpf_fragment() throws RecognitionException {
        Token a2=null;

        // Xwpf.g:2519:4: ( (a2= QUOTED_34_34 ) )
        // Xwpf.g:2519:4: (a2= QUOTED_34_34 )
        {
        // Xwpf.g:2519:4: (a2= QUOTED_34_34 )
        // Xwpf.g:2520:5: a2= QUOTED_34_34
        {
        a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_synpred40_Xwpf2468); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred40_Xwpf

    // $ANTLR start synpred44_Xwpf
    public final void synpred44_Xwpf_fragment() throws RecognitionException {
        Token a12=null;

        // Xwpf.g:2812:8: ( (a12= TEXT ) )
        // Xwpf.g:2812:8: (a12= TEXT )
        {
        // Xwpf.g:2812:8: (a12= TEXT )
        // Xwpf.g:2813:5: a12= TEXT
        {
        a12=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred44_Xwpf2761); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred44_Xwpf

    // $ANTLR start synpred45_Xwpf
    public final void synpred45_Xwpf_fragment() throws RecognitionException {
        Token a13=null;

        // Xwpf.g:2871:8: ( (a13= TEXT ) )
        // Xwpf.g:2871:8: (a13= TEXT )
        {
        // Xwpf.g:2871:8: (a13= TEXT )
        // Xwpf.g:2872:5: a13= TEXT
        {
        a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred45_Xwpf2808); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred45_Xwpf

    // $ANTLR start synpred46_Xwpf
    public final void synpred46_Xwpf_fragment() throws RecognitionException {
        Token a14=null;

        // Xwpf.g:2930:8: ( (a14= TEXT ) )
        // Xwpf.g:2930:8: (a14= TEXT )
        {
        // Xwpf.g:2930:8: (a14= TEXT )
        // Xwpf.g:2931:5: a14= TEXT
        {
        a14=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred46_Xwpf2855); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred46_Xwpf

    // $ANTLR start synpred47_Xwpf
    public final void synpred47_Xwpf_fragment() throws RecognitionException {
        Token a15=null;

        // Xwpf.g:2989:8: ( (a15= TEXT ) )
        // Xwpf.g:2989:8: (a15= TEXT )
        {
        // Xwpf.g:2989:8: (a15= TEXT )
        // Xwpf.g:2990:5: a15= TEXT
        {
        a15=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred47_Xwpf2902); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred47_Xwpf

    // $ANTLR start synpred48_Xwpf
    public final void synpred48_Xwpf_fragment() throws RecognitionException {
        Token a16=null;

        // Xwpf.g:3048:8: ( (a16= TEXT ) )
        // Xwpf.g:3048:8: (a16= TEXT )
        {
        // Xwpf.g:3048:8: (a16= TEXT )
        // Xwpf.g:3049:5: a16= TEXT
        {
        a16=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred48_Xwpf2949); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred48_Xwpf

    // $ANTLR start synpred49_Xwpf
    public final void synpred49_Xwpf_fragment() throws RecognitionException {
        Token a17=null;

        // Xwpf.g:3107:8: ( (a17= TEXT ) )
        // Xwpf.g:3107:8: (a17= TEXT )
        {
        // Xwpf.g:3107:8: (a17= TEXT )
        // Xwpf.g:3108:5: a17= TEXT
        {
        a17=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred49_Xwpf2996); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred49_Xwpf

    // $ANTLR start synpred50_Xwpf
    public final void synpred50_Xwpf_fragment() throws RecognitionException {
        Token a18=null;

        // Xwpf.g:3166:8: ( (a18= TEXT ) )
        // Xwpf.g:3166:8: (a18= TEXT )
        {
        // Xwpf.g:3166:8: (a18= TEXT )
        // Xwpf.g:3167:5: a18= TEXT
        {
        a18=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred50_Xwpf3043); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred50_Xwpf

    // $ANTLR start synpred51_Xwpf
    public final void synpred51_Xwpf_fragment() throws RecognitionException {
        Token a19=null;

        // Xwpf.g:3225:8: ( (a19= QUOTED_34_34 ) )
        // Xwpf.g:3225:8: (a19= QUOTED_34_34 )
        {
        // Xwpf.g:3225:8: (a19= QUOTED_34_34 )
        // Xwpf.g:3226:5: a19= QUOTED_34_34
        {
        a19=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_synpred51_Xwpf3090); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred51_Xwpf

    // $ANTLR start synpred52_Xwpf
    public final void synpred52_Xwpf_fragment() throws RecognitionException {
        Token a20=null;

        // Xwpf.g:3284:8: ( (a20= TEXT ) )
        // Xwpf.g:3284:8: (a20= TEXT )
        {
        // Xwpf.g:3284:8: (a20= TEXT )
        // Xwpf.g:3285:5: a20= TEXT
        {
        a20=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred52_Xwpf3137); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred52_Xwpf

    // $ANTLR start synpred53_Xwpf
    public final void synpred53_Xwpf_fragment() throws RecognitionException {
        Token a21=null;

        // Xwpf.g:3343:8: ( (a21= TEXT ) )
        // Xwpf.g:3343:8: (a21= TEXT )
        {
        // Xwpf.g:3343:8: (a21= TEXT )
        // Xwpf.g:3344:5: a21= TEXT
        {
        a21=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred53_Xwpf3184); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred53_Xwpf

    // $ANTLR start synpred54_Xwpf
    public final void synpred54_Xwpf_fragment() throws RecognitionException {
        Token a22=null;

        // Xwpf.g:3402:8: ( (a22= TEXT ) )
        // Xwpf.g:3402:8: (a22= TEXT )
        {
        // Xwpf.g:3402:8: (a22= TEXT )
        // Xwpf.g:3403:5: a22= TEXT
        {
        a22=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred54_Xwpf3231); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred54_Xwpf

    // $ANTLR start synpred55_Xwpf
    public final void synpred55_Xwpf_fragment() throws RecognitionException {
        Token a23=null;

        // Xwpf.g:3461:8: ( (a23= TEXT ) )
        // Xwpf.g:3461:8: (a23= TEXT )
        {
        // Xwpf.g:3461:8: (a23= TEXT )
        // Xwpf.g:3462:5: a23= TEXT
        {
        a23=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred55_Xwpf3278); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred55_Xwpf

    // $ANTLR start synpred56_Xwpf
    public final void synpred56_Xwpf_fragment() throws RecognitionException {
        Token a24=null;

        // Xwpf.g:3520:8: ( (a24= TEXT ) )
        // Xwpf.g:3520:8: (a24= TEXT )
        {
        // Xwpf.g:3520:8: (a24= TEXT )
        // Xwpf.g:3521:5: a24= TEXT
        {
        a24=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred56_Xwpf3325); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred56_Xwpf

    // $ANTLR start synpred57_Xwpf
    public final void synpred57_Xwpf_fragment() throws RecognitionException {
        Token a25=null;

        // Xwpf.g:3579:8: ( (a25= TEXT ) )
        // Xwpf.g:3579:8: (a25= TEXT )
        {
        // Xwpf.g:3579:8: (a25= TEXT )
        // Xwpf.g:3580:5: a25= TEXT
        {
        a25=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred57_Xwpf3372); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred57_Xwpf

    // $ANTLR start synpred58_Xwpf
    public final void synpred58_Xwpf_fragment() throws RecognitionException {
        Token a26=null;

        // Xwpf.g:3638:8: ( (a26= TEXT ) )
        // Xwpf.g:3638:8: (a26= TEXT )
        {
        // Xwpf.g:3638:8: (a26= TEXT )
        // Xwpf.g:3639:5: a26= TEXT
        {
        a26=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred58_Xwpf3419); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred58_Xwpf

    // $ANTLR start synpred59_Xwpf
    public final void synpred59_Xwpf_fragment() throws RecognitionException {
        Token a27=null;

        // Xwpf.g:3697:8: ( (a27= TEXT ) )
        // Xwpf.g:3697:8: (a27= TEXT )
        {
        // Xwpf.g:3697:8: (a27= TEXT )
        // Xwpf.g:3698:5: a27= TEXT
        {
        a27=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred59_Xwpf3466); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred59_Xwpf

    // $ANTLR start synpred60_Xwpf
    public final void synpred60_Xwpf_fragment() throws RecognitionException {
        Token a28=null;

        // Xwpf.g:3756:8: ( (a28= TEXT ) )
        // Xwpf.g:3756:8: (a28= TEXT )
        {
        // Xwpf.g:3756:8: (a28= TEXT )
        // Xwpf.g:3757:5: a28= TEXT
        {
        a28=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred60_Xwpf3513); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred60_Xwpf

    // $ANTLR start synpred69_Xwpf
    public final void synpred69_Xwpf_fragment() throws RecognitionException {
        Token a11=null;

        // Xwpf.g:4196:4: ( (a11= QUOTED_34_34 ) )
        // Xwpf.g:4196:4: (a11= QUOTED_34_34 )
        {
        // Xwpf.g:4196:4: (a11= QUOTED_34_34 )
        // Xwpf.g:4197:5: a11= QUOTED_34_34
        {
        a11=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_synpred69_Xwpf3892); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred69_Xwpf

    // $ANTLR start synpred70_Xwpf
    public final void synpred70_Xwpf_fragment() throws RecognitionException {
        Token a12=null;

        // Xwpf.g:4253:8: ( (a12= QUOTED_34_34 ) )
        // Xwpf.g:4253:8: (a12= QUOTED_34_34 )
        {
        // Xwpf.g:4253:8: (a12= QUOTED_34_34 )
        // Xwpf.g:4254:5: a12= QUOTED_34_34
        {
        a12=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_synpred70_Xwpf3939); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred70_Xwpf

    // $ANTLR start synpred71_Xwpf
    public final void synpred71_Xwpf_fragment() throws RecognitionException {
        Token a13=null;

        // Xwpf.g:4310:8: ( (a13= TEXT ) )
        // Xwpf.g:4310:8: (a13= TEXT )
        {
        // Xwpf.g:4310:8: (a13= TEXT )
        // Xwpf.g:4311:5: a13= TEXT
        {
        a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred71_Xwpf3986); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred71_Xwpf

    // $ANTLR start synpred72_Xwpf
    public final void synpred72_Xwpf_fragment() throws RecognitionException {
        Token a14=null;

        // Xwpf.g:4367:8: ( (a14= QUOTED_34_34 ) )
        // Xwpf.g:4367:8: (a14= QUOTED_34_34 )
        {
        // Xwpf.g:4367:8: (a14= QUOTED_34_34 )
        // Xwpf.g:4368:5: a14= QUOTED_34_34
        {
        a14=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_synpred72_Xwpf4033); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred72_Xwpf

    // Delegated rules

    public final boolean synpred46_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_Xwpf_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_Xwpf() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_Xwpf_fragment(); // can never throw exception
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
        "\75\uffff";
    static final String DFA1_eofS =
        "\75\uffff";
    static final String DFA1_minS =
        "\1\17\1\uffff\5\63\3\35\1\63\1\uffff\7\10\1\0\1\10\1\0\1\10\1\0"+
        "\1\10\1\0\1\10\3\13\6\10\1\0\2\10\1\0\4\uffff\1\35\1\33\1\15\2\uffff"+
        "\3\35\1\63\2\14\6\10";
    static final String DFA1_maxS =
        "\1\51\1\uffff\5\63\2\51\1\35\1\63\1\uffff\7\64\1\0\1\64\1\0\1\64"+
        "\1\0\1\64\1\0\1\64\3\13\6\64\1\0\2\64\1\0\4\uffff\1\51\1\33\1\15"+
        "\2\uffff\2\51\1\35\1\63\2\14\6\64";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\11\uffff\1\10\34\uffff\1\2\1\3\1\4\1\5\3\uffff\1\6"+
        "\1\7\14\uffff";
    static final String DFA1_specialS =
        "\23\uffff\1\5\1\uffff\1\3\1\uffff\1\1\1\uffff\1\2\12\uffff\1\4\2"+
        "\uffff\1\0\25\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\1\1\13\1\4\1\3\1\5\5\uffff\1\6\2\uffff\1\12\11\uffff"+
            "\1\7\1\10\1\11",
            "",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\12\12\uffff\1\10\1\11",
            "\1\12\13\uffff\1\11",
            "\1\12",
            "\1\21",
            "",
            "\1\22\53\uffff\1\23",
            "\1\24\53\uffff\1\25",
            "\1\26\53\uffff\1\27",
            "\1\30\53\uffff\1\31",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\45\1\46\52\uffff\1\47",
            "\1\22\53\uffff\1\23",
            "\1\uffff",
            "\1\24\53\uffff\1\25",
            "\1\uffff",
            "\1\26\53\uffff\1\27",
            "\1\uffff",
            "\1\30\53\uffff\1\31",
            "\1\uffff",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\uffff",
            "\1\45\1\46\52\uffff\1\47",
            "\1\45\1\46\52\uffff\1\47",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\1\64\11\uffff\1\61\1\62\1\63",
            "\1\65",
            "\1\66",
            "",
            "",
            "\1\64\12\uffff\1\62\1\63",
            "\1\64\13\uffff\1\63",
            "\1\64",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72\1\73\52\uffff\1\74",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44",
            "\1\72\1\73\52\uffff\1\74",
            "\1\72\1\73\52\uffff\1\74",
            "\1\32\1\36\13\uffff\1\40\1\41\1\uffff\1\42\6\uffff\1\35\12"+
            "\uffff\1\43\3\uffff\1\34\1\uffff\1\33\1\uffff\1\37\1\uffff\1"+
            "\44"
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
            return "558:2: (c0= parse_dk_itu_sdg_language_xwpf_Content |c1= parse_dk_itu_sdg_language_xwpf_Comment |c2= parse_dk_itu_sdg_language_xwpf_Footnote |c3= parse_dk_itu_sdg_language_xwpf_Footer |c4= parse_dk_itu_sdg_language_xwpf_Header |c5= parse_dk_itu_sdg_language_xwpf_Paragraph |c6= parse_dk_itu_sdg_language_xwpf_Run |c7= parse_dk_itu_sdg_language_xwpf_Document )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_39 = input.LA(1);

                         
                        int index1_39 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_Xwpf()) ) {s = 1;}

                        else if ( (synpred7_Xwpf()) ) {s = 48;}

                         
                        input.seek(index1_39);

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_23 = input.LA(1);

                         
                        int index1_23 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_Xwpf()) ) {s = 1;}

                        else if ( (synpred4_Xwpf()) ) {s = 42;}

                         
                        input.seek(index1_23);

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_25 = input.LA(1);

                         
                        int index1_25 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_Xwpf()) ) {s = 1;}

                        else if ( (synpred5_Xwpf()) ) {s = 43;}

                         
                        input.seek(index1_25);

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA1_21 = input.LA(1);

                         
                        int index1_21 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_Xwpf()) ) {s = 1;}

                        else if ( (synpred3_Xwpf()) ) {s = 41;}

                         
                        input.seek(index1_21);

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_36 = input.LA(1);

                         
                        int index1_36 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_Xwpf()) ) {s = 1;}

                        else if ( (synpred6_Xwpf()) ) {s = 47;}

                         
                        input.seek(index1_36);

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_19 = input.LA(1);

                         
                        int index1_19 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_Xwpf()) ) {s = 1;}

                        else if ( (synpred2_Xwpf()) ) {s = 40;}

                         
                        input.seek(index1_19);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Content_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Comment_in_start96 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_start110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Footer_in_start124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Header_in_start138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Paragraph_in_start152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Run_in_start166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Document_in_start180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_dk_itu_sdg_language_xwpf_Content213 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Content227 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Content256 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Content302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Comment_in_parse_dk_itu_sdg_language_xwpf_Content321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_parse_dk_itu_sdg_language_xwpf_Content331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Footer_in_parse_dk_itu_sdg_language_xwpf_Content341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Header_in_parse_dk_itu_sdg_language_xwpf_Content351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Paragraph_in_parse_dk_itu_sdg_language_xwpf_Content361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Run_in_parse_dk_itu_sdg_language_xwpf_Content371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_dk_itu_sdg_language_xwpf_Document396 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Document410 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_32_in_parse_dk_itu_sdg_language_xwpf_Document433 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document453 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_BodyElement_in_parse_dk_itu_sdg_language_xwpf_Document479 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_33_in_parse_dk_itu_sdg_language_xwpf_Document515 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document535 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Comment_in_parse_dk_itu_sdg_language_xwpf_Document561 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_34_in_parse_dk_itu_sdg_language_xwpf_Document597 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document617 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_parse_dk_itu_sdg_language_xwpf_Document643 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_35_in_parse_dk_itu_sdg_language_xwpf_Document679 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document699 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Footer_in_parse_dk_itu_sdg_language_xwpf_Document725 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_36_in_parse_dk_itu_sdg_language_xwpf_Document761 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document781 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_parse_dk_itu_sdg_language_xwpf_Document807 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_37_in_parse_dk_itu_sdg_language_xwpf_Document843 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document863 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Header_in_parse_dk_itu_sdg_language_xwpf_Document889 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_38_in_parse_dk_itu_sdg_language_xwpf_Document925 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document945 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Hyperlink_in_parse_dk_itu_sdg_language_xwpf_Document971 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_43_in_parse_dk_itu_sdg_language_xwpf_Document1007 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1027 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Numbering_in_parse_dk_itu_sdg_language_xwpf_Document1053 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_44_in_parse_dk_itu_sdg_language_xwpf_Document1089 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1109 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_PictureData_in_parse_dk_itu_sdg_language_xwpf_Document1135 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_45_in_parse_dk_itu_sdg_language_xwpf_Document1171 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1191 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Paragraph_in_parse_dk_itu_sdg_language_xwpf_Document1217 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_47_in_parse_dk_itu_sdg_language_xwpf_Document1253 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1273 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_PictureData_in_parse_dk_itu_sdg_language_xwpf_Document1299 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_50_in_parse_dk_itu_sdg_language_xwpf_Document1348 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_21_in_parse_dk_itu_sdg_language_xwpf_Document1367 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_22_in_parse_dk_itu_sdg_language_xwpf_Document1386 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_24_in_parse_dk_itu_sdg_language_xwpf_Document1405 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_42_in_parse_dk_itu_sdg_language_xwpf_Document1424 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_49_in_parse_dk_itu_sdg_language_xwpf_Document1463 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Document1483 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Table_in_parse_dk_itu_sdg_language_xwpf_Document1509 = new BitSet(new long[]{0x0016BC7F01600000L});
    public static final BitSet FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Document1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_dk_itu_sdg_language_xwpf_BodyElement1579 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_BodyElement1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_dk_itu_sdg_language_xwpf_Comment1622 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Comment1636 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Comment1665 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Comment1712 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Comment1759 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Comment1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_dk_itu_sdg_language_xwpf_Footnote1834 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Footnote1848 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Footnote1877 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Footnote1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_dk_itu_sdg_language_xwpf_Footer1952 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Footer1966 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Footer1995 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Footer2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_dk_itu_sdg_language_xwpf_Header2070 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Header2084 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Header2113 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Header2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_dk_itu_sdg_language_xwpf_Hyperlink2188 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Hyperlink2217 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Hyperlink2264 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Hyperlink2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_dk_itu_sdg_language_xwpf_Numbering2339 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Numbering2353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_dk_itu_sdg_language_xwpf_PictureData2382 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_PictureData2396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_dk_itu_sdg_language_xwpf_Paragraph2425 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Paragraph2439 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Paragraph2468 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_48_in_parse_dk_itu_sdg_language_xwpf_Paragraph2509 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Paragraph2529 = new BitSet(new long[]{0x0000038020000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Run_in_parse_dk_itu_sdg_language_xwpf_Paragraph2555 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_46_in_parse_dk_itu_sdg_language_xwpf_Paragraph2591 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Paragraph2611 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Part_in_parse_dk_itu_sdg_language_xwpf_Paragraph2637 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_31_in_parse_dk_itu_sdg_language_xwpf_Paragraph2673 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_dk_itu_sdg_language_xwpf_Paragraph2693 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Body_in_parse_dk_itu_sdg_language_xwpf_Paragraph2719 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2761 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2808 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2855 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2902 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2949 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph2996 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3043 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Paragraph3090 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3137 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3184 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3231 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3278 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3325 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3372 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3419 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3466 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Paragraph3513 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_50_in_parse_dk_itu_sdg_language_xwpf_Paragraph3567 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_21_in_parse_dk_itu_sdg_language_xwpf_Paragraph3586 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_22_in_parse_dk_itu_sdg_language_xwpf_Paragraph3605 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_24_in_parse_dk_itu_sdg_language_xwpf_Paragraph3624 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_42_in_parse_dk_itu_sdg_language_xwpf_Paragraph3643 = new BitSet(new long[]{0x0015440081600300L});
    public static final BitSet FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Paragraph3687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_dk_itu_sdg_language_xwpf_Table3716 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Table3730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_dk_itu_sdg_language_xwpf_Run3768 = new BitSet(new long[]{0x0000030020000000L});
    public static final BitSet FOLLOW_40_in_parse_dk_itu_sdg_language_xwpf_Run3798 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_parse_dk_itu_sdg_language_xwpf_Run3828 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_dk_itu_sdg_language_xwpf_Run3849 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_dk_itu_sdg_language_xwpf_Run3863 = new BitSet(new long[]{0x0010000000000300L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Run3892 = new BitSet(new long[]{0x0010000000000300L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Run3939 = new BitSet(new long[]{0x0010000000000300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Run3986 = new BitSet(new long[]{0x0010000000000300L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_dk_itu_sdg_language_xwpf_Run4033 = new BitSet(new long[]{0x0010000000000300L});
    public static final BitSet FOLLOW_TEXT_in_parse_dk_itu_sdg_language_xwpf_Run4080 = new BitSet(new long[]{0x0010000000000300L});
    public static final BitSet FOLLOW_52_in_parse_dk_itu_sdg_language_xwpf_Run4126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_dk_itu_sdg_language_xwpf_Part4155 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Part4169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_dk_itu_sdg_language_xwpf_Body4198 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_dk_itu_sdg_language_xwpf_Body4212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Content_in_synpred1_Xwpf82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Comment_in_synpred2_Xwpf96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Footnote_in_synpred3_Xwpf110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Footer_in_synpred4_Xwpf124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Header_in_synpred5_Xwpf138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Paragraph_in_synpred6_Xwpf152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_dk_itu_sdg_language_xwpf_Run_in_synpred7_Xwpf166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_synpred32_Xwpf1665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_synpred33_Xwpf1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_synpred38_Xwpf2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_synpred40_Xwpf2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred44_Xwpf2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred45_Xwpf2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred46_Xwpf2855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred47_Xwpf2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred48_Xwpf2949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred49_Xwpf2996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred50_Xwpf3043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_synpred51_Xwpf3090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred52_Xwpf3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred53_Xwpf3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred54_Xwpf3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred55_Xwpf3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred56_Xwpf3325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred57_Xwpf3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred58_Xwpf3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred59_Xwpf3466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred60_Xwpf3513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_synpred69_Xwpf3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_synpred70_Xwpf3939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred71_Xwpf3986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_synpred72_Xwpf4033 = new BitSet(new long[]{0x0000000000000002L});

}