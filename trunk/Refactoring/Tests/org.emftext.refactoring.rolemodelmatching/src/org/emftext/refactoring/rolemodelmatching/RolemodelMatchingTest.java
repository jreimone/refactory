package org.emftext.refactoring.rolemodelmatching;

import java.util.LinkedList;
import java.util.List;

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
		//		, "platform:/resource/org.emftext.language.appflow/metamodel/appflow.text.ecore"
		//		, "platform:/resource/org.emftext.language.query/metamodel/query.ecore" 
	};

	private static List<RoleModel> rolemodels;
	private static List<EPackage> metamodels;

	private List<MatchNode> matchTrees;
	private List<EClass> currentMetaClasses;

	@BeforeClass
	public static void initialization() {
		registerTestingRootAsPlatformRoot();
		rolemodels = initRoleModels(rolemodelURIs);
		metamodels = initMetamodels(metamodelURIs);
	}

	@Test
	public void matchRoleModels() {
		matchTrees = new LinkedList<MatchNode>();
		for (EPackage metamodel : metamodels) {
			for (RoleModel rolemodel : rolemodels) {
				MatchNode root = new MatchNode(null);
				root.setMetamodel(metamodel);
				root.setRolemodel(rolemodel);
				matchTrees.add(root);
				match(metamodel, rolemodel, root);
				printTree(root);
			}
		}
	}

	private List<MatchNode> getLeafs(MatchNode root){
		List<MatchNode> leafs = new LinkedList<MatchNode>();
		for (MatchNode child : root.getChildren()) {
			if(child.getChildren().size() == 0){
				leafs.add(child);
			} else {
				leafs.addAll(getLeafs(child));
			}
		}
		return leafs;
	}

	private void traversePrint(List<MatchNode> leafs){
		for (MatchNode leaf : leafs) {
			MatchNode node = leaf;
			while (node != null) {
				printNode(node);
				node = node.getParent();
			}
			System.out.println("******************************************");
		}
	}

	private void printTree(MatchNode root) {
		System.out.println("Matching for metamodel: " + root.getMetamodel().getNsURI());
		System.out.println("role model: " + root.getRolemodel().getName());
		List<MatchNode> leafs = getLeafs(root);
		traversePrint(leafs);
	}

	private void printNode(MatchNode matchNode) {
		EObject roleElement = matchNode.getRoleElement();
		String roleString = "";
		if(roleElement instanceof Role){
			roleString = ((Role) roleElement).getName();
		} else if(roleElement instanceof MultiplicityCollaboration){
			roleString = ((MultiplicityCollaboration) roleElement).getTargetName();
		}
		EObject metaElement = matchNode.getMetaElement();
		String metaString = "";
		if(metaElement instanceof ENamedElement){
			metaString = ((ENamedElement) metaElement).getName();
		}
		System.out.println(roleString + " --> " + metaString);
	}

	private void match(EPackage metamodel, RoleModel rolemodel, MatchNode parent) {
		List<Role> roles = rolemodel.getRoles();
		List<Role> copiedRoles = new LinkedList<Role>(roles);
		currentMetaClasses = collectClasses(metamodel);
		for (Role role : roles) {
			copiedRoles.remove(role);
			for (EClass clazz : currentMetaClasses) {
				MatchNode node = new MatchNode(parent);
				node.setMetaElement(clazz);
				node.setRoleElement(role);
				List<Collaboration> collaborations = role.getOutgoing();
				List<MultiplicityCollaboration> navigableCollaborations = filterCollaborations(collaborations);
				List<EReference> references = clazz.getEAllReferences();
				matchCollaborations(clazz, references, role, navigableCollaborations, node);
			}
		}
	}

	private List<MultiplicityCollaboration> filterCollaborations(List<Collaboration> collaborations) {
		List<MultiplicityCollaboration> filteredCollaborations = new LinkedList<MultiplicityCollaboration>();
		for (Collaboration collaboration : collaborations) {
			if (collaboration instanceof MultiplicityCollaboration) {
				filteredCollaborations.add((MultiplicityCollaboration) collaboration);
			}
		}
		return filteredCollaborations;
	}

	private List<MatchNode> matchCollaborations(EClass clazz, List<EReference> references, Role role, List<MultiplicityCollaboration> collaborations, MatchNode node) {
		List<MatchNode> leafs = new LinkedList<MatchNode>();
		if (collaborations.size() > references.size()) {
			node.getParent().getChildren().remove(node);
			return new LinkedList<MatchNode>();
		}
		VariationGenerator<EReference> generator = new VariationGenerator<EReference>();
		List<List<EReference>> variations = generator.getVariations(references, collaborations.size());
		for (List<EReference> list : variations) {
			MatchNode parent = node;
			if (referencesMappable(list, collaborations)) {
				for (int i = 0; i < list.size(); i++) {
					EReference reference = list.get(i);
					MultiplicityCollaboration collaboration = collaborations.get(i);
					if (!branchContainsMatch(parent, collaboration)) {
						MatchNode child = new MatchNode(parent);
						child.setMetaElement(reference);
						child.setRoleElement(collaboration);
						List<MatchNode> currentLeafs = matchClass(reference, collaboration, child);
						leafs.addAll(currentLeafs);
						for (MatchNode matchNode : currentLeafs) {
							parent = matchNode;
							if (parent == null) { // Branch nicht komplett matchable -> muss wieder raus
								MatchNode parentForRemoval = child.getParent();
								MatchNode removal = child;
								while (!parentForRemoval.equals(node)) {
									removal = parentForRemoval;
									parentForRemoval = parentForRemoval.getParent();
								}
								parentForRemoval.getChildren().remove(removal);
							}
						}
						if(currentLeafs.size() == 0){
							leafs.add(child);
						}
					}
				}
			}
		}
		if(variations.size() == 0){
			leafs.add(node);
		}
		return leafs;
	}

	private List<MatchNode> matchClass(EReference reference, MultiplicityCollaboration collaboration, MatchNode node) {
		List<MatchNode> nodes = new LinkedList<MatchNode>();
		EClassifier type = reference.getEType();
		if (type instanceof EClass) {
			Role target = collaboration.getTarget();
			List<Collaboration> collaborations = target.getOutgoing();
			List<MultiplicityCollaboration> navigableCollaborations = filterCollaborations(collaborations);
			if (!branchContainsMatch(node, target)) {
				EClass clazz = (EClass) type;
				List<EClass> classes = getSubClasses(currentMetaClasses, clazz);
				classes.add(clazz);
				for (EClass eClass : classes) {
					MatchNode child = new MatchNode(node);
					child.setMetaElement(eClass);
					child.setRoleElement(collaboration);
					List<EReference> references = clazz.getEAllReferences();
					List<MatchNode> leafs = matchCollaborations(eClass, references, target, navigableCollaborations, child);
					nodes.addAll(leafs);
				}
			}

		}
		return nodes;
	}

	private List<EClass> getSubClasses(List<EClass> classes, EClass clazz) {
		List<EClass> subClasses = new LinkedList<EClass>();
		for (EClass eClass : classes) {
			if (eClass.getEAllSuperTypes().contains(clazz)) {
				subClasses.add(eClass);
			}
		}
		return subClasses;
	}

	private boolean branchContainsMatch(MatchNode parent, EObject roleElement) {
		MatchNode node = parent;
		while (node != null) {
			if(node.getParent() == null){
				return false;
			} else if (node.getRoleElement().equals(roleElement)) {
				return true;
			}
			node = node.getParent();
		}
		return false;
	}

	private boolean referencesMappable(List<EReference> list, List<MultiplicityCollaboration> collaborations) {
		for (int i = 0; i < list.size(); i++) {
			EReference reference = list.get(i);
			Collaboration collaboration = collaborations.get(i);
			if (collaboration instanceof RoleComposition) {
				if (!reference.isContainment()) {
					return false;
				}
			} else if (collaboration instanceof RoleAssociation) {
				if (reference.isContainment()) {
					return false;
				}
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
