package org.emftext.refactoring.smell.ui.views;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.emftext.refactoring.smell.Quality;
import org.emftext.refactoring.smell.ui.util.ResourceManager;

public class ObservableMapLabelProviderWithCheckboxes extends ObservableMapLabelProvider {

	public ObservableMapLabelProviderWithCheckboxes(IObservableMap[] observeMaps) {
		super(observeMaps);
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if(columnIndex == 0){
			if(element instanceof Quality){
				Quality quality = (Quality) element;
				if(quality.isActive()){
					return ResourceManager.getImageFromThisPlugin("icons/checked.gif");
				}
				return ResourceManager.getImageFromThisPlugin("icons/unchecked.gif");
			}
			return null;
		}
		return super.getColumnImage(element, columnIndex);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if(columnIndex == 0){
			return "";
		}
		return super.getColumnText(element, columnIndex);
	}
}
