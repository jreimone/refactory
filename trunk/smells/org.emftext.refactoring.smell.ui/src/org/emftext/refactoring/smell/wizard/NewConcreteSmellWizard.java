package org.emftext.refactoring.smell.wizard;

import org.eclipse.jface.wizard.Wizard;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class NewConcreteSmellWizard extends Wizard {

	private CalculationsPage calculationPage;
	private QualitySmellModel smellModel;
	private MetamodelPage metamodelPage;
	private RoleMappingPage rolemappingPage;

	public NewConcreteSmellWizard() {
		setWindowTitle("New Concrete Smell Wizard");
		init();
	}

	private void init() {
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceTracker<QualitySmellModel,QualitySmellModel> tracker = new ServiceTracker<>(bundleContext, QualitySmellModel.class, null);
		tracker.open();
		smellModel = tracker.getService();
	}

	@Override
	public void addPages() {
		metamodelPage = new MetamodelPage();
		addPage(metamodelPage);
		rolemappingPage = new RoleMappingPage();
		addPage(rolemappingPage);
		calculationPage = new CalculationsPage(SmellFactory.eINSTANCE.createConcreteQualitySmell());
		addPage(calculationPage);
	}

	@Override
	public boolean performFinish() {
		ConcreteQualitySmell newConcreteSmell = calculationPage.getConcreteSmell();
		if(newConcreteSmell != null){
			smellModel.getConcreteSmells().add(newConcreteSmell);
			return true;
		}
		return false;
	}

	public CalculationsPage getCalculationPage() {
		return calculationPage;
	}

	public MetamodelPage getMetamodelPage() {
		return metamodelPage;
	}

	public RoleMappingPage getRolemappingPage() {
		return rolemappingPage;
	}
}
