package org.emftext.test.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation can be used if simple file pairs contain the input test data and the expected test data.
 * 
 * @author jreimann
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataPairs {
	
	String[] value();
}
