package org.modelrefactoring.guery.test;

import java.io.IOException;
import java.util.List;

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
import com.tinkerpop.blueprints.TransactionalGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;

public class OrientPersistResultListener implements AdditionalResultListener {

	private static final String DB_TYPE 											= "local";
	private static final String DB_ADMIN 											= "superadmin";
	private static final String DB_PASS 											= "kuCh3n$%";
	private static final String DB_SERVER_STRING 									= "remote:hudson-st.inf.tu-dresden.de/";
	private static final String REFERENCE_META_CLASS_PAIR__INDEX_PROPERTY 		= "index";
	// 's' muss angehangen werden, da die Referenz im Metamodell klein geschrieben ist und somit genauso heißt
	// wie der VertexType von 'ReferenceMetaclassPair', da alle VertexTypes mit kleinem Anfangsbuchstaben anfangen
	private static final String COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR	= RolemappingPackage.Literals.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR.getName() + "s";

	private EPackage targetMetamodel;

	private OGraphDatabase database;
	private TransactionalGraph graph;

	private OProperty roleMappingRoleModelP;
	private OProperty concreteMappingRoleP;
	private OProperty concreteMappingMetaclassP;
	private OProperty collMappingCollP;
	private OProperty refMetaClassPairRefP;
	private OProperty refMetaClassPairMetaclassP;
	private OProperty refMetaClassPairIndexP;
	private OProperty roleMappingRole2MetaR;
	private OProperty concreteMappingCollMappingR;
	private OProperty collMappingRefMClassPairR;
	private OClass roleMappingC;
	private OClass concreteMappingC;
	private OClass collMappingC;
	private OClass refMetaClassPairC;

	public OrientPersistResultListener(EPackage targetMetamodel) {
		this.targetMetamodel = targetMetamodel;
//		initGraphAndDatabase(targetMetamodel);
	}

	@Override
	public void found(Object... something) {
		if(something != null && something[0] instanceof RoleMapping){
			RoleMapping roleMapping = (RoleMapping) something[0];
			TransactionalGraph graph = initGraphAndDatabase(targetMetamodel);
			persistRoleMapping(roleMapping, graph);
		}
	}


	protected void persistRoleMapping(RoleMapping roleMapping, TransactionalGraph graph) {
		if(graph != null){
			if(database.isClosed()){
				System.err.println("DB was closed");
				database = database.open(DB_ADMIN, DB_PASS);
			}
			RoleModel roleModel = roleMapping.getMappedRoleModel();
			Vertex roleMappingV = graph.addVertex("class:" + roleMappingC.getName());
//			Vertex roleMappingV = graph.addVertex(roleMappingC.getName());
			roleMappingV.setProperty(roleMappingRoleModelP.getName(), roleModel.getName());
			List<ConcreteMapping> concreteMappings = roleMapping.getRoleToMetaelement();
			for (ConcreteMapping concreteMapping : concreteMappings) {
				Role role = concreteMapping.getRole();
				EClass metaclass = concreteMapping.getMetaclass();
				Vertex concreteMappingV = graph.addVertex("class:" + concreteMappingC.getName());
				roleMappingV.addEdge(roleMappingRole2MetaR.getName(), concreteMappingV);
				concreteMappingV.setProperty(concreteMappingRoleP.getName(), role.getName());
				concreteMappingV.setProperty(concreteMappingMetaclassP.getName(), metaclass.getName());
				List<CollaborationMapping> collaborationMappings = concreteMapping.getCollaborationMappings();
				for (CollaborationMapping collaborationMapping : collaborationMappings) {
					MultiplicityCollaboration collaboration = collaborationMapping.getCollaboration();
					Vertex collMappingV = graph.addVertex("class:" + collMappingC.getName());
					concreteMappingV.addEdge(concreteMappingCollMappingR.getName(), collMappingV);
					collMappingV.setProperty(collMappingCollP.getName(), collaboration.getTargetName());
					List<ReferenceMetaClassPair> pairList = collaborationMapping.getReferenceMetaClassPair();
					for (ReferenceMetaClassPair pair : pairList) {
						Vertex refMetaClassPairV = graph.addVertex("class:" + refMetaClassPairC.getName());
						EReference reference = pair.getReference();
						metaclass = pair.getMetaClass();
						refMetaClassPairV.setProperty(refMetaClassPairRefP.getName(), reference.getName());
						refMetaClassPairV.setProperty(refMetaClassPairMetaclassP.getName(), metaclass.getName());
						refMetaClassPairV.setProperty(refMetaClassPairIndexP.getName(), pairList.indexOf(pair));
						collMappingV.addEdge(collMappingRefMClassPairR.getName(), refMetaClassPairV);
					}
				}
			}
			graph.commit();
		}
	}

	private void initSchema(OGraphDatabase database){
		if(database.isClosed()){
			database = database.open(DB_ADMIN, DB_PASS);
		}
		database.setUseCustomTypes(true);
		// RoleMapping
		roleMappingC 				= database.createVertexType(RoleMapping.class.getSimpleName());
		roleMappingRoleModelP 		= roleMappingC.createProperty(RolemappingPackage.Literals.ROLE_MAPPING__MAPPED_ROLE_MODEL.getName(), OType.STRING);
		// ConcreteMapping
		concreteMappingC 			= database.createVertexType(ConcreteMapping.class.getSimpleName());
		roleMappingRole2MetaR 		= roleMappingC.createProperty(RolemappingPackage.Literals.ROLE_MAPPING__ROLE_TO_METAELEMENT.getName(), OType.LINKLIST, concreteMappingC);
		concreteMappingRoleP 		= concreteMappingC.createProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__ROLE.getName(), OType.STRING);
		concreteMappingMetaclassP 	= concreteMappingC.createProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__METACLASS.getName(), OType.STRING);
		// CollaborationMapping
		collMappingC 				= database.createVertexType(CollaborationMapping.class.getSimpleName());
		concreteMappingCollMappingR = concreteMappingC.createProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__COLLABORATION_MAPPINGS.getName(), OType.LINKLIST, collMappingC);
		collMappingCollP 			= collMappingC.createProperty(RolemappingPackage.Literals.COLLABORATION_MAPPING__COLLABORATION.getName(), OType.STRING);
		// ReferenceMetaclassPair
		refMetaClassPairC			= database.createVertexType(ReferenceMetaClassPair.class.getSimpleName());
		collMappingRefMClassPairR	= collMappingC.createProperty(COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR, OType.LINKLIST, refMetaClassPairC);
		refMetaClassPairRefP		= refMetaClassPairC.createProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__REFERENCE.getName(), OType.STRING);
		refMetaClassPairMetaclassP	= refMetaClassPairC.createProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__META_CLASS.getName(), OType.STRING);
		refMetaClassPairIndexP		= refMetaClassPairC.createProperty(REFERENCE_META_CLASS_PAIR__INDEX_PROPERTY, OType.INTEGER);
		
		// indices
//		roleMappingC.createIndex("roleModelIndex", OClass.INDEX_TYPE.NOTUNIQUE_HASH_INDEX, roleMappingRoleModelP.getName());
//		concreteMappingC.createIndex("roleMetaclassIndex", OClass.INDEX_TYPE.NOTUNIQUE_HASH_INDEX, concreteMappingRoleP.getName(), concreteMappingMetaclassP.getName());
		
		roleMappingC.createIndex("roleModelIndex", OClass.INDEX_TYPE.NOTUNIQUE, roleMappingRoleModelP.getName());
		concreteMappingC.createIndex("roleMetaclassIndex", OClass.INDEX_TYPE.NOTUNIQUE, concreteMappingRoleP.getName(), concreteMappingMetaclassP.getName());
		
		database.commit();
	}
	
	private TransactionalGraph initGraphAndDatabase(EPackage targetMetamodel){
//		System.out.println("Initializing database and graph...");
		if(database == null){
			String name = targetMetamodel.getName();
			String nsURI = targetMetamodel.getNsURI();
			String dbName = name + "_" + nsURI.replaceAll("[/:,\\.]", "_");
			try {
				OServerAdmin admin = new OServerAdmin(DB_SERVER_STRING + dbName);
				admin.connect(DB_ADMIN, DB_PASS);
				if(!admin.existsDatabase(DB_TYPE)){
					admin.createDatabase("graph", DB_TYPE);
					database = new OGraphDatabase(DB_SERVER_STRING + dbName);
					initSchema(database);
//					performanceTuning();
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			if(database == null){
				database = new OGraphDatabase(DB_SERVER_STRING + dbName);
			}
			if(database.isClosed()){
				database = database.open(DB_ADMIN, DB_PASS);
			}
		}
		if(graph == null){
			graph = new OrientGraph(database);
		}
		return graph;
	}

	private void performanceTuning() {
//		OGlobalConfiguration.TX_USE_LOG.setValue(false);
		database.declareIntent(new OIntentMassiveInsert());
	}
	
	@Override
	public void done() {
		System.out.println("Close Graph and DB");
		if(graph != null){
			graph.commit();
//			graph.shutdown();
		}
		if(database != null){
			database.commit();
			database.close();
		}
	}
}
