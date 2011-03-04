package org.emftext.refactoring.rolemodelmatching_long;

import static org.junit.Assert.fail;

import java.io.FileWriter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.stp.bpmn.SubProcess;
import org.eclipse.uml2.uml.Class;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.rolemodelmatching.CollaborationNode;
import org.emftext.refactoring.rolemodelmatching.MatchNode;
import org.emftext.refactoring.rolemodelmatching.RoleNode;
import org.emftext.refactoring.rolemodelmatching.RolemodelMatchingTest;
import org.emftext.refactoring.rolemodelmatching.listener.EqualityCheckListener;
import org.emftext.refactoring.rolemodelmatching.listener.FilePrinterListener;
import org.emftext.refactoring.rolemodelmatching.listener.INodeListener;
import org.emftext.refactoring.rolemodelmatching.listener.MatchCountListener;
import org.emftext.refactoring.rolemodelmatching.listener.RemoveIncompletePathListener;
import org.junit.Before;
import org.junit.BeforeClass;

public class LongRoleModelMatchingTest extends RolemodelMatchingTest{

	public static final String PLUGIN_DIR 	= "results-org.emftext.refactoring.rolemodelmatching.long.test/";
	private Map<EClass, List<EClass>> subClassesCache;

	@Before
	public void cacheInitialization(){
		subClassesCache = new LinkedHashMap<EClass, List<EClass>>();
	}
	
	@BeforeClass
	public static void initialization() {
		MATCHING_RESULTS_ROOT = PLUGIN_DIR;
		registerTestingRootAsPlatformRoot();
		rolemodels = initRoleModels(rolemodelURIs);
		metamodels = initMetamodels(metamodelURIs);
		initAndRegisterArchiveMetamodel("/model/Ecore.ecore", MM_ECORE, EClass.class, metamodels);
		initAndRegisterArchiveMetamodel("/model/UML.ecore", MM_UML, Class.class, metamodels);
		initAndRegisterArchiveMetamodel("/model/bpmn.ecore", MM_BPMN, SubProcess.class, metamodels);
	}

	@Override
	public void matchRoleModelInMetamodel(RoleModel rolemodel, EPackage metamodel, boolean print) {
		RoleNode root = new RoleNode(null);
		AtomicInteger count = new AtomicInteger();
		MatchCountListener matchCountListener = new MatchCountListener(count, rolemodel, metamodel);
		root.addListener(matchCountListener);
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

		root.setMetamodel(metamodel);
		root.setRolemodel(rolemodel);
		List<List<EObject>> linearRolemodelsWithoutOptionals = linearizeRoleModel(rolemodel);
		match(linearRolemodelsWithoutOptionals, metamodel, root);
		matchCountListener.printCount();
	}

	@Override
	public void matchClass(Role role, List<EObject> path, EPackage metamodel, MatchNode<?, ?> parent) {
		if (getMappedClassByRole(role, parent) == null) {
			if(currentMetaClasses == null){
				currentMetaClasses = collectClasses(metamodel);
			}
			if (parent instanceof CollaborationNode) {
				EReference reference = ((CollaborationNode) parent).getMetaElement();
				if (reference.getEType() instanceof EClass) {
					EClass targetClass = (EClass) reference.getEType();
					List<EClass> classes = getSubClasses(currentMetaClasses, targetClass);
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

	@Override
	public List<EClass> getSubClasses(List<EClass> classes, EClass clazz) {
		List<EClass> subClasses = subClassesCache.get(clazz);
		if(subClasses == null){
			subClasses = new LinkedList<EClass>();
			subClassesCache.put(clazz, subClasses);
			for (int i = 0; i < classes.size(); i++) {
				EClass eClass = classes.get(i);
				if (eClass.getEAllSuperTypes().contains(clazz)) {
					subClasses.add(eClass);
				}
			}
		}
		return subClasses;
	}


}
