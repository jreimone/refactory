/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

public class GueryResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements org.qualitune.guery.resource.guery.IGueryTextResource {
	
	public class ElementBasedTextDiagnostic implements org.qualitune.guery.resource.guery.IGueryTextDiagnostic {
		
		private final org.qualitune.guery.resource.guery.IGueryLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final org.qualitune.guery.resource.guery.IGueryProblem problem;
		
		public ElementBasedTextDiagnostic(org.qualitune.guery.resource.guery.IGueryLocationMap locationMap, org.eclipse.emf.common.util.URI uri, org.qualitune.guery.resource.guery.IGueryProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public org.qualitune.guery.resource.guery.IGueryProblem getProblem() {
			return problem;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public int getCharStart() {
			return Math.max(0, locationMap.getCharStart(element));
		}
		
		public int getCharEnd() {
			return Math.max(0, locationMap.getCharEnd(element));
		}
		
		public int getColumn() {
			return Math.max(0, locationMap.getColumn(element));
		}
		
		public int getLine() {
			return Math.max(0, locationMap.getLine(element));
		}
		
		public org.eclipse.emf.ecore.EObject getElement() {
			return element;
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			if (this.element == null) {
				return false;
			}
			return this.element.equals(element);
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	public class PositionBasedTextDiagnostic implements org.qualitune.guery.resource.guery.IGueryTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.qualitune.guery.resource.guery.IGueryProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, org.qualitune.guery.resource.guery.IGueryProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public org.qualitune.guery.resource.guery.IGueryProblem getProblem() {
			return problem;
		}
		
		public int getCharStart() {
			return charStart;
		}
		
		public int getCharEnd() {
			return charEnd;
		}
		
		public int getColumn() {
			return column;
		}
		
		public int getLine() {
			return line;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			return false;
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	private org.qualitune.guery.resource.guery.IGueryReferenceResolverSwitch resolverSwitch;
	private org.qualitune.guery.resource.guery.IGueryLocationMap locationMap;
	private int proxyCounter = 0;
	private org.qualitune.guery.resource.guery.IGueryTextParser parser;
	private java.util.Map<String, org.qualitune.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, org.qualitune.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, org.qualitune.guery.resource.guery.IGueryQuickFix> quickFixMap = new java.util.LinkedHashMap<String, org.qualitune.guery.resource.guery.IGueryQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private org.qualitune.guery.resource.guery.IGueryResourcePostProcessor runningPostProcessor;
	
	/**
	 * A flag to indicate whether reloading of the resource shall be cancelled.
	 */
	private boolean terminateReload = false;
	
	protected org.qualitune.guery.resource.guery.mopp.GueryMetaInformation metaInformation = new org.qualitune.guery.resource.guery.mopp.GueryMetaInformation();
	
	public GueryResource() {
		super();
		resetLocationMap();
	}
	
	public GueryResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		this.loadOptions = options;
		resetLocationMap();
		this.terminateReload = false;
		String encoding = getPlatformResourceEncoding();
		java.io.InputStream actualInputStream = inputStream;
		Object inputStreamPreProcessorProvider = null;
		if (options != null) {
			inputStreamPreProcessorProvider = options.get(org.qualitune.guery.resource.guery.IGueryOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		}
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.qualitune.guery.resource.guery.IGueryInputStreamProcessorProvider) {
				org.qualitune.guery.resource.guery.IGueryInputStreamProcessorProvider provider = (org.qualitune.guery.resource.guery.IGueryInputStreamProcessorProvider) inputStreamPreProcessorProvider;
				org.qualitune.guery.resource.guery.mopp.GueryInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
				actualInputStream = processor;
				encoding = processor.getOutputEncoding();
			}
		}
		
		parser = getMetaInformation().createParser(actualInputStream, encoding);
		parser.setOptions(options);
		org.qualitune.guery.resource.guery.IGueryReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		org.qualitune.guery.resource.guery.IGueryParseResult result = parser.parse();
		// dispose parser, we don't need it anymore
		parser = null;
		clearState();
		getContentsInternal().clear();
		org.eclipse.emf.ecore.EObject root = null;
		if (result != null) {
			root = result.getRoot();
			if (root != null) {
				getContentsInternal().add(root);
			}
			java.util.Collection<org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>> commands = result.getPostParseCommands();
			if (commands != null) {
				for (org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>  command : commands) {
					command.execute(this);
				}
			}
		}
		getReferenceResolverSwitch().setOptions(options);
		if (getErrors().isEmpty()) {
			runPostProcessors(options);
			if (root != null) {
				runValidators(root);
			}
		}
	}
	
	/**
	 * Reloads the contents of this resource from the given stream.
	 */
	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		try {
			isLoaded = false;
			java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
			doLoad(inputStream, loadOptions);
			resolveAfterParsing();
		} catch (org.qualitune.guery.resource.guery.mopp.GueryTerminateParsingException tpe) {
			// do nothing - the resource is left unchanged if this exception is thrown
		}
		isLoaded = true;
	}
	
	/**
	 * Cancels reloading this resource. The running parser and post processors are
	 * terminated.
	 */
	public void cancelReload() {
		org.qualitune.guery.resource.guery.IGueryTextParser parserCopy = parser;
		if (parserCopy != null) {
			parserCopy.terminate();
		}
		this.terminateReload = true;
		org.qualitune.guery.resource.guery.IGueryResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.qualitune.guery.resource.guery.IGueryTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		org.qualitune.guery.resource.guery.IGueryReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		for (org.eclipse.emf.ecore.EObject root : getContentsInternal()) {
			printer.print(root);
		}
	}
	
	protected String getSyntaxName() {
		return "guery";
	}
	
	public org.qualitune.guery.resource.guery.IGueryReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.qualitune.guery.resource.guery.mopp.GueryReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public org.qualitune.guery.resource.guery.mopp.GueryMetaInformation getMetaInformation() {
		return new org.qualitune.guery.resource.guery.mopp.GueryMetaInformation();
	}
	
	/**
	 * Clears the location map by replacing it with a new instance.
	 */
	protected void resetLocationMap() {
		if (isLocationMapEnabled()) {
			locationMap = new org.qualitune.guery.resource.guery.mopp.GueryLocationMap();
		} else {
			locationMap = new org.qualitune.guery.resource.guery.mopp.GueryDevNullLocationMap();
		}
	}
	
	public void addURIFragment(String internalURIFragment, org.qualitune.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.qualitune.guery.resource.guery.IGueryContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position) {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = org.qualitune.guery.resource.guery.IGueryContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.qualitune.guery.resource.guery.IGueryContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.qualitune.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.qualitune.guery.resource.guery.IGueryReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new org.qualitune.guery.resource.guery.mopp.GueryProblem(message, org.qualitune.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE, org.qualitune.guery.resource.guery.GueryEProblemSeverity.ERROR), uriFragment.getProxy());
				new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().logError(message, e);
			}
			if (result == null) {
				// the resolving did call itself
				return null;
			}
			if (!wasResolvedBefore && !result.wasResolved()) {
				attachResolveError(result, uriFragment.getProxy());
				return null;
			} else if (!result.wasResolved()) {
				return null;
			} else {
				org.eclipse.emf.ecore.EObject proxy = uriFragment.getProxy();
				// remove an error that might have been added by an earlier attempt
				removeDiagnostics(proxy, getErrors());
				// remove old warnings and attach new
				removeDiagnostics(proxy, getWarnings());
				attachResolveWarnings(result, proxy);
				org.qualitune.guery.resource.guery.IGueryReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
				org.eclipse.emf.ecore.EObject resultElement = getResultElement(uriFragment, mapping, proxy, result.getErrorMessage());
				org.eclipse.emf.ecore.EObject container = uriFragment.getContainer();
				replaceProxyInLayoutAdapters(container, proxy, resultElement);
				return resultElement;
			}
		} else {
			return super.getEObject(id);
		}
	}
	
	protected void replaceProxyInLayoutAdapters(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject proxy, org.eclipse.emf.ecore.EObject target) {
		for (org.eclipse.emf.common.notify.Adapter adapter : container.eAdapters()) {
			if (adapter instanceof org.qualitune.guery.resource.guery.mopp.GueryLayoutInformationAdapter) {
				org.qualitune.guery.resource.guery.mopp.GueryLayoutInformationAdapter layoutInformationAdapter = (org.qualitune.guery.resource.guery.mopp.GueryLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected org.eclipse.emf.ecore.EObject getResultElement(org.qualitune.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, org.qualitune.guery.resource.guery.IGueryReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof org.qualitune.guery.resource.guery.IGueryURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((org.qualitune.guery.resource.guery.IGueryURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
			if (uri != null) {
				org.eclipse.emf.ecore.EObject result = null;
				try {
					result = this.getResourceSet().getEObject(uri, true);
				} catch (Exception e) {
					// we can catch exceptions here, because EMF will try to resolve again and handle
					// the exception
				}
				if (result == null || result.eIsProxy()) {
					// unable to resolve: attach error
					if (errorMessage == null) {
						assert(false);
					} else {
						addProblem(new org.qualitune.guery.resource.guery.mopp.GueryProblem(errorMessage, org.qualitune.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE, org.qualitune.guery.resource.guery.GueryEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.qualitune.guery.resource.guery.IGueryElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((org.qualitune.guery.resource.guery.IGueryElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = org.qualitune.guery.resource.guery.util.GueryCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
					// oppositeReference
					list.basicAdd(uriFragment.getContainer(),null);
				} else {
					uriFragment.getContainer().eSet(uriFragment.getReference(), element);
				}
			}
			return element;
		} else {
			assert(false);
			return null;
		}
	}
	
	protected void removeDiagnostics(org.eclipse.emf.ecore.EObject cause, java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics) {
		// remove all errors/warnings from this resource
		for (org.eclipse.emf.ecore.resource.Resource.Diagnostic errorCand : new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(diagnostics)) {
			if (errorCand instanceof org.qualitune.guery.resource.guery.IGueryTextDiagnostic) {
				if (((org.qualitune.guery.resource.guery.IGueryTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					if (new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable()) {
						org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper.unmark(this, cause);
					}
				}
			}
		}
	}
	
	protected void attachResolveError(org.qualitune.guery.resource.guery.IGueryReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.qualitune.guery.resource.guery.mopp.GueryProblem(errorMessage, org.qualitune.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE, org.qualitune.guery.resource.guery.GueryEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(org.qualitune.guery.resource.guery.IGueryReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.qualitune.guery.resource.guery.IGueryReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.qualitune.guery.resource.guery.mopp.GueryProblem(warningMessage, org.qualitune.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE, org.qualitune.guery.resource.guery.GueryEProblemSeverity.WARNING), proxy);
			}
		}
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void doUnload() {
		super.doUnload();
		clearState();
		loadOptions = null;
	}
	
	/**
	 * Runs all post processors to process this resource.
	 */
	protected void runPostProcessors(java.util.Map<?, ?> loadOptions) {
		if (new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable()) {
			org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper.unmark(this, org.qualitune.guery.resource.guery.GueryEProblemType.ANALYSIS_PROBLEM);
		}
		if (terminateReload) {
			return;
		}
		// first, run the generated post processor
		runPostProcessor(new org.qualitune.guery.resource.guery.mopp.GueryResourcePostProcessor());
		if (loadOptions == null) {
			return;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(org.qualitune.guery.resource.guery.IGueryOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.qualitune.guery.resource.guery.IGueryResourcePostProcessorProvider) {
				runPostProcessor(((org.qualitune.guery.resource.guery.IGueryResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (terminateReload) {
						return;
					}
					if (processorProvider instanceof org.qualitune.guery.resource.guery.IGueryResourcePostProcessorProvider) {
						org.qualitune.guery.resource.guery.IGueryResourcePostProcessorProvider csProcessorProvider = (org.qualitune.guery.resource.guery.IGueryResourcePostProcessorProvider) processorProvider;
						org.qualitune.guery.resource.guery.IGueryResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						runPostProcessor(postProcessor);
					}
				}
			}
		}
	}
	
	/**
	 * Runs the given post processor to process this resource.
	 */
	protected void runPostProcessor(org.qualitune.guery.resource.guery.IGueryResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().logError("Exception while running a post-processor.", e);
		}
		this.runningPostProcessor = null;
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		resolveAfterParsing();
	}
	
	protected void resolveAfterParsing() {
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
	}
	
	public void setURI(org.eclipse.emf.common.util.URI uri) {
		// because of the context dependent proxy resolving it is essential to resolve all
		// proxies before the URI is changed which can cause loss of object identities
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	/**
	 * Returns the location map that contains information about the position of the
	 * contents of this resource in the original textual representation.
	 */
	public org.qualitune.guery.resource.guery.IGueryLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(org.qualitune.guery.resource.guery.IGueryProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		if (new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable() && isMarkerCreationEnabled()) {
			org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper.mark(this, diagnostic);
		}
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(org.qualitune.guery.resource.guery.IGueryProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		if (new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable() && isMarkerCreationEnabled()) {
			org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper.mark(this, diagnostic);
		}
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(org.qualitune.guery.resource.guery.IGueryProblem problem) {
		java.util.Collection<org.qualitune.guery.resource.guery.IGueryQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (org.qualitune.guery.resource.guery.IGueryQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addError(message, org.qualitune.guery.resource.guery.GueryEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, org.qualitune.guery.resource.guery.GueryEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.qualitune.guery.resource.guery.mopp.GueryProblem(message, type, org.qualitune.guery.resource.guery.GueryEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addWarning(message, org.qualitune.guery.resource.guery.GueryEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, org.qualitune.guery.resource.guery.GueryEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.qualitune.guery.resource.guery.mopp.GueryProblem(message, type, org.qualitune.guery.resource.guery.GueryEProblemSeverity.WARNING), cause);
	}
	
	protected java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(org.qualitune.guery.resource.guery.GueryEProblemSeverity severity) {
		if (severity == org.qualitune.guery.resource.guery.GueryEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = org.qualitune.guery.resource.guery.util.GueryMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new org.qualitune.guery.resource.guery.mopp.GueryOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.qualitune.guery.resource.guery.util.GueryEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
		}
		return loadOptionsCopy;
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void clearState() {
		// clear concrete syntax information
		resetLocationMap();
		internalURIFragmentMap.clear();
		getErrors().clear();
		getWarnings().clear();
		if (new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable() && isMarkerCreationEnabled()) {
			org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper.unmark(this, org.qualitune.guery.resource.guery.GueryEProblemType.UNKNOWN);
			org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper.unmark(this, org.qualitune.guery.resource.guery.GueryEProblemType.SYNTAX_ERROR);
			org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper.unmark(this, org.qualitune.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE);
		}
		proxyCounter = 0;
		resolverSwitch = null;
	}
	
	/**
	 * Returns a copy of the contents of this resource wrapped in a list that
	 * propagates changes to the original resource list. Wrapping is required to make
	 * sure that clients which obtain a reference to the list of contents do not
	 * interfere when changing the list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContents() {
		return new org.qualitune.guery.resource.guery.util.GueryCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}
	
	/**
	 * Returns the raw contents of this resource. In contrast to getContents(), this
	 * methods does not return a copy of the content list, but the original list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContentsInternal() {
		return super.getContents();
	}
	
	/**
	 * Returns all warnings that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		return new org.qualitune.guery.resource.guery.util.GueryCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	/**
	 * Returns all errors that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		return new org.qualitune.guery.resource.guery.util.GueryCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	protected void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		if (new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.qualitune.guery.resource.guery.util.GueryEclipseProxy().checkEMFValidationConstraints(this, root);
		}
	}
	
	public org.qualitune.guery.resource.guery.IGueryQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.qualitune.guery.resource.guery.IGueryOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
	}
	
	protected boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.qualitune.guery.resource.guery.IGueryOptions.DISABLE_LOCATION_MAP);
	}
	
	/**
	 * Returns the encoding for this resource that is specified in the workspace file
	 * properties or determined by the default workspace encoding in Eclipse.
	 */
	protected String getPlatformResourceEncoding() {
		// We can't determine the encoding if the platform is not running.
		if (!new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformRunning()) {
			return null;
		}
		if (uri != null && uri.isPlatform()) {
			String platformString = uri.toPlatformString(true);
			org.eclipse.core.resources.IResource platformResource = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (platformResource instanceof org.eclipse.core.resources.IFile) {
				org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) platformResource;
				try {
					return file.getCharset();
				} catch (org.eclipse.core.runtime.CoreException ce) {
					new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().logWarning("Could not determine encoding of platform resource: " + uri.toString(), ce);
				}
			}
		}
		return null;
	}
	
}
