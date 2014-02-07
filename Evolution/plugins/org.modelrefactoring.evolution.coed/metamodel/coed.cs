SYNTAXDEF coed
FOR <http://www.modelrefactoring.org/evolution/coed>
START CoEvolutionDefinition


OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";	
}


TOKENS {
	DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z' | '-'| '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_')*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
//	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}


RULES {
	CoEvolutionDefinition ::= "CoED" #1 "for" #1 metamodel['<','>'] #1 "{" 
								!1 "incoming" #1 event 
								!1 condition? 
								!1 "outgoing" #1 action 
								!0 "}";
	
	PlainCondition ::= "condition" condition['{','}'];
	
	// 1. possibility: incoming Event and outgoing modifications based on RoleMapping
	RoleMappingEvent ::= "refactoring" #1 concreteRefactoring['<','>'];
	RoleMappingAction ::= "corefactoring" #1 concreteRefactoring['<','>'] (#1 binding['{','}'])?;
	
}