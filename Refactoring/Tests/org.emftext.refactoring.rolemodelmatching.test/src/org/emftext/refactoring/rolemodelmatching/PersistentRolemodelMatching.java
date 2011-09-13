package org.emftext.refactoring.rolemodelmatching;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
import org.emftext.refactoring.rolemodelmatching.listener.FilterMappingFilePrinterListener;
import org.emftext.refactoring.rolemodelmatching.listener.FilterMappingListener;
import org.emftext.refactoring.rolemodelmatching.listener.LeafCollectorListener;
import org.emftext.refactoring.rolemodelmatching.listener.MatchNodeList;
import org.emftext.refactoring.rolemodelmatching.listener.PersistMatchPathListener;
import org.emftext.refactoring.rolemodelmatching.listener.RemoveIncompletePathListener;
import org.emftext.refactoring.rolemodelmatching.listener.ValidMappingListener;
import org.emftext.refactoring.rolemodelmatching.visitors.CollectDistinctMappingsVisitor;
import org.emftext.refactoring.rolemodelmatching.visitors.INodeVisitor;
import org.emftext.refactoring.rolemodelmatching.visitors.LeafCollectorVisitor;
import org.emftext.refactoring.rolemodelmatching.visitors.LeafCounterVisitor;
import org.emftext.refactoring.rolemodelmatching.visitors.PersistPreSelectedMappingsCountComplexVisitor;
import org.emftext.refactoring.rolemodelmatching.visitors.PersistPreSelectedMappingsCountVisitor;
import org.emftext.refactoring.rolemodelmatching.visitors.PreSelectedMappingsCountVisitor;

/**
 * A test class trying to match rolemodels on simple structures in a target
 * metamodel. 'Simple structure' means that collaborations are only matched to
 * single relations and not to paths of relations.
 * 
 * @author jreimann
 * 
 */
public class PersistentRolemodelMatching extends RolemodelMatchingInitialization {

	public List<EClass> currentMetaClasses;

	private RoleModel rolemodel;
	private EPackage metamodel;

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

	public void calculateMatchTreeAndFilter(RoleModel rolemodel, EPackage metamodel, boolean print){
		this.rolemodel = rolemodel;
		this.metamodel = metamodel;
		String fileName = getFileName(ALL_VALID_MAPPINGS_FILE, rolemodel, metamodel, FILE_EXT);
		File file = getFile(fileName);
		if(file.isFile() && file.exists()){
			System.out.println("----------------------------------------");
			System.gc();
			System.out.println(rolemodel.getName() + " -> " + metamodel.getNsURI());
			constructStringMatchingTree(file);
		} else {
			calculateMatchTree(rolemodel, metamodel, print);
			System.gc();
			calculateMatchTreeAndFilter(rolemodel, metamodel, print);
		}
	}

	private void constructStringMatchingTree(File file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = null;
			StringMappingNode root = new StringMappingNode(null);
			Map<Class<? extends INodeVisitor>, INodeVisitor> visitorMap = addVisitors();
			List<String> stringCache = new ArrayList<String>();
			while ((line = in.readLine()) != null) {
				String[] mappingParts = line.split(MAPPING_SEPARATOR);
				addMapping(stringCache, root, mappingParts, visitorMap);
			}
			publishVisitors(visitorMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private Map<Class<? extends INodeVisitor>, INodeVisitor> addVisitors() {
		Map<Class<? extends INodeVisitor>, INodeVisitor> visitorMap = new HashMap<Class<? extends INodeVisitor>, INodeVisitor>();
		// leafCollector only collects all leafs representing all valid matches
		LeafCollectorVisitor leafCollector = new LeafCollectorVisitor();
		visitorMap.put(LeafCollectorVisitor.class, leafCollector);
		// a visitor which collects all distinct mappings which are needed to filter the whole match tree
		CollectDistinctMappingsVisitor distinctMappingCollector = new CollectDistinctMappingsVisitor();
		visitorMap.put(CollectDistinctMappingsVisitor.class, distinctMappingCollector);
		return visitorMap;
	}

	private void publishVisitors(Map<Class<? extends INodeVisitor>, INodeVisitor> visitorMap) {
		// print size of collected leafs
		LeafCollectorVisitor leafCollectorVisitor = getVisitorByType(visitorMap, LeafCollectorVisitor.class);
		int count = 0;
		if(leafCollectorVisitor.getLeafList() != null){
			count = leafCollectorVisitor.getLeafList().size();
		}
		System.out.println("All valid mappings: " + count);
		// print number of collected distinct mappings from role to metaclass
		count = 0;
		CollectDistinctMappingsVisitor distinctMappingCollector = getVisitorByType(visitorMap, CollectDistinctMappingsVisitor.class);
		if(distinctMappingCollector.getDistinctNodeSet() != null){
			count = distinctMappingCollector.getDistinctNodeSet().size();
		}
		System.out.println("number of distinct mappings: " + count);
		StringMappingNode matchingTree = new StringMappingNode(null);
		Map<Class<? extends INodeVisitor>, INodeVisitor> filterVisitorMap = addFilterVisitors();
		constructFilteredMatchingTree(leafCollectorVisitor.getLeafList(), distinctMappingCollector.getDistinctNodeSet(), matchingTree, filterVisitorMap);
		publishFilterVisitors(filterVisitorMap);
	}

	private void publishFilterVisitors(Map<Class<? extends INodeVisitor>, INodeVisitor> filterVisitorMap) {
		LeafCounterVisitor leafCounterVisitor = getVisitorByType(filterVisitorMap, LeafCounterVisitor.class);
		System.out.println("different possibilities of manual mappings: " + leafCounterVisitor.getLeafCount());
		PreSelectedMappingsCountVisitor preSelectedmappingsVisitor = getVisitorByType(filterVisitorMap, PreSelectedMappingsCountVisitor.class);
		int overAllPreSelections = preSelectedmappingsVisitor.getPreSelectedMappingsCount();
		double averagePreSelectionCount;
		if(leafCounterVisitor.getLeafCount() == 0){
			averagePreSelectionCount = 0.0;
		} else {
			averagePreSelectionCount = new Integer(overAllPreSelections).doubleValue() / new Integer(leafCounterVisitor.getLeafCount()).doubleValue();
		}
		System.out.println("average pre-selections: " + averagePreSelectionCount);
		PersistPreSelectedMappingsCountVisitor persistentPreSelectionsCounter = getVisitorByType(filterVisitorMap, PersistPreSelectedMappingsCountVisitor.class);
		PersistPreSelectedMappingsCountComplexVisitor persistentPreSelectionsComplexCounter = getVisitorByType(filterVisitorMap, PersistPreSelectedMappingsCountComplexVisitor.class);
		try {
			persistentPreSelectionsCounter.getFileWriter().close();
			persistentPreSelectionsComplexCounter.getFileWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private Map<Class<? extends INodeVisitor>, INodeVisitor> addFilterVisitors() {
		Map<Class<? extends INodeVisitor>, INodeVisitor> visitorMap = new HashMap<Class<? extends INodeVisitor>, INodeVisitor>();
		LeafCounterVisitor filterCounterVisitor = new LeafCounterVisitor();
		visitorMap.put(LeafCounterVisitor.class, filterCounterVisitor);
		PreSelectedMappingsCountVisitor preSelectedmappingsVisitor = new PreSelectedMappingsCountVisitor();
		visitorMap.put(PreSelectedMappingsCountVisitor.class, preSelectedmappingsVisitor);
		FileWriter fileWriter = getFileWriter(FILTERED_MATCHES_FILE_SHORT + "_" + MAX_MAPPINGS_COUNT, rolemodel, metamodel, FILE_CSV_EXT);
		PersistPreSelectedMappingsCountVisitor persistentPreSelectionsCounter = new PersistPreSelectedMappingsCountVisitor(fileWriter);
		visitorMap.put(PersistPreSelectedMappingsCountVisitor.class, persistentPreSelectionsCounter);
		FileWriter fileWriterComplex = getFileWriter(FILTERED_MATCHES_FILE + "_" + MAX_MAPPINGS_COUNT, rolemodel, metamodel);
		PersistPreSelectedMappingsCountComplexVisitor persistentPreSelectionsComplexCounter = new PersistPreSelectedMappingsCountComplexVisitor(fileWriterComplex);
		visitorMap.put(PersistPreSelectedMappingsCountComplexVisitor.class, persistentPreSelectionsComplexCounter);
		return visitorMap;
	}


	private void constructFilteredMatchingTree(List<StringMappingNode> leafList, Set<String> distinctNodeSet, StringMappingNode root, Map<Class<? extends INodeVisitor>, INodeVisitor> visitorMap) {
		if(leafList == null){
			return;
		}
		StringMappingNode parent = root;
		for (String mapping : distinctNodeSet) {
			StringMappingNode child = new StringMappingNode(parent);
			child.setMappingString(mapping);
			List<StringMappingNode> filteredLeafList = new ArrayList<StringMappingNode>();
			for (StringMappingNode leaf : leafList) {
				StringMappingNodeList rootList = leaf.getListFromRoot();
				if(rootList.contains(mapping)){
					filteredLeafList.add(leaf);
				}
			}
			if(filteredLeafList.size() > MAX_MAPPINGS_COUNT){
				CollectDistinctMappingsVisitor filteredMappingsVisitor = new CollectDistinctMappingsVisitor();
				for (StringMappingNode filteredLeaf : filteredLeafList) {
					filteredMappingsVisitor.visit(filteredLeaf, null);
				}
				Set<String> filterednodeSet = filteredMappingsVisitor.getDistinctNodeSet();
				filterednodeSet.remove(mapping);
				filterednodeSet.retainAll(distinctNodeSet);
				constructFilteredMatchingTree(filteredLeafList, filterednodeSet, child, visitorMap);
			} else {
				Collection<INodeVisitor> visitors = visitorMap.values();
				for (INodeVisitor visitor : visitors) {
					visitor.visit(child, filteredLeafList);
				}
				//				StringMappingNodeList completeMapping = child.getListFromRoot();
				//				try {
				//					fileWriter.append("manual mappings which result in less than " + MAX_MAPPINGS_COUNT + " valid complete mappings (" + completeMapping.size() + " pre-selected): ");
				//					//				System.out.print("manual mappings which result in less than " + MAX_MAPPINGS_COUNT + " valid complete mappings (" + completeMapping.size() + " pre-selected): ");
				//					//					printMappingNodeList(completeMapping);
				//					fileWriter.append(completeMapping.printList() + "\n");
				//					fileWriter.append("\tleft valid mappings: " + filteredLeafList.size() + "\n");
				//					//					System.out.println("\tleft valid mappings: " + filteredLeafList.size());
				////					for (StringMappingNode stringMappingNode : filteredLeafList) {
				////						//					System.out.print("\t");
				////						fileWriter.append("\t");
				////						//					printMappingNodeList(stringMappingNode.getListFromRoot());
				////						fileWriter.append(printMappingNodeList(stringMappingNode.getListFromRoot()) + "\n");
				////					}
				//				} catch (IOException e) {
				//					e.printStackTrace();
				//				}
			}
		}
	}


	@SuppressWarnings("unchecked")
	private <T extends INodeVisitor> T getVisitorByType(Map<Class<? extends INodeVisitor>, INodeVisitor> visitorMap, Class<T> visitorType){
		return (T) visitorMap.get(visitorType);
	}


	private void addMapping(List<String> stringCache, StringMappingNode root, String[] mappingParts, Map<Class<? extends INodeVisitor>, INodeVisitor> visitorMap) {
		StringMappingNode currentParent = root;
		List<StringMappingNode> children = currentParent.getChildren();
		if(children.size() == 0){
			for (String mapping : mappingParts) {
				currentParent = createStringMappingNode(stringCache, currentParent, mapping);
			}
		} else {
			int i = 0;
			String mapping = mappingParts[i];
			while(children.contains(mapping)){
				currentParent = children.get(children.indexOf(mapping));
				children = currentParent.getChildren();
				i++;
				mapping = mappingParts[i];
			}
			if(i < (mappingParts.length - 1)){
				for (; i < mappingParts.length; i++) {
					mapping = mappingParts[i];
					currentParent = createStringMappingNode(stringCache, currentParent, mapping);
				}
			}
		}
		Collection<INodeVisitor> visitors = visitorMap.values();
		for (INodeVisitor visitor : visitors) {
			visitor.visit(currentParent, null);
		}
	}


	private StringMappingNode createStringMappingNode(List<String> stringCache, StringMappingNode currentParent, String mapping) {
		StringMappingNode child = new StringMappingNode(currentParent);
		if(!stringCache.contains(mapping)){
			stringCache.add(mapping);
		}
		child.setMappingString(stringCache.get(stringCache.indexOf(mapping)));
		return child;
	}


	/**
	 * Only claculates the match tree and persists it on disc.
	 * 
	 * @param rolemodel
	 * @param metamodel
	 * @param print
	 */
	public void calculateMatchTree(RoleModel rolemodel, EPackage metamodel, boolean print){
		double freeMemoryStart = Runtime.getRuntime().freeMemory();
		freeMemoryStart = freeMemoryStart / 1024 / 1024;
		System.out.println("memory start: " + freeMemoryStart + "MB");
		RoleNode root = new RoleNode(null);

		AtomicInteger incompleteCount = new AtomicInteger();
		RemoveIncompletePathListener incompletePathListener = new RemoveIncompletePathListener(incompleteCount, rolemodel, metamodel);
		root.addListener(incompletePathListener);
		FileWriter mappingsWriter = getFileWriter(ALL_VALID_MAPPINGS_FILE, rolemodel, metamodel);
		if(mappingsWriter != null){
			PersistMatchPathListener filePrinter = new PersistMatchPathListener(mappingsWriter, print);
			root.addListener(filePrinter);
		}

		root.setMetamodel(metamodel);
		root.setRolemodel(rolemodel);
		List<List<EObject>> linearRolemodelsWithoutOptionals = linearizeRoleModel(rolemodel);
		match(linearRolemodelsWithoutOptionals, metamodel, root);
		incompletePathListener.printIncompleteRemovals();
		try {
			mappingsWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.gc();
		double freeMemoryEnd = Runtime.getRuntime().freeMemory();
		freeMemoryEnd = freeMemoryEnd / 1024 / 1024;
		System.out.println("memory end: " + freeMemoryEnd + "MB (" + (freeMemoryStart - freeMemoryEnd) + "MB)");
	}



	/**
	 * 
	 * @param rolemodel
	 * @param metamodel
	 * @return root of the match tree
	 */
	public void matchRoleModelInMetamodel(RoleModel rolemodel, EPackage metamodel, boolean print){
		double freeMemoryStart = Runtime.getRuntime().freeMemory();
		freeMemoryStart = freeMemoryStart / 1024 / 1024;
		System.out.println("memory start: " + freeMemoryStart + "MB");
		RoleNode root = new RoleNode(null);
		//				INodeListener printMatchPathListener = new PrintMatchPathListener();
		//				root.addListener(printMatchPathListener);
		AtomicInteger count = new AtomicInteger();
		//		MatchCountListener matchCountListener = new MatchCountListener(count, rolemodel, metamodel);
		//		root.addListener(matchCountListener);
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
		//		INodeListener removeCompletePathListener = new RemoveCompletePathListener(leafCollector);
		//		root.addListener(removeCompletePathListener);

		MatchNodeList validMappings = new MatchNodeList();
		ValidMappingListener validMappingsListener = new ValidMappingListener(validMappings);
		root.addListener(validMappingsListener);

		root.setMetamodel(metamodel);
		root.setRolemodel(rolemodel);
		List<List<EObject>> linearRolemodelsWithoutOptionals = linearizeRoleModel(rolemodel);
		match(linearRolemodelsWithoutOptionals, metamodel, root);
		//		matchCountListener.printCount();
		System.out.println(rolemodel.getName() + " --> " + metamodel.getNsURI() + " mapped: " + leafCollector.getLeafList().size());
		//		System.out.println("Overall valid mappings: " + validMappings.size());
		incompletePathListener.printIncompleteRemovals();

		double freeMemoryBeforeFilter = Runtime.getRuntime().freeMemory();
		freeMemoryBeforeFilter = freeMemoryBeforeFilter / 1024 / 1024;
		System.gc();
		System.out.println("memory before filter: " + freeMemoryBeforeFilter + "MB (" + (freeMemoryStart - freeMemoryBeforeFilter) + "MB)");
		saveFilteredMappings(rolemodel, metamodel, count, leafList, validMappings);
		double freeMemoryAfterFilter = Runtime.getRuntime().freeMemory();
		freeMemoryAfterFilter = freeMemoryAfterFilter / 1024 / 1024;
		System.out.println("memory after filter: " + freeMemoryAfterFilter + "MB (" + (freeMemoryBeforeFilter - freeMemoryAfterFilter) + "MB)");
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


}
