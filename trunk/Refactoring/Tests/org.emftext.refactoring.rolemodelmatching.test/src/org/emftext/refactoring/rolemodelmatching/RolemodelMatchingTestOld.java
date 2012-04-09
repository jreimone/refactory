/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.rolemodelmatching;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
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
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.common.util.EList;
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
import org.emftext.refactoring.rolemodelmatching.listener.EqualityCheckListener;
import org.emftext.refactoring.rolemodelmatching.listener.FilePrinterListener;
import org.emftext.refactoring.rolemodelmatching.listener.FilterMappingFilePrinterListener;
import org.emftext.refactoring.rolemodelmatching.listener.FilterMappingListener;
import org.emftext.refactoring.rolemodelmatching.listener.INodeListener;
import org.emftext.refactoring.rolemodelmatching.listener.LeafCollectorListener;
import org.emftext.refactoring.rolemodelmatching.listener.MatchCountListener;
import org.emftext.refactoring.rolemodelmatching.listener.MatchNodeList;
import org.emftext.refactoring.rolemodelmatching.listener.PrintMatchPathListener;
import org.emftext.refactoring.rolemodelmatching.listener.RemoveCompletePathListener;
import org.emftext.refactoring.rolemodelmatching.listener.RemoveIncompletePathListener;
import org.emftext.refactoring.rolemodelmatching.listener.ValidMappingListener;
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
public class RolemodelMatchingTestOld extends RolemodelMatchingInitialRegistrations {

	public static Map<String, RoleModel> rolemodels;
	public static Map<String, EPackage> metamodels;
	public List<EClass> currentMetaClasses;
	
	private Map<EClass, List<EClass>> subClassesCache;
	private Map<RoleModel, List<List<EObject>>> linearRoleModels;

	@BeforeClass
	public static void initialization() {
		registerTestingRootAsPlatformRoot();
		rolemodels = initRoleModels(rolemodelURIs);
		metamodels = initMetamodels(metamodelURIs);
		initAndRegisterArchiveMetamodel("/model/Ecore.ecore", MM_ECORE, EClass.class, metamodels);
		initAndRegisterArchiveMetamodel("/model/UML.ecore", MM_UML, Class.class, metamodels);
		//		initAndRegisterArchiveMetamodel("/metamodel/concretesyntax.ecore", MM_CS, ConcreteSyntax.class, metamodels);
		initAndRegisterArchiveMetamodel("/model/bpmn.ecore", MM_BPMN, SubProcess.class, metamodels);
	}

	@Before
	public void cacheInitialization(){
		subClassesCache = Collections.synchronizedMap(new LinkedHashMap<EClass, List<EClass>>());
	}

	@Test
	@Ignore
	public void matchRenameXtoTestmm(){
		matchRoleModelInMetamodel(rolemodels.get(RM_RENAME_X), metamodels.get(MM_TESTMM), false);
	}

	@Test
	@Ignore
	public void matchExtractXtoTestmm(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_X), metamodels.get(MM_TESTMM), false);
	}


	@Test
	@Ignore
	public void matchExtractXtoEcore(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_X), metamodels.get(MM_ECORE), false);
	}
	
	@Test
	public void matchMooveXlooselytoUML(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_UML), true);
	}
	
	@Test
	public void matchMooveXlooselytoBPMN(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_BPMN), true);
	}
	
	@Test
	public void matchMooveXlooselytoJava(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_JAVA), true);
	}
	
	@Test
	public void matchMooveXlooselytoCS(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_CS), true);
	}
	
	@Test
	public void matchMooveXlooselytoFeature(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_FEATURE), true);
	}
	
	@Test
	public void matchMooveXlooselytoTA(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_TA), true);
	}
	
	@Test
	public void matchMooveXlooselytoPL0(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_PL0), true);
	}
	
	@Test
	public void matchMooveXlooselytoOWL(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_OWL), true);
	}
	
	@Test
	public void matchMooveXlooselytoEcore(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_ECORE), true);
	}
	
	@Test
	public void matchMooveXlooselytoOffice(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_OFFICE), true);
	}
	
	@Test
	public void matchMooveXlooselytoForms(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_FORMS), true);
	}
	
	@Test
	public void matchRemoveUnusedContainedXtoEcore(){
		matchRoleModelInMetamodel(rolemodels.get(RM_REMOVE_UNUSED_CONTAINED_X), metamodels.get(MM_ECORE), true);
	}
	
	@Test
	public void matchRemoveEmptyContainedXtoEcore(){
		matchRoleModelInMetamodel(rolemodels.get(RM_REMOVE_EMPTY_CONTAINED_X), metamodels.get(MM_ECORE), true);
	}

	@Test
	@Ignore
	public void matchExtractXwithReferenceClassToEcore(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_ECORE), false);
	}

	@Test
	@Ignore
	public void matchExtractXwithReferenceClassToPL0(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_PL0), false);
	}

	@Test
	@Ignore
	public void matchMoveXToPL0(){
		matchRoleModelInMetamodel(rolemodels.get(RM_MOVE_X), metamodels.get(MM_PL0), false);
	}

	@Test
	@Ignore
	public void matchExtractXwithReferenceClassToForms(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_FORMS), false);
	}

	@Test
	@Ignore
	public void matchExtractXwithReferenceClassToTextAdventure(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_TEXTADVENTURE), false);
	}

	@Test
	@Ignore
	public void matchExtractXwithReferenceClassToJava(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_JAVA), false);
	}

	@Test
	@Ignore
	public void matchExtractXtoUML(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_X), metamodels.get(MM_UML), false);
	}

	@Test
	@Ignore
	public void matchExtractXwithReferenceClassToUML(){
		matchRoleModelInMetamodel(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_UML), false);
	}

	public List<List<EObject>> linearizeRoleModel(RoleModel roleModel){
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
	@Ignore
	public void linearizeRoleModels() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Linearization of RoleModels:");
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
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
	public void matchRoleModelInMetamodel(RoleModel rolemodel, EPackage metamodel, boolean print){
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
		FileWriter mappingsWriter = getFileWriter(MAPPING_FILE, rolemodel, metamodel);
		if(mappingsWriter != null){
			FilePrinterListener filePrinter = new FilePrinterListener(mappingsWriter);
			root.addListener(filePrinter);
		}
//		Set<MatchNode<?, ?>> nodeSet = new LinkedHashSet<MatchNode<?,?>>();
//		INodeListener equalityChecker = new EqualityCheckListener(nodeSet);
//		root.addListener(equalityChecker);
		List<MatchNode<?, ?>> leafList = new LinkedList<MatchNode<?,?>>();
		LeafCollectorListener leafCollector = new LeafCollectorListener(leafList);
		root.addListener(leafCollector);

		MatchNodeList validMappings = new MatchNodeList();
		ValidMappingListener validMappingsListener = new ValidMappingListener(validMappings);
		root.addListener(validMappingsListener);

		root.setMetamodel(metamodel);
		root.setRolemodel(rolemodel);
		List<List<EObject>> linearRolemodelsWithoutOptionals = linearizeRoleModel(rolemodel);
		match(linearRolemodelsWithoutOptionals, metamodel, root);
		matchCountListener.printCount();
		incompletePathListener.printIncompleteRemovals();

		saveFilteredMappings(rolemodel, metamodel, count, leafList, validMappings);
	}

	private void saveFilteredMappings(RoleModel rolemodel, EPackage metamodel, AtomicInteger count, List<MatchNode<?, ?>> leafList, MatchNodeList validMappings) {
		FileWriter filteredWriter = getFileWriter(FILTERED_MAPPING_FILE, rolemodel, metamodel);
		if(filteredWriter != null){
			try {
				filteredWriter.append("Pre-selecting mappings for RoleModel '" + rolemodel.getName() + "'\n");
				filteredWriter.append("and Metamodel '" + metamodel.getName() + "'");
				filteredWriter.append("\n\n");
				filteredWriter.flush();
				for (MatchNode<?, ?> mapping : validMappings) {
					AtomicInteger filterCounter = new AtomicInteger();
					if(mapping instanceof RoleNode){
						RoleNode filterMapping = (RoleNode) mapping;
						FilterMappingListener filterMapper = new FilterMappingListener(filterMapping, filterCounter, rolemodel, metamodel);
						FilterMappingFilePrinterListener filterFilePrinter = new FilterMappingFilePrinterListener(filterMapper, count, filteredWriter);
						for (MatchNode<?, ?> leaf : leafList) {
							leaf.addListener(filterFilePrinter);
							filterMapper.execute(leaf);
						}
						filterFilePrinter.executeAfterOthers(null);
					}
				}
				filteredWriter.append("*************************");
			} catch (IOException e) {
				fail(e.getMessage());
			}
		}
	}

	private RoleNode determineFilterMapping(RoleModel rolemodel, EPackage metamodel) {
		List<Role> roles = rolemodel.getRoles();
		List<EClass> metaclasses = null;
		if(currentMetaClasses == null){
			currentMetaClasses = collectClasses(metamodel);
		}
		metaclasses = currentMetaClasses;
		Random rolesRandomizer = new Random(System.currentTimeMillis());
		int roleIndex = rolesRandomizer.nextInt(roles.size());
		Random metaclassesRandomizer = new Random(System.currentTimeMillis());
		int metaclassIndex = metaclassesRandomizer.nextInt(metaclasses.size());
		RoleNode filterMapping = new RoleNode(null);
		filterMapping.setRoleElement(roles.get(roleIndex));
		filterMapping.setMetaElement(metaclasses.get(metaclassIndex));
		return filterMapping;
	}

	public FileWriter getFileWriter(String fileNamePrefix, RoleModel rolemodel, EPackage metamodel) {
		File hudsonDir = new File(HUDSON_RESULTS_DIR);
		File file = null;
		final String prefix = fileNamePrefix + "_" + metamodel.getName() + "_" + rolemodel.getName();
		final String fileName = prefix + FILE_EXT;
		if(hudsonDir.exists() && hudsonDir.isDirectory()){
			String path = "";
			File matchingDirRoot = new File(HUDSON_RESULTS_DIR + MATCHING_RESULTS_ROOT);
			if(!matchingDirRoot.exists()){
				if(matchingDirRoot.mkdir()){
					path += HUDSON_RESULTS_DIR + MATCHING_RESULTS_ROOT;
				} else {
					path += HUDSON_RESULTS_DIR;
				}
			} else {
				path += HUDSON_RESULTS_DIR + MATCHING_RESULTS_ROOT;
			}
			File matchingDir = new File(path + MATCHING_RESULTS);
			if(!matchingDir.exists()){
				if(matchingDir.mkdir()){
					path += MATCHING_RESULTS + fileName;
				} else {
					path += fileName;
				}
			} else {
				path += MATCHING_RESULTS + fileName;
			}
			file = new File(path);
		} else {
			file = new File(RESULTS_DIR + fileName);
		}
		try {
			File parentFolder = file.getParentFile();
			File[] files = parentFolder.listFiles(new FilenameFilter() {

				public boolean accept(File dir, String name) {
					if(name.equals(fileName)){
						return true;
					}
					return false;
				}
			});
			for (File fileToDelete : files) {
				fileToDelete.delete();
			}
			if(file.createNewFile()){
				FileWriter writer = new FileWriter(file);
				return writer;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
				if(!(metamodel.equals(metamodels.get(MM_UML)) && rolemodel.equals(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS)))){
					matchRoleModelInMetamodel(rolemodel, metamodel, false);
				}
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}

	public void match(List<List<EObject>> linearRolemodels, EPackage metamodel, RoleNode root) {
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

	public void matchClass(Role role, List<EObject> path, EPackage metamodel, MatchNode<?, ?> parent) {
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
					matchClassWithAttribute(role, path, metamodel, parent, classes);
				} else {
					fail("handle EClassifier!");
				}
			} else {
				matchClassWithAttribute(role, path, metamodel, parent, currentMetaClasses);
			}
		} else {
			nextStepAfterMatching(path, metamodel, parent);
		}
	}

	public void matchClassWithAttribute(Role role, List<EObject> path, EPackage metamodel, MatchNode<?, ?> parent, List<EClass> classes) {
		boolean mappable = false;
		List<EClass> classList = new LinkedList<EClass>(classes);
		for (EClass clazz : classList) {
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
	}

	public void nextStepAfterMatching(List<EObject> path, EPackage metamodel, MatchNode<?, ?> node) {
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

	public EClass getMappedClassByRole(Role role, MatchNode<?, ?> node) {
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


	public synchronized List<EClass> getSubClasses(List<EClass> classes, EClass clazz) {
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

	public List<EClass> collectClasses(EPackage metamodel) {
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
	@Ignore
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

		assertTrue("both trees should be equal", c13.equals(c23));

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

		assertFalse("both trees should not be equal", c13.equals(c33));
		assertFalse("both trees should not be equal", c23.equals(c33));

		hashSet.add(c13);
		assertTrue("should not have been added", hashSet.add(c33));
	}
}
