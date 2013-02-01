package dk.itu.sdg.tracemodel.observer;

import java.util.ArrayList;
import org.aspectj.lang.JoinPoint;
import org.eclipse.emf.ecore.util.EcoreUtil;

import dk.itu.sdg.tracemodel.runtimedata.TraceCollector;


public aspect Tracer {
	
	//TODO: if scoping to a certain class is need fill it in here!!!
	//private pointcut belowMethod(Object o) : within(!!!Put class name here!!!) && !within(Tracer) && cflow(execution(* *(..))) && target(o);
	
private pointcut findMethodA0(Database t1, Model t2) : !within(Tracer) && execution(* *(.., Database, .., Model, ..)) && args(t1,t2,..);
private pointcut findMethodB0(Model t1, Database t2) : !within(Tracer) && execution(* *(.., Model, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC0(Model t1) : !within(Tracer) && execution(Database *(.., Model, ..)) && args(t1,..);
private pointcut findMethodD0(Database t1) : !within(Tracer) && execution(Model *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA1(Database t1, Annotation t2) : !within(Tracer) && execution(* *(.., Database, .., Annotation, ..)) && args(t1,t2,..);
private pointcut findMethodB1(Annotation t1, Database t2) : !within(Tracer) && execution(* *(.., Annotation, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC1(Annotation t1) : !within(Tracer) && execution(Database *(.., Annotation, ..)) && args(t1,..);
private pointcut findMethodD1(Database t1) : !within(Tracer) && execution(Annotation *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA2(Database t1, Package t2) : !within(Tracer) && execution(* *(.., Database, .., Package, ..)) && args(t1,t2,..);
private pointcut findMethodB2(Package t1, Database t2) : !within(Tracer) && execution(* *(.., Package, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC2(Package t1) : !within(Tracer) && execution(Database *(.., Package, ..)) && args(t1,..);
private pointcut findMethodD2(Database t1) : !within(Tracer) && execution(Package *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA3(Database t1, ExternalClass t2) : !within(Tracer) && execution(* *(.., Database, .., ExternalClass, ..)) && args(t1,t2,..);
private pointcut findMethodB3(ExternalClass t1, Database t2) : !within(Tracer) && execution(* *(.., ExternalClass, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC3(ExternalClass t1) : !within(Tracer) && execution(Database *(.., ExternalClass, ..)) && args(t1,..);
private pointcut findMethodD3(Database t1) : !within(Tracer) && execution(ExternalClass *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA4(Database t1, Class t2) : !within(Tracer) && execution(* *(.., Database, .., Class, ..)) && args(t1,t2,..);
private pointcut findMethodB4(Class t1, Database t2) : !within(Tracer) && execution(* *(.., Class, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC4(Class t1) : !within(Tracer) && execution(Database *(.., Class, ..)) && args(t1,..);
private pointcut findMethodD4(Database t1) : !within(Tracer) && execution(Class *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA5(Database t1, Datatype t2) : !within(Tracer) && execution(* *(.., Database, .., Datatype, ..)) && args(t1,t2,..);
private pointcut findMethodB5(Datatype t1, Database t2) : !within(Tracer) && execution(* *(.., Datatype, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC5(Datatype t1) : !within(Tracer) && execution(Database *(.., Datatype, ..)) && args(t1,..);
private pointcut findMethodD5(Database t1) : !within(Tracer) && execution(Datatype *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA6(Database t1, Operation t2) : !within(Tracer) && execution(* *(.., Database, .., Operation, ..)) && args(t1,t2,..);
private pointcut findMethodB6(Operation t1, Database t2) : !within(Tracer) && execution(* *(.., Operation, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC6(Operation t1) : !within(Tracer) && execution(Database *(.., Operation, ..)) && args(t1,..);
private pointcut findMethodD6(Database t1) : !within(Tracer) && execution(Operation *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA7(Database t1, Parameter t2) : !within(Tracer) && execution(* *(.., Database, .., Parameter, ..)) && args(t1,t2,..);
private pointcut findMethodB7(Parameter t1, Database t2) : !within(Tracer) && execution(* *(.., Parameter, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC7(Parameter t1) : !within(Tracer) && execution(Database *(.., Parameter, ..)) && args(t1,..);
private pointcut findMethodD7(Database t1) : !within(Tracer) && execution(Parameter *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA8(Database t1, Reference t2) : !within(Tracer) && execution(* *(.., Database, .., Reference, ..)) && args(t1,t2,..);
private pointcut findMethodB8(Reference t1, Database t2) : !within(Tracer) && execution(* *(.., Reference, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC8(Reference t1) : !within(Tracer) && execution(Database *(.., Reference, ..)) && args(t1,..);
private pointcut findMethodD8(Database t1) : !within(Tracer) && execution(Reference *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA9(Database t1, Attribute t2) : !within(Tracer) && execution(* *(.., Database, .., Attribute, ..)) && args(t1,t2,..);
private pointcut findMethodB9(Attribute t1, Database t2) : !within(Tracer) && execution(* *(.., Attribute, .., Database, ..)) && args(t1,t2,..);


private pointcut findMethodC9(Attribute t1) : !within(Tracer) && execution(Database *(.., Attribute, ..)) && args(t1,..);
private pointcut findMethodD9(Database t1) : !within(Tracer) && execution(Attribute *(.. , Database, ..)) && args(t1,..);

private pointcut findMethodA10(Table t1, Model t2) : !within(Tracer) && execution(* *(.., Table, .., Model, ..)) && args(t1,t2,..);
private pointcut findMethodB10(Model t1, Table t2) : !within(Tracer) && execution(* *(.., Model, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC10(Model t1) : !within(Tracer) && execution(Table *(.., Model, ..)) && args(t1,..);
private pointcut findMethodD10(Table t1) : !within(Tracer) && execution(Model *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA11(Table t1, Annotation t2) : !within(Tracer) && execution(* *(.., Table, .., Annotation, ..)) && args(t1,t2,..);
private pointcut findMethodB11(Annotation t1, Table t2) : !within(Tracer) && execution(* *(.., Annotation, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC11(Annotation t1) : !within(Tracer) && execution(Table *(.., Annotation, ..)) && args(t1,..);
private pointcut findMethodD11(Table t1) : !within(Tracer) && execution(Annotation *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA12(Table t1, Package t2) : !within(Tracer) && execution(* *(.., Table, .., Package, ..)) && args(t1,t2,..);
private pointcut findMethodB12(Package t1, Table t2) : !within(Tracer) && execution(* *(.., Package, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC12(Package t1) : !within(Tracer) && execution(Table *(.., Package, ..)) && args(t1,..);
private pointcut findMethodD12(Table t1) : !within(Tracer) && execution(Package *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA13(Table t1, ExternalClass t2) : !within(Tracer) && execution(* *(.., Table, .., ExternalClass, ..)) && args(t1,t2,..);
private pointcut findMethodB13(ExternalClass t1, Table t2) : !within(Tracer) && execution(* *(.., ExternalClass, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC13(ExternalClass t1) : !within(Tracer) && execution(Table *(.., ExternalClass, ..)) && args(t1,..);
private pointcut findMethodD13(Table t1) : !within(Tracer) && execution(ExternalClass *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA14(Table t1, Class t2) : !within(Tracer) && execution(* *(.., Table, .., Class, ..)) && args(t1,t2,..);
private pointcut findMethodB14(Class t1, Table t2) : !within(Tracer) && execution(* *(.., Class, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC14(Class t1) : !within(Tracer) && execution(Table *(.., Class, ..)) && args(t1,..);
private pointcut findMethodD14(Table t1) : !within(Tracer) && execution(Class *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA15(Table t1, Datatype t2) : !within(Tracer) && execution(* *(.., Table, .., Datatype, ..)) && args(t1,t2,..);
private pointcut findMethodB15(Datatype t1, Table t2) : !within(Tracer) && execution(* *(.., Datatype, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC15(Datatype t1) : !within(Tracer) && execution(Table *(.., Datatype, ..)) && args(t1,..);
private pointcut findMethodD15(Table t1) : !within(Tracer) && execution(Datatype *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA16(Table t1, Operation t2) : !within(Tracer) && execution(* *(.., Table, .., Operation, ..)) && args(t1,t2,..);
private pointcut findMethodB16(Operation t1, Table t2) : !within(Tracer) && execution(* *(.., Operation, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC16(Operation t1) : !within(Tracer) && execution(Table *(.., Operation, ..)) && args(t1,..);
private pointcut findMethodD16(Table t1) : !within(Tracer) && execution(Operation *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA17(Table t1, Parameter t2) : !within(Tracer) && execution(* *(.., Table, .., Parameter, ..)) && args(t1,t2,..);
private pointcut findMethodB17(Parameter t1, Table t2) : !within(Tracer) && execution(* *(.., Parameter, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC17(Parameter t1) : !within(Tracer) && execution(Table *(.., Parameter, ..)) && args(t1,..);
private pointcut findMethodD17(Table t1) : !within(Tracer) && execution(Parameter *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA18(Table t1, Reference t2) : !within(Tracer) && execution(* *(.., Table, .., Reference, ..)) && args(t1,t2,..);
private pointcut findMethodB18(Reference t1, Table t2) : !within(Tracer) && execution(* *(.., Reference, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC18(Reference t1) : !within(Tracer) && execution(Table *(.., Reference, ..)) && args(t1,..);
private pointcut findMethodD18(Table t1) : !within(Tracer) && execution(Reference *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA19(Table t1, Attribute t2) : !within(Tracer) && execution(* *(.., Table, .., Attribute, ..)) && args(t1,t2,..);
private pointcut findMethodB19(Attribute t1, Table t2) : !within(Tracer) && execution(* *(.., Attribute, .., Table, ..)) && args(t1,t2,..);


private pointcut findMethodC19(Attribute t1) : !within(Tracer) && execution(Table *(.., Attribute, ..)) && args(t1,..);
private pointcut findMethodD19(Table t1) : !within(Tracer) && execution(Attribute *(.. , Table, ..)) && args(t1,..);

private pointcut findMethodA20(Column t1, Model t2) : !within(Tracer) && execution(* *(.., Column, .., Model, ..)) && args(t1,t2,..);
private pointcut findMethodB20(Model t1, Column t2) : !within(Tracer) && execution(* *(.., Model, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC20(Model t1) : !within(Tracer) && execution(Column *(.., Model, ..)) && args(t1,..);
private pointcut findMethodD20(Column t1) : !within(Tracer) && execution(Model *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA21(Column t1, Annotation t2) : !within(Tracer) && execution(* *(.., Column, .., Annotation, ..)) && args(t1,t2,..);
private pointcut findMethodB21(Annotation t1, Column t2) : !within(Tracer) && execution(* *(.., Annotation, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC21(Annotation t1) : !within(Tracer) && execution(Column *(.., Annotation, ..)) && args(t1,..);
private pointcut findMethodD21(Column t1) : !within(Tracer) && execution(Annotation *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA22(Column t1, Package t2) : !within(Tracer) && execution(* *(.., Column, .., Package, ..)) && args(t1,t2,..);
private pointcut findMethodB22(Package t1, Column t2) : !within(Tracer) && execution(* *(.., Package, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC22(Package t1) : !within(Tracer) && execution(Column *(.., Package, ..)) && args(t1,..);
private pointcut findMethodD22(Column t1) : !within(Tracer) && execution(Package *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA23(Column t1, ExternalClass t2) : !within(Tracer) && execution(* *(.., Column, .., ExternalClass, ..)) && args(t1,t2,..);
private pointcut findMethodB23(ExternalClass t1, Column t2) : !within(Tracer) && execution(* *(.., ExternalClass, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC23(ExternalClass t1) : !within(Tracer) && execution(Column *(.., ExternalClass, ..)) && args(t1,..);
private pointcut findMethodD23(Column t1) : !within(Tracer) && execution(ExternalClass *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA24(Column t1, Class t2) : !within(Tracer) && execution(* *(.., Column, .., Class, ..)) && args(t1,t2,..);
private pointcut findMethodB24(Class t1, Column t2) : !within(Tracer) && execution(* *(.., Class, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC24(Class t1) : !within(Tracer) && execution(Column *(.., Class, ..)) && args(t1,..);
private pointcut findMethodD24(Column t1) : !within(Tracer) && execution(Class *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA25(Column t1, Datatype t2) : !within(Tracer) && execution(* *(.., Column, .., Datatype, ..)) && args(t1,t2,..);
private pointcut findMethodB25(Datatype t1, Column t2) : !within(Tracer) && execution(* *(.., Datatype, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC25(Datatype t1) : !within(Tracer) && execution(Column *(.., Datatype, ..)) && args(t1,..);
private pointcut findMethodD25(Column t1) : !within(Tracer) && execution(Datatype *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA26(Column t1, Operation t2) : !within(Tracer) && execution(* *(.., Column, .., Operation, ..)) && args(t1,t2,..);
private pointcut findMethodB26(Operation t1, Column t2) : !within(Tracer) && execution(* *(.., Operation, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC26(Operation t1) : !within(Tracer) && execution(Column *(.., Operation, ..)) && args(t1,..);
private pointcut findMethodD26(Column t1) : !within(Tracer) && execution(Operation *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA27(Column t1, Parameter t2) : !within(Tracer) && execution(* *(.., Column, .., Parameter, ..)) && args(t1,t2,..);
private pointcut findMethodB27(Parameter t1, Column t2) : !within(Tracer) && execution(* *(.., Parameter, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC27(Parameter t1) : !within(Tracer) && execution(Column *(.., Parameter, ..)) && args(t1,..);
private pointcut findMethodD27(Column t1) : !within(Tracer) && execution(Parameter *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA28(Column t1, Reference t2) : !within(Tracer) && execution(* *(.., Column, .., Reference, ..)) && args(t1,t2,..);
private pointcut findMethodB28(Reference t1, Column t2) : !within(Tracer) && execution(* *(.., Reference, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC28(Reference t1) : !within(Tracer) && execution(Column *(.., Reference, ..)) && args(t1,..);
private pointcut findMethodD28(Column t1) : !within(Tracer) && execution(Reference *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA29(Column t1, Attribute t2) : !within(Tracer) && execution(* *(.., Column, .., Attribute, ..)) && args(t1,t2,..);
private pointcut findMethodB29(Attribute t1, Column t2) : !within(Tracer) && execution(* *(.., Attribute, .., Column, ..)) && args(t1,t2,..);


private pointcut findMethodC29(Attribute t1) : !within(Tracer) && execution(Column *(.., Attribute, ..)) && args(t1,..);
private pointcut findMethodD29(Column t1) : !within(Tracer) && execution(Attribute *(.. , Column, ..)) && args(t1,..);

private pointcut findMethodA30(ForeignKey t1, Model t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., Model, ..)) && args(t1,t2,..);
private pointcut findMethodB30(Model t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., Model, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC30(Model t1) : !within(Tracer) && execution(ForeignKey *(.., Model, ..)) && args(t1,..);
private pointcut findMethodD30(ForeignKey t1) : !within(Tracer) && execution(Model *(.. , ForeignKey, ..)) && args(t1,..);

private pointcut findMethodA31(ForeignKey t1, Annotation t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., Annotation, ..)) && args(t1,t2,..);
private pointcut findMethodB31(Annotation t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., Annotation, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC31(Annotation t1) : !within(Tracer) && execution(ForeignKey *(.., Annotation, ..)) && args(t1,..);
private pointcut findMethodD31(ForeignKey t1) : !within(Tracer) && execution(Annotation *(.. , ForeignKey, ..)) && args(t1,..);

private pointcut findMethodA32(ForeignKey t1, Package t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., Package, ..)) && args(t1,t2,..);
private pointcut findMethodB32(Package t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., Package, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC32(Package t1) : !within(Tracer) && execution(ForeignKey *(.., Package, ..)) && args(t1,..);
private pointcut findMethodD32(ForeignKey t1) : !within(Tracer) && execution(Package *(.. , ForeignKey, ..)) && args(t1,..);

private pointcut findMethodA33(ForeignKey t1, ExternalClass t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., ExternalClass, ..)) && args(t1,t2,..);
private pointcut findMethodB33(ExternalClass t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., ExternalClass, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC33(ExternalClass t1) : !within(Tracer) && execution(ForeignKey *(.., ExternalClass, ..)) && args(t1,..);
private pointcut findMethodD33(ForeignKey t1) : !within(Tracer) && execution(ExternalClass *(.. , ForeignKey, ..)) && args(t1,..);

private pointcut findMethodA34(ForeignKey t1, Class t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., Class, ..)) && args(t1,t2,..);
private pointcut findMethodB34(Class t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., Class, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC34(Class t1) : !within(Tracer) && execution(ForeignKey *(.., Class, ..)) && args(t1,..);
private pointcut findMethodD34(ForeignKey t1) : !within(Tracer) && execution(Class *(.. , ForeignKey, ..)) && args(t1,..);

private pointcut findMethodA35(ForeignKey t1, Datatype t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., Datatype, ..)) && args(t1,t2,..);
private pointcut findMethodB35(Datatype t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., Datatype, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC35(Datatype t1) : !within(Tracer) && execution(ForeignKey *(.., Datatype, ..)) && args(t1,..);
private pointcut findMethodD35(ForeignKey t1) : !within(Tracer) && execution(Datatype *(.. , ForeignKey, ..)) && args(t1,..);

private pointcut findMethodA36(ForeignKey t1, Operation t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., Operation, ..)) && args(t1,t2,..);
private pointcut findMethodB36(Operation t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., Operation, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC36(Operation t1) : !within(Tracer) && execution(ForeignKey *(.., Operation, ..)) && args(t1,..);
private pointcut findMethodD36(ForeignKey t1) : !within(Tracer) && execution(Operation *(.. , ForeignKey, ..)) && args(t1,..);

private pointcut findMethodA37(ForeignKey t1, Parameter t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., Parameter, ..)) && args(t1,t2,..);
private pointcut findMethodB37(Parameter t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., Parameter, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC37(Parameter t1) : !within(Tracer) && execution(ForeignKey *(.., Parameter, ..)) && args(t1,..);
private pointcut findMethodD37(ForeignKey t1) : !within(Tracer) && execution(Parameter *(.. , ForeignKey, ..)) && args(t1,..);

private pointcut findMethodA38(ForeignKey t1, Reference t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., Reference, ..)) && args(t1,t2,..);
private pointcut findMethodB38(Reference t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., Reference, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC38(Reference t1) : !within(Tracer) && execution(ForeignKey *(.., Reference, ..)) && args(t1,..);
private pointcut findMethodD38(ForeignKey t1) : !within(Tracer) && execution(Reference *(.. , ForeignKey, ..)) && args(t1,..);

private pointcut findMethodA39(ForeignKey t1, Attribute t2) : !within(Tracer) && execution(* *(.., ForeignKey, .., Attribute, ..)) && args(t1,t2,..);
private pointcut findMethodB39(Attribute t1, ForeignKey t2) : !within(Tracer) && execution(* *(.., Attribute, .., ForeignKey, ..)) && args(t1,t2,..);


private pointcut findMethodC39(Attribute t1) : !within(Tracer) && execution(ForeignKey *(.., Attribute, ..)) && args(t1,..);
private pointcut findMethodD39(ForeignKey t1) : !within(Tracer) && execution(Attribute *(.. , ForeignKey, ..)) && args(t1,..);

//before(Object o) : belowMethod(o) {
//	System.out.println("matched: " +  thisJoinPoint.getSignature());
//}
//genertated by generateAdvisePCType1 first part

Object tA0 = null, tB0 = null;
after(Database t1, Model t2) : findMethodA0(t1, t2) {
	if(!this.tA0.equals(t1) || !this.tB0.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, Model t2) : findMethodA0(t1, t2) {
	
	//System.out.println("findMethodA0: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA0 = EcoreUtil.copy((EObject)t1);
	this.tB0 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Model t1, Database t2) : findMethodB0(t1, t2) {
	if(!this.tA0.equals(t1) || !this.tB0.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Model t1, Database t2) : findMethodB0(t1, t2) {
	
	//System.out.println("findMethodB0: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA0 = EcoreUtil.copy((EObject)t1);
	this.tB0 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Model t1) returning (Database returnValue): findMethodC0(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (Model returnValue): findMethodD0(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA1 = null, tB1 = null;
after(Database t1, Annotation t2) : findMethodA1(t1, t2) {
	if(!this.tA1.equals(t1) || !this.tB1.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, Annotation t2) : findMethodA1(t1, t2) {
	
	//System.out.println("findMethodA1: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA1 = EcoreUtil.copy((EObject)t1);
	this.tB1 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Annotation t1, Database t2) : findMethodB1(t1, t2) {
	if(!this.tA1.equals(t1) || !this.tB1.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Annotation t1, Database t2) : findMethodB1(t1, t2) {
	
	//System.out.println("findMethodB1: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA1 = EcoreUtil.copy((EObject)t1);
	this.tB1 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Annotation t1) returning (Database returnValue): findMethodC1(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (Annotation returnValue): findMethodD1(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA2 = null, tB2 = null;
after(Database t1, Package t2) : findMethodA2(t1, t2) {
	if(!this.tA2.equals(t1) || !this.tB2.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, Package t2) : findMethodA2(t1, t2) {
	
	//System.out.println("findMethodA2: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA2 = EcoreUtil.copy((EObject)t1);
	this.tB2 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Package t1, Database t2) : findMethodB2(t1, t2) {
	if(!this.tA2.equals(t1) || !this.tB2.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Package t1, Database t2) : findMethodB2(t1, t2) {
	
	//System.out.println("findMethodB2: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA2 = EcoreUtil.copy((EObject)t1);
	this.tB2 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Package t1) returning (Database returnValue): findMethodC2(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (Package returnValue): findMethodD2(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA3 = null, tB3 = null;
after(Database t1, ExternalClass t2) : findMethodA3(t1, t2) {
	if(!this.tA3.equals(t1) || !this.tB3.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, ExternalClass t2) : findMethodA3(t1, t2) {
	
	//System.out.println("findMethodA3: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA3 = EcoreUtil.copy((EObject)t1);
	this.tB3 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(ExternalClass t1, Database t2) : findMethodB3(t1, t2) {
	if(!this.tA3.equals(t1) || !this.tB3.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ExternalClass t1, Database t2) : findMethodB3(t1, t2) {
	
	//System.out.println("findMethodB3: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA3 = EcoreUtil.copy((EObject)t1);
	this.tB3 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(ExternalClass t1) returning (Database returnValue): findMethodC3(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (ExternalClass returnValue): findMethodD3(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA4 = null, tB4 = null;
after(Database t1, Class t2) : findMethodA4(t1, t2) {
	if(!this.tA4.equals(t1) || !this.tB4.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, Class t2) : findMethodA4(t1, t2) {
	
	//System.out.println("findMethodA4: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA4 = EcoreUtil.copy((EObject)t1);
	this.tB4 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Class t1, Database t2) : findMethodB4(t1, t2) {
	if(!this.tA4.equals(t1) || !this.tB4.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Class t1, Database t2) : findMethodB4(t1, t2) {
	
	//System.out.println("findMethodB4: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA4 = EcoreUtil.copy((EObject)t1);
	this.tB4 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Class t1) returning (Database returnValue): findMethodC4(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (Class returnValue): findMethodD4(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA5 = null, tB5 = null;
after(Database t1, Datatype t2) : findMethodA5(t1, t2) {
	if(!this.tA5.equals(t1) || !this.tB5.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, Datatype t2) : findMethodA5(t1, t2) {
	
	//System.out.println("findMethodA5: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA5 = EcoreUtil.copy((EObject)t1);
	this.tB5 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Datatype t1, Database t2) : findMethodB5(t1, t2) {
	if(!this.tA5.equals(t1) || !this.tB5.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Datatype t1, Database t2) : findMethodB5(t1, t2) {
	
	//System.out.println("findMethodB5: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA5 = EcoreUtil.copy((EObject)t1);
	this.tB5 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Datatype t1) returning (Database returnValue): findMethodC5(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (Datatype returnValue): findMethodD5(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA6 = null, tB6 = null;
after(Database t1, Operation t2) : findMethodA6(t1, t2) {
	if(!this.tA6.equals(t1) || !this.tB6.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, Operation t2) : findMethodA6(t1, t2) {
	
	//System.out.println("findMethodA6: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA6 = EcoreUtil.copy((EObject)t1);
	this.tB6 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Operation t1, Database t2) : findMethodB6(t1, t2) {
	if(!this.tA6.equals(t1) || !this.tB6.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Operation t1, Database t2) : findMethodB6(t1, t2) {
	
	//System.out.println("findMethodB6: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA6 = EcoreUtil.copy((EObject)t1);
	this.tB6 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Operation t1) returning (Database returnValue): findMethodC6(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (Operation returnValue): findMethodD6(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA7 = null, tB7 = null;
after(Database t1, Parameter t2) : findMethodA7(t1, t2) {
	if(!this.tA7.equals(t1) || !this.tB7.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, Parameter t2) : findMethodA7(t1, t2) {
	
	//System.out.println("findMethodA7: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA7 = EcoreUtil.copy((EObject)t1);
	this.tB7 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Parameter t1, Database t2) : findMethodB7(t1, t2) {
	if(!this.tA7.equals(t1) || !this.tB7.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Parameter t1, Database t2) : findMethodB7(t1, t2) {
	
	//System.out.println("findMethodB7: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA7 = EcoreUtil.copy((EObject)t1);
	this.tB7 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Parameter t1) returning (Database returnValue): findMethodC7(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (Parameter returnValue): findMethodD7(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA8 = null, tB8 = null;
after(Database t1, Reference t2) : findMethodA8(t1, t2) {
	if(!this.tA8.equals(t1) || !this.tB8.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, Reference t2) : findMethodA8(t1, t2) {
	
	//System.out.println("findMethodA8: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA8 = EcoreUtil.copy((EObject)t1);
	this.tB8 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Reference t1, Database t2) : findMethodB8(t1, t2) {
	if(!this.tA8.equals(t1) || !this.tB8.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Reference t1, Database t2) : findMethodB8(t1, t2) {
	
	//System.out.println("findMethodB8: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA8 = EcoreUtil.copy((EObject)t1);
	this.tB8 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Reference t1) returning (Database returnValue): findMethodC8(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (Reference returnValue): findMethodD8(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA9 = null, tB9 = null;
after(Database t1, Attribute t2) : findMethodA9(t1, t2) {
	if(!this.tA9.equals(t1) || !this.tB9.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Database t1, Attribute t2) : findMethodA9(t1, t2) {
	
	//System.out.println("findMethodA9: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA9 = EcoreUtil.copy((EObject)t1);
	this.tB9 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Attribute t1, Database t2) : findMethodB9(t1, t2) {
	if(!this.tA9.equals(t1) || !this.tB9.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Attribute t1, Database t2) : findMethodB9(t1, t2) {
	
	//System.out.println("findMethodB9: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA9 = EcoreUtil.copy((EObject)t1);
	this.tB9 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Attribute t1) returning (Database returnValue): findMethodC9(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Database t1) returning (Attribute returnValue): findMethodD9(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA10 = null, tB10 = null;
after(Table t1, Model t2) : findMethodA10(t1, t2) {
	if(!this.tA10.equals(t1) || !this.tB10.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, Model t2) : findMethodA10(t1, t2) {
	
	//System.out.println("findMethodA10: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA10 = EcoreUtil.copy((EObject)t1);
	this.tB10 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Model t1, Table t2) : findMethodB10(t1, t2) {
	if(!this.tA10.equals(t1) || !this.tB10.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Model t1, Table t2) : findMethodB10(t1, t2) {
	
	//System.out.println("findMethodB10: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA10 = EcoreUtil.copy((EObject)t1);
	this.tB10 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Model t1) returning (Table returnValue): findMethodC10(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (Model returnValue): findMethodD10(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA11 = null, tB11 = null;
after(Table t1, Annotation t2) : findMethodA11(t1, t2) {
	if(!this.tA11.equals(t1) || !this.tB11.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, Annotation t2) : findMethodA11(t1, t2) {
	
	//System.out.println("findMethodA11: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA11 = EcoreUtil.copy((EObject)t1);
	this.tB11 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Annotation t1, Table t2) : findMethodB11(t1, t2) {
	if(!this.tA11.equals(t1) || !this.tB11.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Annotation t1, Table t2) : findMethodB11(t1, t2) {
	
	//System.out.println("findMethodB11: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA11 = EcoreUtil.copy((EObject)t1);
	this.tB11 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Annotation t1) returning (Table returnValue): findMethodC11(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (Annotation returnValue): findMethodD11(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA12 = null, tB12 = null;
after(Table t1, Package t2) : findMethodA12(t1, t2) {
	if(!this.tA12.equals(t1) || !this.tB12.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, Package t2) : findMethodA12(t1, t2) {
	
	//System.out.println("findMethodA12: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA12 = EcoreUtil.copy((EObject)t1);
	this.tB12 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Package t1, Table t2) : findMethodB12(t1, t2) {
	if(!this.tA12.equals(t1) || !this.tB12.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Package t1, Table t2) : findMethodB12(t1, t2) {
	
	//System.out.println("findMethodB12: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA12 = EcoreUtil.copy((EObject)t1);
	this.tB12 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Package t1) returning (Table returnValue): findMethodC12(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (Package returnValue): findMethodD12(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA13 = null, tB13 = null;
after(Table t1, ExternalClass t2) : findMethodA13(t1, t2) {
	if(!this.tA13.equals(t1) || !this.tB13.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, ExternalClass t2) : findMethodA13(t1, t2) {
	
	//System.out.println("findMethodA13: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA13 = EcoreUtil.copy((EObject)t1);
	this.tB13 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(ExternalClass t1, Table t2) : findMethodB13(t1, t2) {
	if(!this.tA13.equals(t1) || !this.tB13.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ExternalClass t1, Table t2) : findMethodB13(t1, t2) {
	
	//System.out.println("findMethodB13: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA13 = EcoreUtil.copy((EObject)t1);
	this.tB13 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(ExternalClass t1) returning (Table returnValue): findMethodC13(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (ExternalClass returnValue): findMethodD13(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA14 = null, tB14 = null;
after(Table t1, Class t2) : findMethodA14(t1, t2) {
	if(!this.tA14.equals(t1) || !this.tB14.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, Class t2) : findMethodA14(t1, t2) {
	
	//System.out.println("findMethodA14: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA14 = EcoreUtil.copy((EObject)t1);
	this.tB14 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Class t1, Table t2) : findMethodB14(t1, t2) {
	if(!this.tA14.equals(t1) || !this.tB14.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Class t1, Table t2) : findMethodB14(t1, t2) {
	
	//System.out.println("findMethodB14: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA14 = EcoreUtil.copy((EObject)t1);
	this.tB14 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Class t1) returning (Table returnValue): findMethodC14(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (Class returnValue): findMethodD14(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA15 = null, tB15 = null;
after(Table t1, Datatype t2) : findMethodA15(t1, t2) {
	if(!this.tA15.equals(t1) || !this.tB15.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, Datatype t2) : findMethodA15(t1, t2) {
	
	//System.out.println("findMethodA15: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA15 = EcoreUtil.copy((EObject)t1);
	this.tB15 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Datatype t1, Table t2) : findMethodB15(t1, t2) {
	if(!this.tA15.equals(t1) || !this.tB15.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Datatype t1, Table t2) : findMethodB15(t1, t2) {
	
	//System.out.println("findMethodB15: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA15 = EcoreUtil.copy((EObject)t1);
	this.tB15 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Datatype t1) returning (Table returnValue): findMethodC15(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (Datatype returnValue): findMethodD15(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA16 = null, tB16 = null;
after(Table t1, Operation t2) : findMethodA16(t1, t2) {
	if(!this.tA16.equals(t1) || !this.tB16.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, Operation t2) : findMethodA16(t1, t2) {
	
	//System.out.println("findMethodA16: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA16 = EcoreUtil.copy((EObject)t1);
	this.tB16 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Operation t1, Table t2) : findMethodB16(t1, t2) {
	if(!this.tA16.equals(t1) || !this.tB16.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Operation t1, Table t2) : findMethodB16(t1, t2) {
	
	//System.out.println("findMethodB16: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA16 = EcoreUtil.copy((EObject)t1);
	this.tB16 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Operation t1) returning (Table returnValue): findMethodC16(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (Operation returnValue): findMethodD16(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA17 = null, tB17 = null;
after(Table t1, Parameter t2) : findMethodA17(t1, t2) {
	if(!this.tA17.equals(t1) || !this.tB17.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, Parameter t2) : findMethodA17(t1, t2) {
	
	//System.out.println("findMethodA17: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA17 = EcoreUtil.copy((EObject)t1);
	this.tB17 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Parameter t1, Table t2) : findMethodB17(t1, t2) {
	if(!this.tA17.equals(t1) || !this.tB17.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Parameter t1, Table t2) : findMethodB17(t1, t2) {
	
	//System.out.println("findMethodB17: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA17 = EcoreUtil.copy((EObject)t1);
	this.tB17 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Parameter t1) returning (Table returnValue): findMethodC17(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (Parameter returnValue): findMethodD17(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA18 = null, tB18 = null;
after(Table t1, Reference t2) : findMethodA18(t1, t2) {
	if(!this.tA18.equals(t1) || !this.tB18.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, Reference t2) : findMethodA18(t1, t2) {
	
	//System.out.println("findMethodA18: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA18 = EcoreUtil.copy((EObject)t1);
	this.tB18 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Reference t1, Table t2) : findMethodB18(t1, t2) {
	if(!this.tA18.equals(t1) || !this.tB18.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Reference t1, Table t2) : findMethodB18(t1, t2) {
	
	//System.out.println("findMethodB18: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA18 = EcoreUtil.copy((EObject)t1);
	this.tB18 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Reference t1) returning (Table returnValue): findMethodC18(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (Reference returnValue): findMethodD18(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA19 = null, tB19 = null;
after(Table t1, Attribute t2) : findMethodA19(t1, t2) {
	if(!this.tA19.equals(t1) || !this.tB19.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Table t1, Attribute t2) : findMethodA19(t1, t2) {
	
	//System.out.println("findMethodA19: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA19 = EcoreUtil.copy((EObject)t1);
	this.tB19 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Attribute t1, Table t2) : findMethodB19(t1, t2) {
	if(!this.tA19.equals(t1) || !this.tB19.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Attribute t1, Table t2) : findMethodB19(t1, t2) {
	
	//System.out.println("findMethodB19: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA19 = EcoreUtil.copy((EObject)t1);
	this.tB19 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Attribute t1) returning (Table returnValue): findMethodC19(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Table t1) returning (Attribute returnValue): findMethodD19(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA20 = null, tB20 = null;
after(Column t1, Model t2) : findMethodA20(t1, t2) {
	if(!this.tA20.equals(t1) || !this.tB20.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, Model t2) : findMethodA20(t1, t2) {
	
	//System.out.println("findMethodA20: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA20 = EcoreUtil.copy((EObject)t1);
	this.tB20 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Model t1, Column t2) : findMethodB20(t1, t2) {
	if(!this.tA20.equals(t1) || !this.tB20.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Model t1, Column t2) : findMethodB20(t1, t2) {
	
	//System.out.println("findMethodB20: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA20 = EcoreUtil.copy((EObject)t1);
	this.tB20 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Model t1) returning (Column returnValue): findMethodC20(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (Model returnValue): findMethodD20(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA21 = null, tB21 = null;
after(Column t1, Annotation t2) : findMethodA21(t1, t2) {
	if(!this.tA21.equals(t1) || !this.tB21.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, Annotation t2) : findMethodA21(t1, t2) {
	
	//System.out.println("findMethodA21: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA21 = EcoreUtil.copy((EObject)t1);
	this.tB21 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Annotation t1, Column t2) : findMethodB21(t1, t2) {
	if(!this.tA21.equals(t1) || !this.tB21.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Annotation t1, Column t2) : findMethodB21(t1, t2) {
	
	//System.out.println("findMethodB21: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA21 = EcoreUtil.copy((EObject)t1);
	this.tB21 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Annotation t1) returning (Column returnValue): findMethodC21(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (Annotation returnValue): findMethodD21(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA22 = null, tB22 = null;
after(Column t1, Package t2) : findMethodA22(t1, t2) {
	if(!this.tA22.equals(t1) || !this.tB22.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, Package t2) : findMethodA22(t1, t2) {
	
	//System.out.println("findMethodA22: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA22 = EcoreUtil.copy((EObject)t1);
	this.tB22 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Package t1, Column t2) : findMethodB22(t1, t2) {
	if(!this.tA22.equals(t1) || !this.tB22.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Package t1, Column t2) : findMethodB22(t1, t2) {
	
	//System.out.println("findMethodB22: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA22 = EcoreUtil.copy((EObject)t1);
	this.tB22 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Package t1) returning (Column returnValue): findMethodC22(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (Package returnValue): findMethodD22(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA23 = null, tB23 = null;
after(Column t1, ExternalClass t2) : findMethodA23(t1, t2) {
	if(!this.tA23.equals(t1) || !this.tB23.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, ExternalClass t2) : findMethodA23(t1, t2) {
	
	//System.out.println("findMethodA23: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA23 = EcoreUtil.copy((EObject)t1);
	this.tB23 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(ExternalClass t1, Column t2) : findMethodB23(t1, t2) {
	if(!this.tA23.equals(t1) || !this.tB23.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ExternalClass t1, Column t2) : findMethodB23(t1, t2) {
	
	//System.out.println("findMethodB23: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA23 = EcoreUtil.copy((EObject)t1);
	this.tB23 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(ExternalClass t1) returning (Column returnValue): findMethodC23(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (ExternalClass returnValue): findMethodD23(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA24 = null, tB24 = null;
after(Column t1, Class t2) : findMethodA24(t1, t2) {
	if(!this.tA24.equals(t1) || !this.tB24.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, Class t2) : findMethodA24(t1, t2) {
	
	//System.out.println("findMethodA24: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA24 = EcoreUtil.copy((EObject)t1);
	this.tB24 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Class t1, Column t2) : findMethodB24(t1, t2) {
	if(!this.tA24.equals(t1) || !this.tB24.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Class t1, Column t2) : findMethodB24(t1, t2) {
	
	//System.out.println("findMethodB24: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA24 = EcoreUtil.copy((EObject)t1);
	this.tB24 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Class t1) returning (Column returnValue): findMethodC24(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (Class returnValue): findMethodD24(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA25 = null, tB25 = null;
after(Column t1, Datatype t2) : findMethodA25(t1, t2) {
	if(!this.tA25.equals(t1) || !this.tB25.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, Datatype t2) : findMethodA25(t1, t2) {
	
	//System.out.println("findMethodA25: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA25 = EcoreUtil.copy((EObject)t1);
	this.tB25 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Datatype t1, Column t2) : findMethodB25(t1, t2) {
	if(!this.tA25.equals(t1) || !this.tB25.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Datatype t1, Column t2) : findMethodB25(t1, t2) {
	
	//System.out.println("findMethodB25: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA25 = EcoreUtil.copy((EObject)t1);
	this.tB25 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Datatype t1) returning (Column returnValue): findMethodC25(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (Datatype returnValue): findMethodD25(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA26 = null, tB26 = null;
after(Column t1, Operation t2) : findMethodA26(t1, t2) {
	if(!this.tA26.equals(t1) || !this.tB26.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, Operation t2) : findMethodA26(t1, t2) {
	
	//System.out.println("findMethodA26: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA26 = EcoreUtil.copy((EObject)t1);
	this.tB26 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Operation t1, Column t2) : findMethodB26(t1, t2) {
	if(!this.tA26.equals(t1) || !this.tB26.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Operation t1, Column t2) : findMethodB26(t1, t2) {
	
	//System.out.println("findMethodB26: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA26 = EcoreUtil.copy((EObject)t1);
	this.tB26 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Operation t1) returning (Column returnValue): findMethodC26(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (Operation returnValue): findMethodD26(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA27 = null, tB27 = null;
after(Column t1, Parameter t2) : findMethodA27(t1, t2) {
	if(!this.tA27.equals(t1) || !this.tB27.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, Parameter t2) : findMethodA27(t1, t2) {
	
	//System.out.println("findMethodA27: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA27 = EcoreUtil.copy((EObject)t1);
	this.tB27 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Parameter t1, Column t2) : findMethodB27(t1, t2) {
	if(!this.tA27.equals(t1) || !this.tB27.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Parameter t1, Column t2) : findMethodB27(t1, t2) {
	
	//System.out.println("findMethodB27: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA27 = EcoreUtil.copy((EObject)t1);
	this.tB27 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Parameter t1) returning (Column returnValue): findMethodC27(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (Parameter returnValue): findMethodD27(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA28 = null, tB28 = null;
after(Column t1, Reference t2) : findMethodA28(t1, t2) {
	if(!this.tA28.equals(t1) || !this.tB28.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, Reference t2) : findMethodA28(t1, t2) {
	
	//System.out.println("findMethodA28: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA28 = EcoreUtil.copy((EObject)t1);
	this.tB28 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Reference t1, Column t2) : findMethodB28(t1, t2) {
	if(!this.tA28.equals(t1) || !this.tB28.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Reference t1, Column t2) : findMethodB28(t1, t2) {
	
	//System.out.println("findMethodB28: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA28 = EcoreUtil.copy((EObject)t1);
	this.tB28 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Reference t1) returning (Column returnValue): findMethodC28(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (Reference returnValue): findMethodD28(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA29 = null, tB29 = null;
after(Column t1, Attribute t2) : findMethodA29(t1, t2) {
	if(!this.tA29.equals(t1) || !this.tB29.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Column t1, Attribute t2) : findMethodA29(t1, t2) {
	
	//System.out.println("findMethodA29: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA29 = EcoreUtil.copy((EObject)t1);
	this.tB29 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Attribute t1, Column t2) : findMethodB29(t1, t2) {
	if(!this.tA29.equals(t1) || !this.tB29.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Attribute t1, Column t2) : findMethodB29(t1, t2) {
	
	//System.out.println("findMethodB29: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA29 = EcoreUtil.copy((EObject)t1);
	this.tB29 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Attribute t1) returning (Column returnValue): findMethodC29(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(Column t1) returning (Attribute returnValue): findMethodD29(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA30 = null, tB30 = null;
after(ForeignKey t1, Model t2) : findMethodA30(t1, t2) {
	if(!this.tA30.equals(t1) || !this.tB30.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, Model t2) : findMethodA30(t1, t2) {
	
	//System.out.println("findMethodA30: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA30 = EcoreUtil.copy((EObject)t1);
	this.tB30 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Model t1, ForeignKey t2) : findMethodB30(t1, t2) {
	if(!this.tA30.equals(t1) || !this.tB30.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Model t1, ForeignKey t2) : findMethodB30(t1, t2) {
	
	//System.out.println("findMethodB30: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA30 = EcoreUtil.copy((EObject)t1);
	this.tB30 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Model t1) returning (ForeignKey returnValue): findMethodC30(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (Model returnValue): findMethodD30(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA31 = null, tB31 = null;
after(ForeignKey t1, Annotation t2) : findMethodA31(t1, t2) {
	if(!this.tA31.equals(t1) || !this.tB31.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, Annotation t2) : findMethodA31(t1, t2) {
	
	//System.out.println("findMethodA31: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA31 = EcoreUtil.copy((EObject)t1);
	this.tB31 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Annotation t1, ForeignKey t2) : findMethodB31(t1, t2) {
	if(!this.tA31.equals(t1) || !this.tB31.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Annotation t1, ForeignKey t2) : findMethodB31(t1, t2) {
	
	//System.out.println("findMethodB31: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA31 = EcoreUtil.copy((EObject)t1);
	this.tB31 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Annotation t1) returning (ForeignKey returnValue): findMethodC31(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (Annotation returnValue): findMethodD31(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA32 = null, tB32 = null;
after(ForeignKey t1, Package t2) : findMethodA32(t1, t2) {
	if(!this.tA32.equals(t1) || !this.tB32.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, Package t2) : findMethodA32(t1, t2) {
	
	//System.out.println("findMethodA32: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA32 = EcoreUtil.copy((EObject)t1);
	this.tB32 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Package t1, ForeignKey t2) : findMethodB32(t1, t2) {
	if(!this.tA32.equals(t1) || !this.tB32.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Package t1, ForeignKey t2) : findMethodB32(t1, t2) {
	
	//System.out.println("findMethodB32: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA32 = EcoreUtil.copy((EObject)t1);
	this.tB32 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Package t1) returning (ForeignKey returnValue): findMethodC32(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (Package returnValue): findMethodD32(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA33 = null, tB33 = null;
after(ForeignKey t1, ExternalClass t2) : findMethodA33(t1, t2) {
	if(!this.tA33.equals(t1) || !this.tB33.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, ExternalClass t2) : findMethodA33(t1, t2) {
	
	//System.out.println("findMethodA33: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA33 = EcoreUtil.copy((EObject)t1);
	this.tB33 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(ExternalClass t1, ForeignKey t2) : findMethodB33(t1, t2) {
	if(!this.tA33.equals(t1) || !this.tB33.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ExternalClass t1, ForeignKey t2) : findMethodB33(t1, t2) {
	
	//System.out.println("findMethodB33: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA33 = EcoreUtil.copy((EObject)t1);
	this.tB33 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(ExternalClass t1) returning (ForeignKey returnValue): findMethodC33(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (ExternalClass returnValue): findMethodD33(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA34 = null, tB34 = null;
after(ForeignKey t1, Class t2) : findMethodA34(t1, t2) {
	if(!this.tA34.equals(t1) || !this.tB34.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, Class t2) : findMethodA34(t1, t2) {
	
	//System.out.println("findMethodA34: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA34 = EcoreUtil.copy((EObject)t1);
	this.tB34 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Class t1, ForeignKey t2) : findMethodB34(t1, t2) {
	if(!this.tA34.equals(t1) || !this.tB34.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Class t1, ForeignKey t2) : findMethodB34(t1, t2) {
	
	//System.out.println("findMethodB34: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA34 = EcoreUtil.copy((EObject)t1);
	this.tB34 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Class t1) returning (ForeignKey returnValue): findMethodC34(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (Class returnValue): findMethodD34(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA35 = null, tB35 = null;
after(ForeignKey t1, Datatype t2) : findMethodA35(t1, t2) {
	if(!this.tA35.equals(t1) || !this.tB35.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, Datatype t2) : findMethodA35(t1, t2) {
	
	//System.out.println("findMethodA35: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA35 = EcoreUtil.copy((EObject)t1);
	this.tB35 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Datatype t1, ForeignKey t2) : findMethodB35(t1, t2) {
	if(!this.tA35.equals(t1) || !this.tB35.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Datatype t1, ForeignKey t2) : findMethodB35(t1, t2) {
	
	//System.out.println("findMethodB35: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA35 = EcoreUtil.copy((EObject)t1);
	this.tB35 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Datatype t1) returning (ForeignKey returnValue): findMethodC35(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (Datatype returnValue): findMethodD35(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA36 = null, tB36 = null;
after(ForeignKey t1, Operation t2) : findMethodA36(t1, t2) {
	if(!this.tA36.equals(t1) || !this.tB36.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, Operation t2) : findMethodA36(t1, t2) {
	
	//System.out.println("findMethodA36: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA36 = EcoreUtil.copy((EObject)t1);
	this.tB36 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Operation t1, ForeignKey t2) : findMethodB36(t1, t2) {
	if(!this.tA36.equals(t1) || !this.tB36.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Operation t1, ForeignKey t2) : findMethodB36(t1, t2) {
	
	//System.out.println("findMethodB36: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA36 = EcoreUtil.copy((EObject)t1);
	this.tB36 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Operation t1) returning (ForeignKey returnValue): findMethodC36(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (Operation returnValue): findMethodD36(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA37 = null, tB37 = null;
after(ForeignKey t1, Parameter t2) : findMethodA37(t1, t2) {
	if(!this.tA37.equals(t1) || !this.tB37.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, Parameter t2) : findMethodA37(t1, t2) {
	
	//System.out.println("findMethodA37: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA37 = EcoreUtil.copy((EObject)t1);
	this.tB37 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Parameter t1, ForeignKey t2) : findMethodB37(t1, t2) {
	if(!this.tA37.equals(t1) || !this.tB37.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Parameter t1, ForeignKey t2) : findMethodB37(t1, t2) {
	
	//System.out.println("findMethodB37: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA37 = EcoreUtil.copy((EObject)t1);
	this.tB37 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Parameter t1) returning (ForeignKey returnValue): findMethodC37(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (Parameter returnValue): findMethodD37(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA38 = null, tB38 = null;
after(ForeignKey t1, Reference t2) : findMethodA38(t1, t2) {
	if(!this.tA38.equals(t1) || !this.tB38.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, Reference t2) : findMethodA38(t1, t2) {
	
	//System.out.println("findMethodA38: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA38 = EcoreUtil.copy((EObject)t1);
	this.tB38 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Reference t1, ForeignKey t2) : findMethodB38(t1, t2) {
	if(!this.tA38.equals(t1) || !this.tB38.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Reference t1, ForeignKey t2) : findMethodB38(t1, t2) {
	
	//System.out.println("findMethodB38: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA38 = EcoreUtil.copy((EObject)t1);
	this.tB38 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Reference t1) returning (ForeignKey returnValue): findMethodC38(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (Reference returnValue): findMethodD38(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType1 first part

Object tA39 = null, tB39 = null;
after(ForeignKey t1, Attribute t2) : findMethodA39(t1, t2) {
	if(!this.tA39.equals(t1) || !this.tB39.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(ForeignKey t1, Attribute t2) : findMethodA39(t1, t2) {
	
	//System.out.println("findMethodA39: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA39 = EcoreUtil.copy((EObject)t1);
	this.tB39 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType1 second part			
after(Attribute t1, ForeignKey t2) : findMethodB39(t1, t2) {
	if(!this.tA39.equals(t1) || !this.tB39.equals(t2)) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setTrace(t1, thisJoinPoint, t2);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " <--> " + EcoreUtil.getURI((EObject)t2) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}

before(Attribute t1, ForeignKey t2) : findMethodB39(t1, t2) {
	
	//System.out.println("findMethodB39: " +  thisJoinPoint.getSignature().toShortString());
	
	this.tA39 = EcoreUtil.copy((EObject)t1);
	this.tB39 = EcoreUtil.copy((EObject)t2);
}
//genertated by generateAdvisePCType2 first part
after(Attribute t1) returning (ForeignKey returnValue): findMethodC39(t1) {		
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
//genertated by generateAdvisePCType2 second part
after(ForeignKey t1) returning (Attribute returnValue): findMethodD39(t1) {				
	if(t1 != null && returnValue != null) {
		TraceCollector tc = TraceCollector.getInstance();
		tc.setDirectedTrace(t1, thisJoinPoint, returnValue);
		System.out.println("trace " + EcoreUtil.getURI((EObject)t1) + " --> " + EcoreUtil.getURI((EObject)returnValue) + " by " +  thisJoinPoint.getSignature().toShortString() + " in " + thisJoinPoint.getSourceLocation().toString());
	}
}
}