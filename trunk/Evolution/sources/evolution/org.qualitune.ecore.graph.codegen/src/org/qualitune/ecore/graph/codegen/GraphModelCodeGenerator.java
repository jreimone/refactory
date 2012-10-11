/**
 * 
 */
package org.qualitune.ecore.graph.codegen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.corext.util.CodeFormatterUtil;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.java.statements.Block;
import org.emftext.language.java.statements.Return;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.java.types.Type;
import org.emftext.language.manifest.Manifest;
import org.emftext.language.manifest.ManifestFactory;
import org.emftext.language.manifest.RequireBundleDescription;
import org.qualitune.ecore.graph.GObject;
import org.qualitune.ecore.graph.impl.EObjectContainmentEListGraph;
import org.qualitune.ecore.graph.impl.EObjectResolvingEListGraph;
import org.qualitune.ecore.graph.impl.GObjectImpl;
import org.qualitune.ecore.graph.impl.GReference;

/**
 * @author jreimann
 *
 */
public class GraphModelCodeGenerator {

	private GenModel model;
	private IProject project;
	private ResourceSet rs;
	private int tabWidth;

	public void init(GenModel model) {
		if(model == null){
			return;
		}
		String pluginID = model.getModelPluginID();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginID);
		if(project == null){
			return;
		}
		IJavaProject javaProject = (IJavaProject) project.getAdapter(IJavaProject.class);
		if(javaProject != null){
			tabWidth = CodeFormatterUtil.getTabWidth(javaProject);
		} else {
			tabWidth = CodeFormatterUtil.getTabWidth(null);
		}
		this.project = project;
		this.model = model;
		genModelModifications(model);
	}

	public void generateModel() {
		if(model == null){
			return;
		}
		model.reconcile();
		model.setCanGenerate(true);
		Generator generator = new Generator();
		generator.setInput(model);
		generator.generate(model, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor());
	}

	private void genModelModifications(GenModel model) {
		model.setRootExtendsClass(GObjectImpl.class.getName());
		model.setRootExtendsInterface(GObject.class.getName());
		Resource resource = model.eResource();
		if(resource != null){
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void generateGraphModel() {
		if(model == null){
			return;
		}
		modifyManifest(project);
		modifyRootGraphClass(model);
		modifyClasses(model);
	}

	private void modifyClasses(GenModel model) {
		List<GenClass> classes = GenerationUtil.getConcreteClasses(model);
		for (GenClass genClass : classes) {
			JavaResource javaResource = GenerationUtil.getJavaResource(rs, genClass);
			CompilationUnit cu = (CompilationUnit) javaResource.getContents().get(0);
			List<GenFeature> getGenFeatures = genClass.getEGetGenFeatures();
			boolean modified = false;
			for (GenFeature feature : getGenFeatures) {
				EStructuralFeature ecoreFeature = feature.getEcoreFeature();
				if(ecoreFeature instanceof EReference){
					EReference reference = (EReference) ecoreFeature;
					if(reference.isMany()){
						if(reference.isContainment()){
							modified = replaceLists(cu, genClass, feature, EObjectContainmentEList.class.getName(), EObjectContainmentEListGraph.class.getName());
						} else {
							modified = replaceLists(cu, genClass, feature, EObjectResolvingEList.class.getName(), EObjectResolvingEListGraph.class.getName());
						}
					} else {
						String fieldName = addAttribute(cu, genClass);
						overrideEBasicSetContainer(cu, genClass, fieldName);
						modified = true;
						String type = feature.getType(genClass);
						ConcreteClassifier referenceTargetClassifier = cu.getConcreteClassifier(type);
						if(reference.isContainment()){
							ConcreteClassifier notificationChainClassifier = cu.getConcreteClassifier(NotificationChain.class.getName());
							modifySetFeatureMethod(cu, feature, "basicSet" + feature.getAccessorName(), fieldName, new Type[]{referenceTargetClassifier, notificationChainClassifier}, notificationChainClassifier);
						} else {
							modifySetFeatureMethod(cu, feature, "set" + feature.getAccessorName(), fieldName, new Type[]{referenceTargetClassifier}, null);
						}
					}
				}
			}
			if(modified){
				try {
					javaResource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void modifySetFeatureMethod(CompilationUnit cu, GenFeature feature, String methodName, String fieldName, Type[] requiredTypes, Type returnType) {
		GenClass genClass = feature.getGenClass();
		ConcreteClassifier classifier = cu.getContainedClassifier(genClass.getClassName());
		ClassMethod basicSetFeatureMethod = GenerationUtil.findMethodInClassifier(classifier, methodName, requiredTypes, returnType);
		if(basicSetFeatureMethod != null){
			String referenceTargetParamName = basicSetFeatureMethod.getParameters().get(0).getName();
			EList<Statement> statements = basicSetFeatureMethod.getStatements();
			int index = statements.size() - 1;
			Statement returnStatement = statements.get(index);
			if(!(returnStatement instanceof Return)){
				index = statements.size();
			}
			GenPackage genPackage = genClass.getGenPackage();
			String packageInterfaceName = genPackage.getPackageInterfaceName();
			String literalString = packageInterfaceName + ".Literals." + genClass.getFeatureID(feature);
			String blockString =
					"\n		GObject start = this;\n" +
					"		GObject end = " + referenceTargetParamName + ";\n" +
					"		EReference reference = " + literalString + ";\n" + 
					"		Set<GReference> outEdgesByReference = gGetOutEdgesByReference(reference);\n" + 
					"		GReference existentEdge = null;\n" +
					"		for (GReference edge : outEdgesByReference) {\n" +
					"			//if(edge.getEnd().equals(" + referenceTargetParamName + ")){\n" +
					"				existentEdge = edge;\n" +
					"			//}\n" +
					"		}\n" +
					"		if(existentEdge == null){\n" +
					"			existentEdge = new GReference(start, end, reference);\n" +
					"			gGetOutEdges().add(existentEdge);\n" +
					"			end.gGetInEdges().add(existentEdge);\n" +
					"			getEdges().add(existentEdge);\n" +
					"			if(gGraph() != null){\n" +
//					"				if(!gGraph().getEdges().contains(existentEdge)){\n" +
					"				gGraph().getEdges().add(existentEdge);\n" +
//					"				}\n" +
					"			} else {\n" +
					"				if(" + fieldName + " == null){\n" +
					"					" + fieldName + " = new Stack<GReference>();\n" +
					"				}\n" +
					"				" + fieldName + ".push(existentEdge);\n" +
					"			}\n" +
					"		} else {\n" +
					"			if(" + referenceTargetParamName + " != null){\n" + 
					"				existentEdge.setEnd(" + referenceTargetParamName + ");\n" +
					"			} else {\n" +
					"				start.gGetOutEdges().remove(existentEdge);\n" +
					"				getEdges().remove(existentEdge);\n" +
					"				gGraph().getEdges().remove(existentEdge);\n" +
					"			}\n" +
					"		}\n";
			Block block = GenerationUtil.parsePartialFragment("{" + blockString + "}", StatementsPackage.Literals.BLOCK, Block.class).get(0);
			statements.addAll(index, block.getStatements());
			ConcreteClassifier importClassifier = cu.getConcreteClassifier(EReference.class.getName());
			GenerationUtil.addImport(cu, importClassifier);
			importClassifier = cu.getConcreteClassifier(Set.class.getName());
			GenerationUtil.addImport(cu, importClassifier);
			importClassifier = cu.getConcreteClassifier(GObject.class.getName());
			GenerationUtil.addImport(cu, importClassifier);
		}
	}

	private void overrideEBasicSetContainer(CompilationUnit cu, GenClass genClass, String fieldName) {
		ConcreteClassifier classifier = cu.getContainedClassifier(genClass.getClassName());
		List<Member> members = classifier.getMembersByName("eBasicSetContainer");
		if(members == null || members.size() == 0){
			String methodString = 
					"\n\n	/**\n" +
							"	* @generated\n" +
							"	*/\n" +
							"	@Override\n" +
							"	protected void eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID) {\n" +
							"		super.eBasicSetContainer(newContainer, newContainerFeatureID);\n" +
							"		if(" + fieldName + " != null ){\n" +
							"			while (!" + fieldName + ".isEmpty()) {\n" +
							"				GReference edge = " + fieldName + ".pop();\n" +
//							"				if(!gGraph().getEdges().contains(edge)){\n" +
							"				gGraph().getEdges().add(edge);\n" +
//							"				}\n" +
							"			}\n" +
							"		}\n" +
							"	}\n\n\n";
			ClassMethod method = GenerationUtil.parsePartialFragment(methodString, MembersPackage.Literals.CLASS_METHOD, ClassMethod.class).get(0);
			classifier.getMembers().add(method);
		}
	}

	private String addAttribute(CompilationUnit cu, GenClass genClass) {
		ConcreteClassifier classifier = cu.getContainedClassifier(genClass.getClassName());
		String fieldName = "containerChildEdgesPending";
		Field field = classifier.getContainedField(fieldName);
		if(field == null){
			String fieldDeclaration = 
					"\n	/**\n" + 
							"	* @generated\n" +
							"	*/\n" +
							"	private Stack<GReference> " + fieldName + ";\n\n\n";
			field = GenerationUtil.parsePartialFragment(fieldDeclaration, MembersPackage.Literals.FIELD, Field.class).get(0);
			classifier.getMembers().add(0, field);
			ConcreteClassifier stackClass = cu.getConcreteClassifier(Stack.class.getName());
			ConcreteClassifier referenceClass = cu.getConcreteClassifier(GReference.class.getName());
			GenerationUtil.addImport(cu, referenceClass);
			GenerationUtil.addImport(cu, stackClass);
		}
		return fieldName;
	}

	private boolean replaceLists(CompilationUnit cu, GenClass genClass, GenFeature feature, String oldListName, String newListName) {
		boolean modified;
		ConcreteClassifier classifier = cu.getContainedClassifier(genClass.getClassName());
		ConcreteClassifier oldList = cu.getConcreteClassifier(oldListName);
		ConcreteClassifier newList = cu.getConcreteClassifier(newListName);
		Method method = classifier.getContainedMethod(feature.getGetAccessor());
		GenPackage genPackage = genClass.getGenPackage();
		String packageInterfaceName = genPackage.getPackageInterfaceName();
		String parameterString = packageInterfaceName + ".Literals." + genClass.getFeatureID(feature);
		IdentifierReference parameter = GenerationUtil.parsePartialFragment(parameterString, ReferencesPackage.Literals.IDENTIFIER_REFERENCE, IdentifierReference.class).get(0);
		List<Expression> parameters = new ArrayList<Expression>();
		parameters.add(parameter);
		modified = GenerationUtil.replaceConstructorInMethod(oldList, newList, method, parameters);
		return modified;
	}

	private void modifyRootGraphClass(GenModel model) {
		List<GenClass> rootClasses = GenerationUtil.getRootClasses(model);
		rs = new ResourceSetImpl();
		for (GenClass genClass : rootClasses) {
			JavaResource resource = GenerationUtil.getJavaResource(rs, genClass);
			if(resource == null){
				continue;
			}
			CompilationUnit cu = (CompilationUnit) resource.getContents().get(0);
			ConcreteClassifier importClassifier = cu.getConcreteClassifier(GObject.class.getName());
			GenerationUtil.addImport(cu, importClassifier);
			String className = genClass.getClassName();
			ConcreteClassifier clazz = cu.getContainedClassifier(className);
			String methodString = 
					"\n\n" + 
							"	/**\n" +
							"	* @generated\n" +
							"	*/\n" + 
							"	@Override\n" + 
							"	public GObject gGraph() {\n" + 
							"		return this;\n" + 
							"	}";
			ClassMethod method = GenerationUtil.parsePartialFragment(methodString, MembersPackage.Literals.CLASS_METHOD, ClassMethod.class).get(0);
			clazz.getMembers().add(method);
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void modifyManifest(IProject project) {
		IResource member = project.findMember("META-INF/MANIFEST.MF");
		if(member == null){
			return;
		}
		if(!(member instanceof IFile) || !member.exists()){
			return;
		}
		IFile manifest = (IFile) member;
		URI uri = URI.createPlatformResourceURI(manifest.getFullPath().toString(), true);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		if(resource == null){
			return;
		}
		Manifest manifestModel = (Manifest) resource.getContents().get(0);
		RequireBundleDescription description = ManifestFactory.eINSTANCE.createRequireBundleDescription();
		String symbolicName = org.qualitune.ecore.graph.Activator.getContext().getBundle().getSymbolicName();
		description.setSymbolicName(symbolicName);
		boolean found = false;
		List<RequireBundleDescription> bundleDescription = manifestModel.getRequireBundle().getRequireBundleDescription();
		for (RequireBundleDescription requireBundleDescription : bundleDescription) {
			if(requireBundleDescription.getSymbolicName().equals(symbolicName)){
				found = true;
			}
		}
		if(!found){
			bundleDescription.add(description);
		}
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public IProject getProject() {
		return project;
	}

}
