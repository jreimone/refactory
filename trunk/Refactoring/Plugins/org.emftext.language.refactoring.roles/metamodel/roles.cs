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
}

TOKENS{
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ COLLECT IN comments;
	DEFINE ML_COMMENT $'/*'.*'*/'$ COLLECT IN comments;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;

	DEFINE ROLE_MODIFIER $'optional'|'runtime'|'input'$;
	DEFINE RELATION_MODIFIER $'transitive'|'reflexive'$;
	//DEFINE OPTIONAL $'optional'$;
	//DEFINE INPUT $'input'$;
	//DEFINE RUNTIME $'runtime'$;
	//DEFINE TRANSITIVE $'transitive'$;
	//DEFINE REFLEXIVE $'reflexive'$;

	//DEFINE BOOLEAN_LITERAL $'true'|'false'$;
	DEFINE IDENTIFIER $('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;	
	DEFINE NUMBER $('0')|('-1')|(('1'..'9')('0'..'9')*)$;
}

TOKENSTYLES{
	"|-|" COLOR #FF0000, BOLD;
	"->" COLOR #FFC400, BOLD;
	"--" COLOR #00FF00, BOLD;
	"<>-" COLOR #00FFFF, BOLD;
	//"BOOLEAN_LITERAL" COLOR #7F0055, BOLD;
	"NUMBER" COLOR #0000FF, ITALIC;
	".." COLOR #0000FF, ITALIC;
	"ROLE_MODIFIER" COLOR #7F0055, BOLD;
	"RELATION_MODIFIER" COLOR #7F0055, BOLD;
}

RULES {
	RoleModel ::= "RoleModel" #1 name[IDENTIFIER] "{" !1 roles* !0 !0 relations* !0 "}";
	
	Role ::= ( modifier[ROLE_MODIFIER]* )? #1 "ROLE" #1 name[IDENTIFIER] ";" !0;
	
	RoleProhibition ::= (modifier[RELATION_MODIFIER]* #1 ":")? #1 source[IDENTIFIER] #1 "|-|" #1 target[IDENTIFIER] ";" !0;
	
	RoleImplication ::= (modifier[RELATION_MODIFIER]* #1 ":")? #1 source[IDENTIFIER] #1 "->" #1 target[IDENTIFIER] ";" !0;
	
	RoleAssociation ::= (modifier[RELATION_MODIFIER]* #1 ":")? #1 source[IDENTIFIER] #1 sourceName[IDENTIFIER]? #1 sourceMultiplicity #1 "--" #1 target[IDENTIFIER] #1 targetName[IDENTIFIER]? #1 targetMultiplicity  ";" !0;
	
	RoleComposition ::= (modifier[RELATION_MODIFIER]* #1 ":")? #1 source[IDENTIFIER] #1 sourceName[IDENTIFIER]? #1 sourceMultiplicity #1 "<>-" #1 target[IDENTIFIER] #1 targetName[IDENTIFIER]? #1 targetMultiplicity  ";" !0;
	
	Multiplicity ::= "[" lowerBound[NUMBER] ".." upperBound[NUMBER] "]";
}