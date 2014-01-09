package org.qualitune.evolution.cods.ui;

import java.util.Comparator;

import org.eclipse.jface.viewers.Viewer;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;
import org.qualitune.evolution.megamodel.architecture.TransformationModel;

/**
 * @author jreimann
 *
 */
public class MegamodelSorter extends AbstractInvertableTableSorter {

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		@SuppressWarnings("unchecked")
		Comparator<String> comparator = super.getComparator();
		if(e1 instanceof InstanceModel && e2 instanceof InstanceModel){
			return comparator.compare(((InstanceModel) e1).getModel().eResource().getURI().toString()
					, ((InstanceModel) e2).getModel().eResource().getURI().toString());
		}
		if(e1 instanceof TransformationModel && e2 instanceof TransformationModel){
			return comparator.compare(((TransformationModel) e1).getTransformation().eResource().getURI().toString()
					, ((TransformationModel) e2).getTransformation().eResource().getURI().toString());
		}
		return 0;
	}

}
