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

TOKENSTYLES {
	"ROLEMODELMAPPING" COLOR #7F0055, BOLD;
	"FOR" COLOR #7F0055, BOLD;
	"maps" COLOR #7F0055, BOLD;
}

RULES {
	
	RoleMappingModel::= "ROLEMODELMAPPING" "FOR" targetMetamodel['<','>'] mappings+;
	
	Mapping::= name['"','"'] "maps" mappedRoleModel['<','>'] "{"  "}"  ;
	
	ConcreteMapping ::= role['"','"'] "->" metaclass[];
}