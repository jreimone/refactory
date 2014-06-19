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
import com.orientechnologies.orient.core.db.ODatabaseComplex;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OProperty;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.ORecordInternal;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientBaseGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientPersistResultListener implements AdditionalResultListener {

	private static final String DB_TYPE 											= "plocal";
	private static final String DB_ADMIN 											= "superadmin";
	private static final String DB_PASS 											= "kuCh3n$%";
	private static final String DB_SERVER_STRING 									= "remote:hudson-st.inf.tu-dresden.de/";
	private static final String REFERENCE_META_CLASS_PAIR__INDEX_PROPERTY 			= "index";
	// 's' muss angehangen werden, da die Referenz im Metamodell klein geschrieben ist und somit genauso heißt
	// wie der VertexType von 'ReferenceMetaclassPair', da alle VertexTypes mit kleinem Anfangsbuchstaben anfangen
	private static final String COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR	= RolemappingPackage.Literals.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR.getName() + "s";
	private static final int TRANSACTION_COUNT 										= 300;

	//	private EPackage targetMetamodel;

	//	private OGraphDatabase database;
	private OrientBaseGraph graph;

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

	//	private boolean dbExists = false;
	private int count = 0;
	private ODatabaseComplex<ORecordInternal<?>> tx;

	public OrientPersistResultListener(EPackage targetMetamodel) {
		//		this.targetMetamodel = targetMetamodel;
		initGraph(targetMetamodel);
	}

	@Override
	public void found(Object... something) {
		if(something != null && something[0] instanceof RoleMapping){
			RoleMapping roleMapping = (RoleMapping) something[0];
			count++;
			//			OrientBaseGraph graph = initGraph(targetMetamodel);
			persistRoleMapping(roleMapping, graph);
		}
	}


	protected void persistRoleMapping(RoleMapping roleMapping, OrientBaseGraph graph) {
		if(graph != null){
			//			if(database.isClosed()){
			//				System.err.println("DB was closed");
			//				database = database.open(DB_ADMIN, DB_PASS);
			//			}
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
			if( count % TRANSACTION_COUNT == 0){
				System.out.println("Commit #" + count / TRANSACTION_COUNT);
				graph.commit();
			}
		}
	}

	private void initSchema(OrientBaseGraph graph){
		//		if(graph.isClosed()){
		//			database = graph.open(DB_ADMIN, DB_PASS);
		//		}
		//		graph.setUseCustomTypes(true);
		// RoleMapping
		//		graph.getRawGraph().getTransaction().close();
		//		graph.commit();
		graph.getRawGraph().commit();
		roleMappingC 				= graph.createVertexType(RoleMapping.class.getSimpleName());
		roleMappingRoleModelP 		= roleMappingC.createProperty(RolemappingPackage.Literals.ROLE_MAPPING__MAPPED_ROLE_MODEL.getName(), OType.STRING);
		// ConcreteMapping
		concreteMappingC 			= graph.createVertexType(ConcreteMapping.class.getSimpleName());
		roleMappingRole2MetaR 		= roleMappingC.createProperty(RolemappingPackage.Literals.ROLE_MAPPING__ROLE_TO_METAELEMENT.getName(), OType.LINKLIST, concreteMappingC);
		concreteMappingRoleP 		= concreteMappingC.createProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__ROLE.getName(), OType.STRING);
		concreteMappingMetaclassP 	= concreteMappingC.createProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__METACLASS.getName(), OType.STRING);
		// CollaborationMapping
		collMappingC 				= graph.createVertexType(CollaborationMapping.class.getSimpleName());
		concreteMappingCollMappingR = concreteMappingC.createProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__COLLABORATION_MAPPINGS.getName(), OType.LINKLIST, collMappingC);
		collMappingCollP 			= collMappingC.createProperty(RolemappingPackage.Literals.COLLABORATION_MAPPING__COLLABORATION.getName(), OType.STRING);
		// ReferenceMetaclassPair
		refMetaClassPairC			= graph.createVertexType(ReferenceMetaClassPair.class.getSimpleName());
		collMappingRefMClassPairR	= collMappingC.createProperty(COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR, OType.LINKLIST, refMetaClassPairC);
		refMetaClassPairRefP		= refMetaClassPairC.createProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__REFERENCE.getName(), OType.STRING);
		refMetaClassPairMetaclassP	= refMetaClassPairC.createProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__META_CLASS.getName(), OType.STRING);
		refMetaClassPairIndexP		= refMetaClassPairC.createProperty(REFERENCE_META_CLASS_PAIR__INDEX_PROPERTY, OType.INTEGER);

		// indices
		//		roleMappingC.createIndex("roleModelIndex", OClass.INDEX_TYPE.NOTUNIQUE_HASH_INDEX, roleMappingRoleModelP.getName());
		//		concreteMappingC.createIndex("roleMetaclassIndex", OClass.INDEX_TYPE.NOTUNIQUE_HASH_INDEX, concreteMappingRoleP.getName(), concreteMappingMetaclassP.getName());

		roleMappingC.createIndex("roleModelIndex", OClass.INDEX_TYPE.NOTUNIQUE, roleMappingRoleModelP.getName());
		concreteMappingC.createIndex("roleMetaclassIndex", OClass.INDEX_TYPE.NOTUNIQUE, concreteMappingRoleP.getName(), concreteMappingMetaclassP.getName());

		graph.commit();
	}

	private OrientBaseGraph initGraph(EPackage targetMetamodel){
		if(graph == null){
			String name = targetMetamodel.getName();
			String nsURI = targetMetamodel.getNsURI();
			//			String dbName = name + "_" + nsURI.replaceAll("[/:,\\.]", "_");
			String dbName = name;
			String dbURL = DB_SERVER_STRING + dbName;
			OServerAdmin admin;
			try {
				admin = new OServerAdmin(dbURL);
				admin.connect(DB_ADMIN, DB_PASS);
				if(!admin.existsDatabase(DB_TYPE)){
					admin.createDatabase("graph", DB_TYPE);
					graph = new OrientGraph(dbURL, DB_ADMIN, DB_PASS);
//										graph = new OrientGraphNoTx(dbURL, DB_ADMIN, DB_PASS);
					initSchema(graph);
				} else {
					graph = new OrientGraph(dbURL, DB_ADMIN, DB_PASS);
//										graph = new OrientGraphNoTx(dbURL, DB_ADMIN, DB_PASS);
					loadSchema(graph);
				}
				performanceTuning();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		//		tx = graph.getRawGraph().begin(TXTYPE.OPTIMISTIC);
		return graph;
	}

	private void loadSchema(OrientBaseGraph graph) {
		// RoleMapping
		roleMappingC 				= graph.getVertexType(RoleMapping.class.getSimpleName());
		roleMappingRoleModelP 		= roleMappingC.getProperty(RolemappingPackage.Literals.ROLE_MAPPING__MAPPED_ROLE_MODEL.getName());
		// ConcreteMapping
		concreteMappingC 			= graph.getVertexType(ConcreteMapping.class.getSimpleName());
		roleMappingRole2MetaR 		= roleMappingC.getProperty(RolemappingPackage.Literals.ROLE_MAPPING__ROLE_TO_METAELEMENT.getName());
		concreteMappingRoleP 		= concreteMappingC.getProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__ROLE.getName());
		concreteMappingMetaclassP 	= concreteMappingC.getProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__METACLASS.getName());
		// CollaborationMapping
		collMappingC 				= graph.getVertexType(CollaborationMapping.class.getSimpleName());
		concreteMappingCollMappingR = concreteMappingC.getProperty(RolemappingPackage.Literals.CONCRETE_MAPPING__COLLABORATION_MAPPINGS.getName());
		collMappingCollP 			= collMappingC.getProperty(RolemappingPackage.Literals.COLLABORATION_MAPPING__COLLABORATION.getName());
		// ReferenceMetaclassPair
		refMetaClassPairC			= graph.getVertexType(ReferenceMetaClassPair.class.getSimpleName());
		collMappingRefMClassPairR	= collMappingC.getProperty(COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR);
		refMetaClassPairRefP		= refMetaClassPairC.getProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__REFERENCE.getName());
		refMetaClassPairMetaclassP	= refMetaClassPairC.getProperty(RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR__META_CLASS.getName());
		refMetaClassPairIndexP		= refMetaClassPairC.getProperty(REFERENCE_META_CLASS_PAIR__INDEX_PROPERTY);
	}

	private void performanceTuning() {
		// auf Server Console gemacht mit:
		// config set storage.useWAL false
		OGlobalConfiguration.TX_USE_LOG.setValue(false);
		//		OGlobalConfiguration.USE_WAL.setValue(false);
		//		OGlobalConfiguration.STORAGE_KEEP_OPEN.setValue(false);
		//		OGlobalConfiguration.USE_WAL.setValue(true);
		//		OGlobalConfiguration.TX_USE_LOG.setValue(true);
		//		graph.getRawGraph().declareIntent(new OIntentMassiveInsert());
	}

	@Override
	public void done() {
		if(graph != null){
			System.out.println("Commit #" + (count / TRANSACTION_COUNT + 1));
			graph.commit();
			graph.shutdown();
			//			graph.getRawGraph().declareIntent(null);
			//			graph.shutdown();
			//			tx.commit();
			//			tx.close();
			//			graph.getRawGraph().commit();
			System.out.println("Graph closed");
		}
		//		if(database != null){
		//			database.commit();
		//			database.declareIntent(null);
		//			database.close();
		//		}
	}
}
