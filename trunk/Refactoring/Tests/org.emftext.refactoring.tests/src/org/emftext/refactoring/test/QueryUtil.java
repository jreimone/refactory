/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class QueryUtil {

	private static final String ROOT_SYMBOL 				= "#";
	private static final String SEGMENT_SEPERATOR 			= "/";
	private static final String MULTIPLICITY_CONNECTOR 		= "\\.\\.";
	private static final String ATTRIBUTE_OPEN		 		= "\\[";
	private static final String ATTRIBUTE_CLOSE		 		= "]";
	private static final String ATTRIBUTE_ASSIGN	 		= "=";

	private QueryUtil(){
		// nothing
	}

	public static List<EObject> queryResource(Resource resource, String query){
		EObject model = resource.getContents().get(0);
		return queryModel(model, query);
	}
	
	public static List<EObject> queryModel(EObject model, String query){
		assertNotNull(model);
		assertNotNull(query);
		String[] segments = query.split(SEGMENT_SEPERATOR);
		List<EObject> element = getPath(model, segments);
		return element;
	}

	public static String getLineInFile(File file, int lineNumber){
		assertTrue(file.exists());
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			for (int i = 0; i < lineNumber; i++) {
				String line = reader.readLine();
				if(line == null){
					return null;
				}
				if((i + 1) == lineNumber){
					return line;
				}
			}
		} catch (FileNotFoundException e) {
			//
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static List<EObject> getPath(EObject input, String[] path){
		if(path.length == 0){
			return getSingleList(input);
		}
		String featureName = path[0];
		if(ROOT_SYMBOL.equals(featureName)){
			return getSingleList(input);
		}
		path = removeFirst(path);
		String[] attributes = featureName.split(ATTRIBUTE_OPEN);
		if(attributes == null || attributes.length == 0){
			return null;
		}
		featureName = attributes[0];
		String attribute = null;
		if(attributes.length > 1){
			attribute = attributes[1].replace(ATTRIBUTE_CLOSE, "");
		}
		EClass metaclass = input.eClass();
		EStructuralFeature feature = metaclass.getEStructuralFeature(featureName);
		if(feature == null){
			return null;
		}
		Object value = input.eGet(feature, true);
		if(value instanceof EObject){
//			String[] temp = removeFirst(path);
			return getPath((EObject) value, path);
		}
		if(value instanceof List<?>){
			if(attribute == null){
				List<EObject> temp = new ArrayList<EObject>();
				temp.add((EObject) ((List<?>) value).get(0));
				return temp;
			}
			try{
				int index = Integer.parseInt(attribute);
				EObject ob = (EObject) ((List<?>) value).get(index);
				if(path.length == 0){
					return getSingleList(ob);
				} else {
//					path = removeFirst(path);
					return getPath(ob, path);
				}
			} catch (NumberFormatException e) {

			}
			String[] multiplicity = attribute.split(MULTIPLICITY_CONNECTOR);
			if(multiplicity != null && multiplicity.length > 0){
				int min = Integer.parseInt(multiplicity[0]);
				int max = Integer.parseInt(multiplicity[1]);
				List<?> source = (List<?>) value;
				List<EObject> result = new LinkedList<EObject>();
				for (int i = min; i <= max; i++) {
					result.add((EObject) source.get(i));
				}
				if(path.length == 0){
					return result;
				} else {
					if(result.size() == 1){
//						path = removeFirst(path);
						return getPath(result.get(0), path);
					} else {
						return null;
					}
				}
			} else {
				return null;
			}
		}
		return null;
	}

	private static List<EObject> getSingleList(EObject input) {
		List<EObject> temp = new ArrayList<EObject>();
		temp.add(input);
		return temp;
	}

	private static String[] removeFirst(String[] path) {
		List<String> temp = new ArrayList<String>();
		for (int i = 1; i < path.length; i++) {
			temp.add(path[i]);
		}
		return temp.toArray(new String[0]);
	}
}
