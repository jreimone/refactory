package dk.itu.sdg.tracemodel.observer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import persons.Female;
import persons.Male;
import dk.itu.sdg.tracemodel.runtimedata.TraceCollector;
import families.Family;
import families.Member;


public aspect Tracer {
	
	//TODO: if scoping to a certain class is need fill it in here!!!
	//private pointcut belowMethod(Object o) : within(!!!Put class name here!!!) && !within(Tracer) && cflow(execution(* *(..))) && target(o);
	
private pointcut findMethodA0(Family t1, Male t2) : !within(Tracer) && execution(* *(.., Family, .., Male, ..)) && args(t1,t2,..);
private pointcut findMethodB0(Male t1, Family t2) : !within(Tracer) && execution(* *(.., Male, .., Family, ..)) && args(t1,t2,..);


private pointcut findMethodC0(Male t1) : !within(Tracer) && execution(Family *(.., Male, ..)) && args(t1,..);
private pointcut findMethodD0(Family t1) : !within(Tracer) && execution(Male *(.. , Family, ..)) && args(t1,..);

private pointcut findMethodA1(Family t1, Female t2) : !within(Tracer) && execution(* *(.., Family, .., Female, ..)) && args(t1,t2,..);
private pointcut findMethodB1(Female t1, Family t2) : !within(Tracer) && execution(* *(.., Female, .., Family, ..)) && args(t1,t2,..);


private pointcut findMethodC1(Female t1) : !within(Tracer) && execution(Family *(.., Female, ..)) && args(t1,..);
private pointcut findMethodD1(Family t1) : !within(Tracer) && execution(Female *(.. , Family, ..)) && args(t1,..);

private pointcut findMethodA2(Member t1, Male t2) : !within(Tracer) && execution(* *(.., Member, .., Male, ..)) && args(t1,t2,..);
private pointcut findMethodB2(Male t1, Member t2) : !within(Tracer) && execution(* *(.., Male, .., Member, ..)) && args(t1,t2,..);


private pointcut findMethodC2(Male t1) : !within(Tracer) && execution(Member *(.., Male, ..)) && args(t1,..);
private pointcut findMethodD2(Member t1) : !within(Tracer) && execution(Male *(.. , Member, ..)) && args(t1,..);

private pointcut findMethodA3(Member t1, Female t2) : !within(Tracer) && execution(* *(.., Member, .., Female, ..)) && args(t1,t2,..);
private pointcut findMethodB3(Female t1, Member t2) : !within(Tracer) && execution(* *(.., Female, .., Member, ..)) && args(t1,t2,..);


private pointcut findMethodC3(Female t1) : !within(Tracer) && execution(Member *(.., Female, ..)) && args(t1,..);
private pointcut findMethodD3(Member t1) : !within(Tracer) && execution(Female *(.. , Member, ..)) && args(t1,..);

//before(Object o) : belowMethod(o) {
//	System.out.println("matched: " +  thisJoinPoint.getSignature());
//}
//genertated by generateAdvisePCType1 first part

Object tA0 = null, tB0 = null;
after(Family t1, Male t2) : findMethodA0(t1, t2) {
	if(!this.tA0.equals(t1) || !this.tB0.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Family t1, Male t2) : findMethodA0(t1, t2) {
	
	//System.out.println("findMethodA0: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA0 = EcoreUtil.copy((EObject)t1);
	this.tB0 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Male t1, Family t2) : findMethodB0(t1, t2) {
	if(!this.tA0.equals(t1) || !this.tB0.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Male t1, Family t2) : findMethodB0(t1, t2) {
	
	//System.out.println("findMethodB0: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA0 = EcoreUtil.copy((EObject)t1);
	this.tB0 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Male t1) returning (Family returnValue): findMethodC0(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Family t1) returning (Male returnValue): findMethodD0(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA1 = null, tB1 = null;
after(Family t1, Female t2) : findMethodA1(t1, t2) {
	if(!this.tA1.equals(t1) || !this.tB1.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Family t1, Female t2) : findMethodA1(t1, t2) {
	
	//System.out.println("findMethodA1: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA1 = EcoreUtil.copy((EObject)t1);
	this.tB1 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Female t1, Family t2) : findMethodB1(t1, t2) {
	if(!this.tA1.equals(t1) || !this.tB1.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Female t1, Family t2) : findMethodB1(t1, t2) {
	
	//System.out.println("findMethodB1: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA1 = EcoreUtil.copy((EObject)t1);
	this.tB1 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Female t1) returning (Family returnValue): findMethodC1(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Family t1) returning (Female returnValue): findMethodD1(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA2 = null, tB2 = null;
after(Member t1, Male t2) : findMethodA2(t1, t2) {
	if(!this.tA2.equals(t1) || !this.tB2.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Member t1, Male t2) : findMethodA2(t1, t2) {
	
	//System.out.println("findMethodA2: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA2 = EcoreUtil.copy((EObject)t1);
	this.tB2 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Male t1, Member t2) : findMethodB2(t1, t2) {
	if(!this.tA2.equals(t1) || !this.tB2.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Male t1, Member t2) : findMethodB2(t1, t2) {
	
	//System.out.println("findMethodB2: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA2 = EcoreUtil.copy((EObject)t1);
	this.tB2 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Male t1) returning (Member returnValue): findMethodC2(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Member t1) returning (Male returnValue): findMethodD2(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA3 = null, tB3 = null;
after(Member t1, Female t2) : findMethodA3(t1, t2) {
	if(!this.tA3.equals(t1) || !this.tB3.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Member t1, Female t2) : findMethodA3(t1, t2) {
	
	//System.out.println("findMethodA3: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA3 = EcoreUtil.copy((EObject)t1);
	this.tB3 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Female t1, Member t2) : findMethodB3(t1, t2) {
	if(!this.tA3.equals(t1) || !this.tB3.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Female t1, Member t2) : findMethodB3(t1, t2) {
	
	//System.out.println("findMethodB3: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA3 = EcoreUtil.copy((EObject)t1);
	this.tB3 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Female t1) returning (Member returnValue): findMethodC3(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Member t1) returning (Female returnValue): findMethodD3(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		//System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
}