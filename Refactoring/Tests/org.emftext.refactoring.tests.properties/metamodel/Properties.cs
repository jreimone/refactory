SYNTAXDEF properties
FOR <http://www.emftext.org/language/properties>
START PropertyModel

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";

	generateCodeFromGeneratorModel = "true";
	reloadGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS{
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

TOKENSTYLES{
	"COMMENT" COLOR #008000, ITALIC;
}

RULES{
	
	PropertyModel::= (categories !0!0)* ;
	
	Category::= name['[',']'] !0 pairs*;
	
	KeyValuePair::= (key "=")? value !0;
	
	Key::= name[];
	
	EObjectReferenceValue ::= objectReference['<','>'];
	
	StringValue ::= value['"','"'];
	
}