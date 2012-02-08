package org.qualitune.evolution.prolog.registry.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.qualitune.evolution.prolog.registry.IPrologRegistry;
import org.qualitune.evolution.prolog.registry.IPrologRegistryExtensionPoint;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.Prolog;
import alice.tuprolog.Theory;
import alice.tuprolog.TheoryManager;

public class PrologRegistry implements IPrologRegistry {

	private static TheoryManager manager;
	private static Prolog engine;
	
	public PrologRegistry(){
		engine = new Prolog();
		manager = new TheoryManager();
		manager.initialize(engine);
		initialise();
	}
	
	private void initialise() {
		if(Platform.isRunning()){
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] configurationElements = registry.getConfigurationElementsFor(IPrologRegistryExtensionPoint.ID);
			for (IConfigurationElement configurationElement : configurationElements) {
				String prologFilePath = configurationElement.getAttribute(IPrologRegistryExtensionPoint.ATT_PROLOG_FILE);
				String pluginID = configurationElement.getContributor().getName();
				Bundle bundle = Platform.getBundle(pluginID);
				URL prologFileURL = bundle.getEntry(prologFilePath);
				try {
					InputStream stream = prologFileURL.openStream();
					// http://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner_1.html
					// \\A is the regex for the beginning which is only one in a stream
					String prologRules = new Scanner(stream).useDelimiter("\\A").next();
					prologRules += "\n\n";
					registerKnowledge(prologRules);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Theory registerKnowledge(String knowledgeBase) {
		Theory theory = null;
		try {
			theory = new Theory(knowledgeBase);
			getKnowledgeBase().append(theory);
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		}
		return theory;
	}

	@Override
	public Theory getKnowledgeBase() {
		return manager.getLastConsultedTheory();
	}

	@Override
	public Prolog getEngine() {
		return engine;
	}
}
