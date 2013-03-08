package org.emftext.refactoring.ltk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class ModelRefactoringDescriptor extends RefactoringDescriptor {

	protected static final String ID_SELECTED_ELEMENTS	= "selection";
	protected static final String ID_RESOURCE			= "resource";
	protected static final String ID_METAMODEL			= "metamodel";
	protected static final String ID_ROLEMAPPING		= "rolemapping";
	
	private IRefactorer refactorer;
	
	private ModelRefactoringDescriptor(String id, String project, String description, String comment, int flags) {
		super(id, project, description, comment, flags);
	}
	
	public ModelRefactoringDescriptor(IRefactorer refactorer) {
		this(generateID(refactorer),
				getProjectID(refactorer),
				generateDescription(refactorer),
				generateComment(refactorer),
				generateFlags());
		setTimeStamp(System.currentTimeMillis());
		this.refactorer = refactorer;
	}

	public static int generateFlags() {
		int flags = RefactoringDescriptor.MULTI_CHANGE | RefactoringDescriptor.STRUCTURAL_CHANGE;
		return flags;
	}

	public static String generateComment(IRefactorer refactorer) {
		RoleMapping roleMapping = refactorer.getRoleMapping();
		String comment = generateDescription(refactorer) + ":\n" +
				"- specific for the generic refactoring '" + roleMapping.getMappedRoleModel().getName() + "'\n" +
				"- executable for the language " + roleMapping.getOwningMappingModel().getTargetMetamodel().getName().toUpperCase()
				 + " (" + roleMapping.getOwningMappingModel().getTargetMetamodel().getNsURI() + ")\n" +
				"- refactored elements:";
		List<EObject> selectedElements = refactorer.getInput();
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
		for (EObject selectedElement : selectedElements) {
			String label = labelProvider.getText(selectedElement);
			comment += "\n\t" + label;
		}
		String roleMappingComment = roleMapping.getComment();
		if(roleMappingComment != null && !roleMappingComment.trim().isEmpty()){
			roleMappingComment = roleMappingComment.trim();
			if(roleMappingComment.startsWith("/*")){
				roleMappingComment = roleMappingComment.replace("/*", "");
			}
			if(roleMappingComment.endsWith("*/")){
				roleMappingComment = roleMappingComment.replace("*/", "");
			}
			roleMappingComment = roleMappingComment.trim();
			comment += "\n- has the following description: " + roleMappingComment;
		} else {
			comment += "\n- has the following generic description: " + roleMapping.getMappedRoleModel().getComment();
		}
		return comment;
	}

	public static String generateDescription(IRefactorer refactorer) {
		RoleMapping roleMapping = refactorer.getRoleMapping();
		String description = roleMapping.getName() + " in " + refactorer.getResource().getURI().lastSegment();
		return description;
	}

	public static String getProjectID(IRefactorer refactorer) {
		String projectID = null;
		IFile file = getFileFromResource(refactorer);
		IProject project = file.getProject();
		if(project != null){
			projectID = project.getName();
		}
		return projectID;
	}
	
	public static IFile getFileFromResource(IRefactorer refactorer) {
		URI uri = refactorer.getResource().getURI();
		uri = refactorer.getResource().getResourceSet().getURIConverter().normalize(uri);
		String scheme = uri.scheme();
		if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0)))
		{
			StringBuffer platformResourcePath = new StringBuffer();
			for (int j = 1, size = uri.segmentCount(); j < size; ++j)
			{
				platformResourcePath.append('/');
				platformResourcePath.append(uri.segment(j));
			}
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourcePath.toString()));
		}
		return null;
	}

	public static String generateID(IRefactorer refactorer) {
		RoleMapping roleMapping = refactorer.getRoleMapping();
		return generateRefactoringID(roleMapping);
	}

	/**
	 * Generates a unique ID for the given <code>roleMapping</code>.
	 * @param roleMapping
	 * @return
	 */
	public static String generateRefactoringID(RoleMapping roleMapping) {
		IConfigurationElement element = IRoleMappingRegistry.INSTANCE.getContributorForRoleMapping(roleMapping);
		String id = element.getContributor().getName() + "." + roleMapping.getName().replace(" ", "");
		return id;
	}

	@Override
	public Refactoring createRefactoring(RefactoringStatus status) throws CoreException {
		if(status.isOK()){
			return new ModelRefactoring(refactorer, null, refactorer.getRoleMapping().getName(), null);
		}
		return null;
	}

	public Map<String, String> getArgumentsMap(){
		Map<String, String> arguments = new HashMap<String, String>();
		List<EObject> input = refactorer.getInput();
		String selectedElements = "";
		selectedElements += EcoreUtil.getURI(input.get(0)).toString();
		if(input.size() > 1){
			for (int i = 1; i < input.size(); i++) {
				selectedElements += ";" + EcoreUtil.getURI(input.get(i)).toString();		
			}
		}
		arguments.put(ID_SELECTED_ELEMENTS, selectedElements);
		Resource resource = refactorer.getResource();
		arguments.put(ID_RESOURCE, resource.getURI().toString());
		RoleMapping roleMapping = refactorer.getRoleMapping();
		arguments.put(ID_ROLEMAPPING, roleMapping.getName());
		arguments.put(ID_METAMODEL, roleMapping.getOwningMappingModel().getTargetMetamodel().getNsURI());
		return arguments;
	}
}
