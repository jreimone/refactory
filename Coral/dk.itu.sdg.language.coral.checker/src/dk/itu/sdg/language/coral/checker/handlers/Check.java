package dk.itu.sdg.language.coral.checker.handlers;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.progress.UIJob;

import dk.itu.sdg.language.coral.Relation;
import dk.itu.sdg.language.coral.checker.CoralProperties;
import dk.itu.sdg.language.coral.checker.GReader;
import dk.itu.sdg.language.coral.checker.ResourceUtil;
import dk.itu.sdg.language.coral.checker.VisualCoralRelation;
import dk.itu.sdg.language.coral.checker.jobs.CheckMarkersJob;
import dk.itu.sdg.language.coral.checker.jobs.CheckOthersJob;
import dk.itu.sdg.language.coral.checker.jobs.CheckRelationJob;
import dk.itu.sdg.language.coral.checker.ui.MarkerGenerator;
import dk.itu.sdg.language.coral.checker.ui.MarkerStaticChecker;
import dk.itu.sdg.language.coral.resource.coral.ui.model.RelationModel;
 

@SuppressWarnings("restriction")
public class Check extends AbstractHandler {
	
	final Map<String,Set<org.eclipse.core.internal.resources.File>> clusteredFiles = getFiles();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		if (selection.size() == 2) {
			Object[]  selections = selection.toArray();
			final Object fstSelection = selections[0];
			final Object sndSelection = selections[1];

			checkTwoFiles(ResourceUtil.getResource(fstSelection), ResourceUtil.getResource(sndSelection));
			
		} else if (selection.size() == 1) {
			Object[]  selections = selection.toArray();
			Object fstSelection = selections[0];

			if (fstSelection instanceof Project) {
				Project project = (Project) fstSelection;
				checkProject(project);
			} else if (fstSelection instanceof org.eclipse.core.internal.resources.File) {
				org.eclipse.core.internal.resources.File file = (org.eclipse.core.internal.resources.File) fstSelection;
				
				checkOthersInProject(file);
			} else if (fstSelection instanceof CompilationUnit) {
				CompilationUnit cUnit = (CompilationUnit) fstSelection;			
			
				checkOthersInProject((IResource)fstSelection);
			}	
			
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Please select two files.");
		}
		
		return null;
	}
	
	
	
	private void checkOthersInProject(final IResource resource) {
				

		
		Job removeResourceChangeJob = new Job("Removing Resource Change Listener") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ResourcesPlugin.getWorkspace().removeResourceChangeListener(MarkerStaticChecker.getInstance());		
				return Status.OK_STATUS;
			}
		};
		
		
		CheckOthersJob job = new CheckOthersJob(resource, this);
		
		Job addResourceChangeJob = new Job("Adding Resource Change Listener") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ResourcesPlugin.getWorkspace().addResourceChangeListener(MarkerStaticChecker.getInstance());
				//				ResourcesPlugin.getWorkspace().addResourceChangeListener(changeListener);		
				return Status.OK_STATUS;
			}
		};
		
		MutexRule rule = new MutexRule();

		
		removeResourceChangeJob.setRule(rule);
		job.setRule(rule);
		addResourceChangeJob.setRule(rule);
		
		removeResourceChangeJob.schedule();
		job.schedule();
		addResourceChangeJob.schedule();
		
		UIJob openEditor = job.new OpenEditorJob("Open Editors");
		openEditor.schedule(3000);
	}

	public class MutexRule implements ISchedulingRule {
	      public boolean isConflicting(ISchedulingRule rule) {
	         return rule == this;
	      }
	      public boolean contains(ISchedulingRule rule) {
	         return rule == this;
	      }
	}

	private void checkProject(Project project) {
		// TODO Auto-generated method stub
		
	}

	public void checkMarkers(final IMarker marker) {
		Job job = new CheckMarkersJob(marker, this);
		job.schedule();
	}

	public void checkTwoFiles(final IResource resource, final IResource resource2) {
		
		Job removeResourceChangeJob = new Job("Removing Resource Change Listener") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ResourcesPlugin.getWorkspace().removeResourceChangeListener(MarkerStaticChecker.getInstance());		
				return Status.OK_STATUS;
			}
		};
		
		Job job = new Job("Check Relations of Two Files") {
			@Override
			public IStatus run(IProgressMonitor monitor) {
				// Set total number of work units
				monitor.beginTask("Checking...", 100);
				
				monitor.subTask("Reading Files...");
				GReader reader = new GReader(ResourceUtil.getResource(resource), ResourceUtil.getResource(resource2));
				monitor.worked(50);
				
				ArrayList<ArrayList<Class>> classes = loadCheckerClasses(monitor);
				ArrayList<Method> collectors = getCollectorMethods(monitor, classes.get(0));
				Set relations = performChecks(monitor, reader, resource, resource2, collectors, classes);
				
				MarkerGenerator.createMarkers(resource, resource2, reader.getEmfResources().fst, reader.getEmfResources().snd, (Set<VisualCoralRelation>)relations);
				
				RelationModel relationModel = RelationModel.getInstance();
				relationModel.addRelations(relations);
				
				monitor.done();
				
				return Status.OK_STATUS;
			}
		};
		
		Job addResourceChangeJob = new Job("Adding Resource Change Listener") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ResourcesPlugin.getWorkspace().addResourceChangeListener(MarkerStaticChecker.getInstance());		
				return Status.OK_STATUS;
			}
		};
		
		MutexRule rule = new MutexRule();
		removeResourceChangeJob.setRule(rule);
		job.setRule(rule);
		addResourceChangeJob.setRule(rule);
		
		removeResourceChangeJob.schedule();
		job.schedule();
		addResourceChangeJob.schedule();

		
		UIJob uiJob = new UIJob("Open Editors") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				
				try {
					IDE.openEditor(page, (IFile)resource);
					IDE.openEditor(page, (IFile)resource2);
				} catch (PartInitException e) {
					e.printStackTrace();
				}				
				return Status.OK_STATUS;
			}
		};
		
//		job.schedule();
		uiJob.schedule(3000);
	}
	
	
	protected Class loadCheckerClass(String constraintClassName, IProgressMonitor monitor) {
		monitor.subTask("Loading Constraints...");
		
		Class constraintClass = null;
		
		String pathToMainCoralPlugin = CoralProperties.getCoralProperties().getProperty("pathToMainCoralPlugin");
		IProject mainCoralProject = ResourcesPlugin.getWorkspace().getRoot().getProject(pathToMainCoralPlugin);
		String pluginPath = mainCoralProject.getLocation().toOSString();
		
		IFolder srcFolder = mainCoralProject.getFolder("src/" + pathToMainCoralPlugin.replaceAll("\\.", "/"));
		IFolder srcGenFolder = mainCoralProject.getFolder("src-gen/" + pathToMainCoralPlugin.replaceAll("\\.", "/"));
	
		try {
			IResource[] srcMembers = srcFolder.members();
			IResource[] srcGenMembers = srcGenFolder.members();
			IResource srcConstraintsCode = null;
			IResource srcGenConstraintsCode = null;
			
			Set<String> manualConstraints = new HashSet<String>();
			
			for (IResource srcResource : srcMembers) {
				if(srcResource.getName().equals(constraintClassName + ".groovy")) {
					srcConstraintsCode = srcResource ;
					manualConstraints.add(srcResource.getName());
				}
			}
			for (IResource srcGenResource : srcGenMembers) {
				if(srcGenResource.getName().equals(constraintClassName + ".groovy") && !manualConstraints.contains(srcGenResource.getName())) {
					srcGenConstraintsCode = srcGenResource;
				}
			}
			
			
			File constraintFile;
			
			if (srcConstraintsCode != null) {
				constraintFile = new File(srcConstraintsCode.getLocation().toString());
			} else {
				constraintFile = new File(srcGenConstraintsCode.getLocation().toString());
			}
			
			
			
			ClassLoader parent = getClass().getClassLoader();
			GroovyClassLoader loader = new GroovyClassLoader(parent);
			
			constraintClass = loader.parseClass(constraintFile);
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		monitor.worked(1);
		
		return constraintClass;
	}
	
	
	/**
	 * 
	 * @param monitor 
	 * @return  element 0 is the collector class
	 * 			element 1 is the constraint class
	 */
	public ArrayList<ArrayList<Class>> loadCheckerClasses(IProgressMonitor monitor) {
		
		monitor.subTask("Loading Constraints...");
		
		ArrayList<ArrayList<Class>> classes = new ArrayList<ArrayList<Class>>();
		
		String pathToMainCoralPlugin = CoralProperties.getCoralProperties().getProperty("pathToMainCoralPlugin");
		IProject mainCoralProject = ResourcesPlugin.getWorkspace().getRoot().getProject(pathToMainCoralPlugin);
		String pluginPath = mainCoralProject.getLocation().toOSString();
		
		IFolder srcFolder = mainCoralProject.getFolder("src/" + pathToMainCoralPlugin.replaceAll("\\.", "/"));
		IFolder srcGenFolder = mainCoralProject.getFolder("src-gen/" + pathToMainCoralPlugin.replaceAll("\\.", "/"));
	
		try {
			IResource[] srcMembers = srcFolder.members();
			IResource[] srcGenMembers = srcGenFolder.members();
			ArrayList<IResource> srcConstraintsCode = new ArrayList<IResource>();
			ArrayList<IResource> srcGenConstraintsCode = new ArrayList<IResource>();
			ArrayList<IResource> srcGenCollectorsCode = new ArrayList<IResource>();
			
			Set<String> manualConstraints = new HashSet<String>();
			
			for (IResource srcResource : srcMembers) {
				if(srcResource.getName().endsWith("Constraints.groovy")) {
					srcConstraintsCode.add(srcResource);
					manualConstraints.add(srcResource.getName());
				}
			}
			for (IResource srcGenResource : srcGenMembers) {
				if(srcGenResource.getName().endsWith("Constraints.groovy") && !manualConstraints.contains(srcGenResource.getName())) {
					srcGenConstraintsCode.add(srcGenResource);
				} else if (srcGenResource.getName().endsWith("Collector.groovy")) {
					srcGenCollectorsCode.add(srcGenResource);
				}
			}
			
			
			ArrayList<File> srcConstraintsFiles = new ArrayList<File>();
			ArrayList<File> srcGenConstraintsFiles = new ArrayList<File>();
			ArrayList<File> srcGenCollectorsFiles = new ArrayList<File>();
			
			for (IResource resource : srcConstraintsCode) {
				File file = new File(resource.getLocation().toString());
				srcConstraintsFiles.add(file);
			}
			for (IResource resource : srcGenConstraintsCode) {
				File file = new File(resource.getLocation().toString());
				srcGenConstraintsFiles.add(file);
			}
			for (IResource resource : srcGenCollectorsCode) {
				File file = new File(resource.getLocation().toString());
				srcGenCollectorsFiles.add(file);
			}
			
			
			ClassLoader parent = getClass().getClassLoader();
			GroovyClassLoader loader = new GroovyClassLoader(parent);
			ArrayList<Class> collectorClasses = new ArrayList<Class>();
			ArrayList<Class> constraintClasses = new ArrayList<Class>();
			
			for (File constraintFile : srcConstraintsFiles) {
				Class constraintClass = loader.parseClass(constraintFile);
				constraintClasses.add(constraintClass);
			}	
			for (File constraintFile : srcGenConstraintsFiles) {
				Class constraintClass = loader.parseClass(constraintFile);
				constraintClasses.add(constraintClass);
			}
			for (File collectorFile : srcGenCollectorsFiles) {
				Class collectorClass = loader.parseClass(collectorFile);
				collectorClasses.add(collectorClass);
			}
//			
//			File inferedCollector = new File(pluginPath + "/src-gen/" + pathToMainCoralPlugin.replaceAll("\\.", "/") + "/" + "InferedCollector.groovy");
//			File inferedConstraints = new File(pluginPath + "/src-gen/" + pathToMainCoralPlugin.replaceAll("\\.", "/") + "/" + "InferedConstraints.groovy");
//			File manualCollector = new File(pluginPath + CoralProperties.getCoralProperties().getProperty("pathToCheckAllCollector"));
//			File manualConstraints = new File(pluginPath + CoralProperties.getCoralProperties().getProperty("pathToCheckAllConstraints"));
//			
//			
//			ClassLoader parent = getClass().getClassLoader();
//			GroovyClassLoader loader = new GroovyClassLoader(parent);
//			Class collectorClass = null;
//			Class constraintClass = null;
//			
//			if (inferedCollector.exists() && inferedConstraints.exists()) {
//				constraintClass = loader.parseClass(inferedConstraints);				
//				collectorClass = loader.parseClass(inferedCollector);
//			} else if (manualCollector.exists() && manualConstraints.exists()) {
//				constraintClass = loader.parseClass(manualConstraints);				
//				collectorClass = loader.parseClass(manualCollector);
//			} else {
//				System.out.println("Alles Mist!!!!");
//			}
			
			classes.add(collectorClasses);
			classes.add(constraintClasses);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		monitor.worked(1);
		
		return classes;
	}
	
	private ArrayList<Class> findAllCheckerClasses(IProgressMonitor monitor, Project project) {
		
		monitor.subTask("Searching Constraint Classes...");
		
		ArrayList<Class> classes = new ArrayList<Class>();
	
		String pathToMainCoralPlugin = CoralProperties.getCoralProperties().getProperty("pathToMainCoralPlugin");
		IProject mainCoralProject = ResourcesPlugin.getWorkspace().getRoot().getProject(pathToMainCoralPlugin);
		String pluginPath = mainCoralProject.getLocation().toOSString();
		
		try {
			
			File inferedCollector = new File(pluginPath + "/src-gen/" + pathToMainCoralPlugin.replaceAll("\\.", "/") + "/" + "InferedCollector.groovy");
			File inferedConstraints = new File(pluginPath + "/src-gen/" + pathToMainCoralPlugin.replaceAll("\\.", "/") + "/" + "InferedConstraints.groovy");
			File manualCollector = new File(pluginPath + CoralProperties.getCoralProperties().getProperty("pathToCheckAllCollector"));
			File manualConstraints = new File(pluginPath + CoralProperties.getCoralProperties().getProperty("pathToCheckAllConstraints"));
			
			
			ClassLoader parent = getClass().getClassLoader();
			GroovyClassLoader loader = new GroovyClassLoader(parent);
			Class collectorClass = null;
			Class constraintClass = null;
			
			if (inferedCollector.exists() && inferedConstraints.exists()) {
				constraintClass = loader.parseClass(inferedConstraints);				
				collectorClass = loader.parseClass(inferedCollector);
			} else if (manualCollector.exists() && manualConstraints.exists()) {
				constraintClass = loader.parseClass(manualConstraints);				
				collectorClass = loader.parseClass(manualCollector);
			} else {
				System.out.println("Alles Mist!!!!");
			}
			
			classes.add(collectorClass);
			classes.add(constraintClass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return classes;
	}
	
	private ArrayList<Method> getCollectorMethods(IProgressMonitor monitor, ArrayList<Class> collectorClasses) {
		
		monitor.subTask("Resolving Constraints...");
		
		ArrayList<Method> collectorMethods = new ArrayList<Method>();
		
		for (Class collectorClass : collectorClasses) {
			
		
			Method[] declaredMethods = collectorClass.getDeclaredMethods();
	
			
			for (Method method : declaredMethods) {
				if (method.getName().startsWith("checkRelationCollector") || method.getName().startsWith(CoralProperties.getCoralProperties().getProperty("manualCollectorsStartWith"))) {
					collectorMethods.add(method);
				}
			}
		}
		monitor.worked(1);
		
		return collectorMethods;
	}
	
	public ArrayList<Method> getCollectorMethodsForRelation(IProgressMonitor monitor, Class collectorClass, Relation relation) {
		
		monitor.subTask("Resolving Constraints...");
		
		Method[] declaredMethods = collectorClass.getDeclaredMethods();
		ArrayList<Method> collectorMethods = new ArrayList<Method>();

		
		for (Method method : declaredMethods) {
			if (method.getName().startsWith("checkRelationCollector") || method.getName().startsWith(CoralProperties.getCoralProperties().getProperty("manualCollectorsStartWith"))) {
				collectorMethods.add(method);
			}
		}
		
		monitor.worked(5);
		
		return collectorMethods;
	}
	
	private Set performChecks(IProgressMonitor monitor, GReader reader, IResource resource, IResource resource2, ArrayList<Method> collectors, ArrayList<ArrayList<Class>> classes) {
		
		monitor.subTask("Reading Sources...");
		
		monitor.worked(1);

		ArrayList<Resource> args = new ArrayList<Resource>();
		args.add(reader.getEmfResources().fst);
		args.add(reader.getEmfResources().snd);
		
		ArrayList<GroovyObject> collectorObjects = new ArrayList<GroovyObject>();
		ArrayList<GroovyObject> constraintObjects = new ArrayList<GroovyObject>();
		
		ArrayList<Class> collectorClasses = classes.get(0);
		ArrayList<Class> constraintClasses = classes.get(1);
		
		try {
			for (Class collectorClass : collectorClasses) {
				GroovyObject collectorObject = (GroovyObject) collectorClass.newInstance();
				collectorObjects.add(collectorObject);
			}
			for (Class constraintClass : constraintClasses) {
				GroovyObject constraintObject = (GroovyObject) constraintClass.newInstance();
				constraintObjects.add(constraintObject);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		
//		try {
//			collectorObject = (GroovyObject) classes.get(0).newInstance();
//			constraintObject = (GroovyObject) classes.get(1).newInstance();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		monitor.subTask("Checking constraints...");

		Set relations = new HashSet();
		for (Method collectorMethod : collectors) {

			Class methodsClass = collectorMethod.getDeclaringClass();

			Class objectsClass = null;
			GroovyObject cO = null;
			
			for (GroovyObject collectorObject : collectorObjects) {
				objectsClass = collectorObject.getClass();
				if (objectsClass.equals(methodsClass)) {
					cO = collectorObject;
					break;
				}
				if (objectsClass.getName().equals(methodsClass.getName())) {
					cO = collectorObject;
					break;
				}
			}
			
//			int classIndex = collectorClasses.indexOf(methodsClass);
//			GroovyObject collectorObject = collectorObjects.get(classIndex);
			
			relations.addAll((Collection)cO.invokeMethod(collectorMethod.getName(), args.toArray()));
			
			monitor.worked(1);
		}
		
		return relations;
	}
	
	
	public void checkRelation(final Relation relation) {
		
		Job job = new CheckRelationJob(relation, clusteredFiles, this);
		job.schedule();
	}
	
	public void checkRelations(final List<Relation> relations) {
		Job job = new Job("Checking All Relations...") {
			@Override
			public IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Checking...", relations.size());
								
				for (Relation relation : relations) {
					checkRelation(relation);
					monitor.worked(1);
				}
				
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		
		job.schedule();
	}
	
	public Map<String,Set<org.eclipse.core.internal.resources.File>> getFiles() {
		
		String[] pathToDevelopmentProjects = CoralProperties.getCoralProperties().getProperty("pathToDevelopmentProjects").split(",");
		
		ArrayList<org.eclipse.core.internal.resources.File> files;
		Map<String,Set<org.eclipse.core.internal.resources.File>> clusteredFiles = null;
		
		for (int i = 0; i < pathToDevelopmentProjects.length; i++) {
			
			IProject developmentProject = ResourcesPlugin.getWorkspace().getRoot().getProject(pathToDevelopmentProjects[i]);
			files = ResourceUtil.getFilesFromResource(developmentProject);
			
			if (clusteredFiles == null) {
				clusteredFiles = ResourceUtil.clusterFiles(files);
			} else {
				clusteredFiles.putAll(ResourceUtil.clusterFiles(files));
			}
		}
		
		
		
		return clusteredFiles;
	}
}
