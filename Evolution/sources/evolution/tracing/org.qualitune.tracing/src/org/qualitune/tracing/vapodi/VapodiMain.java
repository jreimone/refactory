package org.qualitune.tracing.vapodi;
import org.apache.log4j.PropertyConfigurator;
import org.qualitune.tracing.atl.AtlHandler;
import org.qualitune.tracing.umt.ModelAttributeVariable;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.UmtFactory;
import org.qualitune.tracing.vapodi.analysis.AnalysisRunner;
import org.qualitune.tracing.vapodi.analysis.ControlFlowStack;
import org.qualitune.tracing.vapodi.analysis.IUmtAnalysis;
import org.qualitune.tracing.vapodi.analysis.Shadow;
import org.qualitune.tracing.vapodi.analysis.SymbolTable;
import org.qualitune.tracing.vapodi.analysis.TraceLinks;

/**
 * Front-end program to showcase VAPODI
 * @author Fabian Haensel
 *
 */
public class VapodiMain {
	
	public static void main(String[] args) {
		long start, end;
		IConcreteLanguageHandler myAtlHandler;
		Program program;
		
		start = System.currentTimeMillis();
		
		PropertyConfigurator.configure("log4j.properties");
		
		/*
		 * load model of source program
		 */
		
//		String PathIn = "in/Families2Persons.atl";
//		String PathOut = "out/Families2Persons.atl";
		
		String PathIn = "in/everyone_is_an_equal_citizen.atl";
		String PathOut = "out/everyone_is_an_equal_citizen.atl";
		
		myAtlHandler = new AtlHandler();
		if (! myAtlHandler.loadModel(PathIn))
			System.err.println("error");
		
		program = myAtlHandler.getUmtRepresentation();
		
		/*
		 * analyse source program and make changes ('invade'/'instrument' it)
		 */
		
		//Analyses analyses = new Analyses();
		//analyses.setName(program);
		//analyses.addDebugToAllFunctions(program);
		//analyses.addTracingModel(program);
		//analyses.addCfs(program);
		
		AnalysisRunner runner = new AnalysisRunner();
		
		IUmtAnalysis SymbolTable = new SymbolTable();
		IUmtAnalysis Shadow = new Shadow();
		IUmtAnalysis CFS = new ControlFlowStack();
		IUmtAnalysis TL = new TraceLinks();
		
		runner.addAnalysis(SymbolTable);
		runner.addAnalysis(Shadow);
		runner.addAnalysis(CFS);
		runner.addAnalysis(TL);
		
		UmtFactory _umtFactory = UmtFactory.eINSTANCE;
		ModelAttributeVariable test = _umtFactory.createModelAttributeVariable();
		runner.run(program);
		
		/*
		 * finally write modified program
		 */
		
		myAtlHandler.writeModel(PathOut);
		
		end = System.currentTimeMillis();
		
		System.out.println("Time elapsed: " + (end-start) + " ms");
	}
}
