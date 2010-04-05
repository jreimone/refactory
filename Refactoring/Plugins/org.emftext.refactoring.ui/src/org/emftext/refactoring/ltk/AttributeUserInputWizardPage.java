/**
 * 
 */
package org.emftext.refactoring.ltk;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;

/**
 * @author Jan Reimann
 *
 */
public class AttributeUserInputWizardPage extends UserInputWizardPage {

	private List<IAttributeValueProvider> valueProviders;
	private AdapterFactoryLabelProvider labelProvider;
	private Map<Text, IAttributeValueProvider> textMap;
	private Control root;
	
	/**
	 * @param name
	 */
	public AttributeUserInputWizardPage(List<IAttributeValueProvider> valueProviders) {
		super("Provide attributes for some elements");
		this.valueProviders = valueProviders;
		this.textMap = new LinkedHashMap<Text, IAttributeValueProvider>();
		initLabelProvider();
	}

	public void createControl(Composite parent) {
		Composite composite= new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setFont(parent.getFont());
		
		Label label = new Label(composite, NONE);
		GridData data = new GridData();
		data.horizontalSpan = 2;
		label.setLayoutData(data);
		
		label.setText("The following attributes must be provided");
		for (IAttributeValueProvider valueProvider : valueProviders) {
			valueProvider.provideValue();
			EAttribute attribute = valueProvider.getAttribute();
			EObject owner = valueProvider.getAttributeOwner();
//			String type = attribute.getEAttributeType().getInstanceTypeName();
			String temp = labelProvider.getText(attribute);
			String addition = (owner == null)? "" : " from " + labelProvider.getText(owner);
			String text = temp + addition;
			Label attribLabel = new Label(composite, SWT.NONE);
			attribLabel.setText(text);
			// TODO add validator 
			Text attribInput = new Text(composite, SWT.BORDER | SWT.SINGLE);
			data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
			data.horizontalSpan = 2;
			attribInput.setFont(composite.getFont());
			attribInput.setLayoutData(data);
			textMap.put(attribInput, valueProvider);
		}
//		setPageComplete(false);
		setControl(composite);
	}
	
	private void initLabelProvider(){
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	@Override
	protected boolean performFinish() {
		for (Text text : textMap.keySet()) {
			textMap.get(text).setValue(text.getText());
		}
		return super.performFinish();
	}

//	@Override
//	public Control getControl() {
//		if(root != null){
//			return root;
//		}
//		return super.getControl();
//	}
}
