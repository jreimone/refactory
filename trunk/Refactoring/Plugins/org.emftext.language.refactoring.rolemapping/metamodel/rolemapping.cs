SYNTAXDEF rolemapping
FOR <http://www.emftext.org/language/rolemapping>
START RoleMappingModel

IMPORTS{
	org.eclipse.emf.ecore:<http://www.eclipse.org/emf/2002/Ecore>
	org.emftext.language.refactoring.roles:<http://www.emftext.org/language/roles>
}

OPTIONS {
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	//usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENS{
	DEFINE COMMENT$'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE TARGETMM $'http://'($+ TEXT +$|'.'|'/'|'_')*$;
	DEFINE MAPPEDRM $'platform:'($+ TEXT +$|'.'|'/'|'_')*$;
}

TOKENSTYLES{
	"RoleMappingModel" COLOR #7F0055, BOLD;
	"targetMetamodel" COLOR #7F0055, BOLD;
	"mappings" COLOR #7F0055, BOLD;
	"Mapping" COLOR #7F0055, BOLD;
	"name" COLOR #7F0055, BOLD;
	"mappedRoleModel" COLOR #7F0055, BOLD;
	"roleToMetaelement" COLOR #7F0055, BOLD;
	"ConcreteMapping" COLOR #7F0055, BOLD;
	"role" COLOR #7F0055, BOLD;
	"metaclass" COLOR #7F0055, BOLD;
}

RULES{
	
	RoleMappingModel::= "ROLEMODELMAPPING" "FOR" "<"targetMetamodel[TARGETMM]">" mappings (mappings)*;
	
	Mapping::= name['"','"'] "maps" mappedRoleModel[MAPPEDRM] "{"  "}"  ;
	
	//ConcreteMapping::= "ConcreteMapping"  "{" ( "role"  ":" role[]| "metaclass"  ":" metaclass[] )* "}"  ;
}