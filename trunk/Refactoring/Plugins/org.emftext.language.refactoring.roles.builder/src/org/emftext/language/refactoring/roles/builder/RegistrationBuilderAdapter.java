package org.emftext.language.refactoring.roles.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBuilder;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextBuilderAdapter;

public class RegistrationBuilderAdapter extends RolestextBuilderAdapter {

	private IRolestextBuilder builder = new RegistrationBuilder();
	
	@Override
	public IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		return build(kind, args, monitor, builder, getProject());
	}

	
}
