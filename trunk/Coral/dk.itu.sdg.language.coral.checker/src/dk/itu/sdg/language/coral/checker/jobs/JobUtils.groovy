package dk.itu.sdg.language.coral.checker.jobs

import java.lang.reflect.Method
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor

import dk.itu.sdg.language.coral.Coral;
import dk.itu.sdg.language.coral.Relation
import dk.itu.sdg.language.coral.checker.CoralProperties
import dk.itu.sdg.language.coral.checker.GReader;
import dk.itu.sdg.language.coral.checker.ResourceUtil

import groovy.lang.GroovyClassLoader
import groovy.lang.GroovyObject


class JobUtils {
	
	def private HashMap<Class, GroovyObject> classToInstance 
	def private static JobUtils instance
	def private classFiles
	def private classes
	def private parsedClasses
	
	public JobUtils() {
		this.classToInstance = classToInstance = new HashMap<Class, GroovyObject>()
		this.classFiles = null
		this.classes = null
		this.parsedClasses = null
	}
		
	public static JobUtils getInstance() {
		
		if (instance == null) {
			instance = new JobUtils()
		}
		return instance
	}
		
	public Collection getClassesFromProject() {
		
		if (this.classFiles == null) {
			this.classFiles = []
			
			def String pathToMainCoralPlugin = CoralProperties.getCoralProperties().getProperty("pathToMainCoralPlugin")
	
			def String collectorSuffix = CoralProperties.getCoralProperties().getProperty("collector_suffix")
			def String constraintSuffix = CoralProperties.getCoralProperties().getProperty("constraint_suffix")
			def String contstraintLanguage = CoralProperties.getCoralProperties().getProperty("contstraint_language")
	
			
			def IProject coralProject = ResourcesPlugin.getWorkspace().getRoot().getProject(pathToMainCoralPlugin)
			def ArrayList<File> files = ResourceUtil.getFilesFromResource(coralProject)
			def collectors = []
			def constraints = []
			
			collectors = files.findAll({file -> file.getName().endsWith(collectorSuffix + "." + contstraintLanguage)})
			constraints = files.findAll({file -> file.getName().contains(constraintSuffix + "." + contstraintLanguage)})
			
			this.classFiles.add(collectors)
			this.classFiles.add(constraints)
		}
		
		return this.classFiles
	}
	
	/**
	 * 
	 * @param monitor
	 * @return a two element collection of collections. The first element is  the collection of collector classes 
	 * and the second element is the collection of constraint classes 
	 */
	public Collection<Class> findAllCheckerClasses(IProgressMonitor monitor) {
	   
		if (this.parsedClasses == null) {
			this.parsedClasses = []
			
			monitor.subTask("Searching Constraint Classes...")
			def groovyClasses = getClassesFromProject()
			def collectorFiles = groovyClasses.get(0)
			def constraintFiles = groovyClasses.get(1)

			this.classes = []
	   
			def ClassLoader parentClassLoader = this.getClass().getClassLoader();
			def GroovyClassLoader classLoader = new GroovyClassLoader(parentClassLoader);
	   

			
			//in case that there is a manually implemented constraint class only take this on an do not parse the on in src-gen
			def generatedConstraints = constraintFiles.findAll({file -> file.getLocation().toString().contains("/src-gen/")})
			def manualConstraints = constraintFiles.findAll({file -> file.getLocation().toString().contains("/src/")})
			
			//do the filtering!!!
			def filteredGeneratedConstraints = []
			for (generatedConstraint in generatedConstraints) {
				
				def manualImplementation = manualConstraints.find({file -> file.getName().equals(generatedConstraint.getName())})
				if (manualImplementation == null) {
					filteredGeneratedConstraints.add(generatedConstraint)
				}
			}
			manualConstraints.addAll(filteredGeneratedConstraints)
			
			def parsedConstraints = manualConstraints.each({constraint ->
				def constraintFile = new File(((org.eclipse.core.resources.IFile)constraint).getLocation().toString())
				def Class constraintClass = classLoader.parseClass(constraintFile)
		   
				this.classes.add(constraintClass)
				this.parsedClasses.add(constraintClass)
				
				classToInstance.put(constraintClass, constraintClass.newInstance())
			})
			
	   
			def parsedCollectors = collectorFiles.each({collector ->
				def collectorFile = new File(((org.eclipse.core.resources.IFile)collector).getLocation().toString())
				def Class collectorClass = classLoader.parseClass(collectorFile)
		   
				this.classes.add(collectorClass)
				this.parsedClasses.add(collectorClass)
				classToInstance.put(collectorClass, collectorClass.newInstance())
			})
	   
//			this.parsedClasses.add(this.classes)
//			this.parsedClasses.add(collectorClasses)
		}
		
		return parsedClasses
	}
	
	public Class getCollectorClassForRelation(IProgressMonitor monitor, Relation relation) {
		
		def String collectorSuffix = CoralProperties.getCoralProperties().getProperty("collector_suffix")
		
		//get class name out of coral model name
		def coralModelName = relation.eResource().getURI().lastSegment()
		def coralName = coralModelName.substring(0, coralModelName.indexOf("."))
		def Class clazz = this.parsedClasses.find({clazz -> clazz.getSimpleName().equals(coralName + collectorSuffix)})
		
		return clazz
	}
	
	public Method getCollectorMethodForRelation(IProgressMonitor monitor, Class clazz, Relation relation) {
			
		//get index of relation to find the corresponding collector
		def relationIndex = ((Coral)relation.eContainer()).getRelations().indexOf(relation)
		def Method collectorMethod = clazz.getDeclaredMethods().find({method -> method.getName().equals("checkRelationCollector" + relationIndex) })
		
		return collectorMethod
	}
	
	public Set performChecks(IProgressMonitor monitor, GReader reader, IResource resource, IResource resource2, Method collector, Class clazz) {
		
		monitor.subTask("Reading Sources...")
		
		monitor.worked(1)

		def args = []
		args.add(reader.getEmfResources().fst)
		args.add(reader.getEmfResources().snd)
		
		def GroovyObject collectorObject = this.classToInstance.get(clazz)
		
		monitor.subTask("Checking constraints...")

		def relations = [] as Set
		
		def long startTime = System.currentTimeMillis()
		def long duration = 0
		
		//the actual check
		def newRelations = (Collection)collectorObject.invokeMethod(collector.getName(), args.toArray())

		duration = System.currentTimeMillis() - startTime
		
		println(newRelations.size() + "," + collector.getName() + "," + duration + "," + reader.fstRes.getLocation().toString() + "," + reader.sndRes.getLocation().toString())

		
			
		relations.addAll(newRelations)
		
		return relations;
	}
}
