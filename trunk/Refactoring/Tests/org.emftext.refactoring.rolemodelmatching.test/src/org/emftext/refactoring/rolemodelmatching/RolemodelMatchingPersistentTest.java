package org.emftext.refactoring.rolemodelmatching;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stp.bpmn.SubProcess;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Region;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class RolemodelMatchingPersistentTest extends RolemodelMatchingInitialRegistrations{

	public static Map<String, RoleModel> rolemodels;
	public static Map<String, EPackage> metamodels;

	private Map<RoleModel, List<List<EObject>>> linearRoleModels;
	private PersistentRolemodelMatching matchingAlgorithm;

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
	public void algorithmInitialisation(){
		matchingAlgorithm = new PersistentRolemodelMatching();
	}

	@Test
	public void countStructuralFeaturesFromUMLStateMachineAndRegion(){
		EPackage umlMetamodel = metamodels.get(MM_UML);
		EClass region = (EClass) umlMetamodel.getEClassifier("Region");
		EClass stateMachine = (EClass) umlMetamodel.getEClassifier("StateMachine");
		EList<EStructuralFeature> statMachineFeatures = stateMachine.getEAllStructuralFeatures();
		List<EReference> composites = new ArrayList<EReference>();
		for (EStructuralFeature feature : statMachineFeatures) {
			if(feature instanceof EReference && ((EReference) feature).isContainment()){
				composites.add((EReference) feature);
			}
		}
		List<EClass> regionContainingClasses = new ArrayList<EClass>();
		for (EClassifier classifier : umlMetamodel.getEClassifiers()) {
			if(classifier instanceof EClass){
				EClass eclass = (EClass) classifier;
				EList<EStructuralFeature> features = eclass.getEAllStructuralFeatures();
				for (EStructuralFeature feature : features) {
					if(feature instanceof EReference && ((EReference) feature).isContainment() && ((EReference) feature).getEType().equals(region)){
						regionContainingClasses.add(eclass);
					}
				}
			}
		}
		System.out.println("metaclass StateMachine has composite features: " + composites.size());
		System.out.println("metaclass Region is contained by other metaclasses: " + regionContainingClasses.size());
	}

	@Test
	public void matchExtractXtoEcore(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_EXTRACT_X), metamodels.get(MM_ECORE), false);
	}

	@Test
	public void matchMooveXlooselytoUML(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_UML), true);
	}

	@Test
	public void matchMooveXlooselytoBPMN(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_BPMN), true);
	}

	@Test
	public void matchMooveXlooselytoJava(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_JAVA), true);
	}

	@Test
	public void matchMooveXlooselytoCS(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_CS), true);
	}

	@Test
	public void matchMooveXlooselytoFeature(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_FEATURE), true);
	}

	@Test
	public void matchMooveXlooselytoTA(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_TA), true);
	}

	@Test
	public void matchMooveXlooselytoPL0(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_PL0), true);
	}

	@Test
	public void matchMooveXlooselytoOWL(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_OWL), true);
	}

	@Test
	public void matchMooveXlooselytoEcore(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_ECORE), true);
	}

	@Test
	public void matchMooveXlooselytoOffice(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_OFFICE), true);
	}

	@Test
	public void matchMooveXlooselytoForms(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_XLOOSELY), metamodels.get(MM_FORMS), true);
	}

	@Test
	public void matchRemoveUnusedContainedXtoEcore(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_REMOVE_UNUSED_CONTAINED_X), metamodels.get(MM_ECORE), true);
	}

	@Test
	public void matchRemoveEmptyContainedXtoEcore(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_REMOVE_EMPTY_CONTAINED_X), metamodels.get(MM_ECORE), true);
	}

	@Test
	public void matchExtractXwithReferenceClassToEcore(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_ECORE), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToPL0(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_PL0), false);
	}

	@Test
	public void matchMoveXToPL0(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_MOVE_X), metamodels.get(MM_PL0), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToForms(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_FORMS), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToTextAdventure(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_TEXTADVENTURE), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToJava(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_JAVA), false);
	}

	@Test
	public void matchExtractXtoUML(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_EXTRACT_X), metamodels.get(MM_UML), false);
	}

	@Test
	public void matchExtractXwithReferenceClassToUML(){
		matchingAlgorithm.calculateMatchTreeAndFilter(rolemodels.get(RM_EXTRACT_XWITH_REFERENCE_CLASS), metamodels.get(MM_UML), false);
	}

	@Test
	@Ignore
	public void linearizeRoleModels() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Linearization of RoleModels:");
		linearRoleModels = new LinkedHashMap<RoleModel, List<List<EObject>>>();
		for (RoleModel roleModel : rolemodels.values()) {
			List<List<EObject>> linearizations = matchingAlgorithm.linearizeRoleModel(roleModel);
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

	@Test
	public void matchAllRoleModelsInAllMetamodelsFor15Remaining() {
		for (EPackage metamodel : metamodels.values()) {
			for (RoleModel rolemodel : rolemodels.values()) {
				matchingAlgorithm.calculateMatchTreeAndFilter(rolemodel, metamodel, false, 15);
				matchingAlgorithm = new PersistentRolemodelMatching();
				System.gc();
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}
	
	@Test
	public void matchAllRoleModelsInAllMetamodelsFor20Remaining() {
		for (EPackage metamodel : metamodels.values()) {
			for (RoleModel rolemodel : rolemodels.values()) {
				matchingAlgorithm.calculateMatchTreeAndFilter(rolemodel, metamodel, false, 20);
				matchingAlgorithm = new PersistentRolemodelMatching();
				System.gc();
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
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
}
