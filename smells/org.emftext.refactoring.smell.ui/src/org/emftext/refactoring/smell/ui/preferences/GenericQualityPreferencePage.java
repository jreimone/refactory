package org.emftext.refactoring.smell.ui.preferences;

import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.refactoring.smell.Quality;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellFactory;
import org.emftext.refactoring.smell.SmellPackage.Literals;
import org.emftext.refactoring.smell.registry.ModelRegistration;

public class GenericQualityPreferencePage extends AbstractPreferencePage {

	@Inject
	private QualitySmellModel smellModel;
	
	@Override
	public EObject getModel() {
		if(smellModel == null){
			smellModel = ModelRegistration.getDefault().getSmellmodel();
		}
		return smellModel;
	}

	@Override
	public EReference getListReference() {
		return Literals.QUALITY_SMELL_MODEL__QUALITIES;
	}

	@Override
	public EAttribute getExposedAttribute() {
		return Literals.QUALITY__NAME;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EList<EObject> getList() {
		return (EList<EObject>) getModel().eGet(getListReference());
	}

	@Override
	public EObject createNewListElement() {
		Quality quality = SmellFactory.eINSTANCE.createQuality();
		quality.setName("Quality");
		return quality;
	}

	@Override
	public void setNewValue(Object element, Object value) {
		String oldName = ((Quality) element).getName();
		if(oldName != null && !oldName.equals(value)){
			((Quality) element).setName((String) value);
		}
	}

	@Override
	public Object getCurrentValue(Object element) {
		return ((Quality) element).getName();
	}

	@Override
	public String getDescription() {
		return "Define generic qualities here.";
	}

	@Override
	public String getTitle() {
		return "Generic Qualities";
	}

	@Override
	public String getColumnTitle() {
		return "Generic Quality";
	}

	@Override
	public String getAddButtonText() {
		return "Add Quality";
	}

	@Override
	public String getRemoveButtonText() {
		return "Remove Quality";
	}

}
