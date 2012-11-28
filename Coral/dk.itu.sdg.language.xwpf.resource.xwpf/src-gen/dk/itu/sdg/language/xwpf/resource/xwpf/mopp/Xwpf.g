grammar Xwpf;

options {
	superClass = XwpfANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
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
	(
		c0 = parse_dk_itu_sdg_language_xwpf_Content{ element = c0; }
		|  		c1 = parse_dk_itu_sdg_language_xwpf_Comment{ element = c1; }
		|  		c2 = parse_dk_itu_sdg_language_xwpf_Footnote{ element = c2; }
		|  		c3 = parse_dk_itu_sdg_language_xwpf_Footer{ element = c3; }
		|  		c4 = parse_dk_itu_sdg_language_xwpf_Header{ element = c4; }
		|  		c5 = parse_dk_itu_sdg_language_xwpf_Paragraph{ element = c5; }
		|  		c6 = parse_dk_itu_sdg_language_xwpf_Run{ element = c6; }
		|  		c7 = parse_dk_itu_sdg_language_xwpf_Document{ element = c7; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_dk_itu_sdg_language_xwpf_Content returns [dk.itu.sdg.language.xwpf.Content element = null]
@init{
}
:
	a0 = 'Content' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createContent();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[11]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createContent();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_0_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[13]);
	}
	
	(
		(
			(
				a2 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[14]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[15]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[16]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[17]);
	}
	
	a3 = '}' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createContent();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_0_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_dk_itu_sdg_language_xwpf_Comment{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_dk_itu_sdg_language_xwpf_Footnote{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_dk_itu_sdg_language_xwpf_Footer{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_dk_itu_sdg_language_xwpf_Header{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_dk_itu_sdg_language_xwpf_Paragraph{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_dk_itu_sdg_language_xwpf_Run{ element = c5; /* this is a subclass or primitive expression choice */ }
	
;

parse_dk_itu_sdg_language_xwpf_Document returns [dk.itu.sdg.language.xwpf.Document element = null]
@init{
}
:
	a0 = 'Document' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[18]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
	(
		(
			a2 = 'bodyElements' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[33]);
			}
			
			a3 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[34]);
			}
			
			(
				a4_0 = parse_dk_itu_sdg_language_xwpf_BodyElement				{
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
			)
			{
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
			
			
			|			a5 = 'comments' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_1_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[49]);
			}
			
			a6 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_1_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[50]);
			}
			
			(
				a7_0 = parse_dk_itu_sdg_language_xwpf_Comment				{
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
			)
			{
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
			
			
			|			a8 = 'endnotes' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_2_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[65]);
			}
			
			a9 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_2_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[66]);
			}
			
			(
				a10_0 = parse_dk_itu_sdg_language_xwpf_Footnote				{
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
			)
			{
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
			
			
			|			a11 = 'footers' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_3_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[81]);
			}
			
			a12 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_3_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[82]);
			}
			
			(
				a13_0 = parse_dk_itu_sdg_language_xwpf_Footer				{
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
			)
			{
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
			
			
			|			a14 = 'footnotes' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_4_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[97]);
			}
			
			a15 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_4_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[98]);
			}
			
			(
				a16_0 = parse_dk_itu_sdg_language_xwpf_Footnote				{
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
			)
			{
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
			
			
			|			a17 = 'headers' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_5_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[113]);
			}
			
			a18 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_5_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[114]);
			}
			
			(
				a19_0 = parse_dk_itu_sdg_language_xwpf_Header				{
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
			)
			{
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
			
			
			|			a20 = 'hyperlinks' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_6_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[129]);
			}
			
			a21 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_6_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[130]);
			}
			
			(
				a22_0 = parse_dk_itu_sdg_language_xwpf_Hyperlink				{
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
			)
			{
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
			
			
			|			a23 = 'numbering' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_7_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a23, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[145]);
			}
			
			a24 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_7_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[146]);
			}
			
			(
				a25_0 = parse_dk_itu_sdg_language_xwpf_Numbering				{
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
			)
			{
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
			
			
			|			a26 = 'packagePictures' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_8_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a26, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[161]);
			}
			
			a27 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_8_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a27, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[162]);
			}
			
			(
				a28_0 = parse_dk_itu_sdg_language_xwpf_PictureData				{
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
			)
			{
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
			
			
			|			a29 = 'paragraphs' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_9_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a29, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[177]);
			}
			
			a30 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_9_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a30, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[178]);
			}
			
			(
				a31_0 = parse_dk_itu_sdg_language_xwpf_Paragraph				{
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
			)
			{
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
			
			
			|			a32 = 'pictures' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_10_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a32, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[193]);
			}
			
			a33 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_10_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a33, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[194]);
			}
			
			(
				a34_0 = parse_dk_itu_sdg_language_xwpf_PictureData				{
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
			)
			{
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
			
			
			|			(
				(
					a35 = 'unrecognized' {
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
					|					a36 = 'Heading1' {
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
					|					a37 = 'Heading2' {
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
					|					a38 = 'ListParagraph' {
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
					|					a39 = 'null' {
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
				)
			)
			{
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
			
			
			|			a42 = 'tables' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_12_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a42, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[223]);
			}
			
			a43 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_2_0_12_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a43, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[224]);
			}
			
			(
				a44_0 = parse_dk_itu_sdg_language_xwpf_Table				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
	a45 = '}' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createDocument();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_1_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a45, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_dk_itu_sdg_language_xwpf_BodyElement returns [dk.itu.sdg.language.xwpf.BodyElement element = null]
@init{
}
:
	a0 = 'BodyElement' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createBodyElement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[253]);
	}
	
	a1 = ';' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createBodyElement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Comment returns [dk.itu.sdg.language.xwpf.Comment element = null]
@init{
}
:
	a0 = 'Comment' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createComment();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[268]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createComment();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[269]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[270]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[271]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[272]);
	}
	
	(
		(
			(
				a2 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[273]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[274]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[275]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[276]);
			}
			
			
			|			(
				a3 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[277]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[278]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[279]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[280]);
			}
			
			
			|			(
				a4 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[281]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[282]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[283]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[284]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[285]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[286]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[287]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[288]);
	}
	
	a5 = '}' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createComment();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Footnote returns [dk.itu.sdg.language.xwpf.Footnote element = null]
@init{
}
:
	a0 = 'Footnote' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFootnote();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[303]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFootnote();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_4_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[304]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[305]);
	}
	
	(
		(
			(
				a2 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[306]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[307]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[308]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[309]);
	}
	
	a3 = '}' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFootnote();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_4_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Footer returns [dk.itu.sdg.language.xwpf.Footer element = null]
@init{
}
:
	a0 = 'Footer' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFooter();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_5_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[324]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFooter();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_5_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[325]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[326]);
	}
	
	(
		(
			(
				a2 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[327]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[328]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[329]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[330]);
	}
	
	a3 = '}' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createFooter();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_5_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Header returns [dk.itu.sdg.language.xwpf.Header element = null]
@init{
}
:
	a0 = 'Header' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHeader();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[345]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHeader();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_6_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[346]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[347]);
	}
	
	(
		(
			(
				a2 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[348]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[349]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[350]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[351]);
	}
	
	a3 = '}' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHeader();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_6_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Hyperlink returns [dk.itu.sdg.language.xwpf.Hyperlink element = null]
@init{
}
:
	a0 = 'Hyperlink' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHyperlink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_7_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[366]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[367]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[368]);
	}
	
	(
		(
			(
				a1 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[369]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[370]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[371]);
			}
			
			
			|			(
				a2 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[372]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[373]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[374]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[375]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[376]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[377]);
	}
	
	a3 = ';' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createHyperlink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_7_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Numbering returns [dk.itu.sdg.language.xwpf.Numbering element = null]
@init{
}
:
	a0 = 'Numbering' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createNumbering();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_8_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[392]);
	}
	
	a1 = ';' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createNumbering();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_8_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_PictureData returns [dk.itu.sdg.language.xwpf.PictureData element = null]
@init{
}
:
	a0 = 'PictureData' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createPictureData();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_9_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[407]);
	}
	
	a1 = ';' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createPictureData();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_9_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Paragraph returns [dk.itu.sdg.language.xwpf.Paragraph element = null]
@init{
}
:
	a0 = 'Paragraph' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[422]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
	(
		(
			(
				a2 = QUOTED_34_34				
				{
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
			)
			{
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
			
			
			|			a3 = 'runs' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_1_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[469]);
			}
			
			a4 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_1_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[470]);
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[471]);
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[472]);
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[473]);
			}
			
			(
				a5_0 = parse_dk_itu_sdg_language_xwpf_Run				{
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
			)
			{
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
			
			
			|			a6 = 'part' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_2_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[497]);
			}
			
			a7 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_2_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[498]);
			}
			
			(
				a8_0 = parse_dk_itu_sdg_language_xwpf_Part				{
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
			)
			{
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
			
			
			|			a9 = 'body' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_3_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[522]);
			}
			
			a10 = ':' {
				if (element == null) {
					element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_2_0_3_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(), dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[523]);
			}
			
			(
				a11_0 = parse_dk_itu_sdg_language_xwpf_Body				{
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
			)
			{
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
			
			
			|			(
				a12 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a13 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a14 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a15 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a16 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a17 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a18 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a19 = QUOTED_34_34				
				{
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
			)
			{
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
			
			
			|			(
				a20 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a21 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a22 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a23 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a24 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a25 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a26 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a27 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				a28 = TEXT				
				{
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
			)
			{
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
			
			
			|			(
				(
					a29 = 'unrecognized' {
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
					|					a30 = 'Heading1' {
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
					|					a31 = 'Heading2' {
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
					|					a32 = 'ListParagraph' {
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
					|					a33 = 'null' {
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
				)
			)
			{
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
			
		)
		
	)*	{
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
	
	a36 = '}' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createParagraph();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_10_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a36, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Table returns [dk.itu.sdg.language.xwpf.Table element = null]
@init{
}
:
	a0 = 'Table' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createTable();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_11_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[998]);
	}
	
	a1 = ';' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createTable();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_11_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Run returns [dk.itu.sdg.language.xwpf.Run element = null]
@init{
}
:
	(
		(
			a0 = 'isBold' {
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
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1013]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1014]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1015]);
	}
	
	(
		(
			a3 = 'isItalic' {
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
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1016]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1017]);
	}
	
	(
		(
			a6 = 'isStrike' {
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
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1018]);
	}
	
	a9 = 'Run' {
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
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1019]);
	}
	
	a10 = '{' {
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
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1020]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1021]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1022]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1023]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1024]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1025]);
	}
	
	(
		(
			(
				a11 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1026]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1027]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1028]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1029]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1030]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1031]);
			}
			
			
			|			(
				a12 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1032]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1033]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1034]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1035]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1036]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1037]);
			}
			
			
			|			(
				a13 = TEXT				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1038]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1039]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1040]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1041]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1042]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1043]);
			}
			
			
			|			(
				a14 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1044]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1045]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1046]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1047]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1048]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1049]);
			}
			
			
			|			(
				a15 = TEXT				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1050]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1051]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1052]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1053]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1054]);
				addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1055]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1056]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1057]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1058]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1059]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1060]);
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1061]);
	}
	
	a16 = '}' {
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
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Part returns [dk.itu.sdg.language.xwpf.Part element = null]
@init{
}
:
	a0 = 'Part' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createPart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_13_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1085]);
	}
	
	a1 = ';' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createPart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_13_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
;

parse_dk_itu_sdg_language_xwpf_Body returns [dk.itu.sdg.language.xwpf.Body element = null]
@init{
}
:
	a0 = 'Body' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createBody();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_14_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfExpectationConstants.EXPECTATIONS[1109]);
	}
	
	a1 = ';' {
		if (element == null) {
			element = dk.itu.sdg.language.xwpf.XwpfFactory.eINSTANCE.createBody();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfGrammarInformationProvider.XWPF_14_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
;

COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
INTEGER:
	(('-')?('1'..'9')('0'..'9')*|'0')
	{ _channel = 99; }
;
FLOAT:
	(('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ )
	{ _channel = 99; }
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

