/**
 * 
 */
package org.emftext.refactoring.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specify the test data for a test method. Normally the it is expected that the test data files have the same name
 * as the test method. But if the method is renamed the test data files won't. To avoid a renaming of all files
 * with this annotation the name of the files can be specified.
 * 
 * @author Jan Reimann
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD , ElementType.TYPE})
public @interface TestData {

	String pattern();
}
