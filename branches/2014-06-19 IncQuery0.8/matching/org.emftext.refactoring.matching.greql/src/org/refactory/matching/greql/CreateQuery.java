package org.refactory.matching.greql;

import java.util.Set;

import de.uni_koblenz.jgralab.Graph;
import de.uni_koblenz.jgralab.ProgressFunction;
import de.uni_koblenz.jgralab.greql.GreqlEnvironment;
import de.uni_koblenz.jgralab.greql.GreqlQuery;
import de.uni_koblenz.jgralab.greql.parser.GreqlLexer;
import de.uni_koblenz.jgralab.greql.parser.GreqlParser;
import de.uni_koblenz.jgralab.greql.schema.GreqlExpression;
import de.uni_koblenz.jgralab.greql.schema.GreqlGraph;
import de.uni_koblenz.jgralab.utilities.greqlgui.GreqlGui;

public class CreateQuery {

	public void testSth(){
//		GreqlQuery.createQuery("test.tg");
		GreqlGui gg=new GreqlGui();
		gg.pack();
	}
	
	public void testSthElse(){
		String source="";
		GreqlParser gp1=new GreqlParser(source);
		de.uni_koblenz.jgralab.greql2.parser.GreqlParser gp=new de.uni_koblenz.jgralab.greql2.parser.GreqlParser(source);
		GreqlLexer gl=new GreqlLexer(source);
	}
	
	public static void main(String args[]){
		CreateQuery cq=new CreateQuery();
		GreqlGui gg=new GreqlGui();
		gg.main(null);
		cq.testSth();
	}
}
