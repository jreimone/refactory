/**
 * 
 */
package org.qualitune.evolution.guery.registry.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifReader;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.io.dsl.DefaultMotifReader;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.qualitune.evolution.guery.registry.EObjectVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;
import org.qualitune.evolution.guery.registry.IGUERYRegistry;
import org.qualitune.evolution.guery.registry.IGUERYRegistryExtensionPoint;

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
			MotifReader<EObjectVertex, EReferenceEdge> reader = new DefaultMotifReader<EObjectVertex, EReferenceEdge>();
			for (IConfigurationElement configurationElement : configurationElements) {
				String gueryFileString = configurationElement.getAttribute(IGUERYRegistryExtensionPoint.ATT_GUERY_FILE);
				String pluginID = configurationElement.getContributor().getName();
				Bundle bundle = Platform.getBundle(pluginID);
				URL motifUrl = bundle.getEntry(gueryFileString);
				try {
					InputStream stream = motifUrl.openStream();
					Motif<EObjectVertex, EReferenceEdge> motif = reader.read(stream);
					if(motif != null){
						motifs.add(motif);
					}
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (MotifReaderException e) {
					e.printStackTrace();
				}
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
