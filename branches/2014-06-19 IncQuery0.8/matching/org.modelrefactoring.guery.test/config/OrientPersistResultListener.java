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

	private static final String DB_ADMIN 											= "admin";
	private static final String DB_PASS 											= "admin";
	private static final String DB_TYPE 											= "plocal";
	private static final String DB_SERVER_STRING 									= "remote:www.myorientdb-server.org/";
	private static final String REFERENCE_META_CLASS_PAIR__INDEX_PROPERTY 			= "index";
	private static final String COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR	= RolemappingPackage.Literals.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR.getName() + "s";
	private static final int TRANSACTION_COUNT 										= 200;

	private EPackage targetMetamodel;

	private OGraphDatabase database;
	private OrientGraph graph;

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
	
	private int count = 0;

	public OrientPersistResultListener(EPackage targetMetamodel) {
		this.targetMetamodel = targetMetamodel;
	}

	@Override
	public void found(Object... something) {
		if(something != null && something[0] instanceof RoleMapping){
			RoleMapping roleMapping = (RoleMapping) something[0];
			count++;
			OrientGraph graph = initGraphAndDatabase(targetMetamodel);
			persistRoleMapping(roleMapping, graph);
		}
	}


	protected void persistRoleMapping(RoleMapping roleMapping, OrientGraph graph) {
		if(graph != null){
			if(database.isClosed()){
				System.err.println("DB was closed");
				database = database.open(DB_ADMIN, DB_PASS);
			}
			RoleModel roleModel = roleMapping.getMappedRoleModel();
			Vertex roleMappingV = graph.addVertex("class:" + roleMappingC.getName());
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
//			if( count % TRANSACTION_COUNT == 0){
//				System.out.println("Commit #" + count / TRANSACTION_COUNT);
//				graph.commit();
//			}
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
		
		roleMappingC.createIndex("roleModelIndex", OClass.INDEX_TYPE.NOTUNIQUE, roleMappingRoleModelP.getName());
		concreteMappingC.createIndex("roleMetaclassIndex", OClass.INDEX_TYPE.NOTUNIQUE, concreteMappingRoleP.getName(), concreteMappingMetaclassP.getName());
		
		database.commit();
	}
	
	private OrientGraph initGraphAndDatabase(EPackage targetMetamodel){
		if(database == null){
			String name = targetMetamodel.getName();
			String nsURI = targetMetamodel.getNsURI();
//			String dbName = name + "_" + nsURI.replaceAll("[/:,\\.]", "_");
			String dbName = name;
			try {
				OServerAdmin admin = new OServerAdmin(DB_SERVER_STRING + dbName);
				admin.connect(DB_ADMIN, DB_PASS);
				if(!admin.existsDatabase(DB_TYPE)){
					admin.createDatabase("graph", DB_TYPE);
					database = new OGraphDatabase(DB_SERVER_STRING + dbName);
					initSchema(database);
				} else {
					database = new OGraphDatabase(DB_SERVER_STRING + dbName);
					loadSchema(database);
				}
				performanceTuning();
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

	private void loadSchema(OGraphDatabase database) {
		// RoleMapping
		roleMappingC 				= database.getVertexType(RoleMapping.class.getSimpleName());
		roleMappingRoleModelP 		= roleMappingC.getProperty(RolemappingPackage.Literals.ROLE_MAPPING__MAPPED_ROLE_MODEL.getName());
		// ConcreteMapping
		concreteMappingC 			= database.getVertexType(ConcreteMapping.class.getSimpleName());
		roleMappingRole2MetaR 		= roleMappingC.getProperty(RolemappingPackage.Literals.ROLE_MAPPING__ROLE_TO_METAELEMENT.getName());
		concreteMappingRoleP 		= concreteMappingC.getProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__ROLE.getName());
		concreteMappingMetaclassP 	= concreteMappingC.getProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__METACLASS.getName());
		// CollaborationMapping
		collMappingC 				= database.getVertexType(CollaborationMapping.class.getSimpleName());
		concreteMappingCollMappingR = concreteMappingC.getProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__COLLABORATION_MAPPINGS.getName());
		collMappingCollP 			= collMappingC.getProperty(RolemappingPackage.Literals.COLLABORATION_MAPPING__COLLABORATION.getName());
		// ReferenceMetaclassPair
		refMetaClassPairC			= database.getVertexType(ReferenceMetaClassPair.class.getSimpleName());
		collMappingRefMClassPairR	= collMappingC.getProperty(COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR);
		refMetaClassPairRefP		= refMetaClassPairC.getProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__REFERENCE.getName());
		refMetaClassPairMetaclassP	= refMetaClassPairC.getProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__META_CLASS.getName());
		refMetaClassPairIndexP		= refMetaClassPairC.getProperty(REFERENCE_META_CLASS_PAIR__INDEX_PROPERTY);
	}

	private void performanceTuning() {
//		OGlobalConfiguration.TX_USE_LOG.setValue(false);
//		OGlobalConfiguration.USE_WAL.setValue(false);
//		OGlobalConfiguration.STORAGE_KEEP_OPEN.setValue(false);
		database.declareIntent(new OIntentMassiveInsert());
	}
	
	@Override
	public void done() {
		System.out.println("Close Graph and DB");
		if(graph != null){
			System.out.println("Commit #" + (count / TRANSACTION_COUNT + 1));
			graph.commit();
			graph.shutdown();
		}
		if(database != null){
			database.declareIntent(null);
			database.close();
		}
	}
}
