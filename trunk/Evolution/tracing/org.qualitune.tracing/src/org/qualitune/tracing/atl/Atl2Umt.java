/**
 * 
 */
package org.qualitune.tracing.atl;

import org.apache.log4j.Logger;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.qualitune.tracing.atl.ATL.Module;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.UmtFactory;
import org.qualitune.tracing.umt.UmtPackage;
import org.qualitune.tracing.util.VUtil;

/**
 * Encapsulates transformation ATL -> UMT
 * 
 * @author Fabian Haensel
 *
 */
public class Atl2Umt {

	protected Logger logger;
	
	
	UmtFactory _umtFactory;
	UmtPackage _umtPackage;
		
	// maps UMT elements to ATL ones
	TranslationTable translationTable;
	
	// root elements
	Program program = null;
	
	public Atl2Umt (Module module) {
		logger = Logger.getLogger(Atl2Umt.class);
		
		_umtFactory = UmtFactory.eINSTANCE;
		_umtPackage = UmtPackage.eINSTANCE;
		
//		Atl2UmtRunner runner = new Atl2UmtRunner();
//		program = runner.run(module);
//		translationTable = new TranslationTable(); 

		Atl2UmtClassic c = new Atl2UmtClassic();
		program = c.module2program(module);
		
//		IReferenceModel atlMetamodel = new AtlParser().getAtlMetamodel();
//		OldAtl2Umt c = new OldAtl2Umt(atlMetamodel);
//		program = c.module2program(module);
	}
	
	public Program getProgram() {
		return program;
	}
}
