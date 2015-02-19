grammar Refcomp;

options {
	superClass = RefcompANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.refactoring.composition.resource.mopp;
	
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
	package org.emftext.language.refactoring.composition.resource.mopp;
	
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
	private org.emftext.language.refactoring.composition.resource.IRefcompTokenResolverFactory tokenResolverFactory = new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenResolverFactory();
	
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
	private List<org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal> expectedElements = new ArrayList<org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal>();
	
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
	List<EObject> incompleteObjects = new ArrayList<EObject>();
	
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
	
	private org.emftext.language.refactoring.composition.resource.IRefcompLocationMap locationMap;
	
	private org.emftext.language.refactoring.composition.resource.mopp.RefcompSyntaxErrorMessageConverter syntaxErrorMessageConverter = new org.emftext.language.refactoring.composition.resource.mopp.RefcompSyntaxErrorMessageConverter(tokenNames);
	
	@Override
	public void reportError(RecognitionException re) {
		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
	}
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource>() {
			public boolean execute(org.emftext.language.refactoring.composition.resource.IRefcompTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.emftext.language.refactoring.composition.resource.IRefcompProblem() {
					public org.emftext.language.refactoring.composition.resource.RefcompEProblemSeverity getSeverity() {
						return org.emftext.language.refactoring.composition.resource.RefcompEProblemSeverity.ERROR;
					}
					public org.emftext.language.refactoring.composition.resource.RefcompEProblemType getType() {
						return org.emftext.language.refactoring.composition.resource.RefcompEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public Collection<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	protected void addErrorToResource(org.emftext.language.refactoring.composition.resource.mopp.RefcompLocalizedMessage message) {
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
		org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement terminal = org.emftext.language.refactoring.composition.resource.grammar.RefcompFollowSetProvider.TERMINALS[terminalID];
		org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[] containmentFeatures = new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.emftext.language.refactoring.composition.resource.grammar.RefcompFollowSetProvider.LINKS[ids[i]];
		}
		org.emftext.language.refactoring.composition.resource.grammar.RefcompContainmentTrace containmentTrace = new org.emftext.language.refactoring.composition.resource.grammar.RefcompContainmentTrace(eClass, containmentFeatures);
		EObject container = getLastIncompleteElement();
		org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal expectedElement = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		final org.emftext.language.refactoring.composition.resource.IRefcompLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource>() {
			public boolean execute(org.emftext.language.refactoring.composition.resource.IRefcompTextResource resource) {
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
		final org.emftext.language.refactoring.composition.resource.IRefcompLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource>() {
			public boolean execute(org.emftext.language.refactoring.composition.resource.IRefcompTextResource resource) {
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
	protected void setLocalizationEnd(Collection<org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		final org.emftext.language.refactoring.composition.resource.IRefcompLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource>() {
			public boolean execute(org.emftext.language.refactoring.composition.resource.IRefcompTextResource resource) {
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTextParser createInstance(InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new RefcompParser(new CommonTokenStream(new RefcompLexer(new ANTLRInputStream(actualInputStream))));
			} else {
				return new RefcompParser(new CommonTokenStream(new RefcompLexer(new ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (IOException e) {
			new org.emftext.language.refactoring.composition.resource.util.RefcompRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public RefcompParser() {
		super(null);
	}
	
	protected EObject doParse() throws RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((RefcompLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((RefcompLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping.class) {
				return parse_org_emftext_language_refactoring_refactoringcomposition_CompositeRoleMapping();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping.class) {
				return parse_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping();
			}
			if (type.getInstanceClass() == org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding.class) {
				return parse_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding();
			}
		}
		throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(org.emftext.language.refactoring.composition.resource.IRefcompOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.emftext.language.refactoring.composition.resource.IRefcompParseResult parse() {
		// Reset parser state
		terminateParsing = false;
		postParseCommands = new ArrayList<org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource>>();
		org.emftext.language.refactoring.composition.resource.mopp.RefcompParseResult parseResult = new org.emftext.language.refactoring.composition.resource.mopp.RefcompParseResult();
		if (disableLocationMap) {
			locationMap = new org.emftext.language.refactoring.composition.resource.mopp.RefcompDevNullLocationMap();
		} else {
			locationMap = new org.emftext.language.refactoring.composition.resource.mopp.RefcompLocationMap();
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
	
	public List<org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal> parseToExpectedElements(EClass type, org.emftext.language.refactoring.composition.resource.IRefcompTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
		org.emftext.language.refactoring.composition.resource.IRefcompParseResult result = parse();
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
			for (org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		Set<org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal> currentFollowSet = new LinkedHashSet<org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal>();
		List<org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal> newFollowSet = new ArrayList<org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 26;
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
				for (org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						Collection<org.emftext.language.refactoring.composition.resource.util.RefcompPair<org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement, org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.language.refactoring.composition.resource.util.RefcompPair<org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement, org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[]> newFollowerPair : newFollowers) {
							org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement newFollower = newFollowerPair.getLeft();
							EObject container = getLastIncompleteElement();
							org.emftext.language.refactoring.composition.resource.grammar.RefcompContainmentTrace containmentTrace = new org.emftext.language.refactoring.composition.resource.grammar.RefcompContainmentTrace(null, newFollowerPair.getRight());
							org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal newFollowTerminal = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_emftext_language_refactoring_refactoringcomposition_CompositeRoleMapping{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_emftext_language_refactoring_refactoringcomposition_CompositeRoleMapping returns [org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping element = null]
@init{
}
:
	a0 = 'COMPOSITE' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createCompositeRoleMapping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = 'REFACTORING' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createCompositeRoleMapping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[2]);
	}
	
	(
		a2 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createCompositeRoleMapping();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_4, resolved, true);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[3]);
	}
	
	a3 = 'FOR' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createCompositeRoleMapping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[4]);
	}
	
	(
		a4 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createCompositeRoleMapping();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EPackage proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.composition.resource.mopp.RefcompContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping, org.eclipse.emf.ecore.EPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeRoleMappingTargetMetamodelReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_8, proxy, true);
				copyLocalizationInfos((CommonToken) a4, element);
				copyLocalizationInfos((CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[5]);
	}
	
	(
		a5 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createCompositeRoleMapping();
				startIncompleteElement(element);
			}
			if (a5 != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.rolemapping.RoleMapping proxy = org.emftext.language.refactoring.rolemapping.RolemappingFactory.eINSTANCE.createRoleMapping();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.composition.resource.mopp.RefcompContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping, org.emftext.language.refactoring.rolemapping.RoleMapping>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeRoleMappingFirstReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_11, proxy, true);
				copyLocalizationInfos((CommonToken) a5, element);
				copyLocalizationInfos((CommonToken) a5, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping(), org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[6]);
	}
	
	(
		a6_0 = parse_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createCompositeRoleMapping();
				startIncompleteElement(element);
			}
			if (a6_0 != null) {
				if (a6_0 != null) {
					Object value = a6_0;
					addObjectToList(element, org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_13, a6_0, true);
				copyLocalizationInfos(a6_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping returns [org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping element = null]
@init{
}
:
	a0 = '->' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createBoundRoleMapping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[7]);
	}
	
	(
		a1 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createBoundRoleMapping();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.rolemapping.RoleMapping proxy = org.emftext.language.refactoring.rolemapping.RolemappingFactory.eINSTANCE.createRoleMapping();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.composition.resource.mopp.RefcompContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping, org.emftext.language.refactoring.rolemapping.RoleMapping>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getBoundRoleMappingRoleMappingReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a1, element);
				copyLocalizationInfos((CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[8]);
		addExpectedElement(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[9]);
	}
	
	(
		(
			a2 = '{' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createBoundRoleMapping();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[10]);
				addExpectedElement(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[11]);
			}
			
			(
				a3_0 = parse_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createBoundRoleMapping();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_4_0_0_2, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[12]);
			}
			
			a4 = '}' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createBoundRoleMapping();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_4_0_0_4, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[13]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[14]);
	}
	
	(
		(
			(
				a5_0 = parse_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createBoundRoleMapping();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_5_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
			}
			
		)
		
	)?	{
		// expected elements (follow set)
	}
	
;

parse_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding returns [org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding element = null]
@init{
}
:
	(
		(
			(
				a0 = QUOTED_60_62				
				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createSourceTargetBinding();
						startIncompleteElement(element);
					}
					if (a0 != null) {
						org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.refactoring.composition.resource.IRefcompTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.language.refactoring.roles.RoleModel proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.language.refactoring.composition.resource.mopp.RefcompContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding, org.emftext.language.refactoring.roles.RoleModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSourceTargetBindingSourceRoleModelReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_0_0_0_0, proxy, true);
						copyLocalizationInfos((CommonToken) a0, element);
						copyLocalizationInfos((CommonToken) a0, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[15]);
			}
			
			a1 = '.' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createSourceTargetBinding();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_0_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[16]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[17]);
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createSourceTargetBinding();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.composition.resource.mopp.RefcompContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSourceTargetBindingSourceReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_1, proxy, true);
				copyLocalizationInfos((CommonToken) a2, element);
				copyLocalizationInfos((CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[18]);
	}
	
	a3 = '=' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createSourceTargetBinding();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[20]);
	}
	
	(
		(
			(
				a4 = QUOTED_60_62				
				{
					if (terminateParsing) {
						throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createSourceTargetBinding();
						startIncompleteElement(element);
					}
					if (a4 != null) {
						org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.refactoring.composition.resource.IRefcompTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.language.refactoring.roles.RoleModel proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRoleModel();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.language.refactoring.composition.resource.mopp.RefcompContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding, org.emftext.language.refactoring.roles.RoleModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSourceTargetBindingTargetRoleModelReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_5_0_0_0, proxy, true);
						copyLocalizationInfos((CommonToken) a4, element);
						copyLocalizationInfos((CommonToken) a4, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[21]);
			}
			
			a5 = '.' {
				if (element == null) {
					element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createSourceTargetBinding();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_5_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[22]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[23]);
	}
	
	(
		a6 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.refactoring.composition.resource.mopp.RefcompTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createSourceTargetBinding();
				startIncompleteElement(element);
			}
			if (a6 != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.refactoring.roles.Role proxy = org.emftext.language.refactoring.roles.RolesFactory.eINSTANCE.createRole();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.refactoring.composition.resource.mopp.RefcompContextDependentURIFragmentFactory<org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding, org.emftext.language.refactoring.roles.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSourceTargetBindingTargetReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_6, proxy, true);
				copyLocalizationInfos((CommonToken) a6, element);
				copyLocalizationInfos((CommonToken) a6, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[24]);
	}
	
	a7 = ';' {
		if (element == null) {
			element = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory.eINSTANCE.createSourceTargetBinding();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_7, null, true);
		copyLocalizationInfos((CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectationConstants.EXPECTATIONS[25]);
	}
	
;

IDENTIFIER:
	(('A'..'Z' | 'a'..'z' | '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*)
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
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;
QUOTED_60_62:
	(('<')(~('>'))*('>'))
;

