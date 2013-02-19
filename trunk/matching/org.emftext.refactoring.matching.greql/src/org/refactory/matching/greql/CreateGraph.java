package org.refactory.matching.greql;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
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
import org.pcollections.ArrayPVector;

import de.uni_koblenz.jgralab.Edge;
import de.uni_koblenz.jgralab.Graph;
import de.uni_koblenz.jgralab.GraphIO;
import de.uni_koblenz.jgralab.ImplementationType;
import de.uni_koblenz.jgralab.Vertex;
import de.uni_koblenz.jgralab.exception.GraphIOException;
import de.uni_koblenz.jgralab.greql.GreqlQuery;
import de.uni_koblenz.jgralab.greql.evaluator.GreqlEnvironmentAdapter;
import de.uni_koblenz.jgralab.greql.evaluator.GreqlEvaluatorImpl;
import de.uni_koblenz.jgralab.schema.GraphClass;
import de.uni_koblenz.jgralab.schema.Schema;
//import de.uni_koblenz.jgralab.schema.impl.SchemaImpl;

public class CreateGraph {
	
	static String schemaFileName="GraphSchema";
	private EPackage pl0MM;
	private Resource pl0MMResource;
	private Graph graph;
	
	private Map<String,Vertex> vertexlist;
//	private Map<String,Edge> edgelist;
//	private Map<String,Edge> inheritlist;
	
	
	public Resource getResource() {
		return pl0MMResource;
	}
	
	public Graph getGraph(){
		return graph;
	}
	
	
	public void createGraph(){
		vertexlist=new HashMap<String, Vertex>();
//		edgelist=new HashMap<String, Edge>();
//		inheritlist=new HashMap<String, Edge>();
		Schema schema=null;
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
						Vertex v=graph.createVertex(graphClass.getVertexClass("Node"));
						v.setAttribute("name", classifier.getName());
						vertexlist.put(classifier.getName(), v);
					}
				}
			}
		}
		
		System.out.println("Create Inheritances");
		
		for (EObject model : contents) {
			if(model instanceof EPackage){
				EPackage epackage = (EPackage) model;
				EList<EClassifier> classifiers = epackage.getEClassifiers();
				for (EClassifier classifier : classifiers) {
					if(classifier instanceof EClass){
						if (!((EClass) classifier).getEAllSuperTypes().isEmpty()){
							EList<EClass> allSuperTypes=((EClass) classifier).getEAllSuperTypes();
							for (EClass superClass:allSuperTypes){
								Vertex v1 = vertexlist.get(classifier.getName());
								Vertex v2 = vertexlist.get(superClass.getName());
								Edge e = graph.createEdge(graphClass.getEdgeClass("Inheritance"),
										v1, v2);
								e.setAttribute("child", v1.getAttribute("name"));
								e.setAttribute("parent", v2.getAttribute("name"));
//								inheritlist.put("Inheritance"+v1.getAttribute("name")+"To"+v2.getAttribute("name"), e);
//								e.setAttribute("name", "Inheritance"+v1.getAttribute("name")+"To"+
//										v2.getAttribute("name"));
//								e.setAttribute("connectionType", "INHERITANCE");
							}
						}
					}
				}
			}
		}
		
		System.out.println("Create normal Edges");
		
		for (EObject model : contents) {
			if(model instanceof EPackage){
				EPackage epackage = (EPackage) model;
				EList<EClassifier> classifiers = epackage.getEClassifiers();
				for (EClassifier classifier : classifiers) {
					if(classifier instanceof EClass){
						if (!((EClass) classifier).getEAllReferences().isEmpty()){
							EList<EReference> refList=((EClass) classifier).getEAllReferences();
							for (EReference ref:refList){
								Vertex v1 = vertexlist.get(classifier.getName());
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
//								edgelist.put(ref.getName(),e);
//								System.out.println(v2+ " "+v2.getAttribute("name"));
//								Iterable<Edge> test=v2.incidences();
//								Iterator<Edge> it=test.iterator();
//								int i=0;
//								while(it.hasNext()){
////									int i=0;
//									i++;
//									Edge next=it.next();
//									if(next.getAttributedElementClass().getSimpleName().equals("Inheritance")){
//										System.out.println("Inheritance");
//									}
//									else{
//										System.out.println(i+" "+next+" "+next.getAlpha()+"->"+next.getOmega()+" "+next.getAttribute("name"));
//									}
//								}
							}
						}
					}
				}
			}
		}
		
//		System.out.println("Create inherited Edges");
		
//		for (EObject model : contents) {
//			if(model instanceof EPackage){
//				EPackage epackage = (EPackage) model;
//				EList<EClassifier> classifiers = epackage.getEClassifiers();
//				for (EClassifier classifier : classifiers) {
//					if(classifier instanceof EClass){
//						Vertex v1 = vertexlist.get(classifier.getName());
//						Iterable<Edge> test=v1.incidences();
//						Iterator<Edge> it=test.iterator();
//						int i=0;
//						System.out.println(v1+" "+v1.getAttribute("name"));
//						while(it.hasNext()){
//							i++;
//							Edge next=it.next();
//							if(next.getAttributedElementClass().getSimpleName().equals("Inheritance")){
//								Vertex v=next.getOmega();
//
//								Vertex high=getHighestVertexInHierarchy(v);
//								Iterable<Edge> highEdge=high.incidences();
//								Iterator<Edge> itHigh=highEdge.iterator();
//								ArrayList<Edge> edges=new ArrayList<Edge>();
//
//								while (itHigh.hasNext()){
//									Edge next2=itHigh.next();
//									if(!next2.getAttributedElementClass().getSimpleName().equals("Inheritance")){
//										edges.add(next2);
//									}
//								}
//								
//								ArrayList<Vertex> verticesBelow=new ArrayList<Vertex>();
//								verticesBelow=getLowerVerticesInHierarchy(v);
//								for (int help=0;help<verticesBelow.size();help++){
//									for (int help2=0;help2<edges.size();help2++){
//										Vertex vSource=edges.get(help2).getAlpha();
//										Vertex vTarget=edges.get(help2).getOmega();
//										String name=edges.get(help2).getAttribute("name");
//										String ct=edges.get(help2).getAttribute("connectionType");
//										if (vSource.equals(high)){
//											vSource=verticesBelow.get(help);
//											
//											Edge e = graph.createEdge(graphClass.getEdgeClass("Connection"),
//													vSource, vTarget);
//											e.setAttribute("name", name);
//											e.setAttribute("connectionType", ct);
//											System.out.println("new Edge: "+vSource.getAttribute("name")+"->"+vTarget.getAttribute("name")+" "+
//													e.getAttribute("name"));
//										}
//										else{
//											if (vTarget.equals(high)){
//												vTarget=verticesBelow.get(help);
//												
//												Edge e = graph.createEdge(graphClass.getEdgeClass("Connection"),
//														vSource, vTarget);
//												e.setAttribute("name", name);
//												e.setAttribute("connectionType", ct);
//												System.out.println("new Edge: "+vSource.getAttribute("name")+"->"+vTarget.getAttribute("name")+" "+
//														e.getAttribute("name"));
//											}
//											else{
//												System.out.println("Sth wrong!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//											}
//										}
//									}
//								}
//								for (int i17=0;i17<verticesBelow.size();i17++){
//									System.out.println("  VB: "+verticesBelow.get(i17)+" "+verticesBelow.get(i17).getAttribute("name"));
//								}
//							}
//							else{
////								System.out.println(i+" "+next+" "+next.getAlpha()+"->"+next.getOmega()+" "+next.getAttribute("name"));
//							}
//						}
//					}
//				}
//			}
//		}
		schema.finish();
		
		path="C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/StructurPL0";
		try {
			graph.save(path);
		} catch (GraphIOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createGraphWithInheritance(){
		vertexlist=new HashMap<String, Vertex>();
//		edgelist=new HashMap<String, Edge>();
//		inheritlist=new HashMap<String, Edge>();
//		ArrayList<Edge> inherit=new ArrayList<Edge>();
		ArrayList<Edge> edgesL=new ArrayList<Edge>();
		ArrayList<ArrayList<Vertex>> inheritlists=new ArrayList<ArrayList<Vertex>>();
		HashMap<String, Edge> edgeListToControl=new HashMap<String, Edge>();
		Schema schema=null;
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
						Vertex v=graph.createVertex(graphClass.getVertexClass("Node"));
						v.setAttribute("name", classifier.getName());
						vertexlist.put(classifier.getName(), v);
						System.out.println(v);
					}
				}
			}
		}
		
		System.out.println("Create Inheritances");
		
		for (EObject model : contents) {
			if(model instanceof EPackage){
				EPackage epackage = (EPackage) model;
				EList<EClassifier> classifiers = epackage.getEClassifiers();
				for (EClassifier classifier : classifiers) {
					if(classifier instanceof EClass){
						if (!((EClass) classifier).getEAllSuperTypes().isEmpty()){
							EList<EClass> allSuperTypes=((EClass) classifier).getEAllSuperTypes();
							for (EClass superClass:allSuperTypes){
								ArrayList<Vertex> il=new ArrayList<Vertex>();
								Vertex v1 = vertexlist.get(classifier.getName());
								Vertex v2 = vertexlist.get(superClass.getName());
								il.add(v1);
								il.add(v2);
								inheritlists.add(il);
								//TODO
//								Edge e = graph.createEdge(graphClass.getEdgeClass("Inheritance"),
//										v1, v2);
//								e.setAttribute("child", v1.getAttribute("name"));
//								e.setAttribute("parent", v2.getAttribute("name"));
//								inheritlist.put("Inheritance"+v1.getAttribute("name")+"To"+v2.getAttribute("name"), e);
//								inherit.add(e);
//								System.out.println(e);
//								e.setAttribute("name", "Inheritance"+v1.getAttribute("name")+"To"+
//										v2.getAttribute("name"));
//								e.setAttribute("connectionType", "INHERITANCE");
							}
						}
					}
				}
			}
		}
		
		System.out.println("Create normal Edges");
		
		for (EObject model : contents) {
			if(model instanceof EPackage){
				EPackage epackage = (EPackage) model;
				EList<EClassifier> classifiers = epackage.getEClassifiers();
				for (EClassifier classifier : classifiers) {
					if(classifier instanceof EClass){
						if (!((EClass) classifier).getEAllReferences().isEmpty()){
							EList<EReference> refList=((EClass) classifier).getEAllReferences();
							for (EReference ref:refList){
								Vertex v1 = vertexlist.get(classifier.getName());
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
//								edgelist.put(ref.getName(),e);
								edgesL.add(e);
								String key=e.getAttribute("connectionType").toString()+e.getAttribute("name").toString()+e.getAttribute("source").toString()+e.getAttribute("target").toString();
								assertTrue(!edgeListToControl.containsKey(key));
								edgeListToControl.put(key, e);
								System.out.println(e);
//								System.out.println(v2+ " "+v2.getAttribute("name"));
								
//								Iterable<Edge> test=v2.incidences();
//								Iterator<Edge> it=test.iterator();
//								int i=0;
//								while(it.hasNext()){
////									int i=0;
//									i++;
//									Edge next=it.next();
//									if(next.getAttributedElementClass().getSimpleName().equals("Inheritance")){
//										System.out.println("Inheritance");
//									}
//									else{
//										System.out.println(i+" "+next+" "+next.getAlpha()+"->"+next.getOmega()+" "+next.getAttribute("name"));
//									}
//								}
							}
						}
					}
				}
			}
		}
		
		System.out.println("Create inherited Edges");
		
		for (EObject model : contents) {
			if(model instanceof EPackage){
				EPackage epackage = (EPackage) model;
				EList<EClassifier> classifiers = epackage.getEClassifiers();
				for (EClassifier classifier : classifiers) {
					if(classifier instanceof EClass){
						Vertex v1 = vertexlist.get(classifier.getName());
//						for (Edge e:inherit){
						for (ArrayList<Vertex> il:inheritlists){
							System.out.println("1 Ich bin hier!!!!!!!!!!!!!!!!!!!!");
//							if (e.getAttribute("child").equals(v1.getAttribute("name"))){
							if (il.get(0).getAttribute("name").equals(v1.getAttribute("name"))){
//								Vertex sup=vertexlist.get(e.getAttribute("parent"));
								System.out.println("2 Ich bin hier!!!!!!!!!!!!!!!!!!!!");
								Vertex sup=il.get(1);
								for (Edge e2:edgesL){
									if (vertexlist.get(e2.getAttribute("source")).equals(sup)){
										String key=e2.getAttribute("connectionType").toString()+e2.getAttribute("name").toString()+v1.getAttribute("name").toString()+vertexlist.get(e2.getAttribute("target")).getAttribute("name").toString();
										if(!(edgeListToControl.containsKey(key))){
											System.out.println("Geklappt: "+key);
											Edge eNew = graph.createEdge(graphClass.getEdgeClass("Connection"),
													v1, vertexlist.get(e2.getAttribute("target")));
											eNew.setAttribute("name", e2.getAttribute("name"));
											eNew.setAttribute("source", v1.getAttribute("name"));
											eNew.setAttribute("target", vertexlist.get(e2.getAttribute("target")).getAttribute("name"));
											eNew.setAttribute("connectionType", e2.getAttribute("connectionType"));
//											edgesL.add(eNew);
											edgeListToControl.put(key, eNew);
											System.out.println(eNew);
										}
										else{
											System.out.println("Nicht geklappt: "+key);
										}
									}
									else{
										if (vertexlist.get(e2.getAttribute("target")).equals(sup)){
											String key=e2.getAttribute("connectionType").toString()+e2.getAttribute("name").toString()+vertexlist.get(e2.getAttribute("source")).getAttribute("name").toString()+v1.getAttribute("name").toString();
											if(!(edgeListToControl.containsKey(key))){
												System.out.println("Geklappt: "+key);
												Edge eNew = graph.createEdge(graphClass.getEdgeClass("Connection"),
														vertexlist.get(e2.getAttribute("source")), v1);
												eNew.setAttribute("name", e2.getAttribute("name"));
												eNew.setAttribute("source", vertexlist.get(e2.getAttribute("source")).getAttribute("name"));
												eNew.setAttribute("target", v1.getAttribute("name"));
												eNew.setAttribute("connectionType", e2.getAttribute("connectionType"));
//												edgesL.add(eNew);
												edgeListToControl.put(key, eNew);
												System.out.println(eNew);
											}
											else{
												System.out.println("Nicht geklappt: "+key);
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
		for (String key:edgeListToControl.keySet()){
			System.out.println("Vorhanden: "+key);
		}
		schema.finish();
		
		path="C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/StructurNew3";
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
//		Edge e2 = graph.createEdge(graphClass.getEdgeClass("Inheritance"),
//				v3, v1); //v3=child, v1=parent
//		Edge e3 = graph.createEdge(graphClass.getEdgeClass("Inheritance"),
//				v2, v4);
		schema.finish();
		
		path="C:/Users/Robert/testGReQL/GReQLPrototyp/src/StructureSimple";
		try {
			graph.save(path);
		} catch (GraphIOException e) {
			e.printStackTrace();
		}
	}
	
	private void test(){
		File file=new File("C:/Users/Robert/testGReQL/GReQLPrototyp/src/test2.tg");
		System.out.println("test");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, graph, new GreqlEnvironmentAdapter());
		
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
	}
	
//	private ArrayList<Vertex> getLowerVerticesInHierarchy(Vertex v) {
//		ArrayList<Vertex> lowerVertices=new ArrayList<Vertex>();//=vList;
//		Iterable<Edge> test=v.incidences();
//		Iterator<Edge> it=test.iterator();
//		while (it.hasNext()){
//			Edge next=it.next();
//			if (next.getAttributedElementClass().getSimpleName().equals("Inheritance")){
//				Vertex v_new=next.getAlpha();
//				if (!lowerVertices.contains(v_new)){
//					lowerVertices.add(v_new);
////					getLowerVerticesInHierarchy(lowerVertices, v_new);
//				}
//			}
//		}
//		return lowerVertices;
//	}


//	private Vertex getHighestVertexInHierarchy(Vertex v) {
//		Vertex high=v;
//		Iterable<Edge> test=v.incidences();
//		Iterator<Edge> it=test.iterator();
////		boolean goHigher=false;
//		while (it.hasNext()){
//			Edge next=it.next();
//			if(next.getAttributedElementClass().getSimpleName().equals("Inheritance")){
//				Vertex v_new=next.getOmega();
//				if (!v_new.equals(high)){
//					high=getHighestVertexInHierarchy(v_new);
//				}
//			}
//		}
//		System.out.println("getHighest"+high+" "+high.getAttribute("name"));
//		return high;
//	}


	public void init(){
		initLanguages();
		initPL0MM();
	}

	private void initLanguages() {
		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new Pl0MetaInformation().getSyntaxName(), new Pl0ResourceFactory());
	}

	private void initPL0MM() {
		pl0MM = (EPackage) EPackage.Registry.INSTANCE.get(PL0Package.eNS_URI);
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
		pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
	}
	
	
	
	public static void main(String[] args){
		CreateGraph t=new CreateGraph();
		t.init();
		t.createGraphWithInheritance();
		t.test();
	}

}
