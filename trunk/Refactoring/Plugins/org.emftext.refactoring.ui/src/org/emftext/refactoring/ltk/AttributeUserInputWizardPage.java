/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
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
//	private Control root;

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
			
			EObject owner = valueProvider.getAttributeOwner();
			boolean fake = false;
			if(owner == null){
				owner = valueProvider.getFakeAttributeOwner();
				fake = true;
			}
			if(fake){
				text += "new ";
			}
			attribLabel.setText(text);
			Label ownerIconLabel = new Label(composite, SWT.NONE);
			ownerIconLabel.setImage(labelProvider.getImage(owner));
			Label ownerLabel = new Label(composite, SWT.NONE);
			if(!fake){
				ownerLabel.setText(labelProvider.getText(owner));
			} else {
				ownerLabel.setText(labelProvider.getText(owner.eClass()));
			}
			
			final Text attribInput = new Text(composite, SWT.BORDER | SWT.SINGLE);
			attribInput.addModifyListener(new ModifyListener() {
				
				public void modifyText(ModifyEvent e) {
					setPageComplete();
				}
			});
			if(owner != null){
				Object value = owner.eGet(attribute);
				attribInput.setFocus();
				attribInput.setText(value.toString());
				int length = value.toString().length();
				attribInput.setSelection(0, length);
			}
			
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
