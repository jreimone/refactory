package dk.itu.sdg.language.coral.checker.jobs

import java.lang.reflect.Method
import java.util.Map;
import java.util.Set;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job

import dk.itu.sdg.language.coral.DirectedRelation
import dk.itu.sdg.language.coral.Relation
import dk.itu.sdg.language.coral.UndirectedRelation
import dk.itu.sdg.language.coral.checker.GReader
import dk.itu.sdg.language.coral.checker.ResourceUtil
import dk.itu.sdg.language.coral.checker.handlers.Check
import dk.itu.sdg.language.coral.checker.jobs.JobUtils
import dk.itu.sdg.language.coral.checker.ui.MarkerGenerator;
import dk.itu.sdg.language.coral.resource.coral.ui.CoralViewContentProvider
import dk.itu.sdg.language.coral.resource.coral.ui.model.RelationModel


class CheckRelationJob extends Job {

	def final Relation relation
	def HashMap clusteredFiles = []
	def Check checkHandler
	
	CheckRelationJob(Relation relation, Map<String, Set<File>> clusteredFiles, Check check) {
		super("Checking Relation...")
		this.relation = relation
		this.clusteredFiles = clusteredFiles
		this.checkHandler = check
	}
	
	
	@Override
	public IStatus run(IProgressMonitor monitor) {
		
		
		//check only those files which are affected by this relation, i.e, get only the two languages
		def fstLanguageFiles
		def sndLanguageFiles
				
		if (relation instanceof DirectedRelation) {
			DirectedRelation directedRelation = (DirectedRelation) relation;
			
			fstLanguageFiles = clusteredFiles.get(directedRelation.getKeyLanguage().getLiteral())
			sndLanguageFiles = clusteredFiles.get(directedRelation.getRefLanguage().getLiteral())
			
//			println(directedRelation.getKeyLanguage().getLiteral() + " " + fstLanguageFiles.size())
//			println(directedRelation.getRefLanguage().getLiteral() + " " + sndLanguageFiles.size())
		} else if (relation instanceof UndirectedRelation) {
			UndirectedRelation undirectedRelation = (UndirectedRelation) relation;
			
			fstLanguageFiles = clusteredFiles.get(undirectedRelation.getLeftLanguage().getLiteral())
			sndLanguageFiles = clusteredFiles.get(undirectedRelation.getRightLanguage().getLiteral())

//			println(undirectedRelation.getLeftLanguage().getLiteral() + " " + fstLanguageFiles.size())
//			println(undirectedRelation.getRightLanguage().getLiteral() + " " + sndLanguageFiles.size())
		}

		monitor.beginTask("Checking...", 3 * fstLanguageFiles.size() * sndLanguageFiles.size())
		
		def JobUtils helper = JobUtils.getInstance();
		def classes = helper.findAllCheckerClasses(monitor)
		def Class collectorClass = helper.getCollectorClassForRelation(progressMonitor, relation)
		def Method collectorMethod = helper.getCollectorMethodForRelation(monitor, collectorClass, relation);
		
		def relations = [] as Set
		
		for (File fstFile in fstLanguageFiles) {
		
			for (File sndFile in sndLanguageFiles) {
			
				monitor.subTask("Reading Files...")
				def GReader reader = new GReader(ResourceUtil.getResource(fstFile), ResourceUtil.getResource(sndFile))
				monitor.worked(1)
				
				def thisRelations = helper.performChecks(monitor, reader, fstFile, sndFile, collectorMethod, collectorClass)
				
				if (!thisRelations.isEmpty()) {
					relations.add(thisRelations)
				
					MarkerGenerator.createMarkers(fstFile, sndFile, reader.getEmfResources().fst, reader.getEmfResources().snd, thisRelations)
					
					def RelationModel relationModel = RelationModel.getInstance()
					relationModel.addRelations(thisRelations)
//					relationModel.viewer.refresh()
				}
				
				monitor.worked(1);
			}
		} 
		
		monitor.done()
		return Status.OK_STATUS
	}
}