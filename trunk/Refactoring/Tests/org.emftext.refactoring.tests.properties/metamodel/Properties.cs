SYNTAXDEF properties
FOR <http://www.emftext.org/language/properties>
START PropertyModel

OPTIONS{
	generateCodeFromGeneratorModel = "true";
	reloadGeneratorModel = "true";
}

TOKENS{
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

TOKENSTYLES{
	"PropertyModel" COLOR #7F0055, BOLD;
	"categories" COLOR #7F0055, BOLD;
	"Category" COLOR #7F0055, BOLD;
	"pairs" COLOR #7F0055, BOLD;
	"Value" COLOR #7F0055, BOLD;
	"value" COLOR #7F0055, BOLD;
	"KeyValuePair" COLOR #7F0055, BOLD;
	"key" COLOR #7F0055, BOLD;
	"Key" COLOR #7F0055, BOLD;
}

RULES{
	
	PropertyModel::= (categories !0!0)* ;
	
	Category::= name['[',']'] !0 pairs*;
	
	KeyValuePair::= (key "=")? value !0;
	
	Key::= key[];
	
	EObjectReferenceValue ::= objectReference['<','>'];
	
	StringValue ::= value[];
	
}