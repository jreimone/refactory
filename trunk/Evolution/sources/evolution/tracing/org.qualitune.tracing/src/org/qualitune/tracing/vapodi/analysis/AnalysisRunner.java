/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.Function;
import org.qualitune.tracing.umt.InstructionBlock;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.Selection;
import org.qualitune.tracing.util.VUtil;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class AnalysisRunner {
	private List<IUmtAnalysis> analyses;
	
	public AnalysisRunner() {
		analyses = new LinkedList<IUmtAnalysis>();
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
			VUtil.warning("Analyses runner class seems broken");
			return false;
		} catch (IllegalAccessException e) {
			VUtil.warning("Analysis class seems broken");
			return false;
		} catch (InvocationTargetException e) {
			VUtil.warning("Analyses runner class seems broken");
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
		
		System.out.println("going for a "  + umtObject.eClass().getName());
		
		@SuppressWarnings("unchecked")
		Class<EObject> wantedClass = (Class<EObject>) umtObject.eClass().getInstanceClass();
		
		boolean successfullyCalled = tryCallVisit(analysis,wantedClass,umtObject);
		
		if (! successfullyCalled ) {
			for (EClass aSuperClass : umtObject.eClass().getESuperTypes()) {
				System.out.println("trying super " + aSuperClass);
				
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
			VUtil.warning("AnalysisRunner: ordered to run, but no analyses have been added");
		
		System.out.println("running");
		
		Iterator <EObject> it  = new UmtTreeIterator(umtProgram);
		
		// SomethingInMyCollectionHasChanged exceptions from iterators ahead?
		while (it.hasNext()) {
			EObject umtObject = it.next();
			visit(umtObject);
		}
	}
}
