package org.modelrefactoring.guery.test;

import org.emftext.language.refactoring.rolemapping.RoleMapping;

public class PreMapAdditionalListener implements AdditionalResultListener {

	@Override
	public void found(Object... something) {
		if(something != null && something[0] instanceof RoleMapping){
			RoleMapping roleMapping = (RoleMapping) something[0];
		}
	}

	@Override
	public void done() {

	}
}
