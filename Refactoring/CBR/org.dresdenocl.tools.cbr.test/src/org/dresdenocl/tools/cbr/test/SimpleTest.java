package org.dresdenocl.tools.cbr.test;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.dresdenocl.tools.cbr.MinzincGenerator;
import org.junit.Test;

import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.ecore.EcoreModelInstanceTypePlugin;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceObject;
import tudresden.ocl20.pivot.pivotmodel.Type;

public class SimpleTest extends AbstractMinzingTest {

	@Test
	public void testGenerator01() throws Exception {

		File instanceFile = getFile(MODEL_INSTANCE01_NAME);
		IModelInstance testModelInstance = ModelBusPlugin
				.getModelInstanceTypeRegistry()
				.getModelInstanceType(EcoreModelInstanceTypePlugin.PLUGIN_ID)
				.getModelInstanceProvider()
				.getModelInstance(instanceFile, testModel);

		/* Select objects for compilation. */
		Set<IModelInstanceObject> affectedObjects = new HashSet<IModelInstanceObject>();

		/* Add classes. */
		Set<Type> affectedTypes = new HashSet<Type>();
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "Class" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "Operation" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "Generalization" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "Interaction" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "Property" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "Type" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "Lifeline" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "ConnectableElement" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "MessageOccurrenceSpecification" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "Event" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "Message" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "MessageEnd" })));
//		afftectedTypes.add(testModel.findType(Arrays.asList(new String[] {
//				"root", "uml", "CallEvent" })));
//
//		for (Type type : afftectedTypes) {
//			affectedObjects.addAll(testModelInstance.getAllInstances(type));
//		}

		affectedObjects.addAll(testModelInstance.getAllModelInstanceObjects());
		affectedTypes.addAll(testModelInstance.getAllImplementedTypes());
		
		/* Start compiler. */
		MinzincGenerator generator = new MinzincGenerator();
		String result = generator.compileModelInstance(testModelInstance,
				affectedObjects, affectedTypes);

		System.out.println(result);
		// compareStringAndFile("resources/output/simpleTest.mzn", result);

		// TODO How to filter further properties?
		// TODO Which elements are vars?
		// TODO Are cross-references valid in MiniZinc?
	}
}
