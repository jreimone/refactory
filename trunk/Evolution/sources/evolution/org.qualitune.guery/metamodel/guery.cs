SYNTAXDEF guery
FOR <http://www.qualitune.org/guery>
START MotifModel


OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	editorName = "GUERY Motif Editor";
	disableDebugSupport = "true";
	disableLaunchSupport = "true";
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
}


RULES {
	MotifModel ::= motifs (!0 !0 motifs)*;
	
	Motif ::= "motif" name[IDENTIFIER] 
				prepare* 
				vertexSelection 
				edgeSelections*
				groupBy*;
	
	PreProcessor ::= !0 "prepare" "with" className[CLASSNAME];
	
	VertexSelection ::= !0 "select" roles ("," roles)* constraint?;
	
	Role ::= name[IDENTIFIER];
	
	Constraint ::= !0 "where" expressions['"','"'] ("and" expressions['"','"'])*;
	
	ConnectedBy ::= !0 "connected" "by" connections ("and" connections)* constraint?;
	
	NotConnectedBy ::= !0 "not" "connected" "by"  connections ("and" connections)* constraint?;
	
	Connection ::= path[IDENTIFIER] "(" from[IDENTIFIER] ">" to[IDENTIFIER] ")" 
						("["minLength[CARDINALITY] "," maxLength[CARDINALITY] "]")? 
						computeAll["find all" : ""];
	

	
	Grouping ::= !0 "group" "by" expressions['"','"'] ("and" expressions['"','"'])*;
}