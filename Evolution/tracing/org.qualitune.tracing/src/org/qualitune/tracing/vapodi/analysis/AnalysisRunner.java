/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class AnalysisRunner {
	protected List<IUmtAnalysis> analyses;
	protected Logger logger;
	
	public AnalysisRunner() {
		analyses = new LinkedList<IUmtAnalysis>();
		logger = Logger.getLogger(AnalysisRunner.class);
	}
	
	public void addAnalysis(IUmtAnalysis analysis) {
		analyses.add(analysis);
	}
	
	protected void visit(EObject program) {
		for (IUmtAnalysis analysis : analyses) {
			tryVisit(analysis,program);
		}
	}
	
	private static final String methodName = "visit";
	
	private boolean tryCallVisit(IUmtAnalysis analysis, Class<EObject> wantedSignatureClass, EObject umtObject) {
		
		Method m;
		try {
			m = analysis.getClass().getMethod(methodName, wantedSignatureClass);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			return false;
		} catch (NoSuchMethodException e1) {
			return false;
		}
		
		try {
			m.invoke(analysis, umtObject);
		} catch (IllegalArgumentException e) {
			logger.error("Analysis " + analysis.getClass().getSimpleName() + " seems broken for " +
					methodName + "(" + wantedSignatureClass.getSimpleName() + ")");
			return false;
		} catch (IllegalAccessException e) {
			logger.error("Analysis " + analysis.getClass().getSimpleName() + " seems broken for " +
					methodName + "(" + wantedSignatureClass.getSimpleName() + ")");
			return false;
		} catch (InvocationTargetException e) {
			logger.error("Analysis " + analysis.getClass().getSimpleName() + " seems broken for " +
					methodName + "(" + wantedSignatureClass.getSimpleName() + "). " + 
					"Details: " + e.getMessage() + " " + e.getCause().getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * This one "fixes" polymorphism.
	 * (non-intrusive visitor pattern)
	 * 
	 * @param analysis
	 * @param umtObject
	 */
	private void tryVisit(IUmtAnalysis analysis, EObject umtObject) {
		
		logger.debug("going for a "  + umtObject.eClass().getName());
		
		@SuppressWarnings("unchecked")
		Class<EObject> wantedClass = (Class<EObject>) umtObject.eClass().getInstanceClass();
		
		boolean successfullyCalled = tryCallVisit(analysis,wantedClass,umtObject);
		
		if (! successfullyCalled ) {
			for (EClass aSuperClass : umtObject.eClass().getESuperTypes()) {
				logger.debug("trying super " + aSuperClass);
				
				@SuppressWarnings("unchecked")
				Class<EObject> wantedSuperClass = (Class<EObject>) aSuperClass.getInstanceClass();
				successfullyCalled = tryCallVisit(analysis,wantedSuperClass,umtObject);
				
				if (successfullyCalled)
					break;
			}
		}
	}
	

	public void run(EObject umtProgram) {
		if (analyses.size() == 0)
			logger.warn("AnalysisRunner: ordered to run, but no analyses have been added");
		
		logger.info("running");
		
		Iterator <EObject> it  = new UmtTreeIterator(umtProgram);
		
		// SomethingInMyCollectionHasChanged exceptions from iterators ahead?
		while (it.hasNext()) {
			EObject umtObject = it.next();
			visit(umtObject);
		}
	}
}
