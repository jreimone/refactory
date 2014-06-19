package org.modelrefactoring.guery.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;

import com.orientechnologies.orient.client.remote.OServerAdmin;
import com.orientechnologies.orient.core.config.OGlobalConfiguration;
import com.orientechnologies.orient.core.db.graph.OGraphDatabase;
import com.orientechnologies.orient.core.intent.OIntentMassiveInsert;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OProperty;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.TransactionalGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;

public class OrientPersistResultListener2 implements AdditionalResultListener {

	private static final String DB_TYPE 											= "local";
	private static final String CONCRETE_MAPPING_PROPERTY 						= "concreteMapping";
	private static final String COLL_MAPPING_PROPERTY 							= "collaborationMapping";
	private static final String DB_ADMIN 											= "superadmin";
	private static final String DB_PASS 											= "kuCh3n$%";
	private static final String DB_SERVER_STRING 									= "remote:hudson-st.inf.tu-dresden.de/";
	private static final String REFERENCE_META_CLASS_PAIR__INDEX_PROPERTY 		= "index";
	// 's' muss angehangen werden, da die Referenz im Metamodell klein geschrieben ist und somit genauso heißt
	// wie der VertexType von 'ReferenceMetaclassPair', da alle VertexTypes mit kleinem Anfangsbuchstaben anfangen
	private static final String COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR	= RolemappingPackage.Literals.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR.getName() + "s";

	private EPackage targetMetamodel;

	private OrientGraphNoTx database;
//	private TransactionalGraph graph;
	private OrientGraphNoTx graph;

	private OProperty roleMappingRoleModelP;
	private OProperty concreteMappingRoleP;
	private OProperty concreteMappingMetaclassP;
	private OProperty collMappingCollP;
	private OProperty refMetaClassPairRefP;
	private OProperty refMetaClassPairMetaclassP;
//	private OProperty refMetaClassPairIndexP;
	private OProperty roleMappingRole2MetaR;
//	private OProperty concreteMappingCollMappingR;
//	private OProperty collMappingRefMClassPairR;
	private OClass roleMappingC;
	private OClass concreteMappingC;
	private OClass collMappingC;
	private OClass refMetaClassPairC;
	private OClass roleMapCollMapE;
	private OProperty roleMapCollMapConcMapP;
	private OClass roleMapRefMetaCPairE;
	private OProperty roleMapRefMetaCPairIndexP;
	
	private Map<String, Vertex> concreteMappingVertices = new HashMap<String, Vertex>();
	private Map<String, Vertex> collMappingVertices = new HashMap<String, Vertex>();
	private Map<String, Vertex> refMetaCPairVertices = new HashMap<String, Vertex>();
	private OProperty roleMapRefMetaCPairConcMapP;
	private OProperty roleMapRefMetaCPairCollMapP;

	public OrientPersistResultListener2(EPackage targetMetamodel) {
		this.targetMetamodel = targetMetamodel;
	}

	@Override
	public void found(Object... something) {
		if(something != null && something[0] instanceof RoleMapping){
			OrientGraphNoTx graph = getGraphForMetamodel(targetMetamodel);
			RoleMapping roleMapping = (RoleMapping) something[0];
			persistRoleMapping(roleMapping, graph);
		}
	}


	protected void persistRoleMapping(RoleMapping roleMapping, OrientGraphNoTx graph) {
		if(graph != null){
//			if(database.isClosed()){
//				System.err.println("DB was closed");
//				database = database.open(DB_ADMIN, DB_PASS);
//			}
			RoleModel roleModel = roleMapping.getMappedRoleModel();
			Vertex roleMappingV = graph.addVertex("class:" + roleMappingC.getName());
			roleMappingV.setProperty(roleMappingRoleModelP.getName(), roleModel.getName());
			List<ConcreteMapping> concreteMappings = roleMapping.getRoleToMetaelement();
			for (ConcreteMapping concreteMapping : concreteMappings) {
				Role role = concreteMapping.getRole();
				EClass metaclass = concreteMapping.getMetaclass();
				
				String key = role.getName() + ":" + metaclass.getName();
				Vertex concreteMappingV = concreteMappingVertices.get(key);
				if(concreteMappingV == null){
					concreteMappingV = graph.addVertex("class:" + concreteMappingC.getName());
					concreteMappingV.setProperty(concreteMappingRoleP.getName(), role.getName());
					concreteMappingV.setProperty(concreteMappingMetaclassP.getName(), metaclass.getName());
					concreteMappingVertices.put(key, concreteMappingV);
				}
				roleMappingV.addEdge(roleMappingRole2MetaR.getName(), concreteMappingV);
				List<CollaborationMapping> collaborationMappings = concreteMapping.getCollaborationMappings();
				for (CollaborationMapping collaborationMapping : collaborationMappings) {
					MultiplicityCollaboration collaboration = collaborationMapping.getCollaboration();
					key = collaboration.getTargetName();
					Vertex collMappingV = collMappingVertices.get(key);
					if(collMappingV == null){
						collMappingV = graph.addVertex("class:" + collMappingC.getName());
						collMappingVertices.put(key, collMappingV);
						collMappingV.setProperty(collMappingCollP.getName(), key);
					}
					Edge roleMapCollMapEdge = roleMappingV.addEdge(roleMapCollMapE.getName(), collMappingV);
					roleMapCollMapEdge.setProperty(roleMapCollMapConcMapP.getName(), concreteMappingV);
					
					List<ReferenceMetaClassPair> pairList = collaborationMapping.getReferenceMetaClassPair();
					for (ReferenceMetaClassPair pair : pairList) {
						EReference reference = pair.getReference();
						metaclass = pair.getMetaClass();
						key = reference.getName() + ":" + metaclass.getName();
						Vertex refMetaClassPairV = refMetaCPairVertices.get(key);
						if(refMetaClassPairV == null){
							refMetaClassPairV = graph.addVertex("class:" + refMetaClassPairC.getName());
							refMetaClassPairV.setProperty(refMetaClassPairRefP.getName(), reference.getName());
							refMetaClassPairV.setProperty(refMetaClassPairMetaclassP.getName(), metaclass.getName());
							refMetaCPairVertices.put(key, refMetaClassPairV);
						}
						Edge roleMapRefMetaCPairEdge = roleMappingV.addEdge(roleMapRefMetaCPairE.getName(), refMetaClassPairV);
						roleMapRefMetaCPairEdge.setProperty(roleMapRefMetaCPairCollMapP.getName(), collMappingV);
						roleMapRefMetaCPairEdge.setProperty(roleMapRefMetaCPairConcMapP.getName(), concreteMappingV);
						roleMapRefMetaCPairEdge.setProperty(roleMapRefMetaCPairIndexP.getName(), pairList.indexOf(pair));
					}
				}
			}
			graph.commit();
		}
	}

	private void schema(OrientGraphNoTx database2){
		if(database2.isClosed()){
			database2 = database2.getRawGraph().open(DB_ADMIN, DB_PASS);
		}
//		database2.setUseCustomTypes(true);
		// RoleMapping
		roleMappingC 				= database2.createVertexType(RoleMapping.class.getSimpleName()).setOverSize(2);
		roleMappingRoleModelP 		= roleMappingC.createProperty(RolemappingPackage.Literals.ROLE_MAPPING__MAPPED_ROLE_MODEL.getName(), OType.STRING);
		// ConcreteMapping
		concreteMappingC 			= database2.createVertexType(ConcreteMapping.class.getSimpleName()).setOverSize(2);
		roleMappingRole2MetaR 		= roleMappingC.createProperty(RolemappingPackage.Literals.ROLE_MAPPING__ROLE_TO_METAELEMENT.getName(), OType.LINKLIST, concreteMappingC);
		concreteMappingRoleP 		= concreteMappingC.createProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__ROLE.getName(), OType.STRING);
		concreteMappingMetaclassP 	= concreteMappingC.createProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__METACLASS.getName(), OType.STRING);
		// CollaborationMapping
		collMappingC 				= database2.createVertexType(CollaborationMapping.class.getSimpleName()).setOverSize(2);
		collMappingCollP 			= collMappingC.createProperty(RolemappingPackage.Literals.COLLABORATION_MAPPING__COLLABORATION.getName(), OType.STRING);
		// ReferenceMetaclassPair
		refMetaClassPairC			= database2.createVertexType(ReferenceMetaClassPair.class.getSimpleName()).setOverSize(2);
		refMetaClassPairRefP		= refMetaClassPairC.createProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__REFERENCE.getName(), OType.STRING);
		refMetaClassPairMetaclassP	= refMetaClassPairC.createProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__META_CLASS.getName(), OType.STRING);
		// EdgeType: Collaborations
		roleMapCollMapE = database2.createEdgeType(roleMappingC.getName() + collMappingC.getName() + "s").setOverSize(2);
		roleMapCollMapConcMapP = roleMapCollMapE.createProperty(CONCRETE_MAPPING_PROPERTY, OType.LINK, concreteMappingC);
		// EdgeType: ReferenceMetaclassPairs
		roleMapRefMetaCPairE = database2.createEdgeType(roleMappingC.getName() + refMetaClassPairC.getName() + "s").setOverSize(2);
		roleMapRefMetaCPairConcMapP = roleMapRefMetaCPairE.createProperty(CONCRETE_MAPPING_PROPERTY, OType.LINK, concreteMappingC);
		roleMapRefMetaCPairCollMapP = roleMapRefMetaCPairE.createProperty(COLL_MAPPING_PROPERTY, OType.LINK, collMappingC);
		roleMapRefMetaCPairIndexP = roleMapRefMetaCPairE.createProperty(REFERENCE_META_CLASS_PAIR__INDEX_PROPERTY, OType.INTEGER);
		
		// indices
//		roleMappingC.createIndex("roleModelIndex", OClass.INDEX_TYPE.NOTUNIQUE_HASH_INDEX, roleMappingRoleModelP.getName());
//		concreteMappingC.createIndex("roleMetaclassIndex", OClass.INDEX_TYPE.NOTUNIQUE_HASH_INDEX, concreteMappingRoleP.getName(), concreteMappingMetaclassP.getName());
		
		roleMappingC.createIndex("roleModelIndex", OClass.INDEX_TYPE.NOTUNIQUE, roleMappingRoleModelP.getName());
		concreteMappingC.createIndex("roleMetaclassIndex", OClass.INDEX_TYPE.UNIQUE, concreteMappingRoleP.getName(), concreteMappingMetaclassP.getName());
		collMappingC.createIndex("collaborationIndex", OClass.INDEX_TYPE.UNIQUE, collMappingCollP.getName());
		refMetaClassPairC.createIndex("referenceMetaclassIndex", OClass.INDEX_TYPE.UNIQUE, refMetaClassPairRefP.getName(), refMetaClassPairMetaclassP.getName());
		
		database2.commit();
	}
	
	private OrientGraphNoTx getGraphForMetamodel(EPackage targetMetamodel){
		if(database == null){
			String name = targetMetamodel.getName();
			String nsURI = targetMetamodel.getNsURI();
			String dbName = name + "_" + nsURI.replaceAll("[/:,\\.]", "_") + "_2";
			try {
				OServerAdmin admin = new OServerAdmin(DB_SERVER_STRING + dbName);
				admin.connect(DB_ADMIN, DB_PASS);
				if(!admin.existsDatabase(DB_TYPE)){
					admin.createDatabase("graph", DB_TYPE);
//					database = new OGraphDatabase(DB_SERVER_STRING + dbName);
					database = new OrientGraphNoTx(DB_SERVER_STRING + dbName);
//					initSchema(database);
					schema(database);
					performanceTuning(database);
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			if(database == null){
//				database = new OGraphDatabase(DB_SERVER_STRING + dbName);
				database = new OrientGraphNoTx(DB_SERVER_STRING + dbName);
			}
			if(database.isClosed()){
//				database = database.open(DB_ADMIN, DB_PASS);
				database = database.getRawGraph().open(DB_ADMIN, DB_PASS);
			}
		}
		if(graph == null){
//			graph = new OrientGraph(database);
			graph = new OrientGraphNoTx(database.getRawGraph());
		}
		return graph;
	}

	private void performanceTuning(OrientGraphNoTx database2) {
		OGlobalConfiguration.TX_USE_LOG.setValue(false);
		database.getRawGraph().declareIntent(new OIntentMassiveInsert());
	}

	@Override
	public void done() {
		System.out.println("Close Graph and DB");
		if(graph != null){
			graph.commit();
			graph.shutdown();
		}
		if(database != null){
			database.getRawGraph().declareIntent(null);
			database.commit();
			database.getRawGraph().close();
		}
	}
}
