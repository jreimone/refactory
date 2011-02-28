package org.emftext.refactoring.rolemodelmatching;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stp.bpmn.SubProcess;
import org.eclipse.uml2.uml.Class;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAssociation;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.rolemodelmatching.combinatory.CombinationGenerator;
import org.emftext.refactoring.rolemodelmatching.listener.FilePrinterListener;
import org.emftext.refactoring.rolemodelmatching.listener.INodeListener;
import org.emftext.refactoring.rolemodelmatching.listener.MatchCountListener;
import org.emftext.refactoring.rolemodelmatching.listener.PrintMatchPathListener;
import org.emftext.refactoring.rolemodelmatching.listener.RemoveCompletePathListener;
import org.emftext.refactoring.rolemodelmatching.listener.RemoveIncompletePathListener;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * A test class trying to match rolemodels on simple structures in a target
 * metamodel. 'Simple structure' means that collaborations are only matched to
 * single relations and not to paths of relations.
 * 
 * @author jreimann
 * 
 */
public class RolemodelMatchingTest extends RolemodelMatchingInitialization {

	private static final String MAPPING_FILE 		= "mappings";
	private static final String FILE_EXT			= ".txt";
	private static final String RESULTS_DIR			= "test_results/";
	private static final String HUDSON_RESULTS_DIR 	= "/home/hudson/build_server/build_workdir/" + RESULTS_DIR;
	private static final String MATCHING_RESULTS	= "matching_results/";

	// Rolemodels
	private static final String RM_RENAME_X 						= "platform:/resource/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext";
	private static final String RM_REMOVE_UNUSED_CONTAINED_X 		= "platform:/resource/org.emftext.refactoring.removeUnusedContainedX/rolemodel/removeUnusedContainedX.rolestext";
	private static final String RM_REMOVE_EMPTY_CONTAINED_X 		= "platform:/resource/org.emftext.refactoring.removeEmptyContainedX/rolemodel/removeEmptyContainedX.rolestext";
	private static final String RM_MOVE_XLOOSELY 					= "platform:/resource/org.emftext.refactoring.moveXloosely/rolemodel/moveXloosely.rolestext";
	private static final String RM_MOVE_X 							= "platform:/resource/org.emftext.refactoring.moveX/rolemodel/moveX.rolestext";
	private static final String RM_INTRODUCE_REFERENCE_CLASS 		= "platform:/resource/org.emftext.refactoring.introduceReferenceClass/rolemodel/IntroduceReferenceClass.rolestext";
	private static final String RM_EXTRACT_XWITH_REFERENCE_CLASS 	= "platform:/resource/org.emftext.refactoring.extractXwithReferenceClass/rolemodel/ExtractXwithReferenceClass.rolestext";
	private static final String RM_EXTRACT_SUB_X 					= "platform:/resource/org.emftext.refactoring.extractSubX/rolemodel/ExtractSubX.rolestext";
	private static final String RM_EXTRACT_X 						= "platform:/resource/org.emftext.refactoring.extractX/rolemodel/ExtractX.rolestext";

	// Metamodels
	private static final String MM_UML 				= "http://www.eclipse.org/uml2/3.0.0/UML";
	private static final String MM_ECORE 			= "http://www.eclipse.org/emf/2002/Ecore";
	private static final String MM_JAVA 			= "platform:/resource/org.emftext.language.java/metamodel/java.ecore";
	private static final String MM_TEXTADVENTURE 	= "platform:/resource/org.emftext.language.textadventure/metamodel/textadventure.ecore";
	private static final String MM_FORMS 			= "platform:/resource/org.emftext.language.forms/metamodel/forms.ecore";
	private static final String MM_PL0 				= "platform:/resource/org.emftext.language.pl0/metamodel/pl0.ecore";
	private static final String MM_TESTMM 			= "platform:/resource/org.emftext.refactoring.rolematching.testmm/metamodel/testmm.ecore";
	private static final String MM_APPFLOW 			= "platform:/resource/org.emftext.language.appflow/metamodel/appflow.text.ecore";
	private static final String MM_CS 				= "http://www.emftext.org/sdk/concretesyntax";
	private static final String MM_FEATURE 			= "platform:/resource/org.featuremapper.models.feature/model/feature.ecore";
	private static final String MM_TA 				= "platform:/resource/org.emftext.language.timedautomata/metamodel/timedAutomata.ecore";
	private static final String MM_OWL 				= "platform:/resource/org.emftext.language.owl/metamodel/owl.text.ecore";
	private static final String MM_ROLES 			= "platform:/resource/org.emftext.language.refactoring.roles/metamodel/roles.ecore";
	private static final String MM_REFSPEC 			= "platform:/resource/org.emftext.language.refactoring.specification/metamodel/refactoring_specification.ecore";
	private static final String MM_ROLEMAPPING 		= "platform:/resource/org.emftext.language.refactoring.rolemapping/metamodel/rolemapping.ecore";
	private static final String MM_CONFERENCE 		= "platform:/resource/org.emftext.language.conference/metamodel/conference.ecore";
	private static final String MM_OFFICE 			= "platform:/resource/org.emftext.language.office/metamodel/office.ecore";
	private static final String MM_SIMPLEGUI 		= "platform:/resource/org.emftext.language.simplegui/metamodel/simplegui.ecore";
	private static final String MM_SANDWICH 		= "platform:/resource/org.emftext.language.sandwich/metamodel/sandwich_simple.ecore";
	private static final String MM_BPMN 			= "http://stp.eclipse.org/bpmn";
	
	

	private static final String[] rolemodelURIs = new String[] { 
		RM_EXTRACT_X
		,RM_EXTRACT_SUB_X 
		,RM_EXTRACT_XWITH_REFERENCE_CLASS 
		,RM_INTRODUCE_REFERENCE_CLASS 
		,RM_MOVE_X 
		,RM_MOVE_XLOOSELY 
		,RM_REMOVE_EMPTY_CONTAINED_X 
		,RM_REMOVE_UNUSED_CONTAINED_X
		,RM_RENAME_X
	};

	private static final String[] metamodelURIs = new String[] { 
		MM_APPFLOW
		,MM_TESTMM
		,MM_PL0
		,MM_FORMS
		,MM_TEXTADVENTURE
		,MM_JAVA
		,MM_FEATURE
		,MM_TA
		,MM_OWL
		,MM_ROLES
		,MM_REFSPEC
		,MM_ROLEMAPPING
		,MM_CONFERENCE
		,MM_OFFICE
		,MM_SIMPLEGUI
		,MM_SANDWICH
	};

	private static Map<String, RoleModel> rolemodels;
	private static Map<String, EPackage> metamodels;

	private List<EClass> currentMetaClasses;
	private Map<EClass, List<EClass>> subClassesCache;
	private Map<RoleModel, List<List<EObject>>> linearRoleModels;

	@BeforeClass
	public static void initialization() {
		registerTestingRootAsPlatformRoot();
		rolemodels = initRoleModels(rolemodelURIs);
		metamodels = initMetamodels(metamodelURIs);
		EPackage ecoreMetamodel = initArchiveMetamodel("/model/Ecore.ecore", MM_ECORE, EClass.class);
		metamodels.put(MM_ECORE, ecoreMetamodel);
		EPackage umlMetamodel = initArchiveMetamodel("/model/UML.ecore", MM_UML, Class.class);
		metamodels.put(MM_UML, umlMetamodel);
		EPackage csMetamodel = initArchiveMetamodel("/metamodel/concretesyntax.ecore", MM_CS, ConcreteSyntax.class);
		metamodels.put(MM_CS, csMetamodel);
		EPackage bpmnMetamodel = initArchiveMetamodel("/model/bpmn.ecore", MM_BPMN, SubProcess.class);
		metamodels.put(MM_BPMN, bpmnMetamodel);
	}

	@Before
	public void cacheInitialization(){
		subClassesCache = Collections.synchronizedMap(new LinkedHashMap<EClass, List<EClass>>());
	}

	@Test
	public void matchExtractXtoTestmm(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_X), metamodels.get(MM_TESTMM), false);
	}


	@Test
	public void matchExtractXtoEcore(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_X), metamodels.get(MM_ECORE), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToEcore(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_ECORE), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToPL0(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_PL0), false);
	}

	@Test
	public void matchMoveXToPL0(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_X), metamodels.get(MM_PL0), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToForms(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_FORMS), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToTextAdventure(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_TEXTADVENTURE), false);
	}

	@Test
	@Ignore
	public void matchExtractXwithReferenceClassToAppflow(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_APPFLOW), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToJava(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_JAVA), false);
	}

	@Test
	public void matchExtractXtoUML(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_X), metamodels.get(MM_UML), false);
	}

	private List<List<EObject>> linearizeRoleModel(RoleModel roleModel){
		LinkedList<EObject> linearization = new LinkedList<EObject>();
		List<Role> roles = roleModel.getRoles();
		List<List<EObject>> pathes = new LinkedList<List<EObject>>();
		for (Role role : roles) {
			constructPath(pathes, null, role);
		}
		Collections.sort(pathes, new Comparator<List<EObject>>() {
			public int compare(List<EObject> o1, List<EObject> o2) {
				if (o1.size() == o2.size()) {
					return 0;
				}
				if (o1.size() < o2.size()) {
					return -1;
				}
				return 1;
			}
		});
		Collections.reverse(pathes);
		for (List<EObject> path : pathes) {
			for (EObject element : path) {
				if (!linearization.contains(element)) {
					linearization.add(element);
				}
			}
		}
		return getLinearRoleModelsWithoutOptional(roleModel, linearization);
	}

	@Test
	public void linearizeRoleModels() {
		linearRoleModels = new LinkedHashMap<RoleModel, List<List<EObject>>>();
		for (RoleModel roleModel : rolemodels.values()) {
			List<List<EObject>> linearizations = linearizeRoleModel(roleModel);
			linearRoleModels.put(roleModel, linearizations);
		}
		for (RoleModel roleModel : rolemodels.values()) {
			List<List<EObject>> linearizations = linearRoleModels.get(roleModel);
			for (List<EObject> linearization : linearizations) {
				printLinearization(roleModel, linearization);
			}
		}
	}

	private void printLinearization(RoleModel roleModel, List<EObject> linearization) {
		System.out.println("Linear order for '" + roleModel.getName()
				+ "' with longest path");
		for (EObject element : linearization) {
			String roleString = "";
			if (element instanceof Role) {
				roleString = ((Role) element).getName();
			} else if (element instanceof MultiplicityCollaboration) {
				roleString = ((MultiplicityCollaboration) element).getTargetName();
			}
			String connector = " --> ";
			if (linearization.indexOf(element) == linearization.size() - 1) {
				connector = "";
			}
			System.out.print(roleString + connector);
		}
		System.out.println();
	}

	private void constructPath(List<List<EObject>> pathes, List<EObject> path, Role role) {
		List<EObject> rolePath = path;
		if (rolePath == null) {
			rolePath = new LinkedList<EObject>();
			pathes.add(rolePath);
		}
		rolePath.add(role);
		List<Collaboration> outgoing = role.getOutgoing();
		if (outgoing.size() > 0) {
			Collaboration firstCollaboration = outgoing.get(0);
			if (outgoing.size() == 1) {
				rolePath.add(firstCollaboration);
				constructPath(pathes, rolePath, firstCollaboration.getTarget());
			} else {
				if (firstCollaboration instanceof MultiplicityCollaboration) {
					rolePath.add(firstCollaboration);
					constructPath(pathes, rolePath, firstCollaboration.getTarget());
				}
				for (int i = 1; i < outgoing.size(); i++) {
					Collaboration collaboration = outgoing.get(i);
					if (collaboration instanceof MultiplicityCollaboration) {
						Role source = collaboration.getSource();
						int index = rolePath.indexOf(source);
						List<EObject> newPath = new LinkedList<EObject>();
						for (int j = 0; j <= index; j++) {
							newPath.add(rolePath.get(j));
						}
						pathes.add(newPath);
						newPath.add(collaboration);
						Role target = collaboration.getTarget();
						constructPath(pathes, newPath, target);
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param rolemodel
	 * @param metamodel
	 * @return root of the match tree
	 */
	private void matchRoleModelInMetamodel(RoleModel rolemodel, EPackage metamodel, boolean print){
		RoleNode root = new RoleNode(null);
		//				INodeListener printMatchPathListener = new PrintMatchPathListener();
		//				root.addListener(printMatchPathListener);
		AtomicInteger count = new AtomicInteger();
		MatchCountListener matchCountListener = new MatchCountListener(count, rolemodel, metamodel);
		root.addListener(matchCountListener);
		//		INodeListener removeCompletePathListener = new RemoveCompletePathListener(matchCountListener);
		//		root.addListener(removeCompletePathListener);
		AtomicInteger incompleteCount = new AtomicInteger();
		RemoveIncompletePathListener incompletePathListener = new RemoveIncompletePathListener(incompleteCount, rolemodel, metamodel);
		root.addListener(incompletePathListener);

		addFileWriterListener(rolemodel, metamodel, root);
		root.setMetamodel(metamodel);
		root.setRolemodel(rolemodel);
		List<List<EObject>> linearRolemodelsWithoutOptionals = linearizeRoleModel(rolemodel);
		match(linearRolemodelsWithoutOptionals, metamodel, root);
		matchCountListener.printCount();
		incompletePathListener.printIncompleteRemovals();
	}

	private void addFileWriterListener(RoleModel rolemodel, EPackage metamodel, RoleNode root) {
		File hudsonDir = new File(HUDSON_RESULTS_DIR);
		File file = null;
		String fileName = MAPPING_FILE + "_" + metamodel.getName() + "_" + rolemodel.getName() + "_" + System.currentTimeMillis() + FILE_EXT;
		if(hudsonDir.exists() && hudsonDir.isDirectory()){
			File matchingDir = new File(HUDSON_RESULTS_DIR + MATCHING_RESULTS);
			if(!matchingDir.exists()){
				if(matchingDir.mkdir()){
					file = new File(HUDSON_RESULTS_DIR + MATCHING_RESULTS + fileName);
				} else {
					file = new File(HUDSON_RESULTS_DIR + fileName);
				}
			} else {
				file = new File(HUDSON_RESULTS_DIR + MATCHING_RESULTS + fileName);
			}
		} else {
			file = new File(RESULTS_DIR + fileName);
		}
		try {
			if(file.createNewFile()){
				FileWriter writer = new FileWriter(file);
				FilePrinterListener filePrinter = new FilePrinterListener(writer);
				root.addListener(filePrinter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<List<EObject>> getLinearRoleModelsWithoutOptional(RoleModel rolemodel, List<EObject> linearRolemodel) {
		List<List<EObject>> linearRolemodelsWithoutOptional = new LinkedList<List<EObject>>();
		linearRolemodelsWithoutOptional.add(linearRolemodel);
		List<Role> optionalRoles = new LinkedList<Role>();
		for (EObject element : linearRolemodel) {
			if(element instanceof Role && ((Role) element).getModifier().contains(RoleModifier.OPTIONAL)){
				optionalRoles.add((Role) element);
			}
		}
		if(optionalRoles.size() > 0){
			CombinationGenerator<Role> generator = new CombinationGenerator<Role>();
			for (int count = 1; count <= optionalRoles.size(); count++) {
				List<List<Role>> combinations = generator.getCombinations(optionalRoles, count);
				for (List<Role> combination : combinations) {
					EcoreUtil.Copier copier = new EcoreUtil.Copier(true, false);
					List<RoleModel> copyList = new LinkedList<RoleModel>();
					copyList.add(rolemodel);
					copier.copyAll(copyList);
					copier.copyReferences();
					RoleModel copiedRoleModel = (RoleModel) copier.get(rolemodel);
					for (Role role : combination) {
						copiedRoleModel.getRoles().remove(copier.get(role));
						for (Collaboration collaboration : role.getIncoming()) {
							EcoreUtil.delete(copier.get(collaboration));
						}
						for (Collaboration collaboration : role.getOutgoing()) {
							EcoreUtil.delete(copier.get(collaboration));
						}
					}
					List<List<EObject>> linearRolemodelWithoutOptionals = linearizeRoleModel(copiedRoleModel);
					linearRolemodelsWithoutOptional.addAll(linearRolemodelWithoutOptionals);
				}
			}
		}
		return linearRolemodelsWithoutOptional;
	}

	@Test
	public void matchAllRoleModelsInAllMetamodels() {
		for (EPackage metamodel : metamodels.values()) {
			currentMetaClasses = collectClasses(metamodel);
			for (RoleModel rolemodel : rolemodels.values()) {
				matchRoleModelInMetamodel(rolemodel, metamodel, false);
			}
			System.err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}

	private void match(List<List<EObject>> linearRolemodels, EPackage metamodel, RoleNode root) {
		for (List<EObject> linearRolemodel : linearRolemodels) {
			EObject element = linearRolemodel.get(0);
			List<EObject> reducedPath = new LinkedList<EObject>(linearRolemodel);
			reducedPath.remove(element);
			if (element instanceof Role) {
				matchClass((Role) element, reducedPath, metamodel, root);
			} else {
				fail("invalid element");
			}
		}
	}

	private void matchClass(Role role, List<EObject> path, EPackage metamodel, MatchNode<?, ?> parent) {
		if (getMappedClassByRole(role, parent) == null) {
			if(currentMetaClasses == null){
				currentMetaClasses = collectClasses(metamodel);
			}
			if (parent instanceof CollaborationNode) {
				EReference reference = ((CollaborationNode) parent).getMetaElement();
				if (reference.getEType() instanceof EClass) {
					EClass targetClass = (EClass) reference.getEType();
					//					List<EClass> classes = getSubClasses(currentMetaClasses, targetClass);
					List<EClass> classes = new LinkedList<EClass>();
					classes.add(targetClass);
					boolean mappable = false;
					for (EClass clazz : classes) {
						List<RoleAttribute> roleAttributes = role.getAttributes();
						List<EAttribute> classAttributes = clazz.getEAllAttributes();
						if(roleAttributes.size() == 0 || (roleAttributes.size() > 0 && classAttributes.size() > 0)){
							mappable = true;
							RoleNode node = new RoleNode(parent);
							node.setMetaElement(clazz);
							node.setRoleElement(role);
							nextStepAfterMatching(path, metamodel, node);
						}
					}
					if(!mappable){
						parent.setComplete(false);
					}
				} else {
					fail("handle EClassifier!");
				}
			} else {
				for (EClass metaclass : currentMetaClasses) {
					RoleNode node = new RoleNode(parent);
					node.setRoleElement(role);
					node.setMetaElement(metaclass);
					nextStepAfterMatching(path, metamodel, node);
				}
			}
		} else {
			nextStepAfterMatching(path, metamodel, parent);
		}
	}

	private void nextStepAfterMatching(List<EObject> path, EPackage metamodel, MatchNode<?, ?> node) {
		if (path.size() > 0) {
			EObject nextElement = path.get(0);
			List<EObject> reducedPath = new LinkedList<EObject>(path);
			reducedPath.remove(nextElement);
			if (nextElement instanceof Collaboration) {
				Collaboration collaboration = (Collaboration) nextElement;
				matchCollaboration(collaboration, reducedPath, metamodel, node);
			} else if (nextElement instanceof Role) {
				Role singleRole = (Role) nextElement;
				matchClass(singleRole, reducedPath, metamodel, node);
			} else {
				fail("invalid element");
			}
		} else {
			node.setComplete(true);
		}
	}

	private void matchCollaboration(Collaboration collaboration, List<EObject> path, EPackage metamodel, MatchNode<?, ?> parent) {
		if (collaboration instanceof MultiplicityCollaboration) {
			MultiplicityCollaboration multiCol = (MultiplicityCollaboration) collaboration;
			Role source = multiCol.getSource();
			EClass sourceClass = getMappedClassByRole(source, parent);
			assertNotNull("something went wrong - mapped role '"
					+ source.getName() + "' must have been mapped already", sourceClass);
			List<EReference> references = sourceClass.getEAllReferences();
			if(references.size() == 0){
				parent.setComplete(false);
			}
			Role target = multiCol.getTarget();
			EClass targetClass = getMappedClassByRole(target, parent);
			boolean mappable = false;
			if (targetClass == null) {
				for (EReference reference : references) {
					if (referenceMappable(reference, multiCol)) {
						mappable = true;
						CollaborationNode node = new CollaborationNode(parent);
						node.setMetaElement(reference);
						node.setRoleElement(multiCol);
						nextStepAfterMatching(path, metamodel, node);
					}
				}
			} else {
				Set<EClass> classes = new LinkedHashSet<EClass>(targetClass.getEAllSuperTypes());
				classes.add(targetClass);
				for (EReference reference : references) {
					if (referenceMappable(reference, multiCol)
							&& classes.contains(reference.getEType())) {
						mappable = true;
						CollaborationNode node = new CollaborationNode(parent);
						node.setMetaElement(reference);
						node.setRoleElement(multiCol);
						nextStepAfterMatching(path, metamodel, node);
					}
				}
			}
			if(!mappable){
				parent.setComplete(false);
			}
		} else {
			parent.setComplete(false);
		}
	}

	private EClass getMappedClassByRole(Role role, MatchNode<?, ?> node) {
		MatchNode<?, ?> parent = node;
		while (parent != null) {
			if (parent instanceof RoleNode) {
				if (role.equals(parent.getRoleElement())) {
					return ((RoleNode) parent).getMetaElement();
				}
			}
			parent = parent.getParent();
		}
		return null;
	}


	private synchronized List<EClass> getSubClasses(List<EClass> classes, EClass clazz) {
		List<EClass> subClasses = new LinkedList<EClass>();
		//		List<EClass> subClasses = subClassesCache.get(clazz);
		//		if(subClasses == null){
		subClasses = new LinkedList<EClass>();
		//			subClassesCache.put(clazz, subClasses);
		for (int i = 0; i < classes.size(); i++) {
			EClass eClass = classes.get(i);
			if (eClass.getEAllSuperTypes().contains(clazz)) {
				subClasses.add(eClass);
			}
		}
		//		}
		return subClasses;
	}

	private boolean referenceMappable(EReference reference, Collaboration collaboration) {
		if (collaboration instanceof RoleComposition) {
			if (!reference.isContainment()) {
				return false;
			}
		} else if (collaboration instanceof RoleAssociation) {
			if (reference.isContainment()) {
				return false;
			}
		}
		return true;
	}

	private List<EClass> collectClasses(EPackage metamodel) {
		List<EClass> classes = new LinkedList<EClass>();
		List<EClassifier> classifiers = metamodel.getEClassifiers();
		for (EClassifier classifier : classifiers) {
			if (classifier instanceof EClass) {
				classes.add((EClass) classifier);
			}
		}
		List<EPackage> subPackages = metamodel.getESubpackages();
		for (EPackage subModel : subPackages) {
			classes.addAll(collectClasses(subModel));
		}
		return classes;
	}

	@Test
	public void equalsHashTest(){
		EPackage metamodel = metamodels.get(MM_TESTMM);
		RoleModel roleModel = rolemodels.get(RM_EXTRACT_X);

		RoleNode n1 = new RoleNode(null);
		n1.setMetamodel(metamodel);
		n1.setRolemodel(roleModel);
		RoleNode c11 = new RoleNode(n1);
		c11.setRoleElement(roleModel.getRoles().get(0));
		c11.setMetaElement((EClass) metamodel.getEClassifiers().get(0));
		CollaborationNode c12 = new CollaborationNode(c11);
		c12.setRoleElement(roleModel.getCollaborations().get(0));
		c12.setMetaElement(((EClass) metamodel.getEClassifiers().get(0)).getEReferences().get(0));
		RoleNode c13 = new RoleNode(c12);
		c13.setRoleElement(roleModel.getRoles().get(1));
		c13.setMetaElement((EClass)metamodel.getEClassifiers().get(1));

		RoleNode n2 = new RoleNode(null);
		n2.setMetamodel(metamodel);
		n2.setRolemodel(roleModel);
		RoleNode c21 = new RoleNode(n2);
		c21.setRoleElement(roleModel.getRoles().get(0));
		c21.setMetaElement((EClass) metamodel.getEClassifiers().get(0));
		CollaborationNode c22 = new CollaborationNode(c21);
		c22.setRoleElement(roleModel.getCollaborations().get(0));
		c22.setMetaElement(((EClass) metamodel.getEClassifiers().get(0)).getEReferences().get(0));
		RoleNode c23 = new RoleNode(c22);
		c23.setRoleElement(roleModel.getRoles().get(1));
		c23.setMetaElement((EClass)metamodel.getEClassifiers().get(1));

		assertTrue("both trees should be the same", c13.equals(c23));

		Set<MatchNode<?, ?>> hashSet = new LinkedHashSet<MatchNode<?,?>>();
		hashSet.add(c13);
		assertFalse("should have already been added", hashSet.add(c23));

		RoleNode n3 = new RoleNode(null);
		n3.setMetamodel(metamodel);
		n3.setRolemodel(roleModel);
		RoleNode c31 = new RoleNode(n3);
		c31.setRoleElement(roleModel.getRoles().get(0));
		c31.setMetaElement((EClass) metamodel.getEClassifiers().get(0));
		CollaborationNode c32 = new CollaborationNode(c31);
		c32.setRoleElement(roleModel.getCollaborations().get(0));
		c32.setMetaElement(((EClass) metamodel.getEClassifiers().get(0)).getEReferences().get(0));
		RoleNode c33 = new RoleNode(c32);
		c33.setRoleElement(roleModel.getRoles().get(2));
		c33.setMetaElement((EClass)metamodel.getEClassifiers().get(1));

		assertFalse("both trees should not be the same", c13.equals(c33));
		assertFalse("both trees should not be the same", c23.equals(c33));

		hashSet.add(c13);
		assertTrue("should not have been added", hashSet.add(c33));
	}
}