package dk.itu.sdg.tracemodel.observer;

import java.lang.reflect.Field;

import org.emftext.language.families.Family;
import org.emftext.language.persons.Persons;

public aspect Tracer {
	
	private int callDepth;
	
//	pointcut traced() : within(org.emftext.language.families.resource.families.postprocessor.Transformation); 
//	
//	before() : traced() {
//		this.print("Before", thisJoinPoint);
//		callDepth++;
//	}
//
//	after() : traced() {
//		this.print("After", thisJoinPoint);
//		callDepth--;
//	}
	

	
//	within(org.eclipse.core.internal.jobs.Worker) && 
//	private pointcut underWorkerRunner() : !within(Tracer) && within(org.eclipse.core.internal.jobs.Worker) && cflowbelow(execution(public void org.eclipse.core.internal.jobs.Worker.run()));
	
//	private pointcut underWorkerRunner() : !within(Tracer) 
//		&& cflowbelow(execution(public void org.eclipse.core.internal.jobs.Worker.run()))
//		&& execution(* org.emftext.language.persons.impl.PersonsFactoryImpl.*());
//	
//	before() : underWorkerRunner() {
//		callDepth++;
//		this.print("", thisJoinPoint);
//		Object a = thisJoinPointStaticPart;
//		callDepth--;
//	}
	
	
	private void print(String prefix, Object message) {
		for(int i = 0; i < callDepth; i++) {
			System.out.print("  ");
		}
		System.out.println(prefix + ": " + message);
	}
	
	private pointcut findMethod() : !within(Tracer) 
		&& execution(* *(..));

	before() : findMethod() {
		callDepth++;
		
		boolean matchingArgumentA = false;
		boolean matchingArgumentB = false;
		Object argA = null, argB = null;
		
		for (Object argument : thisJoinPoint.getArgs()) {
			
			
//			if (argument instanceof Families) {
//				Families families = (Families) argument;
//				matchingArgumentA = true;
//				
//				argA = families;
//			}
//			if (argument instanceof Persons) {
//				Persons persons = (Persons) argument;
//				matchingArgumentB = true;
//				
//				argB = persons;
//			}
			
			if (argument instanceof Family) {
				Family families = (Family) argument;
				matchingArgumentA = true;
				
				argA = families;
			}
			if (argument instanceof Persons) {
				Persons persons = (Persons) argument;
				matchingArgumentB = true;
				
				argB = persons;
			}
		}
		
		//case: execution of a method with two parameter types matching 
		if (matchingArgumentA && matchingArgumentB) {
			
			//TODO: fill the trace model here!
			//cast to EObjects and get URIs
			//check if they are null and not null afterwards
			//only put them into the trace model if at least one of them is different after than before method execution
			System.out.println("A: " + thisJoinPoint.getKind() + " " + argA.getClass().getSimpleName() + " " + argB.getClass().getSimpleName());
			
		} 
		//case: execution of a method with ONE parameter type matching and another field in the class is of the other type
		else if (matchingArgumentA || matchingArgumentB) {
			
			Object target = thisJoinPoint.getTarget();
			Class<?> clazz = null;
			//positive case happens in case of a static class
			if (target == null) {
				clazz = thisJoinPointStaticPart.getClass();
			} else {
				clazz = target.getClass();
			}
			
//			Field[] fields = clazz.getFields();
			Field[] fields = clazz.getDeclaredFields();
			
			if(fields.length > 0) {
				System.out.print("B: " + clazz.getSimpleName() + " ");
			
				for (Field field : fields) {
					System.out.print(field.getType().getSimpleName() + ",");
				}
				
				System.out.println();
			}
		}
		
		callDepth--;
	}
}
