/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

public class TestpropertiesResource extends ResourceImpl implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource {
	
	public class ElementBasedTextDiagnostic implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextDiagnostic {
		
		private final org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap;
		private final URI uri;
		private final EObject element;
		private final org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem problem;
		
		public ElementBasedTextDiagnostic(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap, URI uri, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem problem, EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem getProblem() {
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
		
		public EObject getElement() {
			return element;
		}
		
		public boolean wasCausedBy(EObject element) {
			if (this.element == null) {
				return false;
			}
			return this.element.equals(element);
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	public class PositionBasedTextDiagnostic implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextDiagnostic {
		
		private final URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem problem;
		
		public PositionBasedTextDiagnostic(URI uri, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem problem, int column, int line, int charStart, int charEnd) {
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem getProblem() {
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
		
		public boolean wasCausedBy(EObject element) {
			return false;
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolverSwitch resolverSwitch;
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap;
	private int proxyCounter = 0;
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextParser parser;
	private org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesLayoutUtil layoutUtil = new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesLayoutUtil();
	private org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMarkerHelper markerHelper;
	private Map<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragment<? extends EObject>> internalURIFragmentMap = new LinkedHashMap<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragment<? extends EObject>>();
	private Map<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> quickFixMap = new LinkedHashMap<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix>();
	private Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessor runningPostProcessor;
	
	/**
	 * A flag (and lock) to indicate whether reloading of the resource shall be
	 * cancelled.
	 */
	private Boolean terminateReload = false;
	private Object terminateReloadLock = new Object();
	private Object loadingLock = new Object();
	private boolean delayNotifications = false;
	private List<Notification> delayedNotifications = new ArrayList<Notification>();
	private InputStream latestReloadInputStream = null;
	private Map<?, ?> latestReloadOptions = null;
	
	/**
	 * This flag indicates whether this resource is currently reloaded. The flag is
	 * set and unset in the reload() method and used to decide what kinds of
	 * constraints (live or batch) need to be evaluated. This decision is made in
	 * runValidators().
	 */
	private boolean isReloading = false;
	private org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesInterruptibleEcoreResolver interruptibleResolver;
	
	protected org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation metaInformation = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation();
	
	public TestpropertiesResource() {
		super();
		resetLocationMap();
	}
	
	public TestpropertiesResource(URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(InputStream inputStream, Map<?,?> options) throws IOException {
		synchronized (loadingLock) {
			if (processTerminationRequested()) {
				return;
			}
			this.loadOptions = options;
			delayNotifications = true;
			resetLocationMap();
			String encoding = getEncoding(options);
			InputStream actualInputStream = inputStream;
			Object inputStreamPreProcessorProvider = null;
			if (options != null) {
				inputStreamPreProcessorProvider = options.get(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
			}
			if (inputStreamPreProcessorProvider != null) {
				if (inputStreamPreProcessorProvider instanceof org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesInputStreamProcessorProvider) {
					org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesInputStreamProcessorProvider provider = (org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesInputStreamProcessorProvider) inputStreamPreProcessorProvider;
					org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
					actualInputStream = processor;
				}
			}
			
			// We store the parser instance in a field instead of a local variable, because we
			// may need to terminate the parser from another thread.
			parser = getMetaInformation().createParser(actualInputStream, encoding);
			parser.setOptions(options);
			org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
			referenceResolverSwitch.setOptions(options);
			org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesParseResult result = parser.parse();
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
			EObject root = null;
			if (result != null) {
				root = result.getRoot();
				if (root != null) {
					org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap newLocationMap = result.getLocationMap();
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
				Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>> commands = result.getPostParseCommands();
				if (commands != null) {
					for (org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>  command : commands) {
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
		List<EObject> contentsInternal = getContentsInternal();
		// unload the root objects
		for (EObject eObject : contentsInternal) {
			if (eObject instanceof InternalEObject) {
				unloaded((InternalEObject) eObject);
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
		for (Notification delayedNotification : delayedNotifications) {
			super.eNotify(delayedNotification);
		}
		delayedNotifications.clear();
	}
	
	public void eNotify(Notification notification) {
		if (delayNotifications) {
			delayedNotifications.add(notification);
		} else {
			super.eNotify(notification);
		}
	}
	
	/**
	 * Reloads the contents of this resource from the given stream.
	 */
	public void reload(InputStream inputStream, Map<?,?> options) throws IOException {
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
			Map<Object, Object> loadOptions = addDefaultLoadOptions(latestReloadOptions);
			try {
				// Set isReloading flag to allow other method to differentiate between loading and
				// reloading.
				this.isReloading = true;
				doLoad(latestReloadInputStream, loadOptions);
			} catch (org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTerminateParsingException tpe) {
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
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextParser parserCopy = parser;
		if (parserCopy != null) {
			parserCopy.terminate();
		}
		// Cancel post processor(s)
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
		// Cancel reference resolving
		org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesInterruptibleEcoreResolver interruptibleResolverCopy = interruptibleResolver;
		if (interruptibleResolverCopy != null) {
			interruptibleResolverCopy.terminate();
		}
	}
	
	protected void doSave(OutputStream outputStream, Map<?,?> options) throws IOException {
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		printer.setEncoding(getEncoding(options));
		printer.setOptions(options);
		referenceResolverSwitch.setOptions(options);
		for (EObject root : getContentsInternal()) {
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
		return "testproperties";
	}
	
	public String getEncoding(Map<?, ?> options) {
		String encoding = null;
		if (new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesRuntimeUtil().isEclipsePlatformAvailable()) {
			encoding = new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesEclipseProxy().getPlatformResourceEncoding(uri);
		}
		if (options != null) {
			Object encodingOption = options.get(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesOptions.OPTION_ENCODING);
			if (encodingOption != null) {
				encoding = encodingOption.toString();
			}
		}
		return encoding;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation getMetaInformation() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation();
	}
	
	/**
	 * Clears the location map by replacing it with a new instance.
	 */
	protected void resetLocationMap() {
		// Although, the location map is obtained from the parser after every parse run,
		// we initialize it here to avoid null pointer exceptions.
		locationMap = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesLocationMap();
	}
	
	public void addURIFragment(String internalURIFragment, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragment<? extends EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends EObject, ReferenceType extends EObject> void registerContextDependentProxy(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, EReference reference, String id, EObject proxyElement, int position) {
		InternalEObject proxy = (InternalEObject) proxyElement;
		String internalURIFragment = org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragment<? extends EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolveResult<? extends EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesProblem(message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.UNRESOLVED_REFERENCE, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity.ERROR), uriFragment.getProxy());
				new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesRuntimeUtil().logError(message, e);
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
				EObject proxy = uriFragment.getProxy();
				// remove an error that might have been added by an earlier attempt
				removeDiagnostics(proxy, getErrors());
				// remove old warnings and attach new
				removeDiagnostics(proxy, getWarnings());
				attachResolveWarnings(result, proxy);
				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceMapping<? extends EObject> mapping = result.getMappings().iterator().next();
				EObject resultElement = getResultElement(uriFragment, mapping, proxy, result.getErrorMessage());
				EObject container = uriFragment.getContainer();
				replaceProxyInLayoutAdapters(container, proxy, resultElement);
				return resultElement;
			}
		} else {
			return super.getEObject(id);
		}
	}
	
	protected void replaceProxyInLayoutAdapters(EObject container, EObject proxy, EObject target) {
		for (Adapter adapter : container.eAdapters()) {
			if (adapter instanceof org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesLayoutInformationAdapter) {
				org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesLayoutInformationAdapter layoutInformationAdapter = (org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected EObject getResultElement(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragment<? extends EObject> uriFragment, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceMapping<? extends EObject> mapping, EObject proxy, final String errorMessage) {
		if (mapping instanceof org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesURIMapping<?>) {
			URI uri = ((org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesURIMapping<? extends EObject>)mapping).getTargetIdentifier();
			if (uri != null) {
				EObject result = null;
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
						addProblem(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesProblem(errorMessage, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.UNRESOLVED_REFERENCE, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesElementMapping<?>) {
			EObject element = ((org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesElementMapping<? extends EObject>)mapping).getTargetElement();
			EReference reference = uriFragment.getReference();
			EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					ManyInverse<EObject> list = org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
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
	
	protected void removeDiagnostics(EObject cause, List<Diagnostic> diagnostics) {
		// remove all errors/warnings from this resource
		for (Diagnostic errorCand : new BasicEList<Diagnostic>(diagnostics)) {
			if (errorCand instanceof org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextDiagnostic) {
				if (((org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					unmark(cause);
				}
			}
		}
	}
	
	protected void attachResolveError(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolveResult<?> result, EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesProblem(errorMessage, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.UNRESOLVED_REFERENCE, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolveResult<? extends EObject> result, EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceMapping<? extends EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesProblem(warningMessage, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.UNRESOLVED_REFERENCE, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity.WARNING), proxy);
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
	protected boolean runPostProcessors(Map<?, ?> loadOptions) {
		unmark(org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.ANALYSIS_PROBLEM);
		if (processTerminationRequested()) {
			return false;
		}
		// first, run the generated post processor
		runPostProcessor(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResourcePostProcessor());
		if (loadOptions == null) {
			return true;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessorProvider) {
				runPostProcessor(((org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processTerminationRequested()) {
						return false;
					}
					if (processorProvider instanceof org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessorProvider) {
						org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessorProvider csProcessorProvider = (org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessorProvider) processorProvider;
						org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
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
	protected void runPostProcessor(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesRuntimeUtil().logError("Exception while running a post-processor.", e);
		}
		this.runningPostProcessor = null;
	}
	
	public void load(Map<?, ?> options) throws IOException {
		Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		resolveAfterParsing();
	}
	
	protected void resolveAfterParsing() {
		interruptibleResolver = new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesInterruptibleEcoreResolver();
		interruptibleResolver.resolveAll(this);
		interruptibleResolver = null;
	}
	
	public void setURI(URI uri) {
		// because of the context dependent proxy resolving it is essential to resolve all
		// proxies before the URI is changed which can cause loss of object identities
		EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	/**
	 * Returns the location map that contains information about the position of the
	 * contents of this resource in the original textual representation.
	 */
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem problem, EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem problem) {
		Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated
	public void addError(String message, EObject cause) {
		addError(message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type, EObject cause) {
		addProblem(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesProblem(message, type, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated
	public void addWarning(String message, EObject cause) {
		addWarning(message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type, EObject cause) {
		addProblem(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesProblem(message, type, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity.WARNING), cause);
	}
	
	protected List<Diagnostic> getDiagnostics(org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity severity) {
		if (severity == org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected Map<Object, Object> addDefaultLoadOptions(Map<?, ?> loadOptions) {
		Map<Object, Object> loadOptionsCopy = org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
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
		unmark(org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.UNKNOWN);
		unmark(org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.SYNTAX_ERROR);
		unmark(org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.UNRESOLVED_REFERENCE);
		unmark(org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.LIVE_CONSTRAINT_PROBLEM);
		// If the resource is reloaded, we do not remove the problems that were detected
		// by batch constraints. This ensures that we can see the problems while typing.
		// The problems might get out dated because of the ongoing modifications, but they
		// will be updated (i.e., deleted and recreated) the next time the resource is
		// saved (and loaded again).
		if (!isReloading) {
			unmark(org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.BATCH_CONSTRAINT_PROBLEM);
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
	public EList<EObject> getContents() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new BasicEList<EObject>();
		}
		return new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesCopiedEObjectInternalEList((InternalEList<EObject>) super.getContents());
	}
	
	/**
	 * Returns the raw contents of this resource. In contrast to getContents(), this
	 * methods does not return a copy of the content list, but the original list.
	 */
	public EList<EObject> getContentsInternal() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new BasicEList<EObject>();
		}
		return super.getContents();
	}
	
	/**
	 * Returns all warnings that are associated with this resource.
	 */
	public EList<Diagnostic> getWarnings() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new BasicEList<Diagnostic>();
		}
		return new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesCopiedEList<Diagnostic>(super.getWarnings());
	}
	
	/**
	 * Returns all errors that are associated with this resource.
	 */
	public EList<Diagnostic> getErrors() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new BasicEList<Diagnostic>();
		}
		return new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesCopiedEList<Diagnostic>(super.getErrors());
	}
	
	/**
	 * Returns true if errors are associated with this resource.
	 */
	public boolean hasErrors() {
		// We use the method of the super class to avoid copying the list of errors which
		// is done by getErrors() in this class. Creating a copy is not required to check
		// whether the list of errors is empty and moreover it did cause race conditions
		// in the editor that led to ArrayIndexOutOfBoundsExceptions while copying the
		// error list.
		return !super.getErrors().isEmpty();
	}
	
	protected void runValidators(EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		if (new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesRuntimeUtil().isEclipsePlatformAvailable()) {
			if (loadOptions == null || !Boolean.TRUE.equals(loadOptions.get(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesOptions.DISABLE_EMF_VALIDATION))) {
				// We do only evaluate batch constraints when the resource is loaded for the first
				// time. If the resource is reloaded, only live constraints are evaluated.
				boolean includeBatchConstraints = !this.isReloading;
				new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesEclipseProxy().checkEMFValidationConstraints(this, root, includeBatchConstraints);
			}
		}
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	protected void mark(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextDiagnostic diagnostic) {
		org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.mark(this, diagnostic);
		}
	}
	
	protected void unmark(EObject cause) {
		org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, cause);
		}
	}
	
	protected void unmark(org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType analysisProblem) {
		org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, analysisProblem);
		}
	}
	
	protected org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMarkerHelper getMarkerHelper() {
		if (isMarkerCreationEnabled() && new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesRuntimeUtil().isEclipsePlatformAvailable()) {
			if (markerHelper == null) {
				markerHelper = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMarkerHelper();
			}
			return markerHelper;
		}
		return null;
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		Object value = loadOptions.get(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
		return value == null || Boolean.FALSE.equals(value);
	}
	
	public boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		Object value = loadOptions.get(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesOptions.DISABLE_LOCATION_MAP);
		return value == null || Boolean.FALSE.equals(value);
	}
	
	public boolean isLayoutInformationRecordingEnabled() {
		if (loadOptions == null) {
			return true;
		}
		Object value = loadOptions.get(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesOptions.DISABLE_LAYOUT_INFORMATION_RECORDING);
		return value == null || Boolean.FALSE.equals(value);
	}
	
}
