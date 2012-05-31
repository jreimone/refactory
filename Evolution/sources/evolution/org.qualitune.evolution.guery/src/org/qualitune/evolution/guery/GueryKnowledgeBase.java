package org.qualitune.evolution.guery;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.GQL;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifInstance;
import nz.ac.massey.cs.guery.MotifReader;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.ResultListener;
import nz.ac.massey.cs.guery.impl.MultiThreadedGQLImpl;
import nz.ac.massey.cs.guery.io.dsl.DefaultMotifReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;
import org.qualitune.evolution.guery.graph.EMFGraphAdapter;
import org.qualitune.evolution.guery.graph.EMFGraphAdapterFactory;
import org.qualitune.evolution.guery.graph.EObjectVertex;
import org.qualitune.evolution.guery.graph.EReferenceEdge;
import org.qualitune.evolution.guery.graph.IEMFGraphAdapterFactory;
import org.qualitune.evolution.registry.KnowledgeBase;

public class GueryKnowledgeBase implements KnowledgeBase {

	private EMFGraphAdapter<EObjectVertex, EReferenceEdge> graphAdapter;
	private Resource resource;
	private Map<EObject, Collection<EObject>> dependencies;

	@Override
	public Map<EObject, Collection<EObject>> getDependencies(URI uri, ResourceSet rs) {
		dependencies = new HashMap<EObject, Collection<EObject>>();
		// TODO GUERY registry erstellen und hier verwenden
		Bundle bundle = Activator.getContext().getBundle();
		URI uri2 = resource.getURI();
		String platformString = uri2.toPlatformString(true);
		IFile member3 = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		try {
			InputStream is = bundle.getEntry("inverseReferences.guery").openStream();
			//				InputStream is = new FileInputStream(gueryFile);
			MotifReader<EObjectVertex, EReferenceEdge> reader = new DefaultMotifReader<EObjectVertex, EReferenceEdge>();
			Motif<EObjectVertex, EReferenceEdge> motif = reader.read(is);
			ResultListener<EObjectVertex, EReferenceEdge> resultListener = new ResultListener<EObjectVertex, EReferenceEdge>() {

				@Override
				public boolean found(MotifInstance<EObjectVertex, EReferenceEdge> instance) {
					EObjectVertex target = instance.getVertex("target");
					addToMap(target.getModelElement());
					return true;
				}

				@Override
				public void progressMade(int progress, int total) { }

				@Override
				public void done() { }
			};
			GQL<EObjectVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<EObjectVertex, EReferenceEdge>();
			engine.query(graphAdapter, motif, resultListener, ComputationMode.ALL_INSTANCES);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MotifReaderException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return dependencies;
	}

	@Override
	public void generateKnowledge(Resource resource) {
		this.resource = resource;
		IEMFGraphAdapterFactory<EObjectVertex, EReferenceEdge> factory = new EMFGraphAdapterFactory();
		graphAdapter = new EMFGraphAdapter<EObjectVertex, EReferenceEdge>(resource, factory);
	}
	
	private void addToMap(EObject targetElement) {
		EObject model = EcoreUtil.getRootContainer(targetElement, true);
		if(model == null){
			model = targetElement;
		}
		Collection<EObject> children = dependencies.get(model);
		if(children == null){
			children = new HashSet<EObject>();
			dependencies.put(model, children);
		}
		children.add(targetElement);
	}
}
