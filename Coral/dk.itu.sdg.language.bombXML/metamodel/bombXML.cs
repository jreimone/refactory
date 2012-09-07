SYNTAXDEF xml
FOR <http://www.itu.dk/language/bombXML>
START Document

OPTIONS {	
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	disableTokenSorting = "true";
	backtracking = "false";
	overrideManifest = "false";
	overrideUIManifest = "false";
}

TOKENS {
	DEFINE FRAGMENT ALL $.*$;
	DEFINE XMLCOMMENT $'<!--'$ + ALL + $'-->'$ COLLECT IN comments;

	DEFINE IDENTIFIER $( 'a'..'z' | 'A'..'Z' | '_' | ':') ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-' | '_' | ':')*$;
	DEFINE STRING_LITERAL $'"'$ + ALL + $'"'$;
	DEFINE BOXMLBE $'[_b0mBxMl_]'$ + ALL + $'[_b0mBxMl_]'$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	
}

TOKENSTYLES { 
        "<?xml" COLOR #0000FF, ITALIC;
        "<?XML" COLOR #0000FF, ITALIC;
        "<!doctype" COLOR #0000FF, ITALIC;
        "<!DOCTYPE" COLOR #0000FF, ITALIC;
        "?>" COLOR #0000FF, ITALIC;
        "<" COLOR #0000FF, ITALIC;
        ">" COLOR #0000FF, ITALIC;
        "<![CDATA[" COLOR #00FF00, ITALIC; 
        "]]>" COLOR #00FF00, ITALIC;
        "[_b0mBxMl_]" COLOR #808080, BOLD; 
} 

RULES {
	Document ::= xmltype? doctype? content?;
	XmlType ::= ("<?xml" | "<?XML")  parameters* "?>";
	DocType ::= ("<!doctype" | "<!DOCTYPE") parameters* ">";
	
	IDParameter ::= name[];
	IDValParameter ::= name[] "=" value[];
    StringParameter ::=  name[STRING_LITERAL];		
	StringValParameter ::= name[] "=" value[STRING_LITERAL];
 
 	Content ::= content;
	
	LineTag ::= "<" type[] parameters* "/>";  
	BlockTag ::= "<" type[] parameters* ">" content* "</" type[] ">";
	CDataTag ::= "<![CDATA[" content? "]]>";
	Word ::= text[BOXMLBE]; 
}