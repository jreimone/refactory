package org.emftext.refactoring.rolemodelmatching;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAssociation;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleModel;
import org.junit.BeforeClass;
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
	};

	private static final String[] metamodelURIs = new String[] { 
		"platform:/resource/org.emftext.refactoring.rolematching.testmm/metamodel/testmm.ecore"
		,"platform:/resource/org.emftext.language.appflow/metamodel/appflow.text.ecore"
		// , "platform:/resource/org.emftext.language.query/metamodel/query.ecore"
	};

	private static List<RoleModel> rolemodels;
	private static List<EPackage> metamodels;

	private List<MatchNode<?, ?>> matchTrees;
	private List<EClass> currentMetaClasses;
	private Map<RoleModel, List<EObject>> linearRoleModels;

	@BeforeClass
	public static void initialization() {
		registerTestingRootAsPlatformRoot();
		rolemodels = initRoleModels(rolemodelURIs);
		metamodels = initMetamodels(metamodelURIs);
	}

	@Test
	public void linearizeRoleModels() {
		linearRoleModels = new LinkedHashMap<RoleModel, List<EObject>>();
		for (RoleModel roleModel : rolemodels) {
			List<EObject> leftElements = new LinkedList<EObject>();
			leftElements.addAll(roleModel.getRoles());
			leftElements.addAll(roleModel.getCollaborations());
			LinkedList<EObject> linearization = new LinkedList<EObject>();
			linearRoleModels.put(roleModel, linearization);
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
		}
		for (RoleModel roleModel : rolemodels) {
			List<EObject> linearization = linearRoleModels.get(roleModel);
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

	@Test
	public void matchPaths() {
		linearizeRoleModels();
		matchTrees = new LinkedList<MatchNode<?, ?>>();
		for (EPackage metamodel : metamodels) {
			for (RoleModel rolemodel : rolemodels) {
				RoleNode root = new RoleNode(null);
				matchTrees.add(root);
				root.setMetamodel(metamodel);
				root.setRolemodel(rolemodel);
				List<EObject> linearRolemodel = linearRoleModels.get(rolemodel);
				match(linearRolemodel, metamodel, root);
				printTree(root, rolemodel);
			}
		}
	}

	private void match(List<EObject> linearRolemodel, EPackage metamodel, RoleNode root) {
		EObject element = linearRolemodel.get(0);
		List<EObject> reducedPath = new LinkedList<EObject>(linearRolemodel);
		reducedPath.remove(element);
		if (element instanceof Role) {
			matchClass((Role) element, reducedPath, metamodel, root);
		} else {
			fail("invalid element");
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
						if(roleAttributes.size() <= classAttributes.size()){
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
			if (child.getChildren().size() == 0) {
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
			int size = linearRoleModels.get(rolemodel).size();
			if (path.size() == size) {
				count++;
				for (MatchNode<?, ?> matchNode : path) {
					printNode(matchNode);
				}
				System.out.println("******************************************");
			}
		}
		return count;
	}

	private void printTree(MatchNode<?, ?> root, RoleModel rolemodel) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Matching for metamodel: "
				+ root.getMetamodel().getNsURI());
		System.out.println("role model: " + root.getRolemodel().getName());
		System.out.println();
		List<MatchNode<?, ?>> leafs = getLeafs(root);
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
}
