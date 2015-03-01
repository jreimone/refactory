package org.modelrefactoring.guery.test;

import org.emftext.language.refactoring.roles.RoleModel;
import org.modelrefactoring.matching.guery.RoleModel2MotifConverter;

public class RoleModel2MotifConverterWithoutOptionalRoles extends RoleModel2MotifConverter {

	public RoleModel2MotifConverterWithoutOptionalRoles(RoleModel roleModel) {
		super(roleModel);
	}

	@Override
	protected boolean useNonOptionalRolesOnly() {
		return true;
	}
	
//	protected boolean addMotifsWithoutOptionalRolesCombinations() {
//		return false;
//	}
}
