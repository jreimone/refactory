package org.qualitune.evolution.ui.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.qualitune.evolution.prolog.registry.IPrologRegistry;
import org.qualitune.evolution.prolog.registry.PrologUtil;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.NoMoreSolutionException;
import alice.tuprolog.NoSolutionException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;

public class GetImplicitDependenciesHandler extends AbstractHandler {

	//	private static final String VAR_SOURCE_ELEMENT		= "SourceElement";
	private static final String VAR_TARGET_ELEMENT		= "TargetElement";
	private static final String VAR_SOURCE_ELEMENT_URI	= "SourceElementUri";
	private static final String VAR_TARGET_ELEMENT_URI	= "TargetElementUri";
	private static final String VAR_TARGET_MODEL		= "TargetModel";
	private static final String VAR_TARGET_MODEL_URI	= "TargetModelUri";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection currentSelection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		Object firstElement = currentSelection.getFirstElement();
		if(firstElement instanceof IFile){
			IFile file = (IFile) firstElement;
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			if(!uri.isPlatformResource()){
				uri = URI.createPlatformResourceURI(uri.toString(), true);
			}
			ResourceSet rs = new ResourceSetImpl();
			IPrologRegistry registry = IPrologRegistry.INSTANCE;
			Prolog engine = registry.getEngine();
			String query = "implicit(" + PrologUtil.makeStringAtomic(uri.toString()) + "," + VAR_TARGET_ELEMENT + ",_," + VAR_SOURCE_ELEMENT_URI + "," + VAR_TARGET_ELEMENT_URI + ").";
			System.out.println(query);
			try {
				List<SolveInfo> results = solveQuery(engine, query);
				for (SolveInfo result : results) {
					if (result.isSuccess()){
						String targetElementUriString = PrologUtil.removeApostrophe(result.getVarValue(VAR_TARGET_ELEMENT_URI).toString());
						String targetElementString = result.getVarValue(VAR_TARGET_ELEMENT).toString();
						String targetModelQuery = "elementtoresourcemapping(" + targetElementString + ", " + VAR_TARGET_MODEL + ").";
						SolveInfo modelResult = engine.solve(targetModelQuery);
						String targetModel = modelResult.getVarValue(VAR_TARGET_MODEL).toString();
						String targetModelUriQuery = "uri(" + targetModel + "," + VAR_TARGET_MODEL_URI + ").";
						SolveInfo modelUriResult = engine.solve(targetModelUriQuery);
						String targetModelUriString = PrologUtil.removeApostrophe(modelUriResult.getVarValue(VAR_TARGET_MODEL_URI).toString());
						URI targetModelUri = URI.createURI(targetModelUriString);
						rs.getResource(targetModelUri, true);
						URI targetElementUri = URI.createURI(targetElementUriString);
						EObject targetElement = rs.getEObject(targetElementUri, true);
						System.out.println(targetElement);
					}
				}
			} catch (MalformedGoalException e) {
				e.printStackTrace();
			} catch (NoSolutionException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private List<SolveInfo> solveQuery(Prolog engine, String query) {
		if(engine == null || query == null){
			return null;
		}
		List<SolveInfo> results = new ArrayList<SolveInfo>();
		try {
			SolveInfo result = engine.solve(query);
			results.add(result);
			while (engine.hasOpenAlternatives()) {
				results.add(engine.solveNext());
			}
		} catch (MalformedGoalException e) {
			e.printStackTrace();
		} catch (NoMoreSolutionException e) {
			e.printStackTrace();
		}
		return results;
	}

}
