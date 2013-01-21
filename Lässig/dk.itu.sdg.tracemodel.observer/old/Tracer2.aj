package dk.itu.sdg.tracemodel.observer;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.families.Families;
import org.emftext.language.families.Family;
import org.emftext.language.families.Father;
import org.emftext.language.persons.Male;
import org.emftext.language.persons.Persons;
//import org.emftext.language.families.resource.families.postprocessor.Transformation3;

public aspect Tracer2 {
		
	//method execution with exactly two parameters of the same type
	private pointcut findMethod1(Families t1, Persons t2) : !within(Tracer2) && execution(* *(.., Families, .. , Persons, ..)) && args(t1,t2,..);
	private pointcut findMethod2(Persons t1, Families t2) : !within(Tracer2) && execution(* *(.., Persons, .. , Families, ..)) && args(t1,t2,..);
	private pointcut findMethod3(Families t1, Persons t2) : !within(Tracer2) && execution(Families *(.., Persons, ..)) && args(t1,t2,..);
	private pointcut findMethod4(Persons t1, Families t2) : !within(Tracer2) && execution(Persons *(.. , Families, ..)) && args(t1,t2,..);
	
	//TODO: to find methods with signatures with more than two elements of type T1 and type T2
	//inspect the thisJoinPoint.getArgs() as in Tracer.aj
	//perhaps this is not necessary for this prototype
	
	
	private pointcut belowMethod(Object o) : within(org.emftext.language.families.resource.families.postprocessor.Transformation3) && !within(Tracer2) && cflow(execution(* *(..))) && target(o);
	private pointcut readFather(Father f) : !within(Tracer2) && target(f) && call(* get*(..));
	private pointcut writeMale(Male m) : !within(Tracer2) && target(m) && call(* set*(..));
	private pointcut readFamily(Family f) : !within(Tracer2) && target(f) && call(* get*(..));

	//	private pointcut drunter(Father f, Male m) : !within(Tracer2) && cflow(execution(* *(..))) && read(f) && write(m);


	ArrayList<JoinPoint> methodMatch = new ArrayList<JoinPoint>();
	
	int callDepth = 0;
	
	before(Object o) : belowMethod(o) {
//		methodMatch.add(thisJoinPoint);
		
		printIndent("below", thisJoinPoint);
		callDepth++;
	}
	
	after(Object o) : belowMethod(o) {
//		hier muss der check rein ob innerhalb des joinpoints, während der method execution, modelobjekte gelesen und geschrieben wurden
//		wenn ja, dann muß hier die trace etabliert werden.
		callDepth--;
	}
	
	boolean readFamily = false;
	Object familyReader = null;
	
	before(Family f, Object o) : readFamily(f) && belowMethod(o) {
		readFather = true;
		familyReader = o;
		print("readFamily", f.toString() + " " + thisJoinPoint.getSignature().toString());
	}
	
	boolean readFather = false;
	
	before(Father f, Object o) : readFather(f) && belowMethod(o) {
		readFather = true;
		print("readFather", f.toString() + " " + thisJoinPoint.getSignature().toString());
	}
	
	boolean wroteMale = false;
	
	before(Male m, Object o) : writeMale(m) && belowMethod(o) {
		
		if(readFather) {
			readFather = false;
			print("trace found", "between");
		}
		print("writePerson", m.toString() + " " + thisJoinPoint.getSignature().toString());
	}
	
 	
	
	
	before(Families f, Persons p) : findMethod1(f, p) {
		print("1", thisJoinPoint);
	}
	
//	before() : findMethod2() {
//		print("2", thisJoinPoint);
//	}
	
//	before() : findMethod3() {
//		print("3", thisJoinPoint);
//	}
	
	before(Persons t1, Families t2) : findMethod4(t1, t2) {
		print("4", thisJoinPoint);
	}
	
//	before() : findMethod5() {
//		print("5", thisJoinPoint);
//	}
	
	
	Object t1 = null, t2 = null;
	before(Families t1, Persons t2) : findMethod1(t1, t2) {
		print("6", thisJoinPoint);
		this.t1 = EcoreUtil.copy(t1);
		this.t2 = EcoreUtil.copy(t2);
	}
	
	after(Families t1, Persons t2) : findMethod1(t1, t2) {
		
		print("OIOIOI", null);
		
		if(!this.t1.equals(t1) || !this.t2.equals(t2)) {
			print("trace found", null);
		}
	}
	
	
//	before() : findMethod7() {
//		print("7", thisJoinPoint);
//	}
//	
//	before() : findMethod8() {
//		print("8", thisJoinPoint);
//	}
//	
//	before() : findMethod9() {
//		print("9", thisJoinPoint);
//	}
	
//	before() : findMethod10() {
//		print("10", thisJoinPoint);
//	}
	
//	before() : findMethod11() {
//		print("11", thisJoinPoint);
//	}
	
//	before() : findMethod12() {
//		print("12", thisJoinPoint);
//	}
	
	private void print(String prefix, Object message) {
		System.out.println(prefix + ": " + message);
	}
	
	private void printIndent(String prefix, Object message) {
		for(int i = 0; i < callDepth; i++) {
			System.out.print("  ");
		}
		System.out.println(prefix + ": " + message);
	}

}
