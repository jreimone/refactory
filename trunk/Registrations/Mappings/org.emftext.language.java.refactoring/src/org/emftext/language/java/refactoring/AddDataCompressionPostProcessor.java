package org.emftext.language.java.refactoring;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

public class AddDataCompressionPostProcessor extends AbstractRefactoringPostProcessor {

	private static final String COMPRESSION_METHOD	=
			"\n\n\tprivate static File gzipFile(File uncompressedFile){\n" +
			"\t\ttry {\n" +
			"\t\t\tassert uncompressedFile != null && uncompressedFile.exists();\n" +
			"\t\t\tFile gzippedFile = File.createTempFile(uncompressedFile.getName(), \"gz\");\n" +
			"\t\t\tFileInputStream fis = new FileInputStream(uncompressedFile);\n" +
			"\t\t\tGZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(gzippedFile));\n" +
			"\t\t\tbyte[] buffer = new byte[4096];\n" +
			"\t\t\tint bytesRead;\n" +
			"\t\t\twhile ((bytesRead = fis.read(buffer)) != -1){\n" +
			"\t\t\t\tout.write(buffer, 0, bytesRead);\n" +
			"\t\t\t}\n" +
			"\t\t\tfis.close();\n" +
			"\t\t\tout.close();\n" +
			"\t\t\treturn gzippedFile;\n" +
			"\t\t} catch (FileNotFoundException e) {\n" +
			"\t\t\te.printStackTrace();\n" +
			"\t\t} catch (IOException e) {\n" +
			"\t\t\te.printStackTrace();\n" +
			"\t\t}\n" +
			"\t\treturn null;\n" +
			"\t}";
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		NewConstructorCall newConstructorCall = RoleUtil.getFirstObjectForRole("Selection", NewConstructorCall.class, roleRuntimeInstanceMap);
		EObject container = newConstructorCall.eContainer();
		while (container != null && !(container instanceof CompilationUnit)) {
			container = container.eContainer();
		}
		if(container == null){
			return Status.OK_STATUS;
		}
		CompilationUnit compUnit = (CompilationUnit) container;
		org.emftext.language.java.classifiers.Class clazz = compUnit.getContainedClass();
		List<ClassMethod> methods = new ArrayList<ClassMethod>(clazz.getChildrenByType(ClassMethod.class));
		ClassMethod zippingMethod = parsePartialFragment(COMPRESSION_METHOD, MembersPackage.Literals.CLASS_METHOD, ClassMethod.class).get(0);
		clazz.getMembers().add(zippingMethod);
		boolean methodExists = false;
		for (ClassMethod classMethod : methods) {
			if(EcoreUtil.equals(zippingMethod, classMethod)){
				methodExists = true;
				break;
			}
		}
		if(methodExists){
			clazz.getMembers().remove(zippingMethod);
		}
		List<Expression> arguments = new ArrayList<Expression>(newConstructorCall.getArguments());
		for (Expression expression : arguments) {
			MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			int index = newConstructorCall.getArguments().indexOf(expression);
			newConstructorCall.getArguments().add(index, methodCall);
			methodCall.setTarget(zippingMethod);
			methodCall.getArguments().add(expression);
		}
		return Status.OK_STATUS;
	}

	/**
	 * Parses the given <code>fragment</code> and returns the according model elements.
	 * The parameter <code>startRule</code> specifies the {@link EClass} which should be the starting rule.
	 * 
	 * @param fragment
	 * @param startRule
	 * @return
	 */
	public static<RuleType extends EObject> List<RuleType> parsePartialFragment(String fragment, EClass startRule, Class<RuleType> type){
		URI uri = URI.createURI("temp.java");
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(fragment.getBytes());
		Map<?, ?> typeOption = Collections.singletonMap(IJavaOptions.RESOURCE_CONTENT_TYPE, startRule);
		try {
			resource.load(inputStream, typeOption);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<RuleType> result = new ArrayList<RuleType>();
		for (EObject parseResult : resource.getContents()) {
			if(type.isInstance(parseResult)){
				result.add(type.cast(parseResult));
			}
		}
		return result;
	}
}
