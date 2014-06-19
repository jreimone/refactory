package org.modelrefactoring.guery.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RolemappingFactory;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.matching.guery.RoleModel2MotifConverter;

public class PL0SpecificMotifSolvingTest extends AbstractSpecificMotifSolvingTestFragment {

	private static final String GUERY_FILE				= "queries/ExtractXwithReferenceClass_pl0_MPL4_specific.guery";
	private static final String ROLEMODEL_FILE_NAME		= "rolemodels/ExtractXwithReferenceClass.rolestext";
	private static final int MAX_RESULTS 					= 10000;
	private static final int MAX_PATH_LENGTH				= 4;
	private static final Map<String, String> PRE_MAPPINGS = new HashMap<String, String>();
	
	static{
		PRE_MAPPINGS.put("MovedReference", "CallStatement");
		PRE_MAPPINGS.put("NewContainer", "ProcedureDeclaration");
		PRE_MAPPINGS.put("Extract", "Statement");
	}
	
	@Override
	protected MotifModel getMotifModel() {
		EObject model = loadModel(getRoleModelFileName());
		assertNotNull("Resource must contain a model", model);
		assertTrue("Model must be a MotifModel", model instanceof RoleModel);
		RoleModel roleModel = (RoleModel) model;
		RoleMapping roleMapping = createRoleMapping(roleModel);
		RoleModel2MotifConverter converter = new RoleModel2MotifConverter(roleMapping);
		MotifModel motifModel = converter.createMotifModel(MAX_PATH_LENGTH);
		saveModel(motifModel, "queries/" + roleModel.getName() + "_" + getTargetMetamodel().getName() + "_MPL" + MAX_PATH_LENGTH + "_premapped.guery");
		return motifModel;
	}

	protected RoleMapping createRoleMapping(RoleModel roleModel) {
		RoleMapping roleMapping = RolemappingFactory.eINSTANCE.createRoleMapping();
		roleMapping.setMappedRoleModel(roleModel);
		for (String role : PRE_MAPPINGS.keySet()) {
			ConcreteMapping concreteMapping = RolemappingFactory.eINSTANCE.createConcreteMapping();
			concreteMapping.setRole(getRoleByName(role, roleModel));
			concreteMapping.setMetaclass(getMetaclassByName(PRE_MAPPINGS.get(role), getTargetMetamodel()));
			roleMapping.getRoleToMetaelement().add(concreteMapping);
		}
		return roleMapping;
	}

	private Role getRoleByName(String name, RoleModel roleModel){
		for (Role role : roleModel.getRoles()) {
			if(role.getName().equals(name)){
				return role;
			}
		}
		return null;
	}
	
	private EClass getMetaclassByName(String name, EPackage metamodel){
		for (EClassifier metaclass : metamodel.getEClassifiers()) {
			if(metaclass instanceof EClass && metaclass.getName().equals(name)){
				return (EClass) metaclass;
			}
		}
		List<EPackage> subpackages = metamodel.getESubpackages();
		for (EPackage subpackage : subpackages) {
			EClass metaclass = getMetaclassByName(name, subpackage);
			if(metaclass != null){
				return metaclass;
			}
		}
		return null;
	}
	
	@Override
	protected String getGUERYFileName() {
		return GUERY_FILE;
	}

	@Override
	protected String getRoleModelFileName() {
		return ROLEMODEL_FILE_NAME;
	}

	@Override
	protected int getMaxResults() {
		return MAX_RESULTS;
	}

	@Override
	protected EPackage getTargetMetamodel() {
		return PL0Package.eINSTANCE;
	}

	@Override
	protected void initAdditionalLanguages() {
		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
	}
}
