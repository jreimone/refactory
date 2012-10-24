SYNTAXDEF hwpfdoc
FOR <http://www.itu.dk/language/hwpfdoc>
START Content,Document


TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}


TOKENSTYLES {
	"Content" COLOR #7F0055, BOLD;
	"text" COLOR #7F0055, BOLD;
	"Document" COLOR #7F0055, BOLD;
	"ranges" COLOR #7F0055, BOLD;
	"bookmarks" COLOR #7F0055, BOLD;
	"docProperties" COLOR #7F0055, BOLD;
	"notes" COLOR #7F0055, BOLD;
	"escherRecordHolder" COLOR #7F0055, BOLD;
	"fields" COLOR #7F0055, BOLD;
	"fieldsTable" COLOR #7F0055, BOLD;
	"officeDrawings" COLOR #7F0055, BOLD;
	"revisionMarkAuthorTable" COLOR #7F0055, BOLD;
	"savedByTable" COLOR #7F0055, BOLD;
	"textPieceTable" COLOR #7F0055, BOLD;
	"Bookmark" COLOR #7F0055, BOLD;
	"CommentsRange" COLOR #7F0055, BOLD;
	"characterRuns" COLOR #7F0055, BOLD;
	"paragraphs" COLOR #7F0055, BOLD;
	"sections" COLOR #7F0055, BOLD;
	"tables" COLOR #7F0055, BOLD;
	"EndnoteRange" COLOR #7F0055, BOLD;
	"FootnoteRange" COLOR #7F0055, BOLD;
	"HeaderStoryRange" COLOR #7F0055, BOLD;
	"MainTextboxRange" COLOR #7F0055, BOLD;
	"OverallRange" COLOR #7F0055, BOLD;
	"InnerRange" COLOR #7F0055, BOLD;
	"CharacterRun" COLOR #7F0055, BOLD;
	"Paragraph" COLOR #7F0055, BOLD;
	"Section" COLOR #7F0055, BOLD;
	"Table" COLOR #7F0055, BOLD;
	"DocumentProperty" COLOR #7F0055, BOLD;
	"Endnote" COLOR #7F0055, BOLD;
	"Footnote" COLOR #7F0055, BOLD;
	"EscherRecordHolder" COLOR #7F0055, BOLD;
	"Field" COLOR #7F0055, BOLD;
	"FieldsTable" COLOR #7F0055, BOLD;
	"OfficeDrawingsHeader" COLOR #7F0055, BOLD;
	"OfficeDrawingsMain" COLOR #7F0055, BOLD;
	"RevisionMarkAuthorTable" COLOR #7F0055, BOLD;
	"SavedByTable" COLOR #7F0055, BOLD;
	"TextPieceTable" COLOR #7F0055, BOLD;
}


RULES {
	Content ::= "Content" "{" ("text" ":" text['"','"'])* "}";
	Document ::= "Document" "{" ("ranges" ":" ranges | "bookmarks" ":" bookmarks | "docProperties" ":" docProperties | "notes" ":" notes | "escherRecordHolder" ":" escherRecordHolder | "fields" ":" fields | "fieldsTable" ":" fieldsTable | "officeDrawings" ":" officeDrawings | "revisionMarkAuthorTable" ":" revisionMarkAuthorTable | "savedByTable" ":" savedByTable | "textPieceTable" ":" textPieceTable)* "}";
	Bookmark ::= "Bookmark" "{" "}";
	CommentsRange ::= "CommentsRange" "{" ("text" ":" text['"','"'] | "characterRuns" ":" characterRuns | "paragraphs" ":" paragraphs | "sections" ":" sections | "tables" ":" tables)* "}";
	EndnoteRange ::= "EndnoteRange" "{" ("text" ":" text['"','"'] | "characterRuns" ":" characterRuns | "paragraphs" ":" paragraphs | "sections" ":" sections | "tables" ":" tables)* "}";
	FootnoteRange ::= "FootnoteRange" "{" ("text" ":" text['"','"'] | "characterRuns" ":" characterRuns | "paragraphs" ":" paragraphs | "sections" ":" sections | "tables" ":" tables)* "}";
	HeaderStoryRange ::= "HeaderStoryRange" "{" ("text" ":" text['"','"'] | "characterRuns" ":" characterRuns | "paragraphs" ":" paragraphs | "sections" ":" sections | "tables" ":" tables)* "}";
	MainTextboxRange ::= "MainTextboxRange" "{" ("text" ":" text['"','"'] | "characterRuns" ":" characterRuns | "paragraphs" ":" paragraphs | "sections" ":" sections | "tables" ":" tables)* "}";
	OverallRange ::= "OverallRange" "{" ("text" ":" text['"','"'] | "characterRuns" ":" characterRuns | "paragraphs" ":" paragraphs | "sections" ":" sections | "tables" ":" tables)* "}";
	InnerRange ::= "InnerRange" "{" ("text" ":" text['"','"'] | "characterRuns" ":" characterRuns | "paragraphs" ":" paragraphs | "sections" ":" sections | "tables" ":" tables)* "}";
	CharacterRun ::= "CharacterRun" "{" ("text" ":" text['"','"'])* "}";
	Paragraph ::= "Paragraph" "{" ("text" ":" text['"','"'])* "}";
	Section ::= "Section" "{" ("text" ":" text['"','"'])* "}";
	Table ::= "Table" "{" ("text" ":" text['"','"'])* "}";
	DocumentProperty ::= "DocumentProperty" "{" "}";
	Endnote ::= "Endnote" "{" ("text" ":" text['"','"'])* "}";
	Footnote ::= "Footnote" "{" ("text" ":" text['"','"'])* "}";
	EscherRecordHolder ::= "EscherRecordHolder" "{" "}";
	Field ::= "Field" "{" "}";
	FieldsTable ::= "FieldsTable" "{" "}";
	OfficeDrawingsHeader ::= "OfficeDrawingsHeader" "{" "}";
	OfficeDrawingsMain ::= "OfficeDrawingsMain" "{" "}";
	RevisionMarkAuthorTable ::= "RevisionMarkAuthorTable" "{" "}";
	SavedByTable ::= "SavedByTable" "{" "}";
	TextPieceTable ::= "TextPieceTable" "{" "}";
}