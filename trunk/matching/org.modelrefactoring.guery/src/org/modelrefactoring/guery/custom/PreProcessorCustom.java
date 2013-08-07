package org.modelrefactoring.guery.custom;

import org.modelrefactoring.guery.impl.PreProcessorImpl;


public class PreProcessorCustom extends PreProcessorImpl {

//	/**
//	 * @model
//	 */
//	public Class<?> getProcessorClass() {
//		if(Platform.isRunning()){
//			URI uri2 = EcoreUtil.getURI(container);
//			Resource resource = container.eResource();
//			if(resource != null){
//				URI uri = resource.getURI();
//				if(uri.isPlatformResource()){
//					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
//					IFile file = root.getFile(new Path(uri.toPlatformString(true)));
//					if(file != null && file.exists()){
//						IProject project = file.getProject();
//						if(project != null && project.exists()){
//							IJavaProject javaProject = (IJavaProject) project.getAdapter(IJavaProject.class);
//							if(javaProject != null){
//								String id1 = javaProject.getElementName();
//								String id2 = javaProject.getHandleIdentifier();
////								Platform.getBundle(javaProject.get)
//								try {
//									IType type = javaProject.findType(lexem);
//									if(type != null){
//										IClassFile classFile = type.getClassFile();
//										IJavaModel javaModel = classFile.getJavaModel();
//										//									JavaCore.getClasspathContainer(containerPath, project)
//										System.out.println();
//									}
//								} catch (JavaModelException e) {
//									result.setErrorMessage("Class '" + lexem + "' couldn't be loaded");
//								}
//							}
//						}
//					}
//				}
//			}
//		} else {
//			try {
//				ClassLoader classLoader = this.getClass().getClassLoader();
//				Class<?> clazz = classLoader.loadClass(getProcessorClassName());
//				if(Processor.class.isAssignableFrom(clazz)){
//					result.setResolvedToken(clazz);
//				} else {
//					result.setErrorMessage("Class '" + lexem + "' could be loaded but doesn't implement " + Processor.class.getCanonicalName());
//				}
//			} catch (ClassNotFoundException e) {			
//				result.setErrorMessage("Class '" + lexem + "' couldn't be loaded");
//				//	By default token resolving is delegated to the DefaultTokenResolver.
//				//			defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
//			}
//		}
//		return null;
//	}
}