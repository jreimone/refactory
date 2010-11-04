package org.emftext.refactoring.mappings.ecore.facade;

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
public class EcoreRefactoringFacade {
	
	private Resource resource;
	private List<EObject> selectedElement;
	private Map<String, RoleMapping> mappingMap;
	private IRefactorer refactorer;
	
	public EcoreRefactoringFacade(Resource resource, List<EObject> selectedElement){
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
	 * Returns the {@link RoleMapping} with name 'DeriveCompositeInterface'.
	 * 
	 * @return
	 */
	public RoleMapping getDeriveCompositeInterfaceMapping(){
		return mappingMap.get("DeriveCompositeInterface");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'DeriveCompositeInterface'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getDeriveCompositeInterfaceIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getDeriveCompositeInterfaceMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'ExtractEEnum'.
	 * 
	 * @return
	 */
	public RoleMapping getExtractEEnumMapping(){
		return mappingMap.get("ExtractEEnum");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'ExtractEEnum'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getExtractEEnumIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getExtractEEnumMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'ExtractInterfaceFromFeatures'.
	 * 
	 * @return
	 */
	public RoleMapping getExtractInterfaceFromFeaturesMapping(){
		return mappingMap.get("ExtractInterfaceFromFeatures");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'ExtractInterfaceFromFeatures'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getExtractInterfaceFromFeaturesIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getExtractInterfaceFromFeaturesMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'ExtractInterfaceFromOperations'.
	 * 
	 * @return
	 */
	public RoleMapping getExtractInterfaceFromOperationsMapping(){
		return mappingMap.get("ExtractInterfaceFromOperations");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'ExtractInterfaceFromOperations'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getExtractInterfaceFromOperationsIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getExtractInterfaceFromOperationsMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'ExtractSubEPackage'.
	 * 
	 * @return
	 */
	public RoleMapping getExtractSubEPackageMapping(){
		return mappingMap.get("ExtractSubEPackage");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'ExtractSubEPackage'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getExtractSubEPackageIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getExtractSubEPackageMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'ExtractSuperClass'.
	 * 
	 * @return
	 */
	public RoleMapping getExtractSuperClassMapping(){
		return mappingMap.get("ExtractSuperClass");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'ExtractSuperClass'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getExtractSuperClassIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getExtractSuperClassMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'GeneralizeDeclaredType'.
	 * 
	 * @return
	 */
	public RoleMapping getGeneralizeDeclaredTypeMapping(){
		return mappingMap.get("GeneralizeDeclaredType");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'GeneralizeDeclaredType'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getGeneralizeDeclaredTypeIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getGeneralizeDeclaredTypeMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'IntroduceParameterObject'.
	 * 
	 * @return
	 */
	public RoleMapping getIntroduceParameterObjectMapping(){
		return mappingMap.get("IntroduceParameterObject");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'IntroduceParameterObject'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getIntroduceParameterObjectIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getIntroduceParameterObjectMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'PullUpFeature'.
	 * 
	 * @return
	 */
	public RoleMapping getPullUpFeatureMapping(){
		return mappingMap.get("PullUpFeature");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'PullUpFeature'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getPullUpFeatureIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getPullUpFeatureMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'RenameEElement'.
	 * 
	 * @return
	 */
	public RoleMapping getRenameEElementMapping(){
		return mappingMap.get("RenameEElement");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'RenameEElement'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getRenameEElementIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getRenameEElementMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'ReplaceInheritanceWithDelegation'.
	 * 
	 * @return
	 */
	public RoleMapping getReplaceInheritanceWithDelegationMapping(){
		return mappingMap.get("ReplaceInheritanceWithDelegation");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'ReplaceInheritanceWithDelegation'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getReplaceInheritanceWithDelegationIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getReplaceInheritanceWithDelegationMapping());
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'UseSuperTypeWherePossible'.
	 * 
	 * @return
	 */
	public RoleMapping getUseSuperTypeWherePossibleMapping(){
		return mappingMap.get("UseSuperTypeWherePossible");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'UseSuperTypeWherePossible'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getUseSuperTypeWherePossibleIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getUseSuperTypeWherePossibleMapping());
	}
	
}
