package org.emftext.refactoring.smell.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PackageImport;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.uml2.uml.UMLPackage;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.Quality;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellPackage;
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationModel;
import org.emftext.refactoring.smell.calculation.CalculationPackage;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.ecoresmells.EcoresmellsPackage;
import org.emftext.refactoring.smell.registry.IQualitySmellModelInitializer;
import org.emftext.refactoring.smell.registry.IQualitySmellRegistry;
import org.emftext.refactoring.smell.registry.util.Pair;
import org.emftext.refactoring.smell.registry.util.Triple;
import org.emftext.refactoring.smell.rolessmell.RolessmellPackage;
import org.emftext.refactoring.smell.umlsmells.UmlsmellsPackage;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.io.Files;

@SuppressWarnings("restriction")
public class FindSmellsTest {

	private static final String SMELL_MODEL_PATH		= "../../runtime-Evolution_WS/.metadata/.plugins/org.emftext.refactoring.smell.registry.ui/smellmodel.smell";
	private static final String CALC_MODEL_PATH		= "../../runtime-Evolution_WS/.metadata/.plugins/org.emftext.refactoring.smell.registry.ui/registered.calculation";
	private static final String SMELLING_RESOURCES	= "config/smellingResources.config";

//	private static CalculationModel calculationModel;
//	private static QualitySmellModel smellModel;
	private static IQualitySmellRegistry registry;
	private static List<Resource> smellingResources;
	private static ResourceSetImpl resourceSet;

	@Test
	public void testFindSmells(){
		for (Resource resource : smellingResources) {
			System.out.println("-------------------");
			System.out.println("file: " + resource.getURI().toString());
			List<Pair<Calculation,QualityCalculation>> smellCalculationsForResource = registry.getSmellCalculationsForResource(resource);
//			for (Pair<Calculation, QualityCalculation> pair : smellCalculationsForResource) {
//				Calculation calculation = pair.getFirst();
//				if(calculation instanceof Structure){
//					Pattern pattern = ((Structure) calculation).getPattern();
//					//					if(pattern.eIsProxy()){
//					//						Map<URI, URI> uriMap = URIConverter.URI_MAP;
//					//						URI uri = ((InternalEObject) pattern).eProxyURI();
//					//						URI localUri = URI.createURI(uri.toString().replace("plugin", "resource"));
//					//						uriMap.put(uri, localUri);
//					//						EcoreUtil.resolveAll(pattern);
//					//					}
//					IQuerySpecification<?> querySpecification = QuerySpecificationRegistry.getOrCreateQuerySpecification(pattern);
//					if(querySpecification != null){
//						// TODO try passing only the resource
//						try {
//							IncQueryEngine engine = IncQueryEngine.on(resource.getResourceSet());
//							// TODO try the following one day
//							// attention: then engine.wipe() and engine.dispose() must be called if use finished
//							//						IncQueryEngine engine = AdvancedIncQueryEngine.createUnmanagedEngine(resource);
//							IncQueryMatcher<? extends IPatternMatch> matcher = querySpecification.getMatcher(engine);
//							Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
//							for (IPatternMatch match : matches) {
//								System.out.println(match);
//							}
//						} catch (IncQueryException e) {
//							e.printStackTrace();
//						}
//					}					
//					//					IMatcherFactory<IncQueryMatcher<IPatternMatch>> matcherFactory = (IMatcherFactory<IncQueryMatcher<IPatternMatch>>) MatcherFactoryRegistry.getMatcherFactory(pattern.getName());
//					//					if(matcherFactory != null){
//					//						try {
//					//							IncQueryMatcher<IPatternMatch> matcher = matcherFactory.getMatcher(resourceSet);
//					//							Collection<IPatternMatch> allMatches = matcher.getAllMatches();
//					//							for (IPatternMatch match : allMatches) {
//					//								System.out.println(match);
//					//							}
//					//						} catch (IncQueryException e) {
//					//							e.printStackTrace();
//					//						}
//					//					}
//					checkForProxies(pattern);
//					checkMetamodels(pattern, resource);
//				}
//			}

			List<Triple<CalculationResult, Calculation, QualityCalculation>> matchingSmellCalculations = registry.getMatchingSmellCalculationsForResource(resource);
			for (Triple<CalculationResult, Calculation, QualityCalculation> triple : matchingSmellCalculations) {
				CalculationResult result = triple.getFirst();
				QualityCalculation qualityCalculation = triple.getThird();
				ConcreteQualitySmell concreteSmell = qualityCalculation.getConcreteSmell();
				String concreteName = concreteSmell.getConcreteName();
				String genericName = concreteSmell.getGenericSmell().getName();
				Quality quality = qualityCalculation.getQuality();
				String qualityName = quality.getName();
				System.out.println("generic smell: " + genericName);
				System.out.println("concrete smell: " + concreteName);
				System.out.println("quality: " + qualityName);
				List<EObject> causingObjects = result.getCausingObjects();
				for (EObject element : causingObjects) {
					System.out.println("smelling element: " + EcoreUtil.getURI(element).toString());
				}
			}
		}
	}
	
	@BeforeClass
	public static void setUp(){
		// not needed when test is run as JUnit Plugin test
		registerCoreLanguages();
		registerCalculationExtensionLanguages();
		registerSmellingLanguages();
		registerTestingRootAsPlatformRoot();
		initRegistry();
		initSmellingResources();
	}

	private static void registerCoreLanguages() {
		// IncQuery
		new EMFPatternLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		// old IncQuery
//		EMFPatternLanguageStandaloneSetupGenerated setup = new EMFPatternLanguageStandaloneSetupGenerated();
//		Injector injector = setup.createInjectorAndDoEMFRegistration();
//		EPackage.Registry.INSTANCE.put(XbasePackage.eNS_URI, XbasePackage.eINSTANCE);
//		EPackage.Registry.INSTANCE.put(PatternLanguagePackage.eNS_URI, PatternLanguagePackage.eINSTANCE);
//		EPackage.Registry.INSTANCE.put(EMFPatternLanguagePackage.eNS_URI, EMFPatternLanguagePackage.eINSTANCE);
//		//		Injector injector = Guice.createInjector(new EMFPatternLanguageRuntimeModule());
//		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("eiq", resourceFactory);
		// smells
		EPackage.Registry.INSTANCE.put(SmellPackage.eNS_URI, SmellPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("smell", new XMIResourceFactoryImpl());
		// smells calculation
		EPackage.Registry.INSTANCE.put(CalculationPackage.eNS_URI, CalculationPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("calculation", new XMIResourceFactoryImpl());
	}

	private static void registerCalculationExtensionLanguages() {
		// roles calculation extension
		EPackage.Registry.INSTANCE.put(RolessmellPackage.eNS_URI, RolessmellPackage.eINSTANCE);
		// ecore calculation extension
		EPackage.Registry.INSTANCE.put(EcoresmellsPackage.eNS_URI, EcoresmellsPackage.eINSTANCE);
		// UML calculation extension
		EPackage.Registry.INSTANCE.put(UmlsmellsPackage.eNS_URI, UmlsmellsPackage.eINSTANCE);
	}

	private static void registerSmellingLanguages() {
		// java
		JaMoPPUtil.initialize();
		// roles
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolestextMetaInformation().getSyntaxName(), new RolestextResourceFactory());
		// role mapping
		EPackage.Registry.INSTANCE.put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolemappingMetaInformation().getSyntaxName(), new RolemappingResourceFactory());
		// UML
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
	}

	private static void registerTestingRootAsPlatformRoot() {
		Map<String, URI> resourceMap = EcorePlugin.getPlatformResourceMap();
		Map<URI, URI> uriMap = URIConverter.URI_MAP;
		File root = new File(".");
		assertTrue(root.exists());

		root = root.getAbsoluteFile();
		assertTrue(root.exists());
		root = root.getParentFile().getParentFile();
		assertTrue(root.exists());
		File[] subDirs = root.listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.exists() && pathname.isDirectory() && !pathname.isHidden() && pathname.canRead() && !pathname.getName().startsWith(
						".");
			}
		});
		for (File subDir : subDirs) {
			String rootPath = subDir.getAbsolutePath() + File.separator + ".";
			URI rootUri = URI.createFileURI(rootPath);
			rootUri = rootUri.trimSegments(1);
			String testProjectRoot = rootUri.lastSegment();
			assertNotNull(testProjectRoot);
			rootUri = URI.createFileURI(rootPath);
			resourceMap.put(testProjectRoot, rootUri);
			URI realUri = URI.createURI(rootUri.trimSegments(1).toString() + "/");
			URI pluginURI = URI.createPlatformPluginURI(testProjectRoot + "/", true);
			uriMap.put(pluginURI, realUri);
		}
	}

	private static void initRegistry() {
		resourceSet = new ResourceSetImpl();
		registry = IQualitySmellRegistry.INSTANCE;
		IQualitySmellModelInitializer initializer = new IQualitySmellModelInitializer() {
			
			private CalculationModel calculationModel;
			private QualitySmellModel smellModel;

			@Override
			public void initialize() {
				try {
					File file = new File(CALC_MODEL_PATH).getCanonicalFile();
					URI uri = URI.createFileURI(file.getAbsolutePath());
					Resource resource = resourceSet.getResource(uri, true);
					assertNotNull("Calculation Resource mustn't be null", resource);
					calculationModel = (CalculationModel) resource.getContents().get(0);
					assertNotNull("Calculation Model mustn't be null", calculationModel);
					file = new File(SMELL_MODEL_PATH).getCanonicalFile();
					uri = URI.createFileURI(file.getAbsolutePath());
					resource = resourceSet.getResource(uri, true);
					assertNotNull("Smell Resource mustn't be null", resource);
					smellModel = (QualitySmellModel) resource.getContents().get(0);
					assertNotNull("Smell Model mustn't be null", smellModel);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public QualitySmellModel getQualitySmellModel() {
				return smellModel;
			}
			
			@Override
			public CalculationModel getCalculationModel() {
				return calculationModel;
			}
		};
		registry.setInitializer(initializer);
		// to test all qualities they must be activated
		List<Quality> qualities = registry.getQualitySmellModel().getQualities();
		for (Quality quality : qualities) {
			quality.setActive(true);
		}
	}

	private static void initSmellingResources() {
		File file = new File(SMELLING_RESOURCES);
		assertTrue("Smelling resources file must exist", file != null && file.exists());
		try {
			List<String> paths = Files.readLines(file, Charset.defaultCharset());
			smellingResources = new ArrayList<Resource>();
			for (String path : paths) {
				if(!path.startsWith("//")){
					String[] strings = path.split(";");
					file = new File(strings[0].trim()).getCanonicalFile();
					File parent = file.getParentFile();
					if(strings.length == 2){
						parent = new File(strings[1].trim()).getCanonicalFile();
					}
					assertTrue("Smelling resource must exist", file != null && file.exists());
					assertTrue("Parent of smelling resource must exist", parent != null && parent.exists());
					loadAllFilesInResourceSet(resourceSet, parent , ".java");
					collectJarsAndAddToResourceSet(resourceSet, parent);
					Resource resource = resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
					assertNotNull("Smelling resource " + file.getAbsolutePath() + " couldn't be loaded", resource);
					smellingResources.add(resource);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		checkProxyResolution(resourceSet);
	}

	

	private void checkMetamodels(Pattern pattern, Resource resource) {
		PatternModel patternModel = (PatternModel) pattern.eContainer();
		// new IncQuery version
		PackageImport packageImport = patternModel.getImportPackages().getPackageImport().get(0);
		assertNotNull("import must reference an EPackage", packageImport);
		EPackage metamodelPattern = packageImport.getEPackage();
		// old IncQuery version
		//		ImportDeclaration importDeclaration = patternModel.getImportPackages().get(0);
		//		EPackage metamodelPattern = null;
		//		if(importDeclaration instanceof PackageImport){
		//			PackageImport packageImport = (PackageImport) importDeclaration;
		//			metamodelPattern = packageImport.getEPackage();
		//		}
		//		assertNotNull("import must reference an EPackage", packageImport);
		while(metamodelPattern.getESuperPackage() != null){
			metamodelPattern = metamodelPattern.getESuperPackage();
		}
		EObject model = resource.getContents().get(0);
		EPackage metamodelResource = model.eClass().getEPackage();
		while(metamodelResource.getESuperPackage() != null){
			metamodelResource = metamodelResource.getESuperPackage();
		}
		assertEquals("metamodels of pattern and resource must be equal", metamodelPattern, metamodelResource);
	}

	private void checkForProxies(Pattern pattern) {
		assertNotNull("pattern mustn't be null", pattern);
		TreeIterator<EObject> allContents = pattern.eAllContents();
		while (allContents.hasNext()) {
			EObject element = (EObject) allContents.next();
			if(element.eIsProxy()){
				fail("pattern " + pattern.getName() + " contains proxy:\n" + element);
			}
		}
	}
	
//////////this is adapted from JaMoPPC
	
	private static void collectJarsAndAddToResourceSet(ResourceSet rs, File root) {
		List<File> allJars = collectJars(root);
		JavaClasspath classpath = JavaClasspath.get(rs);
		classpath.registerStdLib();
		// register jar files
		for (File jarFile : allJars) {
			if (!jarFile.exists()) {
				System.out.println("not found: " + jarFile);
				return;
			}
			try {
				System.out.println("Registering JAR " + jarFile.getCanonicalPath());
				classpath.registerClassifierJar(URI.createFileURI(jarFile.getCanonicalPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void checkProxyResolution(ResourceSet rs) {
		if (!resolveAllProxies(rs, 0)) {
			System.err.println("Resolution of some Proxies failed...");
			Iterator<Notifier> it = rs.getAllContents();
			while (it.hasNext()) {
				Notifier next = it.next();
				if (next instanceof EObject) {
					EObject o = (EObject) next;
					if (o.eIsProxy()) {
						try {
							it.remove();
						} catch (UnsupportedOperationException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	private static List<File> collectJars(File root) {
		List<File> jarFiles = new ArrayList<File>();
		File[] files = root.listFiles();
		for (File file : files) {
			if(file.isFile() && file.getName().endsWith(".jar")){
				jarFiles.add(file);
				continue;
			}
			if(file.isDirectory()){
				jarFiles.addAll(collectJars(file));
			}
		}
		return jarFiles; 
	}
	
	private static void loadAllFilesInResourceSet(ResourceSet rs, File startFolder, String extension) {
		for (File member : startFolder.listFiles()) {
			if (member.isFile()) {
				if (member.getName().endsWith(extension)) {
					System.out.println("Parsing " + member);
					parseResource(rs, member);
				} else {
					System.out.println("Skipping " + member);
				}
			}
			if (member.isDirectory()) {
				if (!member.getName().startsWith(".")) {
					System.out.println("Recursing into " + member);
					loadAllFilesInResourceSet(rs, member, extension);
				} else {
					System.out.println("Skipping " + member);
				}
			}
		}
	}
	
	private static void parseResource(ResourceSet rs, File file) {
		try {
			loadResource(rs, file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadResource(ResourceSet rs, String filePath) {
		loadResource(rs, URI.createFileURI(filePath));
	}

	private static void loadResource(ResourceSet rs, URI uri) {
		rs.getResource(uri, true);
	}

	protected static boolean resolveAllProxies(ResourceSet rs, int resourcesProcessedBefore) {
		boolean failure = false;
		List<EObject> eobjects = new LinkedList<EObject>();
		for (Iterator<Notifier> i = rs.getAllContents(); i.hasNext();) {
			Notifier next = i.next();
			if (next instanceof EObject) {
				eobjects.add((EObject) next);
			}
		}
		int resourcesProcessed = rs.getResources().size();
		if (resourcesProcessed == resourcesProcessedBefore) {
			return true;
		}

		System.out.println("Resolving cross-references of " + eobjects.size()
				+ " EObjects.");
		int resolved = 0;
		int notResolved = 0;
		int eobjectCnt = 0;
		for (EObject next : eobjects) {
			eobjectCnt++;
			if (eobjectCnt % 1000 == 0) {
				System.out.println(eobjectCnt + "/" + eobjects.size()
						+ " done: Resolved " + resolved + " crossrefs, "
						+ notResolved + " crossrefs could not be resolved.");
			}

			InternalEObject nextElement = (InternalEObject) next;
			for (EObject crElement : nextElement.eCrossReferences()) {
				crElement = EcoreUtil.resolve(crElement, rs);
				if (crElement.eIsProxy()) {
					failure = true;
					notResolved++;
					System.out
					.println("Can not find referenced element in classpath: "
							+ ((InternalEObject) crElement).eProxyURI());
				} else {
					resolved++;
				}
			}
		}

		System.out.println(eobjectCnt + "/" + eobjects.size()
				+ " done: Resolved " + resolved + " crossrefs, " + notResolved
				+ " crossrefs could not be resolved.");

		//call this method again, because the resolving might have triggered loading
		//of additional resources that may also contain references that need to be resolved.
		return !failure && resolveAllProxies(rs, resourcesProcessed);
	}
}