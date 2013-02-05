package org.emftext.refactoring.ltk;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class ModelRefactoringDescriptor extends RefactoringDescriptor {

	private IRefactorer refactorer;
	private RoleMapping roleMapping;
	private ModelRefactoring modelRefactoring;
	
	private ModelRefactoringDescriptor(String id, String project, String description, String comment, int flags) {
		super(id, project, description, comment, flags);
	}
	
	public ModelRefactoringDescriptor(IRefactorer refactorer, ModelRefactoring modelRefactoring) {
		this(generateID(refactorer),
				getProjectID(refactorer),
				generateDescription(refactorer),
				generateComment(refactorer),
				generateFlags());
		setTimeStamp(System.currentTimeMillis());
		this.refactorer = refactorer;
		this.roleMapping = refactorer.getRoleMapping();
		this.modelRefactoring = modelRefactoring;
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
		for (EObject selectedElement : selectedElements) {
			comment += "\n\t" + selectedElement;
		}
		comment += "\n- has the following generic description: " + roleMapping.getMappedRoleModel().getComment();
		return comment;
	}

	public static String generateDescription(IRefactorer refactorer) {
		RoleMapping roleMapping = refactorer.getRoleMapping();
		String description = roleMapping.getName() + " (" + roleMapping.getOwningMappingModel().getTargetMetamodel().getNsURI() + ")";
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
		IConfigurationElement element = IRoleMappingRegistry.INSTANCE.getContributorForRoleMapping(roleMapping);
		String id = element.getContributor().getName() + "." + roleMapping.getName().replace(" ", "");
		return id;
	}

	@Override
	public Refactoring createRefactoring(RefactoringStatus status) throws CoreException {
		if(status.isOK()){
			return new ModelRefactoring(refactorer, modelRefactoring.getDiagramTransactionalEditingDomain(), modelRefactoring.getName(), modelRefactoring.getActiveEditor());
		}
		return null;
	}

	public RoleMapping getRoleMapping() {
		return roleMapping;
	}

	public IRefactorer getRefactorer() {
		return refactorer;
	}

}
