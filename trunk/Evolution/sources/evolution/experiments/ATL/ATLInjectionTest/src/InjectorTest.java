import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.engine.parser.AtlParser;


/**
 * @author jreimann
 *
 */
public class InjectorTest {
	
	public static void main(String[] args) {
		try {
			AtlParser atlInjector = new AtlParser();
			IReferenceModel atlMetamodel = atlInjector.getAtlMetamodel();
			EClass mcModule = (EClass) atlMetamodel.getMetaElementByName("Module");
			EStructuralFeature attName = mcModule.getEStructuralFeature("name");
			ModelFactory modelFactory = atlInjector.getModelFactory();
			
			EMFModel atlTrafo = (EMFModel) modelFactory.newModel(atlMetamodel);
			atlInjector.inject(atlTrafo, "in/Families2Persons.atl");
			// do some modifications in the trafo
			Resource resource = atlTrafo.getResource();
			EObject trafo = resource.getContents().get(0);
			Object oldName = trafo.eGet(attName);
			System.out.println(oldName);
			trafo.eSet(attName, "NewNameTrafo");
			// now save it
			atlInjector.extract(atlTrafo, "out/Families2PersonsNewName.atl");
		} catch (ATLCoreException e) {
			e.printStackTrace();
		}
	}
}
