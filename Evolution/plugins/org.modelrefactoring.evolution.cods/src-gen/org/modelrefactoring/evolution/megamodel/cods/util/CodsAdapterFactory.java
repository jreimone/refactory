/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelrefactoring.evolution.megamodel.cods.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.modelrefactoring.evolution.megamodel.architecture.MegaModel;
import org.modelrefactoring.evolution.megamodel.architecture.Model;
import org.modelrefactoring.evolution.megamodel.architecture.TerminalModel;
import org.modelrefactoring.evolution.megamodel.cods.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.modelrefactoring.evolution.megamodel.cods.CodsPackage
 * @generated
 */
public class CodsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CodsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CodsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodsSwitch<Adapter> modelSwitch =
		new CodsSwitch<Adapter>() {
			@Override
			public Adapter caseCODS(CODS object) {
				return createCODSAdapter();
			}
			@Override
			public Adapter caseDomainSpecificEvolutionSpecification(DomainSpecificEvolutionSpecification object) {
				return createDomainSpecificEvolutionSpecificationAdapter();
			}
			@Override
			public Adapter caseEvolutionDefinition(EvolutionDefinition object) {
				return createEvolutionDefinitionAdapter();
			}
			@Override
			public Adapter caseCoEvolutionDefinition(CoEvolutionDefinition object) {
				return createCoEvolutionDefinitionAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseTerminalModel(TerminalModel object) {
				return createTerminalModelAdapter();
			}
			@Override
			public Adapter caseMegaModel(MegaModel object) {
				return createMegaModelAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.megamodel.cods.CODS <em>CODS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelrefactoring.evolution.megamodel.cods.CODS
	 * @generated
	 */
	public Adapter createCODSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification <em>Domain Specific Evolution Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification
	 * @generated
	 */
	public Adapter createDomainSpecificEvolutionSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.megamodel.cods.EvolutionDefinition <em>Evolution Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelrefactoring.evolution.megamodel.cods.EvolutionDefinition
	 * @generated
	 */
	public Adapter createEvolutionDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.megamodel.cods.CoEvolutionDefinition <em>Co Evolution Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelrefactoring.evolution.megamodel.cods.CoEvolutionDefinition
	 * @generated
	 */
	public Adapter createCoEvolutionDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.megamodel.architecture.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelrefactoring.evolution.megamodel.architecture.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.megamodel.architecture.TerminalModel <em>Terminal Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelrefactoring.evolution.megamodel.architecture.TerminalModel
	 * @generated
	 */
	public Adapter createTerminalModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.megamodel.architecture.MegaModel <em>Mega Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelrefactoring.evolution.megamodel.architecture.MegaModel
	 * @generated
	 */
	public Adapter createMegaModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CodsAdapterFactory
