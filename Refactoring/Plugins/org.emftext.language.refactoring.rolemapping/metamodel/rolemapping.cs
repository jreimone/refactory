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
	"->" COLOR #FFC400, BOLD;
}

RULES {
	
	RoleMappingModel::= "ROLEMODELMAPPING" #1 name[] #1 "FOR" #1 targetMetamodel['<','>'] !0 !0 mappings+;
	
	Mapping ::= name[] #1 "maps" #1 mappedRoleModel['<','>'] #1 "{" !1 
					roleToMetaelement+ !0 !0 
					( relationMappings*)? 
					"}" !0 !0 ;
	
	ConcreteMapping ::= role[] "->" metaclass[] ";" !0;
	
	RelationMapping ::= "(" relation['"','"'] ")" ":" references[] ("->" references[])* ";";
}