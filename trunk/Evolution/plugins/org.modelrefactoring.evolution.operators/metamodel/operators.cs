SYNTAXDEF operators
FOR <http://www.modelrefactoring.org/operators>
START 
	CREATE
	,DELETE
	,ASSIGN
	,SET
	,MOVE
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
	// Referrable
	EObjectReference ::= elements['<','>'] ("," #1 elements['<','>'])*;
	VariableReference ::= referencedVariable[IDENTIFIER];
	
	// Var
	@SuppressWarnings(featureWithoutSyntax)
	VAR ::= "var" #1 variable;
	@SuppressWarnings(featureWithoutSyntax)
	QueryVariable ::= name[IDENTIFIER] #1 "=" #1 queryObject #0 "." #0 qualifier ;
	EStructuralFeatureQualifier ::= structuralFeature[IDENTIFIER];
	EOperationQualifier ::= operation[IDENTIFIER];
	
	// Create
	@SuppressWarnings(featureWithoutSyntax)
	CREATE ::= "create" newInstanceVariable #1 "in" #1 parent #0 "." #0 parentCompositeReference[IDENTIFIER];
	@SuppressWarnings(featureWithoutSyntax)
	TypeVariable ::= name[IDENTIFIER] #1 "=" #1 "new" #1 type[IDENTIFIER];
	@SuppressWarnings(featureWithoutSyntax)
	
	// Delete
	DELETE ::= "delete" #1 deletion;
	
	// Assign (attribute)
	@SuppressWarnings(featureWithoutSyntax)
	ASSIGN ::= attributeOwner #0 "." #0 attribute[IDENTIFIER] #1 "=" #1 value['"','"'];
	
	// Set (reference)	
	@SuppressWarnings(featureWithoutSyntax)
	SET ::= referenceOwner #0 "." #0 reference[IDENTIFIER] #1 "=" #1 value;
	
	// Move
	@SuppressWarnings(featureWithoutSyntax)
	MOVE ::= "move" #1 movee #1 "to" #1 newParent #0 "." #0 parentReference[IDENTIFIER];
	
	//PrimitiveReference ::= "primitiveReference" (value[])* ";";
	//SPLIT ::= "sPLIT" (result | executed["executed" : ""] | splitSets | splitObject)*;
	//StructuralFeatureSet ::= "structuralFeatureSet" (structuralFeatures[])* ";";
	//MERGE ::= "mERGE" (result | executed["executed" : ""] | mergeObjects)*;
}