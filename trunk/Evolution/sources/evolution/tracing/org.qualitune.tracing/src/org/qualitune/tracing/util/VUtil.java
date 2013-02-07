/**
 * 
 */
package org.qualitune.tracing.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.qualitune.tracing.umt.IntentionEnum;
import org.qualitune.tracing.umt.UniverseType;

/**
 * @author Fabian Haensel
 *
 */
public class VUtil {

	public static String getName(EObject object) {
		EClass rootClass = object.eClass();
		
		for (EAttribute attr : rootClass.getEAllAttributes()) {
			if (attr.getName() == "name")
					return object.eGet(attr).toString();
		}
		return "unknown";
	}
	
	// prints tree
	public static void printer(EObject root, boolean recursive, int intendation)
	{
		//for (int i=0; )
		// rootClass ~= its type
		EClass rootClass = root.eClass();
		EClass metaClass = rootClass.eClass();
		
		for (EAttribute attr : rootClass.getEAllAttributes()) {
			System.out.print("attr: "
					+ attr.getName() + " : "
					+ attr.getEType().getName() + " = "
					+ root.eGet(attr));
			
			if (root.eIsSet(attr))
				System.out.println();
			else
				System.out.println(" (not set)");
		}
		
		// references = attribute which is a reference to another class/attribute?
		for (EReference ref: rootClass.getEAllReferences()) {
			System.out.println("ref: "
					+ ref.getName() + " : "
					+ ref.getEType().getName() + " = "
					+ root.eGet(ref));
		}
		
		System.out.println("Type (Metaclass): " + getName(rootClass));
		
		if (recursive) {
			System.out.println("--------- meta class --------");
			//rootClass.getEAllReferences()
			//printer(rootClass,false,0);
			for (EReference ref: metaClass.getEAllReferences()) {
				System.out.println("Mref: "
						+ ref.getName() + " : "
						+ ref.getEType().getName() + " = "
						+ rootClass.eGet(ref));
			}
			System.out.println("-----------------------------");
		}
		System.out.println();
		//root.getClass().getFields()
		
//		x = getMM(root)
//		
//		for all properties of x {
//			ph = 
//			root.eGet(property);
//		}
	}
	
	public static void printer(EObject root)
	{
		printer(root,false,0);
	}

	/*
	 *  Assertions and notifications to the user
	 */
	
	public static void myExit(String msg) {
		System.err.println("[VAPODI] An error has occured: " + msg);
		System.err.println("This is an internal error. Likely you can't do much about it.");
		new Throwable("Printing stacktrace").printStackTrace();
		
		System.exit(1);
	}
	
	public static void shouldBe(boolean condition, String msg) {
		if (! condition)
			 warning (msg);
	}
	
	public static void warning(String msg) {
		System.err.println("[VAPODI] Warning: " + msg + "\n(I do not know " + 
				"how to handle this issue and and ignore it. This might lead to unexpected " +
				"outcomes or simply do what is expected. " +
				"Processing is continued. Check your results carefully.)");
	}
	
	/*
	 *  Data Access (comfort functions)
	 */
	
	public static String typeName(EObject object) {
		return object.eClass().getName();
	}
	
	public static boolean hasAttribute(EObject object, String name) {
		for (EAttribute candidate : object.eClass().getEAllAttributes())
			if (candidate.getName().equals(name))
				return true;
		return false;
	}
	
	public static EAttribute getAttribute(EObject object, String name) {
		for (EAttribute candidate : object.eClass().getEAllAttributes())
			if (candidate.getName().equals(name))
				return candidate;
		
		myExit("metaclass " + object.getClass().getName() + " does not haven an " +
				"EAttribute named '" + name + "'");
		return null;
	}
	
	public static EReference getReference(EObject object, String name) {
		for (EReference candidate : object.eClass().getEAllReferences())
			if (candidate.getName().equals(name))
				return candidate;
		
		myExit("metaclass " + object.getClass().getName() + " does not haven an " +
				"EReference named '" + name + "'");
		return null;
	}

	public static  EStructuralFeature getStructuralFeature(EObject object, String name) {
		for (EStructuralFeature candidate : object.eClass().getEAllStructuralFeatures())
			if (candidate.getName().equals(name))
				return candidate;
		
		myExit("object's metaclass does not haven an EStructuralFeature named '" + name + "'");
		return null;
	}
	
	public static String getStringAttributeValue(EObject object, String attributeName) {
		EAttribute eAttribute = getAttribute(object,attributeName);
		Object value = object.eGet(eAttribute);
		assert value.getClass().getName().equals("java.lang.String") : 
			"Type of attribute '" + attributeName + "' is " + value.getClass().getName() +
			", expecting java.lang.String";
		
		return ((String)value).toString();
	}
	
	public static boolean getBooleanAttributeValue(EObject object, String attributeName) {
		EAttribute eAttribute = getAttribute(object,attributeName);
		Object value = object.eGet(eAttribute);
		assert value.getClass().getName().equals("java.lang.Boolean") :
			"Type of attribute '" + attributeName + "' is " + value.getClass().getName() +
			", expecting java.lang.Boolean";
		
		return ((Boolean) value).booleanValue();
	}
	
	@SuppressWarnings("unchecked")
	public static EcoreEList<EObject> getRefCollection(EObject object, String refName) {
		EReference ref = getReference(object, refName);
		
		assert ref.isMany();
		EcoreEList<EObject> value = (EcoreEList<EObject>) object.eGet(ref);
		if (value == null)
			return null;		
		assert value.getClass().getName().equals("org.eclipse.emf.ecore.util.EcoreEList$Dynamic") :
			"Type of attribute '" + refName + "' is " + value.getClass().getName() +
			", expecting org.eclipse.emf.ecore.util.EcoreEList$Dynamic";
		
		return value;
	}
	
	public static EObject getRefTarget(EObject object, String refName) {
		EReference ref = getReference(object, refName);
		assert ! ref.isMany();
		EObject value = (EObject) object.eGet(ref);
		if (value == null)
			return null;		
		assert value.getClass().getName().equals("org.eclipse.emf.ecore.impl.DynamicEObjectImpl") :
			"Type of attribute '" + refName + "' is " + value.getClass().getName() +
			", org.eclipse.emf.ecore.impl.DynamicEObjectImpl ";
		
		return value;
	}
	
	public static boolean isSet(EObject object, String featureName) {
		EStructuralFeature feature = getStructuralFeature(object,featureName);
		return object.eIsSet(feature);
	}
	
	public static void unSetAttribute(EObject object, String attributeName) {
		EAttribute eAttribute = getAttribute(object,attributeName);
		object.eUnset(eAttribute);
	}
	
	public static void setAttribute(EObject object, String attributeName, String value) {
		EAttribute eAttribute = getAttribute(object,attributeName);
		assert ! eAttribute.isMany() : 
			"Multiplicity of attribute '" + attributeName + "' is many, "+
			"expecting solitary.";
		assert value.getClass().getName().equals("java.lang.String") : 
			"Type of attribute '" + attributeName + "' is " + value.getClass().getName() +
			", expecting java.lang.String";
		object.eSet(eAttribute, value);
	}
	
	public static void setAttribute(EObject object, String attributeName, IntentionEnum value) {
		EAttribute eAttribute = getAttribute(object,attributeName);
		assert ! eAttribute.isMany() : 
			"Multiplicity of attribute '" + attributeName + "' is many, "+
			"expecting solitary.";
		assert value.getClass().getName().equals("org.qualitune.tracing.umt.IntentionEnum") : 
			"Type of attribute '" + attributeName + "' is " + value.getClass().getName() +
			", org.qualitune.tracing.umt.IntentionEnum";
		object.eSet(eAttribute, value);
	}
	
	public static void setAttribute(EObject object, String attributeName, UniverseType value) {
		EAttribute eAttribute = getAttribute(object,attributeName);
		assert ! eAttribute.isMany() : 
			"Multiplicity of attribute '" + attributeName + "' is many, "+
			"expecting solitary.";
		assert value.getClass().getName().equals("org.qualitune.tracing.umt.UniverseType") : 
			"Type of attribute '" + attributeName + "' is " + value.getClass().getName() +
			", org.qualitune.tracing.umt.UniverseType";
		object.eSet(eAttribute, value);
	}
	
	// mult String
	public static void setAttribute(EObject object, String attributeName, List<String> value) {
		EAttribute eAttribute = getAttribute(object,attributeName);
		assert eAttribute.isMany() : 
			"Multiplicity of attribute '" + attributeName + "' is solitary, "+
			"expecting many.";
		object.eSet(eAttribute, value);
	}
	
	public static void setReference(EObject object, EReference ref, Object value) {
		assert ! ref.isMany() :
			"Multiplicity of reference '" + ref.getName() + "' is many, "+
			"expecting solitary.";
		object.eSet(ref, value);
	}
	
	public static void setReference(EObject object, String refName, Object value) {
		EReference ref = getReference(object, refName);
		setReference(object, ref, value);
	}
	
	public static void setReference(EObject object, String refName, List<Object> value) {
		EReference ref = getReference(object, refName);
		assert ref.isMany() :
			"Multiplicity of reference '" + refName + "' is solitary, "+
			"expecting many.";
		object.eSet(ref, value);
	}
	
	public static void addtoReference(EObject object, String refName, List<EObject> value) {
		EReference ref = getReference(object, refName);
		assert ref.isMany() :
			"Multiplicity of reference '" + refName + "' is solitary, "+
			"expecting many.";
		
		@SuppressWarnings("unchecked")
		List<EObject> currentValue = (List<EObject>) object.eGet(ref);
		if (currentValue == null) {
			currentValue = new LinkedList<EObject>();
			object.eSet(ref, currentValue);
		}

		currentValue.addAll(value);
	}
	
	public static void addtoReference(EObject object, String refName, EObject value) {
		EReference ref = getReference(object, refName);
		assert ref.isMany() :
			"Multiplicity of reference '" + refName + "' is solitary, "+
			"expecting many.";
		
		addtoReference(object, ref, value);
	}
	
	public static void addtoReference(EObject object, EReference ref, EObject value) {
		assert ref.isMany() :
			"Multiplicity of reference '" + ref.getName() + "' is solitary, "+
			"expecting many.";
		
		@SuppressWarnings("unchecked")
		List<EObject> currentValue = (List<EObject>) object.eGet(ref);
		if (currentValue == null) {
			currentValue = new LinkedList<EObject>();
			object.eSet(ref, currentValue);	
		}
		
		currentValue.add(value);
	}
}
