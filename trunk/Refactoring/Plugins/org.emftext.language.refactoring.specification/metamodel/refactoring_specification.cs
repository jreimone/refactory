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

SYNTAXDEF refspec
FOR <http://www.emftext.org/language/refactoring_specification>
START RefactoringSpecification

OPTIONS{
	resourcePluginID = "org.emftext.language.refactoring.specification.resource.refspec";
	basePackage = "org.emftext.language.refactoring.specification.resource";
	resourceUIPluginID = "org.emftext.language.refactoring.specification.resource.refspec.ui";
	uiBasePackage = "org.emftext.language.refactoring.specification.resource";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	additionalDependencies = "org.emftext.refactoring.registry.rolemodel,org.emftext.refactoring.util,org.emftext.refactoring.registry.refactoringspecification";
	additionalUIDependencies = "org.emftext.language.refactoring.roles.resource.rolestext.ui";
	overrideHoverTextProvider = "false";
	overrideBuilder = "false";
	overrideUIPluginXML = "false";
}

TOKENS{
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $;
	DEFINE ML_COMMENT $'/*'.*'*/'$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	DEFINE INTEGER$('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	
	DEFINE CONSTANTS $'INPUT'$;
	DEFINE UPPER_IDENTIFIER $('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;
	DEFINE LOWER_IDENTIFIER $('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;
	//DEFINE IDENTIFIER $('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;
	DEFINE DOT_NOTATION $($ + UPPER_IDENTIFIER + $|$ + LOWER_IDENTIFIER + $)$ + $'.'$ + LOWER_IDENTIFIER;
}

TOKENSTYLES{
	"ML_COMMENT" COLOR #008000, ITALIC;

	"REFACTORING" COLOR #7F0055, BOLD;
	"FOR" COLOR #7F0055, BOLD;
	"STEPS" COLOR #7F0055, BOLD;
	"create" COLOR #7F0055, BOLD;
	"remove" COLOR #7F0055, BOLD;
	"new" COLOR #7F0055, BOLD;
	"in" COLOR #7F0055, BOLD;
	"move" COLOR #7F0055, BOLD;
	"to" COLOR #7F0055, BOLD;
	"set" COLOR #7F0055, BOLD;
	"use" COLOR #7F0055, BOLD;
	"index" COLOR #7F0055, BOLD;
	"of" COLOR #7F0055, BOLD;
	"assign" COLOR #7F0055, BOLD;
	"for" COLOR #7F0055, BOLD;
	"from" COLOR #7F0055, BOLD;
	"uptree" COLOR #50F05C, BOLD;
	"path" COLOR #50F05C, BOLD;
	"filter" COLOR #50F05C, BOLD;
	"trace" COLOR #50F05C, BOLD;
	"first" COLOR #50F05C, BOLD;
	"last" COLOR #50F05C, BOLD;
	"after" COLOR #50F05C, BOLD;
	"as" COLOR #7F0055, BOLD;
	"distinct" COLOR #7F0055, BOLD;
	"unused" COLOR #7F0055, BOLD;
	"empty" COLOR #7F0055, BOLD;
	"DOT_NOTATION" COLOR #0000FF;
	"LOWER_IDENTIFIER" COLOR #0000FF;
	"UPPER_IDENTIFIER" COLOR #0000FF;
	"CONSTANTS" COLOR #FF8000, BOLD;
}

RULES{
	
	RefactoringSpecification ::= "REFACTORING" #1 "FOR" #1 usedRoleModel['<','>'] !0 !0 "STEPS" "{" !1 (instructions ";" !0)+ !0 "}"  ;
	
	CREATE ::= "create" #1 "new" #1 variable #0 ":" #0 sourceRole[UPPER_IDENTIFIER] #1 "in" #1 targetContext ("at" index[LOWER_IDENTIFIER])?;
	
	MOVE ::= "move" #1 source #1 "to" #1 target ("at" index[LOWER_IDENTIFIER])? (moveModifier)?;
	
	DISTINCT ::= "distinct";
	
	SET ::= "set" #1 "use" #1 "of" #1 source #1 "in" #1 target;
	
	ASSIGN ::= "assign" #1 (sourceAttribute[DOT_NOTATION] #1 "for" #1 )? targetAttribute[DOT_NOTATION];
	
	Variable ::= name[LOWER_IDENTIFIER];
	
	VariableReference ::= variable[LOWER_IDENTIFIER] ;
	
	VariableAssignment ::= "object" variable ":=" assignment;
	
	RoleReference ::= role[UPPER_IDENTIFIER] #1 "from" #1 from;
	
	TRACE ::= role[UPPER_IDENTIFIER] "as" "trace" "(" reference ")";
	
	CollaborationReference ::= collaboration[DOT_NOTATION];
	
	ConstantsReference ::= referencedConstant[CONSTANTS] ;
	
	FromClause ::= operator #0 "(" reference ")";
	
	UPTREE ::= "uptree";
	
	PATH ::= "path";
	
	FILTER ::= "filter";
	
	FIRST ::= "index" variable ":=" "first" "(" reference ")";
	
	LAST  ::= "index" variable ":=" "last" "(" reference ")";
	
	AFTER  ::= "index" variable ":=" "after" "(" reference ")";
	
	ConcreteIndex ::= "index" variable ":=" index[INTEGER];
	
	IndexVariable ::= name[LOWER_IDENTIFIER];
	
	REMOVE ::= "remove" (modifier)? removal;
	
	RoleRemoval ::= role[UPPER_IDENTIFIER];
	
	UNUSED ::= "unused";
	
	EMPTY ::= "empty";
}