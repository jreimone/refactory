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

	DEFINE OPTIONAL $'optional'$;
	DEFINE INPUT $'input'$;
	DEFINE RUNTIME $'runtime'$;
	DEFINE TRANSITIVE $'transitive'$;
	DEFINE REFLEXIVE $'reflexiv'$;

	//DEFINE BOOLEAN_LITERAL $'true'|'false'$;
	DEFINE IDENTIFIER $('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;	
	DEFINE NUMBER $('0')|('-1')|(('1'..'9')('0'..'9')*)$;
}

TOKENSTYLES{
	"|-|" COLOR #FF0000, BOLD;
	"->" COLOR #FFC400, BOLD;
	"--" COLOR #00FF00, BOLD;
	"<>-" COLOR #00FFFF, BOLD;
	"BOOLEAN_LITERAL" COLOR #7F0055, BOLD;
	"NUMBER" COLOR #0000FF, ITALIC;
	".." COLOR #0000FF, ITALIC;
	"OPTIONAL" COLOR #05D3E0, BOLD;
	"INPUT" COLOR #05D3E0, BOLD;
	"RUNTIME" COLOR #05D3E0, BOLD;
	"TRANSITIVE" COLOR #05D3E0, BOLD;
	"REFLEXIVE" COLOR #05D3E0, BOLD;
}

RULES {
	RoleModel ::= "RoleModel" name[IDENTIFIER] "{" roles* relations* "}";
	
	Role ::= "role" name[IDENTIFIER] ("(" (optional[OPTIONAL])? (input[INPUT])?  (selectOnRuntime[RUNTIME])? ")" )? ";";
	
	RoleProhibition ::= source[IDENTIFIER] "|-|" target[IDENTIFIER] ("(" (transitive[TRANSITIVE])? (reflexive[REFLEXIVE])? ")")? ";";
	
	RoleImplication ::= source[IDENTIFIER] "->" target[IDENTIFIER] ("(" (transitive[TRANSITIVE])? (reflexive[REFLEXIVE])? ")")? ";";
	
	RoleAssociation ::= source[IDENTIFIER] sourceName[IDENTIFIER]? sourceMultiplicity "--" target[IDENTIFIER] targetName[IDENTIFIER]? targetMultiplicity ("(" (transitive[TRANSITIVE])? (reflexive[REFLEXIVE])? ")")? ";";
	
	RoleComposition ::= source[IDENTIFIER] sourceName[IDENTIFIER]? sourceMultiplicity "<>-" target[IDENTIFIER] targetName[IDENTIFIER]? targetMultiplicity ("(" (transitive[TRANSITIVE])? (reflexive[REFLEXIVE])? ")")? ";";
	
	Multiplicity ::= "[" lowerBound[NUMBER] ".." upperBound[NUMBER] "]";
}