SYNTAXDEF guery
FOR <http://www.qualitune.org/guery>
START MotifModel


OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	editorName = "GUERY Motif Editor";
	disableDebugSupport = "true";
	disableLaunchSupport = "true";
	overrideProposalPostProcessor = "false";
}


TOKENS {
	DEFINE IDENTIFIER $('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;
	DEFINE CLASSNAME IDENTIFIER + $('.'$ + IDENTIFIER + $)*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE CARDINALITY $('0')|('-1')|('*')|(('1'..'9')('0'..'9')*)$;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES{
	"SL_COMMENT" COLOR #008000, ITALIC;
	"CLASSNAME" COLOR #FF9000;
	"find all","connected by","group by","not connected by","prepare with" COLOR #800055, BOLD;
}


RULES {
	MotifModel ::= motifs (!0 !0 motifs)*;
	
	Motif ::= "motif" name[IDENTIFIER] 
				prepare* 
				vertexSelection 
				edgeSelections*
				groupBy*;
	
	PreProcessor ::= !0 "prepare with" class[CLASSNAME];
	
	VertexSelection ::= !0 "select" roles ("," roles)* (!0 "where" constraints ("and" constraints)*)?;
	
	Role ::= name[IDENTIFIER];
	
	Constraint ::= expression['"','"'];
	
	ConnectedBy ::= !0 "connected by" connections ("and" connections)* (!0 "where" constraints ("and" constraints)*)?;
	
	NotConnectedBy ::= !0 "not connected by"  connections ("and" connections)* (!0 "where" constraints ("and" constraints)*)?;
	
	Connection ::= path[IDENTIFIER] "(" from[IDENTIFIER] ">" to[IDENTIFIER] ")" 
						("["minLength[CARDINALITY] "," maxLength[CARDINALITY] "]")? 
						computeAll["find all" : ""];
	

	
	Grouping ::= !0 "group by" constraints ("and" constraints)*;
}