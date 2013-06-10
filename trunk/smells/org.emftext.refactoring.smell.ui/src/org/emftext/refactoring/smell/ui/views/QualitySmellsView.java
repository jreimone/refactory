package org.emftext.refactoring.smell.ui.views;

import org.eclipse.ui.views.markers.MarkerSupportView;
import org.emftext.refactoring.smell.registry.IQualitySmellMarker;

public class QualitySmellsView extends MarkerSupportView {

	public QualitySmellsView() {
		super(IQualitySmellMarker.CONTENT_GENERATOR_ID);
	}

}
