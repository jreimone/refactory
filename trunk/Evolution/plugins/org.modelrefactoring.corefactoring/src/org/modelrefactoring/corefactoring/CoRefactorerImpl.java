package org.modelrefactoring.corefactoring;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.util.RoleUtil;
import org.modelrefactoring.evolution.coed.Action;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.Event;
import org.modelrefactoring.evolution.coed.RoleMappingAction;
import org.modelrefactoring.evolution.coed.RoleMappingEvent;
import org.modelrefactoring.evolution.megamodel.architecture.ReferenceModel;
import org.modelrefactoring.evolution.megamodel.cods.CODS;
import org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification;

public class CoRefactorerImpl implements CoRefactorer {

	public static final String MEGAMODEL_STRING	= "http://modelrefactoring.org/megamodel.cods";

	private IRefactorer initialRefactorer;
	private EObject dependentModel;
	private List<EObject> dependentElements;

	private EPackage metamodelOfDependentModel;

	private CoEvolutionDefinition coed;
	private RoleMappingAction rolemappingAction;
	private RoleMappingEvent rolemappingEvent;

	private IRefactorer dependentRefactorer;

	public CoRefactorerImpl(IRefactorer refactorer, EObject dependentModel, List<EObject> dependentElements) {
		this.initialRefactorer = refactorer;
		this.dependentModel = dependentModel;
		this.dependentElements = dependentElements;
		EObject rootContainer = EcoreUtil.getRootContainer(dependentModel);
		metamodelOfDependentModel = (EPackage) EcoreUtil.getRootContainer(rootContainer.eClass().getEPackage());
	}

	@Override
	public IRefactorer getInitialRefactorer() {
		return initialRefactorer;
	}

	@Override
	public EObject getDependentModel() {
		return dependentModel;
	}

	@Override
	public List<EObject> getDependentElements() {
		return dependentElements;
	}

	@Override
	public EObject coRefactor() {
		IRefactorer dependentRefactorer = getDependentRefactorer();
		if(dependentRefactorer != null){
			return dependentRefactorer.refactor();
		}
		return null;
	}

	@Override
	public RoleMapping getDependentRoleMapping() {
		if(rolemappingAction == null){
			URI uri = URI.createURI(MEGAMODEL_STRING);
			ResourceSet rs = new ResourceSetImpl();
			Resource codsResource = rs.getResource(uri, true);
			EObject model = codsResource.getContents().get(0);
			if(model instanceof CODS){
				CODS cods = (CODS) model;
				List<DomainSpecificEvolutionSpecification> dses = cods.getDSES();
				for (DomainSpecificEvolutionSpecification specification : dses) {
					ReferenceModel referenceModel = specification.getReferenceModel();
					EPackage metamodel = referenceModel.getPackage();
					if(metamodelOfDependentModel.equals(metamodel)){
						CoEvolutionDefinition coed = specification.getCoEvolutionDefinition();
						Action action = coed.getAction();
						Event event = coed.getEvent();
						if(event instanceof RoleMappingEvent && action instanceof RoleMappingAction){
							RoleMappingEvent rolemappingEvent = (RoleMappingEvent) event;
							RoleMapping initialRolemapping = rolemappingEvent.getConcreteRefactoring();
							if(initialRolemapping.equals(initialRefactorer.getRoleMapping())){
								rolemappingAction = (RoleMappingAction) action;
								this.rolemappingEvent = rolemappingEvent;
								this.coed = coed;
								return rolemappingAction.getConcreteRefactoring();
							}
						}
					}
				}
			}
		} else {
			return rolemappingAction.getConcreteRefactoring();
		}
		return null;
	}

	@Override
	public RoleMapping getInitialRoleMapping() {
		return initialRefactorer.getRoleMapping();
	}

	@Override
	public IRefactorer getDependentRefactorer() {
		if(dependentRefactorer == null){
			RoleMapping dependentRoleMapping = getDependentRoleMapping();
			if(dependentRoleMapping != null){
				dependentRefactorer = RefactorerFactory.eINSTANCE.getRefactorer(dependentModel.eResource(), dependentRoleMapping);
				List<EObject> elements = getDependentElements();
				elements = RoleUtil.filterObjectsByInputRoles(elements, dependentRoleMapping);
				dependentRefactorer.setInput(elements);
				String bindingExpression = rolemappingAction.getBinding();
				IValueProviderFactory factory = new CoRefactorerValueProviderFactory(initialRefactorer, dependentRefactorer, bindingExpression);
				dependentRefactorer.setValueProviderFactory(factory);
			}
		}
		return dependentRefactorer;
	}

}
