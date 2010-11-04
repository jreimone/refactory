package org.emftext.language.refactoring.roles.refactoring.facade;

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
 */
public class RolesRefactoringFacade {
	
	private Resource resource;
	private List<EObject> selectedElement;
	private Map<String, RoleMapping> mappingMap;
	private IRefactorer refactorer;
	
	public RolesRefactoringFacade(Resource resource, List<EObject> selectedElement){
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
	
	/**
	 * Returns the refactorer.
	 */
	public IRefactorer getRefactorer() {
		return refactorer;
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'RenameRoleModelElement'.
	 * 
	 * @return
	 */
	public RoleMapping getRenameRoleModelElementMapping(){
		return mappingMap.get("RenameRoleModelElement");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'RenameRoleModelElement'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getRenameRoleModelElementIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getRenameRoleModelElementMapping());
	}
	
}
