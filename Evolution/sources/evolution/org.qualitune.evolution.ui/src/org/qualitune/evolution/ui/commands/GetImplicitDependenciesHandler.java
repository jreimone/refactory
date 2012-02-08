package org.qualitune.evolution.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.qualitune.evolution.prolog.registry.IPrologRegistry;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.NoMoreSolutionException;
import alice.tuprolog.NoSolutionException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Term;
import alice.tuprolog.Theory;

public class GetImplicitDependenciesHandler extends AbstractHandler {

	private static final String VAR_SOURCE_ELEMENT		= "SourceElement";
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
			ResourceSet rs = new ResourceSetImpl();
			IPrologRegistry registry = IPrologRegistry.INSTANCE;
			Prolog engine = registry.getEngine();
			Theory knowledgeBase = registry.getKnowledgeBase();
			String query = "implicit(" + registry.makeAtom(uri.toString()) + "," + VAR_SOURCE_ELEMENT + ",_," + VAR_SOURCE_ELEMENT_URI + "," + VAR_TARGET_ELEMENT_URI + ").";
			System.out.println(query);
			try {
				SolveInfo result = engine.solve(query);
				while (result.isSuccess()){
					System.out.println("solution: " + result.getSolution() + " - bindings: " + result);
					String sourceElementUri = result.getVarValue(VAR_SOURCE_ELEMENT_URI).toString();
					String targetElementUriString = result.getVarValue(VAR_TARGET_ELEMENT_URI).toString();
					String targetElementString = result.getVarValue(VAR_TARGET_ELEMENT).toString();
					String targetModelQuery = "elementtoresourcemapping(" + targetElementString + ", " + VAR_TARGET_MODEL + ").";
					System.out.println(targetModelQuery);
					SolveInfo modelResult = engine.solve(targetModelQuery);
					String targetModel = modelResult.getVarValue(VAR_TARGET_MODEL).toString();
					String targetModelUriQuery = "uri(" + targetModel + "," + VAR_TARGET_MODEL_URI + ")";
					System.out.println(targetModelUriQuery);
					SolveInfo modelUriResult = engine.solve(targetModelUriQuery);
					String targetModelUriString = modelUriResult.getVarValue(VAR_TARGET_MODEL_URI).toString();
					URI targetModelUri = URI.createURI(targetModelUriString);
					Resource resource = rs.getResource(targetModelUri, true);
					URI targetElementUri = URI.createURI(targetElementUriString);
					EObject targetElement = rs.getEObject(targetElementUri, true);
					if (engine.hasOpenAlternatives()){
						result = engine.solveNext();
					} else {
						break;
					}
					System.out.println(targetElement);
				}
			} catch (MalformedGoalException e) {
				e.printStackTrace();
			} catch (NoSolutionException e) {
				e.printStackTrace();
			} catch (NoMoreSolutionException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
