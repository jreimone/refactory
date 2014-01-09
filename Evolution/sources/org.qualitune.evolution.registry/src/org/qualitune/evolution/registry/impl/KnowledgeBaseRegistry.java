package org.qualitune.evolution.registry.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.qualitune.evolution.registry.IKnowledgeBaseRegistry;
import org.qualitune.evolution.registry.IKnowledgeBaseRegistryExtensionPoint;
import org.qualitune.evolution.registry.IKnowledgeBase;

public class KnowledgeBaseRegistry implements IKnowledgeBaseRegistry {

	private List<IKnowledgeBase> knowledgeBases;
	
	public KnowledgeBaseRegistry(){
		initialise();
	}
	
	private void initialise() {
		knowledgeBases = new ArrayList<IKnowledgeBase>();
		if(Platform.isRunning()){
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] configurationElements = registry.getConfigurationElementsFor(IKnowledgeBaseRegistryExtensionPoint.ID);
			for (IConfigurationElement configurationElement : configurationElements) {
				try {
					IKnowledgeBase knowledgeBase = (IKnowledgeBase) configurationElement.createExecutableExtension(IKnowledgeBaseRegistryExtensionPoint.ATT_IMPL);
					registerKnowledgeBase(knowledgeBase);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void registerKnowledgeBase(IKnowledgeBase knowledgeBase) {
		knowledgeBases.add(knowledgeBase);
	}

	@Override
	public List<IKnowledgeBase> getKnowledgeBases() {
		return knowledgeBases;
	}

}
