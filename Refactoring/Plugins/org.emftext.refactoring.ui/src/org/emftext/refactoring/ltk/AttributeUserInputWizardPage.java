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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.internal.ui.refactoring.IPreviewWizardPage;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
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
		composite.setLayout(new GridLayout(4, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setFont(parent.getFont());

		Label label = new Label(composite, NONE);
		GridData data = new GridData();
		data.horizontalSpan = 4;
		label.setLayoutData(data);
		label.setText("The following attributes must be provided");
		for (final IAttributeValueProvider valueProvider : valueProviders) {
			valueProvider.provideValue();
			final EAttribute attribute = valueProvider.getAttribute();
			String text = labelProvider.getText(attribute) + " for ";
			Label attribIconLabel = new Label(composite, SWT.NONE);
			attribIconLabel.setImage(labelProvider.getImage(attribute));
			Label attribLabel = new Label(composite, SWT.NONE);
			attribLabel.setText(text);
			
			EObject owner = valueProvider.getAttributeOwner();
			if(owner == null){
				owner = valueProvider.getFakeAttributeOwner().eClass();
			}
			Label ownerIconLabel = new Label(composite, SWT.NONE);
			ownerIconLabel.setImage(labelProvider.getImage(owner));
			Label ownerLabel = new Label(composite, SWT.NONE);
			ownerLabel.setText(labelProvider.getText(owner));
			
			final Text attribInput = new Text(composite, SWT.BORDER | SWT.SINGLE);
			attribInput.addModifyListener(new ModifyListener() {
				
				public void modifyText(ModifyEvent e) {
					setPageComplete();
				}
			});
//			attribInput.addListener(SWT.Verify, new Listener() {
//
//				public void handleEvent(Event event) {
//					setPageComplete();
////					String input = attribInput.getText() + event.text;
////					boolean valid = valueProvider.isValueValid(input);
////					if(valid && !"".equals(input)){
////						event.doit = true;
////						setPageComplete();
////					} else {
////						event.doit = false;
////					}
//				}
//			});
			data = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
			data.horizontalSpan = 4;
			attribInput.setFont(composite.getFont());
			attribInput.setLayoutData(data);
			textMap.put(attribInput, valueProvider);
		}
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
		propagateInputs();
		return super.performFinish();
	}

	private void propagateInputs() {
		for (Text text : textMap.keySet()) {
			textMap.get(text).setValue(text.getText());
			textMap.get(text).propagateValueToFakeObject();
		}
	}

	@Override
	public IWizardPage getNextPage() {
		propagateInputs();
		return super.getNextPage();
	}

	@Override
	public boolean isPageComplete() {
		boolean allValuesValid = true;
		for (Text text : textMap.keySet()) {
			String input = text.getText();
			IAttributeValueProvider valueProvider = textMap.get(text);
			allValuesValid = allValuesValid && valueProvider.isValueValid(input) && !"".equals(input);
		}
		return allValuesValid;
	}

	private void setPageComplete(){
		setPageComplete(isPageComplete());
	}
}
