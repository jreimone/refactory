SYNTAXDEF operators
FOR <http://www.modelrefactoring.org/operators>
START 
	CREATE
//	,DELETE
//	,ASSIGN
//	,SET
//	,MOVE
//	,SPLIT
//	,MERGE
	,VAR


OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";	
}


TOKENS {
	DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z')('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*$;
//	DEFINE IDENTIFIER_UPPER $('A'..'Z' | )('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*$;
//	DEFINE IDENTIFIER_LOWER $( 'a'..'z')('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE ML_COMMENT $'/*'(.*)'*/'$;
}


RULES {
	EObjectReference ::= element['<','>'];
	VariableReference ::= referencedVariable[IDENTIFIER];
	
	// Var
	@SuppressWarnings(featureWithoutSyntax)
	VAR ::= "var" #1 variable;
	@SuppressWarnings(featureWithoutSyntax)
	QueryVariable ::= name[IDENTIFIER] #1 "=" #1 queryObject #0 "." #0 qualifier ;
	EStructuralFeatureQualifier ::= structuralFeature[IDENTIFIER];
	EOperationQualifier ::= operation[IDENTIFIER];
	@SuppressWarnings(featureWithoutSyntax)
	
	// Create
	CREATE ::= newInstanceVariable #1 "in" #1 parent #0 "." #0 parentCompositeReference[IDENTIFIER];
	@SuppressWarnings(featureWithoutSyntax)
	TypeVariable ::= name[IDENTIFIER] #1 "=" #1 "new" type[IDENTIFIER];
	
	
	//DELETE ::= "dELETE" (result | executed["executed" : ""] | deletion)*;
	//ASSIGN ::= "aSSIGN" (result | executed["executed" : ""] | attribute[] | value[])*;
	//PrimitiveReference ::= "primitiveReference" (value[])* ";";
	//SET ::= "sET" (result | executed["executed" : ""] | reference[] | value)*;
	//MOVE ::= "mOVE" (result | executed["executed" : ""] | newParent | parentReference[] | movee)*;
	//SPLIT ::= "sPLIT" (result | executed["executed" : ""] | splitSets | splitObject)*;
	//StructuralFeatureSet ::= "structuralFeatureSet" (structuralFeatures[])* ";";
	//MERGE ::= "mERGE" (result | executed["executed" : ""] | mergeObjects)*;
}