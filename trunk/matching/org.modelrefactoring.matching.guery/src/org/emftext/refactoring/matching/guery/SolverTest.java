/**
 *
 */
package org.emftext.refactoring.matching.guery;

//import org.emftext.language.conference.ConferencePackage;
//import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
//import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;

//import org.emftext.language.pl0.PL0Package;
//import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
//import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;

//import org.emftext.language.martinfowlerdsl.MartinfowlerdslPackage;
//import org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.mopp.MartinfowlerdslMetaInformation;
//import org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.mopp.MartinfowlerdslResourceFactory;
//
//import org.emftext.language.featherweightjava.FeatherweightjavaPackage;
//import org.emftext.language.featherweightjava.resource.fj.mopp.FjMetaInformation;
//import org.emftext.language.featherweightjava.resource.fj.mopp.FjResourceFactory;

//import util.Writer2txt;

public class SolverTest {

	/*
	private EPackage pl0MM;
	private Resource pl0MMResource;
	*/

//	public void init(){
//		initLanguages();
//		initPL0MM();
//	}

//	private void initLanguages() {
//		EPackage.Registry.INSTANCE.put(MartinfowlerdslPackage.eNS_URI, MartinfowlerdslPackage.eINSTANCE);
////		EPackage.Registry.INSTANCE.put(FeatherweightjavaPackage.eNS_URI, FeatherweightjavaPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new MartinfowlerdslMetaInformation().getSyntaxName(), new MartinfowlerdslResourceFactory());
////		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new FjMetaInformation().getSyntaxName(), new FjResourceFactory());
//	}
//
	/*
	private void initPL0MM() {
		pl0MM = (EPackage) EPackage.Registry.INSTANCE.get(PL0Package.eNS_URI);
//		pl0MM = (EPackage) EPackage.Registry.INSTANCE.get(FeatherweightjavaPackage.eNS_URI);
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
//		assertNotNull("Dot metamodel couldn't be initialised", pl0MM);
		pl0MMResource = pl0MM.eResource();
//		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
	}
	*/

//	@Test
//	@Ignore
//	public void secondTest(){
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//
//		// Register the package to ensure it is available during loading.
//		//
//		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		String path = "../org.emftext.language.pl0/metamodel/pl0.ecore";
//		File file = new File(path);
//		URI uri = URI.createFileURI(file.getAbsolutePath());
//		Resource resource = PL0Package.eINSTANCE.eResource();
//		SolvingMotif solver = new SolvingMotif(loadTestMotifs(), resource);
//		solver.findMotifInstances();
//	}
//
//	@Test
//	@Ignore
//	public void findMapping(){
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//
//		// Register the package to ensure it is available during loading.
//		//
//		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		String path = "../org.emftext.language.pl0/metamodel/pl0.ecore";
//		File file = new File(path);
//		URI uri = URI.createFileURI(file.getAbsolutePath());
//		Resource resource = PL0Package.eINSTANCE.eResource();
//		SolvingMotif solver = new SolvingMotif(loadMappingMotifs(), resource);
//		solver.findMotifInstances();
//	}
//
//	@Test
//	@Ignore
//	public void withoutOptionalTest(){
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//
//		// Register the package to ensure it is available during loading.
//		//
//		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		String path = "../org.emftext.language.pl0/metamodel/pl0.ecore";
//		File file = new File(path);
//		URI uri = URI.createFileURI(file.getAbsolutePath());
//		Resource resource = PL0Package.eINSTANCE.eResource();
//		SolvingMotif solver = new SolvingMotif(loadWithoutOptionalMotifs(), resource);
//		solver.findMotifInstances();
//	}
//
//	@Test
//	@Ignore
//	public void generatedMotifTest(){
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//
//		// Register the package to ensure it is available during loading.
//		//
//		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		String path = "../org.emftext.language.pl0/metamodel/pl0.ecore";
//		File file = new File(path);
//		URI uri = URI.createFileURI(file.getAbsolutePath());
//		Resource resource = PL0Package.eINSTANCE.eResource();
//		SolvingMotif solver = new SolvingMotif(loadGeneratedMotifs(), resource);
//		solver.findMotifInstances();
//	}
//	
//	@Test
//	@Ignore
//	public void ExtractXToNewParentWithRestrictionTest(){
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//
//		// Register the package to ensure it is available during loading.
//		//
//		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		String path = "../org.emftext.language.pl0/metamodel/pl0.ecore";
//		File file = new File(path);
//		URI uri = URI.createFileURI(file.getAbsolutePath());
//		Resource resource = PL0Package.eINSTANCE.eResource();
//		SolvingMotif solver = new SolvingMotif(loadExtractXToNewParentWithRestriction(), resource);
//		solver.findMotifInstances();
//	}
//	
//	@Test
////	@Ignore
//	public void ExtractSubXTest(){
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//
//		// Register the package to ensure it is available during loading.
//		//
//		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		String path = "../org.emftext.language.pl0/metamodel/pl0.ecore";
//		File file = new File(path);
//		URI uri = URI.createFileURI(file.getAbsolutePath());
//		Resource resource = PL0Package.eINSTANCE.eResource();
//		SolvingMotif solver = new SolvingMotif(loadExtractSubX(), resource);
//		solver.findMotifInstances();
//	}
//
//	@Test
//	@Ignore
//	public void optionalAndLength3() {
//
//		//TODO entfernen
////		EPackage.Registry.INSTANCE.put(FeatherweightjavaPackage.eNS_URI, FeatherweightjavaPackage.eINSTANCE);
//////		EPackage.Registry.INSTANCE.put(FeatherweightjavaPackage.eNS_URI, FeatherweightjavaPackage.eINSTANCE);
////		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new FjMetaInformation().getSyntaxName(), new FjResourceFactory());
////		pl0MM = (EPackage) EPackage.Registry.INSTANCE.get(FeatherweightjavaPackage.eNS_URI);
//////		pl0MM = (EPackage) EPackage.Registry.INSTANCE.get(FeatherweightjavaPackage.eNS_URI);
////		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
//////		assertNotNull("Dot metamodel couldn't be initialised", pl0MM);
////		pl0MMResource = pl0MM.eResource();
////		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
////		//TODO entfernen ende
////		Writer2txt w2t=new Writer2txt("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/VergleichMFDSL.txt");
////		String header="tassiloEdited3 -- EXWRC";
////
////		java.util.Date now = new java.util.Date();
////		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss:SSS");
////		String ausgabe = sdf.format(now);
////		w2t.writeLine(ausgabe);
//		// TODO Auto-generated method stub
////		loadMotifs();
////		SolvingMotif sm=new SolvingMotif(loadMotifs(), );
//
////		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
////		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
////		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
////		extensionToFactoryMap.put("rolestext", new RolestextResourceFactory());
////		extensionToFactoryMap.put("guery", new GueryResourceFactory());
////
//////		assertTrue(sourceFile.exists());
//////		System.out.println(sourceFile.getAbsolutePath());
////		URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
////		ResourceSet resourceSet = new ResourceSetImpl();
////		Resource resource = resourceSet.getResource(uri, true);
////		EObject model = resource.getContents().get(0);
////		RoleModel rolemodel = (RoleModel) model;
//
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//
//		// Register the package to ensure it is available during loading.
//		//
//		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		String path = "../org.emftext.language.pl0/metamodel/pl0.ecore";
//		File file = new File(path);
////		assertTrue(file.exists());
//		URI uri = URI.createFileURI(file.getAbsolutePath());
//		Resource resource = PL0Package.eINSTANCE.eResource();
////		Resource pl0MM = resourceSet.getResource(uri, true);
////		SolvingMotif solver = new SolvingMotif(loadMotifs(), pl0MMResource);
//		SolvingMotif solver = new SolvingMotif(loadMotifs(), resource);
//		solver.findMotifInstances();
//
////		File f=new File("../resultGuery.txt");
////
////		now = new java.util.Date();
////		sdf = new java.text.SimpleDateFormat("HH:mm:ss:SSS");
////		ausgabe = sdf.format(now);
////		w2t.writeLine(ausgabe);
//
////		URI fileURI=URI.createFileURI("C:\\Users\\Robert\\gbswt\\org.emftext.refactoring.matching\\src\\org\\emftext\\refactoring\\matching\\Conversion.java");
////		Resource r=resourceSet.createResource(fileURI);
////		Resource res=resourceSet.createResource(URI.createURI(GueryPackage.eNS_URI));
////		Resource resource = resourceSet.createResource(URI.createURI("http:///My.guery"));
////		SolvingMotif sm=new SolvingMotif(loadMotifs(), r);
////
////		sm.findMotifInstances();
//	}
//	
//	private static Motif<MetamodelVertex,EReferenceEdge> loadExtractXToNewParentWithRestriction(){
//		InputStream in=null;
//		try {
////			in = new FileInputStream("ExtractXtoNewParentWithRestrictionV1.guery");
//			in = new FileInputStream("MoveXloosely.guery");
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		MotifReader<MetamodelVertex,EReferenceEdge> reader = new DefaultMotifReader<MetamodelVertex,EReferenceEdge>();
//		Motif<MetamodelVertex,EReferenceEdge> motif=null;
//		try {
//			motif = reader.read(in);
//		} catch (MotifReaderException e) {
//			e.printStackTrace();
//		}
//
//		return motif;
//	}
//
//	private static Motif<MetamodelVertex,EReferenceEdge> loadMotifs(){
//		InputStream in=null;
//		try {
//			in = new FileInputStream("ExtractXwithReferenceClass3.guery");
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		MotifReader<MetamodelVertex,EReferenceEdge> reader = new DefaultMotifReader<MetamodelVertex,EReferenceEdge>();
//		Motif<MetamodelVertex,EReferenceEdge> motif=null;
//		try {
//			motif = reader.read(in);
//		} catch (MotifReaderException e) {
//			e.printStackTrace();
//		}
//
//		return motif;
//	}
//
//	private static Motif<MetamodelVertex,EReferenceEdge> loadMappingMotifs(){
//		InputStream in=null;
//		try {
//			in = new FileInputStream("ExtractXwithReferenceClass1.guery");
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		MotifReader<MetamodelVertex,EReferenceEdge> reader = new DefaultMotifReader<MetamodelVertex,EReferenceEdge>();
//		Motif<MetamodelVertex,EReferenceEdge> motif=null;
//		try {
//			motif = reader.read(in);
//		} catch (MotifReaderException e) {
//			e.printStackTrace();
//		}
//
//		return motif;
//	}
//
//	private static Motif<MetamodelVertex,EReferenceEdge> loadWithoutOptionalMotifs(){
//		InputStream in=null;
//		try {
//			in = new FileInputStream("ExtractXwithReferenceClass2.guery");
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		MotifReader<MetamodelVertex,EReferenceEdge> reader = new DefaultMotifReader<MetamodelVertex,EReferenceEdge>();
//		Motif<MetamodelVertex,EReferenceEdge> motif=null;
//		try {
//			motif = reader.read(in);
//		} catch (MotifReaderException e) {
//			e.printStackTrace();
//		}
//
//		return motif;
//	}
//
//	private static Motif<MetamodelVertex,EReferenceEdge> loadGeneratedMotifs(){
//		InputStream in=null;
//		try {
//			in = new FileInputStream("ExtractXwithReferenceClass2.guery");
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		MotifReader<MetamodelVertex,EReferenceEdge> reader = new DefaultMotifReader<MetamodelVertex,EReferenceEdge>();
//		Motif<MetamodelVertex,EReferenceEdge> motif=null;
//		try {
//			motif = reader.read(in);
//		} catch (MotifReaderException e) {
//			e.printStackTrace();
//		}
//
//		return motif;
//	}
//
//	private static Motif<MetamodelVertex,EReferenceEdge> loadTestMotifs(){
//		InputStream in=null;
//		try {
//			in = new FileInputStream("test1.guery");
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		MotifReader<MetamodelVertex,EReferenceEdge> reader = new DefaultMotifReader<MetamodelVertex,EReferenceEdge>();
//		Motif<MetamodelVertex,EReferenceEdge> motif=null;
//		try {
//			motif = reader.read(in);
//		} catch (MotifReaderException e) {
//			e.printStackTrace();
//		}
//
//		return motif;
//	}
//	
//	private static Motif<MetamodelVertex,EReferenceEdge> loadExtractSubX(){
//		InputStream in=null;
//		try {
//			in = new FileInputStream("ExtractSubXV1.guery");
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		MotifReader<MetamodelVertex,EReferenceEdge> reader = new DefaultMotifReader<MetamodelVertex,EReferenceEdge>();
//		Motif<MetamodelVertex,EReferenceEdge> motif=null;
//		try {
//			motif = reader.read(in);
//		} catch (MotifReaderException e) {
//			e.printStackTrace();
//		}
//
//		return motif;
//	}
}
