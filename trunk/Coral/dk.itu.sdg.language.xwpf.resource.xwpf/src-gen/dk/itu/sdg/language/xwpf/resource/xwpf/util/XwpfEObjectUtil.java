/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.util;

/**
 * A utility class that can be used to work with EObjects. While many similar
 * methods are provided by EMF's own EcoreUtil class, the missing ones are
 * collected here.
 * 
 * @see org.eclipse.emf.ecore.util.EcoreUtil
 */
public class XwpfEObjectUtil {
	
	public static <T> java.util.Collection<T> getObjectsByType(java.util.Iterator<?> iterator, org.eclipse.emf.ecore.EClassifier type) {
		java.util.Collection<T> result = new java.util.ArrayList<T>();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			if (type.isInstance(object)) {
				@SuppressWarnings("unchecked")				
				T t = (T) object;
				result.add(t);
			}
		}
		return result;
	}
	
	/**
	 * Use EcoreUtil.getRootContainer() instead.
	 */
	@Deprecated	
	public static org.eclipse.emf.ecore.EObject findRootContainer(org.eclipse.emf.ecore.EObject object) {
		org.eclipse.emf.ecore.EObject container = object.eContainer();
		if (container != null) {
			return findRootContainer(container);
		} else {
			return object;
		}
	}
	
	public static Object invokeOperation(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EOperation o) {
		java.lang.reflect.Method method;
		try {
			method = element.getClass().getMethod(o.getName(), new Class[]{});
			if (method != null) {
				Object result = method.invoke(element, new Object[]{});
				return result;
			}
		} catch (SecurityException e) {
			new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logError("Exception while matching proxy URI.", e);
		} catch (NoSuchMethodException e) {
			new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logError("Exception while matching proxy URI.", e);
		} catch (IllegalArgumentException e) {
			new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logError("Exception while matching proxy URI.", e);
		} catch (IllegalAccessException e) {
			new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logError("Exception while matching proxy URI.", e);
		} catch (java.lang.reflect.InvocationTargetException e) {
			new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logError("Exception while matching proxy URI.", e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")	
	public static void setFeature(org.eclipse.emf.ecore.EObject object, org.eclipse.emf.ecore.EStructuralFeature eFeature, Object value, boolean clearIfList) {
		int upperBound = eFeature.getUpperBound();
		if (upperBound > 1 || upperBound < 0) {
			Object oldValue = object.eGet(eFeature);
			if (oldValue instanceof java.util.List<?>) {
				java.util.List<Object> list = (java.util.List<Object>) oldValue;
				if (clearIfList) {
					list.clear();
				}
				list.add(value);
			} else {
				assert false;
			}
		} else {
			object.eSet(eFeature, value);
		}
	}
	
	/**
	 * Returns the depth of the given element in the containment tree.
	 */
	public static int getDepth(org.eclipse.emf.ecore.EObject element) {
		org.eclipse.emf.ecore.EObject parent = element.eContainer();
		if (parent == null) {
			return 0;
		} else {
			return getDepth(parent) + 1;
		}
	}
	
	/**
	 * Returns the value of the given feature. If the feature is a list, the list item
	 * at the given index is returned. Proxy objects are resolved.
	 */
	public static Object getFeatureValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int index) {
		return getFeatureValue(eObject, feature, index, true);
	}
	
	/**
	 * Returns the value of the given feature. If the feature is a list, the list item
	 * at the given index is returned.
	 */
	public static Object getFeatureValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int index, boolean resolve) {
		// get value of feature
		Object o = eObject.eGet(feature, resolve);
		if (o instanceof java.util.List<?>) {
			java.util.List<?> list = (java.util.List<?>) o;
			o = list.get(index);
		}
		return o;
	}
	
	/**
	 * Checks whether the root container of the given object has an EAdapter that is
	 * an instance of the given class. If one is found, it is returned, otherwise the
	 * result is null.
	 */
	public static <T> T getEAdapterFromRoot(org.eclipse.emf.ecore.EObject object, Class<T> clazz) {
		org.eclipse.emf.ecore.EObject root = org.eclipse.emf.ecore.util.EcoreUtil.getRootContainer(object);
		return getEAdapter(root, clazz);
	}
	
	/**
	 * Checks whether the given object has an EAdapter that is an instance of the
	 * given class. If one is found, it is returned, otherwise the result is null.
	 */
	@SuppressWarnings("unchecked")	
	public static <T> T getEAdapter(org.eclipse.emf.ecore.EObject object, Class<T> clazz) {
		java.util.List<org.eclipse.emf.common.notify.Adapter> eAdapters = object.eAdapters();
		for (org.eclipse.emf.common.notify.Adapter adapter : eAdapters) {
			if (clazz.isInstance(adapter)) {
				return (T) adapter;
			}
		}
		return null;
	}
	
}
