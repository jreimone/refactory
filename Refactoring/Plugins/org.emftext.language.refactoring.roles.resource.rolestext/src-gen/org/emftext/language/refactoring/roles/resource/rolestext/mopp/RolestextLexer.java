// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.refactoring.roles.resource.rolestext.mopp;


import org.antlr.runtime3_2_0.*;

public class RolestextLexer extends Lexer {
    public static final int T__28=28;
    public static final int TRANSITIVE=8;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int NUMBER=10;
    public static final int INPUT=6;
    public static final int WHITESPACE=13;
    public static final int EOF=-1;
    public static final int LINEBREAKS=14;
    public static final int OPTIONAL=5;
    public static final int RUNTIME=7;
    public static final int T__19=19;
    public static final int ML_COMMENT=12;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int IDENTIFIER=4;
    public static final int SL_COMMENT=11;
    public static final int REFLEXIVE=9;

    	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
    	public java.util.List<java.lang.Integer> lexerExceptionsPosition = new java.util.ArrayList<java.lang.Integer>();
    	
    	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators

    public RolestextLexer() {;} 
    public RolestextLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RolestextLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Rolestext.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:16:7: ( 'RoleModel' )
            // Rolestext.g:16:9: 'RoleModel'
            {
            match("RoleModel"); 


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
            // Rolestext.g:17:7: ( '{' )
            // Rolestext.g:17:9: '{'
            {
            match('{'); 

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
            // Rolestext.g:18:7: ( '}' )
            // Rolestext.g:18:9: '}'
            {
            match('}'); 

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
            // Rolestext.g:19:7: ( 'role' )
            // Rolestext.g:19:9: 'role'
            {
            match("role"); 


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
            // Rolestext.g:20:7: ( '(' )
            // Rolestext.g:20:9: '('
            {
            match('('); 

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
            // Rolestext.g:21:7: ( ')' )
            // Rolestext.g:21:9: ')'
            {
            match(')'); 

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
            // Rolestext.g:22:7: ( ';' )
            // Rolestext.g:22:9: ';'
            {
            match(';'); 

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
            // Rolestext.g:23:7: ( '|-|' )
            // Rolestext.g:23:9: '|-|'
            {
            match("|-|"); 


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
            // Rolestext.g:24:7: ( '->' )
            // Rolestext.g:24:9: '->'
            {
            match("->"); 


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
            // Rolestext.g:25:7: ( '--' )
            // Rolestext.g:25:9: '--'
            {
            match("--"); 


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
            // Rolestext.g:26:7: ( '<>-' )
            // Rolestext.g:26:9: '<>-'
            {
            match("<>-"); 


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
            // Rolestext.g:27:7: ( '[' )
            // Rolestext.g:27:9: '['
            {
            match('['); 

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
            // Rolestext.g:28:7: ( '..' )
            // Rolestext.g:28:9: '..'
            {
            match(".."); 


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
            // Rolestext.g:29:7: ( ']' )
            // Rolestext.g:29:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:2358:11: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Rolestext.g:2359:2: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 

            // Rolestext.g:2359:6: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Rolestext.g:2359:7: ~ ( '\\n' | '\\r' | '\\uffff' )
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
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:2362:11: ( '/*' ( . )* '*/' )
            // Rolestext.g:2363:2: '/*' ( . )* '*/'
            {
            match("/*"); 

            // Rolestext.g:2363:6: ( . )*
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
            	    // Rolestext.g:2363:6: .
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
            // Rolestext.g:2365:11: ( ( ' ' | '\\t' | '\\f' ) )
            // Rolestext.g:2366:2: ( ' ' | '\\t' | '\\f' )
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
            // Rolestext.g:2369:11: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Rolestext.g:2370:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Rolestext.g:2370:2: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Rolestext.g:2370:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // Rolestext.g:2370:10: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Rolestext.g:2370:15: '\\n'
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

    // $ANTLR start "OPTIONAL"
    public final void mOPTIONAL() throws RecognitionException {
        try {
            int _type = OPTIONAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:2373:9: ( 'optional' )
            // Rolestext.g:2374:2: 'optional'
            {
            match("optional"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPTIONAL"

    // $ANTLR start "INPUT"
    public final void mINPUT() throws RecognitionException {
        try {
            int _type = INPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:2375:6: ( 'input' )
            // Rolestext.g:2376:2: 'input'
            {
            match("input"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INPUT"

    // $ANTLR start "RUNTIME"
    public final void mRUNTIME() throws RecognitionException {
        try {
            int _type = RUNTIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:2377:8: ( 'runtime' )
            // Rolestext.g:2378:2: 'runtime'
            {
            match("runtime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RUNTIME"

    // $ANTLR start "TRANSITIVE"
    public final void mTRANSITIVE() throws RecognitionException {
        try {
            int _type = TRANSITIVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:2379:11: ( 'transitive' )
            // Rolestext.g:2380:2: 'transitive'
            {
            match("transitive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRANSITIVE"

    // $ANTLR start "REFLEXIVE"
    public final void mREFLEXIVE() throws RecognitionException {
        try {
            int _type = REFLEXIVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:2381:10: ( 'reflexiv' )
            // Rolestext.g:2382:2: 'reflexiv'
            {
            match("reflexiv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REFLEXIVE"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:2383:11: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // Rolestext.g:2384:2: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // Rolestext.g:2384:21: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Rolestext.g:
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
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Rolestext.g:2385:7: ( ( '0' ) | ( '-1' ) | ( ( '1' .. '9' ) ( '0' .. '9' )* ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case '0':
                {
                alt6=1;
                }
                break;
            case '-':
                {
                alt6=2;
                }
                break;
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // Rolestext.g:2386:2: ( '0' )
                    {
                    // Rolestext.g:2386:2: ( '0' )
                    // Rolestext.g:2386:3: '0'
                    {
                    match('0'); 

                    }


                    }
                    break;
                case 2 :
                    // Rolestext.g:2386:8: ( '-1' )
                    {
                    // Rolestext.g:2386:8: ( '-1' )
                    // Rolestext.g:2386:9: '-1'
                    {
                    match("-1"); 


                    }


                    }
                    break;
                case 3 :
                    // Rolestext.g:2386:15: ( ( '1' .. '9' ) ( '0' .. '9' )* )
                    {
                    // Rolestext.g:2386:15: ( ( '1' .. '9' ) ( '0' .. '9' )* )
                    // Rolestext.g:2386:16: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Rolestext.g:2386:16: ( '1' .. '9' )
                    // Rolestext.g:2386:17: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // Rolestext.g:2386:26: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Rolestext.g:2386:27: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    public void mTokens() throws RecognitionException {
        // Rolestext.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | SL_COMMENT | ML_COMMENT | WHITESPACE | LINEBREAKS | OPTIONAL | INPUT | RUNTIME | TRANSITIVE | REFLEXIVE | IDENTIFIER | NUMBER )
        int alt7=25;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // Rolestext.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // Rolestext.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // Rolestext.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // Rolestext.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // Rolestext.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // Rolestext.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // Rolestext.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // Rolestext.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // Rolestext.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // Rolestext.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // Rolestext.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // Rolestext.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // Rolestext.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // Rolestext.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // Rolestext.g:1:94: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 16 :
                // Rolestext.g:1:105: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 17 :
                // Rolestext.g:1:116: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 18 :
                // Rolestext.g:1:127: LINEBREAKS
                {
                mLINEBREAKS(); 

                }
                break;
            case 19 :
                // Rolestext.g:1:138: OPTIONAL
                {
                mOPTIONAL(); 

                }
                break;
            case 20 :
                // Rolestext.g:1:147: INPUT
                {
                mINPUT(); 

                }
                break;
            case 21 :
                // Rolestext.g:1:153: RUNTIME
                {
                mRUNTIME(); 

                }
                break;
            case 22 :
                // Rolestext.g:1:161: TRANSITIVE
                {
                mTRANSITIVE(); 

                }
                break;
            case 23 :
                // Rolestext.g:1:172: REFLEXIVE
                {
                mREFLEXIVE(); 

                }
                break;
            case 24 :
                // Rolestext.g:1:182: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 25 :
                // Rolestext.g:1:193: NUMBER
                {
                mNUMBER(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\1\24\2\uffff\1\24\14\uffff\3\24\2\uffff\4\24\4\uffff\13"+
        "\24\1\60\6\24\1\uffff\3\24\1\72\5\24\1\uffff\2\24\1\102\4\24\1\uffff"+
        "\1\107\1\110\1\24\1\112\2\uffff\1\24\1\uffff\1\114\1\uffff";
    static final String DFA7_eofS =
        "\115\uffff";
    static final String DFA7_minS =
        "\1\11\1\157\2\uffff\1\145\4\uffff\1\55\4\uffff\1\52\2\uffff\1\160"+
        "\1\156\1\162\2\uffff\2\154\1\156\1\146\4\uffff\1\164\1\160\1\141"+
        "\2\145\1\164\1\154\1\151\1\165\1\156\1\115\1\60\1\151\1\145\1\157"+
        "\1\164\1\163\1\157\1\uffff\1\155\1\170\1\156\1\60\1\151\1\144\1"+
        "\145\1\151\1\141\1\uffff\1\164\1\145\1\60\1\166\1\154\1\151\1\154"+
        "\1\uffff\2\60\1\166\1\60\2\uffff\1\145\1\uffff\1\60\1\uffff";
    static final String DFA7_maxS =
        "\1\175\1\157\2\uffff\1\165\4\uffff\1\76\4\uffff\1\57\2\uffff\1"+
        "\160\1\156\1\162\2\uffff\2\154\1\156\1\146\4\uffff\1\164\1\160\1"+
        "\141\2\145\1\164\1\154\1\151\1\165\1\156\1\115\1\172\1\151\1\145"+
        "\1\157\1\164\1\163\1\157\1\uffff\1\155\1\170\1\156\1\172\1\151\1"+
        "\144\1\145\1\151\1\141\1\uffff\1\164\1\145\1\172\1\166\1\154\1\151"+
        "\1\154\1\uffff\2\172\1\166\1\172\2\uffff\1\145\1\uffff\1\172\1\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\5\1\6\1\7\1\10\1\uffff\1\13\1\14\1\15"+
        "\1\16\1\uffff\1\21\1\22\3\uffff\1\30\1\31\4\uffff\1\11\1\12\1\17"+
        "\1\20\22\uffff\1\4\11\uffff\1\24\7\uffff\1\25\4\uffff\1\27\1\23"+
        "\1\uffff\1\1\1\uffff\1\26";
    static final String DFA7_specialS =
        "\115\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\17\1\20\1\uffff\1\17\1\20\22\uffff\1\17\7\uffff\1\5\1\6"+
            "\3\uffff\1\11\1\14\1\16\12\25\1\uffff\1\7\1\12\4\uffff\21\24"+
            "\1\1\10\24\1\13\1\uffff\1\15\3\uffff\10\24\1\22\5\24\1\21\2"+
            "\24\1\4\1\24\1\23\6\24\1\2\1\10\1\3",
            "\1\26",
            "",
            "",
            "\1\31\11\uffff\1\27\5\uffff\1\30",
            "",
            "",
            "",
            "",
            "\1\33\3\uffff\1\25\14\uffff\1\32",
            "",
            "",
            "",
            "",
            "\1\35\4\uffff\1\34",
            "",
            "",
            "\1\36",
            "\1\37",
            "\1\40",
            "",
            "",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "",
            "",
            "",
            "",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "",
            "\1\100",
            "\1\101",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\1\111",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "",
            "",
            "\1\113",
            "",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | SL_COMMENT | ML_COMMENT | WHITESPACE | LINEBREAKS | OPTIONAL | INPUT | RUNTIME | TRANSITIVE | REFLEXIVE | IDENTIFIER | NUMBER );";
        }
    }
 

}