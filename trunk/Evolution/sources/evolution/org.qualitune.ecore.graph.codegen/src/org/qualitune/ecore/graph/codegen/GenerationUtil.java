/**
 * 
 */
package org.qualitune.ecore.graph.codegen;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.qualitune.ecore.graph.GObject;

public abstract class GenerationUtil {

	/**
	 * Parses the given <code>fragment</code> and returns the according model elements.
	 * The parameter <code>startRule</code> specifies the {@link EClass} which should be the starting rule.
	 * 
	 * @param fragment
	 * @param startRule
	 * @return
	 */
	public static List<EObject> parsePartialFragment(String fragment, EClass startRule){
		URI uri = URI.createURI("temp.java");
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(fragment.getBytes());
		Map<?, ?> typeOption = Collections.singletonMap(IJavaOptions.RESOURCE_CONTENT_TYPE, startRule);
		try {
			resource.load(inputStream, typeOption );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resource.getContents();
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
}
