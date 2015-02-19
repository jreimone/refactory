SYNTAXDEF refcomp
FOR <http://www.emftext.org/language/refactoringcomposition>
START CompositeRoleMapping

IMPORTS{
	org.eclipse.emf.ecore:<http://www.eclipse.org/emf/2002/Ecore>
	org.emftext.language.refactoring.roles:<http://www.emftext.org/language/roles>
	org.emftext.language.refactoring.rolemapping:<http://www.emftext.org/language/rolemapping>
}

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	usePredefinedTokens = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	additionalDependencies = "org.emftext.refactoring.registry.rolemapping";
	preferencePagesCategory = "org.emftext.refactoring.ui.preferences";
	newFileWizardCategory = "org.emftext.refactory.ui";
	editorName = "Composite Refactoring Text Editor";
	resourcePluginID = "org.emftext.language.refactoring.composition.resource.refcomp";
	basePackage = "org.emftext.language.refactoring.composition.resource";
	resourceUIPluginID = "org.emftext.language.refactoring.composition.resource.refcomp.ui";
	uiBasePackage = "org.emftext.language.refactoring.composition.resource.ui";
}


TOKENS {
	DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z' | '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}


RULES {
	CompositeRoleMapping ::= "COMPOSITE" #1 "REFACTORING" #1 name['"','"'] !0 
								"FOR" #1 targetMetamodel['<','>'] !0 !0 
								first['<','>'] !0 sequence;
	BoundRoleMapping ::=  "->" #1 roleMapping['<','>'] #1 ("{" !1 bindings !0 "}")? (!0 nextMapping)?;
	SourceTargetBinding ::= (sourceRoleModel['<','>'] ".")? source[IDENTIFIER] #1 "=" #1 (targetRoleModel['<','>'] ".")? target[IDENTIFIER] ";" !0;
}