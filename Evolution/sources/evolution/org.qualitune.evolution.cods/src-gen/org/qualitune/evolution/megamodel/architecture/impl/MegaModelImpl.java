/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.architecture.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.qualitune.evolution.megamodel.architecture.ArchitecturePackage;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;
import org.qualitune.evolution.megamodel.architecture.MegaModel;
import org.qualitune.evolution.megamodel.architecture.MetaMetaModel;
import org.qualitune.evolution.megamodel.architecture.MetaModel;
import org.qualitune.evolution.megamodel.architecture.Model;
import org.qualitune.evolution.megamodel.architecture.ReferenceModel;
import org.qualitune.evolution.megamodel.architecture.TerminalModel;
import org.qualitune.evolution.megamodel.architecture.TransformationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mega Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl#getModels <em>Models</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MegaModelImpl extends TerminalModelImpl implements MegaModel {
	/**
	 * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModels()
	 * @generated
	 * @ordered
	 */
	protected EList<Model> models;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MegaModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.MEGA_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Model> getModels() {
		if (models == null) {
			models = new EObjectContainmentEList<Model>(Model.class, this, ArchitecturePackage.MEGA_MODEL__MODELS);
		}
		return models;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ReferenceModel> getReferenceModels() {
		EList<ReferenceModel> referenceModels = new BasicEList<ReferenceModel>();
		List<Model> models = getModels();
		for (Model model : models) {
			if(model instanceof ReferenceModel){
				referenceModels.add((ReferenceModel) model);
			}
		}
		return referenceModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TerminalModel> getTerminalModels() {
		EList<TerminalModel> terminalModels = new BasicEList<TerminalModel>();
		List<Model> models = getModels();
		for (Model model : models) {
			if(model instanceof TerminalModel){
				terminalModels.add((TerminalModel) model);
			}
		}
		return terminalModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ReferenceModel getReferenceModelByEPackage(EPackage epackage) {
		List<ReferenceModel> referenceModels = getReferenceModels();
		for (ReferenceModel referenceModel : referenceModels) {
			if(referenceModel.getPackage().equals(epackage)){
				return referenceModel;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TerminalModel getTerminalModelByEObject(EObject model) {
		List<TerminalModel> terminalModels = getTerminalModels();
		for (TerminalModel terminalModel : terminalModels) {
			if(terminalModel instanceof TransformationModel && ((TransformationModel) terminalModel).getTransformation().equals(model)){
				return terminalModel;
			}
			if(terminalModel instanceof InstanceModel && ((InstanceModel) terminalModel).getModel().equals(model)){
				return terminalModel;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MetaMetaModel getMetaMetaModel() {
		List<ReferenceModel> referenceModels = getReferenceModels();
		for (ReferenceModel referenceModel : referenceModels) {
			if(referenceModel instanceof MetaMetaModel){
				return (MetaMetaModel) referenceModel; 
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<MetaModel> getMetaModels() {
		EList<MetaModel> metaModels = new BasicEList<MetaModel>();
		EList<ReferenceModel> referenceModels = new BasicEList<ReferenceModel>(getReferenceModels());
		referenceModels.remove(getMetaMetaModel());
		for (ReferenceModel referenceModel : referenceModels) {
			metaModels.add((MetaModel) referenceModel);
		}
		return metaModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TransformationModel> getTransformationModels() {
		EList<TransformationModel> transformationModels = new BasicEList<TransformationModel>();
		for (TerminalModel terminalModel : getTerminalModels()) {
			if(terminalModel instanceof TransformationModel){
				transformationModels.add((TransformationModel) terminalModel);
			}
		}
		return transformationModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InstanceModel> getInstanceModels() {
		EList<InstanceModel> instanceModels = new BasicEList<InstanceModel>();
		EList<TerminalModel> terminalModels = new BasicEList<TerminalModel>(getTerminalModels());
		terminalModels.removeAll(getTransformationModels());
		for (TerminalModel terminalModel : terminalModels) {
			instanceModels.add((InstanceModel) terminalModel);
		}
		return instanceModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.MEGA_MODEL__MODELS:
				return ((InternalEList<?>)getModels()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturePackage.MEGA_MODEL__MODELS:
				return getModels();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArchitecturePackage.MEGA_MODEL__MODELS:
				getModels().clear();
				getModels().addAll((Collection<? extends Model>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ArchitecturePackage.MEGA_MODEL__MODELS:
				getModels().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ArchitecturePackage.MEGA_MODEL__MODELS:
				return models != null && !models.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MegaModelImpl
