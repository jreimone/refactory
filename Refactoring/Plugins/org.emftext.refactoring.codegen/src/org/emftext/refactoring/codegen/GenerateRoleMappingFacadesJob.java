package org.emftext.refactoring.codegen;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.emftext.language.manifest.Export;
import org.emftext.language.manifest.ExportPackage;
import org.emftext.language.manifest.Manifest;
import org.emftext.language.manifest.ManifestFactory;
import org.emftext.language.manifest.PackageName;
import org.emftext.language.manifest.RequireBundle;
import org.emftext.language.manifest.RequireBundleDescription;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.util.StringUtil;
import org.emftext.sdk.codegen.composites.JavaComposite;

public class GenerateRoleMappingFacadesJob extends Job {

	private static final String GENERAL_JOB_NAME = "Generate Facade(s) for RoleMappings";
	private static final String GENERATE_FACADE_PACKAGE = "Generate facade package: %1$s";
	private static final String FACADE_POSTFIX = ".facade";
	private static final String CLASS_NAME_POSTFIX = "RefactoringFacade";

	private static final String[] REQUIRED_PLUGINS = new String[] {
			"org.eclipse.core.runtime",
			"org.emftext.refactoring.registry.rolemapping",
			"org.emftext.language.refactoring.rolemapping",
			"org.emftext.refactoring.specification.interpreter"
	};

	private IProject project;
	private List<RoleMapping> foundMappings;
	private IPackageFragment fragment;
	private Map<EPackage, List<RoleMapping>> metamodelRoleMappings;

	public GenerateRoleMappingFacadesJob(IProject project, List<RoleMapping> foundMappings) {
		super(GENERAL_JOB_NAME);
		this.project = project;
		this.foundMappings = foundMappings;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		metamodelRoleMappings = new LinkedHashMap<EPackage, List<RoleMapping>>();
		int ticks = 0;
		for (RoleMapping roleMapping : foundMappings) {
			EPackage metamodel = roleMapping.getOwningMappingModel().getTargetMetamodel();
			List<RoleMapping> specificRoleMappings = metamodelRoleMappings.get(metamodel);
			if (specificRoleMappings == null) {
				specificRoleMappings = new LinkedList<RoleMapping>();
				metamodelRoleMappings.put(metamodel, specificRoleMappings);
				// one tick for every Java file
				ticks++;
			}
			specificRoleMappings.add(roleMapping);
			// one tick for every method for a RoleMapping
			ticks++;
		}
		// one tick for creating the package
		ticks++;
		monitor.beginTask(GENERAL_JOB_NAME, ticks);
		monitor.subTask(String.format(GENERATE_FACADE_PACKAGE,
				project.getName() + FACADE_POSTFIX));
		if (!project.isOpen()) {
			try {
				project.open(monitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		fragment = createFacadePackage(monitor);
		monitor.worked(1);
		generateManifest(monitor);
		generateCompilationUnits(monitor);
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		monitor.done();
		return Status.OK_STATUS;
	}

	private void generateCompilationUnits(IProgressMonitor monitor) {
		for (EPackage epackage : metamodelRoleMappings.keySet()) {
			String className = StringUtil.firstLetterUpperCase(epackage.getName()) + CLASS_NAME_POSTFIX;
			monitor.subTask("Generating class " + className);
			JavaComposite sc = new JavaComposite();
			sc.add("package " + fragment.getElementName() + ";");
			sc.addLineBreak();
			addImports(sc);
			sc.addJavadoc(
					"Provides a facade for simpler access to the registered {@link RoleMapping}s for"
					,
					"the metamodel: http://www.emftext.org/language/roles.<br>"
					,
					"For every registered mapping two methods are contained in this facade:"
					,
					"<li> a method for returning the {@link RoleMapping} itself"
					,
					"<li> a method for returning the registered icon if one exists"
					, "<br>"
					, "@author jreimann");
			sc.add("public class " + className + " {");
			sc.addLineBreak();
			sc.add("private Resource resource;");
			sc.add("private List<EObject> selectedElement;");
			sc.add("private Map<String, RoleMapping> mappingMap;");
			sc.add("private IRefactorer refactorer;");
			sc.addLineBreak();
			sc.add("public " + className + "(Resource resource, List<EObject> selectedElement){");
			sc.add("super();");
			sc.add("this.resource = resource;");
			sc.add("this.selectedElement = selectedElement;");
			sc.add("initialize();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("private void initialize() {");
			sc.add("mappingMap = new LinkedHashMap<String, RoleMapping>();");
			sc.add("refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);");
			sc.add("if(refactorer != null){");
			sc.add("refactorer.setInput(selectedElement);");
			sc.add("List<RoleMapping> mappings = refactorer.getPossibleRoleMappings(1.0);");
			sc.add("for (RoleMapping roleMapping : mappings) {");
			sc.add("mappingMap.put(roleMapping.getName(), roleMapping);");
			sc.add("}");
			sc.add("}");
			sc.add("}");
			sc.addLineBreak();
			sc.addJavadoc("Returns the refactorer.");
			sc.add("public IRefactorer getRefactorer() {");
			sc.add("return refactorer;");
			sc.add("}");
			sc.addLineBreak();
			generateMethods(sc, metamodelRoleMappings.get(epackage), monitor);
			sc.add("}");
			try {
				fragment.createCompilationUnit(className + ".java",
						sc.toString(), true, monitor);
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
			monitor.worked(1);
		}
	}

	private void generateMethods(JavaComposite sc, List<RoleMapping> list, IProgressMonitor monitor) {
		for (RoleMapping roleMapping : list) {
			String mappingName = roleMapping.getName();
			sc.addJavadoc(
					"Returns the {@link RoleMapping} with name '" + mappingName + "'.",
					"@return");
			sc.add("public RoleMapping get" + StringUtil.convertWordsToCamelCase(mappingName) + "Mapping(){");
			sc.add("return mappingMap.get(\"" + mappingName + "\");");
			sc.add("}");
			sc.addLineBreak();
			sc.addLineBreak();
			sc.addJavadoc(
					"Returns the registered icon for the {@link RoleMapping} with name '" + mappingName + "'."
					,
					"@return the registered icon or null if none is registered");
			sc.add("public URL get" + StringUtil.convertWordsToCamelCase(mappingName) + "Icon(){");
			sc.add("return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(get" + StringUtil.convertWordsToCamelCase(mappingName) + "Mapping());");
			sc.add("}");
			sc.addLineBreak();
			monitor.worked(1);
		}
	}

	private void addImports(JavaComposite sc) {
		sc.add("import java.net.URL;");
		sc.add("import java.util.LinkedHashMap;");
		sc.add("import java.util.List;");
		sc.add("import java.util.Map;");
		sc.addLineBreak();
		sc.add("import org.eclipse.emf.ecore.EObject;");
		sc.add("import org.eclipse.emf.ecore.resource.Resource;");
		sc.add("import org.emftext.language.refactoring.rolemapping.RoleMapping;");
		sc.add("import org.emftext.refactoring.interpreter.IRefactorer;");
		sc.add("import org.emftext.refactoring.interpreter.RefactorerFactory;");
		sc.add("import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;");
		sc.addLineBreak();
	}

	private void generateManifest(IProgressMonitor monitor) {
		IFolder metaInf = project.getFolder("META-INF");
		if (!metaInf.exists()) {
			try {
				metaInf.create(true, true, monitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		IFile manifestFile = metaInf.getFile("MANIFEST.MF");
		if (!manifestFile.exists()) {
			throw new UnsupportedOperationException("Implement creation of default MANIFEST.MF");
		}
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(manifestFile.getLocation().toFile().getAbsolutePath());
		Resource resource = rs.getResource(uri, true);
		if (resource != null && resource.getContents().get(0) instanceof Manifest) {
			Manifest manifest = (Manifest) resource.getContents().get(0);
			addRequiredPluginsToManifest(manifest);
			addExportedPackagesToManifest(manifest);
			try {
				resource.save(Collections.EMPTY_MAP);
				InputStream stream = new ByteArrayInputStream("\n".getBytes());
				manifestFile.appendContents(stream, true, true, monitor);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	private void addExportedPackagesToManifest(Manifest manifest) {
		ExportPackage exportPackage = manifest.getExportPackage();
		if (exportPackage == null) {
			exportPackage = ManifestFactory.eINSTANCE.createExportPackage();
			manifest.setExportPackage(exportPackage);
		}
		List<Export> exports = exportPackage.getExport();
		boolean contained = false;
		for (Export export : exports) {
			EList<PackageName> packageNames = export.getPackageName();
			for (PackageName packageName : packageNames) {
				String realPackageName = packageName.getId();
				if (realPackageName.equals(fragment.getElementName())) {
					contained = true;
					break;
				}
			}
		}
		if (!contained) {
			Export export = ManifestFactory.eINSTANCE.createExport();
			PackageName packageName = ManifestFactory.eINSTANCE.createPackageName();
			packageName.setId(fragment.getElementName());
			export.getPackageName().add(packageName);
			exportPackage.getExport().add(export);
		}
	}

	private void addRequiredPluginsToManifest(Manifest manifest) {
		RequireBundle requiredBundle = manifest.getRequireBundle();
		if (requiredBundle == null) {
			requiredBundle = ManifestFactory.eINSTANCE.createRequireBundle();
			manifest.setRequireBundle(requiredBundle);
		}
		List<RequireBundleDescription> requiredDescriptions = requiredBundle.getRequireBundleDescription();
		List<String> requiredPlugins = Arrays.asList(REQUIRED_PLUGINS);
		List<String> plugins2add = new LinkedList<String>(requiredPlugins);
		for (RequireBundleDescription requireBundleDescription : requiredDescriptions) {
			String plugin = requireBundleDescription.getSymbolicName();
			if (requiredPlugins.contains(plugin)) {
				plugins2add.remove(plugin);
			}
		}
		for (String pluginID : plugins2add) {
			RequireBundleDescription description = ManifestFactory.eINSTANCE.createRequireBundleDescription();
			description.setSymbolicName(pluginID);
			requiredDescriptions.add(description);
		}
	}

	private IPackageFragment createFacadePackage(IProgressMonitor monitor) {
		IJavaProject javaProject = JavaCore.create(project);
		IFolder genFolder = project.getFolder("src-gen");
		try {
			if (!genFolder.exists()) {
				genFolder.create(true, true, monitor);
			}
			IPackageFragmentRoot srcFolder = javaProject.getPackageFragmentRoot(genFolder);
			IClasspathEntry[] classPathEntries = javaProject.getRawClasspath();
			IClasspathEntry classPath = JavaCore.newSourceEntry(genFolder.getFullPath());
			boolean contained = false;
			for (IClasspathEntry entry : classPathEntries) {
				if (entry.equals(classPath)) {
					contained = true;
					break;
				}
			}
			if (!contained) {
				List<IClasspathEntry> list = new ArrayList<IClasspathEntry>();
				list.addAll(Arrays.asList(classPathEntries));
				list.add(classPath);
				javaProject.setRawClasspath(
						list.toArray(new IClasspathEntry[0]), monitor);
			}
			return srcFolder.createPackageFragment(
					project.getName() + ".facade", true, monitor);
		} catch (JavaModelException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

}
