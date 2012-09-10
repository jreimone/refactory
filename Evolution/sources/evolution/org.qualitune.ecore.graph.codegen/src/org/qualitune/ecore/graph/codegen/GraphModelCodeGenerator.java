/**
 * 
 */
package org.qualitune.ecore.graph.codegen;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.ImportsPackage;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.manifest.Manifest;
import org.emftext.language.manifest.ManifestFactory;
import org.emftext.language.manifest.RequireBundleDescription;
import org.qualitune.ecore.graph.GObject;
import org.qualitune.ecore.graph.impl.GObjectImpl;

/**
 * @author jreimann
 *
 */
public class GraphModelCodeGenerator {

	private GenModel model;
	private IProject project;
	
	public void init(GenModel model) {
		if(model == null){
			return;
		}
		String pluginID = model.getModelPluginID();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginID);
		if(project == null){
			return;
		}
		this.project = project;
		this.model = model;
		genModelModifications(model);
	}

	public void generateModel() {
		if(model == null){
			return;
		}
		model.reconcile();
		model.setCanGenerate(true);
		Generator generator = new Generator();
		generator.setInput(model);
		generator.generate(model, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor());
	}

	private void genModelModifications(GenModel model) {
		model.setRootExtendsClass(GObjectImpl.class.getName());
		model.setRootExtendsInterface(GObject.class.getName());
		Resource resource = model.eResource();
		if(resource != null){
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void generateGraphModel() {
		if(model == null){
			return;
		}
		modifyManifest(project);
		modifyRootGraphClass(model);
	}

	private void modifyRootGraphClass(GenModel model) {
		List<GenClass> rootClasses = GenerationUtil.getRootClasses(model);
		ResourceSet rs = new ResourceSetImpl();
		for (GenClass genClass : rootClasses) {
			String id = genClass.getClassifierID();
			JavaResource resource = GenerationUtil.getJavaResource(rs, genClass);
			if(resource == null){
				continue;
			}
			CompilationUnit cu = (CompilationUnit) resource.getContents().get(0);
			String importString = "import org.qualitune.ecore.graph.GObject;";
			ClassifierImport cimport = (ClassifierImport) GenerationUtil.parsePartialFragment(importString, ImportsPackage.Literals.CLASSIFIER_IMPORT).get(0);
			cu.getImports().add(cimport);
			String className = genClass.getClassName();
			ConcreteClassifier clazz = cu.getContainedClassifier(className);
			String methodString = 
				"\n\n" + 
				"	/**\n" +
				"	* @generated\n" +
				"	*/\n" + 
				"	@Override\n" + 
				"	public GObject gGraph() {\n" + 
				"		return this;\n" + 
				"	}";
			ClassMethod method = (ClassMethod) GenerationUtil.parsePartialFragment(methodString, MembersPackage.Literals.CLASS_METHOD).get(0);
			clazz.getMembers().add(method);
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void modifyManifest(IProject project) {
		IResource member = project.findMember("META-INF/MANIFEST.MF");
		if(member == null){
			return;
		}
		if(!(member instanceof IFile) || !member.exists()){
			return;
		}
		IFile manifest = (IFile) member;
		URI uri = URI.createPlatformResourceURI(manifest.getFullPath().toString(), true);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		if(resource == null){
			return;
		}
		Manifest manifestModel = (Manifest) resource.getContents().get(0);
		RequireBundleDescription description = ManifestFactory.eINSTANCE.createRequireBundleDescription();
		String symbolicName = org.qualitune.ecore.graph.Activator.getContext().getBundle().getSymbolicName();
		description.setSymbolicName(symbolicName);
		boolean found = false;
		List<RequireBundleDescription> bundleDescription = manifestModel.getRequireBundle().getRequireBundleDescription();
		for (RequireBundleDescription requireBundleDescription : bundleDescription) {
			if(requireBundleDescription.getSymbolicName().equals(symbolicName)){
				found = true;
			}
		}
		if(!found){
			bundleDescription.add(description);
		}
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public IProject getProject() {
		return project;
	}

}
