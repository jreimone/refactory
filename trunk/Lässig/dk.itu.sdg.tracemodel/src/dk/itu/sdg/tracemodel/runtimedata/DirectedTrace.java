package dk.itu.sdg.tracemodel.runtimedata;

import org.aspectj.lang.JoinPoint;

public class DirectedTrace extends Trace {

	public DirectedTrace(Object leftHand, JoinPoint joinPoint, Object rightHand) {
		super(leftHand, joinPoint, rightHand);
	}
}
