/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class OperatorsTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsResour
 * ceUtil.
 */
public class OperatorsTextResourceUtil {
	
	/**
	 * Use
	 * org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsResour
	 * ceUtil.getResource() instead.
	 */
	@Deprecated
	public static org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsResource getResource(IFile file) {
		return new org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsResour
	 * ceUtil.getResource() instead.
	 */
	@Deprecated
	public static org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsResource getResource(File file, Map<?,?> options) {
		return org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsResour
	 * ceUtil.getResource() instead.
	 */
	@Deprecated
	public static org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsResource getResource(URI uri) {
		return org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsResour
	 * ceUtil.getResource() instead.
	 */
	@Deprecated
	public static org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsResource getResource(URI uri, Map<?,?> options) {
		return org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsResourceUtil.getResource(uri, options);
	}
	
}
