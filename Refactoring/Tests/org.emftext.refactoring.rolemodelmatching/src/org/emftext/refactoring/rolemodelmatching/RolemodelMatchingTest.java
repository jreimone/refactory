package org.emftext.refactoring.rolemodelmatching;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
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
import org.emftext.language.refactoring.roles.RolesFactory;
import org.emftext.language.refactoring.roles.RolesPackage;
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

	private static final String[] rolemodelURIs = new String[] { 
		"platform:/resource/org.emftext.refactoring.extractX/rolemodel/ExtractX.rolestext"
		,"platform:/resource/org.emftext.refactoring.extractSubX/rolemodel/ExtractSubX.rolestext" 
		,"platform:/resource/org.emftext.refactoring.extractXwithReferenceClass/rolemodel/ExtractXwithReferenceClass.rolestext" 
		,"platform:/resource/org.emftext.refactoring.introduceReferenceClass/rolemodel/IntroduceReferenceClass.rolestext" 
		,"platform:/resource/org.emftext.refactoring.moveX/rolemodel/moveX.rolestext" 
		,"platform:/resource/org.emftext.refactoring.moveXloosely/rolemodel/moveXloosely.rolestext" 
		,"platform:/resource/org.emftext.refactoring.removeEmptyContainedX/rolemodel/removeEmptyContainedX.rolestext" 
		,"platform:/resource/org.emftext.refactoring.removeUnusedContainedX/rolemodel/removeUnusedContainedX.rolestext"
		,"platform:/resource/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext"
	};

	private static final String[] metamodelURIs = new String[] { 
		"platform:/resource/org.emftext.language.appflow/metamodel/appflow.text.ecore"
		,"platform:/resource/org.emftext.refactoring.rolematching.testmm/metamodel/testmm.ecore"
		,"platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore"
		,"platform:/resource/org.eclipse.uml2.uml/model/UML.ecore"
		,"platform:/resource/org.emftext.language.pl0/metamodel/pl0.ecore"
		,"platform:/resource/org.emftext.language.forms/metamodel/forms.ecore"
		,"platform:/resource/org.emftext.language.textadventure/metamodel/textadventure.ecore"
	};

	private static List<RoleModel> rolemodels;
	private static List<EPackage> metamodels;

	private List<EClass> currentMetaClasses;
	private Map<RoleModel, List<EObject>> linearRoleModels;

	@BeforeClass
	public static void initialization() {
		registerTestingRootAsPlatformRoot();
		rolemodels = initRoleModels(rolemodelURIs);
		metamodels = initMetamodels(metamodelURIs);
	}

	@Test
	public void matchExtractXtoTestmm(){
		matchRoleModelInMetamodel(rolemodels.get(0), metamodels.get(1));
	}


	@Test
	@Ignore
	public void matchExtractXtoEcore(){
		matchRoleModelInMetamodel(rolemodels.get(0), metamodels.get(2));
	}

	@Test
	@Ignore
	public void matchExtractXwithReferenceClassToEcore(){
		matchRoleModelInMetamodel(rolemodels.get(2), metamodels.get(2));
	}

	@Test
	public void matchExtractXwithReferenceClassToPL0(){
		matchRoleModelInMetamodel(rolemodels.get(2), metamodels.get(4));
	}
	
	@Test
	public void matchMoveXToPL0(){
		matchRoleModelInMetamodel(rolemodels.get(4), metamodels.get(4));
	}

	@Test
	public void matchExtractXwithReferenceClassToForms(){
		matchRoleModelInMetamodel(rolemodels.get(2), metamodels.get(5));
	}

	@Test
	public void matchExtractXwithReferenceClassToTextAdventure(){
		matchRoleModelInMetamodel(rolemodels.get(2), metamodels.get(6));
	}

	@Test
	@Ignore
	public void matchExtractXtoUML(){
		matchRoleModelInMetamodel(rolemodels.get(0), metamodels.get(3));
	}

	private List<EObject> linearizeRoleModel(RoleModel roleModel){
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
		return linearization;
	}

	@Test
	@Ignore
	public void linearizeRoleModels() {
		linearRoleModels = new LinkedHashMap<RoleModel, List<EObject>>();
		for (RoleModel roleModel : rolemodels) {
			List<EObject> linearization = linearizeRoleModel(roleModel);
			linearRoleModels.put(roleModel, linearization);
		}
		for (RoleModel roleModel : rolemodels) {
			List<EObject> linearization = linearRoleModels.get(roleModel);
			printLinearization(roleModel, linearization);
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
	private void matchRoleModelInMetamodel(RoleModel rolemodel, EPackage metamodel){
		RoleNode root = new RoleNode(null);
		root.setMetamodel(metamodel);
		root.setRolemodel(rolemodel);
		List<EObject> linearRolemodel = linearizeRoleModel(rolemodel);
		List<List<EObject>> linearRolemodelsWithoutOptionals = getLinearRoleModelsWithoutOptional(rolemodel, linearRolemodel);
		for (List<EObject> linearRoleModelWithoutOptionals : linearRolemodelsWithoutOptionals) {
			printLinearization(rolemodel, linearRoleModelWithoutOptionals);
		}
		match(linearRolemodelsWithoutOptionals, metamodel, root);
		printTree(root, linearRolemodel);
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
//							EcoreUtil.remove(copier.get(collaboration));
//							copiedRoleModel.getCollaborations().remove(copier.get(collaboration));
						}
						for (Collaboration collaboration : role.getOutgoing()) {
							EcoreUtil.delete(copier.get(collaboration));
//							EcoreUtil.remove(copier.get(collaboration));
//							copiedRoleModel.getCollaborations().remove(copier.get(collaboration));
						}
					}
					List<EObject> linearRolemodelWithoutOptionals = linearizeRoleModel(copiedRoleModel);
					linearRolemodelsWithoutOptional.add(linearRolemodelWithoutOptionals);
				}
			}
		}
		return linearRolemodelsWithoutOptional;
	}

	@Test
	@Ignore
	public void matchAllRoleModelsInAllMetamodels() {
		linearizeRoleModels();
		for (EPackage metamodel : metamodels) {
			for (RoleModel rolemodel : rolemodels) {
				matchRoleModelInMetamodel(rolemodel, metamodel);
			}
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
			currentMetaClasses = collectClasses(metamodel);
			if (parent instanceof CollaborationNode) {
				EReference reference = ((CollaborationNode) parent).getMetaElement();
				if (reference.getEType() instanceof EClass) {
					EClass targetClass = (EClass) reference.getEType();
					List<EClass> classes = getSubClasses(currentMetaClasses, targetClass);
					for (EClass clazz : classes) {
						List<RoleAttribute> roleAttributes = role.getAttributes();
						List<EAttribute> classAttributes = clazz.getEAllAttributes();
						if(roleAttributes.size() == 0 || (roleAttributes.size() > 0 && classAttributes.size() > 0)){
							RoleNode node = new RoleNode(parent);
							node.setMetaElement(clazz);
							node.setRoleElement(role);
							nextStepAfterMatching(path, metamodel, node);
						}
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
			Role target = multiCol.getTarget();
			EClass targetClass = getMappedClassByRole(target, parent);
			if (targetClass == null) {
				for (EReference reference : references) {
					if (referenceMappable(reference, multiCol)) {
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
						CollaborationNode node = new CollaborationNode(parent);
						node.setMetaElement(reference);
						node.setRoleElement(multiCol);
						nextStepAfterMatching(path, metamodel, node);
					}
				}
			}
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

	// ////////////////////////////////////////////////////////////////////////////////////

	private List<MatchNode<?, ?>> getLeafs(MatchNode<?, ?> root) {
		List<MatchNode<?, ?>> leafs = new LinkedList<MatchNode<?, ?>>();
		for (MatchNode<?, ?> child : root.getChildren()) {
			if (child.getChildren().size() == 0 && child.isComplete()) {
				leafs.add(child);
			} else {
				leafs.addAll(getLeafs(child));
			}
		}
		return leafs;
	}

	private int traversePrint(List<MatchNode<?, ?>> leafs, RoleModel rolemodel) {
		List<List<MatchNode<?, ?>>> allMatchPaths = new LinkedList<List<MatchNode<?, ?>>>();
		for (MatchNode<?, ?> leaf : leafs) {
			List<MatchNode<?, ?>> matchPath = new LinkedList<MatchNode<?, ?>>();
			allMatchPaths.add(matchPath);
			MatchNode<?, ?> node = leaf;
			while (node != null && node.getMetaElement() != null
					&& node.getRoleElement() != null) {
				matchPath.add(node);
				node = node.getParent();
			}
			Collections.reverse(matchPath);
		}
		int count = 0;
		for (List<MatchNode<?, ?>> path : allMatchPaths) {
//			int size = linearization.size();
//			if (path.size() == size) {
				count++;
				for (MatchNode<?, ?> matchNode : path) {
					printNode(matchNode);
				}
				System.out.println("******************************************");
//			}
		}
		return count;
	}

	private void printTree(RoleNode root, List<EObject> linearization) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Matching for metamodel: "
				+ root.getMetamodel().getNsURI());
		System.out.println("role model: " + root.getRolemodel().getName());
		System.out.println();
		List<MatchNode<?, ?>> leafs = getLeafs(root);
		RoleModel rolemodel = root.getRolemodel();
		int count = traversePrint(leafs, rolemodel);
		System.err.println("RoleModel '" + rolemodel.getName()
				+ "' could be mapped in MetaModel '" + root.getMetamodel().getNsURI() + "' " + count + " time(s)");
	}

	private void printNode(MatchNode<?, ?> matchNode) {
		EObject roleElement = matchNode.getRoleElement();
		String roleString = "";
		if (roleElement instanceof Role) {
			roleString = ((Role) roleElement).getName();
		} else if (roleElement instanceof MultiplicityCollaboration) {
			roleString = ((MultiplicityCollaboration) roleElement).getTargetName();
		}
		EObject metaElement = matchNode.getMetaElement();
		String metaString = "";
		if (metaElement instanceof ENamedElement) {
			metaString = ((ENamedElement) metaElement).getName();
		}
		System.out.println(roleString + " --> " + metaString);
	}

	private List<EClass> getSubClasses(List<EClass> classes, EClass clazz) {
		List<EClass> subClasses = new LinkedList<EClass>();
		for (EClass eClass : classes) {
			if (eClass.getEAllSuperTypes().contains(clazz)) {
				subClasses.add(eClass);
			}
		}
		subClasses.add(clazz);
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
		EPackage metamodel = metamodels.get(1);
		RoleModel roleModel = rolemodels.get(0);

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
