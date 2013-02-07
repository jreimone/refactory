package org.qualitune.tracing.vapodi;
import org.qualitune.tracing.atl.AtlHandler;
import org.qualitune.tracing.umt.Program;

/**
 * Front-end program to showcase VAPODI
 * @author Fabian Haensel
 *
 */
public class VapodiMain {
	
	public static void main(String[] args) {
		long start, end;
		AtlHandler myAtlHandler;
		Program program;
		
		start = System.currentTimeMillis();
		
		/*
		 * load model of source program
		 */
		
//		String PathIn = "in/Families2Persons.atl";
//		String PathOut = "out/Families2Persons.atl";
		
		String PathIn = "in/everyone_is_an_equal_citizen.atl";
		String PathOut = "out/everyone_is_an_equal_citizen.atl";
		
		myAtlHandler = new AtlHandler();
		myAtlHandler.loadModel(PathIn);
		program = myAtlHandler.getUmtRepresentation();
		
		/*
		 * analyse source program and make changes ('invade'/'instrument' it)
		 */
		
		Analyses analyses = new Analyses();
		
		//analyses.setName(program);
		//analyses.addDebugToAllFunctions(program);
		//analyses.addTracingModel(program);
		analyses.addCfs(program);
		
		/*
		 * finally write modified program
		 */
		
		myAtlHandler.writeModel(PathOut);
		
		end = System.currentTimeMillis();
		
		System.out.println("Time elapsed: " + (end-start) + " ms");
	}
}
