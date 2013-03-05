/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.qualitune.tracing.umt.InstanceModel;
import org.qualitune.tracing.umt.Instruction;
import org.qualitune.tracing.umt.IntentionEnum;
import org.qualitune.tracing.umt.ModelAttributeVariable;
import org.qualitune.tracing.umt.ModelVariable;
import org.qualitune.tracing.umt.UmtFactory;
import org.qualitune.tracing.umt.Variable;
import org.qualitune.tracing.vapoditrace.vapoditraceFactory;

/**
 * Contains a number of typical infrastructure and helpers. 
 * 
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class IUmtAnalysisImpl implements IUmtAnalysis {

	protected UmtFactory _umtFactory;
	protected vapoditraceFactory _vapodiTraceFactory;
	protected Logger logger;
	
	public IUmtAnalysisImpl (String logPostfix) {
		_umtFactory = UmtFactory.eINSTANCE;
		_vapodiTraceFactory = vapoditraceFactory.eINSTANCE;
		@SuppressWarnings("unused")
		Logger logger = Logger.getLogger("org.qualitune.tracing.analysis." + logPostfix);
	}
	
	// expect some more of this type to show up, maybe parameterise location
	// Expression: may be free or part of variableProcessingInstruction.assignedExpression
	
	public void composeIntoContainment(Instruction existing, Instruction toAdd, LocationEnum where) {
		EObject container = existing.eContainer();
		EStructuralFeature feature = existing.eContainingFeature();
		int index = 0;
		
		assert container.eGet(feature) != null;
		assert container.eGet(feature) instanceof EList;
		
		@SuppressWarnings("unchecked")
		EList<Instruction> list = (EList<Instruction>) container.eGet(feature);
		assert list.contains(existing);
		
		switch (where) {
		case AFTER:
			index = list.indexOf(existing) + 1;
			break;
		case END_OF_SCOPE:
			index = list.size();
			break;
		case BEFORE:
			index = list.indexOf(existing);			
			break;
		default:
			logger.warn("unkown location");
			break;		
		}
		
		list.add(index, toAdd);
	}
	
	protected boolean isInModel(InstanceModel model) {
		IntentionEnum intention = model.getIntention(); 
		return (intention == IntentionEnum.IN) || (intention == IntentionEnum.INOUT); 
	}
	
	protected boolean isOutModel(InstanceModel model) {
		IntentionEnum intention = model.getIntention(); 
		return (intention == IntentionEnum.OUT) || (intention == IntentionEnum.INOUT); 
	}
	
	boolean belongsToOutputModel(Variable var) {
		ModelVariable modelVar;
		
		if (var instanceof ModelAttributeVariable) {
			modelVar = ((ModelAttributeVariable) var).getPartOf();
		} else if (var instanceof ModelVariable) {
			modelVar = (ModelVariable) var;
		} else // variable that is no model variable can't belong to any model
			return false;
		
		return isOutModel(modelVar.getModel());
	}
}
