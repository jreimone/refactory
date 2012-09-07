package dk.itu.sdg.language.bombXML.resource.xml.postprocessor;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import dk.itu.sdg.language.bombXML.CDataTag;
import dk.itu.sdg.language.bombXML.Word;
import dk.itu.sdg.language.bombXML.resource.xml.IXmlOptionProvider;
import dk.itu.sdg.language.bombXML.resource.xml.IXmlOptions;
import dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessor;
import dk.itu.sdg.language.bombXML.resource.xml.IXmlResourcePostProcessorProvider;
import dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlResourceOld;

public class RemoveBombTag implements IXmlOptionProvider, IXmlResourcePostProcessorProvider, IXmlResourcePostProcessor {

	@Override
	public void process(XmlResourceOld resource) {
		
		Iterator<EObject> i = resource.getAllContents();
		while (i.hasNext()) {
			if (i instanceof Word) {
				Word wordTag = (Word) i;
				
				String newText = wordTag.getText().replaceAll("[_b0mBxMl_]", "");
				wordTag.setText(newText);
			}
			if (i instanceof CDataTag) {
				CDataTag cDataTag = (CDataTag) i;
				
				String newText = cDataTag.getContent().getText().replaceAll("[_b0mBxMl_]", "");
				cDataTag.getContent().setText(newText);
			}
		}
	}

	@Override
	public void terminate() {		
	}

	@Override
	public IXmlResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IXmlOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this); 
	} 

}
