package org.emftext.refactoring.smell.registry;

import org.eclipse.ui.views.markers.MarkerField;
import org.eclipse.ui.views.markers.MarkerItem;

public class QualityField extends MarkerField {

	@Override
	public String getValue(MarkerItem item) {
		String quality = item.getAttributeValue(IQualitySmellMarker.QUALITY, null);
		return quality;
	}

}
