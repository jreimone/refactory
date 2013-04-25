package org.refactory.matching.greql;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;

//import org.emftext.language.forms.FormsPackage;
//import org.emftext.language.forms.resource.forms.mopp.FormsMetaInformation;
//import org.emftext.language.forms.resource.forms.mopp.FormsResourceFactory;
//
//import org.emftext.language.models.ModelsPackage;
//import org.emftext.language.models.resource.model.mopp.ModelMetaInformation;
//import org.emftext.language.models.resource.model.mopp.ModelResourceFactory;
//
//import org.emftext.language.rails.RailsPackage;
//import org.emftext.language.rails.resource.rails.mopp.RailsMetaInformation;
//import org.emftext.language.rails.resource.rails.mopp.RailsResourceFactory;

//import org.emftext.language.textadventure.TextadventurePackage;
//import org.emftext.language.textadventure.resource.tas.mopp.TasMetaInformation;
//import org.emftext.language.textadventure.resource.tas.mopp.TasResourceFactory;

//import org.emftext.language.exml.ExmlPackage;
//import org.emftext.language.xml.resource.xml.mopp.XmlMetaInformation;
//import org.emftext.language.xml.resource.xml.mopp.XmlResourceFactory;

//import org.emftext.language.c_sharp.statements.StatementsPackage;
//import org.emftext.language.c_sharp.resource.csharp.mopp.CsharpMetaInformation;
//import org.emftext.language.c_sharp.resource.csharp.mopp.CsharpResourceFactory;

//import org.emftext.language.modelquery.ModelqueryPackage;
//import org.emftext.language.modelquery.resource.modelquery.mopp.ModelqueryMetaInformation;
//import org.emftext.language.modelquery.resource.modelquery.mopp.ModelqueryResourceFactory;

//import org.emftext.language.notes.NotesPackage;
//import org.emftext.language.notes.resource.notes.mopp.NotesMetaInformation;
//import org.emftext.language.notes.resource.notes.mopp.NotesResourceFactory;

//import org.emftext.language.rolecore.RolecorePackage;
//import org.emftext.language.rolecore.resource.rolecore.mopp.RolecoreMetaInformation;
//import org.emftext.language.rolecore.resource.rolecore.mopp.RolecoreResourceFactory;

//import org.emftext.language.simplec.CPackage;
//import org.emftext.language.simplec.resource.c.mopp.CMetaInformation;
//import org.emftext.language.simplec.resource.c.mopp.CResourceFactory;

//import org.emftext.language.tcltk.TcltkPackage;
//import org.emftext.language.tcltk.resource.tcl.mopp.TclMetaInformation;
//import org.emftext.language.tcltk.resource.tcl.mopp.TclResourceFactory;

//import org.emftext.language.petrinet.PetrinetPackage;
//import org.emftext.language.petrinet.resource.petrinet.mopp.PetrinetMetaInformation;
//import org.emftext.language.petrinet.resource.petrinet.mopp.PetrinetResourceFactory;

//import org.emftext.language.office.OfficePackage;
//import org.emftext.language.office.resource.office.mopp.OfficeMetaInformation;
//import org.emftext.language.office.resource.office.mopp.OfficeResourceFactory;

//import org.emftext.language.martinfowlerdsl.MartinfowlerdslPackage;
//import org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.mopp.MartinfowlerdslMetaInformation;
//import org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.mopp.MartinfowlerdslResourceFactory;

//import org.emftext.language.B.BPackage;
//import org.emftext.language.b.resource.mch.mopp.MchMetaInformation;
//import org.emftext.language.b.resource.mch.mopp.MchResourceFactory;

//import org.emftext.language.functions.FunctionsPackage;
//import org.emftext.language.functions.resource.functions.mopp.FunctionsMetaInformation;
//import org.emftext.language.functions.resource.functions.mopp.FunctionsResourceFactory;

//import org.emftext.language.dot.DotPackage;
//import org.emftext.language.dot.resource.dot.mopp.DotMetaInformation;
//import org.emftext.language.dot.resource.dot.mopp.DotResourceFactory;

//import org.emftext.language.manifest.ManifestPackage;
//import org.emftext.language.manifest.resource.manifest.mopp.MFMetaInformation;
//import org.emftext.language.manifest.resource.manifest.mopp.MFResourceFactory;

//import org.emftext.language.latex.latexPackage;
//import org.emftext.language.latex.resource.tex.mopp.TexMetaInformation;
//import org.emftext.language.latex.resource.tex.mopp.TexResourceFactory;

//import org.emftext.language.featherweightjava.FeatherweightjavaPackage;
//import org.emftext.language.featherweightjava.resource.fj.mopp.FjMetaInformation;
//import org.emftext.language.featherweightjava.resource.fj.mopp.FjResourceFactory;

//import org.emftext.language.calc.FeatherweightjavaPackage;
//import org.emftext.language.featherweightjava.resource.fj.mopp.FjMetaInformation;
//import org.emftext.language.featherweightjava.resource.fj.mopp.FjResourceFactory;

//import org.emftext.language.conference.ConferencePackage;
//import org.emftext.language.conference.resource.conference.mopp.ConferenceMetaInformation;
//import org.emftext.language.conference.resource.conference.mopp.ConferenceResourceFactory;

import de.uni_koblenz.jgralab.Edge;
import de.uni_koblenz.jgralab.Graph;
import de.uni_koblenz.jgralab.GraphIO;
import de.uni_koblenz.jgralab.ImplementationType;
import de.uni_koblenz.jgralab.Vertex;
import de.uni_koblenz.jgralab.exception.GraphIOException;
import de.uni_koblenz.jgralab.schema.GraphClass;
import de.uni_koblenz.jgralab.schema.Schema;

public class CreateGraph {
	
	static String schemaFileName="GraphSchema";
	private EPackage pl0MM;
	private Resource pl0MMResource;
	private Graph graph;
	
	private Map<String,Vertex> vertexlist=new HashMap<String,Vertex>();
	private Schema schema=null;
	
	
	public Resource getResource() {
		return pl0MMResource;
	}
	
	public Graph getGraph(){
		return graph;
	}
	
	public void addVertex(EClass clazz, GraphClass graphClass){
		Vertex v=graph.createVertex(graphClass.getVertexClass("Node"));
		v.setAttribute("name", clazz.getName());
		vertexlist.put(clazz.getName(), v);
		System.out.println(v);
	}
	
	public void createGraphWithInheritance(){
		vertexlist=new HashMap<String, Vertex>();
		ArrayList<Edge> edgesL=new ArrayList<Edge>();
		ArrayList<ArrayList<Vertex>> inheritlists=new ArrayList<ArrayList<Vertex>>();
		HashMap<String, Edge> edgeListToControl=new HashMap<String, Edge>();
		String path="";
		try {
			schema = GraphIO.loadSchemaFromFile(schemaFileName);
		} catch (GraphIOException e1) {
			e1.printStackTrace();
		}
		GraphClass graphClass = schema.getGraphClass();
		graph = schema.createGraph(ImplementationType.GENERIC, "ExampleGraph", 50, 100);
		
		System.out.println("Create Vertices");
		
		List<EObject> contents = getResource().getContents();
		for (EObject model : contents) {
			if(model instanceof EPackage){
				EPackage epackage = (EPackage) model;
				EList<EClassifier> classifiers = epackage.getEClassifiers();
				for (EClassifier classifier : classifiers) {
					if(classifier instanceof EClass){
						if (!vertexlist.containsKey(classifier.getName())){
							addVertex((EClass)classifier,graphClass);
						}
						//create inheritanceList
						if (!((EClass) classifier).getEAllSuperTypes().isEmpty()){
							EList<EClass> allSuperTypes=((EClass) classifier).getEAllSuperTypes();
							for (EClass superClass:allSuperTypes){
								ArrayList<Vertex> il=new ArrayList<Vertex>();
								Vertex v1 = vertexlist.get(classifier.getName());
								if (!vertexlist.containsKey(superClass.getName())){
									addVertex(superClass,graphClass);
								}
								Vertex v2 = vertexlist.get(superClass.getName());
								il.add(v1);
								il.add(v2);
								inheritlists.add(il);
							}
						}
						//create normal References
						if (!((EClass) classifier).getEAllReferences().isEmpty()){
							EList<EReference> refList=((EClass) classifier).getEAllReferences();
							for (EReference ref:refList){
								Vertex v1 = vertexlist.get(classifier.getName());
								if (!vertexlist.containsKey(ref.getEReferenceType().getName())){
									addVertex(ref.getEReferenceType(),graphClass);
								}
								Vertex v2 = vertexlist.get(ref.getEReferenceType().getName());
								Edge e = graph.createEdge(graphClass.getEdgeClass("Connection"),
										v1, v2);
								e.setAttribute("name", ref.getName());
								e.setAttribute("source", v1.getAttribute("name"));
								e.setAttribute("target", v2.getAttribute("name"));
								if (ref.isContainment()){
									e.setAttribute("connectionType", "AGGREGATION");
								}
								else{
									e.setAttribute("connectionType", "ASSOCIATION");
								}
								edgesL.add(e);
								String key=e.getAttribute("connectionType").toString()+e.getAttribute("name").toString()+e.getAttribute("source").toString()+e.getAttribute("target").toString();
								assertTrue(!edgeListToControl.containsKey(key));
								edgeListToControl.put(key, e);
								System.out.println(e);
							}
						}
					}
				}
				for (EClassifier classifier : classifiers) {
					if(classifier instanceof EClass){
						Vertex v1 = vertexlist.get(classifier.getName());
						for (ArrayList<Vertex> il:inheritlists){
							if (il.get(0).getAttribute("name").equals(v1.getAttribute("name"))){
								Vertex sup=il.get(1);
								for (Edge e2:edgesL){
									if (vertexlist.get(e2.getAttribute("source")).equals(sup)){
										String key=e2.getAttribute("connectionType").toString()+e2.getAttribute("name").toString()+v1.getAttribute("name").toString()+vertexlist.get(e2.getAttribute("target")).getAttribute("name").toString();
										if(!(edgeListToControl.containsKey(key))){
											Edge eNew = graph.createEdge(graphClass.getEdgeClass("Connection"),
													v1, vertexlist.get(e2.getAttribute("target")));
											eNew.setAttribute("name", e2.getAttribute("name"));
											eNew.setAttribute("source", v1.getAttribute("name"));
											eNew.setAttribute("target", vertexlist.get(e2.getAttribute("target")).getAttribute("name"));
											eNew.setAttribute("connectionType", e2.getAttribute("connectionType"));
											edgeListToControl.put(key, eNew);
											System.out.println(eNew);
										}
										else{
											System.out.println("schon vorhanden: "+key);
										}
									}
									else{
										if (vertexlist.get(e2.getAttribute("target")).equals(sup)){
											String key=e2.getAttribute("connectionType").toString()+e2.getAttribute("name").toString()+vertexlist.get(e2.getAttribute("source")).getAttribute("name").toString()+v1.getAttribute("name").toString();
											if(!(edgeListToControl.containsKey(key))){
												Edge eNew = graph.createEdge(graphClass.getEdgeClass("Connection"),
														vertexlist.get(e2.getAttribute("source")), v1);
												eNew.setAttribute("name", e2.getAttribute("name"));
												eNew.setAttribute("source", vertexlist.get(e2.getAttribute("source")).getAttribute("name"));
												eNew.setAttribute("target", v1.getAttribute("name"));
												eNew.setAttribute("connectionType", e2.getAttribute("connectionType"));
												edgeListToControl.put(key, eNew);
												System.out.println(eNew);
											}
											else{
												System.out.println("schon vorhanden: "+key);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		schema.finish();
		
		path="C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/New";
		try {
			graph.save(path);
		} catch (GraphIOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void createGraphExtractXWithReferenceClass(){
		vertexlist=new HashMap<String, Vertex>();
		Schema schema=null;
		String path="";
		try {
			schema = GraphIO.loadSchemaFromFile(schemaFileName);
		} catch (GraphIOException e1) {
			e1.printStackTrace();
		}
		GraphClass graphClass = schema.getGraphClass();
		graph = schema.createGraph(ImplementationType.GENERIC, "ExampleGraph", 50, 100);
		Vertex v1=graph.createVertex(graphClass.getVertexClass("Node"));
		v1.setAttribute("name", "ContCont");
		Vertex v2=graph.createVertex(graphClass.getVertexClass("Node"));
		v2.setAttribute("name", "OrigCont");
		Vertex v3=graph.createVertex(graphClass.getVertexClass("Node"));
		v3.setAttribute("name", "Extract");
		Vertex v4=graph.createVertex(graphClass.getVertexClass("Node"));
		v4.setAttribute("name", "NewCont");
		Vertex v5=graph.createVertex(graphClass.getVertexClass("Node"));
		v5.setAttribute("name", "MovedRef");
		
		Edge e1 = graph.createEdge(graphClass.getEdgeClass("Connection"),
				v1, v2);
		e1.setAttribute("name", "source");
		e1.setAttribute("source", "ContCont");
		e1.setAttribute("target", "OrigCont");
		e1.setAttribute("connectionType", "AGGREGATION");
		Edge e2 = graph.createEdge(graphClass.getEdgeClass("Connection"),
				v1, v4);
		e2.setAttribute("name", "target");
		e2.setAttribute("source", "ContCont");
		e2.setAttribute("target", "NewCont");
		e2.setAttribute("connectionType", "AGGREGATION");
		Edge e3 = graph.createEdge(graphClass.getEdgeClass("Connection"),
				v2, v3);
		e3.setAttribute("name", "extracts");
		e3.setAttribute("source", "OrigCont");
		e3.setAttribute("target", "Extract");
		e3.setAttribute("connectionType", "AGGREGATION");
		Edge e4 = graph.createEdge(graphClass.getEdgeClass("Connection"),
				v4, v3);
		e4.setAttribute("name", "moved");
		e4.setAttribute("source", "NewCont");
		e4.setAttribute("target", "Extract");
		e4.setAttribute("connectionType", "AGGREGATION");
		Edge e5 = graph.createEdge(graphClass.getEdgeClass("Connection"),
				v2, v5);
		e5.setAttribute("name", "referer");
		e5.setAttribute("source", "OrigCont");
		e5.setAttribute("target", "MovedRef");
		e5.setAttribute("connectionType", "AGGREGATION");
		Edge e6 = graph.createEdge(graphClass.getEdgeClass("Connection"),
				v5, v4);
		e6.setAttribute("name", "contRef");
		e6.setAttribute("source", "MovedRef");
		e6.setAttribute("target", "NewCont");
		e6.setAttribute("connectionType", "ASSOCIATION");
		schema.finish();
		
		path="C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/StructureEXWRC";
		try {
			graph.save(path);
		} catch (GraphIOException e) {
			e.printStackTrace();
		}
	}
	
	public void createGraphSimpleStructure(){
		vertexlist=new HashMap<String, Vertex>();
		Schema schema=null;
		String path="";
		try {
			schema = GraphIO.loadSchemaFromFile(schemaFileName);
		} catch (GraphIOException e1) {
			e1.printStackTrace();
		}
		GraphClass graphClass = schema.getGraphClass();
		graph = schema.createGraph(ImplementationType.GENERIC, "ExampleGraph", 50, 100);
		Vertex v1=graph.createVertex(graphClass.getVertexClass("Node"));
		v1.setAttribute("name", "Class1");
		Vertex v2=graph.createVertex(graphClass.getVertexClass("Node"));
		v2.setAttribute("name", "Class2");
		Vertex v3=graph.createVertex(graphClass.getVertexClass("Node"));
		v3.setAttribute("name", "Class1Sub");
		Vertex v4=graph.createVertex(graphClass.getVertexClass("Node"));
		v4.setAttribute("name", "Class2Sup");
		
		Edge e1 = graph.createEdge(graphClass.getEdgeClass("Connection"),
				v1, v2);
		e1.setAttribute("name", "con");
		e1.setAttribute("source", "Class1");
		e1.setAttribute("target", "Class2");
		e1.setAttribute("connectionType", "AGGREGATION");
		schema.finish();
		
		path="C:/Users/Robert/testGReQL/GReQLPrototyp/src/StructureSimple";
		try {
			graph.save(path);
		} catch (GraphIOException e) {
			e.printStackTrace();
		}
	}

	public void init(){
		initLanguages();
		initPL0MM();
	}

	private void initLanguages() {
		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
//		EPackage.Registry.INSTANCE.put(FeatherweightjavaPackage.eNS_URI, FeatherweightjavaPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new Pl0MetaInformation().getSyntaxName(), new Pl0ResourceFactory());
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new FjMetaInformation().getSyntaxName(), new FjResourceFactory());
	}

	private void initPL0MM() {
		pl0MM = (EPackage) EPackage.Registry.INSTANCE.get(PL0Package.eNS_URI);
//		pl0MM = (EPackage) EPackage.Registry.INSTANCE.get(FeatherweightjavaPackage.eNS_URI);
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
//		assertNotNull("Dot metamodel couldn't be initialised", pl0MM);
		pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
	}
}
