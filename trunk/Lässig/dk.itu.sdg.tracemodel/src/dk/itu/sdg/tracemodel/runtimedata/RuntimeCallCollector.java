package dk.itu.sdg.tracemodel.runtimedata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;

public class RuntimeCallCollector {
	
	private Map<JoinPoint, Object> executionJoinPoint2containerObject = new HashMap<JoinPoint, Object>();
	
	//map from joinpints matching cflow(execution(* *(..))) && target(o) to target(f) && call(* get*(..)) or target(f) && call(* set*(..))
	private Map<JoinPoint, Collection<JoinPoint>> containerMethod2CallJoinpoint = new HashMap<JoinPoint, Collection<JoinPoint>>();
	
	public void setContainerObject(JoinPoint methodExecution, Object container) {
		this.executionJoinPoint2containerObject.put(methodExecution, container);
	}
	
	public void setContainerMethod(JoinPoint methodExecution, JoinPoint methodCall) {
		
		Collection<JoinPoint> methodCalls = this.containerMethod2CallJoinpoint.get(methodExecution);
		if(methodCalls == null) {
			methodCalls = new ArrayList<JoinPoint>();
			methodCalls.add(methodCall);
			this.containerMethod2CallJoinpoint.put(methodExecution, methodCalls);
		} else {
			methodCalls.add(methodCall);
		}
	}
	
	public void setAll(JoinPoint methodExecution, Object container, JoinPoint methodCall) {
		this.executionJoinPoint2containerObject.put(methodExecution, container);
		this.setContainerMethod(methodExecution, methodCall);
	}
	
	public void removeAll(JoinPoint methodExecution) {
		this.executionJoinPoint2containerObject.remove(methodExecution);
		this.containerMethod2CallJoinpoint.remove(methodExecution);
	}
	
	public Collection<JoinPoint> containedCalls(JoinPoint methodExecution) {
		return this.containerMethod2CallJoinpoint.get(methodExecution);
	}
	
	public boolean containsCalls(JoinPoint methodExecution) {
		
		if(this.containerMethod2CallJoinpoint.get(methodExecution) == null) {
			return false;
		} else {
			return true;
		}
	}
}
