// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.refactoring.specification.resource.mopp;


import org.antlr.runtime3_2_0.*;

public class RefspecLexer extends Lexer {
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int FLOAT=14;
    public static final int UPPER_IDENTIFIER=4;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__39=39;
    public static final int INTEGER=9;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int T__17=17;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int ML_COMMENT=11;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int DOT_NOTATION=7;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int LOWER_IDENTIFIER=6;
    public static final int LINEBREAKS=13;
    public static final int T__44=44;
    public static final int CONSTANTS=8;
    public static final int COMMENT=10;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int QUOTED_60_62=5;
    public static final int WHITESPACE=12;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__41=41;
    public static final int T__18=18;

    	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
    	public java.util.List<java.lang.Integer> lexerExceptionsPosition = new java.util.ArrayList<java.lang.Integer>();
    	
    	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators

    public RefspecLexer() {;} 
    public RefspecLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RefspecLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Refspec.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:16:7: ( 'REFACTORING' )
            // Refspec.g:16:9: 'REFACTORING'
            {
            match("REFACTORING"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:17:7: ( 'FOR' )
            // Refspec.g:17:9: 'FOR'
            {
            match("FOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:18:7: ( 'STEPS' )
            // Refspec.g:18:9: 'STEPS'
            {
            match("STEPS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:19:7: ( '{' )
            // Refspec.g:19:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:20:7: ( ';' )
            // Refspec.g:20:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:21:7: ( '}' )
            // Refspec.g:21:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:22:7: ( 'create' )
            // Refspec.g:22:9: 'create'
            {
            match("create"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:23:7: ( 'new' )
            // Refspec.g:23:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:24:7: ( ':' )
            // Refspec.g:24:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:25:7: ( 'in' )
            // Refspec.g:25:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:26:7: ( 'at' )
            // Refspec.g:26:9: 'at'
            {
            match("at"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:27:7: ( 'move' )
            // Refspec.g:27:9: 'move'
            {
            match("move"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:28:7: ( 'to' )
            // Refspec.g:28:9: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:29:7: ( 'set' )
            // Refspec.g:29:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:30:7: ( 'use' )
            // Refspec.g:30:9: 'use'
            {
            match("use"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:31:7: ( 'of' )
            // Refspec.g:31:9: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:32:7: ( 'assign' )
            // Refspec.g:32:9: 'assign'
            {
            match("assign"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:33:7: ( 'for' )
            // Refspec.g:33:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:34:7: ( 'and' )
            // Refspec.g:34:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:35:7: ( 'update' )
            // Refspec.g:35:9: 'update'
            {
            match("update"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:36:7: ( 'object' )
            // Refspec.g:36:9: 'object'
            {
            match("object"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:37:7: ( ':=' )
            // Refspec.g:37:9: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:38:7: ( 'from' )
            // Refspec.g:38:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:39:7: ( 'as' )
            // Refspec.g:39:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:40:7: ( 'trace' )
            // Refspec.g:40:9: 'trace'
            {
            match("trace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:41:7: ( '(' )
            // Refspec.g:41:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:42:7: ( ')' )
            // Refspec.g:42:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:43:7: ( 'uptree' )
            // Refspec.g:43:9: 'uptree'
            {
            match("uptree"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:44:7: ( 'path' )
            // Refspec.g:44:9: 'path'
            {
            match("path"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:45:7: ( 'index' )
            // Refspec.g:45:9: 'index'
            {
            match("index"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:46:7: ( 'first' )
            // Refspec.g:46:9: 'first'
            {
            match("first"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:47:7: ( 'last' )
            // Refspec.g:47:9: 'last'
            {
            match("last"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2322:8: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Refspec.g:2323:2: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 

            // Refspec.g:2323:6: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Refspec.g:2323:7: ~ ( '\\n' | '\\r' | '\\uffff' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2326:11: ( '/*' ( . )* '*/' )
            // Refspec.g:2327:2: '/*' ( . )* '*/'
            {
            match("/*"); 

            // Refspec.g:2327:6: ( . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Refspec.g:2327:6: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("*/"); 

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2329:11: ( ( ' ' | '\\t' | '\\f' ) )
            // Refspec.g:2330:2: ( ' ' | '\\t' | '\\f' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAKS"
    public final void mLINEBREAKS() throws RecognitionException {
        try {
            int _type = LINEBREAKS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2333:11: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Refspec.g:2334:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Refspec.g:2334:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='\n') ) {
                    alt3=1;
                }
                else {
                    alt3=2;}
            }
            else if ( (LA3_0=='\n') ) {
                alt3=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // Refspec.g:2334:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // Refspec.g:2334:10: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Refspec.g:2334:15: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINEBREAKS"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2337:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='1' && LA5_0<='9')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='0') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // Refspec.g:2338:2: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Refspec.g:2338:2: ( '1' .. '9' )
                    // Refspec.g:2338:3: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // Refspec.g:2338:12: ( '0' .. '9' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Refspec.g:2338:13: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Refspec.g:2338:24: '0'
                    {
                    match('0'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2339:6: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // Refspec.g:2340:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // Refspec.g:2340:2: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Refspec.g:2340:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // Refspec.g:2340:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='1' && LA8_0<='9')) ) {
                alt8=1;
            }
            else if ( (LA8_0=='0') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // Refspec.g:2340:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Refspec.g:2340:9: ( '1' .. '9' )
                    // Refspec.g:2340:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // Refspec.g:2340:20: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Refspec.g:2340:21: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Refspec.g:2340:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // Refspec.g:2340:43: ( '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Refspec.g:2340:44: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "CONSTANTS"
    public final void mCONSTANTS() throws RecognitionException {
        try {
            int _type = CONSTANTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2342:10: ( 'INPUT' )
            // Refspec.g:2343:2: 'INPUT'
            {
            match("INPUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONSTANTS"

    // $ANTLR start "UPPER_IDENTIFIER"
    public final void mUPPER_IDENTIFIER() throws RecognitionException {
        try {
            int _type = UPPER_IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2344:17: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // Refspec.g:2345:2: ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            // Refspec.g:2345:2: ( 'A' .. 'Z' )
            // Refspec.g:2345:3: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

            // Refspec.g:2345:12: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Refspec.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UPPER_IDENTIFIER"

    // $ANTLR start "LOWER_IDENTIFIER"
    public final void mLOWER_IDENTIFIER() throws RecognitionException {
        try {
            int _type = LOWER_IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2346:17: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // Refspec.g:2347:2: ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            // Refspec.g:2347:2: ( 'a' .. 'z' )
            // Refspec.g:2347:3: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

            // Refspec.g:2347:12: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Refspec.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOWER_IDENTIFIER"

    // $ANTLR start "DOT_NOTATION"
    public final void mDOT_NOTATION() throws RecognitionException {
        try {
            int _type = DOT_NOTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2348:13: ( ( ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* | ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* ) '.' ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // Refspec.g:2349:2: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* | ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* ) '.' ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            // Refspec.g:2349:2: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* | ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>='A' && LA14_0<='Z')) ) {
                alt14=1;
            }
            else if ( ((LA14_0>='a' && LA14_0<='z')) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // Refspec.g:2349:3: ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
                    {
                    // Refspec.g:2349:3: ( 'A' .. 'Z' )
                    // Refspec.g:2349:4: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }

                    // Refspec.g:2349:13: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')||(LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Refspec.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Refspec.g:2349:47: ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
                    {
                    // Refspec.g:2349:47: ( 'a' .. 'z' )
                    // Refspec.g:2349:48: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }

                    // Refspec.g:2349:57: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='z')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // Refspec.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            match('.'); 
            // Refspec.g:2349:94: ( 'a' .. 'z' )
            // Refspec.g:2349:95: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

            // Refspec.g:2349:104: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')||(LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='z')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Refspec.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT_NOTATION"

    // $ANTLR start "QUOTED_60_62"
    public final void mQUOTED_60_62() throws RecognitionException {
        try {
            int _type = QUOTED_60_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:2350:13: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            // Refspec.g:2351:2: ( '<' ) (~ ( '>' ) )* ( '>' )
            {
            // Refspec.g:2351:2: ( '<' )
            // Refspec.g:2351:3: '<'
            {
            match('<'); 

            }

            // Refspec.g:2351:7: (~ ( '>' ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='=')||(LA16_0>='?' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // Refspec.g:2351:8: ~ ( '>' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // Refspec.g:2351:16: ( '>' )
            // Refspec.g:2351:17: '>'
            {
            match('>'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_60_62"

    public void mTokens() throws RecognitionException {
        // Refspec.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | COMMENT | ML_COMMENT | WHITESPACE | LINEBREAKS | INTEGER | FLOAT | CONSTANTS | UPPER_IDENTIFIER | LOWER_IDENTIFIER | DOT_NOTATION | QUOTED_60_62 )
        int alt17=43;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // Refspec.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // Refspec.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // Refspec.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // Refspec.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // Refspec.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // Refspec.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // Refspec.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // Refspec.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // Refspec.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // Refspec.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // Refspec.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // Refspec.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // Refspec.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // Refspec.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // Refspec.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // Refspec.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // Refspec.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // Refspec.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // Refspec.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // Refspec.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // Refspec.g:1:130: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // Refspec.g:1:136: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // Refspec.g:1:142: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // Refspec.g:1:148: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // Refspec.g:1:154: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // Refspec.g:1:160: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // Refspec.g:1:166: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // Refspec.g:1:172: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // Refspec.g:1:178: T__43
                {
                mT__43(); 

                }
                break;
            case 30 :
                // Refspec.g:1:184: T__44
                {
                mT__44(); 

                }
                break;
            case 31 :
                // Refspec.g:1:190: T__45
                {
                mT__45(); 

                }
                break;
            case 32 :
                // Refspec.g:1:196: T__46
                {
                mT__46(); 

                }
                break;
            case 33 :
                // Refspec.g:1:202: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 34 :
                // Refspec.g:1:210: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 35 :
                // Refspec.g:1:221: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 36 :
                // Refspec.g:1:232: LINEBREAKS
                {
                mLINEBREAKS(); 

                }
                break;
            case 37 :
                // Refspec.g:1:243: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 38 :
                // Refspec.g:1:251: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 39 :
                // Refspec.g:1:257: CONSTANTS
                {
                mCONSTANTS(); 

                }
                break;
            case 40 :
                // Refspec.g:1:267: UPPER_IDENTIFIER
                {
                mUPPER_IDENTIFIER(); 

                }
                break;
            case 41 :
                // Refspec.g:1:284: LOWER_IDENTIFIER
                {
                mLOWER_IDENTIFIER(); 

                }
                break;
            case 42 :
                // Refspec.g:1:301: DOT_NOTATION
                {
                mDOT_NOTATION(); 

                }
                break;
            case 43 :
                // Refspec.g:1:314: QUOTED_60_62
                {
                mQUOTED_60_62(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\1\uffff\3\43\3\uffff\2\50\1\53\10\50\2\uffff\2\50\3\uffff\2\100"+
        "\1\uffff\2\43\1\50\1\uffff\2\43\2\uffff\2\43\2\50\1\uffff\1\50\2"+
        "\uffff\1\110\1\111\1\113\2\50\1\116\4\50\1\124\6\50\2\uffff\1\100"+
        "\1\uffff\2\43\1\135\1\43\1\50\1\140\1\50\2\uffff\1\50\1\uffff\1"+
        "\143\1\50\1\uffff\1\50\1\146\1\147\2\50\1\uffff\1\50\1\153\4\50"+
        "\2\43\1\uffff\1\43\1\50\1\uffff\2\50\1\uffff\1\166\1\50\2\uffff"+
        "\3\50\1\uffff\1\173\1\50\1\175\1\176\2\43\1\u0081\1\50\1\u0083\1"+
        "\50\1\uffff\1\u0085\3\50\1\uffff\1\u0089\2\uffff\1\u008a\1\43\1"+
        "\uffff\1\u008c\1\uffff\1\u008d\1\uffff\1\u008e\1\u008f\1\u0090\2"+
        "\uffff\1\43\5\uffff\3\43\1\u0095\1\uffff";
    static final String DFA17_eofS =
        "\u0096\uffff";
    static final String DFA17_minS =
        "\1\11\3\56\3\uffff\2\56\1\75\10\56\2\uffff\2\56\1\52\2\uffff\2"+
        "\56\1\uffff\3\56\1\uffff\2\56\2\uffff\4\56\1\uffff\1\56\2\uffff"+
        "\21\56\2\uffff\1\56\1\uffff\7\56\2\uffff\1\56\1\uffff\2\56\1\uffff"+
        "\5\56\1\uffff\10\56\1\uffff\2\56\1\uffff\2\56\1\uffff\2\56\2\uffff"+
        "\3\56\1\uffff\12\56\1\uffff\4\56\1\uffff\1\56\2\uffff\2\56\1\uffff"+
        "\1\56\1\uffff\1\56\1\uffff\3\56\2\uffff\1\56\5\uffff\4\56\1\uffff";
    static final String DFA17_maxS =
        "\1\175\3\172\3\uffff\2\172\1\75\10\172\2\uffff\2\172\1\57\2\uffff"+
        "\1\71\1\56\1\uffff\3\172\1\uffff\2\172\2\uffff\4\172\1\uffff\1\172"+
        "\2\uffff\21\172\2\uffff\1\71\1\uffff\7\172\2\uffff\1\172\1\uffff"+
        "\2\172\1\uffff\5\172\1\uffff\10\172\1\uffff\2\172\1\uffff\2\172"+
        "\1\uffff\2\172\2\uffff\3\172\1\uffff\12\172\1\uffff\4\172\1\uffff"+
        "\1\172\2\uffff\2\172\1\uffff\1\172\1\uffff\1\172\1\uffff\3\172\2"+
        "\uffff\1\172\5\uffff\4\172\1\uffff";
    static final String DFA17_acceptS =
        "\4\uffff\1\4\1\5\1\6\13\uffff\1\32\1\33\3\uffff\1\43\1\44\2\uffff"+
        "\1\46\3\uffff\1\53\2\uffff\1\52\1\50\4\uffff\1\51\1\uffff\1\26\1"+
        "\11\21\uffff\1\41\1\42\1\uffff\1\45\7\uffff\1\12\1\13\1\uffff\1"+
        "\30\2\uffff\1\15\5\uffff\1\20\10\uffff\1\2\2\uffff\1\10\2\uffff"+
        "\1\23\2\uffff\1\16\1\17\3\uffff\1\22\12\uffff\1\14\4\uffff\1\27"+
        "\1\uffff\1\35\1\40\2\uffff\1\3\1\uffff\1\36\1\uffff\1\31\3\uffff"+
        "\1\37\1\47\1\uffff\1\7\1\21\1\24\1\34\1\25\4\uffff\1\1";
    static final String DFA17_specialS =
        "\u0096\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\27\1\30\1\uffff\1\27\1\30\22\uffff\1\27\7\uffff\1\22\1\23"+
            "\3\uffff\1\33\1\uffff\1\26\1\32\11\31\1\11\1\5\1\37\4\uffff"+
            "\5\35\1\2\2\35\1\34\10\35\1\1\1\3\7\35\6\uffff\1\13\1\36\1\7"+
            "\2\36\1\21\2\36\1\12\2\36\1\25\1\14\1\10\1\20\1\24\2\36\1\16"+
            "\1\15\1\17\5\36\1\4\1\uffff\1\6",
            "\1\42\1\uffff\12\41\7\uffff\4\41\1\40\25\41\4\uffff\1\41\1"+
            "\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\16\41\1\44\13\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\23\41\1\45\6\41\4\uffff\1\41\1"+
            "\uffff\32\41",
            "",
            "",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\21"+
            "\47\1\46\10\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\51\25\47",
            "\1\52",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\15"+
            "\47\1\54\14\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\15"+
            "\47\1\57\4\47\1\56\1\55\6\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\16"+
            "\47\1\60\13\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\16"+
            "\47\1\61\2\47\1\62\10\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\63\25\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\17"+
            "\47\1\65\2\47\1\64\7\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\1\47"+
            "\1\67\3\47\1\66\24\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\10"+
            "\47\1\72\5\47\1\70\2\47\1\71\10\47",
            "",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\1\73"+
            "\31\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\1\74"+
            "\31\47",
            "\1\76\4\uffff\1\75",
            "",
            "",
            "\1\33\1\uffff\12\77",
            "\1\33",
            "",
            "\1\42\1\uffff\12\41\7\uffff\15\41\1\101\14\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "",
            "\1\42\1\uffff\12\41\7\uffff\5\41\1\102\24\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "",
            "",
            "\1\42\1\uffff\12\41\7\uffff\21\41\1\103\10\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\4\41\1\104\25\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\105\25\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\26"+
            "\47\1\106\3\47",
            "",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\3\47"+
            "\1\107\26\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\22"+
            "\47\1\112\7\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\3\47"+
            "\1\114\26\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\25"+
            "\47\1\115\4\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\1\117"+
            "\31\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\23"+
            "\47\1\120\6\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\121\25\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\3\47"+
            "\1\122\17\47\1\123\6\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\11"+
            "\47\1\125\20\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\21"+
            "\47\1\126\10\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\16"+
            "\47\1\127\13\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\21"+
            "\47\1\130\10\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\23"+
            "\47\1\131\6\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\22"+
            "\47\1\132\7\47",
            "",
            "",
            "\1\33\1\uffff\12\77",
            "",
            "\1\42\1\uffff\12\41\7\uffff\17\41\1\133\12\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\1\134\31\41\4\uffff\1\41\1\uffff"+
            "\32\41",
            "\1\42\1\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\42\1\uffff\12\41\7\uffff\17\41\1\136\12\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\1\137"+
            "\31\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\141\25\47",
            "",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\10"+
            "\47\1\142\21\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\144\25\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\2\47"+
            "\1\145\27\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\1\150"+
            "\31\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\21"+
            "\47\1\151\10\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\152\25\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\14"+
            "\47\1\154\15\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\22"+
            "\47\1\155\7\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\7\47"+
            "\1\156\22\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\23"+
            "\47\1\157\6\47",
            "\1\42\1\uffff\12\41\7\uffff\24\41\1\160\5\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\2\41\1\161\27\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "",
            "\1\42\1\uffff\12\41\7\uffff\22\41\1\162\7\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\23"+
            "\47\1\163\6\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\27"+
            "\47\1\164\2\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\6\47"+
            "\1\165\23\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\167\25\47",
            "",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\23"+
            "\47\1\170\6\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\171\25\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\2\47"+
            "\1\172\27\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\23"+
            "\47\1\174\6\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\41\7\uffff\23\41\1\177\6\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\23\41\1\u0080\6\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\u0082\25\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\15"+
            "\47\1\u0084\14\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\u0086\25\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47"+
            "\1\u0087\25\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\23"+
            "\47\1\u0088\6\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "",
            "",
            "\1\42\1\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            "\1\42\1\uffff\12\41\7\uffff\16\41\1\u008b\13\41\4\uffff\1"+
            "\41\1\uffff\32\41",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\42\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "",
            "",
            "\1\42\1\uffff\12\41\7\uffff\21\41\1\u0091\10\41\4\uffff\1"+
            "\41\1\uffff\32\41",
            "",
            "",
            "",
            "",
            "",
            "\1\42\1\uffff\12\41\7\uffff\10\41\1\u0092\21\41\4\uffff\1"+
            "\41\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\15\41\1\u0093\14\41\4\uffff\1"+
            "\41\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\6\41\1\u0094\23\41\4\uffff\1\41"+
            "\1\uffff\32\41",
            "\1\42\1\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | COMMENT | ML_COMMENT | WHITESPACE | LINEBREAKS | INTEGER | FLOAT | CONSTANTS | UPPER_IDENTIFIER | LOWER_IDENTIFIER | DOT_NOTATION | QUOTED_60_62 );";
        }
    }
 

}