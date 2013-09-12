package org.modelrefactoring.guery.test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import nz.ac.massey.cs.guery.MotifInstance;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingPrinter2;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;
import org.modelrefactoring.matching.guery.MotifInstance2RoleMappingConverter;

public class FileWriteResultListener extends MotifInstance2RoleMappingConverter {

	private int maxResultCount;
	private int count = 0;

	private double timeToWriteInSeconds = 0.0d;
	private int buffer = (int) Math.pow(1024, 2);
	private Writer writer;
	private File file;

	public FileWriteResultListener(RoleModel roleModel, int maxResultCount, String filePath) {
		super(roleModel, maxResultCount);
		this.maxResultCount = maxResultCount;
		initFile(filePath);
	}

	private void initFile(String filePath) {
		file = new File(filePath);
		if(file.exists()){
			file.delete();
		}		
	}

	@Override
	public boolean found(MotifInstance<MetamodelVertex, EReferenceEdge> instance) {
		count++;
		RoleMapping roleMapping = createRoleMapping(instance);
		String string = printRoleMappingSimple(roleMapping);
		if(writer == null){
			initWriter();
		}
		try {
			long start = System.currentTimeMillis();
			writer.write(string);
			long end  = System.currentTimeMillis();
			timeToWriteInSeconds += (end - start)/1000.0d;
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(count == maxResultCount){
			return false;
		}
		return true;
	}

	private void initWriter(){
		try {
			FileWriter fileWriter = new FileWriter(file);
			writer = new BufferedWriter(fileWriter, buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void done() {
		super.done();
		if(writer != null){
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public double getTimeToWriteInSeconds() {
		return timeToWriteInSeconds;
	}
	
	public int getFoundRoleMappingsCount(){
		return count;
	}
	
	public File getFile(){
		return file;
	}

	private String printRoleMappingSimple(RoleMapping roleMapping) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(roleMapping.getName() + "{");
		List<ConcreteMapping> concreteMappings = roleMapping.getRoleToMetaelement();
		for (ConcreteMapping concreteMapping : concreteMappings) {
			Role role = concreteMapping.getRole();
			EClass metaclass = concreteMapping.getMetaclass();
			buffer.append(role.getName() + ":=");
			List<EPackage> packagesOfMetaclass = concreteMapping.getPackagesOfMetaclass();
			for (EPackage package_ : packagesOfMetaclass) {
				buffer.append(package_.getName() + ".");
			}
			buffer.append(metaclass.getName());
			List<CollaborationMapping> collaborationMappings = concreteMapping.getCollaborationMappings();
			if(collaborationMappings.size() > 0){
				buffer.append("[");
				for (CollaborationMapping collaborationMapping : collaborationMappings) {
					MultiplicityCollaboration collaboration = collaborationMapping.getCollaboration();
					buffer.append(collaboration.getTargetName() + ":=");
					List<ReferenceMetaClassPair> referenceMetaClassPairs = collaborationMapping.getReferenceMetaClassPair();
					int size = referenceMetaClassPairs.size();
					for (ReferenceMetaClassPair referenceMetaClassPair : referenceMetaClassPairs) {
						EReference reference = referenceMetaClassPair.getReference();
						EClass metaClass2 = referenceMetaClassPair.getMetaClass();
						int indexOf = referenceMetaClassPairs.indexOf(referenceMetaClassPair);
						buffer.append(reference.getName() + (metaClass2 != null?":" + metaClass2.getName():"") + (indexOf + 1 == size?"":"->"));					
					}
					buffer.append(";");
				}
				buffer.append("]");
			}
			buffer.append(";");
		}
		buffer.append("}\n");
		return buffer.toString();
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
}
