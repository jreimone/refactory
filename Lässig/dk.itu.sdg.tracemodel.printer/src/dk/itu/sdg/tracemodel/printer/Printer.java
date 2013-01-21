package dk.itu.sdg.tracemodel.printer;

import java.io.IOException;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import SimpleTrace.SimpleTraceFactory;
import SimpleTrace.SimpleTracePackage;
import SimpleTrace.impl.SimpleTraceFactoryImpl;
import dk.itu.sdg.tracemodel.runtimedata.DirectedTrace;
import dk.itu.sdg.tracemodel.runtimedata.Trace;
import dk.itu.sdg.tracemodel.runtimedata.TraceCollector;


public class Printer {

	public void toConsole() {
		for (Trace trace : TraceCollector.getInstance().getTraces()) {
			//System.out.println(trace.getLeftHand().toString() + " <--> " + trace.getRightHand());
			System.out.println("trace " + EcoreUtil.getURI((EObject)trace.getLeftHand()) + " <--> " + EcoreUtil.getURI((EObject)trace.getRightHand()) + " by " +  trace.getJoinPoint().getSignature().toString() + " in " + trace.getJoinPoint().getSignature().getDeclaringType().toString());
		}
	}
	
	public void structuredToConsole() {
		
		for (Class clazz : TraceCollector.getInstance().getTracesPerClass().keySet()) {
			Set<Trace> traces = TraceCollector.getInstance().getTracesPerClass().get(clazz);
			
			for (Trace trace : traces) {
				System.out.println("trace " + EcoreUtil.getURI((EObject)trace.getLeftHand()) + " <--> " + EcoreUtil.getURI((EObject)trace.getRightHand()) + " by " +  trace.getJoinPoint().getSignature().toString() + " in " + trace.getJoinPoint().getSignature().getDeclaringType().toString());				
			}
		}
	}
	
	public void toTraceModel() {
		
		String tracemodelPath = "/Users/ropf/Documents/eclipse/juno_dresden/dk.itu.sdg.tracemodel.printer/output/tracemodel.model";
				
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI(tracemodelPath));
		
		SimpleTracePackage tracemodelPackageInstance = SimpleTracePackage.eINSTANCE;
		SimpleTraceFactory factory = new SimpleTraceFactoryImpl();

		
		for (Set tracesPerRealTrace : TraceCollector.getInstance().getRealTraces()) {
			
			SimpleTrace.Trace modelTrace = factory.createTrace();
			
			for (Object trace : tracesPerRealTrace) {
				
				SimpleTrace.TraceLink modelTraceLink = factory.createTraceLink();
				modelTraceLink.getSources().add((EObject)((Trace)trace).getLeftHand());
				modelTraceLink.getTargets().add((EObject)((Trace)trace).getRightHand());
				modelTraceLink.setDescription("D: Transformed by " +  ((Trace)trace).getJoinPoint().getSignature().toString() + " in " + ((Trace)trace).getJoinPoint().getSourceLocation().toString());
				modelTrace.getLinks().add(modelTraceLink);
			}
			
			resource.getContents().add(modelTrace);
		}
		try {
			resource.save(System.out, null);
//			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void toFlatTraceModel() {
		
		String tracemodelPath = "/Users/ropf/Documents/eclipse/juno_dresden/dk.itu.sdg.tracemodel.printer/output/tracemodel.model";
				
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI(tracemodelPath));
		
		SimpleTracePackage tracemodelPackageInstance = SimpleTracePackage.eINSTANCE;
		SimpleTraceFactory factory = new SimpleTraceFactoryImpl();

		SimpleTrace.Trace modelTrace = factory.createTrace();
		for (Trace trace : TraceCollector.getInstance().getTraces()) {
							
			SimpleTrace.TraceLink traceLink = factory.createTraceLink();
			traceLink.getSources().add((EObject)((Trace)trace).getLeftHand());
			traceLink.getTargets().add((EObject)((Trace)trace).getRightHand());
			if (trace instanceof DirectedTrace) {
				traceLink.setDescription("-> Transformed by " +  ((Trace)trace).getJoinPoint().getSignature().toString() + " in " + ((Trace)trace).getJoinPoint().getSourceLocation().toString());
			} else {
				traceLink.setDescription("<-> Transformed by " +  ((Trace)trace).getJoinPoint().getSignature().toString() + " in " + ((Trace)trace).getJoinPoint().getSourceLocation().toString());
			}
			modelTrace.getLinks().add(traceLink);
			
			resource.getContents().add(modelTrace);
		}
		try {
			resource.save(System.out, null);
//			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
