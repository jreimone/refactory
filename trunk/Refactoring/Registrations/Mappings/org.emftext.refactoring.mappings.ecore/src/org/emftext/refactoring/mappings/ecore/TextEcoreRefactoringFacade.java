package org.emftext.refactoring.mappings.ecore;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

/**
 * Provides a facade for simpler access to the registered {@link RoleMapping}s for
 * the metamodel: http://www.emftext.org/language/roles.<br>
 * For every registered mapping two methods are contained in this facade:
 * <li> a method for returning the {@link RoleMapping} itself
 * <li> a method for returning the registered icon if one exists
 * <br>
 * @author jreimann
 *
 */
public class TextEcoreRefactoringFacade {

	private Resource resource;
	private List<? extends EObject> selectedElement;
	private Map<String, RoleMapping> mappingMap;
	private IRefactorer refactorer;
	

	public TextEcoreRefactoringFacade(Resource resource, List<? extends EObject> selectedElement){
		super();
		this.resource = resource;
		this.selectedElement = selectedElement;
		initialize();
	}
	
	private void initialize() {
		mappingMap = new LinkedHashMap<String, RoleMapping>();
		refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
		if(refactorer != null){
			refactorer.setInput(selectedElement);
			List<RoleMapping> mappings = refactorer.getPossibleRoleMappings(1.0);
			for (RoleMapping roleMapping : mappings) {
				mappingMap.put(roleMapping.getName(), roleMapping);
			}
		}
	}
	
	public IRefactorer getRefactorer() {
		return refactorer;
	}
	
	//// from here the methods are generated - upper part is the same
	
	/**
	 * Returns the {@link RoleMapping} with name 'ExtractSuperClass'.
	 * @return
	 */
	public RoleMapping getExtractSuperClassMapping(){
		return mappingMap.get("ExtractSuperClass");
	}
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name 'ExtractSuperClass'.
	 * @return the registered icon or null if none is registered
	 */
	public URL getExtractSuperClassIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getExtractSuperClassMapping());
	}
}
