/**
 * 
 */
package org.emftext.test.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies the test data for a test method and its containing class. Normally it is expected that the test data files have the same name
 * as the test method and those are contained in a folder having the same name as the class which contains the test method.
 *  But if the method is renamed the test data files won't. To avoid a renaming of all files or folder
 * with this annotation the name of the folder can be specified.
 * 
 * @author Jan Reimann
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestData {

	String value();
}
