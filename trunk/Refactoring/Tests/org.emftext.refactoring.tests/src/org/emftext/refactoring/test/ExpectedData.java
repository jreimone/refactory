package org.emftext.refactoring.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation specifies the file name pattern of the files containing the expected data of the tests.
 * Use {@link InputData} to specify the patterns of the files containing the input data.
 * 
 * @author jreimann
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExpectedData {

	String[] value();
}
