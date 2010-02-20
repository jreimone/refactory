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
}

TOKENS{
	DEFINE COMMENT$'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

TOKENSTYLES{
	"REFACTORING" COLOR #7F0055, BOLD;
	"FOR" COLOR #7F0055, BOLD;
	"STEPS" COLOR #7F0055, BOLD;
	"create" COLOR #7F0055, BOLD;
	"new" COLOR #7F0055, BOLD;
	"in" COLOR #7F0055, BOLD;
	"move" COLOR #7F0055, BOLD;
	"to" COLOR #7F0055, BOLD;
	"->" COLOR #FFC400, BOLD;
}

RULES{
	
	RefactoringSpecification::= "REFACTORING" #1 name[] !0 "FOR" #1 usedRoleModel['<','>'] !0 !0 "STEPS" "{" !1 (instructions ";" !0)+ !0 "}"  ;
	
	CREATE::= "create" #1 "new" #1 sourceRoleReference #1 ("(" "->" varDeclaration ")")? #1 "in" #1 targetContext;
	
	MOVE::= "move" #1 source #1 "to" #1 target;
	
	Variable::= name[] ;
	
	VariableReference::= "->" variable[] ;
	
	RoleReference::= role[];
	
	// TODO add relationRole with "." notation here!!!!
	// until now it won't be recognized as feature of RelationReference for hell's sake
	RelationReference::= relationRole "." relation[];
}