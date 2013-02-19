package org.refactory.matching.greql;

import java.io.File;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.pcollections.ArrayPSet;
import org.pcollections.ArrayPVector;
import org.pcollections.OrderedPSet;

import util.Writer2txt;

import de.uni_koblenz.jgralab.greql.GreqlQuery;
import de.uni_koblenz.jgralab.greql.evaluator.GreqlEnvironmentAdapter;
import de.uni_koblenz.jgralab.greql.evaluator.GreqlEvaluatorImpl;
import de.uni_koblenz.jgralab.greql.types.Tuple;

public class CreateGraphTest {

	/**
	 * Testet ExtractXWithReferenceClass-Struktur auf einfaches Caller->Callee Pattern
	 */
	@Ignore
	@Test
	public void testSimpleGraphWithCCP() {
		System.out.println("START~~~~Simple-Struktur CCP~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraphExtractXWithReferenceClass();
		
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/test2.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~Simple-Struktur CCP~~~");
		System.out.println();
	}
	
	/**
	 * Testet PL0-Struktur auf einfaches Caller->Callee Pattern
	 */
	@Ignore
	@Test
	public void testAdvancedGraphWithCCP() {
		System.out.println("START~~~~PL0-Struktur CCP~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraph();
		
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/test2.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~PL0-Struktur CCP~~~");
		System.out.println();
	}
	
	/**
	 * Testet ExtractXWithReferenceClass-Struktur auf EXWRC-Pattern ohne Connection
	 */
	@Ignore
	@Test
	public void testSimpleGraphWithEXWRCWithoutCon() {
		System.out.println("START~~~~Simple-Struktur EXWR ohne Con~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraphExtractXWithReferenceClass();
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/extractXWithReferenceClass.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~Simple-Struktur EXWR ohne Con~~~");
		System.out.println();
	}
	
	/**
	 * Testet PL0-Struktur auf EXWRC-Pattern ohne Connection
	 */
	@Ignore
	@Test
	public void testAdvancedGraphWithEXWRCWithoutCon() {
		System.out.println("START~~~~PL0-Struktur EXWRC ohne Con~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraph();
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/extractXWithReferenceClass.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~PL0-Struktur EXWRC ohne Con~~~");
		System.out.println();
	}
	
	/**
	 * Testet ExtractXWithReferenceClass-Struktur auf EXWRC-Pattern mit Connection
	 */
	@Ignore
	@Test
	public void testSimpleGraphWithEXWRCWithCon() {
		System.out.println("START~~~~Simple-Struktur EXWRC mit Con~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraphExtractXWithReferenceClass();
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/extractXWithReferenceClass2.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~Simple-Struktur EXWR mit Con~~~");
		System.out.println();
	}
	
	/**
	 * Testet PL0-Struktur auf EXWRC-Pattern mit Connection
	 */
	@Ignore
	@Test
	public void testAdvancedGraphWithEXWRCWithCon() {
		System.out.println("START~~~~PL0-Struktur EXWR mit Con~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraph();
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/extractXWithReferenceClass2.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~PL0-Struktur EXWR mit Con~~~");
		System.out.println();
	}
	
	/**
	 * Einfacher Test
	 */
	@Ignore
	@Test
	public void testSimple() {
		System.out.println("START~~~~Einfacher Test~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraphSimpleStructure();
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/simpleCon.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~Einfacher Test~~~");
		System.out.println();
	}
	
	/**
	 * Einfacher Test mit Ausgabe Connection
	 */
	@Ignore
	@Test
	public void testSimpleWith() {
		System.out.println("START~~~~Einfacher Test mit Ausgabe~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraphSimpleStructure();
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/SimpleConWith.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~Einfacher Test mit Ausgabe~~~");
		System.out.println();
	}
	
	/**
	 * PL0-Graph (mit Vererbung) Suche nach Connection mit Ausgabe
	 */
	@Ignore
	@Test
	public void testPL0Con() {
		System.out.println("START~~~~PL0-Graph (inkl.Vererbung) Con mit Ausgabe~~~");
		CreateGraph cg=new CreateGraph(); //Klasse zur Grapherstellung
		cg.init(); //PL0-Metamodell initialisieren
		cg.createGraphWithInheritance(); //Graph erstellen
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/SimpleConWith.tg"); //Query als tg-Datei
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file); //File auslesen
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		ArrayPVector  o=(ArrayPVector) ge.evaluate(); //eigentliche Berechnung
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~PL0-Graph (inkl.Vererbung) Con mit Ausgabe~~~");
		System.out.println();
	}
	
	/**
	 * PL0-Graph (mit Vererbung) Suche nach EXWRC ohne Con
	 */
	@Ignore
	@Test
	public void testPL0EXWRC() {
		System.out.println("START~~~~PL0-Graph (inkl.Vererbung) EXWRC ohne Ausgabe~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraphWithInheritance();
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/extractXWithReferenceClass.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~PL0-Graph (inkl.Vererbung) EXWRC ohne Ausgabe~~~");
		System.out.println();
	}
	
	/**
	 * PL0-Graph (mit Vererbung) Suche nach EXWRC mit Con
	 */
	@Ignore
	@Test
	public void testPL0EXWRCCon() {
		System.out.println("START~~~~PL0-Graph (inkl.Vererbung) EXWRC mit Ausgabe~~~");
		CreateGraph cg=new CreateGraph();
		cg.init();
		cg.createGraphWithInheritance();
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/extractXWithReferenceClass2.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
		ArrayPVector  o=(ArrayPVector) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~PL0-Graph (inkl.Vererbung) EXWRC mit Ausgabe~~~");
		System.out.println();
	}
	
	/**
	 * PL0-Graph (mit Vererbung) Suche mit Tassilos Lösung
	 */
	@Ignore
	@Test
	public void testPL0Tassilo() {
		System.out.println("START~~~~PL0-Graph Tassilo~~~");
		CreateGraph cg=new CreateGraph(); //Klasse zur Grapherstellung
		cg.init(); //PL0-Metamodell initialisieren
		cg.createGraphWithInheritance(); //Graph erstellen
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/tassiloEdited2.tg"); //Query als tg-Datei
//		File file=new File("C:/Users/Robert/testGReQL/GReQLPrototyp/src/testPathSystem.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file); //File auslesen
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
//		ArrayPSet  o=(ArrayPSet) ge.evaluate(); //eigentliche Berechnung
		OrderedPSet o=(OrderedPSet) ge.evaluate();
		System.out.println(o);
		System.out.println(o.size());
		System.out.println("END~~~~PL0-Graph Tassilo~~~");
		System.out.println();
	}
	
	/**
	 * PL0-Graph (mit Vererbung) Suche mit Tassilos Lösung
	 */
//	@Ignore
	@Test
	public void testPL0Tassilo2() {
		System.out.println("START~~~~PL0-Graph Tassilo~~~");
		
		Writer2txt w2t=new Writer2txt("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/ResultEXWRC.txt");
		String header="tassiloEdited3 -- EXWRC";
		
		java.util.Date now = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss:SSS");
		String ausgabe = sdf.format(now);
		w2t.writeLine(ausgabe);
		
		CreateGraph cg=new CreateGraph(); //Klasse zur Grapherstellung
		cg.init(); //PL0-Metamodell initialisieren
		cg.createGraphWithInheritance(); //Graph erstellen
		
		now = new java.util.Date();
		sdf = new java.text.SimpleDateFormat("HH:mm:ss:SSS");
		ausgabe = sdf.format(now);
		w2t.writeLine(ausgabe);
		
		File file=new File("C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.greql/src/tassiloEdited3.tg"); //Query als tg-Datei
//		File file=new File("C:/Users/Robert/testGReQL/GReQLPrototyp/src/testPathSystem.tg");
		GreqlQuery gq=null;
		try {
			gq=GreqlQuery.readQuery(file); //File auslesen
		} catch (IOException e) {
			e.printStackTrace();
		}
		GreqlEvaluatorImpl ge=new GreqlEvaluatorImpl(gq, cg.getGraph(), new GreqlEnvironmentAdapter());
//		ArrayPSet  o=(ArrayPSet) ge.evaluate(); //eigentliche Berechnung
//		OrderedPSet<Tuple> o=(OrderedPSet<Tuple>) ge.evaluate();
		Object o=ge.evaluate();
		if (o.getClass().equals(OrderedPSet.class)){
			OrderedPSet<Tuple> ops=(OrderedPSet<Tuple>)o;
			int i=0;
			w2t.initialize(header);
			for (Tuple e:ops){
				i++;
				w2t.writeLine(i+" "+e.toString());
				System.out.println(i+" "+e);
			}
		}
		else{
			if (o.getClass().equals(ArrayPSet.class)){
				ArrayPSet<Tuple> aps=(ArrayPSet<Tuple>)o;
				int i=0;
				w2t.initialize(header);
				for (Tuple e:aps){
					i++;
					w2t.writeLine(i+" "+e.toString());
					System.out.println(i+" "+e);
				}
			}
		}
//		int i=0;
//		w2t.initialize(header);
//		for (Tuple e:o){
//			i++;
//			w2t.writeLine(i+" "+e.toString());
//			System.out.println(i+" "+e);
//		}
		
		now = new java.util.Date();
		sdf = new java.text.SimpleDateFormat("HH:mm:ss:SSS");
		ausgabe = sdf.format(now);
		w2t.writeLine(ausgabe);
		w2t.closeBW();
		
//		System.out.println(o.size());
		System.out.println("END~~~~PL0-Graph Tassilo~~~");
		System.out.println();
	}

}
