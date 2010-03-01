package org.emftext.test.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation specifies the file name pattern of the files used as input for testing in methods.
 * Use {@link ExpectedData} to specify the patterns of the files containing the expected data.
 * 
 * @author jreimann
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InputData {

	String[] value();
}
