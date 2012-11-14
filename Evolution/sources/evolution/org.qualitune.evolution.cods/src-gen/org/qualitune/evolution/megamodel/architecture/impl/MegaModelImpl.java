/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.architecture.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl#getInstanceModels <em>Instance Models</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl#getReferenceModels <em>Reference Models</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl#getTerminalModels <em>Terminal Models</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl#getMetaMetaModel <em>Meta Meta Model</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl#getMetaModels <em>Meta Models</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl#getTransformationModels <em>Transformation Models</em>}</li>
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
	 * The cached value of the '{@link #getInstanceModels() <em>Instance Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceModels()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceModel> instanceModels;

	/**
	 * The cached value of the '{@link #getReferenceModels() <em>Reference Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceModels()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceModel> referenceModels;

	/**
	 * The cached value of the '{@link #getTerminalModels() <em>Terminal Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminalModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TerminalModel> terminalModels;

	/**
	 * The cached value of the '{@link #getMetaMetaModel() <em>Meta Meta Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaMetaModel()
	 * @generated
	 * @ordered
	 */
	protected MetaMetaModel metaMetaModel;

	/**
	 * The cached value of the '{@link #getMetaModels() <em>Meta Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModels()
	 * @generated
	 * @ordered
	 */
	protected EList<MetaModel> metaModels;

	/**
	 * The cached value of the '{@link #getTransformationModels() <em>Transformation Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TransformationModel> transformationModels;

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
	 * @generated
	 */
	public EList<InstanceModel> getInstanceModels() {
		if (instanceModels == null) {
			instanceModels = new EObjectResolvingEList<InstanceModel>(InstanceModel.class, this, ArchitecturePackage.MEGA_MODEL__INSTANCE_MODELS);
		}
		return instanceModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceModel> getReferenceModels() {
		if (referenceModels == null) {
			referenceModels = new EObjectResolvingEList<ReferenceModel>(ReferenceModel.class, this, ArchitecturePackage.MEGA_MODEL__REFERENCE_MODELS);
		}
		return referenceModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TerminalModel> getTerminalModels() {
		if (terminalModels == null) {
			terminalModels = new EObjectResolvingEList<TerminalModel>(TerminalModel.class, this, ArchitecturePackage.MEGA_MODEL__TERMINAL_MODELS);
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
	 * @generated
	 */
	public MetaMetaModel getMetaMetaModel() {
		if (metaMetaModel != null && metaMetaModel.eIsProxy()) {
			InternalEObject oldMetaMetaModel = (InternalEObject)metaMetaModel;
			metaMetaModel = (MetaMetaModel)eResolveProxy(oldMetaMetaModel);
			if (metaMetaModel != oldMetaMetaModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.MEGA_MODEL__META_META_MODEL, oldMetaMetaModel, metaMetaModel));
			}
		}
		return metaMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaMetaModel basicGetMetaMetaModel() {
		return metaMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaMetaModel(MetaMetaModel newMetaMetaModel) {
		MetaMetaModel oldMetaMetaModel = metaMetaModel;
		metaMetaModel = newMetaMetaModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.MEGA_MODEL__META_META_MODEL, oldMetaMetaModel, metaMetaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetaModel> getMetaModels() {
		if (metaModels == null) {
			metaModels = new EObjectResolvingEList<MetaModel>(MetaModel.class, this, ArchitecturePackage.MEGA_MODEL__META_MODELS);
		}
		return metaModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransformationModel> getTransformationModels() {
		if (transformationModels == null) {
			transformationModels = new EObjectResolvingEList<TransformationModel>(TransformationModel.class, this, ArchitecturePackage.MEGA_MODEL__TRANSFORMATION_MODELS);
		}
		return transformationModels;
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
			case ArchitecturePackage.MEGA_MODEL__INSTANCE_MODELS:
				return getInstanceModels();
			case ArchitecturePackage.MEGA_MODEL__REFERENCE_MODELS:
				return getReferenceModels();
			case ArchitecturePackage.MEGA_MODEL__TERMINAL_MODELS:
				return getTerminalModels();
			case ArchitecturePackage.MEGA_MODEL__META_META_MODEL:
				if (resolve) return getMetaMetaModel();
				return basicGetMetaMetaModel();
			case ArchitecturePackage.MEGA_MODEL__META_MODELS:
				return getMetaModels();
			case ArchitecturePackage.MEGA_MODEL__TRANSFORMATION_MODELS:
				return getTransformationModels();
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
			case ArchitecturePackage.MEGA_MODEL__INSTANCE_MODELS:
				getInstanceModels().clear();
				getInstanceModels().addAll((Collection<? extends InstanceModel>)newValue);
				return;
			case ArchitecturePackage.MEGA_MODEL__REFERENCE_MODELS:
				getReferenceModels().clear();
				getReferenceModels().addAll((Collection<? extends ReferenceModel>)newValue);
				return;
			case ArchitecturePackage.MEGA_MODEL__TERMINAL_MODELS:
				getTerminalModels().clear();
				getTerminalModels().addAll((Collection<? extends TerminalModel>)newValue);
				return;
			case ArchitecturePackage.MEGA_MODEL__META_META_MODEL:
				setMetaMetaModel((MetaMetaModel)newValue);
				return;
			case ArchitecturePackage.MEGA_MODEL__META_MODELS:
				getMetaModels().clear();
				getMetaModels().addAll((Collection<? extends MetaModel>)newValue);
				return;
			case ArchitecturePackage.MEGA_MODEL__TRANSFORMATION_MODELS:
				getTransformationModels().clear();
				getTransformationModels().addAll((Collection<? extends TransformationModel>)newValue);
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
			case ArchitecturePackage.MEGA_MODEL__INSTANCE_MODELS:
				getInstanceModels().clear();
				return;
			case ArchitecturePackage.MEGA_MODEL__REFERENCE_MODELS:
				getReferenceModels().clear();
				return;
			case ArchitecturePackage.MEGA_MODEL__TERMINAL_MODELS:
				getTerminalModels().clear();
				return;
			case ArchitecturePackage.MEGA_MODEL__META_META_MODEL:
				setMetaMetaModel((MetaMetaModel)null);
				return;
			case ArchitecturePackage.MEGA_MODEL__META_MODELS:
				getMetaModels().clear();
				return;
			case ArchitecturePackage.MEGA_MODEL__TRANSFORMATION_MODELS:
				getTransformationModels().clear();
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
			case ArchitecturePackage.MEGA_MODEL__INSTANCE_MODELS:
				return instanceModels != null && !instanceModels.isEmpty();
			case ArchitecturePackage.MEGA_MODEL__REFERENCE_MODELS:
				return referenceModels != null && !referenceModels.isEmpty();
			case ArchitecturePackage.MEGA_MODEL__TERMINAL_MODELS:
				return terminalModels != null && !terminalModels.isEmpty();
			case ArchitecturePackage.MEGA_MODEL__META_META_MODEL:
				return metaMetaModel != null;
			case ArchitecturePackage.MEGA_MODEL__META_MODELS:
				return metaModels != null && !metaModels.isEmpty();
			case ArchitecturePackage.MEGA_MODEL__TRANSFORMATION_MODELS:
				return transformationModels != null && !transformationModels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * This is used to get notified of modified dependent features for updating the derived features.
	 */
	@Override
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		if(ArchitecturePackage.Literals.MEGA_MODEL__MODELS.equals(notification.getFeature())){
			int eventType = notification.getEventType();
			switch (eventType) {
			case Notification.ADD:
				EObject newValue = (EObject) notification.getNewValue();
				if(newValue instanceof InstanceModel){
					if(!getInstanceModels().contains(newValue)){
						getInstanceModels().add((InstanceModel) newValue);
					}
				} else if(newValue instanceof TransformationModel){
					if(!getTransformationModels().contains(newValue)){
						getTransformationModels().add((TransformationModel) newValue);
					}
				} else if(newValue instanceof MetaModel){
					if(!getMetaModels().contains(newValue)){
						getMetaModels().add((MetaModel) newValue);
					}
				} else if(newValue instanceof MetaMetaModel){
					if(!newValue.equals(getMetaMetaModel())){
						setMetaMetaModel((MetaMetaModel) newValue);
					}
				}
				if(newValue instanceof TerminalModel){
					if(!getTerminalModels().contains(newValue)){
						getTerminalModels().add((TerminalModel) newValue);
					}
				}
				if(newValue instanceof ReferenceModel){
					if(!getReferenceModels().contains(newValue)){
						getReferenceModels().add((ReferenceModel) newValue);
					}
				}
				break;
			case Notification.REMOVE:
				EObject oldValue = (EObject) notification.getOldValue();
				if(oldValue instanceof InstanceModel){
					if(getInstanceModels().contains(oldValue)){
						getInstanceModels().remove((InstanceModel) oldValue);
					}
				} else if(oldValue instanceof TransformationModel){
					if(getTransformationModels().contains(oldValue)){
						getTransformationModels().remove((TransformationModel) oldValue);
					}
				} else if(oldValue instanceof MetaModel){
					if(getMetaModels().contains(oldValue)){
						getMetaModels().remove((MetaModel) oldValue);
					}
				} else if(oldValue instanceof MetaMetaModel){
					if(getMetaMetaModel().equals(oldValue)){
						setMetaMetaModel(null);
					}
				}
				if(oldValue instanceof TerminalModel){
					if(getTerminalModels().contains(oldValue)){
						getTerminalModels().remove((TerminalModel) oldValue);
					}
				}
				if(oldValue instanceof ReferenceModel){
					if(getReferenceModels().contains(oldValue)){
						getReferenceModels().remove((ReferenceModel) oldValue);
					}
				}
				break;
			default:
				break;
			}
		}
	}

	/**
	 * This is used to get notified of modified dependent features for updating the derived features.
	 */
	@Override
	public boolean eNotificationRequired() {
//		return super.eNotificationRequired();
		return true;
	}

} //MegaModelImpl
