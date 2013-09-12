package org.modelrefactoring.guery.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import nz.ac.massey.cs.guery.MotifInstance;

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingPrinter2;
import org.emftext.language.refactoring.roles.RoleModel;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;
import org.modelrefactoring.matching.guery.MotifInstance2RoleMappingConverter;

public class CountAndPrintResultListener extends MotifInstance2RoleMappingConverter {

	private int count = 0;
	private int maxResultCount;

	public CountAndPrintResultListener(RoleModel roleModel, int maxResultCount) {
		super(roleModel, maxResultCount);
		this.maxResultCount = maxResultCount;
	}

	@Override
	public boolean found(MotifInstance<MetamodelVertex, EReferenceEdge> instance) {
		count++;
		System.out.println(count);
		RoleMapping roleMapping = createRoleMapping(instance);
		String string = printRoleMapping(roleMapping);
		System.out.println(string);
//		System.out.println();
		if(count == maxResultCount){
			return false;
		}
		return true;
	}

	private String printRoleMapping(RoleMapping roleMapping) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		RolemappingPrinter2 printer = new RolemappingPrinter2(out, null);
		try {
			printer.print(roleMapping);
			out.close();
			return out.toString().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getFoundRoleMappingsCount(){
		return count;
	}
}
