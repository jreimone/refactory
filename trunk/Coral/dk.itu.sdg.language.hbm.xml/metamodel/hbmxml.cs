SYNTAXDEF hbm.xml
FOR <http://www.itu.dk/language/hbm/xml>
START Document

OPTIONS {	
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	disableTokenSorting = "true";
	backtracking = "false";
	
	basePackage = "dk.itu.sdg.language.hbm.xml";
	
	resourcePluginID = "dk.itu.sdg.language.hbm.xml.resource";
	baseResourcePlugin = "dk.itu.sdg.language.hbm.xml.resource";
	
	resourceUIPluginID = "dk.itu.sdg.language.hbm.xml.resource.ui";
	uiBasePackage = "dk.itu.sdg.language.hbm.xml.resource.ui";
	
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	
	
}

TOKENS {
	DEFINE FRAGMENT ALL $.*$;
	DEFINE XMLCOMMENT $'<!--'$ + ALL + $'-->'$ COLLECT IN comments;
	DEFINE IDENTIFIER $( 'a'..'z' | 'A'..'Z' | '_' | ':') ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-' | '_' | ':')*$;
	DEFINE STRING_LITERAL $'"'$ + ALL + $'"'$;
		
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}


RULES {
	Document ::= xmltype? doctype? mapping?;
	
	XmlType ::= ("<?xml" | "<?XML")  parameters* "?>";
	DocType ::= ("<!doctype" | "<!DOCTYPE") parameters* ">";
	
	IDParameter ::= name[];
	IDValParameter ::= name[] "=" value[];
    StringParameter ::=  name[STRING_LITERAL];		
	StringValParameter ::= name[] "=" value[STRING_LITERAL];
	
	HibernateMapping ::= "<hibernate-mapping" parameters* ">" classes* "</hibernate-mapping>";
	Class ::= "<class" parameters* ">" contents* "</class>";
	Identifier ::= "<id" parameters* ">" contents* "</id>" | "<id" parameters* "/>";
	Natural_ID ::= "<natural-id" parameters* ">" contents* "</natural-id>";
	Generator ::= "<generator" parameters* "/>";
	ManyToOne ::= "<many-to-one" parameters* "/>";
	OneToMany ::= "<one-to-many" parameters* "/>";
	Property ::= "<property" parameters* "/>";
	Version ::= "<version" parameters* "/>";
	Set ::= "<set" parameters* ">" contents* "</set>";
	Key ::= "<key" parameters* "/>";
}