package org.emftext.refactoring.smell.ui.preferences;

import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.IWorkbench;
import org.emftext.refactoring.smell.QualitySmell;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellFactory;
import org.emftext.refactoring.smell.SmellPackage.Literals;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class GenericSmellPreferencePage extends AbstractPreferencePage {
	
	@Inject
	private QualitySmellModel smellModel;
	
	@Override
	public EObject getModel() {
		if(smellModel == null){
			BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
			ServiceTracker<QualitySmellModel,QualitySmellModel> tracker = new ServiceTracker<QualitySmellModel,QualitySmellModel>(bundleContext, QualitySmellModel.class, null);
			tracker.open();
			smellModel = tracker.getService();
		}
		return smellModel;
	}

	@Override
	public void init(IWorkbench workbench) {
		super.init(workbench);
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceTracker<QualitySmellModel,QualitySmellModel> tracker = new ServiceTracker<QualitySmellModel,QualitySmellModel>(bundleContext, QualitySmellModel.class, null);
		tracker.open();
		smellModel = tracker.getService();
	}
	
	@Override
	public EReference getListReference() {
		return Literals.QUALITY_SMELL_MODEL__SMELLS;
	}

	@Override
	public EAttribute getExposedAttribute() {
		return Literals.QUALITY_SMELL__NAME;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EList<EObject> getList() {
		return (EList<EObject>) getModel().eGet(getListReference());
	}

	@Override
	public EObject createNewListElement() {
		QualitySmell qualitySmell = SmellFactory.eINSTANCE.createQualitySmell();
		qualitySmell.setName("Quality Smell");
		return qualitySmell;
	}

	@Override
	public void setNewValue(Object element, Object value) {
		String oldName = ((QualitySmell) element).getName();
		if(oldName != null && !oldName.equals(value)){
			((QualitySmell) element).setName((String) value);
		}
	}

	@Override
	public Object getCurrentValue(Object element) {
		return ((QualitySmell) element).getName();
	}

	@Override
	public String getDescription() {
		return "Define generic quality smells here.";
	}

	@Override
	public String getTitle() {
		return "Generic Quality Smells";
	}

	@Override
	public String getColumnTitle() {
		return "Generic Quality Smell";
	}

	@Override
	public String getAddButtonText() {
		return "Add Quality Smell";
	}

	@Override
	public String getRemoveButtonText() {
		return "Remove Quality Smell";
	}
}
