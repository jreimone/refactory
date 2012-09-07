/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.bombXML.resource.xml.mopp;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

public class XmlResourceOld extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements dk.itu.sdg.language.bombXML.resource.xml.IXmlTextResource {
	
	public class ElementBasedTextDiagnostic implements dk.itu.sdg.language.bombXML.resource.xml.IXmlTextDiagnostic {
		
		private final dk.itu.sdg.language.bombXML.resource.xml.IXmlLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final dk.itu.sdg.language.bombXML.resource.xml.IXmlProblem problem;
		
		public ElementBasedTextDiagnostic(dk.itu.sdg.language.bombXML.resource.xml.IXmlLocationMap locationMap, org.eclipse.emf.common.util.URI uri, dk.itu.sdg.language.bombXML.resource.xml.IXmlProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public dk.itu.sdg.language.bombXML.resource.xml.IXmlProblem getProblem() {
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
	
	public class PositionBasedTextDiagnostic implements dk.itu.sdg.language.bombXML.resource.xml.IXmlTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private dk.itu.sdg.language.bombXML.resource.xml.IXmlProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, dk.itu.sdg.language.bombXML.resource.xml.IXmlProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public dk.itu.sdg.language.bombXML.resource.xml.IXmlProblem getProblem() {
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
	
	private dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceResolverSwitch resolverSwitch;
	private dk.itu.sdg.language.bombXML.resource.xml.IXmlLocationMap locationMap;
	private int proxyCounter = 0;
	public dk.itu.sdg.language.bombXML.resource.xml.IXmlTextParser parser;
	private dk.itu.sdg.language.bombXML.resource.xml.util.XmlLayoutUtil layoutUtil = new dk.itu.sdg.language.bombXML.resource.xml.util.XmlLayoutUtil();
	private dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlMarkerHelper markerHelper;
	private java.util.Map<String, dk.itu.sdg.language.bombXML.resource.xml.IXmlContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, dk.itu.sdg.language.bombXML.resource.xml.IXmlContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, dk.itu.sdg.language.bombXML.resource.xml.IXmlQuickFix> quickFixMap = new java.util.LinkedHashMap<String, dk.itu.sdg.language.bombXML.resource.xml.IXmlQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessor runningPostProcessor;
	
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
	
	protected dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlMetaInformation metaInformation = new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlMetaInformation();
	
	private boolean preProcessed = false;
	
	public XmlResourceOld() {
		super();
		resetLocationMap();
	}
	
	public XmlResourceOld(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	
	
	protected ByteArrayInputStream preProcess(InputStream inputStream) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document dom = null;
		try {
			db = dbf.newDocumentBuilder();
			dom = db.parse(inputStream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (dom != null) {
			Element rootElement = dom.getDocumentElement();
		
			//modification necessary for BOMBXML to work correctly
			//it inserts special tags around text nodes
			modifyTextNodes(rootElement);
		}
		
		//TODO: wieder serializieren????
		OutputFormat format = new OutputFormat(dom);
		format.setIndenting(true);
		format.setPreserveEmptyAttributes(true);
		format.setPreserveSpace(true);
		
		try {
					
			String platformString = this.uri.toPlatformString(true);
			IFile myFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
			
			if(!this.preProcessed) {
				XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File(myFile.getLocation().toString())),format);
				serializer.serialize(dom);
				this.preProcessed = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		DOMImplementationLS domImplementation = (DOMImplementationLS) dom.getImplementation();
	    LSSerializer lsSerializer = domImplementation.createLSSerializer();
	    String xmlAsString = lsSerializer.writeToString(dom);  
		
	    System.out.println(xmlAsString);
	    
		ByteArrayInputStream newInputStream = new ByteArrayInputStream(xmlAsString.getBytes());
		return newInputStream;
	}
	
	private void modifyTextNodes(Node node) {
		
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);

			if (((currentNode.getNodeType() == Node.CDATA_SECTION_NODE) || (currentNode.getNodeType() == Node.TEXT_NODE)) && !currentNode.getNodeValue().trim().isEmpty()) {
				String content = currentNode.getNodeValue();
				
				if(!content.startsWith("[_b0mBxMl_]") && !content.endsWith("[_b0mBxMl_]")) {			
					currentNode.setNodeValue("[_b0mBxMl_]" + content + "[_b0mBxMl_]");
				}
			} else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				modifyTextNodes(currentNode);
			}
		}
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		
		//HELGE HACK!!!
		//This is not beautiful! It just adds special bomb tags to let the model parse correctly
//		preProcess(inputStream);
		
		
		synchronized (loadingLock) {
			if (processTerminationRequested()) {
				return;
			}
			this.loadOptions = options;
			delayNotifications = true;
			resetLocationMap();
			String encoding = getEncoding(options);
//			java.io.InputStream actualInputStream = inputStream;
			java.io.InputStream actualInputStream = preProcess(inputStream);
			Object inputStreamPreProcessorProvider = null;
			if (options != null) {
				inputStreamPreProcessorProvider = options.get(dk.itu.sdg.language.bombXML.resource.xml.IXmlOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
			}
			if (inputStreamPreProcessorProvider != null) {
				if (inputStreamPreProcessorProvider instanceof dk.itu.sdg.language.bombXML.resource.xml.IXmlInputStreamProcessorProvider) {
					dk.itu.sdg.language.bombXML.resource.xml.IXmlInputStreamProcessorProvider provider = (dk.itu.sdg.language.bombXML.resource.xml.IXmlInputStreamProcessorProvider) inputStreamPreProcessorProvider;
					dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
					actualInputStream = processor;
				}
			}
			
			parser = getMetaInformation().createParser(actualInputStream, encoding);
			parser.setOptions(options);
			dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
			referenceResolverSwitch.setOptions(options);
			dk.itu.sdg.language.bombXML.resource.xml.IXmlParseResult result = parser.parse();
			// dispose parser, we don't need it anymore
			//parser = null;
			
			if (processTerminationRequested()) {
				// do nothing if reload was already restarted
				return;
			}
			
			clearState();
			getContentsInternal().clear();
			org.eclipse.emf.ecore.EObject root = null;
			if (result != null) {
				root = result.getRoot();
				if (root != null) {
					if (isLayoutInformationRecordingEnabled()) {
						layoutUtil.transferAllLayoutInformationToModel(root);
					}
					getContentsInternal().add(root);
				}
				java.util.Collection<dk.itu.sdg.language.bombXML.resource.xml.IXmlCommand<dk.itu.sdg.language.bombXML.resource.xml.IXmlTextResource>> commands = result.getPostParseCommands();
				if (commands != null) {
					for (dk.itu.sdg.language.bombXML.resource.xml.IXmlCommand<dk.itu.sdg.language.bombXML.resource.xml.IXmlTextResource>  command : commands) {
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
			if (root != null) {
				getContentsInternal().clear();
				if (processTerminationRequested()) {
					// the next reload will add new content
					return;
				}
				getContentsInternal().add(root);
			}
			notifyDelayed();
		}
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
				// //reload already requested
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
				doLoad(latestReloadInputStream, loadOptions);
			} catch (dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlTerminateParsingException tpe) {
				// do nothing - the resource is left unchanged if this exception is thrown
			}
			resolveAfterParsing();
			isLoaded = true;
		}
	}
	
	/**
	 * Cancels reloading this resource. The running parser and post processors are
	 * terminated.
	 */
	protected void cancelReload() {
		dk.itu.sdg.language.bombXML.resource.xml.IXmlTextParser parserCopy = parser;
		if (parserCopy != null) {
			parserCopy.terminate();
		}
		dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		dk.itu.sdg.language.bombXML.resource.xml.IXmlTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		printer.setEncoding(getEncoding(options));
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
		return "xml";
	}
	
	protected String getEncoding(java.util.Map<?, ?> options) {
		String encoding = null;
		if (new dk.itu.sdg.language.bombXML.resource.xml.util.XmlRuntimeUtil().isEclipsePlatformAvailable()) {
			encoding = new dk.itu.sdg.language.bombXML.resource.xml.util.XmlEclipseProxy().getPlatformResourceEncoding(uri);
		}
		if (options != null) {
			Object encodingOption = options.get(dk.itu.sdg.language.bombXML.resource.xml.IXmlOptions.OPTION_ENCODING);
			if (encodingOption != null) {
				encoding = encodingOption.toString();
			}
		}
		return encoding;
	}
	
	public dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlMetaInformation getMetaInformation() {
		return new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlMetaInformation();
	}
	
	/**
	 * Clears the location map by replacing it with a new instance.
	 */
	protected void resetLocationMap() {
		if (isLocationMapEnabled()) {
			locationMap = new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlLocationMap();
		} else {
			locationMap = new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlDevNullLocationMap();
		}
	}
	
	public void addURIFragment(String internalURIFragment, dk.itu.sdg.language.bombXML.resource.xml.IXmlContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(dk.itu.sdg.language.bombXML.resource.xml.IXmlContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position) {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = dk.itu.sdg.language.bombXML.resource.xml.IXmlContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		dk.itu.sdg.language.bombXML.resource.xml.IXmlContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			dk.itu.sdg.language.bombXML.resource.xml.IXmlContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlProblem(message, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.UNRESOLVED_REFERENCE, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemSeverity.ERROR), uriFragment.getProxy());
				new dk.itu.sdg.language.bombXML.resource.xml.util.XmlRuntimeUtil().logError(message, e);
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
				dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
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
			if (adapter instanceof dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlLayoutInformationAdapter) {
				dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlLayoutInformationAdapter layoutInformationAdapter = (dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected org.eclipse.emf.ecore.EObject getResultElement(dk.itu.sdg.language.bombXML.resource.xml.IXmlContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof dk.itu.sdg.language.bombXML.resource.xml.IXmlURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((dk.itu.sdg.language.bombXML.resource.xml.IXmlURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
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
						addProblem(new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlProblem(errorMessage, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.UNRESOLVED_REFERENCE, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof dk.itu.sdg.language.bombXML.resource.xml.IXmlElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((dk.itu.sdg.language.bombXML.resource.xml.IXmlElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = dk.itu.sdg.language.bombXML.resource.xml.util.XmlCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
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
			if (errorCand instanceof dk.itu.sdg.language.bombXML.resource.xml.IXmlTextDiagnostic) {
				if (((dk.itu.sdg.language.bombXML.resource.xml.IXmlTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					unmark(cause);
				}
			}
		}
	}
	
	protected void attachResolveError(dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlProblem(errorMessage, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.UNRESOLVED_REFERENCE, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (dk.itu.sdg.language.bombXML.resource.xml.IXmlReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlProblem(warningMessage, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.UNRESOLVED_REFERENCE, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemSeverity.WARNING), proxy);
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
		unmark(dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.ANALYSIS_PROBLEM);
		if (processTerminationRequested()) {
			return false;
		}
		// first, run the generated post processor
		runPostProcessor(new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlResourcePostProcessor());
		if (loadOptions == null) {
			return true;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(dk.itu.sdg.language.bombXML.resource.xml.IXmlOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessorProvider) {
				runPostProcessor(((dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processTerminationRequested()) {
						return false;
					}
					if (processorProvider instanceof dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessorProvider) {
						dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessorProvider csProcessorProvider = (dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessorProvider) processorProvider;
						dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
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
	protected void runPostProcessor(dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new dk.itu.sdg.language.bombXML.resource.xml.util.XmlRuntimeUtil().logError("Exception while running a post-processor.", e);
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
	public dk.itu.sdg.language.bombXML.resource.xml.IXmlLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(dk.itu.sdg.language.bombXML.resource.xml.IXmlProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(dk.itu.sdg.language.bombXML.resource.xml.IXmlProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(dk.itu.sdg.language.bombXML.resource.xml.IXmlProblem problem) {
		java.util.Collection<dk.itu.sdg.language.bombXML.resource.xml.IXmlQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (dk.itu.sdg.language.bombXML.resource.xml.IXmlQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addError(message, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlProblem(message, type, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addWarning(message, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlProblem(message, type, dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemSeverity.WARNING), cause);
	}
	
	protected java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemSeverity severity) {
		if (severity == dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = dk.itu.sdg.language.bombXML.resource.xml.util.XmlMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new dk.itu.sdg.language.bombXML.resource.xml.util.XmlRuntimeUtil().isEclipsePlatformAvailable()) {
			new dk.itu.sdg.language.bombXML.resource.xml.util.XmlEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
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
		unmark(dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.UNKNOWN);
		unmark(dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.SYNTAX_ERROR);
		unmark(dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType.UNRESOLVED_REFERENCE);
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
		return new dk.itu.sdg.language.bombXML.resource.xml.util.XmlCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
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
		return new dk.itu.sdg.language.bombXML.resource.xml.util.XmlCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	/**
	 * Returns all errors that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new dk.itu.sdg.language.bombXML.resource.xml.util.XmlCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	protected void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		if (new dk.itu.sdg.language.bombXML.resource.xml.util.XmlRuntimeUtil().isEclipsePlatformAvailable()) {
			new dk.itu.sdg.language.bombXML.resource.xml.util.XmlEclipseProxy().checkEMFValidationConstraints(this, root);
		}
	}
	
	public dk.itu.sdg.language.bombXML.resource.xml.IXmlQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	protected void mark(dk.itu.sdg.language.bombXML.resource.xml.IXmlTextDiagnostic diagnostic) {
		if (isMarkerCreationEnabled() && new dk.itu.sdg.language.bombXML.resource.xml.util.XmlRuntimeUtil().isEclipsePlatformAvailable()) {
			if (markerHelper == null) {
				markerHelper = new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlMarkerHelper();
			}
			markerHelper.mark(this, diagnostic);
		}
	}
	protected void unmark(org.eclipse.emf.ecore.EObject cause) {
		if (isMarkerCreationEnabled() && new dk.itu.sdg.language.bombXML.resource.xml.util.XmlRuntimeUtil().isEclipsePlatformAvailable()) {
			if (markerHelper == null) {
				markerHelper = new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlMarkerHelper();
			}
			markerHelper.unmark(this, cause);
		}
	}
	protected void unmark(dk.itu.sdg.language.bombXML.resource.xml.XmlEProblemType analysisProblem) {
		if (isMarkerCreationEnabled() && new dk.itu.sdg.language.bombXML.resource.xml.util.XmlRuntimeUtil().isEclipsePlatformAvailable()) {
			if (markerHelper == null) {
				markerHelper = new dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlMarkerHelper();
			}
			markerHelper.unmark(this, analysisProblem);
		}
	}
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(dk.itu.sdg.language.bombXML.resource.xml.IXmlOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
	}
	
	protected boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(dk.itu.sdg.language.bombXML.resource.xml.IXmlOptions.DISABLE_LOCATION_MAP);
	}
	
	protected boolean isLayoutInformationRecordingEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(dk.itu.sdg.language.bombXML.resource.xml.IXmlOptions.DISABLE_LAYOUT_INFORMATION_RECORDING);
	}
	
}
