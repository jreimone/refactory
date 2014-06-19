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

public class CountAndPrintResultListener2 extends MotifInstance2RoleMappingConverter implements AdditionalListenerInvocator{

	private int count = 0;
	private int maxResultCount;
	private int queryCycleCount;
	private int currentQueryCycle = 0;
	
	private List<AdditionalResultListener> additionalListeners;

	public CountAndPrintResultListener2(RoleModel roleModel, int maxResultCount, int queryCycleCount) {
		super(roleModel, maxResultCount);
		this.maxResultCount = maxResultCount;
		additionalListeners = new ArrayList<AdditionalResultListener>();
		this.queryCycleCount = queryCycleCount;
	}

	@Override
	public boolean found(MotifInstance<MetamodelVertex, EReferenceEdge> instance) {
		count++;
		if(count == maxResultCount){
			return false;
		}
		System.out.println(count);
		RoleMapping roleMapping = createRoleMapping(instance);
//		String string = printRoleMapping(roleMapping);
//		System.out.println(string);
//		System.out.println();
		for (AdditionalResultListener listener : additionalListeners) {
			listener.found(roleMapping);
		}
		return true;
	}

	@Override
	public void done() {
		super.done();
		currentQueryCycle++;
		System.out.println(currentQueryCycle + ". done");
		if(currentQueryCycle == queryCycleCount){
			System.out.println("= final done");
			for (AdditionalResultListener listener : additionalListeners) {
				listener.done();
			}
		}
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
