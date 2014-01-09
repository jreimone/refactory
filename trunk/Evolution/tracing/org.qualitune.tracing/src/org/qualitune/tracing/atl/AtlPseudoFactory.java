/**
 * 
 */
package org.qualitune.tracing.atl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.qualitune.tracing.util.VUtil;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class AtlPseudoFactory {
	
	IModel atlCreator;
	IReferenceModel atlMetamodel;
	
	public AtlPseudoFactory(IModel atlCreator, IReferenceModel atlMetamodel) {
		super();
		this.atlCreator = atlCreator;
		this.atlMetamodel = atlMetamodel;
	}
	
	public EObject createModelElement(String type) {
		EObject metaElement = (EObject) atlMetamodel.getMetaElementByName(type);
		if (metaElement == null)
			VUtil.myExit("Can't create ATL model element (instance) of type (metamodel entity) " + type + 
					"(looks like the type does not exist in ATL)");
		
		EObject newModelElement = (EObject) atlCreator.newElement(metaElement);
		if (newModelElement == null)
			VUtil.myExit("Can't create ATL model element (instance) of type (metamodel entity) " + type + 
					"but type seems to be known to ATL");

		return newModelElement;
	}
}
