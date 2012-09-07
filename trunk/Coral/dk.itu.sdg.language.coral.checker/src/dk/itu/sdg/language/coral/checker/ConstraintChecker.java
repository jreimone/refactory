package dk.itu.sdg.language.coral.checker;

import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class ConstraintChecker {
	
	Resource coralModel;
	Resource fstModel;
	Resource sndModel;
	Set<Pair<EObject,EObject>> elementsInRelation;
	
	public ConstraintChecker(IResource fstFile, IResource sndFile) {
		CoralReader coralReader = new CoralReader();
		coralModel = coralReader.getEmfResource();
		
		Reader reader = new Reader();
//		fstModel = reader.readAsModel(fstFile);
//		sndModel = reader.readAsModel(sndFile);
		
		check(fstModel,sndModel);
	}

	private void check(Resource fstModel, Resource sndModel) {
		
	}
	
	public String generateReportString() {
//		this.elementsInRelation
		return "";
	}
}
