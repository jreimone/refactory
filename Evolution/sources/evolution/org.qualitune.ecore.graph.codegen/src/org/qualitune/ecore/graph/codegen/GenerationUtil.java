/**
 * 
 */
package org.qualitune.ecore.graph.codegen;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.ImportsFactory;
import org.emftext.language.java.instantiations.InstantiationsPackage;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.qualitune.ecore.graph.GObject;

public abstract class GenerationUtil {

	/**
	 * Adds the given <code>importClassifier</code> to the given <code>cu</code>. Furthermore,
	 * redundant imports are removed.
	 * @param cu
	 * @param importClassifier
	 */
	public static void addImport(CompilationUnit cu, ConcreteClassifier importClassifier){
		Collection<Setting> sameImports = EcoreUtil.CrossReferencer.find(cu.getImports()).get(importClassifier);
		if(sameImports != null && sameImports.size() > 0){
			ClassifierImport oldImport = (ClassifierImport) sameImports.iterator().next().getEObject();
			replaceImport(oldImport, importClassifier);
		} else {
			ClassifierImport newImport = ImportsFactory.eINSTANCE.createClassifierImport();
			newImport.setClassifier(importClassifier);
			CompilationUnit importCU = (CompilationUnit) importClassifier.eResource().getContents().get(0);
			newImport.getNamespaces().addAll(importCU.getNamespaces());
			cu.getImports().add(newImport);
		}
	}

	/**
	 * Replaces the <code>source</code> import with the <code>target</code> classifier and checks 
	 * if the new import is already present. If it is present it won't be added.
	 * @param source
	 * @param target
	 */
	public static void replaceImport(ClassifierImport source, ConcreteClassifier target){
		CompilationUnit sourceCU = (CompilationUnit) source.eResource().getContents().get(0);
		CompilationUnit targetCU = (CompilationUnit) target.eResource().getContents().get(0);
		source.setClassifier(target);
		List<String> namespaces = source.getNamespaces();
		namespaces.clear();
		namespaces.addAll(targetCU.getNamespaces());
		Collection<Setting> sameImports = EcoreUtil.CrossReferencer.find(sourceCU.getImports()).get(target);
		for (Setting setting : sameImports) {
			EObject sameImport = setting.getEObject();
			if(sameImport != source){
				sourceCU.getImports().remove(sameImport);
			}
		}
	}

	/**
	 * Parses the given <code>fragment</code> and returns the according model elements.
	 * The parameter <code>startRule</code> specifies the {@link EClass} which should be the starting rule.
	 * 
	 * @param fragment
	 * @param startRule
	 * @return
	 */
	public static<Type> List<Type> parsePartialFragment(String fragment, EClass startRule, Class<Type> type){
		URI uri = URI.createURI("temp.java");
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(fragment.getBytes());
		Map<?, ?> typeOption = Collections.singletonMap(IJavaOptions.RESOURCE_CONTENT_TYPE, startRule);
		try {
			resource.load(inputStream, typeOption);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Type> result = new ArrayList<Type>();
		for (EObject parseResult : resource.getContents()) {
			if(type.isInstance(parseResult)){
				result.add(type.cast(parseResult));
			}
		}
		return result;
	}

	/**
	 * Returns the classes annotated with {@link GObject#ROOT_GRAPH_ELEMENT}.
	 * @param model
	 * @return
	 */
	public static List<GenClass> getRootClasses(GenModel model) {
		List<GenClass> rootClasses = new ArrayList<GenClass>();
		List<GenPackage> genPackages = model.getGenPackages();
		for (GenPackage genPackage : genPackages) {
			List<GenClass> genClasses = genPackage.getGenClasses();
			for (GenClass genClass : genClasses) {
				EClass ecoreClass = genClass.getEcoreClass();
				EAnnotation annotation = ecoreClass.getEAnnotation(GObject.ROOT_GRAPH_ELEMENT);
				if(annotation != null){
					rootClasses.add(genClass);
				}
			}
		}
		return rootClasses;
	}

	/**
	 * Returns all concrete classifiers in the given {@link GenModel model}.
	 * @param model
	 * @return
	 */
	public static List<GenClass> getConcreteClasses(GenModel model){
		List<GenClass> classes = new ArrayList<GenClass>();
		List<GenPackage> genPackages = model.getGenPackages();
		for (GenPackage genPackage : genPackages) {
			List<GenClass> genClasses = genPackage.getGenClasses();
			for (GenClass genClass : genClasses) {
				EClass ecoreClass = genClass.getEcoreClass();
				if(!ecoreClass.isAbstract() && !ecoreClass.isInterface()){
					classes.add(genClass);
				}
			}
		}
		return classes;
	}

	/**
	 * Determines the {@link JavaResource} from the given <code>genClass</code>.
	 * 
	 * @param model
	 * @param rs
	 * @param genClass
	 * @return
	 */
	public static JavaResource getJavaResource(ResourceSet rs, GenClass genClass) {
		GenModel model = genClass.getGenModel();
		String qualifiedClassName = genClass.getQualifiedClassName();
		qualifiedClassName = qualifiedClassName.replace(".", "/") + ".java";
		String modelDirectory = model.getModelDirectory();
		IFolder sourceFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(modelDirectory));
		if(!sourceFolder.exists()){
			return null;
		}
		IFile file = sourceFolder.getFile(qualifiedClassName);
		if(!file.exists()){
			return null;
		}
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		JavaResource resource = (JavaResource) rs.getResource(uri, true);
		return resource;
	}

	/**
	 * Returns the given <code>string</code> with the first letter uppercase.
	 * @param genPackage
	 */
	public static String uppercaseFirstLetter(String string) {
		char[] stringArray = string.toCharArray();
		stringArray[0] = Character.toUpperCase(stringArray[0]);
		return new String(stringArray);
	}

	/**
	 * Replaces {@link ConcreteClassifier oldConstructorType} by {@link ConcreteClassifier newConstructorType} in the given <code>method</code>.
	 * 
	 * 
	 * 
	 * @param feature
	 * @param cu
	 * @param oldConstructorType
	 * @param newConstructorType
	 * @param method
	 * @return
	 */
	public static boolean replaceConstructorInMethod(ConcreteClassifier oldConstructorType, ConcreteClassifier newConstructorType, Method method, List<Expression> additionalConstructorArguments) {
		boolean modified = false;
		EList<EObject> news = method.getChildrenByEType(InstantiationsPackage.Literals.NEW_CONSTRUCTOR_CALL);
		CompilationUnit cu = method.getContainingCompilationUnit();
		for (EObject element : news) {
			NewConstructorCall call = (NewConstructorCall) element;
			NamespaceClassifierReference typeReference = (NamespaceClassifierReference) call.getTypeReference();
			List<ClassifierReference> references = typeReference.getClassifierReferences();
			for (ClassifierReference classifierReference : references) {
				Classifier target = classifierReference.getTarget();
				if(target == oldConstructorType){
					classifierReference.setTarget(newConstructorType);
					for(EStructuralFeature.Setting setting : EcoreUtil.CrossReferencer.find(cu.getImports()).get(oldConstructorType)){
						ClassifierImport oldImport = (ClassifierImport) setting.getEObject();
						replaceImport(oldImport, newConstructorType);
					}
				}
			}
			List<Expression> arguments = call.getArguments();
			arguments.addAll(additionalConstructorArguments);
			modified = true;
		}
		return modified;
	}
}
