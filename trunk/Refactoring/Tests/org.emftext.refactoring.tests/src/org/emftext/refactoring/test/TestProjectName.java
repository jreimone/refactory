/**
 * 
 */
package org.emftext.refactoring.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark a static String attribute with this annotation to specify the name of the test project.
 * 
 * @author Jan Reimann
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TestProjectName {

}
