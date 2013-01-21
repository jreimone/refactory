package dk.itu.sdg.language.epsilon.oo2db;

import java.util.Collection;
import java.util.List;

import oo.OO.Package;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.resource.XbaseResource;

import com.google.common.collect.Iterables;

@SuppressWarnings("restriction")
public class DB2OOWfComponent extends AbstractWorkflowComponent2 {
	private String modelSlot;
  	private String outputSlot;

  	public void setModelSlot(String modelSlot) {
	  this.modelSlot = modelSlot;
  	}

  	public void setOutputSlot(String outputSlot) {
	  this.outputSlot = outputSlot;
  	}

  	@Override
  	protected void checkConfigurationInternal(Issues issues) {
	  checkRequiredConfigProperty("modelSlot", modelSlot, issues);
    	checkRequiredConfigProperty("outputSlot", outputSlot, issues);
  	}
 
  	@Override
  	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor m, Issues issues) {
	    Object slotContent = ctx.get(modelSlot);
	    if (slotContent == null) {
	    	issues.addError(String.format("Slot %s is empty", modelSlot));
	      	return;
	    }
	    
	    db.DB.Database transformed = null;
	    if (slotContent instanceof Package) {
			Package p = (Package) slotContent;
			transformed = new OO2DBGroovy().transform(p);
	    } else {
	    	issues.addError("No Package instance found in model slot");
	    	return;
	    }

	    ctx.set(outputSlot, transformed);
  	}
}
