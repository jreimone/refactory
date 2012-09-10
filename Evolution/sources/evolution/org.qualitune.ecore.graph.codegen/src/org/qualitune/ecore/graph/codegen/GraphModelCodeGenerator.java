/**
 * 
 */
package org.qualitune.ecore.graph.codegen;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.generics.TypeArgument;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.ImportsPackage;
import org.emftext.language.java.instantiations.InstantiationsPackage;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.manifest.Manifest;
import org.emftext.language.manifest.ManifestFactory;
import org.emftext.language.manifest.RequireBundleDescription;
import org.qualitune.ecore.graph.GObject;
import org.qualitune.ecore.graph.impl.EObjectContainmentEListGraph;
import org.qualitune.ecore.graph.impl.GObjectImpl;

/**
 * @author jreimann
 *
 */
public class GraphModelCodeGenerator {

	private GenModel model;
	private IProject project;
	private ResourceSet rs;

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
		modifyClasses(model);
	}

	private void modifyClasses(GenModel model) {
		List<GenClass> classes = GenerationUtil.getConcreteClasses(model);
		for (GenClass genClass : classes) {
			JavaResource javaResource = GenerationUtil.getJavaResource(rs, genClass);
			List<GenFeature> getGenFeatures = genClass.getEGetGenFeatures();
			boolean modified = false;
			for (GenFeature feature : getGenFeatures) {
				EStructuralFeature ecoreFeature = feature.getEcoreFeature();
				if(ecoreFeature instanceof EReference){
					EReference reference = (EReference) ecoreFeature;
					if(reference.isMany() && reference.isContainment()){
						CompilationUnit cu = (CompilationUnit) javaResource.getContents().get(0);
						String importString = "\nimport " + EObjectContainmentEListGraph.class.getName() + ";";
						ClassifierImport cimport = (ClassifierImport) GenerationUtil.parsePartialFragment(importString, ImportsPackage.Literals.CLASSIFIER_IMPORT).get(0);
						cu.getImports().add(cimport);
						ConcreteClassifier classifier = cu.getContainedClassifier(genClass.getClassName());
						Method method = classifier.getContainedMethod(feature.getGetAccessor());
						EList<EObject> news = method.getChildrenByEType(InstantiationsPackage.Literals.NEW_CONSTRUCTOR_CALL);
						for (EObject element : news) {
							NewConstructorCall call = (NewConstructorCall) element;
							NamespaceClassifierReference typeReference = (NamespaceClassifierReference) call.getTypeReference();
							List<ClassifierReference> references = typeReference.getClassifierReferences();
							for (ClassifierReference classifierReference : references) {
								Classifier target = classifierReference.getTarget();
								if(target.getName().equals(EObjectContainmentEList.class.getSimpleName())){
									target.setName(EObjectContainmentEListGraph.class.getSimpleName());
								}
							}
							List<Expression> arguments = call.getArguments();
							if(arguments.size() == 3){
								GenPackage genPackage = genClass.getGenPackage();
								String name = genPackage.getEcorePackage().getName();
								name = GenerationUtil.uppercaseFirstLetter(name);
//								String parameterString = name + "Package.Literals." + genClass.getClassifierID() + "__" + feature.getUpperName();
								String parameterString = name + "Package.Literals." + genClass.getFeatureID(feature);
								IdentifierReference parameter = (IdentifierReference) GenerationUtil.parsePartialFragment(parameterString, ReferencesPackage.Literals.IDENTIFIER_REFERENCE).get(0);
								arguments.add(parameter);
							} else if(arguments.size() > 4){
								int greater = arguments.size() - 4;
								for (int i = 0; i < greater; i++) {
									arguments.remove(arguments.size() - 1);
								}
							}
							modified = true;
						}
					} else if(reference.isMany() && !reference.isContainment()){

					}
				}
			}
			if(modified){
				try {
					javaResource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void modifyRootGraphClass(GenModel model) {
		List<GenClass> rootClasses = GenerationUtil.getRootClasses(model);
		rs = new ResourceSetImpl();
		for (GenClass genClass : rootClasses) {
			JavaResource resource = GenerationUtil.getJavaResource(rs, genClass);
			if(resource == null){
				continue;
			}
			CompilationUnit cu = (CompilationUnit) resource.getContents().get(0);
			String importString = "\nimport " + GObject.class.getName() + ";";
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
