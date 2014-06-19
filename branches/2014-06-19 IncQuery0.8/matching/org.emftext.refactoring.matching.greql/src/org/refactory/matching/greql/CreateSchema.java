package org.refactory.matching.greql;

import de.uni_koblenz.jgralab.GraphIO;
import de.uni_koblenz.jgralab.exception.GraphIOException;
import de.uni_koblenz.jgralab.schema.AggregationKind;
//import de.uni_koblenz.jgralab.schema.Domain;
import de.uni_koblenz.jgralab.schema.EdgeClass;
import de.uni_koblenz.jgralab.schema.CollectionDomain;
import de.uni_koblenz.jgralab.schema.EnumDomain;
//import de.uni_koblenz.jgralab.schema.EnumDomain;
import de.uni_koblenz.jgralab.schema.GraphClass;
import de.uni_koblenz.jgralab.schema.ListDomain;
import de.uni_koblenz.jgralab.schema.MapDomain;
import de.uni_koblenz.jgralab.schema.Schema;
import de.uni_koblenz.jgralab.schema.SetDomain;
import de.uni_koblenz.jgralab.schema.VertexClass;
import de.uni_koblenz.jgralab.schema.codegenerator.CodeGeneratorConfiguration;
import de.uni_koblenz.jgralab.schema.impl.SchemaImpl;

public class CreateSchema {
	
	static String schemaFileName="GraphSchema";
	static Schema schema;
	
	
	public static void createSchema(){
		Schema schema = new SchemaImpl("GraphSchema", "de.uni_koblenz.jgralab.demo.schema");
		GraphClass graphClass = schema.createGraphClass("GraphModel");
		EnumDomain edConnectionType = schema.createEnumDomain("ConnectionType", "AGGREGATION",
				"ASSOCIATION");
//		ListDomain
//		SetDomain
//		CollectionDomain
//		MapDomain
		
		VertexClass vcNode = graphClass.createVertexClass("Node");
		vcNode.createAttribute("name", schema.getStringDomain());
//		vcRole.createAttribute("roleModifier", schema.getEnumDomains());
//		vcRole.createAttribute("roleModifier", schema.getStringDomain());
		
		EdgeClass ecConnection = graphClass.createEdgeClass("Connection",
				vcNode, 0, Integer.MAX_VALUE, "source", AggregationKind.NONE,
				vcNode, 0, Integer.MAX_VALUE, "target", AggregationKind.NONE);
		ecConnection.createAttribute("name", schema.getStringDomain());
		ecConnection.createAttribute("connectionType", edConnectionType);
		ecConnection.createAttribute("source", schema.getStringDomain());
		ecConnection.createAttribute("target", schema.getStringDomain());
		
//		EdgeClass ecInheritance = graphClass.createEdgeClass("Inheritance",
//				vcNode, 1, 1, "child", AggregationKind.NONE,
//				vcNode, 1, 1, "parent", AggregationKind.NONE);
//		ecInheritance.createAttribute("child", schema.getStringDomain());
//		ecInheritance.createAttribute("parent", schema.getStringDomain());
		
//		EdgeClass ecRoleImplication = graphClass.createEdgeClass("RoleImplication",
//				vcRole, 0, Integer.MAX_VALUE, "sourceRI", AggregationKind.NONE,
//				vcRole, 0, Integer.MAX_VALUE, "targetRI", AggregationKind.NONE);
//		ecRoleImplication.addSuperClass(ecCollaboration);
//		
//		EdgeClass ecRoleProhibition = graphClass.createEdgeClass("RoleProhibition",
//				vcRole, 0, Integer.MAX_VALUE, "sourceRP", AggregationKind.NONE,
//				vcRole, 0, Integer.MAX_VALUE, "targetRP", AggregationKind.NONE);
//		ecRoleProhibition.addSuperClass(ecCollaboration);
//		
//		EdgeClass ecMultiplicityCollaboration = graphClass.createEdgeClass("MultiplicityCollaboration",
//				vcRole, 0, Integer.MAX_VALUE, "sourceMC", AggregationKind.NONE,
//				vcRole, 0, Integer.MAX_VALUE, "targetMC", AggregationKind.NONE);
//		ecMultiplicityCollaboration.addSuperClass(ecCollaboration);
//		ecMultiplicityCollaboration.createAttribute("lowerBoundSource", schema.getIntegerDomain());
//		ecMultiplicityCollaboration.createAttribute("upperBoundSource", schema.getIntegerDomain());
//		ecMultiplicityCollaboration.createAttribute("lowerBoundTarget", schema.getIntegerDomain());
//		ecMultiplicityCollaboration.createAttribute("upperBoundTarget", schema.getIntegerDomain());
//		ecMultiplicityCollaboration.createAttribute("sourceName", schema.getStringDomain());
//		ecMultiplicityCollaboration.createAttribute("targetName", schema.getStringDomain());
//		ecMultiplicityCollaboration.setAbstract(true);
//		
//		EdgeClass ecRoleAssociation = graphClass.createEdgeClass("RoleAssociation",
//				vcRole, 0, Integer.MAX_VALUE, "sourceRA", AggregationKind.NONE,
//				vcRole, 0, Integer.MAX_VALUE, "targetRA", AggregationKind.NONE);
//		ecRoleAssociation.addSuperClass(ecMultiplicityCollaboration);
//		
//		EdgeClass ecRoleComposition = graphClass.createEdgeClass("RoleComposition",
//				vcRole, 0, Integer.MAX_VALUE, "sourceRC", AggregationKind.NONE,
//				vcRole, 0, Integer.MAX_VALUE, "targetRC", AggregationKind.NONE);
//		ecRoleComposition.addSuperClass(ecMultiplicityCollaboration);
		
//		VertexClass vcCommentable = graphClass.createVertexClass("Commentable");
//		vcCommentable.createAttribute("comment", schema.getStringDomain());
//		vcCommentable.setAbstract(true);
		
		//NamedElement: String name, SuperType: Commentable
//		VertexClass vcNamedElement = graphClass.createVertexClass("NamedElement");
//		vcNamedElement.createAttribute("name", schema.getStringDomain());
//		vcNamedElement.addSuperClass(vcCommentable);
//		vcNamedElement.setAbstract(true);
		
		//Role: Collaboration outgoing, target, RoleModifier modifier
		//RoleAttribute attributes, SuperType: NamedElement
//		VertexClass vcRole = graphClass.createVertexClass("Role");
//		vcRole.createAttribute("outgoing", (Domain) schema.getCompositeDomains());
//		vcRole.createAttribute("target", (Domain) schema.getCompositeDomains());
//		vcRole.addSuperClass(vcNamedElement);
		
//		EdgeClass ecImports = graphClass.createEdgeClass("RoleFeature", 
//				vcRole, 0, Integer.MAX_VALUE, "source", AggregationKind.NONE, 
//				vcRole, 0, Integer.MAX_VALUE, "namedelement", AggregationKind.NONE);
//		ecImports.setAbstract(true);
		
//		EdgeClass ecImports = graphClass.createEdgeClass("RoleFeature", 
//				vcRole, 0, Integer.MAX_VALUE, "source", AggregationKind.NONE, 
//				vcRole, 0, Integer.MAX_VALUE, "namedelement", AggregationKind.NONE);
//		ecImports.setAbstract(true);
		
//		EdgeClass ecCollaboration = graphClass.createEdgeClass("Collaboration", 
//				vcRole, 0, Integer.MAX_VALUE, "source", AggregationKind.NONE, 
//				vcRole, 0, Integer.MAX_VALUE, "target", AggregationKind.NONE);
//		ecImports.setAbstract(true);
		
//		EdgeClass ecCollaboration = graphClass.createEdgeClass("Collaboration", 
//				vcRole, 0, Integer.MAX_VALUE, "source", AggregationKind.NONE, 
//				vcRole, 0, Integer.MAX_VALUE, "target", AggregationKind.NONE);
//		ecImports.setAbstract(true);

//		vcCollaboration.createAttribute("simpleName", schema.getStringDomain());
//		vcCollaboration.setAbstract(true);
		
//		VertexClass vcJavaType = graphClass.createVertexClass("JavaType");
//		vcJavaType.addSuperClass(vcNamedElement);
//		vcJavaType.createAttribute("kind", edTypeKind);
//		vcJavaType.createAttribute("abstract",schema.getBooleanDomain());
		
//		VertexClass vcJavaPackage=graphClass.createVertexClass("JavaPackage");
//		vcJavaPackage.addSuperClass(vcNamedElement);
		
//		VertexClass vcJavaMember=graphClass.createVertexClass("JavaMember");
//		vcJavaPackage.addSuperClass(vcNamedElement);
		
//		EdgeClass ecImports = graphClass.createEdgeClass("Imports", 
//				vcSourceFile, 0, Integer.MAX_VALUE, "", AggregationKind.NONE, 
//				vcNamedElement, 0, Integer.MAX_VALUE, "namedelement", AggregationKind.NONE);
//		ecImports.createAttribute("lineNumber", schema.getIntegerDomain());
		
//		EdgeClass ecContainsType = graphClass.createEdgeClass("ContainsType", 
//				vcJavaPackage, 0, 1, "", AggregationKind.NONE, 
//				vcJavaType, 0, Integer.MAX_VALUE, "", AggregationKind.SHARED);
		
//		EdgeClass ecDefines = graphClass.createEdgeClass("Defines",
//				vcSourceFile, 0, 1, "", AggregationKind.NONE,
//				vcJavaType, 0, Integer.MAX_VALUE, "javatype", AggregationKind.NONE);
//		ecDefines.createAttribute("lineNumber", schema.getIntegerDomain());
		
//		EdgeClass ecDeclares = graphClass.createEdgeClass("Declares", 
//				vcJavaType, 0, 1, "javaType", AggregationKind.NONE, 
//				vcNamedElement, 0, Integer.MAX_VALUE, "javaMember", AggregationKind.SHARED);
		
//		EdgeClass ecContainsPackage = graphClass.createEdgeClass("ContainsPackage", 
//				vcJavaPackage, 0, 1, "", AggregationKind.NONE, 
//				vcJavaPackage, 0, Integer.MAX_VALUE, "subPackage", AggregationKind.SHARED);
		
		schema.finish();
		try {
			schema.save(schemaFileName);
		} catch (GraphIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			schema.commit("src", CodeGeneratorConfiguration.NORMAL);
		} catch (GraphIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadGraph(){
		try {
			schema = GraphIO.loadSchemaFromFile(schemaFileName);
		} catch (GraphIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		createSchema();
	}

}