package org.modelrefactoring.guery.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nz.ac.massey.cs.guery.MotifInstance;

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingPrinter2;
import org.emftext.language.refactoring.roles.RoleModel;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;
import org.modelrefactoring.matching.guery.MotifInstance2RoleMappingConverter;

public class CountAndPrintResultListener extends MotifInstance2RoleMappingConverter implements AdditionalListenerInvocator{

	private int count = 0;
	private int maxResultCount;
	private int queryIterationsCount;
	private int currentQueryIteration = 0;
	
	private List<AdditionalResultListener> additionalListeners;

	public CountAndPrintResultListener(RoleModel roleModel, int maxResultCount, int queryIterationsCount) {
		super(roleModel, maxResultCount);
		this.maxResultCount = maxResultCount;
		additionalListeners = new ArrayList<AdditionalResultListener>();
		this.queryIterationsCount = queryIterationsCount;
	}

	@Override
	public boolean found(MotifInstance<MetamodelVertex, EReferenceEdge> instance) {
		count++;
		if(count == maxResultCount){
			return false;
		}
		System.out.println(count);
		RoleMapping roleMapping = createRoleMapping(instance);
		String string = printRoleMapping(roleMapping);
		System.out.println(string);
//		System.out.println();
		for (AdditionalResultListener listener : additionalListeners) {
			listener.found(roleMapping);
		}
		return true;
	}

	@Override
	public void done() {
		super.done();
		currentQueryIteration++;
		System.out.println(currentQueryIteration + ". done");
		if(currentQueryIteration == queryIterationsCount){
			System.out.println("= final done");
			for (AdditionalResultListener listener : additionalListeners) {
				listener.done();
			}
		}
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

	@Override
	public void addListener(AdditionalResultListener listener) {
		if(!additionalListeners.contains(listener)){
			additionalListeners.add(listener);
		}
	}

	@Override
	public boolean removeListener(AdditionalResultListener listener) {
		return additionalListeners.remove(listener);
	}

	@Override
	public List<AdditionalResultListener> getAdditionalListeners() {
		return additionalListeners;
	}
}
