/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements org.modelrefactoring.guery.resource.guery.IGueryTextResource {
	
	public class ElementBasedTextDiagnostic implements org.modelrefactoring.guery.resource.guery.IGueryTextDiagnostic {
		
		private final org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final org.modelrefactoring.guery.resource.guery.IGueryProblem problem;
		
		public ElementBasedTextDiagnostic(org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap, org.eclipse.emf.common.util.URI uri, org.modelrefactoring.guery.resource.guery.IGueryProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public org.modelrefactoring.guery.resource.guery.IGueryProblem getProblem() {
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
	
	public class PositionBasedTextDiagnostic implements org.modelrefactoring.guery.resource.guery.IGueryTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.modelrefactoring.guery.resource.guery.IGueryProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, org.modelrefactoring.guery.resource.guery.IGueryProblem problem, int column, int line, int charStart, int charEnd) {
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public org.modelrefactoring.guery.resource.guery.IGueryProblem getProblem() {
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
	
	private org.modelrefactoring.guery.resource.guery.IGueryReferenceResolverSwitch resolverSwitch;
	private org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap;
	private int proxyCounter = 0;
	private org.modelrefactoring.guery.resource.guery.IGueryTextParser parser;
	private org.modelrefactoring.guery.resource.guery.util.GueryLayoutUtil layoutUtil = new org.modelrefactoring.guery.resource.guery.util.GueryLayoutUtil();
	private org.modelrefactoring.guery.resource.guery.mopp.GueryMarkerHelper markerHelper;
	private java.util.Map<String, org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, org.modelrefactoring.guery.resource.guery.IGueryQuickFix> quickFixMap = new java.util.LinkedHashMap<String, org.modelrefactoring.guery.resource.guery.IGueryQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessor runningPostProcessor;
	
	/**
	 * A flag (and lock) to indicate whether reloading of the resource shall be
	 * cancelled.
	 */
	private Boolean terminateReload = false;
	private Object terminateReloadLock = new Object();
	private Object loadingLock = new Object();
	private boolean delayNotifications = false;
	private java.util.List<org.eclipse.emf.common.notify.Notification> delayedNotifications = new java.util.ArrayList<org.eclipse.emf.common.notify.Notification>();
	private java.io.InputStream latestReloadInputStream = null;
	private java.util.Map<?, ?> latestReloadOptions = null;
	
	/**
	 * This flag indicates whether this resource is currently reloaded. The flag is
	 * set and unset in the reload() method and used to decide what kinds of
	 * constraints (live or batch) need to be evaluated. This decision is made in
	 * runValidators().
	 */
	private boolean isReloading = false;
	private org.modelrefactoring.guery.resource.guery.util.GueryInterruptibleEcoreResolver interruptibleResolver;
	
	protected org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation metaInformation = new org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation();
	
	public GueryResource() {
		super();
		resetLocationMap();
	}
	
	public GueryResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		synchronized (loadingLock) {
			if (processTerminationRequested()) {
				return;
			}
			this.loadOptions = options;
			delayNotifications = true;
			resetLocationMap();
			String encoding = getEncoding(options);
			java.io.InputStream actualInputStream = inputStream;
			Object inputStreamPreProcessorProvider = null;
			if (options != null) {
				inputStreamPreProcessorProvider = options.get(org.modelrefactoring.guery.resource.guery.IGueryOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
			}
			if (inputStreamPreProcessorProvider != null) {
				if (inputStreamPreProcessorProvider instanceof org.modelrefactoring.guery.resource.guery.IGueryInputStreamProcessorProvider) {
					org.modelrefactoring.guery.resource.guery.IGueryInputStreamProcessorProvider provider = (org.modelrefactoring.guery.resource.guery.IGueryInputStreamProcessorProvider) inputStreamPreProcessorProvider;
					org.modelrefactoring.guery.resource.guery.mopp.GueryInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
					actualInputStream = processor;
				}
			}
			
			// We store the parser instance in a field instead of a local variable, because we
			// may need to terminate the parser from another thread.
			parser = getMetaInformation().createParser(actualInputStream, encoding);
			parser.setOptions(options);
			org.modelrefactoring.guery.resource.guery.IGueryReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
			referenceResolverSwitch.setOptions(options);
			org.modelrefactoring.guery.resource.guery.IGueryParseResult result = parser.parse();
			// dispose parser, we don't need it anymore
			parser = null;
			
			if (processTerminationRequested()) {
				// do nothing if reload was already restarted
				return;
			}
			
			clearState();
			unloadAndClearContents();
			// We must set the load options again since they are deleted by the unload()
			// method.
			this.loadOptions = options;
			org.eclipse.emf.ecore.EObject root = null;
			if (result != null) {
				root = result.getRoot();
				if (root != null) {
					org.modelrefactoring.guery.resource.guery.IGueryLocationMap newLocationMap = result.getLocationMap();
					if (newLocationMap != null) {
						this.locationMap = newLocationMap;
					}
					if (isLayoutInformationRecordingEnabled()) {
						layoutUtil.transferAllLayoutInformationToModel(root);
					}
					if (processTerminationRequested()) {
						// the next reload will add new content
						return;
					}
					getContentsInternal().add(root);
				}
				java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>> commands = result.getPostParseCommands();
				if (commands != null) {
					for (org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>  command : commands) {
						command.execute(this);
					}
				}
			}
			getReferenceResolverSwitch().setOptions(options);
			if (getErrors().isEmpty()) {
				if (!runPostProcessors(options)) {
					return;
				}
				if (root != null) {
					runValidators(root);
				}
			}
			notifyDelayed();
		}
	}
	
	protected void unloadAndClearContents() {
		java.util.List<org.eclipse.emf.ecore.EObject> contentsInternal = getContentsInternal();
		// unload the root objects
		for (org.eclipse.emf.ecore.EObject eObject : contentsInternal) {
			if (eObject instanceof org.eclipse.emf.ecore.InternalEObject) {
				unloaded((org.eclipse.emf.ecore.InternalEObject) eObject);
			}
		}
		// unload all children using the super class method
		unload();
		// now we can clear the contents
		contentsInternal.clear();
	}
	
	protected boolean processTerminationRequested() {
		if (terminateReload) {
			delayNotifications = false;
			delayedNotifications.clear();
			return true;
		}
		return false;
	}
	
	protected void notifyDelayed() {
		delayNotifications = false;
		for (org.eclipse.emf.common.notify.Notification delayedNotification : delayedNotifications) {
			super.eNotify(delayedNotification);
		}
		delayedNotifications.clear();
	}
	
	public void eNotify(org.eclipse.emf.common.notify.Notification notification) {
		if (delayNotifications) {
			delayedNotifications.add(notification);
		} else {
			super.eNotify(notification);
		}
	}
	
	/**
	 * Reloads the contents of this resource from the given stream.
	 */
	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		synchronized (terminateReloadLock) {
			latestReloadInputStream = inputStream;
			latestReloadOptions = options;
			if (terminateReload == true) {
				// reload already requested
			}
			terminateReload = true;
		}
		cancelReload();
		synchronized (loadingLock) {
			synchronized (terminateReloadLock) {
				terminateReload = false;
			}
			isLoaded = false;
			java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(latestReloadOptions);
			try {
				// Set isReloading flag to allow other method to differentiate between loading and
				// reloading.
				this.isReloading = true;
				doLoad(latestReloadInputStream, loadOptions);
			} catch (org.modelrefactoring.guery.resource.guery.mopp.GueryTerminateParsingException tpe) {
				// do nothing - the resource is left unchanged if this exception is thrown
			}
			this.isReloading = false;
			resolveAfterParsing();
			isLoaded = true;
		}
	}
	
	/**
	 * Cancels reloading this resource. The running parser and post processors are
	 * terminated.
	 */
	protected void cancelReload() {
		// Cancel parser
		org.modelrefactoring.guery.resource.guery.IGueryTextParser parserCopy = parser;
		if (parserCopy != null) {
			parserCopy.terminate();
		}
		// Cancel post processor(s)
		org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
		// Cancel reference resolving
		org.modelrefactoring.guery.resource.guery.util.GueryInterruptibleEcoreResolver interruptibleResolverCopy = interruptibleResolver;
		if (interruptibleResolverCopy != null) {
			interruptibleResolverCopy.terminate();
		}
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.modelrefactoring.guery.resource.guery.IGueryTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		org.modelrefactoring.guery.resource.guery.IGueryReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		printer.setEncoding(getEncoding(options));
		printer.setOptions(options);
		referenceResolverSwitch.setOptions(options);
		for (org.eclipse.emf.ecore.EObject root : getContentsInternal()) {
			if (isLayoutInformationRecordingEnabled()) {
				layoutUtil.transferAllLayoutInformationFromModel(root);
			}
			printer.print(root);
			if (isLayoutInformationRecordingEnabled()) {
				layoutUtil.transferAllLayoutInformationToModel(root);
			}
		}
	}
	
	protected String getSyntaxName() {
		return "guery";
	}
	
	public String getEncoding(java.util.Map<?, ?> options) {
		String encoding = null;
		if (new org.modelrefactoring.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable()) {
			encoding = new org.modelrefactoring.guery.resource.guery.util.GueryEclipseProxy().getPlatformResourceEncoding(uri);
		}
		if (options != null) {
			Object encodingOption = options.get(org.modelrefactoring.guery.resource.guery.IGueryOptions.OPTION_ENCODING);
			if (encodingOption != null) {
				encoding = encodingOption.toString();
			}
		}
		return encoding;
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.modelrefactoring.guery.resource.guery.mopp.GueryReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation getMetaInformation() {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation();
	}
	
	/**
	 * Clears the location map by replacing it with a new instance.
	 */
	protected void resetLocationMap() {
		// Although, the location map is obtained from the parser after every parse run,
		// we initialize it here to avoid null pointer exceptions.
		locationMap = new org.modelrefactoring.guery.resource.guery.mopp.GueryLocationMap();
	}
	
	public void addURIFragment(String internalURIFragment, org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position) {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.modelrefactoring.guery.resource.guery.IGueryReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new org.modelrefactoring.guery.resource.guery.mopp.GueryProblem(message, org.modelrefactoring.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity.ERROR), uriFragment.getProxy());
				new org.modelrefactoring.guery.resource.guery.util.GueryRuntimeUtil().logError(message, e);
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
				org.modelrefactoring.guery.resource.guery.IGueryReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
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
			if (adapter instanceof org.modelrefactoring.guery.resource.guery.mopp.GueryLayoutInformationAdapter) {
				org.modelrefactoring.guery.resource.guery.mopp.GueryLayoutInformationAdapter layoutInformationAdapter = (org.modelrefactoring.guery.resource.guery.mopp.GueryLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected org.eclipse.emf.ecore.EObject getResultElement(org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, org.modelrefactoring.guery.resource.guery.IGueryReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof org.modelrefactoring.guery.resource.guery.IGueryURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((org.modelrefactoring.guery.resource.guery.IGueryURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
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
						addProblem(new org.modelrefactoring.guery.resource.guery.mopp.GueryProblem(errorMessage, org.modelrefactoring.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.modelrefactoring.guery.resource.guery.IGueryElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((org.modelrefactoring.guery.resource.guery.IGueryElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = org.modelrefactoring.guery.resource.guery.util.GueryCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
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
			if (errorCand instanceof org.modelrefactoring.guery.resource.guery.IGueryTextDiagnostic) {
				if (((org.modelrefactoring.guery.resource.guery.IGueryTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					unmark(cause);
				}
			}
		}
	}
	
	protected void attachResolveError(org.modelrefactoring.guery.resource.guery.IGueryReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.modelrefactoring.guery.resource.guery.mopp.GueryProblem(errorMessage, org.modelrefactoring.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(org.modelrefactoring.guery.resource.guery.IGueryReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.modelrefactoring.guery.resource.guery.IGueryReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.modelrefactoring.guery.resource.guery.mopp.GueryProblem(warningMessage, org.modelrefactoring.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity.WARNING), proxy);
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
	protected boolean runPostProcessors(java.util.Map<?, ?> loadOptions) {
		unmark(org.modelrefactoring.guery.resource.guery.GueryEProblemType.ANALYSIS_PROBLEM);
		if (processTerminationRequested()) {
			return false;
		}
		// first, run the generated post processor
		runPostProcessor(new org.modelrefactoring.guery.resource.guery.mopp.GueryResourcePostProcessor());
		if (loadOptions == null) {
			return true;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(org.modelrefactoring.guery.resource.guery.IGueryOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessorProvider) {
				runPostProcessor(((org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processTerminationRequested()) {
						return false;
					}
					if (processorProvider instanceof org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessorProvider) {
						org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessorProvider csProcessorProvider = (org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessorProvider) processorProvider;
						org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						runPostProcessor(postProcessor);
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Runs the given post processor to process this resource.
	 */
	protected void runPostProcessor(org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new org.modelrefactoring.guery.resource.guery.util.GueryRuntimeUtil().logError("Exception while running a post-processor.", e);
		}
		this.runningPostProcessor = null;
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		resolveAfterParsing();
	}
	
	protected void resolveAfterParsing() {
		interruptibleResolver = new org.modelrefactoring.guery.resource.guery.util.GueryInterruptibleEcoreResolver();
		interruptibleResolver.resolveAll(this);
		interruptibleResolver = null;
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
	public org.modelrefactoring.guery.resource.guery.IGueryLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(org.modelrefactoring.guery.resource.guery.IGueryProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(org.modelrefactoring.guery.resource.guery.IGueryProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(org.modelrefactoring.guery.resource.guery.IGueryProblem problem) {
		java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (org.modelrefactoring.guery.resource.guery.IGueryQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addError(message, org.modelrefactoring.guery.resource.guery.GueryEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, org.modelrefactoring.guery.resource.guery.GueryEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.modelrefactoring.guery.resource.guery.mopp.GueryProblem(message, type, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addWarning(message, org.modelrefactoring.guery.resource.guery.GueryEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, org.modelrefactoring.guery.resource.guery.GueryEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.modelrefactoring.guery.resource.guery.mopp.GueryProblem(message, type, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity.WARNING), cause);
	}
	
	protected java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity severity) {
		if (severity == org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = org.modelrefactoring.guery.resource.guery.util.GueryMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new org.modelrefactoring.guery.resource.guery.mopp.GueryOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new org.modelrefactoring.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.modelrefactoring.guery.resource.guery.util.GueryEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
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
		// Remove temporary markers
		unmark(org.modelrefactoring.guery.resource.guery.GueryEProblemType.UNKNOWN);
		unmark(org.modelrefactoring.guery.resource.guery.GueryEProblemType.SYNTAX_ERROR);
		unmark(org.modelrefactoring.guery.resource.guery.GueryEProblemType.UNRESOLVED_REFERENCE);
		unmark(org.modelrefactoring.guery.resource.guery.GueryEProblemType.LIVE_CONSTRAINT_PROBLEM);
		// If the resource is reloaded, we do not remove the problems that were detected
		// by batch constraints. This ensures that we can see the problems while typing.
		// The problems might get out dated because of the ongoing modifications, but they
		// will be updated (i.e., deleted and recreated) the next time the resource is
		// saved (and loaded again).
		if (!isReloading) {
			unmark(org.modelrefactoring.guery.resource.guery.GueryEProblemType.BATCH_CONSTRAINT_PROBLEM);
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
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.EObject>();
		}
		return new org.modelrefactoring.guery.resource.guery.util.GueryCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}
	
	/**
	 * Returns the raw contents of this resource. In contrast to getContents(), this
	 * methods does not return a copy of the content list, but the original list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContentsInternal() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.EObject>();
		}
		return super.getContents();
	}
	
	/**
	 * Returns all warnings that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new org.modelrefactoring.guery.resource.guery.util.GueryCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	/**
	 * Returns all errors that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new org.modelrefactoring.guery.resource.guery.util.GueryCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	protected void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		if (new org.modelrefactoring.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable()) {
			// We do only evaluate batch constraints when the resource is loaded for the first
			// time. If the resource is reloaded, only live constraints are evaluated.
			boolean includeBatchConstraints = !this.isReloading;
			new org.modelrefactoring.guery.resource.guery.util.GueryEclipseProxy().checkEMFValidationConstraints(this, root, includeBatchConstraints);
		}
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	protected void mark(org.modelrefactoring.guery.resource.guery.IGueryTextDiagnostic diagnostic) {
		org.modelrefactoring.guery.resource.guery.mopp.GueryMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.mark(this, diagnostic);
		}
	}
	
	protected void unmark(org.eclipse.emf.ecore.EObject cause) {
		org.modelrefactoring.guery.resource.guery.mopp.GueryMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, cause);
		}
	}
	
	protected void unmark(org.modelrefactoring.guery.resource.guery.GueryEProblemType analysisProblem) {
		org.modelrefactoring.guery.resource.guery.mopp.GueryMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, analysisProblem);
		}
	}
	
	protected org.modelrefactoring.guery.resource.guery.mopp.GueryMarkerHelper getMarkerHelper() {
		if (isMarkerCreationEnabled() && new org.modelrefactoring.guery.resource.guery.util.GueryRuntimeUtil().isEclipsePlatformAvailable()) {
			if (markerHelper == null) {
				markerHelper = new org.modelrefactoring.guery.resource.guery.mopp.GueryMarkerHelper();
			}
			return markerHelper;
		}
		return null;
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		Object value = loadOptions.get(org.modelrefactoring.guery.resource.guery.IGueryOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
		return value == null || Boolean.FALSE.equals(value);
	}
	
	public boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		Object value = loadOptions.get(org.modelrefactoring.guery.resource.guery.IGueryOptions.DISABLE_LOCATION_MAP);
		return value == null || Boolean.FALSE.equals(value);
	}
	
	public boolean isLayoutInformationRecordingEnabled() {
		if (loadOptions == null) {
			return true;
		}
		Object value = loadOptions.get(org.modelrefactoring.guery.resource.guery.IGueryOptions.DISABLE_LAYOUT_INFORMATION_RECORDING);
		return value == null || Boolean.FALSE.equals(value);
	}
	
}
