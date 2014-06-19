grammar Operators;

options {
	superClass = OperatorsANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.modelrefactoring.evolution.operators.resource.operators.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;
}

@lexer::members {
	public List<RecognitionException> lexerExceptions  = new ArrayList<RecognitionException>();
	public List<Integer> lexerExceptionPositions = new ArrayList<Integer>();
	
	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionPositions.add(((ANTLRStringStream) input).index());
	}
}
@header{
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
}

@members{
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
	
}

start returns [ EObject element = null]
:
	{
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
	(
		c0 = parse_org_modelrefactoring_evolution_operators_CREATE{ element = c0; }
		|  		c1 = parse_org_modelrefactoring_evolution_operators_DELETE{ element = c1; }
		|  		c2 = parse_org_modelrefactoring_evolution_operators_ASSIGN{ element = c2; }
		|  		c3 = parse_org_modelrefactoring_evolution_operators_SET{ element = c3; }
		|  		c4 = parse_org_modelrefactoring_evolution_operators_MOVE{ element = c4; }
		|  		c5 = parse_org_modelrefactoring_evolution_operators_VAR{ element = c5; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_modelrefactoring_evolution_operators_EObjectReference returns [org.modelrefactoring.evolution.operators.EObjectReference element = null]
@init{
}
:
	(
		a0 = QUOTED_60_62		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[8]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[13]);
	}
	
	(
		(
			a1 = ',' {
				if (element == null) {
					element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createEObjectReference();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_0_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[14]);
			}
			
			(
				a2 = QUOTED_60_62				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[15]);
				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[17]);
				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[18]);
				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[19]);
				addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[20]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[22]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[26]);
	}
	
;

parse_org_modelrefactoring_evolution_operators_VariableReference returns [org.modelrefactoring.evolution.operators.VariableReference element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[31]);
	}
	
;

parse_org_modelrefactoring_evolution_operators_VAR returns [org.modelrefactoring.evolution.operators.VAR element = null]
@init{
}
:
	a0 = 'var' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createVAR();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_2_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVAR(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[32]);
	}
	
	(
		a1_0 = parse_org_modelrefactoring_evolution_operators_QueryVariable		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_modelrefactoring_evolution_operators_QueryVariable returns [org.modelrefactoring.evolution.operators.QueryVariable element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[33]);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createQueryVariable();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[35]);
	}
	
	(
		a2_0 = parse_org_modelrefactoring_evolution_operators_Referrable		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[36]);
	}
	
	a3 = '.' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createQueryVariable();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_3_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[38]);
	}
	
	(
		a4_0 = parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_modelrefactoring_evolution_operators_EReferenceQualifier returns [org.modelrefactoring.evolution.operators.EReferenceQualifier element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_modelrefactoring_evolution_operators_EOperationQualifier returns [org.modelrefactoring.evolution.operators.EOperationQualifier element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_modelrefactoring_evolution_operators_CREATE returns [org.modelrefactoring.evolution.operators.CREATE element = null]
@init{
}
:
	a0 = 'create' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createCREATE();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_6_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[39]);
	}
	
	(
		a1_0 = parse_org_modelrefactoring_evolution_operators_TypeVariable		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[40]);
	}
	
	a2 = 'in' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createCREATE();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_6_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[41]);
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[42]);
	}
	
	(
		a3_0 = parse_org_modelrefactoring_evolution_operators_Referrable		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[43]);
	}
	
	a4 = '.' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createCREATE();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_6_0_0_7, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[44]);
	}
	
	(
		a5 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_modelrefactoring_evolution_operators_TypeVariable returns [org.modelrefactoring.evolution.operators.TypeVariable element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[45]);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createTypeVariable();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_7_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[46]);
	}
	
	a2 = 'new' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createTypeVariable();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_7_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[47]);
	}
	
	(
		a3 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[48]);
	}
	
;

parse_org_modelrefactoring_evolution_operators_DELETE returns [org.modelrefactoring.evolution.operators.DELETE element = null]
@init{
}
:
	a0 = 'delete' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createDELETE();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_8_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getDELETE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getDELETE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[50]);
	}
	
	(
		a1_0 = parse_org_modelrefactoring_evolution_operators_Referrable		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_modelrefactoring_evolution_operators_ASSIGN returns [org.modelrefactoring.evolution.operators.ASSIGN element = null]
@init{
}
:
	(
		a0_0 = parse_org_modelrefactoring_evolution_operators_Referrable		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[51]);
	}
	
	a1 = '.' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createASSIGN();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_9_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[52]);
	}
	
	(
		a2 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[53]);
	}
	
	a3 = '=' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createASSIGN();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_9_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[54]);
	}
	
	(
		a4 = QUOTED_34_34		
		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_modelrefactoring_evolution_operators_SET returns [org.modelrefactoring.evolution.operators.SET element = null]
@init{
}
:
	(
		a0_0 = parse_org_modelrefactoring_evolution_operators_Referrable		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[55]);
	}
	
	a1 = '.' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createSET();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_10_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[56]);
	}
	
	(
		a2 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[57]);
	}
	
	a3 = '=' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createSET();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_10_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[58]);
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[59]);
	}
	
	(
		a4_0 = parse_org_modelrefactoring_evolution_operators_Referrable		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_modelrefactoring_evolution_operators_MOVE returns [org.modelrefactoring.evolution.operators.MOVE element = null]
@init{
}
:
	a0 = 'move' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createMOVE();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_11_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[61]);
	}
	
	(
		a1_0 = parse_org_modelrefactoring_evolution_operators_Referrable		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[62]);
	}
	
	a2 = 'to' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createMOVE();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_11_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(), org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[64]);
	}
	
	(
		a3_0 = parse_org_modelrefactoring_evolution_operators_Referrable		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[65]);
	}
	
	a4 = '.' {
		if (element == null) {
			element = org.modelrefactoring.evolution.operators.OperatorsFactory.eINSTANCE.createMOVE();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.OPERATORS_11_0_0_8, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsExpectationConstants.EXPECTATIONS[66]);
	}
	
	(
		a5 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_modelrefactoring_evolution_operators_Referrable returns [org.modelrefactoring.evolution.operators.Referrable element = null]
:
	c0 = parse_org_modelrefactoring_evolution_operators_EObjectReference{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_modelrefactoring_evolution_operators_VariableReference{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_modelrefactoring_evolution_operators_QueryVariableQualifier returns [org.modelrefactoring.evolution.operators.QueryVariableQualifier element = null]
:
	c0 = parse_org_modelrefactoring_evolution_operators_EReferenceQualifier{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_modelrefactoring_evolution_operators_EOperationQualifier{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

IDENTIFIER:
	(('A'..'Z' | 'a'..'z')('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*)
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
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
SL_COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
ML_COMMENT:
	('/*'(.*)'*/')
	{ _channel = 99; }
;
QUOTED_60_62:
	(('<')(~('>'))*('>'))
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

