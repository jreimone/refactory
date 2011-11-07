package org.emftext.language.refactoring.roles.builder;

import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBuilder;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextBuilderAdapter;

public class RegistrationBuilderAdapter extends RolestextBuilderAdapter {

	private IRolestextBuilder builder = new RegistrationBuilder();
	
	@Override
	public IRolestextBuilder getBuilder() {
		return builder;
	}
}
