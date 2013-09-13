SYNTAXDEF rolemapping
FOR <http://www.emftext.org/language/rolemapping>
START RoleMappingModel

IMPORTS{
	org.eclipse.emf.ecore:<http://www.eclipse.org/emf/2002/Ecore>
	org.emftext.language.refactoring.roles:<http://www.emftext.org/language/roles>
}

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	additionalDependencies = "org.emftext.refactoring.registry.rolemodel,org.emftext.refactoring.util,org.emftext.refactoring.registry.rolemapping";
	additionalUIDependencies = "org.emftext.language.refactoring.roles.resource.rolestext.ui";
	overrideHoverTextProvider = "false";
	overrideBuilder = "true";
	overrideUIPluginXML = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	preferencePagesCategory = "org.emftext.refactoring.ui.preferences";
	//overrideProposalPostProcessor = "false";
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'))* $;
	DEFINE ML_COMMENT $'/*'.*'*/'$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;	
	//DEFINE DOT_IDENT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')+$ + $('.'$ + IDENT + $)*$;
//	DEFINE IDENT $('A'..'Z'|'a'..'z') + ('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')*$;
	DEFINE UPPER_IDENTIFIER $('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;
	DEFINE LOWER_IDENTIFIER $('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;
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
	
	RoleMappingModel::= "ROLEMODELMAPPING" #1 "FOR" #1 targetMetamodel['<','>'] 
				(!0 "IMPORTS" (imports['<','>']+))? !0 !0 mappings+;
	
	RoleMapping ::= (comment[ML_COMMENT])?
					name['"','"'] #1 "maps" #1 mappedRoleModel['<','>'] #1 "{" !1 
					(roleToMetaelement !1)+
					!0 "}" !0 !0 ;
	
	ConcreteMapping ::= role[UPPER_IDENTIFIER] #1 ":=" #1 (packagesOfMetaclass[LOWER_IDENTIFIER] ".")* metaclass[UPPER_IDENTIFIER] ("(" attributeMappings ("," attributeMappings)* ")")? (#1 "{" !1 collaborationMappings (!1 collaborationMappings)* !0 "}")? ";";
	
	CollaborationMapping ::= collaboration[LOWER_IDENTIFIER] #1 ":=" #1 referenceMetaClassPair (#1 "->" #1 referenceMetaClassPair)* ";";
	
	ReferenceMetaClassPair ::= reference[LOWER_IDENTIFIER] (":" metaClass[UPPER_IDENTIFIER])?;
	
	AttributeMapping ::= roleAttribute[LOWER_IDENTIFIER] #1 "->" #1 classAttribute[LOWER_IDENTIFIER];
}