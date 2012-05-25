SYNTAXDEF operators
FOR <http://www.qualitune.org/operators>
START 
//	CREATE
//	,DELETE
//	,ASSIGN
//	,SET
//	,MOVE
//	,SPLIT
//	,MERGE
	VAR


OPTIONS {
	usePredefinedTokens = "false";
}


TOKENS {
	DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z' | '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE ML_COMMENT $'/*'(.*)'*/'$;
}


RULES {
	@SuppressWarnings(featureWithoutSyntax)
	VAR ::= "var" variable;
	@SuppressWarnings(featureWithoutSyntax)
	QueryVariable ::= name[IDENTIFIER] #1 "=" #1 queryObject "." (operation[IDENTIFIER] | structuralFeature[IDENTIFIER]) ;
	EObjectReference ::= element['<','>'];
	VariableReference ::= referencedVariable[IDENTIFIER];
	//CREATE ::= "new" newInstanceVariable | parent;
	
	
	//TypeVariable ::= "typeVariable" (name[] | type[] | value[])* ";";
	//DELETE ::= "dELETE" (result | executed["executed" : ""] | deletion)*;
	//ASSIGN ::= "aSSIGN" (result | executed["executed" : ""] | attribute[] | value[])*;
	//PrimitiveReference ::= "primitiveReference" (value[])* ";";
	//SET ::= "sET" (result | executed["executed" : ""] | reference[] | value)*;
	//MOVE ::= "mOVE" (result | executed["executed" : ""] | newParent | parentReference[] | movee)*;
	//SPLIT ::= "sPLIT" (result | executed["executed" : ""] | splitSets | splitObject)*;
	//StructuralFeatureSet ::= "structuralFeatureSet" (structuralFeatures[])* ";";
	//MERGE ::= "mERGE" (result | executed["executed" : ""] | mergeObjects)*;
}