/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource {
	
	public class ElementBasedTextDiagnostic implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextDiagnostic {
		
		private final org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecProblem problem;
		
		public ElementBasedTextDiagnostic(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecLocationMap locationMap, org.eclipse.emf.common.util.URI uri, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public java.lang.String getMessage() {
			return problem.getMessage();
		}
		
		public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecProblem getProblem() {
			return problem;
		}
		
		public java.lang.String getLocation() {
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
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			if (this.element == null) {
				return false;
			}
			return this.element.equals(element);
		}
	}
	
	public class PositionBasedTextDiagnostic implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecProblem getProblem() {
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
		
		public java.lang.String getLocation() {
			return uri.toString();
		}
		
		public java.lang.String getMessage() {
			return problem.getMessage();
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			return false;
		}
	}
	
	private org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolverSwitch resolverSwitch;
	private org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecLocationMap locationMap;
	private int proxyCounter = 0;
	private org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextParser parser;
	private java.util.Map<java.lang.String, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.HashMap<java.lang.String, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	
	public RefspecResource() {
		super();
		resetLocationMap();
	}
	
	public RefspecResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		java.lang.String encoding = null;
		java.io.InputStream actualInputStream = inputStream;
		java.lang.Object inputStreamPreProcessorProvider = null;
		if (options!=null) {
			inputStreamPreProcessorProvider = options.get(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		}
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecInputStreamProcessorProvider) {
				org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecInputStreamProcessorProvider provider = (org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecInputStreamProcessorProvider) inputStreamPreProcessorProvider;
				org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
				actualInputStream = processor;
				encoding = processor.getOutputEncoding();
			}
		}
		
		parser = getMetaInformation().createParser(actualInputStream, encoding);
		parser.setOptions(options);
		org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecParseResult result = parser.parse();
		clearState();
		getContents().clear();
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				getContents().add(root);
			}
			java.util.Collection<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecCommand<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource>> commands = result.getPostParseCommands();
			if (commands != null) {
				for (org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecCommand<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource>  command : commands) {
					command.execute(this);
				}
			}
		}
		getReferenceResolverSwitch().setOptions(options);
		if (getErrors().isEmpty()) {
			runPostProcessors(options);
		}
	}
	
	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		try {
			isLoaded = false;
			java.util.Map<java.lang.Object, java.lang.Object> loadOptions = addDefaultLoadOptions(options);
			doLoad(inputStream, loadOptions);
		} catch (org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecTerminateParsingException tpe) {
			// do nothing - the resource is left unchanged if this exception is thrown
		}
		isLoaded = true;
	}
	
	public void cancelReload() {
		org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextParser parserCopy = parser;
		parserCopy.terminate();
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecPrinter printer = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecPrinter(outputStream, this);
		org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		for(org.eclipse.emf.ecore.EObject root : getContents()) {
			printer.print(root);
		}
	}
	
	protected String getSyntaxName() {
		return "refspec";
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecMetaInformation getMetaInformation() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecMetaInformation();
	}
	
	protected void resetLocationMap() {
		locationMap = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecLocationMap();
	}
	
	public void addURIFragment(java.lang.String internalURIFragment, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, java.lang.String id, org.eclipse.emf.ecore.EObject proxyElement) {
		int pos = -1;
		if (reference.isMany()) {
			pos = ((java.util.List<?>)container.eGet(reference)).size();
		}
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		java.lang.String internalURIFragment = org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, pos, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = uriFragment.resolve();
			if (result == null) {
				//the resolving did call itself
				return null;
			}
			if (!wasResolvedBefore && !result.wasResolved()) {
				attachErrors(result, uriFragment.getProxy());
				return null;
			} else if (!result.wasResolved()) {
				return null;
			} else {
				//remove an error that might have been added by an earlier attempt
				removeDiagnostics(uriFragment.getProxy(), getErrors());
				//remove old warnings and attach new
				removeDiagnostics(uriFragment.getProxy(), getWarnings());
				attachWarnings(result, uriFragment.getProxy());
				org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
				return getResultElement(uriFragment, mapping, uriFragment.getProxy(), result.getErrorMessage());
			}
		} else {
			return super.getEObject(id);
		}
	}
	
	private org.eclipse.emf.ecore.EObject getResultElement(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final java.lang.String errorMessage) {
		if (mapping instanceof org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
			if (uri != null) {
				org.eclipse.emf.ecore.EObject result = null;
				try {
					result = this.getResourceSet().getEObject(uri, true);
				} catch (java.lang.Exception e) {
					//we can catch exceptions here, because EMF will try to resolve again and handle the exception
				}
				if (result == null || result.eIsProxy()) {
					//unable to resolve: attach error
					if (errorMessage == null) {
						assert(false);
					} else {
						addProblem(new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecProblem(errorMessage, org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecCastUtil.cast(element.eGet(oppositeReference, false));										//avoids duplicate entries in the reference caused by adding to the oppositeReference 
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
	
	private void removeDiagnostics(org.eclipse.emf.ecore.EObject proxy, java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics) {
		// remove errors/warnings from resource
		for (org.eclipse.emf.ecore.resource.Resource.Diagnostic errorCand : new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(diagnostics)) {
			if (errorCand instanceof org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextDiagnostic) {
				if (((org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextDiagnostic) errorCand).wasCausedBy(proxy)) {
					diagnostics.remove(errorCand);
				}
			}
		}
	}
	
	private void attachErrors(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to resource
		assert result != null;
		final java.lang.String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecProblem(errorMessage, org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType.ERROR), proxy);
		}
	}
	
	private void attachWarnings(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final java.lang.String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecProblem(warningMessage, org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType.ERROR), proxy);
			}
		}
	}
	
	// Extends the super implementation by clearing all information about element positions.
	protected void doUnload() {
		super.doUnload();
		clearState();
	}
	
	protected void runPostProcessors(java.util.Map<?, ?> loadOptions) {
		if (loadOptions == null) {
			return;
		}
		java.lang.Object resourcePostProcessorProvider = loadOptions.get(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecResourcePostProcessorProvider) {
				((org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor().process(this);
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processorProvider instanceof org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecResourcePostProcessorProvider) {
						org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecResourcePostProcessorProvider csProcessorProvider = (org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecResourcePostProcessorProvider) processorProvider;
						org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						try {
							postProcessor.process(this);
						} catch (java.lang.Exception e) {
							org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecPlugin.logError("Exception while running a post-processor.", e);
						}
					}
				}
			}
		}
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<java.lang.Object, java.lang.Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
	}
	
	public void setURI(org.eclipse.emf.common.util.URI uri) {
		//because of the context dependent proxy resolving it is 
		//essential to resolve all proxies before the URI is changed
		//which can cause loss of object identities
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecProblem problem, org.eclipse.emf.ecore.EObject element) {
		getDiagnostics(problem.getType()).add(new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element));
	}
	
	public void addProblem(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecProblem problem, int column, int line, int charStart, int charEnd) {
		getDiagnostics(problem.getType()).add(new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd));
	}
	
	public void addError(java.lang.String message, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecProblem(message, org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType.ERROR), cause);
	}
	
	public void addWarning(java.lang.String message, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecProblem(message, org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType.WARNING), cause);
	}
	
	private java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType type) {
		if (type == org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<java.lang.Object, java.lang.Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<java.lang.Object, java.lang.Object> loadOptionsCopy = org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		if (org.eclipse.core.runtime.Platform.isRunning()) {
			// find default load option providers
			org.eclipse.core.runtime.IExtensionRegistry extensionRegistry = org.eclipse.core.runtime.Platform.getExtensionRegistry();
			org.eclipse.core.runtime.IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecPlugin.EP_DEFAULT_LOAD_OPTIONS_ID);
			for (org.eclipse.core.runtime.IConfigurationElement element : configurationElements) {
				try {
					org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecOptionProvider provider = (org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecOptionProvider) element.createExecutableExtension("class");
					final java.util.Map<?, ?> options = provider.getOptions();
					final java.util.Collection<?> keys = options.keySet();
					for (java.lang.Object key : keys) {
						addLoadOption(loadOptionsCopy, key, options.get(key));
					}
				} catch (org.eclipse.core.runtime.CoreException ce) {
					org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecPlugin.logError("Exception while getting default options.", ce);
				}
			}
		}
		return loadOptionsCopy;
	}
	
	// Adds a new key,value pair to the list of options. If there
	// is already an option with the same key, the two values are 
	// collected in a list.
	private void addLoadOption(java.util.Map<java.lang.Object, java.lang.Object> options,java.lang.Object key, java.lang.Object value) {
		// check if there is already an option set
		if (options.containsKey(key)) {
			java.lang.Object currentValue = options.get(key);
			if (currentValue instanceof java.util.List<?>) {
				// if the current value is a list, we add the new value to
				// this list
				java.util.List<?> currentValueAsList = (java.util.List<?>) currentValue;
				java.util.List<java.lang.Object> currentValueAsObjectList = org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecListUtil.copySafelyToObjectList(currentValueAsList);
				if (value instanceof java.util.Collection<?>) {
					currentValueAsObjectList.addAll((java.util.Collection<?>) value);
				} else {
					currentValueAsObjectList.add(value);
				}
				options.put(key, currentValueAsObjectList);
			} else {
				// if the current value is not a list, we create a fresh list
				// and add both the old (current) and the new value to this list
				java.util.List<java.lang.Object> newValueList = new java.util.ArrayList<java.lang.Object>();
				newValueList.add(currentValue);
				if (value instanceof java.util.Collection<?>) {
					newValueList.addAll((java.util.Collection<?>) value);
				} else {
					newValueList.add(value);
				}
				options.put(key, newValueList);
			}
		} else {
			options.put(key, value);
		}
	}
	
	// Extends the super implementation by clearing all information about element positions.
	protected void clearState() {
		//clear concrete syntax information
		resetLocationMap();
		internalURIFragmentMap.clear();
		getErrors().clear();
		getWarnings().clear();
		proxyCounter = 0;
		resolverSwitch = null;
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContents() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
}
