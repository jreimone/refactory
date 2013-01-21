package dk.itu.sdg.tracemodel.runtimedata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.aspectj.lang.JoinPoint;

public class TraceCollector {
	
	private Set<Trace> traces = new HashSet<Trace>();
	private Set<Set<Trace>> realTraces = new HashSet<Set<Trace>>();
	private HashMap<Class, Set<Trace>> tracesPerClass = new HashMap<Class, Set<Trace>>();

	private static TraceCollector instance = null;
	
	protected TraceCollector() {
	}

	public static TraceCollector reset() {
		instance = new TraceCollector();
		return instance;
	}
	
	public static TraceCollector getInstance() {
		if(instance == null) {
			instance = new TraceCollector();
		}
		return instance;
	}
	
	public void setTrace(Object leftHand, JoinPoint jP, Object rightHand) {
		Trace trace = new Trace(leftHand, jP, rightHand);
		traces.add(trace);
	}
	
	public void setDirectedTrace(Object leftHand, JoinPoint jP, Object rightHand) {
		traces.add(new DirectedTrace(leftHand, jP, rightHand));
	}
	
	public Set<Trace> getTraces() {
		return traces;
	}
	
	public HashMap<Class, Set<Trace>> getTracesPerClass() {		
		for (Trace trace : this.traces) {
			Set<Trace> traceList = tracesPerClass.get(trace.getJoinPoint().getClass());
			if(traceList == null) {
				traceList = new HashSet<Trace>();
				traceList.add(trace);
			} else {
				traceList.add(trace);
			}
			tracesPerClass.put(trace.getJoinPoint().getClass(),traceList);
		}
		
		return tracesPerClass;
	}
	
	public Set<Set<Trace>> getRealTraces() {		
		Object[] tracesAsArray = this.traces.toArray();
		
		
		for (int i = 0; i < this.traces.size(); i++) {
			Set<Trace> similarTraces = new HashSet<Trace>();
			similarTraces.add((Trace)tracesAsArray[i]);
						
			for (int j = i + 1; j < this.traces.size(); j++) {
				if (!((Trace)tracesAsArray[i]).equals(tracesAsArray[j]) 
						&& ((Trace)tracesAsArray[i]).hashCode() != tracesAsArray[j].hashCode() 
						&& ((Trace)tracesAsArray[i]).similar(tracesAsArray[j])) {
					similarTraces.add((Trace)tracesAsArray[j]);
				}
			}
			
			realTraces.add(similarTraces);
		}
		return realTraces;
	}
}
