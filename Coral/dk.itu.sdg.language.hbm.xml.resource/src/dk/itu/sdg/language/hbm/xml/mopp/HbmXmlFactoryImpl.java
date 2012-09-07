package dk.itu.sdg.language.hbm.xml.mopp;

import org.eclipse.emf.ecore.resource.Resource;

import dk.itu.sdg.language.bombXML.impl.BombXMLFactoryImpl;

public class HbmXmlFactoryImpl extends BombXMLFactoryImpl {

	public HbmXmlFactoryImpl() {
		super();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xml", new HbmXmlResourceFactoryDelegator());
	}
}
