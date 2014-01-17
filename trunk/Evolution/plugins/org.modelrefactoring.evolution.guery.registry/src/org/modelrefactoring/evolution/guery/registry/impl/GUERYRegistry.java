/**
 * 
 */
package org.modelrefactoring.evolution.guery.registry.impl;

import java.util.ArrayList;
import java.util.List;

import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifReaderException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.modelrefactoring.evolution.guery.registry.IGUERYRegistry;
import org.modelrefactoring.evolution.guery.registry.IGUERYRegistryExtensionPoint;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.io.ModelMotifReader;

/**
 * @author jreimann
 *
 */
public class GUERYRegistry implements IGUERYRegistry {

	private List<Motif<EObjectVertex, EReferenceEdge>> motifs;
	
	public GUERYRegistry(){
		motifs = new ArrayList<Motif<EObjectVertex, EReferenceEdge>>();
		initialiseRegistry();
	}
	
	private void initialiseRegistry() {
		if(Platform.isRunning()){
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] configurationElements = registry.getConfigurationElementsFor(IGUERYRegistryExtensionPoint.ID);
			for (IConfigurationElement configurationElement : configurationElements) {
				String gueryFileString = configurationElement.getAttribute(IGUERYRegistryExtensionPoint.ATT_GUERY_FILE);
				String pluginID = configurationElement.getContributor().getName();
				
				ResourceSet rs = new ResourceSetImpl();
				URI uri = URI.createPlatformPluginURI(pluginID + "/" + gueryFileString, true);
				Resource motifResource = rs.getResource(uri, true);
				EObject model = motifResource.getContents().get(0);
				assert model instanceof MotifModel;
				MotifModel motifModel = (MotifModel) model;
				List<org.modelrefactoring.guery.Motif> modelMotifs = motifModel.getMotifs();
				for (org.modelrefactoring.guery.Motif modelMotif : modelMotifs) {
					ModelMotifReader<EObjectVertex> reader = new ModelMotifReader<EObjectVertex>(modelMotif);
					try {
						Motif<EObjectVertex, EReferenceEdge> motif = reader.read(null);
						if(motif != null){
							motifs.add(motif);
						}
					} catch (MotifReaderException e) {
						e.printStackTrace();
					}
				}
//				Bundle bundle = Platform.getBundle(pluginID);
//				URL motifUrl = bundle.getEntry(gueryFileString);
//				try {
//					if(motifUrl != null){
//						InputStream stream = motifUrl.openStream();
//						MotifReader<EObjectVertex, EReferenceEdge> reader = new DefaultMotifReader<EObjectVertex, EReferenceEdge>();
//						Motif<EObjectVertex, EReferenceEdge> motif = reader.read(stream);
//						if(motif != null){
//							motifs.add(motif);
//						}
//						stream.close();
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (MotifReaderException e) {
//					e.printStackTrace();
//				}
			}
		}
	}

	@Override
	public void registerMotif(Motif<EObjectVertex, EReferenceEdge> motif) {
		if(!motifs.contains(motif)){
			motifs.add(motif);
		}
	}

	@Override
	public List<Motif<EObjectVertex, EReferenceEdge>> getRegisteredMotifs() {
		return motifs;
	}

}
