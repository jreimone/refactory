//*******************************************************************************
// Copyright (c) 2006-2010 
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/

SYNTAXDEF rolestext
FOR <http://www.emftext.org/language/roles>
START RoleModel

OPTIONS {
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	overrideHoverTextProvider = "false";
	additionalDependencies = "org.emftext.refactoring.registry.rolemodel";
	overrideBuilder = "false";
	overrideUIPluginXML = "false";
}

TOKENS{
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $;
	DEFINE ML_COMMENT $'/*'.*'*/'$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;

	DEFINE ROLE_MODIFIER $'optional'|'runtime'|'input'|'super'$;
	DEFINE RELATION_MODIFIER $'transitive'|'reflexive'$;
	//DEFINE OPTIONAL $'optional'$;
	//DEFINE INPUT $'input'$;
	//DEFINE RUNTIME $'runtime'$;
	//DEFINE TRANSITIVE $'transitive'$;
	//DEFINE REFLEXIVE $'reflexive'$;

	//DEFINE BOOLEAN_LITERAL $'true'|'false'$;
	DEFINE UPPER_IDENTIFIER $('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;
	DEFINE LOWER_IDENTIFIER $('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;	
	DEFINE NUMBER $('0')|('-1')|('*')|(('1'..'9')('0'..'9')*)$;
	//DEFINE COMMENT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|' ')*$;
}

TOKENSTYLES{
	"ML_COMMENT" COLOR #008000, ITALIC;
	"SL_COMMENT" COLOR #008000, ITALIC;
	"|-|" COLOR #FF0000, BOLD;
	"->" COLOR #FFC400, BOLD;
	"--" COLOR #00FF00, BOLD;
	"<>-" COLOR #00FFFF, BOLD;
	"NUMBER" COLOR #0000FF, ITALIC;
	".." COLOR #0000FF, ITALIC;
	"ROLE_MODIFIER" COLOR #7F0055, BOLD;
	"RELATION_MODIFIER" COLOR #7F0055, BOLD;
}

RULES {
	RoleModel ::= 		(comment[ML_COMMENT])?
						"RoleModel" #1 name[UPPER_IDENTIFIER] "{" !1 roles* !0 !0 collaborations* !0 "}";
	
	Role ::= 			(comment[ML_COMMENT])?
						( modifier[ROLE_MODIFIER]* )? #1 "ROLE" #1 name[UPPER_IDENTIFIER] ("(" attributes ("," attributes)* ")")? ";" !0;
	
	RoleAttribute ::= 	(comment[ML_COMMENT])?
						modifier[ROLE_MODIFIER]* name[LOWER_IDENTIFIER];
	
	RoleProhibition ::= (modifier[RELATION_MODIFIER]* #1 ":")? #1 source[UPPER_IDENTIFIER] #1 "|-|" #1 target[UPPER_IDENTIFIER] ";" !0;
	
	RoleImplication ::= (modifier[RELATION_MODIFIER]* #1 ":")? #1 source[UPPER_IDENTIFIER] #1 "->" #1 target[UPPER_IDENTIFIER] ";" !0;
	
	RoleAssociation ::= (modifier[RELATION_MODIFIER]* #1 ":")? #1 source[UPPER_IDENTIFIER] #1 sourceName[LOWER_IDENTIFIER]? #1 sourceMultiplicity #1 "--" #1 target[UPPER_IDENTIFIER] #1 targetName[LOWER_IDENTIFIER]? #1 targetMultiplicity  ";" !0;
	
	RoleComposition ::= (modifier[RELATION_MODIFIER]* #1 ":")? #1 source[UPPER_IDENTIFIER] #1 sourceName[LOWER_IDENTIFIER]? #1 sourceMultiplicity #1 "<>-" #1 target[UPPER_IDENTIFIER] #1 targetName[LOWER_IDENTIFIER]? #1 targetMultiplicity  ";" !0;
	
	Multiplicity ::= "[" lowerBound[NUMBER] ".." upperBound[NUMBER] "]";
}