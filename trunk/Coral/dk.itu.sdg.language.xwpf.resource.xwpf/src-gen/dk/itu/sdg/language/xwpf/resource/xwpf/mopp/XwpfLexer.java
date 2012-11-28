// $ANTLR 3.4

	package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class XwpfLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int COMMENT=4;
    public static final int FLOAT=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_34_34=8;
    public static final int TEXT=9;
    public static final int WHITESPACE=10;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public XwpfLexer() {} 
    public XwpfLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public XwpfLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Xwpf.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:15:7: ( ':' )
            // Xwpf.g:15:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:16:7: ( ';' )
            // Xwpf.g:16:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:17:7: ( 'Body' )
            // Xwpf.g:17:9: 'Body'
            {
            match("Body"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:18:7: ( 'BodyElement' )
            // Xwpf.g:18:9: 'BodyElement'
            {
            match("BodyElement"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:19:7: ( 'Comment' )
            // Xwpf.g:19:9: 'Comment'
            {
            match("Comment"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:20:7: ( 'Content' )
            // Xwpf.g:20:9: 'Content'
            {
            match("Content"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:21:7: ( 'Document' )
            // Xwpf.g:21:9: 'Document'
            {
            match("Document"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:22:7: ( 'Footer' )
            // Xwpf.g:22:9: 'Footer'
            {
            match("Footer"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:23:7: ( 'Footnote' )
            // Xwpf.g:23:9: 'Footnote'
            {
            match("Footnote"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:24:7: ( 'Header' )
            // Xwpf.g:24:9: 'Header'
            {
            match("Header"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:25:7: ( 'Heading1' )
            // Xwpf.g:25:9: 'Heading1'
            {
            match("Heading1"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:26:7: ( 'Heading2' )
            // Xwpf.g:26:9: 'Heading2'
            {
            match("Heading2"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:27:7: ( 'Hyperlink' )
            // Xwpf.g:27:9: 'Hyperlink'
            {
            match("Hyperlink"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:28:7: ( 'ListParagraph' )
            // Xwpf.g:28:9: 'ListParagraph'
            {
            match("ListParagraph"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:29:7: ( 'Numbering' )
            // Xwpf.g:29:9: 'Numbering'
            {
            match("Numbering"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:30:7: ( 'Paragraph' )
            // Xwpf.g:30:9: 'Paragraph'
            {
            match("Paragraph"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:31:7: ( 'Part' )
            // Xwpf.g:31:9: 'Part'
            {
            match("Part"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:32:7: ( 'PictureData' )
            // Xwpf.g:32:9: 'PictureData'
            {
            match("PictureData"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:33:7: ( 'Run' )
            // Xwpf.g:33:9: 'Run'
            {
            match("Run"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:34:7: ( 'Table' )
            // Xwpf.g:34:9: 'Table'
            {
            match("Table"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:35:7: ( 'body' )
            // Xwpf.g:35:9: 'body'
            {
            match("body"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:36:7: ( 'bodyElements' )
            // Xwpf.g:36:9: 'bodyElements'
            {
            match("bodyElements"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:37:7: ( 'comments' )
            // Xwpf.g:37:9: 'comments'
            {
            match("comments"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:38:7: ( 'endnotes' )
            // Xwpf.g:38:9: 'endnotes'
            {
            match("endnotes"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:39:7: ( 'footers' )
            // Xwpf.g:39:9: 'footers'
            {
            match("footers"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:40:7: ( 'footnotes' )
            // Xwpf.g:40:9: 'footnotes'
            {
            match("footnotes"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:41:7: ( 'headers' )
            // Xwpf.g:41:9: 'headers'
            {
            match("headers"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:42:7: ( 'hyperlinks' )
            // Xwpf.g:42:9: 'hyperlinks'
            {
            match("hyperlinks"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:43:7: ( 'isBold' )
            // Xwpf.g:43:9: 'isBold'
            {
            match("isBold"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:44:7: ( 'isItalic' )
            // Xwpf.g:44:9: 'isItalic'
            {
            match("isItalic"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:45:7: ( 'isStrike' )
            // Xwpf.g:45:9: 'isStrike'
            {
            match("isStrike"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:46:7: ( 'null' )
            // Xwpf.g:46:9: 'null'
            {
            match("null"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:47:7: ( 'numbering' )
            // Xwpf.g:47:9: 'numbering'
            {
            match("numbering"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:48:7: ( 'packagePictures' )
            // Xwpf.g:48:9: 'packagePictures'
            {
            match("packagePictures"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:49:7: ( 'paragraphs' )
            // Xwpf.g:49:9: 'paragraphs'
            {
            match("paragraphs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:50:7: ( 'part' )
            // Xwpf.g:50:9: 'part'
            {
            match("part"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:51:7: ( 'pictures' )
            // Xwpf.g:51:9: 'pictures'
            {
            match("pictures"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:52:7: ( 'runs' )
            // Xwpf.g:52:9: 'runs'
            {
            match("runs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:53:7: ( 'tables' )
            // Xwpf.g:53:9: 'tables'
            {
            match("tables"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:54:7: ( 'unrecognized' )
            // Xwpf.g:54:9: 'unrecognized'
            {
            match("unrecognized"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:55:7: ( '{' )
            // Xwpf.g:55:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:56:7: ( '}' )
            // Xwpf.g:56:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:4657:8: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Xwpf.g:4658:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Xwpf.g:4658:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Xwpf.g:4658:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Xwpf.g:4658:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Xwpf.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:4661:8: ( ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) )
            // Xwpf.g:4662:2: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            {
            // Xwpf.g:4662:2: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-'||(LA4_0 >= '1' && LA4_0 <= '9')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='0') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // Xwpf.g:4662:3: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Xwpf.g:4662:3: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // Xwpf.g:4662:4: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Xwpf.g:4662:19: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Xwpf.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Xwpf.g:4662:31: '0'
                    {
                    match('0'); 

                    }
                    break;

            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:4665:6: ( ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ ) )
            // Xwpf.g:4666:2: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            {
            // Xwpf.g:4666:2: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // Xwpf.g:4666:3: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // Xwpf.g:4666:3: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Xwpf.g:4666:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Xwpf.g:4666:9: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0 >= '1' && LA7_0 <= '9')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='0') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // Xwpf.g:4666:10: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Xwpf.g:4666:21: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Xwpf.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Xwpf.g:4666:35: '0'
                    {
                    match('0'); 

                    }
                    break;

            }


            match('.'); 

            // Xwpf.g:4666:44: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Xwpf.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:4669:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Xwpf.g:4670:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Xwpf.g:4670:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Xwpf.g:4670:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Xwpf.g:4670:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='-'||(LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Xwpf.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:4672:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Xwpf.g:4673:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:4676:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Xwpf.g:4677:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Xwpf.g:4677:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Xwpf.g:4677:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Xwpf.g:4677:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\r') ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1=='\n') ) {
                    alt10=1;
                }
                else {
                    alt10=2;
                }
            }
            else if ( (LA10_0=='\n') ) {
                alt10=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // Xwpf.g:4677:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Xwpf.g:4677:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Xwpf.g:4677:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xwpf.g:4680:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Xwpf.g:4681:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Xwpf.g:4681:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Xwpf.g:4681:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Xwpf.g:4681:3: ( '\"' )
            // Xwpf.g:4681:4: '\"'
            {
            match('\"'); 

            }


            // Xwpf.g:4681:8: (~ ( '\"' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '\u0000' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= '\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Xwpf.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            // Xwpf.g:4681:17: ( '\"' )
            // Xwpf.g:4681:18: '\"'
            {
            match('\"'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_34_34"

    public void mTokens() throws RecognitionException {
        // Xwpf.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 )
        int alt12=49;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // Xwpf.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // Xwpf.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // Xwpf.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // Xwpf.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // Xwpf.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // Xwpf.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // Xwpf.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // Xwpf.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // Xwpf.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // Xwpf.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // Xwpf.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // Xwpf.g:1:76: T__22
                {
                mT__22(); 


                }
                break;
            case 13 :
                // Xwpf.g:1:82: T__23
                {
                mT__23(); 


                }
                break;
            case 14 :
                // Xwpf.g:1:88: T__24
                {
                mT__24(); 


                }
                break;
            case 15 :
                // Xwpf.g:1:94: T__25
                {
                mT__25(); 


                }
                break;
            case 16 :
                // Xwpf.g:1:100: T__26
                {
                mT__26(); 


                }
                break;
            case 17 :
                // Xwpf.g:1:106: T__27
                {
                mT__27(); 


                }
                break;
            case 18 :
                // Xwpf.g:1:112: T__28
                {
                mT__28(); 


                }
                break;
            case 19 :
                // Xwpf.g:1:118: T__29
                {
                mT__29(); 


                }
                break;
            case 20 :
                // Xwpf.g:1:124: T__30
                {
                mT__30(); 


                }
                break;
            case 21 :
                // Xwpf.g:1:130: T__31
                {
                mT__31(); 


                }
                break;
            case 22 :
                // Xwpf.g:1:136: T__32
                {
                mT__32(); 


                }
                break;
            case 23 :
                // Xwpf.g:1:142: T__33
                {
                mT__33(); 


                }
                break;
            case 24 :
                // Xwpf.g:1:148: T__34
                {
                mT__34(); 


                }
                break;
            case 25 :
                // Xwpf.g:1:154: T__35
                {
                mT__35(); 


                }
                break;
            case 26 :
                // Xwpf.g:1:160: T__36
                {
                mT__36(); 


                }
                break;
            case 27 :
                // Xwpf.g:1:166: T__37
                {
                mT__37(); 


                }
                break;
            case 28 :
                // Xwpf.g:1:172: T__38
                {
                mT__38(); 


                }
                break;
            case 29 :
                // Xwpf.g:1:178: T__39
                {
                mT__39(); 


                }
                break;
            case 30 :
                // Xwpf.g:1:184: T__40
                {
                mT__40(); 


                }
                break;
            case 31 :
                // Xwpf.g:1:190: T__41
                {
                mT__41(); 


                }
                break;
            case 32 :
                // Xwpf.g:1:196: T__42
                {
                mT__42(); 


                }
                break;
            case 33 :
                // Xwpf.g:1:202: T__43
                {
                mT__43(); 


                }
                break;
            case 34 :
                // Xwpf.g:1:208: T__44
                {
                mT__44(); 


                }
                break;
            case 35 :
                // Xwpf.g:1:214: T__45
                {
                mT__45(); 


                }
                break;
            case 36 :
                // Xwpf.g:1:220: T__46
                {
                mT__46(); 


                }
                break;
            case 37 :
                // Xwpf.g:1:226: T__47
                {
                mT__47(); 


                }
                break;
            case 38 :
                // Xwpf.g:1:232: T__48
                {
                mT__48(); 


                }
                break;
            case 39 :
                // Xwpf.g:1:238: T__49
                {
                mT__49(); 


                }
                break;
            case 40 :
                // Xwpf.g:1:244: T__50
                {
                mT__50(); 


                }
                break;
            case 41 :
                // Xwpf.g:1:250: T__51
                {
                mT__51(); 


                }
                break;
            case 42 :
                // Xwpf.g:1:256: T__52
                {
                mT__52(); 


                }
                break;
            case 43 :
                // Xwpf.g:1:262: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 44 :
                // Xwpf.g:1:270: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 45 :
                // Xwpf.g:1:278: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 46 :
                // Xwpf.g:1:284: TEXT
                {
                mTEXT(); 


                }
                break;
            case 47 :
                // Xwpf.g:1:289: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 48 :
                // Xwpf.g:1:300: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 49 :
                // Xwpf.g:1:310: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\3\uffff\25\36\3\uffff\1\36\2\75\4\uffff\32\36\1\75\2\uffff\13\36"+
        "\1\151\22\36\1\176\11\36\1\u008a\1\36\1\uffff\1\36\1\u008e\10\36"+
        "\1\u0098\3\36\1\u009c\1\36\1\u009e\3\36\1\uffff\13\36\1\uffff\1"+
        "\36\1\u00ae\1\36\1\uffff\11\36\1\uffff\3\36\1\uffff\1\36\1\uffff"+
        "\6\36\1\u00c3\1\36\1\u00c5\6\36\1\uffff\7\36\1\u00d3\6\36\1\u00da"+
        "\2\36\1\u00dd\1\u00de\1\36\1\uffff\1\36\1\uffff\11\36\1\u00eb\1"+
        "\36\1\u00ed\1\36\1\uffff\6\36\1\uffff\2\36\2\uffff\1\u00f7\1\u00f8"+
        "\1\u00f9\1\u00fa\6\36\1\u0101\1\u0102\1\uffff\1\36\1\uffff\1\36"+
        "\1\u0105\1\u0106\3\36\1\u010a\2\36\4\uffff\1\u010d\1\36\1\u010f"+
        "\1\u0110\2\36\2\uffff\1\u0113\1\36\2\uffff\1\u0115\2\36\1\uffff"+
        "\2\36\1\uffff\1\36\2\uffff\2\36\1\uffff\1\u011d\1\uffff\1\36\1\u011f"+
        "\1\36\1\u0121\1\36\1\u0123\1\36\1\uffff\1\36\1\uffff\1\36\1\uffff"+
        "\1\36\1\uffff\1\u0128\1\36\1\u012a\1\u012b\1\uffff\1\36\2\uffff"+
        "\1\36\1\u012e\1\uffff";
    static final String DFA12_eofS =
        "\u012f\uffff";
    static final String DFA12_minS =
        "\1\11\2\uffff\4\157\1\145\1\151\1\165\1\141\1\165\1\141\2\157\1"+
        "\156\1\157\1\145\1\163\1\165\1\141\1\165\1\141\1\156\3\uffff\1\60"+
        "\2\55\4\uffff\1\144\1\155\1\143\1\157\1\141\1\160\1\163\1\155\1"+
        "\162\1\143\1\156\1\142\1\144\1\155\1\144\1\157\1\141\1\160\1\102"+
        "\1\154\2\143\1\156\1\142\1\162\1\56\1\55\2\uffff\1\171\1\155\1\164"+
        "\1\165\1\164\1\144\1\145\1\164\1\142\1\141\1\164\1\55\1\154\1\171"+
        "\1\155\1\156\1\164\1\144\1\145\1\157\2\164\1\154\1\142\1\153\1\141"+
        "\1\164\1\163\1\154\1\145\1\55\2\145\1\155\2\145\1\162\1\120\1\145"+
        "\1\147\1\55\1\165\1\uffff\1\145\1\55\1\145\1\157\2\145\1\162\1\154"+
        "\1\141\1\162\1\55\1\145\1\141\1\147\1\55\1\165\1\55\1\145\1\143"+
        "\1\154\1\uffff\2\156\1\145\1\162\1\157\1\162\1\156\1\154\1\141\2"+
        "\162\1\uffff\1\162\1\55\1\154\1\uffff\1\156\1\164\1\162\1\157\1"+
        "\162\1\154\1\144\1\154\1\151\1\uffff\1\162\1\147\1\162\1\uffff\1"+
        "\162\1\uffff\1\163\1\157\1\145\2\164\1\156\1\55\1\164\1\55\1\147"+
        "\1\151\1\162\1\151\1\141\1\145\1\uffff\1\145\1\164\1\145\1\163\1"+
        "\164\1\163\1\151\1\55\1\151\1\153\1\151\1\145\1\141\1\145\1\55\1"+
        "\147\1\155\2\55\1\164\1\uffff\1\145\1\uffff\1\61\1\156\1\141\1\156"+
        "\1\160\1\104\1\155\2\163\1\55\1\145\1\55\1\156\1\uffff\1\143\1\145"+
        "\1\156\1\120\1\160\1\163\1\uffff\1\156\1\145\2\uffff\4\55\1\153"+
        "\2\147\1\150\1\141\1\145\2\55\1\uffff\1\163\1\uffff\1\153\2\55\1"+
        "\147\1\151\1\150\1\55\1\151\1\156\4\uffff\1\55\1\162\2\55\1\164"+
        "\1\156\2\uffff\1\55\1\163\2\uffff\1\55\1\143\1\163\1\uffff\1\172"+
        "\1\164\1\uffff\1\141\2\uffff\1\141\1\164\1\uffff\1\55\1\uffff\1"+
        "\164\1\55\1\145\1\55\1\160\1\55\1\163\1\uffff\1\165\1\uffff\1\144"+
        "\1\uffff\1\150\1\uffff\1\55\1\162\2\55\1\uffff\1\145\2\uffff\1\163"+
        "\1\55\1\uffff";
    static final String DFA12_maxS =
        "\1\175\2\uffff\4\157\1\171\1\151\1\165\1\151\1\165\1\141\2\157\1"+
        "\156\1\157\1\171\1\163\1\165\1\151\1\165\1\141\1\156\3\uffff\1\71"+
        "\2\172\4\uffff\1\144\1\156\1\143\1\157\1\141\1\160\1\163\1\155\1"+
        "\162\1\143\1\156\1\142\1\144\1\155\1\144\1\157\1\141\1\160\1\123"+
        "\1\155\1\162\1\143\1\156\1\142\1\162\1\56\1\172\2\uffff\1\171\1"+
        "\155\1\164\1\165\1\164\1\144\1\145\1\164\1\142\2\164\1\172\1\154"+
        "\1\171\1\155\1\156\1\164\1\144\1\145\1\157\2\164\1\154\1\142\1\153"+
        "\2\164\1\163\1\154\1\145\1\172\2\145\1\155\1\156\1\151\1\162\1\120"+
        "\1\145\1\147\1\172\1\165\1\uffff\1\145\1\172\1\145\1\157\1\156\1"+
        "\145\1\162\1\154\1\141\1\162\1\172\1\145\1\141\1\147\1\172\1\165"+
        "\1\172\1\145\1\143\1\154\1\uffff\2\156\1\145\1\162\1\157\1\162\1"+
        "\156\1\154\1\141\2\162\1\uffff\1\162\1\172\1\154\1\uffff\1\156\1"+
        "\164\1\162\1\157\1\162\1\154\1\144\1\154\1\151\1\uffff\1\162\1\147"+
        "\1\162\1\uffff\1\162\1\uffff\1\163\1\157\1\145\2\164\1\156\1\172"+
        "\1\164\1\172\1\147\1\151\1\162\1\151\1\141\1\145\1\uffff\1\145\1"+
        "\164\1\145\1\163\1\164\1\163\1\151\1\172\1\151\1\153\1\151\1\145"+
        "\1\141\1\145\1\172\1\147\1\155\2\172\1\164\1\uffff\1\145\1\uffff"+
        "\1\62\1\156\1\141\1\156\1\160\1\104\1\155\2\163\1\172\1\145\1\172"+
        "\1\156\1\uffff\1\143\1\145\1\156\1\120\1\160\1\163\1\uffff\1\156"+
        "\1\145\2\uffff\4\172\1\153\2\147\1\150\1\141\1\145\2\172\1\uffff"+
        "\1\163\1\uffff\1\153\2\172\1\147\1\151\1\150\1\172\1\151\1\156\4"+
        "\uffff\1\172\1\162\2\172\1\164\1\156\2\uffff\1\172\1\163\2\uffff"+
        "\1\172\1\143\1\163\1\uffff\1\172\1\164\1\uffff\1\141\2\uffff\1\141"+
        "\1\164\1\uffff\1\172\1\uffff\1\164\1\172\1\145\1\172\1\160\1\172"+
        "\1\163\1\uffff\1\165\1\uffff\1\144\1\uffff\1\150\1\uffff\1\172\1"+
        "\162\2\172\1\uffff\1\145\2\uffff\1\163\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\25\uffff\1\51\1\52\1\53\3\uffff\1\56\1\57\1\60"+
        "\1\61\33\uffff\1\54\1\55\52\uffff\1\23\24\uffff\1\3\13\uffff\1\21"+
        "\3\uffff\1\25\11\uffff\1\40\3\uffff\1\44\1\uffff\1\46\17\uffff\1"+
        "\24\24\uffff\1\10\1\uffff\1\12\15\uffff\1\35\6\uffff\1\47\2\uffff"+
        "\1\5\1\6\14\uffff\1\31\1\uffff\1\33\11\uffff\1\7\1\11\1\13\1\14"+
        "\6\uffff\1\27\1\30\2\uffff\1\36\1\37\3\uffff\1\45\2\uffff\1\15\1"+
        "\uffff\1\17\1\20\2\uffff\1\32\1\uffff\1\41\7\uffff\1\34\1\uffff"+
        "\1\43\1\uffff\1\4\1\uffff\1\22\4\uffff\1\26\1\uffff\1\50\1\16\2"+
        "\uffff\1\42";
    static final String DFA12_specialS =
        "\u012f\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\37\1\40\1\uffff\1\37\1\40\22\uffff\1\37\1\uffff\1\41\12\uffff"+
            "\1\33\1\uffff\1\32\1\35\11\34\1\1\1\2\5\uffff\1\36\1\3\1\4\1"+
            "\5\1\36\1\6\1\36\1\7\3\36\1\10\1\36\1\11\1\36\1\12\1\36\1\13"+
            "\1\36\1\14\6\36\4\uffff\1\36\1\uffff\1\36\1\15\1\16\1\36\1\17"+
            "\1\20\1\36\1\21\1\22\4\36\1\23\1\36\1\24\1\36\1\25\1\36\1\26"+
            "\1\27\5\36\1\30\1\uffff\1\31",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46\23\uffff\1\47",
            "\1\50",
            "\1\51",
            "\1\52\7\uffff\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62\23\uffff\1\63",
            "\1\64",
            "\1\65",
            "\1\66\7\uffff\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "",
            "",
            "",
            "\1\73\11\34",
            "\1\36\1\76\1\uffff\12\74\7\uffff\32\36\4\uffff\1\36\1\uffff"+
            "\32\36",
            "\1\36\1\76\1\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff"+
            "\32\36",
            "",
            "",
            "",
            "",
            "\1\77",
            "\1\100\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122\6\uffff\1\123\11\uffff\1\124",
            "\1\125\1\126",
            "\1\127\16\uffff\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\76",
            "\1\36\1\76\1\uffff\12\74\7\uffff\32\36\4\uffff\1\36\1\uffff"+
            "\32\36",
            "",
            "",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146\22\uffff\1\147",
            "\1\150",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167\22\uffff\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\36\2\uffff\12\36\7\uffff\4\36\1\175\25\36\4\uffff\1\36\1"+
            "\uffff\32\36",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082\10\uffff\1\u0083",
            "\1\u0084\3\uffff\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u008b",
            "",
            "\1\u008c",
            "\1\36\2\uffff\12\36\7\uffff\4\36\1\u008d\25\36\4\uffff\1\36"+
            "\1\uffff\32\36",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091\10\uffff\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u009d",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "\1\u00ad",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "",
            "\1\u00bc",
            "",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00c4",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00db",
            "\1\u00dc",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00df",
            "",
            "\1\u00e0",
            "",
            "\1\u00e1\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00ec",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00ee",
            "",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "",
            "",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\u0103",
            "",
            "\1\u0104",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u010b",
            "\1\u010c",
            "",
            "",
            "",
            "",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u010e",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0111",
            "\1\u0112",
            "",
            "",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0114",
            "",
            "",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0116",
            "\1\u0117",
            "",
            "\1\u0118",
            "\1\u0119",
            "",
            "\1\u011a",
            "",
            "",
            "\1\u011b",
            "\1\u011c",
            "",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\u011e",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0120",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0122",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0124",
            "",
            "\1\u0125",
            "",
            "\1\u0126",
            "",
            "\1\u0127",
            "",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0129",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\u012c",
            "",
            "",
            "\1\u012d",
            "\1\36\2\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 );";
        }
    }
 

}