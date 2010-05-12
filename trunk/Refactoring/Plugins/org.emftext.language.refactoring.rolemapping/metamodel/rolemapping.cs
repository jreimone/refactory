SYNTAXDEF rolemapping
FOR <http://www.emftext.org/language/rolemapping>
START RoleMappingModel

IMPORTS{
	org.eclipse.emf.ecore:<http://www.eclipse.org/emf/2002/Ecore>
	org.emftext.language.refactoring.roles:<http://www.emftext.org/language/roles>
}

OPTIONS {
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	additionalDependencies = "org.emftext.refactoring.registry.rolemodel,org.emftext.refactoring.util,org.emftext.refactoring.registry.rolemapping";
	additionalUIDependencies = "org.emftext.language.refactoring.roles.resource.rolestext.ui";
	overrideHoverTextProvider = "false";
	overrideBuilder = "false";
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'))* $;
	DEFINE ML_COMMENT $'/*'.*'*/'$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;	
	//DEFINE DOT_IDENT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')+$ + $('.'$ + IDENT + $)*$;
	DEFINE IDENT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-') + ('.'('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')+)*$;
	//DEFINE IDENT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')+$;
	//DEFINE DOT_IDENT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-'|'.')+$;
	//DEFINE DOT_IDENT $(('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')+('.')?('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')+)+$;
	//DEFINE DOT_IDENT IDENT + $('.'$ + IDENT + $)*$;
	//DEFINE DOT_IDENT IDENT + $('.'?$ + IDENT + $)*$;
	//DEFINE DOT_IDENT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-'|'.')+$;
	//DEFINE DOT_PATH $($ + IDENT + $|$ + DOT_IDENT + $)$;
}

TOKENSTYLES {
	"ML_COMMENT" COLOR #008000, ITALIC;
	"SL_COMMENT" COLOR #008000, ITALIC;
	"ROLEMODELMAPPING" COLOR #7F0055, BOLD;
	"FOR" COLOR #7F0055, BOLD;
	"maps" COLOR #7F0055, BOLD;
	"->" COLOR #FFC400, BOLD;
}

RULES {
	
	RoleMappingModel::= "ROLEMODELMAPPING" #1 "FOR" #1 targetMetamodel['<','>'] !0 !0 mappings+;
	
	Mapping ::= name[IDENT] #1 "maps" #1 mappedRoleModel['<','>'] #1 "{" !1 
					roleToMetaelement+ !0 !0  
					"}" !0 !0 ;
	
	ConcreteMapping ::= role[IDENT] ":=" metaclass[IDENT] ("(" attributeMappings ("," attributeMappings)* ")")? ("{" collaborationMappings collaborationMappings* "}")? ";" !0;
	
	CollaborationMapping ::= collaboration[IDENT] ":=" referenceMetaClassPair ("->" referenceMetaClassPair)* ";";
	
	ReferenceMetaClassPair ::= reference[IDENT] (":" metaClass[IDENT])?;
	
	AttributeMapping ::= roleAttribute[IDENT] "->" classAttribute[IDENT];
}