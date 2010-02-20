// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;


import org.antlr.runtime3_2_0.*;

public class RefspecLexer extends Lexer {
    public static final int INTEGER=6;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int WHITESPACE=8;
    public static final int FLOAT=7;
    public static final int TEXT=4;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int COMMENT=5;
    public static final int LINEBREAK=9;

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

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:24:7: ( '(' )
            // Refspec.g:24:9: '('
            {
            match('('); 

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
            // Refspec.g:25:7: ( '->' )
            // Refspec.g:25:9: '->'
            {
            match("->"); 


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
            // Refspec.g:26:7: ( ')' )
            // Refspec.g:26:9: ')'
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
            // Refspec.g:27:7: ( 'in' )
            // Refspec.g:27:9: 'in'
            {
            match("in"); 


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
            // Refspec.g:28:7: ( 'move' )
            // Refspec.g:28:9: 'move'
            {
            match("move"); 


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
            // Refspec.g:29:7: ( 'to' )
            // Refspec.g:29:9: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:1156:8: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Refspec.g:1157:2: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 

            // Refspec.g:1157:6: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Refspec.g:1157:7: ~ ( '\\n' | '\\r' | '\\uffff' )
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

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:1160:8: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-'||(LA4_0>='1' && LA4_0<='9')) ) {
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
                    // Refspec.g:1161:2: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Refspec.g:1161:2: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // Refspec.g:1161:3: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // Refspec.g:1161:8: ( '1' .. '9' )
                    // Refspec.g:1161:9: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // Refspec.g:1161:18: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Refspec.g:1161:19: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Refspec.g:1161:30: '0'
                    {
                    match('0'); 
                     _channel = 99; 

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
            // Refspec.g:1163:6: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // Refspec.g:1164:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // Refspec.g:1164:2: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Refspec.g:1164:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // Refspec.g:1164:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='1' && LA7_0<='9')) ) {
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
                    // Refspec.g:1164:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Refspec.g:1164:9: ( '1' .. '9' )
                    // Refspec.g:1164:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // Refspec.g:1164:20: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Refspec.g:1164:21: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Refspec.g:1164:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // Refspec.g:1164:43: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Refspec.g:1164:44: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:1166:5: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Refspec.g:1167:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Refspec.g:1167:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='-'||(LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Refspec.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:1168:11: ( ( ' ' | '\\t' | '\\f' ) )
            // Refspec.g:1169:2: ( ' ' | '\\t' | '\\f' )
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

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Refspec.g:1172:10: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Refspec.g:1173:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Refspec.g:1173:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\r') ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1=='\n') ) {
                    alt10=1;
                }
                else {
                    alt10=2;}
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
                    // Refspec.g:1173:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // Refspec.g:1173:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Refspec.g:1173:19: '\\n'
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
    // $ANTLR end "LINEBREAK"

    public void mTokens() throws RecognitionException {
        // Refspec.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK )
        int alt11=20;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // Refspec.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // Refspec.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // Refspec.g:1:22: T__12
                {
                mT__12(); 

                }
                break;
            case 4 :
                // Refspec.g:1:28: T__13
                {
                mT__13(); 

                }
                break;
            case 5 :
                // Refspec.g:1:34: T__14
                {
                mT__14(); 

                }
                break;
            case 6 :
                // Refspec.g:1:40: T__15
                {
                mT__15(); 

                }
                break;
            case 7 :
                // Refspec.g:1:46: T__16
                {
                mT__16(); 

                }
                break;
            case 8 :
                // Refspec.g:1:52: T__17
                {
                mT__17(); 

                }
                break;
            case 9 :
                // Refspec.g:1:58: T__18
                {
                mT__18(); 

                }
                break;
            case 10 :
                // Refspec.g:1:64: T__19
                {
                mT__19(); 

                }
                break;
            case 11 :
                // Refspec.g:1:70: T__20
                {
                mT__20(); 

                }
                break;
            case 12 :
                // Refspec.g:1:76: T__21
                {
                mT__21(); 

                }
                break;
            case 13 :
                // Refspec.g:1:82: T__22
                {
                mT__22(); 

                }
                break;
            case 14 :
                // Refspec.g:1:88: T__23
                {
                mT__23(); 

                }
                break;
            case 15 :
                // Refspec.g:1:94: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 16 :
                // Refspec.g:1:102: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 17 :
                // Refspec.g:1:110: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 18 :
                // Refspec.g:1:116: TEXT
                {
                mTEXT(); 

                }
                break;
            case 19 :
                // Refspec.g:1:121: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 20 :
                // Refspec.g:1:132: LINEBREAK
                {
                mLINEBREAK(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\3\22\3\uffff\2\22\1\uffff\1\22\1\uffff\3\22\1\uffff\2"+
        "\37\3\uffff\5\22\1\uffff\1\22\1\47\1\22\1\51\1\uffff\1\37\1\uffff"+
        "\1\22\1\53\2\22\1\56\1\uffff\1\22\1\uffff\1\22\1\uffff\2\22\1\uffff"+
        "\1\63\1\22\1\65\1\22\1\uffff\1\22\1\uffff\1\70\1\22\1\uffff\3\22"+
        "\1\75\1\uffff";
    static final String DFA11_eofS =
        "\76\uffff";
    static final String DFA11_minS =
        "\1\11\1\105\1\117\1\124\3\uffff\1\162\1\145\1\uffff\1\60\1\uffff"+
        "\1\156\2\157\1\uffff\2\55\3\uffff\1\106\1\122\1\105\1\145\1\167"+
        "\1\uffff\1\56\1\55\1\166\1\55\1\uffff\1\55\1\uffff\1\101\1\55\1"+
        "\120\1\141\1\55\1\uffff\1\145\1\uffff\1\103\1\uffff\1\123\1\164"+
        "\1\uffff\1\55\1\124\1\55\1\145\1\uffff\1\117\1\uffff\1\55\1\122"+
        "\1\uffff\1\111\1\116\1\107\1\55\1\uffff";
    static final String DFA11_maxS =
        "\1\175\1\105\1\117\1\124\3\uffff\1\162\1\145\1\uffff\1\76\1\uffff"+
        "\1\156\2\157\1\uffff\2\172\3\uffff\1\106\1\122\1\105\1\145\1\167"+
        "\1\uffff\1\56\1\172\1\166\1\172\1\uffff\1\172\1\uffff\1\101\1\172"+
        "\1\120\1\141\1\172\1\uffff\1\145\1\uffff\1\103\1\uffff\1\123\1\164"+
        "\1\uffff\1\172\1\124\1\172\1\145\1\uffff\1\117\1\uffff\1\172\1\122"+
        "\1\uffff\1\111\1\116\1\107\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\4\uffff\1\4\1\5\1\6\2\uffff\1\11\1\uffff\1\13\3\uffff\1\17\2\uffff"+
        "\1\22\1\23\1\24\5\uffff\1\12\4\uffff\1\20\1\uffff\1\21\5\uffff\1"+
        "\14\1\uffff\1\16\1\uffff\1\2\2\uffff\1\10\4\uffff\1\15\1\uffff\1"+
        "\3\2\uffff\1\7\4\uffff\1\1";
    static final String DFA11_specialS =
        "\76\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\23\1\24\1\uffff\1\23\1\24\22\uffff\1\23\7\uffff\1\11\1\13"+
            "\3\uffff\1\12\1\uffff\1\17\1\21\11\20\1\uffff\1\5\5\uffff\5"+
            "\22\1\2\13\22\1\1\1\3\7\22\4\uffff\1\22\1\uffff\2\22\1\7\5\22"+
            "\1\14\3\22\1\15\1\10\5\22\1\16\6\22\1\4\1\uffff\1\6",
            "\1\25",
            "\1\26",
            "\1\27",
            "",
            "",
            "",
            "\1\30",
            "\1\31",
            "",
            "\1\33\11\20\4\uffff\1\32",
            "",
            "\1\34",
            "\1\35",
            "\1\36",
            "",
            "\1\22\1\41\1\uffff\12\40\7\uffff\32\22\4\uffff\1\22\1\uffff"+
            "\32\22",
            "\1\22\1\41\1\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff"+
            "\32\22",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "",
            "\1\41",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\50",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "",
            "\1\22\1\41\1\uffff\12\40\7\uffff\32\22\4\uffff\1\22\1\uffff"+
            "\32\22",
            "",
            "\1\52",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\54",
            "\1\55",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "",
            "\1\57",
            "",
            "\1\60",
            "",
            "\1\61",
            "\1\62",
            "",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\64",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\66",
            "",
            "\1\67",
            "",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\71",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK );";
        }
    }
 

}